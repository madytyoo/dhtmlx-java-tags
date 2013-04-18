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
import com.mylaensys.dhtmlx.model.StatusBar;

import javax.servlet.jsp.JspException;

public class StatusBarTag extends BaseTag {
    protected String id = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
     public void accept( LayoutCellTag cell ) {
        component.setAttach( new AttachToLayout( cell.getName() , ((BaseTag)cell.getParent()).getName() ) );
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
     public void accept( AccordionCellTag cell ) {
         component.setAttach( new AttachToAccordion( cell.getName() , ((BaseTag)cell.getParent()).getName() ) );
     }


    /**
     * Required for tag validation
     * @param tab
     */
    public void accept( TabTag tab ) {
        component.setAttach( new AttachToLayout( tab.getName() , ((BaseTag)tab.getParent()).getName() ) );
    }

    public int doStartTag() throws JspException {

          /* Declares the variable throws exception if double */
          BodyTag body = this.getBody();
          if( body.getComponents().containsKey( name ) ) {
              throw new JspException( "Duplicate variable " + name  );
          }

          try {
              component = new StatusBar(name,id);
              /* Applies the values specified in the Body tag */
              body.getComponents().put( name , component );

              /* Accept the visitor throws excpetion if not welcome */
              accept( this.getParent() );

          } catch (Exception e) {
              throw new JspException("StatusBar Tag  may only reside within a a Body Tag or another container");
          }
          return super.doStartTag();
      }

}
