package org.checkpoint.config;

import lombok.Data;
import org.checkpoint.adapter.AuthAdapter;

import java.util.List;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/30 15:12
 * @Description:
 **/
@Data
public class ConfigProperties {

//    public boolean defaultOverSee = false;

    private List<AuthAdapter<?>> authAdapters;


}
