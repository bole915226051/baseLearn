package jxls;

import lombok.Data;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

@Data
public class Report {
    private String reportName;
    private String reportEnName;

    private List<Field> fields;

    public Report(String reportName, String reportEnName, List<Field> fields) {
        this.reportName = reportName;
        this.reportEnName = reportEnName;
        this.fields = fields;

    }

    public Report() {

    }


    /**
     * jxls的合并行
     */
    private int mergeCols;

    public int getJxlsMergeCols() {
        this.mergeCols = 0;
        if (CollectionUtils.isEmpty(this.fields)) {
            return mergeCols;
        }
        for (Field field : fields) {
            field.setFieldEnName(this.reportEnName + "_" + field.getFieldEnName());
            this.getJxlsMergeCols(field);
        }
        return mergeCols;
    }

    private void getJxlsMergeCols(Field field) {
        if (CollectionUtils.isEmpty(field.getFields())) {
            mergeCols++;
        } else {
            for (Field fieldSon : field.getFields()) {
                fieldSon.setFieldEnName(field.getFieldEnName() + fieldSon.getFieldEnName());
                this.getJxlsMergeCols(fieldSon);
            }
        }
    }
}
