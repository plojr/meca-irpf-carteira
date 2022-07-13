<jsp:include page="header.jsp" />
<title>Home</title>
</head>
<body>
<div class="container-fluid">
	<div class="row flex-nowrap">
		<jsp:include page="sidebar.jsp" />
		<div class="col py-3">
		<h2>MeCa-IRPF-Cadastro</h2>
		<h3>Resumo</h3>
		<p>
		Este m�dulo � respons�vel por cadastrar as notas de corretagens, ordens e eventos corporativos necess�rios para outros m�dulos.
		</p>
		<h3>Menu</h3>
		<p>
		O menu "B�sico" � onde ser�o cadastradas os tickers, notas de corretagem e as ordens.
		</p>
		<p>
		O menu "Eventos" � onde ser�o cadastrados os eventos corporativos, tais como, bonifica��o, grupamento, desdobramento, cis�o e fus�o.
		</p>
		<h3>Objetivo</h3>
		<p>
		O intuito deste m�dulo � permitir que o investidor cadastre as notas de corretagens, ordens e eventos corporativos que ser�o necess�rios para outros m�dulos.
		</p>
		<p>
		Os outros m�dulos s�o independentes entre si, por�m todos dependem deste m�dulo por causa dos dados que ele fornece.
		</p>
		<h3>Como devo lan�ar as notas de corretagem?</h3>
		<p>A minha sugest�o � que voc� lance, preferencialmente, todas as suas notas de corretagem. Existe um tipo de caso onde isso n�o � preciso. � quando voc� est� com sua posi��o de a��es totalmente zerada, isto �, sem ter nenhuma a��o em sua carteira. Neste caso, voc� pode come�ar a lan�ar as a��es que comprar a partir de ent�o, desde que voc� n�o queira saber dos dados de anos anteriores. Por�m, se esse n�o for o seu caso, o custo das compras feitas de uma determinada a��o no passado pode influenciar, ou n�o, no custo atual. N�o influenciaria no custo atual dadas algumas condi��es bem espec�ficas.
		Com isso em mente, eu sugiro lan�ar todas as notas. Eu sei que � trabalhoso, mas � o cen�rio ideal para evitar c�lculos errados.
		</p>
		<h3>Instru��es</h3>
		<p>Neste projeto, estou utilizando o lombok. Por isso, voc� precisar� instal�-lo no programa - Eclipse, Spring Tool Suite etc - que voc� utilizar� para codificar neste projeto.
		</p>
		<h3>Detalhes t�cnicos</h3>
		<p>Este projeto foi criado no Spring Tool Suite 4. O banco de dados que utilizarei no projeto ser� o H2, simplesmente para teste.</p>
		<button class="btn" onclick="document.body.scrollTop = 0; document.documentElement.scrollTop = 0;">Ir para o topo</button>
		</div>
	</div>
</div>
</body>
</html>