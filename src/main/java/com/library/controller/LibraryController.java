package com.library.controller;

import com.library.dbservice.DbService;
import com.library.domain.Reader;
import com.library.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v2/library")
public class LibraryController {
    @Autowired
    DbService dbService;
    @Autowired
    Mapper mapper;

    @RequestMapping(method = RequestMethod.POST,value = "addReader")
    public void addReader(@RequestBody Reader reader) {
        dbService.addReader(reader);
    }
}
