package com.example.JavaSpring_6dz.repo;

import com.example.JavaSpring_6dz.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface NoteJpa extends JpaRepository<Note, Long>{


}
