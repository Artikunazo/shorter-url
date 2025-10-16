-- PostgreSQL Script
-- Migration from MySQL to PostgreSQL
-- Date: 2025-10-16

-- -----------------------------------------------------
-- Table urls.urls
-- -----------------------------------------------------
DROP TABLE IF EXISTS urls CASCADE;

CREATE TABLE IF NOT EXISTS urls (
    id SERIAL NOT NULL,
    shorted_url TEXT NOT NULL,
    original_url TEXT NOT NULL,
    date TIMESTAMP NOT NULL,
    "user" TEXT NOT NULL,
    PRIMARY KEY (id)
);