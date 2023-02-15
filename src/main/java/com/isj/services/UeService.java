package com.isj.services;

import com.isj.models.UE;
import com.isj.repositories.UeRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UeService {

    @Autowired
    private UeRepositorie ueRepositorie;

    public UE insertUe(UE ue){

        return ueRepositorie.save(ue);
    }


    public Optional<UE> findById(long code){
        return ueRepositorie.findById(code);
    }

    public List<UE> findUe(){

        return ueRepositorie.findAll();
    }

    public void updateUe(UE ue){
         ueRepositorie.save(ue);
    }

    public void deleteUe(long id){
        ueRepositorie.deleteById(id);
    }
}
