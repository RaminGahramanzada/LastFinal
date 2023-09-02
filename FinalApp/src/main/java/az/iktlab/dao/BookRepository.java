package az.iktlab.dao;

import java.util.List;
import java.util.Map;

public interface BookRepository {

    int addBook(Integer usrId,Integer flightId);
    boolean cancelBook(int FlightId);

    List<Map<String, Object>> getBookingsByUserFullName(String fullName);
}
