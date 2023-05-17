-- Lorem Ipsum
-- https://www.lipsum.com/

INSERT INTO `pages` (`id`, `title`, `summary`, `body`, `status`, `type`, `user_id`) VALUES
    (1, 'Nam gravida sem in nunc.', 'Phasellus lorem tellus, auctor et vestibulum nec, ornare at turpis.', 'Duis ut consectetur purus. Ut consequat elementum lacinia. Sed ornare elit eu est vulputate pretium. Donec non pretium nulla. Suspendisse suscipit tristique fringilla. Curabitur odio.', 'published', 'post', 1),
    (2, 'Suspendisse potenti. Duis sit amet.', 'Sed eget ipsum fermentum, blandit erat ac, pretium tellus. Vestibulum.', 'Etiam at nisl lectus. Pellentesque aliquet nec diam at consequat. Ut consequat metus et diam eleifend, eget pretium purus suscipit. Aenean lacinia porta metus, quis.', 'published', 'post', 2),
    (3, 'In rhoncus finibus velit in.', null, 'Vestibulum mattis odio ac nisl imperdiet facilisis. Quisque vitae euismod odio. Vivamus dapibus vitae leo at eleifend. Morbi pharetra, velit ac laoreet lobortis, lectus felis.', 'hidden', 'review', 1),
    (4, 'Duis iaculis volutpat ipsum in.', 'Aliquam gravida non mauris vitae imperdiet. Nulla in ultrices augue.', null, 'draft', 'review', 1);

INSERT INTO `pages_tags` (`page_id`, `tag_id`) VALUES
    (1, 1),
    (1, 2),
    (1, 3),
    (2, 2),
    (3, 5);

INSERT INTO `pages_comments` (`page_id`, `comment_id`) VALUES
    (1, 1),
    (1, 3),
    (1, 5),
    (2, 4),
    (3, 8);