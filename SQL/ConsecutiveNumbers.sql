SELECT DISTINCT s.Num FROM Logs s, Logs t, Logs u
WHERE s.Num = t.Num AND s.Num = u.Num AND t.Id = s.Id - 1 AND t.Id = s.Id + 1;