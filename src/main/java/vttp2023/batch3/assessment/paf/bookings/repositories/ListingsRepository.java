package vttp2023.batch3.assessment.paf.bookings.repositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ListingsRepository {

	//TODO: Task 2
	// db.listings.find({
	// 	"accommodation": { $gte: 0, $lte: 10 },
	// 	"price": { $gte: 1, $lte: 10000 },
	// 	"country": { $ne: "" }
	//   })
@Autowired
private MongoTemplate template;

private final String L_ACC = "accommodates";
private final String L_PRICE = "price";
private final String L_CTY = "country";
private final String L_LIST = "listings";

public List<Document> getAccoms(String country, int accommodates, int price) {
	Criteria c = Criteria.where(L_CTY).is(country).and(L_ACC).is(accommodates).and(L_PRICE).is(price);

	Query query = Query.query(c);

	return template.find(query, Document.class, L_LIST);
}

// public Listings getCountry(String country) {
// 	Criteria c = Criteria.where(L_CTY).is(country);
// 	Query query = Query.query(c);

// 	return template.findOne(query, Listings.class, L_LIST);

// }





	  
	
	//TODO: Task 3


	//TODO: Task 4
	

	//TODO: Task 5


}
