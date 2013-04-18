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

public class Toolbar extends Component {
    protected String iconsPath = null;
    protected String onClick = null;
    protected String onStateChange = null;
    protected String onValueChange = null;
    protected String onEnter = null;
    protected String onXLS = null;
    protected String onXLE = null;
    protected String xml = null;
    protected int index = 0;

    public Toolbar(String name,String id, String iconsPath, String onClick, String onStateChange, String onValueChange, String onEnter,String onXLS, String onXLE, String xml) {
        this.name = name;
        this.id = id;
        this.iconsPath = iconsPath;
        this.onClick = onClick;
        this.onStateChange = onStateChange;
        this.onValueChange = onValueChange;
        this.onXLS = onXLS;
        this.onXLE = onXLE;
        this.onEnter = onEnter;
        this.xml = xml;
    }

    @Override
    public StringBuffer render(StringTemplateGroup group) {
        StringTemplate toolbar = group.getInstanceOf("META-INF/toolbar");
        group.setFileCharEncoding("UTF-8");
        
        StringBuffer buffer = new StringBuffer();


        if( attach != null ) {
            if( attach.open() ) {
                toolbar.setAttribute( "openAttachment" , attach.getAttachment() );
            }
            toolbar.setAttribute( "attachment" , attach.getAttachment() );
        }

        toolbar.setAttribute( "id" , id );
        toolbar.setAttribute( "name" , name );
        toolbar.setAttribute( "skin" , skin );
        toolbar.setAttribute( "iconsPath" , iconsPath  );
        toolbar.setAttribute( "onClick" , onClick );
        toolbar.setAttribute( "onStateChange" , onStateChange );
        toolbar.setAttribute( "onValueChange" , onValueChange );
        toolbar.setAttribute( "onXLS" , onXLS );
        toolbar.setAttribute( "onXLE" , onXLE );
        toolbar.setAttribute( "onEnter" , onEnter );

        if( xml != null ) {
            toolbar.setAttribute( "xml" , xml);
            buffer.append( toolbar.toString() );

        } else {
            StringBuffer items = new StringBuffer();
            items = renderChild(group, items);
            toolbar.setAttribute( "items" , items.toString() );

            buffer.append( toolbar.toString() );
        }

        return buffer;

    }
}
