package com.example.demo.controller;
import com.example.demo.dto.user.OccupationDto;
import com.example.demo.dto.user.UserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	@Autowired
	UserService service;

	//branch test
	@PostMapping("/register")
	public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
		return service.saveUser(userDto);
	}
	@GetMapping("/occupations")
	public List<OccupationDto> getOccupations(){
		return  service.getOccupations();
	}
}
