package com.isj.services;


import com.isj.models.Classe;
import com.isj.repositories.ClassRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService{

    @Autowired
    private ClassRepositorie classRepositorie;


    public Classe insert(Classe clas) {
        return classRepositorie.save(clas);
    }

    public Optional<Classe> findById(long code) {
        return classRepositorie.findById(code);
    }

    public List<Classe> FindClass() {
        return classRepositorie.findAll();
    }

    public Classe updateClass(Classe clas) {
        return classRepositorie.save(clas);
    }

    public void deleteClass(long id) {
        classRepositorie.deleteById(id);
    }

}
