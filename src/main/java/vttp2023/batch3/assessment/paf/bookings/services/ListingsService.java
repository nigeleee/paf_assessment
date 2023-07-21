package vttp2023.batch3.assessment.paf.bookings.services;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2023.batch3.assessment.paf.bookings.repositories.ListingsRepository;

@Service
public class ListingsService {
	
	@Autowired
	private ListingsRepository repo;
	//TODO: Task 2
	
	public List<Document> findAccoms(String country, int accommodates, int price) {
		
		return repo.getAccoms(country, accommodates, price);
	
	}
	
	//TODO: Task 3


	//TODO: Task 4
	

	//TODO: Task 5


}
