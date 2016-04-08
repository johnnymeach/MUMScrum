-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 08, 2016 at 07:40 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `mumscrum_prod`
--

-- --------------------------------------------------------

--
-- Table structure for table `projects`
--

CREATE TABLE IF NOT EXISTS `projects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `description` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `status` tinyint(1) DEFAULT '1',
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_id_idx` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(256) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `name`, `description`, `status`) VALUES
(1, 'Developer', 'The developer in our company.', 1),
(2, 'Scrum Master', 'The Scrum Master for our project.', 1),
(3, 'System Admin', 'The administrator in our system to manage users.', 1),
(4, 'Product Owner', 'The owner of our project.', 1);

-- --------------------------------------------------------

--
-- Table structure for table `sprints`
--

CREATE TABLE IF NOT EXISTS `sprints` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `description` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `status` tinyint(1) DEFAULT '1',
  `project_id` int(11) DEFAULT NULL,
  `assignedDate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_project_id_idx` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `timelogs`
--

CREATE TABLE IF NOT EXISTS `timelogs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `duration` int(11) DEFAULT NULL,
  `userstory_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `updatedDate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_userstory_id_idx` (`userstory_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `lastName` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '1',
  `token` varchar(256) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_role_id_idx` (`role_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `firstName`, `lastName`, `email`, `password`, `status`, `token`, `role_id`) VALUES
(1, 'Sokly', 'Meach', 'meachsokly@gmail.com', '$2a$10$bJ3lCLfd.VaIlDYdDmw/jO4YLSgeWUIiO2lVWgcxixthB73CfCYW.', 1, NULL, 3);

-- --------------------------------------------------------

--
-- Table structure for table `userstory`
--

CREATE TABLE IF NOT EXISTS `userstory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `description` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `estimatedTime` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '1',
  `sprint_id` int(11) DEFAULT NULL,
  `assignedDate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sprint_id_idx` (`sprint_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `projects`
--
ALTER TABLE `projects`
  ADD CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `sprints`
--
ALTER TABLE `sprints`
  ADD CONSTRAINT `fk_project_id` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `timelogs`
--
ALTER TABLE `timelogs`
  ADD CONSTRAINT `fk_userstory_id` FOREIGN KEY (`userstory_id`) REFERENCES `userstory` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `userstory`
--
ALTER TABLE `userstory`
  ADD CONSTRAINT `fk_sprint_id` FOREIGN KEY (`sprint_id`) REFERENCES `sprints` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
