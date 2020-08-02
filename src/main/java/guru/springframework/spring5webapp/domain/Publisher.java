package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/* Created by riddhiman 02/08/2020

 */
@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;


    private String PublisherName;
    private String PublisherAddr;

    @OneToMany
    @JoinColumn(name = "publisher_id")
    private Set<Book> books =new HashSet<>();

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Publisher() {
    }

    public Publisher(String publisherName, String publisherAddr) {
        //Id = id;
        PublisherName = publisherName;
        PublisherAddr = publisherAddr;
    }



    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getPublisherName() {
        return PublisherName;
    }

    public void setPublisherName(String publisherName) {
        this.PublisherName = publisherName;
    }

    public String getPublisherAddr() {
        return PublisherAddr;
    }

    public void setPublisherAddr(String publisherAddr) {
        this.PublisherAddr = publisherAddr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return Id != null ? Id.equals(publisher.Id) : publisher.Id == null;
    }

    @Override
    public int hashCode() {
        return Id != null ? Id.hashCode() : 0;
    }
}
