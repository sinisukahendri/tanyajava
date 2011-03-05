insert into T_DOWNLOAD_ITEM(DOWNLOAD_ITEM_ID,TITLE,CONTENT,EMAIL_TEMPLATE,EMAIL_SUBJECT,EMAIL_FROM,FILE_ABSOLUTE_PATH, FILE_MIME_TYPE,FILE_NAME) 
values('bkjd','Buku Java Desktop','','Hi $name,

Terimakasih telah meminta download buku Java Desktop oleh Ifnu Bima (@ifnubima), link download ada di bawah ini, silahkan mendownload file pdf tersebut dan simpan di komputer anda

http://tanyajava.com/download/bkjd/$id

Ketentuan : Buku ini akan selalu gratis untuk anda miliki dan sebarkan baik secara soft copy (ebook) maupun secara hard copy (print) tanpa modifkasi sama sekali. Jika anda ingin menggunakan buku ini untuk tujuan komersial dan memodifkasi sebagian isinya untuk tujuan tersebut, mohon mendiskusikan dengan pengarang (ifnubima@gmail.com) secara formal.

Dengan Hormat,
Tim tanyajava.com','Download Buku Java Desktop - Ifnu Bima','tanyajava <tanya.jv@gmail.com>',
'/Users/ifnu/Documents/Java Desktop - Ifnu Bima.pdf','application/pdf','Java Desktip - Ifnu Bima.pdf');


insert into T_COMPANY_ROLE(COMPANY_ROLE) values ('Pelajar');
insert into T_COMPANY_ROLE(COMPANY_ROLE) values ('Mahasiswa');
insert into T_COMPANY_ROLE(COMPANY_ROLE) values ('Junior Developer');
insert into T_COMPANY_ROLE(COMPANY_ROLE) values ('Senior Developer');
insert into T_COMPANY_ROLE(COMPANY_ROLE) values ('Architect');
insert into T_COMPANY_ROLE(COMPANY_ROLE) values ('Bussiness Analyst');
insert into T_COMPANY_ROLE(COMPANY_ROLE) values ('Software Tester');
insert into T_COMPANY_ROLE(COMPANY_ROLE) values ('Chief Technology Officer');
insert into T_COMPANY_ROLE(COMPANY_ROLE) values ('Chief Information Officer');
insert into T_COMPANY_ROLE(COMPANY_ROLE) values ('Director / Company Owner');

insert into T_PROJECT_STAGE(PROJECT_STAGE) values ('Learning');
insert into T_PROJECT_STAGE(PROJECT_STAGE) values ('Investigation');
insert into T_PROJECT_STAGE(PROJECT_STAGE) values ('Evaluation');
insert into T_PROJECT_STAGE(PROJECT_STAGE) values ('Development');
insert into T_PROJECT_STAGE(PROJECT_STAGE) values ('Maintenance');
insert into T_PROJECT_STAGE(PROJECT_STAGE) values ('Maintenance');