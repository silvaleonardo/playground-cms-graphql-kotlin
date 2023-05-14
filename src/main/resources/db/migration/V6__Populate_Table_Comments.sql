-- Lorem Ipsum
-- https://www.lipsum.com/

INSERT INTO `comments` (`id`, `title`, `body`, `status`, `user_id`, `comment_id`, `deleted_at`) VALUES
    (1, 'Lorem ipsum dolor sit amet.', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut tempor faucibus tortor ut volutpat. Phasellus purus dolor, ultrices non magna rhoncus, blandit porttitor quam. Lorem.', 'activated', 1, null, null),
    (2, 'Etiam finibus odio at diam.', 'Integer scelerisque aliquam erat, sit amet pretium turpis dictum at. Nam ligula risus, fringilla et pulvinar vitae, fringilla vel dui. Praesent ut dignissim metus, eu.', 'activated', 2, 1, null),
    (3, 'Vestibulum consectetur ultricies magna. Donec.', 'Nullam quam dolor, iaculis ut gravida ut, mattis id erat. Nunc cursus ac dolor ac eleifend. Proin scelerisque ex vitae nibh euismod, ut iaculis massa.', 'moderated', 3, null, null),
    (4, 'Sed ac iaculis risus. Sed.', 'Sed tincidunt a lectus sed hendrerit. Vestibulum sollicitudin, eros vitae molestie aliquam, tellus lorem mollis diam, id luctus ipsum nulla quis sapien. Quisque pretium pulvinar.', 'deleted', 4, null, CURRENT_TIMESTAMP),
    (5, 'Donec lobortis metus et dolor.', 'Mauris fringilla eu neque in pellentesque. Quisque eleifend congue diam, in venenatis neque pellentesque hendrerit. Donec tristique ligula ante, ac volutpat orci mattis et. Nunc.', 'activated', 4, null, null),
    (6, 'Cras euismod quis tortor non.', 'Pellentesque consequat elit eget tempus mattis. Aliquam at ipsum sed odio facilisis luctus. Vivamus eu enim nibh. Cras gravida quam vitae augue varius, ut finibus.', 'activated', 3, 5, null),
    (7, 'Aliquam sit amet orci libero.', 'Duis tincidunt orci semper pellentesque commodo. Maecenas pretium nisi dictum lobortis tincidunt. Nulla velit erat, posuere non dapibus at, fringilla sit amet ligula. Aliquam quis.', 'activated', 1, 5, null),
    (8, 'Mauris eros ex, tincidunt eget.', null, 'activated', 1, null, null);