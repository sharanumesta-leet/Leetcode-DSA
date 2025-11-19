# Write your MySQL query statement below
select
    transaction_date,
    sum(case amount % 2 when 1 then amount else 0 end) as odd_sum,
    sum(case amount % 2 when 0 then amount else 0 end) as even_sum
from transactions
group by transaction_date
order by transaction_date asc;