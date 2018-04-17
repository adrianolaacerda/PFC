Create Table pessoa( 
	id 				serial 	PRIMARY KEY, 
	nome 				varchar (50) NOT NULL,
	cpf				integer NOT NULL,
	rg	        		integer NOT NULL,
	dataNasc			DATE,
	email				varchar (30),
	telefone			varchar (30),
	logradouro 			varchar(60),
	numero				integer,
	cep				varchar(15),
	bairro				varchar(50),
	cidade				varchar (100),
	estado				varchar(100)
	
); 

create table usuario(
	id 				serial primary key,
        login 				varchar NOT NULL,
	senha 				varchar NOT NULL, 
	perfil 				varchar NOT NULL,
	usuario				integer REFERENCES pessoa(id)
);


Create Table produto(
     	codigo				serial PRIMARY KEY,
	nome		    		varchar (50) NOT NULL,
	imagem 	            		varchar,
	dataValidade 	    		Date, 
	tipoPreco	    		varchar NOT NULL,
	preco		    		numeric (6,2) NOT NULL,
	quantidade	    		integer,
	quantidadeMinima   		integer,
	categoria			varchar (45) NOT NULL
);

Insert Into usuario (login,senha,perfil) 
Values ('administrador', '1234', 'Funcionario');