INSERT INTO tb_episode (id, name, synopsis, episode_order, video_url, seconds_long, created_at, updated_at, course_id) VALUES
(uuid_generate_v4(), 'Introdução ao Curso', 'Este episódio apresenta o curso e o instrutor.', 1, 'https://example.com/video1.mp4', 600, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'eb0b57bb-cb08-4aec-bed8-40383013a4b0'),
(uuid_generate_v4(), 'Primeiros Passos', 'Neste episódio, você aprenderá como configurar seu ambiente de desenvolvimento.', 2, 'https://example.com/video2.mp4', 1200, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'eb0b57bb-cb08-4aec-bed8-40383013a4b0'),
(uuid_generate_v4(), 'Conceitos Básicos', 'Vamos abordar os conceitos básicos e a sintaxe da linguagem.', 3, 'https://example.com/video3.mp4', 1500, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'eb0b57bb-cb08-4aec-bed8-40383013a4b0'),
(uuid_generate_v4(), 'Projeto Prático', 'Aplique o que aprendeu em um projeto prático.', 4, 'https://example.com/video4.mp4', 1800, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'eb0b57bb-cb08-4aec-bed8-40383013a4b0');

INSERT INTO tb_episode (id, name, synopsis, episode_order, video_url, seconds_long, created_at, updated_at, course_id) VALUES
(uuid_generate_v4(), 'HTML e CSS', 'Aprenda os fundamentos de HTML e CSS.', 1, 'https://example.com/video5.mp4', 900, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '81ca5d36-549e-4432-a926-e9ff7d3da5c5'),
(uuid_generate_v4(), 'JavaScript Básico', 'Introdução ao JavaScript e suas funcionalidades básicas.', 2, 'https://example.com/video6.mp4', 1300, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '81ca5d36-549e-4432-a926-e9ff7d3da5c5'),
(uuid_generate_v4(), 'Desenvolvendo um Site', 'Crie um site completo usando HTML, CSS e JavaScript.', 3, 'https://example.com/video7.mp4', 1600, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '81ca5d36-549e-4432-a926-e9ff7d3da5c5'),
(uuid_generate_v4(), 'Desafios de Programação', 'Desafios práticos para reforçar seu aprendizado.', 4, 'https://example.com/video8.mp4', 1400, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '81ca5d36-549e-4432-a926-e9ff7d3da5c5');
