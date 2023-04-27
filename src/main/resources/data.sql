INSERT INTO ebanking_user (id, username, password, customer_id)
VALUES (101, 'user', '{bcrypt}$2a$10$neGDeHszLhO6MZb37KmjM.BKBx7SUxmUij3lEptVsjKLME/y3WcCm', 101);

INSERT INTO ebanking_user (id, username, password, customer_id)
VALUES (102, 'JohnDoe', '{bcrypt}$2a$10$aR/Ok2qT6q9wez5yfEHDjOWYSFDg9Gap7R9QX529tSqyMGcfJhx9a', 102);

insert into customer (id, first_name, last_name, oasi)
values (101, 'Jane', 'Doe', '0000011111001');

insert into customer (id, first_name, last_name, oasi)
values (102, 'John', 'Doe', '0000011111002');

insert into customer (id, first_name, last_name, oasi)
values (103, 'First', 'Last', '1234512345123');

insert into bank_account (account_number, account_name, customer_id, type, balance, currency)
values ('CH9300001000011110001', 'Checking Account', 101, 0, 1000.0, 0);

insert into bank_account (account_number, account_name, customer_id, type, balance, currency)
values ('CH9300001000011110002', 'Credit Card', 101, 1, 3000.0, 0);

insert into bank_account (account_number, account_name, customer_id, type, balance, currency)
values ('CH9300001000011110003', 'Savings Account 1', 101, 2, 2000.0, 0);

insert into bank_account (account_number, account_name, customer_id, type, balance, currency)
values ('CH9300001000011110004', 'Savings Account 2', 101, 2, 500.0, 0);

insert into bank_account (account_number, account_name, customer_id, type, balance, currency)
values ('CH9300001000011110005', 'Savings Account 3', 101, 2, 1000.0, 0);

insert into bank_account (account_number, account_name, customer_id, type, balance, currency)
values ('CH9300001000011110006', 'Checking Account', 102, 0, 500.0, 0);

insert into bank_account (account_number, account_name, customer_id, type, balance, currency)
values ('CH9300001000011110007', 'EUR Account', 101, 0, 1000.0, 1);

insert into card (card_number, card_name, name_on_card, account_number, type, availability_date, pin, cvv, status)
values ('0000111122220001', 'MasterCard CHF', 'Jane Doe', 'CH9300001000011110001', 0, DATEADD(yy, 2, CURRENT_DATE()), '0000', '000', 0);

insert into card (card_number, card_name, name_on_card, account_number, type, availability_date, pin, cvv, status)
values ('0000111122220002', 'Credit Card CHF', 'Jane Doe', 'CH9300001000011110002', 0, DATEADD(yy, 4, CURRENT_DATE()), '0000', '000', 0);

insert into transaction (id, from_account_number, to_account_number, issue_date, amount, currency, description, exchange_rate)
values (101, 'CH9300001000011110003', 'CH9300001000011110001', DATEADD(m, -1, CURRENT_DATE()), 31, 0, '', 1);

insert into transaction (id, from_account_number, to_account_number, issue_date, amount, currency, description, exchange_rate)
values (102, 'CH9300001000011110003', 'CH9300001000011110001', DATEADD(d, -30, CURRENT_DATE()), 30, 0, '', 1);

insert into transaction (id, from_account_number, to_account_number, issue_date, amount, currency, description, exchange_rate)
values (103, 'CH9300001000011110003', 'CH9300001000011110001', DATEADD(d, -20, CURRENT_DATE()), 20, 0, '', 1);

insert into transaction (id, from_account_number, to_account_number, issue_date, amount, currency, description, exchange_rate)
values (104, 'CH9300001000011110003', 'CH9300001000011110001', DATEADD(d, -15, CURRENT_DATE()), 15, 0, '', 1);

insert into transaction (id, from_account_number, to_account_number, issue_date, amount, currency, description, exchange_rate)
values (105, 'CH9300001000011110003', 'CH9300001000011110001', DATEADD(d, -14, CURRENT_DATE()), 14, 0, '', 1);

insert into transaction (id, from_account_number, to_account_number, issue_date, amount, currency, description, exchange_rate)
values (106, 'CH9300001000011110003', 'CH9300001000011110001', DATEADD(d, -13, CURRENT_DATE()), 13, 0, '', 1);

insert into transaction (id, from_account_number, to_account_number, issue_date, amount, currency, description, exchange_rate)
values (107, 'CH9300001000011110003', 'CH9300001000011110001', DATEADD(d, -8, CURRENT_DATE()), 8, 0, '', 1);

insert into transaction (id, from_account_number, to_account_number, issue_date, amount, currency, description, exchange_rate)
values (108, 'CH9300001000011110003', 'CH9300001000011110001', DATEADD(d, -7, CURRENT_DATE()), 7, 0, '', 1);

insert into transaction (id, from_account_number, to_account_number, issue_date, amount, currency, description, exchange_rate)
values (109, 'CH9300001000011110003', 'CH9300001000011110001', DATEADD(d, -6, CURRENT_DATE()), 6, 0, '', 1);

insert into transaction (id, from_account_number, to_account_number, issue_date, amount, currency, description, exchange_rate)
values (110, 'CH9300001000011110003', 'CH9300001000011110001', DATEADD(d, -1, CURRENT_DATE()), 1, 0, '', 1);