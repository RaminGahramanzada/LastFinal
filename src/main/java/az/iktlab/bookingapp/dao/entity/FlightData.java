package az.iktlab.bookingapp.dao.entity;

import java.util.List;

public class FlightData {
    private List<Flight> flights;

    public FlightData() {

    }

    public FlightData(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}
