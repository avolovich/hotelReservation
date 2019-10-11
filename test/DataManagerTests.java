import org.testng.Assert;
import org.testng.annotations.Test;
import entity.*;
import org.testng.asserts.SoftAssert;
import services.DataManager;

import javax.xml.crypto.Data;

public class DataManagerTests {

    @Test
    public static void getExistingRoomIsNotNull(){
        // Arrange
        DataManager.addRoom("15",RoomType.KING_ROOM,50.0);
        //Act
        Room rm = DataManager.getRoomByNumber("15");
        //Assert
        Assert.assertNotNull(rm);
    }

    @Test
    public static void getNotExistingRoomIsNull(){
        // Arrange
        DataManager.addRoom("15",RoomType.KING_ROOM,50.0);
        //Act
        Room rm = DataManager.getRoomByNumber("16");
        //Assert
        Assert.assertNull(rm);
    }

    @Test
    public static void getRoomDataSoftAssertion(){
        // Arrange
        DataManager.addRoom("4A",RoomType.DOUBLE_QUEEN_ROOM,1256.0, 6);

        //Act
        Room room = DataManager.getRoomByNumber("4A");
        String roomNumber = room.getNumber();
        RoomType roomType = room.getType();
        double price = room.getPrice();
        int reservationId = room.getReservationId();

        //Assert
        SoftAssert sa = new SoftAssert();
        System.out.println("Assert Room Number");
        sa.assertEquals(roomNumber, "4A");
        System.out.println("Assert Room Type");
        sa.assertEquals(roomType, RoomType.DOUBLE_QUEEN_ROOM);
        System.out.println("Assert Room Price");
        sa.assertEquals(price, 1256.0);
        System.out.println("Assert Reservation Id");
        sa.assertEquals(reservationId, 6);
        sa.assertAll();
    }

    // getExistingUserNotNull
    // getNotExistingUserIsNull
    // getUserDataSoftAssertion
    // getExistingReservationNotNull
    // getNotExistingReservationIsNull
    // getReservationDataSoftAssertion

}

