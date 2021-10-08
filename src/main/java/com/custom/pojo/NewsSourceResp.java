package com.custom.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 外部源数据接口的返回体
 *
 * @author: 邵禹寒
 * @date: 2021-09-17 10:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewsSourceResp {
    private int pageNum;
    private int pageSize;
    private int totalRecordCount;
    private int totalPageCount;
    private List<NewResp> data;
}
