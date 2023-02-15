package com.isj.repositories;


import com.isj.models.Anonymat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnonymatRepositorie extends  JpaRepository<Anonymat, Long>{

}
