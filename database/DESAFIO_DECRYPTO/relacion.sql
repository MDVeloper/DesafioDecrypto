USE DESAFIO_DECRYPTO;

CREATE TABLE IF NOT EXISTS `RELACION` (
	`COMITENTE_ID` INT UNSIGNED not null,
	`MERCADO_ID` INT UNSIGNED not null
	) default CHARSET=utf8 collate=utf8_unicode_ci