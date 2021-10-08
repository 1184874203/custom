package com.custom.constants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;

/**
 * @author: 邵禹寒
 * @date: 2021-09-23 09:33
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Result {
    private Integer code;
    private String message;
    private Object data;

    public static Result success(Object data) {
        return Result.builder()
                .code(200)
                .message("成功！")
                .data(data)
                .build();
    }

}
