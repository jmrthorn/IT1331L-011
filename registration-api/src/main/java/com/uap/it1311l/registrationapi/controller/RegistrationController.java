package com.uap.it1311l.registrationapi.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.uap.it1311l.registrationapi.model.Attendee;
import com.uap.it1311l.registrationapi.repository.RegistrationMybatisRepository;

@RestController
public class RegistrationController {
	@Autowired
	RegistrationMybatisRepository registrationRepo;
	
	@PostMapping("/event/register")
	public Attendee register(@RequestBody Attendee student) {
		registrationRepo.insert(student);
		return student;
	}
	
	@GetMapping("/attendees")
	public List<Attendee> getList() {
		return registrationRepo.findAll();
	}
}
