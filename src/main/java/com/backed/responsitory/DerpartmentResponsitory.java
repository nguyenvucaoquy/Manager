package com.backed.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backed.entity.Department;

public interface DerpartmentResponsitory extends JpaRepository<Department, Short> {

}
