CREATE TABLE `person` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
   `last_name` varchar(255) DEFAULT NULL,
   `first_Name` varchar(255) DEFAULT NULL,
   `dob`  date DEFAULT NULL,
   `status`  int DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
SELECT * FROM shoppingdb.person;
SELECT * FROM shoppingdb.user;