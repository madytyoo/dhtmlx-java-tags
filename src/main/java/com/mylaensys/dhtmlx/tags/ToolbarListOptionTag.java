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

import com.mylaensys.dhtmlx.model.ToolbarListOption;

import javax.servlet.jsp.JspException;

public class ToolbarListOptionTag extends BaseTag {
    protected  String id = null;
    protected  String position = null;
    protected  String type = null;
    protected  String text = null;
    protected String image = null;
    protected String title = null;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public void accept(ToolbarButtonSelectTag parent) {
    }


    public int doStartTag() throws JspException {

        try {
            if (isAuthorized()) {
                BaseTag parent = (BaseTag) getParent();
                text = computeText( text , getBody().getI18n() , this.i18n );
                if( title != null ) {
                    title = computeText( title, getBody().getI18n() , this.i18n );
                }
                component = new ToolbarListOption(parent.component, id, position, type, text,image ,title );
                parent.component.getComponents().add(component);
                accept(this.getParent());
            } else {
                return SKIP_BODY;
            }

        } catch (ClassNotFoundException e) {
            throw new JspException(e.getMessage());
        } catch (InstantiationException e) {
            throw new JspException(e.getMessage());
        } catch (Exception e) {
            throw new JspException("Toolbar List Option Tag may only reside within a Toolbar Button Select Tag");
        }
        return super.doStartTag();
    }


}
