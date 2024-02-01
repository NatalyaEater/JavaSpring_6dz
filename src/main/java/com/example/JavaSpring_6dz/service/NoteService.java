package com.example.JavaSpring_6dz.service;


import com.example.JavaSpring_6dz.model.Note;
import com.example.JavaSpring_6dz.repo.NoteJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteJpa noteJpa;

    public List<Note> findAll(){
        return noteJpa.findAll();
    }

    public Note findById(Long id){
        return noteJpa.findById(id).orElseThrow(null);
    }


    public Note update (Note note) {
            Note noteUpdate = findById(note.getId());
            noteUpdate.setHead(note.getHead());
            noteUpdate.setContent(note.getContent());
            return noteJpa.save(noteUpdate);
    }

    public Note save(Note note){
        return noteJpa.save(note);
    }

    public void deletById(Long id){
        noteJpa.deleteById(id);
    }


}
