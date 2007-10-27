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
package org.seasar.uruma.example.employee.action;

import org.seasar.uruma.annotation.Form;
import org.seasar.uruma.annotation.InitializeMethod;
import org.seasar.uruma.example.employee.dto.DepartmentDto;
import org.seasar.uruma.example.employee.dto.EmployeeDto;
import org.seasar.uruma.example.employee.form.EmployeeEditForm;

/**
 * @author bskuroneko
 * 
 */
@Form(EmployeeEditForm.class)
public class EditAction extends AbstractEditAction {
	@Override
	@InitializeMethod
	public void initialize() {
		employeeEditFormDxo.convert(editEmployee, employeeEditForm);
		super.initialize();
		DepartmentDto selectedDepartment = new DepartmentDto();
		selectedDepartment.setDeptno(employeeEditForm.getDeptno());
		employeeEditForm.setSelectedDepartmentDto(selectedDepartment);
	}

	@Override
	protected EmployeeDto doUpdateOrInsert(final EmployeeDto employeeDto) {
		return employeeLogic.update(employeeDto);
	}
}
