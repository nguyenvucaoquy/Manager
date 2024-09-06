package com.backed.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backed.entity.Position;

public interface IPositionResponsitory extends JpaRepository<Position, Short> {

}
