-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 04-Abr-2019 às 15:09
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
-- Database: `projetoNeilon1`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cadastroDespesa`
--

CREATE TABLE `cadastroDespesa` (
  `idDespesa` int(11) NOT NULL,
  `tipoCobranca` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `moeda` varchar(15) NOT NULL,
  `vencimento` date NOT NULL,
  `titularFatura` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cadastroRenda`
--

CREATE TABLE `cadastroRenda` (
  `idRenda` int(11) NOT NULL,
  `origemRenda` varchar(30) NOT NULL,
  `valor` int(11) NOT NULL,
  `data` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `conta`
--

CREATE TABLE `conta` (
  `idConta` int(11) NOT NULL,
  `banco` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `tipoConta` int(11) NOT NULL,
  `agencia` int(11) NOT NULL,
  `codigoOrdenacao` int(11) NOT NULL,
  `titularConta` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `contatos`
--

CREATE TABLE `contatos` (
  `idContatos` int(11) NOT NULL,
  `telefoneResidencial` varchar(20) NOT NULL,
  `celular` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `telefoneComercial` varchar(20) DEFAULT NULL,
  `idPessoa_fk` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `contatos`
--

INSERT INTO `contatos` (`idContatos`, `telefoneResidencial`, `celular`, `email`, `telefoneComercial`, `idPessoa_fk`) VALUES
(12, 'jlk', 'lkj', 'kj', NULL, 12),
(13, 'jlk', 'lkj', 'kj', NULL, 13),
(15, 'kjh', 'kjh', 'kjh', NULL, 15),
(17, 'kjh', 'kjh', 'kjh', NULL, 17),
(18, 'kjh', 'kjh', 'kjh', NULL, 18),
(19, 'klj', 'klj', 'klj', NULL, 19),
(35, 'hkjhkj', 'hkhkjjh', 'kjh', NULL, 35),
(37, 'hkjhkj', 'hkhkjjh', 'kjh', NULL, 37),
(38, 'hkjhkj', 'hkhkjjh', 'kjh', NULL, 38),
(39, 'hkjhkj', 'hkhkjjh', 'kjh', NULL, 39),
(40, 'hkjhkj', 'hkhkjjh', 'kjh', NULL, 40),
(41, 'hkjhkj', 'hkhkjjh', 'kjh', NULL, 41),
(42, 'hkjhkj', 'hkhkjjh', 'kjh', NULL, 42),
(43, 'hkjhkj', 'hkhkjjh', 'kjh', NULL, 43),
(44, 'lj', 'lj', 'lj', NULL, 44),
(45, 'khk', 'kh', 'hkh', NULL, 45),
(46, 'kjlkj', 'kljklj', 'lkkj', NULL, 46);

-- --------------------------------------------------------

--
-- Estrutura da tabela `contrato`
--

CREATE TABLE `contrato` (
  `idContrato` int(11) NOT NULL,
  `dataInicio` date NOT NULL,
  `dataFim` date NOT NULL,
  `clubeOrigem` varchar(30) NOT NULL,
  `idPessoa_fk` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `complemento` varchar(30) DEFAULT NULL,
  `cep` varchar(30) NOT NULL,
  `idPessoa_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`idEndereco`, `rua`, `numero`, `bairro`, `cidade`, `estado`, `pais`, `complemento`, `cep`, `idPessoa_fk`) VALUES
(12, 'lkj', 'lkj', 'lkj', 'klj', 'Minas Gerais', 'Item 1', 'klj', 'lkj', 12),
(13, 'lkj', 'lkj', 'lkj', 'klj', 'Minas Gerais', 'Item 1', 'klj', 'lkj', 13),
(15, 'kjh', 'kjh', 'hkj', 'kjh', 'Minas Gerais', 'Item 1', 'kj', 'h', 15),
(17, 'kjh', 'kjh', 'hkj', 'kjh', 'Minas Gerais', 'Item 1', 'kj', 'h', 17),
(18, 'kjh', 'kjh', 'hkj', 'kjh', 'Minas Gerais', 'Item 1', 'kj', 'h', 18),
(19, 'klj', 'lkj', 'lkj', 'llll', 'Minas Gerais', 'Item 1', 'klj', 'klj', 19),
(35, 'kh', 'kh', 'kh', 'kjh', 'kjh', 'kjh', 'Item 1', 'Item 1', 35),
(37, 'kh', 'kh', 'kh', 'kjh', 'kjh', 'kjh', 'Item 1', 'Item 1', 37),
(38, 'kh', 'kh', 'kh', 'kjh', 'kjh', 'kjh', 'Item 1', 'Item 1', 38),
(39, 'kh', 'kh', 'kh', 'kjh', 'kjh', 'kjh', 'Item 1', 'Item 1', 39),
(40, 'kh', 'kh', 'kh', 'kjh', 'kjh', 'kjh', 'Item 1', 'Item 1', 40),
(41, 'kh', 'kh', 'kh', 'kjh', 'kjh', 'kjh', 'Item 1', 'Item 1', 41),
(42, 'kh', 'kh', 'kh', 'kjh', 'kjh', 'kjh', 'Item 1', 'Item 1', 42),
(43, 'kh', 'kh', 'kh', 'kjh', 'kjh', 'kjh', 'Item 1', 'Item 1', 43),
(44, 'lj', 'lj', 'lkj', 'lj', 'Minas Gerais', 'Item 1', 'lkj', 'lkj', 44),
(45, 'hkj', 'hkj', 'h', 'kjj', 'Minas Gerais', 'Item 1', 'hk', 'kjh', 45),
(46, 'lkj', 'lj', 'lj', 'lkk', 'lkkj', 'lkj', 'Item 1', 'Item 1', 46);

-- --------------------------------------------------------

--
-- Estrutura da tabela `informacoesMedicas`
--

CREATE TABLE `informacoesMedicas` (
  `idInfMedica` int(11) NOT NULL,
  `dataUltimaRevisao` date NOT NULL,
  `dataProximaRevisao` date NOT NULL,
  `restricaoMedicamento` varchar(500) DEFAULT NULL,
  `informacoesMedica` varchar(500) DEFAULT NULL,
  `tipoSanguinio` varchar(15) DEFAULT NULL,
  `idJogador_fk` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `jogador`
--

CREATE TABLE `jogador` (
  `idJogador` int(11) NOT NULL,
  `categoria` varchar(15) NOT NULL,
  `nomeEmpresario` varchar(30) NOT NULL,
  `posicao` varchar(15) NOT NULL,
  `peso` double NOT NULL,
  `altura` double NOT NULL,
  `assiatencia` int(11) DEFAULT NULL,
  `mediaGols` double DEFAULT NULL,
  `idPessoa_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `jogador`
--

INSERT INTO `jogador` (`idJogador`, `categoria`, `nomeEmpresario`, `posicao`, `peso`, `altura`, `assiatencia`, `mediaGols`, `idPessoa_fk`) VALUES
(12, 'klj', 'klj', 'klj', 9, 9, NULL, NULL, 12),
(13, 'klj', 'klj', 'klj', 9, 9, NULL, NULL, 13),
(15, 'jh', 'kjh', '8', 88, 88, NULL, NULL, 15),
(17, 'jh', 'kjh', '8', 88, 88, NULL, NULL, 17),
(18, 'jh', 'kjh', '8', 88, 88, NULL, NULL, 18),
(19, 'kj', 'klj', '9kj', 9, 9, NULL, NULL, 19),
(20, 'lkj', 'lkj', 'kj', 9, 9, NULL, NULL, 44),
(21, 'hkj', 'hkh', 'jhkj', 8, 8, NULL, NULL, 45);

-- --------------------------------------------------------

--
-- Estrutura da tabela `patrocinador`
--

CREATE TABLE `patrocinador` (
  `idPatrocinador` int(11) NOT NULL,
  `razaoSocial` varchar(30) NOT NULL,
  `cmpj` varchar(30) NOT NULL,
  `inscricaoEstadual` varchar(30) NOT NULL,
  `inscricaoMunicipal` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE `pessoa` (
  `idPessoa` int(11) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `sobrenome` varchar(30) NOT NULL,
  `nacionalidade` varchar(30) NOT NULL,
  `rg` varchar(15) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `dataNascimento` date NOT NULL,
  `escolaridade` varchar(45) NOT NULL,
  `instituicao` varchar(45) NOT NULL,
  `sexo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`idPessoa`, `nome`, `sobrenome`, `nacionalidade`, `rg`, `cpf`, `dataNascimento`, `escolaridade`, `instituicao`, `sexo`) VALUES
(12, 'bbbb', 'jklj', 'lkj', 'lkj', 'lkj', '2018-03-03', 'klj', 'lkjlk', 'Masculono'),
(13, 'ccccc', 'jklj', 'lkj', 'lkj', '5342552', '2017-03-04', 'klj', 'lkjlk', 'Masculono'),
(15, 'ddddddddd', 'hjkjshdfsdkjh', 'jkhkjh', 'kh', 'kh', '2019-03-07', 'kjh', 'kjh', 'Masculono'),
(17, 'kkjklj', 'hjkjshdfsdkjh', 'jkhkjh', 'kh', 'kh', '2016-03-11', 'kjh', 'kjh', 'Masculono'),
(18, 'kkjklj', 'hjkjshdfsdkjh', 'jkhkjh', 'kh', 'kh', '2019-03-07', 'kjh', 'kjh', 'Masculono'),
(19, 'lllll', 'kjlk', 'kjlkj', 'kl', 'jlk', '2018-04-06', 'jlk', 'j', 'Masculono'),
(35, 'jkhkj', 'kjh', 'jk', 'kj', '21', '2019-04-03', 'jkh', 'jkh', 'Selecione,'),
(37, 'jkhkj', 'kjh', 'jk', 'kj', '43', '2019-04-03', 'jkh', 'jkh', 'Selecione,'),
(38, 'jkhkj', 'kjh', 'jk', 'kj', '432', '2019-04-03', 'jkh', 'jkh', 'Selecione,'),
(39, 'jkhkj', 'kjh', 'jk', 'kj', '431', '2019-04-03', 'jkh', 'jkh', 'Selecione,'),
(40, 'jkhkj', 'kjh', 'jk', 'kj', '435', '2019-04-03', 'jkh', 'jkh', 'Selecione,'),
(41, 'jkhkj', 'kjh', 'jk', 'kj', '4321', '2019-04-03', 'jkh', 'jkh', 'Selecione,'),
(42, 'jkhkj', 'kjh', 'jk', 'kj', '23465', '2019-04-03', 'jkh', 'jkh', 'Selecione,'),
(43, 'jkhkj', 'kjh', 'jk', 'kj', '352', '2019-04-03', 'jkh', 'jkh', 'Selecione,'),
(44, 'kjlkj', 'kljlj', 'jlj', 'lkj', 'lkj', '2019-04-01', 'lkj', 'lkj', 'Masculono'),
(45, 'jkhkjh', 'jkhkjh', 'jkh', 'kjh', 'kjh', '2019-03-02', 'kjjh', 'kjjh', 'Masculono'),
(46, 'kj', 'klj', 'kkj', 'lkj', 'lj', '2019-03-03', 'jklkj', 'lkj', 'Selecione,');

-- --------------------------------------------------------

--
-- Estrutura da tabela `socioTorcedor`
--

CREATE TABLE `socioTorcedor` (
  `idSocioTorcedor` int(11) NOT NULL,
  `modalidadeTorcedor` varchar(30) NOT NULL,
  `dataFiliacao` date NOT NULL,
  `formaPagamento` varchar(30) NOT NULL,
  `idPessoa_fk` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `socioTorcedor`
--

INSERT INTO `socioTorcedor` (`idSocioTorcedor`, `modalidadeTorcedor`, `dataFiliacao`, `formaPagamento`, `idPessoa_fk`) VALUES
(15, 'básico ', '2019-04-05', 'Item 1', 35),
(17, 'básico ', '2019-04-05', 'Item 1', 37),
(18, 'básico ', '2019-04-05', 'Item 1', 38),
(19, 'básico ', '2019-04-05', 'Item 1', 39),
(20, 'básico ', '2019-04-05', 'Item 1', 40),
(21, 'básico ', '2019-04-05', 'Item 1', 41),
(22, 'básico ', '2019-04-05', 'Item 1', 42),
(23, 'básico ', '2019-04-05', 'Item 1', 43),
(24, 'básico ', '2019-04-01', 'Item 1', 46);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cadastroDespesa`
--
ALTER TABLE `cadastroDespesa`
  ADD PRIMARY KEY (`idDespesa`),
  ADD UNIQUE KEY `idDespesa` (`idDespesa`);

--
-- Indexes for table `cadastroRenda`
--
ALTER TABLE `cadastroRenda`
  ADD PRIMARY KEY (`idRenda`),
  ADD UNIQUE KEY `idRenda` (`idRenda`);

--
-- Indexes for table `conta`
--
ALTER TABLE `conta`
  ADD PRIMARY KEY (`idConta`),
  ADD UNIQUE KEY `idConta` (`idConta`);

--
-- Indexes for table `contatos`
--
ALTER TABLE `contatos`
  ADD PRIMARY KEY (`idContatos`),
  ADD UNIQUE KEY `idContatos` (`idContatos`),
  ADD KEY `idPessoa_fk` (`idPessoa_fk`);

--
-- Indexes for table `contrato`
--
ALTER TABLE `contrato`
  ADD PRIMARY KEY (`idContrato`),
  ADD UNIQUE KEY `idContrato` (`idContrato`),
  ADD KEY `idPessoa_fk` (`idPessoa_fk`);

--
-- Indexes for table `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`idEndereco`),
  ADD UNIQUE KEY `idEndereco` (`idEndereco`),
  ADD KEY `idPessoa_fk` (`idPessoa_fk`);

--
-- Indexes for table `informacoesMedicas`
--
ALTER TABLE `informacoesMedicas`
  ADD PRIMARY KEY (`idInfMedica`),
  ADD UNIQUE KEY `idInfMedica` (`idInfMedica`),
  ADD KEY `idJogador_fk` (`idJogador_fk`);

--
-- Indexes for table `jogador`
--
ALTER TABLE `jogador`
  ADD PRIMARY KEY (`idJogador`),
  ADD UNIQUE KEY `idJogador` (`idJogador`),
  ADD KEY `idPessoa_fk` (`idPessoa_fk`);

--
-- Indexes for table `patrocinador`
--
ALTER TABLE `patrocinador`
  ADD PRIMARY KEY (`idPatrocinador`),
  ADD UNIQUE KEY `idPatrocinador` (`idPatrocinador`);

--
-- Indexes for table `pessoa`
--
ALTER TABLE `pessoa`
  ADD PRIMARY KEY (`idPessoa`),
  ADD UNIQUE KEY `idPessoa` (`idPessoa`);

--
-- Indexes for table `socioTorcedor`
--
ALTER TABLE `socioTorcedor`
  ADD PRIMARY KEY (`idSocioTorcedor`),
  ADD UNIQUE KEY `idSocioTorcedor` (`idSocioTorcedor`),
  ADD KEY `idPessoa_fk` (`idPessoa_fk`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cadastroDespesa`
--
ALTER TABLE `cadastroDespesa`
  MODIFY `idDespesa` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `cadastroRenda`
--
ALTER TABLE `cadastroRenda`
  MODIFY `idRenda` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `conta`
--
ALTER TABLE `conta`
  MODIFY `idConta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `contatos`
--
ALTER TABLE `contatos`
  MODIFY `idContatos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT for table `contrato`
--
ALTER TABLE `contrato`
  MODIFY `idContrato` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `endereco`
--
ALTER TABLE `endereco`
  MODIFY `idEndereco` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT for table `informacoesMedicas`
--
ALTER TABLE `informacoesMedicas`
  MODIFY `idInfMedica` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `jogador`
--
ALTER TABLE `jogador`
  MODIFY `idJogador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `patrocinador`
--
ALTER TABLE `patrocinador`
  MODIFY `idPatrocinador` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pessoa`
--
ALTER TABLE `pessoa`
  MODIFY `idPessoa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT for table `socioTorcedor`
--
ALTER TABLE `socioTorcedor`
  MODIFY `idSocioTorcedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `contatos`
--
ALTER TABLE `contatos`
  ADD CONSTRAINT `contatos_ibfk_1` FOREIGN KEY (`idPessoa_fk`) REFERENCES `pessoa` (`idPessoa`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `contrato`
--
ALTER TABLE `contrato`
  ADD CONSTRAINT `contrato_ibfk_1` FOREIGN KEY (`idPessoa_fk`) REFERENCES `pessoa` (`idPessoa`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `endereco`
--
ALTER TABLE `endereco`
  ADD CONSTRAINT `endereco_ibfk_1` FOREIGN KEY (`idPessoa_fk`) REFERENCES `pessoa` (`idPessoa`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `informacoesMedicas`
--
ALTER TABLE `informacoesMedicas`
  ADD CONSTRAINT `informacoesMedicas_ibfk_1` FOREIGN KEY (`idJogador_fk`) REFERENCES `jogador` (`idJogador`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `jogador`
--
ALTER TABLE `jogador`
  ADD CONSTRAINT `jogador_ibfk_1` FOREIGN KEY (`idPessoa_fk`) REFERENCES `pessoa` (`idPessoa`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `socioTorcedor`
--
ALTER TABLE `socioTorcedor`
  ADD CONSTRAINT `socioTorcedor_ibfk_1` FOREIGN KEY (`idPessoa_fk`) REFERENCES `pessoa` (`idPessoa`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
