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

import javax.servlet.jsp.JspException;
import java.util.ArrayList;
import java.util.Iterator;

public class Accordion extends Component {
    private String mode = null;
    private String onActive = null;
    private String openItem = null;
    private String onBeforeActive = null;
    private String onDock = null;
    private String onUnDock = null;

    public Accordion(String name,String id,String mode,String openItem, String onActive, String onBeforeActive, String onDock, String onUnDock) {
        this.name = name;
        this.id = id;
        this.mode = mode;
        this.openItem = openItem;
        this.onActive = onActive;
        this.onBeforeActive = onBeforeActive;
        this.onDock = onDock;
        this.onUnDock = onUnDock;
    }

    @Override
    public StringBuffer render(StringTemplateGroup group) {
        StringBuffer buffer = new StringBuffer();
        StringTemplate accordion = group.getInstanceOf("META-INF/accordion");
        group.setFileCharEncoding("UTF-8");

        id = "document.body".equalsIgnoreCase(this.id) ? "document.body" : "'" + this.id + "'";

        if( attach != null ) {
            accordion.setAttribute( "attachment" , attach.getAttachment() );
        }
        accordion.setAttribute( "id" , id );
        accordion.setAttribute( "name" , name );
        accordion.setAttribute( "mode" , mode);
        accordion.setAttribute( "openItem" , openItem);

        addEventHandler(accordion,"onActive" , onActive);
        addEventHandler(accordion,"onBeforeActive" , onBeforeActive);
        addEventHandler(accordion,"onDock" , onDock);
        addEventHandler(accordion,"onUnDock" , onUnDock);

        StringBuffer cells = new StringBuffer();
        cells = renderChild(group, cells);
        accordion.setAttribute( "cells" , cells.toString() );

        buffer.append(accordion.toString());

        return buffer;

    }

  
}
