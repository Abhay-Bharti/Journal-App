package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.Models.Journal;
import net.engineeringdigest.journalApp.Models.Users;
import net.engineeringdigest.journalApp.respository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveEntry(Users user){
        userRepository.save(user);
    }

    public List<Users> getAll(){
        return userRepository.findAll();
    }

    public Optional<Users> getById(ObjectId id){
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }
}
