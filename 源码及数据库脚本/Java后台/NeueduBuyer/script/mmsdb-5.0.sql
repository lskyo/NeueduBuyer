# SQL Manager for MySQL 5.4.3.43929
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : mmsdb


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `mmsdb`;

CREATE DATABASE `mmsdb`
    CHARACTER SET 'utf8'
    COLLATE 'utf8_general_ci';

USE `mmsdb`;

#
# Dropping database objects
#

DROP TABLE IF EXISTS `useraccount`;
DROP TABLE IF EXISTS `t_user`;
DROP TABLE IF EXISTS `roleprivilege`;
DROP TABLE IF EXISTS `rolelist`;
DROP TABLE IF EXISTS `product`;
DROP TABLE IF EXISTS `privilegelist`;
DROP TABLE IF EXISTS `gm_category`;
DROP TABLE IF EXISTS `demo`;
DROP TABLE IF EXISTS `checkbalance`;
DROP TABLE IF EXISTS `translate`;
DROP TABLE IF EXISTS `scrap`;
DROP TABLE IF EXISTS `repair`;
DROP TABLE IF EXISTS `buy`;
DROP TABLE IF EXISTS `provider`;
DROP TABLE IF EXISTS `balance`;
DROP TABLE IF EXISTS `department`;
DROP TABLE IF EXISTS `category`;
DROP TABLE IF EXISTS `asset_category`;
DROP TABLE IF EXISTS `asset`;
DROP TABLE IF EXISTS `area`;

#
# Structure for the `area` table : 
#

CREATE TABLE `area` (
  `AREAID` INTEGER(11) NOT NULL,
  `AREANAME` VARCHAR(50) COLLATE utf8_general_ci NOT NULL,
  `RELATIVE` INTEGER(11) DEFAULT NULL,
  PRIMARY KEY USING BTREE (`AREAID`)
)ENGINE=InnoDB
AVG_ROW_LENGTH=5461 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='';

#
# Structure for the `asset` table : 
#

CREATE TABLE `asset` (
  `id` INTEGER(11) NOT NULL,
  `asset_name` VARCHAR(255) COLLATE utf8_general_ci DEFAULT NULL,
  `cid` INTEGER(11) DEFAULT NULL,
  `create_time` DATETIME DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`)
)ENGINE=InnoDB
AVG_ROW_LENGTH=8192 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='';

#
# Structure for the `asset_category` table : 
#

CREATE TABLE `asset_category` (
  `aid` INTEGER(11) NOT NULL,
  `aname` VARCHAR(255) COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY USING BTREE (`aid`),
  UNIQUE INDEX `asset_aname` USING BTREE (`aname`)
)ENGINE=InnoDB
AVG_ROW_LENGTH=8192 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='';

#
# Structure for the `category` table : 
#

CREATE TABLE `category` (
  `CID` INTEGER(9) NOT NULL,
  `CNAME` VARCHAR(50) COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY USING BTREE (`CID`)
)ENGINE=InnoDB
AVG_ROW_LENGTH=5461 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='';

#
# Structure for the `department` table : 
#

CREATE TABLE `department` (
  `DEPARTID` INTEGER(11) NOT NULL,
  `DEPARTNAME` VARCHAR(20) COLLATE utf8_general_ci NOT NULL,
  `AREAID` INTEGER(11) NOT NULL,
  PRIMARY KEY USING BTREE (`DEPARTID`),
   INDEX `AREAID` USING BTREE (`AREAID`),
  CONSTRAINT `department_ibfk_1` FOREIGN KEY (`AREAID`) REFERENCES `area` (`AREAID`)
)ENGINE=InnoDB
AVG_ROW_LENGTH=5461 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='';

#
# Structure for the `balance` table : 
#

CREATE TABLE `balance` (
  `BID` INTEGER(11) NOT NULL,
  `BNAME` VARCHAR(50) COLLATE utf8_general_ci NOT NULL,
  `BCOUNT` DOUBLE NOT NULL,
  `PRICE` DECIMAL(7,2) NOT NULL,
  `BDATE` DATETIME NOT NULL,
  `CID` INTEGER(11) NOT NULL,
  `DEPARTID` INTEGER(11) NOT NULL,
  PRIMARY KEY USING BTREE (`BID`),
   INDEX `CID` USING BTREE (`CID`),
   INDEX `DEPARTID` USING BTREE (`DEPARTID`),
  CONSTRAINT `balance_ibfk_1` FOREIGN KEY (`CID`) REFERENCES `category` (`CID`),
  CONSTRAINT `balance_ibfk_2` FOREIGN KEY (`DEPARTID`) REFERENCES `department` (`DEPARTID`)
)ENGINE=InnoDB
AVG_ROW_LENGTH=8192 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='';

#
# Structure for the `provider` table : 
#

CREATE TABLE `provider` (
  `PROVID` INTEGER(11) NOT NULL,
  `PROVNAME` VARCHAR(50) COLLATE utf8_general_ci NOT NULL,
  `ADDRESS` VARCHAR(50) COLLATE utf8_general_ci NOT NULL,
  `PHONE` VARCHAR(20) COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY USING BTREE (`PROVID`)
)ENGINE=InnoDB
AVG_ROW_LENGTH=8192 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='';

#
# Structure for the `buy` table : 
#

CREATE TABLE `buy` (
  `BUYID` INTEGER(11) NOT NULL,
  `BUYCOUNT` DOUBLE NOT NULL,
  `BUYTIME` DATETIME NOT NULL,
  `PROVID` INTEGER(11) NOT NULL,
  `DEPARTID` INTEGER(11) NOT NULL,
  PRIMARY KEY USING BTREE (`BUYID`),
   INDEX `DEPARTID` USING BTREE (`DEPARTID`),
   INDEX `PROVID` USING BTREE (`PROVID`),
  CONSTRAINT `buy_ibfk_1` FOREIGN KEY (`DEPARTID`) REFERENCES `department` (`DEPARTID`),
  CONSTRAINT `buy_ibfk_2` FOREIGN KEY (`PROVID`) REFERENCES `provider` (`PROVID`)
)ENGINE=InnoDB
AVG_ROW_LENGTH=8192 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='';

#
# Structure for the `repair` table : 
#

CREATE TABLE `repair` (
  `REPAIRID` INTEGER(11) NOT NULL,
  `RCOUNT` DOUBLE NOT NULL,
  `RTIME` DATETIME NOT NULL,
  `DEPARTID` INTEGER(11) NOT NULL,
  `BID` INTEGER(11) NOT NULL,
  PRIMARY KEY USING BTREE (`REPAIRID`),
   INDEX `BID` USING BTREE (`BID`),
   INDEX `DEPARTID` USING BTREE (`DEPARTID`),
  CONSTRAINT `repair_ibfk_1` FOREIGN KEY (`BID`) REFERENCES `balance` (`BID`),
  CONSTRAINT `repair_ibfk_2` FOREIGN KEY (`DEPARTID`) REFERENCES `department` (`DEPARTID`)
)ENGINE=InnoDB
AVG_ROW_LENGTH=8192 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='';

#
# Structure for the `scrap` table : 
#

CREATE TABLE `scrap` (
  `SID` INTEGER(11) NOT NULL,
  `SCOUNT` DOUBLE NOT NULL,
  `STIME` DATETIME NOT NULL,
  `BID` INTEGER(11) NOT NULL,
  `DEPARTID` INTEGER(11) NOT NULL,
  PRIMARY KEY USING BTREE (`SID`),
   INDEX `BID` USING BTREE (`BID`),
   INDEX `DEPARTID` USING BTREE (`DEPARTID`),
  CONSTRAINT `scrap_ibfk_1` FOREIGN KEY (`BID`) REFERENCES `balance` (`BID`),
  CONSTRAINT `scrap_ibfk_2` FOREIGN KEY (`DEPARTID`) REFERENCES `department` (`DEPARTID`)
)ENGINE=InnoDB
AVG_ROW_LENGTH=8192 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='';

#
# Structure for the `translate` table : 
#

CREATE TABLE `translate` (
  `TID` INTEGER(11) NOT NULL,
  `TCOUNT` DOUBLE NOT NULL,
  `TRTIME` DATETIME NOT NULL,
  `BID` INTEGER(11) NOT NULL,
  `DEPARTID` INTEGER(11) NOT NULL,
  PRIMARY KEY USING BTREE (`TID`),
   INDEX `BID` USING BTREE (`BID`),
   INDEX `DEPARTID` USING BTREE (`DEPARTID`),
  CONSTRAINT `translate_ibfk_1` FOREIGN KEY (`BID`) REFERENCES `balance` (`BID`),
  CONSTRAINT `translate_ibfk_2` FOREIGN KEY (`DEPARTID`) REFERENCES `department` (`DEPARTID`)
)ENGINE=InnoDB
AVG_ROW_LENGTH=8192 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='';

#
# Structure for the `checkbalance` table : 
#

CREATE TABLE `checkbalance` (
  `CHID` INTEGER(11) NOT NULL,
  `BUYID` INTEGER(11) NOT NULL,
  `BID` INTEGER(11) NOT NULL,
  `REPAIRID` INTEGER(11) NOT NULL,
  `SID` INTEGER(11) NOT NULL,
  `TID` INTEGER(11) NOT NULL,
  PRIMARY KEY USING BTREE (`CHID`),
   INDEX `BID` USING BTREE (`BID`),
   INDEX `BUYID` USING BTREE (`BUYID`),
   INDEX `REPAIRID` USING BTREE (`REPAIRID`),
   INDEX `SID` USING BTREE (`SID`),
   INDEX `TID` USING BTREE (`TID`),
  CONSTRAINT `checkbalance_ibfk_1` FOREIGN KEY (`BID`) REFERENCES `balance` (`BID`),
  CONSTRAINT `checkbalance_ibfk_2` FOREIGN KEY (`BUYID`) REFERENCES `buy` (`BUYID`),
  CONSTRAINT `checkbalance_ibfk_3` FOREIGN KEY (`REPAIRID`) REFERENCES `repair` (`REPAIRID`),
  CONSTRAINT `checkbalance_ibfk_4` FOREIGN KEY (`SID`) REFERENCES `scrap` (`SID`),
  CONSTRAINT `checkbalance_ibfk_5` FOREIGN KEY (`TID`) REFERENCES `translate` (`TID`)
)ENGINE=InnoDB
AVG_ROW_LENGTH=8192 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='';

#
# Structure for the `demo` table : 
#

CREATE TABLE `demo` (
  `ID` INTEGER(11) DEFAULT NULL,
  `NAME` VARCHAR(20) COLLATE utf8_general_ci DEFAULT NULL
)ENGINE=InnoDB
AVG_ROW_LENGTH=16384 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='';

#
# Structure for the `gm_category` table : 
#

CREATE TABLE `gm_category` (
  `cid` INTEGER(11) NOT NULL,
  `cname` VARCHAR(50) COLLATE utf8_general_ci NOT NULL,
  `createTime` DATETIME DEFAULT NULL,
  PRIMARY KEY USING BTREE (`cid`)
)ENGINE=InnoDB
AVG_ROW_LENGTH=5461 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='';

#
# Structure for the `privilegelist` table : 
#

CREATE TABLE `privilegelist` (
  `PID` INTEGER(11) NOT NULL,
  `PNAME` VARCHAR(50) COLLATE utf8_general_ci NOT NULL,
  `PURL` VARCHAR(255) COLLATE utf8_general_ci DEFAULT NULL,
  `PARENTID` INTEGER(11) NOT NULL COMMENT '自关联pid列，0表示顶级权限',
  PRIMARY KEY USING BTREE (`PID`)
)ENGINE=InnoDB
AVG_ROW_LENGTH=204 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='';

#
# Structure for the `product` table : 
#

CREATE TABLE `product` (
  `PRODID` INTEGER(11) NOT NULL,
  `PRODNAME` VARCHAR(50) COLLATE utf8_general_ci NOT NULL,
  `PRODCOUNT` DOUBLE NOT NULL,
  `PROVID` INTEGER(11) NOT NULL,
  PRIMARY KEY USING BTREE (`PRODID`),
   INDEX `PROVID` USING BTREE (`PROVID`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`PROVID`) REFERENCES `provider` (`PROVID`)
)ENGINE=InnoDB
AVG_ROW_LENGTH=8192 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='';

#
# Structure for the `rolelist` table : 
#

CREATE TABLE `rolelist` (
  `RID` INTEGER(11) NOT NULL,
  `RNAME` VARCHAR(50) COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY USING BTREE (`RID`)
)ENGINE=InnoDB
AVG_ROW_LENGTH=5461 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='';

#
# Structure for the `roleprivilege` table : 
#

CREATE TABLE `roleprivilege` (
  `RPID` INTEGER(11) NOT NULL,
  `RID` INTEGER(11) NOT NULL,
  `PID` INTEGER(11) NOT NULL,
  PRIMARY KEY USING BTREE (`RPID`),
   INDEX `PID` USING BTREE (`PID`),
   INDEX `RID` USING BTREE (`RID`),
  CONSTRAINT `roleprivilege_ibfk_1` FOREIGN KEY (`PID`) REFERENCES `privilegelist` (`PID`),
  CONSTRAINT `roleprivilege_ibfk_2` FOREIGN KEY (`RID`) REFERENCES `rolelist` (`RID`)
)ENGINE=InnoDB
AVG_ROW_LENGTH=120 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='';

#
# Structure for the `t_user` table : 
#

CREATE TABLE `t_user` (
  `USER_ID` INTEGER(11) NOT NULL AUTO_INCREMENT,
  `USER_NAME` VARCHAR(20) COLLATE utf8_general_ci DEFAULT NULL,
  `USER_AGE` VARCHAR(20) COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY USING BTREE (`USER_ID`)
)ENGINE=InnoDB
AUTO_INCREMENT=3 AVG_ROW_LENGTH=16384 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='';

#
# Structure for the `useraccount` table : 
#

CREATE TABLE `useraccount` (
  `USERID` INTEGER(11) NOT NULL,
  `USERNAME` VARCHAR(20) COLLATE utf8_general_ci NOT NULL,
  `ACCOUNTS` VARCHAR(20) COLLATE utf8_general_ci NOT NULL,
  `PASSWORD` VARCHAR(32) COLLATE utf8_general_ci NOT NULL,
  `SEX` VARCHAR(20) COLLATE utf8_general_ci NOT NULL,
  `AGE` DATETIME NOT NULL,
  `PHONE` VARCHAR(20) COLLATE utf8_general_ci NOT NULL,
  `RAGEDATE` DATETIME NOT NULL,
  `RID` INTEGER(11) NOT NULL,
  `DEPARTID` INTEGER(11) NOT NULL,
  PRIMARY KEY USING BTREE (`USERID`),
   INDEX `DEPARTID` USING BTREE (`DEPARTID`),
   INDEX `RID` USING BTREE (`RID`),
  CONSTRAINT `useraccount_ibfk_1` FOREIGN KEY (`DEPARTID`) REFERENCES `department` (`DEPARTID`),
  CONSTRAINT `useraccount_ibfk_2` FOREIGN KEY (`RID`) REFERENCES `rolelist` (`RID`)
)ENGINE=InnoDB
AVG_ROW_LENGTH=5461 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='';

#
# Data for the `area` table  (LIMIT -495,500)
#

INSERT INTO `area` (`AREAID`, `AREANAME`, `RELATIVE`) VALUES

  (1,'华北地区',0),
  (2,'华南地区',NULL),
  (3,'华中地区',NULL),
  (4,'华西地区',NULL);
COMMIT;

#
# Data for the `asset` table  (LIMIT -497,500)
#

INSERT INTO `asset` (`id`, `asset_name`, `cid`, `create_time`) VALUES

  (1,'华为电脑',1,'2017-05-25 07:52:30'),
  (2,'美家沙发',4,'2017-05-31 07:53:22');
COMMIT;

#
# Data for the `asset_category` table  (LIMIT -497,500)
#

INSERT INTO `asset_category` (`aid`, `aname`) VALUES

  (2,'其他类'),
  (5,'范甘迪');
COMMIT;

#
# Data for the `category` table  (LIMIT -496,500)
#

INSERT INTO `category` (`CID`, `CNAME`) VALUES

  (1,'办公用品'),
  (2,'设备'),
  (3,'房产');
COMMIT;

#
# Data for the `department` table  (LIMIT -496,500)
#

INSERT INTO `department` (`DEPARTID`, `DEPARTNAME`, `AREAID`) VALUES

  (1,'开发部',1),
  (2,'市场部',1),
  (3,'销售部',2);
COMMIT;

#
# Data for the `balance` table  (LIMIT -497,500)
#

INSERT INTO `balance` (`BID`, `BNAME`, `BCOUNT`, `PRICE`, `BDATE`, `CID`, `DEPARTID`) VALUES

  (1,'电脑',200,10000.00,'2017-01-01 00:00:00',1,1),
  (2,'办公桌',100,2000.00,'2017-01-13 00:00:00',1,1);
COMMIT;

#
# Data for the `provider` table  (LIMIT -497,500)
#

INSERT INTO `provider` (`PROVID`, `PROVNAME`, `ADDRESS`, `PHONE`) VALUES

  (1,'深圳电脑批发厂','深圳市','15077788999'),
  (2,'广州电脑生产商','广州市','13677778888');
COMMIT;

#
# Data for the `buy` table  (LIMIT -497,500)
#

INSERT INTO `buy` (`BUYID`, `BUYCOUNT`, `BUYTIME`, `PROVID`, `DEPARTID`) VALUES

  (1,100,'2017-01-13 00:00:00',1,2),
  (2,150,'2017-01-05 00:00:00',2,3);
COMMIT;

#
# Data for the `repair` table  (LIMIT -497,500)
#

INSERT INTO `repair` (`REPAIRID`, `RCOUNT`, `RTIME`, `DEPARTID`, `BID`) VALUES

  (1,10,'2016-12-02 00:00:00',2,1),
  (2,5,'2016-11-30 00:00:00',1,2);
COMMIT;

#
# Data for the `scrap` table  (LIMIT -497,500)
#

INSERT INTO `scrap` (`SID`, `SCOUNT`, `STIME`, `BID`, `DEPARTID`) VALUES

  (1,10,'2017-01-03 00:00:00',1,1),
  (2,10,'2017-01-02 00:00:00',2,1);
COMMIT;

#
# Data for the `translate` table  (LIMIT -497,500)
#

INSERT INTO `translate` (`TID`, `TCOUNT`, `TRTIME`, `BID`, `DEPARTID`) VALUES

  (1,20,'2017-01-02 00:00:00',1,3),
  (2,10,'2016-11-23 00:00:00',1,2);
COMMIT;

#
# Data for the `checkbalance` table  (LIMIT -497,500)
#

INSERT INTO `checkbalance` (`CHID`, `BUYID`, `BID`, `REPAIRID`, `SID`, `TID`) VALUES

  (1,1,1,1,1,1),
  (2,2,2,2,2,2);
COMMIT;

#
# Data for the `demo` table  (LIMIT -498,500)
#

INSERT INTO `demo` (`ID`, `NAME`) VALUES

  (1,'test');
COMMIT;

#
# Data for the `gm_category` table  (LIMIT -495,500)
#

INSERT INTO `gm_category` (`cid`, `cname`, `createTime`) VALUES

  (1,'打印机X','2017-04-18 15:15:15'),
  (2,'办公桌X20','2017-04-19 09:27:28'),
  (3,'打印机','2017-04-19 09:27:32'),
  (4,'办公桌X','2017-04-19 09:27:37');
COMMIT;

#
# Data for the `privilegelist` table  (LIMIT -419,500)
#

INSERT INTO `privilegelist` (`PID`, `PNAME`, `PURL`, `PARENTID`) VALUES

  (1,'基础数据管理',NULL,0),
  (2,'资产管理',NULL,0),
  (3,'使用统计管理',NULL,0),
  (4,'供应商管理',NULL,0),
  (5,'系统管理',NULL,0),
  (101,'资产分类设置',NULL,1),
  (102,'部门设置',NULL,1),
  (103,'资产录入',NULL,1),
  (104,'区域管理',NULL,1),
  (201,'采购管理',NULL,2),
  (202,'盘点管理',NULL,2),
  (203,'跨部门调配管理',NULL,2),
  (204,'报修管理',NULL,2),
  (205,'报废管理',NULL,2),
  (301,'资产总数',NULL,3),
  (302,'采购记录',NULL,3),
  (303,'跨部门调配记录',NULL,3),
  (304,'报修记录',NULL,3),
  (305,'报废记录',NULL,3),
  (306,'盘点记录',NULL,3),
  (401,'供应商信息查看',NULL,4),
  (402,'产品信息查看',NULL,4),
  (501,'用户管理',NULL,5),
  (502,'角色管理',NULL,5),
  (503,'权限管理',NULL,5),
  (10101,'新增分类',NULL,101),
  (10102,'修改分类',NULL,101),
  (10103,'删除分类',NULL,101),
  (10104,'查询分类',NULL,101),
  (10201,'新增部门',NULL,102),
  (10202,'修改部门',NULL,102),
  (10203,'删除部门',NULL,102),
  (10204,'查询部门',NULL,102),
  (10301,'新增资产',NULL,103),
  (10401,'新增区域',NULL,104),
  (10402,'修改区域',NULL,104),
  (10403,'删除区域',NULL,104),
  (10404,'查询区域',NULL,104),
  (20101,'新增采购单',NULL,201),
  (20102,'修改采购单',NULL,201),
  (20103,'删除采购单',NULL,201),
  (20104,'查询采购单',NULL,201),
  (20201,'新增盘点',NULL,202),
  (20202,'修改盘点',NULL,202),
  (20203,'删除盘点',NULL,202),
  (20204,'查询盘点',NULL,202),
  (20301,'新增调配',NULL,203),
  (20302,'修改调配',NULL,203),
  (20303,'删除调配',NULL,203),
  (20304,'查询调配',NULL,203),
  (20401,'新增报修',NULL,204),
  (20402,'修改报修',NULL,204),
  (20403,'删除报修',NULL,204),
  (20404,'查询报修',NULL,204),
  (20501,'新增报废',NULL,205),
  (20502,'修改报废',NULL,205),
  (20503,'删除报废',NULL,205),
  (20504,'查询报废',NULL,205),
  (30101,'统计1',NULL,301),
  (30201,'统计2',NULL,302),
  (30301,'统计3',NULL,303),
  (30401,'统计4',NULL,304),
  (30501,'统计5',NULL,305),
  (30601,'统计6',NULL,306),
  (40101,'新增供应商',NULL,401),
  (40102,'修改供应商',NULL,401),
  (40103,'删除供应商',NULL,401),
  (40104,'查询供应商',NULL,401),
  (40201,'新增产品',NULL,402),
  (40202,'修改产品',NULL,402),
  (40203,'删除产品',NULL,402),
  (40204,'查询产品',NULL,402),
  (50101,'新增用户',NULL,501),
  (50102,'修改用户',NULL,501),
  (50103,'删除用户',NULL,501),
  (50104,'查询用户',NULL,501),
  (50201,'新增角色',NULL,502),
  (50202,'修改角色',NULL,502),
  (50203,'删除角色',NULL,502),
  (50204,'查询角色',NULL,502);
COMMIT;

#
# Data for the `product` table  (LIMIT -497,500)
#

INSERT INTO `product` (`PRODID`, `PRODNAME`, `PRODCOUNT`, `PROVID`) VALUES

  (1,'电脑',10000,1),
  (2,'显示器',2000,2);
COMMIT;

#
# Data for the `rolelist` table  (LIMIT -496,500)
#

INSERT INTO `rolelist` (`RID`, `RNAME`) VALUES

  (1,'系统管理员'),
  (2,'资产管理员'),
  (3,'普通员工');
COMMIT;

#
# Data for the `roleprivilege` table  (LIMIT -363,500)
#

INSERT INTO `roleprivilege` (`RPID`, `RID`, `PID`) VALUES

  (241,1,1),
  (242,1,2),
  (243,1,3),
  (244,1,4),
  (245,1,5),
  (246,1,101),
  (247,1,102),
  (248,1,103),
  (249,1,104),
  (250,1,201),
  (251,1,202),
  (252,1,203),
  (253,1,204),
  (254,1,205),
  (255,1,301),
  (256,1,302),
  (257,1,303),
  (258,1,304),
  (259,1,305),
  (260,1,306),
  (261,1,401),
  (262,1,402),
  (263,1,501),
  (264,1,502),
  (265,1,503),
  (266,1,10101),
  (267,1,10102),
  (268,1,10103),
  (269,1,10104),
  (270,1,10201),
  (271,1,10202),
  (272,1,10203),
  (273,1,10204),
  (274,1,10301),
  (275,1,10401),
  (276,1,10402),
  (277,1,10403),
  (278,1,10404),
  (279,1,20101),
  (280,1,20102),
  (281,1,20103),
  (282,1,20104),
  (283,1,20201),
  (284,1,20202),
  (285,1,20203),
  (286,1,20204),
  (287,1,20301),
  (288,1,20302),
  (289,1,20303),
  (290,1,20304),
  (291,1,20401),
  (292,1,20402),
  (293,1,20403),
  (294,1,20404),
  (295,1,20501),
  (296,1,20502),
  (297,1,20503),
  (298,1,20504),
  (299,1,30101),
  (300,1,30201),
  (301,1,30301),
  (302,1,30401),
  (303,1,30501),
  (304,1,30601),
  (305,1,40101),
  (306,1,40102),
  (307,1,40103),
  (308,1,40104),
  (309,1,40201),
  (310,1,40202),
  (311,1,40203),
  (312,1,40204),
  (313,1,50101),
  (314,1,50102),
  (315,1,50103),
  (316,1,50104),
  (317,1,50201),
  (318,1,50202),
  (319,1,50203),
  (320,1,50204),
  (321,2,20101),
  (322,2,20102),
  (323,2,20103),
  (324,2,20104),
  (325,2,20201),
  (326,2,20202),
  (327,2,20203),
  (328,2,20204),
  (329,2,20301),
  (330,2,20302),
  (331,2,20303),
  (332,2,20304),
  (333,2,20401),
  (334,2,20402),
  (335,2,20403),
  (336,2,20404),
  (337,2,20501),
  (338,2,20502),
  (339,2,20503),
  (340,2,20504),
  (341,2,30101),
  (342,2,30201),
  (343,2,30301),
  (344,2,30401),
  (345,2,30501),
  (346,2,30601),
  (347,2,40101),
  (348,2,40102),
  (349,2,40103),
  (350,2,40104),
  (351,2,40201),
  (352,2,40202),
  (353,2,40203),
  (354,2,40204),
  (355,2,1),
  (356,2,201),
  (357,2,202),
  (358,2,203),
  (359,2,204),
  (360,2,205),
  (361,2,301),
  (362,2,302),
  (363,2,303),
  (364,2,304),
  (365,2,305),
  (366,2,306),
  (367,2,401),
  (368,2,402),
  (369,3,2),
  (370,3,20104),
  (371,3,20204),
  (372,3,20304),
  (373,3,20404),
  (374,3,20504),
  (375,3,40104),
  (376,3,40204);
COMMIT;

#
# Data for the `t_user` table  (LIMIT -498,500)
#

INSERT INTO `t_user` (`USER_ID`, `USER_NAME`, `USER_AGE`) VALUES

  (2,'李四','22');
COMMIT;

#
# Data for the `useraccount` table  (LIMIT -496,500)
#

INSERT INTO `useraccount` (`USERID`, `USERNAME`, `ACCOUNTS`, `PASSWORD`, `SEX`, `AGE`, `PHONE`, `RAGEDATE`, `RID`, `DEPARTID`) VALUES

  (1,'张明','zhangming01','123','男','1985-01-01 00:00:00','13878009999','2013-06-01 00:00:00',3,1),
  (2,'admin','李华','456','男','1985-07-10 00:00:00','15077730988','2013-05-01 00:00:00',2,1),
  (3,'超级管理员','admin','admin','男','1975-07-09 00:00:00','13878008888','2010-01-20 00:00:00',1,1);
COMMIT;



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;