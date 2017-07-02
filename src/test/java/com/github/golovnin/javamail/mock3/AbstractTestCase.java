/*
 *  JavaMail Mock3 Provider - open source mock classes for mock up JavaMail
 *  =======================================================================
 *
 *  Copyright (C) 2014 by Hendrik Saly (http://saly.de)
 *
 *  Based on ideas from Kohsuke Kawaguchi's Mock-javamail
 *  (https://java.net/projects/mock-javamail)
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with
 *  the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on
 *  an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *  either express or implied. See the License for the
 *  specific language governing permissions and limitations under the License.
 */
package com.github.golovnin.javamail.mock3;

import java.util.Properties;
import javax.mail.Session;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

public abstract class AbstractTestCase {

    @Rule
    public TestName name = new TestName();
    protected Session session = null;

    protected Properties getProperties() {
        return new Properties();
    }

    @Before
    public void setUp() throws Exception {
        Properties props = getProperties();
        session = Session.getInstance(props);

        MockMailbox.resetAll();
    }

    @After
    public void tearDown() throws Exception {
        session = null;
    }

}
