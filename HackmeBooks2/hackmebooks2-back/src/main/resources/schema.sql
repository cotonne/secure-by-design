DROP TABLE ORDER_NUMBERS IF EXISTS;
DROP TABLE FEEDBACK IF EXISTS;
DROP TABLE PARTNERS IF EXISTS;
DROP TABLE DISCOUNT_CODES IF EXISTS;
DROP TABLE SALES_TAX_LOOKUP IF EXISTS;
DROP TABLE ORDER_ITEMS IF EXISTS;
DROP TABLE ORDERS IF EXISTS;
DROP TABLE INVENTORY IF EXISTS;
DROP TABLE PRODUCTS IF EXISTS;
DROP TABLE PRODUCT_CATEGORY IF EXISTS;
DROP TABLE VENDORS IF EXISTS;
DROP TABLE ADDRESSES IF EXISTS;
DROP TABLE USER_ROLES IF EXISTS;
DROP TABLE ROLES IF EXISTS;
DROP TABLE GROUP_MEMBERS IF EXISTS;
DROP TABLE GROUP_AUTHORITIES IF EXISTS;
DROP TABLE GROUPS IF EXISTS;
DROP TABLE AUTHORITIES IF EXISTS;
DROP TABLE USERS IF EXISTS;

CREATE TABLE USERS
(
    ID            INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 0) NOT NULL PRIMARY KEY,
    USERNAME      VARCHAR(16)                                             NOT NULL,
    PASSWORD      VARCHAR(255)                                            NOT NULL,
    SSN           VARCHAR(13),
    FIRST_NAME    VARCHAR(16)                                             NOT NULL,
    LAST_NAME     VARCHAR(16)                                             NOT NULL,
    EMAIL         VARCHAR(255)                                            NOT NULL,
    PHONE         CHAR(12)                                                NOT NULL,
    PASSWORD_HINT LONGVARCHAR                                             NOT NULL,
    CONSTRAINT SYS_CT_82 UNIQUE (USERNAME)
);

-- Spring Security Database Schema
-- cf. https://docs.spring.io/spring-security/site/docs/current/reference/html5/#appendix-schema
CREATE TABLE AUTHORITIES
(
    USERNAME  VARCHAR_IGNORECASE(50) NOT NULL,
    AUTHORITY VARCHAR_IGNORECASE(50) NOT NULL,
    CONSTRAINT FK_AUTHORITIES_USERS FOREIGN KEY (USERNAME) REFERENCES USERS (USERNAME)
);

CREATE TABLE GROUPS
(
    ID         BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 0) PRIMARY KEY,
    GROUP_NAME VARCHAR_IGNORECASE(50) NOT NULL
);

CREATE TABLE GROUP_AUTHORITIES
(
    GROUP_ID  BIGINT      NOT NULL,
    AUTHORITY VARCHAR(50) NOT NULL,
    CONSTRAINT FK_GROUP_AUTHORITIES_GROUP FOREIGN KEY (GROUP_ID) REFERENCES GROUPS (ID)
);

CREATE TABLE GROUP_MEMBERS
(
    ID       BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 0) PRIMARY KEY,
    USERNAME VARCHAR(50) NOT NULL,
    GROUP_ID BIGINT      NOT NULL,
    CONSTRAINT FK_GROUP_MEMBERS_GROUP FOREIGN KEY (GROUP_ID) REFERENCES GROUPS (ID)
);
--

CREATE TABLE ROLES
(
    ID          INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 0) NOT NULL PRIMARY KEY,
    ROLE        VARCHAR(16)                                             NOT NULL,
    DESCRIPTION VARCHAR(255)
);
CREATE TABLE USER_ROLES
(
    ROLE_ID INTEGER,
    USER_ID INTEGER,
    CONSTRAINT SYS_FK_84 FOREIGN KEY (ROLE_ID) REFERENCES ROLES (ID) ON DELETE CASCADE,
    CONSTRAINT SYS_FK_85 FOREIGN KEY (USER_ID) REFERENCES USERS (ID) ON DELETE CASCADE
);
CREATE TABLE ADDRESSES
(
    ID            INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 0) NOT NULL PRIMARY KEY,
    SHIP_TO_NAME  VARCHAR(255)                                            NOT NULL,
    SHIP_TO_PHONE VARCHAR(11),
    STREET_NUMBER VARCHAR(6)                                              NOT NULL,
    STREET_NAME   VARCHAR(128)                                            NOT NULL,
    CITY          VARCHAR(128)                                            NOT NULL,
    STATE         VARCHAR(128)                                            NOT NULL,
    ZIP           VARCHAR(10)                                             NOT NULL,
    USER_ID_FK    INTEGER                                                 NOT NULL,
    CONSTRAINT SYS_FK_90 FOREIGN KEY (USER_ID_FK) REFERENCES USERS (ID) ON DELETE CASCADE
);
CREATE TABLE VENDORS
(
    ID          INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 0) NOT NULL PRIMARY KEY,
    NAME        VARCHAR(128)                                            NOT NULL,
    DESCRIPTION VARCHAR(255),
    ABBREV      VARCHAR(3)
);
CREATE TABLE PRODUCT_CATEGORY
(
    ID          INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 0) NOT NULL PRIMARY KEY,
    TITLE       VARCHAR(255),
    DESCRIPTION LONGVARCHAR
);
CREATE TABLE PRODUCTS
(
    ID          INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 0) NOT NULL PRIMARY KEY,
    TITLE       VARCHAR(255)                                            NOT NULL,
    DESCRIPTION LONGVARCHAR,
    POPULARITY  INTEGER DEFAULT 0,
    PRICE       FLOAT                                                   NOT NULL,
    VENDOR      VARCHAR(255),
    CATEGORY    VARCHAR(255),
    PUBLISHER   LONGVARCHAR,
    ISBN        CHAR(13),
    AUTHOR      LONGVARCHAR,
    IMGURL      VARCHAR(255),
    QUANTITY    INTEGER DEFAULT 0
);
CREATE TABLE INVENTORY
(
    ID            INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 0) NOT NULL PRIMARY KEY,
    LOCATOR_KEY   VARCHAR(255)                                            NOT NULL,
    SERIAL        VARCHAR(128),
    UID           VARCHAR(128)                                            NOT NULL,
    PRODUCT_ID_FK INTEGER                                                 NOT NULL,
    ACTIVE        SMALLINT DEFAULT 1,
    CONSTRAINT SYS_CT_93 UNIQUE (UID),
    CONSTRAINT SYS_FK_94 FOREIGN KEY (PRODUCT_ID_FK) REFERENCES PRODUCTS (ID) ON DELETE CASCADE
);
CREATE TABLE ORDERS
(
    ID           INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 0) NOT NULL PRIMARY KEY,
    ORDER_NUMBER BIGINT                                                  NOT NULL,
    USERS_ID_FK  INTEGER                                                 NOT NULL,
    SALES_TAX    FLOAT,
    CREDIT_CARD  CHAR(19),
    SHIPPED      CHAR(1) DEFAULT 'N',
    TOTAL        VARCHAR(8)                                              NOT NULL,
    BANK_ACCOUNT CHAR(30),
    CONSTRAINT SYS_CT_98 UNIQUE (ORDER_NUMBER),
    CONSTRAINT SYS_FK_99 FOREIGN KEY (USERS_ID_FK) REFERENCES USERS (ID) ON DELETE CASCADE
);
CREATE TABLE ORDER_ITEMS
(
    ID               INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 0) NOT NULL PRIMARY KEY,
    TOTAL_SALE_PRICE FLOAT                                                   NOT NULL,
    ORDERS_ID_FK     INTEGER                                                 NOT NULL,
    PRODUCT_ID_FK    INTEGER                                                 NOT NULL,
    CONSTRAINT SYS_FK_103 FOREIGN KEY (ORDERS_ID_FK) REFERENCES ORDERS (ID) ON DELETE CASCADE,
    CONSTRAINT SYS_FK_104 FOREIGN KEY (PRODUCT_ID_FK) REFERENCES PRODUCTS (ID) ON DELETE CASCADE
);
CREATE TABLE SALES_TAX_LOOKUP
(
    ID INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 0) NOT NULL PRIMARY KEY
);
CREATE TABLE DISCOUNT_CODES
(
    ID                  INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 0) NOT NULL PRIMARY KEY,
    CODE                VARCHAR(16)                                             NOT NULL,
    DISCOUNT_PERCENTAGE FLOAT                                                   NOT NULL,
    ACTIVE              SMALLINT DEFAULT 1
);
CREATE TABLE PARTNERS
(
    ID INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 0) NOT NULL PRIMARY KEY
);
CREATE TABLE FEEDBACK
(
    ID            INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 0) NOT NULL PRIMARY KEY,
    FEEDBACK      LONGVARCHAR                                             NOT NULL,
    PRODUCT_ID_FK INTEGER                                                 NOT NULL,
    CONSTRAINT SYS_FK_109 FOREIGN KEY (PRODUCT_ID_FK) REFERENCES PRODUCTS (ID) ON DELETE CASCADE
);
CREATE TABLE ORDER_NUMBERS
(
    ID INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 0) NOT NULL PRIMARY KEY
);
