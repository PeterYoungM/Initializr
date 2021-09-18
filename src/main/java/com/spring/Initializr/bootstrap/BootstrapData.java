package com.spring.Initializr.bootstrap;

import com.spring.Initializr.domain.Author;
import com.spring.Initializr.domain.Book;
import com.spring.Initializr.domain.Publisher;
import com.spring.Initializr.repositories.AuthorRepository;
import com.spring.Initializr.repositories.BookRepository;
import com.spring.Initializr.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher newSoftWorks = new Publisher();
        newSoftWorks.setName("New Soft Works");
        newSoftWorks.setCity("Nairobi");

        publisherRepository.save(newSoftWorks);

        System.out.println("Publisher count "+publisherRepository.count());

        Author stephenson = new Author("Peter","John");
        Book overTheOcean = new Book("Over the Ocean","222.2332.111");


        stephenson.getBooks().add(overTheOcean);
        overTheOcean.getAuthors().add(stephenson);
        overTheOcean.setPublisher(newSoftWorks);
        newSoftWorks.getBooks().add(overTheOcean);

        authorRepository.save(stephenson);
        bookRepository.save(overTheOcean);
        publisherRepository.save(newSoftWorks);

        Author sylvia = new Author("Agnes"," Atieno");
        Book inTheWishingWell = new Book("In The Wshing Well","435.3636.7336");

        sylvia.getBooks().add(inTheWishingWell);
        inTheWishingWell.getAuthors().add(sylvia);
        inTheWishingWell.setPublisher(newSoftWorks);
        newSoftWorks.getBooks().add(inTheWishingWell);


        authorRepository.save(sylvia);
        bookRepository.save(inTheWishingWell);
        publisherRepository.save(newSoftWorks);

        System.out.println("No. of books " + bookRepository.count());


    }



}
