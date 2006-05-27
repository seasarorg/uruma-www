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
package org.seasar.jface.layout;

import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.seasar.jface.component.impl.ControlComponent;

/**
 * @author y-komori
 * 
 */
public class RowLayoutSupport extends AbstractLayoutSupport<RowLayout, RowData> {
    private static final String LAYOUT_NAME = "row";

    public RowLayout createLayout() {
        return new RowLayout();
    }

    public Class<RowLayout> getLayoutType() {
        return RowLayout.class;
    }

    public RowData createLayoutData() {
        return new RowData();
    }

    public RowData createLayoutData(ControlComponent controlComponent) {
        RowData rowData = createLayoutData();

        String width = controlComponent.getWidth();
        if (width != null) {
            rowData.width = Integer.parseInt(width);
        }

        String height = controlComponent.getHeight();
        if (height != null) {
            rowData.height = Integer.parseInt(height);
        }

        setupLayoutData(rowData, controlComponent);

        return rowData;
    }

    public String getLayoutName() {
        return LAYOUT_NAME;
    }
}
