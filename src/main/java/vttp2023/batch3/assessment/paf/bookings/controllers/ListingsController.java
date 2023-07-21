package vttp2023.batch3.assessment.paf.bookings.controllers;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp2023.batch3.assessment.paf.bookings.models.ListingDetails;
import vttp2023.batch3.assessment.paf.bookings.models.ListingPage;
import vttp2023.batch3.assessment.paf.bookings.models.Listings;
import vttp2023.batch3.assessment.paf.bookings.services.ListingsService;

@Controller
@RequestMapping
public class ListingsController {

	@Autowired
	private ListingsService service;
	//TODO: Task 2

	@GetMapping()
	public String searchPage(Model model) {

		model.addAttribute("list", new Listings());
		return "view1";	
	}

	@GetMapping("/search")
	public String resultPage(@RequestParam String country, @RequestParam int accommodates, @RequestParam double price, Model model) {

		List<Document> getListings = service.getAccomResult(country, accommodates, price);
		List<ListingPage> accomList = new ArrayList<>();
		for (Document doc : getListings) {
			ListingPage list = service.docToResults(doc);

			accomList.add(list);
		}

		if(accomList.isEmpty()) {
			return "error";

		} else {
			model.addAttribute("listings", accomList);
			return "view2";
	}

	}

		@GetMapping("details") 
		public String accomDetails(@PathVariable String id, @RequestParam String country, @RequestParam int accommodates, @RequestParam double price, Model model) {
			if(service.checkIfIdExists(id) == null){
				return "view 2";
			} else {
				List<Document> getDetails = service.getAccomDetails(id, accommodates, price);
				List<ListingDetails> details = new ArrayList<>();
				for (Document doc : getDetails) {
				ListingDetails list = service.docToDetails(doc);

				details.add(list);
		}


		
			model.addAttribute("details", details);
			return "view2";
		
			}

			
		}
	}		
	



