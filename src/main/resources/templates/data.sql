insert into beer(beerid, name, type, ibu, recipelink) values
(1, 'lucky jack', 'pale ale', 60, 'http://www.vg.no'),
(2, 'ringnes', 'pilsner', 40, 'http://www.dagbladet.no');

insert into batch(batchid, volume, beerid, og, brewdate)
values(1, 25, 1, 1.06, 2020-09-30),
(2, 23, 1, 1.04, 2020-10-30);