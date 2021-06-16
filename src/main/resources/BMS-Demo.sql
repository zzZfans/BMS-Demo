DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`
(
    `id`          bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '图书ID',
    `name`        varchar(100) NOT NULL COMMENT '图书名称',
    `author`      varchar(100) NOT NULL COMMENT '图书作者',
    `publish`     varchar(100) NOT NULL COMMENT '图书发行商',
    `price`       decimal(10, 2) unsigned NOT NULL COMMENT '图书价格',
    `description` varchar(200) NOT NULL COMMENT '内容简介',
    `amount`      bigint unsigned NOT NULL COMMENT '图书数量',
    PRIMARY KEY (`id`),
    key           `idx_name` (`name`),
    key           `idx_author` (`author`),
    unique `uk_name_author` (`name`, `author`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT ='图书';
# ----------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`
(
    `id`   bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '类别ID',
    `name` varchar(100) NOT NULL UNIQUE COMMENT '类别名称',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT ='图书类型';
# ----------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `book_category`;
CREATE TABLE `book_category`
(
    `book_id`     bigint unsigned NOT NULL COMMENT '图书ID',
    `category_id` bigint unsigned NOT NULL COMMENT '类别ID',
    PRIMARY KEY (`book_id`, `category_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT ='图书 >-< 类别';