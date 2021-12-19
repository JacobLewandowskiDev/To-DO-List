    CREATE Table todos (
        id int unsigned primary key auto_increment,
        text varchar(100) not null,
        done bit
    );

    INSERT INTO todos (text, done) VALUES ('Done todo', 1);
    INSERT INTO todos (text, done) VALUES ('Undone todo', 0);