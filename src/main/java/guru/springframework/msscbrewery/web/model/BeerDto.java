package guru.springframework.msscbrewery.web.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
@Data
@NoArgsConstructor
public class BeerDto extends BaseDto {

    private String beerName;
    private String beerStyle;
    private Long upc;

    @Builder
    public BeerDto(UUID id, UUID id1, String beerName, String beerStyle, Long upc) {
        super(id);
        this.beerName = beerName;
        this.beerStyle = beerStyle;
        this.upc = upc;
    }
}
