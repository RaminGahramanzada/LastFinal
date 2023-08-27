package az.iktlab.bookingapp.dao.repository;

import az.iktlab.bookingapp.dao.entity.Flight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class FlightRepositoryImpl implements FlightRepository {

    @Override
    public void insertFlight(Flight flight) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String jdbcUrl = "jdbc:postgresql://localhost:5432/BookFlight";
            String username = "postgres";
            String password = "12345";


            connection = DriverManager.getConnection(jdbcUrl, username, password);

            String insertQuery = "INSERT INTO flight (flightNumber, airline, destination, departureCity, departureTime, arrivalTime, gate, terminal, status, checkInCounter, boardingTime) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setString(1, flight.getFlightNumber());
            preparedStatement.setString(2, flight.getAirline());
            preparedStatement.setString(3, flight.getDestination());
            preparedStatement.setString(4, flight.getDepartureCity());
            preparedStatement.setTimestamp(5, new java.sql.Timestamp(flight.getDepartureTime().getTime()));
            preparedStatement.setTimestamp(6, new java.sql.Timestamp(flight.getArrivalTime().getTime()));
            preparedStatement.setString(7, flight.getGate());
            preparedStatement.setString(8, flight.getTerminal());
            preparedStatement.setString(9, flight.getStatus());
            preparedStatement.setString(10, flight.getCheckInCounter());
            preparedStatement.setTimestamp(11, new java.sql.Timestamp(flight.getBoardingTime().getTime()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Flight getFlightById(int id) {
        return null;
    }

    @Override
    public List<Flight> getAllFlights() {
        return null;
    }

    @Override
    public void updateFlight(Flight flight) {

    }

    @Override
    public void deleteFlight(int id) {

    }
}
