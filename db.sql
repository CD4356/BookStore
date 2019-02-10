/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.53 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `book` (
	`id` varchar (30),
	`name` varchar (60),
	`price` double ,
	`number` int (11)
); 
insert into `book` (`id`, `name`, `price`, `number`) values('101','红楼梦','82','3');
insert into `book` (`id`, `name`, `price`, `number`) values('102','西游记','63','20');
insert into `book` (`id`, `name`, `price`, `number`) values('103','水浒传','95.8','15');
insert into `book` (`id`, `name`, `price`, `number`) values('104','三国演义','108','9');
