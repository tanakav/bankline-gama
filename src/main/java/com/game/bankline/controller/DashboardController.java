package com.game.bankline.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.bankline.dto.DashboardDto;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
	
	@GetMapping
	public ResponseEntity<DashboardDto> getDashboard() {
		DashboardDto responseData = new DashboardDto();
		
		return ResponseEntity.ok().body(responseData);
	}

}
