CREATE TABLE IF NOT EXISTS `page_complements` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(100) NOT NULL,
  `data` JSON NOT NULL,
  `page_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`),
  INDEX `page_id_idx` (`page_id`),
  CONSTRAINT `fk_page_complements_pages_page_id` FOREIGN KEY (`page_id`) REFERENCES `pages` (`id`)
);