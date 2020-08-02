package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository)
    {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Fuck All Design", "123123");
        Publisher spx = new Publisher("Spx Inter Ltd","USA");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        spx.getBooks().add(ddd);


        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(spx);

        Author riddhiman = new Author("Riddhiman", "Chatterjee");
        Book spring10 = new Book("J2EE Development with Spring", "23354459");
        Publisher xxx = new Publisher("Phantom Ltd","Patna");
        riddhiman.getBooks().add(spring10);
        spring10.getAuthors().add(riddhiman);
        xxx.getBooks().add(spring10);

        authorRepository.save(riddhiman);
        bookRepository.save(spring10);
        publisherRepository.save(xxx);

        System.out.println("Started in Bootstrap---by RC");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("Number of Publishers: "+publisherRepository.toString() + xxx.getBooks().size());
    }
}
