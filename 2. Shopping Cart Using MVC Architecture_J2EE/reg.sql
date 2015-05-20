-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 17, 2014 at 08:50 PM
-- Server version: 5.6.14
-- PHP Version: 5.5.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `reg`
--

-- --------------------------------------------------------

--
-- Table structure for table `cartlist`
--

CREATE TABLE IF NOT EXISTS `cartlist` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `ProductName` varchar(50) NOT NULL,
  `Price` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `cartlist`
--

INSERT INTO `cartlist` (`id`, `ProductName`, `Price`) VALUES
(1, 'Nexus 5', 23000),
(2, 'Lumia 1024', 35000),
(3, 'Iphone 6 Plus', 65000),
(4, 'Samsung Grand 2', 22000),
(5, 'Samsung Note 5', 61000),
(6, 'HTC 8', 72000),
(8, 'Motorolla G', 18000);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `username` varchar(20) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `present_address` varchar(100) NOT NULL,
  `permanent_address` varchar(100) NOT NULL,
  `contact` varchar(30) NOT NULL,
  `qualification` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL,
  `status` tinyint(4) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`firstname`, `lastname`, `username`, `gender`, `present_address`, `permanent_address`, `contact`, `qualification`, `password`, `status`) VALUES
('bb', 'cc', 'dd', 'male', 'pp', 'pp', '99', 'SSC', 'll', 0),
('ff', 'ff', 'ff', 'male', 'ee', 'eee', 'ee', 'SSC', 'll', 0),
('mehedi', 'Alamgir', 'mehedi33', 'male', '33 Ashkona', 'DO', '01674555966', 'UnderGraduate', 'mm', 1),
('oo', 'oo', 'oo', 'male', 'vv', 'vv', 'vv', 'Graduate', 'jj', 0),
('zxcvb', 'mnb', 'pop', 'female', 'mki', 'ikm', '0987', 'SSC', '55', 0),
('pp', 'pp', 'pp', 'male', 'hh', 'hhh', 'hhh', 'SSC', 'yy', 0),
('ds', 'sd', 'qaz', 'male', 'poi', 'iop', '789', 'SSC', '1234', 0),
('plm', 'mlp', 'qazxc', 'male', 'jhg', 'gff', '765', 'HSC', 'pp', 0),
('qq', 'qq', 'qq', 'male', 'rr', 'rr', 'rr', 'UnderGraduate', '99', 0),
('rr', 'rrr', 'rrr', 'male', 'ww', 'www', 'www', 'HSC', 'mm', 0),
('ss', 'sss', 'ss', 'male', 'dd', 'dd', 'dd', 'UnderGraduate', 'yy', 0),
('ccc', 'CCC', 'WER', 'male', 'tt', 'tt', '77', 'Graduate', '99', 0),
('ww', 'ww', 'www', 'female', 'tt', 'tt', 'tt', 'HSC', 'hh', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
