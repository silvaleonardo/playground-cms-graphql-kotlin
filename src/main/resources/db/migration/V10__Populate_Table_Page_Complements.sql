-- Lorem Ipsum
-- https://www.lipsum.com/

INSERT INTO `page_complements` (`id`, `type`, `data`, `page_id`) VALUES
    (1, 'post', '{"attachments":"Lorem ipsum dolor sit amet.","more":"Fusce iaculis tincidunt sem eget posuere. Phasellus eleifend imperdiet neque."}', 1),
    (2, 'post', '{"attachments":"Donec enim metus, feugiat at maximus eu, sagittis in mi.","more":"Morbi eros tellus, sodales in malesuada sed, faucibus quis lorem."}', 2),
    (3, 'review', '{"references":"Donec enim metus, feugiat at maximus eu, sagittis in mi.","rating":9.5,"recommend":true}', 3),
    (4, 'review', '{"references":"Lorem ipsum dolor sit amet.","rating":1.5,"recommend":false}', 4);