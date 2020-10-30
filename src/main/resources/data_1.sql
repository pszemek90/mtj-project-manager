-- users
insert into users(first_name, last_name, email) values ('Jan', 'Nowak', 'jannowak@gmail.com');
insert into users(first_name, last_name, email) values ('Andrzej', 'Kowalski', 'andrzejkowalski@gmail.com');
-- projects
insert into projects(uuid, number, title, customer) values ('968d3886-1aac-11eb-adc1-0242ac120002','P20002', 'Konotopa', 'Depenbrock');
-- categories
insert into categories (uuid, title) values ('968d3ad4-1aac-11eb-adc1-0242ac120002','architektura');
insert into project_category(project_id, category_id) values ('968d3886-1aac-11eb-adc1-0242ac120002', '968d3ad4-1aac-11eb-adc1-0242ac120002');
-- messages
insert into messages (project_id, title, text, category) values ('968d3886-1aac-11eb-adc1-0242ac120002',
'testTitle1', 'testText1', 'architektura')