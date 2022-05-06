package collection.list;

import collection.list.vo.Field;
import collection.list.vo.ReportField;
import org.apache.commons.collections.ListUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * List,根据对象中某个字段,进行合并。
 */
public class ListMerge {
    public static void main(String[] args) {
        ReportField reportField1 = new ReportField("access", "222");
        ReportField reportField2 = new ReportField("access", "222");
        ReportField reportField3 = new ReportField("access", "222");
        ReportField reportField4 = new ReportField("access", "222");

        LinkedList<ReportField> linkedList1 = new LinkedList<>();
        linkedList1.add(reportField1);
        linkedList1.add(reportField2);

        LinkedList<ReportField> linkedList2 = new LinkedList<>();
        linkedList1.add(reportField3);
        linkedList1.add(reportField4);

        Field field1 = new Field("111", linkedList1);
        Field field2 = new Field("111", linkedList2);

        List<Field> fields = new ArrayList<Field>() {{
            add(field1);
            add(field2);
        }};

        Map<String, Field> map = new HashMap<>();
        for (Field field : fields) {
            if (map.containsKey(field.getId())) {
                Field tmp = map.get(field.getId());
                //  将另外一个元素的对象,追加给已经存在的元素
                tmp.getReportFields().addAll(field.getReportFields());
            } else {
                map.put(field.getId(), field);
            }
        }
        fields = map.values().stream().collect(Collectors.toList());
        System.out.println(fields.get(0).getReportFields().size());
    }
}
