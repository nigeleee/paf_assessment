package vttp2023.batch3.assessment.paf.bookings.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ListingDetails {
    private String _id;
    private String description;
    private String address;
    private String picture_url;
    private double price;
    private String amenities;
}
