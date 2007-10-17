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
package org.seasar.uruma.renderer.impl;

import java.util.List;

import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Control;
import org.seasar.uruma.component.UIComponent;
import org.seasar.uruma.component.impl.CTabItemComponent;
import org.seasar.uruma.context.PartContext;
import org.seasar.uruma.context.WidgetHandle;
import org.seasar.uruma.renderer.RendererSupportUtil;

/**
 * {@link CTabItem} のレンダリングを行うクラスです。<br />
 * 
 * @author bskuroneko
 */
public class CTabItemRenderer extends
        AbstractWidgetRenderer<CTabItemComponent, CTabItem> {

    /*
     * @see org.seasar.uruma.renderer.impl.AbstractWidgetRenderer#doRender(org.seasar.uruma.component.UIComponent,
     *      org.eclipse.swt.widgets.Widget)
     */
    @Override
    protected void doRender(final CTabItemComponent controlComponent,
            final CTabItem control) {
        setFont(controlComponent, control);
    }

    /*
     * @see org.seasar.uruma.renderer.impl.AbstractWidgetRenderer#doRenderAfter(org.eclipse.swt.widgets.Widget,
     *      org.seasar.uruma.component.UIComponent,
     *      org.seasar.uruma.context.WidgetHandle,
     *      org.seasar.uruma.context.PartContext)
     */
    @Override
    protected void doRenderAfter(final CTabItem widget,
            final CTabItemComponent uiComponent, final WidgetHandle parent,
            final PartContext context) {
        setControl(widget, uiComponent);
    }

    private void setFont(final CTabItemComponent controlComponent,
            final CTabItem control) {
        if (controlComponent.getFontName() == null
                && controlComponent.getFontStyle() == null
                && controlComponent.getFontHeight() == null) {
            return;
        }
        Font font = RendererSupportUtil.getFont(control.getFont(),
                controlComponent.getFontName(),
                controlComponent.getFontStyle(), controlComponent
                        .getFontHeight());
        control.setFont(font);
    }

    private void setControl(final CTabItem tabItem,
            final CTabItemComponent tabItemComponent) {
        List<UIComponent> children = tabItemComponent.getChildren();
        if (children.size() > 0) {
            WidgetHandle handle = children.get(0).getWidgetHandle();
            tabItem.setControl((Control) handle.getWidget());
        }
    }

    /*
     * @see org.seasar.uruma.renderer.impl.AbstractWidgetRenderer#getWidgetType()
     */
    @Override
    protected Class<CTabItem> getWidgetType() {
        return CTabItem.class;
    }
}
