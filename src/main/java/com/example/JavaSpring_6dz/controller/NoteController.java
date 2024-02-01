package com.example.JavaSpring_6dz.controller;

import com.example.JavaSpring_6dz.model.Note;
import com.example.JavaSpring_6dz.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    //   Просмотр всех заметок( @GetMapping )
    @GetMapping
    public ResponseEntity<List<Note>> getAll() {
        return new ResponseEntity<>(noteService.findAll(), HttpStatus.OK);
    }


    //    Получение заметки по id (@GetMapping("/{id}")
    @GetMapping("{id}")
    public ResponseEntity<Note> getById(@PathVariable("id") long id) {
        return new ResponseEntity<>(noteService.findById(id), HttpStatus.OK);
    }

    //  Добавление заметки ( @PostMapping )
    @PostMapping
    public ResponseEntity<Note> save(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.save(note), HttpStatus.CREATED);
    }

    //   Редактирование заметки( @PutMapping("/{id}")
    @PutMapping
    public ResponseEntity<Note> update(@RequestBody Note note) {

        return new ResponseEntity<>(noteService.update(note), HttpStatus.OK);
    }

    //  Удаление заметки( @DeleteMapping("/{id}")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable("id") long id) {
        noteService.deletById(id);
        return ResponseEntity.ok().build();
    }
}
