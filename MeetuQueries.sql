CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `meets_id` bigint,
  `email` varchar(255),
  `gender_enum` varchar(255),
  `interest_list` varchar(255),
  `more_info` varchar(255),
  `name` varchar(255) NOT NULL,
  `orientation_enum` varchar(255),
  `password` varchar(255) NOT NULL,
  `zodiac_sign_enum` varchar(255),
  `record_status` enum('A','I','D') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_key` (`email`)
);

CREATE TABLE `meets` (
  `quantity` int NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `release_date` datetime(6) NOT NULL,
  `record_status` enum('A','I','D') NOT NULL,
  PRIMARY KEY (`id`)
);

ALTER TABLE `user`
ADD CONSTRAINT user_meets_FK
FOREIGN KEY (meets_id)
REFERENCES meets(id);

CREATE TABLE `review` (
  `date_of_review` date DEFAULT NULL,
  `grade` double DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `record_status` enum('A','I','D') NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `user__review_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
);

CREATE TABLE `experience` (
  `experience_value` int NOT NULL,
  `id_userfk` int NOT NULL,
  `price` double NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `type_experience` varchar(255) NOT NULL,
  `record_status` enum('A','I','D') NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `booking` (
  `price` double NOT NULL,
  `experience_id` bigint,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `type_experience` varchar(255) NOT NULL,
  `record_status` enum('A','I','D') NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `experience_FK` FOREIGN KEY (`experience_id`) REFERENCES `experience` (`id`),
  CONSTRAINT `user_booking_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
);

CREATE TABLE `user_experience` (
  `experience_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  CONSTRAINT `user_experience_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `experience_user_FK` FOREIGN KEY (`experience_id`) REFERENCES `experience` (`id`)
);

