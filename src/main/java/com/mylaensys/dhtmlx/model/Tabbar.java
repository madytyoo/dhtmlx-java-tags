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

import com.mylaensys.dhtmlx.tags.LayoutCellTag;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;

public class Tabbar extends Component {
    private String mode = null;
    private String hrefMode = null;
    private String enableCloseButton= null;
    private String tabActive = null;
    private String onSelect = null;
    private String onTabClose = null;
    private String onTabContentLoaded = null;
    private String onXLS = null;
    private String onXLE = null;
    private String xml = null;
    private LayoutCellTag layoutCell = null;

    public Tabbar(String name, String id, String mode, String hrefMode, String enableCloseButton, String tabActive, String onSelect, String onTabClose, String onTabContentLoaded, String onXLS, String onXLE, String xml) {
        this.name = name;
        this.id = id;
        this.mode = mode;
        this.hrefMode = hrefMode;
        this.enableCloseButton = enableCloseButton;
        this.tabActive = tabActive;
        this.onSelect = onSelect;
        this.onTabClose = onTabClose;
        this.onTabContentLoaded = onTabContentLoaded;
        this.onXLS = onXLS;
        this.onXLE= onXLE;
        this.xml= xml;
    }

    @Override
    public StringBuffer render(StringTemplateGroup group) {
        StringTemplate tabbar = group.getInstanceOf("META-INF/tabbar");
        group.setFileCharEncoding("UTF-8");
        
        StringBuffer buffer = new StringBuffer();

        id = "document.body".equalsIgnoreCase( this.id ) ? "document.body" : "'" + this.id +"'";

        if( attach != null ) {
            if( attach.open() ) {
                tabbar.setAttribute( "openAttachment" , attach.getAttachment() );
            }
            tabbar.setAttribute( "attachment" , attach.getAttachment() );
        }

        /* By default if not specified the tab active attribute, activate the first */
        if( tabActive == null ) {
            if(components.size() > 0 ) {
                Component tab = components.get(0);
                tabActive = tab.getName();
            }
        }
        tabbar.setAttribute( "id" , id );
        tabbar.setAttribute( "name" , name );
        tabbar.setAttribute( "mode" , mode );
        tabbar.setAttribute( "skin" , skin );
        tabbar.setAttribute( "imagePath" , imagePath );
        tabbar.setAttribute( "hrefMode" , hrefMode );
        tabbar.setAttribute( "enableCloseButton" , enableCloseButton );
        tabbar.setAttribute( "tabActive" , tabActive);
        tabbar.setAttribute( "onSelect" , onSelect );
        tabbar.setAttribute( "onTabClose" , onTabClose );
        tabbar.setAttribute( "onTabContentLoaded" , onTabContentLoaded );
        tabbar.setAttribute( "onXLS" , onXLS );
        tabbar.setAttribute( "onXLE" , onXLS );        


        if(xml != null ) {
            tabbar.setAttribute( "xml" , xml);
            buffer.append( tabbar.toString() );
            
        } else {
            StringBuffer tabs = new StringBuffer();
            tabs = renderChild(group, tabs);
            tabbar.setAttribute( "tabs" , tabs.toString() );
            buffer.append( tabbar.toString() );
        }

        return buffer;

    }
}
