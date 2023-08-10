package com.bestrookie.interfaces;

import com.bestrookie.application.IActivityService;
import com.bestrookie.domain.activity.model.ActivityListReq;
import com.bestrookie.domain.activity.model.QueryPageRes;
import com.bestrookie.infrastructure.common.EasyResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author bestrookie
 * @Date 2023/8/10 09:35
 * @Desc 活动管理
 */
@RestController("api/activity")
public class ActivityController {
    private final Logger logger = LoggerFactory.getLogger(ActivityController.class);

    @Resource
    private IActivityService activityService;

    @PostMapping("/page")
    public EasyResult queryActivityListPage(@RequestBody QueryPageRes queryPageRes){
        int page = queryPageRes.getPage();
        int rows = queryPageRes.getRows();
        try {
            logger.info("查询活动列表数据 page:{} rows:{}",page, rows);
            ActivityListReq req = new ActivityListReq(page, rows);
            req.setErpId("rookie");
            return activityService.queryActivityListPage(req);

        }catch (Exception e){
            logger.error("查询活动列表数据失败 page:{} row:{}", page, rows);
            return EasyResult.buildEasyResultError(e);
        }
    }


}
