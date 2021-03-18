package com.sigvetl.twoDog.mapper;

import com.sigvetl.twoDog.model.Batch;
import com.sigvetl.twoDog.model.Beer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BatchMapper {
    @Select("SELECT * FROM BATCH")
    List<Batch> getAllBatches();

    @Select("SELECT * FROM BATCH WHERE batchid=#{batchId}")
    Integer getBatch(Batch batch);

    @Insert("INSERT INTO BATCH(VOLUME, BREWDATE, OG, RECIPELINK, USERID) " +
            "VALUES(#{name}, #{type}, #{ibu}, #{recipeLink}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "batchId")
    void insertBatch(Batch batch);

    @Update("UPDATE BATCH SET NAME = #{name}, TYPE = #{type}, IBU = #{ibu}, " +
            "RECIPELINK = #{recipeLink}, USERID = #{userId} WHERE BATCHID = #{batchId}")
    void updateBatch(Batch batch);

    @Delete("DELETE FROM BATCH WHERE BATCHID = #{batchId}")
    void deleteBatch(Integer batchId);
}
