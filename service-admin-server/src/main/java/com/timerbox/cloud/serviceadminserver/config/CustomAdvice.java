package com.timerbox.cloud.serviceadminserver.config;

import com.alibaba.fastjson.JSONObject;
import com.timerbox.cloud.serviceadminserver.common.ApplicationContextRegister;
import com.timerbox.cloud.serviceadminserver.common.StatusInfo;
import com.timerbox.cloud.serviceadminserver.utils.HttpClientUtils;
import de.codecentric.boot.admin.server.domain.entities.Instance;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.domain.events.InstanceEvent;
import de.codecentric.boot.admin.server.domain.events.InstanceStatusChangedEvent;
import de.codecentric.boot.admin.server.notify.AbstractStatusChangeNotifier;
import de.codecentric.boot.admin.server.notify.LoggingNotifier;
import org.slf4j.Logger;
import org.apache.http.Header;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.message.BasicHeader;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.io.IOException;

/**
 * @ClassName customAdvice
 * @Descripion 微服务监控通知
 * @Author wangchen
 * @Date 2019/10/16 18:07
 */
@Component
public class CustomAdvice extends AbstractStatusChangeNotifier {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingNotifier.class);

    public CustomAdvice(InstanceRepository repositpry) {
        super(repositpry);
    }

    @Override
    protected Mono<Void> doNotify(InstanceEvent event, Instance instance) {
        return Mono.fromRunnable(() -> {
            if (event instanceof InstanceStatusChangedEvent) {
                LOGGER.info("Instance {} ({}) is {}", instance.getRegistration().getName(), event.getInstance(),
                        ((InstanceStatusChangedEvent) event).getStatusInfo().getStatus());

                String status = ((InstanceStatusChangedEvent) event).getStatusInfo().getStatus();
                String url = "https://oapi.dingtalk.com/robot/send?access_token=d32d4ad91b72e4e056689d2f10146a2be2e4c6415dbde812134f9f7a9320b38f";
                StringBuilder content = new StringBuilder();

                if ("insecure".equals(ApplicationContextRegister.getActiveProfile())) {
                    content.append("环境 : 测试服务").append("\n");
                } else {
                    content.append("环境 : 正式服务").append("\n");
                }

                content.append("微服务名称 :").append(" ").append(instance.getRegistration().getName().toLowerCase()).append("\n").append("服务IP地址 :").append(instance.getRegistration().getServiceUrl()).append("\n");
                JSONObject data = new JSONObject();
                data.put("msgtype", "text");
                JSONObject text = new JSONObject();

                Header[] headers = new Header[]{new BasicHeader("content-type", "application/json;charset=UTF-8")};

                switch (StatusInfo.match(status)) {
                    // 健康检查没通过
                    case DOWN:
                        content.append("状态 :").append(" 服务未通过健康检查");
                        text.put("content", content);
                        data.put("text", text);
                        try {
                            HttpClientUtils.doPost(url, new ByteArrayEntity(data.toJSONString().getBytes()), headers);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    // 服务离线
                    case OFFLINE:
                        content.append("状态 :").append(" 服务离线");
                        text.put("content", content);
                        data.put("text", text);
                        try {
                            HttpClientUtils.doPost(url, new ByteArrayEntity(data.toJSONString().getBytes()), headers);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    //服务上线
                    case UP:
                        content.append("状态 :").append(" 服务上线");
                        text.put("content", content);
                        data.put("text", text);
                        try {
                            HttpClientUtils.doPost(url, new ByteArrayEntity(data.toJSONString().getBytes()), headers);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    // 服务未知异常
                    case UNKNOWN:
                        content.append("状态 :").append(" 服务未知异常");
                        text.put("content", content);
                        data.put("text", text);
                        try {
                            HttpClientUtils.doPost(url, new ByteArrayEntity(data.toJSONString().getBytes()), headers);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        break;
                }

            } else {
                LOGGER.info("Instance {} ({}) {}", instance.getRegistration().getName(), event.getInstance(),
                        event.getType());
            }
        });
    }

}

