package com.isj.services;


import com.isj.models.Module;
import com.isj.repositories.ModuleRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleServices {

    @Autowired
    private ModuleRepositorie moduleRepositorie;


    public void save(Module module){

        moduleRepositorie.save(module);
    }
    public Module insert(Module module){
        return  moduleRepositorie.save(module);
    }
    public List<Module> FindModule(){
        return  moduleRepositorie.findAll();
    }

    public Optional<Module> findById(Long codeModule){
        return moduleRepositorie.findById(codeModule);
    }

    public List<Module> findmodule(){

        return moduleRepositorie.findAll();
    }

    public void deleteModule(long id){
        moduleRepositorie.deleteById(id);
    }



}

