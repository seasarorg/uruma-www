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
package org.seasar.jface.template;

import org.seasar.framework.xml.TagHandlerContext;
import org.seasar.jface.component.impl.ControlComponent;
import org.seasar.jface.component.impl.ItemComponent;
import org.xml.sax.Attributes;

public class ItemTagHandler extends AbstractTagHandler {
    private static final long serialVersionUID = 1L;
    private ControlComponent parent;
    
    @Override
    public void start(TagHandlerContext context, Attributes attributes) {
    }
    
    @Override
    public void end(TagHandlerContext context, String body) {
        parent = (ControlComponent) context.peek();
        ItemComponent item = new ItemComponent();
        item.setValue(body);
        parent.addItem(item);
    }
    
    @Override
    protected String getElementName() {
        return "item";
    }
}
