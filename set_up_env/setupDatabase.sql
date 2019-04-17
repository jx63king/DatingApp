-- phpMyAdmin SQL Dump
-- version 4.4.15.7
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 12, 2019 at 03:31 PM
-- Server version: 5.6.37
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

CREATE SCHEMA IF NOT EXISTS `Test` DEFAULT CHARACTER SET utf8 

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `online_dating`
--

-- --------------------------------------------------------

--
-- Table structure for table `Feedback`
--

CREATE TABLE IF NOT EXISTS `Feedback` (
  `feedback_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `date_user_id` int(11) NOT NULL,
  `score` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Feedback`
--

INSERT INTO `Feedback` (`feedback_id`, `user_id`, `date_user_id`, `score`) VALUES
(1, 1, 2, 2),
(2, 2, 4, 3),
(3, 2, 3, 5);

-- --------------------------------------------------------

--
-- Table structure for table `User`
--

CREATE TABLE IF NOT EXISTS `User` (
  `user_id` int(11) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `age` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `sexual_orientation` varchar(45) DEFAULT NULL,
  `zip` int(11) DEFAULT NULL,
  `relationship_type` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `attractiveness` tinyint(1) DEFAULT NULL,
  `hobby` varchar(255) DEFAULT NULL,
  `personality` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `User`
--

INSERT INTO `User` (`user_id`, `first_name`, `last_name`, `age`, `gender`, `sexual_orientation`, `zip`, `relationship_type`, `password`, `notes`, `attractiveness`, `hobby`, `personality`) VALUES
(1, 'John', 'Smith', '23', 'Male', 'Striaght', 15232, 'casual', '123', '', 5, 'movies, karaoke, rock-climbing, hiking', 'open, fun, devoted'),
(2, 'Jane', 'Watson', '33', 'Female', 'Straight', 15213, 'Long-term', '12345', NULL, 8, 'reading, writing, cooking', 'loving, kind'),
(3, 'Rick', 'Hoffman', '28', 'Male', 'Gay', 12504, 'Casual', '12345', NULL, 3, 'hiking, movies, coding', 'kind, hard-working, fun'),
(4, 'Keira', 'Fox', '24', 'Female', 'Straight', 22222, 'Long-term', '222', NULL, 7, 'shopping, movies, sculpture', 'social, fun'),
(5, 'Linda', 'Kalafina', '23', 'Female', 'Gay', 12000, 'Casual', '222', NULL, 7, 'shopping, museum, beer', 'devoted'),
(6, 'Perfect', 'Human', '18', 'Female', 'Straight', 15213, 'Casual', '412', NULL, 7, 'karaoke', 'loving, kind, fun'),
(7, 'Perfect', 'Human', '24', 'Female', 'Straight', 22222, 'Casual', '412', NULL, 7, 'karaoke', 'loving, kind, fun');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Feedback`
--
ALTER TABLE `Feedback`
  ADD PRIMARY KEY (`feedback_id`);

--
-- Indexes for table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Feedback`
--
ALTER TABLE `Feedback`
  MODIFY `feedback_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `User`
--
ALTER TABLE `User`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


SELECT * FROM User 

SELECT * FROM search_result

drop table search_result

create table search_result(
	idx int(11) primary key auto_increment,
    user_id int(11),
    first_name varchar(45),
    last_name varchar(45),
    age int(11),
    gender varchar(45),
    sexual_orientation varchar(45),
    zip int(11),
    relationship_type varchar(45),
    attractiveness tinyint(1),
    hobby varchar(45),
    personality varchar(45))							
