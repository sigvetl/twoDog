
insert into users(userid, username, salt, password, firstname, lastname)
values(1, 's', 'Mk/9Dumyc5bWIWgSOZYLag==', 'GKNOOrWrmodB5A9/xrS97g==', 's', 's'),
(2, 'admin', 'Ijwttlok9ZNx8KcByvw5TA==', 'T6QfZMTOTQ3qoE0HfHv4hw==', 'admin', 'admin');

insert into beer(beerid, name, type, ibu, recipelink, userid) values
(1, 'lucky jack', 'pale ale', 60, 'http://www.vg.no', 1),
(2, 'ringnes', 'pilsner', 40, 'http://www.dagbladet.no', 1);

insert into batch(batchid, volume, beerid, og, fg, abv, brewdate, userid)
values(1, 25, 1, 1.06, 1.012, 0.05, DATE '2020-09-09', 2),
(2, 23, 1, 1.04, 1.010, 0.048, DATE '2020-10-09', 1);



