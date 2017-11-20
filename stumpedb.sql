-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema stumpedb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `stumpedb` ;

-- -----------------------------------------------------
-- Schema stumpedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `stumpedb` DEFAULT CHARACTER SET utf8 ;
USE `stumpedb` ;

-- -----------------------------------------------------
-- Table `rank`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rank` ;

CREATE TABLE IF NOT EXISTS `rank` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `warrior_class`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `warrior_class` ;

CREATE TABLE IF NOT EXISTS `warrior_class` (
  `id` INT NOT NULL,
  `class_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `weapon`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `weapon` ;

CREATE TABLE IF NOT EXISTS `weapon` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `weapon_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `warrior`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `warrior` ;

CREATE TABLE IF NOT EXISTS `warrior` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `rank_id` INT NOT NULL,
  `weapon_id` INT NULL,
  `warrior_class_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_warrior_rank_idx` (`rank_id` ASC),
  INDEX `fk_warrior_warrior_class_idx` (`warrior_class_id` ASC),
  INDEX `fk_warrior_weapon_idx` (`weapon_id` ASC),
  CONSTRAINT `fk_warrior_rank`
    FOREIGN KEY (`rank_id`)
    REFERENCES `rank` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_warrior_warrior_class`
    FOREIGN KEY (`warrior_class_id`)
    REFERENCES `warrior_class` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_warrior_weapon`
    FOREIGN KEY (`weapon_id`)
    REFERENCES `weapon` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO stumpicus@localhost;
 DROP USER stumpicus@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'stumpicus'@'localhost' IDENTIFIED BY 'stumpicus';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'stumpicus'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `rank`
-- -----------------------------------------------------
START TRANSACTION;
USE `stumpedb`;
INSERT INTO `rank` (`id`, `name`) VALUES (1, 'Private');
INSERT INTO `rank` (`id`, `name`) VALUES (2, 'Sergeant');
INSERT INTO `rank` (`id`, `name`) VALUES (3, 'Captain');

COMMIT;


-- -----------------------------------------------------
-- Data for table `warrior_class`
-- -----------------------------------------------------
START TRANSACTION;
USE `stumpedb`;
INSERT INTO `warrior_class` (`id`, `class_name`) VALUES (1, 'Brute');
INSERT INTO `warrior_class` (`id`, `class_name`) VALUES (2, 'Basher');
INSERT INTO `warrior_class` (`id`, `class_name`) VALUES (3, 'Ranger');
INSERT INTO `warrior_class` (`id`, `class_name`) VALUES (4, 'MagicMan');
INSERT INTO `warrior_class` (`id`, `class_name`) VALUES (5, 'Shapeshifter');

COMMIT;


-- -----------------------------------------------------
-- Data for table `weapon`
-- -----------------------------------------------------
START TRANSACTION;
USE `stumpedb`;
INSERT INTO `weapon` (`id`, `weapon_name`) VALUES (1, 'Keyblade');
INSERT INTO `weapon` (`id`, `weapon_name`) VALUES (2, 'Gunchucks');
INSERT INTO `weapon` (`id`, `weapon_name`) VALUES (3, 'Battleaxe');
INSERT INTO `weapon` (`id`, `weapon_name`) VALUES (4, 'Galaxynote7');
INSERT INTO `weapon` (`id`, `weapon_name`) VALUES (5, 'LaserKatana');

COMMIT;


-- -----------------------------------------------------
-- Data for table `warrior`
-- -----------------------------------------------------
START TRANSACTION;
USE `stumpedb`;
INSERT INTO `warrior` (`id`, `name`, `rank_id`, `weapon_id`, `warrior_class_id`) VALUES (1, 'Stumpalicious', 3, 1, 1);
INSERT INTO `warrior` (`id`, `name`, `rank_id`, `weapon_id`, `warrior_class_id`) VALUES (2, 'Stumpinidas', 2, 2, NULL);

COMMIT;
