-- drop table IF  EXISTS template;
CREATE TABLE IF NOT EXISTS`template` (
    `id` BIGINT(20) NOT NULL COMMENT '主键id',
    `remark` VARCHAR(128) NULL  COMMENT '备注',
    `version` int (11) NULL DEFAULT 0 COMMENT '版本号',
    `create_time` DATETIME NOT NULL COMMENT '创建时间',
    `create_user_id` BIGINT(20) NULL COMMENT '创建用户ID',
    `update_time` DATETIME NOT NULL COMMENT '更新时间',
    `update_user_id` BIGINT(20) NULL COMMENT '更新用户ID',
    PRIMARY KEY (`id`)
    ) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '表模板';

delete from template where id <= 12;
INSERT INTO `template`(`id`, `remark`, `version`, `create_time`, `create_user_id`, `update_time`, `update_user_id`) VALUES (1, 'xxxx', 0, '2021-04-16 17:30:24', 1341341, '2021-04-16 17:30:29', 1341341414);
INSERT INTO `template`(`id`, `remark`, `version`, `create_time`, `create_user_id`, `update_time`, `update_user_id`) VALUES (2, 'xxxx', 0, '2021-04-16 17:30:24', 1341341, '2021-04-16 17:30:29', 1341341414);
INSERT INTO `template`(`id`, `remark`, `version`, `create_time`, `create_user_id`, `update_time`, `update_user_id`) VALUES (3, 'xxxx', 0, '2021-04-16 17:30:24', 1341341, '2021-04-16 17:30:29', 1341341414);
INSERT INTO `template`(`id`, `remark`, `version`, `create_time`, `create_user_id`, `update_time`, `update_user_id`) VALUES (4, 'xxxx', 0, '2021-04-16 17:30:24', 1341341, '2021-04-16 17:30:29', 1341341414);
INSERT INTO `template`(`id`, `remark`, `version`, `create_time`, `create_user_id`, `update_time`, `update_user_id`) VALUES (5, 'xxxx', 0, '2021-04-16 17:30:24', 1341341, '2021-04-16 17:30:29', 1341341414);
INSERT INTO `template`(`id`, `remark`, `version`, `create_time`, `create_user_id`, `update_time`, `update_user_id`) VALUES (6, 'xxxx', 0, '2021-04-16 17:30:24', 1341341, '2021-04-16 17:30:29', 1341341414);
INSERT INTO `template`(`id`, `remark`, `version`, `create_time`, `create_user_id`, `update_time`, `update_user_id`) VALUES (7, 'xxxx', 0, '2021-04-16 17:30:24', 1341341, '2021-04-16 17:30:29', 1341341414);
INSERT INTO `template`(`id`, `remark`, `version`, `create_time`, `create_user_id`, `update_time`, `update_user_id`) VALUES (8, 'xxxx', 0, '2021-04-16 17:30:24', 1341341, '2021-04-16 17:30:29', 1341341414);
INSERT INTO `template`(`id`, `remark`, `version`, `create_time`, `create_user_id`, `update_time`, `update_user_id`) VALUES (9, 'xxxx', 0, '2021-04-16 17:30:24', 1341341, '2021-04-16 17:30:29', 1341341414);
INSERT INTO `template`(`id`, `remark`, `version`, `create_time`, `create_user_id`, `update_time`, `update_user_id`) VALUES (10, 'xxxx', 0, '2021-04-16 17:30:24', 1341341, '2021-04-16 17:30:29', 1341341414);
INSERT INTO `template`(`id`, `remark`, `version`, `create_time`, `create_user_id`, `update_time`, `update_user_id`) VALUES (11, 'xxxx', 0, '2021-04-16 17:30:24', 1341341, '2021-04-16 17:30:29', 1341341414);
INSERT INTO `template`(`id`, `remark`, `version`, `create_time`, `create_user_id`, `update_time`, `update_user_id`) VALUES (12, 'xxxx', 0, '2021-04-16 17:30:24', 1341341, '2021-04-16 17:30:29', 1341341414);