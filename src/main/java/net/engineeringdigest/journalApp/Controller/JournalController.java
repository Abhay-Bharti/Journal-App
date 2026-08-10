package net.engineeringdigest.journalApp.Controller;

import net.engineeringdigest.journalApp.Models.Journal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/journal")
public class JournalController {
    public HashMap<Long, Journal> map = new HashMap<>( );

    @GetMapping
    public ArrayList<Journal> getJournal(){
        return new ArrayList<>(map.values());
    }

    @PostMapping
    public String saveJournal(@RequestBody Journal body){
        map.put(body.getId(), body);
        return "Data Saved";
    }

    @PutMapping
    public String editJournal(@RequestBody Journal body ){
        map.put(body.getId(), body);
        return "Data Updated";
    }

    @DeleteMapping("/{id}")
    public String deleteJournal(@PathVariable Long id){
        map.remove(id);
        return "Data Deleted";
    }

    @GetMapping("/{id}")
    public Journal getJournalById(@PathVariable Long id){
        return map.get(id);
    }
}
