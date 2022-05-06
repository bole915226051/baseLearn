package jxls;

import jxls.tool.JxlsUtils;
import org.apache.commons.collections.CollectionUtils;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * 测试jxls循环嵌套
 */
public class Demo {
    private static void createField(Map<String, Object> model) {
        List<Field> threeField = new ArrayList<Field>() {{
            add(new Field("一月", "month_1", new ArrayList<Field>()));
            add(new Field("二月", "month_2", new ArrayList<Field>()));
            add(new Field("三月", "month_3", new ArrayList<Field>()));
            add(new Field("四月", "month_4", new ArrayList<Field>()));
        }};

        List<Field> twoField = new ArrayList<Field>() {{
            add(new Field("普", "", threeField));
            add(new Field("金", "Com", threeField));
            add(new Field("白", "Gold", threeField));
            add(new Field("总量", "Pla", threeField));
        }};

        List<Field> oneField = new ArrayList<Field>() {{
            add(new Field("发卡", "issue", twoField));
            add(new Field("新客", "account", twoField));
            add(new Field("首刷", "swipe", twoField));
            add(new Field("成交量", "deal", threeField));
        }};

        List<Report> reports = new ArrayList<Report>() {{
            add(new Report("日报表", "day", oneField));
            add(new Report("月报表", "month", oneField));
            add(new Report("年报表", "year", oneField));
        }};
        model.put("title", reports);
        model.put("orderFieldList", orderFieldList(reports));
        model.put("maxHeight", getHeight(reports));


    }

    private static void createUser(Map<String, Object> model) {
        Map<String, FieldValue> map = new HashMap<>();
        map.put("day_issue__month_1", new FieldValue("day_issue__month_1", "111"));
        map.put("day_issue__month_2", new FieldValue("day_issue__month_2", "222"));
        map.put("day_issue__month_4", new FieldValue("day_issue__month_4", "444"));

        List<User> users = new ArrayList<User>() {{
            add(new jxls.User("李源青", map));
            add(new jxls.User("李源青1", map));
            add(new jxls.User("李源青2", map));
            add(new jxls.User("李源青3", map));
        }};
        model.put("data", users);
    }

    public static void main(String[] args) throws Exception {
        String templatePath = "/Users/liyuanqing/Downloads/poiDemo.xlsx";
        OutputStream os = new FileOutputStream("/Users/liyuanqing/Downloads/demo1.xlsx");

        /**
         * 3张报表,最多有三层嵌套循环表示
         */

        Map<String, Object> model = new HashMap<String, Object>();
        //  创建字段
        createField(model);
        //  创建用户
        createUser(model);

        JxlsUtils.exportExcel(templatePath, os, model);
        os.close();
        System.out.println("完成");
    }

    private static List<String> orderFieldList(List<Report> reports) {
        List<String> list = new ArrayList<>();
        for (Report report : reports) {
            for (Field field : report.getFields()) {
                //  给自己起名
                field.setFieldEnName(report.getReportEnName() + "_" + field.getFieldEnName());
                orderFieldList(list, field);
            }
        }
        return list;
    }

    private static void orderFieldList(List<String> list, Field field) {
        for (Field fieldSon : field.getFields()) {
            //  给自己起名
            fieldSon.setFieldEnName(field.getFieldEnName() + "_" + fieldSon.getFieldEnName());
            if (CollectionUtils.isEmpty(fieldSon.getFields())) {
                list.add(fieldSon.getFieldEnName());
            } else {
                orderFieldList(list, fieldSon);
            }
        }
    }


    public static int getHeight(List<Report> reports) {
        int[] arr = new int[reports.size()];
        for (int i = 0; i < reports.size(); i++) {
            arr[i] = getHeight(reports.get(i));
        }
        return Arrays.stream(arr).max().getAsInt();

    }

    public static int getHeight(Report report) {
        int maxHeight = 0;
        if (CollectionUtils.isEmpty(report.getFields())) {
            return 1;
        }
        for (Field field : report.getFields()) {
            int currentHeight = getHeight(field);
            if (currentHeight > maxHeight) {
                maxHeight = currentHeight;
            }
        }
        return ++maxHeight;
    }

    public static int getHeight(Field field) {
        int maxHeight = 0;
        if (CollectionUtils.isEmpty(field.getFields())) {
            return 1;
        }
        for (Field son : field.getFields()) {
            int currentHeight = getHeight(son);
            if (currentHeight > maxHeight) {
                maxHeight = currentHeight;
            }
        }
        return ++maxHeight;

    }

}



