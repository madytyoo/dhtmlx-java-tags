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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GridBaseTag extends BaseTag {
    public static class Column {
        public Column() {
        }

        public String name;
        public String type;
        public String align;
        public String valign;
        public String sort;
        public String width;
        public String format;
    }

    protected Collection<Column> columns = new ArrayList<Column>();


    protected String getColumnPropertyList(String property) {
        StringBuffer buffer = new StringBuffer();
        for (Iterator<Column> iterator = columns.iterator(); iterator.hasNext();) {
            Column column = iterator.next();
            buffer.append(getColumnProperty(column, property) + ",");
        }
        return (buffer.length() > 0 ? buffer.toString().substring(0, buffer.length() - 1) : null);
    }

    protected String getColumnProperty(Column column, String property) {
        String value = "";
        try {
            java.lang.reflect.Field field = column.getClass().getDeclaredField(property);
            value = field.get(column).toString();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return value;
    }

}
