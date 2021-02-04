package com.sgq.service;

import com.sgq.api.IAnimalService;
import com.sgq.api.ThirdService;
import com.sgq.pojo.Animal;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service
public class ThirdServiceImpl implements ThirdService {
    @Reference
    private IAnimalService service;
    @Override
    public List<Animal> findAll() {
        System.out.println("在service-1调用findAll");
        return service.findAll();
    }

    @Override
    public List<Animal> findByLike(String name, Integer age) {
        System.out.println("在service-1调用findByLike");
        return service.findByLike(name,age);
    }

    @Override
    public List<Animal> findByLikeDefault(String name, Integer age) {
        System.out.println("在service-1调用findByLikeDefault");
        return service.findByLikeDefault(name,age);
    }
}
