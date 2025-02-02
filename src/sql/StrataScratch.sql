/*
 https://platform.stratascratch.com/coding/2009-users-with-two-statuses?code_type=1
 */
SELECT user_id
FROM twitch_sessions
GROUP BY user_id
HAVING COUNT(DISTINCT session_type) = 2;

/*
 https://leetcode.com/problems/recyclable-and-low-fat-products/description/?envType=study-plan-v2&envId=top-sql-50
 */
SELECT product_id
FROM Products
WHERE low_fats = 'Y' AND recyclable = 'Y';

/*
 https://leetcode.com/problems/find-customer-referee/description/?envType=study-plan-v2&envId=top-sql-50
 */
SELECT name
FROM Customer
WHERE referee_id != 2 OR referee_id IS NULL;

/*
 https://leetcode.com/problems/big-countries/description/?envType=study-plan-v2&envId=top-sql-50
 */
SELECT name, population, area
FROM World
WHERE area >= 3000000 OR population >= 25000000;

/*
 https://leetcode.com/problems/article-views-i/description/?envType=study-plan-v2&envId=top-sql-50
 */
SELECT DISTINCT author_id AS id
FROM Views
WHERE author_id = viewer_id
ORDER BY author_id ASC

/*
 https://leetcode.com/problems/invalid-tweets/description/?envType=study-plan-v2&envId=top-sql-50
 */
 SELECT tweet_id
 FROM Tweets
 WHERE CHAR_LENGTH(content) > 15;

 /*
  https://leetcode.com/problems/replace-employee-id-with-the-unique-identifier/description/?envType=study-plan-v2&envId=top-sql-50
  */
SELECT UNI.unique_id, EMP.name
FROM Employees AS EMP
LEFT JOIN EmployeeUNI AS UNI ON UNI.id = EMP.id