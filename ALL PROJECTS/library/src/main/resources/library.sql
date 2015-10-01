SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `library` DEFAULT CHARACTER SET utf8 ;
USE `library` ;

-- -----------------------------------------------------
-- Table `library`.`Authors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library`.`Authors` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NULL DEFAULT NULL,
  `birthdate` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`Books`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library`.`Books` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `genre` VARCHAR(45) NULL DEFAULT NULL,
  `year_publication` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`Сustomer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library`.`Сustomer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `passport` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `phone` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`Traffic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library`.`Traffic` (
  `IdCustomer` INT NOT NULL,
  `IdBook` INT NOT NULL,
  `data_out` DATE NOT NULL,
  `date_back_out` DATE NOT NULL,
  INDEX `fk_traffic_1_idx` (`IdCustomer` ASC),
  INDEX `fk_traffic_2_idx` (`IdBook` ASC),
  PRIMARY KEY (`IdCustomer`, `IdBook`),
  CONSTRAINT `fk_traffic_1`
    FOREIGN KEY (`IdCustomer`)
    REFERENCES `library`.`Сustomer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_traffic_2`
    FOREIGN KEY (`IdBook`)
    REFERENCES `library`.`Books` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`AB`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library`.`AB` (
  `idAuthor` INT NOT NULL,
  `idBook` INT NOT NULL,
  INDEX `fk_AB_1_idx` (`idAuthor` ASC),
  INDEX `fk_AB_2_idx` (`idBook` ASC),
  CONSTRAINT `fk_AB_1`
    FOREIGN KEY (`idAuthor`)
    REFERENCES `library`.`Authors` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_AB_2`
    FOREIGN KEY (`idBook`)
    REFERENCES `library`.`Books` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
COMMENT = 'Authors and their books';


-- -----------------------------------------------------
-- Table `library`.`Customers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library`.`Customers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `passport` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `phone` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
