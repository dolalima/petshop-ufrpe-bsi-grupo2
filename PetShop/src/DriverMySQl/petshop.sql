-- phpMyAdmin SQL Dump
-- version 3.3.7deb5build0.10.10.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: Mai 02, 2011 as 04:52 AM
-- Versão do Servidor: 5.1.49
-- Versão do PHP: 5.3.3-1ubuntu9.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `petshop`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `animal`
--

CREATE TABLE IF NOT EXISTS `animal` (
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
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `animal`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `rg` int(11) NOT NULL,
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
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`codigo`, `nome`, `sexo`, `cpf`, `rg`, `rua`, `ncasa`, `bairro`, `cidade`, `complemento`, `uf`, `email`, `telefone`, `celular`, `cep`, `info`, `ativo`) VALUES
(1, 'CARLOS EDUARDO DE SOUZA LIMA', 'M', '876.858.757-57', 7667667, 'JARDIM', 74, 'LIMAMENTO', 'VITORIA', 'Complemento', 'PI', '', '(76)3673-6376', '(72)7273-6772', '65556-566', 'Informações Adicionais', 1),
(2, 'MARIA EDUARDA DE SOUZA LIMA', 'F', '070.058.184-74', 7153203, 'JARDIM BETANIA', 69, 'LIVRAMENTO', 'RECIFE', 'Complemento', 'PE', '', '(87)2727-2789', '(99)8387-7363', '55602-380', 'Informações Adicionais', 0),
(3, 'LUANNA RIBEIRO', 'F', '654.354.986-54', 756483, 'JOAO CLEOFAS', 452, 'JACA', 'VITORIA DE SANTO ANTAO', '', 'PE', 'LUANARIBEIRO_LUA@GMAIL.COM', '(81)3516-5466', '(81)8619-6629', '55602-380', '', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE IF NOT EXISTS `produtos` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `qt` int(11) NOT NULL,
  `preco_custo` double NOT NULL,
  `preco_venda` double NOT NULL,
  `info` varchar(200) NOT NULL,
  `ativo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`codigo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produtos`
--

INSERT INTO `produtos` (`codigo`, `nome`, `qt`, `preco_custo`, `preco_venda`, `info`, `ativo`) VALUES
(10001, 'RACAO PEDGRIR 1 KG', 5, 5, 10, 'MARCA BOA', 1),
(10002, 'RACAO PEDGRIR 2 KG', 7, 3.5, 7.5, 'MARCA BOA', 1),
(11001, 'RACAO MAGNUS 10 KG', 15, 10, 14.5, 'RACAO DE MEIA QUALIDADE', 1),
(11002, 'RACAO MAGNUS 15 KG', 7, 12.3, 18.99, 'RACAO DE MEIA QUALIDADE', 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `saidaprodutos`
--

CREATE TABLE IF NOT EXISTS `saidaprodutos` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `venda` int(11) NOT NULL,
  `produto` int(11) NOT NULL,
  `qt` int(11) NOT NULL,
  `valor` double NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `saidaprodutos`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `saidaservicos`
--

CREATE TABLE IF NOT EXISTS `saidaservicos` (
  `codigo` int(11) NOT NULL,
  `venda` int(11) NOT NULL,
  `servico` int(11) NOT NULL,
  `animal` int(11) NOT NULL,
  `valor` double NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `saidaservicos`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `servicos`
--

CREATE TABLE IF NOT EXISTS `servicos` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `duracao` int(3) NOT NULL,
  `preco` double NOT NULL,
  `info` varchar(200) NOT NULL,
  `ativo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`codigo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `servicos`
--

INSERT INTO `servicos` (`codigo`, `nome`, `duracao`, `preco`, `info`, `ativo`) VALUES
(5001, 'BANHO POODLE', 30, 20, 'BLABLABLa', 0),
(5002, 'TOSA POODLE', 60, 30, 'Informações Adicionais', 0),
(5003, 'BANHO POOODLE', 45, 60, 'Informações Adicionais', 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `id_users` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(10) NOT NULL,
  `senha` varchar(10) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  PRIMARY KEY (`id_users`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`id_users`, `user`, `senha`, `nome`, `cpf`) VALUES
(1, 'dolalima', 'lima1807', 'Carlos Eduardo de Souza Lima', '070.058.184-74'),
(2, 'lua', 'luanna29', 'Luanna Ribeiro Santos Silva', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendas`
--

CREATE TABLE IF NOT EXISTS `vendas` (
  `codigo` int(11) NOT NULL,
  `cliente` int(11) NOT NULL,
  `valor` double NOT NULL,
  `pagamento` int(11) NOT NULL,
  `data` date NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `vendas`
--

