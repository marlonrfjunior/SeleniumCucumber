#language: pt
#encoding: utf-8
Funcionalidade: Validar Perfil no linkedin

	Cenário: Verificar Nome
		Dado que acessei o linkedin no browser "Safari"
		E me direciono a página de procurar pessoas conhecidas
        Quando pesquiso o perfil da pessoa com nome "Marlon" e sobrenome "Junior"
        E seleciono o com o titulo "Desenvolvedor de Testes Automatizados Pleno na Accenture" e nome "Marlon Junior"
        Então verifico o curriculo
