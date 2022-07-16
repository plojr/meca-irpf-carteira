<jsp:include page="header.jsp" />
<title>Home</title>
</head>
<body>
<div class="container-fluid">
	<div class="row flex-nowrap">
		<jsp:include page="sidebar.jsp" />
		<div class="col py-3">
		<h2>MeCa-IRPF-Carteira</h2>
		<h3>Resumo</h3>
		<p>Este módulo serve para gerar as carteiras utilizando os cadastros das notas de corretagens.</p>
		<h3>Funcionalidade</h3>
		<p>Em "Carteira", você pode ver as carteiras de cada dia. Pode, também, calcular novamente as carteiras, caso tenha havido
		registro de mais notas de corretagens. Neste caso, é realmente necessário calcular novamente. Lembrando que, para cadastrar as ordens e
		notas de corretagens, é necessário utilizar o módulo Cadastro.</p>
		<h3>Declaração no software da Receita Federal</h3>
		<p>Estes dados precisam ser declarados no itens "Bens e direitos". O grupo utilizado é o "03 - Participações societárias."
		O código é "01 - Ações (inclusive as listadas em bolsa)". Em "discriminação", não existe um texto correto a ser utilizado.
		Um texto comum é colocar quantas ações o investidor tem, qual é o código do ticker, o nome da empresa e o preço médio.
		Em "Situação em 31/12" do ano calendário, é necessário colocar o custo total referente a essas ações.</p>
		<button class="btn btn-light" onclick="document.body.scrollTop = 0; document.documentElement.scrollTop = 0;">Ir para o topo</button>
		</div>
	</div>
</div>
</body>
</html>