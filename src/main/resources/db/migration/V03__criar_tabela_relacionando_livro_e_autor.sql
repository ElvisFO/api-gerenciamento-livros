CREATE TABLE livro_autor (
	livro_isbn BIGINT(13) NOT NULL,
	autor_id BIGINT(13) NOT NULL,
	FOREIGN KEY (livro_isbn) REFERENCES livro(isbn),
    	FOREIGN KEY (autor_id) REFERENCES autor(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
