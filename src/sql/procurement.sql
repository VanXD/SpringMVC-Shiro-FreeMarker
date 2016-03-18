/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : procurement

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2016-03-18 12:11:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for b_order
-- ----------------------------
DROP TABLE IF EXISTS `b_order`;
CREATE TABLE `b_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `order_status` int(4) NOT NULL DEFAULT '0',
  `order_receive_address` varchar(255) DEFAULT '',
  `order_receive_tel` varchar(11) DEFAULT '',
  `order_express_number` varchar(255) DEFAULT '',
  `order_total_price` double(10,2) DEFAULT '0.00',
  `user_id` int(11) NOT NULL DEFAULT '0',
  `user_name` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_order
-- ----------------------------
INSERT INTO `b_order` VALUES ('1', '2016-03-10 18:08:33', '1', 'dddddd', '123123312', '321321312', '111.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('2', '2016-03-10 18:08:33', '1', 'asdgagds', 'asdgagds', 'agdsagdsa', '111.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('3', '2016-03-15 12:32:49', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('4', '2016-03-15 13:57:58', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('5', '2016-03-15 13:58:12', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('6', '2016-03-15 13:58:27', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('7', '2016-03-15 13:58:50', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('8', '2016-03-15 13:59:10', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('9', '2016-03-15 14:06:43', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('10', '2016-03-15 14:07:22', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('11', '2016-03-15 14:07:47', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('12', '2016-03-15 14:19:00', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('13', '2016-03-15 14:19:45', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('14', '2016-03-15 14:23:42', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('15', '2016-03-15 14:23:51', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('16', '2016-03-15 14:24:10', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('17', '2016-03-15 14:24:12', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('18', '2016-03-15 14:24:16', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('19', '2016-03-15 14:24:37', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('20', '2016-03-15 14:24:43', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('21', '2016-03-15 14:24:53', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('22', '2016-03-15 14:25:12', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('23', '2016-03-15 14:25:27', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('24', '2016-03-15 14:25:55', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('25', '2016-03-15 14:26:02', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('26', '2016-03-15 14:27:44', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('27', '2016-03-15 14:30:41', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('28', '2016-03-15 14:30:51', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('29', '2016-03-15 14:31:02', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('30', '2016-03-15 14:31:29', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('31', '2016-03-15 14:31:47', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('32', '2016-03-15 14:31:49', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('33', '2016-03-15 14:32:14', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('34', '2016-03-15 14:32:20', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('35', '2016-03-15 14:32:27', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('36', '2016-03-15 14:32:43', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('37', '2016-03-15 14:32:49', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('38', '2016-03-15 14:32:57', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('39', '2016-03-15 14:33:15', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('40', '2016-03-15 14:33:31', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('41', '2016-03-15 14:33:32', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('42', '2016-03-15 14:33:42', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('43', '2016-03-15 14:34:35', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('44', '2016-03-15 14:34:57', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('45', '2016-03-15 14:35:04', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('46', '2016-03-15 14:35:15', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('47', '2016-03-15 14:36:06', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('48', '2016-03-15 14:36:25', '3', '', '', '', '0.00', '1', 'zhang');
INSERT INTO `b_order` VALUES ('49', '2016-03-16 08:35:29', '3', '', '', '', '0.00', '3', 'wu');
INSERT INTO `b_order` VALUES ('50', '2016-03-16 08:35:45', '3', '', '', '', '0.00', '3', 'wu');
INSERT INTO `b_order` VALUES ('51', '2016-03-16 08:36:08', '3', '', '', '', '0.00', '3', 'wu');
INSERT INTO `b_order` VALUES ('52', '2016-03-16 08:36:26', '3', '', '', '', '0.00', '3', 'wu');
INSERT INTO `b_order` VALUES ('53', '2016-03-16 08:38:01', '3', '', '', '', '0.00', '3', 'wu');
INSERT INTO `b_order` VALUES ('54', '2016-03-16 08:38:41', '3', '', '', '', '0.00', '3', 'wu');
INSERT INTO `b_order` VALUES ('55', '2016-03-16 08:38:45', '3', 'fdsa', 'fds', '', '24824.82', '3', 'wu');
INSERT INTO `b_order` VALUES ('56', '2016-03-16 08:42:45', '1', 'fsd', 'fdsa', 'wdsa', '12412.41', '3', 'wu');
INSERT INTO `b_order` VALUES ('57', '2016-03-17 00:22:33', '3', null, null, null, '25025.82', '3', 'wu');
INSERT INTO `b_order` VALUES ('58', '2016-03-17 00:23:56', '3', null, null, null, '25025.82', '3', 'wu');
INSERT INTO `b_order` VALUES ('59', '2016-03-17 00:24:53', '3', null, null, null, '25025.82', '3', 'wu');
INSERT INTO `b_order` VALUES ('60', '2016-03-17 00:25:16', '3', null, null, null, '25025.82', '3', 'wu');
INSERT INTO `b_order` VALUES ('61', '2016-03-17 00:27:16', '3', null, null, null, '25025.82', '3', 'wu');
INSERT INTO `b_order` VALUES ('62', '2016-03-17 00:28:11', '1', '请输入收货地址', '入收货电话', 'gfagsa', '25025.82', '3', 'wu');

-- ----------------------------
-- Table structure for b_product
-- ----------------------------
DROP TABLE IF EXISTS `b_product`;
CREATE TABLE `b_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `product_status` int(4) NOT NULL DEFAULT '0',
  `product_title` varchar(255) NOT NULL DEFAULT '',
  `product_content` varchar(1000) NOT NULL DEFAULT '',
  `product_avatar` varchar(255) NOT NULL DEFAULT '',
  `product_price` double(10,2) NOT NULL DEFAULT '0.00',
  `product_stock` int(11) NOT NULL DEFAULT '0',
  `product_sales` int(11) DEFAULT '0',
  `product_brand` varchar(255) DEFAULT '',
  `product_model` varchar(255) DEFAULT '',
  `product_public_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `product_weight` double DEFAULT '0',
  `product_working_temperature` float DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_product
-- ----------------------------
INSERT INTO `b_product` VALUES ('2', '2016-03-10 09:07:13', '0', 'BBB', 'CCC', '\\resources\\img\\upload\\6ec5172de17e4f508726b52653bee03b.jpeg', '333.30', '0', '0', '', '', '2016-03-17 18:52:19', '0', '0');
INSERT INTO `b_product` VALUES ('3', '2016-03-10 09:07:13', '0', 'CCC', 'dsaf', '\\resources\\img\\upload\\9298b69dd9804741be75a8a1002b30fa.png', '300.51', '0', '0', '', '', '2016-03-17 18:52:19', '0', '0');
INSERT INTO `b_product` VALUES ('4', '2016-03-10 09:07:13', '0', 'aaaaa', 'bbbbbb', '/resources/img/upload/17.jpg', '100.50', '0', '0', '', '', '2016-03-17 18:52:19', '0', '0');
INSERT INTO `b_product` VALUES ('5', '2016-03-10 09:07:13', '0', 'aaaaa', 'bbbbbb', '/resources/img/upload/17.jpg', '100.50', '0', '0', '', '', '2016-03-17 18:52:19', '0', '0');
INSERT INTO `b_product` VALUES ('6', '2016-03-10 09:07:13', '0', 'aaaaa', 'bbbbbb', '/resources/img/upload/17.jpg', '100.50', '0', '0', '', '', '2016-03-17 18:52:19', '0', '0');
INSERT INTO `b_product` VALUES ('7', '2016-03-10 09:07:13', '0', 'aaaaa', 'bbbbbb', '/resources/img/upload/17.jpg', '100.50', '0', '0', '', '', '2016-03-17 18:52:19', '0', '0');
INSERT INTO `b_product` VALUES ('8', '2016-03-10 09:07:13', '0', 'aaaaa', 'bbbbbb', '/resources/img/upload/17.jpg', '100.50', '0', '0', '', '', '2016-03-17 18:52:19', '0', '0');
INSERT INTO `b_product` VALUES ('9', '2016-03-10 09:07:13', '0', 'aaaaa', 'bbbbbb', '/resources/img/upload/17.jpg', '100.50', '0', '0', '', '', '2016-03-17 18:52:19', '0', '0');
INSERT INTO `b_product` VALUES ('10', '2016-03-10 09:07:13', '0', 'aaaaa', 'bbbbbb', '/resources/img/upload/17.jpg', '100.50', '0', '0', '', '', '2016-03-17 18:52:19', '0', '0');
INSERT INTO `b_product` VALUES ('11', '2016-03-10 09:07:13', '0', 'aaaaa', 'bbbbbb', '/resources/img/upload/17.jpg', '100.50', '0', '0', '', '', '2016-03-17 18:52:19', '0', '0');
INSERT INTO `b_product` VALUES ('12', '2016-03-10 09:07:13', '0', 'aaaaa', 'bbbbbb', '/resources/img/upload/17.jpg', '100.50', '0', '0', '', '', '2016-03-17 18:52:19', '0', '0');
INSERT INTO `b_product` VALUES ('13', '2016-03-10 16:38:55', '0', '蛋糕', '精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕精美蛋糕111111111111111111111111111111', '\\resources\\img\\upload\\9b2e24d14b0a487ca034ce98dc659e54.jpeg', '12412.41', '0', '0', '', '', '2016-03-17 18:52:19', '0', '0');
INSERT INTO `b_product` VALUES ('14', '2016-03-17 19:25:37', '0', '213', '312', '\\resources\\img\\upload\\6b3457d645934c5dbf73e36290c65eaa.jpeg', '213.00', '21312', '0', '31', '31', null, '313', '321');
INSERT INTO `b_product` VALUES ('15', '2016-03-17 20:00:48', '0', '23aaaaaaaa', '231', '\\resources\\img\\upload\\f724408f98bd4b93a7ddb57a24993fba.jpeg', '12321.00', '3213', '0', '2312', '321', '2016-03-18 00:00:00', '3213', '123');

-- ----------------------------
-- Table structure for b_product_order
-- ----------------------------
DROP TABLE IF EXISTS `b_product_order`;
CREATE TABLE `b_product_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL DEFAULT '0',
  `product_amount` int(11) NOT NULL DEFAULT '0',
  `order_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_product_order
-- ----------------------------
INSERT INTO `b_product_order` VALUES ('1', '2', '11', '1');
INSERT INTO `b_product_order` VALUES ('2', '2', '11', '2');
INSERT INTO `b_product_order` VALUES ('3', '3', '11', '1');
INSERT INTO `b_product_order` VALUES ('4', '13', '2', '55');
INSERT INTO `b_product_order` VALUES ('5', '13', '2', '55');
INSERT INTO `b_product_order` VALUES ('6', '13', '2', '55');
INSERT INTO `b_product_order` VALUES ('7', '13', '2', '55');
INSERT INTO `b_product_order` VALUES ('8', '13', '1', '56');
INSERT INTO `b_product_order` VALUES ('9', '8', '2', '57');
INSERT INTO `b_product_order` VALUES ('10', '13', '2', '57');
INSERT INTO `b_product_order` VALUES ('11', '8', '2', '58');
INSERT INTO `b_product_order` VALUES ('12', '13', '2', '58');
INSERT INTO `b_product_order` VALUES ('13', '8', '2', '59');
INSERT INTO `b_product_order` VALUES ('14', '13', '2', '59');
INSERT INTO `b_product_order` VALUES ('15', '8', '2', '60');
INSERT INTO `b_product_order` VALUES ('16', '13', '2', '60');
INSERT INTO `b_product_order` VALUES ('17', '8', '2', '61');
INSERT INTO `b_product_order` VALUES ('18', '13', '2', '61');
INSERT INTO `b_product_order` VALUES ('19', '8', '2', '62');
INSERT INTO `b_product_order` VALUES ('20', '13', '2', '62');

-- ----------------------------
-- Table structure for b_shoping_cart
-- ----------------------------
DROP TABLE IF EXISTS `b_shoping_cart`;
CREATE TABLE `b_shoping_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `product_id` int(11) NOT NULL,
  `product_amount` int(11) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_shoping_cart
-- ----------------------------

-- ----------------------------
-- Table structure for sys_permissions
-- ----------------------------
DROP TABLE IF EXISTS `sys_permissions`;
CREATE TABLE `sys_permissions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `permission` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_permissions_permission` (`permission`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permissions
-- ----------------------------
INSERT INTO `sys_permissions` VALUES ('1', 'user:create', '用户模块新增', '1');
INSERT INTO `sys_permissions` VALUES ('2', 'user:update', '用户模块修改', '1');
INSERT INTO `sys_permissions` VALUES ('3', 'menu:create', '菜单模块新增', '1');
INSERT INTO `sys_permissions` VALUES ('24', 'user:view', '用户模块浏览', '1');

-- ----------------------------
-- Table structure for sys_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles`;
CREATE TABLE `sys_roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_roles_role` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_roles
-- ----------------------------
INSERT INTO `sys_roles` VALUES ('1', 'admin', '管理员', '1');
INSERT INTO `sys_roles` VALUES ('2', 'user', '用户管理员', '1');
INSERT INTO `sys_roles` VALUES ('3', 'customer', '普通客户', '1');
INSERT INTO `sys_roles` VALUES ('4', 'vip', '会员客户', '1');

-- ----------------------------
-- Table structure for sys_roles_permissions
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles_permissions`;
CREATE TABLE `sys_roles_permissions` (
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_roles_permissions
-- ----------------------------
INSERT INTO `sys_roles_permissions` VALUES ('1', '1');
INSERT INTO `sys_roles_permissions` VALUES ('1', '2');
INSERT INTO `sys_roles_permissions` VALUES ('1', '3');
INSERT INTO `sys_roles_permissions` VALUES ('2', '1');
INSERT INTO `sys_roles_permissions` VALUES ('2', '2');

-- ----------------------------
-- Table structure for sys_users
-- ----------------------------
DROP TABLE IF EXISTS `sys_users`;
CREATE TABLE `sys_users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `salt` varchar(100) DEFAULT NULL,
  `locked` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_users_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_users
-- ----------------------------
INSERT INTO `sys_users` VALUES ('1', 'zhang', 'a824f2190d0e6b71ff805250131c2d14', '3c8907920f2a122dd9f98493d6dcfaca', '0');
INSERT INTO `sys_users` VALUES ('2', 'li', '88a306a9b4e4cb1d8fa24819eb3715bb', '13c0620ed328403a7e520458d26f20cb', '0');
INSERT INTO `sys_users` VALUES ('3', 'wu', '2fbb433e67b94e6391d215d96a6742f0', 'ee5ffd26be4f193ea297979b7a8139cf', '0');
INSERT INTO `sys_users` VALUES ('4', 'wang', '8bd98c81e7fcd73ff6b14e7d44b7d3d3', '32be0119c049d8f14528d9fd5c7fb698', '1');
INSERT INTO `sys_users` VALUES ('5', 'chou', '8bd98c81e7fcd73ff6b14e7d44b7d3d3', '32be0119c049d8f14528d9fd5c7fb698', '1');
INSERT INTO `sys_users` VALUES ('6', 'chou1', '8bd98c81e7fcd73ff6b14e7d44b7d3d3', '32be0119c049d8f14528d9fd5c7fb698', '1');
INSERT INTO `sys_users` VALUES ('7', 'chou2', '8bd98c81e7fcd73ff6b14e7d44b7d3d3', '32be0119c049d8f14528d9fd5c7fb698', '1');
INSERT INTO `sys_users` VALUES ('8', 'chou3', '8bd98c81e7fcd73ff6b14e7d44b7d3d3', '32be0119c049d8f14528d9fd5c7fb698', '1');
INSERT INTO `sys_users` VALUES ('9', 'chou4', '8bd98c81e7fcd73ff6b14e7d44b7d3d3', '32be0119c049d8f14528d9fd5c7fb698', '1');
INSERT INTO `sys_users` VALUES ('10', 'chou5', '8bd98c81e7fcd73ff6b14e7d44b7d3d3', '32be0119c049d8f14528d9fd5c7fb698', '1');
INSERT INTO `sys_users` VALUES ('11', 'chou6', '8bd98c81e7fcd73ff6b14e7d44b7d3d3', '32be0119c049d8f14528d9fd5c7fb698', '1');
INSERT INTO `sys_users` VALUES ('12', 'chou7', '8bd98c81e7fcd73ff6b14e7d44b7d3d3', '32be0119c049d8f14528d9fd5c7fb698', '1');
INSERT INTO `sys_users` VALUES ('13', 'chou8', '8bd98c81e7fcd73ff6b14e7d44b7d3d3', '32be0119c049d8f14528d9fd5c7fb698', '1');
INSERT INTO `sys_users` VALUES ('14', 'xd', '6b49edf1be5bf3bd78dc136b53e6ad85', '0e7e7ff3baad93a0cc6dc436d4e2b953', '0');

-- ----------------------------
-- Table structure for sys_users_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_users_roles`;
CREATE TABLE `sys_users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_users_roles
-- ----------------------------
INSERT INTO `sys_users_roles` VALUES ('1', '1');
INSERT INTO `sys_users_roles` VALUES ('2', '1');
INSERT INTO `sys_users_roles` VALUES ('2', '2');
INSERT INTO `sys_users_roles` VALUES ('3', '1');
INSERT INTO `sys_users_roles` VALUES ('3', '2');
INSERT INTO `sys_users_roles` VALUES ('3', '3');
INSERT INTO `sys_users_roles` VALUES ('3', '4');
INSERT INTO `sys_users_roles` VALUES ('4', '1');
INSERT INTO `sys_users_roles` VALUES ('4', '2');
