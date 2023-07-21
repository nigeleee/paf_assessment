package vttp2023.batch3.assessment.paf.bookings.models;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Listings {

    @NotNull
    private String country;

    
    private Integer accommodates;
    private Integer price;
}
