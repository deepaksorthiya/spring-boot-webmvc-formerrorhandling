package com.example.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;

@RestController
@RequestMapping("/users")
public class UserController {

	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody @Valid User user) {
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping("{userId}")
	public ResponseEntity<User> getUser(@PathVariable int userId) {
		if (userId == 99) {
			return new ResponseEntity<User>(new User(userId, "dsaa", null), HttpStatus.OK);
		}
		throw new IllegalArgumentException("invalid parameter");
	}

	@GetMapping
	public ResponseEntity<List<User>> getUsers() throws Exception {
		return new ResponseEntity<List<User>>(new ArrayList<>(), HttpStatus.OK);
	}
}
