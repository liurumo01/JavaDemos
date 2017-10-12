create database account;
use account;

CREATE TABLE `account` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL DEFAULT '',
  `key` varchar(20) NOT NULL DEFAULT '123456',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `page` (
  `id` int(11) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `item` varchar(8) NOT NULL DEFAULT '',
  `amount` int(11) NOT NULL DEFAULT '0',
  `type` varchar(8) NOT NULL DEFAULT ' ’»Î',
  `info` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
