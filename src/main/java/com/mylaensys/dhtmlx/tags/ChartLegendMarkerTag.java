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

import com.mylaensys.dhtmlx.model.ChartLegendMarker;

import javax.servlet.jsp.JspException;

public class ChartLegendMarkerTag extends BaseTag {
    protected String type = null;
    protected String width = null;
    protected String height = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void accept(ChartLegendTag parent) { }

    public int doStartTag() throws JspException {

        try {
                BaseTag parent = (BaseTag) getParent();
                component = new ChartLegendMarker(type,width,height);
                parent.component.getComponents().add( component );
                accept( this.getParent() );
        } catch (Exception e) {
            throw new JspException("Chart Legend Marker can reside only in a chart Legend tag");
        }
        return super.doStartTag();
    }
}
