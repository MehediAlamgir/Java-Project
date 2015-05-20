-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 06, 2013 at 10:01 AM
-- Server version: 5.5.24-log
-- PHP Version: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `contactbook`
--

-- --------------------------------------------------------

--
-- Table structure for table `signupinfo`
--

CREATE TABLE IF NOT EXISTS `signupinfo` (
  `username` varchar(50) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `contact` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `blood` varchar(15) NOT NULL,
  `gender` varchar(8) NOT NULL,
  `dob` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `signupinfo`
--

INSERT INTO `signupinfo` (`username`, `firstname`, `lastname`, `password`, `contact`, `email`, `blood`, `gender`, `dob`) VALUES
('demo', 'Ahmed', 'Ahsun', 'demo', '01674420006', 'ahmed_ahsun@yahoo.com', 'A+', 'Male', '19/8/1991'),
('demo1', 'demo', 'demo', 'demo', 'demo', 'demo', 'A+', 'Male', '2 / Jan / 1971');

-- --------------------------------------------------------

--
-- Table structure for table `userinfo`
--

CREATE TABLE IF NOT EXISTS `userinfo` (
  `me` varchar(50) NOT NULL,
  `nickname` varchar(50) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `contact` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `blood` varchar(20) NOT NULL,
  `dob` varchar(50) NOT NULL,
  `gender` varchar(8) NOT NULL,
  `image` varchar(600) NOT NULL,
  PRIMARY KEY (`nickname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userinfo`
--

INSERT INTO `userinfo` (`me`, `nickname`, `firstname`, `lastname`, `contact`, `email`, `blood`, `dob`, `gender`, `image`) VALUES
('demo', 'shourov01', 'Ahsun', 'Ahmed', '01674420006', 'ahmed_ahsun@yahoo.com', 'A+', '19 / Aug / 1991', 'Male', 'C:UsersShourov01Desktop1.jpg');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
