-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 13-Mar-2019 às 14:33
-- Versão do servidor: 10.1.37-MariaDB
-- versão do PHP: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projetoNeilo`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `idEndereco` int(11) NOT NULL,
  `rua` varchar(30) NOT NULL,
  `numero` varchar(30) NOT NULL,
  `bairro` varchar(30) NOT NULL,
  `cidade` varchar(30) NOT NULL,
  `estado` varchar(30) NOT NULL,
  `pais` varchar(30) NOT NULL,
  `complemento` varchar(30) NOT NULL,
  `cep` varchar(30) NOT NULL,
  `idPessoa_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`idEndereco`, `rua`, `numero`, `bairro`, `cidade`, `estado`, `pais`, `complemento`, `cep`, `idPessoa_fk`) VALUES
(33, 'yyy', 'yyy', 'yyy', 'yyy', 'Minas Gerais', 'Item 1', 'yyy', 'yy', 45),
(34, '203', '264', 'dona marroca', 'ibia', 'Minas Gerais', 'Item 1', '', '38950000', 47),
(35, 'ttt', 'ttt', 'ttt', 'ttt', 'Minas Gerais', 'Item 1', 'ttt', 'ttt', 48),
(36, '60', '753', 'sao benedito', 'ibia', 'Minas Gerais', 'Item 1', 'casa', '38950000', 49),
(37, '88', '78', 'nossa senhora de lurder', 'ibia', 'Minas Gerais', 'Item 1', 'casa', '38950000', 50),
(38, '189', '888', 'risoleta', 'ibia', 'Minas Gerais', 'Item 1', 'casa', '38950000', 51),
(39, '88', '99', 'sao benedito', 'ibia', 'Minas Gerais', 'Item 1', 'casa', '99112221', 52),
(40, '300', '500', 'sao benedito', 'ibia', 'Minas Gerais', 'Item 1', 'casa', '998880000', 53);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`idEndereco`),
  ADD KEY `idPessoa_fk` (`idPessoa_fk`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `endereco`
--
ALTER TABLE `endereco`
  MODIFY `idEndereco` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
