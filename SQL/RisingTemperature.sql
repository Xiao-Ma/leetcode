SELECT s.Id
FROM Weather s, Weather t
WHERE s.Date = ADDDATE(t.Date, 1) AND s.Temperature > t.Temperature;