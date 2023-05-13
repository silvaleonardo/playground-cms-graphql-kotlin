CREATE TABLE IF NOT EXISTS `users` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `nickname` VARCHAR(100) NOT NULL,
  `token` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`),
  UNIQUE INDEX `nickname_UNIQUE` (`nickname`),
  UNIQUE INDEX `token_UNIQUE` (`token`),
  INDEX `email_idx` (`email`),
  INDEX `nickname_email_idx` (`nickname`, `email`)
);