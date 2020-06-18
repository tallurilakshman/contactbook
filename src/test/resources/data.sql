
create table contact(
  cid INT PRIMARY KEY auto_increment,
  name VARCHAR(250) NULL,
  email VARCHAR(250) NULL,
  mobile VARCHAR(250) NULL
);

INSERT INTO contact (name, email, mobile) VALUES
  ('Pradeep', 'pradeep@gmail.com', '1234'),
( 'Praveen', 'praveen@gmail.com', '1234'),
( 'John', 'john@gmail.com', '1234');

CREATE TABLE address (
    aid int primary key auto_increment,
    city varchar(20),
    state varchar(20),
    cid int,
    FOREIGN KEY (cid) REFERENCES contact(cid)
);

insert into address(city,state,cid) values('hyd','TS',1),
('hyd','TS',2),
('Kmm','TS',3);