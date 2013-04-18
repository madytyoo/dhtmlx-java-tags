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

public class MenuSibling extends MenuObject {
    protected String nextTo = null;
    protected String text = null;
    protected String disabled = null;
    protected String imageEnabled = null;
    protected String imageDisabled = null;

    public MenuSibling(Component parent,String nextTo, String id, String text, String disabled, String imageEnabled, String imageDisabled) {
        this.parent = parent;
        this.nextTo = nextTo;
        this.id = id;
        this.text = text;
        this.disabled = disabled;
        this.imageEnabled = imageEnabled;
        this.imageDisabled = imageDisabled;
    }

    
    @Override
    public StringBuffer render(StringTemplateGroup group) {
        StringBuffer buffer = new StringBuffer();

        buffer.append( this.getMenu().getName() + ".addNewSibling(" );
        if( nextTo != null ) {
            buffer.append( "'" + nextTo + "',");
        } else {
            buffer.append( "null,");
        }
        if( id != null ) {
            buffer.append( "'" + id + "',");
        } else {
            /* Should be never be null */
        }

        if( text != null ) {
            buffer.append( "'" + text  + "',");
        } else {
            /* Should be never be null */
        }

        if( disabled != null ) {
            if("true".equalsIgnoreCase( disabled ) ) {
                buffer.append( "true,");
            } else {
                buffer.append( "false,");
            }
        } else {
            buffer.append( "false,");
        }


        if(imageEnabled != null ) {
            buffer.append( "'" + imageEnabled + "',");
        } else {
            buffer.append( "null," );
        }
        if(imageDisabled != null ) {
            buffer.append( "'" + imageDisabled + "'");
        } else {
            buffer.append( "null" );
        }
        buffer.append( ");" );

        buffer.append("\n");

        buffer = renderChild(group, buffer);


        return buffer;

    }
}
