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

import org.eclipse.swt.widgets.Widget;
import org.seasar.framework.beans.BeanDesc;
import org.seasar.framework.beans.PropertyDesc;
import org.seasar.framework.beans.factory.BeanDescFactory;
import org.seasar.jface.WindowContext;

/**
 * 単一プロパティに対するバインディングを行うための汎用クラスです。<br />
 * 
 * @author bskuroneko
 */
public class WidgetPropertyValueBinder extends AbstractWidgetValueBinder {

    private PropertyDesc propertyDesc;

    public WidgetPropertyValueBinder(Class<? extends Widget> widgetType,
            String propertyName) {
        super(widgetType);
        BeanDesc beanDesc = BeanDescFactory.getBeanDesc(widgetType);
        this.propertyDesc = beanDesc.getPropertyDesc(propertyName);
    }

    @Override
    protected Object getWidgetValue(Widget widget) {
        Object value = propertyDesc.getValue(widget);
        // 空文字列の入力は null として扱う
        if (value instanceof String && ((String) value).length() == 0) {
            value = null;
        }
        return value;
    }

    @Override
    protected void putWidgetValue(Widget widget, Object value) {
        Object convertedValue = convertValue(value, propertyDesc
                .getPropertyType());
        convertedValue = convertedValue == null ? "" : convertedValue;
        propertyDesc.setValue(widget, convertedValue);
    }

    public void exportSelection(Object srcObject, Field srcField, Widget dest,
            WindowContext context) {
        // Do nothing.
    }

    public void importSelection(Widget src, Object destObject, Field destField,
            WindowContext context) {
        // Do nothing.
    }
}
