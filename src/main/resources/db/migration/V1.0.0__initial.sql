CREATE TABLE `token_settings` (
  `token_settings_id` bigint PRIMARY KEY AUTO_INCREMENT,
  `is_active` boolean default true,
  `verify_token_expiration_days` int,
  `auth_token_expiration_days` int
);

CREATE TABLE `token_types` (
  `token_type_id` bigint PRIMARY KEY,
  `type` enum('JWT','VERIFICATION','AUTHORIZATION') NOT NULL
);

CREATE TABLE `tokens` (
  `token_id` bigint PRIMARY KEY AUTO_INCREMENT,
  `token` varchar(100) NOT NULL,
  `expiration_date` date NOT NULL,
  `token_type_id` bigint NOT NULL
);

CREATE TABLE `users` (
  `user_id` bigint PRIMARY KEY AUTO_INCREMENT,
  `user_uuid` varchar(36) NOT NULL,
  `credential_id` bigint NOT NULL
);

CREATE TABLE `contacts` (
  `contact_uuid` varchar(36) NOT NULL,
  `contact_id` bigint PRIMARY KEY AUTO_INCREMENT,
  `phone_number` varchar(15),
  `email` varchar(70),
  `user_id` bigint NOT NULL
);

CREATE TABLE `credentials` (
  `credential_id` bigint PRIMARY KEY AUTO_INCREMENT,
  `credential_uuid` varchar(36) NOT NULL,
  `verified_at` date NOT NULL,
  `created_at` date NOT NULL,
  `password` varchar(255) NOT NULL,
  `token_id` bigint NOT NULL,
  `user_id` bigint NOT NULL
);

CREATE TABLE `payment` (
  `payment_id` bigint PRIMARY KEY AUTO_INCREMENT,
  `payment_uuid` varchar(36) NOT NULL,
  `amount` double NOT NULL,
  `date` date NOT NULL
);

ALTER TABLE `tokens` ADD FOREIGN KEY (`token_type_id`) REFERENCES `token_types` (`token_type_id`);

ALTER TABLE `users` ADD FOREIGN KEY (`credential_id`) REFERENCES `credentials` (`credential_id`);

ALTER TABLE `contacts` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

ALTER TABLE `credentials` ADD FOREIGN KEY (`token_id`) REFERENCES `tokens` (`token_id`);

ALTER TABLE `credentials` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);
