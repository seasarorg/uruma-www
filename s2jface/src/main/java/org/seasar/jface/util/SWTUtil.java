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
package org.seasar.jface.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

/**
 * @author y-komori
 * 
 */
public class SWTUtil {
    protected static Map<String, Integer> constants = new HashMap<String, Integer>();

    protected static Map<String, Color> colors = new HashMap<String, Color>();

    static {
        Field[] fields = SWT.class.getFields();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())
                    && (field.getType() == Integer.TYPE)) {
                try {
                    String name = field.getName();
                    constants.put(name, field.getInt(null));

                    if (name.startsWith("COLOR_")) {
                        String colorName = name.substring(6);
                        Color color = Display.getCurrent().getSystemColor(
                                getSWTConstant(name));
                        colors.put(colorName, color);
                        // TODO Color�I�u�W�F�N�g��dispose����
                    }
                } catch (Exception ignore) {
                }
            }
        }
    }

    static {
        Field[] fields = SWT.class.getFields();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())
                    && (field.getType() == Integer.TYPE)) {
                try {
                    constants.put(field.getName(), field.getInt(null));
                } catch (Exception ignore) {
                }
            }
        }
    }

    /**
     * <code>SWT</code>�N���X�̎��萔��Ԃ��܂��B<br>
     * 
     * @param name
     *            �萔��
     * @return �l�B���݂��Ȃ��萔�����w�肳�ꂽ�ꍇ�A<code>SWT.NONE</code>��Ԃ��܂��B
     */
    public static int getSWTConstant(String name) {
        int constant = SWT.NONE;
        Integer constantObj = constants.get(name);
        if (constantObj != null) {
            constant = constantObj.intValue();
        }
        return constant;
    }

    /**
     * �J���}��؂�̒萔����SWT�̃X�^�C�����v�Z���܂��B<br>
     * �Ⴆ�Έȉ��̂悤�ȓ��͂ɑ΂��āA�{���\�b�h��
     * <code>SWT.HORIZONTAL | SWT.SHADOW_IN | SWT.CENTER</code>�̌v�Z���ʂ�
     * �߂�l�Ƃ��ĕԂ��܂��B<br>
     * <code>SWT</code>�N���X�ɒ�`����Ă��Ȃ��萔���w�肳�ꂽ�ꍇ�A��������܂��B
     * 
     * ���͗�:<code>"HORIZONTAL, SHADOW_IN, CENTER"</code><br>
     * 
     * @param styles
     *            �J���}��؂�̒萔�B
     * @param defaultStyle
     *            <code>styles</code> �� <code>null</code> �������ꍇ�ɕԂ��f�t�H���g�l�B
     * @return �X�^�C���l�B ������ <code>null</code> �̏ꍇ�� <code>defalutStyle</code>
     *         ��Ԃ��܂��B
     */
    public static int getStyle(String styles, int defaultStyle) {
        int result = defaultStyle;
        if (styles != null) {
            StringTokenizer st = new StringTokenizer(styles, ",");
            while (st.hasMoreTokens()) {
                String style = st.nextToken().trim();
                Integer constant = getSWTConstant(style);
                if (constant != null) {
                    result |= constant.intValue();
                }
            }
        }
        return result;
    }

    /**
     * �J���}��؂�̒萔����SWT�̃X�^�C�����v�Z���܂��B<br>
     * �Ⴆ�Έȉ��̂悤�ȓ��͂ɑ΂��āA�{���\�b�h��
     * <code>SWT.HORIZONTAL | SWT.SHADOW_IN | SWT.CENTER</code>�̌v�Z���ʂ�
     * �߂�l�Ƃ��ĕԂ��܂��B<br>
     * <code>SWT</code>�N���X�ɒ�`����Ă��Ȃ��萔���w�肳�ꂽ�ꍇ�A��������܂��B
     * 
     * ���͗�:<code>"HORIZONTAL, SHADOW_IN, CENTER"</code><br>
     * 
     * @param styles
     *            �J���}��؂�̒萔�B
     * @return �X�^�C���l�B ������ <code>null</code> �̏ꍇ�� <code>SWT.NONE</code>
     *         ��Ԃ��܂��B
     */
    public static int getStyle(String styles) {
        return getStyle(styles, SWT.NONE);
    }

    /**
     * <code>Color</code>�I�u�W�F�N�g�𐶐����܂��B<br>
     * <code>colorString</code> �Ŏw�肳�ꂽ�����񂩂� <code>Color</code> �I�u�W�F�N�g�𐶐����܂��B<br>
     * <code>colorString</code> �� #RGB �`���܂��� <code>red</code>�A<code>blue</code>
     * �� <code>SWT</code>�N���X�� <code>COLOR_*</code>
     * �萔�ŗp�ӂ��ꂽ�����񂪎w��ł��܂�(��������A�啶���E�������ǂ�����g�p�\)�B<br>
     * ��: <code>#FF0000</code> ���w�肵���ꍇ�A�Ԃ�\���܂��B
     * 
     * @param colorString
     *            �F��\��������B
     * @return <code>Color</code> �I�u�W�F�N�g
     */
    public static Color getColor(String colorString) {
        Color color = null;
        if ((colorString.startsWith("#")) && (colorString.length() == 7)) {
            int red = Integer.parseInt(colorString.substring(1, 3), 16);
            int green = Integer.parseInt(colorString.substring(3, 5), 16);
            int blue = Integer.parseInt(colorString.substring(5, 7), 16);
            color = new Color(Display.getCurrent(), red, green, blue);
        } else {
            color = colors.get(colorString.toUpperCase());
        }
        return color;
    }
}
