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

import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.seasar.eclipse.common.util.GeometryUtil;
import org.seasar.eclipse.common.util.ImageManager;
import org.seasar.framework.util.StringUtil;
import org.seasar.uruma.component.UIComponent;
import org.seasar.uruma.component.impl.ControlComponent;
import org.seasar.uruma.component.impl.WindowComponent;
import org.seasar.uruma.context.PartContext;
import org.seasar.uruma.context.WidgetHandle;
import org.seasar.uruma.util.PathUtil;

/**
 * {@link Window} のレンダリングを行うためのクラスです。<br />
 * 
 * @author y-komori
 */
public class WindowRenderer extends
        AbstractCompositeRenderer<WindowComponent, Composite> {
    /**
     * {@link Shell} のスタイルを返します。<br />
     * 
     * @param uiComponent
     *            {@link WindowComponent} オブジェクト
     * @return スタイル値
     */
    public int getShellStyle(final WindowComponent uiComponent) {
        return getStyle(uiComponent);
    }

    /*
     * @see org.seasar.uruma.renderer.impl.AbstractWidgetRenderer#render(org.seasar.uruma.component.UIComponent,
     *      org.seasar.uruma.context.WidgetHandle,
     *      org.seasar.uruma.context.PartContext)
     */
    @Override
    public WidgetHandle render(final UIComponent uiComponent,
            final WidgetHandle parent, final PartContext context) {
        Shell shell = parent.<Shell> getCastWidget();

        configureShell((WindowComponent) uiComponent, shell);
        return super.render(uiComponent, parent, context);
    }

    /*
     * @see org.seasar.uruma.renderer.impl.AbstractWidgetRenderer#doRenderAfter(org.eclipse.swt.widgets.Widget,
     *      org.seasar.uruma.component.UIComponent,
     *      org.seasar.uruma.context.WidgetHandle,
     *      org.seasar.uruma.context.PartContext)
     */
    @Override
    protected void doRenderAfter(final Composite widget,
            final WindowComponent uiComponent, final WidgetHandle parent,
            final PartContext context) {
        setDefaultButton(uiComponent, context);
        setDefaultFocus(uiComponent, context);
    }

    protected void configureShell(final WindowComponent window,
            final Shell shell) {
        // タイトルの設定
        String title = window.getTitle();
        if (title != null) {
            shell.setText(title);
        }

        // ウィンドウサイズの設定
        String width = window.getWidth();
        String height = window.getHeight();
        if ((width != null) && (height != null)) {
            shell.setSize(calcWidth(width), calcHeight(height));
            shell.setLocation(calcX(window), calcY(window));
        }

        // 最小ウィンドウサイズの設定
        setMinimumSize(window, shell);

        // アイコンの設定
        String img = window.getImage();
        if (!StringUtil.isEmpty(img)) {
            Image image = ImageManager.getImage(img);
            if (image == null) {
                String path = PathUtil.createPath(window.getBasePath(), img);
                image = ImageManager.loadImage(path);
            }
            shell.setImage(image);
        }
    }

    protected int calcWidth(final String width) {
        return GeometryUtil.calcSize(width, Display.getCurrent()
                .getClientArea().width);
    }

    protected int calcHeight(final String height) {
        return GeometryUtil.calcSize(height, Display.getCurrent()
                .getClientArea().height);
    }

    protected int calcX(final WindowComponent window) {
        return GeometryUtil.calcPosition(window.getX(), Display.getCurrent()
                .getClientArea().width, calcWidth(window.getWidth()));
    }

    protected int calcY(final WindowComponent window) {
        return GeometryUtil.calcPosition(window.getY(), Display.getCurrent()
                .getClientArea().height, calcHeight(window.getHeight()));
    }

    protected void setDefaultButton(final WindowComponent windowComponent,
            final PartContext context) {
        WidgetHandle defaultButtonHandle = context
                .getWidgetHandle(windowComponent.getDefaultButtonId());

        if (defaultButtonHandle != null) {
            if (Button.class.isAssignableFrom(defaultButtonHandle
                    .getWidgetClass())) {
                Button defaultButton = defaultButtonHandle
                        .<Button> getCastWidget();

                WidgetHandle handle = context
                        .getWidgetHandle(PartContext.SHELL_ID);
                Shell shell = handle.<Shell> getCastWidget();
                if (shell != null) {
                    shell.setDefaultButton(defaultButton);
                    defaultButton.forceFocus();
                }
            }

        }
    }

    protected void setDefaultFocus(final WindowComponent windowComponent,
            final PartContext context) {
        WidgetHandle defaultFocusHandle = context
                .getWidgetHandle(windowComponent.getDefaultButtonId());
        if (defaultFocusHandle != null) {
            if (Control.class.isAssignableFrom(defaultFocusHandle
                    .getWidgetClass())) {
                Control control = defaultFocusHandle.<Control> getCastWidget();
                control.setFocus();
            }
        }
    }

    protected void setMinimumSize(final WindowComponent windowComponent,
            final Shell shell) {
        String minWidth = windowComponent.getMinimumWidth();
        String minHeight = windowComponent.getMinimumHeight();
        if ((minWidth != null) && (minHeight != null)) {
            shell.setMinimumSize(calcWidth(minWidth), calcHeight(minHeight));
        }
    }

    /*
     * @see org.seasar.uruma.renderer.impl.AbstractWidgetRenderer#getWidgetType()
     */
    @Override
    protected Class<Composite> getWidgetType() {
        return Composite.class;
    }

    /*
     * @see org.seasar.uruma.renderer.impl.AbstractRenderer#getDefaultStyle()
     */
    @Override
    protected int getDefaultStyle() {
        return SWT.SHELL_TRIM;
    }

    /*
     * @see org.seasar.uruma.renderer.impl.AbstractCompositeRenderer#doRenderComposite(org.seasar.uruma.component.impl.CompositeComponent,
     *      org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected void doRenderComposite(final WindowComponent compositeComponent,
            final Composite composite) {
        // Do nothing.
    }

    /*
     * @see org.seasar.uruma.renderer.impl.AbstractControlRenderer#setLocation(org.seasar.uruma.component.impl.ControlComponent,
     *      org.eclipse.swt.widgets.Control)
     */
    @Override
    protected void setLocation(final ControlComponent controlComponent,
            final Control control) {
        // Do nothing.
    }

    /*
     * @see org.seasar.uruma.renderer.impl.AbstractControlRenderer#setSize(org.seasar.uruma.component.impl.ControlComponent,
     *      org.eclipse.swt.widgets.Control)
     */
    @Override
    protected void setSize(final ControlComponent controlComponent,
            final Control control) {
        // Do nothing.
    }

    /*
     * @see org.seasar.uruma.renderer.impl.AbstractControlRenderer#setMenu(org.seasar.uruma.component.impl.ControlComponent,
     *      org.eclipse.swt.widgets.Control)
     */
    @Override
    protected void setMenu(final ControlComponent controlComponent,
            final Control control) {
        // Do nothing.
    }
}
