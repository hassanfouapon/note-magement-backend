package com.isj.services;


import com.isj.models.Note;
import com.isj.repositories.NoteRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServices {

    @Autowired
    private NoteRepositorie noteRepositorie;

    public Note insert(Note note){
        return  noteRepositorie.save(note);
    }


    public void save(Note note){

        noteRepositorie.save(note);
    }

    public List<Note> findNote(){

        return noteRepositorie.findAll();
    }

    public void deletenote(long id){
        noteRepositorie.deleteById(id);
    }

}


