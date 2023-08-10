package com.bestrookie.application;

import com.bestrookie.domain.activity.model.ActivityListReq;
import com.bestrookie.infrastructure.common.EasyResult;

/**
 * @Author bestrookie
 * @Date 2023/8/8 17:11
 * @Desc 活动服务接口
 */
public interface IActivityService {
    /**
     * 查询活动后分页数据
     * @param req 入参
     * @return 结果
     */
    EasyResult queryActivityListPage(ActivityListReq req);
}
