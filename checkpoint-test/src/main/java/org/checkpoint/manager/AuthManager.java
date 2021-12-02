package org.checkpoint.manager;

import org.checkpoint.adapter.AuthAdapter;
import org.checkpoint.pojo.InspectInfo;

import java.util.List;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/30 15:34
 * @Description:
 **/
public class AuthManager {

    private final List<AuthAdapter<?>> authAdapters;

    public AuthManager(List<AuthAdapter<?>> authAdapters) {
        this.authAdapters = authAdapters;
    }

    public boolean auth(InspectInfo inspectInfo) {
//        boolean
        for (AuthAdapter<?> authAdapter : authAdapters) {

        }
        return false;
    }


}
