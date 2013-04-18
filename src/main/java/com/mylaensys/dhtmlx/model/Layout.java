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

public class Layout extends Component {
    private String pattern = null;
    private String onResize = null;
    private String onExpand = null;
    private String onCollapse = null;
    private String onPanelResize = null;
    private String onContentLoaded = null;
    private String onDock = null;
    private String onUnDock = null;
    private String onDblClick = null;

    public Layout(String name, String id, String pattern, String onResize, String onExpand, String onCollapse, String onPanelResize, String onContentLoaded, String onDock, String onUnDock, String onDblClick) {
        this.name = name;
        this.id = id;
        this.pattern = pattern;
        this.onResize = onResize;
        this.onExpand = onExpand;
        this.onCollapse = onCollapse;
        this.onPanelResize = onPanelResize;
        this.onContentLoaded = onContentLoaded;
        this.onDock = onDock;
        this.onUnDock = onUnDock;
        this.onDblClick = onDblClick;
    }

    @Override
    public StringBuffer render(StringTemplateGroup group) {
        StringBuffer buffer = new StringBuffer();
        StringTemplate layout = group.getInstanceOf("META-INF/layout");
        group.setFileCharEncoding("UTF-8");
        
        /* fix for attach to window */
        if( id.startsWith("window:") ) {
            id = id.replaceAll( "window:" , "" );
        } else {
            id = "document.body".equalsIgnoreCase(this.id) ? "document.body" : "'" + this.id + "'";
        }


        if( attach != null ) {
            if( attach.open() ) {
                layout.setAttribute( "openAttachment" , attach.getAttachment() );
            }
            layout.setAttribute( "attachment" , attach.getAttachment() );
        }
        layout.setAttribute("id", id);
        layout.setAttribute("name", name);
        layout.setAttribute("pattern", pattern);
        layout.setAttribute("cells", buffer.toString());


        addEventHandler(layout, "onResize", onResize);
        addEventHandler(layout, "onExpand", onExpand);
        addEventHandler(layout, "onCollapse", onCollapse);
        addEventHandler(layout, "onPanelResize", onPanelResize);
        addEventHandler(layout, "onContentLoaded", onContentLoaded);
        addEventHandler(layout, "onDock", onDock);
        addEventHandler(layout, "onUnDock", onUnDock);
        addEventHandler(layout, "onDblClick", onDblClick);

        buffer.append(layout.toString());

        buffer = renderChild(group, buffer);

        return buffer;
    }
}
