package com.bestrookie.domain.activity.service;

import com.bestrookie.application.IActivityService;
import com.bestrookie.domain.activity.model.ActivityListReq;
import com.bestrookie.infrastructure.common.EasyResult;
import com.bestrookie.lottery.common.Constants;
import com.bestrookie.rpc.deploy.ILotteryActivityDeploy;
import com.bestrookie.rpc.deploy.req.ActivityPageReq;
import com.bestrookie.rpc.deploy.res.ActivityRes;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @Author bestrookie
 * @Date 2023/8/8 17:16
 * @Desc 活动服务
 */
@Service
public class ActivityServiceImpl implements IActivityService {
    @DubboReference(interfaceClass = ILotteryActivityDeploy.class)
    private ILotteryActivityDeploy activityDeploy;


    @Override
    public EasyResult queryActivityListPage(ActivityListReq req) {
        //1.组装参数
        ActivityPageReq activityPageReq = new ActivityPageReq(req.getPage(), req.getRows());
        activityPageReq.setErpId(req.getErpId());
        activityPageReq.setActivityId(req.getActivityId());
        activityPageReq.setActivityName(req.getActivityName());

        //2.查询数据
        ActivityRes activityRes = activityDeploy.queryActivityListByPageForErp(activityPageReq);
        //3.封装结果
        if (Constants.ResponseCode.SUCCESS.getCode().equals(activityRes.getResult().getCode())){
            return EasyResult.buildEasyResultSuccess(activityRes.getCount(), activityRes.getActivityDTOList());
        }else {
            return EasyResult.buildEasyResultError(activityRes.getResult().getCode());
        }
    }
}
