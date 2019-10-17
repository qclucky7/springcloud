package com.timerbox.cloud.serviceadminserver.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @ClassName ApplicationContextRegister
 * @Description
 * @Author xushenglai
 * @Date 2018/10/8 下午3:22
 */
@Component
@Lazy(false)
public class ApplicationContextRegister implements ApplicationContextAware {
    private static ApplicationContext APPLICATION_CONTEXT;

    /**
     * 设置spring上下文  *  * @param applicationContext spring上下文  * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        APPLICATION_CONTEXT = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return APPLICATION_CONTEXT;
    }
    
    public static String getActiveProfile() {
        return APPLICATION_CONTEXT.getEnvironment().getActiveProfiles()[0];
    }
    
}
