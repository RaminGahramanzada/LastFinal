package az.iktlab.bookingapp.dao.repository;

import az.iktlab.bookingapp.dao.entity.Flight;

import java.util.List;

public interface FlightRepository {
    void insertFlight(Flight flight);
    Flight getFlightById(int id);
    List<Flight> getAllFlights();
    void updateFlight(Flight flight);
    void deleteFlight(int id);
}
