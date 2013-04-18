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

public class LineChartItem extends Component {
    protected String borderColor = null;
    protected String borderWidth = null;
    protected String color = null;
    protected String radius = null;

    public LineChartItem(String borderColor, String borderWidth, String color, String radius) {
        this.borderColor = borderColor;
        this.borderWidth = borderWidth;
        this.color = color;
        this.radius = radius;
    }

    @Override
    public StringBuffer render(StringTemplateGroup templateGroup) {
        StringBuffer buffer = new StringBuffer();

        buffer.append( "item:{" );
        if( borderColor != null ) {
            buffer.append( " borderColor: \"" + borderColor + "\", " );
        }
        if( borderWidth != null ) {
            buffer.append( " borderWidth: " + borderWidth + ", " );
        }

        if( color != null ) {
            buffer.append( " color: \"" + color + "\", " );
        }

        if( radius != null ) {
            buffer.append( " radius: " + radius + ", " );
        }

        buffer.append( "}, " );

        return buffer;
    }
}
