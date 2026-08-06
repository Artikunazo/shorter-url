-- PostgreSQL Script
-- Migration from MySQL to PostgreSQL
-- Date: 2025-10-16

-- -----------------------------------------------------
-- Table urls.urls
-- -----------------------------------------------------
DROP TABLE IF EXISTS urls CASCADE;

CREATE TABLE IF NOT EXISTS urls (
    id SERIAL NOT NULL,
    shorted_url VARCHAR(255) NOT NULL,
    original_url TEXT NOT NULL,
    date TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    app_user TEXT NOT NULL,
    PRIMARY KEY (id)
);

CREATE UNIQUE INDEX IF NOT EXISTS idx_urls_shorted_url ON urls (shorted_url);
CREATE INDEX IF NOT EXISTS idx_urls_original_url ON urls (original_url);