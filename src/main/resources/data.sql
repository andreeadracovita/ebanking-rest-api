insert into customer (id, first_name, last_name)
values (1, 'Jane', 'Doe');

insert into customer (id, first_name, last_name)
values (2, 'John', 'Doe');

insert into bank_account (account_number, account_name, customer_id, type, balance, currency)
values ('CH9300001000011110001', 'Checking Account', 1, 0, 1000.0, 0);

insert into bank_account (account_number, account_name, customer_id, type, balance, currency)
values ('CH9300001000011110002', 'Credit Card', 1, 1, 3000.0, 0);

insert into bank_account (account_number, account_name, customer_id, type, balance, currency)
values ('CH9300001000011110003', 'Savings Account 1', 1, 2, 2000.0, 0);

insert into bank_account (account_number, account_name, customer_id, type, balance, currency)
values ('CH9300001000011110004', 'Savings Account 2', 1, 2, 500.0, 0);

insert into bank_account (account_number, account_name, customer_id, type, balance, currency)
values ('CH9300001000011110005', 'Savings Account 3', 1, 2, 1000.0, 0);

insert into bank_account (account_number, account_name, customer_id, type, balance, currency)
values ('CH9300001000011110006', 'Checking Account', 2, 0, 500.0, 0);

insert into bank_account (account_number, account_name, customer_id, type, balance, currency)
values ('CH9300001000011110007', 'EUR Account', 1, 0, 1000.0, 1);

insert into app_account (id, username, password, customer_id)
values (1, 'user', '12345', 1);

insert into card (card_number, card_name, name_on_card, account_number, type, availability_date, pin, cvv)
values ('0000111122220001', 'MasterCard CHF', 'Jane Doe', 'CH9300001000011110001', 0, DATEADD(yy, 2, CURRENT_DATE()), '0000', '000');

insert into card (card_number, card_name, name_on_card, account_number, type, availability_date, pin, cvv)
values ('0000111122220002', 'Credit Card', 'Jane Doe', 'CH9300001000011110002', 0, DATEADD(yy, 4, CURRENT_DATE()), '0000', '000');

insert into card (card_number, card_name, name_on_card, account_number, type, availability_date, pin, cvv)
values ('0000111122220003', 'Virtual Credit Card', 'Jane Doe', 'CH9300001000011110002', 1, DATEADD(yy, 4, CURRENT_DATE()), '0000', '000');