CREATE database `example`;

DROP TABLE IF EXISTS `example`.`t_example_info`;
CREATE TABLE `example`.`t_example_info` (
     `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
     `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户名称',
     `age` int DEFAULT NULL COMMENT '用户年龄',
     `mark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
     `creater` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT 'admin' COMMENT '创建人',
     `updater` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT 'admin' COMMENT '更新人',
     `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
     `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
     PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `example`.`t_example_info` (`id`, `username`, `age`, `mark`, `creater`, `updater`, `create_time`, `update_time`) VALUES (1, 'admin', 10, '备注', 'admin', 'admin', '2023-09-03 04:07:12', '2023-09-03 04:07:12');
