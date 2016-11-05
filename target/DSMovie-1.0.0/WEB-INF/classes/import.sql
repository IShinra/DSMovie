INSERT INTO DSMovie.Roles(type) VALUES ('USER');
  
INSERT INTO DSMovie.Roles(type) VALUES ('ADMIN');
  
INSERT INTO DSMovie.Roles(type) VALUES ('DBA');

INSERT INTO DSMovie.Users(username, password, nome0, cognome, email) VALUES ('sam','$2a$10$4eqIF5s/ewJwHK1p8lqlFOEm2QIA0S8g6./Lok.pQxqcxaBZYChRm', 'Sam','Smith','samy@xyz.com');

INSERT INTO DSMovie.Users_Roles (user_id, role_id) SELECT user.id, role.id FROM DSMovie.Users user, DSMovie.Role role where user.username='sam' and role.type='ADMIN';
