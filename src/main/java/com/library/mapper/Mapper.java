package com.library.mapper;

import com.library.domain.Book;
import com.library.domain.Dto.BookDto;
import com.library.domain.Dto.ReaderDto;
import com.library.domain.Dto.RentalsDto;
import com.library.domain.Dto.TitleDto;
import com.library.domain.Reader;
import com.library.domain.Rentals;
import com.library.domain.Title;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {
    public Book mapToBook(BookDto bookDto) {
        return new Book(bookDto.getBookId(), bookDto.getTitleId(), bookDto.getStatus());
    }

    public BookDto mapToBookDto(Book book) {
        return new BookDto(book.getBookId(), book.getTitleId(), book.getStatus());
    }

    public Reader mapToReader(ReaderDto readerDto) {
        return new Reader(readerDto.getReaderId(), readerDto.getFirstname(), readerDto.getLastname(), readerDto.getSingUpDate(), readerDto.getRentalBook());
    }

    public ReaderDto mapToReaderDto(Reader reader) {
        return new ReaderDto(reader.getReaderId(),reader.getFirstname(),reader.getLastname(),reader.getSingUpDate(),reader.getRentalBook());
    }

    public Rentals mapToRentals(RentalsDto rentalsDto) {
        return new Rentals(rentalsDto.getRentalId(),rentalsDto.getBookId(),rentalsDto.getReaderId(),rentalsDto.getRentDate(),rentalsDto.getGiveBackDate());
    }
    public RentalsDto mapToRentals(Rentals rentals) {
        return new RentalsDto(rentals.getRentalId(),rentals.getBookId(),rentals.getReaderId(),rentals.getRentDate(),rentals.getGiveBackDate());
    }
    public List<RentalsDto> mapToRentalDtoList (List<Rentals> rentalsList) {
        return rentalsList.stream()
                .map(x -> new RentalsDto(x.getRentalId(),x.getBookId(),x.getReaderId(),x.getRentDate(),x.getGiveBackDate()))
                .collect(Collectors.toList());
    }
    public List<Rentals> mapToRentalList (List<RentalsDto> rentalsDtoList) {
        return rentalsDtoList.stream()
                .map(x -> new Rentals(x.getRentalId(),x.getBookId(),x.getReaderId(),x.getRentDate(),x.getGiveBackDate()))
                .collect(Collectors.toList());
    }
    public Title mapToTitle(TitleDto titleDto) {
        return new Title(titleDto.getTitleId(),titleDto.getBookTitle(),titleDto.getAuthor(),titleDto.getPublicationYear(),titleDto.getBooks());
    }
    public TitleDto mapToTitleDto(Title title) {
        return new TitleDto(title.getTitleId(),title.getBookTitle(),title.getAuthor(),title.getPublicationYear(),title.getBooks());
    }
}
