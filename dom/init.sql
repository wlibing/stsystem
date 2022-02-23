CREATE TABLE studteath.testuser (
id BIGINT(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ユーザーID',
user_no CHAR(8) COLLATE utf8_estonian_ci NOT NULL COMMENT 'ユーザーNo',
password VARCHAR(10) COLLATE utf8_estonian_ci NOT NULL COMMENT 'パスワード',
power_flag CHAR(1) COLLATE utf8_estonian_ci NOT NULL COMMENT '権限フラグ',
disable_flag CHAR(1) COLLATE utf8_estonian_ci NOT NULL COMMENT '有効フラグ',
update_date DATETIME COLLATE utf8_estonian_ci NOT NULL COMMENT '更新時間',
update_user BIGINT(10) COLLATE utf8_estonian_ci NOT NULL COMMENT '更新者',
create_date DATETIME COLLATE utf8_estonian_ci NOT NULL COMMENT '作成時間',
create_user BIGINT(10) COLLATE utf8_estonian_ci NOT NULL COMMENT '作成者',
delete_date DATETIME COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '削除時間',
delete_user BIGINT(10) COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '削除者',
PRIMARY KEY (id));

INSERT INTO `studteath`.`testuser` (`user_no`, `password`, `power_flag`, `disable_flag`, `update_date`, `update_user`, `create_date`, `create_user`) VALUES ('00000001', '1111', '1', '1', '2019-05-06 12:00:00', '1', '2019-05-06 12:00:00', '1');
