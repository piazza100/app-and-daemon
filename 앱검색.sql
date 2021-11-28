CREATE TABLE `app` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(1) NOT NULL COMMENT '''IOS:I, AND:A''',
  `app_id` varchar(200) NOT NULL COMMENT '''APP ID''',
  `name` varchar(1000) DEFAULT NULL,
  `display_price` varchar(100) DEFAULT NULL,
  `full_price` varchar(100) DEFAULT NULL,
  `url` varchar(1000) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `reg_time` datetime NOT NULL,
  `mod_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `app_id_UNIQUE` (`app_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1960 DEFAULT CHARSET=utf8



CREATE TABLE `app_his` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(1) NOT NULL COMMENT '''IOS:I, AND:A''',
  `app_id` varchar(200) NOT NULL COMMENT '''APP ID''',
  `name` varchar(1000) DEFAULT NULL,
  `display_price` varchar(100) DEFAULT NULL,
  `full_price` varchar(100) DEFAULT NULL,
  `url` varchar(1000) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `reg_time` datetime NOT NULL,
  `mod_time` datetime NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8
