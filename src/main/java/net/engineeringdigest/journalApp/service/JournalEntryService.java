package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.Models.Journal;
import net.engineeringdigest.journalApp.respository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void saveEntry(Journal journalEntry){
        journalEntryRepository.save(journalEntry);
    }

    public List<Journal> getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<Journal> getById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        journalEntryRepository.deleteById(id);
    }
}
