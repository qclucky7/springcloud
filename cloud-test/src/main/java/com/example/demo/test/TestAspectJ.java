package com.example.demo.test;

import com.example.demo.AESUtil;
import com.example.demo.ApplicationContextRegister;
import com.example.demo.aspect.AnalysisTime;
import com.example.demo.aspect.TimeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.EnumSet;

/**
 * @ClassName TestAspectJ
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/8/28 9:13
 * @Version 1.0
 */
@RestController
public class TestAspectJ {

    @Autowired
    private JSONEncryptionProperties jsonEncryptionProperties;

    @GetMapping(value = "/test")
    @AnalysisTime(value = 1, type = TimeType.TIME)
    public String test(){


        String s = "";
        s = "{\"id\":1759,\"reservationId\":1511867174251,\"visitingPurpose\":1,\"officeBuildingId\":1,\"officeBuildingName\":\"1\",\"cityId\":1,\"cityName\":\"1\",\"reservationStatus\":1,\"visitorName\":\"1 \",\"visitorAreaCode\":\"1\",\"visitorPhone\":\"1\",\"visitorEmail\":null,\"remark\":null,\"visitingTime\":1,\"visitorNum\":1,\"visitingUnit\":null,\"messageNum\":null,\"photoUrl\":null,\"receptionUserName\":\"1\",\"receptionUserDomainAccount\":\"1\",\"visitingInvitationCode\":null,\"createUser\":\"1\",\"createTime\":1,\"createUserDomainAccount\":null,\"updateTime\":null,\"signTime\":null,\"alreadySignedInNum\":null,\"alreadySignedOutNum\":null,\"accompanyPersons\":null,\"visitingReason\":null,\"field1\":null,\"field2\":null,\"field3\":null,\"field4\":null,\"field5\":null,\"approveStatus\":1,\"levelOneName\":null,\"levelTwoName\":null,\"createPlatform\":1}";


        if (jsonEncryptionProperties.getEnabled()){

            s = AESUtil.encrypt(s, "1234");
            //System.out.println("s2:"+AESUtil.decrypt(s, "1234"));

        }
        System.out.println("s:" + s);

        return "success";
    }

}
