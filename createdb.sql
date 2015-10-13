CREATE DATABASE art;
CREATE USER 'art_user'@'localhost' IDENTIFIED BY 'art_user';
GRANT ALL ON art.* TO 'art_user'@'localhost';
commit;
