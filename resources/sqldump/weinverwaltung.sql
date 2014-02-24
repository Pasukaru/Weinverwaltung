-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server Version:               5.6.14 - MySQL Community Server (GPL)
-- Server Betriebssystem:        Win32
-- HeidiSQL Version:             8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Exportiere Datenbank Struktur für weinverwaltung
CREATE DATABASE IF NOT EXISTS `weinverwaltung` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `weinverwaltung`;


-- Exportiere Struktur von Tabelle weinverwaltung.city
CREATE TABLE IF NOT EXISTS `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `zipCode` varchar(255) DEFAULT NULL,
  `region_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_b6tpfd3sd1ch530wfapd41nyq` (`name`),
  KEY `FK_i1tqr2ahrk7pblj3vb732a201` (`region_id`),
  CONSTRAINT `FK_i1tqr2ahrk7pblj3vb732a201` FOREIGN KEY (`region_id`) REFERENCES `region` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Exportiere Daten aus Tabelle weinverwaltung.city: ~3 rows (ungefähr)
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` (`id`, `name`, `zipCode`, `region_id`) VALUES
	(1, 'München', '88888', 1),
	(2, 'Pisa', '12152', 2),
	(3, 'Lille', '65594', 3);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;


-- Exportiere Struktur von Tabelle weinverwaltung.country
CREATE TABLE IF NOT EXISTS `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_t81fgsgaq5hcgbixtau1ptk3` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Exportiere Daten aus Tabelle weinverwaltung.country: ~3 rows (ungefähr)
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` (`id`, `name`) VALUES
	(1, 'Deutschland'),
	(3, 'Frankreich'),
	(2, 'Italien');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;


-- Exportiere Struktur von Tabelle weinverwaltung.region
CREATE TABLE IF NOT EXISTS `region` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `country_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_pvcpiafcn8jecwxj11ej65958` (`name`),
  KEY `FK_pjpy658xasq2hkvb3dtldl1f7` (`country_id`),
  CONSTRAINT `FK_pjpy658xasq2hkvb3dtldl1f7` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Exportiere Daten aus Tabelle weinverwaltung.region: ~3 rows (ungefähr)
/*!40000 ALTER TABLE `region` DISABLE KEYS */;
INSERT INTO `region` (`id`, `name`, `country_id`) VALUES
	(1, 'Oberbayern', 1),
	(2, 'Toskana', 2),
	(3, 'Normandie', 3);
/*!40000 ALTER TABLE `region` ENABLE KEYS */;


-- Exportiere Struktur von Tabelle weinverwaltung.sort
CREATE TABLE IF NOT EXISTS `sort` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6a3e84mpgsea9sm9b2pnmgqpi` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Exportiere Daten aus Tabelle weinverwaltung.sort: ~2 rows (ungefähr)
/*!40000 ALTER TABLE `sort` DISABLE KEYS */;
INSERT INTO `sort` (`id`, `name`) VALUES
	(2, 'halbtrocken'),
	(1, 'trocken');
/*!40000 ALTER TABLE `sort` ENABLE KEYS */;


-- Exportiere Struktur von Tabelle weinverwaltung.type
CREATE TABLE IF NOT EXISTS `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_kq897aq53goyc6y204b24j1c1` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Exportiere Daten aus Tabelle weinverwaltung.type: ~2 rows (ungefähr)
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` (`id`, `name`) VALUES
	(1, 'Rotwein'),
	(2, 'Weißwein');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;


-- Exportiere Struktur von Tabelle weinverwaltung.vine
CREATE TABLE IF NOT EXISTS `vine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_1kjvqiyu4daqspxudvo70hlcq` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Exportiere Daten aus Tabelle weinverwaltung.vine: ~4 rows (ungefähr)
/*!40000 ALTER TABLE `vine` DISABLE KEYS */;
INSERT INTO `vine` (`id`, `name`) VALUES
	(2, 'Burgunder'),
	(4, 'Gewürztraminer'),
	(1, 'Merlot'),
	(3, 'Pinot Gris');
/*!40000 ALTER TABLE `vine` ENABLE KEYS */;


-- Exportiere Struktur von Tabelle weinverwaltung.wine
CREATE TABLE IF NOT EXISTS `wine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  `city_id` int(11) NOT NULL,
  `sort_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  `winery_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_bwxwlg124b680y9686t0ii1ia` (`name`),
  KEY `FK_du8do4h9r1m54e4mphrr7ufkm` (`city_id`),
  KEY `FK_rh0nxc3mvtf87vgt50ldxyyxm` (`sort_id`),
  KEY `FK_jih849u0gkvevl17wnnwcy9jx` (`type_id`),
  KEY `FK_lmde9p0lkkple4rkiqrkst847` (`winery_id`),
  CONSTRAINT `FK_lmde9p0lkkple4rkiqrkst847` FOREIGN KEY (`winery_id`) REFERENCES `winery` (`id`),
  CONSTRAINT `FK_du8do4h9r1m54e4mphrr7ufkm` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`),
  CONSTRAINT `FK_jih849u0gkvevl17wnnwcy9jx` FOREIGN KEY (`type_id`) REFERENCES `type` (`id`),
  CONSTRAINT `FK_rh0nxc3mvtf87vgt50ldxyyxm` FOREIGN KEY (`sort_id`) REFERENCES `sort` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Exportiere Daten aus Tabelle weinverwaltung.wine: ~3 rows (ungefähr)
/*!40000 ALTER TABLE `wine` DISABLE KEYS */;
INSERT INTO `wine` (`id`, `name`, `price`, `city_id`, `sort_id`, `type_id`, `winery_id`) VALUES
	(1, 'Häusl Merlot', 1250, 1, 1, 1, 1),
	(2, 'Keller Burgunder', 3000, 2, 2, 2, 2),
	(3, 'Brauer Pinot Gris', 2222, 3, 1, 2, 3);
/*!40000 ALTER TABLE `wine` ENABLE KEYS */;


-- Exportiere Struktur von Tabelle weinverwaltung.winery
CREATE TABLE IF NOT EXISTS `winery` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_11eq4xgltk99a78o948b6omha` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Exportiere Daten aus Tabelle weinverwaltung.winery: ~3 rows (ungefähr)
/*!40000 ALTER TABLE `winery` DISABLE KEYS */;
INSERT INTO `winery` (`id`, `name`) VALUES
	(3, 'Brauer'),
	(1, 'Häusl'),
	(2, 'Keller');
/*!40000 ALTER TABLE `winery` ENABLE KEYS */;


-- Exportiere Struktur von Tabelle weinverwaltung.winevine
CREATE TABLE IF NOT EXISTS `winevine` (
  `wine_id` int(11) NOT NULL,
  `vine_id` int(11) NOT NULL,
  PRIMARY KEY (`wine_id`,`vine_id`),
  KEY `FK_tqy9gjyho8kk4itqnnpdowu59` (`vine_id`),
  KEY `FK_hevv402bve8ivlgvlx888s093` (`wine_id`),
  CONSTRAINT `FK_hevv402bve8ivlgvlx888s093` FOREIGN KEY (`wine_id`) REFERENCES `wine` (`id`),
  CONSTRAINT `FK_tqy9gjyho8kk4itqnnpdowu59` FOREIGN KEY (`vine_id`) REFERENCES `vine` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportiere Daten aus Tabelle weinverwaltung.winevine: ~4 rows (ungefähr)
/*!40000 ALTER TABLE `winevine` DISABLE KEYS */;
INSERT INTO `winevine` (`wine_id`, `vine_id`) VALUES
	(1, 1),
	(2, 2),
	(3, 3),
	(3, 4);
/*!40000 ALTER TABLE `winevine` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
