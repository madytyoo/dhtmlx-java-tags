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
import com.mylaensys.dhtmlx.model.MenuChild;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;

public class MenuChildTag extends BaseTag {
    protected String id = null;
    protected String position = null;
    protected String text = null;
    protected String disabled = null;
    protected String imageEnabled = null;
    protected String imageDisabled = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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


    /**
     * Required for tag validation
     *
     * @param menu
     */
    public void accept(MenuTag menu) {
    }
    public void accept(MenuSiblingTag sibling) {
    }

    public void accept(MenuChildTag sibling) {
    }

    public MenuTag getMenu() {
        MenuTag menu = null;
        Tag tag = this.getParent();
        while (tag != null) {
            if (tag instanceof MenuTag) {
                menu = (MenuTag) tag;
            }
            tag = tag.getParent();
        }
        return menu;
    }


    public int doStartTag() throws JspException {

        try {
            if (isAuthorized()) {
                BaseTag parent = (BaseTag) getParent();
                text = computeText( text , getBody().getI18n() , this.i18n );
                MenuChild child = new MenuChild(parent.component, id, text, position, disabled, imageEnabled, imageDisabled);
                component = child;
                parent.component.getComponents().add(component);
                accept(this.getParent());

                child.setMenu((Menu) this.getMenu().component);
            } else {
                return SKIP_BODY;
            }

        } catch (ClassNotFoundException e) {
            throw new JspException(e.getMessage());
        } catch (InstantiationException e) {
            throw new JspException(e.getMessage());
        } catch (Exception e) {
            throw new JspException("MenuChild Tag can only reside within a MenuSibling");
        }
        return super.doStartTag();
    }

}
