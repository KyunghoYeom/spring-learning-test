package cholog;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    Person person;

    @OneToMany(mappedBy = "author")
    Set<BookAuthor> books;

    public Author(Person person) {
    }

    public Author() {
    }

    public Long getId() {
        return id;
    }

    public Person getPerson() {
        return null;
    }
}
