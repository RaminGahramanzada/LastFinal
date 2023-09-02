package az.iktlab.dao;

import az.iktlab.dto.FlightDto;
import az.iktlab.model.Flight;

import java.util.List;

public interface FlightRepository {
    List<Flight> getAllFlightsFromKiev();
    Flight getFlightById(Integer id);
    List<Flight> getAllFlightsByDestinationAndTimeAndCount(FlightDto flightDto);
    void insertFlight(Flight flight);
}
