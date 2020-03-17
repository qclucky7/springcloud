package com.example.demo.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName JSONEncryptionProperties
 * @Author wangchen
 * @Date 2020/1/3 15:14
 */
@Component
@ConfigurationProperties(prefix = "json-encryption")
@Validated
public class JSONEncryptionProperties {

    @NotNull
    private Boolean enabled;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
