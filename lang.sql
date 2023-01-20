-- Create language master and Insert all supported languages
use nirmalya;
CREATE TABLE `lang_master` (
  `lang_code` varchar(20) NOT NULL,
  `lang_name` varchar(200) NOT NULL,
  `lang_accent` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`lang_code`),
  UNIQUE KEY `lang_code` (`lang_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


INSERT INTO `nirmalya`.`lang_master`
(`lang_code`,`lang_name`,`lang_accent`)
VALUES ('bn-IN','বাংলা','ভারত');

INSERT INTO `nirmalya`.`lang_master`
(`lang_code`,`lang_name`,`lang_accent`)
VALUES ('en-IN','English','India');

INSERT INTO `nirmalya`.`lang_master`
(`lang_code`,`lang_name`,`lang_accent`)
VALUES ('gu-IN','ગુજરાતી','India');

INSERT INTO `nirmalya`.`lang_master`
(`lang_code`,`lang_name`,`lang_accent`)
VALUES ('kn-IN','ಕನ್ನಡ','India');

INSERT INTO `nirmalya`.`lang_master`
(`lang_code`,`lang_name`,`lang_accent`)
VALUES ('ml-IN','മലയാളം','India');

INSERT INTO `nirmalya`.`lang_master`
(`lang_code`,`lang_name`,`lang_accent`)
VALUES ('mr-IN','मराठी','India');

INSERT INTO `nirmalya`.`lang_master`
(`lang_code`,`lang_name`,`lang_accent`)
VALUES ('ta-IN','தமிழ்','India');

INSERT INTO `nirmalya`.`lang_master`
(`lang_code`,`lang_name`,`lang_accent`)
VALUES ('te-IN','తెలుగు','India');

INSERT INTO `nirmalya`.`lang_master`
(`lang_code`,`lang_name`,`lang_accent`)
VALUES ('ur-IN','اُردُو','India');

INSERT INTO `nirmalya`.`lang_master`
(`lang_code`,`lang_name`,`lang_accent`)
VALUES ('pa-IN','ਪੰਜਾਬੀ','India');

INSERT INTO `nirmalya`.`lang_master`
(`lang_code`,`lang_name`,`lang_accent`)
VALUES ('hi-IN','हिन्दी','India');

INSERT INTO `nirmalya`.`lang_master`
(`lang_code`,`lang_name`,`lang_accent`)
VALUES ('or-IN','ଓଡ଼ିଆ','India');

