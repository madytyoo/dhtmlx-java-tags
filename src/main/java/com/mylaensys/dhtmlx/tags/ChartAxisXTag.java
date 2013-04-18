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

import com.mylaensys.dhtmlx.model.ChartAxisX;

import javax.servlet.jsp.JspException;

public class ChartAxisXTag extends BaseTag {
    protected String title = null;
    protected String color = null;
    protected String template = null;
    protected String lines = null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getLines() {
        return lines;
    }

    public void setLines(String lines) {
        this.lines = lines;
    }

    public void accept(AreaChartTag parent) { }
    public void accept(LineChartTag parent) { }

    public int doStartTag() throws JspException {

        try {
                BaseTag parent = (BaseTag) getParent();
                component = new ChartAxisX(title, color, template, lines);
                parent.component.getComponents().add( component );
                accept( this.getParent() );
        } catch (Exception e) {
            throw new JspException("Chart Axis X can reside only in a chart tag");
        }
        return super.doStartTag();
    }
}
