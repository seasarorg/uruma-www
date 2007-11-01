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
package org.seasar.uruma.exception;

import org.seasar.uruma.binding.enables.EnablesForType;
import org.seasar.uruma.core.UrumaMessageCodes;

/**
 * EnablesDependig に関する例外発生時にスローされるクラスです<br />
 * 
 * @author y-komori
 */
public class EnablesDependingException extends UrumaRuntimeException {

    private static final long serialVersionUID = 8620926004808209421L;

    /**
     * {@link EnablesDependingException} を構築します。<br />
     * 
     * @param targetClass
     *            ターゲットウィジット
     * @see UrumaMessageCodes#DEPENDING_WIDGET_NOT_SUPPORTED
     */
    public EnablesDependingException(final Class<?> targetClass) {
        super(UrumaMessageCodes.DEPENDING_WIDGET_NOT_SUPPORTED, targetClass
                .getName());
    }

    /**
     * {@link EnablesDependingException} を構築します。<br />
     * 
     * @param targetClass
     *            ターゲットウィジット
     * @param type
     *            選択条件を表す {@link EnablesForType}
     * @see UrumaMessageCodes#DEPENDING_TYPE_NOT_SUPPORTED
     */
    public EnablesDependingException(final Class<?> targetClass,
            final EnablesForType type) {
        super(UrumaMessageCodes.DEPENDING_TYPE_NOT_SUPPORTED, targetClass
                .getName(), type);
    }
}
