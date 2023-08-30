package az.iktlab.dto;

import az.iktlab.dao.FlightRepository;
import az.iktlab.dao.impl.FlightDaoImpl;
import az.iktlab.model.Flight;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class FlightDto {
    private List<Flight> flights;
    private String destination;
    private String date;
    private int countOfPeople;

    public FlightDto() {

    }

    public FlightDto(List<Flight> flights) {
        this.flights = flights;
    }

    public FlightDto(String destination, String date, int countOfPeople) {
        this.destination = destination;
        this.date = date;
        this.countOfPeople = countOfPeople;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCountOfPeople() {
        return countOfPeople;
    }

    public void setCountOfPeople(int countOfPeople) {
        this.countOfPeople = countOfPeople;
    }
}
