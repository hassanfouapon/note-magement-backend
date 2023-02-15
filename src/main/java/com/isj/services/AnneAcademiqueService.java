package com.isj.services;

import com.isj.models.AnneeAcademique;
import com.isj.models.AnneeAcademique;
import com.isj.repositories.AnneAcademiqueRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnneAcademiqueService {

    @Autowired private AnneAcademiqueRepositorie anneAcademiqueRepositorie;



    public AnneeAcademique insert(AnneeAcademique anneeAcademique){
        return  anneAcademiqueRepositorie.save(anneeAcademique);
    }

    public Optional<AnneeAcademique> findById(long code){
        return anneAcademiqueRepositorie.findById(code);
    }

    public List<AnneeAcademique> FindAnneeAcademique(){
        return  anneAcademiqueRepositorie.findAll();
    }

    public void updateAnneeAcademique(AnneeAcademique AnneeAcademique) {
        anneAcademiqueRepositorie.save(AnneeAcademique);
    }

    public void deleteAnneeAcademique(long id){
        anneAcademiqueRepositorie.deleteById(id);
    }


}
