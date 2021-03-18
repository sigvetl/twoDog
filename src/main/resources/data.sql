
insert into beer(beerid, name, type, ibu, recipelink) values
(1, 'lucky jack', 'pale ale', 60, 'http://www.vg.no'),
(2, 'ringnes', 'pilsner', 40, 'http://www.dagbladet.no');

insert into batch(batchid, volume, beerid, og, brewdate)
values(1, 25, 1, 1.06, DATE '2020-09-09'),
(2, 23, 1, 1.04, DATE '2020-10-09');


insert into users(userid, username, salt, password, firstname, lastname)
values(1, 's', 'Mk/9Dumyc5bWIWgSOZYLag==', 'GKNOOrWrmodB5A9/xrS97g==', 's', 's'),
(2, 'admin', 'Ijwttlok9ZNx8KcByvw5TA==', 'T6QfZMTOTQ3qoE0HfHv4hw==', 'admin', 'admin');

