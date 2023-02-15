package com.isj.repositories;

import com.isj.models.NoteCC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteccRepositorie extends JpaRepository<NoteCC, Long> {
}
