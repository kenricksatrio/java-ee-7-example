INSERT INTO ProductCategory(id, name, createdAt, updatedAt) VALUES (3, 'Category 3', CURRENT_TIME() , CURRENT_TIME()  );
INSERT INTO ProductCategory(id, name, createdAt, updatedAt) VALUES (5, 'Category 5', CURRENT_TIME() , CURRENT_TIME()  );
INSERT INTO ProductCategory(id, name, createdAt, updatedAt) VALUES (2, 'Category 2', CURRENT_TIME() , CURRENT_TIME()  );
INSERT INTO ProductCategory(id, name, createdAt, updatedAt) VALUES (4, 'Category 4', CURRENT_TIME() , CURRENT_TIME()  );
INSERT INTO ProductCategory(id, name, createdAt, updatedAt) VALUES (1, 'Category 1', CURRENT_TIME() , CURRENT_TIME()  );
INSERT INTO Product(id, name, price, category_id, createdAt, updatedAt) VALUES (6, 'Product 1', 1000, 1, CURRENT_TIME(), CURRENT_TIME()  );
UPDATE hibernate_sequence SET NEXT_VAL = 7;