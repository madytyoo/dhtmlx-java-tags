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

import com.mylaensys.dhtmlx.model.ToolbarSeparator;

import javax.servlet.jsp.JspException;

public class ToolbarSeparatorTag extends BaseTag {
    protected String id = null;
    protected String position = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    public void accept(ToolbarTag parent) {
    }


    public int doStartTag() throws JspException {

        try {
            BaseTag parent = (BaseTag) getParent();
            component = new ToolbarSeparator(parent.component, id, position);
            parent.component.getComponents().add(component);
            accept(this.getParent());

        } catch (ClassNotFoundException e) {
            throw new JspException(e.getMessage());
        } catch (InstantiationException e) {
            throw new JspException(e.getMessage());
        } catch (Exception e) {
            throw new JspException("Toolbar Text Tag may only reside within a Toolbar Tag");
        }
        return super.doStartTag();
    }


}
