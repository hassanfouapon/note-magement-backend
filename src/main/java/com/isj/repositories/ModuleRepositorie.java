package com.isj.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isj.models.Module;

@Repository
public interface ModuleRepositorie  extends JpaRepository <Module, Long> {


}
