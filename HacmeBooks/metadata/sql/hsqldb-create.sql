/*******************************************************************************
The order of these drop statements is critical due to foreign key constraints
*******************************************************************************/
drop table users_roles if exists;
--drop table users_addresses if exists;
drop table addresses if exists;
drop table roles if exists;
drop table order_items if exists;
drop table inventory if exists;
drop table orders if exists;
drop table users if exists;
drop table feedback if exists;
drop table products if exists;
drop table product_category if exists;
drop table vendors if exists;
drop table sales_tax_lookup if exists;
drop table discount_codes if exists;
drop table partners if exists;
drop table order_numbers if exists;


/*******************************************************************************
USERS TABLE

This is where the user login info is stored
*******************************************************************************/
create table users (
  id int generated by default as identity,
  username varchar(16) not null,
  password varchar(255) not null,
  ssn varchar(13),
  first_name varchar(16) not null,
  last_name varchar(16) not null,
  email varchar(255) not null,
  phone char(12) not null,
  password_hint LONGVARCHAR not null,
  unique(username),
  primary key (id)
);


/*******************************************************************************
ROLES TABLE

Business Roles should be defined here
*******************************************************************************/
create table roles (
  rolename varchar(16) not null,
  description varchar(255),
  primary key (rolename)
);

/*******************************************************************************
USERS_ROLES TABLE

M:N Relationship table to map users to roles
*******************************************************************************/
create table users_roles (
	rolename varchar(16),
	username varchar(16),
	foreign key(rolename) references roles(rolename) on delete cascade,
	foreign key(username) references users(username) on delete cascade
);

/*******************************************************************************
ADDRESS TABLE

This is a table to store both user address data and vendor addresses
*******************************************************************************/
create table addresses (
  id int generated by default as identity,
  ship_to_name varchar(255) not null,
  ship_to_phone varchar(11),
  street_number varchar(6) not null,
  street_name varchar(128) not null,
  city varchar(128) not null,
  state varchar(128) not null,
  zip varchar(10) not null,
  user_id_FK int not null,
  foreign key (user_id_FK) references users(id) on delete cascade,
  primary key(id)
);

/*******************************************************************************
VENDOR TABLE

This is a list of vendors.  It might be extended eventually for misc purposes
like federation.  For now it will just be a common place to store vendor
information.
*******************************************************************************/
create table vendors (
  id int generated by default as identity,
  name varchar(128) not null,
  description varchar(255),
  abbrev varchar(3),
  primary key (id)
);

/*******************************************************************************
PRODUCT_CATEGORY TABLE
*******************************************************************************/
create table product_category (
  id int generated by default as identity,
  title varchar(255),
  description LONGVARCHAR,
  primary key (id)
);

/*******************************************************************************
PRODUCTS TABLE

This is a table that will store all of the possible products that the store
might sell.  It is not an inventory.
*******************************************************************************/
create table products (
  id int generated by default as identity,
  title varchar(255) not null,
  description LONGVARCHAR,
  popularity int default 0,
  price float not null,
  vendor varchar(255),
  category varchar(255),
  publisher LONGVARCHAR,
  isbn char(13),
  author LONGVARCHAR,
  imgurl varchar(255),
  quantity int default 0,
  primary key (id)
);

/*******************************************************************************
INVENTORY TABLE

This is a table that will track inventory of products.

The locator_key might be used in coordination with a tracking system.  It can
also be used when there are multiple warehouses.
*******************************************************************************/
create table inventory (
  id int generated by default as identity,
  locator_key varchar(255) not null,
  serial varchar(128),
  uid varchar(128) not null ,
  product_id_FK int not null,
  active smallint default 1,
  unique(uid),
  foreign key (product_id_FK) references products(id) on delete cascade,
  primary key (id)
);

/*******************************************************************************
ORDERS TABLE

This table carries rows of orders that reference specific customer orders.  It
does not actually contain a list of the items, but acts as the parent row for
the itmes in the order.  This is basically a manifest placeholder (i think?)
*******************************************************************************/
create table orders (
  id int generated by default as identity,
  order_number bigint not null ,
  users_id_FK int not null,
  sales_tax float,
  credit_card char(19),
  bank_account char(30),
  shipped char(1) default 'N',
  total varchar(8) not null,
  unique(order_number),
  foreign key(users_id_FK) references users(id) on delete cascade,  
  primary key (id)
);

/*******************************************************************************

*******************************************************************************/
create table order_items (
  id int generated by default as identity,
--  tax_percentage float not null,
  total_sale_price float not null,
  orders_id_FK int not null,
--  inventory_id_FK int not null,
  product_id_FK int not null,
  foreign key(orders_id_FK) references orders(id) on delete cascade,
--  foreign key(inventory_id_FK) references inventory(id),
  foreign key(product_id_FK) references products(id) on delete cascade,
  primary key (id)
);

/*******************************************************************************

*******************************************************************************/
create table sales_tax_lookup (
  id int generated by default as identity,
  primary key (id)
);

/*******************************************************************************

*******************************************************************************/
create table discount_codes (
  id int generated by default as identity,
  code varchar(16) not null,
  discount_percentage float not null,
  active smallint default 1,
  primary key (id)
);

/*******************************************************************************

*******************************************************************************/
create table partners (
  id int generated by default as identity,
  primary key (id)
);

/*******************************************************************************

*******************************************************************************/
create table feedback (
  id int generated by default as identity,
--  tax_percentage float not null,
  feedback LONGVARCHAR not null,
  product_id_FK int not null,
  foreign key(product_id_FK) references products(id) on delete cascade,
  primary key (id)
);

create table order_numbers (
	id int generated by default as identity,
	primary key	(id)
);
/* REMOVED FOR NOW.  THESE ARE TABLES I MIGHT NEED LATER                      */
/*******************************************************************************
USERS_ADDRESSES TABLE

M:N Relationship table to map addresses to users

NOTE:  I am not sure that this relationship is needed, but I am imaginging the
scenario of same address mapped to different users (i.e. Kids to parents
address).
*******************************************************************************/
/*create table users_addresses (
    id int generated by default as identity,
  user_id_FK int,
  users_addresses_id_FK int,
  foreign key (user_id_FK) references users(id),
  foreign key (users_addresses_id_FK) references users_addresses(id),
  primary key (id)
);*/