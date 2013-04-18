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

public class Column extends Component {
    protected String name = "";
    protected String header = "";
    protected String type = "ro";
    protected String sort;
    protected String width;
    protected String align = "left";
    protected String valign;
    protected String format;

    public Column(String name,String header,String type, String sort, String width, String align, String valign, String format) {
        this.name = name;
        this.header = header;
        this.type = type;
        this.sort = sort;
        this.width = width;
        this.align = align;
        this.valign = valign;
        this.format = format;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }


    public String getSort() {
        return sort;
    }


    public String getWidth() {
        return width;
    }


    public String getAlign() {
        return align;
    }

    public String getValign() {
        return valign;
    }


    public String getFormat() {
        return format;
    }


    @Override
    public StringBuffer render(StringTemplateGroup templateGroup) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
