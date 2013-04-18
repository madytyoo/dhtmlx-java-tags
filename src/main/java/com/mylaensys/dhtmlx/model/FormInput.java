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

import java.util.Iterator;

public class FormInput extends Component {
    private String type = "";
    private String label = "";
    private String value = "";
    private String width = "";
    private String rows = "";
    private String align = "";
    private String labelWidth = "";
    private String labelAlign = "";
    private String validate = "";

    public FormInput(Component component,String type, String name, String label, String value,String  width,String  rows ,String  align,String labelWidth,String labelAlign,String validate) {
        this.parent = component;
        this.type = type;
        this.name = name;
        this.label = label;
        this.value = value;
        this.width = width;
        this.rows = rows;
        this.align = align;
        this.labelWidth = labelWidth;
        this.labelAlign = labelAlign;
        this.validate = validate;
    }

    @Override
    public StringBuffer render(StringTemplateGroup templateGroup) {
        StringBuffer buffer = new StringBuffer();
        buffer.append( "{ type: '" + type + "', name: '" + name+ "' , value: '" + value + "', label:'" + label + "' " );

        buffer.append( ", bind:'" + name  + "' ");
        if( width.length() > 0 ) {
            buffer.append( ", width:'" + width + "' ");
        }
        if( labelWidth.length() > 0 ) {
            buffer.append( ", labelWidth:'" + labelWidth + "' ");
        }
        if( rows.length() > 0 ) {
            buffer.append( ", rows:'" + rows + "' ");
        }
        if( align.length() > 0 ) {
            buffer.append( ", align:'" + align + "' ");
        }
        if( labelAlign.length() > 0 ) {
            buffer.append( ", labelAlign:'" + labelAlign + "' ");
        }
        if( validate.length() > 0 ) {
            buffer.append( ", validate:'" + validate + "' ");
        }
        buffer.append( "}," );
        return buffer;
    }

    protected StringBuffer renderChild(StringTemplateGroup group, StringBuffer buffer) {
        for (Iterator<Component> iterator = components.iterator(); iterator.hasNext();) {
            buffer.append(iterator.next().render(group));
            buffer.append(",");
        }
        int index = buffer.indexOf(",");
        buffer.substring(0,index);

        return buffer;
    }
}
