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
) ENGINE=MyISAM AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petshop`.`animal`
--

/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
LOCK TABLES `animal` WRITE;
INSERT INTO `petshop`.`animal` VALUES  (19,'TOBI','M','28/07/1998','CÃO','VIRA-LATA','',22,1),
 (20,'FEFE','M','12/00/2000','AVE','ANDORINHA','',23,1),
 (21,'FEFE','M','12/00/2000','AVE','ANDORINHA','',24,1),
 (22,'FLOR','F','10/05/1999','AVE','ARARA','',24,1),
 (23,'FEFE','M','12/00/2000','AVE','ANDORINHA','',25,1),
 (24,'FLOR','F','10/05/1999','AVE','ARARA','',25,1),
 (25,'ALPHA','M','20/08/2005','CÃO','','',25,1),
 (26,'FEFE','M','12/00/2000','AVE','ANDORINHA','',26,1),
 (27,'FLOR','F','10/05/1999','AVE','ARARA','',26,1),
 (28,'ALPHA','M','20/08/2005','CÃO','','',26,1),
 (29,'BETA','M','06/06/2008','ROEDOR','','',26,1),
 (30,'FEFE','M','12/00/2000','AVE','ANDORINHA','',27,1),
 (31,'FLOR','F','10/05/1999','AVE','ARARA','',27,1),
 (32,'ALPHA','M','20/08/2005','CÃO','','',27,1),
 (33,'BETA','M','06/06/2008','ROEDOR','','',27,1),
 (34,'ABISCISSA','F','01/02/2011','GATO','ANGORA','',27,1),
 (35,'FEFE','M','12/00/2000','AVE','ANDORINHA','',28,1),
 (36,'FLOR','F','10/05/1999','AVE','ARARA','',28,1),
 (37,'ALPHA','M','20/08/2005','CÃO','','',28,1),
 (38,'BETA','M','06/06/2008','ROEDOR','','',28,1),
 (39,'ABISCISSA','F','01/02/2011','GATO','ANGORA','',28,1),
 (40,'FRED','M','05/05/2009','CÃO','','',28,1),
 (41,'FEFE','M','12/00/2000','AVE','ANDORINHA','',29,1),
 (42,'FLOR','F','10/05/1999','AVE','ARARA','',29,1),
 (43,'ALPHA','M','20/08/2005','CÃO','','',29,1),
 (44,'BETA','M','06/06/2008','ROEDOR','','',29,1),
 (45,'ABISCISSA','F','01/02/2011','GATO','ANGORA','',29,1),
 (46,'FRED','M','05/05/2009','CÃO','','',29,1),
 (47,'DOG','M','06/06/2007','GATO','','',29,1),
 (48,'DOLINHA','M','24/02/2005','CÃO','PINCHER','',30,1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;


--
-- Definition of table `petshop`.`cliente`
--

DROP TABLE IF EXISTS `petshop`.`cliente`;
CREATE TABLE  `petshop`.`cliente` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `rg` bigint(20) NOT NULL,
  `rua` varchar(70) NOT NULL,
  `ncasa` int(5) NOT NULL,
  `bairro` varchar(30) NOT NULL,
  `cidade` varchar(30) NOT NULL,
  `complemento` varchar(30) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `email` varchar(70) NOT NULL,
  `telefone` varchar(13) NOT NULL,
  `celular` varchar(13) NOT NULL,
  `cep` varchar(9) NOT NULL,
  `info` varchar(400) NOT NULL,
  `ativo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`codigo`)
) ENGINE=MyISAM AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petshop`.`cliente`
--

/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
LOCK TABLES `cliente` WRITE;
INSERT INTO `petshop`.`cliente` VALUES  (22,'ARTHUR TABORDA','M','055.579.989-18',99994657,'RUA DESEMBARGADOR JOÃO PAES',657,'BOA VIAGEM','RECIFE','AP 101','PR','ARTHUR.HVT@GMAIL.COM','(81)9744-5628','(81)9749-0805','51021-360','',1),
 (23,'ARLINDO FREITAS','M','777.777.777-77',24874,'CLIP',12,'GRAFITE','TRUCO','ESQUINA GRAMPO','AP','LINDINHO_GT@HOTMAIL.COM','(12)3456-789','','85762-346','',1),
 (24,'BIANCA FONSECA','F','111.111.111-11',6423659,'EDIFICIO VINTE E TRES',88,'NOVA ZELANDIA','FLORES','','BA','BI@LIVE.COM','(21)5841-2345','','57415-491','',1),
 (25,'CACAU BLACK','M','222.222.222-22',257415,'EDIFICIO MAURICIO DE NASSAU',50,'RECIFE','RECIFE','','CE','BLACK.BLACK@YAHOO.COM.BR','','','54985-412','',1),
 (26,'DOUGLAS SANTOS','M','333.333.333-33',6742165,'AV 17',20,'CURADO','XÃ GRANDE','','PE','JDOUGLAS91@GMAIL.COM','(99)9752-6552','','57468-562','',1),
 (27,'THAYS MELO','F','444.444.444-44',235796,'03',182,'PIEDADE','RECIFE','','PE','THAYSMELO@LIVE.COM','(81)8623-2957','','34154-986','',1),
 (28,'HANNA PEREIRA','F','555.555.555-55',54916,'09',19,'CANDEIAS','RECIFE','','PE','HANNA.P@IVE.COM','(81)9991-5426','','68526-496','',1),
 (29,'LUIZ FELIPE','M','666.666.666-66',57416,'56',52,'CASA AMARELA','RECIFE','','PE','LUPI@GMAIL.COM','(81)8856-4865','','32745-263','',1),
 (30,'DOLA LIMA','M','070.058.184-74',89789556,'RUA BETANIA',25,'GRACAS','RECIFE','ATRAS DO PUTERO','AC','DOLA@ZIPMAIL.COM','(81)5686-4235','','87458-779','',1);
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
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) NOT NULL,
  `qt` int(11) NOT NULL,
  `preco_custo` double NOT NULL,
  `preco_venda` double NOT NULL,
  `info` varchar(400) NOT NULL,
  `ativo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`codigo`)
) ENGINE=MyISAM AUTO_INCREMENT=1853260881 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petshop`.`produtos`
--

/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
LOCK TABLES `produtos` WRITE;
INSERT INTO `petshop`.`produtos` VALUES  (1853260880,'SHAMPOO CAO CHEIROSO',10,15,25,'MUITO CHEIROSO',1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;


--
-- Definition of table `petshop`.`saidaprodutos`
--

DROP TABLE IF EXISTS `petshop`.`saidaprodutos`;
CREATE TABLE  `petshop`.`saidaprodutos` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `venda` int(11) NOT NULL,
  `produto` int(11) NOT NULL,
  `qt` int(11) NOT NULL,
  `valor` double NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petshop`.`saidaprodutos`
--

/*!40000 ALTER TABLE `saidaprodutos` DISABLE KEYS */;
LOCK TABLES `saidaprodutos` WRITE;
INSERT INTO `petshop`.`saidaprodutos` VALUES  (10,15,1853260880,5,25),
 (11,16,1853260880,12,25),
 (12,17,1853260880,12,25),
 (13,17,1853260880,3,25),
 (14,18,1853260880,3,25),
 (15,18,1853260880,5,25),
 (16,19,1853260880,5,25);
UNLOCK TABLES;
/*!40000 ALTER TABLE `saidaprodutos` ENABLE KEYS */;


--
-- Definition of table `petshop`.`saidaservicos`
--

DROP TABLE IF EXISTS `petshop`.`saidaservicos`;
CREATE TABLE  `petshop`.`saidaservicos` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `venda` int(11) NOT NULL,
  `servico` int(11) NOT NULL,
  `animal` int(11) NOT NULL,
  `valor` double NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petshop`.`saidaservicos`
--

/*!40000 ALTER TABLE `saidaservicos` DISABLE KEYS */;
LOCK TABLES `saidaservicos` WRITE;
INSERT INTO `petshop`.`saidaservicos` VALUES  (5,15,5006,19,25);
UNLOCK TABLES;
/*!40000 ALTER TABLE `saidaservicos` ENABLE KEYS */;


--
-- Definition of table `petshop`.`servicos`
--

DROP TABLE IF EXISTS `petshop`.`servicos`;
CREATE TABLE  `petshop`.`servicos` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) NOT NULL,
  `duracao` int(11) NOT NULL,
  `preco` double NOT NULL,
  `info` varchar(400) NOT NULL,
  `ativo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`codigo`)
) ENGINE=MyISAM AUTO_INCREMENT=5008 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petshop`.`servicos`
--

/*!40000 ALTER TABLE `servicos` DISABLE KEYS */;
LOCK TABLES `servicos` WRITE;
INSERT INTO `petshop`.`servicos` VALUES  (5006,'TOSA ESPECIAL',30,25,'É ESPECIAL',1),
 (5007,'BANHO ESPECIAL',40,35,'',1);
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
  `id_venda` bigint(20) NOT NULL AUTO_INCREMENT,
  `cliente` int(11) NOT NULL,
  `valor` double NOT NULL,
  `pagamento` int(11) NOT NULL,
  `data` varchar(10) NOT NULL,
  `parcelado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_venda`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petshop`.`vendas`
--

/*!40000 ALTER TABLE `vendas` DISABLE KEYS */;
LOCK TABLES `vendas` WRITE;
INSERT INTO `petshop`.`vendas` VALUES  (15,22,150,2,'04/05/2011',1),
 (16,22,300,0,'04/05/2011',0),
 (17,22,375,2,'04/05/2011',0),
 (18,22,200,0,'04/05/2011',0),
 (19,22,125,0,'04/05/2011',0);
UNLOCK TABLES;
/*!40000 ALTER TABLE `vendas` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
