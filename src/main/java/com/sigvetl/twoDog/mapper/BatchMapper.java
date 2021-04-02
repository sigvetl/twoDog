package com.sigvetl.twoDog.mapper;

import com.sigvetl.twoDog.model.Batch;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BatchMapper {
    @Select("SELECT * FROM BATCH " +
            "ORDER BY BREWDATE DESC")
    List<Batch> getAllBatches();

    @Select("SELECT * FROM BATCH WHERE batchid=#{batchId}")
    Integer getBatch(Batch batch);

    //values are wrong
//    @Insert("INSERT INTO BATCH(VOLUME, BREWDATE, OG, RECIPELINK, USERID) " +
//            "VALUES(#{name}, #{type}, #{ibu}, #{recipeLink}, #{userId})")
    @Insert("INSERT INTO BATCH(VOLUME, OG, FG, ABV, USERID, BREWDATE, TAPDATE, CREATEDBY, LASTUPDATEDBY, QUALITY," +
            " COMMENTS, BEERID) " +
            "VALUES(#{volume}, #{og}, #{fg}, #{abv}, #{userId}, #{brewDate}, #{tapDate}, #{createdBy}, #{lastUpdatedBy}, " +
            "#{quality}, #{comments}, #{beerId})")
    @Options(useGeneratedKeys = true, keyProperty = "batchId")
    void insertBatch(Batch batch);

    //values are wrong
//    @Update("UPDATE BATCH SET NAME = #{name}, TYPE = #{type}, IBU = #{ibu}, " +
//            "RECIPELINK = #{recipeLink}, USERID = #{userId} WHERE BATCHID = #{batchId}")
    @Update("UPDATE BATCH SET VOLUME = #{volume}, OG = #{og}, FG = #{fg}, ABV = #{abv}, USERID = #{userId}, " +
            "BREWDATE = #{brewDate}, TAPDATE = #{tapDate}, LASTUPDATEDBY= #{lastUpdatedBy}, QUALITY= #{quality}, " +
            "COMMENTS= #{comments}, BEERID= #{beerId} WHERE BATCHID = #{batchId}")
    void updateBatch(Batch batch);

    @Delete("DELETE FROM BATCH WHERE BATCHID = #{batchId}")
    void deleteBatch(Integer batchId);
}
