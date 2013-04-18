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

public class FormFieldSet extends Component {
    private String label = "";
    private String width = "";

    public FormFieldSet(Component component,String name,String label,String width) {
        this.parent = component;
        this.name = name;
        this.label = label;
        this.width = width;
    }

    @Override
    public StringBuffer render(StringTemplateGroup group) {
        StringBuffer buffer = new StringBuffer();
        buffer.append( "{ type: 'fieldset',  width:'" + width + "', name: '" + name+ "', label:'" + label + "' " );

        buffer.append( ",list: [" );


        StringBuffer content = new StringBuffer();
        if( components.size() > 0 ) {
            content = renderChild(group, content);
            buffer.append( content );
        } else {
             buffer.append( "{ type: 'label', label: '' }," );
        }

        buffer.append( "]}," );
        
        return buffer;
    }
}
