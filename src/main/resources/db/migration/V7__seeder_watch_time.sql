INSERT INTO tb_watch_time (user_id, episode_id, seconds, created_at, updated_at)
VALUES
    ('1e9639de-d683-4859-9ffc-0f79080a653a', 'aa0c9e32-bbfe-4311-8833-074ecdc63fa4', 1200, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('76d16100-2200-4d62-a618-d21549f4483c', '6edc06a5-2160-4378-9736-0a3da4b66f28', 600, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('c289d354-fd5e-4b27-a7ed-72631eb9314f', '6af38ae3-e106-40d3-91a6-87430d9981f7', 1800, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('5b4cfc90-e0f8-41d0-bb4f-b093f192984a', '06bf55ab-a7a9-486e-a288-750761b3a572', 900, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('5c86abba-c5e3-4fec-a1a5-e5e2af31a65c', '1fb1cbab-88b2-4dba-8347-6ba25ef08ae1', 3600, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO tb_favorite (user_id, course_id, created_at, updated_at)
VALUES
    ('5c86abba-c5e3-4fec-a1a5-e5e2af31a65c', '704c434c-2b11-43a5-aea1-a374a13fe551', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('1e9639de-d683-4859-9ffc-0f79080a653a', '81ca5d36-549e-4432-a926-e9ff7d3da5c5', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('c289d354-fd5e-4b27-a7ed-72631eb9314f', 'eb0b57bb-cb08-4aec-bed8-40383013a4b0', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('5b4cfc90-e0f8-41d0-bb4f-b093f192984a', '1c241cfe-f9c0-4902-ab5b-fdeaff9c5064', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('5c86abba-c5e3-4fec-a1a5-e5e2af31a65c', '1c241cfe-f9c0-4902-ab5b-fdeaff9c5064', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO tb_role (id, authority)
VALUES
    (uuid_generate_v4(), 'ROLE_USER'),
    (uuid_generate_v4(), 'ROLE_ADMIN');


INSERT INTO tb_user_role (user_id, role_id)
VALUES
    ((SELECT id FROM tb_user WHERE email='alice.silva@example.com'), (SELECT id FROM tb_role WHERE authority='ROLE_USER')),
    ((SELECT id FROM tb_user WHERE email='bob.souza@example.com'), (SELECT id FROM tb_role WHERE authority='ROLE_USER')),
    ((SELECT id FROM tb_user WHERE email='carol.lima@example.com'), (SELECT id FROM tb_role WHERE authority='ROLE_USER')),
    ((SELECT id FROM tb_user WHERE email='daniel.oliveira@example.com'), (SELECT id FROM tb_role WHERE authority='ROLE_ADMIN')),
    ((SELECT id FROM tb_user WHERE email='eve.costa@example.com'), (SELECT id FROM tb_role WHERE authority='ROLE_ADMIN'));