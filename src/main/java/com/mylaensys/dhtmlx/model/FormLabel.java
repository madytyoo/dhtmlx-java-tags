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

public class FormLabel extends Component {
    private String label = "";
    private String labelWidth = "";
    private String offsetLeft = "";
    private String className = "";

    public FormLabel(Component parent, String name,String label,String labelWidth,String offsetLeft ,String className) {
        this.parent = parent;
        this.name = name;
        this.label = label;
        this.labelWidth = labelWidth;
        this.offsetLeft = offsetLeft;
        this.className = className;
    }

    @Override
    public StringBuffer render(StringTemplateGroup group) {
        StringBuffer buffer = new StringBuffer();
        buffer.append( "{ type: 'label', label: '" + label + "'" );
        if( name.length() > 0 ) {
            buffer.append( ", name:'" + name + "' ");
        }
        if( labelWidth.length() > 0 ) {
            buffer.append( ", labelWidth:" + labelWidth + " ");
        }
        if( offsetLeft.length() > 0 ) {
            buffer.append( ", offsetLeft:" + offsetLeft + " ");
        }

        if( className.length() > 0 ) {
            buffer.append( ", className:'" + className + "' ");
        }

        StringBuffer content = new StringBuffer();
        if( components.size() > 0 ) {
            buffer.append( ",list: [" );
            content = renderChild(group, content);
            buffer.append( content );
            buffer.append( "]," );
        }
        buffer.append( "}," );
        return buffer;

    }
    
}
