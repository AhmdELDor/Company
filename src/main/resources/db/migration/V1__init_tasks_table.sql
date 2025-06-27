CREATE TABLE task (
    id UUID PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    description VARCHAR(500),
    completed BOOLEAN DEFAULT FALSE
);