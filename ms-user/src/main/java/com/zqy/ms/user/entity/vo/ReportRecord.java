package com.zqy.ms.user.entity.vo;

import java.util.Date;

/**
 * <p>
 * 报表图表
 * </p>
 *
 * @author Jadin
 * @since 2019-04-18
 */
public class ReportRecord {
    private static final long serialVersionUID = 1L;

    //时间序列，如2019-01-01
    private String timeSeries;

    //值
    private Integer count;

    //统计的开始时间，按照此字段查询和排序
    private Date beginTime;

    //统计的结束时间
    private Date endTime;

    //执行时间
    private Date exeTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTimeSeries() {
        return timeSeries;
    }

    public void setTimeSeries(String timeSeries) {
        this.timeSeries = timeSeries;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getExeTime() {
        return exeTime;
    }

    public void setExeTime(Date exeTime) {
        this.exeTime = exeTime;
    }
}
