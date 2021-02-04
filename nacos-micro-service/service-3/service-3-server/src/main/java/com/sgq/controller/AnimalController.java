package com.sgq.controller;

import com.sgq.api.IAnimalService;
import com.sgq.pojo.Animal;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnimalController {
    @Reference
    private IAnimalService service;

    @GetMapping("/findAll")
    public List<Animal> findAll(){
        return service.findAll();
    }
}
