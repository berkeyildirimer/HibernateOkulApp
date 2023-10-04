package com.berke.service;

import com.berke.repository.OgrenciRepository;
import com.berke.repository.entity.Ogrenci;

import java.util.List;
import java.util.Optional;

public class OgrenciService {

    OgrenciRepository ogrenciRepository;

    public OgrenciService(){
        this.ogrenciRepository = new OgrenciRepository();
    }

    public Ogrenci save(Ogrenci ogrenci){

        return ogrenciRepository.save(ogrenci);
    }

    public List<Ogrenci> findAll(){
        return ogrenciRepository.findAll();
    }
    public Optional<Ogrenci> findById(Long id){
        return ogrenciRepository.findById(id);
    }
}
