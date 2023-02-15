package com.isj.services;

import com.isj.models.NoteCC;
import com.isj.repositories.NoteccRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteccServices {

    @Autowired
    NoteccRepositorie noteccRepositorie;

    public NoteCC insertNotecc(NoteCC noteCC){
        return  noteccRepositorie.save(noteCC);
    }

    public Optional<NoteCC> findById(long code){
        return noteccRepositorie.findById(code);
    }

    public List<NoteCC> FindNotecc(){
        return  noteccRepositorie.findAll();
    }

    public  NoteCC updateNotecc(NoteCC noteCC) {
        return  noteccRepositorie.save(noteCC);
    }

    public void deleteNotecc(long id){
        noteccRepositorie.deleteById(id);
    }


}
