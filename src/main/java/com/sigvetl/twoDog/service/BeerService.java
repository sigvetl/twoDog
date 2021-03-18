package com.sigvetl.twoDog.service;

import com.sigvetl.twoDog.mapper.BeerMapper;
import com.sigvetl.twoDog.model.Beer;
import com.sigvetl.twoDog.model.BeerForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeerService {

    @Autowired
    private BeerMapper beerMapper;

    @Autowired
    private UserService userService;

    private Integer userId = null;

    public void createBeer(BeerForm beerForm){
        Beer beer = new Beer();
        beer.setIbu(beerForm.getIbu());
        beer.setName(beerForm.getName());
        beer.setType(beerForm.getType());
        beer.setRecipeLink(beerForm.getRecipeLink());
        beer.setUserId(this.userId);

        this.beerMapper.insertBeer(beer);
    }

    public void updateBeer(BeerForm beerForm){
        Beer beer = new Beer();
        beer.setIbu(beerForm.getIbu());
        beer.setName(beerForm.getName());
        beer.setType(beerForm.getType());
        beer.setRecipeLink(beerForm.getRecipeLink());
        beer.setUserId(this.userId);

        this.beerMapper.updateBeer(beer);
    }

    public void deleteBeer(Integer beerId){
        this.beerMapper.deleteBeer(beerId);
    }

    public List<Beer> getBeers(){
        return this.beerMapper.getAllBeers();
    }

    public boolean beerExists(BeerForm beerForm){
        Beer beer = new Beer();
        beer.setBeerId(beerForm.getBeerId());
        boolean exists = this.beerMapper.getBeer(beer) != null;
        return exists;
    }

    public void trackLoggedInUseId(String username){
        this.userId = userService.getUser(username).getUserId();
    }
}
