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
import com.mylaensys.dhtmlx.model.MenuCheckBox;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;

public class MenuCheckBoxTag extends BaseTag {
    protected String nextTo = null;
    protected String id = null;
    protected String text = null;
    protected String position = null;
    protected String state = null;
    protected String disabled = null;

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled;
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

    public void accept(MenuTag sibling) {
    }

    public void accept(MenuSiblingTag sibling) {
    }

    public void accept(MenuChildTag child) {
    }

    public int doStartTag() throws JspException {

        try {
            if (isAuthorized()) {
                BaseTag parent = (BaseTag) getParent();
                text = computeText( text , getBody().getI18n() , this.i18n );
                MenuCheckBox check = new MenuCheckBox(parent.component, nextTo, id, text, position, state, disabled);
                component = check;
                parent.component.getComponents().add(component);
                accept(this.getParent());

                check.setMenu((Menu) this.getMenu().component);
            } else {
                return SKIP_BODY;
            }

        } catch (ClassNotFoundException e) {
            throw new JspException(e.getMessage());
        } catch (InstantiationException e) {
            throw new JspException(e.getMessage());
        } catch (Exception e) {
            throw new JspException("MenuRadioButton Tag Tag can only reside within a Menu");
        }
        return super.doStartTag();
    }


}
