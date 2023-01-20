-- Create DB and user

CREATE DATABASE IF NOT EXISTS nirmalya CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE USER IF NOT EXISTS 'nlab'@'localhost' IDENTIFIED BY 'nlab';
GRANT ALL PRIVILEGES ON nirmalya.* TO 'nlab'@'localhost' IDENTIFIED BY 'nlab';
USE nirmalya ;

-- Create user table and insert admin user

CREATE TABLE IF NOT EXISTS `users` (
  `userid` varchar(45) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `preflang` varchar(255) DEFAULT NULL,
  `uname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO `nirmalya`.`users` 
(`userid`,`active`,`password`,`preflang`,`uname`)
VALUES
('admin',1,'$2a$12$B2aiPsRhNR8hBwktMDWP4OpGFpvdJObVWL1bU8sARLuqIUDcFIrkK','en-IN','The Admin');

-- Create all the roles - admin and user
CREATE TABLE IF NOT EXISTS `all_roles` (
  `rolename` varchar(45) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rolename`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO `nirmalya`.`all_roles`(`rolename`,`description`)
VALUES ('USER', 'The user');

INSERT INTO `nirmalya`.`all_roles`(`rolename`,`description`)
VALUES ('ADMIN', 'The Administrator');

-- Assign role to sample admin user

CREATE TABLE IF NOT EXISTS `users_roles` (
  `user_id` varchar(45) NOT NULL,
  `role_id` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKptmdrx3w59t3jfj135wuxnjpk` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO `nirmalya`.`users_roles`(`user_id`,`role_id`)
VALUES ('admin','ADMIN');

CREATE TABLE IF NOT EXISTS `company` (
  `company_id` varchar(255) NOT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `licence_no` varchar(255) DEFAULT NULL,
  `licence_validity` date DEFAULT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO `nirmalyalabs`.`company`
(`company_id`,`company_name`,`licence_no`,`licence_validity`)
VALUES
('WCORP','The Great Warehouse Corporation','LI001',DATE_ADD(CURDATE(), INTERVAL 365 DAY));

