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

public class ToolbarInput extends Component {
    protected  String position = null;
    protected  String value = null;
    protected String width = null;
    protected String title = null;


    public ToolbarInput(Component parent, String id, String position, String value, String width, String title) {
        this.parent = parent;
        this.id = id;
        this.position = position;
        this.value = value ;
        this.width = width;
        this.title = title;
    }

    @Override
    public StringBuffer render(StringTemplateGroup templateGroup) {
        StringBuffer buffer = new StringBuffer();

        buffer.append( parent.getName() + ".addInput('" + id + "'," + position + ",'" + value+ "','" + width + "');" );
        buffer.append("\n");
        
        if(title != null ) {
            buffer.append( parent.getName() + ".setItemToolTip('" + id + "','" + title + "');");
            buffer.append("\n");
        }

        return buffer;
    }
}
