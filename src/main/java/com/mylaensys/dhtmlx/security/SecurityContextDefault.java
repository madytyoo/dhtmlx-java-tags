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
package com.mylaensys.dhtmlx.security;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.StringTokenizer;

public class SecurityContextDefault implements SecurityContext {
    public boolean hasRole(HttpServletRequest request, String param) {
        StringTokenizer st = new StringTokenizer(param,",");

        while (st.hasMoreTokens()) {
            if( request.isUserInRole( st.nextToken() ) )
                return true;
        }
        return false;
    }

    public boolean hasPermission(HttpServletRequest request, String param) {
        try {
            StringTokenizer st = new StringTokenizer(param,",");
            Properties properties = new Properties();
            InputStream inputStream = this.getClass().getClassLoader() .getResourceAsStream("ResourcePermission.properties");
            if( inputStream != null ) {
                properties.load(inputStream);

                while (st.hasMoreTokens()) {
                    if( properties.getProperty( request.getRemoteUser() + "." + st.nextToken() ) != null )
                        return true;
                }
            }
        } catch (IOException e) {
            //
        }
        return false;

    }
}
