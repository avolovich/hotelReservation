package services;

public class CriteriaFactory {

    CriteriaFactory() {
        // nothing here
    }

    public static Criteria create(String field, String value) {
        if (field.equals("price")) {
            return new Criteria(Criteria.Field.PRICE, value);
        } else if (field.equals("room_type")){
            return new Criteria(Criteria.Field.ROOM_TYPE, value);
        }
        else return  null;
    }
}
