﻿/*
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
package org.seasar.jface.exception;

/**
 * @author y-komori
 * 
 */
public class ParseException extends S2JFaceRuntimeException {
    private static final long serialVersionUID = -2200546651277420749L;

    public ParseException(final String messageCode, final Object... args) {
        super(messageCode, args);
    }

    public ParseException(final String messageCode, final Throwable cause,
            final Object... args) {
        super(messageCode, cause, args);
    }

    public ParseException(final String messageCode) {
        super(messageCode);
    }
}
