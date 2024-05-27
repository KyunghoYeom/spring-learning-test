package cholog;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    Publisher publisher;

    @OneToMany(mappedBy = "book")
    Set<BookAuthor> authors;

    public Book() {

    }

    public Book(String name, Publisher publisher) {
    }

   /* public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Publisher getPublisher() {
        return null;
    }

    public Set<Author> getAuthors() {
        return null;
    }*/
}
