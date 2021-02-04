package com.sgq.api;

import com.sgq.pojo.Animal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ThirdService {

    List<Animal> findAll();

    List<Animal> findByLike(@Param("name") String name, @Param("age") Integer age);

    List<Animal> findByLikeDefault(@Param("name") String name,@Param("age") Integer age);
}
