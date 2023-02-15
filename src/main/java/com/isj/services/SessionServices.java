package com.isj.services;


import com.isj.models.Session;
import com.isj.repositories.SessionRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionServices {

    @Autowired
    private SessionRepositorie sessionRepositorie;


    public Session insert(Session session){
        return  sessionRepositorie.save(session);
    }

    public Optional<Session> findById(long code){
        return sessionRepositorie.findById(code);
    }

    public List<Session> FindSession(){
        return  sessionRepositorie.findAll();
    }

    public  Session updatesession(Session session) {
        return  sessionRepositorie.save(session);
    }

    public void deletesession(long id){
        sessionRepositorie.deleteById(id);
    }

}
