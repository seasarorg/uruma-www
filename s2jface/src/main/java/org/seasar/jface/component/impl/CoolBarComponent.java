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
package org.seasar.jface.component.impl;

import org.seasar.jface.annotation.component.ComponentAttribute;
import org.seasar.jface.annotation.component.ComponentAttribute.ConversionType;
import org.seasar.jface.annotation.component.ComponentAttribute.SetTiming;


/**
 * @author bskuroneko
 * 
 */
public class CoolBarComponent extends CompositeComponent {
    
    @ComponentAttribute(conversionType = ConversionType.BOOLEAN, setTiming = SetTiming.RENDER_AFTER)
    private String locked;
    
    @ComponentAttribute(conversionType = ConversionType.INT_ARRAY, setTiming = SetTiming.RENDER_AFTER)
    private String wrapIndices;

    public String getLocked() {
        return this.locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public String getWrapIndices() {
        return this.wrapIndices;
    }

    public void setWrapIndices(String wrapIndices) {
        this.wrapIndices = wrapIndices;
    }
    
}
