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

import com.mylaensys.dhtmlx.model.LineChartItem;

import javax.servlet.jsp.JspException;

public class LineChartItemTag extends BaseTag {
    protected String borderColor = null;
    protected String borderWidth = null;
    protected String color = null;
    protected String radius = null;


    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(String borderWidth) {
        this.borderWidth = borderWidth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public void accept(LineChartTag parent) { }

    public int doStartTag() throws JspException {

        try {
                BaseTag parent = (BaseTag) getParent();
                component = new LineChartItem(borderColor,borderWidth,color, radius);
                parent.component.getComponents().add( component );
                accept( this.getParent() );

        } catch (Exception e) {
            throw new JspException("Chart Line  can reside only in a chart line tag");
        }
        return super.doStartTag();
    }
}
