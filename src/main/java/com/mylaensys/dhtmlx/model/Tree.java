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

import java.util.Iterator;

public class Tree extends Component {
    protected String id = null;
    protected String width = null;
    protected String height = null;
    protected String root = null;
    protected String onXLS = null;
    protected String onXLE = null;
    protected String onSelect = null;
    protected String onClick = null;
    protected String onDblClick = null;
    protected String xml = null;


    public Tree(String name, String id, String imagePath, String width, String height, String root, String onXLS, String onXLE, String onSelect, String onClick, String onDblClick, String xml, String skin) {
        this.name = name;
        this.id = id;
        this.imagePath = imagePath;        
        this.width = width;
        this.height = height;
        this.root = root;
        this.onXLS = onXLS;
        this.onXLE = onXLE;
        this.onClick = onClick;
        this.onDblClick = onDblClick;
        this.onSelect = onSelect;
        this.xml = xml;
        this.skin = skin;
    }

    @Override
    public StringBuffer render(StringTemplateGroup group) {
        StringTemplate tree = group.getInstanceOf("META-INF/tree");
        group.setFileCharEncoding("UTF-8");
        
        StringBuffer buffer = new StringBuffer();

        if( attach != null ) {
            if( attach.open() ) {
                tree.setAttribute( "openAttachment" , attach.getAttachment() );
            }
            tree.setAttribute( "attachment" , attach.getAttachment() );
        }


        tree.setAttribute("id", id);
        tree.setAttribute("name", name);
        tree.setAttribute("width", width);
        tree.setAttribute("height", height);
        tree.setAttribute("root", root);
        tree.setAttribute("skin", skin);
        tree.setAttribute("imagePath", imagePath );
        /* TODO support i18n
            tree.i18n.decimal_separator=","
            tree.i18n.group_separator=".";
            mytree.setNumberFormat("0,000.00",index);
             tree.setDateFormat("%m/%d/%Y");     // =>   01/25/1980
            tree.setDateFormat(%d-%c-%y");      // =>   25-1-80
            tree.setDateFormat("%M %e, %W);    // =>   January 25, Friday

          */
        /* Events */
        tree.setAttribute("onXLS", this.onXLS);
        tree.setAttribute("onXLE", this.onXLE);
        tree.setAttribute("onSelect", this.onSelect );
        tree.setAttribute("onClick", this.onClick );
        tree.setAttribute("onDblClick", this.onDblClick );
        tree.setAttribute("xml", this.xml);

        buffer.append( tree.toString() );

        return buffer;
    }

}
