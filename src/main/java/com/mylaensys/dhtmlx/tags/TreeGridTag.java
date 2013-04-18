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

import com.mylaensys.dhtmlx.model.AttachToLayout;
import com.mylaensys.dhtmlx.model.TreeGrid;

import javax.servlet.jsp.JspException;

public class TreeGridTag extends BaseTag {
    private String id = null;
    private String onXLS = null;
    private String onXLE = null;
    private String onRowSelect = null;
    private String onRowDblClicked = null;
    protected String imageURL = "";
    private String init = "true";
    private String xml = null;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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

    public String getOnRowSelect() {
        return onRowSelect;
    }

    public void setOnRowSelect(String onRowSelect) {
        this.onRowSelect = onRowSelect;
    }

    public String getOnRowDblClicked() {
        return onRowDblClicked;
    }

    public void setOnRowDblClicked(String onRowDblClicked) {
        this.onRowDblClicked = onRowDblClicked;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public String getInit() {
        return init;
    }

    public void setInit(String init) {
        this.init = init;
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

    


    @Override
    public int doStartTag() throws JspException {
        /* Declares the variable throws exception if double */
        BodyTag body = this.getBody();
        if( body.getComponents().containsKey( name ) ) {
            throw new JspException( "Duplicate variable " + name  );
        }

        try {

            component = new TreeGrid(name,id,onXLS, onXLE, onRowSelect,onRowDblClicked,xml,init);
            ((TreeGrid)component).setImageURL( imageURL );


            component.setSkin( body.getSkin() );
            component.setImagePath( body.getImagePath() );

            body.getComponents().put( name , component );
            /* Accept the visitor throws excpetion if not welcome */
            accept( this.getParent() );
        } catch (Exception e) {
            throw new JspException("Grid Tag  may only reside within a Body Tag or another container");
        }
        return super.doStartTag();
    }

}
