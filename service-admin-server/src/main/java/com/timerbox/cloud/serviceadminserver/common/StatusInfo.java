package com.timerbox.cloud.serviceadminserver.common;

/**
 * 服务状态
 */

public enum StatusInfo {

    DOWN,

    OFFLINE,

    UP,

    UNKNOWN;

    public static StatusInfo match(String value) {
        if (value == null) {
            return null;
        }
        for (StatusInfo typeEnum : StatusInfo.values()) {
            if (typeEnum.toString().equalsIgnoreCase(value)) {
                return typeEnum;
            }
        }
        return null;
    }

}


