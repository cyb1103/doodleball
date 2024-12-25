package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.DoodleBallPlayerMapper;
import com.tencent.wxcloudrun.model.DoodleBallPlayer;
import com.tencent.wxcloudrun.service.DoodleBallPlayerService;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

/**
 * @author 常源博
 * @since 2024-12-25 16:54
 */
@Service
public class DoodleBallPlayerServiceImpl implements DoodleBallPlayerService {
     final DoodleBallPlayerMapper doodleBallPlayerMapper;

    public DoodleBallPlayerServiceImpl(DoodleBallPlayerMapper mapper) {
        doodleBallPlayerMapper = mapper;
    }

    @Override
    public DoodleBallPlayer getPlayerByPlatformAndOpenId(Integer platform, String openId) {
        DoodleBallPlayer player = doodleBallPlayerMapper.getPlayerByPlatformAndOpenId(platform, openId);
        // 用户不存在则新建
        if (player == null) {
            player = new DoodleBallPlayer();
            player.setPlatform(platform);
            player.setOpenId(openId);
            player.setAchievement("");
            player.setTopScore(0);
            player.setMoney(0);
            player.setRegistrationDate(LocalDateTime.now());
            player.setLastLogin(LocalDateTime.now());
            player.setCreatedAt(null);
            player.setUpdatedAt(null);
            doodleBallPlayerMapper.insertPlayer(player);
        }
        return player;
    }

    @Override
    public void upsertPlayer(DoodleBallPlayer doodleBallPlayer) {

    }
}
