create table books(
    id serial primary key,
    bookName varchar not null,
    author_id int references authors(id) on delete cascade
)