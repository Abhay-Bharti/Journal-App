package net.engineeringdigest.journalApp.Models;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "journal_entries")
@Data
public class Journal {

    @Id
    private ObjectId id;
    @NonNull
    private String title;
    @NonNull
    private String description;
}

