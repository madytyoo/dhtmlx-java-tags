/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mylaensys.dhtmlx.tags;


import com.mylaensys.dhtmlx.i18n.ResourceBundleWrapper;
import com.mylaensys.dhtmlx.model.Component;
import com.mylaensys.dhtmlx.security.SecurityContext;
import com.mylaensys.dhtmlx.security.SecurityContextFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public class BaseTag extends TagSupport {
    protected String name = "";
    protected Component component = null;
    protected String i18n;
    protected String hasRole;
    protected String hasPermission;
    private static ResourceBundleWrapper bundle;
    private static SecurityContextFactory security;


    public static SecurityContextFactory getSecurityContextFactory() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (security == null) {
            String className = System.getProperty("com.mylaensys.dhtmlx.security", "com.mylaensys.dhtmlx.security.SecurityContextFactoryDefault");
            Class c = Class.forName(className);
            security = (SecurityContextFactory) c.newInstance();
        }
        return security;
    }

    public static ResourceBundleWrapper getBundle() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (bundle == null) {
            String className = System.getProperty("com.mylaensys.dhtmlx.i18n.ResourceBundle", "com.mylaensys.dhtmlx.i18n.ResourceBundleDefault");
            Class c = Class.forName(className);
            bundle = (ResourceBundleWrapper) c.newInstance();
        }
        return bundle;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getI18n() {
        return i18n;
    }

    public void accept(Object object) throws Exception {
        try {
            Method method = this.getClass().getMethod("accept", new Class[]{object.getClass()});

            if (method != null) {
                method.invoke(this, new Object[]{object});
            }
        }
        catch (Exception e) {
            throw e;
        }
    }

    public BodyTag getBody() {
        BodyTag body = null;
        Tag tag = this.getParent();
        while (tag != null) {
            if (tag instanceof BodyTag) {
                body = (BodyTag) tag;
            }
            tag = tag.getParent();
        }
        return body;
    }

    @Override
    public int doStartTag() throws JspException {
        return EVAL_BODY_INCLUDE;
    }

    public int doEndTag() throws JspException {
        return SKIP_BODY;
    }

    protected String translate(String param) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String text = param;
        BaseTag parent = (BaseTag) getParent();
        String i18n = parent.getI18n() == null ? getBody().getI18n() : parent.getI18n() ;

        if( i18n != null ) {
            HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
            Locale locale = request.getLocale();

            ResourceBundleWrapper bundle = getBundle();
            text = bundle.getString( i18n, param , locale );
        }

        try {
            return new String(text.getBytes(),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return "UnsupportedEncodingException ";       
    }

    protected boolean isAuthorized() throws JspException {
        boolean granted = false;

        if( hasRole == null && hasPermission == null )
            granted = true;

        if (hasRole != null && hasRole.length() == 0) {
            throw new JspException("hasRole attribute cannot be empty");
        }
        if (hasPermission != null && hasPermission.length() == 0) {
            throw new JspException("hasPermission  attribute cannot be empty");
        }

        try {
            HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
            SecurityContext context = getSecurityContextFactory().getSecurityContext();
            if (hasRole != null && hasPermission != null) {
                granted = context.hasRole(request, hasRole) & context.hasPermission(request, hasPermission);
            } else if (hasRole != null) {
                granted = context.hasRole(request, hasRole);
            } else if (hasPermission != null) {
                granted = context.hasPermission(request, hasPermission);
            }


        } catch (Exception e) {
            throw new JspException(e.getMessage());
        }
        return granted;
    }

    protected String computeText(String text, String body, String i18n) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        boolean tagI18N = (i18n == null ?  true : "true".equalsIgnoreCase( i18n ) );
        boolean bodyI18N = "ResourceBundle".equalsIgnoreCase(body) ;

        if(bodyI18N) {
            if( tagI18N ) {
                text = translate(text);
            }
        }
        return text;
    }
}
