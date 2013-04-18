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

public class ChartAxisY extends Component {
    protected String title = null;
    protected String color = null;
    protected String start = null;
    protected String step = null;
    protected String end = null;
    protected String template = null;
    protected String lines = null;

    public ChartAxisY(String title, String color, String start, String step, String end, String template, String lines) {
        this.title = title;
        this.color = color;
        this.start = start;
        this.step = step;
        this.end = end;
        this.template = template;
        this.lines = lines;
    }

    @Override
    public StringBuffer render(StringTemplateGroup templateGroup) {
        StringBuffer buffer = new StringBuffer();

        buffer.append( "yAxis:{" );
        if( title != null ) {
            buffer.append( " title: \"" + title + "\", " );            
        }
        if( color != null ) {
            buffer.append( " color: \"" + color + "\", " );
        }

        if( start != null ) {
            buffer.append( " start: " + start + ", " );
        }
        if( step != null ) {
            buffer.append( " step: " + step + ", " );
        }
        if( end != null ) {
            buffer.append( " end: " + end + ", " );
        }

        if( template != null ) {
            buffer.append( " template: \"" + template + "\", " );
        }
        if( lines != null ) {
            buffer.append( " lines: " + lines + ", " );
        }

        buffer.append( "}, " );

        return buffer;

    }
}
