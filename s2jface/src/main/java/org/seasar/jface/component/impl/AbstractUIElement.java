/*
 * Copyright 2004-2007 the Seasar Foundation and the Others.
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

import org.seasar.jface.component.UIElement;

/**
 * {@link UIElement} を表す基底クラスです。<br />
 * 
 * @author y-komori
 */
public abstract class AbstractUIElement implements UIElement {
    private String basePath;

    private String location;

    /*
     * @see org.seasar.jface.component.UIElement#getBasePath()
     */
    public String getBasePath() {
        return this.basePath;
    }

    /*
     * @see org.seasar.jface.component.UIElement#setBasePath(java.lang.String)
     */
    public void setBasePath(final String basePath) {
        this.basePath = basePath;
    }

    /*
     * @see org.seasar.jface.component.UIElement#getLocation()
     */
    public String getLocation() {
        return this.location;
    }

    /*
     * @see org.seasar.jface.component.UIElement#setLocation(java.lang.String)
     */
    public void setLocation(final String location) {
        this.location = location;
    }
}
