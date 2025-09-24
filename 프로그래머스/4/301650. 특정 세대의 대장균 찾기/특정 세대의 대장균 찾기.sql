-- 코드를 작성해주세요
# select e3.ID
# from ECOLI_DATA e1 join (ECOLI_DATA e2 join ECOLI_DATA e3 on e3.PARENT_ID=e2.ID) on e2.PARENT_ID=e1.ID 
# where e1.PARENT_ID=NULL
# order By e3.ID;

select e3.ID
from ECOLI_DATA e1 join (ECOLI_DATA e2 join ECOLI_DATA e3 on e3.PARENT_ID=e2.ID) on e2.PARENT_ID=e1.ID
where e1.PARENT_ID IS NULL
order by e3.ID;