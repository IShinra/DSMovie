INSERT INTO DSMovie.Roles(role) VALUES ('USER');
  
INSERT INTO DSMovie.Roles(role) VALUES ('ADMIN');
  
INSERT INTO DSMovie.Roles(role) VALUES ('DBA');

INSERT INTO DSMovie.Users(nome, cognome, email, username, password) VALUES ('Sam','Smith','samy@xyz.com','sam','$2a$10$4eqIF5s/ewJwHK1p8lqlFOEm2QIA0S8g6./Lok.pQxqcxaBZYChRm');

INSERT INTO DSMovie.Users_Roles (user_id, role_id) SELECT Users.user_id, Roles.role_id FROM DSMovie.Users users, DSMovie.Roles roles where users.username='sam' and roles.role='ADMIN';