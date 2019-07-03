package com.library;

import com.library.dbservice.DbService;
import com.library.domain.Book;
import com.library.domain.Reader;
import com.library.domain.Rentals;
import com.library.domain.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KodillaLibraryApplicationTests {
    @Autowired
    DbService dbService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testCreateContent() {
        //Given
        Reader freddy = new Reader("Freddy", "Mercury", LocalDate.of(1410, 4, 5), new ArrayList<>());
        Title title1 = new Title("Pszczolka maja", "Adam Mickiewicz", 2011, new ArrayList<>());
        Title title = new Title("Czterej pancerni", "Jan Brzechwka", 1999, new ArrayList<>());
        Book book1 = new Book(title, "new");
        Book book2 = new Book(title1, "new");
        Book book3 = new Book(title, "new");
        Book book4 = new Book(title1, "new");
        title1.getBooks().add(book2);
        title1.getBooks().add(book4);
        title.getBooks().add(book1);
        title.getBooks().add(book3);
        Rentals rentals = new Rentals(book1, freddy, LocalDate.of(2016, 4, 4), LocalDate.of(2016, 4, 4));
        freddy.getRentalBook().add(rentals);

        //When
        dbService.addTitle(title);
        dbService.addTitle(title1);
        dbService.addReader(freddy);
        //Then
        Assert.assertEquals(freddy.getFirstname(), "Freddy");

    }



}
