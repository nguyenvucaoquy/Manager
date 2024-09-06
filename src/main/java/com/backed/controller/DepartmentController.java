package com.backed.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backed.dto.DepartmentDTO;
import com.backed.entity.Department;
import com.backed.form.DepartmentForm;
import com.backed.service.IDerpartmentService;
import com.backed.update.DepartmentUpdate;

@RestController
@RequestMapping(value = "api/backend/department")
@CrossOrigin("*")
public class DepartmentController {
	@Autowired
	private IDerpartmentService derpartmentService;

	// GetAllDepartment
	@GetMapping
	public ResponseEntity<?> getAllDepartment() {
		List<Department> listDepartment = derpartmentService.getAllDepartment();

		List<DepartmentDTO> listDepartmentDTOs = new ArrayList<DepartmentDTO>();

		for (Department department : listDepartment) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			departmentDTO.setName(department.getDep_Name());
			departmentDTO.setIdShort(department.getDep_ID());
			listDepartmentDTOs.add(departmentDTO);
		}

		return new ResponseEntity<>(listDepartmentDTOs, HttpStatus.OK);
	}

	// Get Department by ID
	@GetMapping(value = "/{IdDepartment}")
	public ResponseEntity<?> getAllDepartmentByID(@PathVariable(name = "IdDepartment") short id) {
		Department department = derpartmentService.getAllDepartmentByID(id);
		return new ResponseEntity<>(department, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> CreateDepartment(@RequestBody DepartmentForm departmentForm) {

		Department department = derpartmentService.CreateDepartment(departmentForm);

		return new ResponseEntity<>(department, HttpStatus.OK);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> PutDepartment(@PathVariable(name = "id") short id,
			@RequestBody DepartmentUpdate departmentUpdate) {
		Department department = derpartmentService.PutDepartment(id, departmentUpdate);

		return new ResponseEntity<>(department, HttpStatus.OK);
	}
}
