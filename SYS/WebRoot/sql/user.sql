
CREATE TABLE `user` (                                                   
          `id` int(11) NOT NULL AUTO_INCREMENT,                                 
          `username` varchar(20) CHARACTER SET utf8 NOT NULL,                   
          `password` varchar(50) CHARACTER SET utf8 NOT NULL,                   
          `name` varchar(10) CHARACTER SET utf8 NOT NULL,                       
          `role` varchar(10) CHARACTER SET utf8 NOT NULL DEFAULT '0',           
          `rank` varchar(10) CHARACTER SET utf8 NOT NULL DEFAULT '0000000000',  
          PRIMARY KEY (`id`)                                                    
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8     

insert into user values(1,'admin','96368cf6459b134403567e1135b119bd','管理员','1','1111111111')
-- password: dyong
