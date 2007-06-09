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
package org.seasar.jface.renderer.impl;

import org.eclipse.swt.widgets.MenuItem;
import org.seasar.jface.component.impl.MenuItemComponent;

/**
 * <code>MenuItem</code> のレンダリングを行うクラスです。<br />
 * 
 * @author bskuroneko
 */
public class MenuItemRenderer extends
        AbstractWidgetRenderer<MenuItemComponent, MenuItem> {

    @Override
    protected void doRender(MenuItemComponent menuItemComponent,
            MenuItem control) {
        addEnabledDepend(control, menuItemComponent);
    }

    @Override
    protected Class<MenuItem> getWidgetType() {
        return MenuItem.class;
    }
}
