

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema pawpalandia_pruebas
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pawpalandia_pruebas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pawpalandia_pruebas` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema pawpalandia_pruebas
-- -----------------------------------------------------
USE `pawpalandia_pruebas` ;

-- -----------------------------------------------------
-- Table `pawpalandia_pruebas`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pawpalandia_pruebas`.`users` (
  `id_users` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `maiden_name` VARCHAR(45) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `phone` VARCHAR(20) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `accepted_t&c` TINYINT NOT NULL,
  PRIMARY KEY (`id_users`),
  UNIQUE INDEX `id_users_UNIQUE` (`id_users` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pawpalandia_pruebas`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pawpalandia_pruebas`.`products` (
  `id_products` INT ZEROFILL NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(60) NOT NULL,
  `description` VARCHAR(1000) NOT NULL,
  `img_url` VARCHAR(250) NOT NULL,
  `stock` INT NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  `bar_code` VARCHAR(20) NOT NULL,
  `users_id_users` INT NOT NULL,
  PRIMARY KEY (`id_products`, `users_id_users`),
  UNIQUE INDEX `id_products_UNIQUE` (`id_products` ASC) VISIBLE,
  UNIQUE INDEX `product_name_UNIQUE` (`product_name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pawpalandia_pruebas`.`shipment_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pawpalandia_pruebas`.`shipment_details` (
  `id_shipment_details` INT ZEROFILL NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(45) NOT NULL,
  `ext_number` INT NOT NULL,
  `int_number` INT NULL,
  `zip_code` INT NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_shipment_details`),
  UNIQUE INDEX `id_payment_methods_UNIQUE` (`id_shipment_details` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pawpalandia_pruebas`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pawpalandia_pruebas`.`orders` (
  `id_orders` INT ZEROFILL NOT NULL AUTO_INCREMENT,
  `amount` DECIMAL(10,2) NOT NULL,
  `products_quantity` INT NOT NULL,
  `order_date` DATE NOT NULL,
  `users_id_users` INT NOT NULL,
  PRIMARY KEY (`id_orders`),
  UNIQUE INDEX `id_orders_UNIQUE` (`id_orders` ASC) VISIBLE,
  INDEX `fk_orders_users1_idx` (`users_id_users` ASC) VISIBLE,
  CONSTRAINT `fk_orders_users1`
    FOREIGN KEY (`users_id_users`)
    REFERENCES `pawpalandia_pruebas`.`users` (`id_users`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pawpalandia_pruebas`.`order_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pawpalandia_pruebas`.`order_details` (
  `id_product` INT NOT NULL,
  `quantity_of_products` INT NOT NULL,
  `price_per_unit` DECIMAL(10,2) NOT NULL,
  `tracking_key` VARCHAR(45) NOT NULL,
  `orders_id_orders` INT ZEROFILL NOT NULL,
  `products_id_products` INT ZEROFILL NOT NULL,
  `products_users_id_users` INT NOT NULL,
  `shipment_details_id_shipment_details` INT ZEROFILL NOT NULL,
  UNIQUE INDEX `tracking_key_UNIQUE` (`tracking_key` ASC) VISIBLE,
  INDEX `fk_order_details_orders1_idx` (`orders_id_orders` ASC) VISIBLE,
  INDEX `fk_order_details_products1_idx` (`products_id_products` ASC, `products_users_id_users` ASC) VISIBLE,
  INDEX `fk_order_details_shipment_details1_idx` (`shipment_details_id_shipment_details` ASC) VISIBLE,
  CONSTRAINT `fk_order_details_orders1`
    FOREIGN KEY (`orders_id_orders`)
    REFERENCES `pawpalandia_pruebas`.`orders` (`id_orders`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_details_products1`
    FOREIGN KEY (`products_id_products` , `products_users_id_users`)
    REFERENCES `pawpalandia_pruebas`.`products` (`id_products` , `users_id_users`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_details_shipment_details1`
    FOREIGN KEY (`shipment_details_id_shipment_details`)
    REFERENCES `pawpalandia_pruebas`.`shipment_details` (`id_shipment_details`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
