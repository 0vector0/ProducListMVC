INSERT INTO roles (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_USER');

INSERT INTO public.users (id, email, password, username)
VALUES (32, 'user@gmail.com', '$2a$10$kC6c0n25ldrmMijNworJqOeF2fMOoKkojHY01eqWBE7.AK89tvWAO', 'user');
INSERT INTO public.users (id, email, password, username)
VALUES (35, 'test@gmail.com', '$2a$10$3WzITXLLTMnXL0iAihXiZelFN46ypHZpXAWetYmfAgIXBVsI2pH1K', 'test');
INSERT INTO public.users (id, email, password, username)
VALUES (41, 'admin@gmail.com', '$2a$10$GsWe.5ij90t5FsWcXudBTum.zhEd2xKW0GmR6XZW/Hqh9GBkt.ypK', 'admin');

INSERT INTO public.user_role (user_id, role_id) VALUES (32, 2);

