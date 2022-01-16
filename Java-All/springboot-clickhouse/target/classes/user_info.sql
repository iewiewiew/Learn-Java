-- `default`.user_info definition

CREATE TABLE default.user_info
(

    `id` UInt64,

    `user_name` String,

    `pass_word` String,

    `phone` String,

    `create_day` Date DEFAULT CAST(now(),
                                   'Date')
)
    ENGINE = MergeTree
PRIMARY KEY id
ORDER BY id
SETTINGS index_granularity = 8192;


INSERT INTO `default`.user_info
(id, user_name, pass_word, phone, create_day)
VALUES(1, 'aaa', '123456', '18222050001', '2023-01-01');
INSERT INTO `default`.user_info
(id, user_name, pass_word, phone, create_day)
VALUES(2, 'bbb', '123456', '18222050001', '2023-01-01');
INSERT INTO `default`.user_info
(id, user_name, pass_word, phone, create_day)
VALUES(3, 'ccc', '123456', '18222050001', '2023-01-01');
INSERT INTO `default`.user_info
(id, user_name, pass_word, phone, create_day)
VALUES(4, 'ddd', '54321', '18222050001', '2023-01-01');


