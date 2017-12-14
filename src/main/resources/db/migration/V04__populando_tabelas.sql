INSERT INTO autor(cpf,nome,data_nascimento)
VALUES('60872300331','Robert C. Martin','1952-01-04');
INSERT INTO autor(cpf,nome,data_nascimento)
VALUES('85875823488','Michael C. Feathers','1959-01-04'); 
INSERT INTO autor(cpf,nome,data_nascimento)
VALUES('82481427874','Joshua Bloch','1961-01-04'); 

INSERT INTO livro(isbn,titulo,editora,preco,data_publicacao)
VALUES('9780132350884','Clean Code: A Handbook of Agile Software Craftsmanship','Prentice Hall PTR',87.79,'2008-08-11');
INSERT INTO livro(isbn,titulo,editora,preco,data_publicacao)
VALUES('9780321356680','Effective Java (2nd Edition)','Addison-Wesley',104.68,'2008-05-28');

INSERT INTO livro_autor(livro_isbn,autor_id) VALUES('9780132350884', 1);
INSERT INTO livro_autor(livro_isbn,autor_id) VALUES('9780132350884', 2);
INSERT INTO livro_autor(livro_isbn,autor_id) VALUES('9780321356680', 3);

INSERT INTO critica(livro_isbn,criticas) VALUES('9780132350884', 'Muito poderia ter sido explorado.');
INSERT INTO critica(livro_isbn,criticas) VALUES('9780132350884', 'Excelente livro');
INSERT INTO critica(livro_isbn,criticas) VALUES('9780321356680', 'Livro muito bom');
INSERT INTO critica(livro_isbn,criticas) VALUES('9780321356680', 'Todo javeiro deve ler esse livro rsrs.');


