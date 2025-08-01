# Write your MySQL query statement below
Select today.id from Weather as today inner join  Weather as yesterday on
DateDiff(today.recordDate, yesterday.recordDate) = 1 where today.temperature > yesterday.temperature;