package com.nmys.story.model.dto;

import lombok.Data;

import java.util.Map;

/**
 * description
 *
 * @author hongfei.zhang
 */
@Data
public class IpBean {

    /**响应码**/
    private String code;

    /**数据封装**/
    private Map<String, String> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
}
