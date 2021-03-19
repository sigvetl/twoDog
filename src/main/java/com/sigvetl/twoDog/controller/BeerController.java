package com.sigvetl.twoDog.controller;

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
//        System.out.println(beerForm.getBeerId());
//        System.out.println(beerForm.getName());
//        System.out.println(beerForm.getType());

        //Update homecontroller
        HomeController.updateHome(auth, model, this.beerService, this.batchService, this.userService);

//        List<Beer> beerList = beerService.getBeers();
//        for (Beer b : beerList){
//            System.out.println(b.getBeerId());
//            System.out.println(b.getName());
//            System.out.println(b.getType());
//        }

        return "home";
    }

    @GetMapping("/beers/delete/{beerid}")
    public String deleteBeer(@PathVariable("beerid") Integer beerId, Authentication auth, BeerForm beerForm, BatchForm batchForm, Model model){
        this.beerService.deleteBeer(beerId);

        HomeController.updateHome(auth, model, this.beerService, this.batchService, this.userService);

        return "home";
    }

}
