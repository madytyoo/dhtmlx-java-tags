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

import com.mylaensys.dhtmlx.model.AttachToAccordion;
import com.mylaensys.dhtmlx.model.AttachToLayout;
import com.mylaensys.dhtmlx.model.Tree;

import javax.servlet.jsp.JspException;

public class TreeTag extends BaseTag {
    private String id = null;
    private String imagePath = null;
    private String width = "100%";
    private String height = "100%";
    private String root = "0";
    private String onXLS = null;
    private String onXLE = null;
    private String onSelect = null;
    private String onClick = null;
    private String onDblClick = null;
    private String xml = null;
    private String skin = null;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getOnXLS() {
        return onXLS;
    }

    public void setOnXLS(String onXLS) {
        this.onXLS = onXLS;
    }

    public String getOnXLE() {
        return onXLE;
    }

    public void setOnXLE(String onXLE) {
        this.onXLE = onXLE;
    }

    public String getOnSelect() {
        return onSelect;
    }

    public void setOnSelect(String onSelect) {
        this.onSelect = onSelect;
    }

    public String getOnClick() {
        return onClick;
    }

    public void setOnClick(String onClick) {
        this.onClick = onClick;
    }

    public String getOnDblClick() {
        return onDblClick;
    }

    public void setOnDblClick(String onDblClick) {
        this.onDblClick = onDblClick;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    /**
       * Required for tag validation
       * @param body
       */
      public void accept( BodyTag body ) { }

    /**
     * Required for tag validation
     * @param cell
     */
    public void accept( LayoutCellTag cell ) {
        component.setAttach( new AttachToLayout( cell.getName() , ((BaseTag)cell.getParent()).getName() ) );
    }

    /**
     * Required for tag validation
     * @param tab
     */
    public void accept( TabTag tab ) {
        component.setAttach( new AttachToLayout( tab.getName() , ((BaseTag)tab.getParent()).getName() ) );
    }

    public void accept( AccordionCellTag cell ) {
        component.setAttach( new AttachToAccordion( cell.getName() , ((BaseTag)cell.getParent()).getName() ) );
    }

    @Override
       public int doStartTag() throws JspException {
           /* Declares the variable throws exception if double */
           BodyTag body = this.getBody();
           if( body.getComponents().containsKey( name ) ) {
               throw new JspException( "Duplicate variable " + name  );
           }

           try {

               if(this.imagePath == null) {
                    this.imagePath = body.getImagePath() ;
               }
               
               component = new Tree(name,id, imagePath , width,height,root ,onXLS, onXLE, onSelect , onClick , onDblClick ,xml,skin);               

               body.getComponents().put( name , component );
               /* Accept the visitor throws excpetion if not welcome */
               accept( this.getParent() );
           } catch (Exception e) {
               throw new JspException("Tree Tag  may only reside within a Body Tag or another container");
           }
           return super.doStartTag();
       }

}
