package com.zfans.bmsdemo.ret;

import lombok.Getter;
import lombok.ToString;

/**
 * @author Zfans
 */
@Getter
@ToString
public enum ResultCodeEnum {

    SUCCESS(true, 20000, "成功"),
    UNKNOWN_REASON(false, 20001, "未知错误"),

    BAD_SQL_GRAMMAR(false, 21001, "sql语法错误"),
    JSON_PARSE_ERROR(false, 21002, "json解析异常"),
    PARAM_ERROR(false, 21003, "参数不正确"),

    CATEGORY_ABSENT(false, 22001, "图书类型不存在"),
    UNABLE_TO_REMOVE_DEPENDENCIES(false, 22002, "存在依赖关系，无法删除");


    private Boolean success;

    private Integer code;

    private String message;

    ResultCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
