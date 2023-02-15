package com.isj.services;


import com.isj.models.Filiere;
import com.isj.models.Role;
import com.isj.repositories.RoleRespositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class RoleServices {

    @Autowired
    private RoleRespositorie roleRepositorie;

    public Role insert(Role role){
        return  roleRepositorie.save(role);
    }


    public void save(Role role){

        roleRepositorie.save(role);
    }

    public Optional<Role> findById(long code){
        return roleRepositorie.findById(code);
    }

    public List<Role> findRole(){

        return roleRepositorie.findAll();
    }

    public void deleterole(long id){
        roleRepositorie.deleteById(id);
    }

}
