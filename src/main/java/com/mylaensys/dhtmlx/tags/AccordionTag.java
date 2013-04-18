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

public class AccordionTag extends BaseTag {
    private String id = null;
    private String mode = null;
    private String openItem = null;
    private String onActive = null;
    private String onBeforeActive = null;
    private String onDock = null;
    private String onUnDock = null;

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

    public String getI18n() {
        return i18n;
    }

    public void setI18n(String i18n) {
        this.i18n = i18n;
    }

    public String getOpenItem() {
        return openItem;
    }

    public void setOpenItem(String openItem) {
        this.openItem = openItem;
    }

    public String getOnActive() {
        return onActive;
    }


    public void setOnActive(String onActive) {
        this.onActive = onActive;
    }

    public String getOnBeforeActive() {
        return onBeforeActive;
    }

    public void setOnBeforeActive(String onBeforeActive) {
        this.onBeforeActive = onBeforeActive;
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

    public void accept( BodyTag body ) { }

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
    /**
     * Required for tag validation
     * @param cell
     */
    public void accept(TabTag cell) throws Exception {
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


    @Override
    public int doStartTag() throws JspException {
        /* Declares the variable throws exception if double */
        BodyTag body = this.getBody();
        if( body.getComponents().containsKey( name ) ) {
            throw new JspException( "Duplicate variable " + name  );
        }
        
        try {
            component = new Accordion(name,id, mode,openItem, onActive, onBeforeActive, onDock, onUnDock);
            body.getComponents().put( name , component );
            /* Accept the visitor throws excpetion if not welcome */
            accept( this.getParent() );
        } catch (InvocationTargetException  e) {
            throw new JspException( e.getCause().getMessage() );
        } catch (Exception e) {
            throw new JspException("Accordion Tag  may only reside within a Body Tag or another container");
        }
        return super.doStartTag();
    }
          @Override
    public int doEndTag() throws JspException {
        /* Check if the item active is valid */
        boolean valid = false;
        if( openItem != null && !openItem.equalsIgnoreCase("none") ) {
            ArrayList<Component> list = component.getComponents();
            for (Iterator<Component> componentIterator = list.iterator(); componentIterator.hasNext();) {
                Component cell = componentIterator.next();
                if( openItem.compareTo( cell.getName() ) == 0 )
                    valid = true;
            }
            if( !valid )
                throw new JspException("The 'openItem' attribute is not valid : '" + openItem + "' has not been defined" );

        }
        return super.doEndTag();
    }

}
