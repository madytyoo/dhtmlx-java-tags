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

public class ChartLegend extends Component  {
    protected String width = null;
    protected String align = null;
    protected String valign = null;
    protected String layout = null;


    public ChartLegend(String width, String align, String valign, String layout) {
        this.width = width;
        this.align = align;
        this.valign = valign;
        this.layout = layout;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public String getValign() {
        return valign;
    }

    public void setValign(String valign) {
        this.valign = valign;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    @Override
    public StringBuffer render(StringTemplateGroup group) {
        StringBuffer buffer = new StringBuffer();


        buffer.append( "legend:{" );
        if( width != null ) {
            buffer.append( " width: " + width  + ", " );
        }

        if( align != null ) {
            buffer.append( " align: \"" + align + "\", " );
        }
        if( valign != null ) {
            buffer.append( " valign: \"" + valign + "\", " );
        }
        if( layout != null ) {
            buffer.append( " layout: \"" + layout + "\", " );
        }

        String text = "";
         for(Component component : components) {
            if( component instanceof ChartLegendMarker ) {
                buffer.append( component.render(group) );
            }
             if( component instanceof ChartLegendText ) {
                 text+=( component.render(group) );
             }
         }
        buffer.append( "values:[ " + text + " ]" );
        buffer.append( "}, " );

        return buffer;
    }
}
