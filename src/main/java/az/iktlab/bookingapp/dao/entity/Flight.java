package az.iktlab.bookingapp.dao.entity;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class Flight {
    private long flightId;
    private Date date;
    private Time time;
    private String destination;
    private int seats;
    private int fullSeats;
    private List<Book> bookList;

    public Flight(long flightId) {
        this.flightId = flightId;
    }

    public Flight(long flightId, Date date, Time time, String destination, int seats, int fullSeats, List<Book> bookList) {
        this.flightId = flightId;
        this.date = date;
        this.time = time;
        this.destination = destination;
        this.seats = seats;
        this.fullSeats = fullSeats;
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", date=" + date +
                ", time=" + time +
                ", destination='" + destination + '\'' +
                ", seats=" + seats +
                ", fullSeats=" + fullSeats +
                ", bookList=" + bookList +
                '}';
    }
}
