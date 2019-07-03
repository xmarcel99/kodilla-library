package com.library;

import com.library.dbservice.DbService;
import com.library.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication
public class KodillaLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(KodillaLibraryApplication.class, args);

    }

}
