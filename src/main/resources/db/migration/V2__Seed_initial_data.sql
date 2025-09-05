INSERT INTO sports (name) VALUES ('Athletics')
ON CONFLICT (name) DO NOTHING;

INSERT INTO sports (name) VALUES ('Swimming')
ON CONFLICT (name) DO NOTHING;

INSERT INTO disciplines (name, world_record_holder, world_record_time, sport_id)
VALUES
('100 metres',       'Fred Kerley',         '9.58 (Usain Bolt)',
    (SELECT id FROM sports WHERE name = 'Athletics')),
('200 metres',       'Noah Lyles',          '19.19 (Usain Bolt)',
    (SELECT id FROM sports WHERE name = 'Athletics')),
('400 metres',       'Aleksander Doom',     '43.03 (Wayde van Niekerk)',
    (SELECT id FROM sports WHERE name = 'Athletics')),
('800 metres',       'Marco Arop',          '1:40.91 (David Rudisha)',
    (SELECT id FROM sports WHERE name = 'Athletics')),
('1500 metres',      'Joshua Kerr',         '3:26.00 (Hicham El Guerrouj)',
    (SELECT id FROM sports WHERE name = 'Athletics')),
('50m freestyle',    'Ben Proud',           '20.91 (Cesar Cielo)',
    (SELECT id FROM sports WHERE name = 'Swimming')),
('100m freestyle',   'David Popovici',      '46.40 (Pan Zha Le)',
    (SELECT id FROM sports WHERE name = 'Swimming')),
('200m freestyle',   'Hwang Sun-woo',       '1:42.00 (Paul Biedermann)',
    (SELECT id FROM sports WHERE name = 'Swimming')),
('400m freestyle',   'Ahmed Hafnaoui',      '3:40.00 (Paul Biedermann)',
    (SELECT id FROM sports WHERE name = 'Swimming')),
('50m breaststroke', 'Nicolo Martinenghi',  '25.95 (Adam Peaty)',
    (SELECT id FROM sports WHERE name = 'Swimming')),
('100m breaststroke','Adam Peaty',          '56.88 (Adam Peaty)',
    (SELECT id FROM sports WHERE name = 'Swimming')),
('200m breaststroke','Dong Zhihao',         '2:05.48 (Qin Haiyang)',
    (SELECT id FROM sports WHERE name = 'Swimming'));
