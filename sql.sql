CREATE SCHEMA `school` DEFAULT CHARACTER SET utf8mb4 ;

DROP TABLE if exists `school`.`s_homework`;
CREATE TABLE `school`.`s_homework` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(20) NULL,
  `content` TEXT NULL,
  `create_time` datetime NOT NULL,
  `deadline` datetime NULL,
  PRIMARY KEY (`id`));

INSERT INTO `school`.`s_homework` (`id`,`title`,`content`,`create_time`, `deadline`) VALUES ('1','MyBatis','提交Git地址和博客地址','2020-06-15 12:00:00','2020-06-18 12:00:00');
DROP TABLE if exists `school`.`s_student`;
CREATE TABLE `school`.`s_student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`));
INSERT INTO `school`.`s_student` ( `id`,`name`,`password` )values ('17301092','符永乐','123456');

DROP TABLE if exists `school`.`s_teacher`;
CREATE TABLE `school`.`s_teacher` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`));

INSERT INTO `school`.`s_teacher` ( `id`,`name`,`password` )values ('1008611','符永乐','123456');

DROP TABLE if exists `school`.`s_student_homework`;
CREATE TABLE `school`.`s_student_homework` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `student_id` INT NOT NULL,
  `homework_id` INT NOT NULL,
  `homework_title` VARCHAR(45) NOT NULL,
  `homework_content` TEXT NOT NULL,
  `submit_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `comment` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

INSERT INTO `school`.`s_student_homework` (`id`, `student_id`, `homework_id`, `homework_title`, `homework_content`, `submit_time`,`update_time`,`comment`) VALUES ('1', '17301092', '1', '作业', 'Git:https://github.com/OKlala1999', '2020-06-16 12:00:00','2020-06-15 12:00:00','NICE!!!');
