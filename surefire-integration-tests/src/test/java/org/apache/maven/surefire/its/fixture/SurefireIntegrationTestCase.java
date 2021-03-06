package org.apache.maven.surefire.its.fixture;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import junit.framework.TestCase;

/**
 * Contains commonly used features for most tests, encapsulating
 * common use cases.
 * <p/>
 * Also includes thread-safe access to the extracted resource
 * files, which AbstractSurefireIntegrationTestClass does not.
 * Thread safe only for running in "classes" mode.
 *
 * @author Kristian Rosenvold
 */
public abstract class SurefireIntegrationTestCase
    extends TestCase
{
    public OutputValidator executeErrorFreeTest( String sourceName, int total )
    {
        return unpack( sourceName ).executeTest().verifyErrorFree( total );
    }

    public SurefireLauncher unpack( String sourceName )
    {
        MavenLauncher mavenLauncher = new MavenLauncher( this.getClass(), sourceName, "" );
        return new SurefireLauncher( mavenLauncher );
    }

    public SurefireLauncher unpack( String sourceName, String suffix )
    {
        MavenLauncher mavenLauncher = new MavenLauncher( this.getClass(), sourceName, suffix );
        return new SurefireLauncher( mavenLauncher );
    }
}
