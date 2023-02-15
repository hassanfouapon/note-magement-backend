package com.isj.repositories;


import com.isj.models.AnneeAcademique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnneAcademiqueRepositorie extends  JpaRepository<AnneeAcademique, Long>{

}
