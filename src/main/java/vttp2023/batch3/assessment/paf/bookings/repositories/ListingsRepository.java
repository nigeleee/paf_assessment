package vttp2023.batch3.assessment.paf.bookings.repositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public class ListingsRepository {

	//TODO: Task 2

@Autowired
private MongoTemplate template;


/* db.listings.find({$and : [
		{country : {$ne : ""}},  
		{accommodates: { $gte: 0, $lte: 10 }},
		{price : { $gte: 1, $lte: 10000 }}
	  ]}) */

  
public List<Document> getAccoms(String country, int accommodates, double price) {
	Criteria c = new Criteria()
					.and("country").ne("")
        			.and("accommodates").gte(0).lte(10)
        			.and("price").gte(1).lte(10000);

	Query query = Query.query(c).limit(10).with(Sort.by(Sort.Direction.DESC,"price"));

	return template.find(query, Document.class, "listings");
} 

/*
db.listings.find({$and : [
    { country : { $ne : "" } },
    { accommodates: { $gte : 0, $lte : 10 } },
    { price: { $gte : 1, $lte : 10000 } }
  ]
}).projection({
  "address.country" : 1,  
  name : 1,
  price : 1,
  "images.picture_url" : 1
})
 */	
//TODO: Task 3
public List<Document> getAccomResult(String country, int accommodates, double price) {
	Criteria c = new Criteria()
					.and("country").ne("")
        			.and("accommodates").gte(0).lte(10)
        			.and("price").gte(1).lte(10000);


	
	Query query = Query.query(c).limit(10).with(Sort.by(Sort.Direction.DESC,"price"));
	query.fields().include("address.country", "name", "price", "images.picture_url");


	return template.find(query, Document.class, "listings");
} 

	//TODO: Task 4

	public List <Document> getCountry(String country) {
	Criteria c = Criteria.where("country").is(country);

	Query query = Query.query(c);

	return template.find(query, Document.class, "listings");

	}
	

	//TODO: Task 5


}
