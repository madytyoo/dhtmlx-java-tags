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

public class LineChartTag extends BaseTag {
    protected String value = null;
    protected String label = null;
    protected String tooltip = null;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    public String getI18n() {
        return i18n;
    }

    public void setI18n(String i18n) {
        this.i18n = i18n;
    }

    public void accept( BodyTag body ) throws Exception {
        //@STARTSTD@//
            throw new Exception("Standard Library does not support this feature");
        //@ENDSTD@//
    }

    public void accept(AccordionCellTag cell) throws Exception {
        component.setAttach(new AttachToAccordion(cell.getName(), ((BaseTag) cell.getParent()).getName()));
        //@STARTSTD@//
            throw new Exception("Standard Library does not support this feature");
        //@ENDSTD@//
    }


    public void accept(LayoutCellTag cell) throws Exception {
        component.setAttach(new AttachToLayout(cell.getName(), ((BaseTag) cell.getParent()).getName()));
        //@STARTSTD@//
            throw new Exception("Standard Library does not support this feature");
        //@ENDSTD@//

    }

    public void accept(TabTag tab) throws Exception {
        component.setAttach(new AttachToLayout(tab.getName(), ((BaseTag) tab.getParent()).getName()));
        //@STARTSTD@//
            throw new Exception("Standard Library does not support this feature");
        //@ENDSTD@//
    }

    public int doStartTag() throws JspException {

           /* Declares the variable throws exception if double */
           BodyTag body = this.getBody();
           if (body.getComponents().containsKey(name)) {
               throw new JspException("Duplicate variable " + name);
           }

           try {
               component = new LineChart(name,id,value,label,tooltip);
               body.getComponents().put(name, component);
               /* Accept the visitor throws excpetion if not welcome */
               accept(this.getParent());
           } catch (InvocationTargetException e) {
               throw new JspException( e.getCause().getMessage() );
           } catch (Exception e) {
               throw new JspException("ChartLinr Tag  may only reside within a a Body Tag or another container");
           }
           return super.doStartTag();
       }

}
