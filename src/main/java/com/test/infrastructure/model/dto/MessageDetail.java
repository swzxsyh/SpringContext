package com.test.infrastructure.model.dto;

import lombok.Data;

import java.util.UUID;

/**
 * @author swzxsyh
 */
@Data
public class MessageDetail {

    private Long time;

    private String msg;

    private String uuid;

    public MessageDetail() {
    }

    public MessageDetail(Long time, String msg, String uuid) {
        this.time = System.currentTimeMillis();
        this.msg = msg;
        this.uuid = UUID.randomUUID().toString();
    }

    public MessageDetail(String msg) {
        this.time = System.currentTimeMillis();
        this.msg = msg;
        this.uuid = UUID.randomUUID().toString();
    }
}
