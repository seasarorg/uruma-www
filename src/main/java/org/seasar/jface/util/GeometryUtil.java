package org.seasar.jface.util;

/**
 * @author y-komori
 * 
 */
public class GeometryUtil {
    /**
     * <code>value</code>�̕\�����l�܂��͊��������Ɏ��ۂ̒l���v�Z���܂��B<br>
     * <ul>
     * <li><code>value</code>�����l�݂̂���Ȃ�ꍇ�A���̂܂�int�l�ɕϊ������l��Ԃ��܂��B<br>
     * <li><code>value</code>��%�ŏI��鐔�l��\���ꍇ�A<code>parentSize</code>�ɑ΂���<code>value</code>�̊�����Ԃ��܂��B
     * </ul>
     * 
     * @param value
     *            �v�Z�Ώ�
     * @param parentSize
     *            �e�T�C�Y
     * @return �v�Z����
     * @throws NumberFormatException
     */
    public static int calcSize(final String value, final int parentSize) {
        int result;
        if (value.endsWith("%")) {
            int percent = Integer.parseInt(value.substring(0,
                    value.length() - 1));
            result = parentSize * percent / 100;
        } else {
            result = Integer.parseInt(value);
        }
        return result;
    }

    /**
     * <code>value</code>�����Ɏ��ۂ̈ʒu���v�Z���܂��B<br>
     * <ul>
     * <li><code>value</code>�����l�݂̂���Ȃ�ꍇ�A���̂܂�int�l�ɕϊ������l��Ԃ��܂��B<br>
     * <li><code>value</code>��%�ŏI��鐔�l��\���ꍇ�A<code>parentSize</code>�ɑ΂���<code>value</code>�̊�����Ԃ��܂��B
     * <li><code>value</code>�� top �܂��� left �̏ꍇ�A0��Ԃ��܂��B
     * <li><code>value</code>�� center �܂��� middle �̏ꍇ�A(<code>parentSize</code> -
     * <code>targetSize</code>) / 2 ��Ԃ��܂��B
     * <li><code>value</code>�� bottom �܂��� right �̏ꍇ�A(<code>parentSize</code> -
     * <code>targetSize</code> ��Ԃ��܂��B
     * </ul>
     * 
     * @param value
     *            �v�Z�Ώ�
     * @param parentSize
     *            �eBox�T�C�Y
     * @param targetSize
     *            ��Box�T�C�Y
     * @return �v�Z����
     * @throws NumberFormatException
     */
    public static int calcPosition(final String value, final int parentSize,
            final int targetSize) {
        int position = 0;
        if ("top".equalsIgnoreCase(value) || "left".equalsIgnoreCase(value)) {
            position = 0;
        } else if ("center".equalsIgnoreCase(value)
                || "middle".equalsIgnoreCase(value)) {
            position = (parentSize - targetSize) / 2;
        } else if ("bottom".equalsIgnoreCase(value)
                || "right".equalsIgnoreCase(value)) {
            position = parentSize - targetSize;
        } else {
            position = calcSize(value, parentSize);
        }
        position = (position >= 0) ? position : 0;
        return position;
    }

}
