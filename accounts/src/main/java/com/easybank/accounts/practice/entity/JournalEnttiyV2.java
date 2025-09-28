package com.easybank.accounts.practice.entity;

import jakarta.persistence.Id;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "journal_entries")
/*@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode*/
//@Builder
// instead of above, we can use Lombok
@Data
public class JournalEnttiyV2 {

    // fields
    @Id
    private ObjectId id;
    @NonNull
    private String title;
    private String content;
    private LocalDateTime date;

    // getter and setter

    // removing getters and setters by using Lombok


}
