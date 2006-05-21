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

import java.io.InputStream;
import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.seasar.jface.exception.ResourceNotFoundException;

/**
 * @author y-komori
 * 
 */
public class ImageManager {
    protected static final ImageManager instance = new ImageManager();

    protected static final ImageRegistry imageRegistry = new ImageRegistry();

    public static ImageManager getInstance() {
        return instance;
    }

    /**
     * �w�肳�ꂽ�L�[�œo�^���ꂽ Image �I�u�W�F�N�g��Ԃ��܂��B<br>
     * 
     * @param key
     *            �L�[
     * @return Image�I�u�W�F�N�g�B������Ȃ��ꍇ��<code>null</code>�B
     */
    public Image getImage(final String key) {
        return imageRegistry.get(key);
    }

    /**
     * <code>url</code>���L�[�Ƃ���Image�I�u�W�F�N�g���������܂��B<br>
     * Image�I�u�W�F�N�g���o�^����Ă��Ȃ��ꍇ�A��������<code>url</code>���L�[�Ƃ��ēo�^���Ă���Ԃ��܂��B
     * 
     * @param url
     *            �C���[�W��URL/�L�[
     * @param display
     *            �C���[�W�������Ɏg�p���� <code>Display</code> �I�u�W�F�N�g
     * @return Image�I�u�W�F�N�g
     */
    public Image getImage(final String url, final Display display) {
        Image image = getImage(url);
        if (image == null) {
            InputStream is = getClass().getResourceAsStream(url);
            if (is != null) {
                image = new Image(display, is);
                imageRegistry.put(url, image);
            } else {
                throw new ResourceNotFoundException(url);
            }
        }
        return image;
    }

    /**
     * ImageRegistry �� Image ��o�^���܂��B<br>
     * 
     * @param display
     *            Image�̐����Ɏg�p����Display�̎Q��
     * @param key
     *            �L�[
     * @param url
     *            �C���[�W��URL
     */
    public void putImage(Display display, String key, String url) {
        Image image = new Image(display, getClass().getResourceAsStream(url));
        imageRegistry.put(key, image);
    }

    /**
     * ResourceBundle ���� Image ��ǂݍ��݁A�ꊇ�o�^���܂��B<br>
     * �ukey=url�v�̌`���ŋL�q���ꂽ�v���p�e�B�t�@�C�������ɂ���ResourceBundle ����Image���ꊇ���ēǂݍ��݂܂��B
     * 
     * @param display
     *            Image�̐����Ɏg�p����Display�̎Q��
     * @param bundle
     *            ���\�[�X�o���h���̎Q��
     * @throws MissingResourceException
     *             ���\�[�X��������Ȃ��ꍇ�ɃX���[���܂��B
     */
    public void putImages(Display display, ResourceBundle bundle) {

        Enumeration keys = bundle.getKeys();
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            String url = bundle.getString(key);
            putImage(display, key, url);
        }
    }
}
