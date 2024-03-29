USE DESAFIO_DECRYPTO;

CREATE TABLE IF NOT EXISTS `MERCADO` (
	`ID` INT UNSIGNED NOT NULL DEFAULT 0,
	`CODE` VARCHAR(255) not NULL,
	`DESCRIPTION` VARCHAR(255) DEFAULT null,
	`COUNTRY` VARCHAR(15) not NULL,
	`CREATE_DATE` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`MODIFY_DATE` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	primary key (`ID`)
	) default CHARSET=utf8 collate=utf8_unicode_ci