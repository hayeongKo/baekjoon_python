-- 코드를 작성해주세요 1 또는 3을 포함하면서 2는 포함 x -
select count(*) AS COUNT
from ECOLI_DATA 
where (GENOTYPE & 2) = 0 AND ((GENOTYPE & 1) > 0 OR (GENOTYPE & 4) > 0)