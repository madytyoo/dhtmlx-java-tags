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

import com.mylaensys.dhtmlx.model.LayoutCell;

import javax.servlet.jsp.JspException;

public class LayoutCellTag extends BaseTag {
    private String  text;
    private String  url;
    private String	width;
    private String	height;
    private boolean	fixWidth;
    private boolean	fixHeight;
    private boolean hideHeader;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isHideHeader() {
        return hideHeader;
    }

    public void setHideHeader(boolean hideHeader) {
        this.hideHeader = hideHeader;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public boolean isFixWidth() {
        return fixWidth;
    }

    public void setFixWidth(boolean fixWidth) {
        this.fixWidth = fixWidth;
    }

    public boolean isFixHeight() {
        return fixHeight;
    }

    public void setFixHeight(boolean fixHeight) {
        this.fixHeight = fixHeight;
    }

     public String getI18n() {
        return i18n;
    }

    public void setI18n(String i18n) {
        this.i18n = i18n;
    }

    public void accept(LayoutTag layout) {
        
    }

    @Override
    public int doStartTag() throws JspException {

        try {
            BaseTag parent = (BaseTag) getParent();
            text = computeText( text , getBody().getI18n() , this.i18n );

            component = new LayoutCell( parent.component,name,id,text,url,width,height,fixWidth,fixHeight,hideHeader );
            parent.component.getComponents().add( component );
            accept( this.getParent() );

        } catch (ClassNotFoundException e) {
            throw new JspException( e.getMessage() );
        } catch (InstantiationException e) {
            throw new JspException( e.getMessage() );
        } catch (Exception e) {
            throw new JspException("LayoutCell Tag  may only reside within a Layout Tag");
        }
        return super.doStartTag();
    }

}
