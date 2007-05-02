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
package org.seasar.jface.binding.impl;

import java.lang.reflect.Field;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Widget;
import org.seasar.framework.util.FieldUtil;
import org.seasar.jface.WindowContext;
import org.seasar.jface.binding.WidgetValueBinder;
import org.seasar.jface.viewer.TreeViewerAdapter;

/**
 * {@link org.eclipse.jface.viewers.TreeViewer} のための ValueBinder です。<br />
 * 
 * @author y-komori
 */
public class TreeValueBinder implements WidgetValueBinder {

    public void exportSelection(Object srcObject, Field srcField, Widget dest,
            WindowContext context) {

        // TODO 自動生成されたメソッド・スタブ

    }

    public void exportValue(Object srcObject, Field srcField, Widget dest,
            WindowContext context) {
        TreeViewerAdapter viewerAdapter = (TreeViewerAdapter) context
                .getViewerAdapter(dest);
        TreeViewer viewer = viewerAdapter.getViewer();

        Object input = FieldUtil.get(srcField, srcObject);
        if (input != null) {
            viewer.setInput(input);
        }
    }

    public Class<? extends Widget> getWidgetType() {
        return Tree.class;
    }

    public void importSelection(Widget src, Object destObject, Field destField,
            WindowContext context) {
        // TODO 自動生成されたメソッド・スタブ

    }

    public void importValue(Widget src, Object destObject, Field destField,
            WindowContext context) {
        // TODO 自動生成されたメソッド・スタブ

    }

}
