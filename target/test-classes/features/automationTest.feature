#language: pt
#encoding: utf-8
Funcionalidade: Preenchimento do Formulário Sample App


	@fill_VeicleData
	Esquema do Cenário: Preencher o formulário Enter Vehicle Data
		Dado que acessei o Sample App no browser "<Browser>"
		E preencho o formulario "Vehicle Data" com os dados do propreties e avanco para a proxima etapa
		E preencho o formulario "Insurant Data" com os dados do propreties e avanco para a proxima etapa
		E preencho o formulario "Product Data" com os dados do propreties e avanco para a proxima etapa
		E preencho o formulario "Price Option" com os dados do propreties e avanco para a proxima etapa
		Quando preencho o fomrulario Send Quote e envio a cotacao
		Então valido que o email foi enviado

		Exemplos:
			|	Browser	 |
			|	Chrome   |
#			|	Firefox  |
#			|	 Edge  	 |
#			|	  IE   	 |
