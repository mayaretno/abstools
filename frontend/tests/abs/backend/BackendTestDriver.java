/** 
 * Copyright (c) 2009-2011, The HATS Consortium. All rights reserved. 
 * This file is licensed under the terms of the Modified BSD License.
 */
package abs.backend;

public abstract class BackendTestDriver {

    public abstract void assertEvalEquals(String absCode, boolean value) throws Exception;

    public abstract void assertEvalFails(String absCode) throws Exception;

    public void assertEvalTrue(String absCode) throws Exception {
        assertEvalEquals(absCode, true);
    }
}
