update t_user_info
set is_upload = 1
where id = 2;

create table t_indicators_statistics
(
    id                               varchar(32)    not null comment 'id'
        primary key,
    working_procedure_classification varchar(255)   not null comment '工序分类',
    indicators_name                  varchar(255)   not null comment '指标名',
    series_name                      varchar(32)    not null comment '系列名',
    accumulation                     decimal(11, 5) null comment '累计平均值',
    year                             varchar(4)     null comment '年份',
    create_time                      datetime       null comment '创建时间'
)
    comment '指标统计表';

create index indicators_name_index
    on t_indicators_statistics (indicators_name);

create index working_procedure_index
    on t_indicators_statistics (working_procedure_classification);

create index year_index
    on t_indicators_statistics (year);

