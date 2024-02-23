Q1. select act_fname + act_lname from Actor 
where act_id in 
(select act_id from movie_cast group by act_id having count(mov_id) > 1 )


Q2. select count( distinct  d.dir_id) from movie_cast mt inner join movie_direction md on mt.mov_id  = md.mov_id inner join Actor ar on mt.act_id = ar.act_id inner join director d on d.dir_id = md.dir_id
where d.dir_fname != ar.act_fname


Q3.



Q4.  select COUNT( table1.mov_id) from 
(
select mov_id from movie_genres group by mov_id having count(gen_id) > 1 ) as table1



Q5.select * from Actor where act_id in (
(select act_id from movie_cast mt inner join 
(select TOP(3) mov_id from movie where mov_id in (
select mov_id from movie_genres ms inner join genres gs on ms.gen_id = gs.gen_id where gen_title like 'Action') order by mov_dt_rel DESC ) as t1 on t1.mov_id = mt.mov_id )  ) and act_gender like 'F'



Q6.select * from movie where mov_title like '%MAN'



Q7. select * from Actor where act_id not in (
select act_id from movie_cast mt inner join movie ms on mt.mov_id = ms.mov_id where YEAR(mov_dt_rel) = 2015 )





Q8.  select mov_title from movie where mov_id in (
select mov_id from (select *,  DENSE_RANK() over(order by rev_stars DESC) as rank from rating ) as t1  where t1.rank = 2  )



Q9. create view Top_Rating_Flag as
select * ,
Top_Rating_Flag = CASE 
							when rev_stars > 8 then 'Y'
							when rev_stars < 8 then 'N'
							when rev_stars is NULL then 'N'
							end
from rating









Q10.    Alter table Rating add constraint mycnstrnt check ( rev_stars <= 10)






Q11.    select * from director where dir_id in (
select dir_id from movie_direction md inner join movie_genres mgs on md.mov_id = mgs.mov_id group by dir_id having count(distinct gen_id) > 1  )




Q12.     select * from Actor where act_id in (
select act_id from movie_cast where mov_id in (
select top(1) mov_id  from movie order by mov_time DESC ) )
