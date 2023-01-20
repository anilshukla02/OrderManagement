# OrderManagement
This is a simple Order acceptence system with integrated voice recognization. 
Application has user page to choose a language of your choice for speech recognization.
Tech Stack: Spring Boot, Security with MySQL DB. 
MySQL schema name 'nirmalyalabs' has been used in this application configuration. Replace this with your MYSQL schema name.

Initial Setup:
1) Run DBsetup.sql on your mysql admin login instance. This file will do following setup:
Create a database with name nirmalya.

Create users table and add a sample 'admin' user with 'admin' password - with admin role. User password in users table is Bcrypt encoded using https://bcrypt-generator.com/
This is just a initial user for firtst time login. Once setup is complete you can use this user to create new users with different roles.

Create a 'company' table with a sample company name. You can change this later.It's just a configuration.

2) Run lang.sql script to create language table and insert language codes which are suported by In memory translator.

3) On login, Index page will show options as per user privileges (USER/ADMIN)

Note: In case you decide to change DB name in DBsetup.sql file provided here, then DO NOT FORGET TO CHANGE the same configuration in src/main/resources/application.properties file of the project.
