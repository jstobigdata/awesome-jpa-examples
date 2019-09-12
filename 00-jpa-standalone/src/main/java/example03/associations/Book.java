package example03.associations;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
public class Book implements Serializable {

    @Id
    private String title;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    @CreationTimestamp
    private Timestamp createdOn;

    public Book() {
    }

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(createdOn, book.createdOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, createdOn);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]")
                .add("title='" + title + "'")
                .add("author=" + author)
                .add("createdOn=" + createdOn)
                .toString();
    }
}
