/*1.найти курсы в названии которых есть слово Ubuntu и стоимость больше 500 */
select * from courses where title like "%ubuntu%" having price > 500;
/*2. найти второго  сотрудника с самой большой зарплатой, не первого (подсказка, у LIMIT есть 2 параметра) */
select * from employees order by salary desc LIMIT 1,1;
/*3. добавить в таблицу сотрудников любого однофамильца и запросом найти фамилии, которые встречаются более 1 раза */
select * from employees group by name_last having count(name_last) > 1;
/*4. вывести id сотрудника у которого больше всего материальных ценностей (таблица employees_tangibles)*/
select employee_id, sum(price) from employees_tangibles e inner join tangibles t on e.tangible_id = t.id 
group by employee_id order by sum(price) desc limit 1;
/*5. из таблицы tangibles найти все стулья ценой больше 570*/
select * from tangibles where title like "%стул%" and price > 570;
/*6. из таблицы salaries_paid вывести все записи с salary больше-равно 1200 и меньше 100*/
select * from salaries_paid where salary >= 1200 or salary < 100;
/*7. найти одним запросом минимальную зарплату, максимальную зарплату и количество сотрудников */
select max(salary), min(salary), count(*)employe_sum from employees;
/*8. в таблице employees_courses найти id сотрудников, которые  окончили 2 курса */
select employee_id from employees_courses group by employee_id having count(course_id) = 2;
/*9. из salaries_paid выбрать все записи кроме! марта и августа, отсортировав по date_create */
select * from salaries_paid where date_pay not like "%-08-%" and date_pay not like "%-03-%"  ;
/*10. из таблицы tangibles выбрать либо столы стоимостью меньше 1300, либо другие предметы кроме столов, 
стоимостью больше 1000, отсортировать предметы по стоимости*/
select * from tangibles where (title like "%стол%" and price < 1300) or (title not like "%стол%" and price >1000);


