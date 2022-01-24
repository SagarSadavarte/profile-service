create table profile(
      address varchar_ignorecase(50) not null primary key,
      phoneNumber varchar_ignorecase(50) not null,
      enabled boolean not null);