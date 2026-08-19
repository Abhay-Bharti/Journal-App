package net.engineeringdigest.journalApp.respository;

import net.engineeringdigest.journalApp.Models.Users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Users, ObjectId> {
}
