CREATE TABLE IF NOT EXISTS `pages` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `summary` VARCHAR(255),
  `body` LONGTEXT,
  `status` VARCHAR(100) NOT NULL,
  `type` VARCHAR(100) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted_at` DATETIME,
  `user_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`),
  INDEX `user_id_idx` (`user_id`),
  CONSTRAINT `fk_pages_users_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);

CREATE TABLE IF NOT EXISTS `pages_tags` (
  `page_id` BIGINT(20),
  `tag_id` BIGINT(20),
  PRIMARY KEY (`page_id`, `tag_id`),
  UNIQUE INDEX `page_id_tag_id_UNIQUE` (`page_id`, `tag_id`),
  INDEX `page_id_idx` (`page_id`),
  INDEX `tag_id_idx` (`tag_id`),
  CONSTRAINT `fk_pages_tags_page_id` FOREIGN KEY (`page_id`) REFERENCES `pages` (`id`),
  CONSTRAINT `fk_pages_tags_tag_id` FOREIGN KEY (`tag_id`) REFERENCES `tags` (`id`)
);

CREATE TABLE IF NOT EXISTS `pages_comments` (
  `page_id` BIGINT(20),
  `comment_id` BIGINT(20),
  PRIMARY KEY (`page_id`, `comment_id`),
  UNIQUE INDEX `page_id_tag_id_UNIQUE` (`page_id`, `comment_id`),
  INDEX `page_id_idx` (`page_id`),
  INDEX `comment_id_idx` (`comment_id`),
  CONSTRAINT `fk_pages_comments_page_id` FOREIGN KEY (`page_id`) REFERENCES `pages` (`id`),
  CONSTRAINT `fk_pages_comments_comment_id` FOREIGN KEY (`comment_id`) REFERENCES `comments` (`id`)
);