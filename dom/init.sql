# studteath.user
CREATE TABLE studteath.user (
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

INSERT INTO `studteath`.`user` (`user_no`, `password`, `power_flag`, `disable_flag`, `update_date`, `update_user`, `create_date`, `create_user`) VALUES ('00000001', '1111', '0', '1', '2019-05-06 12:00:00', '1', '2019-05-06 12:00:00', '1');
INSERT INTO `studteath`.`user` (`user_no`, `password`, `power_flag`, `disable_flag`, `update_date`, `update_user`, `create_date`, `create_user`) VALUES ('00000002', '1111', '1', '1', '2019-05-06 12:00:00', '1', '2019-05-06 12:00:00', '1');
INSERT INTO `studteath`.`user` (`user_no`, `password`, `power_flag`, `disable_flag`, `update_date`, `update_user`, `create_date`, `create_user`) VALUES ('00000003', '1111', '2', '1', '2019-05-06 12:00:00', '1', '2019-05-06 12:00:00', '1');

# studteath.staff
CREATE TABLE studteath.staff (
id BIGINT(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '従業員ID',
user_id BIGINT(10) NOT NULL COMMENT 'ユーザーID',
name VARCHAR(24) COLLATE utf8_estonian_ci NOT NULL COMMENT '従業員名前',
age VARCHAR(2) COLLATE utf8_estonian_ci NOT NULL COMMENT '年齢',
sex CHAR(1) COLLATE utf8_estonian_ci NOT NULL COMMENT '性別',
tel CHAR(13) COLLATE utf8_estonian_ci NOT NULL COMMENT '電話番号',
maile_address CHAR(50) COLLATE utf8_estonian_ci NOT NULL COMMENT 'メールアドレス',
shiki_flag CHAR(1) COLLATE utf8_estonian_ci NOT NULL COMMENT '職階フラグ',
work_grade VARCHAR(2) COLLATE utf8_estonian_ci NOT NULL COMMENT '担当グレード',
work_class VARCHAR(2) COLLATE utf8_estonian_ci NOT NULL COMMENT '担当クラス',
disable_flag CHAR(1) COLLATE utf8_estonian_ci NOT NULL COMMENT '有効フラグ',
update_date DATETIME COLLATE utf8_estonian_ci NOT NULL COMMENT '更新時間',
update_user BIGINT(10) COLLATE utf8_estonian_ci NOT NULL COMMENT '更新者',
create_date DATETIME COLLATE utf8_estonian_ci NOT NULL COMMENT '作成時間',
create_user BIGINT(10) COLLATE utf8_estonian_ci NOT NULL COMMENT '作成者',
delete_date DATETIME COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '削除時間',
delete_user BIGINT(10) COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '削除者',
PRIMARY KEY (id));

INSERT INTO `studteath`.`staff` (`user_id`, `name`, `age`, `sex`, `tel`, `maile_address`, `shiki_flag`, `work_grade`, `work_class`, `disable_flag`, `update_date`, `update_user`, `create_date`, `create_user`) VALUES ('1', '中島', '22', '1', '030-0000-0000', '0001@gmail.com', '3', '8', '1', '1', '2019-05-06 12:00:00', '1', '2019-05-06 12:00:00', '1');
INSERT INTO `studteath`.`staff` (`user_id`, `name`, `age`, `sex`, `tel`, `maile_address`, `shiki_flag`, `work_grade`, `work_class`, `disable_flag`, `update_date`, `update_user`, `create_date`, `create_user`) VALUES ('1', '中村', '23', '2', '020-0000-0000', '0002@gmail.com', '4', '8', '1', '1', '2019-05-06 12:00:00', '1', '2019-05-06 12:00:00', '1');
INSERT INTO `studteath`.`staff` (`user_id`, `name`, `age`, `sex`, `tel`, `maile_address`, `shiki_flag`, `work_grade`, `work_class`, `disable_flag`, `update_date`, `update_user`, `create_date`, `create_user`) VALUES ('1', '手塚', '24', '1', '040-0000-0000', '0003@gmail.com', '4', '9', '1', '1', '2019-05-06 12:00:00', '1', '2019-05-06 12:00:00', '1');

# studteath.student
CREATE TABLE studteath.student (
id BIGINT(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '学生ID',
user_id BIGINT(10) NOT NULL COMMENT 'ユーザーID',
staff_id BIGINT(10) NOT NULL COMMENT '従業員ID',
name VARCHAR(24) COLLATE utf8_estonian_ci NOT NULL COMMENT '名前',
age VARCHAR(2) COLLATE utf8_estonian_ci NOT NULL COMMENT '年齢',
sex CHAR(1) COLLATE utf8_estonian_ci NOT NULL COMMENT '性別',
tel CHAR(13) COLLATE utf8_estonian_ci NOT NULL COMMENT '電話番号',
maile_address CHAR(50) COLLATE utf8_estonian_ci NOT NULL COMMENT 'メールアドレス',
guardian_name VARCHAR(24) COLLATE utf8_estonian_ci NOT NULL COMMENT '保護者名前',
guardian_tel CHAR(13) COLLATE utf8_estonian_ci NOT NULL COMMENT '保護者電話番号',
guardian_maile_address CHAR(50) COLLATE utf8_estonian_ci NOT NULL COMMENT '保護者メールアドレス',
grade VARCHAR(2) COLLATE utf8_estonian_ci NOT NULL COMMENT 'グレード',
class VARCHAR(2) COLLATE utf8_estonian_ci NOT NULL COMMENT 'クラス',
disable_flag CHAR(1) COLLATE utf8_estonian_ci NOT NULL COMMENT '有効フラグ',
update_date DATETIME COLLATE utf8_estonian_ci NOT NULL COMMENT '更新時間',
update_user BIGINT(10) COLLATE utf8_estonian_ci NOT NULL COMMENT '更新者',
create_date DATETIME COLLATE utf8_estonian_ci NOT NULL COMMENT '作成時間',
create_user BIGINT(10) COLLATE utf8_estonian_ci NOT NULL COMMENT '作成者',
delete_date DATETIME COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '削除時間',
delete_user BIGINT(10) COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '削除者',
PRIMARY KEY (id));

INSERT INTO `studteath`.`student` (`user_id`, `staff_id`, `name`, `age`, `sex`, `tel`, `maile_address`, `guardian_name`, `guardian_tel`, `guardian_maile_address`, `grade`, `class`, `disable_flag`, `update_date`, `update_user`, `create_date`, `create_user`) VALUES ('2', '1', 'testname', '12', '1', '000-0000-0000', 'lining@gmail.com', 'testguname', '000-8890-0000', 'juidn89@gmail.com', '8', '1', '1', '2019-05-06 12:00:00', '1', '2019-05-06 12:00:00', '1');
#studteath.score
CREATE TABLE studteath.score (
id BIGINT(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '成績ID',
student_id BIGINT(10) NOT NULL COMMENT '学生ID',
scort_count BIGINT(10) NOT NULL COMMENT '成績',
subject_flag CHAR(1) COLLATE utf8_estonian_ci NOT NULL COMMENT '成績フラグ',
school_term VARCHAR(6) COLLATE utf8_estonian_ci NOT NULL COMMENT '学期',
disable_flag CHAR(1) COLLATE utf8_estonian_ci NOT NULL COMMENT '有効フラグ',
update_date DATETIME COLLATE utf8_estonian_ci NOT NULL COMMENT '更新時間',
update_user BIGINT(10) COLLATE utf8_estonian_ci NOT NULL COMMENT '更新者',
create_date DATETIME COLLATE utf8_estonian_ci NOT NULL COMMENT '作成時間',
create_user BIGINT(10) COLLATE utf8_estonian_ci NOT NULL COMMENT '作成者',
delete_date DATETIME COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '削除時間',
delete_user BIGINT(10) COLLATE utf8_estonian_ci DEFAULT NULL COMMENT '削除者',
PRIMARY KEY (id));

INSERT INTO `studteath`.`score` (`student_id`, `scort_count`, `subject_flag`, `school_term`, `disable_flag`, `update_date`, `update_user`, `create_date`, `create_user`) VALUES ('2', '99', '1', '220301', '1', '2019-05-06 12:00:00', '1', '2019-05-06 12:00:00', '1');
INSERT INTO `studteath`.`score` (`student_id`, `scort_count`, `subject_flag`, `school_term`, `disable_flag`, `update_date`, `update_user`, `create_date`, `create_user`) VALUES ('2', '93', '2', '220301', '1', '2019-05-06 12:00:00', '1', '2019-05-06 12:00:00', '1');
INSERT INTO `studteath`.`score` (`student_id`, `scort_count`, `subject_flag`, `school_term`, `disable_flag`, `update_date`, `update_user`, `create_date`, `create_user`) VALUES ('2', '95', '3', '220301', '1', '2019-05-06 12:00:00', '1', '2019-05-06 12:00:00', '1');
