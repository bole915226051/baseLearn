package jxls;

import lombok.Data;

@Data
public class FieldValue {
    private String fieldEnName;
    private String fieldValue;

    public FieldValue(String fieldEnName, String fieldValue) {
        this.fieldEnName = fieldEnName;
        this.fieldValue = fieldValue;
    }
}
