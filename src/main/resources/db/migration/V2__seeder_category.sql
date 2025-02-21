ALTER TABLE tb_category ALTER COLUMN id SET DEFAULT uuid_generate_v4();

INSERT INTO tb_category (name, position, created_at, updated_at) VALUES
('Desenvolvimento Web', 1, NOW(), NOW()),
('Desenvolvimento Mobile', 2, NOW(), NOW()),
('Data Science', 3, NOW(), NOW()),
('Inteligência Artificial', 4, NOW(), NOW()),
('Cibersegurança', 5, NOW(), NOW());