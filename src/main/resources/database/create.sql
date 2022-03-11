SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    id               INT(11)     NOT NULL PRIMARY KEY,
    username         VARCHAR(64) NOT NULL,
    nickname         VARCHAR(64) NULL,
    password         CHAR(255)   NOT NULL,
    gender           CHAR(32)    NULL,
    locked           INT(1)      NOT NULL DEFAULT 0 COMMENT '0-N, 1-Y',
    enabled          INT(1)      NOT NULL DEFAULT 1 COMMENT '0-N, 1-Y',
    created_at       TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_modified_at TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_login_at    TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT uk_user_username UNIQUE (username)
) ENGINE = INNODB
  DEFAULT CHARSET = UTF8MB4
  COLLATE = UTF8MB4_GENERAL_CI;

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`
(
    id               INT(11)      NOT NULL PRIMARY KEY,
    code             VARCHAR(128) NOT NULL,
    name             VARCHAR(128) NOT NULL,
    description      VARCHAR(512) NULL,
    created_by       INT(11)      NOT NULL,
    created_at       TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_modified_by INT(11)      NOT NULL,
    last_modified_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT uk_role_code UNIQUE (code)
) ENGINE = INNODB
  DEFAULT CHARSET = UTF8MB4
  COLLATE = UTF8MB4_GENERAL_CI;

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`
(
    id      INT(11) NOT NULL PRIMARY KEY,
    user_id INT(11) NOT NULL,
    role_id INT(11) NOT NULL,
    CONSTRAINT fk_user_user_id FOREIGN KEY (user_id) REFERENCES user (id),
    CONSTRAINT fk_role_role_id FOREIGN KEY (role_id) REFERENCES role (id)
) ENGINE = INNODB
  DEFAULT CHARSET = UTF8MB4
  COLLATE = UTF8MB4_GENERAL_CI;

SET FOREIGN_KEY_CHECKS = 1;