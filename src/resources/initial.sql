create table test_order (
    order_id varchar(10) primary key,
    quantity int(5) not null,
    type varchar(10) not null
);

create table test_order_status (
   order_id varchar(10) not null,
   sequence int(5) not null,
   status varchar(20) not null,
   primary key (order_id, sequence),
   foreign key (order_id) references test_order(order_id)
);

insert into test_order (order_id, quantity, type) values ('order1', 2, 'PO');
insert into test_order (order_id, quantity, type) values ('order2', 33, 'PO');
insert into test_order (order_id, quantity, type) values ('order3', 10, 'REPLIN');
insert into test_order (order_id, quantity, type) values ('order4', 20, 'REPLOUT');
insert into test_order (order_id, quantity, type) values ('order5', 100, 'SO');

insert into test_order_status (order_id, sequence, status) values ('order1', 2, 'picked');
insert into test_order_status (order_id, sequence, status) values ('order1', 1, 'ordered');
insert into test_order_status (order_id, sequence, status) values ('order2', 3, 'out of delivery');
insert into test_order_status (order_id, sequence, status) values ('order2', 1, 'ordered');
insert into test_order_status (order_id, sequence, status) values ('order2', 2, 'shipped');
insert into test_order_status (order_id, sequence, status) values ('order5', 1, 'ordered');
insert into test_order_status (order_id, sequence, status) values ('order3', 2, 'shipped');
insert into test_order_status (order_id, sequence, status) values ('order3', 1, 'ordered');
insert into test_order_status (order_id, sequence, status) values ('order4', 4, 'delivered');
insert into test_order_status (order_id, sequence, status) values ('order4', 3, 'out of delivery');
insert into test_order_status (order_id, sequence, status) values ('order4', 1, 'ordered');
insert into test_order_status (order_id, sequence, status) values ('order4', 2, 'shipped');


--Error
insert into test_order_status values ('order4', 2, 'shipped');
insert into test_order_status values ('order6', 1, 'ordered');

select * from test_order;
select * from test_order_status;

SELECT tord.order_id, quantity, type, status, sequence
FROM   test_order tord, test_order_status tordsts
WHERE  tord.order_id = tordsts.order_id
  AND ( status, sequence ) IN (SELECT status, sequence
                               FROM   test_order_status
                               WHERE  sequence = (SELECT max(sequence)
                                                  FROM   test_order_status
                                                  WHERE order_id = tord.order_id) AND order_id = tord.order_id);

-- using inner join

SELECT tord.order_id, quantity, type, status, sequence
FROM   test_order tord inner join test_order_status tordsts
ON     tord.order_id = tordsts.order_id
WHERE  ( status, sequence ) IN (SELECT status, sequence
                                FROM   test_order_status
                                WHERE  sequence = (SELECT max(sequence)
                                                   FROM   test_order_status
                                                   WHERE order_id = tord.order_id) AND order_id = tord.order_id);

drop table test_order_status;
drop table test_order;
