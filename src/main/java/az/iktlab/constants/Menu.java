package az.iktlab.constants;

public enum Menu {
    ONLINE_BOARD(1,"Online-board"),
    SHOW_THE_FLIGHT_INFO(2,"Show the flight info"),
    SEARCH_AND_BOOK_FLIGHT(3,"Search and book a flight"),
    CANCEL_THE_BOOKING(4,"Cancel the booking"),
    MY_FLIGHTS(5,"My flights"),
    EXIT(6,"Exit");
    private final int index;
    private final String description;
    Menu(int index,String description){
        this.index =index;
        this.description = description;
    }

    public int getIndex() {
        return index;
    }

    public String getDescription() {
        return description;
    }
}
