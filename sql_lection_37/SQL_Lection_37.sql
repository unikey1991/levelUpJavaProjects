
select * from tangibles;


select d.title, sum(price) as summ from employees e
left join employees_tangibles et on e.id = et.employee_id
left join tangibles t on et.tangible_id = t.id
left join departments d on e.department_id = d.id
group by e.id order by summ desc limit 1;