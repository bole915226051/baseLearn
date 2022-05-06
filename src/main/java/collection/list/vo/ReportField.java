package collection.list.vo;

import lombok.Data;

@Data
public class ReportField {
    private String fieldName;
    private String value;

    public ReportField(String fieldName, String value) {
        this.fieldName = fieldName;
        this.value = value;
    }
}
