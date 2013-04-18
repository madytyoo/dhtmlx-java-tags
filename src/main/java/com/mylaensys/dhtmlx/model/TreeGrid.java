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

public class TreeGrid extends Grid {
    private String imageURL = null;

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public TreeGrid(String name, String id, String onXLS, String onXLE, String onRowSelect,String onRowDblClicked,String xml,String init) {
        super(name, id, onXLS, onXLE, onRowSelect,onRowDblClicked,xml,init);
    }

    @Override
    public StringBuffer render(StringTemplateGroup group) {
        StringTemplate grid = group.getInstanceOf("META-INF/treegrid");
        group.setFileCharEncoding("UTF-8");


        StringBuffer buffer = new StringBuffer();

        if( attach != null ) {
            if( attach.open() ) {
                grid.setAttribute( "openAttachment" , attach.getAttachment() );
            }
            grid.setAttribute( "attachment" , attach.getAttachment() );
        }


        grid.setAttribute("id", id);
        grid.setAttribute("name", name);
        grid.setAttribute("skin", skin);
        grid.setAttribute("imagePath", imagePath );
        grid.setAttribute("ids", getColumnPropertyList("name") );
        grid.setAttribute("header", getColumnPropertyList("header") );
        grid.setAttribute("type", getColumnPropertyList("type") );
        grid.setAttribute("align", getColumnPropertyList("align") );
        // todo grid.setAttribute("valign", getColumnPropertyList("valign") );
        grid.setAttribute("sort", getColumnPropertyList("sort") );
        grid.setAttribute("width", getColumnPropertyList("width") );
        grid.setAttribute("format", getColumnPropertyList("format") );
        /* TODO support i18n
            grid.i18n.decimal_separator=","
            grid.i18n.group_separator=".";
            mygrid.setNumberFormat("0,000.00",index);
             grid.setDateFormat("%m/%d/%Y");     // =>   01/25/1980
            grid.setDateFormat(%d-%c-%y");      // =>   25-1-80
            grid.setDateFormat("%M %e, %W);    // =>   January 25, Friday

          */
        /* Events */
        grid.setAttribute("onXLS", this.onXLS);
        grid.setAttribute("onXLE", this.onXLE);
        grid.setAttribute("onRowSelect", this.onRowSelect );
        grid.setAttribute("onRowDblClicked", this.onRowDblClicked );
        grid.setAttribute("xml", this.xml);
        if( "true".equalsIgnoreCase( this.init) ) {
            grid.setAttribute("init", this.init);
        }

        buffer.append( grid.toString() );

        return buffer;
    }


}
