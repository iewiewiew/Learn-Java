DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `ID` int(11) NOT NULL,
                        `USER_NAME` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL,
                        `USER_AGE` int(11) DEFAULT NULL,
                        PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'IT可乐', '18');
INSERT INTO `user` VALUES ('2', 'YSOcean', '22');