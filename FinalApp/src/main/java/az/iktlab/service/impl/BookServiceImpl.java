package az.iktlab.service.impl;

import az.iktlab.dao.BookRepository;
import az.iktlab.dao.impl.BookDaoImpl;
import az.iktlab.service.BookService;

import java.util.List;
import java.util.Map;

public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository = new BookDaoImpl();
    @Override
    public int addBook(Integer usrId, Integer flightId) {
        return bookRepository.addBook(usrId,flightId);
    }

    public boolean cancelBook(int FlightId) {
        return bookRepository.cancelBook(FlightId);
    }

    public List<Map<String, Object>> getBookingsByUserFullName(String fullName) {
        return bookRepository.getBookingsByUserFullName(fullName);
    }


}

