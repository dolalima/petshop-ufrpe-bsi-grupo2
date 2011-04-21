-- phpMyAdmin SQL Dump
-- version 3.3.7deb5build0.10.10.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: Abr 21, 2011 as 10:29 AM
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
  `id_animal` int(11) NOT NULL,
  `dono` int(11) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `tipo` varchar(10) NOT NULL,
  `raca` varchar(20) NOT NULL,
  `idade` int(2) NOT NULL,
  PRIMARY KEY (`id_animal`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `animal`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `rg` int(11) NOT NULL,
  `rua` varchar(30) NOT NULL,
  `ncasa` int(4) NOT NULL,
  `bairro` varchar(15) NOT NULL,
  `cidade` varchar(25) NOT NULL,
  `complemento` varchar(100) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `telefone` varchar(13) NOT NULL,
  `celular` varchar(13) NOT NULL,
  `cep` varchar(9) NOT NULL,
  `info` varchar(200) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `id_cliente` (`id_cliente`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `nome`, `sexo`, `cpf`, `rg`, `rua`, `ncasa`, `bairro`, `cidade`, `complemento`, `uf`, `telefone`, `celular`, `cep`, `info`) VALUES
(1, 'CARLOS EDUARDO DE SOUZA LIMA', 'Masculino', '876.858.757-57', 7667667, 'JARDIM', 74, 'LIMAMENTO', 'VITORIA', 'Complemento', 'PI', '(76)3673-6376', '(72)7273-6772', '65556-566', 'Informações Adicionais'),
(2, 'MARIA EDUARDA', 'Feminino', '070.058.184-74', 7153203, 'JARDIM BETANIA', 69, 'LIVRAMENTO', 'RECIFE', 'Complemento', 'PE', '(87)2727-2789', '(99)8387-7363', '55602-380', 'Informações Adicionais');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE IF NOT EXISTS `produtos` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `qt` int(11) NOT NULL,
  `preco_custo` float NOT NULL,
  `preco_venda` float NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `id_produto` (`codigo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produtos`
--


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
  `id_vendas` int(11) NOT NULL,
  `cliente` int(11) NOT NULL,
  `produto` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `preco` float NOT NULL,
  `pagamento` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `vendas`
--

