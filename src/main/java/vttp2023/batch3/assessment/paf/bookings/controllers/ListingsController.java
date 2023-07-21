package vttp2023.batch3.assessment.paf.bookings.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp2023.batch3.assessment.paf.bookings.models.Listings;
import vttp2023.batch3.assessment.paf.bookings.services.ListingsService;

@Controller
@RequestMapping
public class ListingsController {

	@Autowired
	private ListingsService service;
	//TODO: Task 2
	
	@GetMapping
	public String findAccoms(Model model) {

		model.addAttribute("listings", new Listings());
		return "view1";
	}
	
	//TODO: Task 3


	//TODO: Task 4
	

	//TODO: Task 5


}
