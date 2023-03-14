-- 코드를 입력하세요
SELECT CATEGORY, SUM(SALES)
FROM BOOK AS B INNER JOIN BOOK_SALES AS BS
ON B.BOOK_ID = BS.BOOK_ID
WHERE SALES_DATE LIKE '2022-01-%'
GROUP BY CATEGORY
ORDER BY CATEGORY