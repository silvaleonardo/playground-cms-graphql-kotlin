CREATE TABLE IF NOT EXISTS `comments` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `body` VARCHAR(255),
  `status` VARCHAR(100) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted_at` DATETIME,
  `user_id` BIGINT(20) NOT NULL,
  `comment_id` BIGINT(20),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`),
  INDEX `user_id_idx` (`user_id`),
  INDEX `comment_id_idx` (`comment_id`),
  CONSTRAINT `fk_comments_users_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `fk_comments_comments_comment_id` FOREIGN KEY (`comment_id`) REFERENCES `comments` (`id`)
);
