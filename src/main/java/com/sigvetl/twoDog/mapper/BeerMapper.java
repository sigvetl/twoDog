package com.sigvetl.twoDog.mapper;

import com.sigvetl.twoDog.model.Beer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BeerMapper {
    @Select("SELECT * FROM BEER")
    List<Beer> getAllBeers();

    @Select("SELECT * FROM BEER WHERE beerid=#{beerId}")
    Integer getBeer(Beer beer);

    //@Insert("INSERT INTO BEER(NAME, TYPE, IBU, RECIPELINK, USERID) " +
    //        "VALUES(#{name}, #{type}, #{ibu}, #{recipeLink}, #{userId})")
    @Insert("INSERT INTO BEER(NAME, TYPE, USERID, IBU, RECIPELINK) " +
            "VALUES(#{name}, #{type}, #{userId}, #{ibu}, #{recipeLink})")
    @Options(useGeneratedKeys = true, keyProperty = "beerId")
    void insertBeer(Beer beer);

//    @Update("UPDATE BEER SET NAME = #{name}, TYPE = #{type}, IBU = #{ibu}, " +
//            "RECIPELINK = #{recipeLink}, USERID = #{userId} WHERE BEERID = #{beerId}")
    @Update("UPDATE BEER SET NAME = #{name}, TYPE = #{type}, USERID = #{userId}, IBU = #{ibu}, RECIPELINK = #{recipeLink} WHERE BEERID = #{beerId}")
    void updateBeer(Beer beer);

    @Delete("DELETE FROM BEER WHERE BEERID = #{beerId}")
    void deleteBeer(Integer beerId);

}
