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

public class Menu extends Component {
    protected String iconsPath = null;
    protected String align = null;
    protected String onClick = null;
    protected String openMode = null;
    protected String onCheckboxClick = null;
    protected String onRadioClick = null;
    protected String onBeforeContextMenu = null;
    protected String onAfterContextMenu = null;
    protected String onXLS  = null;
    protected String onXLE = null;
    protected String xml = null;



    public Menu(String name,String id, String iconsPath, String align, String openMode,String onClick, String onCheckboxClick , String onRadioClick,String onBeforeContextMenu,String onAfterContextMenu,String onXLS,String onXLE,String xml) {
        this.name = name;
        this.id = id;
        this.iconsPath = iconsPath;
        this.align = align;
        this.openMode = openMode;
        this.onClick = onClick;
        this.onCheckboxClick = onCheckboxClick ;
        this.onRadioClick = onRadioClick;
        this.onBeforeContextMenu = onBeforeContextMenu;
        this.onAfterContextMenu = onAfterContextMenu;
        this.onXLS = onXLS;
        this.onXLE = onXLE;
        this.xml = xml;
    }

    @Override
    public StringBuffer render(StringTemplateGroup group) {
        StringBuffer buffer = new StringBuffer();
        StringTemplate menu = group.getInstanceOf("META-INF/menu");
        group.setFileCharEncoding("UTF-8");
        

        id = "document.body".equalsIgnoreCase(this.id) ? "document.body" : "'" + this.id + "'";

        if( attach != null ) {
            if( attach.open() ) {
                menu.setAttribute( "openAttachment" , attach.getAttachment() );
            }
            if( attach.contextual() ) {
                menu.setAttribute( "contextual" , name );
            }
            if( attach.isTree() ) {
                menu.setAttribute( "tree" , "true");
            }

            menu.setAttribute( "attachment" , attach.getAttachment() );
        }
        if( id != null ) {
            menu.setAttribute("id", id);
        }
        menu.setAttribute("name", name);
        menu.setAttribute("iconsPath", iconsPath);
        menu.setAttribute("align", align);
        menu.setAttribute("openMode", openMode);


        addEventHandler(menu, "onClick", onClick);
        addEventHandler(menu, "onCheckboxClick", onCheckboxClick);
        addEventHandler(menu, "onRadioClick", onRadioClick);
        addEventHandler(menu, "onBeforeContextMenu", onBeforeContextMenu);
        addEventHandler(menu, "onAfterContextMenu", onAfterContextMenu);
        addEventHandler(menu, "onXLS", onXLS);
        addEventHandler(menu, "onXLE", onXLE);

        if( xml != null  ) {
            menu.setAttribute("xml", xml);
            buffer.append(menu.toString());

        } else {
            buffer.append(menu.toString());
            buffer = renderChild(group, buffer);
        }
        return buffer;

    }
}
