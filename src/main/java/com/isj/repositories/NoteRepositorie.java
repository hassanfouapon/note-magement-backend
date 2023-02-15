package com.isj.repositories;


import com.isj.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepositorie extends JpaRepository<Note, Long> {

}
