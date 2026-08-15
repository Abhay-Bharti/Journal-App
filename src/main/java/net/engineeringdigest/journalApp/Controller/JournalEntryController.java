package net.engineeringdigest.journalApp.Controller;

import net.engineeringdigest.journalApp.Models.Journal;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;
    
    @PostMapping
    public String saveJournal(@RequestBody Journal body){
        journalEntryService.saveEntry(body);
        return "Data Saved";
    }

    @GetMapping
    public List<Journal> getJournal(){
        return journalEntryService.getAll();
    }

    @GetMapping("/{id}")
    public Journal getJournalById(@PathVariable ObjectId id){
        return journalEntryService.getById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteJournal(@PathVariable ObjectId id){
        journalEntryService.deleteById(id);
        return "Data Deleted";
    }

    @PutMapping("/{id}")
    public String editJournal(@PathVariable ObjectId id, @RequestBody Journal body ){
        Journal oldEntry = journalEntryService.getById(id).orElse(null);

        if(oldEntry != null){
            oldEntry.setTitle( body.getTitle() != null && !body.getTitle().equals("") ? body.getTitle() : oldEntry.getTitle());
            oldEntry.setDescription( body.getDescription() != null && !body.getDescription().equals("") ? body.getDescription() : oldEntry.getDescription());

        }
        journalEntryService.saveEntry(oldEntry);
        return "Data Updated";
    }

}
