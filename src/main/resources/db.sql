CREATE TABLE `Counters`
(
    `id`        int(11)   NOT NULL AUTO_INCREMENT,
    `count`     int(11)   NOT NULL DEFAULT '1',
    `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8;

CREATE TABLE doodle_ball_player
(
    `id`                INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `platform`          INT                  DEFAULT 0 NOT NULL, -- 平台 0-微信
    `open_id`           VARCHAR(50) NOT NULL,                    -- 平台OpenID
    `union_id`          VARCHAR(50),                             -- 平台UnionID
    `achievement`       TEXT,                                    -- 成就
    `top_score`         INT         NOT NULL,                    -- 最高分
    `money`             INT         NOT NULL,                    -- 金币
    `registration_date` DATETIME    NOT NULL,                    -- 注册日期
    `last_login`        DATETIME,                                -- 上次登录时间
    `created_at`        DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`        DATETIME   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    -- 平台和id联合主键
    CONSTRAINT `platform_id_unique` UNIQUE (`platform`, `open_id`)
);
