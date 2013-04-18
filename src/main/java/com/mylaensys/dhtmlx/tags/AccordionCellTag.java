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

import com.mylaensys.dhtmlx.model.AccordionCell;
import com.mylaensys.dhtmlx.model.AttachToAccordion;

import javax.servlet.jsp.JspException;

public class AccordionCellTag extends BaseTag {
    private String  id;
    private String  text;
    private String  url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

     public String getI18n() {
        return i18n;
    }

    public void setI18n(String i18n) {
        this.i18n = i18n;
    }
    public String getHasRole() {
        return hasRole;
    }

    public void setHasRole(String hasRole) {
        this.hasRole = hasRole;
    }

    public String getHasPermission() {
        return hasPermission;
    }

    public void setHasPermission(String hasPermission) {
        this.hasPermission = hasPermission;
    }

    public void accept(AccordionTag parent) {
        //@STARTSTD@//
            throw new IllegalArgumentException("Standard Library does not support this feature");
        //@ENDSTD@//
    
    }

    /**
     * Required for tag validation
     * @param layout
     */
    //public void accept(LayoutTag layout) {
    //    component.setAttach( new AttachToAccordion( layout.getName() , ((BaseTag)layout.getParent()).getName() ) );
    //    //@STARTSTD@//
    //        throw new IllegalArgumentException("Standard Library does not support this feature");
    //    //@ENDSTD@//
    //}

    

    @Override
    public int doStartTag() throws JspException {
        try {
            if( isAuthorized() ) {
                BaseTag parent = (BaseTag) getParent();
                text = computeText( text , getBody().getI18n() , this.i18n );
                component = new AccordionCell( parent.component,name,id,text,url );
                parent.component.getComponents().add( component );
                accept( this.getParent() );
            } else {
                return SKIP_BODY;
            }

        } catch (ClassNotFoundException e) {
            throw new JspException( e.getMessage() );
        } catch (InstantiationException e) {
            throw new JspException( e.getMessage() );
        } catch (Exception e) {
            throw new JspException("AccordionCell Tag  may only reside within a Accordion Tag");
        }
        return super.doStartTag();

    }

    @Override
    public int doEndTag() throws JspException {
//        StringTemplate cell = accordion.getBody().getTemplateGroup().getInstanceOf("META-INF/accordion_cell");
//
//        cell.setAttribute( "name" , name );
//        cell.setAttribute( "accordion" , accordion.getName());
//
//        cell.setAttribute( "id" , id );
//        cell.setAttribute( "url" , url );
//        cell.setAttribute( "text" , text );
//
//        accordion.getCells().add( cell.toString() );

        return SKIP_BODY;
    }
}
