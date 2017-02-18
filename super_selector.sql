-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 05, 2016 at 10:41 PM
-- Server version: 5.5.47-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `super_selector`
--

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

CREATE TABLE IF NOT EXISTS `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `code` varchar(100) NOT NULL,
  `logo` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `country`
--

INSERT INTO `country` (`id`, `name`, `code`, `logo`) VALUES
(1, 'India', 'IND', 'https://s.yimg.com/qx/cricket/fufp/images/india_flag_small-1-2-2011-19e94f1d1081d5dde82b381bf8c783b6'),
(2, 'South Africa', 'SA', 'https://s.yimg.com/qx/cricket/fufp/images/south_africa_flag_small-1-2-2011-52e6632a8c28d6b73e7e58369'),
(3, 'Australia', 'AUS', 'https://s.yimg.com/qx/cricket/fufp/images/australia_flag_small-1-2-2011-2801297b7b06aa33e14c9c031453'),
(4, 'Pakistan', 'PAK', 'https://s.yimg.com/qx/cricket/fufp/images/pakistan_flag_small-1-2-2011-5bbc7ebe24b9bc2460e131bfc9caf'),
(5, 'England', 'ENG', 'https://s.yimg.com/qx/cricket/fufp/images/england_flag_small-1-2-2011-6c19ffee31cd7fb50f75bafcac6e85'),
(6, 'New Zealand', 'NZ', 'https://s.yimg.com/qx/cricket/fufp/images/new_zealand_flag_small-1-2-2011-648a3001043e4d94a5eebd9dfe'),
(7, 'Sri Lanka', 'SL', 'https://s.yimg.com/qx/cricket/fufp/images/sri_lanka_flag_small-1-2-2011-4239d880b394fcc423a14234d1fa'),
(8, 'West Indies', 'WI', 'https://s.yimg.com/qx/cricket/fufp/images/west_indies_flag_small-1-2-2011-7f81c93235b1ea332d460c2877'),
(9, 'Bangladesh', 'BAN', 'https://s.yimg.com/qx/cricket/fufp/images/bangladesh_flag_small-1-2-2011-578103ec57a0fd8d6147f9e92b6'),
(10, 'Zimbabwe', 'ZIM', 'https://s.yimg.com/qx/cricket/fufp/images/zimbabwe_flag_small-1-2-2011-790452146c32bdcacd149e2789500');

-- --------------------------------------------------------

--
-- Table structure for table `groups`
--

CREATE TABLE IF NOT EXISTS `groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `created_by` int(11) NOT NULL,
  `created_on` datetime NOT NULL,
  `last_updated` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `matches`
--

CREATE TABLE IF NOT EXISTS `matches` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `venue` varchar(100) NOT NULL,
  `date` datetime NOT NULL,
  `series_id` int(11) NOT NULL,
  `country_id` int(11) NOT NULL,
  `squad_id_1` int(11) NOT NULL,
  `squad_id_2` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `squad1` (`squad_id_1`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=59 ;

--
-- Dumping data for table `matches`
--

INSERT INTO `matches` (`id`, `venue`, `date`, `series_id`, `country_id`, `squad_id_1`, `squad_id_2`) VALUES
(2, 'Mumbai', '2016-04-09 20:00:00', 1, 1, 6, 8),
(3, 'Kolkata', '2016-04-10 20:00:00', 1, 1, 1, 4),
(4, 'Mohali', '2016-04-11 20:00:00', 1, 1, 5, 7),
(5, 'Bengaluru', '2016-04-12 20:00:00', 1, 1, 3, 2),
(6, 'Kolkata', '2016-04-13 20:00:00', 1, 1, 1, 6),
(7, 'Rajkot', '2016-04-14 20:00:00', 1, 1, 6, 7),
(8, 'Delhi', '2016-04-15 20:00:00', 1, 1, 4, 5),
(9, 'Hyderabad', '2016-04-16 16:00:00', 1, 1, 2, 1),
(10, 'Mumbai', '2016-04-16 20:00:00', 1, 1, 6, 7),
(11, 'Mohali', '2016-04-17 16:00:00', 1, 1, 5, 8),
(12, 'Bengaluru', '2016-04-17 20:00:00', 1, 1, 3, 4),
(13, 'Hyderabad', '2016-04-18 20:00:00', 1, 1, 2, 6),
(14, 'Mohali', '2016-04-19 20:00:00', 1, 1, 5, 1),
(15, 'Mumbai', '2016-04-20 20:00:00', 1, 1, 6, 3),
(16, 'Rajkot', '2016-04-21 20:00:00', 1, 1, 7, 2),
(17, 'Pune', '2016-04-22 20:00:00', 1, 1, 8, 3),
(18, 'Delhi', '2016-04-23 16:00:00', 1, 1, 4, 6),
(19, 'Hyderabad', '2016-04-23 20:00:00', 1, 1, 2, 5),
(20, 'Rajkot', '2016-04-24 16:00:00', 1, 1, 7, 3),
(21, 'Pune', '2016-04-24 20:00:00', 1, 1, 8, 1),
(22, 'Mohali', '2016-04-25 20:00:00', 1, 1, 5, 6),
(23, 'Hyderabad', '2016-04-26 20:00:00', 1, 1, 2, 8),
(24, 'Delhi', '2016-04-27 20:00:00', 1, 1, 4, 7),
(25, 'Mumbai', '2016-04-28 20:00:00', 1, 1, 6, 1),
(26, 'Pune', '2016-04-29 20:00:00', 1, 1, 7, 8),
(27, 'Delhi', '2016-04-30 16:00:00', 1, 1, 4, 1),
(28, 'Hyderabad', '2016-04-30 20:00:00', 1, 1, 2, 3),
(29, 'Rajkot', '2016-05-01 16:00:00', 1, 1, 7, 5),
(30, 'Pune', '2016-05-01 20:00:00', 1, 1, 8, 6),
(31, 'Bengaluru', '2016-05-02 20:00:00', 1, 1, 3, 1),
(32, 'Rajkot', '2016-05-03 20:00:00', 1, 1, 7, 4),
(33, 'Kolkata', '2016-05-03 20:00:00', 1, 1, 1, 5),
(34, 'Delhi', '2016-05-05 20:00:00', 1, 1, 4, 8),
(35, 'Hyderabad', '2016-05-06 20:00:00', 1, 1, 2, 7),
(36, 'Bengaluru', '2016-05-07 16:00:00', 1, 1, 3, 8),
(37, 'Nagpur', '2016-05-07 20:00:00', 1, 1, 5, 4),
(38, 'Mumbai', '2016-05-08 16:00:00', 1, 1, 6, 2),
(39, 'Kolkata', '2016-05-08 20:00:00', 1, 1, 1, 7),
(40, 'Nagpur', '2016-05-09 20:00:00', 1, 1, 5, 3),
(41, 'Pune', '2016-05-10 20:00:00', 1, 1, 8, 2),
(42, 'Bengaluru', '2016-05-11 20:00:00', 1, 1, 3, 6),
(43, 'Hyderabad', '2016-05-12 20:00:00', 1, 1, 2, 4),
(44, 'Mumbai', '2016-05-13 20:00:00', 1, 1, 6, 5),
(45, 'Bengaluru', '2016-05-14 16:00:00', 1, 1, 3, 7),
(46, 'Kolkata', '2016-05-14 20:00:00', 1, 1, 1, 8),
(47, 'Mumbai', '2016-05-15 16:00:00', 1, 1, 6, 4),
(48, 'Nagpur', '2016-05-15 20:00:00', 1, 1, 5, 2),
(49, 'Kolkata', '2016-05-16 20:00:00', 1, 1, 1, 3),
(50, 'Pune', '2016-05-17 20:00:00', 1, 1, 8, 4),
(51, 'Bengaluru', '2016-05-18 20:00:00', 1, 1, 3, 5),
(52, 'Rajkot', '2016-05-19 20:00:00', 1, 1, 7, 1),
(53, 'Delhi', '2016-05-20 16:00:00', 1, 1, 4, 2),
(54, 'Pune', '2016-05-21 16:00:00', 1, 1, 8, 5),
(55, 'Rajkot', '2016-05-21 20:00:00', 1, 1, 7, 6),
(56, 'Kolkata', '2016-05-22 16:00:00', 1, 1, 1, 2),
(57, 'Raipur', '2016-05-22 20:00:00', 1, 1, 4, 3),
(58, 'test', '2016-03-13 10:00:00', 1, 1, 4, 3);

-- --------------------------------------------------------

--
-- Table structure for table `match_points`
--

CREATE TABLE IF NOT EXISTS `match_points` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `player_id` int(11) NOT NULL,
  `match_id` int(11) NOT NULL,
  `points` int(11) NOT NULL,
  `is_captain` tinyint(1) NOT NULL DEFAULT '0',
  `catches` int(11) NOT NULL DEFAULT '0',
  `runs` int(11) NOT NULL DEFAULT '0',
  `wickets` int(11) NOT NULL DEFAULT '0',
  `econ_rate` double NOT NULL DEFAULT '0',
  `strike_rate` double NOT NULL DEFAULT '0',
  `stumps` int(11) NOT NULL DEFAULT '0',
  `playerName` varchar(100) DEFAULT NULL,
  `matchName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique` (`user_id`,`player_id`,`match_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Dumping data for table `match_points`
--

INSERT INTO `match_points` (`id`, `user_id`, `player_id`, `match_id`, `points`, `is_captain`, `catches`, `runs`, `wickets`, `econ_rate`, `strike_rate`, `stumps`, `playerName`, `matchName`) VALUES
(16, 4, 21, 2, 0, 1, 0, 0, 0, 0, 0, 0, NULL, NULL),
(19, 1, 2, 3, 40, 0, 0, 0, 0, 0, 0, 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `players`
--

CREATE TABLE IF NOT EXISTS `players` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `squad_id` int(11) NOT NULL,
  `country_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=155 ;

--
-- Dumping data for table `players`
--

INSERT INTO `players` (`id`, `name`, `squad_id`, `country_id`) VALUES
(1, 'Virat Kohli', 3, 1),
(2, 'Shane Watson', 3, 3),
(3, 'AB de Villers', 3, 2),
(4, 'Samuel Badree', 3, 8),
(5, 'Chris Gayle', 3, 8),
(6, 'Kedar Jadhav', 3, 1),
(7, 'Varun Aaron', 3, 1),
(8, 'Iqbal Abdulla', 3, 1),
(9, 'Mandeep Singh', 3, 1),
(10, 'Stuart Binny', 3, 1),
(11, 'Sarfaraz khan', 3, 1),
(12, 'David Wiese', 3, 2),
(13, 'Mitchell Starc', 3, 3),
(14, 'Adam Milne', 3, 6),
(15, 'Kane Richordson', 3, 3),
(16, 'Travis Head', 3, 3),
(17, 'Sreenath Arvind', 3, 1),
(18, 'Yuzvendra Chahal', 3, 1),
(19, 'Harshal Patel', 3, 1),
(20, 'Gautam Gambhir', 1, 1),
(21, 'Morne Morkel', 1, 2),
(22, 'Andre Russel', 1, 8),
(23, 'Jason Holder', 1, 8),
(24, 'Umesh Yadav', 1, 1),
(25, 'Shakib Al Hasan', 1, 9),
(26, 'Yusuf Pathan', 1, 1),
(27, 'Piyush Chawla', 1, 1),
(28, 'Colin Munro', 1, 6),
(29, 'Jaydev Unadkat', 1, 1),
(30, 'Robin Uthappa', 1, 1),
(31, 'Chris Lynn', 1, 3),
(32, 'Piyush Chawla', 1, 1),
(33, 'Manish Pandey', 1, 1),
(34, 'Kuldeep Yadav', 1, 1),
(35, 'Brad Hogg', 1, 3),
(36, 'Sheldon Jackson', 1, 1),
(37, 'SuryaKumar Yadav', 1, 1),
(38, 'Sunil Narine', 1, 8),
(39, 'John Hstings', 1, 3),
(40, 'Manan Sharma', 1, 1),
(41, 'Rohit Sharma', 6, 1),
(42, 'Jos Butler', 6, 5),
(43, 'Harbhajan Singh', 6, 1),
(44, 'Kieron Pollard', 6, 8),
(45, 'Lendl Simmons', 6, 8),
(46, 'Tim Southee', 6, 6),
(47, 'Unmukt Chand', 6, 1),
(48, 'Ambati Rayadu', 6, 1),
(49, 'Lasith Malinga', 6, 7),
(50, 'Vinay Kumar', 6, 1),
(51, 'Mitchell McClenaghan', 6, 6),
(52, 'Parthiv Patel', 6, 1),
(53, 'Jasprit Bumrah', 6, 1),
(54, 'Corey Anderson', 6, 6),
(55, 'Marchant de Lange', 6, 2),
(56, 'Shreyas Gopal', 6, 1),
(57, 'Hardik Pandya', 6, 1),
(58, 'Akshay Wakhar', 6, 1),
(59, 'Jagdeesha Suchith', 6, 1),
(60, 'Siddesh Lad', 6, 1),
(61, 'Murali Vijay', 5, 1),
(62, 'Glenn Maxwell', 5, 3),
(63, 'Mitchell Johnson', 5, 3),
(64, 'Kyle Abbot', 5, 2),
(65, 'David Miller', 5, 2),
(66, 'Farhan Bahardein', 5, 2),
(67, 'Wriddhiman Saha', 5, 1),
(68, 'Mohit Sharma', 5, 1),
(69, 'Gurkeerat Mann Singh', 5, 1),
(70, 'Manan Vohra', 5, 1),
(71, 'Sandeep Sharma', 5, 1),
(72, 'Shaun Marsh', 5, 1),
(73, 'Akshar Patel', 5, 1),
(74, 'Rishi Dhawan', 5, 1),
(75, 'Marcus Stoinis', 5, 3),
(76, 'Swapnil Singh', 5, 2),
(77, 'Anureet Singh', 5, 2),
(78, 'KC Cariappa', 5, 1),
(79, 'Mahendra Singh Dhoni', 8, 1),
(80, 'Ishant Sharma', 8, 1),
(81, 'Ajinkya Rahane', 8, 1),
(82, 'Ashok Dinda', 8, 1),
(83, 'Kevin Pietersen', 8, 5),
(84, 'Steven Smith', 8, 3),
(85, 'Faf du Plesis', 8, 3),
(86, 'Baba Aprajith', 8, 1),
(87, 'Irfan Pathan', 8, 1),
(88, 'RP Singh', 8, 1),
(89, 'Thisara Parera', 8, 1),
(90, 'Rajat Bhatia ', 8, 1),
(91, 'Ankit Sharma', 8, 1),
(92, 'Ishwar Pandey', 8, 1),
(93, 'Mitchell Marsh', 8, 3),
(94, 'Scott Boland', 8, 3),
(95, 'RaviChandran Ashwin', 8, 1),
(96, 'Adam Zampa', 8, 3),
(97, 'Ankush Bains', 8, 1),
(98, 'Suresh Raina', 7, 1),
(99, 'Ravindra Jadeja', 7, 1),
(100, 'Dale Steyn', 7, 2),
(101, 'Dwayne Bravo', 7, 8),
(102, 'Brendon McCullum', 7, 6),
(103, 'Shadab Jakati', 7, 1),
(104, 'Pradeep Sangwan', 7, 1),
(105, 'Sarabjit Ladda', 7, 1),
(106, 'Praveen Kumar', 7, 1),
(107, 'Dinesh Kartik', 7, 1),
(108, 'Dhawal Kulkarni', 7, 1),
(109, 'Dwayne Smith', 7, 8),
(110, 'James Faulkner', 7, 3),
(111, 'Pravin Tambe', 7, 1),
(112, 'Aaron Finch', 7, 3),
(113, 'Amit Mishra', 7, 1),
(114, 'Andrew Tye', 7, 3),
(115, 'Ishan Kishan', 7, 1),
(116, 'Bhuvneshwar Kumar Singh', 2, 1),
(117, 'Yuvraj Singh', 2, 1),
(118, 'Eoin Morgan', 2, 5),
(119, 'Shikhar Dhawan', 2, 1),
(120, 'David Warner', 2, 3),
(121, 'Ashish Nehra', 2, 1),
(122, 'Kane Willamson', 2, 6),
(123, 'Moises Henriques', 2, 3),
(124, 'Trent Bolt', 2, 6),
(125, 'Naman Ojha', 2, 1),
(126, 'Siddhath Kaul', 2, 1),
(127, 'Brainder Sran', 2, 1),
(128, 'Deepak Hooda', 2, 1),
(129, 'Ben Cutting', 2, 3),
(130, 'Abhimanyu Mithun', 2, 1),
(131, 'Aditya Tare', 2, 1),
(132, 'Parvez Rasool', 2, 1),
(133, 'Karan Sharma', 2, 1),
(134, 'Lokesh Rahul', 2, 1),
(135, 'Mohammed Shami', 4, 1),
(136, 'Amit Mishra', 4, 1),
(137, 'Imran Tahir', 4, 2),
(138, 'Quinton de Kock', 4, 2),
(139, 'Albie Morkel', 4, 2),
(140, 'Chris Morris', 4, 2),
(141, 'Pawan Negi', 4, 1),
(142, 'Shahbaz Nadeem', 4, 1),
(143, 'Nathan Coulter Nile', 4, 3),
(144, 'Pawan Suyal', 4, 1),
(145, 'Karun Nayar', 4, 1),
(146, 'Myank Agarwal', 4, 1),
(147, 'Saurabh Tiwary', 4, 1),
(148, 'Zaheer Khan', 4, 1),
(149, 'JP Duminy', 4, 2),
(150, 'Sanju Samson', 4, 2),
(151, 'Carlos Brathwaite', 4, 8),
(152, 'Joel Paris', 4, 3),
(153, 'Jayant Yadav', 4, 1),
(154, 'Rishabh Pant', 4, 1);

-- --------------------------------------------------------

--
-- Table structure for table `series`
--

CREATE TABLE IF NOT EXISTS `series` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `country_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `series`
--

INSERT INTO `series` (`id`, `name`, `country_id`) VALUES
(1, 'IPL', 1);

-- --------------------------------------------------------

--
-- Table structure for table `squads`
--

CREATE TABLE IF NOT EXISTS `squads` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `series_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `logo` varchar(100) NOT NULL,
  `shortName` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `squads`
--

INSERT INTO `squads` (`id`, `series_id`, `name`, `logo`, `shortName`) VALUES
(1, 1, 'Kolkata Knight Riders', '', 'KKR'),
(2, 1, 'Sunrisers Hyderabad', '', 'SRH'),
(3, 1, 'Royal Challengers Bangalore', '', 'RCB'),
(4, 1, 'Delhi Daredevils', '', 'DD'),
(5, 1, 'Kings X1 Punjab', '', 'KX1P'),
(6, 1, 'Mumbai Indians', '', 'MI'),
(7, 1, 'Gujarat Lions', '', 'GL'),
(8, 1, 'Rising Pune Supergiants', '', 'RPS');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `country_id` int(11) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  `group_id` int(11) NOT NULL DEFAULT '0',
  `nickName` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nickName` (`nickName`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `mobile`, `password`, `country_id`, `city`, `state`, `group_id`, `nickName`) VALUES
(4, 'saurabh kumar', 'ab@a.b', '919900811610', '123', 0, NULL, NULL, 0, 'saurabh'),
(6, 'saurabh kumar', 'abc@a.b', '919900811611', '1234', 0, NULL, NULL, 0, 'saurabh1');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
