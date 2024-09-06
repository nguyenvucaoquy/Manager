package com.backed.service;

import java.util.List;

import com.backed.entity.Department;
import com.backed.form.DepartmentForm;
import com.backed.update.DepartmentUpdate;

public interface IDerpartmentService {

	List<Department> getAllDepartment();

	Department getAllDepartmentByID(short id);

	Department CreateDepartment(DepartmentForm departmentForm);

	Department PutDepartment(short id, DepartmentUpdate departmentUpdate);

}
