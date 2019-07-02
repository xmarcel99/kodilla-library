package com.library.dbservice;

import com.library.domain.Book;
import com.library.domain.Reader;
import com.library.domain.Rentals;
import com.library.domain.Title;
import com.library.repository.BookRepository;
import com.library.repository.ReaderRepository;
import com.library.repository.RentalsRepository;
import com.library.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DbService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    ReaderRepository readerRepository;
    @Autowired
    RentalsRepository rentalsRepository;
    @Autowired
    TitleRepository titleRepository;

    public void addReader(Reader reader) {
        readerRepository.save(reader);
    }
    public void addTitle(Title title) {
        titleRepository.save(title);
    }
    public void addBook(Book book) {
        bookRepository.save(book);
    }
    public void addRentals(Rentals rentals) {
        rentalsRepository.save(rentals);
    }
    public void deleteRentals(int rentalId) {
        rentalsRepository.deleteById(rentalId);
    }


}
