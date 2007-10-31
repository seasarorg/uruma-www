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
package org.seasar.uruma.context.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.seasar.uruma.context.ApplicationContext;
import org.seasar.uruma.context.ContextFactory;
import org.seasar.uruma.context.WindowContext;
import org.seasar.uruma.exception.DuplicateComponentIdException;
import org.seasar.uruma.util.AssertionUtil;

/**
 * {@link ApplicationContext} の実装クラスです。<br />
 * 
 * @author y-komori
 */
public class ApplicationContextImpl implements ApplicationContext {
    private List<WindowContext> windowContextList = new ArrayList<WindowContext>();

    private Map<String, Object> valueMap = new HashMap<String, Object>();

    /**
     * {@link ApplicationContextImpl} を構築します。<br />
     * 本クラスのインスタンスを生成するには、{@link ContextFactory#createApplicationContext()}
     * メソッドを利用してください。<br />
     */
    public ApplicationContextImpl() {
        super();
    }

    /*
     * @see org.seasar.uruma.context.ApplicationContext#getWindowContext(java.lang.String)
     */
    public WindowContext getWindowContext(final String windowName) {
        for (WindowContext context : windowContextList) {
            if (context.getName().equals(windowName)) {
                return context;
            }
        }
        return null;
    }

    /*
     * @see org.seasar.uruma.context.ApplicationContext#getWindowContexts()
     */
    public Collection<WindowContext> getWindowContexts() {
        return Collections.unmodifiableCollection(windowContextList);
    }

    /**
     * {@link WindowContext} オブジェクトを追加します。<br />
     * 
     * @param context
     *            追加する {@link WindowContext} オブジェクト
     * @throws DuplicateComponentIdException
     *             ウィンドウ名称が既に登録されている場合
     */
    public void addWindowContext(final WindowContext context) {
        AssertionUtil.assertNotNull("context", context);

        if (getWindowContext(context.getName()) == null) {
            windowContextList.add(context);
        } else {
            throw new DuplicateComponentIdException(context.getName());
        }
    }

    /**
     * {@link WindowContext} を削除します。<br />
     * 
     * @param windowName
     *            ウィンドウ名称
     */
    public void disposeWindowContext(final String windowName) {
        WindowContext context = getWindowContext(windowName);
        if (context != null) {
            windowContextList.remove(context);
        }
    }

    /*
     * @see org.seasar.uruma.context.ApplicationContext#getValue(java.lang.String)
     */
    public Object getValue(final String name) {
        return valueMap.get(name);
    }

    /*
     * @see org.seasar.uruma.context.ApplicationContext#setValue(java.lang.String,
     *      java.lang.Object)
     */
    public void setValue(final String name, final Object value) {
        AssertionUtil.assertNotEmpty("name", name);
        valueMap.put(name, value);
    }
}
