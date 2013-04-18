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

package com.mylaensys.dhtmlx.tags;

import com.mylaensys.dhtmlx.model.Component;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class BodyTag extends BaseTag {
    private String skin = "dhx_skyblue";
    private String imagePath;

    private String skins[] = { "dhx_skyblue","dhx_blue","dhx_black", "dhx_web" };

    private LinkedHashMap<String,Component> components = new LinkedHashMap<String,Component>();
    private StringTemplateGroup templateGroup = new StringTemplateGroup("templates");

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getI18n() {
        return i18n;
    }

    public void setI18n(String i18n) {
        this.i18n = i18n;
    }


    public LinkedHashMap<String, Component> getComponents() {
        return components;
    }



    @Override
    public int doStartTag() throws JspException {
        components.clear();
        /* Attributes check */
        if( imagePath != null ) {
            if(imagePath.length() == 0)
                throw new JspException("imagePath attribute cannot be empty");
        }

        if( i18n != null ) {
            if(i18n.length() == 0)
                throw new JspException("i18n attribute cannot be empty");
        }

        return super.doStartTag();
    }

    @Override
    public int doEndTag() throws JspException {
        StringTemplate body = templateGroup.getInstanceOf("META-INF/body");

        

        StringBuffer vars = new StringBuffer();
        for (Iterator<Map.Entry<String,Component>> iterator = components.entrySet().iterator(); iterator.hasNext();) {
            vars.append( iterator.next().getKey() + "," );
        }
        if( vars.lastIndexOf(",") > -1){
            vars.setCharAt( vars.lastIndexOf(",") , ';');
        }
        /* Iterate the components an render the code */
        StringBuffer buffer = new StringBuffer();
        for (Iterator<Map.Entry<String,Component>> iterator = components.entrySet().iterator(); iterator.hasNext();) {
            buffer.append( iterator.next().getValue().render(templateGroup) );
        }
        if( components.size() > 0 ) {
            body.setAttribute( "vars" , vars );
        }
        body.setAttribute( "name" , name );
        body.setAttribute( "code" , buffer.toString()  );
        if( imagePath != null ) {
            body.setAttribute( "imagePath" , imagePath );
        }

        try {
            JspWriter writer = pageContext.getOut();
            String path = System.getProperty("com.mylaensys.tag.compile.path", "");
            String filename = System.getProperty("com.mylaensys.tag.compile.filename", "");
            if ("".equalsIgnoreCase(filename)) {
                body.setAttribute( "script" , "script");
                writer.print(body.toString());
            } else {

                try {
                    body.setAttribute( "script" , null );                    
                    FileWriter fstream = new FileWriter(path + "/" + filename, true );
                    BufferedWriter out = new BufferedWriter(fstream);
                    out.write(body.toString());
                    out.close();
                    String already = System.getProperty("com.mylaensys.tag.compile.script","no");
                    if( "no".equalsIgnoreCase( already )) {
                        writer.println("<script language=\"JavaScript\" type=\"text/javascript\" src=\"" + filename +"\"></script>");
                        System.setProperty("com.mylaensys.tag.compile.script","yes");                        
                    }
                } catch (Exception e) {//Catch exception if any
                    System.err.println("Error: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
