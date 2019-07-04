package com.library.mapper;

import com.library.domain.dto.TitleDto;
import com.library.domain.Title;
import org.springframework.stereotype.Component;

@Component
public class TitleMapper {

    public Title mapToTitle(TitleDto titleDto) {
        return new Title(titleDto.getTitleId(), titleDto.getBookTitle(), titleDto.getAuthor(), titleDto.getPublicationYear(), titleDto.getBooks());
    }
}
