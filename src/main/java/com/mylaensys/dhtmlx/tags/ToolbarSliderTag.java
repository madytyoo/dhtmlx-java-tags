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

import com.mylaensys.dhtmlx.model.ToolbarSlider;

import javax.servlet.jsp.JspException;

public class ToolbarSliderTag extends BaseTag {
    protected String id = null;
    protected String position = null;
    protected String width = "100";
    protected String min = "0";
    protected String max = "100";
    protected String initial = "50";
    protected String minText = "";
    protected String maxText = "";
    protected String tooltip = "Current %v";


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

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getMinText() {
        return minText;
    }

    public void setMinText(String minText) {
        this.minText = minText;
    }

    public String getMaxText() {
        return maxText;
    }

    public void setMaxText(String maxText) {
        this.maxText = maxText;
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
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

    public void accept(ToolbarTag parent) {
    }


    public int doStartTag() throws JspException {

        try {
            if (isAuthorized()) {
                BaseTag parent = (BaseTag) getParent();
                minText = computeText( minText , getBody().getI18n() , this.i18n );
                maxText = computeText( maxText , getBody().getI18n() , this.i18n );
                tooltip = computeText( tooltip , getBody().getI18n() , this.i18n );
                component = new ToolbarSlider(parent.component, id, position,width,min,max,initial,minText,maxText,tooltip);
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
            throw new JspException("Toolbar Button Tag may only reside within a Toolbar Tag");
        }
        return super.doStartTag();
    }


}
