package com.bday.portal.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.bday.portal.model.Bday;
import com.bday.portal.repository.BdayRepository;
import com.bday.portal.service.BdayService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("")
public class EmployeeController {
	@Autowired
	private BdayService bdayService;

	@GetMapping("/bdays")
	public List<Bday> getAllEmployees() {
		return bdayService.getAllEmployees();
	}

	@GetMapping("/bdays/{xyz}")
	public List<Bday> search(@PathVariable String xyz){
		return bdayService.getBdaySearch(xyz);
		
	}

	@PostMapping("/bdays")
	public Bday addBday(@Valid @RequestBody Bday bday) {
		return bdayService.addEmployee(bday);
	}

	@DeleteMapping("/bdays/{eid}")
	public String deleteBdayById(@PathVariable Long eid) {
		return bdayService.delete(eid);
	}
}
