# SisPed v1.0

Sistema de Pedidos utilizando Spring Boot + Thymeleaf


==================================================================================

EXERCÍCIOS TEÓRICOS

ET1) Descreva com suas palavras o funcionamento dos protocolos HTTP e HTTPS.
Explique quais são as principais diferenças entre os dois protocolos.

Resp.1) O protocolo de comunicação HTTP transfere dados, via internet, entre o 
computador de um usuário e os servidores de hipermídia, normalmente utilizando 
a porta 80 do dispositivo. No caso do protocolo HTTPS, trata-se de uma versão 
idêntica do HTTP, porém trafegando sobre uma camada SSL que permite criptografia
 na conexão por onde os dados irão transitar, além de haver verificação da autenticidade
  do servidor e do cliente, atravé de certificados digitais. O tráfego ocorre na porta 443.
   As diferenças principais estão relacionadas à segurança, que no protocolo HTTPS é muito melhor.



ET2) Descreva com suas palavras o que é Representational State Transfer (REST).

Resp.2) REST é um modelo de arquitetura, uma representação flexível e desacoplada, que privilegia
 a separação entre aplicações front-end e back-end, como sendo uma boa prática no desenvolvimento.



ET3) Escolha um dos ataques catalogados pela OWASP Foundation
( https://owasp.org/www-community/attacks/ ). Pesquise sobre o ataque escolhido e sobre
quais medidas devem ser tomadas para proteger um sistema de tal ataque.

Resp.3) TROJAN HORSE (Cavalo de Troia): é considerado um malware (abreviação de Malicious Software),
 e não é apenas um simples vírus. Ele é executado como uma ferramenta, tentando enganar a vítima para
  que realize sua instalação. Após isso ele inicia diversos ataques, como roubo de senhas, dados bancários,
   capturas de telas e informações do sistema. Depois disso ele envia tudo ao cracker (invasor).
Medidas protetivas: manter sistemas de softwares atualizados, instalar software de segurança (antivírus)
 e evitar uso arriscado durante navegação na web: clicar em links duvidosos ou anúncios falsos,
  emails suspeitos e realizar downloads em sites fraudulentos. Bloquear execução imediata de arquivos
   executáveis (*.EXE, *.BAT, *.CMD, *.SCR e *.JS) também pode ajudar bastante a evitar que o
    Cavalo de Troia seja executado no sistema.



==================================================

EXERCÍCIOS PRÁTICOS

EP1) Crie uma aplicação Spring Boot que seja capaz de atender requisições HTTP, do tipo
GET, no caminho “/contador”. A resposta para este caminho deve ser uma página HTML
contendo a quantidade de vezes que o caminho foi acessado (i.e., “Número de Acessos:
XX”). O contador não precisa ser persistido, basta que seja armazenado em memória.


EP2) Considerando as entidades Pessoa, Produto, Pedido e PedidoItem apresentadas
abaixo, realiza a implementação de uma aplicação Spring Boot, contendo as seguintes
funcionalidades: (1) operações CRUD para Pessoa e Produto, e (2) movimento de realizar
pedido. Deve-se realizar a persistência de dados com Spring Data. Além disso, deve-se
prover acesso às funcionalidades do sistema por meio de uma interface web (e.g., usando o
Thymeleaf). O valor do produto está em Float, mas pode-se usar outra forma mais
adequada para valores monetários, tal como o uso de BigDecimal.


======================================================

Desenvolvido pelo aluno: Andre Garcia Alves
Disciplina de Desenvolvimento JAVA/WEB - Curso de Especialização: Web Mobile Embarcados - IFPR [2021]

