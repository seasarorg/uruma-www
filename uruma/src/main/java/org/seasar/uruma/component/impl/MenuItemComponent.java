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
package org.seasar.uruma.component.impl;

import org.seasar.uruma.annotation.RenderingPolicy;
import org.seasar.uruma.annotation.RenderingPolicy.TargetType;

/**
 * メニュー項目情報を保持するためのコンポーネントです。<br />
 * 
 * @author bskuroneko
 * @author y-komori
 */
public class MenuItemComponent extends AbstractItemComponent {
    /**
     * プッシュボタンスタイルを表す文字列です。<br />
     */
    public static final String PUSH = "PUSH";

    /**
     * ラジオボタンスタイルを表す文字列です。<br />
     */
    public static final String RADIO = "RADIO";

    /**
     * チェックボックススタイルを表す文字列です。<br />
     */
    public static final String CHECK = "CHECK";

    /**
     * アクセラレータです。
     */
    @RenderingPolicy(targetType = TargetType.NONE)
    public String accelerator;

    /**
     * イネーブル状態です。
     */
    @RenderingPolicy(targetType = TargetType.NONE)
    public String enabled;

    /**
     * 選択状態です。
     */
    @RenderingPolicy(targetType = TargetType.NONE)
    public String selection;

    /**
     * 選択不可時のイメージパスです。
     */
    @RenderingPolicy(targetType = TargetType.NONE)
    public String disabledImage;

    /**
     * 選択時のイメージパスです。
     */
    @RenderingPolicy(targetType = TargetType.NONE)
    public String hoverImage;

    /**
     * 説明テキストです。
     */
    @RenderingPolicy(targetType = TargetType.NONE)
    public String description;
}
