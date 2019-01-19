-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: 19-Jan-2019 às 04:10
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
  `numeroConta` int(11) NOT NULL,
  `tipoConta` int(11) NOT NULL,
  `agencia` int(11) NOT NULL,
  `codigoOrdenacao` int(11) NOT NULL,
  `titularConta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `contatos`
--

CREATE TABLE `contatos` (
  `idContatos` int(11) NOT NULL,
  `telefoneResidencial` varchar(20) NOT NULL,
  `celular` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `telefoneComercial` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `contatos`
--

INSERT INTO `contatos` (`idContatos`, `telefoneResidencial`, `celular`, `email`, `telefoneComercial`) VALUES
(1, '87897', '98798798', 'uyiuyiu', NULL),
(2, '87897', '98798798', 'uyiuyiu', NULL),
(3, '87897', '98798798', 'uyiuyiu', NULL),
(4, '0998098', '9009', 'kljlkjlkj', NULL),
(5, '0998098', '9009', 'kljlkjlkj', NULL),
(6, '0998098', '9009', 'kljlkjlkj', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `contrato`
--

CREATE TABLE `contrato` (
  `idContrato` int(11) NOT NULL,
  `dataInicio` date NOT NULL,
  `dataFim` date NOT NULL,
  `clubeOrigem` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `idEndereco` int(11) NOT NULL,
  `rua` varchar(30) NOT NULL,
  `numero` int(11) NOT NULL,
  `bairro` varchar(30) NOT NULL,
  `cidade` varchar(30) NOT NULL,
  `estado` varchar(30) NOT NULL,
  `pais` varchar(30) NOT NULL,
  `complemento` varchar(30) NOT NULL,
  `cep` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`idEndereco`, `rua`, `numero`, `bairro`, `cidade`, `estado`, `pais`, `complemento`, `cep`) VALUES
(1, '203', 264, 'marroca', 'ibia', 'Minas Gerais', 'Item 3', '-', 38950000),
(2, 'kjdfk', 323, 'akjakjd', 'ima,dkj', 'Minas Gerais', 'Item 1', '', 832983),
(3, 'jakjdak', 898, 'hjhkh', 'isdjiaj', 'Minas Gerais', 'Item 1', '', 78897),
(4, 'jkhk', 1231, 'jkhkj', 'jkjk', 'Minas Gerais', 'Item 1', 'jkkhk', 8987),
(5, 'jhjk', 8988, 'jhkj', 'jhjkh', 'Minas Gerais', 'Item 1', 'jhkjh', 78979),
(6, 'uyjkh', 987, 'kjhkh', 'hkh', 'Minas Gerais', 'Item 1', 'hkh', 89879),
(7, 'ewewr', 43432, 'gfghg', 'trefdg', 'Minas Gerais', 'Item 1', 'fgdgd', 35434),
(8, 'jhkh', 897, 'jkjhk', 'jhkh', 'Minas Gerais', 'Item 1', 'jkhk', 8970),
(9, 'kjhkh', 87, 'jhkj', 'jhkh', 'Minas Gerais', 'Item 1', 'kjhkj', 89879),
(10, 'kjhkh', 87, 'jhkj', 'jhkh', 'Minas Gerais', 'Item 1', 'kjhkj', 89879),
(11, 'kjhkh', 87, 'jhkj', 'jhkh', 'Minas Gerais', 'Item 1', 'kjhkj', 89879),
(12, 'kjhkh', 87, 'jhkj', 'jhkh', 'Minas Gerais', 'Item 1', 'kjhkj', 89879),
(13, 'kjkj', 989, 'jkjkj', 'kjkj', 'Minas Gerais', 'Item 1', '', 9898),
(14, 'hkhkj', 8989, 'jhkjh', 'jkhkhl', 'Minas Gerais', 'Item 1', 'jhkjh', 89800),
(15, 'kjljl', 9809, 'kljlkj', 'kljlj', 'Minas Gerais', 'Item 1', '', 808),
(16, 'kjljl', 9809, 'kljlkj', 'kljlj', 'Minas Gerais', 'Item 1', '', 808),
(17, 'kjljl', 9809, 'kljlkj', 'kljlj', 'Minas Gerais', 'Item 1', '', 10808);

-- --------------------------------------------------------

--
-- Estrutura da tabela `informacoesMedicas`
--

CREATE TABLE `informacoesMedicas` (
  `idInfMedica` int(11) NOT NULL,
  `dataUltimaRevisao` date NOT NULL,
  `dataProximaRevisao` date NOT NULL,
  `restrisaoMedicamento` varchar(50) NOT NULL,
  `informacaoMedica` varchar(50) NOT NULL,
  `tipoSanguinio` varchar(15) NOT NULL
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
  `assistencia` int(11) DEFAULT NULL,
  `mediaGols` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `jogador`
--

INSERT INTO `jogador` (`idJogador`, `categoria`, `nomeEmpresario`, `posicao`, `peso`, `altura`, `assistencia`, `mediaGols`) VALUES
(6, 'kjlkj', 'jlkj', 'null', 44.44, 444.4, NULL, NULL),
(7, 'kjlkj', 'jlkj', 'null', 44.44, 444.4, NULL, NULL),
(8, 'kjlkj', 'jlkj', 'null', 44.44, 444.4, NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `patrocinador`
--

CREATE TABLE `patrocinador` (
  `idPatrocinador` int(11) NOT NULL,
  `razaoSocial` varchar(30) NOT NULL,
  `cmpj` varchar(20) NOT NULL,
  `inscricaoEstadual` varchar(30) NOT NULL,
  `inscricaoMunicipal` varchar(30) NOT NULL,
  `fkPatrocinador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE `pessoa` (
  `idPessoa` int(11) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `sobrenome` varchar(30) NOT NULL,
  `nascionalidade` varchar(20) NOT NULL,
  `rg` varchar(15) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `dataNascimento` varchar(11) NOT NULL,
  `escolaridade` varchar(45) NOT NULL,
  `instituicao` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`idPessoa`, `nome`, `sobrenome`, `nascionalidade`, `rg`, `cpf`, `dataNascimento`, `escolaridade`, `instituicao`) VALUES
(1, 'laiedner', 'camargos', 'br', '1231', '41442', '20/01/1993', '2C', 'ufv'),
(2, 'laiedner', 'camargos', 'br', '1231', '41442', '20/01/1993', '2C', 'ufv'),
(3, 'laiender', 'camargos', 'pt', '2456', '0983', '20/09/2003', '2c', 'ufc'),
(4, 'camamr', 'jdjfsk', 'jhfksjh', '39283', '39829', '18/01/19', 'k', 'jj'),
(5, 'lakdalk', 'lklklsdkf', 'ksjdakj', '8987', '89798', '17/01/19', 'jjhjh', 'jhhj'),
(6, 'sadjalkj', 'kljalkjd', 'jhkjhk', '897', '09098', '18/01/19', 'jhkj', 'jkhkjh'),
(7, 'sadjalkj', 'kljalkjd', 'jhkjhk', '897', '09098', '18/01/19', 'jhkj', 'jkhkjh'),
(8, 'lakdalk', 'kllaksdlk', 'lklk', '9797', '9797', '18/01/19', 'hkjhk', 'kjhkjh'),
(9, 'dadajl', 'lkjasldj', 'kjlkasjd', '9798', '798798', '18/01/19', 'jhkhk9', '879'),
(10, 'jhkjh', 'hjgjg', 'fdgd', '3523', '4343', '18/01/19', 'dff', 'gfdgf'),
(11, 'jose', 'jskdjak', 'jkj', '7970', '8707', '19/01/19', 'hkjhkjh', 'hkjkhk'),
(12, 'jose', 'jsdakj', 'kjkj', '7979879', '987977', '19/01/19', 'jghgj', 'jgjg'),
(13, 'jose13', 'klj', 'lkjlkj', '9879', '97987', '19/01/19', 'jkhjh', 'jhkhk'),
(14, 'jose13', 'klj', 'lkjlkj', '9879', '97987', '19/01/19', 'jkhjh', 'jhkhk'),
(15, 'jose13', 'klj', 'lkjlkj', '9879', '97987', '19/01/19', 'jkhjh', 'jhkhk'),
(16, 'jose13', 'klj', 'lkjlkj', '9879', '97987', '19/01/19', 'jkhjh', 'jhkhk'),
(17, 'maria', 'kkkj', 'kkkk', '098kj', '98908', '19/01/19', 'jhj', 'jhkh'),
(18, 'dadaada', 'asdasda', 'llj', 'jkhkjh', 'jhkjh', '19/01/19', 'jkjhk', 'jhjhk'),
(19, 'kjdalkj', 'lkjsakljd', 'kjlkj', '08089', '908098', '19/01/19', 'kjlj', '9098'),
(20, 'laiednerrrr', 'lkjsakljd', 'kjlkj', '08089', '908098', '19/01/19', 'kjlj', '9098'),
(21, 'laiednerrrr', 'lkjsakljd', 'kjlkj', '08089', '908098', '19/01/19', 'kjlj', '9098');

-- --------------------------------------------------------

--
-- Estrutura da tabela `socioTorcedor`
--

CREATE TABLE `socioTorcedor` (
  `idSocioTorcedor` int(11) NOT NULL,
  `modalidadeTorcedor` varchar(30) NOT NULL,
  `dataFiliacao` date NOT NULL,
  `formaPagamento` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cadastroDespesa`
--
ALTER TABLE `cadastroDespesa`
  ADD PRIMARY KEY (`idDespesa`);

--
-- Indexes for table `cadastroRenda`
--
ALTER TABLE `cadastroRenda`
  ADD PRIMARY KEY (`idRenda`);

--
-- Indexes for table `conta`
--
ALTER TABLE `conta`
  ADD PRIMARY KEY (`idConta`);

--
-- Indexes for table `contatos`
--
ALTER TABLE `contatos`
  ADD PRIMARY KEY (`idContatos`),
  ADD UNIQUE KEY `idContatos` (`idContatos`);

--
-- Indexes for table `contrato`
--
ALTER TABLE `contrato`
  ADD KEY `idContrato_2` (`idContrato`);

--
-- Indexes for table `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`idEndereco`);

--
-- Indexes for table `informacoesMedicas`
--
ALTER TABLE `informacoesMedicas`
  ADD PRIMARY KEY (`idInfMedica`);

--
-- Indexes for table `jogador`
--
ALTER TABLE `jogador`
  ADD PRIMARY KEY (`idJogador`);

--
-- Indexes for table `patrocinador`
--
ALTER TABLE `patrocinador`
  ADD PRIMARY KEY (`idPatrocinador`);

--
-- Indexes for table `pessoa`
--
ALTER TABLE `pessoa`
  ADD PRIMARY KEY (`idPessoa`);

--
-- Indexes for table `socioTorcedor`
--
ALTER TABLE `socioTorcedor`
  ADD PRIMARY KEY (`idSocioTorcedor`);

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
  MODIFY `idContatos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `contrato`
--
ALTER TABLE `contrato`
  MODIFY `idContrato` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `endereco`
--
ALTER TABLE `endereco`
  MODIFY `idEndereco` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `informacoesMedicas`
--
ALTER TABLE `informacoesMedicas`
  MODIFY `idInfMedica` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `jogador`
--
ALTER TABLE `jogador`
  MODIFY `idJogador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `patrocinador`
--
ALTER TABLE `patrocinador`
  MODIFY `idPatrocinador` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pessoa`
--
ALTER TABLE `pessoa`
  MODIFY `idPessoa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `socioTorcedor`
--
ALTER TABLE `socioTorcedor`
  MODIFY `idSocioTorcedor` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `cadastroDespesa`
--
ALTER TABLE `cadastroDespesa`
  ADD CONSTRAINT `cadastroDespesa_ibfk_1` FOREIGN KEY (`idDespesa`) REFERENCES `conta` (`idConta`);

--
-- Limitadores para a tabela `conta`
--
ALTER TABLE `conta`
  ADD CONSTRAINT `conta_ibfk_1` FOREIGN KEY (`idConta`) REFERENCES `jogador` (`idJogador`);

--
-- Limitadores para a tabela `contatos`
--
ALTER TABLE `contatos`
  ADD CONSTRAINT `contatos_ibfk_1` FOREIGN KEY (`idContatos`) REFERENCES `pessoa` (`idPessoa`);

--
-- Limitadores para a tabela `contrato`
--
ALTER TABLE `contrato`
  ADD CONSTRAINT `contrato_ibfk_1` FOREIGN KEY (`idContrato`) REFERENCES `jogador` (`idJogador`);

--
-- Limitadores para a tabela `endereco`
--
ALTER TABLE `endereco`
  ADD CONSTRAINT `endereco_ibfk_1` FOREIGN KEY (`idEndereco`) REFERENCES `pessoa` (`idPessoa`);

--
-- Limitadores para a tabela `informacoesMedicas`
--
ALTER TABLE `informacoesMedicas`
  ADD CONSTRAINT `informacoesMedicas_ibfk_1` FOREIGN KEY (`idInfMedica`) REFERENCES `jogador` (`idJogador`);

--
-- Limitadores para a tabela `jogador`
--
ALTER TABLE `jogador`
  ADD CONSTRAINT `jogador_ibfk_1` FOREIGN KEY (`idJogador`) REFERENCES `pessoa` (`idPessoa`);

--
-- Limitadores para a tabela `patrocinador`
--
ALTER TABLE `patrocinador`
  ADD CONSTRAINT `patrocinador_ibfk_1` FOREIGN KEY (`idPatrocinador`) REFERENCES `conta` (`idConta`);

--
-- Limitadores para a tabela `socioTorcedor`
--
ALTER TABLE `socioTorcedor`
  ADD CONSTRAINT `socioTorcedor_ibfk_1` FOREIGN KEY (`idSocioTorcedor`) REFERENCES `pessoa` (`idPessoa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
