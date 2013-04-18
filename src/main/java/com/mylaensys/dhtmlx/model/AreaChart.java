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

public class AreaChart extends Component {
    protected String value = "";
    protected String label = "";
    protected String tooltip = "";
    protected String alpha = null;
    protected String color = null;


    public AreaChart(String name,String id,String value, String label, String tooltip, String alpha, String color) {

        this.name = name;
        this.id = id;
        this.value = value;
        this.label = label;
        this.tooltip = tooltip;
        this.alpha = alpha;
        this.color = color;
    }

    @Override
    public StringBuffer render(StringTemplateGroup group) {
        StringTemplate chart = group.getInstanceOf("META-INF/chart");
        group.setFileCharEncoding("UTF-8");

        StringBuffer buffer = new StringBuffer();

        chart.setAttribute( "id" , id );
        chart.setAttribute( "name" , name );
        chart.setAttribute( "value" , value );
        chart.setAttribute( "view" , "area" );
        chart.setAttribute( "label" , label );
        chart.setAttribute( "tooltip" , tooltip );

        chart.setAttribute( "alpha" , alpha );
        chart.setAttribute( "color" , color );


        if( attach != null ) {
            if( attach.open() ) {
                chart.setAttribute( "openAttachment" , attach.getAttachment() );
            }
            chart.setAttribute( "attachment" , attach.getAttachment() );
        }


        StringBuffer items = new StringBuffer();

        for(Component component : components) {
            if( component instanceof ChartPadding ) {
                StringBuffer padding = component.render(group);
                chart.setAttribute("padding",padding.toString());
            }

            if( component instanceof ChartLegend) {
                StringBuffer legend = component.render(group);
                chart.setAttribute("legend",legend.toString());
            }
            if( component instanceof ChartAxisX ) {
                StringBuffer x = component.render(group);
                chart.setAttribute("axis_x",x.toString());
            }

            if( component instanceof ChartAxisY ) {
                StringBuffer y = component.render(group);
                chart.setAttribute("axis_y",y.toString());
            }
        }

        buffer.append( chart.toString() );
        return buffer;    }
}
