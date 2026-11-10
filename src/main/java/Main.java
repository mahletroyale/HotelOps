


public class Main {

    public static void main(String[] args) {

        System.out.println("=== EMPLOYEE TEST ===");

        Employee employee = new Employee(
                101, "Sarah", "Front Desk", 20.00, 0
        );

        employee.punchIn(9);
        employee.punchOut(17);

        System.out.println("Total Pay: $" +
                employee.getTotalPay());

        System.out.println("\n=== CURRENT TIME TEST ===");

        employee.punchIn();
        employee.punchOut();


        System.out.println("\n=== HOTEL TEST ===");
        Hotel hotel = new Hotel("Sunset Hotel", 5, 10);

        System.out.println("Hotel: " + hotel.getName());
        System.out.println("Available Suites: " + hotel.getAvailableSuites());
        System.out.println("Available Basic Rooms: " + hotel.getAvailableRooms());

        boolean suiteBooking = hotel.bookRoom(2, true);
        System.out.println("Suite Booking: " + suiteBooking);
        boolean roomBooking = hotel.bookRoom(3, false);

        System.out.println("Basic Room Booking: " + roomBooking);
        System.out.println("Remaining Suites: " + hotel.getAvailableSuites());
        System.out.println("Remaining Basic Rooms: " + hotel.getAvailableRooms());

        boolean failedBooking = hotel.bookRoom(10, true);
        System.out.println("Booking 10 Suites: " + failedBooking);



        Hotel hotel2 = new Hotel("Ocean View Hotel", 8, 15, 3, 5);

        System.out.println("Hotel: " + hotel2.getName());
        System.out.println("Available Suites: " + hotel2.getAvailableSuites());
        System.out.println("Available Basic Rooms: " + hotel2.getAvailableRooms());
    }
}
