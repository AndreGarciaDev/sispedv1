# SisPed v1.0

Sistema de Pedidos utilizando Spring Boot + Thymeleaf


==================================================================================
EXERC�CIOS TE�RICOS

ET1) Descreva com suas palavras o funcionamento dos protocolos HTTP e HTTPS.
Explique quais s�o as principais diferen�as entre os dois protocolos.

Resp.1) O protocolo de comunica��o HTTP transfere dados, via internet, entre o 
computador de um usu�rio e os servidores de hiperm�dia, normalmente utilizando 
a porta 80 do dispositivo. No caso do protocolo HTTPS, trata-se de uma vers�o 
id�ntica do HTTP, por�m trafegando sobre uma camada SSL que permite criptografia
 na conex�o por onde os dados ir�o transitar, al�m de haver verifica��o da autenticidade
  do servidor e do cliente, atrav� de certificados digitais. O tr�fego ocorre na porta 443.
   As diferen�as principais est�o relacionadas � seguran�a, que no protocolo HTTPS � muito melhor.



ET2) Descreva com suas palavras o que � Representational State Transfer (REST).

Resp.2) REST � um modelo de arquitetura, uma representa��o flex�vel e desacoplada, que privilegia
 a separa��o entre aplica��es front-end e back-end, como sendo uma boa pr�tica no desenvolvimento.



ET3) Escolha um dos ataques catalogados pela OWASP Foundation
( https://owasp.org/www-community/attacks/ ). Pesquise sobre o ataque escolhido e sobre
quais medidas devem ser tomadas para proteger um sistema de tal ataque.

Resp.3) TROJAN HORSE (Cavalo de Troia): � considerado um malware (abrevia��o de Malicious Software),
 e n�o � apenas um simples v�rus. Ele � executado como uma ferramenta, tentando enganar a v�tima para
  que realize sua instala��o. Ap�s isso ele inicia diversos ataques, como roubo de senhas, dados banc�rios,
   capturas de telas e informa��es do sistema. Depois disso ele envia tudo ao cracker (invasor).
Medidas protetivas: manter sistemas de softwares atualizados, instalar software de seguran�a (antiv�rus)
 e evitar uso arriscado durante navega��o na web: clicar em links duvidosos ou an�ncios falsos,
  emails suspeitos e realizar downloads em sites fraudulentos. Bloquear execu��o imediata de arquivos
   execut�veis (*.EXE, *.BAT, *.CMD, *.SCR e *.JS) tamb�m pode ajudar bastante a evitar que o
    Cavalo de Troia seja executado no sistema.





==================================================
EXERC�CIOS PR�TICOS

EP1) Crie uma aplica��o Spring Boot que seja capaz de atender requisi��es HTTP, do tipo
GET, no caminho �/contador�. A resposta para este caminho deve ser uma p�gina HTML
contendo a quantidade de vezes que o caminho foi acessado (i.e., �N�mero de Acessos:
XX�). O contador n�o precisa ser persistido, basta que seja armazenado em mem�ria.


EP2) Considerando as entidades Pessoa, Produto, Pedido e PedidoItem apresentadas
abaixo, realiza a implementa��o de uma aplica��o Spring Boot, contendo as seguintes
funcionalidades: (1) opera��es CRUD para Pessoa e Produto, e (2) movimento de realizar
pedido. Deve-se realizar a persist�ncia de dados com Spring Data. Al�m disso, deve-se
prover acesso �s funcionalidades do sistema por meio de uma interface web (e.g., usando o
Thymeleaf). O valor do produto est� em Float, mas pode-se usar outra forma mais
adequada para valores monet�rios, tal como o uso de BigDecimal.


======================================================
Desenvolvido pelo aluno: Andre Garcia Alves
Disciplina de Desenvolvimento JAVA/WEB - Curso de Especializa��o: Web Mobile Embarcados - IFPR [2021]

