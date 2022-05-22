CREATE TABLE INVENTORY(
    "ID" VARCHAR(36) NOT NULL,
    "ARTICLE_ID" VARCHAR(36) NOT NULL,
    "QUANTITY" NUMBER
);

CREATE TABLE PRODUCT(
    "ID" VARCHAR(36) NOT NULL,
    "EXTERNAL_ID" VARCHAR(20) NOT NULL,
    "NAME" VARCHAR(50) NOT NULL
);