package com.berke.service;

import com.berke.repository.OgretmenRepository;
import com.berke.repository.entity.Ogretmen;

import java.util.List;
import java.util.Optional;

public class OgretmenService {
    OgretmenRepository ogretmenRepository;

    public OgretmenService() {
        this.ogretmenRepository = new OgretmenRepository();

    }
    public Ogretmen save(Ogretmen ogretmen){

        return ogretmenRepository.save(ogretmen);
    }
    public List<Ogretmen> findAll(){
        return ogretmenRepository.findAll();
    }
    public Optional<Ogretmen> findById(Long id){
        return ogretmenRepository.findById(id);
    }
}
