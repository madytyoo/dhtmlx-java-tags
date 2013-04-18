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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public abstract class Component {
    protected String id;
    protected String name;
    protected Attach attach;
    protected String skin = "dhx_skyblue";
    protected String i18n;
    protected String imagePath;

    protected Component parent;
    protected ArrayList<Component> components = new ArrayList<Component>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


    public void setSkin(String skin) {
        this.skin = skin;
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public Attach getAttach() {
        return attach;
    }

    public void setAttach(Attach attach) {
        this.attach = attach;
    }

    public abstract StringBuffer render(StringTemplateGroup templateGroup);

    public void addEventHandler( StringTemplate template, String event, String handler ) {
        if( handler != null && handler.trim().length() > 0 ) {
            template.setAttribute( event , handler );
        }
    }

    protected StringBuffer renderChild(StringTemplateGroup group, StringBuffer buffer) {
        for (Iterator<Component> iterator = components.iterator(); iterator.hasNext();) {
            buffer.append(iterator.next().render(group));
        }
        return buffer;
    }
}
