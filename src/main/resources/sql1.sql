insert into  assignee (name)  values ('assignee1');
insert into  assignee (name)  values ('assignee2');
insert into issue (issue , type, description , assignee_id) values ('issue 1', 5,'description 1', 1);
insert into issue (issue , type, description , assignee_id) values ('issue 2', 5, 'description 2', 2);
insert into issue (issue , type, description , assignee_id) values ('issue 3', 5, 'description 3', 1);


INSERT INTO role_table(id, name)
VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN');