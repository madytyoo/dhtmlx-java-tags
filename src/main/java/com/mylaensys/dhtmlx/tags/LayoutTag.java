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
import com.mylaensys.dhtmlx.model.Layout;

import javax.servlet.jsp.JspException;
import java.lang.reflect.InvocationTargetException;

public class LayoutTag extends BaseTag {
    private String id = null;
    private String pattern = null;
    private String onDblClick = null;
    private String onExpand = null;
    private String onCollapse = null;
    private String onResizeFinish = null;
    private String onPanelResizeFinish = null;
    private String onContentLoaded = null;
    private String onDock = null;
    private String onUnDock = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getI18n() {
        return i18n;
    }

    public void setI18n(String i18n) {
        this.i18n = i18n;
    }
    
    public String getOnExpand() {
        return onExpand;
    }

    public void setOnExpand(String onExpand) {
        this.onExpand = onExpand;
    }

    public String getOnCollapse() {
        return onCollapse;
    }

    public void setOnCollapse(String onCollapse) {
        this.onCollapse = onCollapse;
    }

    public String getOnResizeFinish() {
        return onResizeFinish;
    }

    public void setOnResizeFinish(String onResizeFinish) {
        this.onResizeFinish = onResizeFinish;
    }

    public String getOnPanelResizeFinish() {
        return onPanelResizeFinish;
    }

    public void setOnPanelResizeFinish(String onPanelResizeFinish) {
        this.onPanelResizeFinish = onPanelResizeFinish;
    }

    public String getOnContentLoaded() {
        return onContentLoaded;
    }

    public void setOnContentLoaded(String onContentLoaded) {
        this.onContentLoaded = onContentLoaded;
    }

    public String getOnDock() {
        return onDock;
    }

    public void setOnDock(String onDock) {
        this.onDock = onDock;
    }

    public String getOnUnDock() {
        return onUnDock;
    }

    public void setOnUnDock(String onUnDock) {
        this.onUnDock = onUnDock;
    }


    public String getOnDblClick() {
        return onDblClick;
    }

    public void setOnDblClick(String onDblClick) {
        this.onDblClick = onDblClick;
    }

    /**
     * Required for tag validation
     * @param body
     */
    public void accept( BodyTag body ) { }

    /**
     * Required for tag validation
     * @param tab
     */
    public void accept( TabTag tab ) throws Exception {
        component.setAttach( new AttachToLayout( tab.getName() , ((BaseTag)tab.getParent()).getName() ) );
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
     * @param cell
     */
    public void accept( LayoutCellTag cell) throws Exception {
        component.setAttach( new AttachToLayout( cell.getName() , ((BaseTag)cell.getParent()).getName() ) );
        //@STARTSTD@//
            throw new Exception("Standard Library does not support this feature");
        //@ENDSTD@//

    }


    @Override
    public int doStartTag() throws JspException {
        /* Declares the variable throws exception if double */
        BodyTag body = this.getBody();
        if( body.getComponents().containsKey( name ) ) {
            throw new JspException( "Duplicate variable " + name  );
        }
        
        try {
            component = new Layout(name,id,pattern,onResizeFinish,onExpand,onCollapse,onPanelResizeFinish,onContentLoaded,onDock,onUnDock,onDblClick);
            body.getComponents().put( name , component);
            /* Accept the visitor throws excpetion if not welcome */
            accept( this.getParent() );
        } catch (InvocationTargetException e) {
            throw new JspException( e.getCause().getMessage() );
        } catch (Exception e) {
            throw new JspException("Layout Tag  may only reside within a Body Tag or another container");
        }
        return super.doStartTag();
    }

}
