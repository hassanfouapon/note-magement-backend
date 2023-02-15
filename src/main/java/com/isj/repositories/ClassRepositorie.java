package com.isj.repositories;


import com.isj.models.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ClassRepositorie extends JpaRepository <Classe, Long> {



}
