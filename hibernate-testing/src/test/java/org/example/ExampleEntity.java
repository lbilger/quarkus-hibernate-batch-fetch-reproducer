package org.example;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.BatchSize;

import java.util.Set;

@Entity
public class ExampleEntity {

    @Id
    String id;

    @ElementCollection
    @BatchSize(size = 5)
    Set<String> anElementCollection;

    public ExampleEntity() {}

    public ExampleEntity(String id, Set<String> anElementCollection) {
        this.id = id;
        this.anElementCollection = anElementCollection;
    }

    public String getId() {return this.id;}

    public Set<String> getAnElementCollection() {return this.anElementCollection;}

    public void setId(String id) {this.id = id;}

    public void setAnElementCollection(Set<String> anElementCollection) {this.anElementCollection = anElementCollection;}
}
