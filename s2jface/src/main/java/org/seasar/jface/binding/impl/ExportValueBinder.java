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
package org.seasar.jface.binding.impl;

import java.lang.reflect.Field;

import org.eclipse.swt.widgets.Widget;


/**
 * @author bskuroneko
 *
 */
public class ExportValueBinder extends AbstractValueBinder {
    
    public ExportValueBinder(Field field, Object bean, Widget widget) {
        super(field, bean, widget);
    }

    public void saveOldValue() {
        // TODO 自動生成されたメソッド・スタブ
    }

    @Override
    protected void doBind() {
        widgetValueBinder.exportValue(bean, field, widget);
    }
    
}
