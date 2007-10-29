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
package org.seasar.uruma.binding.value.command;

import java.lang.reflect.Field;
import java.util.List;

import org.seasar.framework.beans.PropertyDesc;
import org.seasar.framework.util.StringUtil;
import org.seasar.uruma.annotation.ExportValue;
import org.seasar.uruma.annotation.ImportExportValue;
import org.seasar.uruma.binding.value.BindingCommand;
import org.seasar.uruma.binding.value.ValueBinder;
import org.seasar.uruma.desc.FormDesc;

/**
 * {@link ExportValue} アノテーションに対応した処理を行うための、{@link BindingCommand} です。<br />
 * 
 * @author y-komori
 */
public class ExportValueCommand extends AbstractBindingCommand<ExportValue> {

    /*
     * @see org.seasar.uruma.binding.value.BindingCommand#getTargetPropertyDescs(org.seasar.uruma.desc.FormDesc)
     */
    public List<PropertyDesc> getTargetPropertyDescs(final FormDesc desc) {
        return desc.getExportValueProperties();
    }

    /*
     * @see org.seasar.uruma.binding.value.command.AbstractBindingCommand#doBind(org.seasar.uruma.binding.value.ValueBinder,
     *      java.lang.Object, java.lang.Object,
     *      org.seasar.framework.beans.PropertyDesc)
     */
    @Override
    protected void doBind(final ValueBinder binder, final Object widget,
            final Object formObj, final PropertyDesc propDesc) {
        binder.exportValue(widget, formObj, propDesc);
    }

    /*
     * @see org.seasar.uruma.binding.value.command.AbstractBindingCommand#getId(java.lang.reflect.Field)
     */
    @Override
    public String getId(final Field field) {
        ExportValue exportValue = field.getAnnotation(ExportValue.class);
        if (exportValue != null) {
            String id = exportValue.id();
            return StringUtil.isEmpty(id) ? field.getName() : id;
        }

        ImportExportValue importExportValue = field
                .getAnnotation(ImportExportValue.class);
        if (importExportValue != null) {
            String id = importExportValue.id();
            return StringUtil.isEmpty(id) ? field.getName() : id;
        }

        return field.getName();
    }

    /*
     * @see org.seasar.uruma.binding.value.command.AbstractBindingCommand#getAnnotation(Field)
     */
    @Override
    protected ExportValue getAnnotation(final Field field) {
        return field.getAnnotation(ExportValue.class);
    }

    /*
     * @see org.seasar.uruma.binding.value.command.AbstractBindingCommand#getId(ANNOTATION_CLASS)
     */
    @Override
    protected String getId(final ExportValue annotation) {
        return annotation.id();
    }
}
