CREATE TABLE `address_entity` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `street` VARCHAR(100) NOT NULL,
    `number` VARCHAR(50) NOT NULL,
    `complement` VARCHAR(100),
    `neighborhood` VARCHAR(100) NOT NULL,
    `city` VARCHAR(100),
    `state` VARCHAR(50),
    `cep` VARCHAR(20),
    `person_id` BIGINT,
    `updated_at` DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`person_id`) REFERENCES `person_entity`(`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
