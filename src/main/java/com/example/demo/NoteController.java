package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoteController {

	@Autowired
	private NoteRepository noteRepository;
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("notes", noteRepository.findAll());
		modelAndView.addObject("note",new Note());
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@PostMapping("/notes")
	public String saveNote(@ModelAttribute Note note) {
		noteRepository.save(note);
		return "redirect:/index";
	}
}
