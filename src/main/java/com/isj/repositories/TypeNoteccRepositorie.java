package com.isj.repositories;

import com.isj.models.TypeNoteCC;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeNoteccRepositorie extends JpaRepository<TypeNoteCC,Long> {
}
