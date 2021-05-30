create table test_table
(
    id          bigint auto_increment,
    number      int                                not null,
    add_time    datetime default current_timestamp not null,
    update_time datetime default current_timestamp on update current_timestamp not null,
    delete_time int      default 0,
    constraint test_table_pk
        primary key (id)
);