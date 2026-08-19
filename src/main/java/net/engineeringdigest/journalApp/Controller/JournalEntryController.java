package net.engineeringdigest.journalApp.Controller;

import net.engineeringdigest.journalApp.Models.Journal;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;
    
    @PostMapping
    public ResponseEntity<?> saveJournal(@RequestBody Journal body){
        try {
            journalEntryService.saveEntry(body);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getJournal(){
        List<Journal> list = journalEntryService.getAll();
        if(list != null && !list.isEmpty()){
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getJournalById(@PathVariable ObjectId id){
        Optional<Journal> entry = journalEntryService.getById(id);

        if (entry.isPresent()){
            return new ResponseEntity<>(entry, HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJournal(@PathVariable ObjectId id){
        try {
            journalEntryService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editJournal(@PathVariable ObjectId id, @RequestBody Journal body ){
        Journal oldEntry = journalEntryService.getById(id).orElse(null);

        if(oldEntry != null){
            oldEntry.setTitle( body.getTitle() != null && !body.getTitle().equals("") ? body.getTitle() : oldEntry.getTitle());
            oldEntry.setDescription( body.getDescription() != null && !body.getDescription().equals("") ? body.getDescription() : oldEntry.getDescription());
            journalEntryService.saveEntry(oldEntry);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

}
