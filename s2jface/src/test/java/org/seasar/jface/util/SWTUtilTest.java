/*
 * Copyright 2004-2006 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.jface.util;

import junit.framework.TestCase;

import org.eclipse.swt.SWT;
import org.seasar.jface.util.SWTUtil;

/**
 * @author y-komori
 * 
 */
public class SWTUtilTest extends TestCase {
    public void testGetSWTConstant() {
        assertEquals(SWT.ABORT, SWTUtil.getSWTConstant("ABORT"));
        assertEquals(SWT.BOLD, SWTUtil.getSWTConstant("BOLD"));
        assertEquals(SWT.CLOSE, SWTUtil.getSWTConstant("CLOSE"));
        assertEquals(SWT.NONE, SWTUtil.getSWTConstant("NONE"));
        assertEquals(SWT.NONE, SWTUtil.getSWTConstant("dummy"));
    }

    public void testGetStyle() {
        assertEquals(SWT.RIGHT, SWTUtil.getStyle("RIGHT"));
        assertEquals(SWT.HORIZONTAL | SWT.SHADOW_IN | SWT.CENTER, SWTUtil
                .getStyle("HORIZONTAL,SHADOW_IN,CENTER"));
        assertEquals(SWT.HORIZONTAL | SWT.SHADOW_IN | SWT.CENTER, SWTUtil
                .getStyle("SHADOW_IN,CENTER,HORIZONTAL"));
        assertEquals(SWT.VERTICAL | SWT.SHADOW_OUT | SWT.LEFT, SWTUtil
                .getStyle(" VERTICAL  , SHADOW_OUT ,  LEFT  "));
        assertEquals(SWT.VERTICAL | SWT.LEFT, SWTUtil
                .getStyle(" VERTICAL  , dummy ,  LEFT  "));
        assertEquals(SWT.NONE, SWTUtil.getStyle(""));
        assertEquals(SWT.NONE, SWTUtil.getStyle(", dummy , , ,"));
        assertEquals(SWT.NONE, SWTUtil.getStyle(null));
    }

//    public void testGetColor() {
//        assertSame(new Color(Display.getCurrent(), 255, 0, 0), SWTUtil
//                .getColor("#FF0000"));
//    }
}
