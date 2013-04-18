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

import com.mylaensys.dhtmlx.model.ChartPadding;

import javax.servlet.jsp.JspException;

public class ChartPaddingTag extends BaseTag {
    protected String left = null;
    protected String top = null;
    protected String right = null;
    protected String bottom = null;

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public void accept(LineChartTag parent) { }

    public int doStartTag() throws JspException {

        try {
                BaseTag parent = (BaseTag) getParent();
                component = new ChartPadding(left, top, right, bottom);
                parent.component.getComponents().add( component );
                accept( this.getParent() );
        } catch (Exception e) {
            throw new JspException("Chart Axis X can reside only in a chart tag");
        }
        return super.doStartTag();
    }
}
