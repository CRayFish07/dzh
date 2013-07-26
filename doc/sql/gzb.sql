/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.15 : Database - gzb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`gzb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `gzb`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(36) NOT NULL,
  `name` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(10) NOT NULL,
  `username` varchar(20) NOT NULL,
  `registdate` varchar(20) NOT NULL,
  `modifydate` varchar(20) DEFAULT NULL,
  `flag` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`uid`,`name`,`email`,`password`,`username`,`registdate`,`modifydate`,`flag`) values (1,'c0ea8eef-e4a7-490c-ac87-33f2ba3727b2','dyong','dyong525@163.com','456','DY','2011-10-24 11:25:05',NULL,0),(2,'6bdd28e8-701f-4215-afd9-3c4c8756f007','dyong525','dyong525@163.com','123','DY','2011-10-24 11:25:37',NULL,-1),(3,'3c517f91-65f4-4b55-88b9-58eb965ff935','dyong525','dyong525@163.com','123','DY','2011-10-24 11:27:49',NULL,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
