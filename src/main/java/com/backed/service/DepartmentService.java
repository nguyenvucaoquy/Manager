package com.backed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backed.entity.Department;
import com.backed.form.DepartmentForm;
import com.backed.responsitory.DerpartmentResponsitory;
import com.backed.update.DepartmentUpdate;

@Service
public class DepartmentService implements IDerpartmentService {
	@Autowired
	private DerpartmentResponsitory derpartmentResponsitory;

	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		List<Department> listDepartments = derpartmentResponsitory.findAll();
		return listDepartments;
	}

	@Override
	public Department getAllDepartmentByID(short id) {
		Department department = derpartmentResponsitory.findById(id).get();
		return department;
	}

	@Override
	public Department CreateDepartment(DepartmentForm departmentForm) {
		Department department = new Department();
		department.setDep_Name(departmentForm.getName());
		Department departmentcreated = derpartmentResponsitory.save(department);
		return departmentcreated;
	}

	@Override
	public Department PutDepartment(short id, DepartmentUpdate departmentUpdate) {
		Department department = new Department();
		derpartmentResponsitory.findById(id).get();
		department.setDep_Name(departmentUpdate.getName());
		department.setDep_ID(departmentUpdate.getiD());
		Department departmentUpdated = derpartmentResponsitory.save(department);
		return departmentUpdated;
	}

}
