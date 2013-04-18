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

public class MenuRadioButton extends MenuObject {
    protected String nextTo = null;
    protected String text = null;
    protected String position = null;
    protected String group = null;
    protected String state = null;
    protected String disabled = null;

    public MenuRadioButton(Component parent, String nextTo, String id, String text, String position, String group, String state, String disabled) {
        this.parent = parent;
        this.nextTo = nextTo;
        this.id = id;
        this.text = text;
        this.position = position;
        this.group = group;
        this.state = state;
        this.disabled = disabled;
    }

    @Override
    public StringBuffer render(StringTemplateGroup tgroup) {
        StringBuffer buffer = new StringBuffer();

        if( parent instanceof Menu ) {
            buffer.append( this.getMenu().getName() + ".addRadioButton( 'child'," + parent.getName() + ".topId ," );
        } else {
            buffer.append(this.getMenu().getName() + ".addRadioButton('child','" + parent.id + "',");
        }



        if (position != null) {
            buffer.append(position + ",");
        } else {
            /* Should be never be null */
        }
        
        if (id != null) {
            buffer.append("'" + id + "',");
        } else {
            /* Should be never be null */
        }

        if (text != null) {
            buffer.append("'" + text + "',");
        } else {
            /* Should be never be null */
        }

        if (group != null) {
            buffer.append("'" + group + "',");
        } else {
            /* Should be never be null */
        }

        if (state != null) {
            buffer.append("'" + state + "',");
        } else {
            buffer.append("false,");
        }

        if (disabled != null) {
            if ("true".equalsIgnoreCase(disabled)) {
                buffer.append("true");
            } else {
                buffer.append("false");
            }
        } else {
            buffer.append("false");
        }

        buffer.append(");");
        buffer.append("\n");

        return buffer;

    }
}
