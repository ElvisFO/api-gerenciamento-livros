CREATE TABLE autor (
	id BIGINT(13) PRIMARY KEY,
	cpf VARCHAR(11) NOT NULL,
	nome VARCHAR(100) NOT NULL,
	idade INT NULL,
	data_nascimento DATE NULL, 
	UNIQUE(cpf)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
