-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: basehotel
-- ------------------------------------------------------
-- Server version	5.6.27-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idpessoa` int(11) NOT NULL,
  `codigo_cliente` varchar(10) NOT NULL,
  PRIMARY KEY (`idpessoa`),
  CONSTRAINT `fk_persona_cliente` FOREIGN KEY (`idpessoa`) REFERENCES `pessoa` (`idpessoa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consumo`
--

DROP TABLE IF EXISTS `consumo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consumo` (
  `idconsumo` int(11) NOT NULL AUTO_INCREMENT,
  `idreserva` int(11) NOT NULL,
  `idproduto` int(11) NOT NULL,
  `quantidade` decimal(7,2) NOT NULL,
  `preco_venda` decimal(7,2) NOT NULL,
  `estado` varchar(15) NOT NULL,
  PRIMARY KEY (`idconsumo`),
  KEY `fk_consumo_producto_idx` (`idproduto`),
  KEY `fk_consumo_reserva_idx` (`idreserva`),
  CONSTRAINT `fk_consumo_producto` FOREIGN KEY (`idproduto`) REFERENCES `produto` (`idproduto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_consumo_reserva` FOREIGN KEY (`idreserva`) REFERENCES `reserva` (`idreserva`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consumo`
--

LOCK TABLES `consumo` WRITE;
/*!40000 ALTER TABLE `consumo` DISABLE KEYS */;
/*!40000 ALTER TABLE `consumo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habitacao`
--

DROP TABLE IF EXISTS `habitacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `habitacao` (
  `idhabitacao` int(11) NOT NULL AUTO_INCREMENT,
  `apto` varchar(4) NOT NULL,
  `andar` varchar(2) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `caracteristica` varchar(512) DEFAULT NULL,
  `preco_diaria` decimal(7,2) NOT NULL,
  `status` varchar(15) NOT NULL,
  `tipo_habitacao` varchar(20) NOT NULL,
  PRIMARY KEY (`idhabitacao`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habitacao`
--

LOCK TABLES `habitacao` WRITE;
/*!40000 ALTER TABLE `habitacao` DISABLE KEYS */;
INSERT INTO `habitacao` VALUES (1,'101','1','teste','cadeira erótica',250.00,'Disponível','Casal');
/*!40000 ALTER TABLE `habitacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamento`
--

DROP TABLE IF EXISTS `pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagamento` (
  `idpagamento` int(11) NOT NULL AUTO_INCREMENT,
  `idreserva` int(11) NOT NULL,
  `tipo_comprovante` varchar(20) NOT NULL,
  `num_comprovante` varchar(20) NOT NULL,
  `igv_pagamento` decimal(4,2) NOT NULL,
  `total_pagto` decimal(7,2) NOT NULL,
  `fecha_emissao` date NOT NULL,
  `fecha_pagto` date NOT NULL,
  PRIMARY KEY (`idpagamento`),
  KEY `fk_pago_reserva_idx` (`idreserva`),
  CONSTRAINT `fk_pago_reserva` FOREIGN KEY (`idreserva`) REFERENCES `reserva` (`idreserva`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamento`
--

LOCK TABLES `pagamento` WRITE;
/*!40000 ALTER TABLE `pagamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa` (
  `idpessoa` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `cpf` varchar(20) NOT NULL,
  `rg` varchar(20) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `fone_res_com` varchar(15) DEFAULT NULL,
  `fone_cel` varchar(15) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`idpessoa`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (8,'Daniel','1551111111','48154848','Avenida','980316667','','root@root.com');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `idproduto` int(11) NOT NULL AUTO_INCREMENT,
  `nome_prod` varchar(45) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `unidade_medida` varchar(20) NOT NULL,
  `preco_venda` decimal(7,2) NOT NULL,
  PRIMARY KEY (`idproduto`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'Coca-Cola','refrigerante','Lata',2.50);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva` (
  `idreserva` int(11) NOT NULL AUTO_INCREMENT,
  `idhabitacao` int(11) NOT NULL,
  `idcliente` int(11) NOT NULL,
  `idtrabalhador` int(11) NOT NULL,
  `tipo_reserva` varchar(20) NOT NULL,
  `fecha_reserva` date NOT NULL,
  `entrada_reserva` date NOT NULL,
  `saida_reserva` date NOT NULL,
  `custo_apto` decimal(7,2) NOT NULL,
  `estado` varchar(15) NOT NULL,
  PRIMARY KEY (`idreserva`),
  KEY `fk_reserva_habitacion_idx` (`idhabitacao`),
  KEY `fk_reserva_cliente_idx` (`idcliente`),
  KEY `fk_reserva_trabajador_idx` (`idtrabalhador`),
  CONSTRAINT `fk_reserva_cliente` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idpessoa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_habitacion` FOREIGN KEY (`idhabitacao`) REFERENCES `habitacao` (`idhabitacao`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_trabajador` FOREIGN KEY (`idtrabalhador`) REFERENCES `trabalhador` (`idpessoa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabalhador`
--

DROP TABLE IF EXISTS `trabalhador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trabalhador` (
  `idpessoa` int(11) NOT NULL,
  `salario` decimal(7,2) NOT NULL,
  `acesso` varchar(25) NOT NULL,
  `login` varchar(15) NOT NULL,
  `senha` varchar(32) DEFAULT NULL,
  `estado` varchar(20) NOT NULL,
  PRIMARY KEY (`idpessoa`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  CONSTRAINT `fk_persona_trabajador` FOREIGN KEY (`idpessoa`) REFERENCES `pessoa` (`idpessoa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabalhador`
--

LOCK TABLES `trabalhador` WRITE;
/*!40000 ALTER TABLE `trabalhador` DISABLE KEYS */;
INSERT INTO `trabalhador` VALUES (8,3500.00,'Administrador','root','root','ATIVADO');
/*!40000 ALTER TABLE `trabalhador` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-21 12:37:58
