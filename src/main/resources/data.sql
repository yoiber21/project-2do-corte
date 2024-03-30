INSERT INTO "category" ("id", "description", "created_at")
VALUES (1, 'Perecedero', '2021-12-31');

INSERT INTO "category" ("id", "description", "created_at")
VALUES (2, 'Refrigerado', '2021-12-31');

INSERT INTO "category" ("id", "description", "created_at")
VALUES (3, 'Fruta', '2021-12-31');

insert into "user" ("id", "first_name", "last_name", "email", "username", "password", "phone", "address", "rol", "created_at")
values (1, 'Yoiber', 'Beitar', 'yoiberbeitddar@gmail.com',
        'yoibdder', '$2a$10$hVMJlvPXA84ocnux6WScVOvryCdNG9EP6vLFkuPY.KsVPODxNorJG', '3044508092', 'calle 6d #1-58 E	',
        'ADMINISTRATOR', '2024-03-29');

-- Insert products for category 1 (Perecedero)
INSERT INTO "product" ("name", "description", "price", "category_id", "created_at")
VALUES ('Manzana', 'Fruta fresca', 0.5, 1, '2022-01-01');

INSERT INTO "product" ("name", "description", "price", "category_id", "created_at")
VALUES ('Pera', 'Fruta fresca', 0.6, 1, '2022-01-01');

INSERT INTO "product" ("name", "description", "price", "category_id", "created_at")
VALUES ('Plátano', 'Fruta fresca', 0.3, 1, '2022-01-01');

INSERT INTO "product" ("name", "description", "price", "category_id", "created_at")
VALUES ('Naranja', 'Fruta fresca', 0.4, 1, '2022-01-01');

INSERT INTO "product" ("name", "description", "price", "category_id", "created_at")
VALUES ('Melón', 'Fruta fresca', 1.0, 1, '2022-01-01');

INSERT INTO "product" ("name", "description", "price", "category_id", "created_at")
VALUES ('Sandía', 'Fruta fresca', 1.5, 1, '2022-01-01');

-- Insert products for category 2 (Refrigerado)
INSERT INTO "product" ("name", "description", "price", "category_id", "created_at")
VALUES ('Leche', 'Producto lácteo', 1.2, 2, '2022-01-01');

INSERT INTO "product" ("name", "description", "price", "category_id", "created_at")
VALUES ('Queso', 'Producto lácteo', 2.0, 2, '2022-01-01');

INSERT INTO "product" ("name", "description", "price", "category_id", "created_at")
VALUES ('Yogur', 'Producto lácteo', 0.8, 2, '2022-01-01');

INSERT INTO "product" ("name", "description", "price", "category_id", "created_at")
VALUES ('Mantequilla', 'Producto lácteo', 1.5, 2, '2022-01-01');

INSERT INTO "product" ("name", "description", "price", "category_id", "created_at")
VALUES ('Nata', 'Producto lácteo', 1.0, 2, '2022-01-01');

INSERT INTO "product" ("name", "description", "price", "category_id", "created_at")
VALUES ('Helado', 'Producto lácteo', 2.5, 2, '2022-01-01');

-- Insert products for category 3 (Fruta)
INSERT INTO "product" ("name", "description", "price", "category_id", "created_at")
VALUES ('Fresas', 'Fruta fresca', 1.0, 3, '2022-01-01');

INSERT INTO "product" ("name", "description", "price", "category_id", "created_at")
VALUES ('Cerezas', 'Fruta fresca', 1.5, 3, '2022-01-01');

INSERT INTO "product" ("name", "description", "price", "category_id", "created_at")
VALUES ('Uvas', 'Fruta fresca', 1.2, 3, '2022-01-01');

INSERT INTO "product" ("name", "description", "price", "category_id", "created_at")
VALUES ('Kiwi', 'Fruta fresca', 0.7, 3, '2022-01-01');

INSERT INTO "product" ("name", "description", "price", "category_id", "created_at")
VALUES ('Piña', 'Fruta fresca', 2.0, 3, '2022-01-01');

INSERT INTO "product" ("name", "description", "price", "category_id", "created_at")
VALUES ('Mango', 'Fruta fresca', 1.5, 3, '2022-01-01');