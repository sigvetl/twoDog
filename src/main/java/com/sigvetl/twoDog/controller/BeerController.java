package com.sigvetl.twoDog.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sigvetl.twoDog.model.BatchForm;
import com.sigvetl.twoDog.model.Beer;
import com.sigvetl.twoDog.model.BeerForm;
import com.sigvetl.twoDog.service.BatchService;
import com.sigvetl.twoDog.service.BeerService;
import com.sigvetl.twoDog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

import java.net.ConnectException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Controller
public class BeerController {

    @Autowired
    private UserService userService;

    @Autowired
    private BeerService beerService;

    @Autowired
    private BatchService batchService;

    @PostMapping("/beers")
    public String addUpdateBeers(Authentication auth, BeerForm beerForm, BatchForm batchForm, Model model){
        if (this.beerService.beerExists(beerForm)){
            this.beerService.updateBeer(beerForm);
        } else{
            this.beerService.trackLoggedInUserId(auth.getName());
            this.beerService.createBeer(beerForm);
        }

        //Update homecontroller
        HomeController.updateHome(auth, model, this.beerService, this.batchService, this.userService);

        return "home";
    }

    @GetMapping("api/beers")
        public String addUpdateBeersFromApi(Authentication auth, BeerForm beerForm, BatchForm batchForm, Model model) throws IOException {

        try{
            URL url = new URL("http://127.0.0.1:5000/api/beers");

            ObjectMapper mapper = new ObjectMapper();
            List<Beer> beers = Arrays.asList(mapper.readValue(url, Beer[].class));

            //Not a valid solution
            try{
                Thread.sleep(5000);
            } catch(InterruptedException interruptedException){
                System.out.println("interrupedException");
            }


            for (Beer beer : beers){
                Integer beerId = this.beerService.beerNameExists(beer);
                if (beerId != 0){
                    beer.setBeerId(beerId);
                    this.beerService.updateFromApi(beer);
                } else{
                    this.beerService.trackLoggedInUserId(auth.getName());
                    this.beerService.createFromApi(beer);
                }
                System.out.println("beer: " +  beer.getName());
                System.out.println("ibu: " +  beer.getIbu());
                System.out.println("recipe link: " +  beer.getRecipeLink());
                System.out.println("picture link: " +  beer.getPictureLink());
                System.out.println("abv: " +  beer.getAbv());
                System.out.println("ebc: " +  beer.getEbc());
            }
        } catch(ConnectException connectException){
            System.out.println("api is not live");
        }

            HomeController.updateHome(auth, model, this.beerService, this.batchService, this.userService);
            return "home";
        }

    @GetMapping("/beers/delete/{beerid}")
    public String deleteBeer(@PathVariable("beerid") Integer beerId, Authentication auth, BeerForm beerForm, BatchForm batchForm, Model model){
        this.beerService.deleteBeer(beerId);

        HomeController.updateHome(auth, model, this.beerService, this.batchService, this.userService);

        return "home";
    }

}
