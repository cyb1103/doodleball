package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.DoodleBallPlayer;
import org.apache.ibatis.annotations.Param;

/**
 * @author 常源博
 * @since 2024-12-25 16:18
 */
public interface DoodleBallPlayerMapper {
    DoodleBallPlayer getPlayerByPlatformAndOpenId(@Param("platform") Integer platform, @Param("openId") String openId);

    /**
     * 只能更新achievement, topScore, money, lastLogin
     * @param doodleBallPlayer 玩家信息
     */
    void upsertPlayer(DoodleBallPlayer doodleBallPlayer);

    void insertPlayer(DoodleBallPlayer player);
}
