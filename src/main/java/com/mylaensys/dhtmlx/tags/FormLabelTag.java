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

import com.mylaensys.dhtmlx.model.FormLabel;

import javax.servlet.jsp.JspException;

public class FormLabelTag extends BaseTag {
    protected String label = "";
    protected String labelWidth = "";
    protected String offsetLeft = "";
    protected String className = "";


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabelWidth() {
        return labelWidth;
    }

    public void setLabelWidth(String labelWidth) {
        this.labelWidth = labelWidth;
    }

    public String getOffsetLeft() {
        return offsetLeft;
    }

    public void setOffsetLeft(String offsetLeft) {
        this.offsetLeft = offsetLeft;
    }

    public String getI18n() {
        return i18n;
    }

    public void setI18n(String i18n) {
        this.i18n = i18n;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Required for tag validation
     * @param form
     */
    public void accept( FormTag form ) { }
    public void accept( FormFieldSetTag  fieldset ) { }
    public void accept( FormRadioButtonTag  radio ) { }
    public void accept( FormCheckBoxTag checkbox) { }
    public void accept( FormSelectOptionTag  option ) { }
    public void accept( FormLabelTag label ) { }

    public int doStartTag() throws JspException {

        try {
            BaseTag parent = (BaseTag) getParent();
            label = computeText( label, getBody().getI18n() , this.i18n );

            component = new FormLabel( parent.component ,name ,label, labelWidth , offsetLeft , className);
            parent.component.getComponents().add( component );
            accept( this.getParent() );

        } catch (ClassNotFoundException e) {
            throw new JspException( e.getMessage() );
        } catch (InstantiationException e) {
            throw new JspException( e.getMessage() );
        } catch (Exception e) {
            throw new JspException("FormLabel Tag  may only reside within a Form");
        }
        return super.doStartTag();
    }

}
