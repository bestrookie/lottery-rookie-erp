package com.bestrookie.domain.activity.model;

import com.bestrookie.lottery.common.PageRequest;

/**
 * @Author bestrookie
 * @Date 2023/8/8 17:02
 * @Desc 活动列表请求
 */
public class ActivityListReq extends PageRequest {
    /**
     * erp id，记录谁在操作
     */
    private String erpId;

    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 活动名称
     */
    private String activityName;

    public ActivityListReq(int page, int rows) {
        super(page, rows);
    }

    public ActivityListReq(String page, String rows) {
        super(page, rows);
    }

    public String getErpId() {
        return erpId;
    }

    public void setErpId(String erpId) {
        this.erpId = erpId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
}
