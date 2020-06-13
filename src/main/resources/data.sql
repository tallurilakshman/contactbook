
create table contact(
  cid INT PRIMARY KEY,
  name VARCHAR(250) NULL,
  email VARCHAR(250) NULL,
  mobile VARCHAR(250) NULL
);

INSERT INTO contact (cid, name, email, mobile) VALUES
  (1, 'Pradeep', 'pradeep@gmail.com', '1234'),
(2, 'Praveen', 'praveen@gmail.com', '1234'),
(3, 'John', 'john@gmail.com', '1234');

CREATE TABLE address (
    aid int NOT NULL,
    city varchar(20),
    state varchar(20),
    cid int,
    PRIMARY KEY (aid),
    FOREIGN KEY (cid) REFERENCES contact(cid)
);

insert into address values(1,'hyd','TS',1),
(2,'hyd','TS',2),
(3,'Kmm','TS',3);