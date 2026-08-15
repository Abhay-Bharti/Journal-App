package net.engineeringdigest.journalApp.respository;

import net.engineeringdigest.journalApp.Models.Journal;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<Journal, ObjectId> {

}
