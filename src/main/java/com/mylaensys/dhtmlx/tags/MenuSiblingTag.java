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

import com.mylaensys.dhtmlx.model.Menu;
import com.mylaensys.dhtmlx.model.MenuSibling;

import javax.servlet.jsp.JspException;

public class MenuSiblingTag extends BaseTag {
    protected String nextTo = null;
    protected String id = null;
    protected String text = null;
    protected String disabled = null;
    protected String imageEnabled = null;
    protected String imageDisabled = null;

    public String getNextTo() {
        return nextTo;
    }

    public void setNextTo(String nextTo) {
        this.nextTo = nextTo;
    }

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

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }

    public String getImageEnabled() {
        return imageEnabled;
    }

    public void setImageEnabled(String imageEnabled) {
        this.imageEnabled = imageEnabled;
    }

    public String getImageDisabled() {
        return imageDisabled;
    }

    public void setImageDisabled(String imageDisabled) {
        this.imageDisabled = imageDisabled;
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


     /**
       * Required for tag validation
       * @param menu
       */
      public void accept( MenuTag menu ) { }


    public int doStartTag() throws JspException {
        BodyTag body = this.getBody();
        if( body.getComponents().containsKey( name ) ) {
            throw new JspException( "Duplicate variable " + name  );
        }

        try {
              if (isAuthorized())  {
                BaseTag parent = (BaseTag) getParent();
                text = translate(text);
                MenuSibling sibling = new MenuSibling(parent.component, nextTo, id, text, disabled,imageEnabled,imageDisabled);
                component = sibling ;
                parent.component.getComponents().add(component);
                /* Accept the visitor throws exception if not welcome */
                accept( this.getParent() );

                sibling.setMenu( (Menu)parent.component );
            }

        } catch (Exception e) {
            throw new JspException("Menu Tag may only reside within a Body Tag or another container");
        }
        return super.doStartTag();
    }

}

