USE DESAFIO_DECRYPTO;

CREATE TABLE IF NOT EXISTS `COMITENTE` (
	`ID` INT UNSIGNED NOT NULL DEFAULT 0,
	`DESCRIPTION` VARCHAR(255) DEFAULT null,
	`CREATE_DATE` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	`MODIFY_DATE` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	primary key (`ID`)
	
	) default CHARSET=utf8 collate=utf8_unicode_ci