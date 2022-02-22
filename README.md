# 师生信息系统
学生和教师的信息编辑，学生成绩csv出力的技能。
# 事前准备
1. IntelliJ IDEA Community
2. gradle-7.3.3
3. jdk-17.0.1
4. mysql
5. git
6. thymeleaf
7. sql

CREATE TABLE `studteath`.`user` (
`id` BIGINT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(100) NOT NULL,
`address` VARCHAR(255) NULL,
`phone` VARCHAR(50) NULL,
`update_date` DATETIME NOT NULL,
`create_date` DATETIME NOT NULL,
`delete_date` DATETIME NULL,
PRIMARY KEY (`id`));
INSERT INTO `studteath`.`user` (`id`, `name`, `address`, `phone`, `update_date`, `create_date`) VALUES ('1', 'テスト太郎', '東京都サンプル区1-1', '080-0000-0000', '2019-05-06 12:00:00', '2019-05-01 12:00:00');
# 开发分支 
develop
