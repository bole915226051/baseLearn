package jxls;

import lombok.Data;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

@Data
public class Field {
    // 字段名字
    private String fieldName;
    // 字段变量名称
    private String fieldEnName;

    // 二级字段名称
    private List<Field> fields;


    public Field() {
    }

    public Field(String fieldName, String fieldEnName, List<Field> fields) {
        this.fieldName = fieldName;
        this.fieldEnName = fieldEnName;
        this.fields = fields;
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
            this.getJxlsMergeCols(field);
        }
        return mergeCols;
    }

    private void getJxlsMergeCols(Field field) {
        if (CollectionUtils.isEmpty(field.getFields())) {
            mergeCols++;
        } else {
            for (Field fieldSon : field.getFields()) {
                this.getJxlsMergeCols(fieldSon);
            }
        }
    }

}
