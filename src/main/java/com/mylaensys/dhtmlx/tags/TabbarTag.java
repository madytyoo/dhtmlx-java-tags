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
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;

public class TabbarTag extends BaseTag {
    private String id = null;
    private String mode = null;
    private String hrefMode = null;
    private String enableCloseButton = null;
    private String tabActive = null;
    private String onSelect = null;
    private String onTabClose = null;
    private String onTabContentLoaded = null;
    private String onXLS = null;
    private String onXLE = null;
    private String xml = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getHrefMode() {
        return hrefMode;
    }

    public void setHrefMode(String hrefMode) {
        this.hrefMode = hrefMode;
    }

    public String getEnableCloseButton() {
        return enableCloseButton;
    }

    public void setEnableCloseButton(String enableCloseButton) {
        this.enableCloseButton = enableCloseButton;
    }

    public String getTabActive() {
        return tabActive;
    }

    public void setTabActive(String tabActive) {
        this.tabActive = tabActive;
    }

    

    public String getOnSelect() {
        return onSelect;
    }

    public void setOnSelect(String onSelect) {
        this.onSelect = onSelect;
    }

    public String getOnTabClose() {
        return onTabClose;
    }

    public void setOnTabClose(String onTabClose) {
        this.onTabClose = onTabClose;
    }

    public String getOnTabContentLoaded() {
        return onTabContentLoaded;
    }

    public void setOnTabContentLoaded(String onTabContentLoaded) {
        this.onTabContentLoaded = onTabContentLoaded;
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

    /**
     * Required for tag validation
     * @param cell
     */
    public void accept( LayoutCellTag cell ) throws Exception {
        component.setAttach( new AttachToLayout( cell.getName() , ((BaseTag)cell.getParent()).getName() ) );
        //@STARTSTD@//
            throw new Exception("Standard Library does not support this feature");
        //@ENDSTD@//
    }

    /**
      * Required for tag validation
      * @param cell
      */
     public void accept( AccordionCellTag cell ) throws Exception {
         component.setAttach( new AttachToAccordion( cell.getName() , ((BaseTag)cell.getParent()).getName() ) );
        //@STARTSTD@//
            throw new Exception("Standard Library does not support this feature");
        //@ENDSTD@//
     }

    /**
     * Required for tag validation
     * @param tab
     */
    public void accept( TabTag tab ) throws Exception {
        component.setAttach( new AttachToLayout( tab.getName() , ((BaseTag)tab.getParent()).getName() ) );
    }
    
    @Override
    public int doStartTag() throws JspException {

        /* Declares the variable throws exception if double */
        BodyTag body = this.getBody();
        if( body.getComponents().containsKey( name ) ) {
            throw new JspException( "Duplicate variable " + name  );
        }

        try {
            component = new Tabbar(name,id,mode,hrefMode,enableCloseButton,tabActive,onSelect,onTabClose,onTabContentLoaded,onXLS,onXLE,xml);
            /* Applies the values specified in the Body tag */
            component.setSkin( body.getSkin() );
            component.setImagePath( body.getImagePath() );
            body.getComponents().put( name , component );

            /* Accept the visitor throws excpetion if not welcome */
            accept( this.getParent() );

        } catch (InvocationTargetException e) {
            throw new JspException( e.getCause().getMessage() );
        } catch (Exception e) {
            throw new JspException("Tabbar Tag  may only reside within a a Body Tag or another container");
        }
        return super.doStartTag();
    }

    @Override
    public int doEndTag() throws JspException {
        /* Check if the tab active is valid */
        boolean valid = false;
        if( tabActive != null && !tabActive.equalsIgnoreCase("none") ) {
            ArrayList<Component> list = component.getComponents();
            for (Iterator<Component> componentIterator = list.iterator(); componentIterator.hasNext();) {
                Component tab = componentIterator.next();
                if( tabActive.compareTo( tab.getName() ) == 0 )
                    valid = true;
            }
            if( !valid )
                throw new JspException("The 'tabActive' attribute is not valid : '" + tabActive + "' has not been defined" );

        }
        return super.doEndTag();
    }
}
