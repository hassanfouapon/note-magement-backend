package com.isj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isj.models.Role;

@Repository

public interface RoleRespositorie extends JpaRepository <Role, Long> {


}
