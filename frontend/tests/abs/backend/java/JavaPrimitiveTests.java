/** 
 * Copyright (c) 2009-2011, The HATS Consortium. All rights reserved. 
 * This file is licensed under the terms of the Modified BSD License.
 */
package abs.backend.java;

import org.junit.Test;

public class JavaPrimitiveTests extends JavaBackendTest {
    @Test
    public void testNullLit() throws Exception {
        assertValid("interface I { } { I i; i = null; }");
    }

    @Test
    public void testBoolLit() throws Exception {
        assertValidStdLib(" { Bool b = True; b = False; }");
    }

    @Test
    public void testBoolNeg() throws Exception {
        assertValidStdLib(" { Bool b = ~True; }");
    }

    @Test
    public void testBoolAnd() throws Exception {
        assertValidStdLib(" { Bool b = True && False; }");
    }

    @Test
    public void testBoolOr() throws Exception {
        assertValidStdLib(" { Bool b = True || False; }");
    }

    @Test
    public void testBoolEq() throws Exception {
        assertValidStdLib(" { Bool b = True == False; }");
    }

    @Test
    public void testBoolNotEq() throws Exception {
        assertValidStdLib(" { Bool b = True != False; }");
    }

    @Test
    public void testIntLit() throws Exception {
        assertValidStdLib(" { Int i = 5; }");
    }

    @Test
    public void testNegativeIntLit() throws Exception {
        assertValidStdLib(" { Int i = -7; }");
    }

    @Test
    public void testLongIntLit() throws Exception {
        assertValidStdLib(" { Int i = 534023840238420394820394823094; }");
    }

    @Test
    public void testIntAddOps() throws Exception {
        assertValidStdLib(" { Int i = 5 + -7; }");
    }

    @Test
    public void testIntSubtractOps() throws Exception {
        assertValidStdLib(" { Int i = 7 - 5; }");
    }

    @Test
    public void testIntMultiplyOps() throws Exception {
        assertValidStdLib(" { Int i = 7 * 5; }");
    }

    @Test
    public void testIntDivideOps() throws Exception {
        assertValidStdLib(" { Int i = 7 / 5; }");
    }

    @Test
    public void testIntModOps() throws Exception {
        assertValidStdLib(" { Int i = 7 % 5; }");
    }

    @Test
    public void testIntCompareOps() throws Exception {
        assertValidStdLib("{ Bool b = 7 == 5; }");
        assertValidStdLib("{ Bool b = 7 != 5; }");
        assertValidStdLib("{ Bool b = 7 > 5; }");
        assertValidStdLib("{ Bool b = 7 < 5; }");
        assertValidStdLib("{ Bool b = 7 >= 5; }");
        assertValidStdLib("{ Bool b = 7 <= 5; }");
    }

    @Test
    public void testStringLit() throws Exception {
        assertValidStdLib("{ String s = \"Test\"; }");
    }

    @Test
    public void testStringCompareOps() throws Exception {
        assertValidStdLib("{ Bool b = \"Test\" == \"Test\"; }");
        assertValidStdLib("{ Bool b = \"Test\" != \"Test\"; }");
    }

}
