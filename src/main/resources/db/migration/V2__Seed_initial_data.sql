INSERT INTO sports (name) VALUES
('Athletics'),
('Swimming');

INSERT INTO disciplines (name, world_record_holder, world_record_time, sport_id)
SELECT '100 metres',      'Fred Kerley',            '9.58 (Usain Bolt)',        id FROM sports WHERE name='Athletics'
UNION ALL SELECT '200 metres',      'Noah Lyles',             '19.19 (Usain Bolt)',       id FROM sports WHERE name='Athletics'
UNION ALL SELECT '400 metres',      'Aleksander Doom',        '43.03 (Wayde van Niekerk)',id FROM sports WHERE name='Athletics'
UNION ALL SELECT '800 metres',      'Marco Arop',             '1:40.91 (David Rudisha)',  id FROM sports WHERE name='Athletics'
UNION ALL SELECT '1500 metres',     'Joshua Kerr',            '3:26.00 (Hicham El Guerrouj)', id FROM sports WHERE name='Athletics'
UNION ALL SELECT '50m freestyle',   'Ben Proud',              '20.91 (Cesar Cielo)',      id FROM sports WHERE name='Swimming'
UNION ALL SELECT '100m freestyle',  'David Popovici',         '46.40 (Pan Zha Le)',       id FROM sports WHERE name='Swimming'
UNION ALL SELECT '200m freestyle',  'Hwang Sun-woo',          '1:42.00 (Paul Biedermann)',id FROM sports WHERE name='Swimming'
UNION ALL SELECT '400m freestyle',  'Ahmed Hafnaoui',         '3:40.00 (Paul Biedermann)',id FROM sports WHERE name='Swimming'
UNION ALL SELECT '50m breaststroke','Nicolo Martinenghi',     '25.95 (Adam Peaty)',       id FROM sports WHERE name='Swimming'
UNION ALL SELECT '100m breaststroke','Adam Peaty',            '56.88 (Adam Peaty)',       id FROM sports WHERE name='Swimming'
UNION ALL SELECT '200m breaststroke','Dong Zhihao',           '2:05.48 (Qin Haiyang)',    id FROM sports WHERE name='Swimming';
