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
package org.seasar.uruma.binding.value.binder;

import org.eclipse.swt.widgets.Combo;
import org.seasar.framework.beans.PropertyDesc;
import org.seasar.uruma.binding.value.ValueBinder;

/**
 * {@link Combo} のための {@link ValueBinder} です。<br />
 * 
 * @author y-komori
 */
public class ComboValueBinder extends AbstractValueBinder {

    /**
     * {@link ComboValueBinder} を構築します。<br />
     * 
     */
    public ComboValueBinder() {
        super(Combo.class);
    }

    @Override
    protected Object getWidgetValue(final Object widget) {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    @Override
    protected void setWidgetValue(final Object widget, final Object value) {
        // TODO 自動生成されたメソッド・スタブ

    }

    public void exportSelection(final Object widget, final Object formObj,
            final PropertyDesc propDesc) {
        // TODO 自動生成されたメソッド・スタブ

    }

    public void importSelection(final Object widget, final Object formObj,
            final PropertyDesc propDesc) {
        // TODO 自動生成されたメソッド・スタブ

    }

}
