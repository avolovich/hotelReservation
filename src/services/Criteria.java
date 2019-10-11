package services;

public class Criteria {

    enum Field {
        PRICE,
        ROOM_TYPE
    }

    private Field field; // could be guest, availability, roomType
    private String value; // the value of the field

    public Criteria(Field field, String value) {
        this.field = field;
        this.value = value;
    }
}
