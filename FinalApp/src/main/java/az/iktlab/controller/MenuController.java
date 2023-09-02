package az.iktlab.controller;

import az.iktlab.constants.Menu;
import az.iktlab.dto.FlightDto;
import az.iktlab.model.Flight;
import az.iktlab.model.User;
import az.iktlab.util.ScannerUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static az.iktlab.util.ScannerUtil.getMenu;

public class MenuController {
    private final FlightController flightRepository = new FlightController();
    private final UserController userRepository = new UserController();
    private final BookController bookRepository = new BookController();
    public  void selectMenu(){

        boolean ff=true;
        while (ff){
            showMenu();
            var index = getMenu();
            switch (index){
                case 1->{
                    System.out.println(flightRepository.getAllFlightsFromKiev());
                }
                case 2->{
                   int n =ScannerUtil.getFlightId();
                    System.out.println(flightRepository.getFlightById(n));
                }
                case 3->{
                    FlightDto flightDto =  ScannerUtil.getFlightData();
                    List<Flight>list = flightRepository.getAllFlightsByDestinationAndTimeAndCount(flightDto);
                   if (list== null){
                       System.out.println("there is not flight!!");
                   }else {
                       System.out.println(list);
                       System.out.println("Do you want add a booking 0/1");
                       int num = ScannerUtil.geNum();
                       if (num==1){
                           User user = ScannerUtil.getUser();
                           int flyID = ScannerUtil.getFlightId();
                           userRepository.insertUser(user);
                           User user1 = userRepository.getByNameAndSurname(user.getName(), user.getSurname());
                           bookRepository.addBook(user1.getId(),flyID);

                       }
                   }
                }
                case 4->{
                    int FlightId = ScannerUtil.getFlightId();
                    if (bookRepository.cancelBook(FlightId)) {
                        System.out.println("Booking canceled successfully.");
                    } else {
                        System.out.println("Booking not found or could not be canceled.");
                    }
                }
                case 5->{
                    String fullName = ScannerUtil.getFullName();
                    List<Map<String, Object>> userBookings = bookRepository.getBookingsByUserFullName(fullName);

                    if (userBookings.isEmpty()) {
                        System.out.println("No bookings found for the user.");
                    } else {
                        System.out.println("User's bookings:");
                        for (Map<String, Object> bookingInfo : userBookings) {
                            System.out.println("Booking ID: " + bookingInfo.get("booking_id"));
                            System.out.println("User ID: " + bookingInfo.get("user_id"));
                            System.out.println("Flight ID: " + bookingInfo.get("flight_id"));
                            System.out.println();
                        }
                    }
                }
                case 6->ff=false;
                default -> System.out.println("ENTER VALID COMMAND");
            }
        }
    }
    private void showMenu() {
        Arrays.stream(Menu.values())
                .forEach(it -> System.out.printf("%d-%s\n", it.getIndex(), it.getDescription()));
    }
}
