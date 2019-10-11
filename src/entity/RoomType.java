package entity;

public enum RoomType {

    KING_ROOM("King Room"), QUEEN_ROOM("Queen Room"),  DOUBLE_QUEEN_ROOM("Double Queen Room"),  DOUBLE_FULL_ROOM("Double Full Room");

    private String roomTypeName;

    RoomType(String roomType) {
        roomTypeName = roomType;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }


}
