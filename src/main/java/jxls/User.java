package jxls;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class User {
    private String userName;
    private Map<String, FieldValue> fieldValueMap;

    public User(String userName, Map<String, FieldValue> fieldValueMap) {
        this.userName = userName;
        this.fieldValueMap = fieldValueMap;
    }
}
