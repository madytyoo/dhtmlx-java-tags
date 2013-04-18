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
package com.mylaensys.dhtmlx.model;

import org.antlr.stringtemplate.StringTemplateGroup;

public class ToolbarSlider extends Component {
    protected  String position = null;
    protected  String text = null;
    protected  String width = null;
    protected  String min = null;
    protected  String max = null;
    protected  String initial = null;
    protected  String minText = null;
    protected  String maxText = null;
    private String tooltip = null;


    public ToolbarSlider(Component parent, String id, String position, String width,String min, String max, String initial, String minText, String maxText, String tooltip) {
        this.parent = parent;
        this.id = id;
        this.position = position;
        this.width = width;
        this.min = min;
        this.max = max;
        this.initial = initial;
        this.minText = minText;
        this.maxText = maxText;
        this.tooltip = tooltip;

    }

    @Override
    public StringBuffer render(StringTemplateGroup templateGroup) {
        StringBuffer buffer = new StringBuffer();

        buffer.append( parent.getName() + ".addSlider('" + id + "'," + position + "" );
        buffer.append( ",'" + width + "'");
        buffer.append( ",'" + min + "'");
        buffer.append( ",'" + max + "'");
        buffer.append( ",'" + initial + "'");
        buffer.append( ",'" + minText + "'");
        buffer.append( ",'" + maxText + "'");
        buffer.append( ",'" + tooltip + "'");

        buffer.append( ");" );
        buffer.append("\n");
        

        return buffer;
    }
}
