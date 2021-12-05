-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Feb 16, 2020 at 12:19 PM
-- Server version: 5.7.28-0ubuntu0.19.04.2
-- PHP Version: 7.2.24-0ubuntu0.19.04.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `carsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

CREATE TABLE `car` (
  `id` int(11) NOT NULL,
  `mainId` int(11) DEFAULT NULL,
  `shipperId` int(11) DEFAULT NULL,
  `vendorId` int(11) DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  `uuid` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `year` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `container` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `seal` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `inlandStatus` varchar(255) CHARACTER SET utf8mb4 DEFAULT '0',
  `cargoRecieved` datetime DEFAULT NULL,
  `titleRecieved` int(11) DEFAULT '0',
  `titleNumber` varchar(1025) DEFAULT NULL,
  `stRecieved` datetime DEFAULT NULL,
  `origin` int(11) DEFAULT '-1',
  `destination` int(11) DEFAULT '-1',
  `etd` datetime DEFAULT NULL,
  `eta` datetime DEFAULT NULL,
  `loadrequest` int(11) DEFAULT '0',
  `releaseOption` int(11) DEFAULT '0',
  `consigneeId` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT '-1',
  `landcost` float DEFAULT '0',
  `seacost` float DEFAULT '0',
  `fees` float DEFAULT '0',
  `commision` float DEFAULT '0',
  `lastUpdate` datetime DEFAULT NULL,
  `storageStartDate` datetime DEFAULT NULL,
  `storageEndDate` datetime DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `make` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `model` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `bodyStyle` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `engineType` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `engineLiters` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `color` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `assemlyCountry` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `photoExist` int(11) DEFAULT '0',
  `docExist` int(11) DEFAULT '0',
  `type` int(11) DEFAULT '0',
  `containerLink` varchar(255) DEFAULT NULL,
  `allowSendEmail` int(11) DEFAULT '0',
  `emailToSendComment` text,
  `commentToSend` text,
  `mainTwoId` int(11) DEFAULT NULL,
  `deleted` int(1) DEFAULT '0',
  `weight` varchar(45) DEFAULT '0',
  `valueOfGood` varchar(45) DEFAULT '0',
  `releaseDate` datetime DEFAULT NULL,
  `stateOut` int(11) NOT NULL DEFAULT '0',
  `mobileOrComp` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`id`, `mainId`, `shipperId`, `vendorId`, `customerId`, `uuid`, `description`, `year`, `container`, `seal`, `inlandStatus`, `cargoRecieved`, `titleRecieved`, `titleNumber`, `stRecieved`, `origin`, `destination`, `etd`, `eta`, `loadrequest`, `releaseOption`, `consigneeId`, `state`, `landcost`, `seacost`, `fees`, `commision`, `lastUpdate`, `storageStartDate`, `storageEndDate`, `note`, `make`, `model`, `bodyStyle`, `engineType`, `engineLiters`, `color`, `assemlyCountry`, `photoExist`, `docExist`, `type`, `containerLink`, `allowSendEmail`, `emailToSendComment`, `commentToSend`, `mainTwoId`, `deleted`, `weight`, `valueOfGood`, `releaseDate`, `stateOut`, `mobileOrComp`) VALUES
(475, 48, 27, NULL, NULL, '5TFRT54158X018656', '', '2008', 'HLBU1294814', '', 'ok ', '2019-08-20 15:50:05', 3, NULL, NULL, 381, 3706, '2019-09-21 12:45:08', '2019-11-04 12:45:19', 1, 1, NULL, 6, 0, 0, 0, 0, '2019-09-23 20:38:45', '2019-08-21 16:19:20', NULL, '', 'TOYOTA', 'Tundra', '4x2', 'V-Shaped- 8 Cylinders', '4.7', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=HLBU++1294814', 1, 'abesauto640@gmail.com;', 'car received with title and key ', NULL, 0, '0', '0', NULL, -1, 0),
(477, 48, 39, NULL, NULL, 'KM8NU13C39U083009', '', '2009', 'HLXU-849570-0', '609742', 'LOADED', '2019-08-22 14:59:05', 3, NULL, NULL, 381, 1, '2019-09-07 09:28:09', '2019-10-19 16:34:07', 1, 1, NULL, 8, 0, 0, 0, 212, '2019-10-04 14:35:08', '2019-08-22 14:53:50', NULL, '', 'HYUNDAI', 'Veracruz', 'FWD/Front Wheel Drive', '-  Cylinders', '3.8', '', 'SOUTH KOREA', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=HLXU++8495700', 0, '', 'vehicle received with title and key ', NULL, 0, '0', '0', NULL, -1, 0),
(478, 48, 26, NULL, NULL, 'KMHDN56D64U112094', '', '2004', '', '', '', '2019-08-21 14:57:46', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-08-27 23:55:24', NULL, NULL, '', 'HYUNDAI', 'Elantra', '', '-  Cylinders', '2.0', '', 'SOUTH KOREA', 1, 1, 0, '', 1, '', 'vehicle received with title and key ', NULL, 0, '0', '0', NULL, -1, 0),
(479, 48, 26, NULL, NULL, 'WDDGF5EB1AR093974', '', '2010', 'HLXU-849570-0', '609742', 'LOADED', '2019-08-21 15:04:10', 3, NULL, NULL, 381, 1, '2019-09-07 09:26:02', '2019-10-19 16:36:18', 1, 1, NULL, 8, 0, 0, 0, 212, '2019-09-20 16:32:11', NULL, NULL, '', 'MERCEDES-BENZ', 'C-Class', '', 'V-Shaped- 6 Cylinders', '3.0', '', 'SOUTH AFRICA', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=HLXU++8495700', 0, '', 'received with title and key ', NULL, 0, '0', '0', NULL, -1, 0),
(480, 48, 26, NULL, NULL, '1FTFW1ET1DFB79959', '', '2013', 'SEGU4615342', '609739', 'LOADED', '2019-08-20 15:07:40', 3, NULL, NULL, 381, 1, '2019-10-28 13:58:58', NULL, 1, 1, NULL, 6, 0, 0, 267, 0, '2019-11-12 15:48:16', NULL, NULL, '', 'FORD', 'F-150', '4WD/4-Wheel Drive/4x4', 'V-Shaped- 6 Cylinders', '3.5', '', 'UNITED STATES (USA)', 1, 1, 0, '', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(481, 48, 26, NULL, NULL, 'KNAFE121785551349', '', '2008', 'HLXU-849570-0', '609742', 'LOADED', '2019-08-20 15:09:46', 3, NULL, NULL, 381, 1, '2019-09-07 09:29:29', '2019-10-19 16:39:08', 1, 1, NULL, 8, 0, 213, 0, 0, '2019-09-20 16:20:52', NULL, NULL, '', 'KIA', 'Spectra', '', 'In-Line- 4 Cylinders', '2', '', 'SOUTH KOREA', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=HLXU++8495700', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(482, 48, 26, NULL, NULL, 'KNDJF724177301793', '', '2007', 'HLXU-849570-0', '', 'LOADED', '2019-08-20 15:11:23', 3, NULL, NULL, 381, 1, '2019-09-07 09:27:27', '2019-10-19 16:40:17', 1, 1, NULL, 8, 0, 213, 0, 0, '2019-09-20 16:21:23', NULL, NULL, '', 'KIA', 'Sportage', '4x2', '-  Cylinders', '2', '', 'SOUTH KOREA', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=HLXU++8495700', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(483, 48, 26, NULL, NULL, '1J4GW48S01C501460', '', '2001', 'RELEASED 8/26/2019', '', '', '2019-08-20 15:12:53', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 1, NULL, 8, 0, 0, 75, 0, '2019-09-20 16:17:49', NULL, NULL, '', 'JEEP', 'Grand Cherokee', '4WD/4-Wheel Drive/4x4', 'V-Shaped- 6 Cylinders', '4', '', 'UNITED STATES (USA)', 1, 1, 0, '', 0, '', 'RELEASED WITH TITLE AND KEY 08/26/2019', NULL, 0, '0', '0', NULL, -1, 0),
(484, 48, 26, NULL, NULL, '5NMSH13E67H072720', '', '2007', 'MAGU5350773', '609763', 'LOADED', '2019-08-19 15:14:30', 3, NULL, NULL, 381, 1, NULL, NULL, 1, 1, NULL, 8, 0, 0, 267, 0, '2019-10-10 16:00:33', NULL, NULL, '', 'HYUNDAI', 'Santa Fe', 'FWD/Front Wheel Drive', '-  Cylinders', '3.3', '', 'UNITED STATES (USA)', 1, 1, 0, '', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(485, 48, 26, NULL, NULL, '5TBRT3417YS051886', '', '2000', 'TCLU9760785', '', 'LODED', '2019-08-19 15:15:55', 3, NULL, NULL, 381, 1, NULL, NULL, 1, 1, NULL, 8, 0, 234, 0, 0, '2019-09-20 16:20:19', NULL, NULL, '', 'TOYOTA', 'Tundra', '4x2', 'V-Shaped- 8 Cylinders', '4.7', '', 'UNITED STATES (USA)', 1, 1, 0, '', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(486, 48, 26, NULL, NULL, '5TBET38196S507781', '', '2006', 'TCLU9760785', '', 'LOADED', '2019-08-16 15:22:40', 3, NULL, NULL, 381, 1, NULL, NULL, 1, 1, NULL, 8, 0, 282, 0, 0, '2019-09-20 16:19:37', NULL, NULL, '', 'TOYOTA', 'Tundra', '4x2', 'V-Shaped- 8 Cylinders', '4.7', '', 'UNITED STATES (USA)', 1, 1, 0, '', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(487, 48, 26, NULL, NULL, 'KM8JN12D67U581403', '', '2007', 'RELEASED 8/26/2019', '', '', '2019-08-16 15:24:44', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 1, NULL, 8, 0, 0, 75, 0, '2019-09-20 16:18:28', NULL, NULL, '', 'HYUNDAI', 'Tucson', 'FWD/Front Wheel Drive', '-  Cylinders', '2.7', '', 'SOUTH KOREA', 1, 1, 0, '', 0, '', 'RELEASED WITH TITLE AND KEY 08/26/2019', NULL, 0, '0', '0', NULL, -1, 0),
(488, 48, 26, NULL, NULL, '1C4RJEBT0CC362650', '', '2012', '', '', '', '2019-08-16 15:26:56', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-11-10 02:51:28', NULL, NULL, '', 'JEEP', 'Grand Cherokee', '4x2', '- 8 Cylinders', '5.7', '', '', 1, 1, 0, '', 0, '', 'title received by mail 11/08/2019', NULL, 0, '0', '0', NULL, -1, 0),
(489, 48, 26, NULL, NULL, '5TBRT34194S445500', '', '2004', 'MAGU5350773', '', 'LOADED ', '2019-08-16 15:28:11', 3, NULL, NULL, 381, 1, NULL, NULL, 1, 1, NULL, 8, 0, 0, 266, 0, '2019-10-10 16:01:55', NULL, NULL, '', 'TOYOTA', 'Tundra', '4x2', 'V-Shaped- 8 Cylinders', '4.7', '', 'UNITED STATES (USA)', 1, 1, 0, '', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(490, 48, 26, NULL, NULL, '5TBET34136S547764', '', '2006', 'MAGU5350773', '', 'LOADED ', '2019-08-16 15:29:36', 3, NULL, NULL, 381, 1, NULL, NULL, 1, 1, NULL, 8, 0, 0, 267, 0, '2019-10-10 16:00:56', NULL, NULL, '', 'TOYOTA', 'Tundra', '4x2', 'V-Shaped- 8 Cylinders', '4.7', '', 'UNITED STATES (USA)', 1, 1, 0, '', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(491, 48, 26, NULL, NULL, 'KM8NU13CX7U005713', '', '2007', 'TCLU9760785', '', 'LOADED', '2019-08-15 15:30:44', 3, NULL, NULL, 381, 1, NULL, NULL, 1, 1, NULL, 8, 0, 284, 0, 0, '2019-09-20 16:19:17', NULL, NULL, '', 'HYUNDAI', 'Veracruz', 'FWD/Front Wheel Drive', '-  Cylinders', '3.8', '', 'SOUTH KOREA', 1, 1, 0, '', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(492, 48, 26, NULL, NULL, 'KNAFK4A67G5485018', '', '2016', '', '', '', '2019-08-15 15:32:04', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-08-28 02:42:43', NULL, NULL, '', 'KIA', 'Forte', '', 'In-Line- 4 Cylinders', '1.8', '', 'SOUTH KOREA', 1, 1, 0, '', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(493, 48, 26, NULL, NULL, 'KMHDN46D36U256294', '', '2006', '', '', '', '2019-08-15 15:33:14', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-10-19 19:01:03', NULL, NULL, '', 'HYUNDAI', 'Elantra', '', '-  Cylinders', '2', '', 'SOUTH KOREA', 1, 1, 0, '', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(494, 48, 27, NULL, NULL, '5xyzg3ab7bg068247', '', '2011', 'UACU5645951', '', '', '2019-08-21 16:05:10', 3, NULL, NULL, 381, 1, NULL, '2019-11-04 11:55:57', 0, 1, NULL, 6, NULL, NULL, NULL, NULL, '2019-09-12 17:10:05', NULL, NULL, '', 'HYUNDAI', 'Santa Fe', '4x2', '-  Cylinders', '2.4', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=UACU++5645951', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(495, 48, 27, NULL, NULL, '5NMSG13DX9H297431', '', '2009', 'HLBU1294814', '', 'LOADED', '2019-08-23 18:09:00', 3, NULL, NULL, 381, 3706, '2019-09-21 12:48:09', '2019-11-04 12:48:15', 1, 1, NULL, 6, 0, NULL, 0, 0, '2019-09-23 20:38:07', NULL, NULL, '', 'HYUNDAI', 'Santa Fe', 'FWD/Front Wheel Drive', '-  Cylinders', '2.7', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=HLBU++1294814', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(496, 48, 30, NULL, NULL, '1D7HA18DX5S113095', '', '2005', '', '', '', '2019-08-22 11:14:45', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-08-24 16:16:17', NULL, NULL, '', 'DODGE', 'Ram', '4x2', 'V-Shaped- 8 Cylinders', '5.7', '', 'UNITED STATES (USA)', 0, 0, 0, '', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(497, 48, 30, NULL, NULL, 'WDCGG5GB7AF514015', '', '2010', '', '', '', '2019-08-21 11:17:48', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-08-24 16:18:09', NULL, NULL, '', 'MERCEDES-BENZ', 'GLK-Class', '', 'V-Shaped- 6 Cylinders', '3.5', '', 'GERMANY', 0, 0, 0, '', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(498, 48, 29, NULL, NULL, 'KMHDU46D79U712515', '', '2009', '', '', '', '2019-08-23 11:25:31', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-08-24 16:25:50', NULL, NULL, '', 'HYUNDAI', 'Elantra', '', '-  Cylinders', '2.0', '', 'SOUTH KOREA', 0, 0, 0, '', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(499, 48, 29, NULL, NULL, '2T3DK4DV8BW060955', '', '2011', '', '', '', '2019-08-22 11:26:40', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-08-24 16:26:57', NULL, NULL, '', 'TOYOTA', 'RAV4', '4WD/4-Wheel Drive/4x4', 'V-Shaped- 6 Cylinders', '3.5', '', 'CANADA', 0, 0, 0, '', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(500, 48, 29, NULL, NULL, '5TBDT44195S476263', '', '2005', '', '', '', '2019-08-21 11:27:42', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-08-24 16:27:56', NULL, NULL, '', 'TOYOTA', 'Tundra', '4WD/4-Wheel Drive/4x4', 'V-Shaped- 8 Cylinders', '4.7', '', 'UNITED STATES (USA)', 0, 0, 0, '', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(501, 48, 27, NULL, NULL, 'JT3HN86R120379851', '', '2002', 'HLXU8615765', '609791', 'LOADED', '2019-08-19 11:33:53', 3, NULL, NULL, 381, 3706, '2019-09-07 15:47:10', '2019-10-16 15:47:16', 0, 1, NULL, 6, NULL, NULL, NULL, NULL, '2019-08-29 20:47:25', NULL, NULL, '', 'TOYOTA', '4-Runner', '4WD/4-Wheel Drive/4x4', 'V-Shaped- 6 Cylinders', '3.4', '', 'JAPAN', 0, 0, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=HLXU++8615765', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(502, 48, 27, NULL, NULL, 'KNAFE161585015607', '', '2008', 'HLBU2410837', '609775', 'LOADED', '2019-08-17 11:35:06', 3, NULL, NULL, 381, 3706, '2019-09-21 12:19:47', '2019-11-04 12:19:57', 1, 1, NULL, 6, 0, 0, 0, 0, '2019-09-23 20:39:22', NULL, NULL, '', 'KIA', 'Spectra', '', 'In-Line- 4 Cylinders', '2', '', 'SOUTH KOREA', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-container.html?container=HLBU++2410837', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(503, 48, 27, NULL, NULL, '5NMSG13D37H090084', '', '2007', 'HLXU6548164', '609796', '68017422', '2019-08-15 11:36:26', 3, NULL, NULL, 381, 3706, '2019-08-31 14:37:09', '2019-10-09 14:37:17', 1, 1, NULL, 6, 0, 0, 0, 0, '2019-08-31 20:02:59', NULL, NULL, '', 'HYUNDAI', 'Santa Fe', 'FWD/Front Wheel Drive', '-  Cylinders', '2.7', '', 'UNITED STATES (USA)', 0, 0, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?booking=68017422', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(504, 48, 27, NULL, NULL, 'KNAGM4A72D5376307', '', '2013', 'HLXU6548164', '609796', 'LOADED', '2019-08-13 11:38:38', 3, NULL, NULL, 381, 3706, '2019-08-31 14:42:14', '2019-10-09 14:42:22', 0, 1, NULL, 6, 0, 0, 0, 0, '2019-10-19 17:23:41', NULL, NULL, '', 'KIA', 'Optima', '', '-  Cylinders', '2.4', '', 'SOUTH KOREA', 0, 0, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?booking=68017422', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(505, 48, 27, NULL, NULL, '5TFUW5F17FX458423', '', '2015', 'HLXU8615765', '609791', 'LOADED', '2019-08-13 11:39:58', 3, NULL, NULL, 381, 3706, '2019-09-07 15:41:12', '2019-10-16 15:41:18', 0, 1, NULL, 6, NULL, NULL, NULL, NULL, '2019-08-29 20:44:56', NULL, NULL, '', 'TOYOTA', 'Tundra', '4WD/4-Wheel Drive/4x4', 'V-Shaped- 8 Cylinders', '5.7', '', 'UNITED STATES (USA)', 0, 0, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=HLXU++8615765', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(506, 48, 29, NULL, NULL, '4T1BE46K67U029978', '', '2007', '', '', '', '2019-08-12 11:52:29', 0, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-10-19 17:20:36', NULL, NULL, '', 'TOYOTA', 'Camry', '4x2', 'In-Line- 4 Cylinders', '2.4', '', 'UNITED STATES (USA)', 0, 0, 0, '', 0, '', '', 27, 1, '0', '0', NULL, -1, 0),
(507, 48, 29, NULL, NULL, '5XYKT3A61CG253976', 'BILL OF SALE ', '2012', '', '', '', '2019-08-09 11:54:37', 6, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-09-03 20:49:08', NULL, NULL, '', 'KIA', 'Sorento', '4x2', '-  Cylinders', '2.4', '', 'UNITED STATES (USA)', 0, 0, 0, '', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(508, 48, 29, NULL, NULL, '1N6DD21SXWC365047', '', '1998', '', '', '', '2019-08-02 12:00:42', 0, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-08-24 17:01:01', NULL, NULL, '', 'NISSAN', 'Frontier', '4x2', '-  Cylinders', '2.4', '', 'UNITED STATES (USA)', 0, 0, 0, '', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(509, 48, 29, NULL, NULL, '5TBRT38192S306698', '', '2002', '', '', '', '2019-08-01 12:02:09', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-08-24 17:02:25', NULL, NULL, '', 'TOYOTA', 'Tundra', '4x2', 'V-Shaped- 8 Cylinders', '4.7', '', 'UNITED STATES (USA)', 0, 0, 0, '', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(510, 48, 29, NULL, NULL, 'WVGAV75N49W523949', '', '2009', '', '', '', '2019-08-01 12:03:14', 0, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-08-24 17:03:23', NULL, NULL, '', 'VOLKSWAGEN', 'Tiguan', '', '- 4 Cylinders', '1.984000', '', 'GERMANY', 0, 0, 0, '', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(511, 48, 29, NULL, NULL, 'KNDPB3A23D7353856', '', '2013', '', '', '', '2019-07-24 12:04:27', 0, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-08-24 17:04:36', NULL, NULL, '', 'KIA', 'Sportage', '4x2', '-  Cylinders', '2.4', '', 'SOUTH KOREA', 0, 0, 0, '', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(512, 48, 29, NULL, NULL, 'KM8JN72D26U287983', '', '2006', '', '', '', '2019-07-24 12:05:51', 0, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-08-24 17:09:00', NULL, NULL, '', 'HYUNDAI', 'Tucson', 'AWD/All Wheel Drive', '-  Cylinders', '2.7', '', 'SOUTH KOREA', 0, 0, 0, '', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(513, 48, 29, NULL, NULL, 'KNDJF723567143478', '', '2006', '', '', '', '2019-07-22 12:13:09', 0, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-08-24 17:13:24', NULL, NULL, '', 'KIA', 'Sportage', '4x2', '-  Cylinders', '2.7', '', 'SOUTH KOREA', 0, 0, 0, '', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(514, 48, 29, NULL, NULL, 'KNDKGCA34A7673025', '', '2010', '', '', '', '2019-07-22 12:14:33', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-08-24 17:15:00', NULL, NULL, '', 'KIA', 'Sportage', '4WD/4-Wheel Drive/4x4', 'V-Shaped- 6 Cylinders', '2.7', '', 'SOUTH KOREA', 0, 0, 0, '', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(515, 48, 30, NULL, NULL, '2B3LJ44VX9H526685', 'NO KEY', '2009', '', '', '', '2019-07-10 12:17:09', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-08-24 17:17:34', NULL, NULL, '', 'DODGE', 'Challenger', 'RWD/ Rear Wheel Drive', '- 6 Cylinders', '3.5', '', '', 0, 0, 0, '', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(516, 48, 27, NULL, NULL, 'KMHFH4JG3EA377229', '', '2014', 'HLXU6548164', '609796', 'LOADED', '2019-07-19 14:33:35', 3, NULL, NULL, 381, 3706, '2019-08-31 14:03:09', '2019-10-09 14:03:29', 0, 1, NULL, 6, 0, 0, 0, 0, '2019-10-19 17:24:43', NULL, NULL, '', 'HYUNDAI', 'Azera', '', '-  Cylinders', '3.3', '', 'SOUTH KOREA', 0, 0, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?booking=68017422', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(517, 48, 27, NULL, NULL, '5TDZT38A45S242016', '', '2005', 'HLXU6548164', '609796796', 'LOADED', '2019-08-09 14:32:31', 3, NULL, NULL, 381, 3706, '2019-08-31 14:27:28', '2019-10-09 14:27:38', 0, 1, NULL, 6, 0, 0, 0, 0, '2019-10-19 17:24:12', NULL, NULL, '', 'TOYOTA', 'Sequoia', '4x2', 'V-Shaped- 8 Cylinders', '4.7', '', 'UNITED STATES (USA)', 0, 0, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?booking=68017422', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(518, 48, 27, NULL, NULL, 'KMHGC4DD9CU204508', '', '2012', 'UACU545951', '', '', '2019-08-26 17:08:36', 3, NULL, NULL, 381, 1, '2019-09-21 12:00:00', '2019-11-04 12:00:24', 0, 1, NULL, 6, NULL, NULL, NULL, NULL, '2019-09-12 17:01:01', NULL, NULL, '', 'HYUNDAI', 'Genesis', '', '-  Cylinders', '3.8', '', 'SOUTH KOREA', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=UACU++5645951', 0, '', 'vehicle received with key and title ', NULL, 0, '0', '0', NULL, -1, 0),
(519, 48, 27, NULL, NULL, 'KMHDU4AD5AU954893', '', '2010', 'UACU5645951', '', '', '2019-08-27 15:01:30', 3, NULL, NULL, 381, 1, '2019-09-21 12:07:29', '2019-11-04 12:07:36', 0, 1, NULL, 6, 0, 0, 0, 0, '2019-10-19 17:22:46', '2019-08-27 15:03:05', NULL, '', 'HYUNDAI', 'Elantra', '', '- 4 Cylinders', '2.0', '', 'SOUTH KOREA', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=UACU++5645951', 1, '', 'vehicle received with title and key ', NULL, 0, '0', '0', NULL, -1, 0),
(520, 48, 27, NULL, NULL, 'KNDJF724797625060', '', '2009', 'UACU5645951', '', '', '2019-08-27 15:35:47', 3, NULL, NULL, 381, 1, '2019-09-21 12:04:16', '2019-11-04 12:04:25', 0, 1, NULL, 6, NULL, NULL, NULL, NULL, '2019-09-12 17:05:46', NULL, NULL, '', 'KIA', 'Sportage', '4x2', '-  Cylinders', '2', 'RED', 'SOUTH KOREA', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=UACU++5645951', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(521, 48, 29, NULL, NULL, '5NPDH4AEXGH668610', '', '2016', '', '', '', '2019-08-29 14:38:40', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-09-30 20:51:36', NULL, NULL, '', 'HYUNDAI', 'Elantra', '', '- 4 Cylinders', '1.8', '', 'UNITED STATES (USA)', 0, 0, 0, '', 0, '', '', 27, 1, '0', '0', NULL, -1, 0),
(522, 48, 27, NULL, NULL, '5TDZY68A88S002443', '', '2008', 'HLXU8615765', '609791', 'LOADED', NULL, 3, NULL, NULL, 381, 3706, '2019-09-07 15:36:46', '2019-10-16 15:38:42', 1, 1, NULL, 6, NULL, NULL, NULL, NULL, '2019-08-31 18:33:38', NULL, NULL, '', 'TOYOTA', 'Sequoia', '4x2', 'V-Shaped- 8 Cylinders', '5.7', '', 'UNITED STATES (USA)', 0, 0, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=HLXU++8615765', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(523, 48, 27, NULL, NULL, 'KM8SN4HF9HU241775', '', '2017', 'UACU5468692', '609793', 'LOADED', NULL, 3, NULL, NULL, 381, 3706, '2019-08-31 16:10:26', '2019-10-09 16:10:52', 0, 1, NULL, 6, NULL, NULL, NULL, NULL, '2019-08-29 21:13:30', NULL, NULL, '', 'HYUNDAI', 'Santa Fe', '4x2', 'V-Shaped- 6 Cylinders', '3.3', '', 'SOUTH KOREA', 0, 0, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=UACU++5468692', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(524, 48, 27, NULL, NULL, '5TBT441X4S449482', '', '1995', 'UACU5468692', '609793', 'LOADED', NULL, 3, NULL, NULL, 381, 3706, '2019-08-31 16:20:33', '2019-10-09 16:20:46', 0, 1, NULL, 6, NULL, NULL, NULL, NULL, '2019-08-29 21:22:46', NULL, NULL, '', 'TOYOTA', 'TUNDRA ', '', '-  Cylinders', '', '', '', 0, 0, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=UACU++5468692', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(525, 48, 27, NULL, NULL, '5TBET34196S523856', '', '2006', 'UACU5468692', '609793', 'LOADED', NULL, 3, NULL, NULL, 381, 3706, '2019-08-31 16:25:47', '2019-10-09 16:25:56', 1, 1, NULL, 6, NULL, NULL, NULL, NULL, '2019-08-29 21:29:06', NULL, NULL, '', 'TOYOTA', 'Tundra', '4x2', 'V-Shaped- 8 Cylinders', '4.7', '', 'UNITED STATES (USA)', 0, 0, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=UACU++5468692', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(526, 48, 30, NULL, NULL, 'WBA3A5C56CF259508', '', '2012', '', '', '', '2019-08-29 16:41:57', 1, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-09-30 20:51:18', NULL, NULL, '', 'BMW', '328i', '', '- 4 Cylinders', '2.00', '', 'GERMANY', 0, 0, 0, '', 0, '', '', 27, 1, '0', '0', NULL, -1, 0),
(527, 48, 27, NULL, NULL, '5N3AA08D38N912311', '', '2008', 'HLBU2410837', '609775', 'LOADED', '2019-08-30 11:13:08', 3, NULL, NULL, 381, 3706, '2019-09-21 12:24:09', '2019-11-04 12:24:16', 1, 1, NULL, 6, 0, 0, 0, 0, '2019-09-23 20:37:28', NULL, NULL, '', 'INFINITI', 'QX56', '4x2', '-  Cylinders', '5.6', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-container.html?container=HLBU++2410837', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(528, 48, 27, NULL, NULL, 'JS1GT78A3D2102957', '', '2013', 'UACU5645951', '', '', '2019-08-30 11:20:27', 3, NULL, NULL, 381, 1, '2019-09-21 11:58:30', '2019-11-11 11:58:06', 0, 1, NULL, 6, NULL, NULL, NULL, NULL, '2019-09-12 17:11:53', NULL, NULL, '', 'SUZUKI', 'GSX-R1000L/GSX-R1000ZL', '', '- 4 Cylinders', '0.999000', '', 'JAPAN', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=UACU++5645951', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(529, 48, 27, NULL, NULL, '5N3AA08C76N800163', '', '2006', 'MEDU9382479', '', '', '2019-08-31 11:29:06', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 1, NULL, 6, NULL, NULL, NULL, NULL, '2019-11-02 20:32:36', NULL, NULL, '', 'INFINITI', 'QX56', '4WD/4-Wheel Drive/4x4', '-  Cylinders', '5.6', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.msc.com/track-a-shipment?link=e7029d69-a288-4ce2-a020-2284cc4d542f', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(530, 48, 27, NULL, NULL, 'KNDJP3A50E7106362', '', '2014', 'HLBU2410837', '609775', 'LOADED', '2019-03-23 12:08:17', 3, NULL, NULL, 381, 3706, '2019-09-21 12:26:35', '2019-11-04 12:26:42', 1, 1, NULL, 6, 0, 0, 0, 0, '2019-09-23 20:39:58', NULL, NULL, '', 'KIA', 'Soul', '4x2', '-  Cylinders', '2.0', '', 'SOUTH KOREA', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-container.html?container=HLBU++2410837', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(531, 48, 27, NULL, NULL, '5TBET38136S514225', '', '2006', 'HLBU1294814', '', 'LOADED', NULL, 3, NULL, NULL, 381, 3706, '2019-09-21 12:36:15', '2019-11-04 12:36:23', 0, 1, NULL, 6, 0, 0, 0, 0, '2019-09-23 20:40:33', NULL, NULL, '', 'TOYOTA', 'Tundra', '4x2', 'V-Shaped- 8 Cylinders', '4.7', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=HLBU++1294814', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(532, 48, 27, NULL, NULL, '5NPEU46F57H197449', '', '2007', 'HLBU2410837', '609775', 'LOADED', '2019-09-03 11:09:56', 3, NULL, NULL, 381, 3706, '2019-09-21 12:23:15', '2019-11-04 12:23:22', 1, 1, NULL, 6, 0, NULL, 0, 0, '2019-09-23 20:36:48', NULL, NULL, '', 'HYUNDAI', 'Sonata', '', '-  Cylinders', '3.3', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-container.html?container=HLBU++2410837', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(533, 48, 31, NULL, NULL, 'JT5VN94TXL0017971', '', '1990', 'HLBU1816441', '609330', 'TELEX RELEASE', '2019-09-01 11:20:59', 3, NULL, NULL, 381, 1, '2019-11-11 11:39:17', '2019-12-25 11:39:23', 1, 1, NULL, 6, 0, 1068, 0, 0, '2019-12-27 17:17:53', NULL, NULL, '', 'TOYOTA', '', 'PICKUP BASE RV ', '-  Cylinders', '', '', 'JAPAN', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=HLBU++1816441', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(534, 48, 31, NULL, NULL, '5NPE24AF5GH405956', '', '2016', '', '', '', NULL, 0, NULL, '2019-10-17 11:43:41', 381, 1, NULL, NULL, 0, 0, NULL, 3, NULL, NULL, NULL, NULL, '2019-11-08 17:43:51', NULL, NULL, '', 'HYUNDAI', 'Sonata', '', 'In-Line- 4 Cylinders', '2.4', '', 'UNITED STATES (USA)', 1, 0, 0, '', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(535, 48, 27, NULL, NULL, '5TFRT54198X017123', '', '2008', 'MEDU8627242', '', '', '2019-09-09 14:17:31', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 6, NULL, NULL, NULL, NULL, '2019-10-04 16:06:14', NULL, NULL, '', 'TOYOTA', 'Tundra', '4x2', 'V-Shaped- 8 Cylinders', '4.7', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.msc.com/track-a-shipment?link=675b5915-f330-4c07-8a9e-d0ad85992670', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(536, 48, 27, NULL, NULL, '5XYZG4AG8BG034965', '', '2011', 'MEDU8627242', '', '', '2019-09-10 11:49:55', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 6, NULL, NULL, NULL, NULL, '2019-10-04 16:07:15', NULL, NULL, '', 'HYUNDAI', 'Santa Fe', '4x2', 'V-Shaped- 6 Cylinders', '3.5', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.msc.com/track-a-shipment?link=675b5915-f330-4c07-8a9e-d0ad85992670', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(537, 48, 37, NULL, NULL, 'House Hold ', 'House Hold ', '', 'MSKU1789115', '609767', '586307109', '2019-09-16 18:12:26', 0, NULL, NULL, 381, 2592, '2019-10-03 14:32:31', '2019-11-17 09:44:59', 0, 1, NULL, 6, 0, 1650, 0, 0, '2019-10-02 15:46:08', NULL, NULL, '', 'House Hold ', '', '', '', '', '', '', 1, 1, 1, 'https://www.maersk.com/tracking/#tracking/586307109', 0, '', 'house hold ', NULL, 0, '0', '0', NULL, -1, 0),
(538, 48, 37, NULL, NULL, '1FA6P8THXK5140297', '', '2019', 'MSKU1789115', '609767', '586307109', '2019-09-17 16:32:36', 3, NULL, '2019-09-19 14:33:09', 381, 2592, '2019-10-03 14:32:01', '2019-11-17 09:44:32', 0, 1, NULL, 6, 0, 1650, 0, 0, '2019-10-02 15:45:32', NULL, NULL, '', 'FORD', 'Mustang', '', 'In-Line- 4 Cylinders', '5', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.maersk.com/tracking/#tracking/586307109', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(539, 48, 27, NULL, NULL, '5TBRT34196S479164', '', '2006', 'MEDU8627242', '', '', '2019-09-16 13:03:00', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 6, NULL, NULL, NULL, NULL, '2019-10-04 16:09:33', NULL, NULL, '', 'TOYOTA', 'Tundra', '4x2', 'V-Shaped- 8 Cylinders', '4.7', '', 'UNITED STATES (USA)', 0, 1, 0, 'https://www.msc.com/track-a-shipment?link=675b5915-f330-4c07-8a9e-d0ad85992670', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(540, 48, 27, NULL, NULL, '5TFEM5F16AX010418', '', '2010', '', '', '', '2019-09-16 13:21:41', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-09-18 17:36:29', NULL, NULL, '', 'TOYOTA', 'Tundra', '4x2', 'V-Shaped- 8 Cylinders', '4.6', '', 'UNITED STATES (USA)', 1, 1, 0, '', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(541, 48, 27, NULL, NULL, '5XYKT4A25BG118680', '', '2011', 'DFSU7103386', '', '', '2019-09-16 16:24:38', 3, NULL, NULL, 381, 1, '2019-11-23 13:44:09', '2020-01-06 13:44:16', 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-11-13 19:44:21', NULL, NULL, '', 'KIA', 'Sorento', '4x2', 'V-Shaped- 6 Cylinders', '3.5', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=DFSU++7103386', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(542, 48, 27, 17, NULL, '5TFRM5F16EX072960', '', '2014', 'UACU5759975', '609739', '', '2019-09-18 10:38:07', 3, NULL, NULL, 381, 3706, '2019-10-26 13:19:36', '2019-12-09 13:19:42', 1, 1, NULL, 6, NULL, NULL, NULL, NULL, '2019-10-19 18:21:21', NULL, NULL, '', 'TOYOTA', 'Tundra', '4x2', 'V-Shaped- 8 Cylinders', '4.6', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?booking=69354115', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(543, 48, 27, NULL, NULL, '1D7HA16K05J627822', '', '2005', 'UACU5759975', '609739', '', '2019-09-18 16:25:12', 3, NULL, NULL, 381, 3706, '2019-10-26 13:21:49', '2019-12-09 13:21:56', 1, 1, NULL, 6, NULL, NULL, NULL, NULL, '2019-10-19 18:23:00', NULL, NULL, '', 'DODGE', 'Ram', '4x2', 'V-Shaped- 6 Cylinders', '3.7', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?booking=69354115', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(544, 48, 26, NULL, NULL, 'KM8SC13D36U071324', '', '2006', 'SEGU4615342', '609343', 'LOADED', '2019-09-19 11:09:00', 3, NULL, NULL, 381, 1, '2019-10-28 14:03:10', NULL, 1, 1, NULL, 6, 0, 0, 267, 0, '2019-11-12 15:44:07', NULL, NULL, '', 'HYUNDAI', 'Santa Fe', 'FWD/Front Wheel Drive', '-  Cylinders', '2.7', '', 'SOUTH KOREA', 1, 1, 0, '', 0, '', '', NULL, 0, NULL, '0', NULL, -1, 0),
(545, 48, 27, NULL, NULL, '2C3CDXCT7EH147925', '', '2014', 'MEDU9382479', '', '', '2019-09-25 13:11:30', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 1, NULL, 6, NULL, NULL, NULL, NULL, '2019-11-02 20:49:18', NULL, NULL, '', 'DODGE', 'Charger', 'RWD/ Rear Wheel Drive', '- 8 Cylinders', '5.7', '', '', 0, 1, 0, 'https://www.msc.com/track-a-shipment?link=e7029d69-a288-4ce2-a020-2284cc4d542f', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(546, 48, 27, NULL, NULL, 'KNAFE121075460678', '', '2007', 'MEDU9382479', '', '', '2019-09-25 13:21:31', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 1, NULL, 6, NULL, NULL, NULL, NULL, '2019-10-05 16:35:13', NULL, NULL, '', 'KIA', 'Spectra', '', '-  Cylinders', '2', '', 'SOUTH KOREA', 1, 1, 0, 'https://www.msc.com/track-a-shipment?link=e7029d69-a288-4ce2-a020-2284cc4d542f', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(547, 48, 27, NULL, NULL, 'JTEBU11F970019545', '', '2007', 'MEDU9382479', '', '', '2019-09-24 13:47:08', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 1, NULL, 6, NULL, NULL, NULL, NULL, '2019-10-05 16:33:48', NULL, NULL, '', 'TOYOTA', 'FJ Cruiser', '4WD/4-Wheel Drive/4x4', 'V-Shaped- 6 Cylinders', '4.0', '', 'JAPAN', 1, 1, 0, 'https://www.msc.com/track-a-shipment?link=e7029d69-a288-4ce2-a020-2284cc4d542f', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(548, 48, 27, NULL, NULL, 'KMHFC4DF0BA532493', '', '2011', 'TCNU6697731', '', '', '2019-09-24 13:59:07', 3, NULL, NULL, 381, 3706, '2019-10-26 12:50:55', '2019-12-09 12:51:05', 1, 1, NULL, 6, NULL, NULL, NULL, NULL, '2019-10-19 17:51:23', NULL, NULL, '', 'HYUNDAI', 'Azera', '', '-  Cylinders', '3.8', '', 'SOUTH KOREA', 0, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=TCNU++6697731', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(549, 48, 27, NULL, NULL, '5TFCW5F17AX009845', '', '2010', 'UACU522318', '', '', '2019-09-26 13:07:45', 3, NULL, NULL, 381, 3706, '2019-10-26 13:13:02', '2019-12-09 13:13:08', 1, 1, NULL, 6, NULL, NULL, NULL, NULL, '2019-10-19 18:15:07', NULL, NULL, '', 'TOYOTA', 'Tundra', '4WD/4-Wheel Drive/4x4', 'V-Shaped- 8 Cylinders', '5.7', '', 'UNITED STATES (USA)', 0, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=UACU++5622318', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(550, 48, 36, NULL, NULL, '5TENL42N62Z890746', '', '2002', 'BEAU4985010', '609325', 'TEEX RELEASE', '2019-10-02 13:23:40', 3, NULL, NULL, 381, 4237, '2019-11-09 14:07:53', '2019-12-25 14:10:45', 0, 1, NULL, 6, 200, 1100, 0, 40, '2019-12-17 20:18:57', NULL, NULL, '', 'TOYOTA', 'Tacoma', '4x2', 'In-Line- 4 Cylinders', '2.4', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=BEAU++4985010', 0, '', 'TITLE RECEIVED  MK100\r\nKEYS RECEIVED', NULL, 0, '0', '0', NULL, -1, 0),
(551, 48, 33, NULL, NULL, '3GPA1297', 'CHEVY', '1948', '', '', '', '2019-04-29 11:35:28', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, 60, NULL, NULL, NULL, '2019-09-28 16:38:00', '2019-05-01 11:37:30', NULL, '$100 MONTH', 'CHEVY', 'COE', '', '-  Cylinders', '', '', '', 1, 0, 0, '', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(552, 48, 33, NULL, NULL, '235275P633188', '', '1965', '', '', '', '2019-04-29 11:40:18', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, 60, NULL, NULL, NULL, '2019-09-28 16:50:13', '2019-05-01 11:41:22', NULL, '', 'PONT', '', '', '-  Cylinders', '', '', '', 1, 1, 0, '', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(553, 48, 33, NULL, NULL, '138571L183023', '', '1971', '', '', '', '2019-04-29 12:24:25', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, 60, NULL, NULL, NULL, '2019-09-28 17:39:49', '2019-05-01 12:39:40', NULL, '100', 'CHEVY ', ' monte Carlo', '', '-  Cylinders', '', '', '', 1, 1, 0, '', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(554, 48, 33, NULL, NULL, 'VC56A110259', '', '1956', '', '', '', '2019-04-30 12:26:39', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, 60, NULL, NULL, NULL, '2019-10-01 17:09:49', '2019-05-01 12:27:43', NULL, '', 'CHEY', 'BELAIR', '', '-  Cylinders', '', '', '', 1, 1, 0, '', 1, '', 'alkhateeb79@gmail.com', NULL, 0, '0', '0', NULL, -1, 0),
(555, 48, 27, NULL, NULL, 'WDBRF61J82F186224', '', '2002', 'TCNU6697731', '', '', '2019-09-30 15:05:29', 3, NULL, NULL, 381, 3706, '2019-10-26 12:52:09', '2019-12-09 12:52:21', 1, 1, NULL, 6, NULL, NULL, NULL, NULL, '2019-10-19 17:52:41', NULL, NULL, '', 'MERCEDES-BENZ', 'C-Class', '', 'V-Shaped- 6 Cylinders', '2.60', '', 'GERMANY', 0, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=TCNU++6697731', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(556, 48, 27, NULL, NULL, 'JT3HT05J1W0022663', '', '1998', 'UACU5759975', '609739', '', '2019-10-01 09:43:49', 3, NULL, NULL, 381, 3706, '2019-10-26 13:23:21', '2019-12-09 13:23:27', 1, 1, NULL, 6, NULL, NULL, NULL, NULL, '2019-11-02 20:48:42', NULL, NULL, '', 'TOYOTA', 'LAND CRUISER', '4WD/4-Wheel Drive/4x4', 'V-Shaped- 8 Cylinders', '4.7', '', '', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?booking=69354115', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(557, 48, 32, NULL, NULL, '5TFJU52138X003974', '', '2008', '', '', '', '2019-09-25 09:02:11', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-10-19 17:21:46', NULL, NULL, '', 'TOYOTA', 'Tundra', '4x2', 'V-Shaped- 6 Cylinders', '4', '', 'UNITED STATES (USA)', 1, 1, 0, '', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(558, 48, 27, NULL, NULL, '1D7HU18D15J569032', '', '2005', 'UACU5622318', '', '', '2019-10-07 13:40:31', 3, NULL, NULL, 381, 3706, '2019-10-26 13:15:38', '2019-12-09 13:15:46', 1, 1, NULL, 6, NULL, NULL, NULL, NULL, '2019-10-19 18:16:49', NULL, NULL, '', 'DODGE', 'Ram', '4WD/4-Wheel Drive/4x4', 'V-Shaped- 8 Cylinders', '5.7', '', 'UNITED STATES (USA)', 0, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=UACU++5622318', 0, '', '', NULL, 0, '0', '0', NULL, -1, 0),
(559, 48, 33, 19, NULL, '1J4FA64S16P762799', '', '2006', 'MSKU1237749', '609322', 'SWB', '2019-10-07 12:26:27', 3, NULL, '2019-10-10 08:51:06', 381, 2640, '2019-11-07 10:08:29', '2019-12-14 09:32:41', 1, 1, NULL, 6, 0, 1450, 0, 0, '2019-12-18 21:15:47', NULL, NULL, '', 'JEEP', 'Wrangler', '4WD/4-Wheel Drive/4x4', 'In-Line- 6 Cylinders', '4', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.safmarine.com/tracking/#tracking/MSKU1237749', 0, '', 'TITLE RECEIVED BY FEDEX #776635109564  OCT10/19 plane to loaded with safmarine.com booking#587220821 SHIPMENT ON HOLD FOR DAMEGE INSPECTION  DHL TRACKING #1962142501', NULL, 0, '0', '0', NULL, -1, 0),
(560, 48, 27, NULL, NULL, 'KM8JUCAC0DU574871', '', '2013', 'UACU5622318', '', '', '2019-10-09 10:58:33', 3, NULL, NULL, 381, 3706, '2019-10-26 13:17:15', '2019-12-09 13:17:22', 1, 1, NULL, 6, NULL, NULL, NULL, NULL, '2019-10-19 18:18:21', NULL, NULL, '', 'HYUNDAI', 'Tucson', '4WD/4-Wheel Drive/4x4', '-  Cylinders', '2.4', '', 'SOUTH KOREA', 0, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=UACU++5622318', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(561, 48, 26, NULL, NULL, '5TDZT34AX7S292329', '', '2007', 'SEGU4615342', '609343', 'LOADED', '2019-10-09 11:15:15', 3, NULL, NULL, 381, 1, '2019-10-28 14:02:14', NULL, 1, 1, NULL, 6, 0, 0, 266, 0, '2019-11-12 15:40:35', NULL, NULL, '', 'TOYOTA', 'Sequoia', '4x2', 'V-Shaped- 8 Cylinders', '4.7', '', 'UNITED STATES (USA)', 1, 1, 0, '', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(562, 48, 36, NULL, NULL, '5TDBT48A53S168304', '', '2003', 'BEAU4985010', '609326', 'TELEX RELEASE', '2019-10-18 13:09:35', 3, NULL, NULL, 381, 4237, '2019-11-09 14:11:52', '2019-12-25 14:11:56', 0, 1, NULL, 6, 500, 1100, 0, 40, '2019-12-17 20:20:41', NULL, NULL, '', 'TOYOTA', 'Sequoia', '4WD/4-Wheel Drive/4x4', 'V-Shaped- 8 Cylinders', '4.7', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=BEAU++4985010', 0, '', 'MK102', NULL, 0, '2100', '3748', NULL, -1, 0),
(563, 48, 36, NULL, NULL, '5TBBT44113S434870', '', '2003', 'BEAU4985010', '609326', 'TELEX RELEASE ', '2019-10-12 16:42:26', 3, NULL, NULL, 381, 4237, '2019-11-09 14:13:50', '2019-12-25 14:13:57', 0, 1, NULL, 6, 250, 1100, 0, 40, '2019-12-17 20:19:48', NULL, NULL, '', 'TOYOTA', 'Tundra', '4WD/4-Wheel Drive/4x4', 'V-Shaped- 8 Cylinders', '4.7', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=BEAU++4985010', 0, '', 'vehicle received with key NO TITLE  MK101', NULL, 0, NULL, '2578', NULL, -1, 0),
(564, 48, 26, NULL, NULL, 'WVGBV7AX7DW554519', '', '2013', '', '', '', '2019-10-11 12:30:01', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-10-11 17:33:36', NULL, NULL, '', 'VOLKSWAGEN', 'Tiguan', '', '- 4 Cylinders', '1.984000', '', 'GERMANY', 0, 1, 0, '', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(565, 48, 27, NULL, NULL, '5NPE24AF4GH404183', '', '2016', 'HLBU1089511', '609311', 'LOADED', '2019-10-14 14:35:31', 3, NULL, NULL, 381, 1, '2019-11-02 15:38:29', '2019-12-16 15:38:39', 1, 0, NULL, 6, NULL, NULL, NULL, NULL, '2019-11-02 20:38:59', NULL, NULL, '', 'HYUNDAI', 'Sonata', '', 'In-Line- 4 Cylinders', '2.4', '', 'UNITED STATES (USA)', 0, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=HLBU++1089511', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(566, 48, 27, NULL, NULL, 'JTEZT17R440014462', '', '2004', 'TCNU6697731', '', '', '2019-10-14 14:41:13', 3, NULL, NULL, 381, 1, '2019-10-26 12:54:58', '2019-12-09 12:55:08', 1, 1, NULL, 6, NULL, NULL, NULL, NULL, '2019-10-19 17:55:24', NULL, NULL, '', 'TOYOTA', '4-Runner', '4x2', 'V-Shaped- 8 Cylinders', '4.7', '', 'JAPAN', 0, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=TCNU++6697731', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(567, 48, 40, NULL, NULL, '5TBU34115S456179', '', '1995', '', '', '', NULL, 2, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-10-15 12:11:13', NULL, NULL, '', 'TOYOTA', 'Tundra', '', '-  Cylinders', '', '', '', 0, 0, 0, '', 1, '', '', NULL, 1, NULL, NULL, NULL, -1, 0),
(568, 48, 40, NULL, NULL, '5TBRU34115S456179', '', '2005', 'TCLU5854628', '609314', 'TELEX RELEASE ', '2019-10-16 10:20:06', 3, NULL, NULL, 381, 4346, '2019-11-03 10:48:51', '2019-11-27 18:56:15', 1, 1, NULL, 6, 0, 1100, 0, 0, '2019-11-29 01:40:11', NULL, NULL, '', 'TOYOTA', 'Tundra', '4x2', 'V-Shaped- 6 Cylinders', '4.0', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.msc.com/track-a-shipment?link=ac3d0554-4977-4962-95ea-07fe7668ef7c', 1, '', 'RECEIVED WITH TITLE AND KEY ', NULL, 0, NULL, NULL, NULL, -1, 0),
(569, 48, 27, NULL, NULL, 'KM8SN4HF4HU192422', '', '2017', 'TCNU6697731', '', '', '2019-10-16 10:03:46', 3, NULL, NULL, 381, 3706, '2019-10-26 12:53:06', '2019-12-09 12:53:13', 1, 1, NULL, 6, NULL, NULL, NULL, NULL, '2019-10-19 17:54:10', NULL, NULL, '', 'HYUNDAI', 'Santa Fe', '4x2', 'V-Shaped- 6 Cylinders', '3.3', '', 'SOUTH KOREA', 0, 0, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=TCNU++6697731', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(570, 48, 33, 19, NULL, '1J4FA69S46P789066', '', '2006', 'MSKU1237749', '', 'SWB', '2019-10-21 08:45:18', 3, NULL, NULL, 381, 2640, '2019-10-07 10:07:57', '2019-12-14 09:35:02', 1, 1, NULL, 6, 0, 1450, 0, 0, '2019-12-18 21:15:01', NULL, NULL, '', 'JEEP', 'Wrangler', '4WD/4-Wheel Drive/4x4', 'In-Line- 6 Cylinders', '4', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.safmarine.com/tracking/#tracking/MSKU1237749', 0, '', 'TITLE RECEIVED ONLY NO VEHICLE planed to loaded with safmarine.com booking#587220821 shipment on hold for damage inspection DHL TRACKING #1962142501', NULL, 0, NULL, NULL, NULL, -1, 0),
(571, 48, 40, NULL, NULL, '2G1FA1E39D9168000', '', '2013', 'TCLU5854628', '609314', 'TELEX RELEASE ', '2019-10-17 14:24:02', 3, NULL, NULL, 381, 4346, '2019-11-03 10:40:25', '2019-11-27 18:55:00', 1, 1, NULL, 6, 0, 1100, 0, 0, '2019-11-29 01:38:35', NULL, NULL, '', 'CHEVROLET', 'Camaro', '', '- 6 Cylinders', '3.6', '', 'CANADA', 1, 1, 0, 'https://www.msc.com/track-a-shipment?link=02b60484-8874-4aaf-851f-0d1f1e46ef44', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(572, 48, 40, NULL, NULL, '5TBRN34172S321698', '', '2002', 'TCLU5854628', '609314', 'TELEX ELEASE ', '2019-10-17 14:15:31', 3, NULL, NULL, 381, 4346, '2019-11-03 10:45:37', '2019-11-27 18:55:49', 1, 1, NULL, 6, 0, 1100, 0, 0, '2019-11-29 01:39:27', NULL, NULL, '', 'TOYOTA', 'Tundra', '4x2', 'V-Shaped- 6 Cylinders', '3.4', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.msc.com/track-a-shipment?link=ac3d0554-4977-4962-95ea-07fe7668ef7c', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(573, 48, 27, NULL, NULL, 'WDBUF56X47B130703', '', '2007', 'HLBU1089511', '609311', 'LOADED', '2019-10-16 10:02:28', 3, NULL, NULL, 381, 1, '2019-11-02 15:40:22', '2019-12-16 15:40:29', 1, 1, NULL, 6, NULL, NULL, NULL, NULL, '2019-11-02 20:41:17', NULL, NULL, '', 'MERCEDES-BENZ', 'E-Class', '', 'V-Shaped- 6 Cylinders', '3.5', '', 'GERMANY', 0, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=HLBU++1089511', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(574, 48, 36, NULL, NULL, '4T1F1FK5CU129687', '', '', '', '', '', NULL, 1, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, 160, 0, 0, 40, '2019-10-18 17:03:39', NULL, NULL, '', 'TOYOTA', '', '4x2', '-  Cylinders', '', '', 'JAPAN', 0, 0, 0, '', 0, '', '', NULL, 1, '1590', '2613', NULL, -1, 0),
(575, 48, 36, NULL, NULL, '4T1BF1FK5CU129687', '', '2012', 'TLCU5933509', '609338', 'LOADED', '2019-10-23 12:43:14', 3, NULL, NULL, 381, 1, '2019-11-23 09:15:06', '2020-01-13 09:15:11', 1, 1, NULL, 6, 160, 825, 0, 40, '2019-11-14 15:16:16', NULL, NULL, '', 'TOYOTA', 'Camry', '4x2', 'In-Line- 4 Cylinders', '2.5', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=TLLU++5933509', 0, '', 'MK104', NULL, 0, '1590', '2613', NULL, -1, 0),
(576, 48, 32, NULL, NULL, 'KNDJE723797561614', '', '2009', '', '', '', '2019-10-01 12:13:15', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-10-18 17:14:00', NULL, NULL, '', 'KIA', 'Sportage', '4WD/4-Wheel Drive/4x4', 'V-Shaped- 6 Cylinders', '2.7', '', 'SOUTH KOREA', 0, 0, 0, '', 0, '', '', NULL, 0, '1680', '2200', NULL, -1, 0),
(577, 48, 32, NULL, NULL, '5TFUM5F18AX007919', '', '2010', '', '', '', NULL, 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-10-18 17:15:56', NULL, NULL, '', 'TOYOTA', 'Tundra', '4WD/4-Wheel Drive/4x4', 'V-Shaped- 8 Cylinders', '4.6', '', 'UNITED STATES (USA)', 0, 0, 0, '', 0, '', '', NULL, 0, '2100', '4200', NULL, -1, 0),
(578, 48, 27, NULL, NULL, '5NMSH13E39H303513', '', '2009', 'HLBU1089511', '609311', 'LOADED', '2019-10-18 12:40:52', 3, NULL, NULL, 381, 1, '2019-11-02 15:41:40', '2019-12-16 15:41:45', 0, 1, NULL, 6, NULL, NULL, NULL, NULL, '2019-11-02 20:42:28', NULL, NULL, '', 'HYUNDAI', 'Santa Fe', 'FWD/Front Wheel Drive', '-  Cylinders', '3.3', '', 'UNITED STATES (USA)', 0, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=HLBU++1089511', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(579, 48, 27, NULL, NULL, '5XYKT4A61CG256950', '', '2012', 'HLBU1089511', '609311', 'LOADED', '2019-10-21 11:10:07', 3, NULL, NULL, 381, 3706, '2019-11-02 15:33:44', '2019-12-16 15:36:18', 1, 1, NULL, 6, NULL, NULL, NULL, NULL, '2019-11-02 20:37:17', NULL, NULL, '', 'KIA', 'Sorento', '4x2', '-  Cylinders', '2.4', '', 'UNITED STATES (USA)', 0, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=HLBU++1089511', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(580, 48, 27, NULL, NULL, 'KM8JN12D97U618606', '', '2007', '', '', '', '2019-10-22 11:48:40', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-11-10 03:12:17', NULL, NULL, '', 'HYUNDAI', 'Tucson', 'FWD/Front Wheel Drive', '-  Cylinders', '2.7', '', 'SOUTH KOREA', 1, 1, 0, '', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(581, 48, 36, NULL, NULL, 'KNDPBCA26B7080537', '', '2011', 'TLCU5933509', '609338', 'LOADED', '2019-10-24 16:00:24', 3, NULL, NULL, 381, 1, '2019-11-23 09:06:57', '2020-01-13 09:07:06', 1, 1, NULL, 6, 75, 825, 0, 40, '2019-11-14 15:09:50', NULL, NULL, '', 'KIA', 'Sportage', '4WD/4-Wheel Drive/4x4', '-  Cylinders', '2.4', '', 'SOUTH KOREA', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=TLLU++5933509', 0, '', 'MK105', NULL, 0, '1521', NULL, NULL, -1, 0),
(582, 48, 36, NULL, NULL, '5TFBV54198X082565', '', '2008', 'UACU5872699', '', 'LOADED', '2019-11-13 11:32:01', 3, NULL, NULL, 381, 1, '2019-11-30 10:50:23', '2020-01-20 10:51:17', 1, 1, NULL, 6, 85, 1100, 0, 40, '2019-11-29 17:32:27', NULL, NULL, '', 'TOYOTA', 'Tundra', '4WD/4-Wheel Drive/4x4', 'V-Shaped- 8 Cylinders', '5.7', '', 'UNITED STATES (USA)', 0, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=UACU++5872699', 0, '', 'TITLE PENDING MK103', NULL, 0, NULL, NULL, NULL, -1, 0),
(583, 48, 27, NULL, NULL, '5XYZKDAG0CG107259', '', '2012', 'DFSU7103386', '', '', '2019-10-24 16:32:02', 3, NULL, NULL, 381, 1, '2019-11-23 13:42:08', '2020-01-06 13:42:13', 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-11-13 19:43:12', NULL, NULL, '', 'HYUNDAI', 'Santa Fe', '4WD/4-Wheel Drive/4x4', 'V-Shaped- 6 Cylinders', '3.5', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=DFSU++7103386', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(584, 48, 27, NULL, NULL, '3C6JD6AT0CG136222', '', '2012', '', '', '', '2019-10-28 11:00:50', 3, NULL, NULL, -1, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-11-10 03:16:23', NULL, NULL, '', 'DODGE', 'Ram', '4x2', '- 8 Cylinders', '5.7', '', '', 1, 1, 0, '', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(585, 48, 36, NULL, NULL, 'KM8JN12D15U178460', '', '2005', 'TLCU5933509', '609338', 'LOADED', '2019-11-01 14:21:53', 3, NULL, NULL, 381, 1, '2019-11-23 09:10:19', '2020-01-13 09:10:28', 1, 1, NULL, 6, 225, 825, 0, 40, '2019-11-14 15:11:58', NULL, NULL, '', 'HYUNDAI', 'Tucson', 'FWD/Front Wheel Drive', '-  Cylinders', '2.7', '', 'SOUTH KOREA', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=TLLU++5933509', 0, '', 'MK106', NULL, 0, '1450', '988', NULL, -1, 0),
(586, 48, 36, NULL, NULL, '4T1BK36BX7U194015', '', '2007', 'TLCU5933509', '609338', 'LOADED', '2019-11-04 07:16:53', 3, NULL, NULL, 381, 1, '2019-11-23 09:12:32', '2020-01-13 09:12:40', 1, 1, NULL, 6, 75, 825, 0, 40, '2019-11-14 15:14:08', NULL, NULL, '', 'TOYOTA', 'Avalon', '4x2', 'V-Shaped- 6 Cylinders', '3.5', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=TLLU++5933509', 0, '', 'MK107', NULL, 0, NULL, '1478', NULL, -1, 0),
(587, 48, 27, NULL, NULL, 'KNAFE161985010524', '', '2008', 'DFSU7103386', '', '', '2019-11-01 15:19:41', 3, NULL, NULL, 381, 1, '2019-11-23 13:40:38', '2020-01-06 13:40:47', 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-11-13 19:41:10', NULL, NULL, '', 'KIA', 'Spectra', '', 'In-Line- 4 Cylinders', '2', '', 'SOUTH KOREA', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=DFSU++7103386', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0);
INSERT INTO `car` (`id`, `mainId`, `shipperId`, `vendorId`, `customerId`, `uuid`, `description`, `year`, `container`, `seal`, `inlandStatus`, `cargoRecieved`, `titleRecieved`, `titleNumber`, `stRecieved`, `origin`, `destination`, `etd`, `eta`, `loadrequest`, `releaseOption`, `consigneeId`, `state`, `landcost`, `seacost`, `fees`, `commision`, `lastUpdate`, `storageStartDate`, `storageEndDate`, `note`, `make`, `model`, `bodyStyle`, `engineType`, `engineLiters`, `color`, `assemlyCountry`, `photoExist`, `docExist`, `type`, `containerLink`, `allowSendEmail`, `emailToSendComment`, `commentToSend`, `mainTwoId`, `deleted`, `weight`, `valueOfGood`, `releaseDate`, `stateOut`, `mobileOrComp`) VALUES
(588, 48, 27, NULL, NULL, 'KNAFW6A36A5263695', '', '2010', 'DFSU7103386', '', '', '2019-11-01 21:06:30', 3, NULL, NULL, 381, 1, '2019-11-23 13:37:57', '2020-01-06 13:39:30', 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-11-13 19:40:00', NULL, NULL, '', 'KIA', 'Forte', '', '-  Cylinders', '2.4', '', 'SOUTH KOREA', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=DFSU++7103386', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(589, 48, 36, NULL, NULL, '5TDBK23C77S006549', '', '2007', 'UACU58726999', '609361', 'LOADED', '2019-11-07 14:32:10', 6, NULL, NULL, 381, 1, '2019-11-30 13:07:42', '2020-01-20 13:07:48', 1, 1, NULL, 6, 450, 1100, 0, 40, '2019-11-28 16:26:34', NULL, NULL, '', 'TOYOTA', 'Sienna', '4WD/4-Wheel Drive/4x4', 'V-Shaped- 6 Cylinders', '3.5', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=UACU++5872699', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(590, 48, 27, NULL, NULL, '5NMSG13D79H262829', '', '2009', '', '', '', '2019-11-06 09:44:10', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-11-10 02:57:03', NULL, NULL, '', 'HYUNDAI', 'Santa Fe', 'FWD/Front Wheel Drive', '-  Cylinders', '2.7', '', 'UNITED STATES (USA)', 1, 1, 0, '', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(591, 48, 31, NULL, NULL, '5NPET4AC0AH609882', '', '2010', 'HLBU1816441', '609330', 'TELEX ELE', '2019-10-21 11:27:56', 3, NULL, NULL, 381, 1, '2019-11-11 11:41:39', '2019-12-25 11:41:45', 1, 1, NULL, 6, 0, 1066, 0, 0, '2019-12-27 17:17:15', NULL, NULL, '', 'HYUNDAI', 'Sonata', '', '-  Cylinders', '2.4', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=HLBU++1816441', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(592, 48, 31, NULL, NULL, 'KNAGM4A72F5568880', '', '2015', 'HLBU1816441', '609330', 'TELEX ELEASE ', '2019-10-25 11:54:01', 3, NULL, NULL, 381, 1, '2019-11-11 11:54:33', '2019-12-25 11:54:38', 1, 1, NULL, 6, 0, 1066, 0, 0, '2019-12-27 17:16:15', NULL, NULL, '', 'KIA', 'Optima', '', '-  Cylinders', '2.4', '', 'SOUTH KOREA', 0, 0, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=HLBU++1816441', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(593, 48, 40, 20, NULL, '5XYKU4A25BG101245', '', '2011', 'APHU6315423', '', 'TELEX RELEASE ', '2019-11-14 10:44:48', 3, NULL, NULL, 381, 4346, '2019-12-23 12:45:59', '2020-01-24 11:23:20', 1, 1, NULL, 6, 0, 1134, 0, 0, '2020-02-04 11:05:09', NULL, NULL, '', 'KIA', 'SORENTO', '', '', '', '', '', 1, 1, 0, 'https://www.cma-cgm.com/ebusiness/tracking/search?SearchBy=Booking&Reference=NAM3738611&search=Search', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(594, 48, 40, 20, NULL, 'WDDHF5GBXBA476264', '', '2011', 'CMAU7646023', '609355', 'LOADED', '2019-11-14 13:22:40', 3, NULL, NULL, 381, 4346, '2019-12-23 12:38:30', '2020-01-17 12:38:39', 1, 1, NULL, 6, 0, 875, 0, 0, '2020-01-23 18:04:06', NULL, NULL, '', 'MERCEDES', 'E 350', '', '', '', '', '', 1, 1, 0, 'https://www.cma-cgm.com/ebusiness/tracking/search?SearchBy=Booking&Reference=nam3732369&search=Search', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(595, 48, 40, 20, NULL, 'SALSH23406A944338', '', '2006', 'CMAU7646023', '609355', 'LOADED', '2019-11-14 10:53:42', 3, NULL, NULL, 381, 4346, '2019-12-23 12:37:01', '2020-01-17 12:40:34', 1, 1, NULL, 6, 0, 875, 0, 0, '2020-01-23 18:02:38', NULL, NULL, '', 'LAND ROVER', 'Range Rover Sport', '', 'V-Shaped- 8 Cylinders', '4.2', '', 'ENGLAND', 1, 1, 0, 'https://www.cma-cgm.com/ebusiness/tracking/search?SearchBy=Booking&Reference=nam3732369&search=SearchCMA', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(596, 48, 27, NULL, NULL, '5TDZT38A51S004816', '', '2001', '', '', '', '2019-11-07 15:18:10', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-11-10 02:40:44', NULL, NULL, '', 'TOYOTA', 'Sequoia', '4x2', 'V-Shaped- 8 Cylinders', '4.7', '', 'UNITED STATES (USA)', 0, 1, 0, '', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(597, 48, 27, NULL, NULL, '5NMSG13D89H323153', '', '2009', '', '', '', '2019-11-09 20:36:23', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-11-10 02:37:46', NULL, NULL, '', 'HYUNDAI', 'Santa Fe', 'FWD/Front Wheel Drive', '-  Cylinders', '2.7', '', 'UNITED STATES (USA)', 1, 1, 0, '', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(598, 48, 27, NULL, NULL, 'YV1RH59H542379880', '', '2004', '', '', '', '2019-11-12 15:35:10', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, 0, 0, 0, 0, '2019-11-12 21:39:13', NULL, NULL, '', 'VOLVO', 'S60', 'AWD/All Wheel Drive', '-  Cylinders', '', '', 'BELGIUM', 0, 1, 0, '', 0, '', '', NULL, 0, '1681', '300', NULL, -1, 0),
(599, 48, 36, NULL, NULL, 'JT3GN86R9V0055367', '', '1997', 'UACU5872699', '609361', 'LOADED', '2019-11-18 08:56:54', 3, NULL, NULL, 381, 1, '2019-11-30 13:03:09', '2020-01-20 13:03:23', 1, 1, NULL, 6, 200, 1100, 0, 40, '2019-11-28 16:27:08', NULL, NULL, '', 'TOYOTA ', '4RUNNER ', '', '', '', '', '', 0, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html?view=S8510&container=UACU++5872699', 0, '', 'MK109', NULL, 0, NULL, NULL, NULL, -1, 0),
(600, 48, 36, NULL, NULL, 'IFTPW14514KC33145', '', '2004', 'FDCU0182538', '609843', 'LOADED', '2019-11-26 11:36:34', 3, NULL, NULL, 381, 1, '2020-02-01 13:26:22', '2020-03-13 13:26:54', 0, 0, NULL, 0, 550, 1166, 40, 40, '2020-01-27 19:27:04', NULL, NULL, '', 'FORD', 'F150', '', '', '', '', '', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-container.html?container=FDCU++0182538', 0, '', 'MK110   $40 storage ', NULL, 0, NULL, NULL, NULL, -1, 0),
(601, 48, 36, NULL, NULL, '5XYZG3AB2BG025094', '', '2011', 'FDCU0182538', '609843', 'LOADED', '2019-11-20 10:24:46', 3, NULL, '2020-01-14 11:50:37', 381, 1, '2020-02-01 13:29:46', '2020-03-13 13:29:52', 0, 0, NULL, 0, 300, 1168, 0, 40, '2020-01-27 19:31:16', NULL, NULL, '', 'HYUNDAI', 'Santa Fe', '', '', '', '', '', 0, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-container.html?container=FDCU++0182538', 0, '', 'MK111  title received by fedex 1/14/2020', NULL, 0, NULL, NULL, NULL, -1, 0),
(602, 48, 26, NULL, NULL, '1J4RS5GT8BC557426', '', '2011', '', '', '', '2019-11-18 16:28:15', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-11-19 01:50:30', NULL, NULL, '', 'JEEP', 'Grand Cherokee', '4x2', '- 8 Cylinders', '5.7', '', '', 1, 1, 0, '', 0, '', 'vehicle received with NO KEY ', NULL, 0, NULL, NULL, NULL, -1, 0),
(603, 48, 26, NULL, NULL, 'KNDJE723377367014', '', '2007', '', '', '', '2019-11-20 13:49:09', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-11-21 19:59:55', NULL, NULL, '', 'KIA', 'Sportage', '4WD/4-Wheel Drive/4x4', 'V-Shaped- 6 Cylinders', '2.7', '', 'SOUTH KOREA', 0, 1, 0, '', 0, '', 'PLANE TO BE LOADED WITH ABES BOOKING#68690209', NULL, 0, NULL, NULL, NULL, -1, 0),
(604, 48, 36, NULL, NULL, 'WDBUF65J95A729795', '', '2005', 'FDCU0182538', '609843', 'LOADED', '2019-11-21 13:02:23', 3, NULL, NULL, 381, 1, '2020-02-01 13:28:39', '2020-03-13 13:32:00', 0, 0, NULL, 0, 120, 1166, 0, 40, '2020-01-27 19:32:15', NULL, NULL, '', 'MERCEDES-BENZ', 'E-Class', '', 'V-Shaped- 6 Cylinders', '3.20', '', 'GERMANY', 1, 1, 0, 'https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-container.html?container=FDCU++0182538', 0, '', 'MK112', NULL, 0, NULL, NULL, NULL, -1, 0),
(605, 48, 33, 21, NULL, '70031024', '', '1948', 'MRKU5203914', '1395791', 'LOADED', '2019-11-20 08:24:39', 3, NULL, '2019-11-19 08:24:46', 381, 4358, '2019-12-22 11:41:01', '2020-02-06 14:09:44', 1, 1, NULL, 6, 900, 2030, 200, 75, '2019-12-21 17:42:25', NULL, NULL, '', 'CHRYSLER', 'BUSINESS COUPE', '', '-  Cylinders', '', '', '', 1, 1, 0, 'https://www.safmarine.com/tracking/#tracking/MRKU5203914', 0, '', 'Houston custom but hold on the container 12/18/2019 and released the hold 12/12/2019 with charges $360 for random inspaction ', NULL, 0, NULL, NULL, NULL, -1, 0),
(606, 48, 40, 20, NULL, '1D7HA18N35S357647', '', '2005', 'ECMU9621290', '609807', 'LOADED', '2019-11-25 15:15:21', 3, '', NULL, 381, 1, '2020-01-13 10:56:19', NULL, 0, 0, NULL, 0, 0, 1150, 0, 0, '2020-02-10 18:41:54', NULL, NULL, '', 'DODGE', 'Ram', '4x2', 'V-Shaped- 8 Cylinders', '4.7', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.cma-cgm.com/ebusiness/tracking/search?SearchBy=Container&Reference=ecmu9621290&search=Search', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(607, 48, 40, 20, NULL, 'WBA3A9C53DF477012', '', '2013', 'ECMU9621290', '609807', 'LOADED', '2019-11-27 10:18:39', 3, '', NULL, 381, 1, '2020-01-13 10:57:29', NULL, 0, 0, NULL, 0, 0, 1150, 0, 0, '2020-02-10 18:44:12', NULL, NULL, '', 'BMW', '335i', '', '- 6 Cylinders', '3.0', '', 'GERMANY', 1, 1, 0, 'https://www.cma-cgm.com/ebusiness/tracking/search?SearchBy=Container&Reference=ecmu9621290&search=Search', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(608, 48, 40, NULL, NULL, 'JTEBU11F170006319', '', '2007', 'CMAU7646023', '609355', 'LOADED', '2019-11-25 15:18:39', 3, NULL, NULL, 381, 4346, '2019-12-23 12:34:58', '2020-01-17 12:35:08', 1, 1, NULL, 6, 0, 875, 0, 0, '2020-01-23 18:04:51', NULL, NULL, '', 'TOYOTA', 'FJ Cruiser', '4WD/4-Wheel Drive/4x4', 'V-Shaped- 6 Cylinders', '4.0', '', 'JAPAN', 1, 1, 0, 'https://www.cma-cgm.com/ebusiness/tracking/search?SearchBy=Booking&Reference=nam3732369&search=Search', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(609, 48, 33, 21, NULL, '9726863', '', '1931', 'MRKU5203914', '1395791', 'LODED', '2019-11-25 10:42:46', 3, NULL, NULL, 381, 4358, '2019-12-22 11:43:34', '2020-02-05 14:12:35', 1, 1, NULL, 6, 960, 2030, 200, 75, '2019-12-21 17:43:41', NULL, NULL, '', 'WILLYS', 'ROADSTER ', '', '', '', '', '', 1, 1, 0, 'https://www.safmarine.com/tracking/#tracking/MRKU5203914', 0, '', 'Houston custom but hold on the container 12/18/2019 and released the hold 12/12/2019 with charges $360 for randem check ', NULL, 0, NULL, NULL, NULL, -1, 0),
(610, 48, 26, NULL, NULL, '1V5AA2221N1341244', 'BOAT', '1992', '', '', '', '2019-11-25 15:39:30', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-12-01 02:03:25', NULL, NULL, '', 'MAGNUM TRAILERS OF AUSTIN', '', '', '-  Cylinders', '', '', '', 1, 1, 0, '', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(611, 48, 40, 20, NULL, 'WBAVB33526PS17829', '', '2006', 'APHU6947298', '609810', 'LOADED  ', '2019-11-26 11:42:34', 3, '', NULL, 381, 1, '2020-01-13 12:55:45', NULL, 0, 0, NULL, 0, 0, 875, 0, 0, '2020-02-10 18:36:29', NULL, NULL, '', 'BMW', '330i', '', '- 6 Cylinders', '3', '', 'GERMANY', 0, 1, 0, 'https://www.cma-cgm.com/ebusiness/tracking/search?SearchBy=Container&Reference=aphu6947298&search=Search', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(612, 48, 40, NULL, NULL, 'WBA3A5G56DNP26752', '', '2013', 'CMAU7646023', '609355', 'LOADED', '2019-12-06 12:28:54', 3, NULL, NULL, 381, 4346, '2019-12-23 12:30:23', '2020-01-17 12:31:59', 1, 1, NULL, 6, 0, 875, 0, 0, '2020-01-23 18:05:53', NULL, NULL, '', 'BMW', '328', '', '', '', '', '', 1, 1, 0, 'https://www.cma-cgm.com/ebusiness/tracking/search?SearchBy=Booking&Reference=nam3732369&search=Search', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(613, 48, 40, 20, NULL, '5TBET34194S458939', '', '2004', 'APHU6315423', '', 'LOADED', '2019-12-06 12:25:48', 3, NULL, NULL, 381, 4346, '2019-12-23 11:22:08', '2020-01-24 11:22:16', 1, 1, NULL, 6, 0, 1133, 0, 0, '2020-01-23 18:09:36', NULL, NULL, '', 'TOYOTA', 'Tundra', '4x2', 'V-Shaped- 8 Cylinders', '4.7', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.cma-cgm.com/ebusiness/tracking/search?SearchBy=Booking&Reference=NAM3738611&search=Search', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(614, 48, 40, NULL, NULL, '5TFHW5F13JX704698', '', '2018', 'APHU6315423', '', 'LOADED', '2019-12-09 22:37:03', 3, NULL, NULL, 381, 4346, '2019-12-23 12:43:10', '2020-01-24 11:19:27', 1, 1, NULL, 6, 0, 1133, 0, 0, '2020-01-23 18:08:36', NULL, NULL, '', 'TOYOTA', 'Tundra', '4WD/4-Wheel Drive/4x4', 'V-Shaped- 8 Cylinders', '5.7', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.cma-cgm.com/ebusiness/tracking/search?SearchBy=Booking&Reference=NAM3738611&search=Search', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(615, 48, 27, NULL, NULL, '5UXFG83589LZ93740', '', '2009', '', '', '', '2019-12-02 14:23:52', 3, NULL, NULL, -1, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-12-05 04:52:53', NULL, NULL, '', 'BMW', 'X6', '', '- 8 Cylinders', '4.4', '', 'UNITED STATES (USA)', 1, 0, 0, '', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(616, 48, 36, NULL, NULL, 'KNAFE121665282516', '', '2006', '', '', '', '2019-12-09 12:55:35', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, 200, NULL, NULL, 40, '2019-12-10 04:37:13', NULL, NULL, '', 'KIA', 'Spectra', '', '-  Cylinders', '2', '', 'SOUTH KOREA', 1, 1, 0, '', 0, '', 'MK113', NULL, 0, NULL, NULL, NULL, -1, 0),
(617, 48, 40, NULL, NULL, 'WBA3A9G5XDNP37518', '', '2013', 'APHU6947298', '609810', 'LOADED', '2019-12-06 12:30:37', 3, '', NULL, 381, 1, '2020-01-13 13:00:14', NULL, 0, 0, NULL, 0, 0, 875, 0, 0, '2020-02-10 18:37:31', NULL, NULL, '', 'BMW', '335i', '', '- 6 Cylinders', '3.0', '', 'SOUTH AFRICA', 1, 1, 0, 'https://www.cma-cgm.com/ebusiness/tracking/search?SearchBy=Container&Reference=aphu6947298&search=Search', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(618, 48, 40, NULL, NULL, 'KNDPB3A25D7514546', '', '2013', 'APHU6947298', '609810', 'LOADED', '2019-12-13 22:31:09', 3, '', NULL, 381, 1, '2020-01-13 12:54:04', NULL, 0, 0, NULL, 0, 0, 875, 0, 0, '2020-02-10 18:35:47', NULL, NULL, '', 'KIA', 'Sportage', '4x2', '-  Cylinders', '2.4', '', 'SOUTH KOREA', 1, 1, 0, 'https://www.cma-cgm.com/ebusiness/tracking/search?SearchBy=Container&Reference=aphu6947298&search=Search', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(619, 48, 40, NULL, NULL, '5TBRT3161S189697', '', '1995', '', '', '', '2019-12-17 15:02:11', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2019-12-18 21:10:20', NULL, NULL, '', 'TOYOTA', '', '4x2', 'V-Shaped- 8 Cylinders', '4.7', '', '', 0, 1, 0, '', 0, '', '', NULL, 1, NULL, NULL, NULL, -1, 0),
(620, 48, 40, 20, NULL, '5XXGT4L32GG072975', '', '2016', '', '', '', '2019-12-17 13:29:18', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2020-01-13 18:48:58', NULL, NULL, 'NO TITLE NO KEY ', 'KIA', 'Optima', '', '- 4 Cylinders', '2.4', '', 'UNITED STATES (USA)', 0, 1, 0, '', 0, '', 'NO TITLE NO KEY title received 01/13/2020 by fedex 7774459887172', NULL, 0, NULL, '2764', NULL, -1, 0),
(621, 48, 40, NULL, NULL, '5TBRT34161S189697', '', '2001', 'ECMU9621290', '609807', 'LOADED', '2019-12-17 15:11:18', 3, '', NULL, 381, 1, '2020-01-13 10:58:43', NULL, 0, 0, NULL, 0, 0, 1150, 0, 0, '2020-02-10 18:45:47', NULL, NULL, '', 'TOYOTA', 'Tundra', '4x2', 'V-Shaped- 8 Cylinders', '4.7', '', 'UNITED STATES (USA)', 0, 1, 0, 'https://www.cma-cgm.com/ebusiness/tracking/search?SearchBy=Container&Reference=ecmu9621290&search=Search', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(622, 48, 40, 20, NULL, 'KNAFK4A6XF5429203', '', '2015', 'CAIU8075076', '609811', 'LOADED', '2019-12-24 13:34:35', 3, '', NULL, 381, 1, '2020-01-13 10:39:52', NULL, 0, 0, NULL, 0, 0, 875, 0, 0, '2020-02-10 18:27:56', NULL, NULL, '', 'KIA', 'Forte', '', '- 4 Cylinders', '1.8', '', 'SOUTH KOREA', 1, 1, 0, 'https://www.cma-cgm.com/ebusiness/tracking/search?SearchBy=Container&Reference=caiu8075076&search=Search', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(623, 48, 40, 20, NULL, '5XXGM4A71FG358284', '', '2015', 'CAIU8075076', '609811', 'LOADED', '2019-12-20 20:44:11', 3, '', NULL, 381, 1, '2020-01-13 10:41:18', NULL, 0, 0, NULL, 0, 0, 875, 0, 0, '2020-02-10 18:28:39', NULL, NULL, '', 'KIA', 'Optima', '', '-  Cylinders', '2.4', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.cma-cgm.com/ebusiness/tracking/search?SearchBy=Container&Reference=caiu8075076&search=SearchCA', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(624, 48, 40, 20, NULL, '5XXGT4L33GG052895', '', '2016', 'CAIU8075076', '609811', 'LOADED', '2019-12-20 13:39:54', 3, '', NULL, 381, 1, '2020-01-13 10:45:20', NULL, 0, 0, NULL, 0, 0, 875, 0, 0, '2020-02-10 18:30:44', NULL, NULL, '', 'KIA', 'Optima', '', '- 4 Cylinders', '2.4', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.cma-cgm.com/ebusiness/tracking/search?SearchBy=Container&Reference=caiu8075076&search=Search', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(625, 48, 40, NULL, NULL, 'WDDHF7HB9AA100129', '', '2010', 'CAIU8075076', '609811', 'LOADED', '2019-12-20 17:18:55', 3, '', NULL, 381, 1, '2020-01-13 10:43:10', NULL, 0, 0, NULL, 0, 0, 875, 0, 0, '2020-02-10 18:29:53', NULL, NULL, '', 'MERCEDES-BENZ', 'E-Class', '', 'V-Shaped- 8 Cylinders', '6.2', '', 'GERMANY', 1, 1, 0, 'https://www.cma-cgm.com/ebusiness/tracking/search?SearchBy=Container&Reference=caiu8075076&search=Search', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(626, 48, 37, NULL, NULL, '1N4AL3AP9HC143814', '', '2017', 'TCLU5685894', '609818', '', '2019-12-20 13:47:15', 3, NULL, NULL, 381, 2598, '2020-01-16 15:14:47', '2020-02-16 15:14:57', 0, 0, NULL, 0, 0, 1350, 75, 0, '2020-01-23 17:35:43', NULL, NULL, '', 'NISSAN', 'Altima', '4x2', 'In-Line- 4 Cylinders', '2.5', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.safmarine.com/tracking/#tracking/TCLU5685894', 0, '', 'TITLE AND KEYS WERE RECEIVED BY MO, split bill of loading $75', NULL, 0, NULL, NULL, NULL, -1, 0),
(627, 48, 37, NULL, NULL, '2C4RDGBG5DR650131', '', '2013', 'TCLU5685894', '609818', '', '2019-12-20 13:52:38', 3, NULL, NULL, 381, 2598, '2020-01-16 15:13:16', '2020-02-16 15:14:04', 0, 0, NULL, 0, 0, 1350, 75, 0, '2020-01-23 17:34:36', NULL, NULL, '', 'DODGE', 'Grand Caravan', 'FWD/Front Wheel Drive', '- 6 Cylinders', '3.6', '', 'CANADA', 1, 1, 0, 'https://www.safmarine.com/tracking/#tracking/TCLU5685894', 0, '', 'TITLE AND KEYS WERE RECEIVED BY MO , split bill of loading $75', NULL, 0, NULL, NULL, NULL, -1, 0),
(628, 48, 40, NULL, NULL, '5NMSG13D79H262104', '', '2009', 'TCNU9344975', '609813', 'LOADED', '2019-12-24 19:46:36', 3, '', NULL, 381, 1, '2020-01-13 13:36:21', NULL, 0, 0, NULL, 0, 0, 1150, 0, 0, '2020-02-10 18:32:25', NULL, NULL, '', 'HYUNDAI', 'Santa Fe', 'FWD/Front Wheel Drive', '-  Cylinders', '2.7', '', 'UNITED STATES (USA)', 1, 1, 0, 'https://www.cma-cgm.com/ebusiness/tracking/search?SearchBy=Container&Reference=tcnu9344975&search=Search', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(629, 48, NULL, NULL, NULL, '4T3ZF13CX2U486459', '', '2002', 'TCNU9344975', '609813', 'LOADED', NULL, 0, '', NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, 0, 1150, 0, 0, '2020-02-10 18:33:25', NULL, NULL, '', 'TOYOTA', 'Sienna', '4x2', 'V-Shaped- 6 Cylinders', '3.0', '', 'UNITED STATES (USA)', 0, 1, 0, 'https://www.cma-cgm.com/ebusiness/tracking/search?SearchBy=Container&Reference=tcnu9344975&search=Search', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(630, 48, 40, 20, NULL, 'KMHGC4DD1DU247063', '', '2013', 'APHU6947298', '609810', 'LOADED', '2019-12-27 14:13:01', 3, '', NULL, 381, 1, '2020-01-13 12:58:41', NULL, 0, 0, NULL, 0, 0, 875, 0, 0, '2020-02-10 18:40:40', NULL, NULL, '', 'HYUNDAI', 'Genesis', '', '-  Cylinders', '3.8', '', 'SOUTH KOREA', 1, 1, 0, 'https://www.cma-cgm.com/ebusiness/tracking/search?SearchBy=Container&Reference=aphu6947298&search=Search', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(631, 48, 40, 20, NULL, 'JT3DJ81W7P0023824', '', '1993', '', '', '', '2020-01-06 22:10:32', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2020-01-23 17:23:48', NULL, NULL, '', 'TOYOTA', 'LAND CRUISER', '4WD/4-Wheel Drive/4x4', 'In-Line- 6 Cylinders', '4.5', '', 'JAPAN', 1, 1, 0, '', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(632, 48, 40, 20, NULL, 'JT3GN86R610192647', '', '2001', 'TCNU9344975', '609813', 'LOADED', '2020-01-03 10:31:39', 3, '', NULL, 381, 1, '2020-01-13 13:38:25', NULL, 0, 0, NULL, 0, 0, 1150, 0, 0, '2020-02-10 18:34:21', NULL, NULL, '', 'TOYOTA', '4-Runner', '4x2', 'V-Shaped- 6 Cylinders', '3.4', '', 'JAPAN', 0, 1, 0, 'https://www.cma-cgm.com/ebusiness/tracking/search?SearchBy=Container&Reference=tcnu9344975&search=Search', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(633, 48, 40, 20, NULL, '5XYKTDA2XDG402129', '', '2013', '', '', '', '2020-01-17 15:31:22', 6, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2020-01-23 17:14:32', NULL, NULL, '', 'KIA', 'Sorento', '4WD/4-Wheel Drive/4x4', 'V-Shaped- 6 Cylinders', '3.5', '', 'UNITED STATES (USA)', 1, 1, 0, '', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(634, 48, 40, 20, NULL, 'JTEZT17R830011949', '', '2003', '', '', '', '2020-01-15 17:50:23', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2020-01-17 16:33:19', NULL, NULL, '', 'TOYOTA', '4-Runner', '4x2', 'V-Shaped- 8 Cylinders', '4.7', '', 'JAPAN', 1, 1, 0, '', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(635, 48, 40, 20, NULL, '5TESN92N23Z164314', '', '2003', '', '', '', '2020-01-15 17:53:28', 3, NULL, NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, NULL, NULL, NULL, NULL, '2020-01-17 16:37:09', NULL, NULL, 'NO KEY ', 'TOYOTA', 'Tacoma', '4x2', 'V-Shaped- 6 Cylinders', '3.4', '', 'UNITED STATES (USA)', 1, 1, 0, '', 0, '', 'NO KEY ', NULL, 0, NULL, NULL, NULL, -1, 0),
(636, 48, 30, NULL, NULL, '1C6RR6FG8HS804638', 'PARTS', '2017', '', '', '', '2019-11-15 13:56:07', 3, NULL, NULL, 381, 3706, NULL, NULL, 0, 0, NULL, 0, NULL, 200, 0, 0, '2020-01-30 20:08:53', NULL, NULL, '', 'RAM', '1500', '4x2', 'V-Shaped- 6 Cylinders', '3.6', '', 'UNITED STATES (USA)', 0, 0, 0, '', 0, '', '', NULL, 0, '2100', '700', NULL, -1, 0),
(726, 53, NULL, NULL, NULL, 'WBAGJ8320VDM08065', 'new car', '1997', NULL, NULL, '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, NULL, 8, 0, 0, 0, 0, '2020-02-11 06:57:58', NULL, NULL, NULL, 'BMW', '740iL', '', '- 8 Cylinders', '4.398', '', 'GERMANY', 1, 0, 1, '', 0, NULL, NULL, NULL, 0, '0', '0', '2020-02-07 06:49:26', 2, 0),
(727, 48, 40, 20, NULL, 'WBAFU7C54BC876860', '', '2011', '', '', '', '2020-02-11 11:31:16', 3, '', NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, 0, 0, 0, 0, '2020-02-12 17:32:07', NULL, NULL, '', 'BMW', '535i', '', '- 6 Cylinders', '3.0', '', 'GERMANY', 0, 1, 0, '', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(728, 48, 40, 20, NULL, '5TEUU42N97Z414653', '', '2007', '', '', '', '2020-02-11 12:03:34', 3, '', NULL, 381, 1, NULL, NULL, 0, 0, NULL, 0, 0, 0, 0, 0, '2020-02-12 18:03:59', NULL, NULL, '', 'TOYOTA', 'TACOMA', '', '', '', '', '', 0, 1, 0, '', 0, '', '', NULL, 0, NULL, NULL, NULL, -1, 0),
(729, 48, NULL, NULL, NULL, '5TBDT48196S539020', '', '2006', NULL, NULL, '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, 0, 0, 0, 0, 0, '2020-02-13 16:29:32', NULL, NULL, NULL, 'TOYOTA', 'Tundra', '4WD/4-Wheel Drive/4x4', 'V-Shaped- 8 Cylinders', '4.7', '', 'UNITED STATES (USA)', 1, 0, 0, '', 0, NULL, NULL, NULL, 1, '0', '0', NULL, 0, 0),
(731, 48, NULL, NULL, NULL, 'JTDKN3DU0A0096304', '', '2010', NULL, NULL, '0', NULL, 0, NULL, NULL, -1, -1, NULL, NULL, 0, 0, NULL, 0, 0, 0, 0, 0, '2020-02-16 06:58:26', NULL, NULL, NULL, 'TOYOTA', 'PRIUS', '4x2', 'In-Line- 4 Cylinders', '1.8', '', 'JAPAN', 0, 0, 0, '', 0, NULL, NULL, NULL, 0, '0', '0', NULL, 0, 1),
(732, 48, NULL, NULL, NULL, 'Salmp1e41aa316106', '', '2010', '', '', '0', NULL, 0, '', NULL, -1, 1, NULL, NULL, 0, 0, NULL, 0, 0, 0, 0, 0, '2020-02-14 03:46:28', NULL, NULL, '', 'LAND ROVER', 'Range Rover', '', 'V-Shaped- 8 Cylinders', '5.0', '', 'ENGLAND', 1, 0, 0, '', 0, '', '', NULL, 1, '0', '0', NULL, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `carimage`
--

CREATE TABLE `carimage` (
  `id` int(11) NOT NULL,
  `url` varchar(45) DEFAULT NULL,
  `carId` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `deleted` int(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `carimage`
--

INSERT INTO `carimage` (`id`, `url`, `carId`, `type`, `deleted`) VALUES
(527, 'img13121727891496750644.jpg', 475, 0, 0),
(528, 'img9755497851359919681.jpg', 475, 0, 0),
(529, 'pdf15990824897024387729.pdf', 475, 2, 0),
(530, 'img4904582403385137949.jpg', 518, 0, 0),
(531, 'img15765999787129191320.jpg', 518, 0, 0),
(532, 'img18127485303323693723.jpg', 518, 0, 0),
(533, 'img9319621321994199926.jpg', 518, 0, 0),
(534, 'img14673891987303179920.jpg', 518, 0, 0),
(535, 'img619173934247597850.jpg', 518, 0, 0),
(536, 'pdf18295478206352882758.pdf', 518, 2, 0),
(537, 'img12902947674474547216.jpg', 519, 0, 0),
(538, 'img7278498087274313389.jpg', 519, 0, 0),
(539, 'img15758403682722340599.jpg', 519, 0, 0),
(540, 'img200520848761420681.jpg', 519, 0, 0),
(541, 'img6847785175012359040.jpg', 519, 0, 0),
(542, 'img13691288641481236385.jpg', 519, 0, 0),
(543, 'pdf10473223165247975657.pdf', 519, 2, 0),
(544, 'pdf10569543108947197277.pdf', 519, 2, 0),
(545, 'img17205617110583793584.jpg', 477, 0, 0),
(546, 'img14363376725143978470.jpg', 477, 0, 0),
(547, 'img17073902597324669699.jpg', 477, 0, 0),
(548, 'img17948791718485688463.jpg', 477, 0, 0),
(549, 'pdf14189844970305096784.pdf', 477, 2, 0),
(550, 'pdf3970535983778790710.pdf', 477, 2, 0),
(551, 'img781077038303400272.jpg', 478, 0, 0),
(552, 'img15500885956021177065.jpg', 478, 0, 0),
(553, 'img16917129445244872651.jpg', 478, 0, 0),
(554, 'img4688145472593452892.jpg', 478, 0, 0),
(555, 'img827263160927881728.jpg', 478, 0, 0),
(556, 'pdf16182916473845157690.pdf', 478, 2, 0),
(557, 'pdf14002986713561838334.pdf', 478, 2, 0),
(558, 'pdf13443057688398217980.pdf', 479, 2, 0),
(559, 'pdf12007043519672993826.pdf', 479, 2, 0),
(560, 'img1712280686893573655.jpg', 480, 0, 0),
(561, 'img10401313315838598886.jpg', 480, 0, 0),
(562, 'img7825887560797954705.jpg', 480, 0, 0),
(563, 'img14192283492723533897.jpg', 480, 0, 0),
(564, 'img8177111982353402198.jpg', 480, 0, 0),
(565, 'pdf12243394205186721983.pdf', 480, 2, 0),
(566, 'pdf7863154867808118151.pdf', 480, 2, 0),
(567, 'img9561358829276328420.jpg', 481, 0, 0),
(568, 'img10614728060170450565.jpg', 481, 0, 0),
(569, 'img16576833051722058103.jpg', 481, 0, 0),
(570, 'img2247793188788720686.jpg', 481, 0, 0),
(571, 'img13990738285231471817.jpg', 481, 0, 0),
(572, 'img2812212824141760989.jpg', 481, 0, 0),
(573, 'pdf17566195451293582094.pdf', 481, 2, 0),
(574, 'pdf12659346396607842145.pdf', 481, 2, 0),
(575, 'img12096438872581655233.jpg', 482, 0, 0),
(576, 'img8169772255357707441.jpg', 482, 0, 0),
(577, 'img6182689155537183850.jpg', 482, 0, 0),
(578, 'img4917957824287565614.jpg', 482, 0, 0),
(579, 'img1859731574251853274.jpg', 482, 0, 0),
(580, 'img7933857804898090309.jpg', 482, 0, 0),
(581, 'pdf10903879328646491021.pdf', 482, 2, 0),
(582, 'pdf18264633570574457540.pdf', 482, 2, 0),
(583, 'img15491990383204658159.jpg', 484, 0, 0),
(584, 'img7284243394688635004.jpg', 484, 0, 0),
(585, 'img10817598535467001930.jpg', 484, 0, 0),
(586, 'img1447809945793582238.jpg', 484, 0, 0),
(587, 'img12673699212221085984.jpg', 484, 0, 0),
(588, 'img17895328263804464141.jpg', 484, 0, 0),
(589, 'img1591813113933629895.jpg', 484, 0, 0),
(590, 'pdf10124816022050674322.pdf', 484, 2, 0),
(591, 'pdf6184081318801816893.pdf', 484, 2, 0),
(592, 'img15034993918373527598.jpg', 485, 0, 0),
(593, 'img3232217273084749575.jpg', 485, 0, 0),
(594, 'img3988449999850203140.jpg', 485, 0, 0),
(595, 'img10231969937309147152.jpg', 485, 0, 0),
(596, 'img8316714139765199185.jpg', 485, 0, 0),
(597, 'img10853372419830406288.jpg', 485, 0, 0),
(598, 'pdf11524313750546533036.pdf', 485, 2, 0),
(599, 'pdf10031531611862268546.pdf', 485, 2, 0),
(600, 'img219925552832848391.jpg', 486, 0, 0),
(601, 'img9728164143291207816.jpg', 486, 0, 0),
(602, 'img4329508803424834415.jpg', 486, 0, 0),
(603, 'img6173372052464140193.jpg', 486, 0, 0),
(604, 'img14636598649911800673.jpg', 486, 0, 0),
(605, 'img11122678048638529985.jpg', 486, 0, 0),
(606, 'pdf4858243460494312443.pdf', 486, 2, 0),
(607, 'img9943695385449113169.jpg', 488, 0, 0),
(608, 'img211681834903664006.jpg', 488, 0, 0),
(609, 'img10710116645693415286.jpg', 488, 0, 0),
(610, 'img16291902616356114507.jpg', 488, 0, 0),
(611, 'img6678644944822958407.jpg', 488, 0, 0),
(612, 'img239377545659621425.jpg', 488, 0, 0),
(613, 'img280386260442141510.jpg', 488, 0, 0),
(614, 'img15598254020550757107.jpg', 489, 0, 0),
(615, 'img13673602544129634171.jpg', 489, 0, 0),
(616, 'img11492656631828040945.jpg', 489, 0, 0),
(617, 'img1632231005756942849.jpg', 489, 0, 0),
(618, 'img16432302977323325990.jpg', 489, 0, 0),
(619, 'pdf16190742140619294157.pdf', 489, 2, 0),
(620, 'img9209444962410867497.jpg', 490, 0, 0),
(621, 'img13601206934541062081.jpg', 490, 0, 0),
(622, 'img6585700270302096089.jpg', 490, 0, 0),
(623, 'img11627503146779503063.jpg', 490, 0, 0),
(624, 'img13137268728698408766.jpg', 490, 0, 0),
(625, 'img16696469037790699552.jpg', 490, 0, 0),
(626, 'img3330344858661527884.jpg', 490, 0, 0),
(627, 'pdf14472944860374353506.pdf', 490, 2, 0),
(628, 'img389869749612999630.jpg', 491, 0, 0),
(629, 'img4152040109404274128.jpg', 491, 0, 0),
(630, 'img17895094189962914146.jpg', 491, 0, 0),
(631, 'img1188501303310628672.jpg', 491, 0, 0),
(632, 'img5900347275721146681.jpg', 491, 0, 0),
(633, 'img2092429179508118400.jpg', 491, 0, 0),
(634, 'pdf5727809928876959389.pdf', 491, 2, 0),
(635, 'pdf14475743749402297713.pdf', 491, 2, 0),
(636, 'img15607313693187429995.jpg', 492, 0, 0),
(637, 'img17873950735495395725.jpg', 492, 0, 0),
(638, 'img18199939357609828131.jpg', 492, 0, 0),
(639, 'img1054346091263092427.jpg', 492, 0, 0),
(640, 'img9714929957137430530.jpg', 492, 0, 0),
(641, 'img12425960742694275697.jpg', 492, 0, 0),
(642, 'pdf5555385437544495454.pdf', 492, 2, 0),
(643, 'pdf5295015769404393587.pdf', 492, 2, 0),
(644, 'img3938458850349014874.jpg', 483, 0, 0),
(645, 'img10795911929480853396.jpg', 483, 0, 0),
(646, 'img4694667832734690140.jpg', 483, 0, 0),
(647, 'img2544343859269816415.jpg', 483, 0, 0),
(648, 'img1643437439958183639.jpg', 483, 0, 0),
(649, 'img7091768057567446185.jpg', 483, 0, 0),
(650, 'pdf16480014380908841795.pdf', 483, 2, 0),
(651, 'pdf17323401529984634766.pdf', 483, 2, 0),
(652, 'img2129771951670679599.jpg', 487, 0, 0),
(653, 'img9163657246584310010.jpg', 487, 0, 0),
(654, 'img4323635178399545734.jpg', 487, 0, 0),
(655, 'img11640276852099735927.jpg', 487, 0, 0),
(656, 'img2280748023402045785.jpg', 487, 0, 0),
(657, 'img2719675908820271779.jpg', 487, 0, 0),
(658, 'pdf8760093550158043701.pdf', 487, 2, 0),
(659, 'pdf12442522934556194101.pdf', 487, 2, 0),
(660, 'img5654647695841780483.jpg', 520, 0, 0),
(661, 'img6486497517598137632.jpg', 520, 0, 0),
(662, 'img6983621713189655349.jpg', 520, 0, 0),
(663, 'img120171239033534496.jpg', 520, 0, 0),
(664, 'img11192508397608352835.jpg', 520, 0, 0),
(665, 'img4911081336475629735.jpg', 520, 0, 0),
(666, 'pdf17446314350897814407.pdf', 520, 2, 0),
(667, 'pdf831853144020759646.pdf', 520, 2, 0),
(668, 'img17364227775198462403.jpg', 493, 0, 0),
(669, 'img12257322535895597954.jpg', 493, 0, 0),
(670, 'pdf7320027306087511949.pdf', 493, 2, 0),
(671, 'img11818293591677355893.jpg', 493, 0, 0),
(672, 'img2175539764068872600.jpg', 493, 0, 0),
(673, 'img2558022211623870818.jpg', 493, 0, 0),
(674, 'pdf10258743472415728967.pdf', 493, 2, 0),
(675, 'img16527273990426223325.jpg', 527, 0, 0),
(676, 'img18434396313449989123.jpg', 527, 0, 0),
(677, 'img15130264523858892435.jpg', 527, 0, 0),
(678, 'img11969276814541350071.jpg', 527, 0, 0),
(679, 'img4553231568200636958.jpg', 527, 0, 0),
(680, 'img8484863533883555407.jpg', 527, 0, 0),
(681, 'pdf14300354971634298752.pdf', 527, 2, 0),
(682, 'pdf2128091899883070633.pdf', 527, 2, 0),
(683, 'img5143441340853124200.jpg', 528, 0, 0),
(684, 'img4465364204145689617.jpg', 528, 0, 0),
(685, 'img3893853693377017887.jpg', 528, 0, 0),
(686, 'img11863087950592117616.jpg', 528, 0, 0),
(687, 'img12779387385739702214.jpg', 528, 0, 0),
(688, 'pdf9451434728463331231.pdf', 528, 2, 0),
(689, 'pdf17662073520910574328.pdf', 528, 2, 0),
(690, 'img3396272955373021545.jpg', 529, 0, 0),
(691, 'img17984973542183835841.jpg', 529, 0, 0),
(692, 'img7816031397350702580.jpg', 529, 0, 0),
(693, 'img17816113607962922178.jpg', 529, 0, 0),
(694, 'img2065265273276837434.jpg', 529, 0, 0),
(695, 'img18068235077935773631.jpg', 529, 0, 0),
(696, 'pdf2191515647329082792.pdf', 494, 2, 0),
(697, 'pdf16916267214683504266.pdf', 494, 2, 0),
(698, 'img6279495474049185438.jpg', 530, 0, 0),
(699, 'img13455986432239335714.jpg', 530, 0, 0),
(700, 'pdf12210062493903493607.pdf', 530, 2, 0),
(701, 'pdf13368200449809251873.pdf', 530, 2, 0),
(702, 'img12683286625117702244.jpg', 494, 0, 0),
(703, 'img6194755383693877017.jpg', 494, 0, 0),
(704, 'img13121371422465297914.jpg', 494, 0, 0),
(705, 'img14644318963376353093.jpg', 494, 0, 0),
(706, 'img7986804810091172944.jpg', 494, 0, 0),
(707, 'img6719662947641916252.jpg', 494, 0, 0),
(708, 'img13283538413084968925.jpg', 495, 0, 0),
(709, 'img15241202619581492014.jpg', 495, 0, 0),
(710, 'img179307970277948231.jpg', 495, 0, 0),
(711, 'img10980326122016844333.jpg', 495, 0, 0),
(712, 'img11914303013415681822.jpg', 495, 0, 0),
(713, 'img905762002423301835.jpg', 495, 0, 0),
(714, 'pdf13419936715437389575.pdf', 495, 2, 0),
(715, 'pdf14064544764203167349.pdf', 495, 2, 0),
(716, 'img1489752978007417838.jpg', 502, 0, 0),
(717, 'img3793698610745197777.jpg', 502, 0, 0),
(718, 'img16443608692766770352.jpg', 502, 0, 0),
(719, 'img16449906697427176300.jpg', 502, 0, 0),
(720, 'img7319575431956291945.jpg', 502, 0, 0),
(721, 'img12444782241036195051.jpg', 502, 0, 0),
(722, 'pdf3708907379606961458.pdf', 502, 2, 0),
(723, 'pdf13088943671173018315.pdf', 502, 2, 0),
(724, 'img1831782912603151439.jpg', 531, 0, 0),
(725, 'img2260762711448079430.jpg', 531, 0, 0),
(726, 'img17166600742580505666.jpg', 531, 0, 0),
(727, 'img17574970951005952780.jpg', 531, 0, 0),
(728, 'img16734744338478680461.jpg', 531, 0, 0),
(729, 'img18031013122898495375.jpg', 531, 0, 0),
(730, 'pdf8380382056504460361.pdf', 531, 2, 0),
(731, 'pdf1819929573769973670.pdf', 531, 2, 0),
(732, 'pdf10806211974325160054.pdf', 532, 2, 0),
(733, 'pdf9887468019266502.pdf', 532, 2, 0),
(734, 'pdf9294940225013279242.pdf', 533, 2, 0),
(735, 'pdf12593722248914200223.pdf', 533, 2, 0),
(736, 'img914076331854470644.jpg', 534, 0, 0),
(737, 'img7286708144461235430.jpg', 534, 0, 0),
(738, 'img6830825570581362201.jpg', 534, 0, 0),
(739, 'img780804830434627805.jpg', 534, 0, 0),
(740, 'img396948359211000182.jpg', 534, 0, 0),
(741, 'img3443779592697168550.jpg', 534, 0, 0),
(742, 'img4334148387644140473.jpg', 532, 0, 0),
(743, 'img1037831493668685146.jpg', 532, 0, 0),
(744, 'img1485362558415357341.jpg', 532, 0, 0),
(745, 'img14179915728135241804.jpg', 532, 0, 0),
(746, 'img14957488163096158058.jpg', 532, 0, 0),
(747, 'img13081625336387643356.jpg', 532, 0, 0),
(748, 'img730535419487914211.jpg', 533, 0, 0),
(749, 'img9878471994164693742.jpg', 533, 0, 0),
(750, 'img3386282681934829679.jpg', 533, 0, 0),
(751, 'img2533481955381692772.jpg', 533, 0, 0),
(752, 'img15540912678980540758.jpg', 533, 0, 0),
(753, 'pdf15502472528687805136.pdf', 535, 2, 0),
(754, 'pdf15366060308189752626.pdf', 535, 2, 0),
(755, 'img18156325682219213044.jpg', 535, 0, 0),
(756, 'img2430641829576618006.jpg', 535, 0, 0),
(757, 'img16430837022036931180.jpg', 535, 0, 0),
(758, 'img9859944103508385730.jpg', 535, 0, 0),
(759, 'img5290000239943728463.jpg', 535, 0, 0),
(760, 'img14882973568951529857.jpg', 536, 0, 0),
(761, 'img7584354393148615438.jpg', 536, 0, 0),
(762, 'img4959437837380163929.jpg', 536, 0, 0),
(763, 'img8200149607846558694.jpg', 536, 0, 0),
(764, 'img6557757951928991868.jpg', 536, 0, 0),
(765, 'pdf15067944886116890320.pdf', 536, 2, 0),
(766, 'pdf8568527341841909590.pdf', 536, 2, 0),
(767, 'img6832718137767680203.jpg', 537, 0, 0),
(768, 'img12410982824947661037.jpg', 537, 0, 0),
(769, 'img4257624205992760648.jpg', 537, 0, 0),
(770, 'img6885759772215070245.jpg', 537, 0, 0),
(771, 'img17226266559575126586.jpg', 537, 0, 0),
(772, 'pdf8139538438549949780.pdf', 539, 2, 0),
(773, 'pdf7191412818641580991.pdf', 539, 2, 0),
(774, 'pdf10951898429192147442.pdf', 540, 2, 0),
(775, 'pdf10285696023301760108.pdf', 540, 2, 0),
(776, 'pdf3215391478399080747.pdf', 541, 2, 0),
(777, 'pdf13277056646683187292.pdf', 541, 2, 0),
(778, 'img6370118006173602671.jpg', 538, 0, 0),
(779, 'img2116760115410438541.jpg', 538, 0, 0),
(780, 'img16356133539087725066.jpg', 538, 0, 0),
(781, 'img3578745329869760159.jpg', 538, 0, 0),
(782, 'img7108694485284416726.jpg', 540, 0, 0),
(783, 'img16900815037710838503.jpg', 540, 0, 0),
(784, 'img16147191254032165894.jpg', 540, 0, 0),
(785, 'img9544477040858195939.jpg', 540, 0, 0),
(786, 'img11809075354484726277.jpg', 540, 0, 0),
(787, 'pdf10738814092602994943.pdf', 538, 2, 0),
(788, 'img4257359026699606935.jpg', 542, 0, 0),
(789, 'img12122396748886330292.jpg', 542, 0, 0),
(790, 'img11059668049126919219.jpg', 542, 0, 0),
(791, 'img833855263014310674.jpg', 542, 0, 0),
(792, 'img17765265371162851869.jpg', 542, 0, 0),
(793, 'img8399295191096301511.jpg', 542, 0, 0),
(794, 'img16724628589669636579.jpg', 543, 0, 0),
(795, 'img1415937835134135783.jpg', 543, 0, 0),
(796, 'img5369087429284567841.jpg', 543, 0, 0),
(797, 'img15412410245412626457.jpg', 543, 0, 0),
(798, 'img12361669906300058818.jpg', 543, 0, 0),
(799, 'img17890711102584914065.jpg', 543, 0, 0),
(800, 'pdf13794555885071022371.pdf', 543, 2, 0),
(801, 'pdf2190612479007869353.pdf', 543, 2, 0),
(802, 'img4007722454517221836.jpg', 544, 0, 0),
(803, 'img14273056448275764275.jpg', 544, 0, 0),
(804, 'img3903186917924231018.jpg', 544, 0, 0),
(805, 'img6137945868920233619.jpg', 544, 0, 0),
(806, 'img7560258750090179704.jpg', 544, 0, 0),
(807, 'img7466996158545938920.jpg', 544, 0, 0),
(808, 'pdf6854274275405212853.pdf', 544, 2, 0),
(809, 'pdf1655039633005846564.pdf', 544, 2, 0),
(810, 'img16962500925241601593.jpg', 479, 0, 0),
(811, 'img5805224549821402006.jpg', 479, 0, 0),
(812, 'img4312315503009213734.jpg', 479, 0, 0),
(813, 'img14856686809866674985.jpg', 479, 0, 0),
(814, 'img12684589657053160509.jpg', 479, 0, 0),
(815, 'img1285993021106584967.jpg', 479, 0, 0),
(816, 'img9814187096347725972.jpg', 479, 0, 0),
(817, 'img14810295082362900816.jpg', 479, 0, 0),
(818, 'pdf4535887256134809134.pdf', 545, 2, 0),
(819, 'pdf1711235256419966988.pdf', 545, 2, 0),
(820, 'img15487111003388598327.jpg', 546, 0, 0),
(821, 'img728220962341183897.jpg', 546, 0, 0),
(822, 'img12998157932344041258.jpg', 546, 0, 0),
(823, 'img477797732008313126.jpg', 546, 0, 0),
(824, 'img6735177894239175379.jpg', 546, 0, 0),
(825, 'img10840945446600088059.jpg', 546, 0, 0),
(826, 'pdf3789821370899384353.pdf', 546, 2, 0),
(827, 'pdf14433245023667487239.pdf', 546, 2, 0),
(828, 'img16183374068737282230.jpg', 547, 0, 0),
(829, 'img15115306229269254262.jpg', 547, 0, 0),
(830, 'img2306704521594653803.jpg', 547, 0, 0),
(831, 'img3960266896214799983.jpg', 547, 0, 0),
(832, 'img17968548031169291285.jpg', 547, 0, 0),
(833, 'img2311062142146367114.jpg', 547, 0, 0),
(834, 'pdf7927243996932465432.pdf', 547, 2, 0),
(835, 'pdf11944784877015331871.pdf', 547, 2, 0),
(836, 'pdf9714169142082672163.pdf', 548, 2, 0),
(837, 'pdf16558952809871204927.pdf', 548, 2, 0),
(838, 'img5392216761716529550.jpg', 537, 1, 0),
(839, 'img17457286281096090105.jpg', 537, 1, 0),
(840, 'img4359025748164207472.jpg', 537, 1, 0),
(841, 'img18415349406701596153.jpg', 538, 1, 0),
(842, 'img8765646885590750183.jpg', 538, 1, 0),
(843, 'img13640405264881231865.jpg', 538, 1, 0),
(844, 'pdf4674947490714038643.pdf', 538, 2, 0),
(845, 'pdf9591395013541714480.pdf', 537, 2, 0),
(846, 'pdf6494149567924559128.pdf', 549, 2, 0),
(847, 'pdf13279159548781066133.pdf', 549, 2, 0),
(848, 'img8067774880754287584.jpg', 551, 0, 0),
(849, 'img1365694437635616235.jpg', 551, 0, 0),
(850, 'img10208042923941333901.jpg', 551, 0, 0),
(851, 'img5937786984338397237.jpg', 552, 0, 0),
(852, 'img15917202218164889636.jpg', 552, 0, 0),
(853, 'img2288922929588124403.jpg', 552, 0, 0),
(854, 'img14228604044828912521.jpg', 552, 1, 0),
(855, 'img916448466104357691.jpg', 552, 1, 0),
(856, 'img6618795349007848240.jpg', 553, 0, 0),
(857, 'img5068747920501394775.jpg', 553, 0, 0),
(858, 'img13817732268385659578.jpg', 553, 0, 0),
(859, 'img5841634107728370118.jpg', 553, 0, 0),
(860, 'img3191220777301102704.jpg', 553, 1, 0),
(861, 'img15101033363473425928.jpg', 553, 1, 0),
(862, 'img17976618389687878414.jpg', 554, 0, 1),
(863, 'img12274922828547023513.jpg', 554, 0, 0),
(864, 'img10116864147282966104.jpg', 554, 0, 0),
(865, 'img1104815152384477336.jpg', 554, 1, 0),
(866, 'pdf10153935670607897648.pdf', 555, 2, 0),
(867, 'pdf8191096998896263403.pdf', 555, 2, 0),
(868, 'img15430492547629375724.jpg', 556, 0, 0),
(869, 'img6050772188099898028.jpg', 556, 0, 0),
(870, 'img4477476024209549348.jpg', 556, 0, 0),
(871, 'img18138634729387224199.jpg', 556, 0, 0),
(872, 'img16518599011378808626.jpg', 556, 0, 0),
(873, 'pdf17114089051681374542.pdf', 556, 2, 0),
(874, 'pdf16119130729772835856.pdf', 556, 2, 0),
(875, 'pdf10209517023953352854.pdf', 550, 2, 0),
(876, 'pdf6001030721859990228.pdf', 550, 2, 0),
(877, 'img17157645632983932961.jpg', 550, 0, 0),
(878, 'img7546038888076975499.jpg', 550, 0, 0),
(879, 'img2481862233746683040.jpg', 550, 0, 0),
(880, 'img16579705114131608138.jpg', 550, 0, 0),
(881, 'pdf9568758184451588981.pdf', 542, 2, 0),
(882, 'pdf11212221864678693741.pdf', 542, 2, 0),
(883, 'pdf5430301227555457124.pdf', 529, 2, 0),
(884, 'pdf3738611286085987114.pdf', 529, 2, 0),
(885, 'pdf5949128143520702164.pdf', 557, 2, 0),
(886, 'pdf1305871853004333801.pdf', 557, 2, 0),
(887, 'img2286555303801905111.jpg', 557, 0, 0),
(888, 'img3582944486789387470.jpg', 557, 0, 0),
(889, 'img225460876056919009.jpg', 557, 0, 0),
(890, 'img16561460824184639031.jpg', 559, 0, 0),
(891, 'img12074667427796701395.jpg', 559, 0, 0),
(892, 'img16649085904056017554.jpg', 559, 0, 0),
(893, 'img8681790879794982493.jpg', 559, 0, 0),
(894, 'img15973564781729629925.jpg', 559, 0, 0),
(895, 'img14860860102807831479.jpg', 559, 0, 0),
(896, 'img13117207463754472269.jpg', 559, 0, 0),
(897, 'img8185245933160878714.jpg', 559, 0, 0),
(898, 'img11688731420752970770.jpg', 559, 0, 0),
(899, 'pdf1127205076113100386.pdf', 558, 2, 0),
(900, 'pdf10330057821368227145.pdf', 558, 2, 0),
(901, 'img14200741903655015849.jpg', 561, 0, 1),
(902, 'pdf7808160861695855062.pdf', 561, 2, 0),
(903, 'pdf12912630497473240346.pdf', 560, 2, 0),
(904, 'pdf9536327559356837602.pdf', 560, 2, 0),
(905, 'pdf3946949030037928879.pdf', 561, 2, 0),
(906, 'pdf9983837931346579934.pdf', 559, 2, 0),
(907, 'img16856992316357539364.jpg', 561, 0, 0),
(908, 'img5530305975006047030.jpg', 561, 0, 0),
(909, 'img13640142408582158171.jpg', 561, 0, 0),
(910, 'img4877616794019465979.jpg', 561, 0, 0),
(911, 'img17756722802186813397.jpg', 561, 0, 0),
(912, 'img5085356896642764352.jpg', 561, 0, 0),
(913, 'pdf6328288253152323076.pdf', 564, 2, 0),
(914, 'pdf15617640756208397275.pdf', 564, 2, 0),
(915, 'img11065571791051158851.jpg', 563, 0, 0),
(916, 'img15154871514125310110.jpg', 563, 0, 0),
(917, 'img12043100454356068056.jpg', 563, 0, 0),
(918, 'img6371038895944273062.jpg', 563, 0, 0),
(919, 'img2838839511454855609.jpg', 563, 0, 0),
(920, 'img9745563004408304078.jpg', 563, 0, 0),
(921, 'pdf5329934146829635993.pdf', 565, 2, 0),
(922, 'pdf16354102341978627335.pdf', 565, 2, 0),
(923, 'pdf10850193168048354421.pdf', 566, 2, 0),
(924, 'pdf10053765247373183316.pdf', 566, 2, 0),
(925, 'pdf7095800456366956077.pdf', 570, 2, 0),
(926, 'pdf9604034742983221704.pdf', 570, 2, 0),
(927, 'pdf12561661710820211282.pdf', 568, 2, 0),
(928, 'pdf1397061510688531399.pdf', 568, 2, 0),
(929, 'img264698457243747661.jpg', 572, 0, 0),
(930, 'img4234993147263815347.jpg', 572, 0, 0),
(931, 'img579508858341413208.jpg', 572, 0, 0),
(932, 'img2365294379857726213.jpg', 572, 0, 0),
(933, 'img7347177040514347240.jpg', 572, 0, 0),
(934, 'img4400329743823176205.jpg', 572, 0, 0),
(935, 'pdf6493926810762347832.pdf', 572, 2, 0),
(936, 'pdf1224037839786146851.pdf', 572, 2, 0),
(937, 'img6761034563491113150.jpg', 571, 0, 0),
(938, 'img13935311328627945593.jpg', 571, 0, 0),
(939, 'img3052195410249992773.jpg', 571, 0, 0),
(940, 'img9811623846862601375.jpg', 571, 0, 0),
(941, 'img9554584330948611844.jpg', 571, 0, 0),
(942, 'img3348334622763996837.jpg', 571, 0, 0),
(943, 'pdf5011126486803527498.pdf', 571, 2, 0),
(944, 'pdf12794844780323742505.pdf', 571, 2, 0),
(945, 'img8393203958980787126.jpg', 568, 0, 0),
(946, 'img2116993279679410755.jpg', 568, 0, 0),
(947, 'img14058073711832725736.jpg', 568, 0, 0),
(948, 'img18259117067815865263.jpg', 568, 0, 0),
(949, 'img10544919595167483128.jpg', 568, 0, 0),
(950, 'pdf4046347086612908612.pdf', 563, 2, 0),
(951, 'pdf17202802951639406097.pdf', 563, 2, 0),
(952, 'pdf10609999877379795681.pdf', 573, 2, 0),
(953, 'pdf7605178880691540920.pdf', 573, 2, 0),
(954, 'pdf8015537846501490341.pdf', 578, 2, 0),
(955, 'pdf11795239888391062719.pdf', 578, 2, 0),
(956, 'pdf10600854689009890532.pdf', 579, 2, 0),
(957, 'img1845220894861656182.jpg', 570, 0, 0),
(958, 'img3984760093257548963.jpg', 570, 0, 0),
(959, 'img276434682194204231.jpg', 570, 0, 0),
(960, 'img15361428522937648862.jpg', 570, 0, 0),
(961, 'img4764270781350393494.jpg', 570, 0, 0),
(962, 'img3195217864939902144.jpg', 570, 0, 0),
(963, 'img5006164949877973805.jpg', 570, 0, 0),
(964, 'img4224055567600254071.jpg', 570, 0, 0),
(965, 'img4192881030706724714.jpg', 570, 0, 0),
(966, 'img18102814875114332769.jpg', 570, 0, 0),
(967, 'img16186202285238684871.jpg', 570, 0, 0),
(968, 'pdf15630904864977579701.pdf', 575, 2, 0),
(969, 'pdf13327206535735589107.pdf', 575, 2, 0),
(970, 'img7093223941578944998.jpg', 575, 0, 0),
(971, 'img9508057995452777003.jpg', 575, 0, 0),
(972, 'img18031596103640623146.jpg', 575, 0, 0),
(973, 'img16976113861881631897.jpg', 575, 0, 0),
(974, 'img8186049189026934815.jpg', 575, 0, 0),
(975, 'img11853730159242519073.jpg', 575, 0, 0),
(976, 'img9765384473870776524.jpg', 581, 0, 0),
(977, 'img16839922488111682750.jpg', 581, 0, 0),
(978, 'img5330062170352671800.jpg', 581, 0, 0),
(979, 'img10928751521842973354.jpg', 581, 0, 0),
(980, 'img9493509382178057484.jpg', 581, 0, 0),
(981, 'img7653614328402102464.jpg', 581, 0, 0),
(982, 'pdf4510088717640828938.pdf', 581, 2, 0),
(983, 'pdf11477185199506343774.pdf', 581, 2, 0),
(984, 'pdf8063553265485262372.pdf', 583, 2, 0),
(985, 'pdf5049855546116310598.pdf', 583, 2, 0),
(986, 'pdf14784568868082451379.pdf', 584, 2, 0),
(987, 'pdf4889984916793516311.pdf', 584, 2, 0),
(988, 'img12120783250856479318.jpg', 562, 0, 0),
(989, 'img11288303473153772248.jpg', 562, 0, 0),
(990, 'img12606919223244916440.jpg', 562, 0, 0),
(991, 'img11257400220717475051.jpg', 562, 0, 0),
(992, 'img2717543995204632581.jpg', 562, 0, 0),
(993, 'img16644908174386169794.jpg', 562, 0, 0),
(994, 'pdf8112255198162287366.pdf', 562, 2, 0),
(995, 'pdf5916347013376965853.pdf', 562, 2, 0),
(996, 'pdf8085835625655748492.pdf', 585, 2, 0),
(997, 'pdf8191544861841027564.pdf', 585, 2, 0),
(998, 'pdf3039232741964288188.pdf', 587, 2, 0),
(999, 'img5910684926515584646.jpg', 585, 0, 0),
(1000, 'img10375750557795307093.jpg', 585, 0, 0),
(1001, 'img13604704942598062424.jpg', 585, 0, 0),
(1002, 'img13700231530292752191.jpg', 585, 0, 0),
(1003, 'img13468001760637778056.jpg', 585, 0, 0),
(1004, 'img16020361492412681977.jpg', 585, 0, 0),
(1005, 'img2707238528496392119.jpg', 585, 0, 0),
(1006, 'pdf6966043849494307564.pdf', 586, 2, 0),
(1007, 'pdf6725751392418135663.pdf', 586, 2, 0),
(1008, 'pdf12567532089920107166.pdf', 590, 2, 0),
(1009, 'pdf17305479365612757052.pdf', 590, 2, 0),
(1010, 'img10479339238030267176.jpg', 586, 0, 0),
(1011, 'img12013258128211667737.jpg', 586, 0, 0),
(1012, 'img11783547957521232671.jpg', 586, 0, 0),
(1013, 'img17702930016884096541.jpg', 586, 0, 0),
(1014, 'img4673579059260528689.jpg', 586, 0, 0),
(1015, 'img153592771949801061.jpg', 586, 0, 0),
(1016, 'img6337348127568307300.jpg', 591, 0, 0),
(1017, 'img2103799875731630969.jpg', 591, 0, 0),
(1018, 'img2066633579710379898.jpg', 591, 0, 0),
(1019, 'img8492989416963508416.jpg', 591, 0, 0),
(1020, 'img13232635210745652854.jpg', 591, 0, 0),
(1021, 'img6520441853648593589.jpg', 591, 0, 0),
(1022, 'img13956558547499225041.jpg', 591, 0, 0),
(1023, 'img5458870768707851980.jpg', 591, 0, 0),
(1024, 'pdf18312514798473435110.pdf', 591, 2, 0),
(1025, 'pdf15391642789150049075.pdf', 591, 2, 0),
(1026, 'pdf17586423344186707660.pdf', 589, 2, 0),
(1027, 'img3753804315054595181.jpg', 589, 0, 0),
(1028, 'img4194151296002880198.jpg', 589, 0, 0),
(1029, 'img9728890186458084124.jpg', 589, 0, 0),
(1030, 'img6751699518403321427.jpg', 589, 0, 0),
(1031, 'img3934291660389648728.jpg', 589, 0, 0),
(1032, 'img5627765240925690806.jpg', 597, 0, 0),
(1033, 'img17931604020403588188.jpg', 597, 0, 0),
(1034, 'img3711580534367083764.jpg', 597, 0, 0),
(1035, 'img13994170708528438290.jpg', 597, 0, 0),
(1036, 'img10714814223787384101.jpg', 597, 0, 0),
(1037, 'img8606341252376030954.jpg', 597, 0, 0),
(1038, 'pdf1830842958866150371.pdf', 597, 2, 0),
(1039, 'pdf309695147816113706.pdf', 597, 2, 0),
(1040, 'pdf5229282554372321270.pdf', 596, 2, 0),
(1041, 'pdf3663911076898049636.pdf', 596, 2, 0),
(1042, 'pdf15133942363964076136.pdf', 488, 2, 0),
(1043, 'pdf6194207655310004299.pdf', 488, 2, 0),
(1044, 'img3121319473120424943.jpg', 590, 0, 0),
(1045, 'img4667935232129938204.jpg', 590, 0, 0),
(1046, 'img10585435330751146947.jpg', 590, 0, 0),
(1047, 'img3129140892733771938.jpg', 590, 0, 0),
(1048, 'img16302352710240676572.jpg', 590, 0, 0),
(1049, 'img7684045393741772926.jpg', 590, 0, 0),
(1050, 'img15497837880642590462.jpg', 587, 0, 0),
(1051, 'img770026532261135649.jpg', 587, 0, 0),
(1052, 'img11603907181071944779.jpg', 587, 0, 0),
(1053, 'img12301676873396498936.jpg', 587, 0, 0),
(1054, 'img16072549785420601316.jpg', 587, 0, 0),
(1055, 'img843711048457975320.jpg', 587, 0, 0),
(1056, 'img50077260931980641.jpg', 588, 0, 0),
(1057, 'img11894426630548177048.jpg', 588, 0, 0),
(1058, 'img11332804509378904448.jpg', 588, 0, 0),
(1059, 'img4672661748411751747.jpg', 588, 0, 0),
(1060, 'img17990214048459215281.jpg', 588, 0, 0),
(1061, 'img16641150570050669907.jpg', 588, 0, 0),
(1062, 'pdf6928693169973080885.pdf', 588, 2, 0),
(1063, 'pdf10857414724047727314.pdf', 588, 2, 0),
(1064, 'img14944697305920514752.jpg', 580, 0, 0),
(1065, 'img6224477482837066507.jpg', 580, 0, 0),
(1066, 'img6276851734171062933.jpg', 580, 0, 0),
(1067, 'img9825789773551373398.jpg', 580, 0, 0),
(1068, 'img1594442477256735227.jpg', 580, 0, 0),
(1069, 'img17899461288946179888.jpg', 580, 0, 0),
(1070, 'pdf9630916130710266830.pdf', 580, 2, 0),
(1071, 'pdf5301923137215417795.pdf', 580, 2, 0),
(1072, 'img9235976305521551127.jpg', 584, 0, 0),
(1073, 'img2637810940296188691.jpg', 584, 0, 0),
(1074, 'img16269287747314114600.jpg', 584, 0, 0),
(1075, 'img918963976792196969.jpg', 584, 0, 0),
(1076, 'img1067358052222193247.jpg', 584, 0, 0),
(1077, 'img9931872605674151226.jpg', 584, 0, 0),
(1078, 'img16406618414369366986.jpg', 541, 0, 0),
(1079, 'img8297551093699296073.jpg', 541, 0, 0),
(1080, 'img14566302907586525210.jpg', 541, 0, 0),
(1081, 'img13187702284674100489.jpg', 541, 0, 0),
(1082, 'img6369336567245894123.jpg', 541, 0, 0),
(1083, 'img17547292266290442574.jpg', 541, 0, 0),
(1084, 'img6284597965348526304.jpg', 583, 0, 0),
(1085, 'img5803551543043216688.jpg', 583, 0, 0),
(1086, 'img15041177427817959979.jpg', 583, 0, 0),
(1087, 'img7073666455218394612.jpg', 583, 0, 0),
(1088, 'img13699565092237866631.jpg', 583, 0, 0),
(1089, 'img12113404376761714981.jpg', 583, 0, 0),
(1090, 'pdf7826290347925614686.pdf', 598, 2, 0),
(1091, 'pdf3640546512649700191.pdf', 598, 2, 0),
(1092, 'pdf14724284553610346920.pdf', 593, 2, 0),
(1093, 'pdf2397190925876137539.pdf', 593, 2, 0),
(1094, 'pdf8306043808507579139.pdf', 595, 2, 0),
(1095, 'pdf7985737835886902858.pdf', 595, 2, 0),
(1096, 'pdf3519284524384576691.pdf', 594, 2, 0),
(1097, 'pdf12010290698484429362.pdf', 594, 2, 0),
(1098, 'img14053171210921799955.jpg', 594, 0, 0),
(1099, 'img4463918563457088242.jpg', 594, 0, 0),
(1100, 'img13264615197760829265.jpg', 594, 0, 0),
(1101, 'img17273501704209406046.jpg', 594, 0, 0),
(1102, 'img1207823380040232410.jpg', 594, 0, 0),
(1103, 'img16280011554299838619.jpg', 594, 0, 0),
(1104, 'img15771850043109808557.jpg', 594, 0, 0),
(1105, 'pdf1845437717162224369.pdf', 602, 2, 0),
(1106, 'pdf16185692683692595656.pdf', 602, 2, 0),
(1107, 'img12738892993250820564.jpg', 595, 0, 0),
(1108, 'img17155015816340683161.jpg', 595, 0, 0),
(1109, 'img16787476410631976653.jpg', 595, 0, 0),
(1110, 'img5069101072172571242.jpg', 595, 0, 0),
(1111, 'img11024311358483282258.jpg', 595, 0, 0),
(1112, 'img14251800537707506581.jpg', 595, 0, 0),
(1113, 'img8920460767742551975.jpg', 595, 0, 0),
(1114, 'img6782943017766314191.jpg', 595, 0, 0),
(1115, 'img4663607642502221707.jpg', 593, 0, 0),
(1116, 'img14300063536266722304.jpg', 593, 0, 0),
(1117, 'img10076000515770163325.jpg', 593, 0, 0),
(1118, 'img2572743516167125880.jpg', 602, 0, 0),
(1119, 'img7831822990367724795.jpg', 602, 0, 0),
(1120, 'img9868538976077957317.jpg', 602, 0, 0),
(1121, 'img5782683058483641485.jpg', 602, 0, 0),
(1122, 'pdf9948133711482893287.pdf', 599, 2, 0),
(1123, 'pdf8028586015476571144.pdf', 599, 2, 0),
(1124, 'pdf14868032702164322188.pdf', 582, 2, 0),
(1125, 'pdf281548105670594568.pdf', 582, 2, 0),
(1126, 'img12693572835429154933.jpg', 605, 0, 0),
(1127, 'img15086878039722647367.jpg', 605, 0, 0),
(1128, 'img1408853136052539009.jpg', 605, 0, 0),
(1129, 'img15551740819481799827.jpg', 605, 0, 0),
(1130, 'img12567252092621952741.jpg', 605, 0, 0),
(1131, 'img14676083257322494244.jpg', 605, 0, 0),
(1132, 'img10690493063196394785.jpg', 605, 0, 0),
(1133, 'img6051384101125566037.jpg', 605, 0, 0),
(1134, 'pdf12571782598210834932.pdf', 605, 2, 0),
(1135, 'pdf6572592503639643636.pdf', 605, 2, 0),
(1136, 'pdf10738810645632937631.pdf', 603, 2, 0),
(1137, 'pdf14338664726006863907.pdf', 603, 2, 0),
(1138, 'img15654934169536912974.jpg', 609, 0, 0),
(1139, 'img2660093478066155172.jpg', 609, 0, 0),
(1140, 'img12742027865358398261.jpg', 609, 0, 0),
(1141, 'img18072355472038687780.jpg', 609, 0, 0),
(1142, 'pdf13414962773451149117.pdf', 606, 2, 0),
(1143, 'pdf9940963333899289142.pdf', 606, 2, 0),
(1144, 'pdf1389041481246058108.pdf', 608, 2, 0),
(1145, 'pdf2016038184453702076.pdf', 610, 2, 0),
(1146, 'pdf15444222079404684441.pdf', 610, 2, 0),
(1147, 'pdf10758102852035252431.pdf', 610, 2, 0),
(1148, 'pdf12264201622516213479.pdf', 610, 2, 0),
(1149, 'pdf12740812352513394087.pdf', 571, 2, 0),
(1150, 'pdf8794696296911090449.pdf', 572, 2, 0),
(1151, 'pdf16887219030097847071.pdf', 568, 2, 0),
(1152, 'pdf6254290022961414293.pdf', 600, 2, 0),
(1153, 'pdf12647622284356215842.pdf', 600, 2, 0),
(1154, 'pdf10362279829067519762.pdf', 611, 2, 0),
(1155, 'pdf16795312074448521649.pdf', 611, 2, 0),
(1156, 'pdf6373695781220283298.pdf', 607, 2, 0),
(1157, 'pdf18263451091192476115.pdf', 607, 2, 0),
(1158, 'pdf18416864122798357544.pdf', 604, 2, 0),
(1159, 'pdf12471062563331330203.pdf', 604, 2, 0),
(1160, 'img2073554042482731517.jpg', 610, 0, 0),
(1161, 'img17552153427075069003.jpg', 610, 0, 0),
(1162, 'img9932855983608926110.jpg', 610, 0, 0),
(1163, 'img15256910643908520559.jpg', 610, 0, 0),
(1164, 'img2105243002457419840.jpg', 610, 0, 0),
(1165, 'img18047454784967092617.jpg', 607, 0, 0),
(1166, 'img3610904419790235861.jpg', 607, 0, 0),
(1167, 'img9739834875248243410.jpg', 607, 0, 0),
(1168, 'img4347971931308365047.jpg', 607, 0, 0),
(1169, 'img17211886211125288148.jpg', 607, 0, 0),
(1170, 'img14712523496360121338.jpg', 607, 0, 0),
(1171, 'img8096477589212100644.jpg', 608, 0, 0),
(1172, 'img10127428295971242917.jpg', 608, 0, 0),
(1173, 'img3437490445568873536.jpg', 608, 0, 0),
(1174, 'img9081089079500377369.jpg', 608, 0, 0),
(1175, 'img15692519073033695923.jpg', 608, 0, 0),
(1176, 'img1611747016513579069.jpg', 608, 0, 0),
(1177, 'img7005749316318334869.jpg', 606, 0, 0),
(1178, 'img11919162065399306570.jpg', 606, 0, 0),
(1179, 'img15305151144319385804.jpg', 606, 0, 0),
(1180, 'img17586752984456836580.jpg', 606, 0, 0),
(1181, 'img10571092720284801488.jpg', 606, 0, 0),
(1182, 'img10082296363355749509.jpg', 615, 0, 0),
(1183, 'img4023641049598443554.jpg', 615, 0, 0),
(1184, 'img18354076157804337020.jpg', 615, 0, 0),
(1185, 'img1739601985869216332.jpg', 615, 0, 0),
(1186, 'img5022567856855995405.jpg', 615, 0, 0),
(1187, 'img3420311184470301584.jpg', 615, 0, 0),
(1188, 'img16591619342155355175.jpg', 615, 0, 0),
(1189, 'img13516127326078392463.jpg', 615, 0, 0),
(1190, 'img17145529589140695272.jpg', 615, 0, 0),
(1191, 'img16879751177518244548.jpg', 612, 0, 0),
(1192, 'img2943753104672920428.jpg', 612, 0, 0),
(1193, 'img13127443743770165247.jpg', 612, 0, 0),
(1194, 'img17933417130756532882.jpg', 612, 0, 0),
(1195, 'pdf2265786762741731940.pdf', 614, 2, 1),
(1196, 'pdf183912960290530437.pdf', 614, 2, 0),
(1197, 'img13167288423364256199.jpg', 617, 0, 0),
(1198, 'img9943478085440948801.jpg', 617, 0, 0),
(1199, 'img6640665595782151823.jpg', 617, 0, 0),
(1200, 'img704055064357275435.jpg', 617, 0, 0),
(1201, 'img4254647650566706215.jpg', 617, 0, 0),
(1202, 'img9555164882681051850.jpg', 617, 0, 0),
(1203, 'pdf7591528825058750005.pdf', 617, 2, 0),
(1204, 'pdf13183901426190826614.pdf', 617, 2, 0),
(1205, 'pdf18220455681851871476.pdf', 616, 2, 0),
(1206, 'pdf17897252904277339479.pdf', 616, 2, 0),
(1207, 'img15982272585085340548.jpg', 616, 0, 0),
(1208, 'img16090674555904850865.jpg', 616, 0, 0),
(1209, 'img3975084996971621133.jpg', 616, 0, 0),
(1210, 'img7443163092852051956.jpg', 616, 0, 0),
(1211, 'img6102561470743720758.jpg', 616, 0, 0),
(1212, 'img16393986627711051378.jpg', 616, 0, 0),
(1213, 'img3482606390304512592.jpg', 604, 0, 0),
(1214, 'img14970913101259027001.jpg', 604, 0, 0),
(1215, 'img8367888583496831217.jpg', 604, 0, 0),
(1216, 'img11110951266255084603.jpg', 604, 0, 0),
(1217, 'img4757834739087299471.jpg', 604, 0, 0),
(1218, 'img10787072365092682386.jpg', 600, 0, 0),
(1219, 'img6219718925462481792.jpg', 600, 0, 0),
(1220, 'img9841916775427372705.jpg', 600, 0, 0),
(1221, 'img6777487651057101363.jpg', 600, 0, 0),
(1222, 'img9289836097520260240.jpg', 600, 0, 0),
(1223, 'img1176178408935103958.jpg', 600, 0, 0),
(1224, 'img4323827279037583636.jpg', 600, 0, 0),
(1225, 'img6902018928407889664.jpg', 613, 0, 0),
(1226, 'img10516598224206104071.jpg', 613, 0, 0),
(1227, 'img13638271731982272590.jpg', 613, 0, 0),
(1228, 'img1980454043687955202.jpg', 613, 0, 0),
(1229, 'img13612638230126200528.jpg', 613, 0, 0),
(1230, 'img153033546787933213.jpg', 613, 0, 0),
(1231, 'img3981585703376920945.jpg', 613, 0, 0),
(1232, 'pdf14005516626417540400.pdf', 613, 2, 0),
(1233, 'pdf16098815276059293829.pdf', 613, 2, 0),
(1234, 'img700006548846000858.jpg', 612, 0, 0),
(1235, 'img6491483251932653887.jpg', 612, 0, 0),
(1236, 'img18109096644719212680.jpg', 612, 0, 0),
(1237, 'pdf8903186742318283699.pdf', 612, 2, 0),
(1238, 'pdf11109601210108218993.pdf', 612, 2, 0),
(1239, 'pdf40024291035259791.pdf', 618, 2, 0),
(1240, 'pdf5198188681927444822.pdf', 618, 2, 0),
(1241, 'pdf6202131109397606847.pdf', 614, 2, 1),
(1242, 'img6548819262483648740.jpg', 614, 0, 0),
(1243, 'img11032026840021003905.jpg', 614, 0, 0),
(1244, 'img6846350748979778588.jpg', 614, 0, 0),
(1245, 'img18295304896005189178.jpg', 614, 0, 0),
(1246, 'img9332827911972853244.jpg', 614, 0, 0),
(1247, 'img11101927445199557116.jpg', 614, 0, 0),
(1248, 'img15354765371156980600.jpg', 614, 0, 0),
(1249, 'pdf5720632269914770641.pdf', 614, 2, 0),
(1250, 'img11371960846850990692.jpg', 605, 1, 0),
(1251, 'img6212393375758709221.jpg', 605, 1, 0),
(1252, 'img18295220601656712174.jpg', 605, 1, 0),
(1253, 'img11794478816990110654.jpg', 609, 1, 0),
(1254, 'img10306312282277999806.jpg', 609, 1, 0),
(1255, 'img2948603793390413972.jpg', 609, 1, 0),
(1256, 'pdf4457963036989827485.pdf', 609, 2, 0),
(1257, 'pdf7688417551725037302.pdf', 621, 2, 1),
(1258, 'pdf11039395917066200916.pdf', 621, 2, 0),
(1259, 'pdf15216368760999520842.pdf', 619, 2, 0),
(1260, 'pdf296252660446397426.pdf', 619, 2, 0),
(1261, 'pdf2834649332736085947.pdf', 621, 2, 1),
(1262, 'pdf6305404771934417590.pdf', 621, 2, 0),
(1263, 'pdf17465355014017066302.pdf', 623, 2, 0),
(1264, 'pdf564654323285908160.pdf', 623, 2, 0),
(1265, 'pdf12463435211849355568.pdf', 622, 2, 0),
(1266, 'pdf2778390820741957822.pdf', 622, 2, 0),
(1267, 'pdf16699833824585200881.pdf', 624, 2, 0),
(1268, 'pdf16352718980560055684.pdf', 624, 2, 0),
(1269, 'pdf8667145758360771409.pdf', 625, 2, 0),
(1270, 'pdf3594934603594097392.pdf', 625, 2, 0),
(1271, 'pdf2051266983798924634.pdf', 626, 2, 0),
(1272, 'pdf3153274395060936091.pdf', 627, 2, 0),
(1273, 'img12443919792310637785.jpg', 622, 0, 0),
(1274, 'img8464986347762762003.jpg', 622, 0, 0),
(1275, 'img6067423657643738989.jpg', 622, 0, 0),
(1276, 'img8036288001001558429.jpg', 622, 0, 0),
(1277, 'img5058887102818993501.jpg', 622, 0, 0),
(1278, 'img6648761663518143815.jpg', 622, 0, 0),
(1279, 'img16110187596297337590.jpg', 622, 0, 0),
(1280, 'img14390405940489370301.jpg', 628, 0, 0),
(1281, 'img11766570220902404218.jpg', 628, 0, 0),
(1282, 'img12117158836663162656.jpg', 628, 0, 0),
(1283, 'img4974459535001780511.jpg', 628, 0, 0),
(1284, 'pdf4558395374123547843.pdf', 628, 2, 0),
(1285, 'pdf13463494179373277013.pdf', 628, 2, 0),
(1286, 'img18320876457860050052.jpg', 625, 0, 0),
(1287, 'img2501569227134384608.jpg', 625, 0, 0),
(1288, 'img7617991244831698444.jpg', 628, 0, 0),
(1289, 'img6055846110102160902.jpg', 628, 0, 0),
(1290, 'img2737452508761037622.jpg', 623, 0, 1),
(1291, 'img1164591348138981728.jpg', 623, 0, 1),
(1292, 'img17927265269042899332.jpg', 623, 0, 1),
(1293, 'img11617761513410849233.jpg', 623, 0, 1),
(1294, 'img13301253867107592721.jpg', 623, 1, 1),
(1295, 'img3971634141307634351.jpg', 623, 1, 1),
(1296, 'img2651582802945692801.jpg', 623, 1, 1),
(1297, 'img3791602789193852271.jpg', 625, 0, 0),
(1298, 'img16981099896859216134.jpg', 624, 0, 0),
(1299, 'img5599479638790148883.jpg', 624, 0, 0),
(1300, 'img13003017761521316498.jpg', 624, 0, 0),
(1301, 'img8200293216696418245.jpg', 624, 0, 0),
(1302, 'img2516035641057481902.jpg', 624, 0, 0),
(1303, 'img11556645883718731379.jpg', 624, 0, 0),
(1304, 'img3247476930711416904.jpg', 624, 0, 0),
(1305, 'img8024831599627961156.jpg', 624, 0, 0),
(1306, 'img3827044422809123826.jpg', 625, 0, 0),
(1307, 'img81995412175100945.jpg', 625, 0, 0),
(1308, 'img2575154477635200909.jpg', 625, 0, 0),
(1309, 'img15723972024771513287.jpg', 623, 0, 0),
(1310, 'img9729952114399947004.jpg', 623, 0, 0),
(1311, 'img17025264001090790157.jpg', 623, 0, 0),
(1312, 'img4232422456804619424.jpg', 623, 0, 0),
(1313, 'img3133062549769157562.jpg', 623, 0, 0),
(1314, 'img763379094669014654.jpg', 623, 0, 0),
(1315, 'img13183835383069384117.jpg', 618, 0, 0),
(1316, 'img4173861198024838006.jpg', 618, 0, 0),
(1317, 'img15185485016814086144.jpg', 618, 0, 0),
(1318, 'img17454103018539574257.jpg', 618, 0, 0),
(1319, 'img18149960137098068128.jpg', 618, 0, 0),
(1320, 'img4027080619499102156.jpg', 618, 0, 0),
(1321, 'img2867273461539015307.jpg', 626, 0, 0),
(1322, 'img11854175533556911877.jpg', 626, 0, 0),
(1323, 'img1393620650215210562.jpg', 626, 0, 0),
(1324, 'img12588440388410509792.jpg', 626, 0, 0),
(1325, 'img8170609675129269030.jpg', 626, 0, 0),
(1326, 'img79979874797745621.jpg', 626, 0, 0),
(1327, 'img107239025559510504.jpg', 626, 0, 0),
(1328, 'img9135274713530890014.jpg', 627, 0, 0),
(1329, 'img15550881363441330270.jpg', 627, 0, 0),
(1330, 'img17284477776022082534.jpg', 627, 0, 0),
(1331, 'img12453731767166665362.jpg', 627, 0, 0),
(1332, 'img6649427441190299573.jpg', 627, 0, 0),
(1333, 'pdf13661593141390530014.pdf', 630, 2, 0),
(1334, 'pdf15723076293372066603.pdf', 630, 2, 0),
(1335, 'img16883219936417828267.jpg', 630, 0, 0),
(1336, 'img6592994212170803947.jpg', 630, 0, 0),
(1337, 'img13325057693378429900.jpg', 630, 0, 0),
(1338, 'img1559406543238528767.jpg', 630, 0, 0),
(1339, 'img4260101988759306523.jpg', 630, 0, 0),
(1340, 'img10981102826650400414.jpg', 630, 0, 0),
(1341, 'img12149625143081717933.jpg', 630, 0, 0),
(1342, 'pdf5126886149210492311.pdf', 620, 2, 0),
(1343, 'pdf315437315570871549.pdf', 629, 2, 1),
(1344, 'pdf4688981274426728731.pdf', 629, 2, 1),
(1345, 'pdf14930477834551202596.pdf', 629, 2, 1),
(1346, 'pdf9718935498442221481.pdf', 629, 2, 0),
(1347, 'pdf12425529985429791322.pdf', 629, 2, 0),
(1348, 'pdf17832428634985161187.pdf', 632, 2, 0),
(1349, 'pdf1771039719165122179.pdf', 632, 2, 0),
(1350, 'pdf9581713522658633186.pdf', 631, 2, 0),
(1351, 'pdf14892954622975666915.pdf', 631, 2, 0),
(1352, 'img9999270684433845811.jpg', 627, 1, 0),
(1353, 'img14814207683008934898.jpg', 627, 1, 0),
(1354, 'img13450959669522101565.jpg', 627, 1, 0),
(1355, 'img3385928279666296050.jpg', 627, 1, 0),
(1356, 'img8073430890346408591.jpg', 626, 1, 0),
(1357, 'img13038622836755944733.jpg', 626, 1, 0),
(1358, 'img13912928036803935696.jpg', 626, 1, 0),
(1359, 'pdf15101950361331776462.pdf', 620, 2, 0),
(1360, 'pdf6530180795453404592.pdf', 620, 2, 0),
(1361, 'pdf17412429462259514483.pdf', 601, 2, 0),
(1362, 'pdf16824266144879778924.pdf', 601, 2, 0),
(1363, 'pdf1174777047759456226.pdf', 634, 2, 0),
(1364, 'pdf3411971231425015545.pdf', 634, 2, 0),
(1365, 'pdf15104986903453051974.pdf', 635, 2, 0),
(1366, 'pdf10581269519253828679.pdf', 635, 2, 0),
(1367, 'img1064578109824361253.jpg', 634, 0, 0),
(1368, 'img11554908495388040679.jpg', 634, 0, 0),
(1369, 'img15669277814796181393.jpg', 634, 0, 0),
(1370, 'img1208622827030104990.jpg', 634, 0, 0),
(1371, 'img9527682506319672800.jpg', 634, 0, 0),
(1372, 'img308965120063525735.jpg', 634, 0, 0),
(1373, 'img6015063788171145082.jpg', 635, 0, 0),
(1374, 'img5969619182051167984.jpg', 635, 0, 0),
(1375, 'img3000713381913741227.jpg', 635, 0, 0),
(1376, 'img15285610238219393315.jpg', 635, 0, 0),
(1377, 'img11798644438410387948.jpg', 635, 0, 0),
(1378, 'pdf1853736646443447390.pdf', 633, 2, 0),
(1379, 'img4999345343715570149.jpg', 633, 0, 0),
(1380, 'img16821928905531869220.jpg', 633, 0, 0),
(1381, 'img12445194642891846035.jpg', 633, 0, 0),
(1382, 'img16626270792896459074.jpg', 633, 0, 0),
(1383, 'img6237853638353619991.jpg', 633, 0, 0),
(1384, 'img2253547993376165989.jpg', 631, 0, 0),
(1385, 'img16682821271460814548.jpg', 631, 0, 0),
(1386, 'img936452853801914239.jpg', 631, 0, 0),
(1387, 'img17269809025088726582.jpg', 631, 0, 0),
(1388, 'img6798735934149408872.jpg', 631, 0, 0),
(1389, 'img4037646964504970728.jpg', 631, 0, 0),
(1421, '1580921431130.jpeg', 726, 0, 0),
(1422, '1580921477236.jpeg', 726, 0, 0),
(1423, '1581516962967.jpeg', 729, 0, 0),
(1424, '1581517277208.jpeg', 729, 1, 0),
(1425, '1581523627413.jpeg', 729, 0, 0),
(1426, '', 727, 2, 0),
(1427, '1581610936969.jpeg', 731, 0, 0),
(1428, '1581611018096.jpeg', 731, 0, 0),
(1429, '1581611159849.jpeg', 731, 0, 0),
(1430, '1581651486037.jpeg', 732, 0, 0),
(1431, '1581651519610.jpeg', 732, 0, 0),
(1432, '1581651547135.jpeg', 732, 0, 0),
(1433, '1581651566514.jpeg', 732, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `carimageLanding`
--

CREATE TABLE `carimageLanding` (
  `id` int(11) NOT NULL,
  `url` varchar(45) DEFAULT NULL,
  `carId` int(11) DEFAULT NULL,
  `deleted` int(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `carimageLanding`
--

INSERT INTO `carimageLanding` (`id`, `url`, `carId`, `deleted`) VALUES
(17, 'img6904015842140216299.jpg', 6, 0),
(18, 'img10590752442785442715.jpg', 7, 0),
(19, 'img2282934173401047942.jpg', 8, 0),
(20, 'img12537831448780625325.jpg', 8, 0),
(21, 'img9254292986208669317.jpg', 9, 0),
(22, '', 7, 1);

-- --------------------------------------------------------

--
-- Table structure for table `carLanding`
--

CREATE TABLE `carLanding` (
  `id` int(11) NOT NULL,
  `uuid` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `model` varchar(45) DEFAULT NULL,
  `make` varchar(45) DEFAULT NULL,
  `year` varchar(45) DEFAULT NULL,
  `assemblyCountry` varchar(45) DEFAULT NULL,
  `bodyStyle` varchar(45) DEFAULT NULL,
  `docType` varchar(45) DEFAULT NULL,
  `odoMeter` varchar(45) DEFAULT NULL,
  `transmission` int(11) DEFAULT NULL,
  `primaryDamage` varchar(45) DEFAULT NULL,
  `secondaryDamage` varchar(45) DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  `cylinder` varchar(45) DEFAULT NULL,
  `fuel` varchar(45) DEFAULT NULL,
  `currentBid` varchar(45) DEFAULT NULL,
  `saleStatues` varchar(45) DEFAULT NULL,
  `auctionLocation` varchar(45) DEFAULT NULL,
  `dateAdd` datetime DEFAULT NULL,
  `saleDate` datetime DEFAULT NULL,
  `kiloDistance` varchar(45) DEFAULT NULL,
  `Category` int(11) DEFAULT NULL,
  `mainId` int(11) DEFAULT NULL,
  `mainImage` varchar(45) DEFAULT NULL,
  `isShowenInLanding` int(11) DEFAULT '1',
  `deleted` int(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `carLanding`
--

INSERT INTO `carLanding` (`id`, `uuid`, `description`, `model`, `make`, `year`, `assemblyCountry`, `bodyStyle`, `docType`, `odoMeter`, `transmission`, `primaryDamage`, `secondaryDamage`, `color`, `cylinder`, `fuel`, `currentBid`, `saleStatues`, `auctionLocation`, `dateAdd`, `saleDate`, `kiloDistance`, `Category`, `mainId`, `mainImage`, `isShowenInLanding`, `deleted`) VALUES
(6, 'load suv ', '', '', 'BMW', '2010', 'UNITED STATES (USA)', '', '', NULL, 0, '', '', '', '-  Cylinders', '', '0', '', '', '2019-08-24 03:24:45', NULL, '', 0, NULL, 'img2867827282921766464.jpg', 1, 0),
(7, 'TRANSPORTATION  ', '', '', 'Service', '', '', '', '', NULL, 0, '', '', '', '-  Cylinders', '', '0', '', '', '2019-09-28 17:49:37', NULL, '', 0, NULL, 'img16126974696034210721.jpg', 1, 0),
(8, 'Motor Cycle RO/RO ', 'Vehicle in Container', '', '', '2010', '', '', '', NULL, 0, '', '', '', '', '', '0', '', '', '2019-08-24 03:25:32', NULL, '', 2, NULL, 'img247221560613154543.jpg', 1, 0),
(9, 'LOADING 4 VEHICLE IN 40HC ', 'vechicle in container', '', 'Fiat', '2013', '', '', '', NULL, 0, '', '', '', '', '', '', '', '', '2019-08-24 03:26:18', NULL, '', 0, NULL, 'img8635945255878357805.jpg', 1, 0),
(10, 'dozar IN 40HC ', '', '', '', '', '', '', '', NULL, 0, '', '', '', '', '', '', '', '', '2019-08-24 03:26:34', NULL, '', 0, NULL, 'img9247925091115727407.jpg', 1, 0),
(11, 'boat', '', '', '', '', '', '', '', NULL, 0, '', '', '', '', '', '', '', '', '2019-08-23 01:23:49', NULL, '', 1, NULL, 'img6886088245701018029.jpg', 1, 0),
(12, 'helicopter', '', '', '', '', '', '', '', NULL, 0, '', '', '', '', '', '', '', '', '2019-08-23 01:42:10', NULL, '', 0, NULL, 'img10332231950668488679.jpg', 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `commoditiy`
--

CREATE TABLE `commoditiy` (
  `id` int(11) NOT NULL,
  `lineNum` int(11) DEFAULT NULL,
  `isLine` varchar(1) DEFAULT NULL,
  `it_1` varchar(45) DEFAULT NULL,
  `it_2` varchar(45) DEFAULT NULL,
  `it_3` varchar(45) DEFAULT NULL,
  `it_4` varchar(45) DEFAULT NULL,
  `it_5` varchar(45) DEFAULT NULL,
  `it_6` varchar(45) DEFAULT NULL,
  `it_7` varchar(45) DEFAULT NULL,
  `it_8` varchar(45) DEFAULT NULL,
  `it_9` varchar(45) DEFAULT NULL,
  `it_10` varchar(45) DEFAULT NULL,
  `it_12` varchar(45) DEFAULT NULL,
  `it_13` varchar(45) DEFAULT NULL,
  `it_15` varchar(45) DEFAULT NULL,
  `it_16` varchar(45) DEFAULT NULL,
  `it_17` varchar(45) DEFAULT NULL,
  `it_18` varchar(45) DEFAULT NULL,
  `it_20` varchar(45) DEFAULT NULL,
  `it_21` varchar(45) DEFAULT NULL,
  `odtc_1` varchar(45) DEFAULT NULL,
  `odtc_2` varchar(45) DEFAULT NULL,
  `odtc_3` varchar(45) DEFAULT NULL,
  `odtc_4` varchar(45) DEFAULT NULL,
  `odtc_5` varchar(45) DEFAULT NULL,
  `odtc_6` varchar(45) DEFAULT NULL,
  `odtc_7` varchar(45) DEFAULT NULL,
  `customId` int(11) DEFAULT NULL,
  `deleted` int(1) DEFAULT '0',
  `docReceiptId` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `commoditiy`
--

INSERT INTO `commoditiy` (`id`, `lineNum`, `isLine`, `it_1`, `it_2`, `it_3`, `it_4`, `it_5`, `it_6`, `it_7`, `it_8`, `it_9`, `it_10`, `it_12`, `it_13`, `it_15`, `it_16`, `it_17`, `it_18`, `it_20`, `it_21`, `odtc_1`, `odtc_2`, `odtc_3`, `odtc_4`, `odtc_5`, `odtc_6`, `odtc_7`, `customId`, `deleted`, `docReceiptId`, `description`) VALUES
(32, 1, 'Y', '', '1300', '', '1', '', '', '1500', '', '', '', '', '', 'Y', NULL, '1D7HU18D15J569032', NULL, '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 7, '2005 DODGE Ram');

-- --------------------------------------------------------

--
-- Table structure for table `consignee`
--

CREATE TABLE `consignee` (
  `id` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `other` text,
  `notes` text,
  `parentId` int(11) DEFAULT NULL,
  `deleted` int(1) DEFAULT '0',
  `idType` varchar(1) DEFAULT NULL,
  `idNumber` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `consignee`
--

INSERT INTO `consignee` (`id`, `userId`, `other`, `notes`, `parentId`, `deleted`, `idType`, `idNumber`) VALUES
(7, 56, '', '', 28, 0, NULL, NULL),
(8, 62, '', '', 26, 0, NULL, NULL),
(9, 72, '', '', 27, 0, 'E', ''),
(12, 77, '', '', 40, 0, 'E', '000000'),
(13, 78, '', '', 40, 0, 'E', '');

-- --------------------------------------------------------

--
-- Table structure for table `custom`
--

CREATE TABLE `custom` (
  `id` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `usppiId` int(11) DEFAULT NULL,
  `ulConsigneeId` int(11) DEFAULT NULL,
  `consigneeType` varchar(1) DEFAULT NULL,
  `soldEnRoute` varchar(1) DEFAULT NULL,
  `interConsigneeId` int(11) DEFAULT NULL,
  `freightForwardedId` int(11) DEFAULT NULL,
  `eda` datetime DEFAULT NULL,
  `srn` varchar(45) DEFAULT NULL,
  `scac` varchar(45) DEFAULT NULL,
  `vn` varchar(45) DEFAULT NULL,
  `bn` varchar(45) DEFAULT NULL,
  `doReceiptId` int(11) DEFAULT NULL,
  `st` varchar(45) DEFAULT NULL,
  `ibt` varchar(45) DEFAULT NULL,
  `poe` varchar(45) DEFAULT NULL,
  `cod` varchar(45) DEFAULT NULL,
  `pou` varchar(45) DEFAULT NULL,
  `mot` varchar(45) DEFAULT NULL,
  `rcc` varchar(45) DEFAULT NULL,
  `haz` varchar(45) DEFAULT NULL,
  `rt` varchar(45) DEFAULT NULL,
  `deleted` int(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `custom`
--

INSERT INTO `custom` (`id`, `userId`, `usppiId`, `ulConsigneeId`, `consigneeType`, `soldEnRoute`, `interConsigneeId`, `freightForwardedId`, `eda`, `srn`, `scac`, `vn`, `bn`, `doReceiptId`, `st`, `ibt`, `poe`, `cod`, `pou`, `mot`, `rcc`, `haz`, `rt`, `deleted`) VALUES
(1, 48, NULL, NULL, '', '', NULL, NULL, NULL, '', '', '', '', 8, '0', '-1', '-1', '0', '-1', '-1', '', '', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `idType` int(11) DEFAULT NULL,
  `other` mediumtext,
  `notes` mediumtext,
  `allowAccess` int(11) NOT NULL DEFAULT '0',
  `parentId` int(11) DEFAULT NULL,
  `salesRep` mediumtext,
  `idNumber` varchar(255) DEFAULT NULL,
  `deleted` int(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customtransportation`
--

CREATE TABLE `customtransportation` (
  `id` int(11) NOT NULL,
  `lineNum` int(11) DEFAULT NULL,
  `customId` int(11) DEFAULT NULL,
  `eqNumber` varchar(45) DEFAULT NULL,
  `sn` varchar(45) DEFAULT NULL,
  `deleted` int(1) DEFAULT '0',
  `docReceiptId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `docreciept`
--

CREATE TABLE `docreciept` (
  `id` int(11) NOT NULL,
  `usppiId` int(11) DEFAULT NULL,
  `freightForwarderId` int(11) DEFAULT NULL,
  `ultiConsignee` int(11) DEFAULT NULL,
  `intermConsignee` int(11) DEFAULT NULL,
  `bn` varchar(255) DEFAULT NULL,
  `srn` varchar(255) DEFAULT NULL,
  `portOfExportCountry` varchar(45) DEFAULT NULL,
  `scac` varchar(225) DEFAULT NULL,
  `vn` varchar(225) DEFAULT NULL,
  `portOfExportState` varchar(45) DEFAULT NULL,
  `sailingOn` varchar(45) DEFAULT NULL,
  `itn` varchar(128) DEFAULT NULL,
  `portOfDestination` varchar(45) DEFAULT NULL,
  `loadingTerminal` varchar(255) DEFAULT NULL,
  `mot` varchar(45) DEFAULT NULL,
  `mark_cont` varchar(45) DEFAULT NULL,
  `mark_seal` varchar(45) DEFAULT NULL,
  `no_of_pkg` varchar(45) DEFAULT NULL,
  `billOfLading` varchar(255) DEFAULT NULL,
  `deleted` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `mainId` int(11) DEFAULT '0',
  `notifyParity` varchar(1024) DEFAULT NULL,
  `placeOfReceipt` varchar(255) DEFAULT NULL,
  `countryOfDestination` varchar(45) DEFAULT NULL,
  `ibt` int(11) DEFAULT NULL,
  `rt` varchar(45) DEFAULT NULL,
  `rcc` varchar(45) DEFAULT NULL,
  `haz` varchar(45) DEFAULT NULL,
  `consigneeType` varchar(45) DEFAULT NULL,
  `soldEnRoute` varchar(45) DEFAULT NULL,
  `preCarrageBy` varchar(255) DEFAULT NULL,
  `exportCarrier` varchar(225) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `docreciept`
--

INSERT INTO `docreciept` (`id`, `usppiId`, `freightForwarderId`, `ultiConsignee`, `intermConsignee`, `bn`, `srn`, `portOfExportCountry`, `scac`, `vn`, `portOfExportState`, `sailingOn`, `itn`, `portOfDestination`, `loadingTerminal`, `mot`, `mark_cont`, `mark_seal`, `no_of_pkg`, `billOfLading`, `deleted`, `date`, `userId`, `mainId`, `notifyParity`, `placeOfReceipt`, `countryOfDestination`, `ibt`, `rt`, `rcc`, `haz`, `consigneeType`, `soldEnRoute`, `preCarrageBy`, `exportCarrier`) VALUES
(7, 7, 7, 9, 9, '12e', 'ahmweere', 'AL', '4343', '12c', 'CA', '23e', '23e', '40301', '23e', '21', '23e', '23', '23e', '23e', 0, '2019-10-30 15:47:22', 48, 48, '23e', '23e', 'DZ', 36, 'N', 'Y', 'N', 'D', 'N', '23e', '23');

-- --------------------------------------------------------

--
-- Table structure for table `images`
--

CREATE TABLE `images` (
  `id` int(11) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `image` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `images`
--

INSERT INTO `images` (`id`, `description`, `image`) VALUES
(176, '\"My Image\"', '1580370124084.jpeg');

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `id` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  `userIdIssuer` int(11) DEFAULT NULL,
  `userIdCustomer` int(11) DEFAULT NULL,
  `bankName` varchar(255) DEFAULT NULL,
  `bankTelephone` varchar(45) DEFAULT NULL,
  `bankAddress` varchar(255) DEFAULT NULL,
  `bankAccountNumber` varchar(45) DEFAULT NULL,
  `transferFees` int(11) NOT NULL DEFAULT '0',
  `description_of_charges` mediumtext NOT NULL,
  `deleted` int(1) DEFAULT '0',
  `payedOrNot` int(11) NOT NULL DEFAULT '0',
  `role` int(11) NOT NULL DEFAULT '0',
  `transactionId` int(11) DEFAULT NULL,
  `wireFees` float DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`id`, `date`, `userIdIssuer`, `userIdCustomer`, `bankName`, `bankTelephone`, `bankAddress`, `bankAccountNumber`, `transferFees`, `description_of_charges`, `deleted`, `payedOrNot`, `role`, `transactionId`, `wireFees`) VALUES
(26, '2019-09-14 17:19:28', 48, 49, 'chase bank ', '', '', '896142981', 0, 'loading 3 unit in 40hc \r\nBOOKING#63684779', 0, 0, 1, NULL, 0),
(27, '2019-10-02 15:52:36', 48, 69, 'CHASE BANK ', '7136407963', '8411 Gulf Fwy', '896142981', 0, 'Freight and loading from Houston to dammam container 40HC container#MSKU1789115 MAERSK LINNE', 0, 0, 1, NULL, 0),
(28, '2019-10-10 15:46:02', 48, 49, 'CHASE BANK ', '00', '00', '00', 0, 'LOADING 3 VEHICLE IN 40HC \r\nBOOKING# NAM3650117\r\nCONTAINER#MAGU5350773', 0, 0, 1, NULL, 0),
(29, '2020-02-12 16:28:11', 48, 49, 'CHASE BANK', '00', '00', '896142981', 0, 'LOADING 3 CARS IM 40HC BOOKING:NAM3650117', 0, 1, 1, 1, 0),
(30, '2019-11-12 22:02:39', 48, 65, 'BANK OF AMERICA ', '00', '222 BROADWAY NEWYORK 10038', '488039632168', 1, 'FRIGHT AND LOADING \r\n\r\nSWIFT CODE :BOFAUS3N \r\nROUT : 026009593', 0, 0, 1, NULL, 0),
(31, '2019-12-11 18:24:16', 48, 63, 'BANK OF AMERICA', '00', '00', '488039632168', 0, 'LOADING AND FREIGHT BOOKING #67688734 CONTAINER #HLBU1816441', 0, 0, 1, NULL, 0),
(32, '2019-12-14 20:24:22', 48, 65, 'BANK OF AMERICA ', '18004321000', '222 BROADWAY NEW YORK 10038', '488039632168', 0, 'LOADED 2 VEHICLE IN CONTAINER 40HC FROM HOUSTON TX TO RIYADH PORT SAUDIA ARABIA \r\nSAFMARINE SHIPLINE BOOKING 588822516 ', 0, 0, 1, NULL, 0),
(33, '2020-01-06 15:59:29', 48, 65, 'BANK OF AMERICA', '', '222 BROADWAY NEW YORK 10038', '488039632168,ROUT 026009593,SWIFT BOFAUS3N', 0, 'LOADING AND FREIGHT WITH STOREG AND RANDOM CHECK WITH CUSTOMS ', 0, 0, 1, NULL, 0),
(34, '2020-01-23 17:41:06', 48, 69, 'CHASE BANK ', '00', 'BRUD WAY ', '896142981', 0, 'LOADING 2 CARS AND HOUSE HOLD  GOOD WITH SPLIT BILL OF LOADING \r\nBOOKING#590153334\r\nCONT#TCLU5685894', 0, 0, 1, NULL, 0),
(35, '2020-01-23 18:22:29', 48, 76, 'CHASE BANK ', '00', 'DEPOSIT ', '896142981', 0, '2 CONTAINER LOADED BOOKING \r\nNAM3732369---CMAU7646023\r\nNAM3738611----APHU6315423', 0, 0, 1, NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `invoiceCar`
--

CREATE TABLE `invoiceCar` (
  `id` int(11) NOT NULL,
  `carId` int(11) DEFAULT NULL,
  `invoiceId` int(11) DEFAULT NULL,
  `deleted` int(1) DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `invoiceCar`
--

INSERT INTO `invoiceCar` (`id`, `carId`, `invoiceId`, `deleted`) VALUES
(69, 483, NULL, 0),
(68, 487, NULL, 0),
(67, 481, NULL, 0),
(66, 482, NULL, 0),
(65, 477, NULL, 0),
(64, 479, NULL, 0),
(60, 479, NULL, 0),
(63, 482, NULL, 0),
(62, 479, NULL, 0),
(61, 482, NULL, 0),
(70, 491, NULL, 0),
(71, 485, NULL, 0),
(72, 486, NULL, 0),
(73, 491, NULL, 0),
(74, 485, NULL, 0),
(75, 486, NULL, 0),
(76, 491, NULL, 0),
(77, 485, NULL, 0),
(78, 486, NULL, 0),
(79, 486, NULL, 0),
(80, 491, NULL, 0),
(81, 485, NULL, 0),
(82, 486, NULL, 0),
(83, 491, NULL, 0),
(84, 485, NULL, 0),
(85, 486, NULL, 0),
(86, 491, NULL, 0),
(87, 485, NULL, 0),
(88, 486, NULL, 0),
(89, 491, NULL, 0),
(90, 485, NULL, 0),
(91, 486, 26, 0),
(92, 491, 26, 0),
(93, 485, 26, 0),
(94, 538, NULL, 0),
(95, 537, NULL, 0),
(96, 537, NULL, 0),
(97, 538, NULL, 0),
(98, 538, NULL, 0),
(99, 537, NULL, 0),
(100, 538, 27, 0),
(101, 537, 27, 0),
(102, 484, 28, 0),
(103, 490, 28, 0),
(104, 489, 28, 0),
(105, 480, NULL, 0),
(106, 544, NULL, 0),
(107, 561, NULL, 0),
(108, 561, NULL, 0),
(109, 480, NULL, 0),
(110, 544, NULL, 0),
(111, 561, NULL, 0),
(154, 561, 29, 0),
(153, 544, 29, 0),
(152, 480, 29, 0),
(115, 570, 30, 0),
(116, 559, 30, 0),
(117, 570, 30, 0),
(118, 559, 30, 0),
(119, 570, 30, 0),
(120, 559, 30, 0),
(121, 570, 30, 0),
(122, 559, 30, 0),
(123, 570, 30, 0),
(124, 559, 30, 0),
(125, 592, 31, 0),
(126, 533, 31, 0),
(127, 591, 31, 0),
(128, 605, 32, 0),
(129, 609, 32, 0),
(130, 605, 32, 0),
(131, 609, 32, 0),
(132, 609, 33, 0),
(133, 605, 33, 0),
(134, 627, 34, 0),
(135, 626, 34, 0),
(136, 627, 34, 0),
(137, 626, 34, 0),
(138, 614, 35, 0),
(139, 613, 35, 0),
(140, 593, 35, 0),
(141, 612, 35, 0),
(142, 608, 35, 0),
(143, 595, 35, 0),
(144, 594, 35, 0),
(145, 614, 35, 0),
(146, 613, 35, 0),
(147, 593, 35, 0),
(148, 612, 35, 0),
(149, 608, 35, 0),
(150, 595, 35, 0),
(151, 594, 35, 0);

-- --------------------------------------------------------

--
-- Table structure for table `mainTwo`
--

CREATE TABLE `mainTwo` (
  `id` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `idType` int(11) DEFAULT NULL,
  `other` mediumtext,
  `notes` mediumtext,
  `allowAccess` int(11) NOT NULL DEFAULT '0',
  `parentId` int(11) DEFAULT NULL,
  `idNumber` varchar(255) DEFAULT NULL,
  `deleted` int(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mainTwo`
--

INSERT INTO `mainTwo` (`id`, `userId`, `idType`, `other`, `notes`, `allowAccess`, `parentId`, `idNumber`, `deleted`) VALUES
(27, 55, 1, '', '', 0, 48, '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `moneybox`
--

CREATE TABLE `moneybox` (
  `id` int(255) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `availableMoney` float DEFAULT '0',
  `totalUsed` float DEFAULT '0',
  `bankAccountNumber` varchar(255) DEFAULT NULL,
  `bankName` varchar(255) DEFAULT NULL,
  `bankAddress` varchar(255) DEFAULT NULL,
  `bankTelephone` varchar(255) DEFAULT NULL,
  `active` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `moneybox`
--

INSERT INTO `moneybox` (`id`, `userId`, `availableMoney`, `totalUsed`, `bankAccountNumber`, `bankName`, `bankAddress`, `bankTelephone`, `active`) VALUES
(1, 48, 5800, 2000, NULL, NULL, NULL, NULL, 1),
(2, 49, -800, 800, NULL, NULL, NULL, NULL, 1),
(3, 51, 0, 0, NULL, NULL, NULL, NULL, 1),
(4, 52, 0, 0, NULL, NULL, NULL, NULL, 1),
(5, 53, 0, 0, NULL, NULL, NULL, NULL, 1),
(6, 54, 0, 0, NULL, NULL, NULL, NULL, 1),
(7, 55, 0, 0, NULL, NULL, NULL, NULL, 1),
(8, 56, 0, 0, NULL, NULL, NULL, NULL, 1),
(9, 57, 0, 0, NULL, NULL, NULL, NULL, 1),
(10, 58, 0, 0, NULL, NULL, NULL, NULL, 1),
(11, 59, 0, 0, NULL, NULL, NULL, NULL, 1),
(12, 60, 0, 0, NULL, NULL, NULL, NULL, 1),
(13, 61, 0, 0, NULL, NULL, NULL, NULL, 1),
(14, 62, 0, 0, NULL, NULL, NULL, NULL, 1),
(15, 63, 0, 0, NULL, NULL, NULL, NULL, 1),
(16, 64, 0, 0, NULL, NULL, NULL, NULL, 1),
(17, 65, 0, 0, NULL, NULL, NULL, NULL, 1),
(18, 66, 0, 0, NULL, NULL, NULL, NULL, 1),
(19, 67, 0, 0, NULL, NULL, NULL, NULL, 1),
(20, 68, 0, 0, NULL, NULL, NULL, NULL, 1),
(21, 69, 0, 0, NULL, NULL, NULL, NULL, 1),
(22, 70, 0, 0, NULL, NULL, NULL, NULL, 1),
(23, 71, 0, 0, NULL, NULL, NULL, NULL, 1),
(24, 72, 0, 0, NULL, NULL, NULL, NULL, 1),
(25, 74, 0, 0, NULL, NULL, NULL, NULL, 1),
(26, 75, 0, 0, NULL, NULL, NULL, NULL, 1),
(27, 76, 0, 0, NULL, NULL, NULL, NULL, 1),
(28, 77, 0, 0, NULL, NULL, NULL, NULL, 1),
(29, 78, 0, 0, NULL, NULL, NULL, NULL, 1),
(30, 79, 0, 0, NULL, NULL, NULL, NULL, 1),
(31, 80, 0, 0, NULL, NULL, NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `moneybox_transaction_details`
--

CREATE TABLE `moneybox_transaction_details` (
  `id` int(11) NOT NULL,
  `moneyBoxId` int(11) DEFAULT NULL,
  `amount` float DEFAULT '0',
  `amountBefore` float DEFAULT '0',
  `date` datetime DEFAULT NULL,
  `typeOfTransaction` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `moneybox_transaction_details`
--

INSERT INTO `moneybox_transaction_details` (`id`, `moneyBoxId`, `amount`, `amountBefore`, `date`, `typeOfTransaction`) VALUES
(1, 2, 800, 5000, '2020-02-12 16:28:11', 1);

-- --------------------------------------------------------

--
-- Table structure for table `quote`
--

CREATE TABLE `quote` (
  `id` int(11) NOT NULL,
  `shipperId` int(11) DEFAULT NULL,
  `dateOfShipment` datetime DEFAULT NULL,
  `dimensions` int(11) DEFAULT NULL,
  `commodity` int(11) DEFAULT NULL,
  `comDescription` varchar(255) DEFAULT NULL,
  `width` float DEFAULT NULL,
  `height` float DEFAULT NULL,
  `depth` float DEFAULT NULL,
  `movetype` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `pieces` int(11) DEFAULT NULL,
  `mode` int(11) DEFAULT NULL,
  `loadtype` int(11) DEFAULT NULL,
  `declaredvalue` varchar(255) DEFAULT NULL,
  `fromCountry` int(11) DEFAULT NULL,
  `fromState` int(11) DEFAULT NULL,
  `fromPort` int(11) DEFAULT NULL,
  `toCountry` int(11) DEFAULT NULL,
  `toState` int(11) DEFAULT NULL,
  `toPort` int(11) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `marineInsurance` int(11) DEFAULT NULL,
  `deleted` int(1) DEFAULT '0'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `quote`
--

INSERT INTO `quote` (`id`, `shipperId`, `dateOfShipment`, `dimensions`, `commodity`, `comDescription`, `width`, `height`, `depth`, `movetype`, `quantity`, `pieces`, `mode`, `loadtype`, `declaredvalue`, `fromCountry`, `fromState`, `fromPort`, `toCountry`, `toState`, `toPort`, `note`, `weight`, `marineInsurance`, `deleted`) VALUES
(5, 27, '2019-10-03 07:59:04', 1, 0, 'vehicle ', NULL, NULL, NULL, 1, NULL, 3, 1, 1, '', 1, 46, 4802, 438, 2, 3706, '3 vihicle ', NULL, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `shipper`
--

CREATE TABLE `shipper` (
  `id` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `idType` int(11) DEFAULT NULL,
  `other` mediumtext,
  `notes` mediumtext,
  `allowAccess` int(11) NOT NULL DEFAULT '0',
  `parentId` int(11) DEFAULT NULL,
  `salesRep` varchar(45) DEFAULT NULL,
  `idNumber` varchar(255) DEFAULT NULL,
  `deleted` int(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shipper`
--

INSERT INTO `shipper` (`id`, `userId`, `idType`, `other`, `notes`, `allowAccess`, `parentId`, `salesRep`, `idNumber`, `deleted`) VALUES
(26, 49, 1, '', '', 0, 48, '', '', 0),
(27, 52, 1, '', '', 0, 48, '', '27164199500', 0),
(28, 54, 1, '', '', 0, 48, 'jay', '', 0),
(29, 57, 3, '', '', 1, 48, '', '552165', 0),
(30, 58, 1, '', '', 0, 48, '', '32040771200', 0),
(31, 63, 1, '', '', 0, 48, '', '', 0),
(32, 64, 1, '', '', 0, 48, '', '', 0),
(33, 65, 1, '', '', 0, 48, '', '', 0),
(34, 66, 1, '', '', 0, 48, '', '', 0),
(35, 67, 1, '', '', 0, 48, '', '260201827', 0),
(36, 68, 3, '', '', 0, 48, '', 'N49RC8GF', 0),
(37, 69, 1, '', '', 0, 48, '', '4108012', 0),
(39, 74, 1, '', '', 0, 48, '', '9292390232323', 0),
(40, 76, 3, '', 'TAREEK ALNAJAH ', 0, 48, 'TAREEK ALNAJAH ', 'GZ344G5G', 0);

-- --------------------------------------------------------

--
-- Table structure for table `transportfee`
--

CREATE TABLE `transportfee` (
  `id` int(11) NOT NULL,
  `location` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `njPortCost` varchar(45) DEFAULT NULL,
  `gaPortCost` varchar(45) DEFAULT NULL,
  `txPortCost` varchar(45) DEFAULT NULL,
  `caPortCost` varchar(45) DEFAULT NULL,
  `lowCost` varchar(45) DEFAULT NULL,
  `highCost` varchar(45) DEFAULT NULL,
  `deleted` int(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transportfee`
--

INSERT INTO `transportfee` (`id`, `location`, `city`, `state`, `njPortCost`, `gaPortCost`, `txPortCost`, `caPortCost`, `lowCost`, `highCost`, `deleted`) VALUES
(1, 'BIRMINGHAM', 'HUETOWN', 'AL', '0', '400', '0', '0', '875', '1100', 0),
(2, 'HUNTSVILLE', 'HUNTSVILLE', 'AL', '0', '425', '0', '0', '875', '1100', 0),
(3, 'MOBILE', 'EIGHT MILE', 'AL', '0', '400', '0', '0', '875', '1100', 0),
(4, 'MONTGOMERY', 'MONTGOMERY', 'AL', '0', '400', '0', '0', '875', '1100', 0),
(5, 'BIRMINGHAM', 'BESSEMER', 'AL', '0', '400', '0', '0', '875', '1100', 0),
(6, 'DOTHAN', 'HEADLAND', 'AL', '0', '400', '0', '0', '875', '1100', 0),
(7, 'HUNTSVILLE', 'ATHENS', 'AL', '0', '400', '0', '0', '875', '1100', 0),
(8, 'BIRMINGHAM', 'MOODY', 'AL', '0', '425', '0', '0', '875', '1100', 0),
(9, 'TANNER', 'TANNER', 'AL', '0', '450', '0', '0', '875', '1100', 0),
(10, 'Fayetteville', 'PRAIRIE GROVE', 'AR', '0', '0', '425', '0', '975', '1200', 0),
(11, 'Little Rock', 'CONWAY', 'AR', '0', '0', '425', '0', '975', '1200', 0),
(12, 'Fayetteville', 'Lincoln', 'AR', '0', '0', '425', '0', '975', '1200', 0),
(13, 'Little Rock', 'Scott', 'AR', '0', '0', '425', '0', '975', '1200', 0),
(14, 'PHOENIX', 'PHOENIX', 'AZ', '0', '0', '0', '300', '1050', '1400', 0),
(15, 'TUCSON', 'TUCSON', 'AZ', '0', '0', '0', '425', '1050', '1400', 0),
(16, 'PHOENIX', 'PHOENIX', 'AZ', '0', '0', '0', '300', '1050', '1400', 0),
(17, 'TUCSON', 'TUCSON', 'AZ', '0', '0', '0', '425', '1050', '1400', 0),
(18, 'ARIZONA', 'PHOENIX', 'AZ', '0', '0', '0', '300', '1050', '1400', 0),
(19, 'PNOENIX', 'TOLLESON', 'AZ', '0', '0', '0', '400', '1050', '1400', 0),
(20, 'TUCSON', 'TUCSON', 'AZ', '0', '0', '0', '475', '1050', '1400', 0),
(21, 'PHOENIX', 'CHANDLER', 'AZ', '0', '0', '0', '350', '1050', '1400', 0),
(22, 'BAKERSFIELD', 'BAKERSFIELD', 'CA', '0', '0', '0', '275', '1050', '1400', 0),
(23, 'FRESNO', 'FRESNO', 'CA', '0', '0', '0', '350', '1050', '1400', 0),
(24, 'HAYWARD', 'HAYWARD', 'CA', '0', '0', '0', '400', '1050', '1400', 0),
(25, 'LOS ANGELES', 'LOS ANGELES', 'CA', '0', '0', '0', '150', '1050', '1400', 0),
(26, 'MARTINEZ', 'MARTINEZ', 'CA', '0', '0', '0', '375', '1050', '1400', 0),
(27, 'RANCHO CUCAMONGA', 'RANCHO CUCAMONGA', 'CA', '0', '0', '0', '225', '1050', '1400', 0),
(28, 'SACRAMENTO', 'SACRAMENTO', 'CA', '0', '0', '0', '375', '1050', '1400', 0),
(29, 'SAN BERNARDINO', 'COLTON', 'CA', '0', '0', '0', '200', '1050', '1400', 0),
(30, 'SAN DIEGO', 'SAN DIEGO', 'CA', '0', '0', '0', '225', '1050', '1400', 0),
(31, 'SAN JOSE', 'SAN MARTIN', 'CA', '0', '0', '0', '350', '1050', '1400', 0),
(32, 'SOUTH SACRAMENTO', 'SACRAMENTO', 'CA', '0', '0', '0', '375', '1050', '1400', 0),
(33, 'VALLEJO', 'VALLEJO', 'CA', '0', '0', '0', '375', '1050', '1400', 0),
(34, 'VAN NUYS', 'VAN NUYS', 'CA', '0', '0', '0', '175', '1050', '1400', 0),
(35, 'ANAHEIM', 'ANAHEIM', 'CA', '0', '0', '0', '200', '1050', '1400', 0),
(36, 'COLTON', 'COLTON', 'CA', '0', '0', '0', '200', '1050', '1400', 0),
(37, 'EAST BAY', 'BAY POINT', 'CA', '0', '0', '0', '325', '1050', '1400', 0),
(38, 'FRESNO', 'FRESNO', 'CA', '0', '0', '0', '375', '1050', '1400', 0),
(39, 'FONTANA', 'FONTANA', 'CA', '0', '0', '0', '225', '1050', '1400', 0),
(40, 'FREMONT', 'FREMONT', 'CA', '0', '0', '0', '375', '1050', '1400', 0),
(41, 'HIGH DESERT', 'HESPERIA', 'CA', '0', '0', '0', '375', '1050', '1400', 0),
(42, 'LOS ANGELES', 'GARDENA', 'CA', '0', '0', '0', '150', '1050', '1400', 0),
(43, 'NORTH HOLLYWOOD', 'NORTH HOLLYWOOD', 'CA', '0', '0', '0', '150', '1050', '1400', 0),
(44, 'SACRAMENTO', 'RANCHO CORDOVA', 'CA', '0', '0', '0', '375', '1050', '1400', 0),
(45, 'SAN DIEGO', 'SAN DIEGO', 'CA', '0', '0', '0', '225', '1050', '1400', 0),
(46, 'CALIFORNIA', 'ANAHEIM', 'CA', '0', '0', '0', '175', '1050', '1400', 0),
(47, 'CENTRAL CALIFORNIA', 'FRESNO', 'CA', '0', '0', '0', '375', '1050', '1400', 0),
(48, 'RIVERSIDE', 'RIVERSIDE', 'CA', '0', '0', '0', '375', '1050', '1400', 0),
(49, 'SAN DIEGO', 'OCEANSIDE', 'CA', '0', '0', '0', '250', '1050', '1400', 0),
(50, 'SAN FRANCISCO BAY', 'HAYWARD', 'CA', '0', '0', '0', '375', '1050', '1400', 0),
(51, 'SOUTHERN CALIFORNIA', 'FONTANA', 'CA', '0', '0', '0', '225', '1050', '1400', 0),
(52, 'SAN DIEGO', 'SAN DIEGO', 'CA', '0', '0', '0', '225', '1050', '1400', 0),
(53, 'SACRAMENTO', 'SACRAMENTO', 'CA', '0', '0', '0', '375', '1050', '1400', 0),
(54, 'LOS ANGELES', 'MIRA LOMA', 'CA', '0', '0', '0', '375', '1050', '1400', 0),
(55, 'SUN VALLEY', 'SUN VALLEY', 'CA', '0', '0', '0', '200', '1050', '1400', 0),
(56, 'GOLDEN GATE', 'TRACY', 'CA', '0', '0', '0', '550', '1050', '1400', 0),
(57, 'DENVER', 'BRIGHTON', 'CO', '0', '0', '525', '550', '1050', '1400', 0),
(58, 'DENVER', 'DENVER', 'CO', '0', '0', '525', '550', '1050', '1400', 0),
(59, 'WESTERN COLORADO', 'DELTA', 'CO', '0', '0', '525', '525', '1050', '1400', 0),
(60, 'COLORADO', 'COMMERCE CITY', 'CO', '0', '0', '525', '550', '1050', '1400', 0),
(61, 'DENVER', 'AURORA', 'CO', '0', '0', '525', '550', '1050', '1400', 0),
(62, 'COLORADO SPRINGS', 'FOUNTAIN', 'CO', '0', '0', '525', '550', '1050', '1400', 0),
(63, 'Hartford', 'East Windsor', 'CT', '250', '0', '0', '0', '875', '1100', 0),
(64, 'Hartford-South', 'Middletown', 'CT', '250', '0', '0', '0', '875', '1100', 0),
(65, 'HARTFORD', 'NEW BRITAIN', 'CT', '250', '0', '0', '0', '875', '1100', 0),
(66, 'New Castle', 'New Castle', 'DE', '275', '0', '0', '0', '875', '1100', 0),
(67, 'SEAFORD', 'SEAFORD', 'DE', '275', '0', '0', '0', '875', '1100', 0),
(68, 'FORT PIERCE', 'FORT PIERCE', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(69, 'JACKSONVILLE EAST', 'JACKSONVILLE', 'FL', '0', '225', '0', '0', '875', '1100', 0),
(70, 'JACKSONVILLE WEST', 'JACKSONVILLE', 'FL', '0', '225', '0', '0', '875', '1100', 0),
(71, 'MIAMI CENTRAL', 'MIAMI', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(72, 'MIAMI NORTH', 'MIAMI', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(73, 'OCALA', 'OCALA', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(74, 'ORLANDO', 'ORLANDO', 'FL', '0', '300', '0', '0', '875', '1100', 0),
(75, 'PUNTA GORDA', 'PUNTA GORDA', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(76, 'TALLAHASSEE', 'MIDWAY', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(77, 'TAMPA EAST', 'DOVER', 'FL', '0', '300', '0', '0', '875', '1100', 0),
(78, 'TAMPA SOUTH', 'RIVERVIEW', 'FL', '0', '300', '0', '0', '875', '1100', 0),
(79, 'WEST PALM BEACH', 'WEST PALM BEACH', 'FL', '0', '375', '0', '0', '875', '1100', 0),
(80, 'CLEARWATER', 'CLEARWATER', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(81, 'JACKSONVILLE', 'JACKSONVILLE', 'FL', '0', '225', '0', '0', '875', '1100', 0),
(82, 'MIAMI', 'OPA LOCKA', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(83, 'MIAMI NORTH', 'PEMBROKE PINES', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(84, 'ORLANDO NORTH', 'SANFORD', 'FL', '0', '275', '0', '0', '875', '1100', 0),
(85, 'ORLANDO', 'ORLANDO', 'FL', '0', '300', '0', '0', '875', '1100', 0),
(86, 'PENSACOLA', 'MILTON', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(87, 'TAMPA', 'PALMETTO', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(88, 'CENTRAL FLORIDA', 'ORLANDO', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(89, 'DAYTONA BEACH', 'DAYTONA BEACH', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(90, 'FORT LAUDERDALE', 'DAVIE', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(91, 'FORT MYERS', 'FORT MYERS', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(92, 'IMPERIAL FLORIDA', 'LAKELAND', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(93, 'JACKSONVILLE', 'JACKSONVILLE', 'FL', '0', '225', '0', '0', '875', '1100', 0),
(94, 'LAKELAND', 'LAKELAND', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(95, 'ORLANDO', 'OCOEE', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(96, 'PALM BEACH', 'WEST PALM BEACH', 'FL', '0', '375', '0', '0', '875', '1100', 0),
(97, 'PENSACOLA', 'PENSACOLA', 'FL', '0', '375', '0', '0', '875', '1100', 0),
(98, 'SAINT PETE', 'CLEARWATER', 'FL', '0', '325', '0', '0', '875', '1100', 0),
(99, 'TAMPA', 'TAMPA', 'FL', '0', '300', '0', '0', '875', '1100', 0),
(100, 'MIAMI', 'OPA LOCKA', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(101, 'SARASOTA', 'BRADENTON', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(102, 'TAMPA', 'TAMPA', 'FL', '0', '300', '0', '0', '875', '1100', 0),
(103, 'OCALA', 'OCALA', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(104, 'JACKSONVILLE', 'JACKSONVILLE', 'FL', '0', '225', '0', '0', '875', '1100', 0),
(105, 'ATLANTA EAST', 'LOGANVILLE', 'GA', '0', '275', '0', '0', '875', '1100', 0),
(106, 'ATLANTA WEST', 'AUSTELL', 'GA', '0', '275', '0', '0', '875', '1100', 0),
(107, 'SAVANNAH', 'SAVANNAH', 'GA', '0', '125', '0', '0', '875', '1100', 0),
(108, 'TIFTON', 'TIFTON', 'GA', '0', '275', '0', '0', '875', '1100', 0),
(109, 'ATLANTA EAST', 'WINDER', 'GA', '0', '275', '0', '0', '875', '1100', 0),
(110, 'ATLANTA NORTH', 'ACWORTH', 'GA', '0', '275', '0', '0', '875', '1100', 0),
(111, 'ATLANTA', 'LOGANVILLE', 'GA', '0', '275', '0', '0', '875', '1100', 0),
(112, 'ATLANTA SOUTH', 'LAKE CITY', 'GA', '0', '275', '0', '0', '875', '1100', 0),
(113, 'SAVANNAH', 'RINCON', 'GA', '0', '125', '0', '0', '875', '1100', 0),
(114, 'TIFTON', 'TIFTON', 'GA', '0', '275', '0', '0', '875', '1100', 0),
(115, 'GEORGIA', 'ATLANTA', 'GA', '0', '300', '0', '0', '875', '1100', 0),
(116, 'DRIVE CENTER', 'STOCKBRIDGE', 'GA', '0', '325', '0', '0', '875', '1100', 0),
(117, 'GEORGIA', 'ATLANTA', 'GA', '0', '325', '0', '0', '875', '1100', 0),
(118, 'METRO ATLANTA', 'ATLANTA', 'GA', '0', '325', '0', '0', '875', '1100', 0),
(119, 'ATLANTA', 'FAIRBURN', 'GA', '0', '325', '0', '0', '875', '1100', 0),
(120, 'CARTERSVILLE', 'CARTERSVILLE', 'GA', '0', '300', '0', '0', '875', '1100', 0),
(121, 'BOISE', 'NAMPA', 'ID', '0', '0', '0', '600', '875', '1100', 0),
(122, 'BOISE', 'CALDWELL', 'ID', '0', '0', '0', '600', '875', '1100', 0),
(123, 'CHICAGO NORTH', 'ELGIN', 'IL', '475', '0', '0', '0', '875', '1100', 0),
(124, 'CHICAGO SOUTH', 'CHICAGO HEIGHTS', 'IL', '475', '0', '0', '0', '875', '1100', 0),
(125, 'PEORIA', 'PEKIN', 'IL', '500', '0', '0', '0', '875', '1100', 0),
(126, 'CHICAGO WEST', 'AURORA', 'IL', '475', '0', '0', '0', '875', '1100', 0),
(127, 'CHICAGO NORTH', 'WHEELING', 'IL', '475', '0', '0', '0', '875', '1100', 0),
(128, 'CHICAGO SOUTH', 'MARKHAM', 'IL', '475', '0', '0', '0', '875', '1100', 0),
(129, 'LINCOLN', 'LINCOLN', 'IL', '525', '0', '0', '0', '875', '1100', 0),
(130, 'SPECIALTY DIVISION', 'WHEELING', 'IL', '575', '0', '0', '0', '875', '1100', 0),
(131, 'SAINT LOUIS', 'GRANITE CITY', 'IL', '550', '0', '0', '0', '875', '1100', 0),
(132, 'ARENA ILLINOIS', 'BOLINGBROOK', 'IL', '475', '0', '0', '0', '875', '1100', 0),
(133, 'CHICAGO', 'MATTESON', 'IL', '475', '0', '0', '0', '875', '1100', 0),
(134, 'METRO CHICAGO', 'AISIP', 'IL', '500', '0', '0', '0', '875', '1100', 0),
(135, 'Chicago North', 'East Dundee', 'IL', '475', '0', '0', '0', '875', '1100', 0),
(136, 'SOUTHERN ILLINOIS', 'Saint Louis', 'IL', '500', '0', '0', '0', '875', '1100', 0),
(137, 'HAMMOND', 'HAMMOND', 'IN', '475', '0', '0', '0', '875', '1100', 0),
(138, 'INDIANAPOLIS', 'INDIANAPOLIS', 'IN', '475', '0', '0', '0', '875', '1100', 0),
(139, 'INDIANAPOLIS', 'INDIANAPOLIS', 'IN', '475', '0', '0', '0', '875', '1100', 0),
(140, 'SOUTH BEND', 'SOUTH BEND', 'IN', '475', '0', '0', '0', '875', '1100', 0),
(141, 'FORT WAYNE', 'FORT WAYNE', 'IN', '475', '0', '0', '0', '875', '1100', 0),
(142, 'INDIANAPOLIS', 'INDIANAPOLIS', 'IN', '475', '0', '0', '0', '875', '1100', 0),
(143, 'LOUISVILLE', 'CLARKSVILLE', 'IN', '475', '0', '0', '0', '875', '1100', 0),
(144, 'INDIANAPOLIS', 'PLAINFIELD', 'IN', '475', '0', '0', '0', '875', '1100', 0),
(145, 'DES MOINES', 'DES MOINES', 'IA', '650', '0', '0', '0', '875', '1100', 0),
(146, 'DES MOINES', 'DES MOINES', 'IA', '650', '0', '0', '0', '875', '1100', 0),
(147, 'DES MOINES', 'GRIMES', 'IA', '725', '0', '0', '0', '875', '1100', 0),
(148, 'Davenport', 'Davenport', 'IA', '650', '0', '0', '0', '875', '1100', 0),
(149, 'KANSAS CITY', 'KANSAS CITY', 'KS', '0', '0', '475', '0', '975', '1200', 0),
(150, 'WICHITA', 'WICHITA', 'KS', '0', '0', '475', '0', '975', '1200', 0),
(151, 'KANSAS CITY', 'KANSAS CITY', 'KS', '0', '0', '475', '0', '975', '1200', 0),
(152, 'WICHITA', 'WICHITA', 'KS', '0', '0', '475', '0', '975', '1200', 0),
(153, 'LEXINGTON EAST', 'LEXINGTON', 'KY', '525', '0', '0', '0', '875', '1100', 0),
(154, 'LEXINGTON WEST', 'LAWRENCEBURG', 'KY', '525', '0', '0', '0', '875', '1100', 0),
(155, 'LOUISVILLE', 'LOUISVILLE', 'KY', '525', '0', '0', '0', '875', '1100', 0),
(156, 'WALTON', 'WALTON', 'KY', '525', '0', '0', '0', '875', '1100', 0),
(157, 'ASHLAND', 'ASHLAND', 'KY', '500', '0', '0', '0', '875', '1100', 0),
(158, 'BOWLING GREEN', 'BOWLING GREEN', 'KY', '525', '0', '0', '0', '875', '1100', 0),
(159, 'PADUCAH', 'PADUCAH', 'KY', '550', '0', '0', '0', '875', '1100', 0),
(160, 'BIRMINGHAM', 'HUETOWN', 'AL', '0', '400', '0', '0', '875', '1100', 0),
(161, 'HUNTSVILLE', 'HUNTSVILLE', 'AL', '0', '425', '0', '0', '875', '1100', 0),
(162, 'MOBILE', 'EIGHT MILE', 'AL', '0', '400', '0', '0', '875', '1100', 0),
(163, 'MONTGOMERY', 'MONTGOMERY', 'AL', '0', '400', '0', '0', '875', '1100', 0),
(164, 'BIRMINGHAM', 'BESSEMER', 'AL', '0', '400', '0', '0', '875', '1100', 0),
(165, 'DOTHAN', 'HEADLAND', 'AL', '0', '400', '0', '0', '875', '1100', 0),
(166, 'HUNTSVILLE', 'ATHENS', 'AL', '0', '400', '0', '0', '875', '1100', 0),
(167, 'BIRMINGHAM', 'MOODY', 'AL', '0', '425', '0', '0', '875', '1100', 0),
(168, 'TANNER', 'TANNER', 'AL', '0', '450', '0', '0', '875', '1100', 0),
(169, 'Fayetteville', 'PRAIRIE GROVE', 'AR', '0', '0', '425', '0', '975', '1200', 0),
(170, 'Little Rock', 'CONWAY', 'AR', '0', '0', '425', '0', '975', '1200', 0),
(171, 'Fayetteville', 'Lincoln', 'AR', '0', '0', '425', '0', '975', '1200', 0),
(172, 'Little Rock', 'Scott', 'AR', '0', '0', '425', '0', '975', '1200', 0),
(173, 'PHOENIX', 'PHOENIX', 'AZ', '0', '0', '0', '300', '1050', '1400', 0),
(174, 'TUCSON', 'TUCSON', 'AZ', '0', '0', '0', '425', '1050', '1400', 0),
(175, 'PHOENIX', 'PHOENIX', 'AZ', '0', '0', '0', '300', '1050', '1400', 0),
(176, 'TUCSON', 'TUCSON', 'AZ', '0', '0', '0', '425', '1050', '1400', 0),
(177, 'ARIZONA', 'PHOENIX', 'AZ', '0', '0', '0', '300', '1050', '1400', 0),
(178, 'PNOENIX', 'TOLLESON', 'AZ', '0', '0', '0', '400', '1050', '1400', 0),
(179, 'TUCSON', 'TUCSON', 'AZ', '0', '0', '0', '475', '1050', '1400', 0),
(180, 'PHOENIX', 'CHANDLER', 'AZ', '0', '0', '0', '350', '1050', '1400', 0),
(181, 'BAKERSFIELD', 'BAKERSFIELD', 'CA', '0', '0', '0', '275', '1050', '1400', 0),
(182, 'FRESNO', 'FRESNO', 'CA', '0', '0', '0', '350', '1050', '1400', 0),
(183, 'HAYWARD', 'HAYWARD', 'CA', '0', '0', '0', '400', '1050', '1400', 0),
(184, 'LOS ANGELES', 'LOS ANGELES', 'CA', '0', '0', '0', '150', '1050', '1400', 0),
(185, 'MARTINEZ', 'MARTINEZ', 'CA', '0', '0', '0', '375', '1050', '1400', 0),
(186, 'RANCHO CUCAMONGA', 'RANCHO CUCAMONGA', 'CA', '0', '0', '0', '225', '1050', '1400', 0),
(187, 'SACRAMENTO', 'SACRAMENTO', 'CA', '0', '0', '0', '375', '1050', '1400', 0),
(188, 'SAN BERNARDINO', 'COLTON', 'CA', '0', '0', '0', '200', '1050', '1400', 0),
(189, 'SAN DIEGO', 'SAN DIEGO', 'CA', '0', '0', '0', '225', '1050', '1400', 0),
(190, 'SAN JOSE', 'SAN MARTIN', 'CA', '0', '0', '0', '350', '1050', '1400', 0),
(191, 'SOUTH SACRAMENTO', 'SACRAMENTO', 'CA', '0', '0', '0', '375', '1050', '1400', 0),
(192, 'VALLEJO', 'VALLEJO', 'CA', '0', '0', '0', '375', '1050', '1400', 0),
(193, 'VAN NUYS', 'VAN NUYS', 'CA', '0', '0', '0', '175', '1050', '1400', 0),
(194, 'ANAHEIM', 'ANAHEIM', 'CA', '0', '0', '0', '200', '1050', '1400', 0),
(195, 'COLTON', 'COLTON', 'CA', '0', '0', '0', '200', '1050', '1400', 0),
(196, 'EAST BAY', 'BAY POINT', 'CA', '0', '0', '0', '325', '1050', '1400', 0),
(197, 'FRESNO', 'FRESNO', 'CA', '0', '0', '0', '375', '1050', '1400', 0),
(198, 'FONTANA', 'FONTANA', 'CA', '0', '0', '0', '225', '1050', '1400', 0),
(199, 'FREMONT', 'FREMONT', 'CA', '0', '0', '0', '375', '1050', '1400', 0),
(200, 'HIGH DESERT', 'HESPERIA', 'CA', '0', '0', '0', '375', '1050', '1400', 0),
(201, 'LOS ANGELES', 'GARDENA', 'CA', '0', '0', '0', '150', '1050', '1400', 0),
(202, 'NORTH HOLLYWOOD', 'NORTH HOLLYWOOD', 'CA', '0', '0', '0', '150', '1050', '1400', 0),
(203, 'SACRAMENTO', 'RANCHO CORDOVA', 'CA', '0', '0', '0', '375', '1050', '1400', 0),
(204, 'SAN DIEGO', 'SAN DIEGO', 'CA', '0', '0', '0', '225', '1050', '1400', 0),
(205, 'CALIFORNIA', 'ANAHEIM', 'CA', '0', '0', '0', '175', '1050', '1400', 0),
(206, 'CENTRAL CALIFORNIA', 'FRESNO', 'CA', '0', '0', '0', '375', '1050', '1400', 0),
(207, 'RIVERSIDE', 'RIVERSIDE', 'CA', '0', '0', '0', '1050', '1050', '1400', 0),
(208, 'SAN DIEGO', 'OCEANSIDE', 'CA', '0', '0', '0', '250', '1050', '1400', 0),
(209, 'SAN FRANCISCO BAY', 'HAYWARD', 'CA', '0', '0', '0', '375', '1050', '1400', 0),
(210, 'SOUTHERN CALIFORNIA', 'FONTANA', 'CA', '0', '0', '0', '225', '1050', '1400', 0),
(211, 'SAN DIEGO', 'SAN DIEGO', 'CA', '0', '0', '0', '225', '1050', '1400', 0),
(212, 'SACRAMENTO', 'SACRAMENTO', 'CA', '0', '0', '0', '375', '1050', '1400', 0),
(213, 'LOS ANGELES', 'MIRA LOMA', 'CA', '0', '0', '0', '1050', '1050', '1400', 0),
(214, 'SUN VALLEY', 'SUN VALLEY', 'CA', '0', '0', '0', '200', '1050', '1400', 0),
(215, 'GOLDEN GATE', 'TRACY', 'CA', '0', '0', '0', '1050', '1050', '1400', 0),
(216, 'DENVER', 'BRIGHTON', 'CO', '0', '0', '525', '550', '1050', '1400', 0),
(217, 'DENVER', 'DENVER', 'CO', '0', '0', '525', '550', '1050', '1400', 0),
(218, 'WESTERN COLORADO', 'DELTA', 'CO', '0', '0', '1050', '1050', '1050', '1400', 0),
(219, 'COLORADO', 'COMMERCE CITY', 'CO', '0', '0', '525', '550', '1050', '1400', 0),
(220, 'DENVER', 'AURORA', 'CO', '0', '0', '525', '550', '1050', '1400', 0),
(221, 'COLORADO SPRINGS', 'FOUNTAIN', 'CO', '0', '0', '525', '550', '1050', '1400', 0),
(222, 'Hartford', 'East Windsor', 'CT', '250', '0', '0', '0', '875', '1100', 0),
(223, 'Hartford-South', 'Middletown', 'CT', '250', '0', '0', '0', '875', '1100', 0),
(224, 'HARTFORD', 'NEW BRITAIN', 'CT', '250', '0', '0', '0', '875', '1100', 0),
(225, 'New Castle', 'New Castle', 'DE', '275', '0', '0', '0', '875', '1100', 0),
(226, 'SEAFORD', 'SEAFORD', 'DE', '275', '0', '0', '0', '875', '1100', 0),
(227, 'FORT PIERCE', 'FORT PIERCE', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(228, 'JACKSONVILLE EAST', 'JACKSONVILLE', 'FL', '0', '225', '0', '0', '875', '1100', 0),
(229, 'JACKSONVILLE WEST', 'JACKSONVILLE', 'FL', '0', '225', '0', '0', '875', '1100', 0),
(230, 'MIAMI CENTRAL', 'MIAMI', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(231, 'MIAMI NORTH', 'MIAMI', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(232, 'OCALA', 'OCALA', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(233, 'ORLANDO', 'ORLANDO', 'FL', '0', '300', '0', '0', '875', '1100', 0),
(234, 'PUNTA GORDA', 'PUNTA GORDA', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(235, 'TALLAHASSEE', 'MIDWAY', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(236, 'TAMPA EAST', 'DOVER', 'FL', '0', '300', '0', '0', '875', '1100', 0),
(237, 'TAMPA SOUTH', 'RIVERVIEW', 'FL', '0', '300', '0', '0', '875', '1100', 0),
(238, 'WEST PALM BEACH', 'WEST PALM BEACH', 'FL', '0', '375', '0', '0', '875', '1100', 0),
(239, 'CLEARWATER', 'CLEARWATER', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(240, 'JACKSONVILLE', 'JACKSONVILLE', 'FL', '0', '225', '0', '0', '875', '1100', 0),
(241, 'MIAMI', 'OPA LOCKA', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(242, 'MIAMI NORTH', 'PEMBROKE PINES', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(243, 'ORLANDO NORTH', 'SANFORD', 'FL', '0', '275', '0', '0', '875', '1100', 0),
(244, 'ORLANDO', 'ORLANDO', 'FL', '0', '300', '0', '0', '875', '1100', 0),
(245, 'PENSACOLA', 'MILTON', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(246, 'TAMPA', 'PALMETTO', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(247, 'CENTRAL FLORIDA', 'ORLANDO', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(248, 'DAYTONA BEACH', 'DAYTONA BEACH', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(249, 'FORT LAUDERDALE', 'DAVIE', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(250, 'FORT MYERS', 'FORT MYERS', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(251, 'IMPERIAL FLORIDA', 'LAKELAND', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(252, 'JACKSONVILLE', 'JACKSONVILLE', 'FL', '0', '225', '0', '0', '875', '1100', 0),
(253, 'LAKELAND', 'LAKELAND', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(254, 'ORLANDO', 'OCOEE', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(255, 'PALM BEACH', 'WEST PALM BEACH', 'FL', '0', '375', '0', '0', '875', '1100', 0),
(256, 'PENSACOLA', 'PENSACOLA', 'FL', '0', '375', '0', '0', '875', '1100', 0),
(257, 'SAINT PETE', 'CLEARWATER', 'FL', '0', '325', '0', '0', '875', '1100', 0),
(258, 'TAMPA', 'TAMPA', 'FL', '0', '300', '0', '0', '875', '1100', 0),
(259, 'MIAMI', 'OPA LOCKA', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(260, 'SARASOTA', 'BRADENTON', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(261, 'TAMPA', 'TAMPA', 'FL', '0', '300', '0', '0', '875', '1100', 0),
(262, 'OCALA', 'OCALA', 'FL', '0', '350', '0', '0', '875', '1100', 0),
(263, 'JACKSONVILLE', 'JACKSONVILLE', 'FL', '0', '225', '0', '0', '875', '1100', 0),
(264, 'ATLANTA EAST', 'LOGANVILLE', 'GA', '0', '275', '0', '0', '875', '1100', 0),
(265, 'ATLANTA WEST', 'AUSTELL', 'GA', '0', '275', '0', '0', '875', '1100', 0),
(266, 'SAVANNAH', 'SAVANNAH', 'GA', '0', '125', '0', '0', '875', '1100', 0),
(267, 'TIFTON', 'TIFTON', 'GA', '0', '275', '0', '0', '875', '1100', 0),
(268, 'ATLANTA EAST', 'WINDER', 'GA', '0', '275', '0', '0', '875', '1100', 0),
(269, 'ATLANTA NORTH', 'ACWORTH', 'GA', '0', '275', '0', '0', '875', '1100', 0),
(270, 'ATLANTA', 'LOGANVILLE', 'GA', '0', '275', '0', '0', '875', '1100', 0),
(271, 'ATLANTA SOUTH', 'LAKE CITY', 'GA', '0', '275', '0', '0', '875', '1100', 0),
(272, 'SAVANNAH', 'RINCON', 'GA', '0', '125', '0', '0', '875', '1100', 0),
(273, 'TIFTON', 'TIFTON', 'GA', '0', '275', '0', '0', '875', '1100', 0),
(274, 'GEORGIA', 'ATLANTA', 'GA', '0', '300', '0', '0', '875', '1100', 0),
(275, 'DRIVE CENTER', 'STOCKBRIDGE', 'GA', '0', '325', '0', '0', '875', '1100', 0),
(276, 'GEORGIA', 'ATLANTA', 'GA', '0', '325', '0', '0', '875', '1100', 0),
(277, 'METRO ATLANTA', 'ATLANTA', 'GA', '0', '325', '0', '0', '875', '1100', 0),
(278, 'ATLANTA', 'FAIRBURN', 'GA', '0', '325', '0', '0', '875', '1100', 0),
(279, 'CARTERSVILLE', 'CARTERSVILLE', 'GA', '0', '300', '0', '0', '875', '1100', 0),
(280, 'BOISE', 'NAMPA', 'ID', '0', '0', '0', '600', '1050', '1400', 0),
(281, 'BOISE', 'CALDWELL', 'ID', '0', '0', '', '600', '1050', '1400', 0),
(282, 'CHICAGO NORTH', 'ELGIN', 'IL', '475', '0', '0', '0', '875', '1100', 0),
(283, 'CHICAGO SOUTH', 'CHICAGO HEIGHTS', 'IL', '475', '0', '0', '0', '875', '1100', 0),
(284, 'PEORIA', 'PEKIN', 'IL', '500', '0', '0', '0', '875', '1100', 0),
(285, 'CHICAGO WEST', 'AURORA', 'IL', '475', '0', '0', '0', '875', '1100', 0),
(286, 'CHICAGO NORTH', 'WHEELING', 'IL', '475', '0', '0', '0', '875', '1100', 0),
(287, 'CHICAGO SOUTH', 'MARKHAM', 'IL', '475', '0', '0', '0', '875', '1100', 0),
(288, 'LINCOLN', 'LINCOLN', 'IL', '525', '0', '0', '0', '875', '1100', 0),
(289, 'SPECIALTY DIVISION', 'WHEELING', 'IL', '575', '0', '0', '0', '875', '1100', 0),
(290, 'SAINT LOUIS', 'GRANITE CITY', 'IL', '550', '0', '0', '0', '875', '1100', 0),
(291, 'ARENA ILLINOIS', 'BOLINGBROOK', 'IL', '475', '0', '0', '0', '875', '1100', 0),
(292, 'CHICAGO', 'MATTESON', 'IL', '475', '0', '0', '0', '875', '1100', 0),
(293, 'METRO CHICAGO', 'AISIP', 'IL', '500', '0', '0', '0', '875', '1100', 0),
(294, 'Chicago North', 'East Dundee', 'IL', '475', '0', '0', '0', '875', '1100', 0),
(295, 'SOUTHERN ILLINOIS', 'Saint Louis', 'IL', '500', '0', '0', '0', '875', '1100', 0),
(296, 'HAMMOND', 'HAMMOND', 'IN', '475', '0', '0', '0', '875', '1100', 0),
(297, 'INDIANAPOLIS', 'INDIANAPOLIS', 'IN', '475', '0', '0', '0', '875', '1100', 0),
(298, 'INDIANAPOLIS', 'INDIANAPOLIS', 'IN', '475', '0', '0', '0', '875', '1100', 0),
(299, 'SOUTH BEND', 'SOUTH BEND', 'IN', '475', '0', '0', '0', '875', '1100', 0),
(300, 'FORT WAYNE', 'FORT WAYNE', 'IN', '475', '0', '0', '0', '875', '1100', 0),
(301, 'INDIANAPOLIS', 'INDIANAPOLIS', 'IN', '475', '0', '0', '0', '875', '1100', 0),
(302, 'LOUISVILLE', 'CLARKSVILLE', 'IN', '475', '0', '0', '0', '875', '1100', 0),
(303, 'INDIANAPOLIS', 'PLAINFIELD', 'IN', '475', '0', '0', '0', '875', '1100', 0),
(304, 'DES MOINES', 'DES MOINES', 'IA', '650', '0', '0', '0', '875', '1100', 0),
(305, 'DES MOINES', 'DES MOINES', 'IA', '650', '0', '0', '0', '875', '1100', 0),
(306, 'DES MOINES', 'GRIMES', 'IA', '725', '0', '0', '0', '875', '1100', 0),
(307, 'Davenport', 'Davenport', 'IA', '650', '0', '0', '0', '875', '1100', 0),
(308, 'KANSAS CITY', 'KANSAS CITY', 'KS', '0', '0', '475', '0', '975', '1200', 0),
(309, 'WICHITA', 'WICHITA', 'KS', '0', '0', '475', '0', '975', '1200', 0),
(310, 'KANSAS CITY', 'KANSAS CITY', 'KS', '0', '0', '475', '0', '975', '1200', 0),
(311, 'WICHITA', 'WICHITA', 'KS', '0', '0', '475', '0', '975', '1200', 0),
(312, 'LEXINGTON EAST', 'LEXINGTON', 'KY', '525', '0', '0', '0', '875', '1100', 0),
(313, 'LEXINGTON WEST', 'LAWRENCEBURG', 'KY', '525', '0', '0', '0', '875', '1100', 0),
(314, 'LOUISVILLE', 'LOUISVILLE', 'KY', '525', '0', '0', '0', '875', '1100', 0),
(315, 'WALTON', 'WALTON', 'KY', '525', '0', '0', '0', '875', '1100', 0),
(316, 'ASHLAND', 'ASHLAND', 'KY', '500', '0', '0', '0', '875', '1100', 0),
(317, 'BOWLING GREEN', 'BOWLING GREEN', 'KY', '525', '0', '0', '0', '875', '1100', 0),
(318, 'PADUCAH', 'PADUCAH', 'KY', '550', '0', '0', '0', '875', '1100', 0),
(319, 'LEXINGTON', 'LEXINGTON', 'KY', '525', '0', '0', '0', '875', '1100', 0),
(320, 'Louisville North', 'Eminence', 'KY', '575', '0', '575', '575', '875', '1100', 0),
(321, 'BATON ROUGE', 'GREENWELL SPRINGS', 'LA', '0', '0', '325', '0', '975', '1200', 0),
(322, 'LIVINGSTON', 'LIVINGSTON', 'LA', '0', '0', '325', '0', '975', '1200', 0),
(323, 'NEW ORLEANS', 'NEW ORLEANS', 'LA', '0', '0', '325', '0', '975', '1200', 0),
(324, 'SHREVEPORT', 'SHREVEPORT', 'LA', '0', '0', '325', '0', '975', '1200', 0),
(325, 'BATON ROUGE', 'LIVINGSTON', 'LA', '0', '0', '300', '0', '975', '1200', 0),
(326, 'LAFAYETTE', 'SCOTT', 'LA', '0', '0', '325', '0', '975', '1200', 0),
(327, 'NEW ORLEANS', 'SLIDELL', 'LA', '0', '0', '325', '0', '975', '1200', 0),
(328, 'SHREVEPORT', 'SHREVEPORT', 'LA', '0', '0', '325', '0', '975', '1200', 0),
(329, 'PORTLAND - SACO', 'SACO', 'ME', '300', '0', '0', '0', '875', '1100', 0),
(330, 'LYMAN', 'LYMAN', 'ME', '300', '0', '0', '0', '875', '1100', 0),
(331, 'Portland - Gorham', 'Gorham', 'ME', '300', '0', '0', '0', '875', '1100', 0),
(332, 'WASHINGTON DC', 'WALDORF', 'MD', '300', '0', '0', '0', '875', '1100', 0),
(333, 'BALTIMORE', 'FINKSBURG', 'MD', '300', '0', '0', '0', '875', '1100', 0),
(334, 'SALISBURY', 'FRUITLAND', 'MD', '325', '0', '0', '0', '875', '1100', 0),
(335, 'BALTIMORE', 'BALTIMORE', 'MD', '300', '0', '0', '0', '875', '1100', 0),
(336, 'LAUREL', 'LAUREL', 'MD', '300', '0', '0', '0', '875', '1100', 0),
(337, 'METRO DC', 'BRANDYWINE', 'MD', '300', '0', '0', '0', '875', '1100', 0),
(338, 'BALTIMORE - WASHINGTON', 'ELKRIDGE', 'MD', '300', '0', '0', '0', '875', '1100', 0),
(339, 'Dundalk', 'Dundalk', 'MD', '300', '0', '0', '0', '875', '1100', 0),
(340, 'NORTH BOSTON', 'NORTH BILLERICA', 'MA', '325', '0', '0', '0', '875', '1100', 0),
(341, 'SOUTH BOSTON', 'BELLINGHAM', 'MA', '350', '0', '0', '0', '875', '1100', 0),
(342, 'WEST WARREN', 'WEST WARREN', 'MA', '350', '0', '0', '0', '875', '1100', 0),
(343, 'BOSTON', 'LANCASTER', 'MA', '350', '0', '0', '0', '875', '1100', 0),
(344, 'TAUNTON', 'EAST TAUNTON', 'MA', '350', '0', '0', '0', '875', '1100', 0),
(345, 'NEW ENGLAND', 'NORTH DIGHTON', 'MA', '350', '0', '0', '0', '875', '1100', 0),
(346, 'BOSTON', 'FRAMINGHAM', 'MA', '350', '0', '0', '0', '875', '1100', 0),
(347, 'CONCORD', 'ACTON', 'MA', '350', '0', '0', '0', '875', '1100', 0),
(348, 'Boston - Shirley', 'Shirley', 'MA', '350', '0', '0', '0', '875', '1100', 0),
(349, 'DETROIT', 'WOODHAVEN', 'MI', '525', '0', '0', '0', '875', '1100', 0),
(350, 'LANSING', 'LANSING', 'MI', '525', '0', '0', '0', '875', '1100', 0),
(351, 'DETROIT', 'BELLEVILLE', 'MI', '525', '0', '0', '0', '875', '1100', 0),
(352, 'GRAND RAPIDS', 'BYRON CENTER', 'MI', '525', '0', '0', '0', '875', '1100', 0),
(353, 'DETROIT', 'CARLETON', 'MI', '525', '0', '0', '0', '875', '1100', 0),
(354, 'METRO DETROIT', 'FLAT ROCK', 'MI', '575', '0', '0', '0', '875', '1100', 0),
(355, 'LANSING', 'DIMONDALE', 'MI', '525', '0', '0', '0', '875', '1100', 0),
(356, 'KINCHELOE', 'KINCHELOE', 'MI', '850', '0', '0', '0', '875', '1100', 0),
(357, 'MINNEAPOLIS', 'FRIDLEY', 'MN', '525', '0', '0', '0', '875', '1100', 0),
(358, 'MINNEAPOLIS NORTH', 'HAM LAKE', 'MN', '525', '0', '0', '0', '875', '1100', 0),
(359, 'SAINT CLOUD', 'AVON', 'MN', '525', '0', '0', '0', '875', '1100', 0),
(360, 'MINNEAPOLIS', 'SAINT PAUL', 'MN', '525', '0', '0', '0', '875', '1100', 0),
(361, 'MINNEAPOLLIS', 'MAPLE GROVE', 'MN', '525', '0', '0', '0', '875', '1100', 0),
(362, 'NORTHSTAR MINNESOTA', 'SHAKOPEE', 'MN', '525', '0', '0', '0', '875', '1100', 0),
(363, 'MINNEAPOLIS', 'DAYTON', 'MN', '525', '0', '0', '0', '875', '1100', 0),
(364, 'JACKSON', 'FLORENCE', 'MS', '0', '450', '0', '0', '875', '1100', 0),
(365, 'JACKSON', 'JACKSON', 'MS', '0', '450', '0', '0', '875', '1100', 0),
(366, 'Gulf Coast', 'Moss Point', 'MS', '0', '450', '0', '0', '875', '1100', 0),
(367, 'Grenada', 'Grenada', 'MS', '0', '450', '0', '0', '875', '1100', 0),
(368, 'COLUMBIA', 'COLUMBIA', 'MO', '550', '0', '0', '0', '875', '1100', 0),
(369, 'SIKESTON', 'SIKESTON', 'MO', '550', '0', '0', '0', '875', '1100', 0),
(370, 'SPRINGFIELD', 'ROGERSVILLE', 'MO', '550', '0', '0', '0', '875', '1100', 0),
(371, 'SAINT LOUIS', 'BRIDGETON', 'MO', '550', '0', '0', '0', '875', '1100', 0),
(372, 'SPRINGFIELD', 'SPRINGFIELD', 'MOY', '550', '0', '0', '0', '875', '1100', 0),
(373, 'KANSAS CITY', 'KANSAS CITY', 'MO', '550', '0', '0', '0', '875', '1100', 0),
(374, 'MISSOURI', 'SPRINGFIELD', 'MO', '550', '0', '0', '0', '875', '1100', 0),
(375, 'SAINT LOUIS', 'BRIDGETON', 'MO', '550', '0', '0', '0', '875', '1100', 0),
(376, 'KANSAS CITY', 'BELTON', 'MO', '550', '0', '0', '0', '875', '1100', 0),
(377, 'SAINT LOUIS', 'BARNHART', 'MO', '550', '0', '0', '0', '875', '1100', 0),
(378, 'BILLINGS', 'BILLINGS', 'MT', '1050', '0', '0', '0', '875', '1100', 0),
(379, 'HELENA', 'HELENA', 'MT', '1050', '0', '0', '0', '875', '1100', 0),
(380, 'BILLINGS', 'BILLINGS', 'MT', '1050', '0', '0', '0', '875', '1100', 0),
(381, 'MISSOULA', 'MISSOULA', 'MT', '1050', '0', '0', '0', '875', '1100', 0),
(382, 'LINCOLN', 'GREENWOOD', 'NE', '775', '0', '0', '0', '875', '1100', 0),
(383, 'OMANA', 'OMAHA', 'NE', '775', '0', '0', '0', '875', '1100', 0),
(384, 'OMAHA', 'OMAHA', 'NE', '775', '0', '0', '0', '875', '1100', 0),
(385, 'Fargo', 'Fargo', 'ND', '0', '0', '0', '1100', '1050', '1400', 0),
(386, 'LAS VEGAS', 'LAS VEGAS', 'NV', '0', '0', '0', '300', '1050', '1400', 0),
(387, 'RENO', 'RENO', 'NV', '0', '0', '0', '400', '1050', '1400', 0),
(388, 'LAS VEGAS', 'HENDERSON', 'NV', '0', '0', '0', '300', '1050', '1400', 0),
(389, 'RENO', 'MCCARRAN', 'NV', '0', '0', '0', '400', '1050', '1400', 0),
(390, 'LAS VEGAS', 'LAS VEGAS', 'NV', '0', '0', '0', '300', '1050', '1400', 0),
(391, 'NEVADA', 'LAS VEGAS', 'NV', '0', '0', '0', '300', '1050', '1400', 0),
(392, 'MANCHESTER', 'SALEM', 'NH', '400', '0', '0', '0', '875', '1100', 0),
(393, 'CANDIA', 'CANDIA', 'NH', '400', '0', '0', '0', '875', '1100', 0),
(394, 'GLASSBORO EAST', 'GLASSBORO', 'NJ', '200', '0', '0', '0', '875', '1100', 0),
(395, 'SOMERVILLE', 'HILLSBOROUGH', 'NJ', '150', '0', '0', '0', '875', '1100', 0),
(396, 'TRENTON', 'WINDSOR', 'NJ', '150', '0', '0', '0', '875', '1100', 0),
(397, 'CENTRAL NEW JERSEY', 'MORGANVILLE', 'NJ', '150', '0', '0', '0', '875', '1100', 0),
(398, 'NORTHERN NEW JERSEY', 'CARTERET', 'NJ', '125', '0', '0', '0', '875', '1100', 0),
(399, 'SOUTHERN NEW JERSEY', 'TURNERSVILLE', 'NJ', '200', '0', '0', '0', '875', '1100', 0),
(400, 'NY METRO SKYLINE', 'FAIRFIELD', 'NJ', '175', '0', '0', '0', '875', '1100', 0),
(401, 'NEW JERSEY', 'BORDENTOWN', 'NJ', '200', '0', '0', '0', '875', '1100', 0),
(402, 'NEW JERSEY', 'MANVILLE', 'NJ', '200', '0', '0', '0', '875', '1100', 0),
(403, 'Avenel New Jersey', 'Avenel', 'NJ', '125', '0', '0', '0', '875', '1100', 0),
(404, 'ALBUQUERQUE', 'ALBUQUERQUE', 'NM', '0', '0', '0', '525', '1050', '1400', 0),
(405, 'ALBUQUERQUE', 'ALBUQUERQUE', 'NM', '0', '0', '0', '525', '1050', '1400', 0),
(406, 'NEW MEXICO', 'ALBUQUERQUE', 'NM', '0', '0', '0', '525', '1050', '1400', 0),
(407, 'ALBANY', 'ALBANY', 'NY', '300', '0', '0', '0', '875', '1100', 0),
(408, 'LONG ISLAND', 'BROOKHAVEN', 'NY', '225', '0', '0', '0', '875', '1100', 0),
(409, 'NEWBURGH', 'MARLBORO', 'NY', '225', '0', '0', '0', '875', '1100', 0),
(410, 'ROCHESTER', 'LE ROY', 'NY', '350', '0', '0', '0', '875', '1100', 0),
(411, 'SYRACUSE', 'CENTRAL SQUARE', 'NY', '325', '0', '0', '0', '875', '1100', 0),
(412, 'ALBANY', 'SCHENECTADY', 'NY', '300', '0', '0', '0', '875', '1100', 0),
(413, 'BUFFALO', 'BUFFALO', 'NY', '400', '0', '0', '0', '875', '1100', 0),
(414, 'LONG ISLAND', 'MEDFORD', 'NY', '225', '0', '0', '0', '875', '1100', 0),
(415, 'NEWBURGH', 'ROCK TAVERN', 'NY', '225', '0', '0', '0', '875', '1100', 0),
(416, 'ROCHESTER', 'ROCHESTER', 'NY', '350', '0', '0', '0', '875', '1100', 0),
(417, 'SYRACUSE', 'CICERO', 'NY', '325', '0', '0', '0', '875', '1100', 0),
(418, 'ALBANY', 'CLIFTON PARK', 'NY', '350', '0', '0', '0', '875', '1100', 0),
(419, 'NEW YORK', 'NEWBURGH', 'NY', '250', '0', '0', '0', '875', '1100', 0),
(420, 'BUFFALO', 'AKRON', 'NY', '425', '0', '0', '0', '875', '1100', 0),
(421, 'SYRACUSE', 'CICERO', 'NY', '325', '0', '0', '0', '875', '1100', 0),
(422, 'LONG ISLAND', 'YAPHANK', 'NY', '300', '0', '0', '0', '875', '1100', 0),
(423, 'CHINA GROVE', 'CHINA GROVE', 'NC', '0', '300', '0', '0', '875', '1100', 0),
(424, 'RALEIGH', 'DUNN', 'NC', '0', '300', '0', '0', '875', '1100', 0),
(425, 'ASHEVILLE', 'FLETCHER', 'NC', '0', '300', '0', '0', '875', '1100', 0),
(426, 'CONCORD', 'CONCORD', 'NC', '0', '300', '0', '0', '875', '1100', 0),
(427, 'CHARLOTTE', 'CHARLOTTE', 'NC', '0', '300', '0', '0', '875', '1100', 0),
(428, 'GREENSBORO', 'GRAHAM', 'NC', '0', '325', '0', '0', '875', '1100', 0),
(429, 'RALEIGH', 'CLAYTON', 'NC', '0', '300', '0', '0', '875', '1100', 0),
(430, 'WILMINGTON', 'CASTLE HAYNE', 'NC', '0', '350', '0', '0', '875', '1100', 0),
(431, 'NORTH CAROLINA', 'KENLY', 'NC', '0', '400', '0', '0', '875', '1100', 0),
(432, 'STATESVILLE', 'STATESVILLE', 'NC', '0', '400', '0', '0', '875', '1100', 0),
(433, 'RALEIGH', 'CLAYTON', 'NC', '0', '300', '0', '0', '875', '1100', 0),
(434, 'CHARLOTTE', 'CHARLOTTE', 'NC', '0', '300', '0', '0', '875', '1100', 0),
(435, 'MEBANE', 'MEBANE', 'NC', '0', '350', '0', '0', '875', '1100', 0),
(436, 'CLEVELAND EAST', 'NORTHFIELD', 'OH', '450', '0', '0', '0', '875', '1100', 0),
(437, 'CLEVELAND WEST', 'COLUMBIA STATION', 'OH', '450', '0', '0', '0', '875', '1100', 0),
(438, 'COLUMBUS', 'COLUMBUS', 'OH', '450', '0', '0', '0', '875', '1100', 0),
(439, 'AKRON - CANTON', 'NEW PHILADELPHIA', 'OH', '450', '0', '0', '0', '875', '1100', 0),
(440, 'COLUMBUS', 'GROVE CITY', 'OH', '450', '0', '0', '0', '875', '1100', 0),
(441, 'CINCINNATI', 'WEST CHESTER', 'OH', '450', '0', '0', '0', '875', '1100', 0),
(442, 'CLEVELAND', 'LORAIN', 'OH', '450', '0', '0', '0', '875', '1100', 0),
(443, 'CINCINNATI SOUTH', 'AMELIA', 'OH', '450', '0', '0', '0', '875', '1100', 0),
(444, 'DAYTON', 'DAYTON', 'OH', '450', '0', '0', '0', '875', '1100', 0),
(445, 'LIMA', 'LIMA', 'OH', '450', '0', '0', '0', '875', '1100', 0),
(446, 'CINCINNATI', 'HAMILTON', 'OH', '450', '0', '0', '0', '875', '1100', 0),
(447, 'OHIO', 'GROVE CITY', 'OH', '450', '0', '0', '0', '875', '1100', 0),
(448, 'DAYTON', 'DAYTON', 'OH', '450', '0', '0', '0', '875', '1100', 0),
(449, 'CLEVELAND', 'NORTHFIELD', 'OH', '450', '0', '0', '0', '875', '1100', 0),
(450, 'CINCINNATI', 'FRANKLIN', 'OH', '450', '0', '0', '0', '875', '1100', 0),
(451, 'OKLAHOMA CITY', 'OKLAHOMA CITY', 'OK', '0', '0', '400', '0', '975', '1200', 0),
(452, 'TULSA', 'TULSA', 'OK', '0', '0', '400', '0', '975', '1200', 0),
(453, 'OKLAHOMA CITY', 'OKLAHOMA CITY', 'OK', '0', '0', '400', '0', '975', '1200', 0),
(454, 'TULSA', 'TULSA', 'OK', '0', '0', '400', '0', '975', '1200', 0),
(455, 'EUGENE', 'EUGENE', 'OR', '0', '0', '0', '525', '1050', '1400', 0),
(456, 'PORTLAND', 'PORTLAND', 'OR', '0', '0', '0', '525', '1050', '1400', 0),
(457, 'WOODBURN', 'WOODBURN', 'OR', '0', '0', '0', '525', '1050', '1400', 0),
(458, 'EUGENE', 'EUGENE', 'OR', '0', '0', '0', '525', '1050', '1400', 0),
(459, 'PORTLAND', 'PORTLAND', 'OR', '0', '0', '0', '525', '1050', '1400', 0),
(460, 'PORTLAND', 'PORTLAND', 'OR', '0', '0', '0', '525', '1050', '1400', 0),
(461, 'ALTOONA', 'EBENSBURG', 'PA', '375', '0', '0', '0', '875', '1100', 0),
(462, 'CHAMBERSBURG', 'CHAMBERSBURG', 'PA', '375', '0', '0', '0', '875', '1100', 0),
(463, 'HARRISBURG', 'GRANTVILLE', 'PA', '300', '0', '0', '0', '875', '1100', 0),
(464, 'PHILADELPHIA', 'PENNSBURG', 'PA', '200', '0', '0', '0', '875', '1100', 0),
(465, 'Bridgeport', 'Bridgeport', 'PA', '200', '0', '0', '0', '875', '1100', 0),
(466, 'PITTSBURGH NORTH', 'ELLWOOD CITY', 'PA', '400', '0', '0', '0', '875', '1100', 0),
(467, 'PITTSBURGH SOUTH', 'WEST MIFFLIN', 'PA', '400', '0', '0', '0', '875', '1100', 0),
(468, 'YORK HAVEN', 'YORK HAVEN', 'PA', '300', '0', '0', '0', '875', '1100', 0),
(469, 'ALTOONA', 'EAST FREEDOM', 'PA', '375', '0', '0', '0', '875', '1100', 0),
(470, 'ERIE', 'GARLAND', 'PA', '475', '0', '0', '0', '875', '1100', 0),
(471, 'HARRISBURG', 'MANCHESTER', 'PA', '325', '0', '0', '0', '875', '1100', 0),
(472, 'PHILADELPHIA', 'CONSHOHOCKEN', 'PA', '200', '0', '0', '0', '875', '1100', 0),
(473, 'PITTSBURGH SOUTH', 'MOUNTAIN MORRIS', 'PA', '400', '0', '0', '0', '875', '1100', 0),
(474, 'Pittsburgh-North', 'GIBSONIA', 'PA', '400', '0', '0', '0', '875', '1100', 0),
(475, 'SCRANTON', 'PITTSTON', 'PA', '275', '0', '0', '0', '875', '1100', 0),
(476, 'CENTRAL PENN', 'GRANTVILLE', 'PA', '275', '0', '0', '0', '875', '1100', 0),
(477, 'PENNSYLVANIA', 'MANHEIM', 'PA', '275', '0', '0', '0', '875', '1100', 0),
(478, 'PHILADELPHIA', 'HATFIELD', 'PA', '275', '0', '0', '0', '875', '1100', 0),
(479, 'PITTSBURGH', 'CRANBERRY', 'PA', '400', '0', '0', '0', '875', '1100', 0),
(480, 'PA', 'YORK', 'PA', '350', '0', '0', '0', '875', '1100', 0),
(481, 'York Springs', 'York Springs', 'PA', '275', '0', '0', '0', '875', '1100', 0),
(482, 'PITTSBURGH', 'MERCER', 'PA', '300', '0', '0', '0', '875', '1100', 0),
(483, 'PHILADELPHIA EAST', 'CHALFONT', 'PA', '250', '0', '0', '0', '875', '1100', 0),
(484, 'COLUMBIA', 'GASTON', 'SC', '0', '275', '0', '0', '875', '1100', 0),
(485, 'GREER', 'GREER', 'SC', '0', '275', '0', '0', '875', '1100', 0),
(486, 'CHARLESTON', 'RAVENEL', 'SC', '0', '275', '0', '0', '875', '1100', 0),
(487, 'GREENVILLE', 'GREENVILLE', 'SC', '0', '275', '0', '0', '875', '1100', 0),
(488, 'DARLINGTON', 'DARLINGTON', 'SC', '0', '275', '0', '0', '875', '1100', 0),
(489, 'SIOUX FALLS', 'TEA', 'SD', '900', '0', '0', '0', '875', '1100', 0),
(490, 'SIOUX FALLS', 'TEA', 'SD', '900', '0', '0', '0', '875', '1100', 0),
(491, 'Sioux Falls', 'Sioux Falls', 'SD', '900', '0', '0', '0', '875', '1100', 0),
(492, 'KNOXVILLE', 'MADISONVILLE', 'TN', '0', '400', '0', '0', '875', '1100', 0),
(493, 'MEMPHIS', 'MEMPHIS', 'TN', '0', '400', '0', '0', '875', '1100', 0),
(494, 'NASHVILLE', 'LEBANON', 'TN', '0', '400', '0', '0', '875', '1100', 0),
(495, 'CHATTANOOGA', 'CHATTANOOGA', 'TN', '0', '400', '0', '0', '875', '1100', 0),
(496, 'KNOXVILLE', 'KNOXVILLE', 'TN', '0', '400', '0', '0', '875', '1100', 0),
(497, 'MEMPHIS', 'MEMPHIS', 'TN', '0', '425', '0', '0', '875', '1100', 0),
(498, 'NASHVILLE', 'NASHVILLE', 'TN', '0', '400', '0', '0', '875', '1100', 0),
(499, 'NASHVILLE', 'MOUNTAINE JULIET', 'TN', '0', '400', '0', '0', '875', '1100', 0),
(500, 'TENNESSEE', 'NASHVILLE', 'TN', '0', '400', '0', '0', '875', '1100', 0),
(501, 'KNOXVILLE', 'LENOIR CITY', 'TN', '0', '400', '0', '0', '875', '1100', 0),
(502, 'MEMPHIS', 'MEMPHIS', 'TN', '0', '400', '0', '0', '875', '1100', 0),
(503, 'NASHVILLE', 'OLD HICKORY', 'TN', '0', '400', '0', '0', '875', '1100', 0),
(504, 'ABILENE', 'ABILENE', 'TX', '0', '0', '375', '0', '975', '1200', 0),
(505, 'AMARILLO', 'AMARILLO', 'TX', '0', '0', '450', '0', '975', '1200', 0),
(506, 'AUSTIN', 'NEW BRAUNFELS', 'TX', '0', '0', '250', '0', '975', '1200', 0),
(507, 'CORPUS CHRISTI', 'CORPUS CHRISTI', 'TX', '0', '0', '300', '0', '975', '1200', 0),
(508, 'DALLAS', 'GRAND PRAIRIE', 'TX', '0', '0', '275', '0', '975', '1200', 0),
(509, 'EL PASO', 'EL PASO', 'TX', '0', '0', '450', '0', '975', '1200', 0),
(510, 'FORT WORTH', 'HASLET', 'TX', '0', '0', '275', '0', '975', '1200', 0),
(511, 'HOUSTON', 'HOUSTON', 'TX', '0', '0', '125', '0', '975', '1200', 0),
(512, 'KEMAH', 'KEMAH', 'TX', '0', '0', '275', '0', '975', '1200', 0),
(513, 'LONGVIEW', 'LONGVIEW', 'TX', '0', '0', '275', '0', '975', '1200', 0),
(514, 'LUFKIN', 'LUFKIN', 'TX', '0', '0', '275', '0', '975', '1200', 0),
(515, 'MCALLEN', 'MERCEDES', 'TX', '0', '0', '325', '0', '975', '1200', 0),
(516, 'AUSTIN', 'AUSTIN', 'TX', '0', '0', '250', '0', '975', '1200', 0),
(517, 'CORPUS CHRISTI', 'CORPUS CHRISTI', 'TX', '0', '0', '325', '0', '975', '1200', 0),
(518, 'FORT WORTH', 'GRAND PRAIRIE', 'TX', '0', '0', '275', '0', '975', '1200', 0),
(519, 'DALLAS SOUTH', 'WILMER', 'TX', '0', '0', '275', '0', '975', '1200', 0),
(520, 'EL PASO', 'EL PASO', 'TX', '0', '0', '400', '0', '975', '1200', 0),
(521, 'HOUSTON NORTH', 'HOUSTON', 'TX', '0', '0', '125', '0', '975', '1200', 0),
(522, 'HOUSTON', 'HOUSTON', 'TX', '0', '0', '125', '0', '975', '1200', 0),
(523, 'LONGVIEW', 'LONGVIEW', 'TX', '0', '0', '275', '0', '975', '1200', 0),
(524, 'PERMIAN BASIN', 'ODESSA', 'TX', '0', '0', '400', '0', '975', '1200', 0),
(525, 'SAN ANTONIO SOUTH', 'SAN ANTONIO', 'TX', '0', '0', '275', '0', '975', '1200', 0),
(526, 'SAN ANTONIO', 'SAN ANTONIO', 'TX', '0', '0', '275', '0', '975', '1200', 0),
(527, 'DALLAS', 'DALLAS', 'TX', '0', '0', '275', '0', '975', '1200', 0),
(528, 'DALLAS - FORT WORTH', 'EULESS', 'TX', '0', '0', '375', '0', '975', '1200', 0),
(529, 'EL PASO', 'EL PASO', 'TX', '0', '0', '500', '0', '975', '1200', 0),
(530, 'HOUSTON', 'HOUSTON', 'TX', '0', '0', '125', '0', '975', '1200', 0),
(531, 'METRO DALLAS', 'GRAND PRAIRIE', 'TX', '0', '0', '275', '0', '975', '1200', 0),
(532, 'SAN ANTONIO', 'SAN ANTONIO', 'TX', '0', '0', '275', '0', '975', '1200', 0),
(533, 'TEXAS HOBBY', 'HOUSTON', 'TX', '0', '0', '125', '0', '975', '1200', 0),
(534, 'HOUSTON', 'HOUSTON', 'TX', '0', '0', '125', '0', '975', '1200', 0),
(535, 'SAN ANTONIO', 'SAN ANTONIO', 'TX', '0', '0', '325', '0', '975', '1200', 0),
(536, 'DALLAS', 'HUTCHINS', 'TX', '0', '0', '375', '0', '975', '1200', 0),
(537, 'AUSTIN', 'AUSTIN', 'TX', '0', '0', '250', '0', '975', '1200', 0),
(538, 'SAN ANTONIO', 'SAN ANTONIO', 'TX', '0', '0', '325', '0', '975', '1200', 0),
(539, 'ANDREWS', 'ANDREWS', 'TX', '0', '0', '450', '0', '975', '1200', 0),
(540, 'LUBBOCK', 'LUBBOCK', 'TX', '0', '0', '450', '0', '975', '1200', 0),
(541, 'Fort Worth North', 'Justin', 'TX', '0', '0', '325', '0', '975', '1200', 0),
(542, 'Austin', 'Dale', 'TX', '0', '0', '250', '0', '975', '1200', 0),
(543, 'SALT LAKE CITY', 'NORTH SALT LAKE', 'UT', '1050', '1050', '1050', '450', '1050', '1400', 0),
(544, 'SALT LAKE CITY', 'OGDEN', 'UT', '1050', '1050', '1050', '450', '1050', '1400', 0),
(545, 'UTAH', 'WOODS CROSS', 'UT', '1050', '1050', '1050', '450', '1050', '1400', 0),
(546, 'Culpeper', 'Culpeper', 'VA', '375', '375', '375', '375', '875', '1100', 0),
(547, 'Northern Virginia', 'Fredericksburg', 'VA', '350', '350', '350', '350', '875', '1100', 0),
(548, 'Pulaski', 'Pulaski', 'VA', '375', '500', '500', '500', '875', '1100', 0),
(549, 'Richmond', 'Ashland', 'VA', '375', '375', '375', '375', '875', '1100', 0),
(550, 'Suffolk', 'Suffolk', 'VA', '375', '500', '500', '500', '875', '1100', 0),
(551, 'Tidewater', 'Yorktown', 'VA', '375', '500', '500', '500', '875', '1100', 0),
(552, 'DANVILLE', 'CHATHAM', 'VA', '375', '375', '375', '375', '875', '1100', 0),
(553, 'HAMPTON', 'HAMPTON', 'VA', '375', '375', '375', '375', '875', '1100', 0),
(554, 'RICHMOND', 'SANDSTON', 'VA', '375', '375', '375', '375', '875', '1100', 0),
(555, 'BURLINGTON', 'ESSEX', 'VT', '500', '500', '500', '500', '875', '1100', 0),
(556, 'GRAHAM', 'GRAHAM', 'WA', '0', '0', '0', '800', '1050', '1400', 0),
(557, 'NORTH SEATTLE', 'ARLINGTON', 'WA', '0', '0', '0', '675', '1050', '1400', 0),
(558, 'PASCO', 'PASCO', 'WA', '0', '0', '0', '800', '1050', '1400', 0),
(559, 'SPOKANE', 'AIRWAY HEIGHTS', 'WA', '0', '0', '0', '800', '1050', '1400', 0),
(560, 'SPOKANE', 'SPOKANE', 'WA', '0', '0', '0', '800', '1050', '1400', 0),
(561, 'SEATTLE', 'TUKWILA', 'WA', '0', '0', '0', '675', '1050', '1400', 0),
(562, 'SEATTLE', 'KENT', 'WA', '0', '0', '0', '675', '1050', '1400', 0),
(563, 'SEATTLE', 'AUBURN', 'WA', '0', '0', '0', '675', '1050', '1400', 0),
(564, 'CHARLESTON', 'HURRICANE', 'WV', '550', '0', '0', '0', '875', '1100', 0),
(565, 'BUCKHANNON', 'BUCKHANNON', 'WV', '550', '0', '0', '0', '875', '1100', 0),
(566, 'SHADY SPRING', 'Shady Spring', 'WV', '550', '0', '0', '0', '875', '1100', 0),
(567, 'MADISON', 'MADISON', 'WI', '525', '0', '0', '0', '875', '1100', 0),
(568, 'MILWAUKEE', 'CUDAHY', 'WI', '525', '0', '0', '0', '875', '1100', 0),
(569, 'APPLETON', 'APPLETON', 'WI', '525', '0', '0', '0', '875', '1100', 0),
(570, 'MILWAUKEE', 'SUSSEX', 'WI', '525', '0', '0', '0', '875', '1100', 0),
(571, 'MILWAUKEE', 'CALEDONIA', 'WI', '525', '0', '0', '0', '875', '1100', 0),
(572, 'WISCONSIN', 'PORTAGE', 'WI', '525', '525', '525', '525', '875', '1100', 0);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(255) NOT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `date` datetime NOT NULL,
  `lastUpdate` datetime NOT NULL,
  `image` longblob,
  `role` int(11) NOT NULL,
  `active` int(11) NOT NULL,
  `country` varchar(11) DEFAULT NULL,
  `address1` varchar(255) DEFAULT NULL,
  `address2` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  `phoneCode` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `mobilePhone` varchar(255) DEFAULT NULL,
  `phone2` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `deleted` int(1) DEFAULT '0',
  `mainUserId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `userName`, `company`, `firstName`, `lastName`, `email`, `password`, `date`, `lastUpdate`, `image`, `role`, `active`, `country`, `address1`, `address2`, `city`, `state`, `zip`, `phoneCode`, `phone`, `mobilePhone`, `phone2`, `fax`, `deleted`, `mainUserId`) VALUES
(48, 'AeneasExporting@yahoo.com', 'Aeneas Exporting LLC', 'Ziad', '', 'AeneasExporting@yahoo.com', 'a83a8948fbc4214b67dba6096d8f9c3c', '2019-08-21 00:00:00', '2019-11-02 19:02:24', 0x89504e470d0a1a0a0000000d49484452000003200000018d0806000000e96d157100000006624b47440004000b0016f442470f000000097048597300002e2300002e230178a53f760000000774494d4507e30815080c2decca6d21000020004944415478daecdd79b8675959d8fbefbbd6da7bffa6335555d7d40374377437b320480431022a484c082657a2f12a1125518989f749629e0c2a6a7235371ae3838f0689783551426e4413c3a002a2a8111164ea11aababaabbbba865367fc4d7bafb5defbc7dae75479f3c725032d98f7f33cd0dd75aacff9d56fd8bddefd4e608c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c618638c31c61863fe147ae76fbc4fec5930c618f3bf12fb0f9f31c63c4ebeef077ecc2f16dbab478f1debaa6ae8e6ed22fa6ef1fcdcb6a7f36cbffdf0473f92ef3df3a92fbb7275e727bbd4ddb7b97935d9b3668c31c60210638c31875efdf5dfe09a6650679f7fb0dd9f7e70efead55f7dea339ff5d7f677b76f3ff7c0a77e7377779bae8dc4d4321eafaddcfcc4db9ea7225fd2b56ddd756db573f9e22787a13ebdb6b6f2c5172f5ee0f295cb5cda9db248f917aa66f09357af5cfe803dcbc618632c0031c61803c0b77ec7dfbcf9e2f9871fdad9ba8c769d56a8d6a17229259d4df7592e17e418c931812a75e540552475684e04843629fb5d6252096b8de781ad2917a789c168c06838fe4f38f96b2b93f5f6befb3eb967cfb831c698cf77c19e02638cf9eff7890fffd189ed2b8fe5bcb7e55603e282975633925586281314750951c58b32c9503b65d440859255b8b2542ee5c4465d7172e298cf85bc5424b5b473fdf329d41f5ef8fd87ef78f29ddf7dff03f7fd8e3debc618632c0031c698ff4555c3d14f2f66737724ce79f2a0e2689dd19c48aa200a0e220e152120ac5442e594d5cad13868153692f2ec7ac0f19167a5aab8a9713cb492d86b854f4f3bcecf67b7ec2d17b7c4f1e403b7df76fb070683c1eb6f3c75fa21e7abed77fdda3bd45e05638c3116801863cc67e85ffdeb5ff0cbc5826f7ded5fd39f7ce38f7d19aa8badcdadfaddbff6cefdf3171ebd6b776fefaa3af9b5e9ee6efc5c7cfcd3fdddb704c9fff2d424f08c63034e340239a392f15e41042120eaf00e1aefa804465e081ea26692874180accaa0aa59ab2a9e3886cb0b616d7b4eb5953937ed68f776d95fccbf244e563ff4287c28c6f4e6affd96effc99b7bdf9c72d0831c618f379c37a408c31ff435efce2171f49293722e8dede3e476fb86178c71d4fa99ffab4676d5d387f6ee5a17367c79ffcf8472f6f6e5d15455621cfc7e3c9da6838f437df72dbd7d4557de7623ecb39a50755e3172de6f37b63dbddbcb9b9f9d5972e5f64ba98a3ca43e3c9ca374d262bf79c39fbe98b9f4b7ffee73dfbb9afc9bb97dff267d75a5e766ac4e946685cc24906975014a7019741c4818213051c4e20aa32576881ab09b20b6c4e23b34e19d603b6a72df75f9d717edab1159587f75b2e2d23848a6a30603459fdc470bcfa2ff6a657dffad09973337b471a638cb100c418f339e5adffe13ffa95f515fd732f7d71befed77ff7a3f756bff4f33f2b7ff0a1dfcf1ffbf087f5252f7bf9f8d8c6d1afaa821beeececccdff64b6ffd9553c74f0f524c7acb2db7bc74319f4d34ebb3d4f19539eb045467b3791e0c87eb379e3c3d9e8c060f0a9cdedddd5b7df4fc436777f6f6a44de9460f9b834173725437347545cab0e83a668b059213c109316552b7a006e631b2b38cd48321c3e1e881c170f8db22fce8a7cf9cf9e4e74400f29c2f7c4d33dd7ccb5f3c9e79c5a9214783e28924974829935511956b175c05440e2fc149a1cd8e248e2d15f6f13cbcbb2065383a1a314048cbc434c2b9fd963fb8b2cf83bb0bda94d96a13fbaec637c359331cdcbdb6b1fe53ab478ffdfcefbef73dadbdd38d31c65800628cf9acfb077ffffbe49ffed0f7e9f7fff0ff29bfff5bbfc9539ffb67aaf164edce1b4f9cfcf47bdff34e37ac6a9a66f497f6f776ba7367ce3d02a229a6f4a43bef7a7908eeb9e71f7ab039fff04357a67b7b5a0f072b274e9cfcf2baaaaad974cad5ab57d8df9fa2aa344d830362ec68bb16b292c9745d0485f5f190d5a6c18ba2392329b2582ed95b768ceac038788e0e2bc65ed85976ecb41ddb8b48e3852010158277ac0e1ae629b3395ba23816ea88ce119a01a10affb1ae9bffebecd9b31fb8eb8e3be4defbefff132943fa82a73ffd352bcbedb77cc38d9e979d1cb0e222898e3667508753873841040425f78f520fafc042c2b11f950b6d26f98afd6524a8508786da056a0455d8ed22e7f75b2eee2fb9385df0c0f68c4716ca7e863d7584d188f5a3c7baf58d23af5f5b5d7bdb7231db79ff6fbeeff3b23ceb4d6f7f9fbcee552fb6d232638cb100c418f3d9f61fdff981c15ff8aa2f59fcf23b7ecddfffc05937dfd9e17bbfe7ef75075fffe17ffec62acdbadbfec1f77cd77d07bff6a33ffc5383fbefffb80e5756feead6e6a3ef9e6cacfee5fbeefef82c461d1f3d7ef2b9971e3dff892ee7af9ecf6621b6ddd114d3bae28e013871688e745d478a1d92129a2268465519044f1021e7c4b24de49ca99dc3a1a866324a25d0e6c4ac8b3884e3a38663839a5a0487e251e629b3d545360681b5da73ebca901bc7817917d9ef1257979191770427b402ea1c5555b1bd48ec2d3b52840776e63cbcbfa045a0aa08f5605655d5bb87c3e1ef0d06cdcf7ef2ee7b2e3fdeafd7d3eebcf3356bddde5b5e73b3e76527874c5c226acb5c9540a0128fb8fe6aab990c687fac1601c581085bcbc4c38b0c55458c890a8fb80a2f351e105540c9288b2e71797fc1c33b7376e7f0c834f2e1dd2997ba4cae6bead164b6b6b1f17008fe478ede70e2b7deffdedfb8eff57ffbbbe48d3ff62f3e270ff46f7fc7efb857bde285f9e77ee9bf54d5785c7fddcb9e31fdb977ffc10ba6bb5b0f7edbfff6958fda55c118632c0031c65ce74947d6c40b0842129188905539b7b9956f3d7674dd7b3ff9d4c54be75ffdf257c88db7dd2e1bc78e1c99ee2f567fe8477ff8cc4ffcd0bf587fecea955bce9c3bebefbdf79e2de77cf3452ff8d2af7fefafbfe3df3ce359cff93e5f85d16c7fdf5fb972f92dabab6bcfaf07c358b9f08cd42edacdcd2b9ff8d4a7ef7dffadb73ef93947378e7eed95cdcb5796edfceadacae4eb62bb08d3d99476b924a70c29a2a965b9e88839b3ec226dca381182f3388194320e38391eb05257a0e5b8bbde54acd615008bb6236765b5aea88044269181ccf67cc9f672c90da39a5b26038e5601af00195449287384495331f270725471e33010242364baa454ce21ce91bcd039c7340be77696eccf5bba080feeb65c98776c758907f7965c6d132e049ae188d1783407f98eaaae3ebc7164fd9e0f7df00f1f9732a4bb9ef4a4d7acc5fdb7bce626c7cb4f8d58ad3291c82229c15554b81280a0281994c32c48498b0820ec749947174ae71d6d9ba99cc3b91a911aef5c19e3ab659c2f391263222e3bd20cceef757c647fc99945c79979cbe52e43a8184c5658d938f2a043bef5d4c9d3f363371cfdf8bffb77bfb8fb787d36fed93f7ff3fafefe76bcf7a3bf32fd9217bd9a7636e3effca3bfa7ffe1dfffa6dbbc7ceef6e9f44a476a19ae1eddd8bb78cfc78e3debd52f10d1bffae8fd7ff87f9fb9fb43bb9bd3d9579f3b7be642d50c9eba73f5eadbeebcebe9677ee597dfb66d571d638cb100c4983ff59e76e3a9155fb93c9fb74e52aa1c795c09eb6de606553d2ec20d829c4c22e388dc9c552739e9df724eb2736ed2c5f8e8939f74c75fbefdaea7be626f3afdd4defe2e5b57b7d8585b7f91afab27edeeec84cb972f5d9ecd661263bb581d8dd74693f10d82b2582e5976911002950fe494c839b25c2c68170b44a00a0127424c094d89a1139c6686de31f0c2913ab056396629d20a6c2f3be69de2c533f015de3bba947002a74643c6c1a1aaa0ca9161c5d14143e385944bd0b2de54d4fd3f779ad86e979cd9de23e58e2f3a3ee2d6d51123e770592165904c70427601c5a1393170c2d083239334e3707884e404ad1c9d0857bbc47d57e66ccd5a56ab9ad510482a7d2fc49433d396adb6636b99c83e30180c680683ced7d53bb2f2032b93c903f7de7dcf67f5c07de7edb7bf663deebfe51b6f767cd5a9216b01924496199c54d4e2ca38de3e03a2f41910b97619568469522e2d95a90ad3365189a30a03c4d578e711cd488ed0b568ea7029e172c645880976baccd979e6233b0bce2f22db5de491a53297c0703c61757de3dc0d274efed6136fbbfd6ffefccfbe79e7b3fd99f99a577d73387a6cf50d5bdb8f9d1c0d983ef58ea7ff513b9fe9c38f9e7dcfcd4fb8e3a5015ed4ce775fe81d93e0d2a520ddf92c7e23667fc374de3e71ebead5fa9efbefdb7ee0dc63ebfbd3196beb473979eac69f5a595f7fc37bdef5ab8fd955c918633e7fd9185ef3a7c6cfbcf51d321c8e24844a738ceed5affcb3e9fffb7b9effcc678a8870eb5d4f97c71e393f7cdf07de3f7dc6139f708bf33e77314e62d75d16b4f14e9e1d7c754bcae982e6fc85005d979f0b3c05ef9f40cab4b99c2145042dc7f54ee02750be26a58cc23d9a95944baff7d9f30ff3d8d65572cacc1773628c3c2c0ea7998022596f76393109c2099d316e1768ce4cdb96fd4547e51db538724e54a26856b4566ae7188584282c25d13a988440ed84d5da3170c2b126706a54d37a47d70857e74b164ba8fd8071356018025e14d1ccd0799052f22364c695671c4a962492894ea8832f3d209a9845652b2af39c1907e1d858d81843232049d00c6839666b86ae8bb439e39c43b2d065659695c6c1d07b4a2e49709471b6f4ff34ac1cc7878e81c231df70baae3837eff8d8ce8cbb77162ca242eed8db5d564b71afaceae69592d9bfe38ebbfeeec9e327de5b0f9a877ee3377e6df13ffd2e8eb8f23e009c8038c17190dc50721fc8b9208003cdd77ad07b8ae01d0c2a61d66562ca38efa8b42fd312454ae852c6f6c644c8112fb0ac40bdb2e2e12995e7c6e1842bcbc87dfb0b3ebcb3e4fc22b2b3bbc585e9de13f6a67bdf70e1c2233f0e7ce8b3fd79bcf0d899db1e7c70f60f168b1d4e1f5fe368d37e109195c5fef6cf7ceaee0b4c063512973415acae0c4e8f579b2fa824972cdba225a639ab7e6f3dce7759cc16b4cb25b16bffc6c9eed4177ed52bfefc5b26abeb3ff7efdffaf353bbf219638c0520c6fc89595b3ff2f476b978e66236f522f2ca5f7ed7effd9dbff8f22f3e0bf0d61ffa41f713bff8b6d5596c9f92234ffef0efbe7f4b95e73ce9e4c9ed36b6b7d06a1bb37e49cee988646d9277b7773121c255effc5acaf91f66f4f90aabdeb93f50addea5a97b6ee5e4e3c3e0ef3f3aa8b65f78d3c6915f3f7be9c967a71d39973bddd79f33f3fe0edd74bf1c3e53c669a6f18eb1738c8367145c396a07cfad2b356b8340d4c4fe02e6358cfb0024e6c0a4162a0187b2161ceb8da7061629b1c80e5f058273d4be94eed45e38326a705560176518a06d84811f32f60d83e01978c1a3a4a4b429e39dc3a3040f9eb2a3c2e1700a44253b4756474c30ef32cb04c3508207c942ee4fd98a27f7cfc43c2a7b6da6cb997509101c11611a15ad3cb5f7200e0412a0ce330c813c14468d23bacc2242e51c370d0237f481d553d73ab6dbc4638bc4bd3b531e992d59762ded7c3ee9daf627738e17c7e3955f79e94bbee217dff3de5fffcdffa90188175c022f82730ee720abc34946556893e2046a04e9c7efaa1e0c20bbf60e09e2a85d09d2522e4b0c851208aaf6e37c45a9bce083e0930394996666aaac0013a7dc34104ed481f5c1909551e09e9d9673bb2d9f9a2eb878e1b156824f8fc7e7f1ee4f7ea4ca398226067284faf6c1177529b29c5e06322c3c1a1322c26cbf62b63f20784831d1b689c67beebc69c4d5ed31f79eeb6853c4c73de29e7bde23f3bde7109aaff8e217bee8adbff73bbffd36bbfa19638c0520c6fc37f9919ff95517bb2571b64f4e1d5d3723ce670c0647f5f63b37dc273efab127adaf1f7fe8f77feb7de9b627ddb55ed5a3e33967a96a7fe591f367d7362f5d70d3fd7df95baff9ead9b39fffa24b274edff4ba6e319fef5cdd7cfd739ffe8c0fce66d3fcfd3ff1532ff121fc85b6eb1eecba6e23e5fc14edcb89d0d2b3d1c584e69c01f5d945efd816715bb8fcf1e0dc8b3606e1c74e041e7ee1f1c983f32e9d5c6d82db5f2cbf70ada95fe3637bfcd2de0e4f39327e70bb56daae6550558caa807491496c3926d088c33b4fd4d237518b63e01d2347e9a9d0d203b03e19b13a6ef05e59b64be262c148cb215570ac34e5b01a44197a61d4975cb5a96440b2772c93924518788ff3ae3c96106853665835540895aba8a434949736855cc6deb68995ba66547954843e8981a812520615f082a8103ac17782cf42238e0935a3ec20bb1278a882944de0d1c320789c2a2104f025a3a31e543c89be1f45950e8849f15e18e0c1090b556a07557054ce314018558e538d671695c796991b8681fb77e63c345db0dd46967bdbccf7764fd4e3f1ebf6f7f65ef9ec673debdf8f06835fbcfdd65b1f585d59bdfac69f7ed3ffd081dcf5b184778aef5b3a9c00b9bcaf520675c2e1205ed1f2fc51b2677d62a394d249c918a504eafa27bdefa111c938519c03171ca29994954a4b564835b1d48c38f0b5e3e430305c099c1c7aee75b0db26765324c7c7a70f7db95c0099ca3b06151c5df1a838521e5179684245db95606d301cb2b23aa2ae02a4484e2dc7572ad6c71583dab11212d379c7faea9844e2be471e739d0c5ee55d7ed5f39ff7ec17578e1f19afad9e7bf7afbdbfbbfe31fceccffe07e787228be51eb14bf9db5efbcdfacddff6b7ddcffce48f65bbf21a638c0520e67f013ffd636f3c5a7bc923475e1d045ef6dabfbef3dddff3432777af3cf25710b7d72da6dd72b6bb9edaf928774bbfbd3c7b66eb92bfedd2e5cddb3e78e1034feddad66d5dbd7ab5ae9ab30a8aa62fee627bba5bce653e9fb3b2b2c6039ffc987be8d3f71f730879b980b6c5c58efdf9fce0047d3aa64c2a5531d4952cf17e57d05dc9f9bec6c9272795bfffc8b0da7ceec9f555df2e9e38aeab27776dfbe44ef5af4ebcac4f72bb71aa71d5c8478e1f6d98d415b5543cb0bbe44a33ee1e69475cb87485238386db56c79cc89123f37dd6622648208480e644ca8920503b2150b219d92973e768070d2bab23260de458a1cb40e8122e0ac17b9c2ba7534111012f999ccb21b5229335b1bb8c64718c078e4a94103339475282d42a39bb52e624fddd76d172b73d97836db9577fddee0a05af82a84755912c90949c283f3b2b8d3a26e218a8d0c5d26c2de2cae23da7d4281acaa13d38085ec079c622d422a54c4b4abbb6962fd1f8f238c2c1ff5c29572225342b0ea1f14a5339364635b7ac573c657dc827b6e73cb8bfe4e2ace3b1d99ceded2d16d3d989f9fee4f5e3f1f87f5f2c97bf736463e3a7bfe59b5efbb1e77cc1732e7efb777dc77f57398fa2fd7354824a2841ad1e7c45a4042422e54954419c5cff0dd0fed79c084995d8bf0625f0509ccb382dfd3d9aca7b37297451a9541888439d90507210d497d7744584dbc79e66b5e6a33b2d0f4525394f9a7ff69320379d3842259961a33cf38e937ce1336e65b23266d6cda825115c4542f0554d339a305a19d1549eb85cb0b7bd8de425dab6ecececc06c93f922321eaf30ed8494b3ecb74253cf50a9fec63285afdddbda79d74bbef405dff9dedffaddcd9ffe976f5c5b593f199a23a79e9843fba476735a3d7afefef37ffe2fbeca5db978e1f92ffbaa57bee9ddeffc954dbb2a1b638c0520e64f916fffeeef93b4ccb72df6b79f2371b97ac3c6da99b66b9fbe7965f30471593501ff77bffd9b66b38bf7fd95e92539badcbbf8db71319bfbc1eacb51b79e734472c7e6f91dce9edfe4c2a52d6257260379e7ca1421cd04723f2236434e484eccfb92a37115383eac0903e5d3cbd2cf10043aaf2c62669694910b3ff1f2536bbfdb381d8cebeaced4b55f5087f07592d24d7139e558e3590d89a393861b0615e3da33a92ac439c47b92f3e594dcb58c1791edac696b678f33e71ee5b1e0d838798c671e9970ca7b6af1381f50e759a67297bb12a5728217700793924499c7164d8e8043a4c3f988761111a1d1be2c876b439404f05ea882c7699968954239e48e50724ac494c10772e7689789a4505719f17d2f0b09afcac809b9720c05822a2e953e0605120e3dbccb9f5968c77e8a2c50a296fe844c22e1590ab4ea08ae6cfe8e9ad96d239d6ad9f3e1140d4a25425d4989832497322529af6b904470b13cf6e4699ca37690487492c1f5cf85402742e53347c473a40edc3a59e3c242b97b7bc11f5edee6a1bd39c10b212eb87a797f6d7b7beb15dbdb5b5fdec5fcf0defede7ff9d217bce83b568e1c39d28c26e77ee96dfff633be431eaa5a49a55f457346f0870d218223e0a95ce220642c214b2194644879fecbae9098619194da95c961555f7a95722a830232d40a5985a59698a70e25420c5ef05e808ca632f237aad0548e61f03897c9e21f976bc0134e1d61750047d795673ef504b7df7e9cf1788d4e238be902279ee1007c53e3ea01a12e2558dda2c2b164be9f6853579e2d0115e1c89121cf3eb5c11d4f3cc2438fedd175999c84bb1f996e3cbcad5fdf75f1792f79e19ff9fe7befbdfba92b2b8f540fdef7a60fcda657663218deb93d8bafdbdeed5eb4ec32ce57af7fe18b5ef237262b6bbffeee77bc7d61576c638cb100c4fc29a06dfa730fdcfd476fd8dbd97a4e25894b633f7fe0e3cb4f55955ff1ced57510371c8693e3101985483dc8afd43a11e326a9cb7429e3bd1064892eaeb298ee115266141c8df37459704e58ab3c8d137019a710249355080e86b5707ae2cac8d7da53236c0c1c38e1d27cc947775a7dead18d65d7b6ffcf2d93c0c990581bd5ac548eb566445d7946558df3aecf3808ad4274ae3f80973bdb312bb5088d77681bc96d627fbe2439a19bce19af0c18d50e5cb94bad2855e5692a8fa3347ea365a4adaa903491e8e89263193db19b13ba963a2b0d65519f68284756913e18d1c3466891921559abc341e282452ce558e33a3011cf11f52c228cbc67e81db5e47231d0520a3640a8d0926538a8a2a23ccf5115dfdfcd6f3591bc122a87042589d252fe2a5ea80378e7c9e2c931214e68046a49541520098794e957993e1b9351cd2407f398d85d76749d3216a86ac1f7fb30fa9a3162ccec751d4b1c9341cd30084315c68d70a4a9383eaa383df23cb43b2301db5de2e357f7b9349fb17d695eefec6cdffee9e1f8461ffcb336e6f3b59337ddf44f7fee6d6f7fd3377eedab3ea32064e3e8f16fc81777c8b4f4f10088c73bc58943505c59e4d1ef1dd4be29bf0f42fa8a2c1570f47d3b42bf411d424991d02588b1bc3ece39bcef2fe15a02942e95522daf25a326b90ff4bce06b47893bcae7e671b906104ba599f7348380af3cbe02cd015f3534556030802c65df8cebe7133b81e03db5d4244dcc3bc7d9cb1d7bd3961c661c5919310c991b468ace23129559d3c9763b636b3a7bf27c77f7e7df7bf9f2a34d708c9af077904c17af32df9fa2ed922e2a7bb9395d4dd6ffadf3e1cd77dc75d73fb9ffde7b2d1b628c31168098cf67dff3436f7af27d777fe40de7cedeff9c47cf9f63d2084f3c351a1e5f6f9e915c6952ee2a479e39066b1e3ff2d4b503074d25f891c307c764e4501d30194e985491766bc98dc1737c38c04940c531a91c83500eb2a209a74acea59fa0a91b8e8d024397e95aa192cc4a5dc6bb9ed98d3cb8907872d28caa79cbcb4f8e190f86d44dcd3c691f60942c47ccb9ecf8502565a571073f4351119c2a5184b1f7b8dc694e0941a9c53176c2504a83722e7538e500e905ef04cd993e79836ad976dd88672420d9b154cfe65cc9f3c8a9ca3369fc41c554e95fb9768cedf77628aa6584aeebef1aab48297d12c179a17681919643be132d010d90fa5bf182a30ee57c9f34a35a0ec39573845c9ad05d5f4d548b30f4c2389400cc8b80b8d274ed4b56471162765452b35af7bfe63abcefca5e8b5cee6277b13c3e41880ee649d96a133b6da6c25355be6cd2c8e5f47ed07b212a5478bc730c290de19dcb882482174e564250c7111768113a57737ce838b3b3e0dcfe9247673316ed6ca0224fdfdb9bd28c06dffb9f7ff5ed6f053eb37d1329dee3942ff765045609055d09aa88092523295fd71cd29764f5d3b154409c2f6d354e586b2a26a12b65677d5f8966a8d4e38210b46445444a195b0910952ca5142e67254a59e8280a03a764d7b124e382a7ae064cd9ffac5f07c683c068a00ceb40edc7b8d01002f81ca8261555a5e4d4b19ccff1b5e09a06a74a52c539a10a3552092907ce5c6ad9ddda67394d745bfb543e3354e5541558099e3bab845f87fb36675cdcdba3cd7a5afa80df09d42e73b28213ab9e44e0deed050f6d5e5889a1f9aec170e5ab9ef6b467fea32f7de92b3e79cb8d3771fad8ea03dff4da6f4c762537c6180b40cce791377cf7b77eea4bbfeca5ff9a6ef68cd501d5898d8aa7dc3ce4e4d1019a959815ef1da1f2ac8c02e3816734ac682a6132aa5919054683c0dac4d1848ebb6e6c98a05c3ebbc36dbee2c6c10a9e40a74210a50a994195f12ee129778d630ed48301a3da53a548ee04d54444d94e4a97a1cd74791987c79a8aba19909a21c9f7fd055aee5697437839343b298dc4292bdef501437ff64785ca0b03e73db9c521d4de310e8ec6974350a28ca20d1cdcf2a64c4352ca21b3af6d12299bc3db0cb5783a3c8b0ea83c41024e332ab9efdb38ec672e7d01fde1dc4b1905ab25e18373652a950a64caf6f24e531f5809486933f7ae64545c2ebf2faa92732666c5558180e0d4e1540eefd807325e84aaef6128eb0bfb3bfbea4838a2069480f31ec88804720ea8b648ea885da6cbc240023ee4f2a0b5fc19bdcb8c43cd20048444d27cd897229443f85aed4baf85eb1f772e7f6627e51ca9b923c64855396e5b1970e76ac3b98d111fdb9ef3d07cc122763cb63be7e1f994edab9b83a669dc67fa7edf387ae4ab9a3ae8000020004944415405fb3be7712e8240ee33534e4bd91429a34ec9a9f4dc5c3f825755c9b90426da0753c3e01904474e2538745a1ab52ba72578cd99c3b790f4237e5dc95a2584a8d74a969c96e7a3cba5413d8486ba6e1e97ebc0daea90f551e6d85a603c1c31a81b42059a3c4e1cce29ad4604297d3d52526d3927528ef82a524d226b6be5b5252a6edab177611fe713ab938a531b9e15819520d42b156b0297e79965562ae7a97df91c342e310ecac6b022fac0b8ca0cb5e5c1e9825917ef524d6ff9e0efbdffe3e74e9cfe811b26dcff97feca37de14829ffebb7ff3962dbba21b638c0520e6f38088e8577ef98b2fdf7e7a35adde92abbb6e1df1e2679fe0c49161b93bab8eaaaa08c1538532e52884521a52795feaf41d84904969413b4bac8d2adc38f08450b382676f9991ae1c343b9f18ac38c641a8bd909332d58ca34c4c0a3993a54c2252059f4a099108711e75b2362ae5513167baacfd168a52a5df788f731073e93f09ae5f4dd1671bd2c19e8a7e04ebc0eb8aefffdd5229d4d7fcf7655250b209394562fff7c1392a717d8f72f9bdcb94997642ad8a1747e31c8d2bd9131588da11f5606386f40145c9581c040749cb29f5e0efb3784484362bcb048b98c03ba22f2383ddc1ae09153ad57ebf097de0520eba590e022fd7378af70de9e2f1e24bff862bcf67565f020dad5102c99556fb2c0ab99491490ef8bc40694b499bf7e57b39a1d64ce395711518f940e53d92a594ea1cc47dfd454c5d490b95ac5439d897544d791dbc2fcdfb03e7183b681c8c561a4eaf0cd8217265b1cffbce252e2c3a2e3df6d89befbde79eab9fe9fbfdd48d27270f3d721f683fe8e08f7f18007ff87e3aacb53a0842b47fb7c9c19fa71cc20fde3ad2ff4145af7d3b7152821aaebdbf4a8160c976499fa13a0806fb8a2f0ef6a978ef1e97eb40e3034d4834952378d7bf53cb6376de958109a162349e107c8d50b21f8a10634beca654ae6334ca9c586d589b8eb8a9ae58f1820f911b2acf11ef18796124818d5071ebb8216a791e43083827a80a4e3a2a8db8e0986ac5aacf4c52e078d3f1f0ace3eccee6ca99fdbd175c387fee9d83e1e8cd77dcf5b49d13a76f7afb8ffecb7ff5e1ffe36ffdf5b95dd58d31c60210f379e0a6c9fc5d9323834bb71f5bbbe5494f18f3945b57581f37e4ec501708a1c207079452200e0fdffda912451ca01ecdc232663c42ed4a03f5e65ea45b66242b8b90a943c56ae5f1a13428ef4725b8c4b0024991d4e71fe8b301c10b5e241e19346bb553820f785f8eb6591527429794dc2fcf73078771ed97c289905269942e5535da2fdccbebb593c3de8b8c1e4e90d2fedfed6262d6b5cc7329cb19571512caae0dfa72a745caec2e954197c99426757f300b574b5378a26f83e827b946cdc4d42fab43889a51842c94e0c465bc64e6d9b18c42974a3f41eccfa3eafa9e92fec778e7f0ae6c3b4f7d8055a63bf577eba55f18e83c4e4a0954f099ca43e54ba0921192966024e3fb1e1887aac3e506af2de2a071a5f7a36430a43f98bb72784e4a2692903e50bb76ca97ebff2a8aeba73f79288302fa72a7e0cad8deaa3463905322201cab3c472b385e0be7d63c1fb91cb9da2e3fe3257dfff99deffad20ffffeefddfa687fa857b9fe39ec5f7bd777edf70186883b8860cb2b78504a7710844819df9bfb2cc7c1c0816b7b41aefd7cd7bff60743b60eaabc0e1721ea414f4a1fa21c7cf17150fa9c94ba8210cae78ec3458d7da0a519ef02de7bb47fef0ad0c5ccc5cd19a0cc168e13a3869b4f3aee1a3484d092ea9623b5e7a8f3847ed3bc53414a2527de79d439927832fd672b6b198a903c3af2ac1ff73c692d71efce127f45b9b488e4e59c36c66fb9efe31f7974ebd2632babcde02b7ffcc7dffc23dff99ddfb26b5775638cb100c47c8e9bd42aeb43e1d86a6065ec71ae8c1695be46de893bbc5bac28e4727a3a18c10ae54eaee652bad4764a4e65f6e86299d89f47525bee744fbbc4ac75883a02b0005a2de52baa99945359ace7fb321dca68d8d22b9d378208b398a89d3bdcd55039211d9462954de7fdfd63e8522979092278d76fb6c6517b21e63c3cf82e7a1874fcf1e76699323bcb8e69cab8fed05f3b39ec9738e87c4eaa65891d421057cabeb2f63d16d21f38e5f0f1210ef18a88a3ea7b56caf3297442398c79cf3297c6fde8a17681daf9f2679192d788aafde1d6e1fba665df6f262f19860c38845c765368c29140334e326518ac232164cda4dc95a95f02c195458342a90d931cf0fdcf977e525619915cb24b316516b1435224544a15fce1b4a88373b85ef7ffbe1439952f1cf4e928ec77890bf3967113388a2f7d2fd2af48d48e5a5b062ee1cbc3ea3ed3f7794ef90929a54b5dd7de2822e2aeabaf52bd3e38926b51c2f5a1539fe23808e60ed6a61c06e27a189b70f045e96b03e55a9ddbe1b747cb28e5f23ed7eb96615e3bdc7b797c2290f1b062348051a3547d637d59c058de972945e6f329de37781f0e77a1f4b30588b1a1ae06e513ad9ef53a716cd4f1589c7325b50c6540e50383c3552a7a18907b49fd38e3f27910c9d782f79489eaa81bc789c6d154b03110a69d6396029fda5b72ffeecea90bb17bddfbdfffeb9ffec81f7d68e79b5ffbfadfbee1d4c98ffdf00ffea3e56ffeee3df2652f788ada55de18632c00319f63a66eb51aeb568829a2e4bef7a01f13ea04fcb5a3d141090ae2e86f669623532c8751d4a1e20efb2652029f1d0e479b131d8994cb5d4e7f5083ef02c3aa1caaf3419685831a7c29fb29f0797fd9ae4d5687042fa89691b83165d49566eba45a1a7d819c537f80ebcb607209aa90fe677b4723ca50f2f567cbfea0d91f9ab504066d56ba9cf1e2c938c4cbe12132a83016cfac9fe65a05c7b0f6d40777d2a56f70beeefb6629237dbd96c7124aeb7379004e48e2c8ced1e169fb0d1515655a52d03259cbf78dcd94a79ce0fa69b2b9040fd21f76f1b1f45794bc0b593b20961e1c07f88cbad4afc42877f80fca6f9c8b3812d9a5524ee522e23ac44590b23844fa20b48ce44d289156956556861a10575eab8324c2c1f60dcd8ea0aef4bbf487f24acb93b8dd46cecf97ac91b9552a4695c3e5b25f2393d96d1317a789799b36db2e7dea337d9fbbdc7ce0cc0367fed572bef87e5deb7fed301dd11ffac5956ccc61a2430e47285f9bc1db6793fa40ac6499aecbf41cac6be9a79e49dfffa15c177cfcf1b75b1fd068df5b54823eef1ccebbc76509df643860652cac8e1383e660074a3e7ced724ab46d4bd50472ea037c5742db415573646dc278b8caded519beae58c419bb927830b66c5589b1266e4889104a0962c9da9540591c650c71eedfcbfd75c68947d5318dca3cc37ae5383df19c1a562c3b61bff3dc381ae0a5933fdcdce291bddddb3757d6fee972b9dcaaee69bee5af7fc7777decbebb3fbafaa69ffb854fbfee1bbfdec6f71a638c0520e673898a7cd932cbc6a28ba49cc939011ee7c1fb72b82ce7907cedd444c9241c946325b40420fd08dc52eee47059184985f381bddc21249c9432258008841018558e4a6339ecb912f8644af0b1c8ca7a533fb6cc3a5ead3de31058f6652fe2202a78579a82cb8dd3f25842df2be2f3b5694cbecf42d4de712408c79ab00f4cae3f58727820ec0ff57d8b82877edf85c3f791973861d53be6a2644d341e864170be641f4404c98e835a9a9299290187938ce8416f8aa2521ac61d190878512aa72c51545339144ac6014e4b0994f78ea010427fc8f7b91c1005d0844aea9f9bcc525bbc6456c81c1f65d6078ee0231d199c2f53b6c834be42e9ca4150218b471d7832c1b578b72c4b15b534c2274dc49c19d7916e5836ef0dbc52f9dc4f0febdf67fdb310fbef89f7a5f7e16052962f11c1a0ce8c87b03252ea4107026d143a11dad4b19341abc068e4d73c83132f7ed1f36fbdbcb9bdf1f0f9f30facacade5577fcdabe3b7bceedbe30ffee3efd11ffea9371e1ee08761f0fc53276f79ed0571d037bc5f8be2b82ec3d1071f72b0f183eb46f25e2bc13a8c22ae1b7076f0cbaefffdae74a5ffb12fca75e55b259375ddb7ea3bf64560301cfad337dd7cececd9b39ff56bc0cab86665a8ac8c5a9ae00e339a6508411951ecc380459b98ef6f51551593c91001eaaa623252064d66d024c4290b8d2c5419d47062e2580d42ee289f5baef52cb983c10bfd543171422582f425819577d44ed008752e13b29c0357250899e31e6e5b3a3a1df0d8ace3e19dcde681fdbd932bab1bbf54d5d5c7b637affcf2339ff3ec5ff9d97ff38bbbaff986af7bc8aef6c618630188f95cd1cddeafd25ec9999b632ad3993299b2c6b994e664ed430e7168dfaf20fdc1ea600f42cebeec3f484ad59767a80a95ba526e23421241bcc305873a65991d513c49cbdd62efcb941d71d052ee962f3a58699a47493c5dfaf1ba9d2a83e0d00cb96f5ccfb91c62bc73a4540ebfe0ca1d76578299a4421b2395381a07eb836a2a3051f4b084eb20f372305d4be45ad98dc8f5e7d63276b5467139b268136eecf1414892e95c9938551ac6cb5e8d6bff7e29f82f3d35b9bf3b5e4e62a579395279cf0088243a3203512a9f084e09924b6021251073d2379af71bdabd03ef32482ac15e4e2c72c750606d081b4365e833392fb93a4fe42c34c1e37d45548717cf20944de649cb5d6b2750b94c70b9344f6b20ca41b629b35a270612fb71c18e41c838feeb3d1625940ab8a0042913b4ca6be4f122789f198d1cc32673c368ce322a9d7a5485e813c757335f289e8bad0f6ee5c42f2caf5ec8ddeeb4aa24ed11d3eee685473ff8533ffacf3ef1c97b3f3e067ef0e0e7464d7ebe98ffa794e2b709120e5fc7c3877890d538c880f4ef83bea42fab5e0b520e220695ffea4f78d8e3a207412d875be30f7edc41bbc9c1e4b383c5ebfda300718c26abe18613a79e03bce7b37d09180f1a8683ccb04ed4a1ef8bd108ea412184d23b74f6c14778f0c18b6c6cacf2054fbf95f54983f3bedf73b264bad867b65cb0880a2970ba7238e938ea0283e00fca29fbde28202bc9954c6510edfb4efaa0adfffc4d7c09606a1489a0dee1ab7213a096c41d1b35378f1bceec2cf9c32b33361791f9fe667ddf273ef2dcf3e7ce3cedc2a3e79ef792977ec58537bce19ffce0f77eef3f7cc42ef8c618630188f91c30f67beda4713a193a06b5a70a55df83a124edd09c413cced5650469be56d37fd0c4eb9c475ca64db06c330320e3e814622e47b4694ecc5c46fb2041fb4578cb2c4ca33290cca8cf9c1c4c02eac82c33a4b6db74be1a54ce91a4947e94266e88da4fc3eac7d71e6cb14ef97082161ee8b2e272478c99943315cac4fb19fdc4adac8a6625fb83e9572573920f86fcf68dd2a544ad7094efed34b34c654744559766ee83c354d08493728b5dfbbbe84249ab9476ef74b81b42fbc719531ff03870be64429c78b294a9572a8994cb14aeaecf78642d414d52a50942ed95e0b40f769498124985b5da112493b2306b95591b81cca42a99a72e0bde79eae0704188643a4a8642c5f535548e797474595944659133c1676ae9f01e1a5f7a65e4ba0690dc0f2cf008ea1c21787c3f092de6122406e7381232eba3f2fd9ccb2c1c8cab0a2f1e255387441d3aceef0f90613c36aae66ca56dce7671633306b6ce9d39756ed1bee691471f75379f3c71da8d8fbefedca7efceb73cf9d6f79f3977df71cdd17b17fa52a783f1ccd7caa85cdfdf2472adecf0ba14c9b57a3d75657f899400ed5a32e45ac6e3b004cbc9c1f4e43ff62d9c1e768cf44decfdfbca411502c366f0b86c226c2a4f5d05aae0084229bfca07dd1ae5f3359dcef9c38f9de3b7ffe00c379e3ac289e31bacaf9cc0fb400803b246f66789f922528be7681831714a1b170cfa91c5de39badc67547379c6d361995a19f490fa9b013197f1d639279a3e4849d991b32049681c6cf8ccb05192578e04b869e4b9bc4cdcbfb3e4ecfe82fdade5e07cb77ce5db37b7eeb9f1e6273cef152fff0b7fff8b5ff2e5effbc77fef3b6d778831c6580062fe24ddf9c2af7d623ef79ec9b1d5ccb1d59a415d119c437322c78e4cc68706f1253392b5cc0e2d2b114addbaeb4769aa3a52d6c30578b1df751053623746da2af777998536c1ac3fb47729115d46aa52ee940e9a70e94bbfd46f6f789a7155768ae4fec09efad1b7a11f5644eaf751e4ccb2cd688e745d4251a631d1c6c42c6536dbcc569bd9c9a109dee151bc53b28fa82b199fe894858b2c4810145f4155472a5f320ca5a40b1c9901b15fe81770c0bc2bdbca738e645a42df2790d2410952e90309445cee4ae602a14d99366522205e8828b34e99b6508963d137983b4ae33ea4d2887e78d3b894c3355d09409c08b52bbfbedf420c9e98caa4ad4c20e7f2c405d7e1454b199b424ac21c216768159608c197295c4be7c82aec2d84360bcb94e91446b502893a65a472e46b37bbc9993ecb55d200d9954961c14397a08b25f3e07dd914be526706ae4c0f1b7aa842c4a9905229091c89327215f36ec14d2b912f5eed787092f9ed4b0b64ba7d74efea3ed3ed4d6297bf6d58ef4f806ffce0877fefae95954913ab2ae17d88e2e8f2c160e4121465f5e55da7d7955e21a53749c0f58de3091097092133ac1d29bab21fa634d37010da380e36a9976968074de89e3e60e4dab4acacb9df3d53caecaaaaa66906ffcd9fe7bd99ca4ffffccf3d65306806cf7ace17ddfdc267dcf6ffdbff50cae3843a0855dd6721440e338ca8329f2f79f4e2369f7e780b7c603e5f80085555a3da9062c48521c1075624734313581129bb60843edb756d44f4c1d8e940bf3ae4faa10080f693ddf099a8b9f4136557d246590849a9c411c4d185c4c4c1e90666d973d3d0737e2e3cb6cc72dfd68cc71ed97bcac58b8fa5d1caeabfbefffe7bfefe57bcece5ffe5d7dffdaeb376f537c6180b40cc9f9023ab1bb7d5371c1ddeb81139be31a4a94a294acae5febe2b6ddb74319560c43bd49783459714af8eaa3f6c7a5fee726a2e0dc3c9094b97e9227464362ac76a00b2726519d96b3d27573d134965e99f94e023f69dbcde9746e8a71ed998ddec52330a0224da9498c7444e8945175107db8bc8f6a2a3cdca2225aeb45997596354d14546c539cd3ec4adac0c9a41887523776f4f4f6fd49e1b42e6d824331cb70cbc967d24aab82a234d4273a209b03a58a00a0b7134558548c6e71617233106165159761d7bfb33c61e262e5291a87c79ae1711e6b16c8318fab2742dd09591b65a7698c47ed9a1cf25c352e772ac557568f624ad801a3d28c53a1889abda2ff62b999045df07c3c1e60907c35046f626848a86da0b1a4a6f49f011505c2e87e7d0f727f80c43f1d4ae2c3aec72460944f5b4b91cb30319d1b234312a2c52c2eb41f959ff5ecabe94d7f51bd2bb984a762579fe5ff6de3cd8b6ecaeeffbfc7e6badbdf739e7ce6fea593da95b422da98540a0015040604a010707411862303829b031601c4a858331c11438c66017293be54a5c8eed3821769c2a0742308921089791911042426aa927f5f05ebf7ee37d773ae7ec61adf5cb1f6b9ffbba85289ba48a4accf95575bfd7b7dfbbc33efb9cf3fbaeefd40d01cb81ac89ac3d2a99a92fe84545104be3cf5796d8fd5679663ff1ecf1118bd6f1c07dc69b761237da81a797c748ca9c75426e3bfabefb936f7bfb3b3efe6ddff48d3ffd1d5fff1fbeef8edd2d3f9b24920b2c722258c669e949195c29deb30ccef415b23bc13497f2c81eb20a5225bc4bcc06cfb074c5b06f0991aa64306448c97056aee3caeb51d2874be78718a7d239a37894821500e2bc6732ddfc9ccfd91ff8911faf2a0dfa5ddfff7df1d28b97f8d2c71f893ffc533ffbb5cbe572f8811ffe217bf8c187fa38f4f7fcdcdfff3bdffe5ddffbfd1f8c8be587def1655ffed2b3cf3ecd4ffed88f749ffdf996436b7d4e5455a06904246106317658169c57a64de0e1fbf6d83f5cf0ba07ce71fecc949c0d114f537b52109aa6c63b4f230355483807011da582e567f46e752118e1dd58c4588c3725754f0d6fa52bc83b4546e3bb1bbb62c8769ac0d52854eac8a900a5e0e10d7b0d0f64b8da1a672ac713fb0b9e393a7107cbf97d938dadfff1f2c54b9ff9c2b7bfe347f676cf7de0bd5ff1de6bdff2cddf14cfddb5bd4ecb5acf7ad6b39e350059cf1fd62c0faf6d4c2db9d9a4a2697c310353224055ebb13caf2cc718e554374792183915df45362dcba8380c6119136d8e0c1887245a408271df8672aece2091a39888e2d8a860d38c4a4619d54a2f2f50b9d24bf096335bc7c7b7f6eb676e1cf0fcf2262f2e0a93b1c8420f69101b7ce5ad57af9da9d4786e9db4a461d09d26f8cde9441edc9ce044591ccd79f2c621d707e360d1b2e7338fed3a1eda35369b9e9a1eb18c89310db05965522ecbb98871a3cb5c8f157bb309db6e609297c414597435f3ce31f41df376ce2464c497c56b1897fa98a0ed95688eec3c493395669cb3517e352eaa63c298038240e3a1cf462f8259456052dab635e2259534262bcc464f91a50584c61913574edd271e9c37364326045f72b52c601891c212391d1bbd513c86a54c9d0b1871188b5816f3e01c8d8611a44af10be9503e8b450082086194806504e71c410bd7d39b621ec41bbd2acbd8d05bc3c050d8112dcc8cae3efd4af6e68befa513e5302ad7bbccf5ceb110e1ae59e6ccace5d3f38eadd916c7478eb3cbcccb8b13168bc5fbdfffe33f79347feee94d77436dabce4250da2e411acde232c621db80e602480457e26635914874261ca7c21c058b1c59e24654164ba825b3534313802ca4587a516a312a63045d2578c046e051c2c714ef4a778baa31a8235a6218529aee9df3007ffacffe856f5c2cfbf6ea95975eb8f4e2b3379f7bfae97736a1bef72ffd677fe1e193e3c3feb5af7bec977efdfff8a5ff24a5dc9bc8d77ce09fffeffb5dbbd08dd9c68510dc773775fda998ed77dff925effe89f77df3773ef34f7feeefc557be06e8a4de747547d5389c3a52140c478a03f88403767626bce75dafe50bde7837dbb3097b67364a80823aea4ab038deb00521907460a94265f2aad4b6dfa3295ba58aadca19cb8b4c493e13f0ab52c653f95a1e4b2b4776490b0baade91ad9c847811ea00b3cad8a91a766ad8a894eb6de67ab7e0c6cb171ff4871b7f6f68bb273ff2dbbff55bddbcffaf818facdf0dd6b39ef5ac670d40d6f38734179f7fa23a4ad7646fdab3797e9759ed8a2ce5b4ffa32c4aab04a01433586142821b972683de8ac9dcb922bf892ee36b21854452d86b843b7760d6f49857aa89b22d82731162446cd554ce98482bd45eb86fc3736971f0f51b4dbdfc4837a4e7f2a06cd793a5cbb2d328dbc1b97618dc24382e1e2516b70672973967914910ce57c61b7702afdd9e110dcec625f1a0c54e96cc9789d0c03d53cfb92aa1a9275b8f908a072641174b2e95923132b77a787a6e9c57e58217ce4b220e899412392782c2cc65662e3375e5a47b25ee378114049c67e23d920dc9c5b89d47e663950a244689dc1d253ba2e3af52d2af1c851dd271e137297d13ea21983211632646a3e564382a884bcc44a8bd611a51f16420ad64614e4600525aa987544cff410bf8f411bc413063c345bc9626f49c0b80c902290b29711a556ba77e9701d1d2001fccf01e9c87c18cce323167cc1b5241e3152fe37da78273a3b762fcd8f686f2d8fd13cef60d8fec2676763ad427b6664253b7b87a8fe6a061bb5d32ed32970f0fce7de6c94ffb33debe42056953e268c8645386a4f4a9b4c29b0926915585a3a821a9786e0612377ae5a9c3c4f565e2ec16b436f0f1975a0e8e8599371edaa978fdaeb059f9516d54bc40852d540e874c1a7d1faa25e5a9718e6950c4294726dc30a1b3ccad837df9971ff8956f7bfd9bdffae8b34f3ff56d7dd773fdc6d5fda35b0737ffd5affdea3c04df5455fdbabeebc866df7bfca94f9172a6ef7b8b43ba2ba7c475b98913a9264df5e66bd7ae3ff66b1ff8bfe26b1e78f8f9f7ffe59f74af79e8c1bf36994ee43bdef7c7e77fff67be5d9a69c01452acb158e12b8f6b14753d488713e18e73db5cd8db4445c838e2ca683f467be5944ba707e5d72257d315d9f1fbccaa1da600b3ac254efab41494dbc6fd55f4b7ad3a438553a99bc2f87d958fab40a3c2b999f2986f383fabb9be343e7dabe533472db716c7f58d8bdd9b3e9178d3a5179fdbf9beef79fffff9d8a36fdafbc6aff9d69ffef95ffc9bd5ced9ad2e3cf21fa5a3177fb5ba79e562bcfac2131b4f3ef342b879b838f7dc0b170f9e79ea99cbeb778ff5ac673d6b00b29ef5fc3f9c5b87c77b03315c39ccdcbd34b4b25333ed69ef871543681ae50f12134244a5f8160e97c6ad055cbb7e42256511dc9ac099a0ecd61503c246659c6d06a2761cf6804ed8f0c6c172cea26fd9d25282c6d895a1aaa49cb9a38a3cb9b8f6f80965599e38e3e42463098ec498c74c95134b51240b4da7dc574d79cd466037c01d1b813bb71c1b75a237b87726bc615bd1242c6231786f4a24c44cb28c31209a4b1257827974a8f3d463bbb5aad09b12f17439d359f14a48d9959906217ac56b2e00a2742a6256627b3d5055cac43972b672ca4cb1af188aaedcca2b29d6e81330319c2454135588457e65194689d6d8fd482d8a8a238c46fb12f1bb9271411c4149e53b2a8dc0803100095d45c45a31e33b6fc464c45c16bbca81e6441c0c74a0aa142782e57c5b4a94c748e6b15c310bd828a11accc6b6eb5cae8b8340465d8f49c68584861e33e853e960f12aa337646cab8fc24650de79af436bc78e769c9781a918f76f252edc5a70dd7af676b6d8ed231764c9fe62cef5e73ff32736ee39ffcb11f76d1fbed6f1b11b3db3aa66d70b1233220309a54b913646862cc46c0cd918c8448ce3247c7a7fe0dabce39173136641f8dd974e385824a695e36657b15307b6263575f0684e384b2536d93bb67cc0393d8d9df54ef0a3c1ba43b8ba103ebd1838887073ff406f1e7de2d19cd3a3975e7811c361a27b66ba07403b60d66329ddee211145b412f51e57f922c1cb89765830bf7ac321f6a7528cb15b2e9fbef0c45de7dffd555ff56bffe4e77fe9895cdf7bb7d91572f6043fa572aec46fbb01e4849c3a608293ba18ea575ea4553ec3f81a912d97b003b191a1287178c2edb2c75744587cceff7c4528d96969a1adf2b0c7ff5e7d421bd1c6aa597e15e97c1aa53d3e27772a6343840b9563d7cdb87f567169def1cce1922b179fe6eae5c91f3f3a3efc9aab972f7ef443fffa979b377edefd4b95e34fdefa951f7d6bccfa68b0fe5a23fd97c56e79f78b2fbc1896cb565f73df7d3f554feafff2a9279f1ed6ef22eb59cf7ad600643debf937cccffd0fbfe8dae5811cecdfd0e3c31395eed33a49d6999dd42fbddc71e5c6404aa3613a593110a7c472482c0723c54c1e22968a69b61d32fb2791e522235d64383ca1b101c989ad5b0df31500002000494441543ab11b1c5d2edd0b42c751dbf2fcdc587ae1dc86d22e96b86e49efa0768a494645a97d91c4dc38495c591ad165cef8cc3d2ee327468c4225828e4bf82d33aef68e97bbc8907bce04c7b9069a504055eb12434ecc9accdd1bca0b27855af06a54d6234349cec2ad226e4bbfc8c41941134e0a0332738e73b5b113604b20c4c21ad452188b49f074c12139612380583114951895144621b872ca9edd18753b16bb215a4e92a5ec5c2511d6ca0b8018cef578d55266988b5c258f0584598a915acc93315a12823158621e8b3f632f96167a27912c11b1787b811d8f956d9409094aec3df3166286499da95d593497e3fde428c020db5803a3ca985350181f8121098b0e164988c0d41b1b5abc2a056e252a075548e01262e5543b6859d4cd6018c632c3244c73e67e3fa7b1257e180892a9bde3ae20dce5975c3a99b3bd7d8eb0ec3867918706e3cae1fe7b6e04251e0d7cfcea0927fdc0b9ad4d2e6ccc188648ca25b9eda8ef38697bda21d2c544cca95c1d1550cf491f1962a49a4e786827b059072a0267373c776d786a4fb95744e94abc1a9b5e9905c7f684318481b10ba348f4560cc9f54178e6d83848153d8e1401f338e7113fc557dba8abc704af7119cf63b3bdf388f3201e11871bd915af30b4871c1d5d6539bfc1f5ebfbfef8e4e4f5972ebef0e8277ee7b7ef79f875affbf0d7befbf5cf2f730627544d44f5a478be72861c89fd405d55485558212ba71205b08e745dc104253d2ba91550ea747420ade2bae1b61be636fa10298ff1abf459a7f77e694757b1c2cc8d60a6c4188f5e9a55358b0a3ab6cbdbe8dd5103a26131b3adcaceb6e73533cfe5a9e34cad7cec60ce8bc747feea0b9fe6d6d58b5fb473e6cc175dbbf6ecc7dffe967beb33bbf5a3daf7ec4c6b6a7f42777899eb575ea68fc9ceececfc959aea2d6f7bf39bffcadece994ffcf30ffc6a5cbfbbac673deb590390f5ace715f3137ff567effff61ffcbecb7ffb27fee623bff2abbff81547fbd79f11ec8f91dafbf7eafedd67fc49d55e39e4934fb4744362d927fa3ed30d99218dbd0f39d3c6441b8b37a0c1a8b568dbfb94993ae142037b3a30d3c880d0e61e41d9efa0cdb0e1128b2171f904e69a98fa813af5481e4a9a532a4b76d0227bea92f1d4017c7419d8db9d301f7a36a4e3a13a53f9d2326e593888421c1cde39d465a238f08e658e74d1982687a9d2c788c6c426824789b99cf6abd8a9ac63c5648cca21365ca61abb3aa2c19ecfbc7616a97dc74c130ea3cfc28614c951e5945e3c310f65e12a47b3ab305f440cc90316ad74a9a47159d3d28d2299510b5fb6311bd3911c4506263620b1749fa895fae8559e922547ce8e983c59c7f42e67a424444d244690224a52615081ec4e7b3ea26949c2ca899c8c2135b4cb098b7961a36806fcb445b4c7cc31c422bbcb06d9041db38465f4cb980a09a5ed3dcba57232085105d7442a8d48ce2404118f778aa5d23b232922561e238b4adbc1bc2b6676e72b4250a6c34035b444832154080e9713675c22a48e6656d34da74ce28237e6c8e1d14dae2e96542170bdf7ec2f07e6b30d0e6487361e136322e358c640afc6202d3d7dc927731e0935e21cd9f5f894986bc3221b776f4ed8db729cdbf4ec4e32cac0f5b9114d38ee2243cadc3d0bcc9c30f363c1a52aaa65b966640be64919cc13dd049a6d2ab741a618f79daf513f45aa2dd0ba7864d495f86b29ade98822aef0963965483d953326c133742744a9303f853430b4b7b87efd865695fff7fbbefb2a96d72fbefb2d6798550d3b7b82064fd71962139c4cc01aa8a434de5b018c99b148500b58b4319fbb34dde711c0da28912acf67f9bd069057fc4e4ee3b7475472daa3e2a0841a50ba854a6fcfaa9b474e414ea6308e797c0e1b06c91152794257a2a52cd4c12c78a67585f3913b260e53c7cbf38e172e3dcfc1ade64d8d1cf1aec7efe0be0b336655cb95a3033643c7b90d61a3a9e5cc96a7b5fc277a86f7dc3abcfe0b6f7dfcf1fffc23bff33b2facdf6dd6b39ef5ac01c87afe48cd0ffed07f51fdf5bffaa30320dff367fefc3d572e5f3ad8ddddf9a2aa9edefaf4273efa0ddff9def7be31c6f88e93839bd5fecdeb97ab503d14483c3033ee38039e25275d4b3fb21b160d8d46c8c6548d89c28b4bb8b428ade3f7d6990726c6d415dcb019e00ea74c34a366844c49a932b8b2508e92e3c244c956ba3c104f4e30552178608ceb54c0492ae949c93889420e9ebbee9a914e944537209a68c4b004bd3aa22996959953ce05c7b6afd87015952813a9d018e85ce0b8cf8485d00cc2b638662ad4eef6693d6eec363123e522c10a569acd11f00abe32267920caa2c4adaa958586c20e25f30cb92cd333bdbd0c315a6ac432a4929094ac2c6b31950241ef0a9bd09922e20892c7d8dd5734d58d096363273a5ec7babf2cc4ece88740db0b5933dbd3e243c9ce68b4984a369d31231328a7c5322e7562367a888d64424c909323e79abeafe8868128463d11664ec636f472c27c0ade6c957235a6988d06f43c286de7f0bd2378657b226c69a962c836323c39e16201527da618f72590a367b984b615861ca82601ef064c3229955e9968428a8233b850c359dfd3e501db68b8722c9cd3c8dd2462e7c9935ddc560d75c7c9990759cc36e9d215921b906a8adf3e8f9beda231e2638fa9439b193ad9c044b09303aaa36b1cde7c96178eaef2fa5ad89928539f50c99c0cc6221a95131631b38c09b7844a85adca1530e9956970d41ec26842afd531f58ee964978de62e7067705211bc43b48046135f4c3ea268a11f4ebb78721e466f56407224f791ac99ec03d894b079271bcd395484eef865e607cf1387136eee1f878f7fe2d9076f5ebdc4271fdce4dd07f7f28647f6d86a2a36279ecd6a93103caa6d091b18f9321b1f6b917cead738f5738c34c52a8ed8f86c7ae3b320c84a32b52a6b1419bd5385312acf81950fa8dc673676caac5e33b2dc7e1eaf52b905c199508b10a4445b2729a10b89c4ccc3e7ef363cbee35846e1636ec130f42cfa05cf3d7591f6e480b73d76278f3dbc8b7978e4816dce34c6f9a93248c3c503e3c671dc7cf970f92dcb8177bef9b1d7ffc3e964eb673ef8e1df3c5cbf23ad673deb590390f5fc3b3f7ff1477efc6e33bbf3ebbfee7d5fdc75eda355d57cd7e5975efccde79f7ffa8253bdb7ef963ab4cb2ab773f2d072d4c687da98d90bb075def1e076c5769338b19ede67522a8578c3282a9852e2639f3a100e526036ad68a567560d3c30131a35666a6cf8442e31fda7c94e2b69c54ee3b9732be045984c8463ab682c132c31abb9ddee379aae558ccac1d98970c660bb16240a1bb97cdc1b4494ca949daa08cd3b134210a6a254d93175ca542a86ac0c1ae8357332c0c6904983e10c1c45ead567a8b3905df174e40432029b2165c425bc2bfd1d4622c70e51879815609232275d625a1500d10db0e9947aa50fc919d555e1a08d4df3458e92ac300739438f30cf8af31e24135e618a36b9bdec632079344e8fadf2f3a41cf570d49634b181cc56557c17d14042f189c464547e20b8550745b9f48e841874198e1274d2d3f62dd7ba81a36ec0e5257757037749c6a5c2c088ded6f7bb514a538a05a1f28259e66091b87eac1cf7caac513627914afb12cd6aa3c15e0491e213590003827382256511611e4b0744132379d9d25a4f251957431a5a862c5492d9708e1d5a9e5b1c514d76b82681ed74c2831361180217c3067ee70c93adf32ccfbf96560369be8f388784096e631736f750f57813cc8fec870fa41891e531d5adcbf8a784c9cd05f76e443e7fdbb3530da84f4473204a1088b174ca04e7a89c9638e65cbc1f95d762fad7b2982fa330991ba84774139129411b429814be41232a0e9362e9b671d3372b376b8eed2bc0414647a60829fc9bab37f14d0308ce4f09935d6277c4f2f83287f3eb1c9fccb97875c1b3974e78f3ebcff0c647cff3f8eb8407ef0c785f957b3e975864f2584f6809cc832584846a29b3d45c40e5a9c46a9570659f23e9564e4d1b23eb61b75f0b4eefab51deb76a9e1f6560856559b120f62a0645c6cf7bca264a2266233a88c0fe9039ee33775615dbaee296241e9836d4ea4892b93c5ff2c4533739e98cbbeedee19e7bcf31dd9cb03f159a34706551247fb839878b9661c8afc983fda585f10d6f7ec31bfe9a9fddf9df7fe443ff625d78b89ef5ac670d40d6f3ffdff9e58f5f9f7de25fffdad6d685ddbbf7af5e79dbf1e1f199979e7b72f7e5179e9ddcbc72f9c58f7ee837fe64bb383e591c1f7fe1e2e488a1eb8cd8be4bd380cb03b5c06e30b68371981387594003d32a714f3370560726666c84526497b394457594d404e0eac2480867ce6d72df3d5bc4abfb444d4c27c2d990a9c646f20ea10ac59bd1c512077bc744984d8c73d312351b459920cc173d3145c41921707a922ae3925d3b78ed96d1b591d9f19c3d89ec293463bbba53c864aa5c98989c8c9c84561211a8bc2f8b7ce58995c7e5c420c651ccdc1c06e639a1d968137409aa583c1b65b929f2a4a3a4c4ec983868bc119c31e4d26be246f9968e4cc6e190984e180dcc4a679e0d512c0fc04032bbedbdcde389ae151912a3c97f9ee0d0ca69b8196816d44a4cebaa86de28057e5d2c40b1074e628908beb6140eba52de363b522a676413a215bc33ad944980da65dc98ce15f36d00215692a91606c9193176dc3c81a32e12fcc01dc770ae29b49799959378f2a91938668849085e98f8c2e81c2c32fbf34c9b60b751ee5c649a50fe1c064e6fcbe0862cccadb4da37de80c8a283650f4e06267e4cd40266419934c5209f7266e6845a95a32133e4395bd35d080d5d2f3c38752c260d573766f8bbef279c7f9493edfb887e527c2b1ad06c24274855935dc0d49593fe9cd138602e4135c33533cedacb3cb0b3cf5dc3cbdcdb081b9ae924336b94e01d43ccc4a84c9ce2d451fb12e9eb460f88adb8012b4963c526956807cf5216f42953d53b986f48ae8410ac647c2b79d30add9b4169771762df11634b5505a4d90432e2226e447a0668bd41156afc740fad37881b17b07ea05bdee093cfdce4b94b2ff0e18f5fe3f1d75fe30bde74076f7ae42c0fdcb1c9f6b4a2f2ae78843298f32576d90ad054a148c6583199abdbdd4e41c8efc3819c76aedcfef30544382961053236cb1bab440719418e9c36c8cbc884c02bbaeb5d09124f43e22425da616ca61765b3f234cea12acc2acf237b9e07812e259e3d08ecb7871c1c771c75c664da50892187135824f682e3de9d4dee9dd7ec6c385ebed172e328c9e172feba2efbff2e2e2e7ffbbbdffd153ffad677bcebc33ff3933fb65cbf8bad673deb590390f5fc7f7afed75ffe8d87ff833ff68e677efaa7fed66b7ff0fd7feee9effdf33ff475bff6cffed137f7437ff4898fbcb83b3fbcf5e8d1fecd7b0ff7af6fb587b7242ee7e9dad58b2ee7c8bc8ff429d14892d74c32f74e3333c94cc6123a033e1621d41336b7cfddd8adda2d69f6ab14065c289e8e95a4a3f8674b3eabe6d2f971c704fa06ce6c28b250ce9bb0e38bb1da3c448c36091375482ea58213276c858cf84837c0d1a0dc1a8ca656a62e525b2a894ee58093571e923a81bb6a23c880f473761d4c3034152fc120c251ccbc7092b939286699652f54d273578aeca8927262470d9548d4880f704c26e544186555d9c6466e2d4c881b179d981dfbbd6710cf66162203b519d18c2c0a52fa42cad26d9cf4a34786e2a7c09504ad44a68f8936e7025e72f97ac94accef62b4bf44338e23b49a391f85656f1c75b9a4fdac3429e32f6d1416b1c41f77194e12cc63699f0faea2aa67cc82a3091ea70ec3505506e738769cb6af67037cf1af382952af3cb6d9574e2118ce0d545d44c4986b89ae4d63b19ce5b2fc97c4a84c970c278e298e90cb229983d24d8d3e265280c3c1c87dc6acb48e674b25e10ac85918ac2ce62b662419f43193525ad9900121a850793b4def9a84220f9b548e0b9b9eede0594eb7e91737111ba87c264c2bc2e694d8cfe94ff6e1dc03683d43862201cc4d4d1bea22b7324173c65b871b63a83320cee1270dbe72a4be7c3f5e948850abd148a61dfb5d2a5582cb258cc0042fc5e49fedd56c963723e79e6ef0c4d017b995cb25d29a08967012507b65a86db946980369ca639ac06942a42e3d2d66089e9c17a4dce13480d3e243f1539aea1eb2ddc1d01e222713f2729b76b1cf939fb9c6f3979ee1431fbbcce77fde59def596bb78f36bcf72ef1d5bcc9a1af59063c48b434c21e572cf78a853290d1c73cb38bd7d5730415ee9f9185de4631f7bc116ab2003c38dec868e6c898ce96a2b366505344e3bed5fa9f612433591497431d191cb6324c2a62b1e9320802482cf6c89a152fa44bc9b72a58f7c3225d2587ce8bd3209427289a908f7dfd1b0bd7986cfbb7787a75eb8c553178fb87a18b974b3e7f2ad5befdebfc1fff4c9dff9c82fbce72bbefceffe8b5ff9d50fafdfddd6b39ef5ac01c87afed0e6bd5fffad1bb11bb4ef967443c7d075a4d8db030f3d3aad67934726cd468b657ef9e7ffc927bffb7bffe2773ff1b18fbee93bbeed4fffb38f7ee45f7dfd577ff9975f78e6531fffcae5629ef7af5dfe4c501e66e808b165c33a5ee3223b4d74c132fb3d7c2c2b730295ab98f99e47a699b395114643e75152766a61c72a76cf6ed75b32d18378c2cd21b1591503e74a6b9dc988ad4cb3b0d5186fda3134cdd9d8cfdc5d2d79c827b6756c391e93a31a4ab428a6d4ce9806c309b439328f90c4d1549e2d17713e5119b82ca4628db8bd688f856495c03957d27e9a6cc5642a8665a1cdc6a78e8c5fbfa92cc55359623366ce84c849ee19cca149504b6c58c25964e1ca7258ebe86d91db4fae9ca11fd3a74ca0cf1951a13168073819caf7d45b615f3453e44166dc1c8cab3192fc80b3c4d066d081fd2ab1e823b7dacc61af2cb3d065a14b85619a67613057e45c2a0c0655f0dcf035cbbee1a82bd29795565e4570ea4aeb7ce350e7485612c16621707636e1aead29776e34ec4d6b66219436692be676172a9c0f240aa3b55a0a658c835d6d8c218317432cd1e7be78834c5029c667c6f2be3c46e6b6c95864e8b3d078cfa617cc5291d2a923a54c1f2348a627d3030e8f8830a448cc1919bd0d09298deb39e39ca04e8831b3ec07fa5852a99215f6879471327eaf1841321b3eb31994d82961e288d319c916089126381a5f13160bbc2db01471fd01b94d58b54bd240caf9b68427252427d4158626c501724fee3379282ccfb44e6c79654b02ce1726608212b594e2adbc352246ca525add570105aa38155cce2343a138ada9c21654534c0c52497a35f70aa9d22a0a0a390d9632117c35233041544a3b7d4e23cb12cbf75e69012122e35a2f88451c3dcedf896ede457f7283f9ad8a6577c0b3975b5ebe71898f3f7983c71e3ac3db1ebb93c71f3dc703f7ecd034e06b218867e822a98f458ee94b11e1c160041c9b0e4ae5a5a2aef886b2a502c246f33c23308b63125bc4c08612539c4b229bac4e2856bd3a2b19d6286b545e61471927592912558199f7d4ce15d01113f33e31b8f202902c816454234e3c3b8de7dcccb3d119d3ba480751e5a608ed60a544d4393627353b7757dcb337e175f76ef1c48b477ce49903cc068ebbe33b6fbcf4f4b757a1feba7fef5d5ffc8f5392bff1eb1ffce0f3eb77c5f5ac673d6b00b29e3ff0fce4dffa0793f9c9f1e4d68d2b43ead36bbee54ffdd9e77ee17ff9876ffed4139fe0f8e02099c817f571a8dbc5c272ca1b575fbaf8f6945218fa9e61e818fa1ec87cfc773e8c772ea12a1613f564aaffe0effe57716b73e30d39c6ffb85d9cc8d02e35c51e6f5127e4871b9fd972b05dc1b94a38d738367db17a360be3a9289cddbec0eeb4c12faf13c331b1892473252ad612f76f29872e71dc1d6e565589d93dee85a181da4b91d4e422abc808494a4785f3f0fa5de3dcd082f69cab8cbd907063946a69ac2ec93c3917cd441d12e2121125e6b238545ed8a8a04a694c7d750c065d367a294b86938417434d4ab99d142d7b2fb765435932c300d75be510cf5d776e7072d0d11df63402ce1215c6b4f24c5d29b633122d464f2e4dee066d8283be44e8fad190ce78dabacc45e295a3f1f222737d10965616f7204232c73c0aad143031a0bc14334e9534789e591693711b2bda5c33e472f21cd451798773c2a40adc31997066d2b0d378b218bd382675cdae0f3463c290988df1bc82aac3a9527905ef197024f54cea8acde09939632a998ad1382f25106040a99b9a69dd946b68e9f629fcedc3e972da8ba2398fd1aaa11881a498e3d5956e11b3c258f4596993d1e2c8ded378c7945cb28f5646f79cc74538315826ca8a6dd3c2b499215a643a4946306a721a9d6426a49ce85362489164452a2894e5965cae937745bad7cf975cdebfc9bdb660b2d560c92152b15f5774cd0e8bc926cb668f230116072053725317594fbf2809531a20f5d01d61c1915d490c33e799cef638b375963bd27526fe00a548ad64644ac44a6bbc0aa41849800fa1b06619b21430a75a645179f43fa804bcd6683dc37c8561047164cacd994bce1532b6c5dbca62b46212dc8a112940080f7100b4c2851a510fe24651d46a14af9b684d4913aba6b8668b7e7948bbb8c1727e95a72f9d70f1e54b7cf453d779e7e377f2beaf7c98d73d7086da2283c1b21d68db39136fcc9cd227e166ab0473b889a319899b6a642a16d188a6d441c7b6f392061723a0426fd0a738768b805ac0e1cae32ca960aeec4a4daa975380beeabb41cbc71205a8d5ae94270675ac54839537441c1e238bc394f2f5c8a896d703af4213a00942cc4244e9b32223b0f70ac17926f58cd9b462677bca9de7673c7be9988f3e738b97f7973592cfb76dfade3efb6f7afbdbbef0ef7cf0431ffecbeb77d2f5ac673d6b00b29ecf3966263ffcd3ffed9d8dafeb1b575f4a8787070fa79cbef4831ff895773effdc93bfd12f9676eefc9d7feefbffd36fb8accedddb2d17b45d9711d94b31320c911807ccc696ec9448319e9e488ac898715fa44e9632668997722e91a7398f6de0ca6615a82b0712185438cc463b08d7b250078757e568482c89a87348a859f40dcfc5969797025215e0e23a9aa970970acf2c0f8819c2c488deb19f8d360a9320040df4095a53e649e887cc960e6cbbc4bdde5032b5b7222771760a56a2395209cd44a5fc8cc5eb20542bc3358ab362944d02591d5161f0a0ce131024652426c8a0e2f05292b39225867e20e65c4e91134c05b61bc7c3676b5aafa42cdc2bca102347436267a2d44e57fd64e32969597c5b335e5a1ac726ccc2a8515ff534a8925182f778ef594a45ac4b35b9a284a06cbac05dcd84aa0e30fa17eaa6a1aa149f96cc32b85c96f6d20c5e1e2baf0eefc1bb812a083b4dc34e15987ae1381907be6173638bdd3c308bcb72029e323946fa64a79296ca3248a25721aa1188f861c02f7b2cf7e43c2062a59d3e26ba68f88d6d7473b3b4538f00e4b3ee7c00dceade4c0538147052180a75828dede8390bc4b18e02c17ca0094a3de67499ad4ae9ca63eeb2a13152e57cbb457be503d062984eb93c274474d4fcaf928f288101a92796a3729c6a616e722941c40baef2a4458fcd176cc59e3da7645751abe788c891456e6dcd085e71b6205b40fcd6e843e990d881ab8a211c2b20c405f025ce19f1f8c98c8d8d0d268b507ece6c63a2979e6a09751408a53159ccaffa3f9c21595e75c933af3032508c0fb662204511096316d4ed423e79d523765b9a66363a4cc66e19a33cb7107fea0379e5083a3210a3ef22cca8371b5cb383abb788933dd2f280c5c16778fac57d524aec6c78cc7aeebf7b4adf275eb8b2e085cbd769d4986845952bf6a8a8d53151c3dc302ef73024639e05ef0b00934cf1d9e4d23c8f794c3d310bb7da8ee33e214e99b9c2aae5944f6557de298d4931f84b61976cf493f8d14092636639fea34ed8a80255ed697c26242bafd1627466cc9321de9558e851fe47369c968084793b70b48c38f3a464c574afe575c385c085338e333b131eb8b0c9b9ed864fbd70c2e5fd9eeb4791933e9feb52fa912f78f363ef1972fad9506ffed3dffaad0fad8deaeb59cf7ad600643db7e73d5ff3beafbe70e77def10ec9b6e5ebb5c5dbef4625e2e17f72d17273a3f39fef214075e7ee9a2a614cfa414c705cbc839bf22a1668ca0b4db456fab484a5141d4958cfc9c304be3c17b311bdbeaf7d961515964e16a57a23e57255dce157db9f70ecb99e33e61d7f6d93f3861660357b47cb56c89ad3ab03799527b476f81c334602951d70dcbce7872b1a4d6ccac2a59f999b2b4990b902367e20977f98e0d2f347e34d2ea6dd94302b215fb6989854dc498905cba2d04102d5d1d24a18f9961480c097a3392083355bc73f449e8a210a392cc7112adf81d129c0ccac9901952f9ba577ac379d831d89c05f206346de65697d86e32f7aba2322e6194d4ab5a956a3c656df16c6c6c70615ae3c6c5435470a264ef09b3197b4dc5a6c2c40ba12ac658afc2a6abd86b36f095a34f999316643aa3992a757742335f60cb3c2e92a3f63f1b3167628ac4b125bb6e13cd50ee9f97e78997dc260fdf33837e8eef0fd892813a67342792e5728dada476a938b2f364e791584e73350d2406064998648278ba98a08f4ca2b2991d0e255be2b3b7d1d5759251e65362790b98d491a1d2342efcabe5d9602690551117f156420884b15f65f55cb89dd78b49e6765ff5abff3daa70c6451e6e7fa07cc14cc6348f1f16c4953e8d2c89c160e82343dfe1e380cb8930b68f2b9107dbab5c3fb9c88b1b3ba055e95dc92016a9864874992127d0745beea485b912f5c57391fa72c2aeab9afbb140725c8bbdc8f8fd8dc6f1d15dad6324adac5e17468076fb672fd795b15cd3d4c6e7bafc5b1e9a7caeae8d3fd0a9cb08fc4a2675a8263817607a8e7e7e0479c03ae170d1f30bbffe3c2fbe7cc0173fb6cbb28bfceeb347dcbc39e7616f1ccf0278cf6ee308a638379448e0f10a65c94c3d342e96d0abace3b14546491882d38a7982cb0b639e8dad29cc1a874749b1bc86aa94143175e5b5a8fc088aad30ad2f77d372c85cef8a99dc34b31561771ad8f28ab7a1a067b5025ad421c111cd38ea06967d616a75bcb043caccfb8cd744cc9cf6b0d8a9124ef0ce717e4f79c71b02af39b7c5132f1cf1c2f505d70e13570f7a6e9df46f8fbdbdbd4bf63f7fc9977de9fbffe5077efdf9f53bee7ad6b39e3500f923385ffa955fbb7bb07fb54931deed5cf516e03b9e7bfa89473ef1d1df5ca8baf371e8ebb65dd2f71d29262c27b5d3d34341d49725f754575d4e734bfca38c5293b1ed979246e3bc27840a1525c59ea1ef4bd1978e2e0c51542bc405328ece1258841c8bec603463bb5c622f9d38cc39da3eb3e85bfa2ad0573332893ec2be55bcd42b62893a54249994a5adad787298c7650000200049444154be5fd275863ac34926a748ce19e707ea00b566f6c471be6ad8ac94addab3553ba6558912ad4838ebc6e41b37fa2304cd8ab32205524a5f478c9e45973958648e9699655f62686baf9cdb50b66bc7221afb4b1892d265e1207a12e54dfed88cfd9438198c211723f5fd9b0df755155335fa4ae962a44a5039c1bbdb7b1d94d3ca4a8a84ca89707652f1ee3b3679fd990daa2a9446695506839b596976f7b8733a212c16d0b56422c9127dca8438b0d99d90874c6a23ae175c1ed8d09a4977c2c6f298300ca76dcd904896883133a4c46082384fad4a3058a6c4c17ec713b1c74fb6d8ee8fa8f3213b55a612a3d6918d4047d37829a033759894fb46c705df917123f2f3127124a2f5d43650117125efebf7ab6738b50867298de4051cdb2851b3d3c57905282a04248f1c979c9ed2af7cf3a7f166401e03bd44f2b8a2af3c17ac04fda73d13e52f70ca8460468e919c0b1366aa380925623846722afd21ded2d85b5124712286c69eade515eebbfe042f853d2e9f3dc7a14cc9c32122275037e5899b86d2b70163cbb72b2c96f3c5741f73f13ca92b9e182be063c8058c481859191b01ba73a7a94eab6b27364aa9447f4f4b46b6d188739af6f4ff1258fc1e67c4e77abc6f97f995c7b60011e72acc17e9d2cc3f881f6a1607cff3994b57b976f384279fbbc51013576eb64836dadd8a7befdce0be8d04da73bd8dd451d89948e9ac11086482089606e6b148da260ed0813e95d7b70ecfad0457bbf29cd96c12954bd40a7104a74e849822275d3a8d745ec13e5123382538e3b88fec0f99832e33a496ebcbc45e5773c7b4e6ac83897a9c2ffe219f33ea20a644b2f8aaeb5779d89e06da49402b4f5d154653b418e519d3cd44caebced6a4627297e3dc4ee0eac184272e9ef0f445e3ca7ee685ab0b8e23df60c3e24bbfe49d6ffbdb8bb6fb6f3ef2918f5d5dbf1baf673deb5903903f22f3d62ffeb26fbd75f3faf71c1e1eec90f36bfbbed3aeebb46f970c437fa6b01863e19708ea0284306adb1dea033e4c703ea0a285c9c8e329e27882ba5aa54a8a6ad11d5755a0ae2a9c3ae2d0d1b673ba7641c670aec6571374d46ce70c96234a3138dbc89858b6d38e08e73d268e24a581db35b3d313401f3c86a7eb7b86f6841833d3a646c5d175cac95298c7aa98bb2d11fb4c4e09e732de0d382088a3769eda09d3e099548eca4150c15b1e4fbd13952b0c49ed9446a11665b756ce3535e62b8e3a65bf8d1cce035d4c78945970ec56811402a9f2e00def06c899a08e0bd584adba2238a545398cc2223b7a8460707748dcd12c89c70b06efe92aa5c6d80a2b7d3db723404730e0051a054f622f2ed9ed85868ae003a2ca71323e7392584ae06e5126c70b268b139481a4560ceab99ce46689b8ae873ea0b965d335846e4edd2ea8cd10b5f10e48644b0ca33edf49cd2478a622a8643465521a386c3b167d240c89454a444998e355666619d391b29416722baabdf1c45cf12ee046bdbb332111cba9fa5832698ecff201bc7a5f355b49af46b18bacba4a56c573f9369bb76a7b3720c9c8ba1586e374735e7d2ea19408ea2b976279d52fa71bf74a9ea5b7dbaf2d6586dcd3f72d5d1c30ef69dc045125da80534fed4ba0422213a5943c8215afced072f7d18b3c2ebfcb2d3dc7f1eeebb91936c90a3d850e913414c9958db23295f1ecde2192c9b934d18b73080e4ce9b27134144075c629135d15e78dd747e455cbfeca4cfdeafeefdb1c50b97ea70eeb3f38e0b0db12ad7fd3df2fec64f9d3ba4abfb3e20f2bdffa808644d029f1a4a6ed0b97b148ca8bb7123926e6cb8c58e2fa4259a60c9a58d273bdef69a8a943431d1c6290d228a1c468731a8de903431ee82d938944fa02ea2c1387448c2d69c8b408f34e91ec702ab443cfc9104b20c108a0ca198f507b61529512c7a015d17a8ebac278a4c18a7470e2d96d3c13c0f2409f12d32ab15d197b8dd044b094e987814a8df33b01dfd5586898d5616cb4ffbdd77845e039075b1b309b559cd9d9e281f335bffdd4117118682d60da5fb876d8fdd8d0db77bef5f137ffd8c3f7bce61ffde3ffede7e3fa9d793deb59cf1a80fc3b34dff5677e203cf9cc53f5e1c1e157b7ddf2bd5dbb78ecfab597dfd22e177e393f61880336fa0b5619fbea2b7c35c585aa24b18ca75c480112ce85d23e3cfebfd5c9a5bdc2dd7b2a41291ecad2ecab1ee72b827325096818c8d28e6940025a980421e1c66544d5a1b822ef186503a7d22d849c8d4a1ca16e702ed0f72d8a109a1a711e012a9de0c45006244786aca00e1f1a863494ce090f68c629c57f61466bc2320a124b539da5969c0672cee3c9789144149b661ea3750d2fc666edb8634399340e171c5e1ba66ec266edd8aa2b369da37182782179613bc00597099aa9549868a051871347af812134102664f5e421a18b2386e51286624c2ee57fc5f8dea722a1d13131682593231b9509131bd8688f999d7434755d58295f5adadbe3c8d2d72c2a65b63c623a2c4f635fcde5d2bf90331d038c32bc3ef568f448b4d273a12358b5b2a047a4c4f82a0411fc4ab863459ab51c633fbd2a8df7d484311e7725f14ba8aeccdf637cad166f444c058c78ad90c6a1f871912d3d278b24a408935ca468fafbeeafb9781a7261e4c4e96d4956cac517326ea7eab5e8f855cba9be093917df938d54a088bc621187948d14e38a061941fa2bce9a57dfd8c8ea602bdf42697f17dfe01a874f19f18e3069cad7f7a5efc29b112d7212235e12bb560cffd9055cf2eca496470e3ecdc2262c68f8d8d947396c26a490212e4b0803b904154b011fa6a31f259724ac24995cb43fa5f365885c6b13c994695d7a635660427405e24a4c6c3add56cbeb4c69fbbecd3aad283b7b1535b2e228feedd0c81f84303146f26aec26597d99530969ca8814efc5727e4252d87bdd6bd9b8b0cbd66683f42d072f5fa5bd7683737562ab111cc604c7f9bac253d2a71c9e644a2c57b41c60f84c9713ed60f8d160af787c825d15eeae02523beed980334d2625476d1ec5139c11eb8a3ebaa25ce376b4b12863e1a3a0de7321392a717c6680e32e1187ccb21d783909ff377beff263d996e7777d7ebfb5d6dee7151991effba8aa5b7dabaaabfa51dded76ab911bb08c2d0bdb2d192498c0843f00c620060c104202613c44ea913df000231062e007205b166d1a83dd6e57773dbade75eb56dd57e6cd8c8cd73967efb5d68fc16fed734ec4cd7bbb3ce3a2585228233223f779ecb5cffefd7edfd78b0c8f1691458c881a9dc22c568e12f4d10d14c671a48fc6d14cb155a2c44417b5f5e275777d4e1cc66295cd903db13d2a51957bc71dab59cff162c6e71fad385f17bef3ce2517676bd996faf9a1e4bff1b5ef7ce3dffed5affee27ff5b53ffae63fb9bd63dfaedb75bb6e1b90ff1facfffcbffd9daffce37ff8bffd3b1f3e7df2972e2ecf7febf2fc4cd7eb3579f422daac7a13111251e34e8311524f9aad08b1c3ac52f3e09c6102314434a69dd8da6a690d48dd971876fd665ec642a6609608c189cab5648a5534ce48aa4ea7aa95bc5d136af1e255941a7baa763e896d135a2fde8c5232255f3143988740a69273268892c4288cd04198cfc8e386eda6651b68605425c6485f5d5b20d688f1b552cd03f7bae0c840ad95711cd814f7d61f72463590662b5403a56c29e316cb793745d78bc2f74e4762b8f2c78981658cdce97a8e67894512826592c09d04afcc02afcd030f7a58a990054c95590cc46ec662b6247623a309c32633acd7d4b2a5e6cc3806866ce460940c453d89ba48a348341d86379995548d451d5898d155a133436b218bf230c1366642b9a2da86351b10a10b42a94616412d3188e792044d0c5539cd9195ce0802694a6fb6d2929cabdb800263cd5c96cc284a124f604f1a38ee9d9232afb00a4a1712512bc532a58a53820844a237c2e6054f684e6421248224b7296dd5a849c4a8982420b8c859f89829b962529a2fb3badee1901a252e16360534509b105771eb5744b030511175d74c580bba5653cfb3307b69616dd5f6626c5a2864b31050f18628e99c1e43821243f41044cbed5a1ad8d6ca6571d7b4b5c102a1d7888a329ad18f17fcc2e91f322058ecf8e62bbfc0b3902865e34dc3b45fda48dda6f3582b36ae29b138ddd2849ce174a87c7099c908afae22d669a3ab4d0868a35fe18e66d61a436fb2f6cdcaa1664c6c4238654f51fb97682a6e22225398e1cb1ace52eb41aab8a34ed5ea5e175215a93d6681d9ddbb3cfe577f93bb5f78cc72ee86030f9f3e61f3ad6ff3b9a73fe54887164aa8746ac43a12aa619628ea14c7482551d9e6ca668c544d9476feb4285d88dc15884b653613ee1f0df469a466a85da4d78ea815f5118bd3c7eaf40efbdb6acd15ab10581725d49e8ec093cbeca9e8a5f2ded586d9e8ff7f1161b4cca60a8f564a97227db45d682454621052546822f5fd9ca952cb888912cd43440b340a6dbb6588d075c2675f493cb8d3b15e6f399e57a4aef8fe071b7ef4c18621cbbfa57df8ed3ff39bbff6dfdcbb7bffaffd9dfff51f3cbbbd7bdfaedb75bb6e1b904fe1faebbff3b7ef5e5c5efe475ffbfdffeb577ff2f68f7efbe993f766ebab4be78b4f7cfad83541a97fafc1550b22ced1d7d8b9209ce2bf3771dc55f6748a762752f5a27e7763aa07c50640102c1ba58c8c25a1c1a5a9125c6029d3c4bc3805c9cc7334102117f3e4f04900ab6157de1429a82a9d289d38777fd6752c34a292b92a835bca8ab2c9233567fae09488216fe9744e97e66e25daf8f6562ba55474ca1c08ee5065b1a30b3da405a16454953ef500e4ac8c51a939b626c6c3db72f5fc0c1b0ddb1a626b94cb5d18a0e2b4a879148ebbc0832e702f45ee75c2ebc978d42bab3eb2986db833db70dc4516025d15e6d503c72ec59b9582b8f05895a46e955969f4219c667220e271ed8aed45b098301378631e18bac23d1de863f680c150a9d5d80e4629913e052c08c1fc32dd64b8dc56a40b2c1166565ababa37b995e61e25c6b654b6352041bd8953e3f34b634bc75ddb729781a366a33b09ba0b421047c222a0e6f6c21125893b3441c28a4fea0d7710a238252ae0e17e6e677c50a6cae1f742983226e4401aae10d42b3b0dadb8ab855a0bd54243415aa310947db4f514a2e80570d08046df7be83e8dcf6e0efb1d836c7d8a23211e5c48430e1435259426d6ae90ab355b68bf0e1510d3a6478240c12cb296c0b23ce7174f7f9ff2d39ea823df7af0264f55190fe2ed9852bf0da41a5a3375dc52243b4662c258e1f9a6f0c17aa498723e18366f88a01c0c219a4b6e9984e8930ea4356f1c4cf03fd246584b43ff9994e6dee9d9cf8884782f5e1a4a15774181417ce0a004543ba805a9827591fef547749fff0cd5368c21317ffc0a27b3c0e36f0f2c4e9f705646de1b8c8badb25048db81d36164837fe651bd60bfda1a97a563decd5897c2d3cb0df3a87ce564cec3ceada68f7b613983982a365650484008d51113f326b5aa3770d63e2fab99076416a366652ef09955e4c1bc673b1a4fd65bf2baa002a7eb91b7365b4ec781e365e40bf7e79cd50452dcdd3828aab56964845af7cdc794686fd5db1fd38006a5ef1348a01447056b6ec613228404275de2377ff12eaf3d5ef14fbf73caeafb2f787155b91c6bbcd8aeffd3cbf317ffde6ffca95f79fb27efbcff1fbff7fefbb788c8edba5db7ebb601f934ad1ffee0bb7ffedbdffcda9fffd10fbef3e73e78ef5dc671dc351d5e08f56872f169cd19c3751e22d10bfd462dd266aa1f42a0d6b22ba664c7d1b6894cbd2fa2a6c24ed95156266e70ae995832b938af1cdc8a121bf76584c636086e2e4aa5002354f500af129a3569a5d4d15397bb9e90022118312692813192288c6366cc825421c5393dee1e64a1b9bc04f1b033bcc9b2e296a1560dab032537aa8124429fe8bb259de069d114b77dd5d48a94196d268ed616322630d64ac923350f58d9b0cd996da94d631338cfc607eb911fca401298a9729ce0280a7d526621b04a81077de4b3cbc81b7dc7a314e86623e743e5b2444403abae63d145fa10016949dd1e5e67667453640290518aa95b6e9636a90ef04aa70895e5904908162295cc66308651e925d049a16a21682653d98e95d38d70ac89819181bccb1699b2334ab36256339631d085dead7d4be1cb0be14884be5c7057474e42a11323b45039159facd75ac8782361d52d4ed1e093590a3557cc46c40a46c24a464a41cc83f55c005e39e009ee151907d6b88726afeedea68429c0ae16eab8259782c41e627277ad0351b955db4ff76b6d85a262eaefb3b4c27a27cede6106b2c30464774d550f502cb9d1ea22680bf5334799848a5458c58efb7dcf89159612e85c2c030c243592cc1929dc2dcff8f9e7bf4fb12d0c1bbe71ffe778da04cd561b0270d81e9502a5a17bcd58622c7031544eb7856cc655ae6ec9ab8e164d45fe8468282f2152b530bd6bbec887c090dcf8f313a10fa7c2edf5257bfdd3f5a8f05dbfe934bb3674d90d58daf9f6e4f64c192f18d72f884b88f339ddc387d838ba4dad0d2cefad38395e32be78c6fff1d30bfef0d9964ce0c13c70b119f8c9d9c8664a3aaf95528db1562a81a3bee76acc3c5b6f597581df7aadf08b777b3ebb88ac8e221a8d7e66586c42f3e23a11a312c43faffc14d78647f8abdf54635d85cb625c6623176dd6e6813bfd8cc7abc28b6de5ed8b81f7b785b3adf1a2143e1c373cdb663e30e3c5d548298645f5e75c7c1020072e6ed6823e1de51454ddd0038c10126389acd723b90ecce79e726f29325f24beb884bbc7337ee9cd63de7a7fcd377ef8821fbc77c593f30f3ffffe07179fdf6cc7bf0f9cdcdecd6fd7edba5db70dc8a760fd177ffd77665ff8d297e5affd97ffd9bff1e107efffb9172f4e3153668b13424a988466e3e9fc754f27766dc01418e18272d9290a457c8a5e4bf62068553705ad19ab1555f5c958adbb09ea74435755aa4dc16e5e085a19c102b9421e0777d812763416cf8f0804ed88a68460a8b4c72b4608eece53cded79fbd8d1f53d2906b254f29019cb48884eed29d579017d3fa3d79e54bcfcee620fa9d10a26f1ab8596b5d1c4c8357b309d804e5c7c917d91522bd6a86b86ba201a69d3d34ab411697cf7d225a48b603d5632566ab35c1572cd8ce39aab32ee26c41f0c93356c73d7146111857b5de4d12cf138c1b2f35c92543aeef41d5f08335e8d1df3516163142a5759b8b4c04820a1cc291494ad05b615188d281024a221b1d2889642a895d44ab2c114b2b2b0c05215a5b0a9996299ab5279b28653ab7c663ee78a4ac4f51641836b39aab930ba6482147a33522b9a448d471d1c69a5e89ab954663404aa164fe556df5f792c8414daf4b5ed9ba06e49da744851022a4e79e9a2b16a6e63ae013a28780f7b8dc9e5aaa136cd3e6c6f495bdd75cb51b20c25a3668854cf7ec1081fad87af55cfb596d6744cbcf9ba13be036808cdf6b4397b4923d60b943193c70d264ae87bc224ac6ae3e8ea11e374e2fbe3b8183371a7b849246032922491480c1ab8333ce5cb1f7e83923b3612b193479c6a65b00135216ac23452c894b2a5ab050f252f88644c2ba30a1b53b6d9912da4baab1d93fdb34feb99e88d4d606ed3ebb40331b84d218d61d788315959ec9a881bf4b5e9efa70477d99fb7e93afd58bca47d064ad348ddc05ea87560cc5794e119e378c12cac98252112c9a92368268c1b4c8cb36de5c58703fff74f2ef9dad30d88727fd9b31e32cfae06720bb199286d867f2674c15dcdc652998f85af3dbbe4d938f2a7ee2ff8dc5da59a223522a614abaea32a1913a758aa486b0a0fb52082a81b682494719bb9180b5d85ae375649990765ae421717ccbb9e9f5e6c78be1938bd18797235f0412efc937ff12e7d147ee5e78e9815415360d1f9634ad1e67808aa2da033b82e2f84a6892a8622f4fd9c4e2270c5e5fa122d4b64392346787077c6fde39ecf3d5cf2eaddc43ffbce73fee11fbccfe5e53957eb6cb777f4db75bb6ed76d03f229590f1e3efec2fff0b7fee66f9f9fbff80fcfcece88dd926ebe8298d0d0bbb8b456f2b8a1d44250a7c514cb9844844ac9db16bed653701f7f6a813cb8eda9b6223d8f94bc25a41931c45658d59d83cd9e67eff480a8da10946677694dc3519d8e51f2d60b0811d4021a15b4f784633c5fa3d4917958d0a508a6a8411f3c00d0c4bc59c823db3c320bc9295bd10ba15e9514c02c53ab6b38409d5f5dbd3855f522b6d4c9ed487742e28991b52f566c4791518904a97e339e66845528a67e736612ddbadec663baeb8e6bafb5b8f0bf8c0d69aaadbe6c569bb53056633d549e0f036f5d8e442006a313611eb61ca5c4abe703af2e475e598c3c5e25ee76ca4a2ab144866e4e9841b711ac53c62e7045c12aac2acc905d4354a450b45572c5a855e9a217348887cc590d14139e8c1b7e723960244457d4e0057330751ad034f5af954af4664741185bd1e83fcf83e764c4e208412d855c2a221145c9636ecd9d8759123a24484bb97601b0a9e776a87a8276d0c02255428cecf8402d2aef656654de28eb2e8470c22510a5b6a0bd0a48f44c11d77a94d644888b6f54f6617a766043cd946f316562ec20a2f6a73f8688bfc7752ab2ebbe4b52703ae081c66a9a825be3f787c91082ba73df3211820516cd2e7890448771af9c22cfff881a138bf855be1e334f10448e0861490e50ca15369ca16644029d65a28e4834fad4a101c67168c0a7ebc14a758380800f16ac969d68d9ddbdbc5930554c6a9b9e8355f506a45684d81acb3d42b4b3e86d229f2a07288d68d3425482396255455bbafc4b5094eb60d74700956a3ef4a82121698e8ad1adcf4917978cb167ec0b4994cbadf2c14faf387ffb921fbe18b9181d8728b6a59a5176a89078806400152506a7ae5af5a150adc67b970343ae7cf1ce8c404006a5d6e09942c50836110a5d5324d315d13e63a717a52224512c28f31818a2db013b3a571094558a2c3be5d1bce3f545e0dd0be5c9d5968ecae58bc2b7bef594a74fd67cff4bf7f8f26756bc7a37f0e09e517241cc762611b55dc3636b36858214a516a31661de275065b31d9096ca1ea545454a2046e1e1ddc46ad931eb22cf4eaf78f27c0ddaf1ecf4ecf6a67ebb6ed7edba6d403e0d6bbbdebcf5d39fbcfd1f5cbc3843426271748f7e75c29847c6525cef414035b7a9ad225a19c48bdcd22c6975f2eecf3e6d53154248542be471f064ec185cdcdba68e1af42078ad8938db2d51453cb7a1b8f0b3e4ec93d05aa0189dccd19830734a4fa152c4a961520d55d9655a4c592256bc291af3066324d448a9ee9fafd1ed5a73114a4a583006ab0c79cdb05d2341e9658e144f1e179b84c35e2406c5751ce25ffb7bfbbe5a9143fa4ee38edb613513d4d11133a4ee05b16693439236472f9f7e278d4466ad29a98dba53a9e67a03abc59128ab14ab8c384d4c6a866144d7233fbcd8d0c773e6d1295bc77de4d12cf0a80f3c488a750bc2f19ce35e60a55cc8d6a7d42922c19ae0db0bf54898cc98bc88555853d88e421a8524c111aa928866283d51964436a43230a77ad123c6ba169ee6cc4536ee247f2e1daee5f0d46ca8a3bf3fb9fd6cd9f7504c5ed4538c109c1a584d3cb15bf69a052f4c8d3a09bf69617a5ef1b5b0395a6ecd8d82746798d0fe4d754f2d1439f06f6afaa990f602eb3a21278e8a51f7d49f83dd7228f16822fa2959b3519f0e04e8def44c136dcfd089b1df57cef5f0a8ee3057044633c652ddc6f5c6543f12da631a3309f4e2d7ea9be529f317ff9455baa4e65fe31bf78f385df6e494404662156a5ac19d848553ec5289c59895c211819926cea4621218cd08d983362b8145d21dd233692cf6ed98ecc4d3936df764af2d569ad52f7b3a26875fd3f1a6b3e2c7d2f6c6eced7d65c7e8ba71f9b6d047aed3bf0e7a93a809494b4a55727707f229dbf7dfa57ff80af2e015ac7349f97a5379ebfd733e7c76c955a91c2d132906665d6039ef4851e99232eb038b5962354fcc679118dc254ac511bd9f3e39e7c76f3fe371a7fcdcc98ce32e120ceae87aaa307d8eca8d069a0939bafef3a4dfe934b0883e0870eae2f41a0d156311e0b3abc4c35e79b14cdce91219e5bdcb2d671f9cf3bba7577cf3bb335e7bb4e04b6fdce5377f59f9ca1bc622a61df26b55a955a9a5b05e5f62a5d27733ac1846466324c6c4f19d13528c84a0cd10839d53df7c26bcf9da1dfe95afdce7fbef5d31a8dd3620b7eb76ddaedb06e4d3b27eeffffc47afd59adfccb5d2cf8f581cdd25ce97e4cb33cab8453510341025014244e88207bc8dade82d1a918668d45a5bd1ecc9cbb518258f44edd0107689cfd74687cd53ff50586a6d8a6f2d19dbcc88eaa25f0f280b04896099a8c610322399216f88128924bfa16ad809e7cdb207dbe50146a7b4e49c11852e7544d516e457184617b7470d0cc3164d91d29c6ffa9048b103f5c9fec46cf1d72ed70ad07ff935352ffb39ee4bab9dc6110790e0cd8f3b2a19c1d2ae68b546fcafe602f7622365dc90f39a5cfcfdb8aa95e78353bf827ac2fb2a058ebac83225524abc46627e25fc54227783f1d8843be61cee19c67d49f4b82572adc668239765e0c950b82cca639d714f8528cabdd0f3e62270359f63d2733aaea9e31a455806e7a98f54b656585b255443b681b9187394a80193d674206cac52d5e8d403279d4e63c470cd3c69aab40e0ad4c34d283ba12cd5dc2a480e7fdf5e3a0df7c6e64084de04d51c14b4e861e97fa833f898f3fb33ec91bd46415efabc76f93a9f7408995257649755d276cb6e93198e1e4c2e5386712203f3f5db84f7339667741cf1c752783a5b5125a144b6ab8764d972356ed8aaba8d751172295c8c851763e5a2c058216254532c248a2801cf845193d66cf8f9961b628fe9ed9be6ea13e5cac47662753e06c87037bf09816d0d1efbec1169f0a5dc80393e81a045d040d2193967b61a5dec7f79c9f0f443babb0fd1b4448a3fc75c0beb5279fc70c16f7cf53ef78e17ac66331edf5f319f05fa1498f791e53cb15824bace69a481e896df187ff8dd77f9dddffb1eaf8c036fde4bbb30d18fd810ef14fe9fb01dec3a92633b04891dcdd07054454320a872d427faa8c4945876896f3dbbe447e7175c96ca78b6e5fb97236fbfbfe6c71f5cf01bbf7cc257de38e1d57b7758f41d65989ea7b2dd1ac58c988c6285311bbd1aa98b686841a2d3f391c376d151d63b8bc4a28f0429b737f4db75bb6ed76d03f269599bcde604642612e8172bfad9d25da304e7d303e6d83f5a8353826260268128859c47c631377bc782d5b18592555452cbbf50442225bb564235ec5c7bae7b0c1d5a8cfa63ab06a20682ec1415540adbb2612cda6e866e4d99f3c60b8aa858f18c05354f7e2e217b232301b4238f5bca38528abbb794b1ee421273de300e1b474eba9e24422999cdc54050252d96d420587191e60bbd7500002000494441543bd363d4e282f8d608dcbce7dfcc59b64f2c0af685ecceda55ecda04d67682e47df16c2d99591aed48423b5675917b959edaf58ca1a796c1e7cae285582d8e98ac6b65bd2e3cdd54828ec410793b29df7e2ecc8055849324aca2324bca8314f9ca023ed7771ca7c822f924fac30c3f198498020f164a954aaa70047c56034f67c6a803cf2df33c1bd56dcce82cd0a33c8e917ba172558dd3a17289715785a364a490dc3618b828a35bfd8688966db3d16d5c732bd496d03dbda1263f7bd96fad803ba4ab1cfeabee529d77d106bb06742a93eacdf1f3ee9ccaee3cdbb507b4c3ca9aebf08bed8b4ab95e905d9be4ef640f87ae597ba7ae89cee5e611b6a775310d040e8e26d70b7f430925f0eae692eec57739d12d0fd70ff9f6ec3eef778fb9e8ef63c727589fc9b261889043e44a02ef0d1b7e74b1e1e9baf07ceb060cbd1a4594aac13109d346bfac3b1c48260181e9ae69d8d9ee4ad3fe48c5d49ac3d8cdd0c67de89d1cd4e422ecf245ac0d18ca0e2178d920c15e6aaeb5bb946b71eb5c85941cd548b1e99a709dc37c9578edb3c71c5ddee1cffcd27dfeca9fff3c0fee1eb398f5dc5976c4d8a8731a08415dc3a6812a9e59a3d52875a4da961f7c77417d77cbf97acb451496b3707d4f1c34c66637f6cfc1939f3e56aa995b6717df83a999174cfdb8b362f7cd5a17028f67c271104ea2f0701ef9707034edb2c287ebcc1f7efd09df7dfb949fffdc09bff90b8ff9f21bf758f491651f58ce94e57246c129a459035dec20b8b941ad387a1ef6eda7d9fe1c88ca6e9fc3ad04e476ddaedb75db807c6ad672befa17dbede6bbaaf2a57030b90f1a8831ba178d08552ab579fe475134089d28b56417834f61006db28ac61d642e21369b4a4135b5fbc54baaf3c3c25c5c907ea8fd2d63c64a863a30da160d89200b8a0a793b6025d3274fe9cec55a52b2318e9918b28b9cc5d19a3e2466ab3bf4291283a32a63298cb550ca48084b8228a5f8e4afaa707175c5b0d9b25d370ebb2634b93353699c753d486dfed8a2f6131a0f3908d33bfcfd6b5494a9b09c04c507f6b55363b22f385a91654a32453450a42748a48411b1660a80d390dc423463654bce6eb49aabf2e166e0e995070f0781a83e658e222ca3f2fabce3d559e26e977865d671bf8f680894d8f34adf731532a10ccc4b25612c222c7520ea969345406d49529fc68fd9a95673838544e6a1b010430d16aacc82f3e29d8e66e42ad4188951b09add14c17097ab52bd299cc6c353a6c6b5e9b6bca44b6c98c0ae9978191225d7f6a71e1c4b2704c16eba651d4cd3e51a4e72f054e4e58deb81939c20d77a867d9179a04591973ff3091f1069619f07cdee4e6f3f65c5ed1ce91a350aa1d2516441a78157f3538e4f9ff1fad58237e243fe203ce247f12edb079fa1ac12f76797acca8620ca50031f0e950fd623679bc2366782447a329bda4c921b4dce5f8b5e4389f61888ec3420de3954aa65d46a3b5fb60388aebd7a995a8ad6f449739f13b72a46852ceaf92d93b5f2cd6bf56312d745ac15cc6e9ca10afda26375ff0eddbd23720a945ac00a47abc4a39fbfcf9de5c09ff985bb7ce9b547ac8e4e582e02a9cbad8f997441ee3288062c06d414868c5638390a1c2d233fde66de073e374bd83c5ca756710370fbb87d7cf0195c2754b721a753786150d9ef875add5e5d5c21b588c6174e7a1ead7a4e07e374283c59677e221bea45e1f993913f387dc20fdfbee417de3ce597bf78975f7af308890913a18a7275b9c150fa93b937f625ef1048d9a1748774b9bd466a77dfb95db7eb76ddaedb06e4d3b1aed61769b93afacef9d98b2fe571c3385c11bb052974e4909c6284dbd7d6bca56864d44034b767adcd2a5635baae41fd86599a06c143c98c52b6a089d8cd3d3dba15be7b82f17463b37d1155ddc1a5b8e92f65d8422dac82539f0632a5aeb17100abccc28c4537a712a8921befde6d2c732e5e845a21e7812e048e16473c385ab0481d1294ab3173b9dd38ada84b44e0ecfcdcb9f129d2a9b20eae4b194b6953750fd2aacdb9ea70d26876d840ec492d7f5213324df8ae33d55ac4975ccf40d879eb4f9a86c9e5c6ca3e770508a89f1b694e4a35bb55ea94e01c2212022176048b102255c776fe6120926d6ce707d7e5544fe93ecb990f3699af2b2455963170a7212147b39ecf5d2cf8d22af280ca09702f282954d656598cc6bd98384a9579a3be5469fb462b2a7064c29dd6f0282d5d5d1df598f24cb4097677943d0e9ab41bc5d627172a07ce49ed5b954f9eadded42bcbc1d85dd4a6befc26c0e5da9e97fc2fae2b83aeef05b9d12cb54e669a044fba05bb718c6be5682bd62633286908c0f44013a2a3dc0012dabfab0829444a508c819361c3c9d573eeea3366fa0e2775c5d5f9db5ccee6dcbf239cd873ec6a0d257094e6acd2c07aa83bb38ac146b6395343a09fe14dbc28048f3f2976585cb66649b521ab80148c0252af2155724dfb711366929df3d6f45aab4c41917a108ac84bd1cc972196a8bb75955c19eb0862e83c12573d6352b278c39ea272f74ee2ce452005c36ca4962de39808519b8ec8c5f5a68eded944ed93d63c1b2cfbc0c951cf8fa33236130ad9c1707b22965dfbe9935fc2de91d0ae6d6c55dd89c8a7eb2a23bb3d52c575772721b08a9587bdf24aaf3cea84477de2c9baf0f6e5156fbff382f79e5cf0adb73ee47befdce7ab6fdee5f547c79cac7a6aed489db43c2747a47cd8a5d73a29d1bdfd31e24d52a9d0f7f3f07bdf7fb7ffad2fbcbabdbdb3dfaedb75bb6e1b90ff8fafffe56fffcdcbbff057feddff6ebe78f1dbe7e7678cdb2b6273a98a2151c6c16d1ccb40c99be6d0a26473dbc6dafe5d4509312178f3410b08140dd43a6265a48a60e62185227a9dd12dfbe1b4d5d26e348a154f1a2ea532e68168953b29d105e1ac54ce4b25e74a0889599a93a4635b8b0bb5636ac174d5e958402903dbcd2561de514ba06e07b2252444cecfd77c787e858872b298f3fadd63ee1c1d31e4914d15baa562cb259bcd86f3cdc09640164ffbae78dab071736a6ad7cada6a9f54ba1e36217f326a62adf1d98de165d23f680b85abcdef7f12e98f9e7958cace0d29496c054fa1d6bc9fdfab410c5e248a79f863751d909860c5d0da1cb8805c0ab916ae72e1c5507857b6041162b8e4ebcfceb89722ab183889caa31439ee84388b3c5807beb2e878bd6e59292c526011855968ae67144a1177c71208a1cd42c528c1a9214984500b5a2bb5154e9e441e0ef6daf58008f918f4edf02f45f6d3d53fa16a3b3893d70bb71dd2f191f337ed7e7dc9d3f868b1a872b8770e420f77d93bd7ffef216276ad93e190b172fd119b992fda6c716ff42cbb5f0f5a8135d64c73d502a90e3ccae7fc1217dc61c1b367e7bcaf91f98b0472c54ff20b2e3b2fee1fce3b86b19034304a6043224b2569416d6c0d9f5e13834fbaf4c9b63a482484d8a8496e433d8934c4748f42de44419ac5afd59602ce64e7ddd04b959d987d9ffdd2d0a483cbec65ab8ad3c78632306c2f19b62d07252a45955c0d29c6b01e393bbb62f3ec8ce7f70736059ebcfb3eb91cf1c5375ee5f868d52c7f83abee1acd6c2c23621044912084e0993fc5e06230360dad3ddcdfbbe60a0e54f41fd3c8b26f48f79a27f14f3533ea443f6b466bb534e4281845c4833bb512add0091c47e3953ef0e632f2ee1abe7e6a74d1381f479ebf77ce3f3addf29d1f5cf0a5cf5ef06b3fff90375e59b15a74ee486785d08609a59949ec69a9d31e3f406caa315baebabff3dfffad2f02dfb8bdb3dfaedb75bb6e1b904fc1fa077ff77ffcbb5ffdd3bff5f780bf5cc62d22866af41b5df540369d2c32312c8f7e130fee6835c1f28afba36a7161b76a602c995a46527227939247241831e8348ae57a7d3689615d2b122614a38c945a5b4275601113619e88b5f0e26a4335710bd65ac814aa55a75ba9eeb42755855a4a73778171d87255afc86b615de1e9f996a7171b7285edf11dee2de76850d6eb0d174361a8eea53f431855590f99cd583c6b4164df54dd7013ba26ac37dbe54ad841e0995c6b348c976b485a6120ada2982813ed66ac07ba0169ae4cba3f1a432d8e5a54cfc308a1234477d5112b2ed2afb515196e191bd4511e1d3ccbc285ef11137776aaeaaf39a61554c86520972da56632462eb0298567ebb1597dc22c28bd3a62b17aff8257668987c13849ca2b8bc49b471d9f9d25ee24f5c6562329467a15660abd1aa14dbd85ca5c03814228135529b422c9f76398f4033785d9f2723a0acd4677a701a87b40e47a497f50d0b580b51dca75b09fad7e4c9763f2529c627774956bdde87524e4a3427339e87dec5040ffb29768d70fb80f5074b4cc51b4c363d8aeecab14061990aaf4d62156c94128a1725204a91ba20d9421504be445d9f0245fa241192c306c2bcbe02e48cf8600dd9c590f41aa27c6e3d6c8bbc6bdee3b11af8b5dfb154372fb39ab54dc75edda39bed13b3a8bcc76ce59583da0a91d5a5f4f35b91c041fcafe0dfeb88ed4845a8d92074a1e9a0946bb4e4ca843a60e2357e757e4a797dc1b078e16c27af31ebfffad351797f739be73c2d1eaa8b90a8248c1cca9aeb95c6116e9e344fb14c6025783f12c17ae469bccceae9dfb9dcdb77cccc063d2d3d8a4096a89e6d2686e402edeb405f5bfdfeddb0681d4e64fa60812cc8d23cc886a1ccf60d6c19dc58c9f5b47de3adbf2a38b2deb1aa81f6ef9674fdfe17b6f3de72b3f778f5ffdca7d7ef98b271c2f3d2b69cc85204a08fa520dc82e8eb335e28bc5aadeded16fd7edba5db70dc8a768ddbbffcaffb35e6ffff2308e949209929a039682b9d30982a73a9742a995d4759452f771090d054021a9bb4a9daf3382309b2d98cd179c9d9f91f316a12384f8d231b4aaee0a22d5e002ef162e87281b116208cc1673ee85c0588d17976b4ad950a2b5a9b71c14fdd539ec48b38c0a6cb785f321933ac15458e74a1d3db73784c0dd3b474808fcf4f90b5e9c9d79f60742146311fde638b4a624f43362d761264d201b3e66566e4daf6137068ffbd75eab575b7517d238d5137aa002f5626ba25f4d9488da7224ae1515515dc7534109040b94e0e54290e0191e387a202648f5f75e82a244e7a03305e8790e8a111be3a442f1c223a812bb9eae74e4dc93cd39e22678764bcb52d99481f59877459e6e067e244214cf783cee42cb19e8b9df47eef68987cb9e47abc0fd4eb81ffd6b2e9e905ecd2ffad4a6b4cd13d791a136bffd99dca6ccaeff9e5c4721ece668d90ef6d7e1efcb0d65c9b5c2f57a3b699f187bd7e032d5033faaebb89989eda949bb66c176597b1fdbdaec3ae2d2f442b6939eece837c5f368aef1eddbf1b3c116e8cd830b8b0a2f14d6083309dc5545351307e3b4c05b9b81773723db5ca94509444e161da7ebcceffd64e4b53b91cfdd491c77c2422a3313fa896a585baf6deeac575b91ec5aae26b86ef6d366a5bd0df550f470edbcb9aeacee26fd531ab78a7fce9566a7bd9f8afc0cd4a5838710532289a08914cd05e8286a8274ced7ccc59041b8375f72d427de79f78aefbf3db29abb764483dbdd229308bf80e546176bb92752d11049a95127ab115b48e2a17cfe6795657bbf3a15f310e440ef8191ad52ab11c23e0452d9eb728a3912bd51a1579dcc919d46a7851999c71dacbac89d4e79b4e82955b8182adf3abbe49d779ff3d67ba77cefbd17f4fd17f9952f9eb83b9a2869ea8226cdc7ce20c07676e6aafedea8dc2ad16fd7edba5db70dc8a76a7dfe4bbf707efae2c317dba71f1e0feb0b7491d09048dd8c9807b44250239882052425423fe772bd26e7cc58aa3b5e05dbcddcba1898a5e4c18122f47d47b7e918b717ceb76e96abb5e51608fb24672bb6a3f7d0265e31f4c4181854b81277ca49219062a40b812281d82544949c5d03516b75dd427098de2d7c9dce3396caf920486ac2784644847b7756bcf1e811bd2a1fd617e4b1d2b52c8ecd30709e0b71bea0ef22b982a60e95e87927b8eb1307f6c166b69faa1ea22134bad90d04c48ba903f6f6e425ab7b0bd93dc542ae212c7bfacdc4e5d696ab026a014814b56628203b8d8ed238de0a46702a8a2a561d6e292160a109835b912214346c2965cbc0e0e7347add968884d87bd643195d104e66d85e6235b7e6c727d205633458e7cc591e79e76ae49bcfd72455e6c9293baf1df51cc7c0bda4bcd6471ef581a3087792f220051ecc84b9ba98358a505ac19464aa946a93c43852654d7c7d58a44d316dd2d4cdb5ca3e1ddbac4dcbd939ee98ed883faddc6aa912f5a0906f0da5c9f54ec6263a8cda7581adb90dae5573040ad94dfea7e1fb44af7318cb76a2ede9f0660750c9351e13d75c8077c882ed519ba9b8ab5ad11ba8e4744c15a19748d040b6c4a5144e6ba050998931d742a1704fe0a48f2ce292d53cb0c915198c52158d81a717033f1c06bef35c79b8eab83f173e7f27f0b985703fc13c08d50aa3b9ddb10a8c55189b09865aa6e48d37e035bbae89d228536df6dfb27676537b63a7f1a01a625bb435d0a566ac0a426cba9a76fa1a0a223bf4436e34adecde971422d6a8a88a2059b16ce822107b254a6476b4607174c489553a59d2c5c257bf9479f5d15d1edc5df83e933ae1cded9a2ea4988084b6f3945260318b1ccd227715569de776881cb6a90774bd9fa91391e923d81110716a19400c8e4484e6e03669f5142355c8d51a9d33904d18cdf76637212402f3247c2e455e5b1843a97cb8cec4b020bd10fef99373bef7e3537efae4922fbcbe246a652cc21261216987e8baa946dde546755d609e1273faf0f4fd771f027f7c7b47bf5db7eb76dd36209f925572fe9f67b3e55f0de1f99f1dd697c43027750b5423433ea30c1bee74f0f8a82324c871c6868e9a07cec5f03252a9656c81555ee4cf67330fc3ab15a9952e45ae44bc29a8b482b715d22258a9d4623b8ebae0b4276268c7eb4929123d869ced382212e9670b4c03aadef0a818b9e406d74f5c621737f77d241a0c63668dd2c78e4e1431d7133c3c3e61315b106be568bee0c5f91539bb9df046148d893bb3053302391b2d7e99bab32ddd37049346235f9b8aefe08e9d50bc8aa71d7b30ddf44b7b14e4daa01bd92563fb045777a8ca445d3914edee8b0b2f02740a353c4c85b6e6aad49e83c824e8f61b3d5333235373d31e3da4d63096566418952db5b4423e86d6fd38a29258a0569d3e53c5e92acdc90bcb94b2258f0363a9500a6783709ee1dd7526e7ec0854881c25611903f7fbc41bcbc89b473daf2e12f766917b51b91360269e1b93b590cd5c735f942eb449f8e426a610ccd0421337070f2754a5883637a2a6b5c903d4ec857a480ded9276aef72656627888e63840082d84733a0de2f5a5ba6141b1d2421005b191320cde7cc4991fb7b8f8df031275cf839fac7ce5c02dee46fc03d76ae683ac1d9b66d4b5d1910e50b3e68e35eddd6b544211027e2dd28afa88b068c8580f4801adc2a242170b0f8e225fea8e3c1f281b2f86cabbdbc24f2f32cfb695b7cf06fef8c3355d0afcdc71cfe79789cf2c2b5f38891cf74669c1a635172e2cb08e8198465239a31620f444ed4022a5e403f94245088e26d0d842a66e8a91b794cd73189ed1754a9c2db8b838e7325764b622cd56c46e8e84e497a9b484cd1df5510fdee00a14540c6b4d51296b84399695c120472078c8659acde81611bb82d4cdf9ca6b277c75d1d1f73df3c5c251c6a9196c8dac7f1fb0aad79cd2a2c2222a2704962ae88101819f5b3db0e9fe184ca435562a0db16826119189ede91a8cd89a0fd1bdebad34d7bf1884b904dfb7e289f3e59acf7a2434baae0a908c128d45482cba84099c8d46ed23efbd77c6d7beeda8cabbcfb6cc671d5f7aed98cf3c5a727cd4a3e2689787ddc2ddd58c7bc72b9e9c6a7cfacedb6f00bf7b7b47bf5db7eb76dd36209f92f5b77ee7bffec15ffcabfffedf7ef1fcd99fbdbcb8a0e491908c9c07aeae2e0879cb7cb6e0f585b295c2e9b8e66adc421e0921a0b5d9c196421f235d9708c1e1736dd4a9187d6a1a82537b34a80b6ba515eab5e57f9817fbaa4d78dc12c75d0762f44d97b0dd666a710421868eaa4aad953c0e8d1ae6055408ba0b888b1298755e308610e862c052e750bf088b5a291278ffec823e083526c262c1d530104489b39e941235f5ae390960121053426cf40fa629a24071fbe27dbb30a10e5eeceb649d0afbfc889d3b58e030c840dad0db6c1f96e7cd5540b5eee946f651fe4dc5a86a7b2d831c16974dd4ddea1a6d5f7bba586dc8c18138f9603a1e2482066acdae090ad1431ecb001a18d92333417b62730332b566955b08cd72d4ac508327a29752dc7da75fb1cd2317e3d084f2b99d4b21aab28cc27117b9d7471ecd3b3e334fbcb1e8f8ecace3f14c394e5ea8a90acb240435ac8c9c8f850198c5c032263438e5c55428b15253215471d4af1582a5210721f8e4772a6eebceb6b751ed4a210f23a5428ca951a95af13535abda4a436b8da14a0b8e2c882841c5cd17c6dcde67d7cda0cdf50add35921c20243271e4a51e30886ca7e2a0255eabbaa572c0fc4fbb6e74ab4cd9107b5abda8e30736e57190990149746f936bd0998bd9b14cacc68a8046c13ae3682edccf1d8f978179a77cfde9259bed8864b8d8147eff7ce4774be52b0f66fceaab0be6b3c4c576e4bd175bfa85b0992fb83bcb3cf9f05d2ed61f405cd02d5644d952b750f2d834188518630ba86f14430dd492d95c9db23d7f82960b56f796589ef3e13b1f70bed912672b56c78f59dd7b8dd01da3d2216186895276b4376d8dc25ed355f29671b864bb7941c903b3749714e76ca332860a3513b237fbc52a67c3866d292c173356c70b44a25b46b7cf04e1c0e9cb2a36358b68fbce9b44c5e8dab99cd4182615aa5c8b8b99c25e5fde8178469204250681208406e759337f882a2d2075dfffeed11f25b5cf0da7e2d2f4237b5bf2891e3a65cc08913e1a0fc4f8c5fb0beece16bcb3def0bd3f7ec23ffff6fb6c86c23ba70331295f7cf5983ffd9587fcfa971ff1f8fe8cc54c59ce952ec272d17167d5b379e77cfbe31fffe00f6eefe6b7eb76ddaedb06e453b652eabf99fafe5db9bc7cd503dc2ac3b8a53424216763bb352ec7818bedc8655186d1290d3128637163c6183b52d7fb0d5161d9250c25d74aae95d8cd506dee4b3b9ad4de367682ff4308bb9069112f847236ae3683176378e85841282650a194e2c8474311442084484cb1251c1786d26851a22091abdcb22fcc138adf3f7dc1d3f33352f000c4b11a1612a1eb48aa945c596f36e496deec4fae782dd8909f29af23a8ee4215afd5ed3a25a1e90d47a68fea3f3898b34e36c5f5208c2d04c0e235f1b31d1c0f919d26e2e344d887992166509a9cb552f7f423938faa16267a8a1879183031ba6e8e764ac99ec3a1c153cb757211d249066c9e2550b575560531a10b5d7330dbd2771df3c58aed76838ec3ae04b39ad9d6ca50605de0d9003fbe1849bae1282a275de25e1f79d045ee47b8db071e2d139f5d757c7611e9c538cd854ce095a5272e6bad9854b2546a70dd4b90d1ddcd4c5c621b6845a236794771e255757dcf44421f860ddb626837a75209d9882121c1f529458d48435e14aa363d758c549921ea31ee1220ce663b8e7e4b67000b6e4f7a781eece3851f07f9e1be4f1a92a50d790bdcd4e4b78c99b61f4b9bc207f346e5d062618ae338c824278ab4b0d18a8cc5297f28925c27324f81650cacbac8a345cf07571e0a3a8c996f5e5df0fdf381f36a3cabca605b7e7ab6e19db30dafdfcdfcfa1b73eeaa502f4e79fee4055523f3c592ae9fb31d0be3b0a1e411ab050df11a75cedd940a65dc320c1b6601d29d156c22c3e533d69703e1f239b63d27af4f09dd11a13b62be7c4c9c1f1362c0c4cd37ac8686dc19a6959a07c661ed086c8ca4be27761d43f06c8e529c0658815a8db1b845f8340ff0f9815d5370ec72f63ec6aec0aa1de4637c82f0c75e3a9738403ff709f2aad21ef750d4cec76bef39f034e0b029d9eba03eeef90bc22cc02b8b4830b8ba5c63676b9e5d6ed90c70b5ad4850be7bf58c9fbc77c1d7bf7fcaaf7ff901bffee5fbbcf9da12164eaf952e309b75e8acbb15a1dfaedb75bb6e1b904fdbfabbffd3dff847bff1affd9b7f10bbf46ab601ad036e24e4c5fb59ae3c1f845c22e763616b0143c8758ba1a4d4efc2ff8a1921c466a1ebc9bdebedc898fdef5563bb8196c6736fc9c7daf211a609db81ab4dd0d8f2275a5096b24b2ef6c974a5b62967e331ed900f55d798d40a431ec963f149dd585b9099edd3c06de2602b41b539ac04e25010116a2de40aa1eb0931613553f216354831ed351b345a9908520f26e4324dbae51a8ddc0e722bec865be6d45cd80d5dc88efbdfbc31ed20576557789a5d6b463e5a05c875c7a483e773d8a0d84d8e4ffbd1ad8ebd61ad154a5524f66832422d20b8281d73c72df6afc91044232124e7e787ce85b80d4d8b212018c53c50d08b6ec5f200b53a1d28764e9baa99abb2e16a3bf2643336c4003a812e28275de09545cfebcbc4833eb29a251ecc03db20149493166e2866f46acc708466a84ee1aa383d4b35789166b8f5ef3072350c8cb9d0f51dfd6c86750bb483b156d697e7040b1caf56044d5e68065c3c5d3cc0ce85cf4e55b31af7144409a414bd4929b5595cfbdeb71ba6467a2d197ddfc4da4e17643b0a9f89db2bd7037ace44899cce77c5afe3dccc1374aa9ecd51968fcbc690d680689b76975219878a59a0ab91be736a5c54a19f2b0f6781cdd8733966debfdc906d206b0555bef3c1153f39db723a142eb331e42bbe7874468889edfa94cde6cc3381d6cf499d1b26a4c07e026f90827f9ecc7b7fece52c70bcea19c7c4f9f9962e0ce43c308bb8ad6d1dd95e3d67bb3e7774b55bb23a7e9dc5f12b84c50ae957689863d2353380e06f5be848b31372ced4ab1926906b216fb7581e902eeeed6d0fe86e3b67dc1de56d7a939be1047b9d911d5a7b4d830ebb69effdf10da81d50eae4a6156fa31aee9ed7646ad1a86072c355eda61fdc27c5eb88bd74eed172658ca0ee5478b9ce0c83b0949e57161d6f2c13b33e90c9bc7576c13fffa377f9eedbcff9e3b79ef3afffca237ef50b77a80afdace7d1ab77c29ffeadbff417fefedffbdfbf757b37bf5db7eb76dd36209fb295c7ed7f1244feec308eabda8f84aea39b2fb1ed9aa11a6759e8e21ce92251023517c2584094107b4af69bf9502231268a6b42a9c5288d76e48e4eb24bf89e2c1f4d0edd679c2f5c0f84dcd5bc582b4d446ed513b94bf5af9de05bf7c79f8aae9c4776b34493bd539538f5479bf3948aee0a8149c82d2d18ac14cf3129563df324449f12b75c8da9d93974ce71c71ea5c656b0b6aac1825d9b5ede8427e4c0877f3ae60ee138b0389a420ef7ff5d3e5a5cc0b56cbd9b13483e6a16743d77e45aa1f2d14aa75ac1eae876b938673103af6300002000494441543ee7ecae3c2d1c2d88b4e4697f2e55fc9cd552da0c1dcfed08ea990e96e952f240cc6160d86e3d8d39ce9010a9da7b03d2dccd4c0c8d8a14c1ca08b5780065853540a97c3814deba1ce89f29f3a82c52e4e1a2e77347735e5fcc78dc274ebac8fd79c72b4781474be5ce2c10d405b58691547113d4c9e23831e2c2e8122a35f4107a2404440a32aed1a068136dfbb32d8855ca81be67df06b806c74cfc7db1c309b6edf27164efa5bbb3301039d82fa6de36486b1ab861e98bec9ad86afbe6f850ac6edcc8af119a418210ff8482d7bde6846c6e083196422d9e1d841ac4468da4828d6828f46274a2941a5884196763cf379eac495578b59b1317c2e379a06e37fcf8f9395b2b7cf98d636217c08ca365c7bc0bccfb448cfe19914b65b98844155eb937e76815b8bb4adcbbd371755579fb9d73de79e78ca7675b96b3054f2f069e9ead39bd1cd88e6b4a31f2b881b265b87a82ce56a4c55dbae57dbaf91d425c21b1c71a0d91188969cea0b19905344473fa9ad027d957e572c06b94c3a0d25a274e13b2c324af5fa89315b3a3aef209666ff6918c90c3cbdbaee59ed00612e23a1a3ba08ebeacb91079e9710fbb0fbb11b479f8e0b50d6a32c6b3a1b0d18ed74f16bc1a662c6247ec035779cb52033f3e3be3a71f5ef28fcfb6bcf3dec5ffcbde9bc5cc9665797dbfb5f63e43447cd31df2e654595955993536d574374dd3400bdb2dcbd8b2110281c046b2845f2c214b4846c80f084b6e643546201933497e30b26559163658c692b16c61370f40ab71d37355774e9d5939dfe9bbdf14c3397befe587bdcf8913716f55b72d61122976e966ddfb0d11678a73d67fadffc0db5fbbc52b2f9d7079a334551dee3effd2c5e1297e588775580700f22fe06a8f6e7d6bbd595fb35c1da5d0e3aa166d8f722e48ecb836f009d6c958c78e2e04708eca37c53529a7f7869058498f0d3a85c2574e2927e60e9d7a295db66caea4db446fb2256d088194b25de8f04017d522121e1ef04648d9f54827f90883603a0bd0d3486d12913c852909d29380dfdc8d669b8a2885922065db422cba94aa061c16026a86d7d2d99fba5795ff57e7c6b8391d0a702bc5e14e627ade6799ea42d83a5d0daf6fc53d6aa7a89874299f551c9858c940e0d919d97bbf67f68cc0b2316062f7f72d25528a78cdc185b1bba14f91de295e94dab525cf45c62236a644b2583abc42d23816bf29ac518bb46d4d55d7acd62b2c194e3daa35229ee441922262245b21449cabd0ca637d9d45c6318054983699b8947a42b966af83a19b9e8f6e3a7eedf10dad57e6deb1709edbb39a578ee7bc76eb882f9d1ef1fcbc61517b16b5e3b472545e509fe97f8650d70d4dd38ee26d13e893e1493885aa6da8b4a6f12e03a318e9355b8c9a789ca63251b0a2a129819e43319a2c67dbc49445e04e73d27d04f1ba1bad28f2d4b9da3a6449e1e1db489791c96fcb68bbbabd26b450e4b4008fa7cbd9a7a71f52baf95280c8e0062566d04792087dcaa0d4792390b2105f22f32af15c03cdb127a5864550be5835dc6e6ada0a36d2f3d6cd8a4fa2f1dbbfff397ef4875ee6f46481e2386a7dfebcba4c09158cae0fccda0cfeef9c3534b54781ae8f5c2f035f7ae90e4f1e5e71ffe19ac7cbc483cb35ef7d7acebb9f5ef3e9e3354f6e36ac36916e7345d7add0d513fcf539f5ec3e557b4233bb4d7b7417df9ce0a42299a3172b626dc1fb8aaaaed98810539a64934871ebdade7ca6f78f2193c38ab5c5987f31aabfb753072dae07a38deed4f6ccac4c6175326d9986c99420c649a363a460a9156fb7726da83c1346c8d842f81e1310d9fda5a915b989c79cd26b6249e474def2e5e7ced0558f858e9a8aa3a6e6484e3812e5c82dd998b17eb4e1a77ee623ead9036ea4a53e096ef577ff87f7017eea97be7d6bb35ad5bff7477ee8d3c353fdb00eebb00e00e45f80f5d37fff7f4adff8c1dffd979dba9f4ca1037188385c3b4382e326e5e4f32e44ba6e4334f055eef852a60fa62e779f371b2ca65c80abcbf4a9c2839652b0ebb4b69d3c986462639b52d1890c25534a881a12a550be06ea919186022be522a9f239093bc6488cf9e19d85bcb6df14de16f250baf5e57fbad56938a763b4432aae5a5a1ecc967200a2b9ec3d93c61ad076021777b21598828694dd7ed224df41b63dee44a692a5d219b54285993ee4b7f4af294566b07c4d4f35209fdd2cb5a7ff3e2d6cf7d2de453ce22229f4103784b0215a4293d2e1a86a876835ba40e55c871cf020642a4e2eb55276cf498144407c4b1088c9f05a65717b49799754340c257721e723e47c96a042d41c6827c59967a0d3e12a2acb9397947afad8d3c5c0652f085d2e9a2fe0171f5d72f671cd73b386bb6dcb595bf3dcbce6a5a3862f1c37bc7cd470da56cc9c6351798ebcd2147bd068d941289258a748408811d6a12758ced1880a38c13bc1e3a82c664d534ad9464a1c955284bf60518896033c4520f6b1a445d79893ad85f5fed8cb26a7cab6a2e4ac03d611b42ab28b3587afab5291ed8d2d250685824c26274cc1f5f47d4b715c89162306c14721f58955cce7c0b782f78c45af9a717ba12c1aa15f19b3b3866ed1408a5ca59e8fba8e27a1e785174ef97d3ff632bfe5fb5ee6f8f4945935c3919d931875f99966e948f958a92052d36d8c47976b2a0247c709891d46e03479be5a2ff8c1e511f72f367cf070c35b1f5cf2ce47977c7abee466d5d387750edbdc5c82dca7aa67cc16cfb138b9c76c7e0bdf1ce359a3a4ecf8e4b3e5f0182af98c80c86d6d9ef6ec72a77383b407fc26f07137b89ca703636cd2946147c725c3991b27be8c4d996c9a908a09c8361c7207541813e0f45de1c7f8b356b4643ba19aaa04814e2341224dad348df1e8ea9abe5b73c29c59bbe056e5698f8f79a199b34e89079b8e8fd7373c7ab4e4a3d515bd5f568f9fdcfcafbff3477ff7bff44b3ffd8fbffe852f7fa505fecbbff997ffb2ffe37ff24f86c3d3fdb00eebb00e00e433bebef573fff0cfbffe8ddff6937ddf612668d510bd27881163a6a298ab706d85c350e73020763d31845dca942552c8740bd0c228c8c58793ec38341434363c208ba529830b8c6e3b7f3279805bd1748c4dbd499ec120ba0e21a16ee8ece9166058a60069b69dda29da477a4b011e32094cc874b2fcef9c630216f344235944074bde1278660cdb62ec12196c94644829046d986e4c03d06c1b3837fc7102294d5fc78ab85bd9a571ed4e34a669f3b6d789dcf9b9711c643badcb1dbdcab4172e39713c6e7a520cd495a36ee7c498586f7a7a0b8845c41cb1e82ab2d359b674b518886983a9435c85ab2a9cabc17b369b357d2862e242eab7e21235588c8a5524cb9497c1902039c11c0801c23217cf06aa3eeb385ca67d38ad506971a2448c983afad071b1eeb8dc747c74bdc46ba6d1b54e39693ccf2f5a5e3c99716fdef05ceb79f1a8e58b272d5f386e39f69a3d8a4470de11c5f324186f3fbee283272b8209ea8aedb27734ce71abf19cd55059224423a44cf9bb3b6bf8dce99c933a3b2379e733bdb0e48b0cd91883ffaf886dc3ae07e051688ed3e4f492f491b5493b530fd971511bbaeba245a0ef5cc9c3903cd9e4d9317d668c9d7b11c19b503e844884508aedeb7564b54ab433c7ad85a3f655de952a811857371b9caf79a1a9d884127cd828cf054768145f29bef6ccdb19ad9f6550a4d90e3a58849893598c1c98d9235402548a368a1adcac37bc75ff9cfb0faf38399af1d5db67bcf6f2297d14ceaf13efdd5ff2d687977cf8e09afb8f577cf460c9870f6f7872d511e29ad02d899b1bfae543d6ed09cde2169d199bd513ba4d4be83ac69bd46482603bf7b361fc9927c15bf59631a545e509886c732101a7f97e203288be77cfca74722a7c0faad41894be05a322a984126ad16a3d43895eae39f90d3a1be3b567b20ba286693086d3c8bccef4bc3e46566143481b6aab30029554d4ced378c7321ab379cbbda6e2a3a5d0c7359f761de79f7e3c5b5e5dfed47ff5d7ffea2fdd79fededffaf7fefd3ff1851391cfffedbff8977eeee7df7ef7facffd8dbf72082a3cacc33aac0300f92c2f83ff0cf88f2c05b08a103305c48a66c2395f98f039853886ec62932ca05a6d3bdce28a80d950755811719b2592148bd3f2001c04e5a37dbc65ca898a92d4b629dfeccdf3b7f2cc0975283f8c534aa32e244f076cdb492c0167390c6e5b7c8b94023d5ab1c42dddc8c1c35eb3a83ccb7425d3c42ca26e4bc34a21e45279d8d75200e8a059b0c15d4a47f7ac6932ba4da2b77347f2e90ee480329ef9f5678090c13674326f2ac0871d1ada4ee1339da04c352493536029904247b2c8e9bce1f3cf3fc7fc78c1070f1ef1e9fd27c414092914f7abace3c9ba90dc35ef6347eabbdc257735be3da2a9e7588a747d4f4801758336a758348bc724d37992fa0c6c06eb65146739c44f4d510904ba9ce66c3d411238c19c505b4dc32c4f9630bab4a1674d4c9b9c5fe33c419555bfe1baef79bcdef0fed512ffd0d1a8e60c86b6e20ba70bbe76f798cf1fcfb8dd54dc9ed5dc5dd42caa8a6f3f5ef2777ef5037ee5c1052a42ab795a282ab45e78e5b8e5b5e38a639705db9b08d701ce662d3ff6f97b7ce3de29f3ca0fa3a3fcc72992649b7383942ef8f6fc8a4c4eece41ac9d7fa6e31fa948078c893182c535527456c7ecf0196ebd3b5ecf897dc4c900218f3f9d7a8790ad5f75cc58eab8d82b5dc5e3892565c87ec8a5779a1153872b0f01527a6b0366a367c78bee6ad8f57bcfe758f49431f1caecef7a7983c2956a418b2f9410c458c0e3887494fd7afe9ba8eb6514e8e6a9e3c716899b656bea2691db38572eb74c6ab2f2c787cb9e6fee325ef7e74c3afbd77ceaf7f7cc9c38b0d97373d9b7ec5cdcd86e5f21c7f751f53c5e286d8df8114b3d6a51863d8946fb96322600307b3648e149aa53ce3e787cc9e81e2a94a853d1b20b01dbb3e6b4821d386c4e4c44d489f39df4426af2d7baf60df5b80be7dcda7a97b526ca03d81a32af1f2c271832374915567390cb4f56042e8032e29b52855addc52651d2acce6e0677c453d1f5f2d79e7f2f1fce3ab8bdf717efef8871f7ef2e90fbbebabfff69b5ffbda4fbcf08d6ffc04707e78ba1fd6611dd601807c869773ee7f31e34f25f083fe215b83ba1c3298860e7f2e2853c87d4defea1c3e1713667d293eca03a8b8fc483244e24ed77d582925628c80e6ce58a157c9b44a9a3cc3d228ca1e484adb86e2987261d926554b1776b7b41ee85a6c81522c85b2801671fb902792692b39bc6e803203bd2473adcba376e2799913d8f39b24376c5f2ae0a874a45576a71ea3e07c2b841765e2673479b08f549a3d5ba47192c416740d5842b646fe5bfa46e672a7b8cd94d8dae13c0dfb86236c3192fa8e4a8417cfcef8ea0bcf7343e4c3fb9956a56e083d2c36a4295bd79a2921f6a414a8bc602674b1c3a7805a62b35911fa3ebbaaa590c10719e8b971101072185d716a7208be80bc21e8d1a4457d436529db0a6b217ca58059a26795c5ebaa88532a9d23c161b1a7696754be62b9bca2dbac7226b509a14bac2c700e7c7ab3e6bd8b253ffbc9134e9a8ad3a6e2f9c58c2f9e2df8dc51cbbb174b7ee6e3733ebc5ab2f09e5b554d9379555c6862917a5eab5a4e1aa84a2afc079df1f672c9ac526ecf1bbe70b628b4a754ccb21c6928544be0dc98cf309c2579da327987b293f239f7397f6e52e85af9ec59b99e0b6d862db83761c715692a2dc8034447b448172309cd96d62aa865a034b31c5eb8c0d10563b30aacd5316b6a9a3ccae2d40bb5387c102c7acc6a7c80be5fd2ab727c3463d634403684105d61aca85c4be33c96244f6c3542ec710a4e32cdcfabd25635676dc5d73f7787e79b869bb531abe6046ba8501aafb44789e3d671f7d873efc4f3b9db0d5f7db9e58387a7bcf7e992373eb8e6dd4faeb9b8eee8fb48e8af4929e766e4c1a0915da6f3f535709106f0566e8953345fce69496219335806cd512a018bdba947a5d0a85069062cd310d7810a37e4958442db1ca62589814a27e5de6483d1f3983abedff6d91a550ce607361d883c7bbab27fe7b04913c4226a81132fbcb2a8f978e3b38949aa68bce3b46ab3be26f55416a9199cc112a6c60bb396174f6a12f04905777ce2dd9b8e8fce1fbb0f2f2efee8f9a3477fe097df7cf39d1ffac11f7af34ffc077feabff9eb7ff52f5d1f9ef0877558877500209fd1f5c62ffdcc3ffceaf7ffae0fbb7ef36a0a1de22a54abdc6d8da9d09f52713849a553e67175cecf4da99f74dff638cf2a482ac9bb6c8bf469865e168c4fc48ab6ab8b9876ebb725b9b21df06fb524c3cf0e02efa9f0d34426afbd156d667dc12ee09192383d4e4acc404b3168137d45e1515bb2a273285067b0e01d685f22dbe0b0893bd1b44b3a76a089c511679a3a374c404ad2b84c281e32cda09b5486221301eb44b82c3682365190e2a244f9f75842ecd02db68e5baa1eefb2a8fac1cd9a6508f44969db05eada0228c982e3d491429f7fcf19f359cdc9d131cbe58aabd58abaf2484ac410325daa72632ab798c34c4b0912b1981da5c42c6b49d4e5824885c490f9a2545a2183db9945880152c8806280ae96fd719dab71782289cad5d4aea6d78ee4d27875e56b3f146d8e70d3276efa359fdeacb3bdacbfe4e73ea9b9ddd66c52e2c1720328b56f9837736622784b601d472ab4669caa714aa6308a4f7c7063fceae34b7ee0e5dbbc6c0d5319419ec2e5f3918bc938861a0ee7d4c44d6abe21207330668098a00bd908404bf11a53a24f3d21eddaec0a59343e8ad59fc636e3752ea503902259556350173173c9e844306e5515b5874db645a3e98dc61933ef899a32984cb205c39601899972fb74c6eb9fbbcdd1bc060db85a81488a3dde3bbce68998d263b621c5759ed2c506efe7dc3e3ea2ef20c5400a30af1cadf3b4f3196ded471d8990c3eeaa45c3bc763c77d2f0caf373be70d9f1fae30daf7f6ec55b1f5cf1e9f99247971d9f3e5af1e8728589e489cacd12bb7a82b515416b9c45027da6b4613957c6474c420eb5b4448c02d2e4664eca40d55228d3da84f9021824e1aac4bc8263c0491cc1c4687a61b9d837317a229b587439791eca26c1326540568b10cc587681ae775480ef024923e28bfdf47897659b8d238213db95a79b8d5a13996851f6c764c36b8454d127a18b899494b9f7dc691ae62eb1708e5615577b7c88a414e842409c5039cfa9ab8ab1496436afb85d9ff2e2a2e38d8b35bf7eb994078f1eb66f5c5d7ee3bdefbcf79f7cfe0b5ffa637fec8ffdf1fff0ecf69d5ffd6b7fe52f1e1cb30eebb00eeb00403e8babaaeabf1053f86b5db7c131e46b6c270063c9915c4e1a16105ca15865ab5bd15438e8db8ebb4de84843a85eb6c01d38e93ae9aa4d751993a7d75e7af8f080db86724d5bf632f1cc377694120520d9c4bdca76b81136f2e7076090288e52624852f61d2cc7ff96afa90e255729db4b25a99a8be3a1eb29644a16c64ec2f2086a263488311724c59c601ec91dd69dec07dda578888c49d663c2235b3129921d84b2c6ddd8468a0c45eb50784e8e8f90751b2238efb9b48a7863f8aae5e8ec05ea7947bfe959af37f465126516896943e53d67f33977efdc65365bf0d1fd076c925137355d0091aa74929544c2ac9a745c4b8955a859b928676baf3c1ce7d483752451d41c3105223d31ad51331a374371984ab1068e447a2ce61c11f59e40766a4a62233545bcc349c9b331cb939cd8631673e06607cb7ec583d57a4cb46e7c4de51aa2383acdd3b485b6e0025731b236e358b3c39517a5d6442ca7bf8f01a7c55a36c52cde178fe28819f267fa4e0122a2be80512d1aa494cd140a07bf4fb08ac6456fac93712a8228ac53e422f4f4b100db61fa87e155f125f8b2226b0f866b68d40d94ab3c96e0985a5d99044c3e179a032e1538c231971cc628c9707d2ec46baf23888e18c4808548909e8e445357ccdb86ca2be242a1e555981c8d36c54636a030154c1231f69824ea4aa89c601eba289c5ff7ac2faf396a2be652510d69e4a3ae220339f14ae52a662d1cb589bb278157eff57cff6bb7797cb1e2c3072b7eedbd6bdefae09c754c9cce1baedf799f9bcb0bbaafbc863cff32663d7195c5d52918de47443bfa6879a2957a5290ecb2a714e17fa4ebd75872993a2891647509324c38317c822e46aecb34cca96231bb7d8502d89731f16893ddd38ebc30738e879bc407abc051ed79f54c091ede3cef5807cf0b6dc391241a97a8512a9772ba7d3995094f2792432c0b941fee79a9801e25db316f4149c1f96447b67caff1a8f75c2e37bc7db164c986574f1b1a6fc4d09342c0d78e5a05f14a1f1c6a59d3e75447677241699dc73b61e62b6ef98a5b4e78f3129ef491cb9babbbefbef5c6dd07f73ffd5b47a7a7ef00ffcae1297f588775580700f2195cbffcb33ff5d7bff2cd1ffd6b4391aa2ac5a63617772a5a06f686142dc730bdb018c6a9c1539dd21df1ab8df6bca663a53d82092b6f2e7b45fe5080cb563e5b6ae8df908c3c5afd4ebe30a13fcb9e55252378484c680da950b4d476b66f4b5ed875f47a5abc3970f6659226ae5bb056f40e25f5ad1c47d9daa70eb6ad26e3833deb4cb6e0c724b235e6b4ad856fa1c1954d2f139fad58550bbf5f9d1fb77fa0a38f1a12b309d0c9df379480a7c321aec6f94cd50beb8e10fb927b9105c94e3d75e539393ae2e468418fa76a5be6e272ce47df1530a665bae6b669dfd3b3a3df3d7f40c80098d29db5d4132d92248d13a3545524a9cb3590704908fd9a943aaaf9027342dff599faa49aeda8d59573ae082e834575a0390c91e13c5816c58b68c9c4102efb8e65e800a352c7b1f35cf6c675322e9272af566a1cbd294d03b7e64734d2b0ee7db6f4951cf6e8340bedc3c0b1214f06622ae924c95197dc1541c1b97c2c077aa1813948eae992a353a813f426f492830f5b1548054c906dae7b49c490afd9a43252814c0457a67c18c468db40c2bdde4176871b808be5d4f4d2fd271a168ae9826d5dad0d0862f4c5db2ae7ef644b6fef1c5e8094751c19e06bd14e79c063de8aa0de21ea49a12f1a0bd884c4cdbac38b7114c338551d4243f376b89cc561f99ed6d40ea7caacf1dc3d6b59df5df0ea731dafdfbbcd9bf7e6bcfde935f7fbc007bff0260ffb8e5bef9ff3f2ef14dab3063dbfa2bbec48d170c9b0d065c9be3608ed98fd91ac47c48874746183a5864a3c445014314fc271d30b8f7a65b3343eb9d9b08e5079a18bc6fd4d601973e6cccd26f2781348d138ab3d274dc5a375e0bdeb0d47b5e3b77dfe8cdb470dfff4c32b1ede445e3b39e6cb672d9f9b2b2f26cd3449c9ee624921ba72fb11a14fd94021a5fc6ca855519592825e6ca6f786b198a06224cdd6bfd79df1f17547ace0c5980829957055dbdeae2587580a3994d484e27647a1092a5ee0d87baa19789b71ab562efac4dbd72bdebbb9e1f17af5f99babcbcfbff2b957be93ccfe6cb75affdd078f1f1eb421877558877500209fa5d5f7fd9f55e5cf8953d4799285a1ad5f44de066aa8950231a50c5276c4d1b60d521b6c6d47ca5111b2c336986f10a127dba6384f8de4c76185b14f089a183dedfc2577f36d27217ce4c3ef482ea7fa8b09b4b16db4c274e232556f9aa5bdadb031a17c70d0da8630eeeb3864f4f11f5b7a25ea0e61e29e2525748c9281518ee318bab8b5e7dcd9ab11b0c432bd01d3b403c476bcfa07aa5a014fdbdc88c9519da6ae0bc414596fd6b9c31e73577ab359b15addd0c70e510fe2f15281cff6ccc9556c22f466d4f36382ef582e57f4a1cf8585eee3b6c9fefc26ae5f5525991f7535a282b82a3bdd8a612a043225ab122dc60a86f38eca7bfa7ec5a6eb412bbc6b32fd2459a190155d900a4a85a94307d058aaad58cc0aa2192945bad8e773508aaa73116a15debf16deb8d46ce7eb944a1d8d7a5ed20d270faef87463dc99d53c573b8eccd1548ad332451b0b3d45d48f7176c92c6b3b064d8cc9287056125a5c98d6c9781286ce79c569e5a948f89439f631e5494c9092480fd94e38a4f19c542aa4c9c4d1accc5fa6934f262c40d589de61abb31aaee3543cac135af27fa4149a197186980809bcf3ccbc62c10821e469c760816d7922a60a56b5f821f074080d9d38e68552f00e543f4a06c634a4276b912248c2151d9189e19ce3b8ae58d415cf1f25ee2d0c48e1c33797e74f1e5e3cf7e4e20a67152f9edc22dd99b37afc09faa4e3f8de114db3c042a670ba4a7075933f641a89d693a2b15adf70f1e486b63ae5f8d8e37a70068d7952f43c5ec3afad13ef9faff9d98f2fb8ea226d95cd3f9e6c027d2a94ad64f4d9b39cca2bb52a7d4aac82d178e1d2795ebd93f8a587377c78bee68dc74bde3839e2f5b3966f9cccf9c2a2e66ce699558ab784c404a1a317c1a3d9aedd29ce095ef3747b1313628976b046962d95b6303fcb4447e82db00c11c408317f762a115c79d6880cad1d191ddc984cbc4db60d9f4c19848583975be5c599e7a872dc6a2b2e82f1a48f5cdc5cbdb236fb9b31daafcde7f3dfb75c2edf3a3cf10febb00eeb00403e232b5afaef15fe8cc5d85a0aa87719748c05a1e502c7956c8c91b2a463113b08b077dc95264589ea40c5cac53113cbd8b1f0de9b4a6443abbdf03c9eb695dd2f56874edc3447dac66036d9f1e137db15610e6f2205c8eca7984f251563b7cff6367faae49cecd350586dc15006665380328a376cbbbd5af679d0adece70b8cf3029b7ab3c671c032cd204953e42639cf258bdf07e7aebdc32ab9881455bcb61978f41bfa7e8df739b723a4949d8854c1e5025f5c85910828ab0812f33514c51152c772b5a40f1dea1ab64cf2676710eca1cd679c7b463eba88cb992d6ac4d8671d88ac919848a127a8c789c73b47d32e50efd9dcdc9042beeed1a23fb19e04787519880b85c6a5450b64d91da18c8d32904a589251d363162125420c6c22dc04e1715782fb4450052fcafc72c5cf3fbae6dea2e59593055f3e9ef3ea7cc60b4735cf1d0b8b4658d435ad73787185ef5f42e724871d4a01f8a371aee6bc8c6045c32546289de4563583966823c0160487229a7096295db1fc0894489dc4687830d8c3329d5ec28e89928dd3d141503cf1480ad9da7af8856162920a08c172a8a9a866006891d045022e671295fd338a6ea572b8e471963557a10fe324d652b6168fd188696f4aba739fca9ab7140368d643d8c402bbf63918b5f789e3547174abedbe59d99fbfddf6effc4c1ffeb0ac36bfebeacd5f7ff5e21d95e5d5135e3ef2dcbd730ff5b7b95a2542ec389af7cc2bc15742883d7d1748c9b15a2aeb75435bbb42b58b48302440d7251e2e039f5e45de7dd2f1de4d2046b835e4af649539905094d615f739c9c7a6aa1cb30a1aafcceb8a882358a607f651b9bfec79b2e979e3f192978f5b5e3f9df1fa59cb4b33c74272269353686ac5a630099800002000494441543b8fb86ca861065d4af429229645f2c2342c71b81852b18f08f90a95fc1057c0a5acf1a80bf57040b026cf4a5119724b985c4ff9ea52314e2be1a46a7875d17263c2a3aee7fdeb35efadd6f2e9aafb5a1fe32f5795ff2f624c3f91523a88d40febb00eeb0040fe79afeffcdacfbdf5c5affde0ff6ca1ff23491dd5ec2877de63dc967e229922930330cae323176283cbd340231a8bf7212724a509cd6a52844cbafe5634177bbdf05d64609312e637d11adfb1a31dac6827ce53e30423d9ae764576351869ecb76e291b4cc2daf6a95303b0990ac9873d57d189c3cca0e1b01df03174fa6cdcdf4c5f79160d69c70d6cd0ec0c9390a95a65e4b96c45d6521cb444a7c189bbb4b56d575bb23b18390bc542a42f8529aa88f7a5a2cca425d52ad3b1bcb01687052954bcc872bda6ef3605d40ad6c70cb4d43d65ff39e851649ad06dbb16c2c9521626bb3a3b250166012c408a681771850217e286e48caa3dc2b773ac4f280e91448c2513c7d598f7482a09f7c5a6394a29772656b942ee068f133347061e03dd2885ac978a31e79790f30f8404311b0f5c762beedfac78e35c98bb8adbb3863b6dcdf38b86978e6a5e3eaef8d2d982574f8eb8ddd4ccbd63e61db5dfea7c0617a454ae472d41738dc051ebb83df71c0563a68aaae5d04ed2987c2de5b3a7968bfdf1f3ea749b766e326aab46d385678141317661e3d0cd1ef45096a71d713053c8fb90600cdf8c46169a7ba12f46022696a939ceb65b3124b9179bebec44c118b23780b490863053b693b2495ec538299572feac846f8ae49c19c97a375c06725724cefb186eafe2efbddbce7eecb7b6b39f5ec37ffda6e9ff7d59b53fdad4277f6613021f5c38bef5b1e274cde5d539778f95d75e5970ef6e4b9248df056a3767313b61562bed0cbcebd1046a118b3deb2ef078d9b1bae91035be78f78863e7b9eb3d735362547c3123486278058fe570c6e2839d9ca3ae1c270bc74a85ab5bc79c558bcc888b81ebcd9a8f972bdeb95af2c665cb972e667cf564ce578e1a5e6c3ca7adcb1ab072bf1ca6599518c7951400cb4ee36ada4990d2a06a5538a9145739ea72ce1b91317c73df614b0a55757bddc9d8b2c93237a1759eda415d26724795479ce7e5bae6c5aae2f959cb5bd72bde7872d1dc5ff67f1ab373e0270f4ffec33aacc33a0090cfc0faf55ffdb93ffac5affdd01f493160296447ac52c84a216ae787814c0c26777dee750ce11acbe6ccc72f5dc4212f605feff19b5dbb616aec6477fc6697ed15d7bfb95fb251539283ee7467d2b3cd39945dcffd49a1b6c3301b0b9ea100d2b10292c98377376a4ca7cddaeda6259b049897eeb114bbe211880c402e8e62dbe914646a7d3cb89d31c928c9a0258df31344d1aade8e8e4ade09b174ba35db3957dea35e8978d62115dd45a4ef23a9682d18fbdf3ab1d2d96f7c3e0d8a76ae06db9a000cfb6e2966e1bae4f4f2dbb30651e5e16ac546155a4f1722d227148f124afa7ccad49cd093e21a4b42ed1ac4557b699879f2a1a2286ebca6f391ca827ac450af78520e4ec4e54675e820f6991e5542daa245626f6cfa8ef375c7bb0a952a8bca71da785e3c9af1b993392f1fcd7869d1f2eae982578e335da6ae3c95cf942eaf997a2529831395ec7ea59aa956c125922a9d646d4525595341a1555adc26abab28ae9c63b5ed146468024c5ddd76b2465291f54cd87f5be0be05baa25bc49e3f5ec5ee9bedfb0783759fa82ba5ae328809fd0a751ed56a4c571f6caff32c2a9f7b0a0dccc856bd71d047eda2a5edb59f0c4bd98d4ac4b24182e62b3f17d0c5563c095d84ebcee2dd2473119983fd7863fcf8f73d7e72df8cff6b5d57bfffddbb77bff17059ffa17ff04be7af5d3cb97f7675f9843b47c2375e3de5477eeb8bbcfcc282a6ada92a8fa69ea419ccaac66cb81c842ef55c6f7a2e5701e9132f2d66dc3d9a73ec2bc22a605de2b66f39f10db528beb89c757d9f33714859c7e184c629ce60a94273eb948fabc0bbe7375cf4294f434d5906e393eb8ecb55cfbbe74bbe7dd4f2a59305af9db57ce1cc73d62a9e6c39ee25513b9869d68645d3d2a8b0ed24cc2653eb9458a8f07c5b23aea655ca54ce2601adbb1ffb316073f2751da665c51ebe4f469f04758e961c8ae90d1ae768da96e3ba61ee94cbf58ac7ab0deb946e1f9ef8877558877500209fa1a5cefdc722f613b15be31b87f355c9b1d84e30f2c4a0749f745bbccaa0719874fed398d951b8d46c1d86c6d79a74eb7722406c3b0178ba9bb69da0fc06fdd8a70bd849d921b2df699f4006911da9876dfdadb2d5af0e006028d88b2876eccc153acc5008ed018cedc355f66c8c65472c3f70aad9fbde084c4af05fe659eb84fde576b346461053c4c0c90a3166fa7a25446d678c331c8048a675592ec6d5e76231c5499541e9f1bbe2d6e572611221c69ed8f7444ba54b9a6d77d512e27c99aee9334f9994733ee61da45d00a9aa985428139a9f45543d95c0595df195dba7f41801e1bc7451379b15da0fd7b1c3799fc5cbfd861456198414db526792b31e06c0eb7c7106d26ce55c8e7139c23874cccfc921993e3b899966eb5cf58865b1b9a43c61d30212538cd9c92b255621f278ddf3fed59a5ff8f482b6729c36352f9f2c78fd6cc197cfe63cbf68b8bb98f1dcbce54e5331731900252744078f7be361307c48cc9d7154659a992b9faf94800884dc20307393b46e19af694b4cc2f1646447ca04188e9742ca40548d6d777bc8d72913c7e1b88d82f9624a5199518bb109914d9fdf2bd3bd12311921c642d919de2c8ed3264b61626badc52a3bef638c3bacb39dcc9cf1fd5322860d921cd4f564da96275a29245c0f75af68206ab2d3a199904d82b9172dfd916ab3f983af7df0e17be1fd0f7e7a797cf49fbfd9e8ece22afde9b7debbfcf29bef5d71d3cdf95d3f7cc68bf72a96eb6bfacd154ded38b3058db7ec7c161dc1c8419c09ee88e7ebaea65e1bbdf5cc7c8556ca69e558a8516bc459629d121718de65f17e286d85791208798ad4569e7ae6b11e1e558e4d089c85c4aa8bac43cfaa0f5c6dd67cb2dcf0ad8b252f3eaaf92d77e7bc7e6bc68b470db71acf7165a845528819f84d00a6ec378a8a698117e35eedc129ad453624424c7431325337c1f8c368d646d0abe57eb9cfca4c08497c014142880997a0ad947955313343ace6bd45c3db97376ccc6cbc6f1fd6611dd6611d00c83fffd5cee67f3bc5f867434c15249cf7d9cb3ec59c6c3d6a2964923abe7de00c63f96dc6c5b6c8de3a35fdc6a30fd9136ff33d7e6b4ae1faee93935dca964cc3f7d875d592fdd796ad8e44f680d010f6673b530d7600914d40924e9ca88cbd0909535be15d98213b7af9898665c230db9d1d4cda8f1325ccf4985ab1441d83e8ece9e3bdb385ea8b235aca5496943bc216fb0c1eb5da6607a49e5082c7300741c6cea8a46cb79a272611d4e37c83a89b24b40b5b6be6bdfdb13c694b699a93a26340e340b3d362275ba963deb6f8aa21c4c8bc99b30a91656f8516659854e0eb2c5e8e1da95f222932af2b9c2a5d3292f5795f061aa18c52d99c39c296f6338afaade8140a75c90f3e6ba22457e5c4f0a1d6322bc181319bee9a9188d91ad8123dd0c7c475e878b4daf0fee5925fbe7fceada6e2b4aeb9bb98f1cac9822f9e2e78f168c1715bb198d7b473cf4a1b96f59c681bd6eae87dd150f43d3e061a85daa0725968ac9281430623936b42ac0ceb26d6ce05fc8ed4bf32fbb4d27210d15d0fbb623a9186dfd12d40cea6ba302371a2f0dee59ab7de7ec4cbcf2f78f1de228be54df095cbd6cd03f0184aff18b0d4e5f18bb99ca3320458a6b43b021d2eae89766c04af43e863a1620d6602c90c8b8646f0d1903e4585538ad6428b26268ad099559b185f37e3757f71f987bf99ec2d15fec6cff5fae1771e75bfff67be7dfec3bd1c7de5c5176a2c3c217617bc70a7e58bcf474e668ea3794b5d3704f2dfef1cb5bc18135f729e5517d820bcd47a2a6740403416ef5ba1754a55684dae604b2b5ccdf314e98a05f79938be7ab4603d9fb1ee3bba203cd924de5f5ef3d1ea9a60d025e34917b9ee96dc5faef995c73930f3cbb7167ce9a4e1f9d631d3ec8456699e90d9fe34b79cdd3e26428056c0d3d324236ae249cae6005610ee08f9469de0a06fdbbd0b0ff7f55a1d8d3a7c311ae88b36a671a5f165c6dc29c755d946ecffedf0fdb00eebb00eeb0040fe59aeeab6ffb65dfaff91aeffb7293904ea3d31f425e1572109ea5d7eb08b4e340e45c049dc2b5e77c1c358b04f6d729f61fbba0b0c642fe04a76a22f760a66db9f7514b1e224242bd3a8b6606157f7b12d50768a7ad9e3508ddfd40930d8dd846960e0902cad3b426f9b1472db2f8dd3953d4821b22dcc777775087834765dc3ca160c31ccb64d60174ab0e104648c0ffb67f0e30432484839dc2f6fb7cbd41edb8ac8f3742a61566c6d53ca35a6167b9b025c7247db65cbd411e5c90e24dbb93cc649d570beb45c296907f466709c23d848111121a8e7dc1c0187ab1d4dead8746bd412c162d1d8d4996a167b24254e662daf9c9d2029f1e1f58aeb909dddd021736348138f793f193432ba2d9404cc5550ac8e73a73e22e65051d2b00fa9cf20a6842d56aec56995332d6c53b249b23621ebda239b98d8ac3bce573d2a4beac757ccbce3b469389b37dc59b4dc3d9af1ea9d135eb97544db2c48aee25a855055782799f2d32b754af8042dc69140ad203113f6b2966410170f69e953e9f8ee6742caf599467d54d6675876fb25a6dcf14eaa28b613bc282553e258e1abade7e172c9dfffa95fe5d3c797fc6b3ff645befcf933eaa6a212c99df718b38e43b54c4772b60be2760ad5ec165680f3e47a4f83639f4cbaee645b5fadaadc6d4f89a97545924874c22605aed79b780fee400620ae88fba308deb2f5b08b0985265afcbe758a7ff135e7975f50f74fedc347ffddfbc747ffe017df5cfebbabe5d51fbf752cbcf662e29db757cc1a78edf3b7393ee9b95c072e2e3b9e9bb5bcd01bc775c5595d8d072da58493428d13cbd3c73232701946654b6e553a332e2dd1ab3213456262169553f5500bc1c3450d6dadb495e7c166cd3a84ac5b4a81c79bac577aff72c3b71e5cf385d396efbb3de3cba72d2f2d3cc79ac30ac77e8f0c7773c54c8811fa00eb10a9aca7f191566211955b314cb331503615e392211456b777b40960cc0581b34c9313a0aa94c63bbc13423282243a4974e51a201de0c7611dd6611d00c8676afdfcfffef70df877bef9233ffe6ff57d384e6183ab5b9ccf741b5187690e8b4b85ee62c5770793b1461feb5895ccdc49b613fc273249382f09dfc348fc7bcd3176e706f63436b1bd3186c9d3630df68b5ac6e27d076c4c40c8b3e702b68d22479eb9ed36a1a5087b8c31fb2ebb382df861427d9bce659e064742ee586fb529ba93823ea6ba0b5b41b76cd394d364c232384aedcf41cc62997cd8485b1267a498b6eec7a33e46276e389062b61bb5312cb1029745dca914de4c45e8fb4052b609f2e37e659e5bb6fdb442ff1345bd62e67238a1192b511e8bc7f90a5168d29aba8f39c17bccb8c942714b91a6ae78eee494cfddbec572b9e27c93e84588aa2508b0e80d4619cd70e10f6726651b5f934cb5525fbaf03d16ba1cce265a088a094b7d01e40e7315c1e7a9418a01b3b0a52da69869454e47dbdd648998027d082c43cfe3f506bd142ae798558ee78ee77ceeec98dbf39ac62b55e5395db4dc3e6eb8d52867550b96b8481dd21ba79238de2a81988bd292ad73450567598cbe05c8b6b5d295614a95dda68cdc19cf538a6c53bc49d0a7fc25151dddc0d4f2844830664ef9e6518379e19fdc3fe7a7fec10dabd5867ff3f7bcce575ebb8b7a573405b9f067d03aa430994a5ab1509631c767fab92cb033ef4b1a8053de97aa9ae1bc0773c4b8c9ce5c928bf99ec4da7aae53c726c64e708be13ad70244945c883b11bc088d2a952a5510bdb270b48ae1f7c43efd9ef48bef9c3fe7f4efadccfee0a3b3f6fb7efeeafa5f95b8f981dba7d5e99b1facb95805ae561b5c08dceae1ce6c96352f23f7481049c520201ffb48e0a6efb9ee23779a9aca3910c5a9c78960295fabadaf109fa77335992edb79a152cfac5e70ab6d79bceeb8da6c58859e277dcfc3b061d9755c6e7a2e371df7af57bcf764c9e78f3310f9bedb339e9b5578af544e103f7c160242c293dde982015dc262a492f2b3e573385864f4e53e5633710d9cc8d9b653ab6cabeccb4dcc522c9aa03c4d91321c1397e958dec977bfff1ed6611dd661fd06cb1d0ec13fdbf5e2e7bef4c02cfdbe949238e75057a1ce6d3bd0458438d8a7da604b3a24a80f256b290ee2201a91ad8055f6eaeaad6fbcec95e04c281a537c20bfb987c84e41bb57c83fe3fd777c44772635bb9ddead3a429ead9b1e7245462ffb6df1b313c53171f3d99d74c856572332f91a3bff5661e76732cfbe58eb4e7fcf767348c63c920114dadef7642b84dffe19e8585a0200b7ee5fa2ae4c44b26b54a6e8f951e49eb06ce92b52b6cf4d6c8399649bd80e052fd332d2b85de3e9d9d95687b8324d5145d515c38472d5b80a733ee75c14dbd03e869c77a10ee77c49042f790655cd9dd35bcc670bfa28f4789228311a21766302bd8acf7fd4e76da0d8199b8cb41d2dae60997ed41343474a3127aac71eb38424c012ea2a4c7db1d8cdc0444470c3eb4b16eeabd6785765a3883275d1e25246a13c05cb1a8a8bd5868f2e6f78eff1256f3fbae49d8797bcfde88ab71f5ef1fef9928faf363cea1237265c27e132c25584f324245fa3ce711d02e721b1914cd37296e97ba9686a22421247524712210a041c95d465bb523effba0589822b2e53c3111a6ca073b15f7bc72defb925c2d5cd86373eb9e2a3f335aea9688f1ac46701ba134ae64a2ea6a3655bda9cdd91874fa1efb9fff0926eb5a6ad1cf39339759baf3f2d9f8d2c400f88a42c70174f3225869c3bef9ccf0e58a9274458af121f7cb2f9f4f4317704c4eb90659171b14aa65c7acd42fe4a85aa50a31ae7063ae62c24fba6c3fed0dd2ebd7a7719df5824ff93e78dfb3fdff9f8e607fec9b73f3a7df7c3276c6e3ace5478a5cec7a330e150814a32d57017b30b9508952a4ec0a9e235eba8d6c988aea255471b8dd672ca7a2c14d10aa5153812e596f7dcad2beed535c7b5cfa1a565024939ef171be3fd9b0def5f6e78b24a3cde18d7216f5ce512c97a56a1c3a56ca9bc3465b94e9c06e124e54c9b587b1a5fe305428a448154ee3f6da1520eb6e4d35b71226b479241553eefa1e4a1e47d1e127ff2c8fb719778f3c90dd721fd2333fb3f0e4ffac33aacc33a4c403e6b08cfebdf126dfed3aeebee856e43d53abcab0804522c4c1ad19cd41c63093e1b722b0637a32123211784d98a373bcae820d01da720d3e4f2c9987d27884eb63d571b7af6df7d82f01b8c53260060775a31021cdba3630d93837d6760f6a4e126bb186607bcd8de6fc977ddee6d38dfc4ed4964a293d8260d0fdb28033e97bd9c937d2026cf38707be18bbb84b2ed1c48b59ae6326620216ed400e5bacab31bf99840abd15273a0bd8da98f7bc76527c5a508934d76f77b27e091c1016c32c52abcb784d28708ab0ddee79cf6100221c511306d5ddc72964912e8808d56c8bc62ae0debeb1b6e366b62e87352b36f326863f75ac9d7484ed01e525c32b53d8de74525d34492418c6974f9b1d8678a9acb93a401d86432cdd6a67a088f7418e61caa7e046a4347582c32789aad630623a43ed300af573811def18eb6722c9a8ad379cba276cc4ad1d738c7174f167cfea8c55b4555d79cd64a4801ed3aac8f34de97e03f47a55aceba66872467a84420112467d8882ae65c71da329c45423256214f3072919e93b349700bc7d7172d3311fef1e58a6ffde2073cb858f1fefd1b7ee76f7b952fbd7c8c5659d82c96e8fb40b4fc3e8e84f35a6e431926a594d8f42508d112790e42b623f64a8c1d7dd7d1afc1bb96a69ea3aece76b63ae88b94da398e1a386daa256c9eba05e9289e2e693fc516d921d4b5d29b71e41deb18d924a38fc905b3d75578fd24f0079ebb9fbe3d73ed5f98554797ffe8faf18f3fb2eec73f405eb9a86a6ce6326882a22bcac57a2a9f198730774a2a96e9539b6527509bb146884946630d2be04390d19adb0bcc3c98f704731c45cfac6db9d5343c58d63cdeacb9e9031b33ba18f9f0a6e7c1f29c9387573cbf6878ed56cbd76fb73cbf701c3bcf6d4f4e352fcaa6ca62ce9bf1cabcf5397fa74b7449b2785eb2375d9ef2e5ebd84deea132d1854da7cb364ea3b6d357572671d5742a7c58877558877598807cf6d6c7efbfb379edebbff5d594d28fc4be439cc3b9ba847a45624a63b77dac72772a737b4ad70113edc1be27ed04740832915b3ce55bbb57b00bec4d09763af6f2d48f4e7e1676c2ff76d0c76e69bbfdb73d2d1497dda98cec9b7c8e9dfa674c799e4a402c742dd915bcdbc46657a6810522bbc746863c04d9110acb64b232a5450dc768e0f94f8f25d32988e864daa0dba266388e93fd1a262f5bed003bd318119dbceeb0cd3a292864cfb2d5b6f929227b477817f7e5d4c5ed49b162959b730bb2cd6cb4928111429e3e946bd84ad16831e6eeb9f7f8ba457d4532a58f914ddf13522c5d7d57261b59dbb2bb8f32f97c389258997874882516ade3e5e78e78e5b939f3cad3a8646bd3f19a2b9f1457e769cee85ea63be19f037d51348300d10c46d4b932a1ca7908ce55d9f2781ab807f4c958f589ebf58647cb350fafd67c72b5e2c3cb151f5eadf9ced58aefdcac79d02542556175c50dc2c79bc8790457b7683527b82a3b1199a1a4423f4a88444c024922c9813947a78eb5195e13b506362970d1f75c85484fc4bb1c7a174b977fe68423afb46a5cae3b3e7ab4e4fd4faee8fac8e9bce26856d334428a8118727e862fd79e160dc793cb256ffefa631e9faf101c774f162cda0a4722b126c886e4e0baeff8e4f1154f2e3678e759cc1b5ce5ca84af089a53c2a9b25927de79effaddfa41f81c88640d889490c9e9e72d4f4344f367a22ec2f05a5df9a3cc2bc7dc396aef68447da5fa02f06fbc7674f42ffff8dd3b76a7aabffd71b7fec6eb47335ef07ea44dea24ca74f01bd4c91d6ba486c9563b758dd1b90aaf0e1f0d3fc91a1a9a225aec8bbd6afe3975d4de33f315a7de7354552cbc67e12b8eab8a99732c63cfe34dc74d485cf53d0f961d9f5cf53c582656c1e1b5c2d58e8dc17ab9a2891d5e21b54a57292699f226288d786acb0e7a01cdce65d8f63e35061166d139667886fc9884ba0c127dc9b041f3e7fbd34de05b4faeb8eac3610272588775580700f2595defbff3ab7feff3af7fe35e4af1b763e07c8da812d34089d1b15864bf2b3fd8b94e1af8bbd171f20c85017b45f93e28903d87a9294d68fff7f781c353117b3ce580b50360f60b78d971f37ad6f67d4f21ba3016003beffd8c29442e86652fefe37b77ed84676be477f65ab6da72192c8fa7616d7b076a1be4267b804976beb7ddf7b2b75ac4da0338dd035e537ad7c405750b0e919de33902d8c1f27902da6c0a7ed98ae187504c1bdca9462bd91c5497d2201cd7ac6b1a0fa496639393dca340d747d65d9fa91de250ef3175c54ad80add4b4b77f75993a572406387a58e9917ee9dd47cf1c5053ff8955bbcf6fc3147ea706678df5055359b100856a60613e0c5a4b01c01e7786e74027a64347b10243b98a99f50b82ad4d5886b4afe43221527a23e26d621b10a8127eb0df7af577c7cbde2a3eb35dfb95cf2eed58a8f961b6ea2205503754bef6a96e6e824d3a7b2514224c6409f025d49224fe828c06f8c4ccbc161640b558fa3417136f4adf36403a04f4205dc5261bdec78eb934b1e3e59339f559c1d355455a61939721e8d2b991a66c6f9c59a6fbffd88c7e72bbc785eba75c6c97c5e44dc45646dc2f965e2fea388f79ee7cee62c66d9863786580ae032c910e1f26ac33b6f5fbedd9cdb17453215cced35426caf89e154517277df89e035eb431a75d44e694499b93c4daad449253253d5576e55d5eccaa75b5f9ed7dc51dd09372d47a94cff9ebeaf4c01b101373600104f15b3f940514c64730e064c3d4c6e1c4e850a612e70e49453ef39ab6a6e37f9cfb1f7046063a04e5094108deb3ef16015f8ce75c7fd756019732ee2118179ece952e4dc8c2726385fd38ad224a54982a43c404faa98e6a99853dd61de669d549e68b9816c65e054a8bd1fa7902844153e5d75fccaf901801cd6611dd6fff775a060fdffb44ecf6eff23e7fc9fb8b9be26c50ef54da653b90a935882db1c32b05886246ccb5f48184ace4f104b5bbb4e1932299ee5c5be17e2271327ad91023571b71a8bea7d73c5ef6db5286c295f4c1cb0e459820ee1d95fb3ddf7921d67af2914d0a75bf6ec856eedcd5dcc9e0e1d7ce6b23d45e538d9994c6244778eebfeae4c07583baf261321bd4ce711d34848db72a2a629f132c93861d7f16c8b297281e81874443c0d1c45b3c87cb011933d00377444939404efc9fb961d5337e862a66e5fdbf047555f407204dfe05430f1acbbc83a2d915480862aced538cbe9d1994a943f03903bdd69c7892c924a50a4af1c09c7d951c54b6735c49ebeefb8db366ce64a3c6e393d9af1d1d5868bd5261ff71872fab6b8423511f69dd38c5dfd920d7d70c985f230094a453c3f8291e21c15fa444a65aa255983418a0cd126eb98d82c375cac37fcfaa31c74e85538a92a5e3abee18593239e9b2fb8336bb8533bee56f9f8d0197510ccb29ea575c251141695e5046c73f4e64161d108b3bad0d362442d51910804ae4206074dddf2baabf962883cbf5ef30bab0ddffe85f7b9ba5ef3e4ea0bfc8eef7f9e7bb79af1ba504086ee78d105c561ba680e8247aaac4f7144520f0b6d78e5f69cf92cd0b68e4424c648df77382a9cd6a311421713a94f1d85b6b4b524dfbb8265ac8147edc4a011f1192e919265ef4057c4ff299126cd8cb5933ef5ca324482fa9d07e098df53ee426eb03b171b99b0d3fbd168883e49171f2980187da1f9a9ee6a985cc9ec4184990a8bc6d199639d12374dcda2aa79617ecce3f58af36ecd4ddfd393d804e371bfe1e39b156f9c5ff103f7e6fcf613874b8907cb9eb743c41f577c659e4d08ea60b8248490b2e98108e264629cc1cef3c18d0d8962e32b93e64af956943cf38b960e0e5887755887750020ff22ac935bb77f5a54ffb7bedbfceb5de85157e17deeb9c5e1e195520e823321f32c52a6859821298d6e589820a6c536753ad9604764be1f473149d4986cd96e12f9fecc612c782749cdc6eedf07c06043c8dd6899bbc731de7be911a4ecf0fe796adaf334e078b6fdd553664fcf72fa7db67063f7cd6db281ec20b8f1684dbfc677d98a672480b0afc4e1195f11d9f67c73e351b6a399811a555ca284b407f80c4c8b73d19ecb4dd983b1eb6fcf387e7be78c93ba0000200049444154c992dba94a116717abdf9c51520a155249dbce1ddbd1727514a5bb9cdf5136282423848e649118870960b19b4db1bc07e3eb0ed73ca92711118b38118e9a9ac62917ff0f7bef1673cb96dd77fdc69cb3aad6e5bbed6fdfcea5fb9cd3dda7db6dbb8ded38d82121368e1329311128221210203c584242423c21f2849078c35c8540e2c5f0148414e7018402014c1408766212dbd8ee76dfcf39dde7b2f7d9b7efbe565de61c3ccc59b5aa6ad5fa76b7e5a0eed61a475bfb7cdf5eab56adaa5955e33fc6f8ffff5715ef3dbae1aa2879fe7c8d9105f3bca07a71834ff3fa2ac961dee80668cad0bc727b84af93238b4a65097c78629743a4ed448084328e8589624d86b591afe2c510a41d988c80a449236c6592b7baaa6a9eae2abef2fc8279967154e4bc72b0e093c7071ccd720ec4718423479959387182cd944a3d65d3a04462b60991af921bc3d299c80568141b33728285460ccbc232337075d3f0bab52c8b9a6f5615bfffb547fceaf90d8f9e5cf0a7ffd8ebbcf9da21cb590eaa3475dcefcc08f78f0aaacb9cc379469e03a64169928883c104289ca0c6b2261af281417d481db968ec195af27d13a0d15a6f69528a6cf723c765915605cca6fb46208eaa45a01e3b7b02feaa0e3c334aedf2a82cd6fbd8906e0349e02a3ad613c500445bf5a8a13878b4fdd4ce8d5e44a359231ac7df34168d4cf0a86981b58f0478311462c9ac50a861e10c47c6f146bee0e97cc987eb1b3e58dff0bcaeb8f19e9ba6e6ba6cb82c2b2cf09a3de44d37a7768ee00db99b51588b1008168c4fca7612d8b8ed48e41a8eee1cfd3256f74410e9c6e0204a307b85c6fb2488b20721fbd8c73ef600e47b3afee67ff39f7de32ffc8bffc6bf3e9b2fbf595f5e2c7d5361b328cb4b77734f0f0b6352a2693ab26c570454937c0ffa3461dd742e4487528bed2b0c3d37ef51559f9eebba8c92fb64663550b9d221b743078e00db49be4e21896d9ddd94f3a72abcf647cb7a2449ed25f12356f8a6d3a1db004587a9cbf654d6b05ba35b3ac43d2c22d27334ec7124a6b2a7ae59d1cadf9ac10e8d8fedb87bd32ffeb69958c73717896043fb0999202630362fdb7c7fed3a2a1a642ba96b65833b65b3a414d482902e114912c2edf16847654cbf0d9412360d9ae6f60d6a05f50dc137343efa9ba024ae45eb3d62bbf3143492cf31716e3df838f635cb1c87f3197926e44150753cbd6878b616ee1fcdb9a91ace562b1a888a433d25ad28a52c0ca4e0446fcb7a37905e04311667e2316a3b62ada88088c1da2c92c47dd2b692d019bd457e89262f8d9088ca9eb58f7fcecb92a7d786f72f2ff9cab3172c6705c759ce81732c9de5b870bc7290f3e020c7598717e138138e8c81aa82a02cd5e334b0208036d4218291a270e02c36171aa2d2d51d97f130149cdc94ac9b4bfe9f6f3ee1579f5cf3e8f1157ff1e73ecd0f7fea1e8b998bdda710c80d3c38ca9072c63ccf98cd6b709e5a43345b6ca2b257a6d1ec71e515d1387a6493ca9aedd4cd12ae04889372b15b34d4c5ee5dea3a7169f580b2f6f96a89d3a14097f41bbcfa1079787480a1bbff8ec06754448b92dcb615f1d061bda235c56cc1bf1813bb4e1624b40a6e1b83480d91aedfddbdb5955e4f3c1160aec211c2b1cb392d1c0f17733eae4a9e946b9eadd7bc3086555d517ac3f3da70af2890bce100382ee68873944d8335429319c4c4313e114f0871cd5a36be20ed31b3e9feeb35745dd4c8bb89539b21bdbe568d20ba2b3fed631ffbd8c71e807c4f47e6cc93a298ffa765b9fef7caaa84e0b036ef110a128958e31d3f84644498ba202d1118e2434542eb59d1eaf5870df8a0afc414418376d6ba03cdaa9ec1b70c40860e7d97874f7e1d25aee38ec944597dec21be051552f5b0ddc7d015a95bef86f41d52b261fa124e321ac592d1b8964e62894127e2a5216c79b08c81c67082ab6f08d91f79ea297c29939d27e9dc44640ce5861c9cbecc5892756ef917835315e80c073bbe8395cefd7ac3334a1e1966c8eb311bb7c9cee3216212db4f01f1a18989998dfc8438f71fbd39d4d9e4b511ba441e1f6bd5460467338c3518ebe267d482041f13d5a071bc2b7810cbc1a2e0eed19c7b73c332b3ac15ae1bb87f7cc8c17cceb7ce9e7253fb44266fc18d65c2e37ee43fb3631d044d492c69ec2a9da5d4151197010560089898e8112bde5023f8580917c1981c35260e0d851ab4894a522102933a78eab2e1a6f2989b15962841ebaca1b086c322e7745970e760c6c3a3396f1fcd2932c7626671be66a64a4120d3d8a1f1d645695f943c77a8136e7c832c0c778d6351c5e3ff99aae2715ef1ced935fff76f7e8ba6f45cfd8992cf7fe61e774f0a3263b152b39c39c26141e1329c6ba87ce06c058f5fd43c392b39c81da78b8c2cb364b339cb7c8e48883e20be4110667981b1161f7b48642a3e4200b3197eeb4b458ffc5137a214ec04286d07d1b7be48aac11b832d720e5c1a57e47656d86054af779fea4619dbebb1954526763532034e944c15af06d34e29a67b7994d3de7c1943047891f705c6c142c1a9e1c0e5dccd2caf668e8bbce09c43ce9b0a2781d258fefeb31b9e5eafa9113eeb1cc5d28187d00472b5ccad652e868ce8ed110b5523cc1d74a34497e4bba547c497d13345bb42c53ef6b18f7dec01c8f77cfc8f7ffdbfd63fff977fe9bf9dcd977fc937fe0bc137515c3fcdba4b5bf9178b52a7eaa8f6f81b1be7f1104cfa3bc4ca70f27750d51e9e48bafcd233d41b0aacf61cbb870a55ad54ae8a4ef342fab2b55d723eaadcf7c7c3743bbddba47c13fbd3fe9bca46cd2895395bdec1e69b0c257b37dd9f511f43a72bddaae336c32d9949afb5d4875532ee788c482f939c905e82df6feaa43466408c1e38be773c931ea7a71bb393a1a430dd145172556f89f251c0392432795f52d358db7547a425eaea86a0ddaed54e0278702ca394b43136917153a5343434554d081e15834b8a527114a76e33b7e4256213d7a2cfbd114210c47a9c510e66394b679887405d079e5e56cce70b3efde02e4faed69cadd6783158374fbe2c1bff670646998c44d8b647d352eb04d31b6d6b3d11443df81a352e7dff900a07269288c5a0d8ce7052b0a844f23d266082607089bf10a2a298693a3fa0b6535287000d5c012f566b3eb88c0ed5cb59ce970fe67cf260ce699e719209f7ade161667820c2d2e618717812f0ab146b0db9cb704e70063c302f1c9f9a2fb1770c0ff31bbe55357cf58b1f717e76c34f7ce1213ffbc75fe7d3af1d2162c9b28c5931636e2d5a592ed6f0f5470d7fe7771ff1fbef3c65963bee1ee5dc3b9ef1f66ba77ceecd535ebf37c3d968a66a2456d8ad95ae7862c388c4963aaf8373057dedbfa18cf68e4bb5edd4a561212d83ca6559731394e0ecf43b07deac7104c9ebd605da39be1be90b8127ff1d225fac2f52813158a4bb86fab79dd660159f9ccb53c1c98970680cf3dc72ea66dc148e17bee24a1de262a7ecef3f3ee7e3d51a670da1c8c8171937eb9ab355cdcce6bc329ff1ea3ce39e75e4261a3a6e264c37f77793d6b54d235ab1792469b492348e257bd8b18f7dec630f40be1fe37ff9d55f79e7cffd0bbff4affaa6f99debeb2b425327de878d604248a449e9921d10d418f0be4b882455972529ef4c4aaab60f386d2b5eda3d145b22f5c664ae47244f953035a91e397ed0b7e313a66721a8b26d92313d8d94f4e5b7ead043675e6d1fe6320207b283cbd123dcf7c15037dab5496c645b5e6b93d88fdb2432e1dfae8cc08e6e55d2a75b477d2ec850e25313d8dab05d652b39d689f776a6949d774c4fc7bf9f544be4860c715674820e1de49154990d3d1e86b4860cddd9d0107a80a73d563e1157e3eb7d88be15adb12290c087a01af0de27b343dbf16abcf709d0b4fe26a1534b136b6265d8180c26712ce228c87aad8490f1f0e884799e73b63a6755fb0dbab03655de433218dc6e028efd6674ea3a4a0eed68e85cda518f35b1c5a4aa34be8c4688e2b09ac7e435711d8280159bae973a56bc834f672012ba9d2d08524420e31b34546984abede0c4ea73d5345475c5d5bae6f9e50d5f7396cc5a16c6729c5b1e16399f58ce78a5c8b8931b4e9c6199095a964869b87f3267690d6bdf10246073cb2b8739c7cef0b0c8f8b8a979b75cf3a5f79ef26be7375465cd9ffd993778e5ee324a121b470886d595e3ec3ce7bdf72ff8cd2f3ee7cbdf7e1a1f2c4e58cc325ebdf3313ffcd61d7ef6c75fe5273f7b97a3454ee6e2f1ad9be4d61d14e3a5dfb04545375dce89fb866a2abe8c54ee946d35c196a91054b5f28d9cddacb8985bfc7cb675b90eee2d2939f712cf9df6ef998c95b906575bfae8289ca090bc4b34fa9a28114ca7dfb7d761545cd7e8c4de71bce27a740299895d9b20c2d2586a097cb5aa39af6a563e301758878a0faed67c7876c38b9b12672c771773de5c2e78ebb0e0d53ce3d00ab96c9e18b6bbe7840e3c8944553097ee0bedab838906a46a06c36ffb07fb3ef6b18f3d00f97e0863f8a2b5eebf3446feadd0d488cb3162c19a38b6d1b5394c8ffcdd569f4397181b23f101d711699906223dbe820c38b83aacdf8f00c42041d69161d544076458ad97e163594672bab09d086e3dca7ae5c121cb61d00cd864c2c3c4407b3c16e9bd2e8cd46cc653637d09e04dc573d78e76e9e36684acf7f3566ba43db6c3a64d473c8f95dd565ed70c0c2465dc3de981aa3e69bcdfc9eaefac4c16796534ca167b2361a010250333c59690adc9ac0c3489b699eed87572c1495a7743c30ec94b4421843872681c1aa2129c76c9bd7433ea26a92285b4f63428eb125edc18d6021795852cc74bce7b2fd63c3a5b517bed7c3e62f2e849f5e7aec1441f7cf74d3bdbfd6fc7e7928163a4d8c76e63136a208e9bc54e4e4e086b0c3e5e9bd224f3b76253301043903882634569872643303dbf188315d349c1c6a43b8a5388447bc21002122a54eb6e26bf2a3d68c30b511e89f08e35cc9f5be6ce729819eecd0a5e5d161855ac83cfd781b78f330e736526862c8b67b930c28359c6616d39ae0c8bbce445035fffbd8f31def04ffdc46b600c4f5ed4dc5c56686d09f582cb8bc0f54d4359a7fb570537eb9a17172b3e787a4550e553af1d70f7608e88500743308278a1f1b119d4aed98df5ddcecac4668d2502c3a069a5dbdcaf780e09b570d31a6b0e7b98ad4565248f4b3279add3ca0912a84243d534143623b3499dd04682ba1bdcd2d23e867ee730ed8bfa4488df7437cd588d4e052b3a94b3d0cdd8e9322f2053aecb1547cef3da61c6b1178e32e14e11289b1bcecb1567eb0a630caba6e1f9bae4db370bde3a58f2e965c19ddcc5d12c074283f1354a04a32a16094a8650489478f628a528cf7d4949c372a6cc33c1aca5bb57ec631ffbd8c71e807c8fc7dffe1bbfd2fcd3bff82ffd27ce657fb5aaca237c83d80c2b161f1424c4d10d6310f55dd54ddb0a2c1b759e8dde4b3b632c91f4cbb688d390c7219d8f8532545e52d1b1d4d388e33055f5920d8f6322d19d72eb60476ebf95ebeb503f6a4357997ef0c9b843c1d0897d82813e2072f771587f444dc692bf832fb7f9b7810bfd16839f6e146c3ccad08de099ad5f0ea05bdbcdda00dad49162282f4ba79466369e249dc3faf608579f076212a7a8036f9da4d6a6abb421a807b02eb962d333a9eccba90a6aa23a90e946c23660d2d8c8f350427434ef2d069f88ea011f392004ca60f878054d55715dad31b6e6b28e9d95b39b1b7c30888d5e231841c9ba79fbae8adde7cfbc64b0441331d7a4a9f838f69814bfd4a02192cd0f9619b3dc523781d53ad0f82af23ed21850e8c07d3220ed4c0d87636d92c05be717d397a1b582d819689eba3171ec2b340d5e1b4250eae0b9ae7ddbbce21db7e2f832c76030a27cf5b2e4ade3821fbd33e7ed8319c7d640ad84264ada1ece2d0b63f84436e3d207fe60bde6fdaf7dcc979c63793ce7cb1f9cf3b5f75f707ddd70fff00467e65831f11ea64dba0ea387c5c54dc5b3f31537372bd62bc166196ee10889c0a64170888bebcea4269576803652df8600b105899dfaf704c3ac2fe21cc70155c59aec705670924ba7801597631c778aaac76d7f4b53172e5e47d74dcd8b72cdc3b921130b068228b51532df7605372c7a118bb50193c64855e336a3a4bad9c8de8e3a38486801131df296089082b828859c2950f223a773de7898e34dc0360d4195735f70bdf65c9735a50fdcf89a72addc3481cbbae1c9bae0feace0e172c683b9e3d40a7389f2dade1834c4ee47869205c54a4385c31ba50c1e8c725c5866991d74a8f6b18f3faaf877ffc35f79ed97ffda2f7db83f127b00b28f7f0cf1f7fed67fffeecffc99bff46f3a6bff7ae31ba2fe49ea62c459134c3031b99124c12b920a6a324840a5030d6d22b3791ceba05330ec6c68eb338176bafaddf6068ff0296f905ef69de6d5b7c6a5744b3abf6778b7698decc212c2aece888eead53a1aa7ea11bd19b34c764d8bb7df40075d9c3e39634ba83825e7b205a0b41be391f19675acc3d5f7f6989eaf96818eb20c92adee8c495f4558ba2abf6872251f20b7de88171b134391a120b374fe1e1b20249b92eda68ba3a93397d6674c9ecde890c4631015ae740054358d8789d131f2ebde0b3e8e2c01793ec3e573563e705956acca1204ced6ab08541482b5189b8358ac002e23fa7e2687f6760549fff3647a79a4c4d8fb8ae035190fcee248970a788fea8aa303c78f7cea84e365c17b1f5df2dea34baa661d49d612018bc7e11313ab130c1033a0260d77c9f4d65baf03201b834a8322e2a3637bd8f072dad51434b0aa1bcaa6eaba57cfd715ef9e677cedf99a4f2e679c6496d3dcf14a91f15666c9bde1d065d4aea1a1e1ed59c1a90666cf6e684af8e8c32b7eef9de73cbf2ab97bb8e6cd070f51b114794e59c735ba2ce6d10fc357716cacaa59dd942c97608323a8a76902d64635306ba2b3b968f29b19f3754677319151b7638a16ddeb782a8a15ee2f0bc74991bc5d464a741143b79d90085d7cf020819935dc2b16cc244b3d9ab866820e7500b5351dd5c4b44a32ccadba9fa6aea99d5e6ad1c76472b22972318c189c810ae16096f199578e395c1ac2aae4baaab9f21947b382c359c6d39b9acbb2e1baf2a0351765e0aa5af1689df16159f07036e3d53ce75eee38949c5c248d6455d8d0a0048c819936182c2792d378b85a55f846b73860fbd8c71f513cda1f823d00d9c73fc630c6fc0d63ddbf2d3efc4cf04dcf840d7c72ab1603e27598b8a7f449bbcc7133cddf56da3613c4baa36111418c8eb21ee9a7f7aa83c7fec6157b53818c64591978477495c8890461dc4c911da066a3b7bfabc2a6034a462f2de967c66d86db1b779afabc3eb0613476351e5163fbf5c8c46675d331d8d1f8e9ef834c16e265478ba86722a9bdf3363186d51ec30e9f762a59c3bc1b8695e421f7a55db0b231826bd749122a9024192d3d75a0bef840bfe346cfe070a366a4844476d59186b46848620c82154b9ecd31c65136155588bc26a525ad1b24cbb12e4749aa59219a78429ce7dfac9d289b2aad6f499f3fd08e9675496d6b089980566b2b2296a00dc6c0833b73de7ae588b26e084d4caa0b6b585a43612db50a3764ac03781f09f9229a80979d4846fbaa63a107aeb75d3d239726aae869d01ebe8ce73254ebe461e25094c62be5bae1acbce46bcf2ec91c1cd88c07f382379773de9a17dc7106c902450e77ade1948c7c2ddc188135acd781d5ba6155042a9f1cc0c520c630738e07a7f7509467174f59578155092ecb985903bec68706d453556b158fb508d66c48cf5bc3a4634106dd91c10f041bfaa514095553e7343573530c54b0ba3e72a7b09d380f34341a10356464ccadc51aba91d424c9d0735e32e91ab88d19b191ad96f1e53da4e20dc743d32dd94ae4935c979ee71a78bd2878e5ce0c37cfb95e975cd786837cc61b770e382b031f5eacf9da930b3e3a5f7151d6ac43a00c35abbae2c5f58a6fb98cd3bce04e31e35e91733f13961e0aa21a6366843cd9a91f525079c3fabaa2acc2a4fded3ef6f187893ff927ffb4f9f55fffbf02c02fffb55fda2fad3d00d9c73fcef88dfffd6fd63ffd0bfffc5fb5d67ea5699a58ed33362692212547ad6f41d02dc7f00d28d898a9696b84a5b73c024755ede1984fafa38261a8ba448fb8b021646adfd4ad9ff732a4896cc679a6f2791d75467829f8d01ddd0cd5b193f2047f63f2ad2336b26e46d2b6391d6348316afb7409b692eceb777eb7ae6e2a32d88eeec2490320a2dd78ce16deebbfb9c314b29daf0dcc2165f2d86fedb6b66edfbdb1afd624738bf4d3aeb3911f8c0cd5c3ccf691ec923a8382d828ef6b2c4d50aaa68ed78acb520a18479ac4e5a871481a67945e874efa7a45bde32dc60ec7f3a4d7e5e9124b13c9f02268f0e9c035080df3c2f2e0ce9c10021f3cbee4f272cdd25996c58ca3a43675e90d5a5bea46f1c1a3a141431d8183353d8f98a9536d0627a00f4eb4ed621917b7d1359936ea7a9265d0d41dbf4cac43b5a6aa4b4a8d0a5b67d43c5aadf9eaf9154b6799594b96194e668eb78f0ff9cce18c87d78642e0d5e5219fbbbfe69bd670305fb0ccb2e4745ea240b19c333b58b22e57f8a0bcb8aa78f7f18a578ee780255750277894eb75bdb69ecc25f031bcbbf5bb930cc646c74359daebe6f557cfa6b5a1baae6a73b55eb35e58426eb72eadcecb466453c4090683c3491e81ac7a545a5eced4adb5e578188286c13a16d1e49c1ed82513de83327154b187b862c755d110b8aa1a3eaa2b7e480db33c67163cbeaab8686a1636e30bf70fb136e3d975c55bc773befae4826f9dddf0e8aae4aaf2acaa9aeb506110de778edc3aee17396f2ee61c1b38ca844f64339c730409041f10b5186fa89a086209fb3c711f7f34d1828f7dec01c83efe7f8adffcb5ffe1ab7ffce7fee2bf23f01f373e2523a9021879bd91b46a247492bcc3fa9af4cb7629d98bb2a39be796a41c50b75cefc6a355ca44822cc3a7a36c8dab4c24ad03f9de8db4efad7c45e9559a6f099d4ce1fb029d3d2cb055ead71e7761cae744273b08e36e8c6e8dcce84e4cd2722936634cb2198b620c2afbfe25ca48a577b28fa2234c39182b51869db08926d016141a01ddadf331927a1e9c0de98d578de5c654468a64fd7d186b2877ec90241f6c112b5863a3cf86f7344d3cc1c664ddc6ac7191f3125ac76703d2aa11c9005cc4bc5eb6c0a70e0c0a938a9c4687f3ae1b6134021b8da4f3a365c1c9c18ca767251f7c7cc3baf4dc2d16dc2f0a663610f0941a504d64fbce8f65e34cdf8e4e8e51e410980e415d4b96df74bf6cafac1e083eaa6c3963c00875d380c9100b92783221c4113a55a815eada7399f823885058cb87d79e6f1cd4dc5f14dc3d98717430e353f74ec9b339620b66368b72b71ab92d599eb1f625cfcecf585725e797c2fff9bb1ff1f5f7cff9d1b7eef0436f9eb03c148c78ca86ca20b919a85c693be9d75b766349dee120a3c8f4b1eb99b90675d6dcd49e8bb2a27139d9485676a3bb1752d32f76011c395998e3a5c48b4f2b938157c91054f704445ab186a1bf6b04c712414927cddbf1ab7ae3afa269742b8ed3198d237b5580f3b5e7b20ed44198a9e01be5c58d47ade5fe91e5706659b8823b8b8c1fba7bc093ab8af7cf6ef8faf32bbefefc9a0f2e575c560d4d5d21182e4bc7f97acddc0ac759ceb90a759e739a3bac05d4c6356c3c417a0228fbd8c73ef6b10720df7f117cf82f10fe0c1a7e31f81ae3a2a3b2e0a36a4e4bd80dbdb1aaaea0ae5d6bbecf15187018640442b68be83b92dc1d9d88f1dcfc64223f95d6eb4baaf9dff9311b774fa42ba1ebceee490738928253ef086e63071dfda03245f6181c069962be4b2f59d269d7f3beb9a08ec1c558dd678c3db75ce0777dfbbeb9c1f87c6ec34e1d6d7ff8d21e0c9689eaefd621ea916d7be065a74cf314d9d8a6e4da4633430dc910b055c88a040f2480b5a0966ef6deb7dca956292e8d25994ea1ab0ffe1828a0f5414b2c0ba4d1a1e48f12b4217386a365ceba0a3c79b6e6a68c12c3451a9511040f943eb0ae9b44b297f4f991acdc1a3d4a4f01961d23489b53d3abf5eb503c6173728480c34b1c27028f3140f0a8af2358b00624c32639f0a8b4a551994c03a5af797479cd8bd59a99b3cc9ce1685e7067b98c23553347652a66b38283f90c5598678e50ad59ad6ee2f7b2c2b73fbee2abdf3ee39d47577ce3f125b3192c0bcb519e970f94bcef7924095409123d385493dcf1ae3b816eeb4b6cea2f9da2aecd731163b96e7ca734b67d356a57bc5015bcc44e879a3598a81465c474267ddb66a21b2edd660a51ba7b842405b4288ed00a5cc4113b31dbe0abbdb645b553913608ce5a6a85abdab30e7000586bb0d611ac03630921725d8e8b8c9322e31387333e7732e7471f1ef2b5b3157ff0e492af3cb9e0c3f31bcecb86abaaa66e1a726378ee2aaed573e103af1e2d385d641c6530cb1a4216f75ff600641ffbd8c71e807cffc66ffdbdbf55ffe49ffaf3ff9531f617bdf7046f221f440c22be1b380089155b1f46a4ee3691eeb135d2784c7fc646bf83aec2200193ed047ddbbc7bf819724ba7e2d6c968919db06137f8181b388cde27bbdfd59fadd6dda97acf22a4872aa6304e5f56b73fd8ad3d6daa3e9019a98ce9aef6c914d819ff7e700aa64c4e86fee9db8d90d179d1e157183820d31bc563978bfcc82091de5716193563460753faf4fa51978f38a71f824f540c13134169b94989e86e23c9bbf19ea0a9926fa2e1a706c5583be83e886ae73b3f7516e27a31e974d69d046ce4be08078b8cc5ccf1ecc53557ab35478565662c87ce2234d446b86e842b0f751add329d2bbb01b15b52d8710af3e5d7cb0046f7b93d09688bcb41321aad22e8c9724c3ec3371e558f337117ac58accd3164a98364925c724de92fa9fc9aa6f2acead8c9fbf86a4df6e29adc5916f319778e0f992de7bc91bd4a681a0e974b1a1fb89caf08da70302fa8eb9aaaaeb8bc2af9e8f10598c8595b18e7ff99e674d6020ea31a55d852a1204df64532f98092244394c16e709fa296cccd0e0ac74166a238c18ef2462b447de93d1f86c0d1b2c61965a9b05487c54692b9740a5b9bb131319d296c5f8670b0a23b5caba3fbc0c6d810d9dc77da9ea0db9433c85de409aebc52a7ebab7096a385a19102672d211d3793a49cb34c3974c2fc60c68393199fbb7bc83bf78ff8f2e373bef9e29a0faf57bc5837acbdc7d701aea1f281c7eb92d365c1fd45c62bb9b0ee79a3ec631ffbd8c71f26ecfe107c6fc4a36f7ffd6bafbef1d97f4e35bc1abcef1e64b4de0841071d0c9d506792c97cf23b79408c1dc285a902b88c81c7567e7fbb4baeb05364a8e723dcff08bda5a24faf32cd746be196376ffba50c09dfed58d52e5daa5d3fca8ece41777464aa532093c0efe5506cea737bb8642c173cc8f314b31aea0000200049444154b7748e27333691e1b9db72109f5a242d1f6880f064f8f2767250868e0f9d0adce6878d146dea128434caa43d5e8dc8466a3826ab9e10ea68d2990c0fdb656e8c458cd9ccf0eb26e9ef8f436daea5f65a0b408318499e1c066b94a3e59ccc5a9e5faca9abc0d2661cd882998d1d965285f35ab9a89432445957634c0f6c984939d381078b0ebb575b63715bef974e592d10d0a6c4e129f20ce38ae8f5906eff1a02413d5e2168944a26b9d95b47f48708e938e63988232078355401d655c97559e103386bc98dc319cb2c9fb1581c707cb4e0705e30cb73e679c6e941c1e9d27234771c1405eb557378b7c9ab0c73a2928c3135fa71c4b12e929a5514136865a76554f8d86655d181561fef932f9e6632ab9a75fe4f2c734ecda6fe1689dd1b1f90763befdedcf03bd525d7472b6e16d77813380e73321c3542691c2a06e70356237431ed1a4a8a57da9e8b643ad84a88d8dec8e910908f78545dd7301e8b1ac53ba114e5f1bae4ce9d396f9e2e38d006ab011f0cd63966b9c39a28bbdc9acf7a142f0111a570c29dc2f1dab2e0adc3259f3e99f3e0b020cf0c950fac9a401d023e046aefb9ac6aceaa06ef0de7a5e79b17d7aceae6d715feb7fd137c1ffbd8c7771bfb0ec8f75084e07f56c47c4969de50df6c7c005a695d1d26ce7de5a3981c6d17a1dbb12c151d14dedbeec8e677713480add18f6d4af0e01523b0a35bd9ab8e648087c0417b353eb925dbd6a9ef269374d391b1e034f95c5fd60fd2edcf961def959ea3e0502e75dc9de993e7436fb67f4c981de594fa920323bba052dad3d03b14815e6575f41de8cb244ffbcd6ffd72bc107600df3eaba34f2c4e1fbe9d3a0e00adb679d8664b262a5ff9e03b23c8ee2826f7e9aecb4152866ad77c02339dfa9561505e1774041abbf42fad2d43b2adc08ad2d481abab065f65182908ded1a850a980852bdf705e7bd641d16edc2a117893ffc22e842d4252e8eaaf6d19b46706a762404e0268307585848a83454151e45caf2bbc17accd50b1786c77157a94a06b241009ffeac015d8d45d116b08a121789f248e1dc1d7ac6bc55fafa8bc5258875e5db1982f385e1c307319ce790e0e17e4f60e86064b49a335739373b2807ff8f4c56b3f57dcc3fb78924cf2bdf022d109de4bec0c88743e31c1836db913f4cd5a37f7b8b607918e4a7d5356f6c0c289b503cd8bd01a6bb60732c4d1afa765cd23563cb80fa7f705ffd8e29f99444c0f38517cbb4e5a2e8ec8f45856cf87c6a77badebf1cb34812d114d2066d333d69e537aa9e08c6159141c14391ea102bc08b9118a5cb0aa187c94d415501fe2b655b198ee4e6d8c922f846591f1e0ce016f3d28f8e107737efff1015f7e76c3a3ab8a8b55cd45ed91daf37ce5a9cbd856a903186baae0f7dce17dec631ffb0ec8f7753c7eff9bf52b9f783b13c29f0bc1a7078e6c52a2a47ed2b6f6fb695ceb01a71bebdf8192934c144ab7073c64ba39d2abd0c9241ad8aee48fa79ffa05f3e1f6643ac19dcc76c715ff1d9d880962f5d69796dbdb2532a476dfda0491edf6c52478db5436475d0819795f88304cbf778c3addd6d59800003b77731bbfedb6c4d871cc864e087d8771266ad33238f7b2ad87b6b59aa4f39b21762ed21fedb99977eb3fcdd21b93c5e4bea7b0d6722e5a13bb56b69a344eb5e97cc800288bf441a644cf8d047b82067cad28968045c582cd6810ae9ac0591567ebab1095bcda119db8fdd89d7959e7700348a6fa88bbcf3ba121f88a22b3dc3d3964e11c55554250ac98e4edee7026c35897aaf4a97b143c6a2c6af3485cd7003e44077b119ccbb076863105262f10b1042334c0f57acdba6a00c3ba2c39bfba6655d5711cc81882c0c5aa615536e456b8f095fde8babe7c239f1701a5516854f1e94f3b5ee855379e48a3052d89ab213df4d67a748468cefaecdd6a7d6ca8dde78a9c4c4db77283c675e08269f10775a33c2e57ac8b86375e15ee2f0db3ab1907eb39064b83523a432d42e3853a44de853169842b91c749475930a92bb2f1ca3108161b6527d217b2091c4f0cd9a12a042c79614194f7af57e487735ebf7bc4b156cc68e21ac460adc51ae900561cfd33580c0e1bcfbf8952ef41a2b0c2dcc1bd79c6278e977ce6f484b74e8f389ee5040d548d67ed1b10a10c9e176585c98a1fadebfa97f74fef7dec631ffb0ec8f779fcee3ff85fffa31ffbe93ffb2f0bfe27435b9d95be42ce543edd23816b0f8df4408aea9013207dcec5c0644f867d8cb67897ba259da42bb2f5bebeb387f4647bb5a7e6844eb30676ff72fc0ffd247e425e7793ff8e52e3217761ab8a2fc38ddc8a51a63e4bc720613cd6b6c1189be90a1d6c60487e66e041711b8ba76739b2b3633209c874b368b60ec10e837065f7311ba88ed1775adf4805c368fc4d87dd91adb5d72bf18bb091aa5520b949abd96a3ff52ae17d228b203d243c9437dd808f8e3f35be264480ac675619f041d046a805841aa8a8b2822679fad441297d8833fab219ad8995f298968af6cc1f98b2ec914dd763b29d38448e3a20a40bc6189c2bc8b2399928478b38d7bfaa3c55edbbd19e565ad9d9bcfb7f310e158d1e22c918d11897382c16310e6b056c5473322e9923e60655e1b21142d350aed7988b1b8aec92dc297796735e7d7008343c59579caf025f3e7b7ed888f2c9d9bcb9afae9e19993749bd590097b821d608d64b22a59b8ea0ed13b8e9ee43aae312806f9a46320b69982b39937b5425820a8ddde2a0e0051ecc73eecf2d878f0df3e716576510845a146fa2ef8d155863512c188b333526813493c40a08f17888089918b021ee81449543d180d53496d56b8caa86444a371b5e8c067c53b36a6a6eaa86031c2b6fb969944309c90fc6258f9af41e6c1472d0fe3a0788ea8a1dd41787cb840799e5ee5278f364c6674f0b7efcfe9cf7cf6ff8f665c559d9f0c1f975042f993bdc3fb5f7b18f7dec01c80f48040d7f1931df88266a92d4527a65e97eb55af5a5340f7d5992df5732e9ab390dd4b6767fcc668cdef408ef2d3743bbf19e3e4a7a9922efb450d62e17f31192e81f9fdbe6875e7adc7a1e17db506fabebb0055a5a1028d37d800d4f7da32825a33c5a27e087c8d647a4f7ea4e326e1f5a0dba582a1382069b81ae2d7033f5fd76763e46a74c991cff1a0874f521e356f3ca4c7e23492325f4af913e16e946969441cfad2f65cbb0723eb90eb455a44b1b0e89afad262deb04b6545937f5064a3987a8c7f8d6fb61e4c0de259cc258034cb7967f7f286d50524818a6153948a05f046333accb52726939b019abd2d3e89a461beaf2061f3c42115f671c2679e9a82aea934791b5581315fa5421f880518fd82c7d4eeaee1843661c21040206b5055228ded75c956bfcc58aeb55c99de3199f7ee3148be7a3a717dc94354f6445e5d4fddde76b9749c14f1f1df3464404414db08260834477794cf4e3908d7f0823cf0c0620587d2098b180b5625121765d4451d31e47c343b720b38254012a4350c3b987da4170118459329cb158e728ac60428def0c6263f746a521205871b1c9a410249e239398ec1a22478320582bbd82d2c6ac130dd404c4299908cbdc5258cbbaf25c9625778a8037a905d82ac4e946f259633b64ebfe615207497bfd6b8bb270303bc87938cff8ecdd258fae1abe797e8357cf7b972bbcb5fb298a7dec631f7b00f203135e3e10e4d7805f50f548e8733574ab233048e8c6d98bea10acec0211b29b343d785cf5b269ede43237554afa5e0632f428e92b76b19546eddcb1d1175394dbe8ee2fef8a309ef19f2c3b8f7fdd871efdae421f29c8d0f8acdd8d8e83d12a43f524b3c2702775f21b8ddc0f74bb83415761df18d3ed86202f857adbde30130a5b63be8bcaf69675d419da1e7093ad46918c80b6b20d8e75eb3c4e80a4be4268f2d31900eb6e7deebe1e7463e23e305e54d50d593ebddfa449af103c5505c61af23c47bcd034f5a6f525666ba16daeb56d31eb2941b701e7851ebf4b46d786089a404f13024d4800c81a6c96e310aada4088e47a8c8d09abb151da388428592c0663b2d46130103c3e3404310475712907c548e4b668b4cfc09a5855c72e68ea328e7549c9cdaae2838f5ff0636fdce1c7debacb5bf7721e1e81af6b9c3104111e9fd7fcc3d50b7ebdf1529f97f61597f18593939bb7e68b85028d06820ad62856a533506dbd933afe47272220aad69a17e58a8f434d151ce7556085c1d8d80fa9bca7112128347543e30399137213479a6eeac007d7375c05e5c1e901f78f0b2e6faeb18de16eb6a0f481a50d14ce2575b310258f43a4b67b1322ef2348e4af988def87126882070c963cf94135a828262dee2604ae587120b0287266591c4dacaa86ca47a165d5ed8a91282f2dfaf42f85bef6823142668403c9784d32326bf8f86ac5179f5eb376b3fdf37a1ffbd8c71e80fca0c4177febd7ca1ff9633fff9f8b985f08dea3a689f3c303a36c1db997834e752a5a90f05deec31493a1733defa7f923426c3f851a7800b26d843dee0a6c11a3452640cacba6e5b701da747b6202a10ccbf4e9abe918aaec26cb4fb8ca33822a1b795b1d38feb5b2a95315f869e8b46dde3204a9df61e8c43607e4661966c2f4784663c03238c6d39d21ed69204f0fbb6d77960604771956fd37c04e4692c9dbc05ab7db872fbd0a5a43cff1f515b7db760942fc3f6323793978ac01e7728c182a5f250e424cf007d7c40e27edc139991a15d46d079e49d5e9640ee851d6754d559504146bf30842d4329bcf696a8bd81c05cab2ec247d45c0baac771d459d2824c4227b6b8418021843f081a4238b6d3b00a1218448d5b66e0685e2eb35cfced67ce383e77cfae192a3a5e5273f7d446e6baa4a78ebf5396737810f9f5ff0cea333de5f2b5f2e57fcc1c7378b5966f9a9bb77f989c51107210482a091a31ebb2189b4df1e9f40db2152cd673373e6d77c655df1fce28a6f5f94940a45ee70a25c3535a557822a7513c79f2c42661d9975548de745b9a611e1f3163e9959bef9e81954f0dae11139cadd79ce9b07471c66964c2c2e7a9a63d46343888c103158137b777486960163a5e366982088b19d084108f0bc6978cf5ff16ab064d650d60d52d510e23eabd28d248ed783be6ccdf7bbe95d31235e594684dc5a5ca1e426e78de31947b31c25df3fb0f7b18f7dec01c80f527ce9b7fecefff4a33ff5f3bf1982ffe9e03ded70701c43093d6f905b1a015380649a2831f9f66d594bedb979b3adf19a94bafae06130d09594b876c11dd9d1019001d1427656ea99485d771d937ef6a7bb52e6091cf1726ec82e47f44d97626abf3aa778fad2a2bb3a45bd1ecca4498bde7e005e06e406d8a6f7834ef7acfa1e161316271b6c36f8fda49456eff5db004b651792ecafb11ef5a697846f9cb2855d9db797266863409fcc09db2d1a31b15b80906539ce65344d836f9af8561bbd3f54b7fd1f36a20a13aea03a21b32cbdabab35d6ec136ba4477217c5870840826f5055f23cb628326739581e47d9db10b8bebaa25a95048dc9afb30ee71cde079a2612d321fa1449df4b457a2ef29d33a7e29b9ae86da4a8c9305981188b318eaabae11b1f9ef399d74ff89137e77cf27ec19dc272b3123e698eb1f98c6797477cf3f109cf2e2b5e5c567ce9bd677cf8f48aafac6ef8d82ae56569b2caf3d67c51fdf8d1911e882dfce894856e01ea7ab99c85fbf9a1395badf9472fae78ff7c4580d8e130b0f69ed02ad575f7324dbc8a764c0a16b925b8c08a9227e58af53a709db87607ab8ce755e0c17cc9b1731c39cb81c9986171aad8c40d8966e7d1ecb16d936626fe9b11133b52bd6b4e05ae834772e1ceb1c336117c67aa2cb24866f71208d1f8e3bb8f76a452b70b3922b1d3e412a49be70667e525c2ebfbd8c73ef6b10720df97a1aaff9a887c0502ea7df441e8f92628bb937952b21f06b9936c48ea3bf1c7d8188b9d49e21659612b4dee7974688f0cbc6b1bb788f96cb1e27b067c9beec90ee9d8fe44ca4b15b664e72e8c73e2fed8cf64bd5fa740c990784eafcbb37d68a62ceaf59683745b6621bbb7b3e54338d477ede1a7c943b6e148f427b5fa634ea3e336f81f61070a9cfe790288be74b4a4cf2c997cf1c803e6bbe92349eb4b1dbaa4cdda0c97e578efa9ebd4fd68657f7523bb3a41f098f8710748eb7740061c97cda23422a815b01625507bc588432550350dc618968b82bba77770229455853625d757a0a1c104302e2a34790da8af53272376638d753159b649916c30a0183b2fa18eef115b60ac4b9782c1e64b44e0e9e50dbfffde190fef17fcd02766dc5956e45658aba352617930e34f3c38c659c78bcb359ff9c4095f7af71917576bceae2ace42c95555f161a8f23f306b0e707cdecef8ec7c11e6c60489862d71240c965508266854a8f212819b15581651da366b22313c330663c08944d95a09d15145943cb7dc5fce78ebd852e48187cb8c4775c555551380abbae1aaf21ce5371ce519272ee36e91732fcf39cd0b8e9c236bb5aa348e5099044a6d48ab28159cd42409e974951db88ce3ccb22e3d65d5a0024785707f261c1b87e009aabd71c35b6e753beb2621f17cb423aab73e3bde7b1a3cc124f182b097e0ddc73ef6b107203f7821e65d21fc7788fc15f5c9117d68b7cd467c37fd371acdea2734da958887999b4e90c263457e94fcf4cad883747f2253d7c97c51982ed94f809d916ad6f0f5e3f68e6e438f9dae87dbc9b9bcfc4593f3632f83020355abbeb158bf33d4e325ec36461c7deaa879a01359c6b617a54ef226a6775e87b845a7b1cb2e5274df78f056728d8e40884ce083094a8ff4e0ed000c0e08dddb4851d9616c29fd55df2ef35d277b02a42410127c93bc152caa4ad3341df868b91fd28743d21fb9ea8ffac970cc4d260c3a65347625b28d865b3e88219a0e26c5300d82f7355615df047c55e28a0c0364d691bb8c5a25baa32795264372278ffac689c6a289c36052c21af0be4135c442893558eba264b1b5186b09415123642ec31b585dadf883f73ee6ce91e173afbdcefd458e38d0e05855e0b1dc3939e4689171ef64c6ebf716fc939fbbcb074f2f79ffe9351f9fadf8f0c9358f9e5d737e5571be5ef30157fcc68d3327ae306fdf7fc0176cf6345b57f72e327bef463c34354dddf0eaf18ca3b9c59ac0bdc2a135101ca7c58cc37941661d33e3b04658351517f53526573e7177c1dd3ce3fcbae2a60efcf8dd438ea5e2f155c3aa0e5c370dcffc8ab3ba245f1b0a312c6dc66931e3c172c9abf305f732c7d21a72eb281c3875586dba4e9a26f5320d81600d4419618ef39c276bf8dd772fa97d465114bcba34dccf1a0e8dd03496da1b26e5125f86a349aa5b6d412411df5b810b4509a2d40482b4d6867b00b28f7dec630f407ee0e24bffe8ffa83eff133ff7ef5b63fe8a0f21ba1127df00a3b1fa14348cb9e623552186e319136a3b3ac1bfe83809225bc9ac0e2adf5349b86ca5e7aa13b2b42f9b209be4d6cb7619782a41dff1c4dd3984a4b2637b2fdfd7db767ccb974f5eb641659acb328d7874c78e0ecfd73498d19d5dad5ed2abbb282db249d4c7f34109588cc493b7f670ec73b053c4ab37d2b3d9bc6c54866020f33b06157db76cd5495c335cb9426f0c658c057b05009d00af892755370dc1874dd771871dcd8084defb47d144ea1f73717a12da7d0533d91a4fec15155411eb108992b821c4312c0d0dd757d7a8afc9f30c41687cc0b9194a13c7afacebb9da0b2679b1a83169fc2a4a217798327882af130f24c7e57914baf5016315eb2cd65ab0d1c7c2640bceae9ef3c5779ef2f5b78f796d7984016c6eb973b4c4658679e130c0b2701cce0d770f0d6f3c9c51857b5cae1ade7d74cd57de7dc1373eb8e0f1b32baaaae178968131bc281a7e63b1b8f7687d83b9b8b9f7d0395e5be494583e73e784e5b221e80d79235c9d651cca11af2f672c9619d65a9c5844036755c907eb399a2b6fde9d71e095a7e535ab4cc9c4f14676c0874be5f9aae6ddab4bbe7d73c975dd507961ad706d2b2e9b8a2775c9e3f59a5766334e8a8283dc71e81c87ce30338e5c2053c5024ea257886ae2d50006471672ceae94b3a6e6674e0f78fbd8702825333cd7386e15c3db26090e564ce4be785c66702681d7107a251e417158eb70d680df3fa7f7b18f7dec01c80f647cf977feeed77fe4a77efe7f0edeff8556916690caa96cb41ab712c93eb7223041c31d5661a7e6df758a7f20831110ddda980e12bf41e6b795d18d469206b5e87182aa3bb0c528bd95add600dbaee4a3147887a7e16d3c99ef04446d0da54d1de256065687c9f9d40898f092b1b897eda4ee4a44b6ad3ddaf5a03bc7e664723bc22eecb401111d8f42876fe8bbcaef0496b24d7a5776493b0fbb691b8d808963325e8bbb51f00070740027753e7c3b96d29a808a6cfa2603118951435387fb232365b1aeefb2d5191995027a8a748366a7f778dfa40d18543dabaaa2f615d6b4868806b559ea5ae4d8dc91192504655d57344d4d4010175f6fc562711d720bc18206d4b45e148e2a54789f08d812418ab5193673b8d99c72ed78f2fc86dffffa337ee87ec1e94186310d774f7216b38c103c4de371591c052b7d8dcb2c77e6330e8ee0f4f880cfbf79cad9c50d1f3fbde49d8fcef9e0f1054dad1ccc0d8f2ecef8e8e38f58dd94bcbe3ce1cd9323965981293216f72b0e0e1be6a5a57e72c80177b9337788f388b5e402de07569af1264b2e44a8d4b35adf70f7604991435d7aee59cba70e665c56cab72e67fcee0bc707572bae9b8695f7343eb0a6a109cabaf1bc285714d632b796a32ce3eeace0e17cc69d59c191819986e44dd36b6c8960711ce5479c6615416ade3c9af1200fd05cb3ae84d21b9a10d5c75486d7e2a43ec6e0461e3b6265e331d621b6c738d410af1f1532b114e2709114b37f48ef631ffbf843c55ec3fbfb201ebefef665d0f0cf060dc526194d8a27a944dd3985f4a6a5b64be67d03aaa95c4a36c5ce897c4bf53612b34cfc35d48dd24152f45dbb80745bda22e40e0048dfc96b6a124b0655fc1db063305f3fe91e3e094c5e46f2d669d2e6d82c436ff9bc5b8ed5774b08d549533b61f770d9144a93293c38f24fd905f0f416802813dbdc3e7fdb937d53d996ec5c4b5b96f65bb2cf3201027508aada6b5064a022d4c18244d61e6f6de0762d3be4806ff9697b9f37db6d7fdf99e141c7dfb02edf10c88dc18738db5f370d3e44b2b860b0366396e72ce639d6462e42208e57599791e505b9cb70d6619d456ce4b9600cc6588ccb30084ddd20a23863a8eb12ef4bac8d268641150d356559a24179e3c121af9c2e719970723467398f1d9448d48edb56049767647946662dcb99e370613939c878f55ece271fcc383d749810a8ea8acac7cfcf8c72e0e0d8194ec472e9d79ccd2e78f0c915f7160d2732e7202bc89615955931779683dca25aa146592c661c1c1e9115738c311c6496833c760a1636e3242fb85338eecf1dafcd667c72b9e4d5c582c33cc388444e8c06aae0b9aa6baeab8a8bb2e4bc5c735e565c79cf4d08ac7ca00c9e3a3da24332ae1489e47483e1a66ef078de7e6079ed6e8df8060d96a0396530189be1acdd8c79f6d689b48380d2de05b403124dd350fb40ee1cce1808104248a28b4208f1ef67ab86fff7f139e78de8f9c5e57fb07f4aef631ffbd803901f4800f2e98f54c34f07ef3fdbf746882044275493e819024e8fd948f718fa0ea912136065bb6cbe830eac3a9d6fcb28a1944d9a7e6b3addf31d1118ba440f3ea4f579d8fc914988320233323a3249a77ff0ed643b01d7a9c4562740820c20c068be7fe21cbcd4497207609cfc69d39779a938f31497a87f0207e41065607238895b749aacbf0374c8809f2ed38047b669e3bba0675faeb63b0f223b8f99a6045e7ac97c7f6d8d4196c8081c753f9b21e8a3b73dd90091d68d7dfc27fea3e9f988a4b56ccc8067d4df37634c22be4735a596af23091c749f686c1af369b761c85c46e6726645c6acc82872834da61e9a7c40c43ab22c272f8af86f86ee7ee49b8a109a8801831282c73a8ba254e5354103c56c81b551a0d6aa50d715ebaa663e9ff3c9578eb97768383830b822036b09eaa97d83b58e453123cf2c467cfc938a23de2bce0987737870947358585675cd72297ce1ad431e9c16544198db8293ace045b5e6dbf50547af94d8a084170b66fe009335ac43c34ce6e4145cd79e8be0c96739f97281cbe72c3530d726ad77835383c3905b61ee2cf78a824f2e177ce260c12b0773eece738e0acb61ee981949fb1ba8bda7f481d207ce1bcfb3b2e2e3f59a27eb8a17b5e74695269debe8c5024a0d4de45f1477af599cde0090fb02631cde145857608d8d9e2c21244e8741d46042543053a3a8d974d5250812a2b1a7330e2bb6bb8e0c11f8d521e0bd72567a7efbf1252f6af600641ffbd8c71e80fca0c6c71f7eb3bcffdaa75e40f8575ad5116d2bbc3b48e753232632598f4fc98cdc9217f69da3fb49a84c7b6c28ec4c01bb2e405f32567725d43da4a23d9ab9b045a49f4048d399790f934c21309950ea925ed51076bcf1966f3cdead97353376b343f496af2cb7af8197c297f10b267646e4e500756c7abfab4b32fef7e936ca04f8d93eedbbbc34764aa13106cc13d2bc3bba80b2d593d85c1bb2b533b2dd9de8fe1bbe5f44a6bf888cba7b2df8109994c1de801bd35dd7d212e05b69d7d1828c5c8e76f3517a37778e2c73382718134d15c55a506812b17e369b33cb730881ba6e689ae83352d72b9a7a4d508ff71e0888b5785f53572bb2ac60b13c2273395637aa7d555573b5ae395ce6bcf1ea012787056273c0505625d57a85b39659916324e09b060d829041c83092810abe119c184e66967b77735e7f58f0a9870b4e8f17345816eab8670a8204ec51c9ebaf2ac77e4e717ecab19e90e7e068302a48b02816328347795e290d96bcae986b0d2a345e111f8194318218c1895058c322b79c14190f1605af1dccf9c472c12bcb39c779416605dffa77a431bdaa09ac9a86abaae2ac2c79b1ae38af6bd64dc063f002b5782c8e2bbfe66a71c1ddd72a166e86ab9680a06d478a08fe7cf004a221a41009ed4a83d706af354a40b495948e1d96560a38821e8b35d145bdf281a0ca6515f8ed27573caf740f40f6b18f7dec01c80f723cfde8ddafdf7be5ad25aa7faa1b47d09ef2cf20f197a1b6d460dc68aacadc73d79651d7602a83ee039151a2a75dc360acb9a4e3f2f2ce51b0cd2e0f090bfd5d1ca8fa6ee102998404725be62cb22311eebdf776eb8aef34c5ff0e92ff04d47a6edcdfc976273b415b9b9e22814c0800eb14707c091fa29f666f75c5fa6d91a4dcb68b37de9dfbf1fb98e63b0dd6b24c9eebaec03f3932378215aabb61e5d49a1bbd4eb63a6eb7ea810d17e768b176db1b6d5f7ad7e966cc2b8d5cb5de1cfda24167fade2b3848dfdc34b15452e24992610dada29596a48d810000200049444154b1a80a55021ad608f3f902e71c5555b25a5fb15edd50556b7c5d7655770d3e6d0f7cb9268486d962c97c718015836f6a546056ccb146b8b8bce27a5df3f0ee31afdd3b659ecd71e2a8cb1a0d0d799e610cf82610c831143833c3a8c39a0c8b43d44088cee6f3a5e570e95814d183e4836715efbc77c6f965c9e951c15baf5a32518e9a03eefb7b2c7401e229f58a955fe1513257e0ade51b4f2ff8bda7571479c1219e3931b1af9b8034da414bed49508b082ea95d2db28cc33ce37456706f91736f51703acb399a652c32879168e8e843a00e8126045655cd55557359375c349eb3c673e903eb004fea6bb2932bbef07620d7025dcfc8d4214ec02a8ac7879004402cc644a181106a9a5051858a3af8b8de4d7c0d5d17cea4f1bd6842d8fa91d42120182e2ae5b71f5ff2ac563dbfb8d803907dec631fdf75ec49e8df4f272bcbfe81aa5ef8e08f48b3d893d2b4f409cd1b0f046598c14b9ffcbb2b7dee7539646a6847866338d2afd4ea78bbd3ded73b73f1114179981fb6aa49ba954c4f412de9e7b5b243194a6e374cffcec8df7acb6f6544ebb8edd86b9247fe0e5cd1b5f5781992f8f5a507b77f50c6dff365fa5ab7b313748b5c3edaeb244ca049eab3751054ddb5f59dce9abd35cdb4b7c8f84b4c68fdeef238191ee4e9ddb87584b193cb95de58e4c407e89619cb9644f1aecf5031037028531dcbb67538a513910a1ac6baf491d1cd3d848626c42d370aa1f1947585aae29c4382a75c37dcfc7fecbd5bac6d597adff5fbc618f3b22e7b9f7dee75aaabbadbd5ee3676bbb163e31825cecd4684804c4488040fb604e2011e7843f04624c40b2f444242485c141141800859383691822d4c1c0b62623b76dcc6b7aeeeaeeeaedbb9efcbbacd39c7181f0f63aeb9e6baed73aadbed4e55cdaf746aefbdd69a73cdeb98df7f7cdfffff5fce592de634be064c4b3e371be0646d9b5807accbc9f212636cdb76b520cb4af2d118e70c4db3e2cd772ff9a5df7c9fd7efdde7873e9b91e796d3f1842638a2062e2fe64431dc3829b02ec3ca9aac9fa482c110a2e05bc771e72c3e46ac496e2d6f3ebe42e70193dd420acb7b6fc1ab85707262188912159e379e85acb86d2c86112b6ff9eab3055f5934bc72eb36bed850ff8d2ab1031d9a7c3b3ab3c9044a32c08a21b7861323dc2ee0d5b1e3b3a7239e3781c7cb9ab72f97bc3d9bf1705173e93d8d0fd4284d0c7855e6de63e689185e66c232cef9be55433d37ccae2a260bcfb41c618d12f044521b9ec5926c0ad376192b88580c4a94d8828e562e19922bfbd6ed9bcc07559388c0ba8aa6ba3ede430c31c4100300f94847e6dcff19bcff65849fd4d04ae4ee0991ecf6b66f92bbedd9b96b92533996dfb56bd8011cba93a1efb519492f49ee274e7adc4a515fb03dd725fd475463775ed323ebb8cee04e3f4081e3058edbbd1627bd2ef9177dc962cb7666adbd8c5a8fba941ceef9d217e12ca16774d6f30151f64a45b2051a7b3c8975c47659d9d60e3d26f0bce62ff5d5a11273a18fabf498d2682fd9bffefad7ad24fd486f9cea07b8163620f185c4f2837bbea32ad7bb3165af1cd80322f202dc4652efea96683f18d1b67a6191a0547e45a82b54234551628da1a92b5655c56ab920049f808775ad4a9e767c132386e02bac7314c508eb0abcf7545545889ecc0a55d360145c5e727931e7b7de7ccc671ebccdeb774f3879654aee2c561c8b4a592c2326cbd2f7d8ba3b17a2114c44630da6e9ee1d55f03ed2c4b4734d0c785f737ed5509a82b72f0c7516f8be4f37dc3ef1e95a2c2da3d23242c81bc5062046309608cceb861b366cb403424c5e2b4a722297d68c5c23a29a5a9c348187f5c44fe9e0d439ee9619af8f46bc3119f1fe62c2bbcb9a77972b1ecf573c5bad58f948a381ba4e9c111f935f48156b2653387f5232cea6049b1355b0c1a26a0808a289ef6362446393aa1ace624cf285c1c4e47aaf16d420a22dcfa73f31d2f20d6332b74c1591561840ccf0601e6288210600f2518fdffad55f38fffc3ff7e37fdb06f7931aea9e0382ec8b90ae4da4f4c53ed12f126fda757038ce41d0ed0473232575d0c88fe3c2a92fdee62e3bdcf517d97744577609fabd19ed17a68eba85ebaecf39f505c9fbdadc713fa13dd666a57a0c24f5ab49b2b5bc1c3b8e5b98e19a4acdae83fb2e49bc2fd4253bfbf2823635ed67f8d23bbe6b4537d94eb60fb7f9e9012f9b9debb08f3cf59a0ddbedadd20ef71d80a87d03c99744ee2fbae4d7fd847d62ff817b4f0fde89ec385e1fd3923e7ebfee4ade2992cea992924b63f111826f08be26330eebd263a3aa57ac562b428c882b30360119f51e3460484684698644c9f392a29c106364b19811a3272f0a5494d56a96ae816830b6e07c56f30fbef80d3ef5e094b27c8db311184ded4493d10d6c31c658d0581125812588680c8450a30ad619a2b3f8188808993114d6707b9a33368693cc3091827bb9616c12a95b6c4dd486696928cf32267546b80209015161545830c2e5aae67616c89c2584e473628d76d2b96237e385464d6470956e2c5493ae24dbfaa8949970eac63c188ff85c889cd7358f162bde59543c5c563c59363c5e2cb90a912c895311b1c42ae7dd87274c272553a38c334f565b566a8822e4d630ca0db97a0c3e2d582b183046310256daf64ad5a3a2256bc54521f56da77dd6e1a13cc410430c00e4e31292e53f6383ffe9e0fd5fd4d872417a0a3dda375d13e9da00b626a8a55fc538dc7322c70082eea4797d17f55e85a38f3d0ee6d6ba4b22160e792f68dfffa14314dbe041763b5776db94646f91ed19e5174d485f936cee3544ed91b877925dd523ebbdde14f0e0bad73202a23b559497039c878c02a5df8eb475a28e187ebc48ffe050f541b467d5220716d01dd0a107c8f0dbe86df78ce8d6bad6c207d71ce39d33a97a1495ed57e754af439dc7af2bb63140ef6638bcf86e8ba0bca4bcf0910f6d7c45b477ddb4ed44b42678ad3f902aa9c2d1820fef0375d324f06153e50355625341681023586bc99cc337354684a218e19c63b19a532daec8f21c29cb64a81a35b9a91b47514cd0d8f0b58797fcefbffa265969f891cfdee66c0499cb9814638c2dd01088aa44bbe6c4456230348d6234e26c0449a618455ea04618978e4fdd1cf1e913c59271568e78504e315a6373a1320d51034623d54a710dd044aa3ae23592b902b1964513a824624588212443d8a8189b2a04c9c4351dc7b8e63cad278b44401c71cddbe9b569e5229c8872cf5a5ecb477cf674c4b987f7570d6f5dcc783c5f608c129d4d204b227ffff7173cab2fb937c9f8d1fb53266ec2b395e0116e4e0a5ebd51726b0413a7e4c6a64a4c0467944cc0269398d426270aceecb556adef89f573c687c451d13854408618628801807c2ce277fee1df5b7dfe877ffc6fc4ccfd445d37aeaff1bed7f4a35b506027d53becf42c47c108adf3b25e9f341f4a50553733f47b184337b3aef467c17793403d9ab4efb76bc90670c8f6f71cdb37dd0133c708c3d7367bedce9aab1e4f36f57a2ff4ebf9ded7bc29fdacffe52d0bf545125cd76399039ba3db0870e79ad063d75877905295e350b794f42a33c729f57200c80a87bc2775a722d6c7135b9506e96ded81eb515e70a0f400ec3b5c3a7a118e91831e905bd547bd6e95bdd6acb6fab206faba26f9771307018d8262302e478da509c9453d44ed4d7e281a52e5c35a933c428a31c6586268307941312a51855057c4e089c1d1340d2a82cb0b9ccb097545d0085158ad6a7efbcb8fb97963ccbd5b2326af8f28acc7c832293885b68ae04c4b924f6d4f31cb884d850f2bd47ac466146506b5608de1accc78602d71965a8b6e9f8eb0e28804e6011c86f94c39bff0dc7591d3a8488ce46db26e4d2b4bacb10315562cc6f4417ccb9b581b679af439d30290204999cc5893da07e3ba021131041c1167858933dc2e2d9f1897bc312978ba9cb0f09ee81c4be0d7df7dcc6fbc7dc9b36ac5839382b103a7155f3faf5878988e723e713ae6fe49c19d89e5de74c4fdc99493dc3216702626e0466aef0aa2384357cdea8759179c7d724bf721a0430a31c410430c00e46374d2f2fc37a2c6ffd737e14f87e83b659b0d69b997d44b4ae224a6e462db0d570e645072303b3ee61cb1474cee39a7ef4e5a47ddf74e4f099f6e75a16c4f74cbe1e4f09a4c587792d3cde2075a9c8423904b0f27e8c7c005db9c96439591740c5e846e8eb5611da8d8ac89dc7b07ed2591c4c1ae243df8f6c183bd674baf5dc275ece4c8de3ec835e7757b0b64efbcf6a0460b10763d41d8dfc46d6c7c0cdc1ec21851b7af979d63d6551fb7da100f994c6e838ecdccb21e596ef716dde7d81c412abdf6aede7134fd0fb4e386ac2b53b1779fb6fba4b1ad6a269524ef3d3186565dc9a47b2306d08869fd4146c51897e754750daae445499e17ac962b20b64edb0e0d8acb1c2ecb11b188cd08b64650b27cccb29af39b7ff890576e159c8c5ee18d073999cc512c5e8120143623770069165f4da49106bf9a1123b82c11ae55851084aa49b2c2991366f50ad511d609b346c10a13eb7836333c9b0be391e08cc71b18e7c90dc319e16c545022186bb04e53a1454d7213d744d8d63541a425e5af6bb3b1f52c314610bb9e1689a824325f301075c3c3284dfa776a33ee65962baf44a37c6d35e3e96ace55d360ada518655c8970b558f1f5d98a6513c896198fe635d3678e93dc72775af2993b359f381d717fecb83bb24c6d0256de5ca3ea9e204877af85a009803290d0871862886f2e0619de0f613c7cfbcde70f3ef9b9fb31869f483afbc7da7a7afdf03b86817b42b5d7a8991c6af9d82590ebb50bebd62cadc86eba7f583af55086d5299cbe7063f7e68ce1a596916353d7c7f378dd8562fa8203f3f29c9c5daa3707c1c6f518e1b0d5de4ba86b1d80a9f282b51c556dd2e3e7e7f029936bcfa9ec5de3b2e599a12f3abdd79c974335be2d4e88c8f57e293be7a70317ca71f429bb068bd701906bcebb1cd1e45a9b11eefaae489b564af2af404c3793bf3eae4636a47291e407a16b6023a66dc314acb3b8aca02c269465893186aa5ae24343598ec8b282d56a4e5d2db036a72c478cc623f2a224fa866a7105409ee5389361b392288ed97ccea367338c55eede3258db8059127581d719593e43ec25c6cc115912e315d678540c388b1543ac615e095f7fb8e4fd77afb8a58e5196533711573ab086f35560ee0de3ac806808ded02c034f672bbc35541ab93286576fdde08e516e98a46ca59a0cfc8c0a11499584b53248e7d96250e8247605c51ac1a0f8d850f99a10420287c61044882d0727b973a487756e8442327213388f0bfeb05a32b3969bb74fb9713a62de04666a688ca5c1a0c612c5520761d528b33af0f06acebb97331ecd175c550d7508a849e695c61a9c13acf404a465c73127c2d72f96fcdafb97cc541e5e5d5dfde7c353798821861800c8c7245efbaeeffb4d34fe54f0f50d6d65343b7a84f47dbe377a9b9d73b31cc855b6127b39f23a3d55a01e097ad305769842a18713c83e1879817ddf866cdddbb3bea99b1cc550c73487f478e2acd7f8971ccdf7f5dac45675bf29e860fe7b4c0a560e1cc183c52a7d0128e9cdbecb3117f60368e1034c741e95d03df629b96e45c74d0cb7fc5ee40072ddeda7ebcc3b8f6d9eee5c73ba0bd30f1f697d812de4d677cace8f1e12107a60440f9a40ca51a39a8d8fcd964589ace59876eee93e77ac75da4e2f992db3c3ce8c4eda0622637a60c9740a5a023897511423f2a24024a964d575853186ac180142552d08de931725d39353c693313104e657e7d4ab1999cb188fc6c9f8d0d8b64ae2b99a2d797e55312a4b4ec725ea23d5ca1155f03e49005b4684ba207ac1d80c91111a2dc12f982f57cc1ac3b30bcf93870b6e89e3563922cb1cd1586a2c8fe70d8f160de32ce7665932b296baaa58d435d37146966534aee0ce6442111a461a10116a1f093e746d7e31ca962fcb7a3c5692899f02ce589c11546392db0d8929e22499002635649b54a7badea7f4c313f0da70196bdecd0479e516375eb94de384d9b2e1c6ed5b9cbd7e8f381e136d4630422342b49680705957bc7f35e71be70bbe763ee79d59cda281462c62844c52a53c9dda357f25b6d530a589f087174b7ee3fd0b9ece96ffcdaaaa7f6178220f31c4100300f998c4ab9ffa4c0c312e43087f46632c0e25ab5b66e1da272ef7522ad9ce7df6676277f2b4a87b89d9b1e44bf488dced0b13fa632ee39bf78e01891d58f21209f24bbc234772f9ddef3f4456df2285cb0b96b9a6374b0e923d5e0032645f07f7e88e5da3b9bbebb4fd8141c84b7cb223731fb520df79791f45cb2127f123877aaba2744c86781f0bbdf8832f3c1eb2b333d78128b68ebd1cdd4f397a8c64cf14929e11e1e6671f0c49c731498974f2f4b03df0d19fe000695bb4accb70598131a695d95da23192e525ce658410f0758d18c3683c613c998228f3ab4b96f32bc418a69329655122283e84e42a6e1cde7b2ee7358b154c8b096536c6c919991dd38448ee4a0a73135fdd40e30434a7f242682aaad52557f58a4632e64be1fcd18abb6279302a18d98c65102ab13cab3ccf57152296519651fb0a0d0d93d2726f3aa6c2b014c7495140b522d7086a58d535cba62268c0e030e48891b6d52d398b4b5b69b2984ef9aa7f969c183263b1d626a9def628dbb59b7d7bdc6b8d5c6a4d34914580afaa70999754ce5165caa8c878e5d57b94af3d406fdf223b3dc14d46c4c2e2c5d04458f9c8d2071641b96a02cf170d0f670d6f5fac783c5bb108812a2a755bd159b7f746ef91105968e0f72f567cf1e18c79edffef555dffe2f0441e6288210600f23189f7befea63e78ed335f8e31fe700cf17331c69d1c54b77213ddf50ee040f561ade92edb95925d59d60d67f77092bf99ecdd9f4116959df44f76b150afaa219b2a896c2a26a6a7fa7538b1ec25473b4a33b235c37d285bbd8e25de3789389281ee72325e08123e48bc947de37728e483fcb98395856b2b524756b675360f1540d856863b7abc7678462f03ccf4a5cecd81cac7eeafb2bb0f3df785be77caa16a906cc3866d8cd1bfa136ced662d65512d96e5beb2dde25bcdd3861b65cd63772db9bc90c6b2dd63a4c4b06f7bec1fb0650accba0753d07c8cb927c344d2d5aab25cbf925be69c8f29ce9c929455174ea68d6585c96272f91d0707eb9e2f9ac663a9df2e9d76e73769a331dc1a470e462201a62cc5936c27cb1026a321790dc929563cecfe1f9fb0b6e89e146966111ceab88778eacc8a8a31262c439e1e97c4e53d7dc3d29b955163c5bd43cf3919be38253a38c31a09655135836351ac14ab6f1d868c7aaed3137b53a490ff4495bf5b06db5696b1c5c8f772d576719039551c679c62ac057eac0130c8b10510737cfc69cddb9893f3ba53939213f99929f8eb16763dc648ccb0b3006b5165a401954b9aa3cef5f2d78ebf98caf9daf78fbaae1d1dc33ab3591fd3511d8d40796aa3c5a45be71d5403191a7e7177f6378220f31c4100300f918c5c377beb27af0c9cf8618c35fd6186c2adb9bcec9b6ef94ae079320d99b61dde6c2eecfb46e88ee2fa1b47480b72d07a08220c7f91fda9bcbdd4d3cbbe46a934c6db93df7f753f6e69ff700c921f5a8fece1c25ef6f99ff1dd8e1171d980f9ce87f58f4f78fa84ebd34ac3a46e63ef4b21cac20e816d4dd513210ae69c7da3d57b28d3dbfe543b3cb7b92c3220cb2ab7c254781d6eef52e7da02fbbc684dbd5902def52e9dd29adf15cd74ad4ad7723336d8cc5b4e0035542f09d2f872018e312ff21341863285b39dea66e582eaea8ab250a94a331d3e90d5c56b4c21469dd795192673982b0ac563cbf5ce215eedf9b70fbcce14c858d2b24067ca32c1b58d491f9724e9e45ce6e588ae90863c63c7adcf0f89d39672a9cd88cdc386a552a6370458eb3062730c92d5103b98157c62527d6b16c3ccb18b95538ee64c2482ca8a3f611ef4372885f9b31b6dc37e9f1ebf6aaccb22bb0d01b59db76b80e3026f63acb1090dc30758667ab862f5e2d3877199a3bccd8319916e4a3926a3ca2ca738ccb30e30c3929c94f4e199d9e52dc38219b8ec159028a8f4a1d0255885cad1a9ecc6b1ece6adeb95cf2eec59227f386451309115043740e6f329eacc0e7e3d7bff1fec3ff64781a0f31c4101f340615ac0f7914e3e2ef84d0fc4af0fec735a43e6411836adcb4b4746d131b92811e4d8e0fc8f5f67be95b02aef4bc4476f9125b399d6e137b0f9283fb3e13fd0284f69325dd56b312b926d79503caaf7a4420eab0bc96f6c9fb1ce2595c633a7848c7f58f2c3e4ce65f7a4d87da06111e6ffeda56573b8456d60a61b2ebf171d08053afef783b003efa6ed0ecf9cdecff7ea8e9f0f0a1d90641dbf5b77de5af7d127b5f8757d969b86c6fd9edfb447b80bf53d2da919fdbe5856dbc217b5e439df77cfab126a703440dc46e1c5ab76d19342465281107c6e01bcf6a35a7a92b407059465e8c3059465408aac4a85807d666585b50a8124569ea257ff88d4bfe8f5f7d0b23aff2cf7c5208a6c6048bc60c29c01511ebc15ac8b2c4dff0ea0831199a4720b3c2d8396e8ae1e9a2e2e1aa615a64448dbc7b356364859ba3022b16016e16968bb0a25e5d62b231ce14a8319426a3b19686484093b19f08aaa61b32b7ce9cc876957a1775ae419e91cda5df9efecc08ae5de26251f3feb319cb3b39c5cd2971044d8c2cab9a3a06bc08d60a625c7237cf202b47b8b329597546767ec6e2d153564f9ed35ccd699615f16a46b3f468806ad5f07c51f1f6f98c3f7c5af2fae988d7a7056727232a9351453dce491a628821861800c8473b2cd61779f977830f3fe6578b7cfdc493b65ad125f0873c0c7ac98cec000ed1e39044d7f2b8ed87360a419b65756f065af656b5677827d724b247dac10e25a58758db72b00566036a8e3a941fc72887b7e5430712be83e064eb50ed733ff63ded39a2a6a507908cee716f74cb8d73f75e801d8dea839b770c4c1fae030ad7e871ed6c7a7bcfc981658eade2da55efc3a30ec774c042b715bd8e8a1ff4aa4b5b1510b3796f07b8180c626d5b916d1d318c05b1781f8831e0bd4745c88a51e71b22088df7d475933c45c41234190eda6cc48d9b25c1afb8b878c26ffcdefb080d86bb7ceebea320a3cc4b4623075985988c91351023c10b311a423434ad796a2e42662013c3a2aa796f5e71f774ccd56cce3bcf2fb93b29b8fbca4d021048a4ec45b3e22a28af4e8491b388383267296cde02af804a4c92c547274964cbae67334f24fb933edd644cba76336308a2345e993781abf98ae63430ca733457fc6241655bd7f5b68a8426f96835101c98cc624623caa923bb3d6132bf83ce2bfc6cc9e2f1058ba7e7846545582cf155455d7b6697731ecd2b7ec740e62c38c7a2118ad3d35f19c6b22186186200201fc3f847bffcf3fe47fffc5ffe473e84df6aeafa4f7aef37fd147d373ed55d5dac7e41a337bbd94fd8db99fe5e8542b6f418fb5de0da9b33d6ad7603d56379e70bd8bf4a6fc675eb09be8f337467a6b16b15e325347875af8f5e7afaab7d9f3a3d58dd1800c71f3920692fccb5c7f9768543b6aec1ed99f943abdeb9008fb5daa9be60bb8e2c776c16780f24eb5eb2af087d1ca03bb3e2bbb414d5b655ab57b9d083a86153efa07fdf1f929deb0a1afdfd6b8f7b1f20c9362f47da6aeb7a7394a4c667ad0331ddc447e83c425252eebd2784061121cb47b8a2a0c80a4c96d378a5ae9224adb58618c1373521443257928fc6a875183b677635e71fffee5362f0fcc40fbdcaf77fb26494098b7a814129b3924c1aaad592ca786a851024b5128942ebc0aea4aac8387714c6300b0a5111550a6bc89c430c84a87807b6104c190834a86618e370ce914787d7d47a460bbcb65b04b72743a4535ad3ad1eb883b64022682b37e88904ddf0499293613a3f2ecfc9f3026f2c560513054324c4909681640a6540acc1e505d934c784084de4e4b53bf88b19d5e59ce5e373e68f9e515d2d5879cf2a28549e10563421226238f5f1d787b16b882186f86662e0807c04e29db7fee0eb9ffaecf7ffdb55b57a107c633659c28ee24e6f3a5745b71e789d1c673fa11200b349fe0ea8f628ec8b561d9d8dbd067c1c0522bae5bfb0e795280778caca41b2eede975c6beabec3149163b9e6003ebe3d718dbe5aef7c6ee80ab2d3d277dd393aec16b2ffa943afe837bf0fd778dcc8a1df762ee2eededce16aec79831c7abd7fcc7649ed9d1cf6b6d2dcfa37233dc189438a5a90cc21a4958e3549ce95165069f00018eb129889c9bbc8589b12e0bcc0da0c11430c21b9a3b7159388126392a81567890a5555e17d4566841095874f6b9e5f464e6f8c998c0dcbba4162ce241f6155592c97cc2a2168c9a3a775f20189ca0de7284c46a3c2a50a4599e3506c8cdc1d657ceab4e0eea8e4acc8b1028fea15cf8de7ee1dc7d93491c76374102da9e3351235b62d69b6c7a9d9e6a5edf278d632bd666ba8d60d6869cd64112100b511d4189e57812f5515cdc9142d72bc7a2679c6e4e4846634c28bc3a9604451932a6c36aeaf6b6d650ad792bb82cd0c2eb7e4d38ce2c684f26c427e72829b8c31e3097632a23839a1988e00253491dbb76f7feae9b3677f7d18af861862880f1a4305e4a392ae09ff419e677fa75a2defc518c0b89439689b1c6c759a2457e00e0aecccbcedcfc3b58f445dcf8dae11806e1e96fa222f8c1d3071d0ed6de7053930790ddb6c765d577474eb61bfdf55a24726bff57ad3ba3d77ecb63cd2ff3900916f435c578de85fbb6d42a7d7fb726c27fbfa5280f845afe83550e9e01a76db1a0f1a491fe9ff939695d46fabd4feebdbba12b2c5f1a0bb5e65c73c46d78971d797b54b54df544eb6846365a7156d8f6bb2696f146bbb762041109ba469312d58694dfaa22ada56245453c5014940c58a458367552da9eb154603a3e93411b3e74bde7c67ce2ffeda7bac9a3b7ccfaba7dc2cc69898e383a7aa1c950ab94bdf678d746d4f2a1183639c65bc375ff2e8f28a9b4ef8be5b136ee4202152fb80c7f3de72c5bc8898b1655504d478f03ef566ad8d1cd5a4f1d46c442dfa984d0ebae4680f2c266f108d9a5ab9acdb80c3b6ea55c5482d4a6385acc871b923d40dab5545b406758628828f8ad1f4905f1b4a5a11542d2a61adabbe0d941ca84d7c1157169c9cde60f489fb845543f0011714b35c72f5d6db3cfeea7bb8ccdd1fc6aa2186186200201fe3989e9cfcfa72b9fc07d6b9bf12abca10437a306aec9cbab56ba93a90d5efe543879582f64566afab672831f65aa30ee694fd950bd792bbfb2f46521bc11a1809071cdf8f7749bda87b4aaffbecc1653e4cea541f1570720069b6a69c8741cbdeaf7f2cb0e920b8dd01eb5bed513bd07ff3479f15a30750504fa16ee7f3f4ff5c738a277bb600002000494441540eb696ef019623ea65bb7f49db5e29db1936686a6d82445077d6251f89902a1fd66680100969563f2a4ae8247ebbcdd2b4bc1143f035c157f890bc286c9e23360703f948d0d8f0e577e654ab40fd05a1d0125f412e81aa3184cc51e0b0d65116191394dc1a2426d278686afee0e173de3abfe24fde3d6522c258206860b9ac68b4e1a2f16467423e1542a63412a18a2091082406c8dabbc31cf0ffd980b7f5b1eea8743dee8fa2849888fc0e494cfa354050e5a26a98015741f190a48f8d23560b1a1ff1aa34285e15db717dd289526c1a3871e97a318a41116927934c8607a28f40c48c856c2cb818094d001fc99b125bcf993f7a8669b7f93ffef7fefdac6a6aeb0bf786a99effa9b2fef2ff56e4d577cf3caf3f9be9affcb73ff3db0f87716b8821861800c847307ee9e7ff27ff27fed45ffa9b7996ffab4d5de7aaadd40bbdaa81ee82807e466db6dcb5b739d9da3dfc646b29dd242caafb4a41ad7c8bc603cf613dd4ce7218dceca63e5d9f7cec91c7555a10d29569b65ab7f67759f753bd3621587f9b2a3def9303cc797dd9d473886f3f26510e491fb09fb2772209c2811c7eeb827bb9da86be24495c0f563c0e5cd7bd77b48f16d6958d830211691e5d352593daf237369c2dede049e23849bfb8b2b53ae98110392c05b0f96cc7a6ee01bcae1dcbb49e176bef90d84afab67fb7e46a6915afd69500ed717a342a750c445f1183c7743c8792180dde37386bc9f282a65ef0b587737ea97e9727cf567cfad688691e89e2b9796fca1b2325b7c249513052102c754cdc15173c4d5d1363646a2cd4914b1f12793e362c43e0429557471993715a66b6f4d8e0c9344b133db0716f5f8f711b13a3ee9a4a45a9d893574ee7cfb4ac9008c496dba4d2726dd6d76d4cc74a8cc5990c6b6cf2102933b2e8c0826f8d218d4d13406918930e7ceb5a0bcdb4588488b4db1f3144158286540c33068c2011d090f6d15adcb4643c299880fde9bff8134fe6cfde7b3b2ff2efaf2e97ba983f33a699fd57beb9924773efde7de67f0af85bc32035c41043f463e0807c84e2b537beaff64d75e6bdffa110fc467e57f79dcbd7729c7da52cd3124765d73b43a497e2c8d6b4acf67422b7a916baef35c2b6b0e976d2a2ec6a0989ea0ef9b7bf9c1ec813fbb6763b69a5ec278c724826f780cfa06e7acfb6258907f0f11d8ebef7871e4e923fd0da7809c0217f74c52e39fedd72ecf3dabf9f0fd42676da18d7554fd16db773fa6d5b3b1063ff16d61dc3c41d7f96febfd664cf9a24c1dbb9a7b78004311de7a175d943a5a7d6d41a79aaa456a4d0d4c4d02018ac2bc8b23c19135a07d1206a90d6415c440821523591cb79835f34cc2f1bde7c7fc9791db97b7744080df1ca73470aca68a89ae47f610446061e8c0a3e332d9010f9eabce6eb4d40aca58ec2330377ee5beede0c34bee1f21c749593f91c6912903236434d4658ab111a839164faa72284b5c4b02a5136e394413129cb27aab6ed690e6b0c62e89ae1a246b086519e53abe32d1f69a61932cef0168a5146311a63ca82682cb4e3baa167f66212df44649f3aa46dcbaeac41a449ad5b0a6888d0782c914c03d3baa2b8bac42c97e331e195fb766e6e55cfcde2fc429e3cb9b4abcba579fc7cc9fbe7f5ef5dad9a5f1ac6ab218618a21f6638041f9df8f55ffeb9b7f272f4b35996a7074bd4d44fbcc58fd821a7d32b6240578a47b4f7b16bfaf1d1ddf46c4370ed7146b4a793d5f149d609475b3d59839c5449899b35af9393de72fd8dd7b89dc0c49d062a45b7be6b5d0aeae38aeebb95ed6d8bb137bb1ebb4ad2f692437c47e0871cb9feb640f6070b3df26feb13aad77cf2c56bd894e8f4e0db726cabb4bd06bb97f62b86daab7276dcac56a14ab52574c7d8dd43aa74f7c79ee904bd3fdbfb85defd4a3b49d01f51045a27f0043ea4fb2f010531a6031fddfb2adb52e12d70e9843144b059de39ad03a90ad0724a34469ae08980730900f860995542ed732e17c2ef7ee38a2fbd7b4ee33d27058c9cd0083ca92ade992f89026f9c8df9fedb2332ab3c0b9167c6e2a713eccd53ccb4e4f424c79519d13a46e228c562d412a2e023686c791f515a32bec38a4d6ee8aad4de33ab2a2eab9a5550822659e056808a26284d4ced5cc658acb3603795e98862044e9c72e23c4e0378a5f19e102a7096281982c32421e0ee181a91c4bb6989e798f578167b5e4d496dce0ad8565c4bbaf39d4e8e45b059463e193399e664bec2cd678c9673eeb2e2bb479157c739b7ca090f26635e9f968c73f7f99ffaab7fe5e6dfff99ff61348c5a430c31c43a860ac8472c3ef33d5ff00a3f51af56f77c6836629c1df830db294bafed43761d7bdbf7e256f2b59b871df14d380854e8253dd72c756486777f7a7b672db22dff7b789dbdac4a8ecc726f90cfb57b36c4771a805cdf22f56d61e51c2ab11cba5c0fd9815c8386645762fae0670e40945dfec5cefab6e5a50f704c84edd2c9c686bbab844aaf7d6897482dfd69f4d6cb42d6096fcf3d7d9d04afd7236b99de6ef049fd40d2cef89b76dadf1883b5194652f2ab3112439aceb06d42ed8327867a3331210900a8c9a824671694c7b33967370a4e4b8b5e2e19370d95572e83d2280422573e7219e09dd98af7aa86b39309b74e4f207318148d35732260310bc5d419364e8821c78775a354f23ab16623971c5b19dc3a78aa108922b82cc7599708fa6250848021625b05ad8d816cbf314f01b581682a1ed735bf73b96496591865c42cc3496a4f9332c73bdb35d79a9693a2b28184875b0ccdd670299dc8431af0adb1386b91ba61f5ce2366ef3d61142d378b92935c29ad837cca74348258b36c1ade5df2a95bf7effdebbef23f7a369afc646edd5b0f9f3d7b7f18c18618e2e31d0307e42316e3c98d8788f987abc5fcb3ded745d498ba8b653b4f891ab7678a5b3dff7d77f2cd6ceb064aac15a0e2f104fe58feb6c76dd76b16de35a0d3ebcdd7f49821dc3ea8eabc424476be5a87f6aa8f487cdb4ce88f5d1ffab2cbf5a091ec3b2fea61d5eb1eced9b92f0e7635eef0a27a2b5691ce293d8d0e8993b12bf0d6f113f6be63dbc5feb027a4f6fc2e366f6c4d72b4ff5bf324a407985414d33aa98b80d580b4cc09d180118bb192b8234d2012881a5131a0868528444ba460e96b2a0f8b4aa8826359058a5543494151e618e3793e5f72190cd6591ed6705579a6a3c0ece99c19f089d250ad6ade7b56f1b5772c6736727f24bc32167ca384288c4d468ee05a07f4d84e72ac8158298622832882356e03ec8c80daaec35334241e4dcb07317d2f17b10485982dc84e5614579095134c31218e0ca18ef8a6c631699730f4ed0fa5e70f73509d9c7525645fbe193104d3724ca21231782c014b61339c1a561eb2a260629437dff7bc7dbe6215cd68b9aaf2ffef0fbef4f92fbdf9e63ffbfcf2ea6de0b786116a88213ede3154403e62f1953ff827cde73effc3a7de37ffe272312f630c9b87cabafd61ddaa11756be632cd3a1e6f4cd756d2b3eb2e8fba51f93c2833a57b5cefbd39d843ccdc2d699df5cfb89fbc1d9ce3d6e333d40763871c2203f0f850c421d3b617a1906f59fdea3a97f36f7d5f7afe7f3b6fcb3557af1c462b877c27a4c703919defed6dcbc65b65b3a28decefb6bf8848cf27a7e5796c5edb95f4ed6d9b4949ae9a56b7cb98ae0abb21b6a79a82d38035d212da5355c459d7ceeac7c4216143b01663c0e6485682d85425692af2dc72ff744aeec1344a8c96a0c2bc899c3711b519e3bc24627006963ef2a5f325ef2f6b26794608354fae56bcfdace6e1a5276a4ee64adebeaa7877d9d018d726e5a0d6116d720ca775805f1b31aeab3c1be5b2de44d07a6cddc80f243e8c243011d570e9e12abbe2aa5cf0952a635edc44c623622988afc95c8e9d8c09d612dbd6abcef2b05d8fb420a3dfe6d63f4f6bdedb7a722af9b72461136b8411ca9d6ac5edc59257f3099fbb7d9b3b238b27e2ed08e72c5f7b76ce7b577316647af3e6ad7f1cead5773d79ffdde96ab5fc7259163fb7a89a611c1b628801800cf1518aeff9c28f7ca369ea3796cbf90f3455ddd3e9970df17c8798de278ba2d2714164ed7dd16bd75af79aa34738107d4f905d07e8dd7c507a7aa07ac4615abfd9446f17ac5c9384ea003a3e6ce0e3a570c20b30e707bf9eb6ddc5bf0d3bf7c2eddc4ee665e790c89143d54b300d5b2d387beee822dbfee9bab3b26e51e9e1988d69de1a80481fcc749f950ecc74c9ef1a847459b980c494268726b55fad2b06da0a66989414475db71599de58667159012ac410c88ce08c522f5784066e8f4fb014ac1ab85c79e68de04d8698822a92408b35bcbd5cf1f655951aab8ce20c84289cd78659104eca12e31cbffbf88a372fe6cc315408731f982bac30d418a258827578b1d462f008910d3f4f35b61c9b48d490a65afa7cbd9e184883f0a8aab9b457acb29a2f2f3216d91437cdb163a5304a598c30a311de984e5bcb88b0914533dba202bb40573620640d144520860440f2cc92c7c09dc59c3bb319b724e7b5d31b8c5de0d162c9d266dc9d8e31b1c219c5bb424e6edd7aa314a6ab678f5979ff5490fff1aa6a86017788213ec631b4607d1451a5914bebb27f92e5f9d7c4c8a7628c10d3c32cf67912c4b653a32dcdb7098376ffdb9fa1d39ec6ed16fcd09daefbbe69e08b668ef508c8d06ff5f97480c3a1d78194213e14f122cec50770e3f840c0e59bfff0b7b873bb9fd0bd425dc713e8ee6fe96e21e90949a4361fd9a863f56c19a5574f4a6d5ada1193b7777963feb931314de6a67280ef223d4f12e5805a97aec1476f9e400d1a1b8c06441c4a24468831f4f82d4a883125c84eb03125c949be5609a141bd2798117956b25c05bef2de8c50591e8c4bea8567365f112364598e6aa06a3c41232a81674d64e42ca708e7b3154c4a0a7b8acb034e6bc84a9ed5cad7ae96bc3faf785447de2947dccc1c6745c128cf191719378a829322a7cc1cb9c9c8255248c0a19818534b598cc8fa1f064c7b3c62ecce8db6aee55926e4d6d1c411a5cb286dcda858629c418220d6e2c5749349a61ddfd73c103954f95a9f8df6bc832036090418115453853c12204462ed992d6af2aac1d5cae56a09d2f068b1247363a6057ce1fe849b6365f5fe8a87171794e382d33ce7c2f9d7110bcc87b16c8821060032c44729feeefffadf45e0af7fe147fec20f2eecd54f07bf424d526741cc0670b4aebba8a24692308af42a131da848ca2c6b9ca0eb8462b7b77d176c1ca82a6c2958c94665e53b9fcd0ef1e14220f272a4a36ffa945fe714a27f3cfbd8f130aedbba5d77f83eefa38506bd5d91f61e5c57130e3bb16f9b96680f4948dbccd33548f5bc81d6a4eb6478d7bfcf0539785cfbdba01b477b491c3513aab6858ad6d83012a24f0f2e491591e4189edab2742df1ab0adea39254bf7cf448c8f114cc7ce4ada74bbef6e88abaa95836154121331601420c781f11033772c3e74605a506cea3303605991d51f919972170d144bc5a664de4f9b2e6a2f23ccae69ce63977c763267941661da3cc715216dc188d38290a6e149693cc521a2133915c1db9d1d46aa6318dc3ad1cae1a938c1dd787c9c08d120a29084dc9a908be08dc98d4341eaeae80e9b43dbc2dd15fd7d594d89b6f919eeeee264c5b7989444c6ca5b0d65c20230920a55f099a8c1023ca2a045c08440ba342c85ca4280d773427b715cbab25de3934c929bf5ab84c86716c8821060032c44730fefcbff253eeeafce9afe545f16fd47595475590e48a6e92f7ed6656541582b6e6b87d826c2fb368e568b5259e77a061e7a76ee54f3b72b97de401c96d6b000043fcb102c7ebf8432ffa0efdceeca7eedc37721d28db90cfb73806bb6edb6db542558fc0aa759521b6a6a1bbb1a99a6e9974b6e21422a6033ab2bbd1225b1494aee5675d818d01532d379e21edc44644db8a80a036e5d32a1b852623c95c4fa3d2f83ab54e394315233e809a1c8b300f0dd572c1a25a269343006d12b06a3d3a10e5d4947c7ee278bdcc788e63954d79f3caf3ee7cc679b562641daf9d5aac71a8082b1fa84360d578667524734b0c9059c3a428b83d9e706b3c615a664cb38c9115c6ce70ea2c532b4cac65642d058ad38815d24e623632c92859b42c2b435d1b328994be213cad595c7aea85c5e537a11de763a77aa5ddf14dc7f4d8b5945e309d38c05aa84388d1638c60ad302a32eedf3ae5dee594d365fadb1591cf4e264c4f4738278426b9b96779cefd3b279c38c713856818fd477fe6b5b37fe77f7ee7e9308e0d31c4c737060ec84734defad26fc7cf7cef0fbc5d37f5bf50ad160f12195d36ca342691c83b35ac4e277ea76fbc67c617d7de1c6bcf8d18b712a463348ae3158e017c0c31c48b438e820fe17002b9fbf98e01b2d3bbb5a1196cf806fb4a5574fc8e4e6a97dee77a84f14ee94ab73905b2033ee84bf4760a58ad1748bd040d9d6bfac62748bb9632d3fa8c7444e9be729346a2f7a806c4baa4de8410742d432e1867b0d626de85981d57a3f4bd0f4ac79fbb5df0855b96d3e988ca8ef88359cd97cf2f59f8406e2d67e588ca472eaa1adf82840854d1b36a1a16edbf79ddb0a86b2eaa8a27b3050faf665c55355195ca071e2f965c36813a1a96de53fb40ab474c5461d388251060512bf3205c6486b9af78fbebe75c3e5b7273522267a784c909c1d904345baf954eb550ccd12b48b619469bf3a48ad601ab90112962c3d96acec9c525279a615c81cd229fb891538e467884f962c9f365c3b99970e7de034ec4d35c3c631e94c98d935ff87fbef4ee57877b7b88213ebe3154403ec2311a4f9f96f9f9dfcaf3e287eaa64e6dd8a6f5d40d6d49be978f4422465ccfc03c42ea00e8b55f25c0110ff87f6c1b04b2514e19628821be05f0f14162d701a52f82dbe369b4af6aaf64b969816a2b09ad992862367e41223d318acddaa56bfd5ab778a571434c9bbcd227cb6faa30db3e268236158466bd75ad246d0b2ada043af145d204c89a4cafbbb40611ac73389721c6812a411b827ac41a9ccb28f21c5794ac1633e64d438cbeaba6388171e170234b2c0cd608b9b1b8cc223609762c43a40942661c99b158895b477f2dc3ab0a4bef5985c0b3d50251c159e1d59331b74ae5220aef5faea870bc723ae5ccc189136e8f4bce8a9c02a5401823940a4e322679c9d948b83736cce635d5bc6132121edc313ccc6021a9f52efa80c182a6aa10d6e29ced14b0b475b9d7b52b7b00899b63a89208f3b135b1a4f2a8f184b8e2e9e525fe7289aae14e6659d5c2e34b582c965422b8852706e1b4742cab19f9ec9c4f97705e8b79fb7cf9e7feadbff4da1783d6e5571f590de6bede989ee972b9d088aa2152cde7aa8b0bad9b9a55459c5755fcfac5ecd930260c31c4004086f8a73c7ef167ff66f5a37fe1277f79341affd67231ffc110226262372bb69ecddc54355a4e468f499a128ab5fbb2b6c4d4d469d107217be043151d0a1c430cf12dc60e51e3fa3f77d03fecabc0b520040e7a8cf4e71eba4e1ddd109735eab608d966b622419c5eab901cf034d148d70a269de948fa4c8c1eea657f10d95457db76cd7575a58340da7faddd06937c36acc930c621088188892101037504150c169b179402bab8a2f28a0fa9d5d419e1649ae34e0bbc33d898538ae324cb295a395d1f955ac1b6aee566edc6de2a72c5b53561cba3f031e2dbaa71681455cf388f84084fab15efcf6b1e2e57bc763ae24659f05485d3263235c289319c89e5c4180aa0b68eb951a41cf1a03861e9579c4ce1c60dc33bab8a66b1c26791e0232e2f12a13c2ac61aac188cd94827af3937da78a28fa945d7daf6f54e671d23865035041aa45456b5c73681c6a4e3f670b6e48bcb058f6bcf5c233744797552104e3c6fcf1e339acfb9111b168b8667ef9dffb53b4bfd6b8d345c5c04900b9a654d55d7c4183537128a5887337c13d0f8246ab354790ff8c230260c31c4004086f810c46b9ffcecef56abd5d3abcb0b9a3aa98e88759dc4e23acbd0566637cd3acab61d88ece4196d22d36fcfea12996fbae2a107667e0f219881bb38c4c71184f4ae7de58841e1f1d8f5dfd11e015c7ae6817bb6ed7d15ad96bcacedccbeb4c612ba96776d2b1f68ecd1d40d7d4f433ade8924a2393625e4aa4835df945b7b068a6bf2b544b3012171b371dd986336fe266b895f8d695b3406d66da8c604144bd0884470ce319ddec02d67cc5735412359269c4c1cd3494e8ec5d405b9cf28c4608d45c4e03555714679c128cb5986805118db0c2bc22a7a1465229688308b4dda7755acc08349ce272605b3683076ceacae99d50dcb7ac5a4c8c9ad659265dc2c0b6e9705b78b92339731b182d7c8133cd538e7f466c9779f9e3119479a006e017ab9408b80388729c1388b3319625b27f3de39d5a8e003a1aad3e1cf8a043e6222bf1b119c739043a34a5337b8d3829bb7a6dcbabae24e931163e462b9e2bdcb2b9e2e3d97c1739959c678b2d0f0ceb33961e5b99709cf579eaa6ad095a10a4a1322853dc75f3dc73711551132e36e15c63dc8a5f0161a22d1193f8c05430c310090213e24d15473737a72f6eb9793e73fb65c2c8a182322b17d886f128d75af353b1e80a2d7a5343b6d5851f966646d3b00236b31d18d59e2260b3a94480d2065888f1b10f900d7b6ec428e6dd5a9f4866c9ccfdbd73b827a5fa6770b88b4f7674772371da8d04e10780d722262ccc68ba8ad586c3edfcace567308817e7b56023a3d5961d1344e4505937c42b6c42ea2a6997e4ce23cb46047351043022022428c06824755b16288d690d98c513921fa48151b4a67b9e11c6363b06a68ac419cc1188335066b4de25288e16434e24e53138d908b70d31588b1cc7d850f9e3cc232441631e08c928b5038f8d4b8e08eb358cdb9311a61cc8c55e3793c5bf074b94a0476d32a6895256765c9add1885b658e68c38c86d1494e19059cc348603276dcbb754ad45396cea5ea8d4b8ff9464183478d492ef324b55fd5642e6833871743b496d0823c69cf9769dbb1247304c9a8bd7232b67ceefe88dbb3828b65ce2b9331367aeee60d359169667990c3531fd026a21a298ce15669399be6bc31716863710856566808542b830f8acd2df7c796db19780f9f9c28e7eaf44d77235b3cfafae06038c410030019e29ff6f8b9ffe5bf9effb97ff9dffc2f47e3c9bfe432f70355556104544cd2854f3d119def956a6c956576e742b755ae74ad6ad5564d3e88246a07533ab7f41e8bdd6cda2d76b3a8246bbf51fbd17ddd9eb655e465e6848718e2430c420e6091ad978e2a65b1a3807448656b5b58620be6f7d45b378aaeda199c8a26a3c3f5fb1d0f6c9de9aec716b369a58acd0af155dfdd64f3dd31f68c54dbb161ddba453768a531c408a2969e836aaaec86480c01342457728d6814a28238085e517c52ab9a9c90554b4e8c72d7e4643504eba9c552bb805ac5194be91c53e798e68e93a2e0d6748a2b730a633821499d9fc4113e78eaaa61399b1305ac580a63b85908f74a471e132099161945965185c4790931c9dc36b1a15a04ce572bdeb196933ce7fec984cc08de44deb83bc1d91c4c81951ae32d85584a0c414c121609e9d8946288665db952d6057003e00cce66880ad59ae8ef36247f0d0940e4d31282633ebf60b1aa988e956910d08ca99bf2bda54188981c8891a7f38aa7f3150fc6397771bc9239befb56c1ebb72caf9681bcce19a9e569ad3c59d4d4992317885628cb8cbb6347a1f0c95a7912acfdd3218c7ef111030019628801800cf16188bbb7ef3dd1e04fcf9f3fa25a2d085e71599666f034a01a3bc7f3838a556bef0fd56ec6718b74dee185c3e0e3d03a3bd2a8ee9889c46349535f67e7807788c801d8f101678c8718e2c30442ae7be70006df9e4ce8b5601d5b93eebca9ebd7942dc741dda853a928a8e9d089ae270562ecc007260d0042e27d48b5d86c74afd75349fe1f6bb0b256ecea3c323a3527ed70d39a442e6b02782b1fde2940694caf89a00608a9106cdb59fecc3ab2f194915ff17ca1d44d46a315c134446dc040e62cb78a9c4f4f0a3e352d59912478830a8a496eea28c6398a2c552b4ce6b1a1495c0a23dc2d325e2973463663a6961c43660d626ca744a5edf686a8040d54de53fb8626069c11b2dcf0faa282a6c0980c5307e6cbc0c3f79ff27e7d851f1798f1887c54928f0a8ad2128c69eb5a8269c1470c91183c314442db5646eeb0d6d2f2fd13c0b4166385d8186459a006a28b68a6604142a4cca0b086e00c1755c322cf1859cb7795199f6c02a5b75c660536832bb7e0fe24908782d5d54d1efa8695f19c9a9aab5611ec355b52cd172c162b7c34722ab6042ebf5d77d64f7fef278c46fb09549eb96897fffd9b5f1954548618620020437cb321998b93c9f46747a3f1bf36bb38ffb40f1e8d1663d203130dadd1977612bb5d1f96b6fafb2419de8e78be96e0dd010a9dafc01636d1a393b1ece437fb1bcfaeb9c8617f36ed799a74606443b61d60c8101f693cd2031beb5ae5e63edc543c0e19186e70c636d897bed9e8cefa653d2120bd96ac35d8d02d9721fa32c26b752c8c12bd877ad17146faad56b4fc92a47641bf476cdb2bb1b78169bbd6e4f5b8e1acf4dabe365e29e95ff43e99ef194bd4c4477002ea4abeba88fc5f0fe7fcd8fd82dc198c1a0ae3382d4bc6a5e1076f4db83dc9f9e2c59287b31973ef29acc3b5db64aca1b00e55a1d65475f628c108f7c619f70a87c90bb4b69d84af11938c15312da5c5126224c4d02a520995f754aa8cd5b0bab8e4f13b91c62a37ca88f7cae377ae783c8f84c2914dc78c4fa68c4fa6e4d302cd1d665c608b3c11e74d92f50dcb80360d226dcb964b1e90ebc1d3388b1aa1a93d04211b4d203882289283b7c24c3c0bd7603c7cf9a2e24b570d67d3924fdd9d70b5b2ccce973c59467eff728e0996cf7c12c24d8f2c61e65ee1e6dd92e7ab0bde79fc90c7ab39923b623ee24b0fe73c7bbee24eee8cb8d1e8db751bfda77ff68dfbbff7b8fa0f9f55f55f0d812741f9db7ff6f5fb3fff276e8edffc2f7efbab03ff648821060032c4070d1f6273fbee27feb3377fff8b6363ccbf4b5313bc07f18021f6d4ad345aa289982dadf8de13be6f3818751f20b0fdf7cb31427a9e04bb40443ff024702703da4f58f40008e989830e17c9101f3ed4a1eca38397b859b630c59af7011d6f627b99757543b6e725daffaddb22bbc5e2a6bab93b7fb056c5eab8247e05d17712c1dd07766ed6248cb1b317da032a3bc4358d8a9ab49ed85643d672c29daa5fd88c5f2a86486c410004e3d0ccd03481ea79c5c27bfef957ef60b3827b9392cfde8c4c59f2c9d3119259c285526b64193cabe05be0975ac52c893712625217f4282eb3dc1817601d8d5a3019c6588c597b9b241065e4ff67efcd636649aff3bedf7997dabafbdbee3ac321392392a2ac500ba56889adc48a0cc7572714ea000020004944415488144308623889ff09102b8101d9888100419c18fec7412c3b01a22432ec0089603b8621230a1407b10227301c219223dbb2164a96288ae470383377ffeeb7f65255effb9efc51d5ddd5df72ef1dce42caec4370ee77bfdb5d555d5df5d679ce39cff358bc0888a11143a4eb54c7fe3c1446c89a96d9d3196711ea1c329fd14c03d3e3198d42562d083b35f16c41312e516f3045862f4b8aaa202f0bac1524082239784bf096680db1c77e2b08291dc04bc9d03630af23751ea951828185b32c12843af299a339bf7254f37213b97b50b233ce396c1a5e3f59f0ebd39adddd92575f2a79309af1a5c3391ee5951b13c8857b0f0f79b848386d89f3445d4d482d782766624df15edc3d7fee473f29f9dc5ae6c1568b667f37d8dfffc651fc0bc7a179ed8bb38698f8a8c57ca733fcd8df7bd0fe2fdf7063f7ef88ca3f2873f7e437ee3fd982916d6c630b40b6f122f1337ffdc71578f4c96ff9ee5fccf2e28f378bb94b3180b4bd467e27c328283145acdad594c52a17188c5be992dcd9ff45067043552f55259f5fbad5174ca42e028dc19cb9720588d18139d915e6bfd70293777a24ef4372095fd139d9c6d73b2091ebc4b2aef8c51557be5ed52d1910d27bf2f85230422f70c574a87cd56f68d95de97c41faf7b4750740565c0dc37ac872c055317245c960093e74609b971035a8e92666349acd02c846f7463b1062ba4e032831c68ea3612c4a621195796c6925a104ceef9ff1e957f6d99b38be35137cc8d8cf32a662c98a9a3c73d81857421eda1f5f8b62e9e46f05032aec94193ba382b971a838bccb986405b9cbb026ac94a7b29e2f22089926ea18695224aa9219c3ed51c94bd588d69424a0d4888916a7353124da103ad9e490601188d31a5cc74fb199a31e9594a30aac106324af0a8add09d6188c158c81403f96d5d7a39c7318e761d66dbb2672d4362c52e4b089bc75de50b490a4ebae58852c2a37bcc58c729e94354511b87973c22baf562459901e7ab015a9cc299de1f6fe0da6b386e359cda3e386d73e7287eaf60d8ad32393a6f3af1880fcd97fff5fa84e4ec34d52fa903b97eff086efaa5bbe6d5e9bbd5087571ecf1b3713b87d678458cbe3e386c3d3858931fddb31a63f6ae00db5e61f7ffa95bb3fb963dcaffcdc97df7ab45d77b6b18d2d00d9c60bc4ed973ffcab6ddb1ccdcfcf6fb5a14553ec4dbd86aa53bdcbf920cbef5cd0bb87b6d2113875c8c3581244753d70b5d918b9ccd7587752f45235f67227449e9daaeb055032ac9ef619d26a1c65359ea5ab844b450769129778be2f3071ff3e828f6d6ce32bb884e445aed04d04be09bce5daf72f47b036c6a2b8d0ddd08184de70642a755ee1daced66fdf90eeedee51d1e148a76c6c6ec89517197e145dbd26695a7147d6ef59ae5369f9a22eb1ee4197188388e99cc7638224ccc5f03439ea59e2f8ad7b7cef37bcccdd91a38c2599786a1576ab829db2e4ac8db431763c0f3a1f10a3e09dc13a8336609372a72a796952917b474d8e8d965196937b87588b51b0c6e0c4f6068716ac206d4b6c178414f1cef2d2a8e223d5983333c1468fa746138c7dc29a7390448a89c5bc2634817a3ac758b3eab42c72cf79e6d1948831528c4bc6b70ff00713eca8c4941e719de2575a9e70125684bc2a18db920cc13868509e2e020f4f0377b29c8fed571499f052e6b86d209bb5dc0982949ec73b4a95953467963a191c3995cf08754baa1bee8e4a46776e70783ae7a8055b07f60a61bff42609f9c5abf83b7fe05f931bb347f24d71c64b752dbf7e3a972fb7c97de44e351a57e613113e71b3c8bf39be1d3f3d5db4df1149b7f6d5205679faa8e5e4b86556471e342da39b05ffca77bdc4dd5b3b7cfeed399ff99d43de7a74c6e1692d67b3f6d5b336bc1a93fed1536d3ef7a95b377fea4e99ffac48facca777b2c57ff5eb6f6c17ef6d6c630b40b671558c2793b0bb7fe3174f8e9efe50d33646534b92eea13b54a04aaa9d1baeaca7ae92a6f5e834eb91ada5d42503552c61c04bbf0a422c5f7fa11a7b113c7ca589fe262ed22b66402e94458740e8425366559395ab81c27b073f5e444e78abeeb58d17bc8e06d7b7caf5578d0e40885c704d5ffe7ea87227ab8ec5600b3de9bce3a52fa578b5aff86b0f1e3a4e89aa429c0f781f0310a483a28708905632c072c54ddead4d4b9ed7b233c28679e110a0ac8e372d473e1525426fcc27d0798368ea7191a06258884555a8670bfec1ef7c89ef7df5437c34f74b4d0e760bcf7e55f064b620eafa684d3ffee5bda5c83bf9df02e19551c69d22c319474c0e49061187b31df13ba96210c438ac7178efb0cea2d6304f2d82761e21ce925b4b709e2aab30c16363602f2fa9b28c450cbdf1a2d2869610c2ca015d04383764ce30f2a653e10a8e7078c2f4748eab2af249851b79c804f5065b784811131b8aca31ce0bcc494e661c45d611f99d5a4aeff896db8eef487432c662383e6fb1f3863d93f8d84ec634447efb57e73c3e6f393a3be546f9257267903ab26723770ac74ba3110fce1b9e3c7a429a28a3b173a9aabefb3ff9fedf3b3e3e3f9b54494a9c2ddf3aba573e98cdaaa933e5d3a4e551d0fd24f2ed4594bbb7c5eeb631ecdf68153f179a93c8690c8c82a3f0094e13f359621660912cb7aa824f7e749f6ffef82dbef3f7587effb7bdcc971f9ef0b937cff98d2f1ef1f9b78f797a32a769e33796d1fcb928fa1f9556defc7f9fb47ff3073e7ae767fffe1ffeb6df909ff8bfb640641bdbd802906d0ce3fffce9bff61bdff7077ff86fececedffd07c764e8ca1233b5a8788ed1088c84ae56a0d242e772b96d2bdcb2ae57af44aae4ca52f26117a891cd293c7af5cbadf59c22d174ab217ff7ee900f545123ab9727ce5ddf5409e0528b620631bef0518910d882d57a291e1e8d5e67b965dc3d5d5aa9b638dabf70c89e82b40a0178e40202e30316cac011b825a0cc7aa5859b22f47af4496927c83d549ccca0091b436235c1635d67b5fabe86d1e772269b78e1949fd5ad88f9a628909da0431298f42c3cf7ffe2d9a575ee2d591277386ca67ec972555364311a26ad745d188a684759067d0b4867de3f8686999a4c45c219a44ead7de84c118bbea2c773623166f5cd79d315df7c2e1a8324fe53cc6191a0d3c981e13eac00d6f282c54de73d274047696608ab5b471f7db8449b093756a5e5a14dc9bd63c393f45ada79a54943b05b88ee351ecece0ab0c9596b6516651f9f27dcb5e9d288bc824f3dca94a6e8d8597c6c20de309c6711e72a60b4bd00e00dd2e1c5302f79e2e583c55ceea1a5f1e9219d000d60b7bc173231fb39f02b376868f016f46053afeef47d2729a22a50863514e69388c91446281d21ae120b77cf328e323b92744a1349d1cf1c8296deeb8ed05eb0c3bbb19cdc87314845f9db7f83c27f33999f3ec8f0beeee8ff8c46b7b7cfa9b1abee7de19bff9c6533efbfa119ffdf231f79f4c795287ddb848bb95353fb69bd25f78ed6fffe3fff5fb3e75ebfff8fe4fedfcefffc54f7de168bb066d631b5b00b28d3e6edf7d653a9b9ebff1f4f1c3574398498a2d20582b9dfc624f02ed26b304a3b241d55e3efad3c0fc6ba5c3df5715d7331d7d1b45e4729e7f254a19fc522e229477d001b9f00ebd084abe22592cbd829a21577e94770e1d2e982e3c770b5f29ecd9724bb690e4a221e115d7865c755f0e0a0e833b6c4db81eeca1ef4a5cc2fb296043bd5a1386239a9b70be5f3786a6236c8e47ae6476919ed331f85c578c87b161acd8fb95a8ae95bea2a224921ab0bd506daf3ad5750e40522468e2541bfec997dea4fdd06d5eb9b947749eaa2cd8ad4a0aef090af32650c7d0a957a9d244100c770acb6d074d889c89706e944695680c2c41c6f27c88416c375a166320c488d8aeeb31ca0a72efb1cef2e46cce6f3d3e665637bc5c95ec942599f378eb40e2ca68d0f58691513b1e89aa628d303270e03dadcdb8d74c594ccf6923b4b373ead30c3510a2e28b138a4989358685872a8fb44fe069503e7ad3f3d171c6c70a4f95b594aab4ad659165b4e2c99dc75885e4c892a130c224f7e4552277968f1c944c1c6814f61cdcf69191064a314caa92dd49cd4121a44670a5672c055e15272daf5586cae7dc6c5b2a318cf7c6bc34327c6b69d9e94164c2f0c4341429b1573a6eee58ac13f65a416be5716b783d416b2dc674cef5490dde0a559151dc76dc3e28f8d4c7f779f074c16fbe7eccaf7dee095f78fb84fb87530e8f673c6ea364963f32c9cd0f87262c80bfbd5d71b6b18d2d00d9c6f20b777c7e6777afc8cb52178bb9a82654639734e89a442e48a780d9cbf0aaea4a4a3fa5d48f65a45e69266d261f038ec7d58e692fd0a1bec41bb93ee9be72465de4dad45b2e5476bff26ceeea63d24d7cf28c78e7aef1dbd8c63b07ce9755a5ba5b6ab31bb24acce519d77b3f66b5bc27577d850bb7d452894efb75443560c262fd9a155f4c069c0ee9b7c99a0372dd5ddffb162da5b8242ddf3b1c8d1c8098341827eb5ddccd8a36df1751524292a029f63c098b0552328496956fc6222a5613bffcd6434e92e1e0e64d16181443e61cbbdeb3c823f3d8b2080da1eff858a3541ed4440e13ccbd63a6864621198b88c51adb99040299b5e4992713db8d5389e08cc55b8b776e35a6358d2d2775cd59dd608ce0f382c2675459c922b6c414c97a4e498a91d82b1f065532a314d653180758489df78a6aa25e449aa65e8d6cb5d3397a9e91798f5a88939c4233bc181c9e83cc51ba96ba5516adb030c22217e6ae266481268b1c9d19de8e899b183ee23df98ea522e3c307230e7c24057024480b8ea781533594650e4e99b506170da3d2e372a54d9145328c8d231f1b466733b2d052649e49ae2c4c8b5843e50bc478e62e702f2848e29c8053a1ae03a656e631a3d14e3a59ace9ba6022fd78610412c62abb13c7eece0eafdc1df3ed9fbccdfd2733be74ff94cfbe71c8eb6f1d333d9ff1f2aea88bc4eddab38d6d6c01c83606f1eac73ff1f9b7bef4c60f8f46937f78767a6262083d9058ce54a77ea42a750f9e255f634940d70e7c68d295e7c7b2aab87ce05f340994ebc91d2f1672158c58ffc3c53ec90bf70fdeed715d7b4cba81a1445e8c442f722d94790ee47aa7c7f8956c631bbfbb41c8e07b1f7632fa8b4e8623503a64382d5b0e9b1c29590191255f63a992b5791b2c4d436dac917e9c6ad3917d834db2e6a1f486211b1c1019de57ebf9ad152fed3aced492e3322072c905eeda4a9a4213242501564cef611849ac15b9a20af324c408bff6e6dbdc6d12c1669c340d463bce07021821f38649e5290b613153f2429879cfc8e5f8acc0b4d2ab83198cb38831783a33bf89cb186739ce5aa415dacec5102b5d07c95a83c561c5618cc55a4b94eeb396deb35354d8d0306f6bb2fe7d8d40291e01424ae426b257e44cf292a01e2f9eca3a5a17c9332872b07d53ca46289d623dc49890b6617f54b0eb4b9c35bcbd98f3e864cee93c703bcbb8b92798a2a6ad16842a702cc23f7baabc7d96f87872dc3ec8c018ce82e341cc5968a06e0367ad328d96e369cb9359cbb871dc882577ade15696511bc7d3b6655e07ea24685131294bce1670767ecce3b306e3e14363e5a53dcbcbb9c58be1b13a0ecb8a460ca7d6119a443d6fd94f86d23a5c46ef8d625782048a905468532245459dc139655c194665c987ef167cea1b77f87dc73779fdad137ee9d7eff3e4c1a13e386eeaedbab38d6d6c01c83606f197fef33fad3ff46ffd7b4f9f3e79fc578abcfc53e7ed592fa94bf794c1ad937865a39ab8744b37d215148709cd70347bdd009117f2d97826b55a9e8b4abe723cb38912debb64efcacaf1b3b72ff26e3ed7756750dff373b78d7f3ef0c8a5a6645fddd74d84be2105376c985c7d49eb1597be6063031a37ef85b59b61ef39b81ee71a160796c2bbaa8342870ce480198a4a0c2c18fb56cb0ab8e8e65dd24d87a6f5dd603a223a2a2b3ebbaa925240c591b4c562c158dabe331cfb237ae3fedbd8bca25183d1c4a20dccdbc82c04bc8597f63db7f61ca767ca8ecb305581339e849079871a435ec7beb3e1c98c61c7592aebc89c4530143e2388606324a44ee12bb30e672c99f5543e2702e33c23778e1003cec8ca5fc4398b138b62285c46e12db16d91d4507acf38cf98a78ccae7ecf88ce8032fdf113e7cbb3b71a7478acec0892588e5749198b52dc956ec4d4a6629f0e569cb3f7dbae0c979c3ada2e1350b1f7e39f0ca6b81b1571e2adcfb223c0ecacb2a3418eeb781371689e9a4e0b1491ccf67449b73b0b70fd58cd9a373dcee4de4a0a46dcf386ce06982a792f1e6c91941e1959d7d8af198f9ace50bf5096f9db56866382e3316ced1fa884f89a977ecdfadd8d929c933c7db8fa79ccd136d84ddbc60442239b7520a5b5e2dddf5e4b1b673b1ef1e19099144e6217386715eb0535a8e8ee7fcb3cf3fd1c3c37ab15d68b6b18d2d00d9c68530be787b67ffa03a393e8cd3f333db3d6813064125ae3a1b467af9cb245863402d889292628cf67411ede42c65585cbdc245f962b63d9ceb7e0e52f88a0695de6977e33de986bc70be7781ef72f1077d8ff6ba8d6d5c73352a1bfc8a252743aebc07871d8bfe9ebf54a0e847a2a4e7812dd5b03420da6c6c4f0728472e5caa2a03a2f8d2c97cc9f9d08ba4f6f50637a63e9720250d3a3cfd2a3214c25ba97999ceb944a44b3cd3aa3392ba6d68eaaae2ac15b792083181a5e3512cce4e0918aac90ede3a16915517d926c762615934119c2573394d484cdb0564232aef18e58eddb2a05525b796c20856bbfd8b51322b4c6c8e4f89f37ad199114a37f6651072ef1123dc1915ec649eb3ba61115ada14fb6e8925339dd8489917547946bd58b0a8032d5d07c98921cf32b09ed4f3619aa8b44de26caea4392889282df336511983cb72342b31a145ec825a84c390582c1af61ac3ab0299f78855ac242a9bb8913b6e6719164b4da436163399e0324f34a74cf6c6bcf6a15d427b8896a7e4a3bbe7799ec6678f8e79323f679a8dd8b97d83098e3628ea2b8ece5b2a35642e0393383828f9e66fda637f14a09d92824162461d1df78e5b426a393c6e787216394942d444c2e0aded9e75fdb955a177873758b15d134cbb490021412f3410daee9bc8bde7b456bd7f1ab71d906d6c630b40b67131f2a26827bbfb3f5956d5b738efbebb6d5a922c1f98064d1d71b173e51d10422f26c8c20642b83279b9f0d2d5bbfb4c40b8220fbf1e8bbc27a9f6fbe1def14e76ae1708bff27eec641bdb78e13b49367009d7724136479a2efbe45c18ad52c5a56673b78981a1876ea212a1f7e6905e157cdd56d52bae6eb992e9de6f6e003e3a77f64d67d50dffa15e014bb417d748a903216847044fb193b33502c9f53418c14a27d6210ac67a4cdb208b29d5de2e4185454c645648d1f1e02830af03afe5112b2dd3a81cce951d5b52e4862273ec9539d6180a9f1353a00d2d1a53775c022944da100849c10a6a2cd108012102b9b3bc34ae289ce7e1bc066b1055ac05673dd67406912eeb647da3083542adc234b4342a3827246f983586370fe1e1098408a1353d515f490472637865b762c78fa9534120639c076e8c663c98b59406ee780747ca6ffd53edb44a4e0c2ffbc83437dcb2194ea1b48e2ab718a734296273cf7867e7974693ec13dab27beb56a96acb5f69a6271f399fcd3fdad4338af1841bfb15b81c55c7e9e9194f9f9c3046b9ed720eb3c4a4cc981439de0a1e4fc2f2f434f1a547a73c3a6d6942c268a2a9034443d28cfd5141e10c464c6ffbdec930239d5f5657a813d05eba9ecef345932092f03e91398f88d536c916806c631b5b00b28d8bf1d37fedbf8dffe6bff31f1edebaf3f29da3c3436d9a4634468c515234c4d4995361d6fc8f9462ffffeec1dc11d1d7894067f837a86ab2ce29e43a5c22724dd2bce9cfb1a97e7b51db6aa9b8f3ce92ee0f1a845c777c72656278b113f22c3530dd028f6dbccb2bbf4ff257b2d5b2e1fd3154c01a26ed1bca57c8a5df9bd4ac647497de1eb212aa603d36d52bbfad9a31a97b4fa21b0b5b8f63b12170a1178a1c97ee27d54dc27defe82d038f145999a8765c8fee385267642886e551a8263476821d2ba9726348622076a339de67c410b8ffe01e76b20f2264cee2ac45db44e91dfba592bbc0c25ad408188373066bbbf3ee8dc589308d8926440a67c9bd2384c822458c11c679ceadc2b1536498cc515ba5d68433c26ee628b38c2acb287d0b36113552e419a66b67e38d9052a4d584f4e359754c2c428d6ac41a83358eb6a5ebda60b1d69124d1c616031c64191f1957e46238ad153139de55ec9605a37cce9e358866fce69b0b1e340123c2dd1c6e569e7de729f0cc48e0853c389a4543d306ce9a4835997ff3dbf7cf72979ea0a110a5fd9ed804cee72da115466278f4f08887c735a3b28294c8b094098cf1e4a6e6f4b4e5f35f9ab237167672c3f94cf9fcbd058f4f6bda36917b4395410ad0c48eab937b8b118bd22942f6522ca858d0d07bc4584c4fd6876e2240c4e05d024d5485655c643a2ef22d00d9c636b600641b57c5feed3b5f7cf8f0de8f8fc693bf389d9e679ad2faf1dd3b6c756474564ee84bf5ab25017df9905e26d74be32f5d2509ba5ac40748e5dacaac5e0956863556bd36c916b9407e7f8171aa8dfdc907df1311e1c2e77a2fc8e5dbd8c633afbacb97cfc698150329e801415c3715a22fe08f15f258bec3a606b3e47d5c01a457f7eaaa7bba94ec66d3d0b41f815981901ed0885e712fcb10d30c6cd6650091d2a6f188ae46c17a095ee26aedea6cdbbb2eb026e9256dd7450f544931f4e33a1663c088653e9f53cfa6643bb74899455222b386ca5b8acc328d1dd9f9a0749499c79b8eb4be8881691b69a3f274b1a08e817dc929734ba493001ee505b7ab8a8f968edb234f728664bb913015c15aa5f296cc399c3364d1a0c6511605168386486e853a441421f78edd222333a62f3429562ca513922a8bd875c2aba2a4695b529d7022dc1d17bc52399c09c418103ab3466f33c63e639c798e93e3f3a70d274198e45015caed5dc328389a85b010c3e345e2ac55f26829b39c969aa68ed593c519a59db17b505047cdce9bc079ad8866b48de5e9d994f37920134f5538c6a382bdb6e1ac159c87458c34d3883ac7690387a70d67f380c330ae7226a5c1d9404c4ae91d1fda2bb0d6a1fde855d28e4ba4fd38b11ac51a5dc9ce8b1abaa69a45241185ded452a832a707b9df02906d6ce33961b6a7e0eb337ef2bffbf36d598d7f7d6767ef4defdd2a8937c6f4a4f4d4f13d44d795cd0b79f252c6f252157ff900d7b59ce68be6d67a65ba22bcc84636d4a6de61476465f3fe3551a17e3fc1c79680bec520cfbe0c94a1d2d4a01b2917fb6deb0ec3f24d82428c480a976f6abd7c972f15ac742087bba98cd52bf32d414bbf1f453714fbe8f912cba2495a6e77fd9795c4f8eacfe5fe96c595256012e9476c180874f48597e5eb34753fc7eebd29466254a226b016936071f490455d73d640480683e7a8ce7973ea98274f91e56499434db78ab60aad769d1511212a44559a1038ae1b8eea4050e5465172b7aac845503a7e8a73166b3b477a673a85ac26759e1fd2f3302665c9a4a8004b489da164e51c0779c64191b157e68cf21c6f3d460c49048cc53a8358450c186b2973cfcdd233293a2775e761dacc78fbfc9ca88edbe3113b65ce2c19e66ac8aca5ca1cc959de9a2baf2f5a9e68e04c2c87ade1ac4984a464bea02ac6e4d988a8196d748cf29cdd32a7f2f48eeb15b9c9f0366767b2c3649c6325e05c6454266eef08079521f3066f125e156dbbeb64b7ccb8bd577267b76494e7b4d1d2aaa5f486dd5230a284d48d5469b4a460d0a4bd996377bec46c5690443ab9660c0422f3d0d0c6a409b624f46d6ce339b1ed807c1dc79d0fbff2ff3d7af0f6cfe645f5a7daa65d25042925428a587157ba07ca4655715d111459a625cb57e98a54baa137cbf3ebfd57ba00c80b60e67761adf1c173435e54b5eabd020ff2357b26b6f101025c7dd6b530e05de8b04b77fdf5b1c1c94809a70dd7b9f05cf9ce15df64786c6beed94aa16f25197c418e8b8107c94535ac9e902e173e93f65d1b1d20b26e04cd0cbd5359f353ecc6f95bca040f5a36dd089708462cde818496d9d3c7e8ce0ebbe588cc080bf594d681b5a873a8158240ec937b6b619465d4b13392c89c431442d2ce584220770e4198c74034062be08c45494c5b65bfec927e630c46c11a07c6e09da18dca3c44ce63a4252262f1e2b891173897388f81ca071629414c78e7c8330faa84a4386b996439b9f344f1b86c8c36f06071caa3e98cbd51ce4b0723cea70bcee74d3f52d6f148ee1f27eaa8e412f95869786992919519133327c5138e670bb023c67617294a7229c9c41262e0c02a32ce49a6242b6cdfd9089ccd4e30668a311073cb9e13eed4394fa681b3a08c1b50f15867d89f08622275a33c3d8f4c5b21e2c93c58136912a404563d4e3d24479b16685ce0330fc675dc22ba6e134227cf8c12d51212cc4364d646ad13ed76add9c636b600641bd7c4dffaabfff5ec5ffcbd7ff0a7cab2fac1e9f9d9c73425d4a4553290542f27f4aa3d391d5855093793dc4d855eb936ad5ea709f282a9f00b26c572d5af840bf4ef6b52fe0f26f9167911e4f4d5342adc82907fee81c8eac76711ce07d7e192c0ddaf0f3230245c26e28670fdf5734531839e17b23901b6e90db2b22b59a9edad3d4764e31e59be70d88965c56d59fdfb86b0c61ab488915edda8ab8263fa63ebdfa30844edfc40640d5656eb623fd29500b106673c16e5d1bd37696fbf8ccb0aea14095a60056ee63985b328da1b1f76557823607b1f0a2786c20ade5a5c520ae731c6304b50390318dad479933408477562b74d2806672da5cb288a82d26738b160c1fb1c132321b5d4aacc55ba312b84d22999b314d18101eb1cb9cf983735460cde1a8a2c03eb684d46969584b6e5b86939a95bcac2b39b17cce60df310410c99ed88ddb5c6ee996004b11ee71d07956592355493298bd410a2a3f03511c519c77c11989f9f93cf231f2946b42ee7dc390eeb86c3d35346bb677cd3c7027bb93239b7e44f3b15311108eac056882829ceb1121067689a44f2b033ca894119652d2603d31a6ce6116351b124853a04541ac4b8ce953e7560d8d8f5f593d4769410c970d661ad5571b23522dcc636b600641bcf8ac9cede1b67a727f5e9e931f56c0e1a3b3e053da7c3bca84ed575698e3ea7daca73bd3ede592a7c49a473c0a5ed5d99bfcadc89cbde28d75598f5ab000a740b42be1ec1c80557f4cdab21c1d012f08292eff2954623a2717323aa576c532fabe20def57ed61c540ca7b8d2164e965be7af7da7d5d567c125d12e75724f3cbebc1ca7c503acd2d9276f3fe98ee332759ab2119c1682fcb9a7ac95e491d1889064c5a8339d371efce2e690000200049444154074cef201e52e0ad2f7f8162ef16d3dd3d9ecce63c2c73be3dcb3a97ef5ece3c2ab4288b1498c540a389a009d4e18dc1598335c23c349ca970a7f2a80841973e2a9616a189d28f58192a9fe3c5766a5a6218e519493af9db58871588091892016c22194545f1c6926539a5cb3a9ff7de895d8d305368ada51168e83c5110f062185bcbcddcf328f718a3dc2d7346ce100c4c551967252f672012f12e71734fd8bf299cd4ca9b0fa6bc75ff6de64dc0b260922df0a1e66682bdcce1bd6786c724301876760ddff849c3cd2292bd11895347e932760b6154296521d4c160bdc59844ee2da98a1c1c043096b71e461a15c82ca39443e949566988387144b144753805d33bc41b40d5ac9e935d11cd91d99c2acfa972a799755b00b28d6d6c01c8369e15dff6eddf79ffe9e1e39f29cbf2f7348bb9245d93ccbb06b3ddec50c8855442bf3260b2b1956572202fda0979b1345f5615d6a1f2165c6551229bfff92010c80b808d6783ab77b1d36d6c836b11c775a69817656f8720242986b029c7db2b5c6d60904b587b53c26a4d0d97aba5bdd9bc79b54ffaa5ef8c0c018d0e386b4365bea557c98a50ae0a92fab1aa25e01a1c07822443a2afe02fbb3646909e0927fdfa252248eac00774aa5b4621b396fae8311645aa0941e1b0491c6030a2d4981eef9815e4eb5cb8e978787dc725a5c4593d4733075275bc3d3118207786bd3c67e43cd636186b89aaccea3934e0ab92cc58ead092805b93311f2e2c63d7a979196330b60355c918407a552830c650fa0c11a863e43c42f48ed61ac43b46de93b28cfd3c676c1c2ecff8c48ea1c5722bf3e44e88a21cc5c48dc90e1389bc7e74c2b48e8cb29279b29c9d25ce1e373c9d2e386e0221250a67d8cb02f92823b80a23169261371f63f60d6d9bf8c217e64cc7ca2bc75006c78ecfb9e9145f2d8861815ac78d32a3f08e18a06d6bca0c0ea70df78f13b746c22238300eef4ca7f62591cc3b325710719d49a580e987aed602064a54435201ba8e95b556d5f42e97dbd8c636b600641b57c78fffd87f9a3efdbd7fe067f2bcfc5163cc5e4a89a401c8d60f6db9223996d573fa9d27bdeb0d735119e79920e439ff7edd8e44e472b2c3b508e4034cfaf45d008a0f3029ddc6d7695c666c0c04a4d6b74c4a38c20685630924a447fccbaec66a2c6a30117511732fd71bb97004aacbfbf9e271ad3b3872c97848575d934d2032509f93b535c9d0097e25ee65e8d5b7d6c58bd531a86264adf5b7e2c78980741c8c8462c5e0334b7b7a44a64a3e7e09cd72822fbb877006595e8036e4ce51b491262ac61ad41a3016231d2f6416235932ebe5573aa52a672c9577e499eb5cd2ad411162ecc7ba14626c99360b228983f10e079981b66116138ece5d7db72cc038920a064ba38979c7cec60884d48d20f9cc61324f15e0a532e7a6156e9415184be6132fefe4883a9c2a2209630d4112bbde6242e070de70d6281372fc4986ad233b4de05c1b4e34d1462546a5b44a9e97b4a6a455cb34b688b1ec8f4a8e9a31f7dec838738636b51c84c4a9282d2d99517cee70d133ce2d994b4c53c4886071a490ba9fc5f3f4bceb54ddda4d2412d644c4441c0e118ff46207465c6fb4d9a940ae0a68d2bdde7b2832abded8ad44e136b6b10520db785e6445f11bc6d87f68adffc1186a5208688c743a57eb11065d95143b832b15d93053be32959567a4d732e066e810645c9f040f29ee57ed6b9d7dc885dfb1e14770f9a0bf96936ef92abf7f1bbffbe2190e97fa9c31bbcb1abb038c2e834d77d9b8d1880c65ae567fac1d4a2f31c186f7fb0a01acb926b2cef4076bc2f0f0f542cd40570065ed8e2e9b05131d2a060f1ce0132bb775d978a1ac8152bfe395a8462fdb6b582a7149bf3f59c9076b2fdbab0ad640e1339c73d467c73c9a9ff199d3273c7de92eb76fdc6477779fdbfb079c9d9dd3366da7846504e32c2ecf28b13412705ec075e3526d6fd8181244a04e897952a2f4c476159c11bc73380b79e630740a5939426e0c8b36d284845a254f8184a5f41e631d750b754c780c63572228a10d6868c8ac2133a63b393172abf0d8cc4191137c47aecf92b258248e9a962a73ec7bc78e85ca094d883429d126086d37ed560998cab2b0394f53629e6a4484bda2e276758073257302d839c674e7626c0b8ee6194fce2318e13c0b3cd69af310a934a3f225ad74e04448586718158e9d129264cc16190ef8f2f19ca0cae44ef7918c081a216920a910e954cfbcb358b3be2f8ce9ba674923220dde2746859d8f72b7ed806c631b5b00b28de7c53ffa7ffe6e7de3f687ff8c77fe079bb626a5488c6dcfb8335cc99a78a6a7c73b488b852b3a211781c3f3b734ec8c5c875fbe9a94ee777656f477cdd16ee3772336197604e59a9bf2d9f7deca6523050cf19a170e24bcb9603b72f1553aec5e289a36ddd5bb35619351a6acfd407443814f078591753b43a433e2d39572d512a8ac4fc750d16b293dbe24be77b8a5df9ee97e5eda8a48afa025d281944ebe573ae356d5ae9be022a21035a141797a74c4d9e9299f95cf618da5a8c694d508b21cf13995f3948547bc41628b0d1d272f49e77ede3a8fa8741d12845a95992ac174bc8c46159712814e89b84128acc15b8b49098991d310c844d8b59dec6e0a424a905499c5c079d3e2ad655ce43881199d43fdc8775d8193e9827ba7e7ecabb2ef3dad588ea332af03a528d326707fbae0404aca3227cbbb645eac63bfacf0268183a9364c5ca0b2c28eb194ade53458bc35ec1705bb59412b96901a426f82ebc4d024787a3a675e471636726423e7315047d8719e868cc67426bb0a0415b006e3a0cc2cfba38af93c72b85860bd608da3691d8bdaa1d6f63cc8eefcc59e13244b2546d30931440d34b146d3024c6254d85955bc3f1d90bff7f7ff47f387fec08f3c13dcfcc45ffa8bb9cbd3abed7c3effdce73e77637674e89ba61d9fb569f4fbbee73bc6dff1d157ad9562f2fd7ffc4ffc95ed62b88d2d00d9c6573df6f6eefcf6f1f1c39f3762bf2fa548082d31068cb1ab0aa0c8c0c78bf7363f5e6b54ad3b2ed2575b876d94a1c84d57745d1b1dbef014d53380d35737ed7f91bdbfd747a75cc52d59267cef57f7e44a99e517c09bfaa298f4eb3ef41a75ab2b80c8f0c45efc4a2e9e701ddea309db89c30e3a93d713da37cdff86ff9c3681f7505a77608cb812e51b746036ccd42f09fcf6c6a80340b2ea7eac357b575c918bcabb2a6b20a217afdb242b6afedaa55d3788ef9daf92acbc4a42e8f91da9f30a894aa7fbaa9d89dda239e2f4ec1444883191e5056932665e55b49293c4d0f66b61612cd16514ce53140b9c9f4252bc779dfbba11ac809a6e046b1113b31010f12c5257cd0f3141525c66d92d32bc0a5195c24666cd82456a99c740ad09db749f7cd106f632c7addce363645e070e673536f3ec14967952de389df1687ace8ddc6245781222eda2c167869dc2e283e1c0e47c78e2986589a40dd39048aef79df24a990b596bc98d65925b8a22b0080d4fcf4e79345b90b99c9b5a323d6f994e1b5252e65699a6c02c7484fb45e64985252f15c92c87a791a3d38831090a61ba889cd50d13e7b83b2af0b923938c371f349c2fe61c8c8571e9280b7a011301b51d0b44150d09b14a8c42d37632c521429ed9f9a8f2ef4b07e4b33fffab7fe44ffebb3ff4edbff5cb9f699e9cd5b8837dbee11b5e5d7cd72b77c3c76fdffcaddf69f4936f3f7eeb433be3d10f9c1c1fbbb7ee3df8c6076fdf63b6a8a59c4ce47c3a3bffe2fd47c7b3595bfc677fe247ff87fff2affee56da7661b5b00b28daf6e7ce173bf54dfbafbea2f38efbeafae436fac15702e5b25142bf762bd2a97d91ca57aa17c59ae01074324b10221175fbe4c3964731efddda6efd790d4df2dacb890dec32635fe8a9f3fa0247598b4e985f44ddf7b8378bdb2f42dcf38aaab40cbf3c49bb7b10621c37be9052f52d52b01ca8a034267ee677b52f655108361770236c7b6aebefa2e49f00e2f91b584ee600fb2e9802e4355bd0d2cb30608ab4de9c58a85aeba28433e89f61de0e13d2ad281214d09433fa6258251d0be0bb2ecc8769d9cfe3d69c915e90e38a588a6ae7b9b52424cd79d103a4f90d0b61c1d3e213e8e2415acf58cc615455532de3fa0311e670b26a331fbd51c5260b7c8b1b623bd97de518a45249062c74b69526211234e84103ba5c3cea5dd60138ca2e1669e818960128a62ade08d705e07a2429565ecfa0caf86d21a768b927166116b99369147b30587f31a23397b45012672de24de385d502cbaf1af6cd733f29e8c04d65321f854336b3a3e51ee94dc2b5e2c99b7b822c13c725ab73c396fd8ad1cd53cd02c0285083821b396d3460902b7ab8abb93317b95a57586a7b3c09b4f124fce02b907e32d75ab9c2f5a5ed9cdb93ddac5f88cd9027ef9734f31fe8cbbfb235eba5171ebc0537aa5f0869da89445a792666429966010724889900c2e93f9b87c7fea58bff3d937bff5c1fd277f66ac9d3bfbfda7a77cd9bc05d3399ff9c297670b63f2591b8c904e25c5c9eb5f7cc31c3e3e6416127b3717bcf5f6bdfcde9b0f3ef4f8c9f1f1dddb374b60ba5d27b7b10520dbf8aa4735d9f90585d4368d513a929d6a47ca5b3b02b352ffb8987a3c8fe3bd59f5eed4b69673d308bdc993f62d6e1d70442ed251d70995bc48d9fc0501820c37fa5ebba23fb3b9f16ca3b7f72fe4b9d04c37fce8dfd9313df30c0ecfaf5e6eab5d05302e59d25c03dbf43918f7eb12886c9c18d93c59d78c3b4a5f0c582a4dad14ad847eecea6aa43e1c835aa317b972f757ad0ed77e773a18831a4c80f67067bd0595cdcfc0128c0c81986e9816cac57b41a4e375a80e37b75ae796a0222d55f674f9735a211f4530b697e4ed13c6d590584a84de85dd3adb49f6f6bf4f02602125520aa8743c0e80f9f48cd9d909678f1ff2d6eb5f60673c211f4d28f28abdbd1daab22461c9334f95797cea40476185dc38ac803796d20a89c43c258ced4d1635e18cc51b6127b78cca8c3237ec5605560c6f3c9d326f2223efc99d27b78e1bd6f30d26c76a4b8c9d93b8a8503a4fe93326454e52cfbc6d396b6a9ecc1b46cef2a1714bee13e222359659029b8436659cd5c2b4693af34763485820277742e91664aec51b4bddd6a8066e950e6f0dad1870c2cd2ce39b0e76b8e9609e128b85e1ecb8653a352c82d026e1d149f7dd8620883af68b09d13ade3e3de1f34f4e9987c4ebd52937f70a6eef65ec568671e9b8bd577167afc039102b4c2ac7a870887a34b6d4b542626e85f7a5b3f05b9ff9edb78ecfcef4156de4ae189ad0101f3de4e4e41411aa696c386b03c6b8dddb65c6fe628658e12809da349c9f1c978b59cdc3c3539b79536c01c836b600641b5f13b17770eb0d559d4ecfcf26310434a6d503330d889c4bf58fe168d4d5f97af72037c33ca79f77d00d07e3ee096f4c6f004627fbd8b90acb4a0af3aa145d5fa0b87b75423cc8bc64f34f7d8fc1875edaf93b3dda7703485e6c5ffa2cb7c80f5221ac2f69cb75dfd98553a1cf013c1707ccb6806490a4cb156070880ee4ea73af31adcfb67065e7e2aaef6eb5d90d0f445d8f518abe100c572ebdb45ba7e402f0d12bba2fba79342bfec7e0df3646b196e76a3592b8fc7dcf1f6130aeb53a3ab33a2729f65b33428c03a0d3cbba2655248271b6ebb8a4d86dbb1fdd4a7d27693992aafd5c5812dbb96e1f1da14f9fae8efb0ba38abdc90ee57842968d8831d2b62d49953a2632274c4acbc80aa94db40a882569d7859905e5715d1325727364b93bb2bcbc3fc220c426f0685a537acb24f394dea178d45a164dc33c05721328ac031263efd8359622b33c49ca595323c660ad41ad6232a817ca1bd3196f9dcf284598b892472170d226542c88619a94806792157c642f60fb2fae691b8acc73b3f018814502ef335ebab1c727f62ace4ecf389f45823a72f58cbda3466963e274dead79953158e3c11404111641385f24ce9a86d379c3a39319af3fe888eb8533dcdd2ff9f8dd093eb3344939d8cb79f576c9a410626859d44a5233b7f2fe70406e35e70f67f522452376af328c734b8ee386f16022f7ea96fb6d8b88f09a33c449c179ee7858471e158e22af999dce69ebc6344d9b6fd7c26d6c01c836be26c2e6e59b3eafee3be72731b4dd8880ae1fec2bde664a6cfa93cbb55573b3f18ab5c9972cd56da037ec32a464109b7a32e7056e072bd1cc2be0c8b35d33d6204007c9d6e6b6e54af071c187bd3fe67713f242477d554dffabedfd71d13eeed97bd417aac46f56b7377e7e9674f210d15d94471279e699db82908bd9f9f5e044afba2cd390f72117ba2a6b1e883c03ccea856b61c90a91e108e04a8c6ae0467ee94abac025598d5b0dba76320422bd5fc8c020442f7ec00d46fa8087b6bcbc06c6262a6b15afa167c8926ca2bdc788f4dd175d99282648dd1a872a814e1ab6eb96f400a6275aaf34b754118ddd9ffd878d83eece72a4ec643ae3e47c0a7aafdb967124eb302e27ecee72b0bfcbdea4c068e26933270aa873a8cb096a38a6e1b00e644631a5a732425a448c28bbce70ea3cbb45c638775d9108c1f41fdb00d608d67626814e0c1e1022968473969b65c9be1326ce9319cb4ce0b45970348fb4de2126b1d004c6e2b0a0ba323a2c9de5e59d11636f38ad03e775cbc8041c91d3a61b61dbf58ebd2a67925b1a63fbae9432c984bba39cac713c5ed49c378104ec7a4b956768e668a3c1d9026b1d2aa1e37434917913383e6f3146399fb6984649168e17919db1e7f1d31177f73c99558ece95592b479fb8532fde8fbbf693390f5c41aa30f620330467296cc6becd891a38353979549cb1e485213719fb8d233381a61032df9513638a66de34e5761ddcc616806ce36b2226931bb3e9d9c92fe565f58d4d3d27695c81846132a87db6b0547ed9a890eb8521ec4b55f67eb8c680f46eb2cb312c6364307a2397d2f4775b52d2779ca37fb552d5e78f467dd0b9ea6a6ce539c7fd9e1cadbc83ed5c04283d08d117f938dbb806fc5e6c1d2cefedd4d7f62f5f9b8a0e00846c90c0af401f57ec5a2ff1833689e6da1381f512d255d93cf6cb3e9f7a25e692c172258356ee0aacf4050919d40374f8c68163fb4a914bfa91add43987776685ddff52471ce9b669bbce70ea7924317552c6d6581269e35409b20224aa69e5046f56b047561f5307dd6580145b525ba33ae5c9d9538e1f580e0e7628ab114df2f87c442b390b5f814b786ac68b4846c4e34084936943254a96849d3ce3f64e85f586461391c0420d2761c13c041a963c16a5ca3ce33c632a8150078c31ece6392fe59eb13558357894b171dcc87226de9339c334b32403310a4694ca191c893604da9828328ff125b96fc868399a4f79d84bfdbe3c1eb35b14785146996537739cb72d411237ca1c6395f39098f6be265843b0709e22b308ae1f1d3bad1ba2748536d50eec75268689e9b4e5bc0d3c38afd1c7ca83c32977f60a46854553e0dea3e65fffcd93ecaffcc97fe35ffe3bafdd6e3efb1fffe43ffae27b76878a3c1c95266544be54278e43c9cdfd92fbc692b0ccade1583d6d84b93a685b64de606322d30cbb502ab5384dbedaa9fea53fff67ff74dab1a3dbb109d3c5ecec4691196e1dec89c2e99bf71e8cbef8faef98c5f939653521ba82bd5b378ffe9bffe96f7e66bb566e630b40b6f19ec6cffdddbf5e7fea7bfed02f14a3c91f3b3f3922c6444ab19bc595fee1a7eb27b92e13826175528600629358baac641a59cacbacc720d6230d3278ef52c272d3a95c45def910935ed74590e7bc5b2e6ce37d4af8ae3c960f027ce88bd15d5ee435a25764f9f29c8afb65f0313c335f91dcf375af1f1ccfef2617980f16695ef8fb40ca56486b8ec315afbfaaf4b0e6b3cb2596c7f037f222b7e68087b6a15a75610397641df48a6f5d069d922197443655b896af1be26f19b46157a767c3bcb0eb102504a39d19a0f61abfba042022ddcce9f2342b9d642f118ce9f970ddf1244092d958c73a6e8a198a79759cbdc13a25a62bee186b31bdc3ba88727272c6d1f1194ddd82c2c9fd3ddebc799383831bbc747083970e0e90b0c0081827344dcb3cb49cb62dc138726bfb91b2d48d84a5409d9a8e4fe2320ae74846191943650db5b5881142521621928f0a2645d6fb6c240c86b1f7dc2a72bcb7e09487d39a694aec173977ca029394b3b6e6683ec75983cf0cf3a4d4aa34e2694dcb42855685691d38d34454b0d239e68a0823ef69551979c75988342982b5d4020f170b8e661d59df59bb1a015e5e0ba93761f4d6a3d172be68385db4b42172366b797c52537a43e98036ee27e43f30c6fe8818f7f64ffcc877fe6278e27ef663ecfcf41ffedffeeff3777387ee8ef61f3d95a3f4f074c617eb40b93fe2b50f7f84715502358bf614735663cc88d2e79c9f9f523f7ec2ad2650949e6c06be151e85541e3e7efa3fff935ffab537efeeddbc139b667a3e9bee1a23dcdedb25c4180f4f8eedc3fb0f884d4d59cc49594eb633fef99ffd5b7ff95ffdc13ff6a35bf5ac6d6c01c836dedbf099fb39efb3a7d6fb83d836841870cef49af8ba2e199a41e5f362aeb01eac5e01125145cdc0acab1fb1ea9e8b9d5efe90cfa1fdfe52eadd66ff7ff6de3dd6922dbfebfbfcd65a55b51fe7d1dda7fb3e66eebd637b3c63639809f600b1c4c313ec18a30890310a04299887481412254a488888f8834794a048111144110424149260231213029143100ec6901883ed30b631339ef1ccbd77eeab9fa7cf397bef7aadf5cb1f557befaada557bef73baeff578bc9774fb769f538f55abd65af5fbfe1edfaf34b8fc074c26d96590eab07dd30f2e3ea84270dde3989b0212dd0364bd4ff6eb75ef21b239eacf13f469df24909da37468807ad6dadbba73b66d8ca76ece776d978e6faec9165c6ce54175ce91b6a6c98a735786f709ed0723aa4d80d3a4dd6800e325539ed24a0faba240d2221e0b3e8059c629d6699e15d8a853516b428e5202460d121423a64ef1aa697ed5af219b5634b346422d96b8048a81109465f296c160ea3db732a00d6199061614eb225098a70bbef8d69b7cf1ad37abc8c528e6e4e89893a323ee9d9d71fbd66d2ee673de78ba40083c9ee79c4a426c6250b04119e3b0b1d6ec528650588e8d105195bb64c1b3284b1ecd17644709911d81ad344c160432026285d80963b1789452611ac78c9c615196cc0ae1c922238e2ca654eecf16442690440ec5302b0ade38bfe4ed4be5fc28e2a524066b1925232691c3aa70e13db18b184501f506e72cc1181ecf52de3e9f33b2118210bb081f1441abda44558c2aa7a331d3648c494b96c986791938bfcab810183be15ee2381b4f651c4f454cfaea83abf2d537cfcbeffea9e2f24ffe91eff8f48fdd1d257f6b2afcf81ffa952ffeacfca9bfe2afb30cffc31ffdccd51ffbb68f84b78d401471f778c4c408132c1608c58c912fb13ac6fb12eb3daf1dc5bcaa23309687f31c662926cbf899cf7e81e4cdb75e7df5684aa9217ef3f12545089c8c63626b4d9ae714794604046391f198175f79f9cecf7ceef309b0386c8a8776002087f65cdb2bbffc5ffa17b3fff71f7c268a924ffb22afeb3de84439ea3fd6f90b1b39da2d6140915661b1d4351ec6aca1cb52286a6d05047c587ed659810fd5806036a220dbc0870e19b2f22ceefe67c01bd7b2e66f0a3e64bf1b7e50195eda35f37ba0e360fad47678f04ce0a13187750be46b90b5ae8dde5f32e023548adf742309d23bf66b10b2fcb3396aba055c6f82f18df37af0baca1a284803a368834e786b52a37618bb9a00a7b9c72d7faa5d3ca56b38256b0ae22a4babd20c212c6b25aa3daf022154112563605957636a762daa9a0659710c9b9a8950ebbdb08a9488ae69c857cc850d50166a9d9165cdca8ad61c59692a79d5eaeef51acde70b2ee673f4dd77902f7c9ed168848d47e462399e4e79673a26328eb35184c5a158264e39768ab742e915718e6303b62a1ca2d440e13d9937a465415916586331562909a4aae4a248f02cbc27b05493afa88d03c2ac0c3cc973626f889c709ee6c411dc7611d65a0aaf3c9ca7a4be4074ccd96842145b8c7a7c9932cb0aae7c204711637008d658bc87451e987b8f88c18ae0ac45a5e6df8a6c35bade739a24dc198f78946644d65104ad53b4eaef952a661cf3a1a3db9c8ec6f8d2f2cec58c9f7a52385fe6afdecdfcabaf1d85ef3975e6f11ffbd1377ee2bffcae6ffb3b2fc4fad7fec0fffe0fdedc7739fac7e97c9ae9f4971dc5bc6c1724efbe899598dbb172162eb9cc3c8fd394fbf302ef33ccd4e18e8e483dbc7d71c9ec2a65a49e5beab95da67c928a2d6ce153ce0bcf44728e225701edc49018e141ae6422c496db45b6380090433b0090437bfeed6ffdf9ffc27fe2d77ce71793c9f4d3d9625ee51e2f9d7cdd741801d35521ef0015d920dcacd206cc8a7e5790ae6151179f9aa5f0e11eb6b30e784ff526684079fe02186c8aa5ed34d8e50334723f7001f67541bf48171034ffb93ca6ab1ab13165b6bedd9d2065e080fd53fdbe7a81c97045cd7ed06f13b8f4fd4e3af0ae9db2b78e40e8d68d40fb5e5a23754b36225e3d1c5eade8477b41e8405ae18a54a3a5cc5e1d1974092aaab0b1912a02221256bf37a15a08765917077501fbb24e2e10560f18401b42884dcaf246ba59e53baaa225552252a801cbb26addd4d197b0d253a2eecfea2d78c5a739bac829ca82cb07cac32fbfcef1f48897cece78f9ec253e74fb05123722b29e28329c4e2cc53c23cb33722df1402406670ca24a5e786659416c035a56df9750d31d2fbc67e1431d61573c8a71863872e8a220f58a2780ade88a8d98aaf0ddd89ab958f11ebc0a180bea783acf395fa42cf282f34299f980a7feb668a5e3e18c25768ec8ba6a3c4d253c68c4d4e96b018c108992a024c660adc3d469ca528fa5b3867b93311f3a3dc1c50979e149178e59a1cc8a928b62ce8334676aed9d89e53b8e2cdf7164f58ffc3bbff69b7f6a44f4b762ec3ffed6bbc967befb6ffefd417adcf26938bfe5a27baf9c3a4eb9e26a164882e32c719cc442194ade4b674cd3944741c146947144aaca559aa1bee0e389e3b568ccd9447865ec28548883f2faa2e0d628e2b59329b76287e059949ecfcd4b1e26638e8cde723edf6937fe7bbfeddb8efedbbff9c3571cdaa11d00c8a15dcf29ac7f364946df2bc618ef3d3678c0604ca502ab1a560c315a7ff85a20a4c78491460ad5523d78e976d60e0269fb3365d8732dbb39a586adaa0f282d69e73d07c863e583e8d35a7551565100bd3908e9860d748ff1505de7c46f8cc2ba3ea6d270184eabe913cfd38dab6d8180b21b746c4d3c5ad5007c9549246ae8a9e9da06fd9a6a3fd282301d537e30cad4e4d1938177b8c180d57d1d03f4dccd54cb6e5fb497feb9be4f4f0ad91af04855d05ca7e4c8724dad74539660bb060ecba277cd215e220000200049444154232bf8e397c0256855bba12046315245425a54e175c4c52cc75896a95f3d840ccbf55c89b7ace7a70a4ad91e17adea46d6a0caa084d533381b118227f79ec757973c9dcdf8c29b5fae1897e284d3d3635eb87d8b976fdf23361169a1959447ec9824238ef31234907af0c1512094216011122bc442050e42a853d42a71c7d2077066a52be2509c7344a68a5678ef510d1c8d471c4fc72cd205672347620d5799f26891f3ee2cadc049fd1d93504593440c89b14c22c771927014c564458e158338cbd84538011fcaeaf8a0e04b4c5d13628c20d83a320f93c8729638a6569863287c84688295aa403dc3932f3c8f55ebd9a2c4c2bd23677ee3ed38fe8d1363d22f67b39ffa4f7ffdaff9fb779dfd9f2726ffccbffbf77ebcf562476ef4e896311f7345e06d5ff05e6a3836c028309978280aca7949880da7168e27863b478ac9e1f62422339e530fb782a130f036319324e6f834e14e5272679cf0ca9d29b72303e99c4596818b39b231e9c5c5347b7af2adc0df6ef6e93ffefdbffb9349b9f8956fbdf5faa7ee9f5f7ceca7dfbafff0db7fed37ffdebff78f7ef2502b726807007268d7981471f264343e12174514455179c86aaa5c235ae711d75e3731b4297937a04755786ed684bc4d2fe4a6bd13088defa6768c7759169f5c0f51fdc27b9177028a01b1c5f7997eb71b6891f775b8641be8a545853ad4895d9dd3017adee658764813ae35720d0fb7f49ef8d5063eb65559b5a545370d74dd80937da950d2812482f6ae14e9f98976887437de53f7fcc1a0a7b6e87ad1751178eb3aaa83da246d8143d64e9adab0d79506922046abc2f23a8abc5c032aa1021f750a9531958821b5c2fa32726864a974a71b0ea0a6d347eb14a8aa86cfac6888a54102d2acec176cc5aeb5043975f4a4a9f7b4a45f2e2b7842e13d8bf915e78b4bde7cf76d2c42ec62e264c4e9ad13ceeedc45e211ce3af2b260e66181e5c8c5585f707b32e1b8cc3975957e4886c120244688c590e681c229c6189c500116238c9c23b1cac459226389a288e00c47267096088928f3ba8ea6ac2346d6188e9dc5182168416caa14a3c81a46d6723b8eb90262972126e2281a6150167e812f42a54b1558d1d38b98ea5d8a25b196d3d89288e1e962ce430a4c006b131217636d810fa1fec6e98abc20d3c0acf03cc93c56c3e83831bf5aacfdd591987f7b11f22ffdbe6ffebabf9dc9e81f7eeac5931ffbc33ff8a38f42e2de2b4af8ec65cedbd67272728be9684c3699333f7d8acf4a2eb284228919b99478e409e302af8693e398450c7916d0203c12251a1f31738e99f19c1c478c13cb2c1294c0480d4e1c274679272b78ebcbefe2d57edf7ffefb7ec7cf1785ff9947f3c5c71ecdb3971f3d7834cd664fa75f78fd9de89da757d8f1d14f4e8f8e0e6575877600208776bd361a4d73ef8bd7e364f4525994a326a5a65615792b0fd99ac252facd4da9440545aa7036d2f0426aab8cb44eb796b559a1157069a6046c756f3e17fb5c0628796e769b9d57da48b5d29b5ce5ba96656728e4795f76bfc1501db0eefb40c8fb5026de32c03a8954838cb1b2f5675f355fdc55e4639f45a45b6b41f6ff593b1d6af3b83654d954a6d9be567460796dac816694a4952638c0a0d64d1b9436739e34c9eea41930a921849a868a3babc2724109c1542a184657d18e0aa8087565426514d795f11a68117d80aefab34ada926624baea6758aab253d55cac9e5d4ccdd2a5559a9486553aaed605ef6274c59028801a4b5916cc8b9cf3f9256fbcfde5aa5f2e22194fb0b76f71344978d1c58c9231779dc1f88cc47b52ef191943e20c4e0d049817557d45f0caa20c38514e8ce1ce286264855bb1a508300b250fae72bc2f09f168b58f5b2338eb2ae31f656c0d0687229c8e63c6b1810c9c158e2247d0c0388af0d83575805605fc462c917518e3eaef59450e1045234e26134e6d35666f5d5df1f38b82bbc904672cc7c98885f7a44586afaf39427008c1971894c40845280904520285869363e49323ec27ad8cb9a5d167fff46ff8657fef27dfbe78f976b03c2d0dd6457c683ae1c85aae169e77d4e30bcf8352290ddc5f94185ff0210769ae8ce21191331894582d3e94ccf28cb72ee73cc94bee1d4dc8e6ca3b45caabe388d79ca1f48627f3050f2fe73c556176b9387af8c63b9f34c67ef2fe7c5e09328e12e222233fbfe4e9e502e75d29121f8ca9433b009043bb5efbc8d77ffcc1cffdf37ff677c7d3d33fb898cdd1e06b2696da3bd7a0daad7c557de279b53f6d5570be4a18585dab6919a86c7a18abbce99a2fbf99aab31414dbc734943671e87510cab39afe7b99ccd2e7a77dbf4210ed64f9a60afdbe0186671a0161ab16610b18a8ee65d2f78eb1307ca36ebd89acd3d05a06b5764e90350352f7de5fbd6ebe7e86aacd3197c139ac7bad26edad13d956eaae3d7de9a620c99e8fa81b80a4e77eca266397b4819134d9f6a401449aa286c84abc703924a166c35a9ebad65eaaf75c11a48e42373beb435d4322f5b5c3badea4d24c69aea546d43a08c6ae8bda45cc4ae05083124ca8c745d7eaefcbbeb08ece2cf548aaf42fa9be13a662b0629932191a4c62454659a4bc7ef198375eff22e3f198dba777b87deb36f74e4f3989134a53a5f74652e9a264a56751481d15afd2ceac0813279cc6098909c412b8cc4bde4e0bdeba9c132394470906c50a4406626bf122a44541e9152b86a3d8328d62621b7114793480b3308e1cc7d1a8aa45093985f794be04559cb324714412d9aa885e3c082451cc683cc26941610ce765cee3ab1923e02c4a388a23529f1089909705b11ac662191b830d01133c88270dc24c721ece534e029c4e85d364829729c6da6fb8c47fc37b5a0444793989b91327bc94cf09a1a4582c18cf94a7011ee429769293e639912a4519989705671343547ad4c33181d372c13b73cf9b5739e7b9723b5f60247095a62c8e47703a014dd02c70ea731284320b4cf28c451e783c9be38de1c5a331af8d0ca3181e5861ee03be2c0fc6d4a11d00c8a15daffdb5bff0a7ca6ff9b6effee16434fe8362045f965863501faa6886b1a0be2e6e9416e34dd3cdb7d4fb58159cb359e5b132026a8efca545b0ccc9366aaa0f74e3cb7edd242cf30c0ae61f080819f02aef7fe6b3a46bf11ccedd76bd1d02747d8fb0e7bbd21bfdb233a63befa52daade2e78f9aaa4ef1d887e6c071ed21391d8774d08435194e69e2183f7ed8f4d0c5202ef022403f56c5da0a28317ae8cf256cf97a94f4d46aa508b2bb652c974a599a2a1511ba5dae857556722b523664543ac15703675945a6bc4bcbe7ebd7f4a55a8bdd43c51a9f7dd1a882c7360a5019696b520a68e6057da26d4bf91750a65e37c6dd0210bd577406b70ef55b99ccf992d32de7aef1d4049a288e3e911e3e931a57518176382e0826556e54f711cc7882889b31c59c1095096887a6679c1bc2889a34a655d5410134822615218f2008537140a5919b022645e89ade385f19848058c12bb88d3c412b239a9cf29b45c83440336122267aa1a1453b9e0226b30aa145a9249828962226b31049c15ac35c4c64014136171a5079452aa3a9902e5aa2c999725a9f73c5c948887b3e9093a122c8e2704d2b17274cf98c5b9e250ee04cf699a92fa405408c7de506089a4e0deb464e494488511c28581f8b8129a241a11955088f220f3bc570432111213b8132b79707835e452702411f7e28445e178332fb0cef2d238e291e4143358a872ee3d5fe7e06b9ce3f30bc73b08b13964601dda01801cda0d9a31f60d1bc5b98ba2b8c8d2f6475d2b0615e9c40b9a4ee375a4426a1b2fac05843be641f5410b1b5ff97561681bbcb40b5cf734d16f00429e9b49be2df97c507cf03aa0622f35948ddb4ac7e3bf34685a826fcf038348cf8f3714cc9fe36d743f88b7ff0d9ac5efed1cffaf3a10d28c4c0ed2e2368fe8463f37ffde1705b91e08e9f66393ce59fb77a2de6a949da044b7ccad5ea2055dd9deab082f8d4c4e092b3d8f9583a511f55da9c8b7f49336ab69d6a2afd5f5845a6cb05143222215f5ee5ac97343a32920b59648fda3fa3895b04e17935aa3a9938ea6ab3da23ad9ebd2c1c3ea6241b4a5d122529db75cf7ca9a69ab197d5c1405e9f963f4fc316559451c46e329c7c7279465c94b67f708718ca8b2108713c169d59f4af4b1c069257e3832664500ada2582b98ba702b0d8179596211d2d2e1ac307531a52fc955294d0492b3280b520d4c92112384b2cc50632a1a5f3144c692b80aec8cc561bd47346014c626e2248e99ba88d8ba1591b41541ac0515f232232d4a543d992f599425650894a102933996d2461590d1982765ce953aeedd49789816fcfc79c195837b6278942b65091f8f0c6791e31b8e950fdd5326738359c00596f3d81225254f1625a996b824a1989cf238785e7a3161120bb19644cef351318c7c8cba2bf2509065315fca859f5d286749c4649270610d7746538e4e4e3946999573349b03392e76c4e3f1c1903ab4030039b4ebb7e9ad3bff783e7bfa137132f9d632cb6a7697b57279e585331dc3aeedc9ebe6dc04366db89611a19b1ffbe5c7712d15a1ab8f983c079a5a7986e8c8b32112dde21e7e5f8a5b7a2caa267d72db48f94a28dcbf2e301c4edaaa21ebb3cc17d5e13a96e70c427ec1004d037cec4a9d1a8a2e684beb6308840cbdc5ed2064ed7a5086ab49ba7d783e8e05dd32c9ba197fcb54ac55a99aae850ab5515fb414779565ba966a0390ac01cb2a25abb52eb58e10af1d08cbf9b862159425d090d51e2adaac0991d526db7c374b262c09b2f1ba94658ad7fabe7ef556b4f18d9015e3d62abdac21e0d8ac055ca7e5b28a9a68cdc0b5481764e982f3270ff969b14471c2747ac44b775fe4d57b2f709cc458b51418625b30b11963636b4d16b035bdee348210f27a9fd32a4853bd00ac042691e1f6d89179e12237042d59f802104e4763ac084f179e52a04070c630892202c2c4442462b1aac4c0182132969328e6245a83106b2aa79d43008f0f9ed467e4be240b0135b578643d278e9208671dce5a8484428532b7186f3912782714e4d6624fee702586bcc8382f2ff890cd78ed2870770a82e3e24a799a06f248c90b787be6797796329a5a6e1f1f716c625eb97b872832bc77b9e0a29cf1a2cd38f1066320cb3c0babdc57433a39267af1a5f0e4c81a54f9c65b67bc70f71ed9e582fb6fbcc17bb39ca75e297cc07bcfa11dda01801cdab5db0fff8dff3effa65ff39d7f254a46dfba14c132c6ac8d80a64856e3432c3d20441b1f48edb0cb34bff00da75d0b81482b85a787c9e82b1a6cec635eea07637c6a7fa54ebf00c64d40c8a65647d7237d630b70eba95b0b3d3e00e4d3f0c25f9755abef164b4ff32f92bd421b49986b00b07bf0fa01e32e80b25d57646d26ef1e7f7d86f7d48a9248df8cd34604a4fea3367a55d77dacf6d026eb56bd62ea62f37574a28f61500941aa58f43ab8526b273536d4a5ae88489d0ed6d1ac59a67149a8fbd28c86f628742e8bd361cdf4d5a00510a845162b41c525036265f83754e3a96b56962963cb3d4ad61a28cbf12cbd12c493cdae98cdae78fce801ffe273308a479c1c9f727a748c1b4d98c40949e498a9100783b1863b49c4d47ad45f91598f21501a050d38c004213630491c3e55b222a72873440263673889202b7c450fac555dc95114733b0e789f3212cb580c422011c308c81462b14c22cbc4458c6d446c1c4a9d22672abd9122f794c1636a2d146baba27f67601a2704efabe2f7482883c18498a3e0b9971846c705e528e2f8ec84176e9fb0b87acae9658e2972e6061e174251285fb8f4fc8b2739e9d4f18d771c6961b85a780a9f820f68997091c3a3a064e329c638ae2eef7351144c4681b18999f91c8c72efee1d3efaf18ffdc868147f5b962eb89ccdf9ec5bf7b101521c4fbce1ca2b459633bf3ac8801cda01801cda0d5b91a6ff97b5568d355285f5bbf494d2cbdbba2e5197d6af42082db3a3e5995be51bf7181da20d6053d350ded054ef82900f06900ca97fb73dc59b5d791ffbb62341febab52fbda2826dfb7cab1d273bae2d227b828f678783cf76416d4597ae737ddd3558ef2b8a085bc646f60210dbdfa56cb05d0da763ed77ad36d4d11bcfaf2130b2f7bbd3fec0a5ae8cfe465f3b37d2a5e1bdda4a1bd19b26cb81b2499420757ad352d5bcaba5a4cb284493d54a1a45e45d00b27e1841aa4848ad5db2394a61eda858029ce53ed68cf0082b4d0f6d441d967d31dacc5d5b6664d5bd5e16edd7d7f51256c0bc0c550d62992e98a573de7bf82ea1462f27d3296fdf3ae5c3f75ee0232fbec4d48e4834307639c771206439162188a9ea5e302c023c5e643c49030fd39ccb222536f0d291e17654f2b008a001a3018b67648589ad6b7128b162ea22f9ea1be7d553aaaf008780a54286cb6f9c418845183b0bc47872b2b2c40844ce121b7062c94a8f18c148ced33467960967d111afc409f76e67bc19663c9a5d904841717581cf669c97050f2e4b460b1805cb9b57ca676781db11d8107327562e35e5685170541444212017390fca9ce2ec2ef7ce0c988c776773ecdcf1b5b7628a5010db82a01e2dfdb7c46ecc45b6e0cb6f3d64912d381e8fb02622358662f506bf72a3e88776002087f615de6c14c5b68cc558a7becc44ec32e3a49302b18a84688fe1b8b66f74596dce3a02d22a609721dfb13492a6eb94851ef1ba2141bb3e10f241810fd927d17c0dd76e967e7593b42db9be81bc0b7c5c17106ca844e81ef7902d0667c7dadc74dceaca587a7f8df9fa8f2d7a375decf795063eae0fd0368544fb52ae86eab7862875770311bd865a7dbf5b60fbbcbc0680d4cd25d604e6da75d134ea26d0668d5b0356a9acd9b56453ceb169e96f4a6d2ea30aa1555fa2a2ed38a5f647ef8c9ac67d5917bad7c7366b4156d17059039115fba07429e4b48ed2d4357e55b1c9baf87ef9bc0deda8c0b2e85ed025b3a1861570f34bec2f81a7b34b2e6697bcf1f65bfc136b399e1c73e7e494e9e488647a42610c453d8c8518ce111ecd0bde787245e12bc6c638168e13cb2bc7c26d557c215c3ac1a150966859e9b417a1c48950aa21f725de78f2e0c93ca4befa7ba98110023e94781f500c51bddf4722e01c59f014bec4195b6baf541a3c63e3185bc3559172319f212a8c9209911aacc998aae7d1f9398bf30bc8163c582c782bcb79907b4611dc4b6222122623c7cb4723c6216664843c0a4c538f53051c91b57c38f63c340b4c08dc3909a40bc8738f98c038126e458687bee0e983c7c7e5a2209d2d1805619c4418cdf1de7332761c8f2c198e643c3a1851877600208776430062ccbb22fc8475d1b7e479460861a5985bbb711a5fdb4d0352ea8fd60aaef4d46e68b7e272f5c5d761f0a07da9f8fa7ef9b49f15827cc5bdd77db0ca2e7036f4fb7d6c68ddfb875b6e203df6fe9ee7eb7506e2d990d9e6a06b2f0f5cef80f4fbf71bebeff9aab8ec0021c331b1a122f33e81426128b2623a60629360775734e4ba2b6ead3a22d79aafd287767780b7168f41172a6c845fb487857aede4e9ee9e4b0cb2ac7bd880f6750aedb2dfb264fa12a547a27ed5024b5642d9d47f5ff992d6628b4ba023dd11eadc479b60b48ee2341478d640ac2ea6973aba200d415b44d0a56abbacfb676aa5f9a5f3abf49efcea8227571795e27c504c1421f188e9d109d964c423b52cb294c759601445dc9d8c4822c5eb1c7cc098c0d85a126320047c500a55725f01102bc202981525b1f19c85983c087908142154c5e7862a4a22015baba01b028980d5ca10b352c7aa8292fb92b428181f8d888c20c173e484894444e2981539988051439c17445e2973e1cd4be14b0be532542c5fe6d8f289b313ee24112f1c3b5ce9315eb937f614def37a9e7169032f1d9f323d3ec61bc839c7397089e122f73c98679822210d1621260421cf662411dc3d1e51a425f37c0626e2855b96f9a5e37eea88a2e860441dda01801cdacd5a1c27f3f9ecf2e7ad75df5271c4afc3ee951f67f82bdd9b03beca455e1bb12d8a48a5cd91dfb0b75ae6ca732a927ebf6b42642f30326401e8b3dc68c7a11d63b81339d20173f87944d4f53a48658f0be966627c8f1ac4165575f98000e2759fb75127b0edf7cb31b83114d912fdb83e48d91cef2e08d1060881cd68c8d0cf374dfee1ba9fdd3522cd6bca20a4195a60ba65acbb6aecab684137c552b47f66eae688ac0c729166606d5d63b262bad65eda2ea9540fd73b4d831eb79932d81254ac0f5cc5563a007a89f897a9b3cd28b87601906e2ecc25205263eafef5bfaf2a154c1bac628d08baae23f0522bb6eb52ec963af54b2ba1446b4c85b78c5016399a6714b34b2e1fbcc3cf7f2e62341a138f26dc3bbb833f9a320f86c79725a953c2c430cf615654aa5485384a03b996f81a5095c1b3f0054508a43e50aaa9b5ab2a60318a2cd3c8e0c5e2a8fb1214ef03a581236b1075380c99f7a41a981745757d5f5de3a54984f34a2070690547c58e95a892f982cb129e1442ae82068373c2cb47533e767cc2c439c44051d4518fd8f3c4a47ca1506636406248dc18b57014a79c1c67947920cf0d8f53c1e586870b289d62ae1684ab396727238e4613f2ac044a4ea6317746cac948785c18c41a0eedd00e00e4d06ed47ef21ffdedecb58fffaa3f03e1db416eafbe7e4b4f56d09a31a5eda1ec16646e33f2b5c180d514279456d565d3f89501b3e106d6f8fbddf64ebfea3bfe3a551872a3c374c85fabda7beafeea1cfb96fe5eefcc2d36f8cd5ffd070942de3770d3287c966b0cc435c0c7ae28c8754148ffb41c8a78f4a9ae6f271ad0d65e713d9d1cedf4f63a33b3f7485d6b81b4b6b4deda2b6d530af7301cab6ea6ba359d085dd28e6654a42af0eed004af1652a37e49ab42f82e60683da73648437497c2689f8e3d880f358bdc70c45b82749e8f462a65ad356596b5f1daa2420e1ab05a5566b064161353471b84a04a9e17e459813c3de7d1fdb7f8ac58b011c15a9e1c9f605e38c1034f0a0fc650da8420909352d400c28a508640102859a684e95ad7a8569237406c04a7543a1b04ac28a7ce307251a5cfa225a9084519c87d00352c7cc1590c0ee5a2c859a83202926089e398475af0e579c11c486c44004ec711afdd9e304e0c57b9e7222ff16a387511c6c4cc8cc745817b931113a7785f709c185e3a35dc9908b13a623184f3290f1e1b6645065ec98a8259ba204e225c22cc82274a208a95cb6c41a981c882794ece8d433b009043fb25dad48773c42e44cc6d5d0902ca56c76e3f1752d719dc7287f5fbff1ba9c72b66c98657f159ea401a5fb8ce83743f93cf0b7bb472103ac2023a00dd3e380b566b3efd6d60719ff1d041bff2f6c71a2698ea4963da71ed76aa4bdfdfafaf23b3348654bfb20b2b55074653360fbc0943d7fec67c5fedc7e64c1a303b1b9413fdd76dab7f6c67cedaa8bdb8569dd2b02a89ec3dc5ebabd4867fb7bbad552f034fd804097d1119a19566a58d4e8a9a759feb1a90cd15d1056d74d20537a3576b16afc6c8484390906e22ddb25ea4c104d6546c6f6df66b129395934a1a4417ba2ebc975aac161409a641ebdbae5959466a7459198e598fc2920658152381e053bc0f3cbcbae2c97bef629c458da53839e5f664ca787c442996805084fa9cfa397d3dde46a914c88b82cb3ce722cb8854895c8415f05a529425048f130866ad486f54f1aa145ec17b665946ac824378fd6ac155e19958cbd4c02452422ce416c409aea852be226b49624b66020ff38cfbf394a2145e1c393e3c767c687acc6934c52642c0f320cb7830cf78f8e48ab14bb993186e312671475c59c5980be2185e3e1b931596f1e488dc072e161977a681b428797451f270e609c2573495fba11d00c8a1fd2268629d58ebc45a8b06bf4a27685b7a4a9359be4dd8b2db6cddc96e249db4777d06c03174df0dfad4e168c0dec65aab9e45b61869cfaab7feac4f2f2b7efc6dc7e91eaf74e3fd771fbdc756d46d7793bebec816226318ae07d8a7a6e0173f08d96f9169ef28ed3f26dbf541b675a1b7509a4d3d91e66f652b18d11d2968da63643390fcb5ff505e4769bd937dd50b2096bfd3cecb905ea820bd4b4301eda204429d42b5bcb8e97d666938485474c0b5d0e3209006b0d381d5d808b9a8b6c2393508696f08224df5f6f51857648c6b90b4fc7bad38828a47308884965e68f0a131924ac0acfebeac31a12e6aaff090c159b3ba7f5916789f723f9df3f8d1039c8b30514c300e750eef12a0aa5129c4323242e22c0ae4aa2cca92aba2200e4aac9502791972663e47541919417d4082e06a7d970018098c2d040382e1a2f43c4c332ef292d83a22f5dc8ac11bcfc839725790fb4ae9feaa28793cf7dc361eab1e1b94455e3097123b9e328d8571506645c13b59cacf5fce2b70936738a37ce3ad119f7a21261e278c8f1c77b339e33b8e575f00c2181fc63cbc4c890c2446486cc29581cbec02498c4e5c7c30a00eed00400eede6ed8dcffdd8cfbcf4359ff85963eccb8dddb9fed8845621a748c708dd020e741737abf4192dec75ad670125cf0db80d755a07fe71e3da79b9e6b1ba6978ecab5fb85700a269e8f43d9bf41b34da5f45decb49203bccc50e2b98b65884fa0eef2194d535e0e84caeaf82551d06179c6ec78a55a1ef3ee07b0b50d90422ba65ad0b43b530dd442976a676b561433f7978175aec0f4676af48852172d2aecee58edb8b6c1913a5058d9a0c6b95ed1ffa770669149ceb760ae6d6b94df1c3d55aeeec03d2a3e5d43cbfb32169cf7ea85a19e4cb7b2d01888881b04ebd5ad7d7d73586120875b463552f13964005542b2945a41280d49578637b5f33c62262f0aa8422478b0cef3d1a028a625d4c321ef39e813b47c7786b299cc5c731d4a28569f05c9425862a6a52d5c0286a84e003654d5feba462f9327826b5ee561984580ca72ec6854a87ab087091155c150545500a0fbe7ee78bbce4c12ce36b2631b792088be5a92b985a889cc307652181f7b2059fbdb8e2f5cb94474541e603b1b5647982f723bc71c4a398976f9d604681fcea2979e6f17e416c8e78e9e4985ba305de4c994742620c2566fa999ffdec4189f0d00e00e4d09ed95e7973c9f7becef595167de4928f7e1fa0b1936169a9043cf8455fd2f1cad67bc816eb7abb01fbbc84e0a4dfcae81ae17a536fec0d297b9ff5196e7259dd34bff6913d9181f7d37aaf9d7f0f62b99de529c373f5d9221f7af3f7f581b57e89caedc3b80f33d61094e903c643c6bc7480e2d0eb1c8aadf4f5457a80413ba5eba63e81ed604919524e69ddafc709d37ab681cc446d80a7756ca0d9b92dfbe15228b183fc7507269256c4a5de9755dbc4cb371135ed2136097531f9b21eb1ea725809bf4bfd5d5a2acbab08f8b56e22eb531bc3b114616c88e90e7c37429d86bc260410b0165042f02c66977c79838e2326000020004944415476c95b8011c3c9c90967b7eea0d662e38445cda2e55026a662d6b2460941598492b45454435dc01e28bc6786e1695980b51c45115f334ec82347e9858557decb17cccb9ca20c1084481c91040a2d49b302d1c0d445242ee16434c26a9522951b6111479ca7c2fda2e4d27b6263b1c6717b14f1b1d3538e6cc47c91f324cbc9cb9cf451ca3befcd28b3c02439e5851762ee4c27382d98e59e53ebf8e8e998fbdefdb24f7cd7bffaa593dbb77ebf2fcbcffcb5bffe371e1e0ca9433b009043bb3efe08e50f23f2bd4b236cf56151d96a2a6ed7dbd01dbec2b6d4b0cab3272ae956b3a7f355577db6fa8fbd22308d1e7c80119b6d86e5d020770d381d04120374686dab6678dcf79d29dd73ba0280aa3b2ea69dfcfaeda3a5da1f0dd121b4d437863234e73f48ea68dd010876fbf2b50342646f11c07ea0215b40ca2e20b34b27a4bb9f6c3fae3bb7650f3d76bdc69adba46c934e44b2058174c7daedd58115bac9612afdfd6d0b2e6ea21dd50db71083357d8db0c9668d1f8351cb9531dfbcd02a02b16644d465543384b6865183816be934aa6445ea915408121ac2b535404110f56bdae096968ab4f6e3d638ada22ff5755691a5a5836e9dfae5bde7c9d3a75c5c5d12ca4a9830e0302e228e62c4442010895268c965a9a4a5071fc84360542a5725a426f0b0288943c05a41f194be32f84bb18cade134b2942a55da983138235ce44aa48af501c423e2702264a5e7c12ce3a2ac8048881d27d3118b22e08cc31be1ee28e6c347632281fb5733be703ee77199a3c693fbaa1ee5f856209f2f78f7e91597f3a7e4a5e1b569c237dc3a61b4b0e68b5f78fd232179ebef4e46a377bffdd3bfe107bfee6b5ff9effee25ffeab3f71b0a80eed00400e6d7f93c5877f32b01ddfc0a975136fb0b69864ae77cf0f96e548aef1d35f9077d9630aea2e9bf43a57d6fdc6463a2ed4a192e456be7d9f36c21e006657bfb58753497aace09d1110dd672a76f42d3e78fc39840e6fe024e872d2f59bd9d74fc9ea07199bc7f4ba2b069fb53ff16a9ff5baad02631b0891be59dcd36f59c11d6d718d6d27846816b577a145ebbd688f0b417a84407b9e48f61867e93e620fa5c8367fc0ca79d0d2156914ca37d8bf8c48276db3fd6f2382066939c10c862583fc326abf5290d726bd713ba2bf061d6b04d51461d49a6677499960561a55ba4a0d53a5161f145083e009594196cdc9802b57e9650896851a32f5041f288232f7ca4c2d476a509f912b3cc94a1679c693f98287698113e1c5a9e36e2294ce4069288d612196acb42b5d117ca0a4a40881f334e5cdcb198fd31c45998e2c27b183e998cbcc739ee75c1ab8f425a368cc6531e7e162c18cc02bb78eb865c74c543989633effe8213ff5f03157598a08e4a7535efaf00b3855eebff71e4fd28571ce7de8ceedd33f5064e9bff1af7fcf6ff9118da23f3a82cffd8fdfff03b383757500208776685b5b800b557d22626eabf8dda6ca40f4409fb9d05a073ccb3bd8b81a4c281f3c0ad95e96db15287b3683710f30c68098b8ee67470f95d2ef1144d873e0864dafdd7a17b2f734ea1eae6bcba36d18b50c6bb991a1bef90abed2ea48f68d886c8e731fb818aa23911d33661bf5ee9657c7505d513f8ce8af07b9ae2341072245cde848bfba3b838b6f98fcba1f944903f4eb9677d0eadf5aaea39312d95c7bed7528034050bb80ac5b412fda0d4c6e6ce5226bb6ab06d2efbd9308b5827a8714ba81e22b85f4b6d329acd81bcdcadbb28a64ac86586a31c7e53a95d6be432722df7248d4e7854624476bd5f6250852b462de0a20c6b28c2316bea4280a820642d0d55848503c865c62104b6472bc401043aa058f4ae5bdacc48a328a4aee8c0d5620f79006431a4a0ab41243f4815c84cc1764aae40a05421a202f4ad2bc208a2c2608b90f3ccd0be6bee4f317738e9311c751c44bd309de39befeec847b94d83c2345c8d294ab3425f51e237095799ee68159a9045f521605799ee38b9cc8fb497af1f437e5ce7dfb2449fed96ffa75bffa7f3b9e86ffe67ff93b3f7e75b0b20e00e4d00e6dc8be7a0af2a320bfb9cf64900195e7b6e1f57e1a5d7ba64274d3749e7317649fa2865e9346deb717b70d3634e930370cb95efb4aae6fc45e9376f79ae86e638e5d8b7ca08f0e7967ea563fa8439e2d8daabb3e446e08ae9e69adec4b03dd9e1cdbc0856e05219bf7d95688bedf71dbdd1ddde397a6ac6e8517b2c758350d7f19189beb409c2170d59571d45edaf3ee68ad622c1bcb53b68c731754ac7fdcdd3636854ab5f13d18628dd01623d65af4b0b9336aa776bd8e5c2c69871b60a31144a9387097758a62ea6bfa06505a03a4e55ed81eb7ce389b660444dbc312d645f79520fc3a8a23a62e926f8834eaf23bb48cbc1883518b1808c1e382c7e229d32b7eeedd8249322212c33449884763121192b4c09a82d2972c0214417101bc42e63d8bc253045f45524aa50c81abbca014b091e3eef111de443c59a4ccd394f9a22031312296c83a8a50f2ced5828f9d96dc4a62dca9e12a28927bd454ef20b2865be398b3c998f3bc40832731862c2fc94a4f622d560c8a2716c36d85f0f482372e2e5d403e351dc59f9a4c926f017efbc1c8faa5d9ec61080e6d575b5c3dcac6e3db2f05f43bd70c2ab23294b6197d1f1465e9de76e736a1b66789902cd3866597612e5bee7b5d46ab6b1e2b0c08d5491b94e9b64bec309c44768ce3f0f9d2f89b347e261bbfefd0b27629946ff21e97fdee136bd425db4e03bcaa0e3fff57686b17d237481c068d79e17ac4bcb21316f483ef7d8cf1fdfa22d7387ebb98a96c81ee433f919d576d0331dd71e5ed7526cffabef6ebe3b35e6db84668101c0f456365931e5d9bc2b8e8da0fa01d30a60df9c3fad82a854a1b519435f1af76488097ac8e4bb1dc0afcac239a8aa24137af8baea2258ad6918eb0c2671b4c6c22182cc61a8ca952c7525f7095a73c5dcc7934bbe232cfc97ca854d6ade3ee6444220ef106098e5c85cba224f781b173dc4a62d2a09ca739a9c2388eb022a465c50d3671068332b28e493c221a25882863a3bc321e71e4aa0a9a5951304b731645491a0251e2f0c65088a1085086c0dd28e2c81aceb39c3228b9afea795e48623e7672cc2ccff8f2c525b3346596e68c46c9e5c5d5fc2f1dacac5f9aed100139b4bd5a20fcf39aa9dcf67e237f0140c7fe9eddedfded05033778861b7db4e58318976140b44a0fd07dae24d7bf6dab3464bb2f59771a639bbf59bdf5561edeee37b159e7a1034af1da3a64270b98f6f7539f051c3da7a69dd4960dfaea3692dae3cd77cfd71e50a13d950f7d7506b265e4b71fd7d7a3ddca26ba47b9bd0c10570c17746f0312baf16cb207a818ea9d5e0bac5c670f1b1edda111dab5d636e34e8d984cff1d5b2f521bd187ce4ca8eb30ea6af69500dee6da9646ca98ae19ac96c56535f56f9f3e6c152ce98827ae840dd76b4b1ba11a59d589d485f39de7d2661e1cdd146159c5b68206a82977034af09ecc7b42f0780d882a8f1730b30eab11231351e029a5a0a464e6952b358cc490513188cdf32aedea629e029ebb89e54e14e3cb4ac324328e443ca7048c2fc88a50a56b117894659445815ae5355329bea7694156784495582c911822e73815471a024fb305ce1a4686aa48bf3156d3c9f8f675e6e7fffa5fff71f99e3ffcc70f0a8707007268bfb49a3c46785384afd1ee77e217ab36c2f32c50ef2d90d61b5ee479838f0edd67835a76f9b953192814957dc087b259425c9b6a7b64f5e83e5d6fde5f7a0c1a5d8b920dbd181d3070fb1880ba5d68a512f5a57ae98031dc39eea6e0fcfd012e3de3b51a14dd6a886f4202dd30b5378d7de95d2e7de6bc6c0117b09d396b684e5d375d6b18064b67e6ec02333278df5dcfa80c1323eb40425917f8ed025adbeeb1df8ea57bba2796b3a3afd64bfac148e7471b6f6ab987352211ab50af766659a356445a6b511a6bba71df867649d7c1b0aa9bd756e75a63b29a1bda4743a0ab3a136daad6f668a54883816f2d1069aab430845485b42cabfa123242503c8a35861cc8c592b89868641181544bcef392595e608d47134f6c042316ef859097f8a2204e1c06e1499a71ee039989c8a51243bc4a336c6c995acbf922a5f081a94b388e23ee8c278c1da4c1528ae122cf98170559f04c938871e228d302237074343ddb77aefddedff16de66ffec8dffd73dffdaf7ceccfff8dfffbe77eea60931d00c8a1fd12694f1f7ef11f9fdcf9c85b827ccdfec5e4dbcb419fb7fb7f9864b2e75e3a6c383e3fc35f767cfab75a02cf090df51be4322451427f316c4bdbafd7d9aa3db9f4bb4c44e9893cc8761b593abc55c23ad77be9ae6440337d1d2eb9c6ec6b182f4d769e1df3465a2097f765be6f033572ad9cc4e7e135972d3fd945b7dda31fd4cbafb51d02ed42baba1740d834e27719efad82e83dfa217b5cb1b5450dac26e91db3f67bd53d5d1dfd8a29dab3bab7bfc9be952fd798773bbf0cda86b9ab688ad00622aa6d1cb12abb905e9214e91bef4e91f9ea7a4daca09bfbad2e59bfc4b4855b5a34f6d2aa6f5983196dad67a9354a549705f3d2ce5413f0cba277535d331070ce60c46104be7871c9388a895dc4348989dd882bc978ea954403a90ac12b04435ee63c4d531e9725b79cc31987331e72cfd81a6c12e173c3c20b1a94d819a6d6111bc7add831b1c22452a6cef1301362eb384e12b42c0891f0f264ca5b594a5e56d400b18bf68e80381b31cb8a5fae4c7fecf7ff96dff49f1c4deffc0f7ff6fbbfeff2609d1d00c8a17d95b7e33baf89a20f0729a7b61845c3ce621da849b8a9dd2f1bcc45dc84baf7265843f7f731b6bd6cbb304a1f29e6bea966fbf259ed957fb55944bcfa6a4acbfbd83266b6e9a9688f9773c7235639d8b22ae25c7e935b7ca44da3688b22fb2a12b4e7bcda4859da281c1ff023eb1ee32cd7c0907b8292557add4ec3af271d46b9defc681e2d6da58c4df37c9fe846b347bb4d7bb9c6dcdea5aa3e749debbb5dba6c617d9137651bf12d3b9448da6f547ba226fb40a2a16365ebbf37e64cab374334caba1780d18139bb516cdfc7feddd4f068a4680d81a826bdb736c21a32a4c8bea181d5b85043813d1056fb92acf6aeaeec65732bec17c75c29baaf404883fd4c9aa9b4b21a256b1dd63844840c288a12294a9e2ce68808de7b3201631c85441543971a1685e7d22b33afcc4ac51bc3248ab9e5a14031c1736604175b6e3bc7540c2fc623bc464426009edce7a82f7934f73c99cf21048c11d41a6e8f13ce4631efd905c968c4d9f15854554464e7d494c868ba28deb978b2181d49fae7ca68fe6ffdaeeffa8d7fe8fbffcf1ffa87070bed00400eedabb85d3e7e434feebcf6138afcb6dd1fae1dde61d92116f74c18a493dbbead02f639dffeda12252d23459fdf9d745825ba0f10b6adf36b168cdeb4e94dc7789d2eb52afaefa44bec691dae29775577e2807d8dfe6d1866eb7bdb617f0e5dbb39df65af742fed379c56a931db4cddbd07a2014696865fbfbf5e074c5461c817dfff13dd0b500c3fcbf552b636cfd23da08ff67285492ff2969d80b1cfc0979ea8499b31eb7937ede52b13fae90df486b16fedb95f679c9a751ecdd42aa947a55573d138531aecdb75ae54977f4b421fde1852896c386356bce175944675cbd90de0d674a499e5fdeb35da052aba149b6ca4c136c41215f05ad313d7a327b553c85a8717e5edb4fab913f0180aeb2028b9313cc530b6c2423c1785e7e93cc5f992a31a7c94040a2ab6ad54158d60ee21f781cb32709e2e981705c74984b516eb0c93d8103be1eead235eb875ccbff9ddbff965e0ed9dd3605ef2f4fcf2fe93274f494a20949fb091fe833ff8af7dcb9fbdfff8d19fb9ffeefce8c945fae185897ed59d175ffca1eff9ddbfe79ffcb1ffec8ffa83f576002087f655d054f991fdbdefb2cacddf65ab7c1075b9bd66feb61bef098e5aa680ec6f69ab0e599f43491ff20c4fdd37e68d6c645deb91f432099be6d5a4217c26ad9ce8966772ab29a1dc380d4fccfad52d8d7ad92d8238f802a4476aed7d2b691a46193a5087b2ebed3741c61010a14791625f90b13d46b44704a98ec4f51587f79b63dd1922bdf509daa391d1ec47a09fac40ae116adaa7487dc8f93214b7949e6797deb7b14904bc8f4ecab63eea46afb4677c9ecf0cef4fc21bae66d9bf0f5bea60b40786a934c08334b484d64ae9ab7a8c8e6ea38426381970b968c709d2a8356993ea69477fa567ee2df7dfd0a0f60e526dbf6da1adc175b6dadf9770c3006a308d54301141b01857d79048159d9150fdde58cb442aad9037b38293c8918be5a92a0fcac038081f494658eb58e0b90c05b33c1044111bb328035921c4228c9d6551144ce384493c428071643819479c9d8eebe7b61fda0780fcc51ff821fd0dbfe2a30f4c59525e3ce69dab4be6d64834d6ffe06ab1f85d65168e8ee2787aec1c8bc53cffabffd35ff97f7ee5affad47ff4fffdd31fffc983f576002087f68b1f823c1a3282fa73cef7f5923fb7e2879501f6ccd1957d53cdf6c0321ba91ccaa0a1f8bc01d790c15a85f3b5c3ded231e837aed7e3eddc739c5acfa8030044f67827cbe3a4addf70730177dd7837b2d769dafbf7fef7ba0fd0de9538237b9fdb5d8f2db5e9be81deb9fc860e902dbfed4fa8d1ce6b97ded4b9e6793aa8cadd8518ba232ad20f0165affd4af75c5f9b25f9c3c967b21588492f2f587fa466b886655fa746a30f9f53f8f84d5d1efbc106064057fb59e55a57eec6d3d61105d1b6be510b90aca69f36000c75eaa8b4e6acee6249ee3a61b41645ecf9266a1fc5458f944a2570b86b14d71d5ced884b07531020e0cdba6865edbb31eba891980ab2588311c1682088f07091f328ad0adb8342612c918bd0644a1159827abcc9b92867941a98448ea210f0ca59e270b7c73c1847dc3d3e656213f23cc38ae76462393b3294458a198d5fd8771ee5a53c50059b67947ec1fdd473ee0379082f8e9de3eb6f9d703a8af8e9474fe247e9834fc771fc131f79e5d5ef4b46f19ffedce7bff0997ff957fcf28fa58bc56f7ffce8bdef7ff37cf6fac1a6fb856d071d9043dbbb4dc7278f3d7c13c8376dda859bf4b54d25d821a0d0feddf30f858808efef1dba0044b6f84f75ab91ba1dc0eddbf3e657b49b921336a8645b9f6c59d7562cffabc6afabd2b1feaf15fde9932150ed1902ddcc931f4a515af6a1a6b5ac84bdd67d6a6983dc2402d2e8ff4e1cf50ca05606b44ab44fbc53aef92c03f7e96705db0b31ef696c6fbbce7a42c89e1a15b2ba9e0c4faac67c922df7ec832bbad7730e2bd05c7f8cae7faded0a3afb5caf29ca273bb5567aee7236dc6fd9e192783667c9668467f77f72a3bb69cf999d08c88d615637216eff1eaa6cc7fca22c731a7b404fdb91b3ac075916bd4b83ce78b9d769ab3eaf0a752b80a93448c41882183cd5ff035201152bcc34705e962c82902a5ce52545508ee284bbe331136b381b5b5e9c38ce26234e46539c58d232e571ba200d9e0f9f4d4012a2f8a4fcd8377e8acffcf3cffcdc9ffc137f62ebf0bff6ca475ecdb2fc77b950e0102e0be53c2b59941e0dc2bde998442c6f5fcc78ba48f1be44caf2138b34fb3dc7d3a34fde1d8defbb50fe2525fbdda7237efdd8869fbeccb97fb0ee7e61da210272687b378f1b41f892105285d186074b07325b772a543fff828ce71205b9b681263bcc89be625cb989d9770d6b48b7db8dda3528e4dab76a15810fd064769fb91dbb90c18b4ba7775bbdedbb6b9d5b466c576a60c8b7daf095b67edb37bd54fb41e6465442b774b4577c7a4f7f70e33eba35e75c9f8f11b94f9450da46e5368ea9be356b0436087b9794acd21c1ddd61de6e4fabdabfb07df368dd7b156faff9dafd0443c0a4ef3adaa39cde77b7ebd67ef5ad0a65885479d71cdb1e21da65f2f751160cd5bb48ef6a16dddc8bf59a4321d79e19ed679016b65e535c695d13d2cb69a62bb4b1faade9fdb6281a1acebe50fd2cd4615943836d0b8308042a06afc0524cbede8c9d2100a9810c30de5328c4b1c34686c20ae746b9ed2c1a199c03cd024f1719939101755c66421a042d0336522e2e2fbff74bf7bffcbd5fffd16fd4affbba8ffff06432faebe3e9e8c7eede3dfbfc0ffe1f3f78de7ce4d174fa305fcc31784e447859c04bca7be98ca08a2f9560148b604488102294cbf97c1ae0779e3bf73b3f7ef794dba3c90b0f67f96fcd5cf45bbff6c5e847eedd36ffd5c545fea33ff4d9ece1c1d23b009043fb0a6c174fbe74797cfbd5fb8a8c7a08da073da4a2ba470ecaf3ca42a6d700bc9189bf05c4886c510ddfd324da0fa0eceee9f6c49186a1dc50f35e1bf4615d2c297b66ba2f0dc266e148956fb0f35c5d093d0e78209b7da5abb0de6f96e9a6f3910174309c96d365b8922d65cc7b52f176c1c8d0f1ba07c392ec91e675ad89ae9b25e0d7624e6aa4deedec4b5f7d90f48d42ff6c0e3a8868aa71914e958bb0c13fb5017468335349efcad9e652d88f3c62a8785e7782937e98b6ede8619d940deea85e30312c10789d49d62f9eb85bbc719703e07a60647fc6ae36edeeb5be3e0d6ef2c17d65afacca010630d5d5326bc33bed784ed637096c3a83a4b52576669e2a35eca8be7752e5a88948b5eea4ce22d00ab01881604ceb81c539dc688c0d01acf0a028785214bc9d2a636b98e79e995ff0aa89399d8c48d59196054561c194bcfee02d3effd67d166926c928f9f47836fef4e82a49cf9f3ebdff4d9ff8c467c7c9f82ffff83ffdb1ef03c80aff4eee03850f046718bb98d3115cf8824559e0bd52fa8ab658119cb59c25236284277981f8402c30892d231c85b34423f3ebd3d4ffba8b19ef7ef285d31f3c393efdf7ffe117de981d2cbef7bf1d52b00eed5a6d7474e7331afc6f119117fa0c6091556ad59508ae9d25b36fdad1fbdfe459cf15e93c9aec79fd755ada706284ecdd5b19f4d6f6a7336d784d576972a6f70a83e0a3c7b8ef7a0487ab06a49349211b16d45a24b1010637243d1ab2c20df69a0df0a1babf57b30f40ef79f24e6d90e1c29cb5a9d063834a6fcac8060ed80003d2631c49ef5f74735e7c008b6f530961138776adb96d69488aa062d6b9fb757efbb0eaf8b6741e5d5610ec0014fba52a5d6f4f92819538bc63e80ec7840caeee6da95cdd88d5b3ec9db2f7bde57ddbc39ffd9eddc5b9f56d3c23c5bc6eecb9baf12cd2d93074638d4b7fbf5688a6c18c25b226fdd57521bcaef6b6ba667029aeb8a4261783b116631d622d5e051fa0444883e1b2f0a4a567e14b6645c1bcf00485a3e91169eaf9d2fd275c2d32a2f198c9f8185561b158b8ababc5e9fc6af6d13ccfbfe76b3ffaf57ffce31ffff8af9b5f5d46f38ba7df69f394586056061ea61917658eaa726f9c30b18e2745c9bcf4c4cef2da74c2bd2422891d679331ea3de7b3193e2f7144288efbb352660b737cecc6df9c7bffbda9eae71752fc1c9e83eafafbd80e119043bb560b653903b9eacb7a91b6525d725d87d25722f8e87aae3773f91954d0eef7e7f648800d45877a738476c9bbf5183f353f7df33ecd0f55b3b65bd9a59b27c3d6ef56576da7df1b0ac3f483865accab5bcfa00d6fae6aa80188d91ced3dd3f036a2207d9a1eaa3b1e74174019bef74adfa4697574426c7d6063136be9e6bc951e6fefc04bebf3b7ef1d6db9a65086b644311bda06ab87dd3c517781f48df193169c68613cd19e5aa2b521a703d18abe32efdd2062375dc2fe1eff5d6e75dd59f3227bff540740d8f5231afbeecac3718a7efae1e7113bdf51deddb9cf9efa3a4d2da69ec3db4aead2bf06a55d3cdef6d27415d63b45f88df3541a424e413beb70edb80980a9144c5817b1b7219b86da61d5fcde9b4aa7c4eb3a641342054c4264105b90fa4091e66850b08eb71ecd088527cf0b923861343d66343a428392e72985f768f068502ece9ff0f8e1fdef188b7ec794803386b92f59a892fa92a2f4444e882c4c63c75194e06c8e2a58032f8c479c00c646bc7b79c5f92c636a8569e2485378eb4a31c67212475ca6d987e7b9ff8198f847fe7ff6de35d6b66d4b0bfa5aeb63aeb5f739e7beeb75535514559660ac900215850483fcd03f221191878a5122102554884409f2c3440d811821189487891ae40f10c55862d4040a5396154b432962454249956529d4ebd6bde79eb31f6bced1dbe78ffe6abd8f3ee69c6befb5ef8538c7cdbe67efb5e663cc31c7e8a37dad7d8ffbf7f5577ff4e2f5976e95df0d80dcb6bf05b672abb6ec51c89d424bc043cb591088fceddb4838ab27e1d9d27f67343f101dbc0ebba35e0c39d1e41b74d54a589f032159e5cc69c0d75e35d177a8fb82fa8277acea4e62d8c5033f6956fad4b06dfaf99ba889b8d728dd7924ab06e1316f76dee5ea1aa0ca994bce8053442625195b8ec01b3565afadee64073c5f61c5bd7d3ea73e501d6295fd13764e06dc3a0d3570e5c5c9db546f5e717609aed1695c473ce2230ef5f6a7fbf6c0b3aff4bcf6f99c6df10c38f0c95b4c635e8a4c57533ec2a9eccdb0f4cc6298672e00819cf523e705e05f1a0a92175deebdc0940636a4b1182b1d9aee56c27c0d986b0c9977ca625977b2b62c9f205a9c0825d1b1b832d3564b60a26285422980069086638ce0ba228480fbc33d5608561a822e78260a3d1db1c62f6159eef1fcf00ccfef9328fefe3e603d3de0a30f3fc4f3fb80af7dff399655f0d1eb570862f8c4bde2a5699a076980a8e2b028822a8222bd3f00cd54708142f41ef78705073da409ca83e183bb0584e061359831a8e83f74c0f2e39f79efbd7fe54b2f5ffec7048eb70af006406edb57b71a2fabd4f6c7e85d7dfa0efbe345b46f0b95ded6cf049b7de1243c9093db6249c2f57bc2cde7a37b846c7bb5f5379dc6fbdaaf0843b71c8dc2245ef02bfdbecbf485b68554db9f7247ca45794efb8568363492e1b5ecac6e99435d53802bebcd909b1bf05e52c4b9af7f0e3a2694ba7cf3a50cb69cd28e1f58fc63e44291cd2ba0fd7cb30a42d87d9f63c49fe779b763d778dd322bfccf1c9f742cb277291d207ec2a908b13502d837b0ed731f76fbe6b331dee65a2ec749602eb8addf3943df1ed8eab4f6a009278d88eb7cb0f8a8c32a57af87335022978363af0224d7ed0d774af6c74c3046b362624f88bfaf497b5ab5e1fca871f78abab0560c3327760be3ec763ccf46a1773704db201c5b2c0f21ac24ad633e39a65b6f2d7743540d46756ba5b585bcd8bc97358c849941c302407182c0f480e54edb3e11b0f800c635bd96084ef10e12149f7cef03bcbf108765c133352006bc8e11a2012fd605c768300aa20816113cd3e4d8b592f89957471c497cf2f982cf3c7f0fcf97039e694cf4d607d4eb1fd1f26757bcb71cf099c3fd075f3ebefe639f7beffdeffaecb3c3affe6b3ffba51fbe1581370072dbbe9af803f2ffaae44568ff316f0c044378c200002000494441541b9ef226f064ee5ab2913994490fb692cff437cd85a31f71979ffb425636b7c6f69eb271b1190000dfe2d3cb60833b49099f7ac23afa400d247430ab58e6f696aa97bfe3913d5344b18383ef75250ab7d429ca7511673e6d9d63e7fd5d0df278be6863a14ec8f633cad9c0c91edcb744b247ec18b7d41779c2124e2efe8c5bb725b29d7bb217ccd6177bb37df667986108a92bc25cf7fdb4a6b3ba736bdb139f37132e4d49ae5d057bc8c3375e572f09c6b7ffdaae2fe35e3f6676c34138bebd20ae15aaef51a5ce8192d990eedd81123973768ff19372862a39dc2d787931294e5ad363d119cbb113d67bcb5e710b3e7d583b01b5fa8064f52e022dc023b3625913db15104564a6ce8a4074a99399d634b15a4cd00c340310f1f264f8498bf854101cc2823b559082e7e1846800222147e29901f7aaa00a5e5bc487c7135ead1158023ef7de73dc89e2f5c311d12cbf6f407a07c044212278a6019f5e0e580430e5777cfebd673ff4f9e7cffec88f7cf4e2bb7ffccb1ffdf7004eb78af006406edb577063f2c3f82102bfa65fbca5eb628cdcf5ab97f7278b45e7e696ef17d8abde6592dd20930029c9ea83fa099d90563abe3b53c893c8a6749825170852216f95cbabdb6eaabb5790ed79e8b2b74ad2b978c4d302baa44b85eb04f6bea356decf4ffe8be565ed8ea9bad7bc9cd6bc296e7c175c9a7ca51e6f5ec1a1e71003c7c79d5b74ddc276fce6c2f647f2b0defc6c26878a23977f227dac19fbebad737392e1688b2f0ee65f02c7c00d1ff62c03cd6327488f5714c4fb7086934acb47d5b5224a2e9c19e406d6e549a5d56b83beea1aad9639b80f95bc9c49e95d27a8032089f09279ecb51e1e091c78b1edf0383dc8dc35ac57b2ecbdc7dc7d8a8f6a4500f344f8fdcf276740c925b9f9de9975febc7c9abb131f05b76657daa85eea5fcb072cd241ecb340ceaf9f745a15819b6cb44bc2dcbaccfc77138592b03241ccf75dcdc03dc68834e0e8ef1335ef4934ff91aa918bf9a51e28f8d8003505091c2dbf9f00d188b8aeb0ec2086dcb7794dc32b8b781d4f786d82d727c387af8e00048644d5a200d1e54e11c0bd283ef9fefb903b819a1d7ee6d5c3ef3846feb66ff8f4a7bff8d94f7cf01fbeffd9cffd5bfff35ffecbaf6e95e19b6d7a3b04b7ed51278c0202f972298eb12953e79dd8a789e4784ca0d6e31f7eee36257bce4f2054a5ab4554bc6b2c6b37470004f73b1dc94395a6dea821bd152d7b0329f79e53b9c4fc83c045890f4ff42fe81ed6d5597d30a1076bccaf97bac3deeed452b9678d7f3c5201badbaaf578a83ec25a4779f607d92ab217a83b350df79fcde9394bd06971e86eb0adf1cda1d7bdbb774f54b6600e848a985a662557ef7426fefcdcf13ea80e37f5bc1c4fb6b7b8b8768ecef9efd6ad239c00bfd91a33fb37ad9d6063a648f7ff67d62ce22c18a603d02692dc85446112400930093004440444a4a03766af33ee04289e3f9b4667a7c705205e7bb68ec532dd6bf3ccfbd13d860e14f3518bf8b9cf3771e1bef2f3ed1d4fbacfc4cdbecbd9d7bae6cfd3b52dfaf58b7b3f67d262cea8a9e4f0c7af017ebf33c59646b724279051d60bba868931aff9563b165533629188166166b07c87a4db4f42faba4114aa0b242c881af08a821750bc9405af4571920068c02b01be00e22310313f57097ce270870f0e7750119c4e868763c4ab68789df72b4800a8594f9ff633129025e0fdfb03de5b0282114ac12796c3e1f3f7f75ff7b5cbf2afdd7df4f1cb5ffa73bfed37de2ac3db04e4b67d05b60f7fe6c7f889cf7ef3f7d7116cfe0b99c189789a10a71391b7c21ffe2f6744d05de89bc81b21a07320a473c66a87018a3a754e63e67c1b3333a84a022b64e69cfafe60ff3e228d2d23ae0b556bbf491fb4fb989c144c189e98f33f2af7bd0895e54c5fb46b35ced3077c8fb976923378a8a0c2e607bcbe5a69d6712c32cf4c4072b7cd7c513ef22b786eeed1d34abcf56407b127b91682f3a7d8f9e18b9cf93d3bb0bbeda14af7fa9c71c5f3174732058a7943816cbfb9a112c97ecef853165097d89a33ef8279649c6cf0d8dc3e591aab0c8e4e66d284b67b9f6e086497735fbaf49d64026ef2899ee208b8c94813ff6242c8d99b0b5c3353b84c7ebc9ed625b8f4bdccde6f3b9338179579dd67da7bbd7d53874b7a9debdeeb91a185571cf3c7b620da5ac5b356c91dcd8df3469ab850cf910bbb3923a4210381f66763012112b6e7697e8ea1811251e411bfa3ef02901c68a26522a10a84008ae248e2644464bed3ca82180883e1b41cf0fa70c0c908094b9e70063c0f8267e180fb25006b32d0091aa02a081a701702040611e2a09a00890a4e8c78882bb01a340a3e1deef041b8c327ef029e898241cd44fece5b65780320b7ed2bb409e4cb06be06f1ac34444bc758d5878449e5753e7528b90c8534cf14c2c586b0f04c2f87225e7b3348014e692ad404e6d2e94524b335f262da15c62d044abd3dae20039551eb91f32e9cc6c21724e9f1b2bdad39157b970d210ea81987433791d6baaeb7145d02072b4812568b3fab5d3232a60986c8769a640dcb88064727626fe6c4c1fcc089e0cbb4a22fe0f6aac6f33778f1c0298be68969eed79399905e2a78aaf5e7a6c23eff91eab75505ebd2978fbd98a78277198a9746f7937aae7f35b7999a636c4e507839d7a45e63e66c9cc76b685eb26e1b2b2e6d9a7b00f71251cc3750f6a95d7bba934daecae613c86e20dfac74bd665ffdb3f6483efba919e7c4d93cfb5e6fda4ee22321c3f574c1377d55b97097993f9fd3bf4f6139369d188eabbc740f6b586462ffcb6c8f5ed6784837594ff781a2051953869840509e3ca47043e9d6f194bc9e7f0f2230a92963d917018cc96dabde4f824235620d07bc12453cdc6161824776b84bd42a102682280a84886738a4dac480bba0304bf7af3b153c3b042c2258a3e1a357af1101bc17162c1a408b50121f20828cf2e1317ef65615de00c86dfbca4190d72a78658267e298d4246026980eb6892d07fdd155073bfd46574c8f1c714a27c848e063afdb7445174a665da334f551387aac3a91b90266ed97a9db2215ac956612b42f22c5d9a54a9b4b4354eb74046e4252c1870c1a63cf771a49f2a3405912c5c9d3a76af73fbf77a74fe42c8bc32a4eb25aa8e6ae58a4d3566ccf8da251119a9b343490531cb6b8b9cbcaa40b3e2ff56689e7e76ef99556503bd93adcdda56feebd8529c3253c2c99b4d70baea516aa2513a4d95df75a8f691e289b8627fd5237fb2b856e964f541944a84f92bfc0473c16979c8cc6d26b2764d18dad0a70a658fe8c13bfe3abcaf0818632b0f173af64f3ad6ecbee99b31ea68d80dd8e3fd9c1c7694ec445082d5777f079156c99bdf239f372794441fe1880724d98239fd2c2e4ea73fb4d3ecd75afbbf70dc9f40974ffb701e1f9e24f3a89dc28f313da3ce913ab3122eefeaf1d5c22123ba069da32f029b886820803a830c4cde450b203570807800b4c14470aa80a791600020faa883488191e4c71508530641a6a69020650136d4ba0b8538150708ac46a114710940030e2cba72328c0077777582072c20d80dc00c86dfbca9d340bbfb4aefc6140fefe79f137f656deb65fd4b5c1dd0dd82d5ad066015b164d672bd8852671efe677bed7365a14269a94245d071ae62934293369d39ffcbb1004d10889a9de9398f520f9896669410c68417325986d9b72edc6efd2c7f0751deadd4eb0d4ce7a2d23883e79d789e83776b764b5c6a559060899e72bbd3a62b063da76a0f327a9ce62851a64eeab21cfdfbac7f03ab9a27749eedc87e9340719253ab5f3533b419d4dbbcfe799199bfd2f98059dedbc4875c1ac24cf730fcfdf738544351da88339814aeb40b614f2027a4a3ec1634acea72dd62e8b84e78e57b3afbe0af5c9dcc3d7fe3506c445918b80914eb4c22cb821d94d59d21451b60069a76770fda924d36c087fcdfabef9255ad7657072d1d7ee519427393b85b9ec8b754eb6fe985c7a9e813ca3fdc223db59178e349fe495aebd9a3849599709c81c1b8174b690e256c3fa8a1c2065b2f243a7411c727d88e4a0d5de2a4d26558b98dd12b860b3064fe77ba64f5a6aa6510411020d82a3088e31ed90466209c4a202e501224983b21c12d8b1a03013100a63c4d1926ef344c34330ac667811577c71557cda223e5816d8b27cddad2a7cb32ddc0ec16d7becf6eac587afee9f7ffa1f04ed3bab0ec4695335a7a48a4a2b7abacefadb156729706876dfdd96d9c5d142068eb84c45b4a3c8d1fd4687db270d410587a05824156c2282a0ad0e8e6688943a95080a04d564fdc7c26f2d00a4ed67bf8ff91d0b00c9abba96e30b47c9422b3c4486ae1414507514b04cfbaa1a106b1428955ed882ec4aa2ba296c52c737838f82ff74f2e5701eccc50d1cdaaf657a92d556882a53c078fd394771fddc4e9599ddc7c489b2eb944a2e16362297d3c4cffede39b394d155395f8a01c2b94b47d0dcc944faca565c4e4bf924090c6b0744a5980b8c6fe6d398873044b93aade28a227316f32117560ab9d255c8ebb9ca35b197b0ea7666ff3be31c308b4c4a4c7692b6ae6497adcded79c82bdb4ef52e38c96b7216c8530258c5f09a81924cda47e335776e9f2e8be1e50228914ee07e155cc76304f8d7eb3ef65e6f268817f4661d8ff9035c12dcb7f7b806a2886b34f939e83961ffe523d4ad7d22f3ef70f3f33635a1f4a27ce9dce0a513c28fe3faa21849ba42b6c9b894894ad1011683094d861046ac486ce308c11a04ab0a6236858006a80618140f59c1fefcb040439ac294bbdac9528be2fdbb058b047cbce2db9ebdffe95ff5e9affbc6ffe667bff8d31fde2ac4db04e4b6bde34d047f85a2296e4fd044c6d55549eb32d9df87dfbcabd3080bc468e056535a3555922d100f9b2c325e0ac7d85470ec1bec6cb71af5627114a1695a1c6364a39dd10004ac318245902e9206d259c05ff21d55b78b774da835cb4262b4ae3639645c48e5a713ec0b4ce90bb814689744b83d21642003bb099475855ba26e217bbac3a5e5969b1491804dfa4e72414f5e30e675baa1fa586eb21de6dd3c6f1dc949781ca61d4d7face9a8621c4d326bb2f89b9ed36f383929542a2916cd3a1482e6fc327d212b5b4432ed38cb302529e7ed199fdb991df1a8dbe92a7ad97cc7b2f1619e4d2a66e17fba8b53e4cc4ff6cf80c9846f4456e4e631be0130da25733865b7017305849489a3b4e99270e8c45f8ef99bff985b50363b6535198afb496f2b025169a70538d1adc7bcc21e77f6d3b976813bd6c4b2d3b8f0e7c463a0c6f9fd7eb3ab54cec2ea37095cecaf98619d9fbee2be428a8f489bd967088cd6df5b5b08f10ed96e39f1c0a04cca418315a054a983529f9be85ce6ece3dbbadc3d3abb5835cb79cd43970868ce2061b2c28e90ca870c00b004a470c414c818ee00d802064dfa301104552c50a844dc896035c18ba321ae8245c2df13d7f547bfed9bbffd4f7cf270f7439f78fefc0b3ff1e50f7fe6877ffcfffc73b76af106406edb136edff02dbff0b3a7d3ab7f727d7805660a91b7d12bdc4a4ec2e0de66a3a31bf5958bb38dad63dea11b593ac8797cdba603ad8bb3af11d0ee660b24eb41a556fbd9249c43e5d5a7b94022c152510187312da4419b581d4e075eb510e8ed5047098d8ad79a6897c5d107a0495788fa09cbe4eed65903b3bbc9314f38d8159d92ad4d99f523b54b5e05ffdea54beb6bd8b49298df4cbb6fc46cf7f6d94956653b13b1b362eda4f068c52edd39b775bed1cefa8abb49c5d3b3b86a35a46f4a9f99ccb48478cd36cfd240651dcc348d4813f037ed8114ab64ec64af94d79446a7144d06f972e698179d109d9644068d50a343727b8c39949bdcd2eadaa96deebdad0502ce6aee6eb2b19d0af45a32e951012700c4af3964ef72d56114176929e74bd3fa5033372191ec4cd69f27f3c2fbdca9c6474c83467a616bea3483883e701470a273b7a65e50a75c35c5e0c5b27e74ecda4b27b90694c82e30b99442728d6a650b02b00b781efbbc6b623c1f0957cfbc8aec7f47c25de25cb9be493fe3488d2ff10d0cf1927773ed112946598e65dba628e5a4b5fcbd31afcfe2e1a50dcd174a353f89750d09e99ead02e83300c48308568940309c3293432d6201705220da8a55816086971f7da81f9fd6df747c768fb81ef1707af809009fbf558c370072db9e700b8745c845eca42063f5cd86799fd8341da02b6e66ce396d3d9049e131e97f654bbe16f4d7c79353fa60b23e47a35f385ba771b0c7ecc089b81b731649bb4002756d7161e9ea4aeae810301a1628ee96054104c7958e1606685e74abb57a46249a8f97e53f6ddc9d0b50f463f0226cb7d24535eb0a4b9544aba0b43e585f1c69611aa1a3342920e65ca6c8adc314b3bf52a1ba1520359972884a022b931bbc882fd27b0b670e965e65c22557e7515cd17b648f29d2e7d26d42fab577f02bdeffba904e37c52a6e56158048573415cd91d4fc1901b5056b159c671dbc9eef9f388a45d7d9f79eff3565bebcb647389cbb915d2885b6fa6f772ee46aa289f2afef205f2eaaf6be57d9ed338faf30efb3f4e0c6998ef613626ea795dc9bce3ca68b2d3bd5ae62ea17d29de792d7356147d3ab786ca3f19239f470c0513afb6a5ef309ba6b706e2b7029ca9253d0f09884f8d1d2609a1ff486f392ad7bd89bcc4bf64328cf019c3d1adcc5c70f0fa648a70199c556fad5aa820238a02dd6404bf991b6eb85906d63d18190322536d7d8d1fc704374d3917c3e976bd29ca17115732e5845b04a8006830158256786808845c32586d52256331cd7151fbd22d4042bedafdfaac51b00b96d4fbcdddd1f483b4155a1142c01306a728c487c9b7aa3e9b5c78ff4fa18b404320291025cc6267aa94bac2fd6eacd5c2e050ff04cf73ad15c54804505a1d8fbe66e659d7e58ccc001b85b020e2a80451c421a0517e179e90e8d769ab38c81526aab68d50094671909b3d403b2fa11246b37a471dbd1c9899ddf22bbce77d75d776c2c8e20ad8ed26dec8b4f0b11e17ebf2f3581b9395fc837ebf0fdadb8f5cdf40456452e972e225b9dcb08ac8bd35b11377b8ffe967781964eeceee370d49bdd7d37abe090e450846730a483d900f768733b9499bd34416e01c1b529ba6f44a5999c7b4f2b0d96a108f794470728a7ffdaf954b2b35aced249155303866e4d28ae75dd34d11934cb20343ec76f7593aaad30dea67d7599d8f0ee39a13dc6ea84534071cdea228f5c872e83ef73de54d77e269e054d7310760e34f9e32397decf654149678b3fdf9ddee4ba3da60d45b7d4312bf72671842b9f6d25dbbd2d13605181896b28163641eec250dcb4187dd693d0aa6ed2cac4253b3c9a284e593f2534c4a040386059d2be9e6888e40fdfaac51b00b96d4fbc89e849c1ef3b08bfe310ec7d1581a9a68b93dae80365512ae9a7b4be393a788b7715959c59f6279512eb2225ad63a768ba1457182317e556525a4bc1ccb1ff2fe84705a55c4802f2450342a11b39dd064bf605883b55dc1f04160dab11aa9ac4c3d2001a9983c8f231500704bc45214b40a1666081d6852e45a1e5a22f694942a57e6561495ecc0b38c97cf3ec274c6e8bff4e6058ac1769bd25ae005282a7c6e4b852acd6e953711a1ab9fddefaf75c37d99f034f9830ceaf849753cfe6f7e64a17dfbdb4f43876b05b81efa7789dc6a71ed736bd8059239ae4efae8412cae4da2af41a2b6e6735d958369399314179d72a9767661f1c28533e347153ac5f5356c9e69c92494b9cb39ef720aee70e66eac1b33f57f7354b636fbe99200cd5bdc850fa497fe5c84e613cbc771753221361b7cb176acd117f005c802aad6b82543a8de8905973417b77169ccc334fc6e327986790c8c53effb63ce62332dadff611d7ac144f78e7bef25a017005054dc663395b43878cae4aa1da585dcbd48dad34ac98537e85d9992f7fe122cc99246cdd47d776315af7ca64af0f6c6fa62933a4bbde0354ac4b905fb301c88a9029c721ddc70371a0e279382280b078c2f1147fe2562d9edf6e2e58b7edd1db177feac78f9ffcc427bf1c187fc3f3109f2f6ab9e895eca412f27d8cce39c7ddbcba1bd9e6eed7ad957be6b15bde435b165330a056fb52cdb4ad1a96581da05aeba5386a88f44e21552857f8eb167362aae0d912925f7829be542a9d6ab5b4f83d5b023eb85b7232bae064292f25b8c3e23335bcb3518c8668ec8a0215410821e58948a36d99cb16691ceee45c2519f4f8635ca748a56074557f01313258ffd662d498c4f48ca8e3a6fc1a1da58d7d2e4219797b16d7e8f8f558a910ab752a3b3a560359fe64926931ec81674ff9e25048be61049af420d84b091ef59a1ceb777f10275e45451cdd1b5aa1b8b8359a5ed6238dc76b0a440cb4d897cdaa493ba47df79cce416da7529e9741a32bd500aceaf5a982bd883bee362d64b3e4087cb3642697e8b5627b85dd5e88fae6bb9e38fb6c5f47867e0c378849269fa55f3c27ee514ee7337b77714e799d635a7136f4c7a85593dd7ae21b1c6ded9237bb7e44863f9a004ef983a2b9eb1da8c629c9e40e82cb2e54975db4b053a0cbd969cdbca07f1a58b1e7e4b8eff0f8b8e330bbe62ef9454b251cca8e7bb36c525eb93d97096cb45ad237066476ee6c2c7fb780bd5898736c4665dd9ce57bace473901240913c19d194ba1e162c770788281e8e0ff1184fffd9e9f8ea076e15e36d0272db9e78fb84a820009fb833a81a3e7c2d383e083a6231cb7d4baa88da9c934f6b42b0734512f40d4edf211669d187a5e0ac6b517ea222e4a24bea18b689ce99a70849b34215204a5fcc495f40410462041101c6c41755609144c162eecc5204914434c31a2384c021a4c9c2125257f0e1758421e2a021a190dce6296f555cb50a584a942fcd2ec6c5ef7c7f74ef3343e48a117ea339d115b26e5ced04e5e5b1968b5082c99f9d8059cc13127596c7dca4a437925abfe7751273a102ef38bccc857499ac2901592edca9a5b353e5a031789701df24277ae66bb429ee38e68e1e65b0bbac060ba8b6d83efb9c952e975384b396a882052334703e8d71001339701443f13e261cd2656af419e03b672ee7d0819382d4f503b68fdba9e83829c7c44d373b92983bdfc90deaeb0350dfa0cfcd4ae574d31d2fa62f97df588e710421c374e3dc0eb9ebd89f37293bc18680571dbae0b22d67ab301dadf03783e7f4a76b7e0067384fc57d7cf5adfb53833389f1fb018c72015ae0ec6c827b6bf2ceb31e7f24b60a9659fb614a757a6476cbf9bd90b319f6b3f7dbd008dd454b8e3671d2477ee19ccd402b00bc5644b2210cfceda240557f8d15f31a5aa64d9720634ba7b46a6ed6248d9dd46226bb5ee6ba4625402460c58a4844237efa5629de00c86d7b07dbb79f4e5825e2ee8e38bc071c82e0c5c960c753a549042dddb6943a1a735a76b513a580c9102f513fc89d8ea0b362e904e6a973d1096a55eb4422dd9faa3a169a5d820a785115d004b1d32f8c8b715a7852811d011a9444106d4ef9524d35108d58a3c1cce04d5249608de6684c32742aadfe55a51f5bf7059c5f8d9b95693703ea7223e6059aa737145a4d0186c5d6c724854225a32b6b456829fa5dcbd72c7db7896d173aebdc5934e5f6562d978b7f5adf9913711644d9867197eeb2cd2ef0bbb0adbbf96460648f6235a3eeec8244abe6c71dadd0903c9c5503c4acbfc5cbd02dcfd84ba1b00c5838b839c96c5fe98bc69286de7f172d2d1d5527553eb778de8fcc681a33d7a15c2c4e6cbbce42b633f509fdb196a11b5ea6739dd8e9ccf721d7a684efec77370519fae5e73e6b43493bd6ace37ba0e73f719211a2da7ad45dd60b6b82443f79199acad54ab8852c7a81fa26c5493c9df31d22fe4b89f19e123c8013d905279c4c11cef957c9cedf67c046706dcce65947aa61dd7d9b798a83973b46006ea82a97e08d64cd1b712e832bf94cd8e63c9dce47d8d6c3d29c62d57ab820e07c3616af3ef135885bbbcaba25d94c46900c5dac684a7230a1e40602254d0d192d6775e5a9bf2040700b28bc0190dbf64e00c8aba8514df8dc600b707c2ef89b1fc55430f0040d07e8923a020590688e8ba8b100520a024e6feaed462a437e452bb09963b38ace409034205e749daa1e8568b2ce2d3a8cba10652e6772086f372f95edad49f2cf8bfe43eafb02b12682b729c56a86100e38c588634c457e50eddd8f5c5642cd6c8c2ee1dab5cc651c2be7b189c47c4337aba171ea8e0167b7a63ef4a2ef6267ae94b9c28599536bb963aa12f2e21babe315d10349cb36bdbd63936d260eb39bd24807a213cb4bf174afdd7e9eaf1a653200415fc84ded51dfcd2c6498169caf7899c19d7f6e27f3cff4c7543c66a05d261f65ec58a79245725e5c6bc4150e3d756e7b00d3774e91541f0cd76cd15375944270b7f662efaf3b50c986fc9049277dbff893699937037f9094b45ca71e35d7669c7e0c060d7e5f77470ffba924ad187754cf4971373b177baa68fd492b8d377aff1e74d57646d57a343d8fc80c7fc97672e4f26850cd34cc81d1d219626f189003e1eafe6f2cd5f16e41c9647a72ad6bd799985acccd92af9d3e9c7fdc39f303b9406994ab80d26550c2b367f525cadb16ce4caf47f701bbcfcc41bbe49f27ecace5d9ade9796dad2f92ddaea4855b129c64ab36305d027ad3f3ca3a6580696e8c0242051061195ca509270381afbf558a370072dbdec1f6a913fe1ac09f952fc9a75fdf13f7216251c35d50bc8e11660232e43b8f54e2cd18e4e75a1853cbce4d781e92081b99ff5bc6a169d2c18d8edd73bf0314d4462f50490b988624c2ad5eb870cfcd374a232150a810070d381c92c03be91ef252cfb4e02787ac503bc1a775c5ebe30a9a202c4b9a2ab87a8b7ef2508a431584a008a65907924145d173b86a4c44a04181688952d6c1266d85c670e3eafa934e4ccc8e6bcb2e9196b9b3a439355644928fba6a4b3b879bb074b90d43ad79a97939e62894224db4727655f26dc28abb983caeb93774f1de1e58ecbf91d795c810cc77391c73ecc9369a40a245c5fa7d9702b585c9c47ef7c8a1a019ca14273a2fff4ddfb556328e6a805974577573462b7aaaf441f56c33778b4dfa5c80ce75c901a1f3076ca2861d4142b1958e022adb14d252b161dd786c620f2ed7391bed9edb21b42b51a5070476b9842bb6a7ad9ce399c273b263dae7a0c830319839f0750a33c92f521b30ecfe5d0692304e271fa85327b6fe52cd7ce157ff06f786d4ae118a6c8bf237f752e3746a726ecdd8a7333e26bfe46d5b2ce7672b98e49772f33a53cb6bdf9c942dd4afc6ba6c946f3f9df3a77a0338bdd143c917e9f36d8ac5b93a5bf0f4bb564208407ccdad52bc0190dbf60eb6676bfc3c880f16132c3f05dcdf1bde27c17b457c19f1f2f80a6611613940f590479911d16236b0288ab67552000020004944415449e93e90aca70748d7e5611696a7eeab28bb067e277acd0b938a22a876857ae383160f6fcda2f20081a5202236a7ac5a901589bd24607008a18e5b854df0bba8224840e40a91444d8bd1604684b064b7a8b58508d6e0c1948a5e42e64af2aa8a24dd4c7e5f4d0a7ba7c7735dd48cf7ccac1502c5552b4f7cccd84d5f4ad89c3811b78839aa15b2e395e47f97827449fbe2a7481950faefa34b5116ad568a403fb5f0c7a1b938b50e6bf3686fc58e08a1042c53fc468efac6e987d832d8cc4d98ceb0b5c54d70b8db6f77b4984d409ef5a607f9785c5b824c03f78aed7345b356f51f46422d1d2bcb1d7dc196265129822e65b8feaf50f372c750abb0380016d3b92cad63cc3201f455aea30cc1ddd43d48d89449ae9d497179195eff2197819b6c721bd06500a51455a9eb453bd7dd44b64ea70cbd893577de4df661295b71eb03c947538d52a8efcf76e40cb9c74f355c0366538f4aa3c2ba376e8517a760a1ebbc77099ae5fcd3b6b095204b77192a1a65b61a1fb0c7d79addfabe2238e34dfa0e5752bbb6d393b1f7bffd06f7951963ab402e0080f9d9239bf7e3e4fa1841edac7de512c865f814b9b346d9f604fc2463fe15cfaf59e93422e21a1cd3f645fb99a73373f28978be5345bfb392db76e5f395c97ea113baa64b3eefbfe55629de00c86d7b075ba0bd2fe42144e0f90be0f32f052f9e1b3ebc270e6af882adc0c9207105e4088324f091e93be99a36989b0014912e7db89fe7cc38fa91386795f25a64bf502f61c1b21c6ab230556a61483a6965e62d481060250c11b008834275491dddac01312ae49004bc34e2b8468802cf545be091451823de3f2c78be2c78b5ae08217456b7a5c043ce04094cea7332394c85b020941c0f218206042810736727bf99a188c25bc15f8a409543ce0b718d4f4df7c712bcd4dd2cabe83d0e337126ce2b008181928f517e5f8be978153a11619d6ea1dd8ab59baa942e7419fe547a5cf191cf0b3e86a4ec66a5684da88fe6dca5215481315d47b9149a85eb5ff25baa5a65cfa205bdb87edb1d965a686dbb76794620a115b596c5d98233056d5ff04c6cefbb72a483750ea00b0989e604c8039d420093355d17bde23917ffe8afc1520c88b4294ed17b70e81ea233aa1a2619dba3c53df53838c9b0f1c592f7efe7d9aeabd4e0442fca6797b05c4b648e1d6f5710c976b2b547419133ed6c4a9b66d5ab6d43811b78f01b4c3d2ac6b41da3022286225faa91c788496463aa56e9aed276a0a4a2d31b38c04f8e0150f33ac3a9705f800d5f8c687a40feed7a737ce4f444a0031898cd3cae9d51480711f6660abd9ea3819106f1395ca93280b616ceebf77d3793c4c786e08204de4de0abe9c82cebe3cc51a925c3a691308025710d18e708d85b574b0d46ac2fe7ae3ca1419dd39f533d7eebad52bc0190dbf60e3635c414b591b41d5f4f811af1a5d5f07551f0d20e081a7034c14b234e349c68388258615841441227a411a70188395dd4fc0d75b811995b5809419602a4d770d91414c1aa01f198684228e023175acd1143103400a23046585c11e35a8b4e2c7789d66296404920c834bd5961385a048844e3a2e2b8469cd615f707c5a79f1f100478b9228521e5ee6ab488139bed65d5934812bbaf91b883665cc4d4e9cf49f351920357289d64023146d81afbae7a2eaa8a26c68f961358f1a2f256ca45ae88d9d14aab4f702bf6adf43a639a66c1626fcb5a82f54a31caa1e7a439999b8e7e476b8bbab116213529b74c6f68eece917ba94e389c04d6b9e0d1907f96fce3cd0ce57cdde40b6430aa55803376e4f33e683e76b02e1b82922673a2da53481c9d4dbb36a0f62119e4ae051773b16caebad5ae706c1dfc748164c240d14c90d0fcd9c7dbbe65086b626e5a54a6824e149a43b92cb662d46aa7c09ac89e7db277b991abd74f60902478873bf4d4c2f1b12da0b318c2c9d63ccb77397d21311c5a158185d088155d65acc9f5aed0c03a872a4e61940722c0c614ac2f7b068618074baf328569ba33dd4c86a70613a501225ed29fae35d589c5f9cc661bbda38564b0a1e53a2c135395c6a025ebb5c69c71d442dfac9fb549af53514fcd751d743a7ddd5366f46cbe924107b3ed3d3ce13b7b538889195427bec618ca7821355e26731dcea634b23b23e1552e595b10bc773de0c204af9c04745393fe4be2d8069a585d6f4d01ba012b3178b8cd27499ded6ed742296636dae51b95e76aa51e33dfbf095b4f88eb0a92df78ab146f00e4b63df1f6ef1ebee99b49fe5ad25e09f819217067c0d71f033e73cabe5614281427018e4802ed1501c98456b08258f322183308592b0849fff5eb3f6bffbdfd7b15e235515fab8017401001bc88112f704a8556a63295c2cc0438d5e0b57c9365ee6664dee8a240c09a0bf3549407104a025c212082102733bc3a9ea012f06a3d024a7cea8303ee17c1e994f67c8d5615f8a7f554ed3c4505160c4bd0da9dce79e655446c245644847c3cd4b21e25dbae1ab2c3189ab35702759a742385e8963bd5310bc9992718de672b757af231629b30a1d22234839accf5b7ccb1ad16c7e9ef3a8859cbebc42ac06f3d240471fb167d655f3ba9a84d2ce78886b10d9dc01d25051c3187264666fbe44d57af3975050a94a116cb635166504465d6d54634ca5576529100a56edc9cd2648750d33c71e17063650dae9c773bd31522cea98db5a357e86ad970808d5ac4fed9b9889d88a449307a8d4380887516d7041123008d49e0aeda59bace9d82fc57c3a1bbd928979c6666cc6709dc6857e68602dbd7997548cf651788cbde90cbf5de0c348e7c8f73acfbe967e8693e8f35feddf47a5dcb579ce0dcdbf376d3af422fa9720fe9408bd6464e03cf3a16bb9d131a86f3fbccc4a873c71274a8f609c0c7fc2ced1fd42b8f9e20a943f662707a4052358ab2a5d9d16c7826a77fef010f36faae6b662afe3b98110b49f4ee761dd6ef8bfc7d5f2f6933d9b1f123e36bee284aa6dcdbd1ae5ae69f99fbdf476da669fb7b01caac861ce2329ed2fd315a6a405a6a4cfe17b76af106406edb136f14bc0fc8e740c4d2bc53010e06dc45e996786e567b9dbab197ffc6dd56550f44006215e024c8c0a314ee69415a497c4cc30b18627eaca1fd59413c00584bb32ea625fc04cd8028b95b08150649ef93bbaecb2a0892c0ce89011faf86132396906e12cbdd82cfdc1dc0354d33341ac21aa1a2b9239ddd3bd87ad1c96543b188e02e28964c0d09309c48c478ca014889ed14b020882240b01295b220a2600060b9f79879f4b696f4724b80aca6a76757ab522c231517ea6e0805d4a5fd17a869062e29749252167c43842528b873bf28f6adac7301b6429a8420c01bb477fc79b2d86a6d4bdf22789724c88e1ad2b4a53848912063a515f5cf234c14276876901a5be959adb44a7640316c6c532dc092ab81ebd64ba54199a1a68f8f9dbd1476a59562c8d1b3cc88e06c6f9b78387d0726314fd88a05ae75149ee4f0a6705e44dd67144a4f0361b39384e4a997003005c58058284a96d3828b156f7f3593b3c2e77c63f9926531f344b0f7959ebfce7e02791d15ecfe5ae689841b37bebd376fd43e5600dd78e4973144df85dd82eddd507147c16a078230e6c466ede5b43d1066d36015ad99b42684f8a9c9641a63251309eeb34ab34b6f525e9b71d8ea712f260a74d4b7a780013eeb843e6895dc3d957abf83f95e5427b0a1cbbf05d657cc064486dc0bf7db10ce00ead90495fd5d967d20eae5c325d7c15d993fcf7fa3ddb84f66a93cd820b46aa10f6ffd2ced65bc79414799529715a6fdf75874643281f31be02b43786db37d1796497efb72c9a4b74b746dbe06f0a76ed5e20d80dcb627de0487d7c4e91f13e06bc660d2715d92336bdd59270e5ed1dfabf350d97449289202d710328d05953e5458de0568a04acc53b11d4572199d50870910a15885e09a0a513e245acc4ac14b531c0dd02078c50085e2fd8f89e34a1c0d7871241e0c5872bdbd42414d4b6434c993a144155a44135dc288d34abc32c50b469ca24115401044020ac3a299669585f0945ca88a6015421921260960d80ac604efd4d16852fe472f1e364ac7e96d017489ce65257fa41ed196789e44fcf182ff4ae13d37ebce8c5f7a60516e56e5e661838dcf70e668113d33d337ac04636a065e0d6cc1dfb80a0080245bdf496085e4c9536181752d635768813ea3a6d16d22acbaa9cc5bb2dc3dd545bcd2c1dfac357f0b6cf4b40ea4e50280cd256efefa3af47cd9a874fe2b91ad9b8f143798b1ef3e70a39ed25ab5ebe29ee960ee811991610d3953b05ed89179513ad36ff0bac9c5b96ba6ad733c77ba0c939b3c611383226b32349d2f9a6caab6c7a9d0d0ea7ac01a23a7a53623376bb7aa666a5e31aa48ebaf2f6459f319640a3efc8b9642d257906f0a44547a445127bbb35c149c9bca49776e097ce827a65387cd4fce888564a40ab94a7946dbf2c53165fbf2adc795d7ea815e26e36c6136981b2674b26399ec2722ec8afcbde4f5f31720b1a51b967b7bd508c910b75b359e82b18720dd65249300d5fe0bec92a3a4579cb460dd9e0e5ba570c69f81f07fb8558b370072db9e788be1831fc7f10b7f5e81dfd0c568b948064fbd01b792b6330d9447dea0e7cc5861a2e1f40fdf93fbf6c2b6165cd4404bfd9d0058e984cb4064023988195c44229c4e254e00abb51b71cd631754fa59940686541280484525f100c16b2ad65c54980a4e204c0c38aea02a4e2b71b20494cae42392a026da51a4e16486d52256641b63680259f41324e06486a3ad8848f698a5935b0046969a3bda50a7d8a934b1f298ac1248058cb47b200710c1b19bc8993deb60472b6389a635488f6cee607036a3e2bac3144f7f0805366c5f9fb9d0ae6060209b14ed882cce4e5932bdaf7c5249c2f06c3b3a4a136466bdda794ab7cc8266dc90418911c150bbed32e9aa26affa2d05cbb2d89cce918ea328b8a28fec7224562dab09c9b870eecec3bd4c91eb1ad6952a448e49f28dee8747661d9017401faec932d8011fdd992c532cc3b7f43cbdc2a4370304df154f103c01fd4429f49945a201aadacc3188ec8ed7765aa43991916c6e6128d6d8fe9a914a316ddd63d669643d0e2e47c94f96249b59cc343d3e1769066e2bf8afa4cbe6f8c5ed58c3e552ed14d6ceb3b8fc58a55d27deea7d330d180ada0d761d979afec3ee14c9035e1a8ee1f42a0bba6f856db6731671f3d6b2d98f7e94e0cdaa44f6a217272e5323aae2760a9218c05229814274d3387fcd7536e7cef9b26a63b4fdae73969333c0509cc05fdbfb901eec5b0a2d16fc593bad5fba558b370072db9e7a02127ff61b487e7b5a89d322a585c669d20918bb0bf88a2ee8aca498df802f7a07ed940d72a6cbb87d5f1dd7c749bdb1b8bfaf0288657291e5e29b13f71e6f47586709ad23e5cd3fcd9b390ad2848648ba003ac548121ca4c9469dfa64e13b05269ae95769318df9b52312c0b14c5d7b60a3a1592e528b2e27123839bd4dd2f6304f89920f7acc00a8180b58edd2279d8f35728a7350ef79fd74ef5f7e633847e3914c00dbda4156a0ca996ea414f3364cd1e8befd21684b867fb064718cd3803699112e504a9db87148e138e7942442d7fb6e0507f3a44ac9dccdf637e0468134894d0c3cb2d6dc64861b2be2023c0ac02a5919acd922a4265bde648b30258b7324a7740f349c4b7bf69411cf4b7f92dc02ceaa9e7cdcae6ab59fb76dde324b1e4f25e26c4dbc983acdde154cc4cf4eb2ee67ad1a3055c1b264a12d005acc96d97905cc949994fdd3a3e74afdd176eea7896bef88d65940775d2b76c9eabe6e344e821b31b1d77680427cd14a74138afe1a96de204326dfdf6464d1993f782ba521cba47df7f3fb8dec50b64466a228d9958e97f77c549ec778126ae88775cdea6910c6fb77376721ed541f13cac32c6ba877f6f3ce5c1c40d9190853f417b29d86774868fcf83a522ce7c6007dcbcb4d4c442a35d1d7213112ebe9945d21f95f9e8e1fc75bb5780320b7ed09b73ffcc1cf551afed0d18eef09adeb7494754a5c01d8f20b268bccce8279197cecafa5e36fafbbd9cb231fb5eff7af95e3958199f50580ef28f6c5455ba6c30080cc1763744c24160727d49bbfc466c4394a08598a443fd1c1249583a19685049cf80e6e2ac41e3c6527b258a724cd5c203a97b3025e3cc0698f4dd32003b1b2b9a295d7aca0c791bf6229b2011cf3eb5bf7f3160e6599b2e48d30ebe7a26dce95da31769330020843a56dd53948b6185b73e64d06087dd68da3b94177cf43cd6e43e6449e74c9f3c9354887a149bb711b4f98518e3816073bd38a1a6629adcb87ead464e9a3959940ab0caa55724f57cb5a1429b932b67fbde9e22659653df1217c36a4c8f780e55246c8c63eaa9bb7d1857a5eb366b4d0cd948fc3060807732fb9e0eac45d5834a06f4eb20f24035e3725aba654ae884a8388a48b3213180342cef3392ccf92c1450e53ad932717865a721054a4663bb9989b44f10220217453c550c208d11ce264d3512062b49a4354a778e2ce530ff07341b8e9e48f7952e2422cab66ce8f2106a9bf7f3e1b1db54d56dbf4a7ab75f7384d9ba9ea0c43c9857b906ece0876219dd85a51679a123734bb6927a702d17a24c2248328dfa5ea31af9abd761d88cca7261e8c8b8a93e07897b8d6a2498d07541a540a226e81a02a6d7fd2808ff53932ac8585469c03b7daf5d9217af6cd093f61e9ac87db7a431231ae584f4798ad7f39dafa83b76af106406edb136fdff5f1ff657fe0fe9bfe0805df43fae035b7a888af772ce557941bdf5b50c11f4fb698960957038fdd9bffc4f7a7fb3bbb28366088281b5fb7820ca20b28db6d58b975729becd03a8972e663f2ecb119a741829927bd9fd6c886b6038cf42a0f5ec602b884df197b90608e1ee6c107bac73470f3800684da0406cee6b9ff99a1074ee6c84856272fc011866316f0fbdb65f93c9109e898f4a02db3597062aca0a8e5a5b052f16ccce718660405e470523f8c45eba61b6e17ae11d74594691f9d0ee8163be9e888de4e4d550a55e69c93f1cdbb05c33a47b10d4448a8b6266ad7294e173cca569849c817904ea639feca410ddaeccf78ed8f26b1bb025420355b59584c26a4b8409c6da23c7e21f4ba9ac98c40d18d5a4be64d99440b041ab2464e5ae8a045c3720808cb016109d556345a04634ca6180135f34611926b534c85a8e64e3a356bcbaa998577bdcaa61525034804214f748d31995b94c99c0b5354dd665b6c40a76c694abef016d982f33e9f44063ad8a0833238202ec0c0ff9f37dce702eb52e46eb353784577cd4d75dda25071ba9f0879daa94fdf93edd4759caa5166f7821187848d8c860c0ee8dae64e26832bdae64625edfa571f220c4d975d05d5bab1922e3a256be823e780b570454ab3dc6861beeedaacf761853744a9539b519342c0a2e1747c403c9d40b3ff7b7df8f2cfdeaac51b00f9aa6f2465527be67542bea2594b31c66f11916f02f0fdaafac6efbd8afc769a355ebfe6cebf024a81c4023dd247d731717757ffb995b8b683b62d66f701c2fee4e412807933b63a6b2aac0c48ab50cf6458601dfdb97fbfa9214b119b63d341ebb2143688a3a7ec60f0dcdff67d8b0e7c32a162df3df6c023a0c40c4af5ab978941eb168a6d60d3d89aab60e0d27761590e4df74c3f01b26192630e60f4939d5e5e8f0ee018a2ebf695e98a39a014d926331ed89c6038a1776c4b2192c9892dfdbe075b1c809307639bc955ee2cc7cdd447eaebcd004b3d26b4e90550f622d1fd1c48613e32534b64994e3beba511430af2840b919c9df5d120129d108bf0d575efba556874a1591673a6cfc81d644607407498f19da160d54e2c36c18ded2106313837b8bc0eaa3a8acedc6dadedb75f08b4ef789393d5aaa530373f3b369b5d160a5e808464dbac10800ba2ad2963289e72d8aa81b887e60988ad11663117834bbb5a8b431643a3a464dd8798548f07c61c5ada5a542973c90c4105a6213b08c59ccb242015820c6a8af56f8a41cd9df7162659ef11da77ead559a4b60a59f2b4de6a412bc59971a4b615c7a4d29b0f652dd6618e2c134a9cf495bcf40390866fe93aeba375796de9f7cd21f722e9b8990331d2e963d47ffed1da782a9c4fbf4baf39ecb40335adf5d5c0bad49060f73e614b496df72d1b7eead5968d8e260358d2a23782cfb27140d2ac9e0bd5361a5a754bed3348efacd5e07a06afbab934254fdbca243846e6e9c709f1f41a6627d0f8576f95ef0d80bcf36d5dd73b55fdac887c16c0a749fe3c00bf00c0b703f85611f97a005fbb533b1d49fe4d923f02e08700fc4f22f27f90fc69923f194278fd94fb6a66bf5e44fe14c9df0be0fbdff4757edf27bee51bd7e3fa515a1c52611ca419ef48ed0b6a16558bcb567055b3cd8b7cee74e7c5f530cdfd57ba2214b8a27d743518c15520c7f7f0916fea33bff3f36fa69d2660a24e197642ce4e3026015e6c376c3a7b646e261fec33f236af3f820fe6ef231507ae3c7c4b7381f9e7dcfbce82eb471be0804bda9b00a737914629e9d8419d1e65ebf2238ec22693645d7f0e7a7adb8cc6c63ac96919381ef8d83001f2d31bbae94d13a5274fec14ee997439a7fc9c238af606c33e243bea230d51fabc8e713ffcd4a7e97a420651522739ded5ac3a74f9e3985c1c32282456727214ddc48c717b2ecb4e41c508467596477ea653568b7c96543134cfac408a4e0546371951cbb74f6e1734e62bba143ce55cb36cd31c14d025ef8655fd511517399be614a28a46cccc939b9ad38121753b09cfb2875f9a40747b2749ada3da4c31244a8a55b58835c6146c1a0d4b5892f57716aaab2eb5235d0e4f050631359aca6449c4f273d7647f6d06b336ad8a59832261818464944112cbdd1d420850cba610aa8831d6421ff975c43191bc9b955faffb746a470f7400af3ca6e429f54312a9a75267273152aca4e84198bbf2e3b42335e6b63734365b62747292be3915b46f29798442c9c6f168e190797df3b435668b738a557ce2e947b50191dfa83a9ac1af8b4363aa8e49d84d12c866fa51e8c85b1e625eb547bda81b2b08d98c07f2d4ac7ea6ba9fd2dc0cd980683043ccc7c09f07e51af354d15db684a4794a310e51755a112617c9753d625d2398038c491e21f8df6ed5f10d80bcab29c2a744e41f11915f09e0efce00e3eb003c177954c97507e05b44e45b00fc0ad775f92911f91b24ffa299fdd110c20fbfed3e9f4ea76f16913f9481c8bfb72ccb9b4f3f0c5f4ff01f3dc07050e010529fc0357992552b5242b4fa11295d1122ac40c273a23994f5b3425b27c529a7c1565d8f665ae61097f9d8e7218d606636786e70bdd3efed2604be88af2510f7cc6d5b41364af5640031cef4b66fb27645e65ce83b4aa665e70f261dfabdcf3ed2b72e8146dbf1c62a7e37a958b75a3c7720dcd11eb87501ed266dcd9e799cf4383d8fcccf8399ce49399e19fdd9a21db0ab8a1e470ae256ab337453cd15fd3540102988d0d3c9464adc0aab931c0f6e8a55759436d5a921a2925e7b8562cd219f26d90ec192309e341c9102433b20932db14f205e0a7174a08aae0f7982215aa353986bf4574057be47cb3f11a6311492ae86d555cda772e7e3c4def0c1536092c77fc8e0a0ec93b58e35152ab1febc6825cad041110a37a389fc4b31c55474a7f5b8ccc85a5199e8645a4149c9ef281e9f8c2b60311757a172ef49c22465ce088945162c87671009c9825a5361a922a92056e9022795654f045c936d75d0ccb92f8089d9549a4408078450727b4e252d2fbdfee10ea2824062b9bf87665dc8ebf584d343224adedf1df0def3f7926db8254015960522c8a0239f8329551a923bf3e577528c116ac0a7ab874be34bdb24ae14af666dea474a2db6ab6b97cf08e92627add82e1913b551e1750faa1d3156a435a6b615fcb8f20035f4954e67206dea477394b25c809b38fde17887f2cbbd490ead2de056b3eb99b8f32fa7c9b05fab8adeaa4d3a12b690c1feaa1d36715325474b569d78f0cb3c30b10288764f5295d64010a74f2bda11cbd3b09cad5541a1d74c154ad740c1ca35529d96b481527354845b73628c588faf106d05e30a113981f2576e95f20d803cc9763a9d966559be8de4df0be03789c83ffc0edec62f4d5f9bfffc4255fd97cdec2f8ac8bf6d667f2984f0d36f30a5f96408e1cf02f806927ff8c58b173ff9a63bf9ef7cdd777ee3e9f4f04f3d1c8fafbae9aaa414f1e2149f46f0998a330b25ca177d40e3490bbb94839d19440f4042d7a996da8fe4a438e750e28fa6a37cd4572557ce4938edddcbce54a14f3c96ab1cc1c6fd18a70f2328d233931eecf68266efb2ed315f9a3fb1eba3c9645f78f6277bda129711ee7ec68d98b7005de19eb74a2bd2cb2d2fb889c53a015a98bcf71e8cdad3c5940958edb98b20100892686d81fbdf1bfbd2a813d7cbc5f952b3431ea72a332052ff2b5e5f23956ac95cf2a7b81ad6ae32866950e9ac9e403c489ad64437f1a9d4331227e9a74065da53c2448beea6d2d6f2078c488e7456ddde127d8e52becbdecc000560e580d1956cc02143d1162e081c28385073416bd968207b8a650b59cbee68e22727522c974b811927bc4fad852541202a68daae6e6b6027cadaa545d7ffb150219b2145a2cf274d87a9010ca958d68c953220d170a8cf2f852533ac170b49a49c3bd4260a6a6a36098145034496f4f9d7232281c34111c201906c03713a011a7138dce1fed93d4ed180d331d30833f5c7d21117d52f8bca7331dc254d09b3e94113b3a70f605dc8a8683e86daacb945f2c4430b052beb612471882d55c7f084c51268a9beed454243cb734fddf9e416e633758c4367dfd7e922c3f4bb3490a44e6498d78266879c5046cacf6cad2a86146e5bdca8e60dbbec56a55addcb0a952c01b034b14b804d20233d4a1a2189ee4eadde396b6c7f1541a8cb98d2eaa6e76298861595d5f23c8143716d82923e0e09750a1896647450ae091342e29af62d0390c6bc68ee5da2bd8d7269f2a926902ad01aee2a4c754dd9f74826d001c2ec84783ca5ef5ff57bf4b0fc085ee3b6dd00c89b6f66f60cc0af13917f09c0cf1791cfbc83b7f902803f47f27b48fe35d5bc8c90df0ae09789c83f2122bf02c0af50d51f35b3bf40f2f78710fefa352ffef2e5cbfb0c3efe3e000f00fecca73ef5a9379e7ee8ddf23501f6cf40715094ae245b7646693f154a4637536e5d9fed0443e1aa15cccd06391571cb90c9c03385abb98295f0c51137c53e1f054266408357009749daed4ea9285780836b1e73f9b7d7c09ceb60d108cbf600d56c7ac569e12ee09914977e12231b9bcb808907fde45f9e2605f454a8da2d1ec6273cb3ffdbd7f585363315aad12204c02289f015402c22c9096be77de40c081cff6b93299539417d732edb0202cb024edfb3a72b7295c002c10182253b1e3f3d9ee700002000494441542d0494bafffd729c9671f36f74d72edd3e65bb686ea96e458fb3569735af9f4960f228a31181e148e2214f5f1e32c059f3734f795a4400f75870c7254f158b1628f3c18538497a3d1356f724abe2dfecc483de99ad94b4064961f32e6cb2e632a880bae4efc0b06611bf42b184054116886ae2f0abd4822d20d3802cd19d4a01d6740349e3a05004cd5d706ba43f96823d68a2789160242c18946912a3a5e0b7083b11eb9ae8580fa238da3115b79244ee3062b58887d309af1f1ef0ead52b4080fbbb7bdcdfdda5294750b93b1c44554fc7d7c73b0170381c7080605dd73609514d9f194e0fa10a0da14f6caf93910438082084054b08cddc422401b33235cb9f5b43062a79da12f27b16a1b464c09d6867edda29b7b5c85845f7ddec577a27a582a1129e1184a02e7322c3959adb833a2543a15df97044ef5ea67ed62cb018f33aa66d5a44b71a8b749924d2cde7db47d06114db677036d1365ddabcd7d06c44e4e55457674020da35e55435bbb7b14d09d53bce11c60594984d19b42e9e120ac571c870a9e18652c7a19201a9927512a5aa586384d90a5b4f588fafd3840e1130fc6e007fe0f5977f7abd55d03700f2e8ed783ccae170f83924ff7100ffa6887cf21dbccd0ae00749fe7155fd8f761ef30300fe1480df1e63fc9daafabb903425bf59447e33c9ef06f0c7638c3fb02ccb177600d47788c87f0ae0efca3ffaab66f6bfbccd8eebfdfd17e2c38b1fd320bf241050cd138c7c176f457d5b2c76e50f4e9c276511cd6e377e24dda591564a52ef59a303d5c82605dfd8d135b73796293076c5244480b9b8f62dcafa730424193addef0254c8c539c4a5a1dd7520647c3762eee674e9efb2b3dfe2ce87f9e3e5e2671d2709d71e613b7366f839512b929b38bc64a394b0b7c2ec0fee5c37ccf524e7ce88e0a65eb69922f9625d5ace4b9e167821bc8f4ff1592a5e12aef9fdee001c90804760d61b3c6a0c3c58a10eae6770da1976ab0006ed125d57d9014a3ac0257e9d915a8416fdcc292fd66bfed92aacff0e1004867a4ce821720ee92c1df942ef2a139ceadc51a73a6c7108109c68380a33bd65301d8882930a5eabe015228eb222023888e21e071ca088143c680a1dadf6c04c26dc8be52b819a0b4185290053c422ec5ed734cda1177c0ba882850aa1251043e24e044103404334e2618d38c5359f13e90c5be38a784a94b1bbbb05074994a7783a212e87e4b015f3de6a009704001655a8ca274baab545cba0295f73999ab7144a1099c013a56955d024f9a10a070030200208aa08cb82452431f7aae3115381abcc8567118a275022aa4d3f8216bc572e0fb24f110a554ba32e183115c005542780977466c9c4205941d7505769792aa3f5b2197b1a582efa45329d30d3add2744521d00c42328d8f8d2298f63ba9e62abda914f0f43956997e8dd67814611fe898352130735432d74a71d39daad3c95ccb8467436787acf9f5b9a6694679beb8f4432521622d3755da2a9d585b8e0b308ad869b0b8821661142ca2589643dad5900287a3255306e38a787c80c5f54300dfb51e3ffe93cbdd074f1251740320ff3fdbd675fd6c08e1f702f8b522f2b977f4363f6e66ff02c9ef5d96e5e19a278410fe608cf1bf53d53f07e0f3f9c7bf0ac0af0a21fc3f24ff6b33fbfd31c61f3b1c0e1a63fc8610c2bf01e0d700f864eb2cf04f0378f9363bfff1473ffb2c1e5fff1d0718ee342d060180a6fb15627561691dd59415a25de7bc4656495f8496345a634fa01aad5e7dd1e3ff3e19e4d6e2adf2d96bf796c3f46326b59b95aa3251213cd5264f9c16ff34af256ff1183eaa8c3f1b49771180cc41db79d074e93564ba0fdb99959e9961c90678890311d2031ecef5347100f71542484f6b6afb5309911bdb62bab2db5b1b8f96c77000467c57d0b909956b5099fe7b40011ede46d82e9edf9800244c742f146ff230b35068c0452f819b5c2dfaac9d62609082351d3893a297c9ef6df3e9650a864c37d6d091471afdabbec7f09d78b3a1a4a16337b92d7f3f99e0418807281e3475ef17151cb02098e0a4c42b284e4aac3117b7062c301c1092cb9408b8125157c4bc83919681564f6da5082c647082138cc48904ec847b010ee10033c38be3038e0f2f8118b1e88243e23c210278b0533a3ef10e0182359e1034e09910cfeeef71af01314688162aade01014b09880eda27828404515abad305b5351c89840929b64d3b482278009d894021c8228e9bc17180e8b2268004f996696270c2a68132bcd5aa23c41520a444bc73fd3990af8687eb8e99e48419005a1e815cad998a7602b57c448886a9a608942618885ba94b535d585ba031ba95d11a8750a57579ce45f5d6966e2fc0b4513ad28f925489fa72379d560a853b7d67c400d70946cb7dd92e9b78b26cbf443b5bb4aad98b23900529fa69a326672cb2884e6bea79204f32c391eeaac788bc6276b78925b56caad210046d6efaa668b642d4f056c59d3c20cf634285497bc862510abaab063c4e9f800e37a12f2579e4e2fbe0f00d6e3c75f5167d31b00f9db7c8b317e5a44fe6911f98300eedfd1db1880fffc743afd96bbbbbb2f3ef6c921841fcc9390ff24dfe3cbf64d007e8baafe1655fd1f017c3684f0f3a63776f24fbc8df8fcf7fe9cefbc3f7dfce2f7705dbff68ec47deeaac89a0c6152c7472a2561cd37f1506107272a09d71fdf0428350bc4c1a9bdf3a709be0872c520879c867578cf0a903afbdcc7c189cb3e5bef0a123cfdc677b467fb253bce14eb4f73b464671fde74a63373f6e25504baed4f860cde8b3a1a7536c37e8a4247331a019b3ab05e8a6bc150a438b349f5531a69443b653f8954f6d7a663a8bb86403f65f1476b6f22e50339b72b44e3e4f3ea232dbba0547cc6096a8e7bed5a7bfd4fb14b2e4d8c8deb750742fdba843e5e926e022b5b730c1927beec6f20823eb87385205aa29768d43c9501d608ac992a57dcd544046ab96994273f26a744b0aa190752410f5ce01a25eb6c343d2fd27004010b38704558803546bc381ef1f1d1b01238689a46408128825708c9f12c17aaaf63d266dc1f23a8c409821304714d227b098a3b111c2d51d22468a272714d990b56342906314b9a9d5cb0535a01993439a931b666517aa5ba91105900bd0754708aafb1aea75634977b8b2a0296dc09670ddbabea9a22062f74a6fc77232096b24d4414a2872ccc4eefdd0afa058ba420c845423d2b2bfd2a830e74803e4f1c5453b8a3a13a5c4104d4221c4b395c253c325a3947173024cd52e45a1d121b2d2fd4c046195b012e4f466ad48d3763c9d3229189198834176a62624f9faf435d2ae0502732970c2048852e0b82a6ff8a0b15541a4258404993aa104273f8cb931871c0b250c2c4b922863a20294e5ec53827d1d7d6e32bac0fafc018ff7d3985efc76dbb019047a302b35f2e227f1cc0cf7fa7c51df93b628c7feceeeeee8db98122f2dd00fe7700bf68e721bfe4ccd3ff6808e16fbcd589a278ef48fbc5164f583475a5624c0b9a642f50e68bb5709ee1c3d6e8fa8ff9e6186ae0d050cc9705c271626702ef9220bd0de913773367a558555eeed06116a718900b549afd02fbda44924b3382af1ef0e015d385370527e75ef75d1f813745ddf286afb54da0bff4fabcf053e98004bb6c935424c5010ac9003e002fa817671ebb93b5426c4260c43505b6931d1992307a30243bc06b167f39b621667a209e8589c09e55c0f6d86eb55a85121a1ce81cb545dcb18b56f466068013eab6e5ade6368f6e6675322c8d4fcf41485e3bb5421cd8ce8f2583c5668d9cce8b429da953e22c308e1510647e7bd61d15230471421d4ac9abc891a1d90249d70868ead6c708181708f373a354ea56842437b498cedb076ab2893e3e54a380c846830d4121c1708c86550521049cb265f44a22327fc61c027a32ab54c604f0920eb17c4613c38a64cd8a20b90bae382cc40791305b210faff0f2e1c16506b9cefa7280dcdd279385d32951a3d62553a272be8a08a0011a164053a11a4fa724780f77c01d1134c008c4986c8f21e9b3e91272032f51bc4c224c81e5ee2e4d6c62725a336be608aa49d3201292d65bbd952e61b4448c544d81819684d366065d0e796a935de3ccba698fa098c3e4b33df3018d70c57efa9eb502b6a2abd07ae2175d94b7fe4d01adb10b7faceb449988486ba0040d5926ca961fc2808386040e3574b92766693a2594045044f3f594698524440334689f13038212b2c1c082783a618d6bbaa6c39202658faff1eae597f1f0ea63583cfd2070fc574f58ed06256e00e431c0e373007e8f88fcce77fc561f02f8adaafa67def685d6757d7d381cfedb3300646f3b65fad55b6dcfa9dff840fb5c60668752aadd63b4d142af394a148ef968b1a779545aa61566ae6470423d8a0721bd9ea31948f64e57e26855b34c855e847ebeb8dc4fe7189f371232ae2f55bf929b9ce9b23fd66d6bef333cb6709733c7fe2b7994e4899e25574d44ae07a4d29dd3ed78a92bfdf5c231dcf369d3290868bb3266c2f829854ce69a2597a46c817d40e756f373493bb3bdf6cf9f23d759310ce90b1741b94fdcb09d7d1841a23a3023de8a94259c15d37c1f60ab5d839f7c392903a49d1b2578efc0819c26db7331e6fd2bdf6760320da8931ba602aeda3ee40557eb84244f0818014b9a0ecb4da70eb820b97e752e8424d63c7129d3a57a2e642d02d764cdb03213f834a66946093ff41331b2dac1926502d2e701ad2056a6a93c63767552453060b12356001f3d102f8f82981dd34c58033e4d1ec0d7274412478b0974a83aba5cfede55214161109c2ce2613d810096bb6758963be8121285cd92810045217707e8b264f09152e7a345c8a210799ecc148e2758b4aa3f20922661590e303da4e3582d9fa5da4c0329cfe54eefd2be9f1e708a11c1168470872082a54c350455bb53dd14051009a02495648d0b2999235973d36bcf353b72b1e583099dde2289dfaddcf4dd75c02cdc28f77551058226106fac8e6301843181b72e94106d6264458b14b4a3cf9623e4b3707c2024a0590392697e4b022bc7e311af5ebdc0eb571f23aec797047f979dd69be0fc06401e053efe0100ffd53bd4799422fb01c06fccda8db7deeeeeee8ce4fffa064ffd51927fe96ddefb8f7ceb2ffe9af5f8f06bc31a4f2177d9a201160512a50ad348d9709a8d70373ae78647d6112d32101197f7a58e103df6580dcded836ec1ec3314fa4ea90f72f3816e33c7a3d97ff7ca1d5e311b79db9297e0a6ec7fcac2fa92b45dce3ea7ef5b5feaf6cb95478b5f3588f694939799c9ef7c4ed26b5cb8810e768678a4571eafbd80c8cbe7870caf21ae1097cdf7c5a1c8d7cd7994ff1d1472583abdc97612d7170e7b9f730e637ac7bd39cc13d8c3c33413879d1576497896e9e7ecd61e6ed7a24a5311c1727f3fb52dd5e1f8f835690cb0a4a3ae0a8bc5aea3d589201e8f29853c83106f3b2e6c993a95c66a6511a65b5dc7306f71826bc9216dd683d9d649aa47519c239311582a90d204164af27679cd6c017c28202c5aedfc2f21243172c9caa0b71e6e7a254a7fced2dd632080ac8448048eaf41085602910bfc11289f2382a0958e7ee8688aa4250096ffce0c5c4e9672738c843c1c018980a61c9dc8440b8e0ac4f000534953248b69c203832d0be4e5038eabe1b49eb032e5e2ac098a811a80a0a02e49b3446b14bde2caa69280cadd3d02099e8e90d52041a1cb0177e180bbe5ae9e1f2206ad7a128384d04e6abab3d13298a05497dba2232936ba2649b0bd464ba0364f62aab3450193b42cee2fa121310181a0503954b74b51d640c264a33c361e9adb97d1b0aea75ce4de351a969bfaa53c12c94e6770d43260cd15c2e1fe80c3fd3d228987d72ff0f0f2cb88eb03c0f81fd87afc0b3708710320576d5ffce217f5539ffad46fcd817cf7eff8ed3e06f0cf3e15f870a0e68745e467007ccd239ef32745e4c55b758689d77c78888768efdf212df86b143026c1691ceeece6261d756c0b38f179a694e445bb581592db1bfa8ce0212ebd200eddc7915f3e7612bdcd68741dcd4b8184efa277be2d279f9e88246ffc3c39d3e1dfd2d546abe4cb9ff25292c65713383ceed85dd224cc4196ec16d3ec40c87574c0bd09c7a5232bbbe5f9769eb79d7b4937c7a88f188245e3a439a000bee997ff52fcb2dff7bb07479f5c10f862e1caefe84da0fefafa01dffdebfe45bcfec217b147856b6be904ecc8f64ad1c19fcb33d97ed16ffbe7f00bfef95f8f783c3eea5a7dec9511eeeef0bdbfe7f7e1c7fefcf73ad7a2065620db5c25c9855b946c2d0b4fb7cb4e50ddfa900ae94866cbdfd4a9d6ec8818699d5e465cb3892c227ca2b4c985ce1824bf51a8660ac5e424851b824ee3e4e8bd6daac40e5496c9ba33446af7284befb7b4ecbb6a69abe28e804a9f1a554f72cdf6b1c3cf21a035c389e2314be72e97ecea4be822b3a5b4247b6621f832193f474b3f4bf73069c61402445dab00bd64dd14c304138281c0ebd4f43b9ae5efc512654b23e4b0224acaf329f6f9914c804715544d14ba6c5250a72c22d0b04097256923cc70aaf93729e48f16214c6e552a0930951c92a0926c8b8b8d3593b6a63418a90a3d4450eec04c334306ab16d7f43e5c6a3e47d090e67a4cfb50a685aa802e01075568d01c3499723d9805feabc50c9242d5f13c7fef39ee9fbf0740f0c52f7e11af5f7c09ebf12510e3f7c568fffa0d3edc00c855dbf1f8ffb177dd615214e9fbfdaa7b7636b0ec92250741404031614211c5339fd9530ff5cc67f6f48ce79939c5848a399df94ca798138a28124451515110246758d838b3335df5fdfee8dcd3137717b9dfb3fd3cb8eeec7457577575d5f77ee17d13515dd79f20a293819c59219b02142e11424c6a81eb2e25a275f9001000cf08219a64d925ab3614b1618cd12577100094b2f22c955fb40d295e502fb7b84787804dcf50587a886d9a1107cd610e615372d308825e5611a2eb60fb4c24fc54a69c06807056732fcc779fab49543888206c89c800074085ed87e240d48302d084530403834f321df52e39750d9cc5a06e19c091e973caf9dcfcf5518211845c6007e5d12b2e90f78c02cc6f9cf50ec253b9bced7bd78bda15abb170d287204d402f2946b4a22d4abb7444db3e3dd1a6fb36282a6f83a236652dfaece3d535a088964226c0219187a0f3c3d679f0b3f0b16ffdf18e43c7a183b0cfcd57a0a47d3b6c89a3a8b2ad13e5f0ea303999f81c5c1f95c38816213673e76db13ee1d56bb0facd6415ef5b1e65cbb1043b3ae1441cd84af92278e4142dc794ab48ef450676cd8ab73e4990abfc640354e16395f2cc59953a53895211a5d3238f923859511857c6caa3371136e7191ee0cd29a0d3ff2671ea0bcf9e2a2b4f3d841b24b3bcfa61eb08032cc3f72e479a4bc22d4e87b0b467ec6192e0b8725227ed7a4d9f1e90554b64783eb3358118665443c214164d5a14cdcad21e31a33d764d8e06255c820486591f645814d52678b1224356f049d72310ba66169e93192d9330890a041842e84eca1d341dac09b032804412424ab3662961520a13c3ac59b2225bf6bba12483a5998617896880a64110501c2d469bb232c4e2312463b548c6eb21a5ac01700160d4b6c287560092f590527611423c02e0a82dd4e4b80cfa1e4d3a344ddbc8cc1bf3002c8fc662b1154d6ed8900348a9111a5b6a07b6f4700ae0c8cd480b4acaa5ea41a452ea02a965a5e4f1ae4a8f8f36dc77cfbeda0fefcf30433017439fb318eeb9998cf99bd7b978c39b0b7e049f0fa5199560928e5bececa7430da61b213017bc39f4b98290a6c68f3225cb35df534b3d2f5bcd462e6d71ce7332d373a68c5029f59e29105dc9cc0416e6386000550b1661d66d13d3de5ffb210331e4b4e3b1f34567402f2e6e296f91476432640e53c89b6c4b1838e4001428f84fed8f5e5a8243ff7def16011fcbbf988579afbc852553bef4f7cb43f6e1a8ba5b2f98ad342f6dd6237605146c9a67ef9b6d17cc472cc149c3b6fad9051f825dca5b3665bded218764573f05e4928730b347f82d35c6c6aedc83af2e27dd3b9b36dd900309920c1f60f2ce8fb0ddc0f79be71c87d92ad30ec2d9d7afb03742e4b9d67b8925d9028da1841fccfe6ea47ec15d87c9535f64cd214e1a81fd931cca691fa53449eb5d136e3d9330e78217e018e4b2cd095250022e5101996406497695eb253394c5b6a6002460d6d84802a019d062661d870420ad742b4904258445e9cc30a40404109111e8ba0606a18422288d4a54c71aa1c7e3d0a46409f93725e5dc56e8d00a4072051fefc05402df12c7bb4aa9712ddc46558edf6b04f07a595959c10ee4bb4bb7133a8cfe2493638939eae6687aea35423d9d1cbab8720e8613214cef9a7ca24e99ccb12000f10a93a58b78a82c9eef6cc5b15ed0947f2251fe6673b6a2ede68b0c70c654aca0e9ea33503c9ba6979189b26cb49c620e67e7176b2ec0d512dfcd043a0a6993b2807ecee37e732bf2a7d07b0ebe431c7297e1aaf741beacf4eff5fa9fe6e3b32bc7c14824b1d73f2e69b105d526a80885591c0e0ed913791581181387ac7f7bdff47774dd754724eaeaa197149b2add2d704cb9f636ccbc7da2fb5c6c439bddf751397545a913c02b5e09a59c027108f218e3a6575b87291668eb542898e9578e22b680e9b5b6f3fd85d7b3cfa6e7d9bab4702a48525d14de68043cc0c989c02a579f2223f759107404df2d6f7d0887ec6494e19de20c109c029f53f8bc6a926723c37beffc74c62f241a648f3a85bfb5141c23cf4887bada82d1209fa2a9e739281be453e87a637b19d9abebe5137cf41205b824188a854575ad002d0145022cccfa236551041bb64e0d038655782a0c032494c966d61803d7275115af871633782deb0fcd978d4fa1f5680520d91d5bdc9f995f03b0e3166a7299611817442291580bb7b32ec7ef2d81a9a8de84c961ec03f04d605909b6f4687d61e1e0869b1e22e4eaa50e33489cd4ad1c4008a76c2ceca3f24c57c85a084b53fad69b4f253d787e3a0f794bd1d872c09cccd456d82cf06ab68834a3cd699eadbfd2849b3d1d8b7398a38cdca211f9729e15aa49c2395d3b5f2dfb745af55efd09ef67361904393f3381620ac44dbc65e5f6fb2842e79d79d5f9933e6851008210104501338b03f3399de061d8f3e8bed76ed8f982d351bf763dde3ff70afce1817fa16d8f6ecd7eff8bdefb045fdd76bf298048e9d34bc9014ffe7a713b6a2900b3ce02aec16af2ad9363c8bb45c6661a94edea668fdb9da555b82f2cf352d985e196f68a056ac86609539c4600d41fad21e58dcaaa0c0020f5a1f8d99afc03930244b2818390499fd31a954304a40527b8f3087de39071a032bb7cb28be752fabf51a0c68c325d833dea3dfe0dc72630800764b1cd4220ad888c72b8809d77dda7ad2418a4ac680e09301268540a458946941958398c4bfe351ff5683d5a0148c6434ad905c02422da7e0b35d9c0cc67442291a55ba0ad9c000833bf20a56c529e22812e23995c0fe65150a9228161decc541584dc0d354ab328078dcf6c667eaa61c979b32be556f44b59483cb36d4ce9b61e2e70a16f4908c2beff4b4735ab027c62e995eafdb9f55e4d0b7b86d9c588b660647e65d9f90380b05422ca005438c7d912a6c2cd21809b9af89452677b58ca54ba271c9e5e125630cf1e20c219df29f619b9294c78083792fd9af184447d83bda661e38245e838b07fb3ce70e1011514f23c38049008a44ff5f1f6a5b44b271cf2e4dd889494e0fdd3ff86a2e2688b800f009879d3ddd686ce8eca36e7b896a5a42a5916aa624f5f2d52115fea91955e4516dba1df28b4208df2ff8d606a4009af23cb8ab6d8299b828286a6a7c03c0c20709a594eb903922619f4c8c0f417922de0c5724d752471131d67294e9614705298be55500929ac868c52fd99a91da0f087e91f4fcf8e445e021a7626875768d0a1f9b5f541acf31cc14236dd2a4a4a402651a2d413f7a36a155a8f560092057c741342bc0560c8166cf6f19a9a9a4fb74443cc5c4d4412ae9655d8a100bc1089440a16c8b9af7cbb1b4819e5041e0a871631e89fe42d5a289ccd139dcd41d57c14af9c61390c9332e40c2023b75eff9e5ae91c78dee180cff52605fc96018200efb6e48a434acf7544469591f4cf3d5df42c68b7a47edffbec1c09b20ce9779c92c21796fac7690cfae0799cc110ccf73971ceb008690d54caf0f7e0fd3338a391ab0246bb823f8a2033bc21f6ef957d7a0000e29babf1f2a16371c1a299cd0e40bca0227dea58f8330a9270084fbf46def477741834003f3efd1216bc3c09474d7aba45ded1456f7d88755f7debd386e100d80b031d4ef4c9b39073c040604fbfbcda300e42a14064c86b70b30d34e0b814ec3f5a8ca9a68a37d8ac19b16bda05fbea551c7a5d0a18c859f69fb0733299d4cd0900d21acbb97b00bd382fd4c3c64dbc2f078851eabae5ddcff2dde5c39c2e29c989e4d7ab71a9a43d3081d8bfa792bb6e30bb097b5e864defc4600f10b73f0bbe0b926c8162766aa1ccb58b906409c9fcab00dddb0a175a0148c6c3308ca810e26900bb6c31e38cf9db4422716d6565e596e210adb1f6132dc33dfdfbf3cf3f5f5c6803133a0edf15d2f81b251a7f15a43ab1b58379532538c418cd5631d0a445b2091b03376b7b4168e1cd3b269fe7d65bcdc248b38364f47dfdbee0c37fc7e1e4aee461be428aa143bef43915d8886c4134057b03705bf38b4572c6d423571f21b5989d7c80c0efc957217335a8da4d2163e0b206b9a256ca62f8c966e4abc00c90c83502920bbd6fba485ff6d4c8ec0034bcfe231d831c02c083919a1ee9150df58f35f932ccbbed361c00b074f2173e76bbe604203ac253c1c28c474ad34feff73500fdfef8070c39ed04c4365661c63fef409b2e9dd07defdd9aff3d550ab36eb82be5de29d0c7b0bf05538c2803104c3b06cca1757714864643f28fc8531cef443254bab6b2e912853f400a011ed4a41d203d48cd086c28cbfc2284bada98fcd7602ee03ed3f8c03211b1a45b3b7cfd24840a1113798bd53da2a3819c2fe9d0fa02ba20474fc40b7f98fc4e29bbb689bdce0d22573f8cc8ef94f1fc2ead7375e1594d984da62e98a045b242128c4656ac088f4cc4c6ea56b8d00a40d21e524a41444f0338700b365b0be0a2e2e2e2862dd8662c8bdd9000f0dffdf6dbafa09d7a62afbd2252c97bd1283f27c94385653d2a2290f27b57530db8fc83c8d9d28a9a272da5f98108a508cbe5d2ab96acd668a6c356abb5f9ef6d2d064e47b19ad9e3ee051f140a1c08d04cce7832c29f9082d773eeaf3df28bb3a52710082b9a0ea63f050d271162cc93077c28cf064721d4095e60ee0722eca840c34931cbc446a5b2ce5a1100825e60c610d0101e9561cf38521eef910bc228630a8896055efba30f41180f90a6619b5d760033b2fd3260000020004944415463d17b935154d2fc6c58c2e3cdc9c4484439bec104a04dafeed8ffc1dba01717e383b117a27ec52aec79f39528e9d8fcfab7aba6cdc2a65f16668cb18a165e890a8a84731e20a23997b814e0defcd7e55cbc3aa94b6fc6d1e4346de4521799ea6809f4dd934e977e3723ff3ec1e49686939772df755804a3838ef6460890226ff4c2db2687ada6f0ec51164073e8d1ace83bfb45346d9635d82c6b8ea3438134f33c33158b211590900a09255730ab575ba1422b00c96237d1d544f4a72dea21667e329148ccd8c25d4d64593357019856e8c593eddb5d2b620d2292a8129a405f5dc02ce28257148c1cefaff0305449f2e7e4b2e5cd7194d0d3e5dc52fa0d295ffad55c52b39ab6e1501a6f60ae2956b904fea9c537e5a2b6e588b6af40b4b202d1769568dbb717caba7541718776286a53061189980b722281444d1d1aab36a17ef53ad42d5e8ef8c62a246a6a11df5085445d7dc0b8464a5444fafae20fbb43d3b1efc45b50b36829e6defd684a0a097b92498285d60af045981cc5ea4c1e46f843fe5e433a13531b394a094120917a6fa96d730084902f8a12549e0e9f25d95469c2a3142a0330b47fca80b7311738ed072f14fa3e86fdf4d684a452d8a6b615ad688b5ea3f644a2a616aba77f033d1a69518394d2cc9974867c3a4b729ff1d7a1bc4737fcf8f8f358f4df77515c59897e7f3ca845dee51f1e7d1e321ecfd90dd252eb0ab7c073e1667cbed9fece055e2fdf71660e67a1725108a78438c2a218599d749ce59e883c028e1ea5ca0c9db0d72fdbce2708a7bec2fe02b1b9ea900552885c4a6ba78b3658602be596bdae3df8a2d9820041c2b76e694278008cad4323a069c25d731950ac2c520672ec117b973085072d6d222bc74f590eb824699052412a7aea6155b5bc152ab40290b48794721411ddb485ddcb0ba594b7161717ab2ddcdd6446070bf3b3cc5c1055c3cdfb8edd3da98c73dbaacd9fe8511a1b95cc9414c4ac20d81493228b27c5f0800f6fceb3b94e109425122548b8058c41312556ae02145380ea31905ac21e5a58f67bde298d67b7a537c85caed8142f5bb34d662244da94a1d3f021e8b6cfeee8b0c3f668dbb717daf6e989d2ce1d0bba647c6315aa7f5b8acdf31761edd773b1ecc329a8fe6d199447e1d9368045c078539ead66c8592761d879a761da45ff84b0200107e4bc6cd35ca41957379241be3cfee068b6e9da0554d106e51d3b60e08947412989b6bd7b6280c7309cf9ce07d0172e83884430ffa549a8dd5005555d8b86d56b3cb3d17da2d972d0333f499592a4170411b9cc2911180bf7ea2e880b46a082f5272a4d8b9403a8438801effddd1fe9208739cacb90962efda9fb88e18856b4c5baef7f42cd8245e8386c50b31bb9b9a41de5730c1a7b2c069e78146a962cc7cc9bee0100f4dc7f6f74dab1f9cb12ebd7acc36f6fbcf7bfed3c4c33af0aa399a0263fc7a6021fceb33142a0aa90428a71d2d47fd8a94e14e6c0a36cf7e9468e35ab49c97e5634e736c8ebd050201610c2d66b21a7c0dbaec32006c8020d4eb76052e5da6bba10664186b23f67f3da0a26bb9a640526822e042264030a53b55e386c566cf1e330846676c451b2b745487ce3e1d10b139efa126230b1a5aaae99295fbafeab4a1af7b4c284560092097c7416427cb485fbd2c8cc574422918dbf4397b3019ee7344dcb1b1431338d3bf8acbb4422f175a428b947a4c84034a648b7560c61f165139be91c064cc11fb2221c128c066218424384080a02bad0a039fcee160d9ed768649171d5679b75852d4f31bb8ab4ec908186142c7bf243396dea50d38089f2b03ce5bfa9e5b72d169ab31c695386f6430662e09f8fc1d0734f8156545438eaadab47ddf29568dc540da33101a16b88b42943f7fd4762e0d8e3c0cc58f1e9347c37e131acffe607d4af591b6ab47ae3143dc7ec83fd1e190f231ec74f0f3c0daf0fcc2637f54644d21bc7ee358380a0b447570c38e538f4da7f6f74db7907a0b404c5c5c5886dda0c214c8d82455fcec2c619dfa0d3987d307cef3d40fbec05a51476fceba9905242d6d661ddbc055835753aa63ff60c68f96a78c512c39e4db006233ca2c105193cc174332fa5aa7f9cbdb355644ca50a1a2608dcbfb78f02de9c6e4acb08e5a55ff682c3e0cff4739bb1db55170000e63ef22c72e374fa7d8ff6430662df09378195c2a7e75d85fa95ab21340d038e3fa245da9b7eed6d3062f1ff39b0d154e6a670904169af9d8f8650ae157a2de2c6a20c7f0ba3ef0d72c364001ec16b39eb089986bd179438e10a7bed652fe9048148392b0133432973af1564d6560872eb3d1ccd0e2b7302b07c8d56718e625357c62620514ac16058b51a0cc1c2d4ef80094a0804dd2af690306b351403c510d0088e1e88540a069b32f09aa68100244dc603689a659708b39d8432451275a14311d0a88899e891478df535ad30a115806470eed21d008ab670b35301fc5e6e279101443cbd79f3e645855cf4e1336fb8a26d9b927ebc615537568dd0d88026258a2541834011845508c6206624c14840210905cd0ac326c1308811d50584d010113a344bda8aad5a02b61615c56974089cef004ab12926c4262d9e2232418c00147b4a96add305fbf3fa152cea3de68ccc44e9d22ed253b5920756a527074ccfca1560f6c8b231e6bbf995f7ea8ec1679c883e878d41975d873769b26dfef537fcf8f0335837e36b6cfae95718b5756e785c0894f7e9890ec38760c8d97f46ef83f747cf03f6c1e6858bb1facbaff0eb8b93b066fa6c24ebea7d7d1145110c3eed048c7a643c00e0eb9bee4dd1b117d656687be64508db92eb3d271f20d1cb4ad0759fddb1db5dd7a3cba001d0340db52b5661dec753b1fea3cfb16ac6d7d8f8f3afbe2b72c0cf4f00da0ee80b5912c561f78d43bb6d7ba3f73e9761b7ab2fc6fa5f7ec5b42b6ec2f22f6622595f1f6aa6b087d98b9c39139ea6e4cdf8ce964befad3ff14a7da59220f8e7ac4b668c14704119cad86daf2779c657f940a130531c026008f04738dc4848aa58683af051ba4d67f4dc6f6f241b1af0d3bf5fc6960c70a7cbbea7cc9b11f6beed5a9474688f6fef7d0c4b3f98020028e9d4013d46efddecf758b76a0d967d3435cdea5558c4e0f738c2e88f0b15e9e4263de75cbecb196ab5b2839bb08bda11065f1483c989fc8b50e75caa2321acb685d33c6d9ff8a6154661f8a96bedc8865b44ce9eba0b32f76778fe31a059429382ac3dd2522457cc16c86127fa61465a18acd849eb52ec4665c88a7ee89a0091d91eacefd9e345242095840140278206130c29326d914625410444c95cdf9396f86511bbec6d49000d52411110258104080d8a9725245a6b3f5a0148064fa052a389e8b42ddc6c23803b851089dfa9dbd1346b5b829927b56fdf3e6f17e183e7dfb227118e2959baf89dc686cde7a8da7a507d1291460324099a88a0d84aa782929000222068b09573191a3362603402886a02459a065de8d04877723d155bec15ac1c0f85993f2a6c00657953ccc5ca10caf48e280526618213415659ad3719d6650ab1092fd8e2af6766273c9cc2ed1f92ca952de2e0e52c27a68c3083b26c92cdedcb2debde1543cf3d05bb5d77a99b935be0d1b06e03bebdf3217c7bd7c3d0e0ea78f8faa0146a7e5b8aeadf9662d1ebef61e8396331f29e9b50d9bf2f2afbf7c5e0d3fe8486751bf0cd6d13b1f2936950c924cafbf6c4ce575f84eefbee614656ea1bf0f363cf3be62f798407f3f5801280c17f3d1523aeb910e5bd7a8099b1e0a5499871fd9da85fb30e89ba063080f2be3d30e2aa0b200d09a34f57ecb8efde6065ce936fbf9c81a285cba145a3f8e5a329a89ff3135e197d2cf4f2529476ed8c91375e81ed4f3a06c7bfff12aa972ec7f4dbefc7dc479ef1c100156076e20c8ac161228c990d2a776ea980694119e65d38c16690198c432320de14ba30b6aaa012b83f0a42d6f99c727e360d9dbe87ec0f0058fee934c8c696f7f2a71773cc66da9a3dd9e992b3d0ef883f60f3a225f8eab689ce5f079d7a3c4abb746af6fb5d35ed2bd4af5a83e64d18ca452a969a6d9c0b010284dc69d891c3bb943b6948ee62ac99fece011093cf889347053ccc891182897dfa2b0ea020572bc64903b36a39ec7a388dec126d65452dac742b2b1f4b5a9fb113c5705712c51eba750ba8c053286e3b19c1e6f534e1b208dad9d8020412802e34336a21dc62734db8110c8d35180414e91ac00c030ca1094434c06005418c88ae5945f356144608184466ca15081122b01080ae236628c4213f78b47e596bed472b00093fa494ed88e8a52deead617e4e0831f9f7ea371145d2ac356b007c91eff5c69f7e634436c4c7698d553355ddc663b0b90adaa6188a1a144423906065bdd480ae548a7ab1eef3649a7e150146c45a9c8466795120a0b11dcd301720cd2e441326b8b0818719f255d0943f7ae12ca8b617c42289b729fa8415eeb50be61518a40498148422286210fb1999c20041e6edc8bf21a5f38b661249748bec28c5e72d72f6afb94751455b0cffdb39d8fe8c1351deb37b93e7d8e2b73ec48cabc661f32f0b9d9cfd7078e5ff7cde632fa076f1721cf2c65388949502004a3b77c43e136e42b2be01462c96c202b4fa8b5968dc540d5844b65e539911ae61107674de75471cf4e243a81cd00f9be62fc4d7773c88e957dd0a0610eddd1d7d0edd1f038e3b02db7952619452508601954c3a9f1d30705b68d1288808fbde762d0060feab6f63c16b6f61fd8fbfe0bd93cfc37b279f873dc75f8781471e82431ebe13c3cf3f1d1f9f7929d6cefede535b41be9a97740610217f06217b7e68ce4ff218fae1f30d590ca23425af1ee06ea750b9dcfb61fa259c0240ece80fe765d29210e835665f733ebeff6946badfa61ac3ca49e8a414914def0cf7af15ee5f0480cebb0dc71e375d012316c3c767fe0db1751b000091d212f43ff6b016d90be6dcf9506e7cac594df95cf9bdf289ae342de2d09454ad5c045bc3681738cd6acfc83d0d36b711241f40f01598b38791ceabee4e9e3827850ba6da2c2f7e265f7f68c5a9fd0e7e4ee4a3baf5821727766b1583db63a291558c2ec88a5cb8f7aeac542717a89805e224e0d358b2a7afe6001ce16725b43566048195669d6ffe81840009421101ac99eb515c2661b04254d3511a2982ae134829689a80808688525020282120c9dcdd340025009410a8518c5aa3013589c44fadf0a015806432c4cf01d0790b37bb89886ef83dfbcdcc510a716f33f3b34aa9cdf95eaf78edca7349603b5af1c3d264434d4f54d5a2a44121d208184c480a73b3d5a02c03873c0272d6e262998f09cb576e30c1500c820431acfc4b72d24a1d63c243f5aa144359d1155b1f42323b14ac8ec724c4c5e3f5499167e5124c80b06a4dc88c9a98947cececb7cc9936a8d4bf29d8d195cc5b12a5f59f2110ea468a499feb164f42a0cb889d70c0bf27a0fda0014d9e5b4a4acc7de0297c79e90d012a5a0a50d5928fd1ca6bb62dfff8737c7fdfe3d8f5da4b7cd78e94953aa0c47bfcfcef97c02c2d835659db4126738352fe74c86b4f60dba30ec6f2152b30e5e093b1f6f39948c662d8f6b8c331fcaa0b50deaf17dab66f6ff6d130f0ddab6fe1b7e75e07740d1b7ffe15a40c0f230ca1c390812066ec74e119e8b5ff480c3cfe080c3cfe08c84402abbffd01dfdcf910665c752b66dd78177a8dda13bb3d321ea7ccfc00bf4e7a1f6f1e7786adcd96c2b645696210f99a8cf04420841385489fce944db1940370883c861205a219140a9039ab3116569c9e0e84b0355f7a1fb82f12b57558f6d9740784ca168a7c78633f8cec6b82afc28608fbde7d03a26dcbf1d5f807b07cea0ce79de9366a4f6c3362a766bfe7659f7c810ddffdd40c518ae6203c6f86fd3c67d0901ea45013db4b77bd74c9b6cd0ebc98bd658ea6c1efb900a79b851e062ae707a769993810af0c28cefb982ced5546b9bb007bdc70369dadb29d205e1065020925603a1ebdce35761d89caea1891899f441830b368c3487848ba8430e9db0539d11b05e500388d0474d2401a838532ed01a18194554f2204229a6e26902a735ce220342a03f58cba6a956c0520ad0024fc686c6c2c21a2eb7e87a65faea9a959fd3b773f2c052b49442fe6ab7c3e61c4317de5da35e76bb5553fca44dd5fb8b696230d9228012499204d866c2779c2cc825260651b2ee4049325804602140b2424434a09450c5d5388282ba81b5452b28bc599a1a432bd264280d90620ca898a000ca53c1e1f4b9697d8efc541205ae233fcd8bfa1644faa08cf9bb5a3177a0e5b8d4f90c9f3a1599ba29ccd40585fca758bd38a8bb1fbcd5760f8a567438b349d9a9499f1f945d7e1a7879ff6289753686a4d2a0399df1337eb1fe3b1c3c567a1a84d59c636e31babf0db2bef202c99202c118b02a66bc9369d71e01b8fa3d71ebb62f597b3f1d6c83f0220540eea8fd18fdee1a479d5af5987ef263e89e1179d89d8c64df8ece40b1d7333481f4c006a162d0300fcf6f6649cb7762e8c781c8bdfff14fd8f3c183d76df053d5e7b12cb3f9f818fcefd3b167f30058bfb8cc049d3dec676c71c86bfccfd0caf1df667d42c5be9a112ce4eca9c8b81926a3684830f4af96fbab63985a71fbe7a1a774c32178ce7ae04948b5e0103e83262279476ea880d3ffd82f5f316048042cb0090303ae14ca273f6b1d78d97a3c73e7b60cd37df63d6ed139dfa1c2281fec71dde229bc077f73e0e651819ccf4a6caedfdfee0a3109092cf33cfbd5226355ec2591c4db9f62745759c5ce577ff86e1860b82fa1f8e132fe8e5a210914cfb730aef8fbfa89d7d9ba67d5fca5625f66e6c021e6f9edd08839447534a99c49726b6f15c9bdd9a426665d91916da300b39a194c950a50203adb115999526e4296273a58a3281a4999ea5acbc696240b0e93a14cac6312655b001460c0a7550880b6a8893f6632b3c680520a1472412b91d409b2ddcec3a29e51d151515bf370d4b11528468f9e55f7ffdf5977c2e7263db7e7aed920587684af5824a0c2e9109e8098344821053662d872ec88a4698f47ce64261a63299ac18aeba68028c982230319461474b24a28a9194caa2eb4bdd0514cc2234a53cb26cc2f48c28c580629fe09c9737944026d59ebde173b094170ea53a07b6935c0cbf305a54bf11445936adb0dc7fd793e386d403d19b2c479b9edd70c8ab8f639bdd776e1e034c297c76ee95f8f989173de023bc77ae2f2ca83ce1f71f7e77d7c31871e3df33b63bfdaa7121a3e65511f14658fc664351bf9e3869d6bb286edf0e9f9e7305e63df12200e0f0779f438fd17b412f29c1c6790b30f3c6bbb0fc932f10afda8c36878c42fffefd51d2be12b1aacd2106813f37bb749b4e28eddc111f9f7715e63ef22ca65dfb2ff43a601fec75f395e8b9ef9e3875ce642c9ff225fe7bd89ff19f91476087b3c7e2a0c7eec65fbefd048f0fdf1f0dcb57e6e411e5144f7c76f0414eb17e785d466e0610f98b51036d79a32bdeb638438257bec660baf4b33daebb14003067e2533eaae0965b7cb3c57538057033801efbec813dfe79191a6b6a31f9826b10dfec0a26eb2551f43e70df66bfd34d0b1661f5cc6f326854ff6f1d2d590a9fb15e230d7dad338ee48f04a4941d7a3fce9302974200bf8f85d70b063cfb8347f6c2ef102082c6b661efe918853b2228c3a24429d00b7e0173f6de9f55dba182fba502b3b93f9bb51730bfe41dfce0a0d9a163656a8738fdb76b3f95c9702561316ab28250804e2ed9854d7b8324411aca022f661ab6f9d0cc8a3525c88c8c68e69e135712554602eb8d46d44b63f394f8ba75adf0a01580a41c52caae4474f6965e2399f9595dd7176f0543500c3f135602c0a4810307e6b537ebba7e968cd53f281b1ba1a0cca22f8360484292089a70d38d88d9c9fd669f41ef9a8a09100c6b61492886b028f98825a4e0f49b80056c947d610258918f4297bda165bb56824d90e2134f55caefd3b1dc496c475002d7c9257d3a2c1caf219c8acc5fbc1b52ac48fedc56bb66c5beaee2cca92900d063ff9118f3ef0928efd5a3d926d48cabc7e117cb8007c2221feca3d0e51c4a407f9bf441460012dfb4198b5f7fdff1c27b4bb883db7330fda1e3f021386ef67be0c6045edef9206cfc7e1e3aef361c277cf52e00a07edd067c72d6e598ffe21b3ed028bff909e8df1f43cf3a19b3ef783034e5c2dbef6e16c0ab5bba020010abda8cf9afbe8df9afbe8d81271d8dfdeeb909fd0e1d832b782d1ed9fd20cc7dfc792cfe6a0ece9cfe2eceff6d369e1df107acfdf6c78c40371dd57f98885f98d1420140926f424dbab4164a1b5df197cf160a08329d57b64d67f41cb51792b1187e78fae5bcbcca85de4d5050322842c93e886cfe37d2a60cfbdd753d8808b3ee78102b677de37b8786fce54f28efd1add9ef76c97b9f20bea12aef71690a5b54a674a774ac4b617331537a5b93343b28045e933770c0593b971259208f389f63d7133259f49cc2a7e707fcc1bdc2bbbe51f0e18880768f3745cbba3f91ae0d326b2dd3828ee0a2c7c1373aa417b6ac069b8e46e11a47697742b29c8a04f2dfbbdf8d2701184c9c641bac30fbfba24c164c693b448582b442391a090836b54c7432d5a4a492261d2f119825924a951acc8241d0340d9aae8134dd4cfc158c1803d54602b58d7134b25ad80a0d5a0148f85a417404cc9aa12d796c26a2fbb69221280efcbe9e883ec9e702e3db0feaada4310ec924846140b716565317d08ddf1a21bb06d9a15e9fafc35c2534eb23cd5e3514c320652d5059924198cdf02cd95e1cf8c0470a10b50091cae0adf786848360261743c8e79c09987e224d012367704852500ede4ac57252c5d815ee0b33127a1d3c1a87bdfe24f492e69bfe3f3ffd32bebff361c00256fe4d987db0cf0621228d21e335381a376e42a2b60e45e5e181cad5d3be4262538de351a634b02b98e2d075e46e387aeaeb2021f0fc90d1a85ef01b8ef9e20d741b39020030f7a1a7f1d5cdf720b6767d4a9bf6bd3428e98be1a4e3a3a9e8dfc79c6b8d8994beceffcf1b5832f9738cbcf1efd8e9fcd3f1d7591f62c91733f1eabe47e2e99d0ec0d9f367e0f4af27e3f9517fc48a69b34c7efb2cc65b26e04069fe8f0250201f3573fbd002a09242010eb2fadb0b65320a9ed7e7e0d10080659f4e836c6cf47dbfa552b0007fd432bcdcdc7fdf236fbd1a5d47ec8cd55fcdc19c894f78662e81223a069df0c726b3d1851ddf3ef87441b530d998f828cbc30a9e23028e184ee3b02164aaab40e87b9eee467c4ea894026b4fc49980708607f25d2508f65528282127b240d9e8afbc40221748c7fea080f0a52ac3270868ce2577f7153e3646cf770337e532fb5228dd0405da728483c9aafa605b7383d9258921665749ddf649c6003432d0c0401cc48d0a14035bbf33c7881027a001841a56540da086c1d5445403c666b879d5bee88b82053e6cb4a2800427c1c204200023c21a8a6cd0a914926412d4b05422a98cbe0956c30ca0b7505a371d919e1aa3a36280233a2588489259ab1a61cc6d8506ad0024dd71d6efd0e6db44b4622b0160be142c667e2e994ce62c96736b87ed4b914c3ea029a37d4449d300b65e70bb10cca6d953419f06a76e1c5e134e8479433c22439977477659313837a3c6de7bfc71879035be40d011ee230d6c74a12025c45c6336a3ce2a580fc2be4d8b38ac65c2f6679c88fd1ebc0d7a7171b3cda535b3e660ea5faf4e310c5408eb15c33f1fc2f873c8939227637118f50d6901c80ff73f9562f684a92d288fa950dea7278efce415d43734e09921fb8197adc298a7ef45b79123105bbf113f3ef22c665e7f67da7b5c3ee54bf43df4000c1c330af3ee7ecca1610e8d1a08429f83472359df80dae5ab9cf9ed3d12eb37e2d30bae417ce326ec70ee29e8b3cf1e38e2a547f1e13997e3f6dec3f1d7d91fe3e44f5ec76303f7c4e625cb7dc5e0857aa183308332809a5cafa942fc9d2200b8335d3717dae054c1d070c8c544e87de0281011167f3435d4a06a892313157118c8ea7fc41fb0d379a7a161c346bc7fe6dfd05853eb5b0bbbedb90bba8fdcbdd9ef73de8baf63fdc2df4c428d1c9c2541b0e1a555563ea702a54632c82526b06d5cc5cab9b659c2eb37a01d70c2f0a5efa50326eefee3469a5c96353f4d8737a2910aecdc5a035bafc20d00b895dd44e444c653d8db2c6a5ab73e82dd866d9f1a086cd1c70b12695e3a772524e77ccba5e34d5bb2c086ef36c9abe5e386cc5d013f91326fd9332e2eab9d351ee43e6b05968a6130739200298892024812c300b301b396344126906800a886801a106a19a802a30e408d64d412a106c4b5029420906470020a8d044e32a191c18d604a1ae0840695501089cb78b5cc29142cd1a2c7a5fa36ed4b84e82841ed0d413d88b58152d3ba697aa4a2588be8c478ad151ab4029054afb7947d8868b72ddc6c3d80c7b6a26188067e7f3e1a8de6547c7e5b9b7e6da8b1f145623ebcc84842e710cf518837cbd958293c6d29adf796dd853d17fb215f7d0ccef10b2d99bec12900254ccad67f23291e414ee7bd363feffbc78330fae1f14d52324f3152a4c4d4bf5e05d9d8e890df7a01406af1bdbff6853378f101401912b2315c2aa76ec52aac98fc454a4202053c9c1ef3071d771e86a33e7b1deb366ec4e4c34f8558b31ebb4f7a02838e3c14cc8c49a38fc5c69fe6c31bbb5170890318c0c69fcc32a9cafe7d108916c188c77d511fafe1a61715a1a26f2f134c491952aced1e33aebf03b31e7a0ae7fe361b83fe7414baedb92b1eefb71b9ede713f9cf8ed273863ee54bcb4df515833e7879027cc29467e538955f3f93c940237003e2807f0910a2cc2bfc919ee8061d2d66e7bf88148d4d763c987533ccf935bbcba215d8425b8be452bdb62d4f8eba0151561f69d0f61c38fbfa4f467e0b18743685af3de9f52f8e6a9ff20015b7f29dc09625b795e8148e54851c2012fb63c656ad4963ce361096a7a94b2c9bab68282b04088c942e4a62009b811550252a27fc2033e82b39f3da29d5e214c0480875df3c7205f5135915bb6c114f0f5db5a1664d6179adfb7189bc84a35b644f4142b5fc4c3d69050f08f8f725630618dbbd903cdbe2f22eb4c72fb40c1d7c2a467b4b3867dbb861b666093730a3110624c8831733d83e30c6a04105340039b194571226e10201340306a15738d64d429603381638255ad4e5aad2413545ca3561b79bd2cb2d08df9f73dee35d654c14055abf9df0a40f2f5feff1ecc579f13d1975bd13014b9ce737e5908f153ee0f9b6e849247683209a12484824f7bc117664f411541038243cd9c50f1bd3440401415412b8a8034cd512c67a5cc7f86849148e4cd73df9245aa94d690cac493929bd197ce4fd8f7c88370c8cb8f362bf800804f4ebb181bbefb29050c798bbd950336bc79c11ca8d2084bbb76800000200049444154ce0fb2d2f9cce718767c71e9f58eb895d71b1acc1df6eebf3b5d711e8acadb60de35b7a276ce0f1870ed45d8f9c84351bb7c259eeeb58b9f6480d831c41400c39ad8ebd6ae4532994471bb0ae82511c87883a757b63161096c964451dcae0289ea5a34fcb614e924271d4364cd063c52da17672efd1a6d7bf5c0f03bafc77797dd841f6f9980310f8ec70e97fd15ebc75e90023c5c8f2f878a16520eb329189d42d6373337c042195af7030f3f635936709a0996f41ab30fa26dcbb1fec79fb171feafbebf339a5275926dddc8dc47e759691ac64cfc173a0cde0e8b3f9a82afef7f220584e9a5c5e877c801cd7e8f1b172ec6e2afbe41120abafd9e794647d960c10219ca31e4d907403490bf36cafadd8099b242e4d569603fe111bb640dd2823612a62defe5afb30184ee4976746b2be018e31004bdb8189aa69b808d9553cfc78684914c828da4273860452e9c174438f7a6ac542965f7cf53c7a81ca644766bf85c312908e1ae42c2892a68d655c9193f058245b40449800182a1cc7a041ba4098035e2648444522324045152839660e624344e0a8804801813d793422d806a33d2409b016a00ab5a2bea5047a03a066a01b6ca2c29097012e0040109662414c360a8a42128a98cfac4d5a856683d32bfefcc4444dc3a12ad0024a723168b4588e8d82ddc6c8299efdaca86c2b64493ccfc46ae27dd53b6ed45a4f8cf90526a5269c2ae37b036144e497ba2140f3ea7e116e72c1636691ab468112a06f647fb21dba1bc6737b4eddb0b259d3b225ad9165a34eab25d48d3736e34c490a8ae41bc6a33967d34154bdf9d9cd6908994b7c1ce579c677adc6def9d54a90286e4a71921cfef4e68ded9d70484aef9ce6129a19249f3fe6271246beb10db5085ba956bb079f13218f5f5e044d20cef73f890700e46a01d0f68b7ddb638e0b1bba047a3cd3a8196beff2916befc7648040221e67ff81d06bdc61ce8292b0596a92eb286751bb07cca74131478aead0546c69b6830f8b27331e0c4a3f1fdc427f0cb834f63c7cbcec5c871ff804c26f1c28e0738d70a164d3bfa1b167b9bd6100719068adbb7435165251a3755fb126e6cd14501a04dd7ce286edf0ef5abd7a6f493e0a6b2b05307651a7bcfef3406e7ad9f87fd2f3917da8a35f8e69e47d07ed000ec7cd159a8fe662ee64c783484492ac4d0cd0010c2e690c802288290867c463d85808fccfc56e9286a390dc0e02c90db3ef6bec1242e9879c7836999c29afb5016d8e60c4e02fb390f39fe080c197b3c6a57adc1c717ff03c9782ca0ed036c77fc11a8ecd7bbd9eff3bb175e43acb6da32fe85e7fe9513a950600808e8700be6e1897498cf557a3cfae63986e5d096308943d88e4e7872620531242404c8f2f2bbf4c5363d6a1193ef3d72812c438f4651d2b13dba0c1b8476fdfba26def1e68d37d1b9476ea00bd380a1189987b8052e0a401231647a2b60e8d9bab51b76a2d66de78b7c7f94190d6bacdc26469ec3a6a0ff418b5270cc3309914d964575436dd393108c442b8f2aa44c420324573ed2428215803416882f56891d4342d094d4b92260cd2b4040309562aa10c23964c2462b19a9aeaea55eb36ad5fb068cdc6f98b5619b1d8e6447dc32610d531d16602d529a26a20597b79e3caeabce6a652db11d10981a547667a15aecac7abe696f23080b86118f747229164ba130cc328d734ed4a0071df2b949b5e6ce83d30f3a74288afb27d514a2988e868221a0a3825aa328765c1bb3548667e8e885632f37600c6c224f2e13cae974b5b9996ac42afaf33f36c21c447ad00640b1fd168743052d38f5afa58c8ccdf6f6543618b3e6c0630259713ee8ef4bc0c867107b1aa134a09e1a180652ba7d70617ce021f8c12732e1107f63092104813e8bad76e187ace5874d9631714b7af44b4b20224445e1d5ef5f9cc8c1e5b3b8d498be888b46983922e1dd171d86074dc7148e1c8b3b60edfddf738b448045a6909a215e5683f6420baecb2a37f416e6c84d11043b2b60e752b5663f15b1f62d9fb9f62e3dc7939799a013f9fbbbdc3443bb6c321af3d8ed2ce1d9bd7f3a314beb8e83a282389b088152185a12400a038501b140431e635959450210064f5b45988575585f8cf53eb1a184051ffde1875c7f55837672ea65e7c1dbaefb30746de7d1398190f761f0eb5a9dad552b10d712bbf5b404080a159d48b9b162e41bcb61e65c5c5a05d87422e5ee623651656ea0481d161d0b60080785d7da0c7a9108d3d5ede78d5263cdc6930cedf381ffbdd7d1396ce9c8dcf2ebe16ddf71e8191e3ff89f96fbc87d892e521b52e1c12114a35f819a9553384ec751f9ca607f92a37871be89cc21aa53c9689577493d394fc3380ca7ebdd16987edd1585b879f5e7e13460835816a8144ac240849085763c0f1f2fb47ada2670fecfbaf6b0100d36eb91bebe72f0cdc1b40ba8ec17f3aaaf9d3af98f1d553cf5b910a3bdee1c60d15d8c9fdd7ad48866499f23ebb73cda560968e0549504c56ca959761c98d3a2808ab56d01fb794566445831b61b08dfc8a3e3d31e0a88331e8842350d1b717a215e588e449a4b1e483299241f50c366012b51a203258088309520a965c561cd52bcb8b237a844b3ab41395bd7b44b61936a8bca8ac4ccfb014679c50f19adae98d9baa67eba525e55a51a4442f8e76d12245234850a5d7368659375107a09a996710d16b4aa9d99aa63547aa0f317311807222da06c04e000636f19a068005001631f34600d500d6708e1907cc1cb5eea73380be000601685750e7885e04f0e71c0008745db70df14a005d89a89f35166d339c3a0fc01200eb9879b5a78fe4e94b5b22ea06606700fd9a30ae4b00ccb56c55ddfa5962fd2cb6febf0d808a02af7f606b04e4773888683b6c79f6ab0f354ddbb8b50d0500c5ccff965266bdb7bb45f7cba0d4dd048650aa42b032370ff2148c7bc0073c5ee374090fd90ac3455114ddf7df1b43cf3d15ed070fc0e2b73ec48a4fa661e8b9a7e4ddd986b5ebb1e8bfef6636206aebf0d50da981aa3ffce7616c77e251050df2e2b73ec457ffbcc357430000bb5e7901f61a770d84b910428f46a147a3286e5789f25e3dd075afddb0d7edd761fef3afe1c7079fc2da59df3a200fc89ce36fef849aa6619f7b6e42c761839b7df27c76ce15a859b4d83114d9633486978123a0c1e1679049ed83656e2a191a01f9e65ff7858adaa52ba6def386bf43d3347c74ca8520100e7ffb5900c0177fbb1e585f95a25311349935ef6f860449937861df8bcec69bafbe1bc2be633eabde07994c4c4b3efcd4a9ef1121b68a48e10a031aab3661cac5d762f4fdffc209efbc8847da6f870fc75e8853e77d8e51ffba161f9c7c5e4add1565d1d3608f5bcd5f219383b190e573467a41b54c426b6135632af0533a06333cb9f2dea277b77a6ad8c1a321340d8b264f455da2d1d15df7b69768e6f78101c4891013e4444360518c6a9e01d022511c38711c2afbf6c6fc773ec2eca75e725297ec1a0745e06ebb0de77e078e12cdfdde4e79e0495eb5728d32a9bbc937ff9cb78e6ca0c050ac9cf9a239bad46e8d889d6e28a16080a1209c744533e149b0b0e0bc556fc26651b46002b12242924d4822c16cb0923a5142834868e046801215fd7aa911979c5d31f0a8832aeb56ae6d5830e9fd55bb5e7af6b6919292d2fc9c26ac6a97afba05e0a90caa076040200e417125386e101a15536cfedbd31b4f7efb7915305a4701f814e1cce9d98ed591b2d2134b2adaae0e5c737b024d0230c0b3ccb4b1fe6d43440301fc4508f18352ea71a5d4f3baae6f2ae4b90b211600b8250400cc0350e806b184992f1442bc9bb7c1a8ebb500fe19020eb61742fc07c00e05dccfa85cbe545454a400fcd7fae76d7ba810e2660047074ef901c03f89e8cd3436e57c00d7fb50996174d0346d2a8042bc9709a5d4599aa685b292ae5bb74eebd0a1432722ea624571c602f8431e73f307669edd0a407e9f63d72ddc5e9d52eaa9ad701c2e07703380d54545453e0befde92be7d88b818cce58269284b55a3588d05b32229053c85842ee5943f7dc06f74a4e7ab4947df58deb717f67b783ca2ed2a307bdc7d5835753a12d5b538f68b370beaec8c6bfe55f0402dff686a410044261258f09f49a11edfefee7f027d0e3d003d46ed95f11a03c71e87be471e8c798f3e8b1957dfea33c62964bcbdc599fd8f3b02fd0b044e998e75df7c8f5f5ef8afe33bf5d2d0866bfc86999c9c021282de6f02402a990240d67ff703d67df31d3289e579afd56ee8200c1b7b1c967df419aae62dc0c87b6f46b4a22dd6ad5889efef7b3cc4f31fc8e4f7d14afaafde6b971da105be2f3c106ad839a79abf19d26330a7afa30896edaf9bfd2d00a0a45d25464db8059fffed7a7cf5ef1731e2f493317bdcbda8fa697e5ae0c5a151865456a0a0f19f097030c2a96c3351a752daca26f6cc04bfdabbf2d4dd280f00916048f2eb0739e0c262ebd9f6f03f00007efc642a6a0459112de1e4e003400335bb6d8f9826d0a0691603a0c9a0a42948499c00234182e3bb5f707a64e01107b5af5db32ef9e6c5fff8256e187520d108460c400d136a15a166d455178dd0747d6473de9f348ce48a5f173d1e235aa4c32ddc161668f04e1eb36a4139710ecdfa263b8950ca8978d8910bfb1f93a9089d30df95a4068e0b500303710d2246409c403126c4196428eb714b401a8014cc8aa1a4842effb674f669e5ddba9c93a86f7863c5f4af1f7df9d0537e3b6beee401e55dbbccc9dbe32668e5f6679c78ff0ee78cdde4f313e490f44344df33f38f44548861fcb9a6696b831f6a9a364f29752d11bd004f4d66c8318c88eed734ed3429e5999aa6356736c55756d4216fed4f661e2d8458d29c7354d3b479cc3c1ec00b059cdedd308ced755d9f5760db3f4a29cf1642ec06c016c89aa394faa3a6692bf304581b99f9f30201c82a22fa2edd1f3b77ee2c01acb1fe7ddfd8d8f8df48247237119d9fe383fb201fc6d35600d29c9e2ae6dd5b82533dc33157d3b41fb7b67120a2f5001c91837b4bb78d40c98e0c5c08602014460198027057006d89b907583512738987332485669283119034064abadc6f001870d251d8ebf6ebf0cbf3ffc5ac7f8e87b48401cb7bf740a79d86e6ddd7f8a6cd98ffd21ba125deb91c1d7628cc41b471ee3c2cb36a4e5cffb4e915958d092cfcefbb59010860ea4e0cfffbf9d04b4b30ede27f80a47452dc82e36ab3c69475db067bdcf14f689148b3cf9d19d7dd8e443ce6eab4a478d8c3cc583fc408a36a0d9d232145e8d3afbed549c7714d50c04ffeeb9ac1639e9d88c6cdd578ff94f35131a83f76bad8d41fedd8ad2b4e98fd01164e7a0fdf8ebb0f48114864077d08625faaca92f73ec69033c7828a8a50d6bf0fea172e09c43380f23e3d9d4fbe9ff8a4d3ab30c6202f6d288131e094e3b0f30567a0ebeebb8099d1b0763d76bef45cfcf6f6479875c975d8e1e8c330e6b907f0cacee1917415184f6feebe0af9893480241300496525e21475750e05a508382c5c07850afc93564a93b4c08741a6ae90223bca404e3a950250daae02430e390089580c33df996c0202871cd6055fe5cd9cdaa4452289a2caca7fabb51bd733a14100b504d40be25a66aa63e2ba03afbfbcdd986b2f7d4a0881a23665975cb5f8eb87c306581ab2580831a7b9df5b4dd7e7fd79c2ad7f3f6de2edb1aca8bd499b6c8edfc9f03da5541f007712d160663ea6a4b2c2198f7f0c1b3ca1c03b7ba7d0080280765644a290e379225269ec91c944b41cc0b6395c671721c4874aa9314288e6b22986a230edc6fb9b1b7c788e82372d21c459002e6bc2f9b500165900a45e297551bee00300a4946d727ca66173e2312144ce1933d168340ee002661e0c60740ed77fbcb8b8f8ff55e1fcff520464a72dd89664e6c7b7e6c178b0683025447c04837b0ba283c1ea2f42e145807f05614f65c80789f95ab02a67468a7ab1cb5a8250e3d2e4040c7cce7e3e24dba2215dc381cf4e44a75d76c007c79f8db5b3bf75b40540c0c0b1c722525696771f974ffe1c32164f631467d9b48b8bd17997fc9d5e4a4acc7de0dffe941102345b74891875cbf393841972de5fb0f1db1f30ff89177c6934b669a55be0431061f89517a04d33aa9cdbc72fcfbf86a51f7c1aa8b7700d73bfb8a03fbb9f438ded00300e0090e033aa5bb506eb66cdf15ddddb8af299c240fbed07a0fdf6db61d11befa161dd06fce1998920224cbf6322224a61e839a7a2e2f8c3f197f34ec7eb879d84d892e54854d77a67a73d65e14d908a6faeb13d5dd02bda5805bcfe8cfff65d3ab920b821661acec8404f1f8da0ebb0c138fab527c115e528d174cc79f0297c7ce1351831fe3a8cbef222ec7cf97978e3b03f63c9079fa2dfd187a26ce840d4fd38df67c07388312f439529f257c0ce542722ac02faa0a27a7aea817019399b3dc9498b23f759381a11242c062113ee2a937614a3cf3f5302d096cdfd39b961f5c6b542e871063532a8d11434133180e391f6954500c634d77b515456da70dd0f536e24a235e90c1221c4fb003a32f34bc5e56d1ecee01c3a12c0762de07c7b9c99e35bfb06ad94da1fc0cb44f4b894f2145dd7139ebf6d0ba0106194783299bca609b7b5170aab1dfd4629f5450683b71a26457fae4717001392c9e41f239148ac29e39c48243aa3300fbd64e616cbea60e6bd89e827009d0174cad3b17a48530088b5dab4b1eee3114dd3a6170864ba02d8b780be6f04f06681f77e2580cf009465b8fe1b353535ffef14daff976a402ab66073f55b19f56eca918c344458d283c4f8b548359e9ea0a22530f309e743f2a760fe3b3397c363bc84a561784b80499087bdc94bd0ee52267a5e081080b2eedb60ff27ef41b4a22d5edbfb08c4375481c8344094452cb5dbb59714d4c79f9f79250775dcf0a3acfb36e832227fcc1a5bb7014b3e9ce230ca30d99cf59e9facf29dbb187ae11958f8cccbe0a49961ad599d129672bc06a0bc4737f41f7b5cb3cf95445d3d66df7aaff3a41904e9811ab6475ca492d3a7d0c2a6ab07f0015710486820e17aab577e3a0d8d9b6b4325f4fc73d18c340cfecb49d0a351cc1c771fcab7ed8bbe079bb4a69f5d75333410be1c3f1183cf1c8ba177dd8853bffb0cd54b9661ce8447f1ddc4277c0c64de342109e0ab079ec42e979b11ef6d468dc4ea6f7e708c7ec3ea5de7517b02006a376fc68635eb5c8a5ee2146d9c5e87ec8ffd6fbc02bd771c0abda8085f3cf414bebef3216c5eb21c0030f9aa5b30faca8bd0efd03128ddb637a68dbb17834e3c1a9d0eda0f551600810770b0053a64008064a254f153e6a63e270a545390253600b86967f0c41a448a6382aca44d5656f9b152a61e01c3fa2920148399408600ea1550a7803a09d48250af01f52051079356b44e801a14441d010d91b2e2d891d75cf22880f2d50b165d00c6672c518f22516f946875ffa95ae4603f9ebc7418b0e5948a89e85c0023611292a43590962c592288e84f00b466be853a667e2d12896cb59e4f292511d119443491992f24a23023f7609845b8f91a76ef1715155517785f4544744681c6f4ab9aa6656b97f39c4b63344d3b04c0eb4d32da74fd9242c612c02c21c4dc167c574e64e6b3009c484447e7797a27a5d44021c4fc02c16f9910a23380b54474671340d43e44142da0ef1f12514129648944e2fba2a2a2e9c85c607e4fbb76edfedfd106ff4f001029e5802ddce40f52ca155bf39824921cd574da85143f1a8b14f5d324efc7c08e60c418ea6d063a288f7ab9c352c496a22c098b85d04c7ab669d0dd7c79423041de4b90414428dda6338e9ef25fd42c5e8649638e8751dfe039df6c67fb334e46a4b434effed5af5e8ba5ef7de272d2733ef10f60db630e8556007dede20fa7a07acd3a9bb7d74c0cb2d24594d537ad6ddbbcaf5bdeaf0fbaed3d02ab3ffb123a79e962d9616fdaf19a8b51dca17db3cf9525ef4e46d5a2655042f379fa0904625705d92c3d4dd58406bc511b4a49fd09032742e880e6e6eb4fbbe10e24c99c485ed141f6a436d9e93a0ac0c0bf9e82dad56bb1eca7053879f22b00802937de897a4b34acbeba0e33ee7914739f7915473f731ffa8ed917a3ef1b8751136ec1e42b6ec6cfafbd83eae52b2d1d008b86948044bdeb48deebef1760ce4b9350bb7aad13e128edd80efd8f3e04006054d72246ee68d8fd8e5656a0ddb04138e1d1bbd16390e9f05e336f3edebdf226fc62a5ee7961d6cb175d8d3f4dbc1d639e9880e7471f83dad56bb1efe5e763eedd8fa628cddbba0caeee009c3a09f78a9662b33bec122613a901900460b029a890b47f37bf23a4b0be4304496053ca002489d960401284c1e02440924cad813a98694975006d36b509b089805a02d730a806e677ec409141d6bd102035505229524253868026ef3596a6049238cefb022805b062ef3f1ffbf4bea79e60d280c6ac7fbf9f477f7722bad1324caed3346d75baeff6eedd7b1880235ac0abfc40581dc256e3084b264908712b804b99f90021c48c3406dad9856cfd44f47c136eaf378061059cb74a4a99310362fdfaf5a253a74e798b3311d14952ca77354d6b2cd0582d21a2230a9c4b7f6dc17765048072001f13510fa41684673bda11d1f6000a022042889d007465e627851005bf2f44747c013ecf2433bf5a689bd16834c9cccf01d83f8d03e37b669e8bff87c7ff040021a25e5bb8c9d9baaec7b6e6311125d191acd4270992838554f703540c42128c9110a202020c0903acea98c55c807b02e80c410900d3013a148c18881711615b104ac9021e4c767e568067c7937951dab58b71e4c72f6bb5cb56f25b079f6410c363c65a31154d60fbd34f8c14f04263fad5e34c83c64aefb7c4a6e20014b39f8d090160a29514d3aeffb8b422df768d7823fffcc2eb7500190e1a6362052e4e2ae80a80244669bfde5abe9ecea2f236a81832002ba74e3385ac949f9cbc72f000f43ef6f016992b9f8f7f000d1a005db7b807acfa083048d9cabd96475c313496607601825dac6a464a2c5fba850ad92b84470c1bce44340158f9fa4b3f9b8e754b564291862479d38ac8936a04ab0096d17fdf3d505e5e8e874f3c17b1ceedd16dd71d210d031f3cf024ea2c60a85b150275553578ec88d3d1b6db36d863c23f30e6b8a3f087bb6fc43e375c8e453366f39d879cc8c54230b38561375471d58a5591f63dba51dbae5d70f1f753f8f56bc719afbcf8221f72dcb174caed37e86d3a7734e37e249482a823022b669604def1c2d34bfe78e52545a59d3b888855a7f3d81163d72ef8684abd4a1a714018044e588678028031ebb1e712878ebbf6a05e237652a5bdbabffbf135e3da1cf3f4fdfb0f3ae1a8377f7ee5cd150c241948c2ffd380f9ff09133b91fdbb0150c2d2414b0ac06050d20212064c9ad224200c103732901426084912445223248550e677493354249abca1fe37d93cd67286df336b2c1f6abd4fef33b3b135acaf52ca0e44f420ccb48e2785102f6739e5c816d84feb9879d2d6bc0f699a7609802b99f9a874e0434ab913801d0bb8fcea6432f94913ec8631c83315c83a26ebba9e31fad1a14387aec8903293e1d855085104a02000a2ebfa4e00fa1770ea4c002d59d37a0d802fa594b5baaecfb1def87cde07c1cc2301bc5160fb63acade4e92680a85d50589ae07a00d39a68e33ec7ccb703e816f2e70f344dfb7f557cfe3f05400074df826dc598f9cdad7930c6b71f488ab99848542b69f431a4f1ae20628d4c0d57622184a0d514d13fe0647292e9a1a4a820d185040d67a01d98e3cc4c0c529aa0f92033c1c2f494004cca4781e9bab859812976fcf477f68ab6af6cf7c19fcebdc9bc3e07ca96199d761ad6b6cb6e3bdd89cc4c21a9402016af5bf3f5775733513d31333392202498f03531195eb811a64e7dfcf4b70f8b56943f52c0d0ce5936f98ba3bc6886088a41fd18dc5f8251d4a17d64d00947fe15265f787ea0b15d25ea7401a9182cccf4ab88064440d8e6a0d128eedca9d9e7caec27ff83250b7f0347232e5da832236166fa1759510f05c56ceaa9280d6082410c831949b6a83ac98a0458b2c4b62e834bbd6a468b0404caa211288baaf89d9b2760b31601839180320c709c408d00c5999094cc86026412ca301872cff34eef6e2493ed7f5bb068ce0ec71e56565cde66d0afd3666dd8585bf7356b421253224942694c8600190424ebd6ae4bbe74f245c94dbf2e1e76e879670c2fabac281f7ad0fef48c5a470b677e33fbbd098f4c9937fbdbaa41fbed5949652557dbe3d3a663073af5b17b22a73e764fcad855f6ea2efef4ecc4d37ef872e6bafdfe72f2a0ce3b6eff6471b199f9c08a1b120db1e9effdf3f60be6bdfbf126e1a623c182976c115d739b7615aab4a4f4152da21f72c90f535fad59b5661a80f923c65f1399fbca9b97682851376109e765dce7b4a3a6b3aebd2ed5ad62493bc5dcffd5bbbaae6f156906447439805d00cc67e6cb335ac9ab570b0047b5c06d2cc4164c372bc0603b81882630f3f199285d8510130abcfeeb85a65f2593c9329834a7f9e368e697851032cbfcd80e85e95e94a069697ac723fff42b06f0a210a245de2d296505118d027077241231a4943f0821e21678cfe79d3b1826cb67beed7702702680a94288994d78e78f29f0993e2a84d8d00c43f9318053838e53a5d423f87f7ad0ffc24d2aa5ce23a287b65073cb88a8375a8f4ccfe34a22ba45293554d3b45f337cef6a22baad80265eababab3ba1bcbc3cef05534aa959deca63f33d95994f1242bc9a65736a677992bae57b6f5fdffbc84f1f5f79c32f86621866c9c52e1150697151047f9efc4645d73d776b56eaab64bc11f71e7402967cffa3bdc04201484a0530a92210474953bac9cbcc8aa5526025946010a9a4522a0ea91a15ab242b255929268e81b89e15c5185ccf408322d4301007a18e84d6a0b168e8d6bb871affcdc79713116eddf5d02baa172ddf24886349567183559c04c5f17fed5d799854c5b53f75bb67588619861d411191208b2842dc71c728fadc8d313109a8718dd1c4688c9aa7890f139f468c418d6be2730b1a575c71c70d5c50d611646764046698bda7a7efad3abff74757633b764fdf5bb79b19a47edf379fced05d75ea54d5a9734e9d3a47500b39e4ba8a2481a424e91d7bf905253ffef37fcf05f8aba94543f67b5056dee138cef94474a110e21e9f0a444fd7754f2c2e2efe479a9752353434d4959595950b2182385e54229168eed2a54bfa1bb48f88e81421445500a5e63a22fa1311dd4b44bfd46ba88c884609211a76605972b810e22d22da2284e8eb838ff97e0352afe760631a4d9384102f10519499cf8844224fe79039273b8ef30485c8029465ac531dc7f9bf4e3a6f3b09215613d1a342885fb4c39b5d1dc7f99c82d7f08a4b2907151515d51bd277b010c2c42bfdbeebba937486a2f6e6ea7c92340000200049444154e62a22bac9a0fd4d44b487c99eafadad15bd7af5da48c947de817c7accbc6b2412a92ad05a384408f18ee779838a8b8bbfd2fc5940c16fbd94526a40341add12b0ff1f0a219e00708c699570a5d44e8ee37c4844bb04951fcc7c682412599c7312a48c388e3390883666327099f97421c4cc3606eae3428833bfabf27f7bb901d99615d03f208bf636fbbe42889b88e8acf68c0fadf05e6fd8c7dd26c687465f4ac65206452580f77dd036ca719c7213c2f69cfae3e92fffee4f8f495224932ef21e4414997cebff0c1eb8df8497c92c5c202baad7aeaffde2f365b35c560941e40a211204c45dc50901b42a114d0847c449387101e1b2107102c5593831268a2bc76991e056254849122c9397274a243dfdcc44cc0eb14cd60260a622551775787ef33af0b2753db442b976dab239be33ca3d74d3754388a8bba048e5c3a8f21e729cd45cfa0e1fd087fbc344f4f0dab56b5fd875d75d8f23a248cf9e3d530a6e23113d4bc98c45076438e8e7f5eeddfb0b4a7ab5cb52c60733b73a8e738310e22f48af06e70fb3b501325e0821012ca764eac59e94ac42bc43420871b3e6edf4ce408f52aa9f10e27e7de6ccc8657cc462b188e3383fcab7f141441b88e8954e3c75b71151457bc6071191e338c718181f04e07953e34329151542fccaece8e199b98c0fd775bb92cfe27919f015e50a48cc82f2f2f25f19181f046066a18c0fbd878f21a24f52c687eef37e21c48c804d451cc73997886e0e30d7454288cb89e80b00f3438ce160328bb479cb8ff1a1f7c2d9447481ce16d7948186957a6d44d2f838832c3a5ce9bd04db069299a7588eb72bcce60278c2c79c4d319c837521d7cab986fddee773fcd30cdbdfa8941a93a5cd730178f95ecccc7cd676b8be2668f2a753d2030d001b42b6796b1bd65ca3ffde0b80dbe6dfdccacaca5efadfaff9c63fb8eed921e9d8c0cc2022dab469d32dbad9093baa2c514a0d079000109752f6f4c9c3b179de26750006a6c98fdbf5df17789e57e643deec09205680bdfbc74e7c1e9f0a004aa9dd7dccd76786e7f02921d6d560005526678f94b2978ff18f0310379cd7db94528143b05a5b5ba300e699f4a994daadc032bb5629f55f6de6a0af217fe6065c8ba3003402b825e4189e3459a74aa91ffa69df75dd7e7a4d5ed40e0d4300ac4b6b7f8152aaecbb7c0638db099db16dd48f12422c268b6c9bfd1c221aecba6ebbb1b59ee7458410530dfbb8c294bee6e6e688be9d09bcbe98f9ce5c1f92520e00607a1dfab9522a5b9abe0328ffb791d5005ed80e9759cac377dfe79f7f9ecadab222649b0f53da2b8af5ebd71f5c5353d3939205a7aaababab9f23a25b1389c4134454bdf3ce3bef1e8fc77b3637371f9c7638d4c7e3f15743d2b1420841f5f5f567ce9e3dfb2e22a2356bd6f4d951e589f68e1713d15b4288e6cea0580b212e252209e0eaa2a2223f0f3f4fa46406af7ca29e886675d233a04c087117802b2391c8aa1cf2726f221a6722bb5a5b5b679bd228843882887632f8ea0b42083f737e0699a5c125227a3a1289044efa505c5c3c96cc327abd02a0b280ebe120222a6d9b8040d7c558663077439452416e228e21228799ef0d318631447488c93a25a2777de80d454545457711513133bfd80e1df59456645acb8026ab7976bcd09bbc8d6e40d632f32e96e319e7603000d78f678a9907026836e0ff66006521683cda70de5ff36b1c993b3433f3cd75ddae00de2e8007f5caed719d0178400f615700530060d5aa559f8569f3d1471fddb9b5b5b52edd730560cd860d1bde00d0bbbababa1cc041f178bc2780de00de00b0467f2e854d0042190b1b366c58a0db9aa2c787fafafa7b77549902e043cd8ff3037ca72037204aa9a100d6ebbdf3673fb4b8ae5b0ce093029c43f394525d3ae99cfd11c03b3e3ffba6a1ecbad9943ecff38a01bc62d0ad072067e8ae94b29f960d26e37a3c9148440cf97e030036e8f3bc02af879701bc9d695c00fe6ec02697997d151a554a950258c6cccf851cc33586fb749a4fbde132fdf9994aa9ac8ec6a6a626277dcf28a5ec5be4ce0029e5c86d6480bce7795e17cbf18c9bf42100cffb140c571bf2ff4953fa366dda24003c6872f030f3641f63da0540b5e1c173776363a3934538ed0a60659ed77103807db6d375f600004829873637375f00002b57ae3c3c4c9bb158ec074aa9b63c6a7af2c927cb01dcdce6ef3733733980a66f31b5a161b241f711006500ba5755559d090055555597b9ae3b5437fbc00e2ad347a4148e4422d135c0fac8b701520ba08c991fd6bf7fc2ccbeb2f730f309050a9d3ca333ce99526a240005e07b3e78b3ab964341118fc7e3c6673033ef6dc8f6b77cb63fdd749d29a54685908b95269d7a9e575ea8f5c0ccfd00d433f36559683ecbc0686266beda67ff3fd08afac4106bba1f8055268e0b661eef83c64b523c60e6037dccf34bfab3f73536360ab2e878ac5ab5cad94606c81396db199585d100364b29fbfa14964631d14aa9c34208925e00be32e8760580fe3e04c9dd86cac44c2965493bed8ecfa4ec86c44752caaedbe35a03707f2c16031115bbae3b478f677e5555d57f5cd73d0dc069004e7de699670e0dd0e6ea0c3c3a7afefcf953f41b93b69802e05bb7691b376e8c8d1b372eab613773e6ccc99abe5356ac58711b8067bffcf2cb0ff5edc966cf4beaaa8d8d8def1351712c16db610d1000cfa50eda80dfcbb70152cfcc17ebff6ff12b839a9b9b23ccfc5801cea0954aa9be9d6dbe94521100f398d9d7a358663edb545e86a0d161e67b0d6f3fa6f818d351866f3f3629a5268518d73926b71ffa1d5d21f7f051da62ec96855fa3904cf71f740dbce7832751667e05c0729d99d2740c93dbdc74fb45bb2192f1783ccacc57e9376e60e6d7fc385a003ca33f3f71473807b68b2c58bbefbe3b03a825a2de05eeaac29a1bdf86e338cf10d16dd168b4c6c7063a87cc62a25747229139a6340a218e26a281065f9d2d84d89ccb8b2184b82060bbaef6a6df188d465bdba1bb0705cc97ee47b9731cc76d4f783b8e338a92997e3abaee429c88960991aca1d1d2d2d2bb7bf7ee7544e416a52afd113da3949a585454349d88ca01949d74d249c92a1bc9f1d2fbefbf4f13274efca75e7b3122ba9b92a992b35dcfaf1a3f7efcc559feed64ca908f7ec08001dd3efbecb34f89e869228acf9e3d7be2d1471fbdabe3385be948fd77f8f0e17544d404e06d229a3e6bd6acd74f3cf1c45144f46e6969a943446ef7eeddeb9b9a9a4a763479c2cc3b51320318747ae28e449910e2af7ade6ef42b834a4a4a4650b22643be95ba472391484d279cb6438868a8e33807f894c7bf31f17509219e0a41635f5d7c3028aa88e8a91c4eb8be3aab5350c7ce7c669e1a89448c8a00d6d7d73b8ee37cab3684cf7d764b211704809f09215eead6ad5b3c8bdef039009702663115428cafadad8df4eeddbbbdb732bb0921f60370afe338752186f1530a5e974511515643d975ddde45454577a7c90716423c912bbb5a8a6d4454c1cc0bace6d9b90eadd905befd7099f964cbe96ff1fd42005fb5e7c54fdb781100af1ade7e9c6a4ae3c68d1b1dc32bea26661e9663fcbf08e8f56a01309b990ff729c48fc9f742564a8dc8e13d2ad7593fe601f808c0421d0656a77f36eb70b37cff34e8f6576bcfd522003301744de3c7e300eaf4ff7fa08774a4febd18407fd775c72e5cb8f080bababaa756ad5ab521006b62001ed5ff3f2ce56dca806700eca6ffffd1f66ef4523728f5f5f590523e06e09c783cfefdfafafa81004adbccf524fdb50ff4efb59595959d2e5180e7795d95523b03d803c068007b30f3ce52ca6ef9681fc04f536f1d98b928e077c71648febf1b3014ec6a43af747b68d455c33b152a2b2b1d00557ecf47a5d404c3f17fd5d2d2621c7ea5943acdb0dfe9ccecb4d3ee1e69ef95fc6239802b9552bdc2f05e29350a40bd89871e40a490eb429f3507e5f8ccfd866f267f9ee35cbe0840b3526ae710bcdd1dc00603fa3602189cc148edcdcc53012c6bf3f96abf7402188e64ad238b4ea6085f536003a49999edc47f7b436c524af955a67b19865f6d64e6be21d6c611f90eb9534a8d09f8a6a406c0bf98f948a59408c0dfe3f21c3ffe2e3307ba81f23caf27338f06703a804219faadfa303a8d99c731f3b04c694ed31ea117af5fbf3ef5202fa757f3c30f3f1cebbaeee92b57ae7c10c00b00d62aa5daa6e2bc908868f9f2e54727128949a947ee6db16eddba298944e2a865cb964dd2345d986edfe9c7caefad59b3e67fd6ae5dfbc300733d49bf01798d888ae3f13800dcdf8964ec4800bf07f0bc36489b74784a4c1b8d2f01f80333ef19b29fd4bc5e6b208f0a61803431f3fe7e69d8b46953c44021f5153aa994ead609cf809b012c6f6d6d2df2f9f9370c1d273786309a8b99799641b7b16cb1f94aa91e3aadbb5fe79602f02e33ff5a4a599ea73df907dd6ed073e0a70596151700a8cb656029a5f6353cc7dacb16d583995702783ae4bafeb5216dd713113535351531f330669e04e0aa6c092998f95e66de5e6aee59645974934d36629058e04422d1d372fa1b3cbf15c0cb013e7fad21ef9f0a41a303e06ec37ee700b8432bbd3301bc886446aa54dcfe370c54fdf777f57fdfd1defaeb011ca3941a66280427e7d900f96d48ef7737008b0b702b73b24f7ea40c90a19b376f3e4fffff51067c2d6b6868e83367ce9cdbd3c8388e88a8b5b5f500000d9f7efa69795555d5cda95b0c66465555d5cd8d8d8de5ccdc50575777700623f142006552cac02111b5b5b587e8372067ebac4b9de20d887e107e3ffcd74ed808e0ff008c32585fa971434a6952542ddf0608677b44db8e527562016e3fc0cc3fee6c67807ea4dba094dacbe7e70721599721b003d075dd9210e7c05e866c8f01b807c0bd48265a7906c0eb5abe7f9ec1c058a5cf8db9fa8676b63e43ce61e67d945279d521b2bc5f2b282f7361e9d2a5429f113993d2e84c71264ec995d98c38663e5eef974342ac97f20cf3ebd7c85cace77fb19685b9de90ec67b5c9ccd89eacb2c544d44c44852acca2ba74e9d2d08904ffb142885d94528ffbcc479f6fe3632f21c46544f40700132977cd9818115d6d38d69b43f0a9241a8d9a846fad25a29788c8a3e43b84082563558711d1cfe9dbef3212009612d19bb158ecc9d2d2d2d63cb1dacde3b4b512d1fc300d141515c5012c21a23df34514801b2291c8b37e3edbd2d242ddbb77272242bf7efd12facf7f25a240a129a97cfe006e23a24b29f9d6e509663e4308f12411751b3a74e8ab2fbdf4d2b1679d75d68d443466cb962d153bedb493d3d2d2f2aa10a2acbcbcfc35663e9d889ed0df1794ac5961b41f3dcfbb8688a8b4b494757be4795e473b198e1242cc24a220379003f41e399d99cf761cc777f28e68349a7a18fb7c341adddc0944eddb416a08b8ae5bec38ce596410939f036bfc6662da961042dc0ce00bc771ba00c895f80144742811951ac888e78a8b8b8dea7d49291d2232a97c9e20a27f10d1462d3b953e03ca2859df65e4b7c9c406227a95995f8c46a30b0abc377f4144430d7839cd94977e306ad4a861443412c07ffbd8ef9288de20a2130276332812898c24a2796dcefba810e27744b4948896988e01c078218489d3f055005710513911458510a5443481882ed272b16d3fb31289c4a7d6d4f80e00c0a705bc01d9dc59c6e9ba6e2980f9dacaef906ad63ac34b23929539d767f95997f6b3d990ef4b43d2f973c37effd04e9b3fca91316515804799f9b03cf0f900e42f95e75aa5d4c03cecb3b7f2b8afea98d9374dd5d5d5930160dab469a3eaebeb2fd16dbc1d622c17b7475c3c1edfe4baee8b001eabadad7d39c3cd575b3c178296b799192b56ac98b268d1a2d100d0dcdc3cb9a3e48c8e996f09fb760ec0d53efb1b90caf8c6cc230d7998cf1b902d4aa931017936c6301352aedb8f9b3adb79ab949aa8c9ab6ce70c589f7646ac4e65fd09ea5566e65343d0d91f66b53916647b83a494eaadbddc59f5057d03f2abb0ef3c327a925a5b8b98f9758331b530f3a002eb06e7006809b0677f6f7833f98b0c7defa165c89f439e71f7196ed5e3b3ac97bd01ac6dab2b30f314b2f86e404af983021a201b3bcb38d352182e96526ef34ac97a3381994f66e6b1ccbc77969fbd00a47e9e350ccd39c194cebaba3ac787c29851f1686868e8da8e70ea039fb53998f90f4aa9a210733d1266e9833361be52aa38ccdc7b9e27f47b967c215078ddba75eb264829b171e3c6e944149552a6bc8e2687cc449f619bbf033070c58a15fff639a66b0ce9d9a09482563052f5042674908cf1cb1b3ff098f9681f7da60cfb85ccdcd5908763f348f3b906fd1b1584cbf50645297570273b6b8b00bc07601133efe5e30c18cbcc07993aff162c58e08458cba7e4db09a5e7fa3a9f733d574a3934cffb730cccd2b33f695aec30c01e58c9ccd70418cb2498a5ba7d26435bbf0510735db77f08de0e63e6f506f42c574af56fa7ddf3db38133703e86735f7efd62dc8ea0219209b3a89e02f45323b1003d8e6d5ac63b15814c9ac48af059893a8e1bc6c62e6de21048949e57366e6bb738ca76f90f850bf9593b3187b7df375b3c7cc7f6d2f9b8bcff5b7673e37959472f780fd0fd1376fcf1111353737af00807beeb967ff807262bff4c3c075dd8dd9de389c74d2497be8ef645b4fab333c44bd21203dfbebef7dac7f7f4e8f734807c9d14579969f750d0d0d4539fa7c4f7ff62f21e81e9ba7bdf24250c78194b20cc06705387b1629a53a553a66a5d461da41b45780b9b9c9702eae31a5d375dd28cc2aae6f514a8dcd319e6b02189b2b72651f0cb8ceff076695cfcf28f0ba48157adc2dc0bee96978cbbfa54ddf3d91acdbf3ef90c6dda586ebf4f73978d327dd21cacc7f0b620c7a9e1765e6fe26ef0b2db69de7ee570532406a3ac9f8ae4f5d7be7239cc6a0ffd3f5e63922c0778e37e479d82c160f18f49960e6fd728c67b481703a3fc4389ece9352756ad8f907707b1ec34a5e35e8bfa7be115a26a58cea07a240807a1148a6d0ad4b7997172f5e7c77dabf0d4632fdf0d687e7aeebde01601f6d14a4e363005b3d9b175e78e1316d0c911303d0741d00d4d4d4dca30df665da20dae6892f94525717428032f38ded282123b65e3d785eff10eb331f06c8a6a086b1960b3f2e10df2eea848ebe2a667e24006fcae03f89c1371e4cc762b14888b53cde90e74ff9e0c133019b7d33482ae71c7d9b78e8e3852e40ab79b2d0f3bca0e9b33f32bca53c562be78299a7e8b93bd0947e66ee85648ae4a0a8544a0dcf31c6ee0096a4393ac7fba56bc992250e80e78226c4b0d8f63704fd90cc48946fd4c5e3f10ead1ead941a9716233db5830e9ee5c851e533c37756187ac7c785bc2932c9b6b2309148746fc70b210c8ddc0d4aa9dd0d85e2f579526476cfc3fcafcda36275b8210df7ebb70583011ca9afef67f9496f0ca01fbece9bcf000ec962e4d4a51b211942045c00dff268ae59b3a65f22916848fbdc2f7dec6b81645e7e06f0233daed6152b56bcbaadf77722912801f065819c3815aeeb166599979735af1f0bb93ec31a2092997f64206f4a90cc7e9477c7573ef66d9ecf802bf45ced1d40861d69189af628330b43b92990cc5c155851574a1d9a63cff607506120f3a635363686f26033f32f0dc3997f53c875a13dfcf5cc7c85c198ce36dc1f0feafdd755bfb9592aa5ec19626d1f03b3774a8ffa18633724b36482999faaadadf5b50e62b1585724539c4b009d2a14d3228f1b34571c6e471e044aa9689a07f68500df8b482977d385796600f81780db75fef2be9ee74502f0f54abd794604e8ff48437e2fec8835c0ccd7e51050c548a6e23569fb3ec3b14c44b2485f2845a6bdf8549f74ec6d18779c095f9a3ece64e6c3741bc700e8af79e3016837b7fec71f7f5cd6dcdcbc4a7fb7f1bcf3ce3bb69d797e3757584c0e453e3de7fbfe39d65491a6bf411b48a9e293133b40b9fc019235590a81cdcc3c20c37ceea28d4225a5dc2d24fd610d9067827a6f75bffb217fc922d2717f9ee6b59b526a328069fa66f83e246bb61c1ca4d8a352aa0792c5d95e0eb8674d6a702800a78590578360f6f87c113397e6e0a7e9ad7e8299878770ac75353c7f9ada7b7c0e20aaeb65fd55dfb8bf04e03f006e504aedc3cc111ffc9e04007575751183b9ea67aa2724128922669ea09d077f09b94ffecf306cdbcf1bb76e3accd4534afd24004d4fa66edc3dcfeb5027b885ff49cbb7372ac1cc1d9691869953197f1afd5edd29a5066b6ff1e62c1edc4d006ef33cafc487e01b8464b5ea873ccff3f58e403f587ed05059377e7cdedadada0540ad41b7b5aeeb16e7e0e92098554705802f4c2ab3ea436759c8db86f798b947c83d7501f2f7c03694a7bba1a181015469ba5285cdae6fef3b8d8d8da910103757b13c0017a5d17a2f80a3aaabab1ff16b202f5dbab4cb1b6fbcb120152a00a03d63279589eb4dfd7b1580da0e929b850a614d29414333f479befef7b952caa290f4873140d67b9e37d0b0dfbb0bc0af56663e290f733a45df5c67aab7d000e07d3f0a943e87ae0180208f7c5dd71d6c1a0a17f2cc3cd350565eef83a7ff1be286edbc10631a6b18e1f1ac522a92e54c3b401b35d92206ea003ca994da23074fde0d92b23a83636fa149640a33efc6cc7f03d0e2795ecf10bcdd23fde63b003e9552f6f631c65408d62666ee9febf64e4a59ac6fc653ebf2979ee7d9f71fdb0394521390ff7488d776c45898f910e87498cc7c894fa575307c168c63e6f7725566554a5d058073c539b6d97025da68098ab095cf4f46f00c3eccccf7f8687b72080fb16772850ac001706bc8b5fb88e779d190ebf0a97c6d2429e5f7422a55297eec096078aadd2c1f8f5656563eae3fb20ec0e13eda4f0f432ad37f2b4b33c09a01f83974ee4c85752043613e005dd2fa19aec70324eb93748401723b0a8758a65b647cfd30f3dc3cd03f3684b27fa2e15933349fa189e972d0cf1acbb167a705508ccfc871ab37403bb2fe18704e1e353404ae301db794b20b332f30b92996528ecdc1d3decc1c26d9c08c10f37907f2f8f85c87c6f9bd5daf64e65159f6c010ddcf9e21f6ee1d26b764cc7ca1eefb91907be53ac3757ab9cff19502a866e63f2712092787d12e98f989740778d808068b6dafb85f9ae703e1e96d3d06a5d46ef8fa51d403b1582ce7ed83e779bd11fc51d753d91454cff37a6a05eada80fcbfc090cf4f86106202c9aae581e37e99f9501f63ba32e41a3a2e84116a6c5033f32d61d6e1962d5b22790cbf9a1f765f0018ad0dc17febdf5f0480783cfeadc37df9f2e58fa5f55deea3ed43d26e0c4f6af36f27a5580ac0570ef7575e79e545fd9d16007bb7692f956ffe45fdfbbf5dd7c5871f7e786847c84c008f14d0006964e65db3c8e82ff344ff58c3fdf1483c1e770cfbbcaa10cc62e65b5dd70d937ef6e2808e9858dbf949578800fc83991341eaf6e877011b0d865f2fa52c09716e4e3264bb9fc7e7c30ddf09f87e2f90e51cee6bc8cb3a2965b70c06652f047fefb52c0b4f1e02b036533f01d6ebd98637ec75483e4837aebb25a5ec6318d9b0c6f3bc013ec73714407daecc714d4d4ddfb8f9d0b2e02f64b15d1a21ffcae399b090997b6d2bda95524399399535e123cff3727ac31a1b1b0533df60a81c4c68c783b53ed72d493b9ecda0def1312178661a4bbac875dd6e398454313387cd4875a2e9d8d262414d9499ab43aec50bf3a858e5a5782692e989eb00f4afaaaa3a32ed6662ebedd9e6cd9befd22123f50084cf76539ea73500bea100b6b4b4384aa93500505b5bdb1c807f3f4d29da000610117df2c92765001aebeaea00e0c8cf3efbacbf0e2998df51f212c063053440be117a20a54cbd2700331fd38106c82ad3d00da5d4407c3b0573bef6c901a67c482412bd4dc25099f93f59ced1fedadb7c59c0f3f7385325dd34dda87e2ff9bca113ea301f6bec34847bef33d3706dffd1701d5d96656e9e366cef9236fcee85646da81bc2ec5d5df3cab4f6d022a55498f0abb3900c4b0f8a7f05e8632c33ffb6a2a242b473f351d2d6f8d08e81fdc962fb8394b28c99dfca570801803db711ddc3983955ff61a9526a179f8bbc077c16c9cb20587e99a1bd71fa7afe8280c2f234431ecf0ba98098a4de8552ea1a1f6df785d9a3c674182b5a4aa9d1f83a83535e0ea1007cadc8d31e6a0af308b30d4da970a5d944444b972e7d211566a5ff7daa1efbebb7dd765b77bfedae59b3758acfcea2dc6dcdd8b26eddba1b02d03b59df226d04d05b4ab9323ddc6af3e6cdb3f5ef633a4a5e02f847010d90e5e9b7accc9c32ca163173719ee80f6a80b432f39121f6e4b9c85fc1c6f4fdfa6a73737334041f6e33ec5a49294b33b4f71a748d9a8074cc371b3e9f1c42991c06b337800b9452653ec6e4b70061363c6cc0c75e307b2351cfcc4332acdb5d61962512002adaf0fb7866464b4b4b711ef66f8de17eb9d1b44fcff38a98f979435e0429471001106dcfe18cb414f069f85429d58d2cb65b23a42733bf979f73c17ca10758a8e3f175e1be75b90a22b5b5b24d050b33dfd3b6501d33bf0a604190f703524a01e071431a8e0bc1b78130aba85abb7af56ac78770dc39e4d57b1cc00119f81565e6fff53caf38075f1d18c6e887a925a01f29c6f2a45b2df39b7e30a0c77e945e035bf4ef0f02404b4bcb5cfd39bfb71fa9c7c4d5397892eaa72620bd87343535c5521e5466aed37f1f1d263c238ffcbc12050233ff3dd54f3c1e8fa6e4543e937b181820ffacabab335a8ff178bc08c03b056095428822b3f1783c02e07dd3bedba6d765e6d34c9c2752cabd0d69d81cf2fcfc9d61bf7ff2b9c6ee0c39bfd3b3d07d19339f92e5df0e37f4d03f93a9d89d76104a43fad7a7276b61e665cc7c6b9e749fbf9b1859adadad3d42f439d1900fef8749f9dbf68c65e6e5d9ce6e3f29e62d3a3194528398f9ed3c1c0e1b3dcfeb5b283a751c642a746949d0eaa9ba5060dc504178343ddd1e339f8764c6a0f14168705db72bcc32756c62e63e21948f4b60f640ef4e9fed0f864e0660889559b2009d0be01e9febb817332f3618e3af43f0f5863c2aa157e773bf7cf0c107a3b5323f9f88e8e38f3fde1af2b160c182b789a828c038b786ad4829dbad713067ce9cff4a296c1515154704a179c68c1987e8da2258b972e5d1294fb1520af3e6cdfb7e47ca49663e11054827cbcc480f734232c5279839af8fed031a204b5a5b5b8b42f0ea4c140631007b84a0ab0fbe2e7866e264dbbf0d4f5730f38b0673f1bc2101178638e7cb0d15f51aa5d4489fe3fa7b88b995002ecad0660980b7b3a5b807f0aa212f4fcfd25e985205ebe3f17854f3fb84640081fa5e3ef6af526a1f037a1e0879fbf19f7c458c04dc1f42efd773903d594f7d47149cb628cc4d48191fff3fdc0000109049444154be5dcdd8040f15e0e0ef8b6f6681f8402935c4a09d1fc13c4bd34d69826088be0ebd7ff9f2e522200dd30cfb7fca947fcdcdcd028049d69304334ff4291cfb02581562ddbc9c81570398f9a36cef6fda11d29b030acb9b4208cabcc5b8271289927cef9d254b96dcac9bffbba6f772a514006c9452f60930ce9fe976de6befaa5c7fd691527e00000d0d0d7303ec8dde292339953d254da1b9bca365648847c3b9d6dfefd378708cf6f22ff33caf7b3ee90f6080c4fceefb2c7ceacdcc15280cde534a95843c4b969a4e95526a581b59de9248247a05a46127005b4cbcd94aa93046e1e586ebf3e9006bec0f21c2ee124aa903b2dc7e4ccbb2d60e33747c35670bdd41b874db155a798fea10bbd979943f3d02ae9b04331f1c62bd8c84597295954aa93e61c62aa52c67e65b73accb695673ff6edd847463e61bc3ea514aa98bf245932e0ab8326dd1ddee795e99615b071bde3e203de73c8099ccbc4c4a19e8e0715db7b7690898947274081e9e621a971e8bc5baf8141851667e3c8412f6c70c07c13466feabc1787f18b0efe7983970112300bfcda3123aa750fb1ac0bf01a0babafa0a3d57a9cc53eb02b4010058bd7ab52fcfd673cf3d77e256f7694dcd953efba804808a8a8a59faf72b00a0b2b2f29d4e2423ff926785fa05cff3bae9b6f74432e1059452df2fc03a18eb732dde1eb29f5fa1006f3f342e0c397fdd017c68d8f7a6850b170a3dc6c3f48dc85906f2c954c17dca6f9da90ce32e337442b5e6aa7cde66eec3dc127ed5368b1880313ada614886f3340ab3ac8e60e6ab72dcdea930ed2aa58e6266482907e46bff4a29a3019dc415aeeb760fb18f6f34e4c19d21f7e85e48566e6f0f8d61125158746230f319213dbb9299af91529a1a0ae54aa9237558582a6c6803334f0d79309601f8cac4aba194ea97f2c620f938739c41ffd71a6ee855a663d6215f9b0ce7717ac0f1fdc2b09ffab6c244293511c05b29e5cc600d4d85cfb719ccdc98a90a750e213902d91f05d622f94ee913667e1dc942568b91acb3d19a85862985dacf00c60368acacac84ebbaa30144a494eb98198d8d8d3933ab01b84693f969c07e3ff363e86825238575009cb973e74ed4a1628d00f6e94cf211c0e779323a3f524a75d1eb75048015faef3f2b10dd637dd0f44948e56104cc8b91e6746e019890073efcdb70bece48bb095b07833749b5b5b511c3302830f3b921cef41f1af27c25802037a53bc3ac601d003c24a5dcfa7ec2f3bcae005e01f0b32c631a63e8a1f79452a3db59c37bc0ec5d5f5d4d4d4d4417fbad0e132ed70e7fff14c6a917601fefcecc268fde250cea79e93e4bb4c3d94fbff39552c564f19dbd0d19c8cc33421c160ac0c7007ead941a9cabbf77de794730f3a100a6e9efb9691be901661e96270fc24341850a331fa105de099a9eb30c8547d5b67e1ba0eb8d98642571a5942302f277a06188ca2a66ee96b6f6460258cccc07998ebbb5b55530f349018c9033fdb65d55551561e64c1e9a97015cc4ccdf9752f604d015c9627a5d00749352f661e66399f9b50c212f05cdee0460a8de53353366cc98b078f1e2b296969694f77033b2a4899c3a756a692291d8a80ffa6101fb1ca6bf2795527b66e1e50d6921733301945d7cf1c547363636a614cea19dd041b37f9e0c909fe9f57e3a74063966bea5b1b15114680de432409a9879df10f2b55f9ad1997730730d33ef9187b36d1f030ff79dcc1c9152960098c7cc6fb6b4b41419cc8169263529a5ec67e884ea05f3ac4e0f677aa89d637f9846519cad79948affbfabbd1a0fcc3ccbb09ff9b9327ae9043381ce4b663e5cd3ff1a33bf9bfe183d8fb2e7689ff434d4d4d4440cd74b84994d6b1ebd9e4824ba18ecc913904c0e217dca8273ac96be63dc861c8ce423afc61067c7060073013cc8cc7f66e66b99f91a66fe0b807f6a0ff18a367dc4017cc0cc3fc8b36135c6e72d0823f9f06d74daad5043d094bb697c7c2cc4c13bc9b0cfbd43cc5b8b217fcf34b8825f983a749452fb33f307cc7c429ed6ef38f82b3cb9c84f712fa5d4607c33bbcf0600f72aa5f6f59b0ed0f3bc327c3305e73a1365c640f99998a6788dd07f7b378d8ebbda7a3b5b5a5a0ed5f3f982619f2f008052eae136875c5f7c3363cebbfaf323d21c18133bab5c544a1d6118c7ff8d901ebdf65387eebd059effb139e44ce0b750bafecf202d1f97a3c060e6eba494ddf32017fc5696de9292f952ca9d00bcc1cc8b99b9b7419ffb9a860003700d8dc29e0857bf26709137d775cb98798e415f27e8bdd59799ef01f0782699fac5175f08660e53e0f2451f7cebc3cc9b02accb0735af6f67e675a6b5737cf0b6871f259d99ef0bb1377e6c784ba7fcdee47b9ed705c02eccfc5f0066235806cd9aa0110b16dbf76d4854579bbe0be68fb8d36f46a4fe5119bcf38a99ffc5cc479ac4e5fb1ccf81683f17ba4add3ab8ae5bae6f4d6a99f9f4a031b89ee70d00f030c2e5467f4329b57baebee2f17837661ea2bd247784341a01e076a5d4f00c024ae41060418d901880fb01bcc0ccf3c3dc7c643b8475dc75530ea1fdaf1ced9c9aa6647dc9ccbf514a0d514a450dd6e0f8b47effbeadf632807d5cd74df17cb29eaffdda18543f495bbfcf03c06f7ffbdb9126fd5d7ef9e57d520dcf983163b2a6e127e9b781a9cc4248d6028949290160dc7620174767b9090baa548399af9052762df0dcb76780ccc9b1a77763e6537426c22b01fc2f807b91cce6b41605c80e964d11d746f31d00ae60e69f32f309cc7c943ea3f6574a457cc8e51ecc3c33c7bcac4965e6d3214c0d001e9352f630582b3f41b804060ce01ccff34a7cc8bb3edaf974898f58fa5cf89c998f755db734a012bbb38111f221807b987939335f979e7add75dd5266fe1e8033912c3a1b460fa963e64b95523be718c37eccec3714ab5abf61690430bc90fb9899dfcc15aa18a47e8fe6ed30663e551bab7143beae95528e66e65d997938338f62e609cc7c846efb3c1d867e278017f559e31ac84bfbf89c8876c8dcc34aa9614288a38510a713d13022da8988c214829144544544eb003c0be085152b56ac183972240a3c8e918ee3dc4244871051266fc52c22aa25a27d01ac22a2ab1dc7a9c821184611d16942883e44348888066bfe0c20a2d610e41613511d11356b7e49228a00f8bde338af30f34542885f1311135117222ad573d21a924de9fd7a44a400bcee38ce553ef83bce719ceb89e80022ca952acf23a22f89689652eac668345a5da039df59087176dadacda448cc27a2fb017c268420222a21a2fd89e804221a41444b00dc2f84784d08b129e441f2b810e20ca5d46ed16874edb6dac36fbef9e61e471c71c40744d49b88ce27a2078410ac0dc0498ee37421a2cf89e81622fa27115d208430f6ce03389f88eed9b265cbf2f2f272198944c610519c88de12421c8f6445f57389e85e22aa9d376fde51071e78e082ed411e327319119d2f84f80511050d0ffa8a881600b8de719c8f0b4d2b92451c3f25a2a636e75833339f1089441665f99e43445713d17544e41291a3650df47f95feff6d8588fe896ad99192898a889a98797c241289f950bca2d168f45221c445449449696c04f0a010621f7d33780b333f128d46658e35f13b22ea29841898760e0cc9039f1c22daace720d5567d3c1e3fb66bd7ae5d84104fe9be8a89a8ab3ed794fe09c36b4f9f0389148f015cea384ebb7b349148941415155d228498a2e56daed09c1a22aa00f027c771ded40538a70b218ed6ffde45cb2c689ac2e86ec544544d442d9a9f11bd0f9f6d7366ecee38cead44742811b59774a69a88e628a52e8f46a3950596393f11423c4044b12c6b648d52ead068341acbd1ce955a6e41af97b2b4f936123144d4a0db10fa27aa7f8ad2e65f85901bad004e731ce7436b80eca0705d5744a3d1a81606a3b570d98b884611d13021c44e4494e99a9c016c24a2354288cf012c1442ac60e6658ee36c6066158944b6d94126a52c8e442263011c2484180f60b0dec0f59ac605ccfc91e338ab85103985b83ea486e9cdd57663e67bbd0900ab1dc7a965e6414288c169fda250eb1c409de338ab7d2afc5121c4ee44b40f118d11420cd73c8a12514c08b101408510622933cf27a28642cfbf52ca11427427a2bd355d0712d1de9aceb61ee80624d32ace15427ca88d9235420899275a063b8e739c10e2be6dbd87010c21a21789684f00731dc739888868fefcf9137af7eefdf4d0a143d3b3ce3ccacc774422917906c6ce65471c71c438229a9af6e777b451b34cd3f22e114d24a2254474bc1062fdf6240f0108a5544fc771260a21260138540831aaed7a42b230e34a6de4be4f449f00581d8944d436a2b32b118dcda090c63ccffba2b8b818ed7c37a548ab4e3e1d8a99174722110e700e0c8c4422076b67c90800a5428856ed185baac3e43e8e44224d3ef9bcaf96c1c8f31990e91c50f1787c51d7ae5d851062b456acf37d06b4ed570158e9384eb30f192788a85408b12f11ed298418add75209114921c416002b85104b002c62e61529038f998596cbe569e329d4d92600ac751ca72683a2ee10d178223a5008f17d4dbf1042d413d15a000b88e833cff39675e9d2a5e0fb434ad9351289eca58dee4c636a1442acf061c8ec2284189067de8a02acf9f4f6143357442211493b386cf5c56f2fe81222ea2684e8a22ddea856e8a10f2e0f408288e22d2d2dcd3d7af44067a13d9148448a8a8a520a83741c27616734efca7f9110227540722c166b2d2d2dedd03520a52c721ca75408d14d7b6852e11b1e33c78510313f07edf608fdeee649223ab9a6a646f4eddbf778a5d49c6834dae279de0f5b5b5bafebd1a3c7f7529eab9696966ac7712aa2d1e8ad4aa9a8947249494949ab10a212c02e5f7cf14559fffefd4746a351b7a1a1e13742882183060d4a850eba44b480886e11423c595b5bdbdd719cc3cbcaca5e144230113d4b44a70b21b0bdf39599cb8510259a6f51ed1848c9be16c7711aad34e8b432aaab10228264cd8f447171315baee40f757575a267cf9e5d537a01337bd168d4db5ee86f6d6d8d16171777d1f253462211ab27585858585858182accfba652c07a9eb7b2a9a9e9b63423653480337486aaf4cc74a94411d3f4e7a631b3d2450eb7a6bbd4df3b4387ff1011d1faf5eb6ff33c2f55dbe78b3099972c2c2c2c2c2c2c2c2c2c2cb65300f8b97e509cc2633a2b5569da678601b80ac0af67cd9af56eaa36889472e17befbdf73700bf0770557adaecf9f3e7f7d8b061c38836d978d65554545c6ab96e616161616161616161b1631b2125008e6d686858e7795b131bad07f0c6f4e9d3cfa9a8a818e5b39d5100ced119dcd64b29e1ba2e1a1a1ad60138164089e5b685858585858585858585c5565c7bedb54701f8634d4dcd52009b3dcf4322910033d701a80750fbc9279f54af5ab5ea61d775d7e90ac8f5a94ac8f1781c006a6a6a6a3e6b6e6e9ef6c61b6f8cb45cb5b0b0b0b0b0b0b0b0b0b0c885ae00062c5bb66c5c4545c5419b366dba03c0f4f9f3e7affd4621893973e601f89baed13071d1a245fb0018485f3fecb7b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0b0d891f1ff8ea29c87596172ee0000000049454e44ae426082, 0, 1, '0', '', '', '', '', '', '713', '2239000', '', '', '', 0, 48);
INSERT INTO `user` (`id`, `userName`, `company`, `firstName`, `lastName`, `email`, `password`, `date`, `lastUpdate`, `image`, `role`, `active`, `country`, `address1`, `address2`, `city`, `state`, `zip`, `phoneCode`, `phone`, `mobilePhone`, `phone2`, `fax`, `deleted`, `mainUserId`) VALUES
(49, 'abdallah@worldwideautosllc.com', 'WORLDWIDE AUTOS LLC', 'WORLDWIDE', ' AUTOS LLC', 'abdallah@worldwideautosllc.com', 'b983716f4cf156df17f019e14c228491', '2019-08-21 18:45:19', '2019-09-09 18:10:37', NULL, 1, 1, '1', '790 WESTLAND DR', '', 'LEXINGTON, KY', NULL, '40504', NULL, '8596672379', '', '', '', 0, 48),
(51, 'MTWALY64@HOTMAIL.COM', 'LEEN AUTO SALE', 'LEEN AUTO ', 'LEEN AUTO ', 'MTWALY64@HOTMAIL.COM', 'a47d4bdbcb65c99cbffc3ba1dfb9c5b3', '2019-08-21 20:42:55', '2019-08-21 20:42:55', NULL, 5, 1, '1', '3925 GALVESTON RD ', '', 'HOUSTON ', NULL, '77017', NULL, '8322795300', '', '', '', 0, 48),
(52, 'abesauto640@gmail.com', 'ABE\'S AUTO LLC', 'abrahim ', 'bakoush ', 'abesauto640@gmail.com', 'ff1ecee5bffafdd236eec3c13bc632e3', '2019-08-21 20:47:39', '2019-09-28 15:17:54', NULL, 1, 1, 'US', '271 Gold Rush RD #9', '', 'Lexington ,KY', NULL, '40503', NULL, '859-260-1145', '', '', '', 0, 48),
(53, 'ahmedsonic1993@gmail.com', 'Smart Opal', 'Ahmed', 'Dakrory', 'ahmedsonic1993@gmail.com', '27cba063737584db2847f3090979bd46', '2019-08-22 00:00:00', '2019-08-22 00:00:00', NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 53),
(54, 'carmartransport@gmail.com', 'carmartransport', 'carmar', 'transport ', 'carmartransport@gmail.com', 'af246bf6117c86d42e5c085352c07a11', '2019-08-22 16:30:44', '2019-09-11 19:17:26', NULL, 1, 1, '1', '7999 hansin rd ', '', 'houston ,tx', NULL, '77061', NULL, '3463721516', '', '', '', 0, 48),
(55, 'asmglobal6013@gmail.com', 'ASM Global Logistics', 'ASM', 'GLOBAL LOGISTICS ', 'asmglobal6013@gmail.com', '2d30067c9a56af30ac3ca8506182ffeb', '2019-08-22 21:40:43', '2019-10-16 20:36:48', NULL, 5, 1, '0', '6013 Spencer Hwy', '', 'HOUSTON,TX ', NULL, '77505', NULL, '832-850-6475', '', '', '', 0, 48),
(56, 'jaygbrial32@gmail.com', 'carmar', 'jay', 'miranda ', 'jaygbrial32@gmail.com', '168ce324c96b38b7ad6d7e2053bb393f', '2019-08-23 20:53:47', '2019-08-23 20:53:47', NULL, 4, 1, '456', '12340 haris dr ', '', 'maxico ', NULL, '77017', NULL, '7132239000', '', '', '', 0, 48),
(57, 'ajeebzayed@hotmail.co.uk', 'AJEEB OVERSEAS LLC', 'AJEEB ', 'OVERSEAS LLC', 'ajeebzayed@hotmail.co.uk', '440701be6cd987def795247f658e683f', '2019-08-24 15:44:41', '2019-08-24 15:44:41', NULL, 1, 1, '1', '340 SHADOW RIDGE', '', 'COLORADO SPRINGS, CO', NULL, '80918', NULL, '1-719-321-0826', '', '', '', 0, 48),
(58, 'osama_kia@yahoo.com', 'ALENTELAQA ALTHABITA COMPANY', 'osama ', 'almighrihi ', 'osama_kia@yahoo.com', 'f756c68b552929bf8a868d682c655d0d', '2019-08-24 16:12:38', '2019-09-16 14:55:21', NULL, 1, 1, 'US', '5114 EBROADWAY', '', 'TAMPA, FL ', NULL, '33617', NULL, '218913262644', '', '218925335249', '', 0, 48),
(59, 'honor200172018@gmail.com', 'KOSSI ELBASOUNI', 'KOSS', 'ELBASOUNI', 'abesauto640@gmail.com', '7dcc74cfc4706f3f16a44f0633d34dc6', '2019-08-26 20:04:29', '2019-09-23 20:53:27', NULL, 2, 0, '0', '', '', '', NULL, '', NULL, '', '', '', '', 0, 48),
(60, 'sealandfreightllc@gmail.com', 'Aeneas Exporting LLC', 'ziad ', 'haj', 'sealandfreightllc@gmail.com', '9a73e36b04a234c3fcd3b02b0429c17f', '2019-08-27 21:16:51', '2019-08-27 21:18:34', NULL, 2, 1, '1', '', '', '', NULL, '77061', NULL, '', '', '', '', 0, 48),
(61, 'betarbetar452@gmail.com', 'MOHAMED OBADI', 'MOHAMED ', 'OBADI', 'abesauto640@gmail.com', '547b08c3e32d5322a228131c78f667c2', '2019-08-28 15:50:19', '2019-09-23 20:50:33', NULL, 2, 0, '0', '', '', '', NULL, '', NULL, '', '', '', '', 0, 48),
(62, 'INFO@LIBLINE.COM.LY ', 'LIBYANMARINE LINES CORP', 'LIBYANMARINE ', 'LINES CORP', 'INFO@LIBLINE.COM.LY ', 'b8e1772f20643dad8dc5e5da3d5e947d', '2019-08-30 21:46:35', '2019-08-30 21:46:35', NULL, 4, 0, '438', 'AL-MINA STREET ', 'NEAR AL-KHOMS PORT ', 'KHOMS LIBYA ', NULL, '', NULL, '218926131714', '', '', '', 0, 48),
(63, 'tsallabi@yahoo.ca', 'SALABI CAR DEALER ', 'SALLABI ', 'CAR DEALER ', 'tsallabi@yahoo.ca', '612d608c24d0b6e8946d9b73aa75a446', '2019-09-03 16:07:08', '2019-10-07 20:17:03', NULL, 1, 1, '0', '3925 GALVESTON RD ', '', 'HOUSTON TX ', NULL, '', NULL, '', '', '', '', 0, 48),
(64, 'ABAN012003@YAHOO.COM', 'WHITE SEA EXPORT ', 'WHIT SEA ', 'EXPORT ', 'ABAN012003@YAHOO.COM', '14a74907455a64a2d42170153140f394', '2019-09-04 16:26:37', '2019-10-29 21:38:21', NULL, 1, 1, '0', '26907 CANYON WALK IN ', '', 'SYPRESS ', NULL, '77433', NULL, '7137035525', '', '', '', 0, 48),
(65, 'alkhateeb79@gmail.com', 'RAID ALKHATEEB', 'RAID ', 'ALKHATEEB ', 'alkhateeb79@gmail.com', 'c99303489014c5674899816aee8dc103', '2019-09-04 17:36:42', '2019-10-07 20:15:29', NULL, 1, 1, '0', '3925 GALVESTON RD ', '', 'HOUSTON ,TX', NULL, '77017', NULL, '(713) 366-6663', '', '', '', 0, 48),
(66, 'raedkanaan71@yahoo.com', 'RAID KANAAN', 'RAID ', 'KANAAN ', 'raedkanaan71@yahoo.com', 'e88e9aff5e75ab0e1792bfeeedbaaee5', '2019-09-08 19:01:57', '2019-09-10 21:11:15', NULL, 1, 1, 'CA', '', '', '', NULL, '', NULL, '9054625570', '', '', '', 0, 48),
(67, 'Aeneas Exporting LLC', 'Aeneas Exporting LLC', 'ZIAD ', 'HAJAHMED ', 'AeneasExporting@yahoo.com', 'b3e2c582069c73d762cc6dbb12531b5d', '2019-09-14 18:52:25', '2019-09-14 18:52:25', NULL, 1, 1, 'US', '7999 HANSEN RD ', '', 'HOUSTON,TX ', NULL, '77065', NULL, '713-223-9000', '', '', '', 0, 48),
(68, 'attwairi@gmail.com', 'abna altuwayri auto sales ', 'MUKHTAR', 'altuwayri', 'attwairi@gmail.com', '51c29b58a573b8c52aee1ec4fa30e173', '2019-09-16 14:46:57', '2020-01-18 01:14:34', NULL, 1, 1, 'US', '3925 Galiveston rd ', '', 'houston,tx ', NULL, '77017', NULL, '218927943144', '', '', '', 0, 48),
(69, 'imt@imtautomachinery.com', 'International Machinery Trading, LLC', 'Abdelmoneam', 'Raef', 'imt@imtautomachinery.com', '29d170f59912ee9e9bd88517d6e7a07b', '2019-09-16 16:13:12', '2019-10-02 15:31:04', NULL, 1, 1, 'US', '2029 Vanesta Place, Suite 2', '', 'Manhattan', 'KS', '66053', NULL, '785-473-7223', '7853412350', '3176546512', '', 0, 48),
(70, 'Abdalla', 'A.Shakhi', 'A.Shakhi', 'SHAKHI', 'abesauto640@gmail.com', '0c0a6ecdb387bb216e5ccc69cbaaa276', '2019-09-23 20:42:06', '2019-09-23 20:54:57', NULL, 2, 0, 'LY', '', '', '', NULL, '', NULL, '', '', '', '', 0, 48),
(71, 'M.FARSI', 'M.FARSI', 'MOHAMED', 'FARSI', 'abesauto640@gmail.com', 'c97af6a8cbb032664005a96acd6ffe8c', '2019-09-23 20:53:10', '2019-09-23 20:53:10', NULL, 2, 0, 'LY', '', '', '', NULL, '', NULL, '', '', '', '', 0, 48),
(72, 'Dogal ', 'Dogal Shipping Agencies CO', 'IBRAHIM', 'BAQOSH ', 'info@libyanit.com', '1fc301206c0a042c40a2ca54cafd7b42', '2019-10-01 16:25:34', '2019-10-01 16:54:56', NULL, 4, 1, 'LY', 'Jamal Abdel Nasser St', '', 'Benghazi ', '0', '', NULL, '218619096148', '', '218918785869', '', 0, 48),
(74, 'Dakrory', 'giza', 'Ahmed', 'Dakrory', 'ahmedsonic1993@gmail.com', 'f84b74e870290e08a073e29f70888cab', '2019-10-04 14:24:43', '2019-10-04 14:24:43', NULL, 1, 1, 'EG', '1 omda st from fasel talbya', '1 omda st from fasel talbya', 'giza', NULL, '12111', NULL, '01061690939', '', '', '', 0, 48),
(75, 'luai@4weelstation.com', '4wheelstation ', 'LUAI', 'ALSHEHELI', 'luai@4wheelstation.com', '0f07ba1576dad2c53fba6ef87f31a122', '2019-10-07 20:28:46', '2019-12-17 01:27:23', NULL, 2, 1, 'SA', '', '', 'RIYADH ', NULL, '', NULL, '966560809070', '', '', '', 0, 48),
(76, 'riad.hmimida@gmail.com', 'JEBAL GORINA ALMOTAHEDA ', 'TAREEK', 'ALNAJAH', 'riad.hmimida@gmail.com', '4ff327bca47e558b0ae8f147118889cb', '2019-10-14 19:55:27', '2019-11-15 16:55:23', NULL, 1, 1, 'LY', '555 Tareek Almatar', '', 'MISRATA ', NULL, '', NULL, '6316330803', '', '', '', 0, 48),
(77, '00', '00', '00', '00', 'AeneasExporting@YAHOO.COM', '005e4a0d7dc4309c6646d02308c867f8', '2019-10-14 20:45:00', '2019-10-14 20:47:25', NULL, 4, 0, 'DZ', '00', '000', '', 'AK', '0000', NULL, '00000', '000000', '00000', '000', 0, 48),
(78, 'jebalcyrene@gmail.com', 'JEBAL GORINA ALMOTAHEDA ', 'RIAD', 'HMIMIDA ', 'jebalcyrene@gmail.com', 'ccafc7f6eb1f2a88c84cab06d245c6f0', '2019-10-17 21:21:26', '2019-10-17 21:21:27', NULL, 4, 1, 'LY', '555 TAREEK ALMATAR ', '', 'MISURATA ', '0', '', NULL, '218918316789', '', '', '', 0, 48),
(79, 'Riadhmimida', 'Riad', 'Riad', 'Hmimida', 'riad.hmimida2@gmail.com', '7204ece8616fc8804bf388d4164c4a75', '2019-11-08 23:58:25', '2019-11-08 23:58:25', NULL, 2, 0, 'US', '', '', '', NULL, '', NULL, '', '', '', '', 0, 48),
(80, 'nalmasary@yahoo.com', 'NASSER ALMASARY ', 'NASSER ', 'ALMASARY ', 'nalmasary@yahoo.com', 'cf605fa423cf57a008ad0d52c04bc029', '2019-12-17 19:51:01', '2020-01-01 09:22:21', NULL, 2, 1, 'SA', '7757 ALWASEEF STREET ', '', 'IZDIHAR-RIYADH ', NULL, '12487-2163', NULL, '0505533926', '', '', '', 0, 48);

-- --------------------------------------------------------

--
-- Table structure for table `vendor`
--

CREATE TABLE `vendor` (
  `id` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `idType` int(11) DEFAULT NULL,
  `other` mediumtext,
  `notes` mediumtext,
  `allowAccess` int(11) NOT NULL DEFAULT '0',
  `parentId` int(11) DEFAULT NULL,
  `salesRep` mediumtext,
  `idNumber` varchar(255) DEFAULT NULL,
  `deleted` int(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vendor`
--

INSERT INTO `vendor` (`id`, `userId`, `idType`, `other`, `notes`, `allowAccess`, `parentId`, `salesRep`, `idNumber`, `deleted`) VALUES
(14, 59, 1, '', '', 0, 27, '', '', 0),
(15, 60, 1, '', 'welcome to Aeneas Exporting LLC ', 0, 28, '', '', 0),
(16, 61, 1, '', '', 0, 27, '', '', 0),
(17, 70, 1, '', '', 0, 27, '', '', 0),
(18, 71, 1, '', '', 0, 27, '', '', 0),
(19, 75, 1, '', '', 0, 33, '', '', 0),
(20, 79, 1, '', '', 0, 40, '', '', 0),
(21, 80, 3, '', '', 0, 33, 'RAID ', 'W755435', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD UNIQUE KEY `uuid_2` (`uuid`),
  ADD KEY `mainIdkey_idx` (`mainId`),
  ADD KEY `shipperIdKey_idx` (`shipperId`),
  ADD KEY `vendorIdKey_idx` (`vendorId`),
  ADD KEY `customerIdKey_idx` (`customerId`),
  ADD KEY `consigneeIdKey_idx` (`consigneeId`),
  ADD KEY `mainTwoIdKey_idx` (`mainTwoId`),
  ADD KEY `uuid` (`uuid`);

--
-- Indexes for table `carimage`
--
ALTER TABLE `carimage`
  ADD PRIMARY KEY (`id`),
  ADD KEY `carId_idx` (`carId`);

--
-- Indexes for table `carimageLanding`
--
ALTER TABLE `carimageLanding`
  ADD PRIMARY KEY (`id`),
  ADD KEY `carIdIndex_idx` (`carId`);

--
-- Indexes for table `carLanding`
--
ALTER TABLE `carLanding`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userMainId_idx` (`mainId`);

--
-- Indexes for table `commoditiy`
--
ALTER TABLE `commoditiy`
  ADD PRIMARY KEY (`id`),
  ADD KEY `customIdcomm_idx` (`customId`),
  ADD KEY `docrecIdComm_idx` (`docReceiptId`);

--
-- Indexes for table `consignee`
--
ALTER TABLE `consignee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `useridForCongnie_idx` (`userId`),
  ADD KEY `parentIdShipper_idx` (`parentId`);

--
-- Indexes for table `custom`
--
ALTER TABLE `custom`
  ADD PRIMARY KEY (`id`),
  ADD KEY `usppiId_idx` (`usppiId`),
  ADD KEY `ulconsignee_idx` (`ulConsigneeId`),
  ADD KEY `interconsignee_idx` (`interConsigneeId`),
  ADD KEY `freightForward_idx` (`freightForwardedId`),
  ADD KEY `userIDForm_idx` (`userId`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userIdx_idx` (`userId`),
  ADD KEY `dataCustomervendor_idx` (`parentId`);

--
-- Indexes for table `customtransportation`
--
ALTER TABLE `customtransportation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `customIdTrans_idx` (`customId`),
  ADD KEY `docReIdTran_idx` (`docReceiptId`);

--
-- Indexes for table `docreciept`
--
ALTER TABLE `docreciept`
  ADD PRIMARY KEY (`id`),
  ADD KEY `usppiId_idx` (`usppiId`),
  ADD KEY `freightIdDoc_idx` (`freightForwarderId`),
  ADD KEY `consigneeIdDoc_idx` (`ultiConsignee`),
  ADD KEY `interConsigneeIdDoc_idx` (`intermConsignee`),
  ADD KEY `userId_idx` (`userId`),
  ADD KEY `userIdMainDoc_idx` (`mainId`);

--
-- Indexes for table `images`
--
ALTER TABLE `images`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idCustomerUser_idx` (`userIdIssuer`),
  ADD KEY `idIssuerUser_idx` (`userIdCustomer`),
  ADD KEY `invoice_transaction_idx` (`transactionId`);

--
-- Indexes for table `invoiceCar`
--
ALTER TABLE `invoiceCar`
  ADD PRIMARY KEY (`id`),
  ADD KEY `invoiceId_idx` (`invoiceId`),
  ADD KEY `carId_idx` (`carId`);

--
-- Indexes for table `mainTwo`
--
ALTER TABLE `mainTwo`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`),
  ADD KEY `idUser_idx` (`userId`),
  ADD KEY `idMainUnder_idx` (`parentId`),
  ADD KEY `underMainId` (`parentId`);

--
-- Indexes for table `moneybox`
--
ALTER TABLE `moneybox`
  ADD PRIMARY KEY (`id`),
  ADD KEY `moneybox_userId_idx` (`userId`);

--
-- Indexes for table `moneybox_transaction_details`
--
ALTER TABLE `moneybox_transaction_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `moneybox_transaction_idx` (`moneyBoxId`);

--
-- Indexes for table `quote`
--
ALTER TABLE `quote`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `shipper`
--
ALTER TABLE `shipper`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`),
  ADD KEY `idUser_idx` (`userId`),
  ADD KEY `idMainUnder_idx` (`parentId`),
  ADD KEY `underMainId` (`parentId`);

--
-- Indexes for table `transportfee`
--
ALTER TABLE `transportfee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idForMain_idx` (`mainUserId`);

--
-- Indexes for table `vendor`
--
ALTER TABLE `vendor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idUser_idx` (`parentId`),
  ADD KEY `userIdx_idx` (`userId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `car`
--
ALTER TABLE `car`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=733;
--
-- AUTO_INCREMENT for table `carimage`
--
ALTER TABLE `carimage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1434;
--
-- AUTO_INCREMENT for table `carimageLanding`
--
ALTER TABLE `carimageLanding`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT for table `carLanding`
--
ALTER TABLE `carLanding`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `commoditiy`
--
ALTER TABLE `commoditiy`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT for table `consignee`
--
ALTER TABLE `consignee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `custom`
--
ALTER TABLE `custom`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `customtransportation`
--
ALTER TABLE `customtransportation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `docreciept`
--
ALTER TABLE `docreciept`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `images`
--
ALTER TABLE `images`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=196;
--
-- AUTO_INCREMENT for table `invoice`
--
ALTER TABLE `invoice`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
--
-- AUTO_INCREMENT for table `invoiceCar`
--
ALTER TABLE `invoiceCar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=155;
--
-- AUTO_INCREMENT for table `mainTwo`
--
ALTER TABLE `mainTwo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT for table `moneybox`
--
ALTER TABLE `moneybox`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
--
-- AUTO_INCREMENT for table `moneybox_transaction_details`
--
ALTER TABLE `moneybox_transaction_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `quote`
--
ALTER TABLE `quote`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `shipper`
--
ALTER TABLE `shipper`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
--
-- AUTO_INCREMENT for table `transportfee`
--
ALTER TABLE `transportfee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=573;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=81;
--
-- AUTO_INCREMENT for table `vendor`
--
ALTER TABLE `vendor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `car`
--
ALTER TABLE `car`
  ADD CONSTRAINT `consigneeIdKey` FOREIGN KEY (`consigneeId`) REFERENCES `consignee` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `customerIdKey` FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `mainIdkey` FOREIGN KEY (`mainId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `mainTwoIdKey` FOREIGN KEY (`mainTwoId`) REFERENCES `mainTwo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `shipperIdKey` FOREIGN KEY (`shipperId`) REFERENCES `shipper` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `vendorIdKey` FOREIGN KEY (`vendorId`) REFERENCES `vendor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `carimage`
--
ALTER TABLE `carimage`
  ADD CONSTRAINT `carId` FOREIGN KEY (`carId`) REFERENCES `car` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `carimageLanding`
--
ALTER TABLE `carimageLanding`
  ADD CONSTRAINT `carIdIndex` FOREIGN KEY (`carId`) REFERENCES `carLanding` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `carLanding`
--
ALTER TABLE `carLanding`
  ADD CONSTRAINT `userMainId` FOREIGN KEY (`mainId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `commoditiy`
--
ALTER TABLE `commoditiy`
  ADD CONSTRAINT `customIdcomm` FOREIGN KEY (`customId`) REFERENCES `custom` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `docrecIdComm` FOREIGN KEY (`docReceiptId`) REFERENCES `docreciept` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `consignee`
--
ALTER TABLE `consignee`
  ADD CONSTRAINT `parentIdShipper` FOREIGN KEY (`parentId`) REFERENCES `shipper` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `useridForCongnie` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `custom`
--
ALTER TABLE `custom`
  ADD CONSTRAINT `freightForward` FOREIGN KEY (`freightForwardedId`) REFERENCES `consignee` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `interconsignee` FOREIGN KEY (`interConsigneeId`) REFERENCES `consignee` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ulconsignee` FOREIGN KEY (`ulConsigneeId`) REFERENCES `consignee` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `userIDForm` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `usppiId` FOREIGN KEY (`usppiId`) REFERENCES `consignee` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `dataCustomervendor` FOREIGN KEY (`parentId`) REFERENCES `vendor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `newUserData` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `customtransportation`
--
ALTER TABLE `customtransportation`
  ADD CONSTRAINT `customIdTrans` FOREIGN KEY (`customId`) REFERENCES `custom` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `docReIdTran` FOREIGN KEY (`docReceiptId`) REFERENCES `docreciept` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `docreciept`
--
ALTER TABLE `docreciept`
  ADD CONSTRAINT `freightIdDoc` FOREIGN KEY (`freightForwarderId`) REFERENCES `consignee` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `userIdDoc` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `userIdMainDoc` FOREIGN KEY (`mainId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `usppiIdDoc` FOREIGN KEY (`usppiId`) REFERENCES `consignee` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `invoice_transaction` FOREIGN KEY (`transactionId`) REFERENCES `moneybox_transaction_details` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `mainTwo`
--
ALTER TABLE `mainTwo`
  ADD CONSTRAINT `parentIdMain` FOREIGN KEY (`parentId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `userIDData` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `moneybox`
--
ALTER TABLE `moneybox`
  ADD CONSTRAINT `moneybox_userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `moneybox_transaction_details`
--
ALTER TABLE `moneybox_transaction_details`
  ADD CONSTRAINT `moneybox_transaction` FOREIGN KEY (`moneyBoxId`) REFERENCES `moneybox` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `shipper`
--
ALTER TABLE `shipper`
  ADD CONSTRAINT `idUser` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `mainParentKey` FOREIGN KEY (`parentId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `idForMain` FOREIGN KEY (`mainUserId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `vendor`
--
ALTER TABLE `vendor`
  ADD CONSTRAINT `datashipping` FOREIGN KEY (`parentId`) REFERENCES `shipper` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `userIdx` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
