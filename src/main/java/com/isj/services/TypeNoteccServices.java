package com.isj.services;
import com.isj.models.TypeNoteCC;
import com.isj.repositories.TypeNoteccRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeNoteccServices {

    @Autowired
    TypeNoteccRepositorie typeNoteccRepositorie;

    public TypeNoteCC insertTypeNotecc(TypeNoteCC typeNoteCC){
        return  typeNoteccRepositorie.save(typeNoteCC);
    }

    public Optional<TypeNoteCC> findById(long code){
        return typeNoteccRepositorie.findById(code);
    }

    public List<TypeNoteCC> FindTypeNotecc(){
        return  typeNoteccRepositorie.findAll();
    }

    public  TypeNoteCC updateTypeNotecc(TypeNoteCC typeNoteCC) {
        return  typeNoteccRepositorie.save(typeNoteCC);
    }

    public void deleteTypeNotecc(long id){
        typeNoteccRepositorie.deleteById(id);
    }


}
