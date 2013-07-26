/*
SQLyog Enterprise - MySQL GUI v6.03
Host - 5.5.1-m2-community : Database - sys
*********************************************************************
Server version : 5.5.1-m2-community
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `sys`;

USE `sys`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(36) CHARACTER SET utf8 NOT NULL,
  `title` varchar(20) CHARACTER SET utf8 NOT NULL,
  `money` double NOT NULL,
  `kindid` varchar(36) CHARACTER SET utf8 NOT NULL,
  `kindtitle` varchar(20) CHARACTER SET utf8 NOT NULL,
  `datetime` varchar(20) CHARACTER SET utf8 NOT NULL,
  `userid` varchar(36) CHARACTER SET utf8 NOT NULL,
  `username` varchar(20) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `account` */
DROP TABLE IF EXISTS `income`;

CREATE TABLE `income` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(36) CHARACTER SET utf8 NOT NULL,
  `title` varchar(20) CHARACTER SET utf8 NOT NULL,
  `money` double NOT NULL,
  `kindid` varchar(36) CHARACTER SET utf8 NOT NULL,
  `kindtitle` varchar(20) CHARACTER SET utf8 NOT NULL,
  `datetime` varchar(20) CHARACTER SET utf8 NOT NULL,
  `userid` varchar(36) CHARACTER SET utf8 NOT NULL,
  `username` varchar(20) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `diary` */

DROP TABLE IF EXISTS `diary`;

CREATE TABLE `diary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(36) CHARACTER SET utf8 NOT NULL,
  `title` varchar(20) CHARACTER SET utf8 NOT NULL,
  `content` varchar(1000) CHARACTER SET utf8 NOT NULL,
  `datetime` varchar(20) CHARACTER SET utf8 NOT NULL,
  `userId` varchar(36) CHARACTER SET utf8 NOT NULL,
  `username` varchar(10) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `diary` */

/*Table structure for table `kind` */

DROP TABLE IF EXISTS `kind`;

CREATE TABLE `kind` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(36) CHARACTER SET utf8 NOT NULL,
  `title` varchar(20) CHARACTER SET utf8 NOT NULL,
  `note` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `parentId` varchar(36) CHARACTER SET utf8 NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`,`uid`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into `kind` (`id`, `uid`, `title`, `note`, `parentId`) values('1','1','入账',' ','0');
insert into `kind` (`id`, `uid`, `title`, `note`, `parentId`) values('2','-1','出账',' ','0');
/*Data for the table `kind` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(36) CHARACTER SET utf8 NOT NULL,
  `username` varchar(20) CHARACTER SET utf8 NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 NOT NULL,
  `role` varchar(20) CHARACTER SET utf8 NOT NULL DEFAULT '0',
  `rank` varchar(20) CHARACTER SET utf8 NOT NULL DEFAULT '0000000000',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`uid`,`username`,`password`,`name`,`role`,`rank`) values (1,'20c15fa6-0078-481b-8c76-d7ac1b45fc8e','admin','96368cf6459b134403567e1135b119bd','管理员','1','1111111111');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
