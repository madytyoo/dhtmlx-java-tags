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

import com.mylaensys.dhtmlx.model.Column;

import javax.servlet.jsp.JspException;

public class ColumnTag extends BaseTag {
    private String header = "";
    private String type = "ro";
    private String sort;
    private String width;
    private String align = "left";
    private String valign;
    private String format;


    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public String getValign() {
        return valign;
    }

    public void setValign(String valign) {
        this.valign = valign;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getI18n() {
        return i18n;
    }

    public void setI18n(String i18n) {
        this.i18n = i18n;
    }

    public void setHasRole(String hasRole) {
        this.hasRole = hasRole;
    }

    public String getHasPermission() {
        return hasPermission;
    }

    public void setHasPermission(String hasPermission) {
        this.hasPermission = hasPermission;
    }

    /**
     * Required for tag validation
     * @param grid
     */
    public void accept( GridTag grid ) { }

    /**
     * Required for tag validation
     * @param grid
     */
    public void accept( TreeGridTag grid ) { }


    @Override
    public int doStartTag() throws JspException {
        try {
            if( isAuthorized() ) {
                BaseTag parent = (BaseTag) getParent();
                header = computeText( header, getBody().getI18n() , this.i18n );
                //@STARTSTD@//
                if( parent.component.getComponents().size() > 4 ) {
                    throw new IllegalArgumentException("Standard Library allows only 5 columns");
                }
                //@ENDSTD@//
                component = new Column(name,header,type, sort, width, align, valign, format );
                parent.component.getComponents().add( component );
                accept( this.getParent() );
            } else {
                return SKIP_BODY;
            }

        } catch (ClassNotFoundException e) {
            throw new JspException( e.getMessage() );
        } catch (InstantiationException e) {
            throw new JspException( e.getMessage() );
        } catch (IllegalArgumentException e) {
            throw new JspException(e.getMessage());
        } catch (Exception e) {
            throw new JspException("Column Tag  may only reside within a Grid Tag");
        }
        return super.doStartTag();
    }
}
