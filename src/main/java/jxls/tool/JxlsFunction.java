package jxls.tool;

import jxls.Report;
import org.apache.commons.collections.CollectionUtils;
import org.jxls.transform.poi.WritableCellValue;

import java.util.List;

/**
 * 绘制xlsx的单元格
 */
public class JxlsFunction {
    /**
     * 绘制title
     *
     * @param reports
     */
    public WritableCellValue drawCell(Report reports) {
        return new WritableCell(reports);
    }


    /**
     * 绘制data
     */


}
