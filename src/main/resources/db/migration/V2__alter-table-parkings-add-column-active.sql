alter table parkings add column active tinyint;
update parkings set active = 1;