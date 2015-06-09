# Write your MySQL query statement below
#SET @i = 0;
SELECT Scores.Score AS Score, v1.Rank AS Rank
FROM Scores LEFT JOIN (
  SELECT Score, @i := @i + 1 AS Rank
  FROM (
    SELECT DISTINCT Score
    FROM Scores, (SELECT @i := 0) AS v0
    ORDER BY Score DESC) AS v
  ) AS v1
ON Scores.Score = v1.Score
ORDER BY Scores.Score DESC;