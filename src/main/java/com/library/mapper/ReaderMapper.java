package com.library.mapper;

import com.library.domain.dto.ReaderDto;
import com.library.domain.Reader;
import org.springframework.stereotype.Component;

@Component
public class ReaderMapper {

    public Reader mapToReader(ReaderDto readerDto) {
        return new Reader(readerDto.getReaderId(), readerDto.getFirstname(), readerDto.getLastname(), readerDto.getSingUpDate(), readerDto.getRentalBook());
    }
}
