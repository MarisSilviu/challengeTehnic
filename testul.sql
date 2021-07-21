-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 21, 2021 at 05:29 PM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `testul`
--

-- --------------------------------------------------------

--
-- Table structure for table `angajat`
--

CREATE TABLE `angajat` (
  `idAngajat` int(5) NOT NULL,
  `nume` varchar(35) NOT NULL,
  `functie` varchar(35) NOT NULL,
  `dataAngajarii` date NOT NULL,
  `departament` varchar(35) NOT NULL,
  `superior` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `angajat`
--

INSERT INTO `angajat` (`idAngajat`, `nume`, `functie`, `dataAngajarii`, `departament`, `superior`) VALUES
(1, 'Andreea Maria', 'Statistician', '2021-07-21', 'Marketing', 'Marius Moldovan'),
(2, 'Marius Moldovan', 'Programator', '2013-10-25', 'Software', 'Alin Costea'),
(3, 'Maria Averescu', 'Programator', '2018-05-16', 'Software', 'Alin Costea'),
(4, 'Vasile Marica', 'Contabil', '2020-03-24', 'Financiar', 'Magda Oprea');

-- --------------------------------------------------------

--
-- Table structure for table `concediu`
--

CREATE TABLE `concediu` (
  `idConcediu` int(11) NOT NULL,
  `nume` varchar(35) NOT NULL,
  `dataInceput` date NOT NULL,
  `dataFinal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `concediu`
--

INSERT INTO `concediu` (`idConcediu`, `nume`, `dataInceput`, `dataFinal`) VALUES
(2, 'Maria Averescu', '2021-07-31', '2021-09-01'),
(3, 'Marcel Inlocuitor', '2021-07-16', '2021-07-29');

-- --------------------------------------------------------

--
-- Table structure for table `departament`
--

CREATE TABLE `departament` (
  `idDepartament` int(11) NOT NULL,
  `numeDepartament` varchar(35) NOT NULL,
  `director` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `departament`
--

INSERT INTO `departament` (`idDepartament`, `numeDepartament`, `director`) VALUES
(1, 'Marketing', 'Sorina Popescu'),
(2, 'Software', 'Alin Costea'),
(3, 'Financiar', 'Magda Oprea');

-- --------------------------------------------------------

--
-- Table structure for table `functie`
--

CREATE TABLE `functie` (
  `idFunctie` int(11) NOT NULL,
  `numeFunctie` varchar(35) NOT NULL,
  `salariuBaza` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `functie`
--

INSERT INTO `functie` (`idFunctie`, `numeFunctie`, `salariuBaza`) VALUES
(1, 'Statistician', 2000),
(2, 'Programator', 5000),
(3, 'Contabil', 3000);

-- --------------------------------------------------------

--
-- Table structure for table `proiect`
--

CREATE TABLE `proiect` (
  `idProiect` int(11) NOT NULL,
  `numeProiect` varchar(35) NOT NULL,
  `membru` varchar(35) NOT NULL,
  `dataInceput` date NOT NULL,
  `deadline` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `proiect`
--

INSERT INTO `proiect` (`idProiect`, `numeProiect`, `membru`, `dataInceput`, `deadline`) VALUES
(517, 'Challenge tehnic', 'Vasile Marica', '2021-07-14', '2021-07-24');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `angajat`
--
ALTER TABLE `angajat`
  ADD PRIMARY KEY (`idAngajat`);

--
-- Indexes for table `concediu`
--
ALTER TABLE `concediu`
  ADD PRIMARY KEY (`idConcediu`);

--
-- Indexes for table `departament`
--
ALTER TABLE `departament`
  ADD PRIMARY KEY (`idDepartament`);

--
-- Indexes for table `functie`
--
ALTER TABLE `functie`
  ADD PRIMARY KEY (`idFunctie`);

--
-- Indexes for table `proiect`
--
ALTER TABLE `proiect`
  ADD PRIMARY KEY (`idProiect`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `angajat`
--
ALTER TABLE `angajat`
  MODIFY `idAngajat` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `concediu`
--
ALTER TABLE `concediu`
  MODIFY `idConcediu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `departament`
--
ALTER TABLE `departament`
  MODIFY `idDepartament` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `functie`
--
ALTER TABLE `functie`
  MODIFY `idFunctie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `proiect`
--
ALTER TABLE `proiect`
  MODIFY `idProiect` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=551;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
