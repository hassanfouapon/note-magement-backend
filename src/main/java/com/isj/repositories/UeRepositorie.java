package com.isj.repositories;
import com.isj.models.UE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UeRepositorie extends JpaRepository<UE, Long> {
}
