package az.iktlab;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class StartApplication {


    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();


        try {
            FlightData flightData = objectMapper.readValue(new File("Docs/flights.json"), FlightData.class);


            FlightRepositoryImpl flightRepository = new FlightRepositoryImpl();
            for (Flight flight : flightData.getFlights()) {
                flightRepository.insertFlight(flight);
            }

            System.out.println("Data insertion completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
