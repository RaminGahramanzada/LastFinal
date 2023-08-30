package az.iktlab.controller;

import az.iktlab.dao.BookRepository;
import az.iktlab.dao.impl.BookDaoImpl;
import az.iktlab.service.BookService;
import az.iktlab.service.impl.BookServiceImpl;
import az.iktlab.util.ScannerUtil;

import java.util.List;
import java.util.Map;

public class BookController {
    private final BookService bookService= new BookServiceImpl();
    public int addBook(Integer usrId, Integer flightId) {
        return bookService.addBook(usrId,flightId);
    }
    public boolean cancelBook(int FlightId) {
        return bookService.cancelBook(FlightId);
    }
    public List<Map<String, Object>> getBookingsByUserFullName(String fullName) {
        return bookService.getBookingsByUserFullName(fullName);
    }
}
