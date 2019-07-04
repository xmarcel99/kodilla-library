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

}
