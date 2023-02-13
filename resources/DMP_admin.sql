create database DMP_admin;

use DMP_admin;

###########################################################################################################################################################
# 用户表
CREATE TABLE `user` (
                        `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
                        `username` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
                        `password` varchar(32) NOT NULL DEFAULT '' COMMENT '密码',
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `uname` (`username`)
) ENGINE=InnoDB CHARSET=utf8mb4 COMMENT='用户表';

INSERT INTO `user` VALUES (1, 'admin', '96e79218965eb72c92a549dd5a330112');
INSERT INTO `user` VALUES (2, 'zhangsan', '96e79218965eb72c92a549dd5a330112');
INSERT INTO `user` VALUES (3, 'lisi', '96e79218965eb72c92a549dd5a330112');

###########################################################################################################################################################
# 角色表
CREATE TABLE `role` (
                        `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色id',
                        `role_name` varchar(20) NOT NULL DEFAULT '' COMMENT '角色名称',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8mb4 COMMENT='角色';

INSERT INTO `role` VALUES (1, '系统管理员');
INSERT INTO `role` VALUES (2, '普通用户');

###########################################################################################################################################################
# 权限表
CREATE TABLE `permission` (
                              `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
                              `parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '所属上级',
                              `permission_name` varchar(20) NOT NULL DEFAULT '' COMMENT '名称',
                              `permission_code` varchar(50) DEFAULT NULL COMMENT '名称code',
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8mb4 COMMENT='权限表';

INSERT INTO `permission` VALUES (1, 0, '全部权限', 'ALL');

INSERT INTO `permission` VALUES (2, 1, '权限管理', 'ADMIN');
INSERT INTO `permission` VALUES (3, 1, '数据统计', 'STATISTICS');
INSERT INTO `permission` VALUES (4, 1, '报表管理', 'REPORT');
INSERT INTO `permission` VALUES (5, 1, '任务调度', 'SCHEDULER');
INSERT INTO `permission` VALUES (6, 1, '数据治理', 'GOVERNMENT');

INSERT INTO `permission` VALUES (7, 2, '用户管理', 'ADMIN-USER');
INSERT INTO `permission` VALUES (8, 2, '角色管理', 'ADMIN-ROLE');

INSERT INTO `permission` VALUES (9, 3, '实时统计', 'STATISTICS-REALTIME');
INSERT INTO `permission` VALUES (10, 3, '访问流量统计', 'STATISTICS-VISIT');

INSERT INTO `permission` VALUES (12, 4, 'MySQL报表管理', 'REPORT-MYSQL');
INSERT INTO `permission` VALUES (13, 4, 'ClickHouse报表管理', 'REPORT-CLICKHOUSE');

INSERT INTO `permission` VALUES (14, 5, '调度详情', 'SCHEDULER-DETAIL');

INSERT INTO `permission` VALUES (15, 6, 'Hive表元数据质量', 'GOVERNMENT-HIVE-META');
INSERT INTO `permission` VALUES (16, 6, 'Hive表血缘关系', 'GOVERNMENT-HIVE-LINEAGE');
INSERT INTO `permission` VALUES (17, 6, 'MySQL表数据质量监控', 'GOVERNMENT-MYSQL');

###########################################################################################################################################################
# 用户-角色表
CREATE TABLE `user_role` (
                             `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
                             `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户id',
                             `role_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '角色id',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8mb4 COMMENT='用户角色关系表';

INSERT INTO `user_role` VALUES (1, 1, 1);
INSERT INTO `user_role` VALUES (2, 2, 2);
INSERT INTO `user_role` VALUES (3, 3, 2);

###########################################################################################################################################################
# 角色-权限表
CREATE TABLE `role_permission` (
                                   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                   `role_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '角色id',
                                   `permission_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '权限id',
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8mb4 COMMENT='角色权限关系表';

INSERT INTO `role_permission` VALUES (1, 1, 1);
INSERT INTO `role_permission` VALUES (2, 1, 2);
INSERT INTO `role_permission` VALUES (3, 1, 3);
INSERT INTO `role_permission` VALUES (4, 1, 4);
INSERT INTO `role_permission` VALUES (5, 1, 5);
INSERT INTO `role_permission` VALUES (6, 1, 6);
INSERT INTO `role_permission` VALUES (7, 1, 7);
INSERT INTO `role_permission` VALUES (8, 1, 8);
INSERT INTO `role_permission` VALUES (9, 1, 9);
INSERT INTO `role_permission` VALUES (10, 1, 10);
INSERT INTO `role_permission` VALUES (12, 1, 12);
INSERT INTO `role_permission` VALUES (13, 1, 13);
INSERT INTO `role_permission` VALUES (14, 1, 14);
INSERT INTO `role_permission` VALUES (15, 1, 15);
INSERT INTO `role_permission` VALUES (16, 1, 16);
INSERT INTO `role_permission` VALUES (17, 1, 17);

INSERT INTO `role_permission` VALUES (18, 2, 1);
INSERT INTO `role_permission` VALUES (19, 2, 3);
INSERT INTO `role_permission` VALUES (20, 2, 9);
INSERT INTO `role_permission` VALUES (21, 2, 10);