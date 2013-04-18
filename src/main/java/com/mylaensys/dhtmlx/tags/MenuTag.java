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

import com.mylaensys.dhtmlx.model.*;

import javax.servlet.jsp.JspException;

public class MenuTag extends BaseTag {
    protected String id = null;
    protected String iconsPath = null;
    protected String align = null;    
    protected String openMode = "web";
    protected String overflowHeight = null;
    protected String onClick = null;
    protected String onRadioClick = null;
    protected String onCheckboxClick  = null;
    protected String onXLS = null;
    protected String onXLE = null;
    protected String onBeforeContextMenu = null;
    protected String onAfterContextMenu = null;
    protected String xml = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIconsPath() {
        return iconsPath;
    }

    public void setIconsPath(String iconsPath) {
        this.iconsPath = iconsPath;
    }

    public String getOpenMode() {
        return openMode;
    }

    public void setOpenMode(String openMode) {
        this.openMode = openMode;
    }

    public String getOverflowHeight() {
        return overflowHeight;
    }

    public void setOverflowHeight(String overflowHeight) {
        this.overflowHeight = overflowHeight;
    }

    public String getI18n() {
        return i18n;
    }

    public void setI18n(String i18n) {
        this.i18n = i18n;
    }

    public String getOnClick() {
        return onClick;
    }

    public void setOnClick(String onClick) {
        this.onClick = onClick;
    }



    public String getOnCheckboxClick() {
        return onCheckboxClick;
    }

    public void setOnCheckboxClick(String onCheckboxClick) {
        this.onCheckboxClick = onCheckboxClick;
    }

    public String getOnRadioClick() {
        return onRadioClick;
    }

    public void setOnRadioClick(String onRadioClick) {
        this.onRadioClick = onRadioClick;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
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

    public String getOnBeforeContextMenu() {
        return onBeforeContextMenu;
    }

    public void setOnBeforeContextMenu(String onBeforeContextMenu) {
        this.onBeforeContextMenu = onBeforeContextMenu;
    }

    public String getOnAfterContextMenu() {
        return onAfterContextMenu;
    }

    public void setOnAfterContextMenu(String onAfterContextMenu) {
        this.onAfterContextMenu = onAfterContextMenu;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    /**
       * Required for tag validation
       * @param body
       */
      public void accept( BodyTag body ) { }
      public void accept( LayoutCellTag cell) {
        component.setAttach( new AttachToLayout( cell.getName() , ((BaseTag)cell.getParent()).getName() ) );
      }

    public void accept( AccordionCellTag cell ) {
        component.setAttach( new AttachToAccordion( cell.getName() , ((BaseTag)cell.getParent()).getName() ) );
    }

    public void accept( GridTag grid ) {
        component.setAttach( new AttachToGrid( grid.getName() ));
    }

    public void accept( TreeTag tree ) {
        component.setAttach( new AttachToTree( tree.getName() ));
    }

    public void accept( TreeGridTag tree ) {
        component.setAttach( new AttachToGrid( tree.getName() ));
    }
    
    public int doStartTag() throws JspException {

        /* Declares the variable throws exception if double */
        BodyTag body = this.getBody();
        if( body.getComponents().containsKey( name ) ) {
            throw new JspException( "Duplicate variable " + name  );
        }

        if( this.iconsPath == null ) {
            this.iconsPath = body.getImagePath();
        }

        try {
            component = new Menu(name,id,iconsPath ,align ,openMode, onClick,onCheckboxClick, onRadioClick,onBeforeContextMenu,onAfterContextMenu,onXLS,onXLE,xml);
            /* Applies the values specified in the Body tag */
            body.getComponents().put( name , component );

            /* Accept the visitor throws exception if not welcome */
            accept( this.getParent() );

        } catch (Exception e) {
            throw new JspException("Menu Tag may only reside within a Body Tag or another container");
        }
        return super.doStartTag();
    }
}
