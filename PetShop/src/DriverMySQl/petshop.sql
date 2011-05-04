-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.41-3ubuntu12.10


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema petshop
--

CREATE DATABASE IF NOT EXISTS petshop;
USE petshop;

--
-- Definition of table `petshop`.`animal`
--

DROP TABLE IF EXISTS `petshop`.`animal`;
CREATE TABLE  `petshop`.`animal` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `nascimento` varchar(10) NOT NULL,
  `especie` varchar(15) NOT NULL,
  `raca` varchar(20) NOT NULL,
  `info` varchar(250) NOT NULL,
  `dono` int(11) NOT NULL,
  `ativo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`codigo`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petshop`.`animal`
--

/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
LOCK TABLES `animal` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;


--
-- Definition of table `petshop`.`cliente`
--

DROP TABLE IF EXISTS `petshop`.`cliente`;
CREATE TABLE  `petshop`.`cliente` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `rg` bigint(20) NOT NULL,
  `rua` varchar(30) NOT NULL,
  `ncasa` int(4) NOT NULL,
  `bairro` varchar(15) NOT NULL,
  `cidade` varchar(25) NOT NULL,
  `complemento` varchar(100) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `email` varchar(30) NOT NULL,
  `telefone` varchar(13) NOT NULL,
  `celular` varchar(13) NOT NULL,
  `cep` varchar(9) NOT NULL,
  `info` varchar(200) NOT NULL,
  `ativo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`codigo`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petshop`.`cliente`
--

/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
LOCK TABLES `cliente` WRITE;
INSERT INTO `petshop`.`cliente` VALUES  (1,'CARLOS EDUARDO DE SOUZA LIMA','M','876.858.757-57',7667667,'JARDIM',74,'LIMAMENTO','VITORIA','Complemento','PI','','(76)3673-6376','(72)7273-6772','65556-566','',1),
 (2,'MARIA EDUARDA DE SOUZA LIMA','F','070.058.184-74',7153203,'JARDIM BETANIA',69,'LIVRAMENTO','RECIFE','Complemento','PE','','(87)2727-2789','(99)8387-7363','55602-380','',0),
 (3,'LUANNA RIBEIRO','F','654.354.986-54',756483,'JOAO CLEOFAS',452,'JACA','VITORIA DE SANTO ANTAO','','PE','LUANARIBEIRO_LUA@GMAIL.COM','(81)3516-5466','(81)8619-6629','55602-380','',1),
 (4,'ARTHUR HENRIQUE VARGAS TABORDA','M','055.579.989-18',99994657,'RUA DESEMBARGADOR JOÃO PAES',657,'BOA VIAGEM','RECIFE','AP 101','PE','ARTHUR.HVT@GMAIL.COM','','(81)9749-0805','51213-60','',1),
 (5,'FELIX','M','321.565.416-55',2546854,'TRES',128,'ARRU','RECIFE','','PE','FOITRISTE@GMAIL.COM','(85)8888-8888','','32589-523','',1),
 (20,'NUINU','M','',187189,' JIM J',81,'N HU HU','NUINUI','NH UN HU','AC','MDIMWIJ','(12)8918-9189','','28918-918','',1),
 (17,'CLEOPATRA','F','649.513.214-98',54943241,'VINTE',999,'CAIRO','NOA','','AC','CLEO@GMAIL.COM','(99)9999-9999','','','',1),
 (18,'NUINUI','M','918.918.918-91',18918918,'NUNUI9',189,'NUINUI','NUINUINUI','NUINUINUI','AC','189189','(18)9189-1891','(18)9189-1891','41894-189','',1),
 (19,'WOLVERINE','M','491.891.891-89',9878898,'BASE SECRETA DOS X-MEN',69,'CAPAO RASO','MANHATTAN','ATRAS DA FARMACIA DO TIO JOAO','AC','WOL-GATAO@ZIPMAIL.COM','(08)9189-4189','','','',1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;


--
-- Definition of table `petshop`.`pagamento`
--

DROP TABLE IF EXISTS `petshop`.`pagamento`;
CREATE TABLE  `petshop`.`pagamento` (
  `id_pagamento` int(11) NOT NULL,
  `tipo` varchar(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petshop`.`pagamento`
--

/*!40000 ALTER TABLE `pagamento` DISABLE KEYS */;
LOCK TABLES `pagamento` WRITE;
INSERT INTO `petshop`.`pagamento` VALUES  (0,'DINHEIRO'),
 (1,'CARTAO'),
 (2,'CHEQUE');
UNLOCK TABLES;
/*!40000 ALTER TABLE `pagamento` ENABLE KEYS */;


--
-- Definition of table `petshop`.`produtos`
--

DROP TABLE IF EXISTS `petshop`.`produtos`;
CREATE TABLE  `petshop`.`produtos` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `qt` int(11) NOT NULL,
  `preco_custo` double NOT NULL,
  `preco_venda` double NOT NULL,
  `info` varchar(200) NOT NULL,
  `ativo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`codigo`)
) ENGINE=MyISAM AUTO_INCREMENT=1853260880 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petshop`.`produtos`
--

/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
LOCK TABLES `produtos` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;


--
-- Definition of table `petshop`.`saidaprodutos`
--

DROP TABLE IF EXISTS `petshop`.`saidaprodutos`;
CREATE TABLE  `petshop`.`saidaprodutos` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `venda` int(11) NOT NULL,
  `produto` int(11) NOT NULL,
  `qt` int(11) NOT NULL,
  `valor` double NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petshop`.`saidaprodutos`
--

/*!40000 ALTER TABLE `saidaprodutos` DISABLE KEYS */;
LOCK TABLES `saidaprodutos` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `saidaprodutos` ENABLE KEYS */;


--
-- Definition of table `petshop`.`saidaservicos`
--

DROP TABLE IF EXISTS `petshop`.`saidaservicos`;
CREATE TABLE  `petshop`.`saidaservicos` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `venda` int(11) NOT NULL,
  `servico` int(11) NOT NULL,
  `animal` int(11) NOT NULL,
  `valor` double NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petshop`.`saidaservicos`
--

/*!40000 ALTER TABLE `saidaservicos` DISABLE KEYS */;
LOCK TABLES `saidaservicos` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `saidaservicos` ENABLE KEYS */;


--
-- Definition of table `petshop`.`servicos`
--

DROP TABLE IF EXISTS `petshop`.`servicos`;
CREATE TABLE  `petshop`.`servicos` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `duracao` int(3) NOT NULL,
  `preco` double NOT NULL,
  `info` varchar(200) NOT NULL,
  `ativo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`codigo`)
) ENGINE=MyISAM AUTO_INCREMENT=5006 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petshop`.`servicos`
--

/*!40000 ALTER TABLE `servicos` DISABLE KEYS */;
LOCK TABLES `servicos` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `servicos` ENABLE KEYS */;


--
-- Definition of table `petshop`.`usuarios`
--

DROP TABLE IF EXISTS `petshop`.`usuarios`;
CREATE TABLE  `petshop`.`usuarios` (
  `id_users` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(10) NOT NULL,
  `senha` varchar(10) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  PRIMARY KEY (`id_users`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petshop`.`usuarios`
--

/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
LOCK TABLES `usuarios` WRITE;
INSERT INTO `petshop`.`usuarios` VALUES  (3,'admin','admin','admin',''),
 (2,'arthur','taborda','Arthur Taborda','055.579.989-18'),
 (1,'dolalima','lima1807','Dola','');
UNLOCK TABLES;
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;


--
-- Definition of table `petshop`.`vendas`
--

DROP TABLE IF EXISTS `petshop`.`vendas`;
CREATE TABLE  `petshop`.`vendas` (
  `id_venda` int(11) NOT NULL AUTO_INCREMENT,
  `cliente` int(11) NOT NULL,
  `valor` double NOT NULL,
  `pagamento` int(11) NOT NULL,
  `data` varchar(10) NOT NULL,
  `parcelado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_venda`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petshop`.`vendas`
--

/*!40000 ALTER TABLE `vendas` DISABLE KEYS */;
LOCK TABLES `vendas` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `vendas` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
