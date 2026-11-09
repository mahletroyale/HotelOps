


public class Reservation {
    private String roomType;
    private int numberOfNights;
    private boolean weekend;


    public Reservation(String roomType, int numberOfNights,  boolean weekend) {
        setRoomType(roomType);
        setNumberOfNights(numberOfNights);
        this.weekend = weekend;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        if (roomType.equalsIgnoreCase("king") || roomType.equalsIgnoreCase("double")) {
            this.roomType = roomType.toLowerCase();
        } else {
            throw new IllegalArgumentException(
                    "Room type must be king or double."
            );
        }
    }

    public double getPrice() {

        double price;
        if (roomType.equals("king")) {
            price = 139.00;
        } else {
            price = 124.00;
        }
        if (weekend) {
            price = price * 1.1;
        }
        return price;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        if (numberOfNights > 0) {
            this.numberOfNights = numberOfNights;
        } else {
            throw new IllegalArgumentException(
                    "Number of nights must be positive."
            );
        }
    }

    public boolean isWeekend() {
        return weekend;
    }

    public void setWeekend(boolean weekend) {
        this.weekend = weekend;
    }

    public double getReservationTotal() {
        return getPrice() * numberOfNights;
    }
}
