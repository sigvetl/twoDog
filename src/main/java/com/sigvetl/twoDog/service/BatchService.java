package com.sigvetl.twoDog.service;

import com.sigvetl.twoDog.mapper.BatchMapper;
import com.sigvetl.twoDog.model.Batch;
import com.sigvetl.twoDog.model.BatchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchService {

    @Autowired
    private BatchMapper batchMapper;

    @Autowired
    private UserService userService;

    private Integer userId = null;

    public void createBatch(BatchForm batchForm){
        Batch batch = new Batch();
        batch.setVolume(batchForm.getVolume());
        batch.setBrewDate(batchForm.getBrewDate());
        batch.setOg(batchForm.getOg());
        //batch.set(batchForm.getRecipeLink());
        batch.setUserId(this.userId);

        this.batchMapper.insertBatch(batch);
    }

    public void updateBatch(BatchForm batchForm){
        Batch batch = new Batch();
        batch.setBatchId(batchForm.getBatchId());
        batch.setVolume(batchForm.getVolume());
        batch.setBrewDate(batchForm.getBrewDate());
        batch.setOg(batchForm.getOg());
        //batch.set(batchForm.getRecipeLink());
        batch.setUserId(this.userId);

        this.batchMapper.updateBatch(batch);
    }

    public void deleteBatch(Integer batchId){
        this.batchMapper.deleteBatch(batchId);
    }

    public List<Batch> getBatches(){
        return this.batchMapper.getAllBatches();
    }

    public boolean batchExists(BatchForm batchForm){
        Batch batch = new Batch();
        batch.setBatchId(batchForm.getBatchId());
        boolean exists = this.batchMapper.getBatch(batch) != null;
        return exists;
    }

    public void trackLoggedInUserId(String username){
        this.userId = userService.getUser(username).getUserId();
    }
}
