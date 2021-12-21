package timer.main.adapter;

import timer.main.context.LimitingGroupObject;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/12/20 14:08
 * @Description:
 **/
public class LimitingGroupAdapter {

    public static LimitingGroupObject getLimitingGroup(timer.main.ano.LimitingGroup limitingGroup) {
        return new LimitingGroupObject()
                .setGroup(limitingGroup.group())
                .setPartitionEnum(limitingGroup.partitionEnum())
                .setTime(limitingGroup.time())
                .setTimeUnit(limitingGroup.timeUnit())
                .setCode(limitingGroup.code())
                .setPermitsPerTime(limitingGroup.permitsPerTime());
    }

}
