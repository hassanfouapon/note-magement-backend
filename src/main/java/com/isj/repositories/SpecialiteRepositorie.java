package com.isj.repositories;


import com.isj.models.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialiteRepositorie extends  JpaRepository<Specialite, Long>{


}
