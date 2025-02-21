CREATE EXTENSION IF NOT EXISTS pgcrypto;

INSERT INTO tb_user (id, firstname, lastname, phone, birth_date, email, password, created_at, updated_at)
VALUES
    (uuid_generate_v4(), 'Alice', 'Silva', '555-1234', '1995-05-15', 'alice.silva@example.com', crypt('password1', gen_salt('bf')), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (uuid_generate_v4(), 'Bob', 'Souza', '555-5678', '1990-03-10', 'bob.souza@example.com', crypt('password2', gen_salt('bf')), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (uuid_generate_v4(), 'Carol', 'Lima', '555-9012', '1988-07-22', 'carol.lima@example.com', crypt('password3', gen_salt('bf')), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (uuid_generate_v4(), 'Daniel', 'Oliveira', '555-3456', '1993-09-08', 'daniel.oliveira@example.com', crypt('password4', gen_salt('bf')), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (uuid_generate_v4(), 'Eve', 'Costa', '555-7890', '2000-12-05', 'eve.costa@example.com', crypt('password5', gen_salt('bf')), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
