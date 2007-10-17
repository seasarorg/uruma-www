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
package org.seasar.jface.viewer;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;

/**
 * {@link StructuredViewer} のための規定アダプタクラスです。<br />
 * 
 * @author y-komori
 * 
 * @param <VIEWER_TYPE>
 */
public abstract class AbstractStructuredViewerAdapter<VIEWER_TYPE extends Viewer>
        extends AbstractViewerAdapter<VIEWER_TYPE> {

    public AbstractStructuredViewerAdapter(StructuredViewer viewer) {
        super(viewer);
    }

    @Override
    protected IStructuredContentProvider createContentProvider() {
        return new GenericContentProvider();
    }
}
