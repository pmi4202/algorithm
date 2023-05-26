SELECT U.USER_ID, U.NICKNAME, W.TOTAL FROM USED_GOODS_USER U INNER JOIN
(SELECT WRITER_ID, SUM(PRICE) TOTAL FROM USED_GOODS_BOARD WHERE STATUS='DONE'
GROUP BY WRITER_ID HAVING SUM(PRICE) >= 700000) W
ON U.USER_ID=W.WRITER_ID
ORDER BY W.TOTAL;