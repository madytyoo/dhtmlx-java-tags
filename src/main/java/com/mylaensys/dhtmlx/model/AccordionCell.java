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

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;

public class AccordionCell extends Component {
    private String  text;
    private String  url;

    public AccordionCell(Component parent,String name, String id, String text, String url) {
        this.parent = parent;
        this.name = name;
        this.id = id;
        this.text = text;
        this.url = url;
    }

    @Override
    public StringBuffer render(StringTemplateGroup group) {
        StringTemplate cell = group.getInstanceOf("META-INF/accordion_cell");
        group.setFileCharEncoding("UTF-8");

        StringBuffer buffer = new StringBuffer();

        cell.setAttribute( "name" , name );
        cell.setAttribute( "accordion" , parent.getName()  );

        cell.setAttribute( "id" , id );
        cell.setAttribute( "url" , url );
        cell.setAttribute( "text" , text );

        buffer.append( cell.toString() );
        buffer = renderChild(group, buffer);

        return buffer;
    }
}
