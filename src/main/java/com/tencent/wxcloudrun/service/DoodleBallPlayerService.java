package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.DoodleBallPlayer;

/**
 * @author 常源博
 * @since 2024-12-25 16:52
 */
public interface DoodleBallPlayerService {
    /**
     * 获取用户信息或创建新用户并返回
     */
    DoodleBallPlayer getPlayerByPlatformAndOpenId(Integer platform, String openId, String unionId, String fields);

    /**
     * 更新用户信息
     */
    void updatePlayer(DoodleBallPlayer doodleBallPlayer);
}
