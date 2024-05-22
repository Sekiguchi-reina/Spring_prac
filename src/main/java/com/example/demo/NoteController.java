package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

	@Autowired
	private NoteRepository noteRepository;
	
	@PostMapping("/notes")
	public ResponseEntity<String> saveNote(@RequestBody Note note){
		try {
			noteRepository.save(note);
			return ResponseEntity.ok("Note saved successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save note:" + e.getMessage());
		}
	}
}
