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

import org.eclipse.swt.widgets.Widget;
import org.seasar.jface.component.UIComponent;
import org.seasar.jface.renderer.Renderer;
import org.seasar.jface.util.AssertionUtil;

/**
 * @author y-komori
 */
public abstract class AbstractUIComponent extends AbstractUIElement implements
        UIComponent {
    private String id;

    private String style;

    private Renderer renderer;

    private Widget widget;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStyle() {
        return this.style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Renderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(Renderer renderer) {
        AssertionUtil.assertNotNull("renderer", renderer);
        this.renderer = renderer;
    }

    public Widget getWidget() {
        return this.widget;
    }

    public void setWidget(Widget widget) {
        AssertionUtil.assertNotNull("widget", widget);
        this.widget = widget;
    }
}
