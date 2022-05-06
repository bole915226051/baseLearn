package basic;

import org.springframework.data.domain.Sort;

public class TestEnum {
    SortEnum sortEnumA = SortEnum.A;
    SortEnum sortEnumB = SortEnum.B;
}

enum SortEnum       {
    A("a", "A"),
    B("b", "B"),
    ;

    SortEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private String code;
    private String value;
}
