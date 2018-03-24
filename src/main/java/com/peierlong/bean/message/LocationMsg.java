package com.peierlong.bean.message;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 包名: com.peierlong.entity
 * 创建人 : Elong
 * 时间: 11/15/16 3:47 PM
 * 描述 : 地理位置消息
 * @author elong
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LocationMsg extends BaseMsg {
    /**
     * 地理位置维度
     */
    private String location_X;
    /**
     * 地理位置经度
     */
    private String location_Y;
    /**
     * 地图缩放大小
     */
    private String scale;
    /**
     * 地理位置信息
     */
    private String label;

}
