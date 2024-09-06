package com.backed.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backed.entity.Position;
import com.backed.service.IPositionService;

@RestController
@RequestMapping(value = "api/backend/position")
@CrossOrigin("*")
public class PositionController {
	@Autowired
	private IPositionService positionService;

	@GetMapping
	public ResponseEntity<?> getAllPosition() {
		List<Position> positions = new ArrayList<>();
		positions = positionService.getAllPosition();
		return new ResponseEntity<>(positions, HttpStatus.OK);
	}
}
