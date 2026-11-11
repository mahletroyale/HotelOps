import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    public class RoomTest {

        @Test
        void checkInRoom() {

            // arrange
            Room room = new Room(2, 124.00, false, false);
            boolean expectedOccupied = true;
            boolean expectedDirty = true;

            // act
            room.checkIn();

            // assert
            assertEquals(expectedOccupied, room.isOccupied());
            assertEquals(expectedDirty, room.isDirty());
        }

        @Test
        void checkInOccupiedRoom() {

            // arrange
            Room room = new Room(2, 124.00, true, false);
            boolean expected = true;

            // act
            room.checkIn();

            // assert
            assertEquals(expected, room.isOccupied());
        }

        @Test
        void checkInDirtyRoom() {

            // arrange
            Room room = new Room(2, 124.00, false, true);
            boolean expected = false;

            // act
            room.checkIn();

            // assert
            assertEquals(expected, room.isOccupied());
        }

        @Test
        void checkOutRoom() {

            // arrange
            Room room = new Room(2, 124.00, true, true);
            boolean expectedOccupied = false;
            boolean expectedDirty = true;

            // act
            room.checkOut();

            // assert
            assertEquals(expectedOccupied, room.isOccupied());
            assertEquals(expectedDirty, room.isDirty());
        }

        @Test
        void cleanRoom() {

            // arrange
            Room room = new Room(2, 124.00, false, true);
            boolean expected = false;

            // act
            room.cleanRoom();

            // assert
            assertEquals(expected, room.isDirty());
        }

        @Test
        void cleanOccupiedRoom() {

            // arrange
            Room room = new Room(2, 124.00, true, true);
            boolean expected = true;

            // act
            room.cleanRoom();

            // assert
            assertEquals(expected, room.isDirty());
        }
    }


