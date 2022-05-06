package collection.list.vo;

import lombok.Data;

import java.util.LinkedList;

@Data
public class Field {
    /**
     * 可能是userId,可能是teamId,可能是BankId
     */
    private String id;

    private LinkedList<ReportField> reportFields;

    public Field(String id, LinkedList<ReportField> reportFields) {
        this.id = id;
        this.reportFields = reportFields;
    }
}
