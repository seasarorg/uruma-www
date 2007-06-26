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
package org.seasar.eclipse.rcp.ui;

import java.lang.reflect.Method;

import org.eclipse.ui.INullSelectionListener;

/**
 * {@link INullSelectionListener} を実装した {@link GenericSelectionListener} です。<br />
 * <p>
 * 本クラスは、{@link INullSelectionListener} を実装し、選択結果が <code>null</code>
 * の場合でも呼び出される以外は {@link GenericSelectionListener} と同じ機能を提供します。<br />
 * </p>
 * 
 * @author y-komori
 */
public class NullGenericSelectionListener extends GenericSelectionListener
        implements INullSelectionListener {

    /**
     * {@link NullGenericSelectionListener} を構築します。<br />
     * 
     * @param targetObjct
     *            呼び出し対象オブジェクト
     * @param targetMethod
     *            呼び出し対象メソッドの {@link Method} オブジェクト
     */
    public NullGenericSelectionListener(Object targetObjct, Method targetMethod) {
        super(targetObjct, targetMethod);
    }
}
