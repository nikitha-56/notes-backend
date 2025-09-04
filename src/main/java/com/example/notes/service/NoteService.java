package com.example.notes.service;

import com.example.notes.model.Note;
import com.example.notes.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    public Optional<Note> getNoteByShareId(String shareId) {
        return noteRepository.findAll().stream()
                .filter(n -> shareId.equals(n.getShareId()))
                .findFirst();
    }
}
