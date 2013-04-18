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

public class StatusBar extends Component {

    public StatusBar(String name,String id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public StringBuffer render(StringTemplateGroup group) {
        StringTemplate status = group.getInstanceOf("META-INF/statusbar");
        group.setFileCharEncoding("UTF-8");

        
        StringBuffer buffer = new StringBuffer();


        if( attach != null ) {
            if( attach.open() ) {
                status.setAttribute( "openAttachment" , attach.getAttachment() );
            }
            status.setAttribute( "attachment" , attach.getAttachment() );
        }

        status.setAttribute( "id" , id );
        status.setAttribute( "name" , name );

        StringBuffer items = new StringBuffer();
        buffer.append( status.toString() );

        return buffer;


    }
}
