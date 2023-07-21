package vttp2023.batch3.assessment.paf.bookings.services;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2023.batch3.assessment.paf.bookings.models.ListingDetails;
import vttp2023.batch3.assessment.paf.bookings.models.ListingPage;
import vttp2023.batch3.assessment.paf.bookings.models.Listings;
import vttp2023.batch3.assessment.paf.bookings.repositories.ListingsRepository;

@Service
public class ListingsService {
	
	@Autowired
	private ListingsRepository repo;
	//TODO: Task 2
	
	public List<Document> findAccoms(String country, int accommodates, double price) {
		
		return repo.getAccoms(country, accommodates, price);
	
	}

	// public List<Document> getCountry(String country) {
	// 	return repo.getCountry(country);
	// }

	public Listings docToListing(Document d) {
        Document address = d.get("address", Document.class);
        String country = address.getString("country");


        return new Listings(
				country,
                d.getInteger("accommodates"),
                d.getDouble("price")
                );
    }

	//TODO: Task 3
	public List<Document> getAccomResult(String country, int accommodates, double price) {
		return repo.getAccomResult(country, accommodates, price);
	}

	public ListingPage docToResults(Document d) {
        Document address = d.get("address", Document.class);
        String country = address.getString("country");
		Document images = d.get("images", Document.class);
		String url = images.getString("picture_url");

        return new ListingPage(
				d.getString("name"),
				country,
                d.getInteger("accommodates"),
                d.getDouble("price"),
				url
                );
    }
	
	//TODO: Task 4
	public List<Document> getAccomDetails(String country, int accommodates, double price) {
		return repo.getAccomDetails(country, accommodates, price);
	}

	public ListingDetails checkIfIdExists(String _id) {
		return repo.checkIfIdExists(_id);
	}


	public ListingDetails docToDetails(Document d) {
		List<String> amenitiesList = d.getList("amenities", String.class);
		Document images = d.get("images", Document.class);
		String url = images.getString("picture_url");

        return new ListingDetails(
				d.getString("_id"),
				d.getString("description"),
				d.getString("address"),
				url,
                d.getDouble("price"),
				amenitiesList.toString()
                );
    }


	//TODO: Task 5


}
