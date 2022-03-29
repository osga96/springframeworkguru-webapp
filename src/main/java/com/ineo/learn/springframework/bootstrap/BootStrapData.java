package com.ineo.learn.springframework.bootstrap;

import com.ineo.learn.springframework.model.Author;
import com.ineo.learn.springframework.model.Book;
import com.ineo.learn.springframework.model.Publisher;
import com.ineo.learn.springframework.repositories.AuthorRepository;
import com.ineo.learn.springframework.repositories.BookRepository;
import com.ineo.learn.springframework.repositories.PublisherRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final SessionFactory hibernateFactory;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository, EntityManagerFactory sessionFactory) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.hibernateFactory = sessionFactory.unwrap(SessionFactory.class);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("running...");

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE development without EJB", "783712931");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        Publisher thePublisher = new Publisher("Publisher1", "C/ Perico de los palotes, 12", "Zaragoza", "Zaragoza", "50001");

        publisherRepository.save(thePublisher);

        ddd.setPublisher(thePublisher);
        thePublisher.getBooks().add(ddd);

        noEJB.setPublisher(thePublisher);
        thePublisher.getBooks().add(noEJB);

        publisherRepository.save(thePublisher);
        bookRepository.save(ddd);
        bookRepository.save(noEJB);

        System.out.println("Book count: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());
        /*System.out.println("Publisher get books size: " + thePublisher.getBooks().size());

        List<Publisher> publisherList = (List<Publisher>) publisherRepository.findAll();

        for (Publisher publisher : publisherList) {
            System.out.println("publisher.getBooks().size(): " + publisher.getBooks().size());
        }

        Session session = hibernateFactory.openSession();
        session.beginTransaction();
        publisherRepository.findAll().forEach(publisher -> {
            System.out.println("books: " + publisher.getBooks());
        });*/

    }
}
