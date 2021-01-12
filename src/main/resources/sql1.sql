insert into  assignee (name)  values ('assignee1');
insert into  assignee (name)  values ('assignee2');
insert into  assignee (name)  values ('assignee3');
insert into  assignee (name)  values ('assignee4');
insert into issue (issue , type, description , assignee_id, active) values ('issue 1', 5,'description 1', 1, false);
insert into issue (issue , type, description , assignee_id, active) values ('issue 2', 5, 'description 2', 2, false);
insert into issue (issue , type, description , assignee_id, active) values ('issue 3', 5, 'description 3', 1, true);
insert into issue (issue , type, description , assignee_id, active) values ('issue 3', 5, 'description 3', 3, false);
insert into issue (issue , type, description , assignee_id, active) values ('issue 3', 5, 'description 3', 3, false);
insert into issue (issue , type, description , assignee_id, active) values ('issue 3', 5, 'description 3', null, false);


INSERT INTO role_table(id, name)
VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN');