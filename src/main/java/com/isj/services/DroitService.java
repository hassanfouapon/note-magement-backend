package com.isj.services;
import com.isj.models.Droit;
import com.isj.repositories.DroitRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DroitService {
    @Autowired
    private DroitRepositorie droitRepositorie;

    public Droit insert(Droit droit){
        return droitRepositorie.save(droit);
    }
    public Optional<Droit> findById(long code){
        return droitRepositorie.findById(code);
    }
    public List<Droit> FindDroit(){
        return  droitRepositorie.findAll();
    }

    public void updateDroit(Droit droit) {
        droitRepositorie.save(droit);
    }

    public void deleteDroit(long id){
        droitRepositorie.deleteById(id);
    }
}
