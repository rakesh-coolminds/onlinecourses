CREATE DATABASE  IF NOT EXISTS `online_learning`;
USE `online_learning`;

DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  `currency` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `duration_in_months` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `price_components`
--

DROP TABLE IF EXISTS `price_components`;
CREATE TABLE `price_components` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `price_component_vaue`
--

DROP TABLE IF EXISTS `price_component_value`;
CREATE TABLE `price_component_value` (
  `id` int(11) NOT NULL,
  `country_id` int(11) DEFAULT NULL,
  `component_id` int(11) DEFAULT NULL,
  `value` decimal(24,12) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_PRICE_COMPONENT_ID_idx` (`component_id`),
  KEY `FK_COUNTRY_COUNTRY_ID_idx` (`country_id`),
  CONSTRAINT `FK_COUNTRY_COUNTRY_ID` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_PRICE_COMPONENT_ID` FOREIGN KEY (`component_id`) REFERENCES `price_components` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `course_component_value`
--

DROP TABLE IF EXISTS `course_component_value`;
CREATE TABLE `course_component_value` (
  `id` int(11) NOT NULL,
  `component_value_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_COURSE_ID_idx` (`course_id`),
  KEY `FK_COMPONENT_ID_idx` (`component_value_id`),
  CONSTRAINT `FK_COMPONENT_ID` FOREIGN KEY (`component_value_id`) REFERENCES `price_component_value` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_COURSE_ID` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `price_strategies`
--

DROP TABLE IF EXISTS `price_strategies`;
CREATE TABLE `price_strategies` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `strategies_option`
--

DROP TABLE IF EXISTS `strategies_option`;
CREATE TABLE `strategies_option` (
  `id` int(11) NOT NULL,
  `course_id` int(11) DEFAULT NULL,
  `duration_in_months` int(11) DEFAULT NULL,
  `price_strategy_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_COURSE_COURSE_ID_idx` (`course_id`),
  KEY `FK_STRATEGY_ID_idx` (`price_strategy_id`),
  CONSTRAINT `FK_STRATEGY_ID` FOREIGN KEY (`price_strategy_id`) REFERENCES `price_strategies` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_COURSE_COURSE_ID` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

INSERT INTO `country` VALUES (1,'India','IND','INR'),(2,'US','US','USD');
INSERT INTO `course` VALUES (1,'Spring boot','Beginers guide to spring boot',2);
INSERT INTO `price_components` VALUES (1,'tax','percentage'),(2,'base_price','fixed'),(3,'conversion_fee','fixed');
INSERT INTO `price_component_value` VALUES (1,1,1,18.250000000000),(2,1,2,240.750000000000),(3,2,3,2.250000000000),(4,2,1,5.110000000000),(5,2,2,100.750000000000);
INSERT INTO `course_component_value` VALUES (1,1,1),(2,2,1),(3,3,1),(4,4,1),(5,5,1);
INSERT INTO `price_strategies` VALUES (1,'subscription'),(2,'free'),(3,'one_time_payment');
INSERT INTO `strategies_option` VALUES (1,1,6,1);
INSERT INTO `strategies_option` VALUES (2,1,6,3);

