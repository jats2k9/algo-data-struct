/*
 https://platform.stratascratch.com/coding/2009-users-with-two-statuses?code_type=1
 */

SELECT user_id
FROM twitch_sessions
GROUP BY user_id
HAVING COUNT(DISTINCT session_type) = 2;