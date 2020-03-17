package com.example.demo.medal.entity;

import com.example.demo.medal.AbstractMedalEntity;

/**
 * @ClassName MedalEntityVO
 * @Descripion ToDo
 * @Author wangchen
 * @Date 2019/12/6 16:55
 */
public class MedalEntityVO extends AbstractMedalEntity {

    private long medal_record_id;
    private String content;
    private String image_url;
    private long user_id;
    private long tag_id;
    private long task_id;
    private long create_time;
    private long is_top;
    private long is_finish;

    public long getMedal_record_id() {
        return medal_record_id;
    }

    public void setMedal_record_id(long medal_record_id) {
        this.medal_record_id = medal_record_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getTag_id() {
        return tag_id;
    }

    public void setTag_id(long tag_id) {
        this.tag_id = tag_id;
    }

    public long getTask_id() {
        return task_id;
    }

    public void setTask_id(long task_id) {
        this.task_id = task_id;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public long getIs_top() {
        return is_top;
    }

    public void setIs_top(long is_top) {
        this.is_top = is_top;
    }

    public long getIs_finish() {
        return is_finish;
    }

    public void setIs_finish(long is_finish) {
        this.is_finish = is_finish;
    }
}
