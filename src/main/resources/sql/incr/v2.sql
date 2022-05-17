update t_user_info
set is_upload = 1
where id = 2;

create table t_indicators_statistics
(
    id              int auto_increment,
    series_name     varchar(32)    not null comment '系列名',
    indicators_name varchar(32)    null comment '指标名',
    accumulation    decimal(11, 5) null comment '累计',
    year            varchar(4)     null comment '年份',
    create_time     datetime       null comment '创建时间',
    constraint t_indicators_statistics_pk
        primary key (id)
)
    comment '指标统计表';