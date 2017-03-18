SELECT * FROM address_book.citizen;
select count(*) as people_sum from address_book.citizen; /*Вывести общее число жителей*/
select avg(age) as sredn_vozrast from address_book.citizen; /*Вывести средний возраст жителей */
select distinct last_name from address_book.citizen 
	order by last_name; /*Вывести отсортированный по алфавиту список фамилий без повторений*/
select last_name, count(last_name) as count
	from address_book.citizen group by last_name; /*Вывести список фамилий, с указанием количества повторений этих фамилий в общем списке*/
select last_name from address_book.citizen where last_name like '_%н%_'; /*Вывести фамилии, которые содержат в середине букву «n»*/
select * from address_book.citizen where street_id is null; /*Вывести список «бомжей»*/
select * from address_book.citizen where street_id is null having age <18; /*Вывести список несовершеннолетних, проживающих на улице*/
select s.street_name, count(last_name) from address_book.street s
	inner join address_book.citizen c on s.id = c.street_id group by s.street_name;
/*Вывести упорядоченный по алфавиту список всех улиц с указанием, 
сколько жильцов живет на улице*/
select distinct street_name from address_book.street where street_name like '______';
/*Вывести список улиц, название которых состоит из 6-ти букв*/
select s.street_name from address_book.street s
	inner join address_book.citizen c on s.id = c.street_id 
     group by s.street_name having count(last_name) < 3;
     /*Вывести список улиц с количеством жильцов на них меньше 3*/