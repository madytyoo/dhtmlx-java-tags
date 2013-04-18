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

import com.mylaensys.dhtmlx.model.FormFieldSet;

import javax.servlet.jsp.JspException;

public class FormFieldSetTag extends BaseTag {
    protected String label = "";
    protected String width  = "99%";

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getI18n() {
        return i18n;
    }

    public void setI18n(String i18n) {
        this.i18n = i18n;
    }

    /**
     * Required for tag validation
     * @param form
     */
    public void accept( FormTag form ) { }
    public void accept( FormLabelTag label) {  }
    public void accept( FormRadioButtonTag  radio ) { }
    public void accept( FormCheckBoxTag checkbox ) { }
    public void accept( FormSelectOptionTag  option ) { }
    public void accept( FormFieldSetTag fieldset ) { }

    public int doStartTag() throws JspException {

        try {
            BaseTag parent = (BaseTag) getParent();
            label = computeText( label, getBody().getI18n() , this.i18n );

            component = new FormFieldSet( parent.component, name , label , width );
            parent.component.getComponents().add( component );
            accept( this.getParent() );

        } catch (ClassNotFoundException e) {
            throw new JspException( e.getMessage() );
        } catch (InstantiationException e) {
            throw new JspException( e.getMessage() );
        } catch (Exception e) {
            throw new JspException("FormFieldSet Tag  may only reside within a Form");
        }
        return super.doStartTag();
    }
}
