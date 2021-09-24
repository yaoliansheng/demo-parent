CREATE TABLE IF NOT EXISTS `member` (
                           `id` bigint(20) NOT NULL,
                           `name` varchar(64) DEFAULT NULL,
                           `age` int(11) DEFAULT NULL,
                           `mobile` varchar(64) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;