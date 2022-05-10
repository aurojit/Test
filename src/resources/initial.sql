create table test_order (
    order_id varchar(10) primary key,
    quantity int(5),
    type varchar(10)
);

create table test_order_status (
   order_id varchar(10),
   sequence int(5),
   status varchar(20),
   primary key (order_id, sequence)
);

insert into test_order values ('order1', 2, 'PO');
insert into test_order values ('order2', 33, 'PO');
insert into test_order values ('order3', 10, 'REPLIN');
insert into test_order values ('order4', 20, 'REPLOUT');
insert into test_order values ('order5', 100, 'SO');

insert into test_order_status values ('order1', 2, 'picked');
insert into test_order_status values ('order1', 1, 'ordered');
insert into test_order_status values ('order2', 3, 'out of delivery');
insert into test_order_status values ('order2', 1, 'ordered');
insert into test_order_status values ('order2', 2, 'shipped');
insert into test_order_status values ('order5', 1, 'ordered');
insert into test_order_status values ('order3', 2, 'shipped');
insert into test_order_status values ('order3', 1, 'ordered');
insert into test_order_status values ('order4', 4, 'delivered');
insert into test_order_status values ('order4', 3, 'out of delivery');
insert into test_order_status values ('order4', 1, 'ordered');
insert into test_order_status values ('order4', 2, 'shipped');

SELECT tord.order_id, quantity, type, status, sequence
FROM   test_order tord, test_order_status tordsts
WHERE  tord.order_id = tordsts.order_id
  AND ( status, sequence ) IN (SELECT status, sequence
                               FROM   test_order_status
                               WHERE  sequence = (SELECT max(sequence)
                                                  FROM   test_order_status
                                                  WHERE order_id = tord.order_id) AND order_id = tord.order_id);

drop table test_order;
drop table test_order_status;