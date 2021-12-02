package org.checkpoint.adapter;

import org.checkpoint.pojo.AccountInfo;
import org.checkpoint.pojo.InspectInfo;
import org.checkpoint.pojo.PassProof;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/30 15:19
 * @Description: 认证的扩展支持
 **/
public interface AuthAdapter<A extends AccountInfo> {

    /**
     * 认证
     *
     * @param inspectInfo
     * @return 是否通过认证
     */
    boolean inspect(InspectInfo inspectInfo);

    /**
     * 获取用户信息
     *
     * @param t
     * @return
     */
    A getAccountInfo(InspectInfo t);


}
