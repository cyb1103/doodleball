package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.dao.DoodleBallPlayerMapper;
import com.tencent.wxcloudrun.model.DoodleBallPlayer;
import com.tencent.wxcloudrun.service.DoodleBallPlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 常源博
 * @since 2024-12-25 16:43
 */
@RestController
@RequestMapping("doodle-ball")
public class DoodleBallController {

    final DoodleBallPlayerService doodleBallPlayerService;

    public DoodleBallController(DoodleBallPlayerService doodleBallPlayerService) {
        this.doodleBallPlayerService = doodleBallPlayerService;
    }

    /**
     * 获取用户信息
     */
    @GetMapping("player")
    public Object getPlayer(@RequestHeader("x-wx-openid")String openId,@RequestHeader("x-wx-source")String source,
            @RequestParam String fields) {
        DoodleBallPlayer player = doodleBallPlayerService.getPlayerByPlatformAndOpenId(0, openId);
        return player;
    }
}
