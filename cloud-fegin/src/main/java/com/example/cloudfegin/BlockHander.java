package com.example.cloudfegin;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @ClassName BlockHander
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/7/24 15:36
 * @Version 1.0
 */
public class BlockHander {

    public static String BlockHanderfallback(BlockException x){

        String ruleLimitApp = x.getRuleLimitApp();

        return ruleLimitApp;
    }


}

