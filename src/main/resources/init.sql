
-- vytvoreni autoru
insert into autor(createDate,Name) values(sysdate(),"Marek Jindrak");
insert into autor(createDate,Name) values(sysdate(),"Petr Novak");
insert into autor(createDate,Name) values(sysdate(),"Petra Bila");

-- vytvoreni obrazku
insert into images (createDate,name,updateDate,url,id)values(sysdate(),"Logo 1",sysdate(),"/img/logo-fm.png",1);
insert into images (createDate,name,updateDate,url,id)values(sysdate(),"Obr z webu",sysdate(),"http://watelier.cz/img/logo/logo.png",3);
insert into images (createDate,name,updateDate,url,id)values(sysdate(),"Logo 2",sysdate(),"/img/logo.png",2);

-- vytvoreni tagu
insert into tags (Tag)values("logo");
insert into tags (Tag)values("obrazek");
insert into tags (Tag)values("Neco"); 

-- vytvoreni liku
insert into likes (result,ID_images) values(1,1);
insert into likes (result,ID_images) values(1,1);
insert into likes (result,ID_images) values(1,1);

-- vytvoreni tagu pro obrazek
insert into imagetag (ID_tags,ID_images)values(1,1);
insert into imagetag (ID_tags,ID_images)values(2,1);
insert into imagetag (ID_tags,ID_images)values(2,2);
insert into imagetag (ID_tags,ID_images)values(3,1);
insert into imagetag (ID_tags,ID_images)values(3,3);

-- vytvoreni komentare
insert into comment (createDate,Description,ID,ID_images) values(sysdate(),"Pekny obrazek",1,1);
insert into comment (createDate,Description,ID,ID_images) values(sysdate(),"Pekny fakt",1,2);
insert into comment (createDate,Description,ID,ID_images) values(sysdate(),"jo jo fakt",2,2);
insert into comment (createDate,Description,ID,ID_images) values(sysdate(),"jo no fakt",3,1);

insert into likescomment (Result,ID_Coment) values(-1,1);
insert into likescomment (Result,ID_Coment) values(-1,2);
insert into likescomment (Result,ID_Coment) values(-1,1);
insert into likescomment (Result,ID_Coment) values(-1,2);
insert into likescomment (Result,ID_Coment) values(1,1);
insert into likescomment (Result,ID_Coment) values(-1,3);
