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
		<p>Este m�dulo serve para gerar as carteiras utilizando os cadastros das notas de corretagens.</p>
		<h3>Funcionalidade</h3>
		<p>Em "Carteira", voc� pode ver as carteiras de cada dia. Pode, tamb�m, calcular novamente as carteiras, caso tenha havido
		registro de mais notas de corretagens. Neste caso, � realmente necess�rio calcular novamente. Lembrando que, para cadastrar as ordens e
		notas de corretagens, � necess�rio utilizar o m�dulo Cadastro.</p>
		<h3>Declara��o no software da Receita Federal</h3>
		<p>Estes dados precisam ser declarados no itens "Bens e direitos". O grupo utilizado � o "03 - Participa��es societ�rias."
		O c�digo � "01 - A��es (inclusive as listadas em bolsa)". Em "discrimina��o", n�o existe um texto correto a ser utilizado.
		Um texto comum � colocar quantas a��es o investidor tem, qual � o c�digo do ticker, o nome da empresa e o pre�o m�dio.
		Em "Situa��o em 31/12" do ano calend�rio, � necess�rio colocar o custo total referente a essas a��es.</p>
		<button class="btn btn-light" onclick="document.body.scrollTop = 0; document.documentElement.scrollTop = 0;">Ir para o topo</button>
		</div>
	</div>
</div>
</body>
</html>