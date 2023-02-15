package com.isj.services;


import com.isj.models.Discipline;
import com.isj.repositories.DisciplineRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplineService {
    @Autowired
    private DisciplineRepositorie disciplineRepositorie;


    public Discipline insert(Discipline discipline){
        return  disciplineRepositorie.save(discipline);
    }

    public Optional<Discipline> findById(long code){
        return disciplineRepositorie.findById(code);
    }

    public List<Discipline> FindDiscipline(){
        return  disciplineRepositorie.findAll();
    }

    public void updatediscipline(Discipline discipline) {
        disciplineRepositorie.save(discipline);
    }

    public void deletediscipline(long id){
        disciplineRepositorie.deleteById(id);
    }

}
