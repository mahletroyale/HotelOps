



public class Main {

    public static void main(String[] args) {

        System.out.println("=== ROOM TEST ===");

        Room room = new Room(2, 124.00, false, false);

        System.out.println("Available: " + room.isAvailable());

        room.checkIn();
        System.out.println("Available: " + room.isAvailable());

        room.checkOut();
        System.out.println("Available: " + room.isAvailable());

        room.cleanRoom();
        System.out.println("Available: " + room.isAvailable());


        System.out.println("\n=== EMPLOYEE TEST ===");

        Employee employee = new Employee(
                101, "Sarah", "Front Desk", 20.00, 0
        );

        employee.punchIn(9);
        employee.punchOut(17);

        System.out.println("Regular Hours: " + employee.getRegularHours());

        System.out.println("Overtime Hours: " + employee.getOvertimeHours());

        System.out.println("Total Pay: $" + employee.getTotalPay());

        employee.punchTimeCard(10);
        employee.punchTimeCard(14);

        System.out.println("Updated Hours: " + employee.getHoursWorked());
    }
}
