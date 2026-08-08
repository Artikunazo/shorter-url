CREATE TABLE IF NOT EXISTS urls (
    id SERIAL PRIMARY KEY,
    shorted_url TEXT NOT NULL UNIQUE,
    original_url TEXT NOT NULL,
    date TIMESTAMP NOT NULL,
    app_user TEXT NOT NULL
);
