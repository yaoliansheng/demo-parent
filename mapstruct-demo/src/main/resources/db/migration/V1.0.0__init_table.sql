CREATE TABLE IF NOT EXISTS `person` (
                           `id` bigint(20) NOT NULL,
                           `name` varchar(64) DEFAULT NULL,
                           `age` int(11) DEFAULT NULL,
                           `dog_id` bigint(11) NOT NULL,
                           `cat_id` bigint(11) NOT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS  `dog` (
                       `id` bigint(20) NOT NULL,
                       `name` varchar(64) DEFAULT NULL,
                       `age` int(11) DEFAULT NULL,
                       PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `cat` (
                       `id` bigint(20) NOT NULL,
                       `name` varchar(64) DEFAULT NULL,
                       `age` int(11) DEFAULT NULL,
                       PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

delete from cat where id = 1;
delete from dog where id = 1;
delete from person where id = 1;
INSERT INTO `cat`(`id`, `name`, `age`) VALUES (1, '咪咪', 2);
INSERT INTO `dog`(`id`, `name`, `age`) VALUES (1, '狗狗', 3);
INSERT INTO `person`(`id`, `name`, `age`, `dog_id`, `cat_id`) VALUES (1, '小王', 20, 1, 1);
