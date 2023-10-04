package com.berke.controller;


import com.berke.repository.entity.Sinif;
import com.berke.service.SinifService;

import java.util.List;
import java.util.Optional;

public class SinifController {
    SinifService sinifService;

    public SinifController (){
        this.sinifService = new SinifService();
    }

    public Sinif save(Sinif sinif){
        return sinifService.save(sinif);
    }

//    public void update(Sinif sinif){
//        sinifService.update(sinif);
//    }

    public List<Sinif> findAll(){
        return sinifService.findAll();
    }

    public Optional<Sinif> findById(Long id){
        return sinifService.findById(id);
    }
}
