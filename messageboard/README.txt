登入用户：张三       密码：1234567
登入用户：李四       密码：1234567
登入用户：王五       密码：12345678
登入用户：老六       密码：123456789


 user表结构:
+----------+-------------+------+-----+---------+----------------+
| Field    | Type        | Null | Key | Default | Extra          |
+----------+-------------+------+-----+---------+----------------+
| id       | int(10)     | NO   | PRI | NULL    | auto_increment |
| name     | varchar(20) | YES  |     | NULL    |                |
| password | varchar(20) | YES  |     | NULL    |                |
| email    | varchar(20) | YES  |     | NULL    |                |
| phone    | varchar(20) | YES  |     | NULL    |                |
+----------+-------------+------+-----+---------+----------------+ 

mysql> select * from user;
+----+--------+-----------+-------------------+-------------+
| id | name   | password  | email             | phone       |
+----+--------+-----------+-------------------+-------------+
|  1 | 张三   | 1234567   | 731039257@qq.com  | 13067406766 |
|  2 | 李四   | 1234567   | 21789413@qq.com   | 13067415946 |
|  3 | 王五   | 12345678  | 513951763@qq.com  | 13078946766 |
|  4 | 老六   | 123456789 | 3148412354@qq.com | 13067412866 |
+----+--------+-----------+-------------------+-------------+






message表结构：
+-------------+--------------+------+-----+---------+----------------+
| Field       | Type         | Null | Key | Default | Extra          |
+-------------+--------------+------+-----+---------+----------------+
| id          | int(10)      | NO   | PRI | NULL    | auto_increment |
| label       | varchar(20)  | YES  |     | NULL    |                |
| detail      | varchar(100) | YES  |     | NULL    |                |
| date_create | datetime     | YES  |     | NULL    |                |
| date_edit   | datetime     | YES  |     | NULL    |                |
| user_id     | int(10)      | YES  | MUL | NULL    |                |
+-------------+--------------+------+-----+---------+----------------+