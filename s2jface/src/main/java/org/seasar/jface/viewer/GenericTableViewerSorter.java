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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

/**
 * {@link TableViewer} 用の汎用ソートクラスです。<br />
 * 
 * @author y-komori
 */
public class GenericTableViewerSorter extends ViewerSorter {
    private Table table;

    private Map<TableColumn, Integer> columnMap = new HashMap<TableColumn, Integer>();

    private TableColumn sortKey;

    private boolean order = true;

    public GenericTableViewerSorter(final TableViewer viewer) {
        this.table = viewer.getTable();
        TableColumn[] columns = table.getColumns();
        if (columns.length == 0) {
            return;
        }
        
        for (int i = 0; i < columns.length; i++) {
            columnMap.put(columns[i], i);

            columns[i].addSelectionListener(new SelectionListener() {
                public void widgetDefaultSelected(SelectionEvent e) {
                }

                public void widgetSelected(SelectionEvent e) {
                    setSortKey((TableColumn) e.widget);
                    viewer.setInput(viewer.getInput());
                }
            });
        }

        sortKey = columns[0];
    }

    @Override
    public int compare(Viewer viewer, Object e1, Object e2) {
        TableViewer tableViewer = (TableViewer) viewer;
        IBaseLabelProvider baseLabelProvider = tableViewer.getLabelProvider();

        String value1 = "";
        String value2 = "";
        if (baseLabelProvider instanceof ITableLabelProvider) {
            ITableLabelProvider prov = (ITableLabelProvider) baseLabelProvider;
            int column = columnMap.get(sortKey);
            value1 = prov.getColumnText(e1, column);
            value2 = prov.getColumnText(e2, column);
        } else {
            value1 = e1.toString();
            value2 = e2.toString();
        }

        if (value1 == null) {
            value1 = "";
        }
        if (value2 == null) {
            value2 = "";
        }
        int result = collator.compare(value1.toString(), value2.toString());
        return order ? result : result * (-1);
    }

    /**
     * ソートキーとなるカラムを設定します。<br />
     * ソート順は呼び出すたびに反転します。
     * 
     * @param tableColumn
     *            ソートキーとなる {@link TableColumn} オブジェクト
     */
    public void setSortKey(final TableColumn tableColumn) {
        if (tableColumn != null) {
            sortKey = tableColumn;
            order = order ? false : true;

            table.setSortColumn(sortKey);
            table.setSortDirection(order ? SWT.UP : SWT.DOWN);
        }
    }
}
