SELECT Email FROM Person GROUP BY Email HAVING COUNT(*) > 1;
#Notice that sometimes newline causes internal error..............