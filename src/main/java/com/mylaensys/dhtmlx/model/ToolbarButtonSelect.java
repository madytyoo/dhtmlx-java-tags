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

public class ToolbarButtonSelect extends Component {
    protected  String position = null;
    protected  String width = null;
    protected  String text = null;
    protected String imageEnabled = null;
    protected String imageDisabled = null;
    protected String title = null;


    public ToolbarButtonSelect(Component parent, String id, String position, String width, String text, String imageEnabled, String imageDisabled, String title) {
        this.parent = parent;
        this.id = id;
        this.position = position;
        this.width = width;
        this.text = text;
        this.imageEnabled = imageEnabled;
        this.imageDisabled = imageDisabled;
        this.title = title;
    }

    @Override
    public StringBuffer render(StringTemplateGroup group) {
        StringBuffer buffer = new StringBuffer();

        buffer.append( parent.getName() + ".addButtonSelect('" + id + "'," + position + ",'" + text + "', Array()"  );
        if(imageEnabled != null ) {
            buffer.append( ",'" + imageEnabled + "'");
        } else {
            buffer.append( ",null" );
        }
        if(imageDisabled != null ) {
            buffer.append( ",'" + imageDisabled + "'");
        } else {
            buffer.append( ",null" );
        }
        buffer.append( ");\n" );
        if(width != null ) {
            buffer.append( parent.getName() + ".setWidth('"+ id + "'," + width + ");\n" );
        }

        if(title != null ) {
            buffer.append( parent.getName() + ".setItemToolTip('" + id + "','" + title + "');");
            buffer.append("\n");
        }

        buffer.append( renderChild( null, null ) );


        return buffer;
    }

    @Override
    protected StringBuffer renderChild(StringTemplateGroup group, StringBuffer n2) {
        StringBuffer buffer = new StringBuffer();

        for (Iterator<Component> iterator = components.iterator(); iterator.hasNext();) {
            buffer.append(iterator.next().render(group));
        }
        return buffer;
    }
}
