package az.iktlab.service;

import az.iktlab.dto.FlightDto;
import az.iktlab.model.Flight;

import java.util.List;

public interface FlightService {
    List<Flight> getAllFlightsFromKiev();
    Flight getFlightById(Integer id);
    List<Flight> getAllFlightsByDestinationAndTimeAndCount(FlightDto flightDto);
    void insertFlight(Flight flight);
}
