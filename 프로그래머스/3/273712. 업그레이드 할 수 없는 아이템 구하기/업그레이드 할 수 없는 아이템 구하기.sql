-- 코드를 작성해주세요
SELECT FI.ITEM_ID, ITEM_NAME, RARITY
FROM ITEM_INFO AS FI JOIN ITEM_TREE AS IT ON FI.ITEM_ID = IT.ITEM_ID
WHERE IT.ITEM_ID NOT IN (SELECT PARENT_ITEM_ID FROM ITEM_TREE WHERE PARENT_ITEM_ID IS NOT NULL)
ORDER BY FI.ITEM_ID DESC;