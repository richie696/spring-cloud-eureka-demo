DROP SCHEMA IF EXISTS `sc-demo`;
CREATE SCHEMA `sc-demo` DEFAULT CHARACTER SET utf8mb4;
USE `sc-demo`;
CREATE TABLE `sc-demo`.`account_info` (
  `id` INT NOT NULL COMMENT '主键列',
  `login_name` VARCHAR(45) NOT NULL COMMENT '登录账号名',
  `login_password` VARCHAR(32) NOT NULL COMMENT '登录密码',
  `password_token` VARCHAR(32) NOT NULL COMMENT '密码令牌',
  `user_name` VARCHAR(45) NOT NULL COMMENT '用户姓名',
  `age` TINYINT(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户年龄',
  `status` MEDIUMINT NOT NULL COMMENT '用户状态标识',
  `version` INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '乐观锁版本号',
  `created_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `deleted_flag` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '删除标识(1 - 删除，0 - 未删除)',
  PRIMARY KEY (`id`)
) COMMENT '账户信息表';
