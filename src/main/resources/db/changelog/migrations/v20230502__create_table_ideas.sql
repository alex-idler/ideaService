
create table idea_db.ideas
(
    id          bigserial not null,
    name        varchar(255),
    text        varchar,
    rating      integer,
    user_id     uuid   not null,
    status_id   bigint,

    constraint pk_ideas primary key (id)

);
