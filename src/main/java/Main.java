


public class Main {

    public static void main(String[] args) {


        Room room = new Room(2, 124.00, false, false);

        System.out.println("ROOM");
        System.out.println("Beds: " + room.getNumberOfBeds());
        System.out.println("Available: " + room.isAvailable());

        Reservation reservation = new Reservation("king", 3, true);

        System.out.println("\nRESERVATION");
        System.out.println("Room: " + reservation.getRoomType());
        System.out.println("Price per night: $" + reservation.getPrice());
        System.out.println("Total: $" + reservation.getReservationTotal());

        Employee employee = new Employee(101, "Sarah", "Front Desk", 20.00, 45);

        System.out.println("\nEMPLOYEE");
        System.out.println("Name: " + employee.getName());
        System.out.println("Regular Hours: " + employee.getRegularHours());
        System.out.println("Overtime Hours: " + employee.getOvertimeHours());
        System.out.println("Total Pay: $" + employee.getTotalPay());
    }
}
