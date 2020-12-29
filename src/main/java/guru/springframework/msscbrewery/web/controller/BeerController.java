package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.BeerService;
import guru.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
@RequestMapping(BeerController.BASE_URL)
@RestController
public class BeerController {
    public static final String BASE_URL = "/api/v1/beer";

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

//    @GetMapping({"/{beerId}"})
//    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){
//
//        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
//    }

    @GetMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.OK)
    public BeerDto getBeer(@PathVariable("beerId") UUID beerId){

        return beerService.getBeerById(beerId);
    }
}
