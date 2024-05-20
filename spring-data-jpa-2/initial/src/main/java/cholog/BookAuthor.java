package cholog;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BookAuthor {
    @Id
    @GeneratedValue
    Long id;
    @ManyToOne
    Book book;

    @ManyToOne
    Author author;

    public BookAuthor(Book book, Author author) {
        this.book = book;
        this.author = author;
    }
    public BookAuthor(){

    }
}
