package com.backed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backed.entity.Position;
import com.backed.responsitory.IPositionResponsitory;

@Service
public class PositionService implements IPositionService {
	@Autowired
	private IPositionResponsitory positionResponsitory;

	@Override
	public List<Position> getAllPosition() {
		List<Position> positions = positionResponsitory.findAll();
		return positions;
	}

}
