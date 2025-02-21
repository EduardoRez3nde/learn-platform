CREATE EXTENSION IF NOT EXISTS "uuid-ossp";


CREATE TABLE tb_category (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    position INTEGER NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE tb_course (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    synopsis TEXT NOT NULL,
    thumbnail_url VARCHAR(255) NOT NULL,
    featured BOOLEAN NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    category_id UUID NOT NULL,
    FOREIGN KEY (category_id) REFERENCES tb_category(id)
);

CREATE TABLE tb_episode (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    synopsis TEXT NOT NULL,
    episode_order INT NOT NULL,
    video_url VARCHAR(255) NOT NULL,
    seconds_long BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    course_id UUID NOT NULL,
    FOREIGN KEY (course_id) REFERENCES tb_course(id)
);

CREATE TABLE tb_user (
    id UUID PRIMARY KEY,
    firstname VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    phone VARCHAR(20),
    birth_date DATE,
    email VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tb_like (
    user_id UUID NOT NULL,
    course_id UUID NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id, course_id),
    FOREIGN KEY (user_id) REFERENCES tb_user(id) ON DELETE CASCADE,
    FOREIGN KEY (course_id) REFERENCES tb_course(id) ON DELETE CASCADE
);

CREATE TABLE tb_watch_time (
    user_id UUID NOT NULL,
    episode_id UUID NOT NULL,
    seconds BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id, episode_id),
    FOREIGN KEY (user_id) REFERENCES tb_user(id) ON DELETE CASCADE,
    FOREIGN KEY (episode_id) REFERENCES tb_episode(id) ON DELETE CASCADE
);

CREATE TABLE tb_favorite (
    user_id UUID NOT NULL,
    course_id UUID NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    PRIMARY KEY (user_id, course_id),
    CONSTRAINT fk_user
        FOREIGN KEY (user_id)
        REFERENCES tb_user (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT fk_course
        FOREIGN KEY (course_id)
        REFERENCES tb_course (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE tb_role (
    id UUID PRIMARY KEY,
    authority VARCHAR NOT NULL
);

CREATE TABLE tb_user_role (
    user_id UUID NOT NULL,
    role_id UUID NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES tb_user(id),
    FOREIGN KEY (role_id) REFERENCES tb_role(id)
);


-- UPDATE tb_users
-- SET password = crypt('default_password', gen_salt('bf'));