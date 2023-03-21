create database jukebox;
use jukebox;
create table songs(songId int primary key AUTO_INCREMENT,
songName varchar(50) unique not null, 
artistName varchar(50)not null,
album varchar(50) not null,
genre varchar(50)not null,
duration time not null,
songPath varchar(80) unique not null);
desc songs;
drop table songs;
insert into songs  (songName,artistName,album,genre,duration,songPath) values('Pehla-Pyaar','Armaan-Malik','Kabir-Singh','Romantic','4:33','G:\\NIIT\\CapstonProject\\src\\Songs\\Pehla Pyaar.wav');
insert into songs (songName,artistName,album,genre,duration,songPath) values('Despecito','Luis-Fonsi','Despecito','Pop','4:42','G:\\NIIT\\CapstonProject\\src\\Songs\\Despacito.wav');
insert into songs (songName,artistName,album,genre,duration,songPath) values('Pal-Pal-Dil-Ke-Pass','Arijit-Singh','Pal-Pal-Dil-Ke-Pass','Romantic','3:03','G:\\NIIT\\CapstonProject\\src\\Songs\\Pal-pal-dil-ke-pass.wav');
insert into songs (songName,artistName,album,genre,duration,songPath) values('Laagi-Lagan-Shankara','Hansraj','God','Devotion','4:17','G:\\NIIT\\CapstonProject\\src\\Songs\\Laagi Lagan Shankara.wav');
insert into songs (songName,artistName,album,genre,duration,songPath) values('Kesariya','Arijit-Singh','Brahmastra','Melody','2:25','G:\\NIIT\\CapstonProject\\src\\Songs\\Kesariyan.wav');
insert into songs (songName,artistName,album,genre,duration,songPath) values('Sami-Sami','DSP','Pushpa','Dance','3:49','G:\\NIIT\\CapstonProject\\src\\Songs\\Sami Sami.wav');
insert into songs(songName,artistName,album,genre,duration,songPath) values('Kajaliyo','Kapil','Rajasthani-song','KS','3:22','G:\\NIIT\\CapstonProject\\src\\Songs\\KAJALIYO.wav');
select*from songs;
select songName from songs order by songName asc;
select song_Name from songs_list;
create table Users(userId int primary key auto_increment, userName varchar(50) not null, 
password varchar(50) not null,email varchar(50), mobileNumber long);
insert into Users(userId,userName,password) values(1,'Vicky123','vicky@124');
desc users;
drop table users;
select*from Users;
create table playlist(playlistId int primary key auto_increment, 
playListName varchar (50) unique,
 userId int, foreign key(userId) references Users(userId));
 insert into playlist(playListName,userId) values('Lofi',1);
select*from playList;
select  playListName from playlist where playlistId=4;
desc playlistList;
create table playlistShow(playlistId int, foreign key(playListId) references playList(playListId), 
songId int unique, foreign key(songId) references songs(songId),userId int ,foreign key(userId) references Users(userId));

desc playlistShow;
select*from playlistShow;
drop table playlistShow;
select songName artistName from songs order by artistName asc;
select genre from songs order by genre asc;
select album from songs order by album asc;
select duration from songs order by duration asc;
drop table songs;
drop table playlist;
insert into playlist values(1,'Romantic',1);
insert into playlistShow values(2,'7',1);
drop table playlistshow;
select * from songs where songId in(select songId from playlistShow where playlistId=4);
insert into playlistshow values(1,3,4);
drop database jukebox;



