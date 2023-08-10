package com.bestrookie.domain.activity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author bestrookie
 * @Date 2023/8/10 15:44
 * @Desc 分页请求参数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryPageRes {
    int page;
    int  rows;
}
