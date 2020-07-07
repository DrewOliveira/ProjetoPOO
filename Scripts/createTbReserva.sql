use BDProjetoPOO;

-- criar tabela cliente e quarto antes !

Create Table Reserva (
    id int IDENTITY(1,1) PRIMARY KEY,
    quarto_id int Not Null,
    cliente_id int Not Null,
    diaria int Not Null,
	custo decimal (28,3) DEFAULT 0.000,
	refeicaoManha bit DEFAULT 0,
	refeicaoTarde bit DEFAULT 0,
	refeicaoNoite bit DEFAULT 0,
	servicoQuarto bit DEFAULT 0,
	acessoPiscina bit DEFAULT 0,

	FOREIGN KEY (quarto_id) REFERENCES Quarto(id),
	FOREIGN KEY (cliente_id) REFERENCES Cliente(id)
);
