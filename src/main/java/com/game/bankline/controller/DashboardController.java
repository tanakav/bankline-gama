package com.game.bankline.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.game.bankline.dto.DashboardDto;
import com.game.bankline.service.DashboardService;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
	
	@Autowired
	private DashboardService dashboardService;
	
	@GetMapping
	public ResponseEntity<DashboardDto> getDashboard(
			@RequestParam(required=true) String numeroDaConta,
			@RequestParam(required=true) Date dataInicial,
			@RequestParam(required=true) Date dataFinal) {
		DashboardDto responseData = new DashboardDto();
		
		responseData = dashboardService.getLancamentosDaConta(numeroDaConta, dataInicial, dataFinal);
		
		return ResponseEntity.ok().body(responseData);
	}

}
