# OrderManagement
This is a simple Order acceptence system with integrated voice recognization. 
Application has user page to choose a language of your choice for speech recognization.
Tech Stack: Spring Boot, Security with MySQL DB. 
MySQL schema name 'nirmalyalabs' has been used in this application configuration. Replace this with your MYSQL schema name.

Initial Setup:
1) Create a Language master table
      CREATE TABLE `lang_master` (
        `lang_code` varchar(20) NOT NULL,
        `lang_name` varchar(200) NOT NULL,
        `lang_accent` varchar(100) DEFAULT NULL,
        PRIMARY KEY (`lang_code`),
        UNIQUE KEY `lang_code` (`lang_code`)
      ) ENGINE=MyISAM DEFAULT CHARSET=utf8;
2) Run lang.sql script to insert language codes.

3) Add user to user table 
        CREATE TABLE `users` (
          `userid` varchar(45) NOT NULL,
          `active` bit(1) DEFAULT NULL,
          `password` varchar(255) DEFAULT NULL,
          `preflang` varchar(255) DEFAULT NULL,
          `uname` varchar(255) DEFAULT NULL,
          PRIMARY KEY (`userid`)
        ) ENGINE=MyISAM DEFAULT CHARSET=latin1;

3.5) Create company table. This has no UI as it's a static company configuration i.e. in future, this can be used for s/w licence validation

            CREATE TABLE `company` (
              `company_id` varchar(255) NOT NULL,
              `company_name` varchar(255) DEFAULT NULL,
              `licence_no` varchar(255) DEFAULT NULL,
              `licence_validity` date DEFAULT NULL,
              PRIMARY KEY (`company_id`)
            ) ENGINE=MyISAM DEFAULT CHARSET=latin1;

            INSERT INTO `nirmalyalabs`.`company`
            (`company_id`,`company_name`,`licence_no`,`licence_validity`)
            VALUES ('INOV','My Inventory Comany','LIC-001','20-04-2030');

4) User password in above table should be Bcrypt encoded
    https://bcrypt-generator.com/

5) Create all_roles table
     CREATE TABLE `all_roles` (
      `rolename` varchar(45) NOT NULL,
      `description` varchar(255) DEFAULT NULL,
      PRIMARY KEY (`rolename`)
    ) ENGINE=MyISAM DEFAULT CHARSET=latin1;
    
      // Applicable user roles: USER and ADMIN. 
          INSERT INTO `nirmalyalabs`.`all_roles`(`rolename`,`description`) VALUES ('ADMIN','The Administrator');
          INSERT INTO `nirmalyalabs`.`all_roles`(`rolename`,`description`) VALUES ('USER','The User');

6) Create user and role mapping table
      CREATE TABLE `users_roles` (
        `user_id` varchar(45) NOT NULL,
        `role_id` varchar(45) NOT NULL,
        PRIMARY KEY (`user_id`,`role_id`),
        KEY `FKptmdrx3w59t3jfj135wuxnjpk` (`role_id`)
      ) ENGINE=MyISAM DEFAULT CHARSET=latin1;
      
  INSERT INTO `nirmalyalabs`.`users_roles`(`user_id`,`role_id`) VALUES (<{user_id: }>,'ADMIN');
7) On login, Index page will show options as per user privileges (USER/ADMIN)
