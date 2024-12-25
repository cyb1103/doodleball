package com.tencent.wxcloudrun.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author 常源博
 * @since 2024-12-25 16:37
 */
@Data
public class DoodleBallPlayer implements Serializable {

    private Integer id;
    private Integer platform;
    private String openId;
    private String unionId;
    private String achievement;
    private Integer topScore;
    private Integer money;

    private LocalDateTime registrationDate;
    private LocalDateTime lastLogin;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
