package az.iktlab.dao.impl;

import az.iktlab.dao.FlightRepository;
import az.iktlab.dao.connection.JDBCConnection;
import az.iktlab.dto.FlightDto;
import az.iktlab.model.Flight;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FlightDaoImpl implements FlightRepository {
    private Flight getFlight(ResultSet rs) {
        try {
            Long id = (long) rs.getInt("id");
            String flightNumber = rs.getString("flightnumber");
            String airline = rs.getString("airline");
            String destination = rs.getString("destination");
            String departureCity = rs.getString("departurecity");
            Time timestamp = rs.getTime("departuretime");
            Date departureTime = new Date(timestamp.getTime());
            Time timestamp1 = rs.getTime("arrivaltime");
            Date arrivalTime = new Date(timestamp1.getTime());
            String gate = rs.getString("gate");
            String terminal = rs.getString("terminal");
            String status = rs.getString("status");
            String checkInCounter = rs.getString("checkincounter");
            Time timestamp2 = rs.getTime("boardingtime");
            Date boardingTime = new Date(timestamp2.getTime());
            return new Flight(id,flightNumber, airline, destination, departureCity, departureTime, arrivalTime, gate, terminal, status, checkInCounter, boardingTime);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Flight> getAllFlightsFromKiev() {
        List<Flight> list = new ArrayList<>();
        try {
            Statement stmt = JDBCConnection.getInstance().getConnection().createStatement();
            stmt.execute("SELECT *\n" +
                    "FROM flight WHERE departuretime > current_date and departuretime<current_date + interval '1 day'");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                Flight flight = getFlight(rs);
                list.add(flight);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return list;
    }

    @Override
    public Flight getFlightById(Integer id) {
        Flight flight = null;
        try {
            Statement stmt = JDBCConnection.getInstance().getConnection().createStatement();

            stmt.execute("select *from flight where id=" + id);
            ResultSet rs = stmt.getResultSet();
            while (rs.next())
                flight = getFlight(rs);
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flight;
    }

    @Override
    public List<Flight> getAllFlightsByDestinationAndTimeAndCount(FlightDto flightDto) {
        List<Flight>list = new ArrayList<>();
        try {
            Statement stmt = JDBCConnection.getInstance().getConnection().createStatement();
            String query = "select *from flight where destination='" + flightDto.getDestination()+"'and departuretime='"+flightDto.getDate()+"';";
            stmt.execute(query);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()){
                String count = rs.getString("checkincounter");
                int num = Integer.parseInt(count.split(" ")[1]);
                if (flightDto.getCountOfPeople()<num){
                    Flight flight = getFlight(rs);
                    list.add(flight);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void insertFlight(Flight flight) {
        String insertQuery = "INSERT INTO flight (flightNumber, airline, destination, departureCity, departureTime, arrivalTime, gate, terminal, status, checkInCounter, boardingTime) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = JDBCConnection.getInstance().getConnection().prepareStatement(insertQuery);

            preparedStatement.setString(1, flight.getFlightNumber());
            preparedStatement.setString(2, flight.getAirline());
            preparedStatement.setString(3, flight.getDestination());
            preparedStatement.setString(4, flight.getDepartureCity());
            preparedStatement.setTimestamp(5, new Timestamp(flight.getDepartureTime().getTime()));
            preparedStatement.setTimestamp(6, new Timestamp(flight.getArrivalTime().getTime()));
            preparedStatement.setString(7, flight.getGate());
            preparedStatement.setString(8, flight.getTerminal());
            preparedStatement.setString(9, flight.getStatus());
            preparedStatement.setString(10, flight.getCheckInCounter());
            preparedStatement.setTimestamp(11, new Timestamp(flight.getBoardingTime().getTime()));

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
