
public class Hotel {

    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    public Hotel(String name, int numberOfSuites,
                 int numberOfRooms) {

        this(name, numberOfSuites, numberOfRooms, 0, 0);
    }

    public Hotel(String name, int numberOfSuites,
                 int numberOfRooms, int bookedSuites,
                 int bookedBasicRooms) {

        if (numberOfSuites < 0 || numberOfRooms < 0 ||
                bookedSuites < 0 || bookedBasicRooms < 0 ||
                bookedSuites > numberOfSuites ||
                bookedBasicRooms > numberOfRooms) {

            throw new IllegalArgumentException(
                    "Invalid hotel room counts."
            );
        }

        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfSuites() {
        return numberOfSuites;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getBookedSuites() {
        return bookedSuites;
    }

    public int getBookedBasicRooms() {
        return bookedBasicRooms;
    }

    public int getAvailableSuites() {
        return numberOfSuites - bookedSuites;
    }

    public int getAvailableRooms() {
        return numberOfRooms - bookedBasicRooms;
    }

    public boolean bookRoom(int roomCount, boolean suite) {

        if (roomCount <= 0) {
            return false;
        }

        if (suite) {

            if (roomCount <= getAvailableSuites()) {
                bookedSuites += roomCount;
                return true;
            }

        } else {

            if (roomCount <= getAvailableRooms()) {
                bookedBasicRooms += roomCount;
                return true;
            }
        }

        return false;
    }
}

