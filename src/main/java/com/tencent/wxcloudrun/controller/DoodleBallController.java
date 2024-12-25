package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.DoodleBallPlayer;
import com.tencent.wxcloudrun.service.DoodleBallPlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 常源博
 * @since 2024-12-25 16:43
 */
@Slf4j
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
    public ApiResponse getPlayer(@RequestHeader("x-wx-openid")String openId,
            @RequestHeader(value = "w-wx-unionid",required = false)String unionId,
            @RequestParam(required = false) String fields) {
        DoodleBallPlayer player = doodleBallPlayerService.getPlayerByPlatformAndOpenId(0, openId,unionId,fields);
        return ApiResponse.ok(player);
    }
    /**
     * 根据传入字段更新用户信息
     */
    @PatchMapping("player")
    public ApiResponse upsertPlayer(@RequestHeader("x-wx-openid")String openId,
            @RequestBody DoodleBallPlayer player) {
        log.info("upsertPlayer: openId={}, player={}", openId, player);
        doodleBallPlayerService.updatePlayer(0,openId,player);
        return ApiResponse.ok();
    }

}
