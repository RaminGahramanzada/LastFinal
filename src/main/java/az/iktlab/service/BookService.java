package az.iktlab.service;

import java.util.List;
import java.util.Map;

public interface BookService {
    int addBook(Integer usrId,Integer flightId);
    boolean cancelBook(int FlightId);
    List<Map<String, Object>> getBookingsByUserFullName(String fullName);
}
