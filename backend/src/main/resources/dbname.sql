#####基础设置#####
use mysql;
alter user 'root'@'%' identified with mysql_native_password by 'root';
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY 'root' WITH GRANT OPTION;
flush privileges;
select host,user,plugin,authentication_string from mysql.user;


#####demo表结构#####
CREATE database `dbname`;

DROP TABLE IF EXISTS `dbname`.`demo`;
CREATE TABLE `dbname`.`demo` (
                                 `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
                                 `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '账号',
                                 `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '密码',
                                 `creater` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT 'admin' COMMENT '创建人',
                                 `updater` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT 'admin' COMMENT '更新人',
                                 `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                 `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

TRUNCATE `dbname`.`demo`;

drop procedure if exists batch_data;
create procedure batch_data()
begin
    declare i int;
    set i=1;
    while(i<=20) do
            INSERT INTO `dbname`.`demo` (`id`, `username`, `password`, `creater`, `updater`, `create_time`, `update_time`) VALUES (i, CONCAT('用户',i), CONCAT('0000',i), 'admin',  'admin', NOW(), NOW());
            set i=i+1;
        end while;
end;
call batch_data();


#####tb_employee表结构#####
DROP TABLE IF EXISTS `tb_employee`;
CREATE TABLE `tb_employee` (
                               `id` int(11) NOT NULL AUTO_INCREMENT,
                               `lastName` varchar(255) DEFAULT NULL,
                               `email` varchar(255) DEFAULT NULL,
                               `gender` int(2) DEFAULT NULL,
                               `d_id` int(11) DEFAULT NULL,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;