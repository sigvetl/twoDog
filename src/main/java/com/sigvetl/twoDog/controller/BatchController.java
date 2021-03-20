package com.sigvetl.twoDog.controller;

import com.sigvetl.twoDog.model.BatchForm;
import com.sigvetl.twoDog.model.BeerForm;
import com.sigvetl.twoDog.service.BatchService;
import com.sigvetl.twoDog.service.BeerService;
import com.sigvetl.twoDog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class BatchController {
    @Autowired
    BatchService batchService;

    @Autowired
    UserService userService;

    @Autowired
    BeerService beerService;

    @PostMapping("/batches")
    public String addUpdateBatch(Authentication auth, BatchForm batchForm, BeerForm beerForm, Model model){
//        LocalDate brewDate = processDate(batchForm);
//        batchForm.setBrewDate(brewDate);
        System.out.println("controller " + batchForm.getBrewDate());
        if (this.batchService.batchExists(batchForm)){
            this.batchService.updateBatch(batchForm);
        } else{
            this.batchService.trackLoggedInUserId(auth.getName());
            this.batchService.createBatch(batchForm);
        }

        //Update homecontroller
        HomeController.updateHome(auth, model, beerService, batchService, userService);

        return "home";
    }

    @GetMapping("/batch/delete/{batchid}")
    public String deleteBatch(@PathVariable("batchid") Integer batchId, Authentication auth, BeerForm beerForm, BatchForm batchForm, Model model){
        this.batchService.deleteBatch(batchId);

        HomeController.updateHome(auth, model, this.beerService, this.batchService, this.userService);

        return "home";
    }

//    public LocalDate processDate(BatchForm batchForm){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
//        LocalDate brewDate = LocalDate.parse(batchForm.getBrewDate(), formatter);
//        return brewDate;
//    }
}
