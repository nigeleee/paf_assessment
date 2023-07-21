package vttp2023.batch3.assessment.paf.bookings.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListingPage {

    private String name;

    @NotNull(message = "Field cannot be empty")
    private String country;

    @NotNull(message = "Field cannot be empty")
    @Min(value = 1, message = "Cannot be less than 1")
    @Max(value = 10, message = "Cannot be more than 10")
    private Integer accommodates;

    @NotNull(message = "Field cannot be empty")
    @Min(value = 1, message = "Cannot be less than 1")
    @Max(value = 10000, message = "Cannot be more than 10")
    private Double price;

    private String picture_url;
}
