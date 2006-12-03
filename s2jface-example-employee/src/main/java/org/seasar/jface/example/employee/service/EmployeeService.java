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
package org.seasar.jface.example.employee.service;

import java.util.List;

import org.seasar.jface.example.employee.dto.DepartmentDto;
import org.seasar.jface.example.employee.dto.EmployeeDto;
import org.seasar.jface.example.employee.dto.EmployeeSearchDto;

/**
 * @author bskuroneko
 */
public interface EmployeeService {

    void delete(EmployeeDto dto);

    EmployeeDto insert(EmployeeDto dto);

    EmployeeDto update(EmployeeDto dto);

    List<DepartmentDto> getAllDepartments();

    List<EmployeeDto> searchEmployeeDtoList(EmployeeSearchDto dto);

}
