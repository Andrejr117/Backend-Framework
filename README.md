## Backend-Framework
# ProFut ⚽
## Grupo Eniac :
Carlos andre Gomes da Silva Junior <br>
José Carlos da Silva de Figueroa <br> 
Márcio Henrique dos Santos Silva <br>
Matheus felipe Moreira Pereira <br>
Wictor isaac Gomes da Silva <br>
<br>
<h1><img src= "https://user-images.githubusercontent.com/101275023/230258920-f57117e0-c26f-41b4-8b78-57cfe49e54ed.jpg" height="164" width="164" /> </h1>
<br>
<h2>Modelagem em UML do sistema</h2>
<h1><img src= "https://user-images.githubusercontent.com/101275023/232313704-9169944d-fddd-4e6e-b5d3-54acfa2970de.png" height="264" width="164" /> </h1>
<br>
<h2>Caso de uso UML</h2>
<h1><img src="https://user-images.githubusercontent.com/101275023/230800178-94dff6f5-becf-4a1d-8a89-8cc9accd2cfe.png" height="264" width="164" /></h1>
<br>
<h2>Protótipo da aplicação mobile no Figma</h2>
<h1><img src="https://user-images.githubusercontent.com/101275023/232313316-c68d1882-59b6-4da4-a7e3-732224852bf5.png" height="264" width="164" /></h1>
<h1><img src="https://user-images.githubusercontent.com/101275023/232313357-6ba103f6-bc9d-4905-b6e5-004977cc53bd.png" height="264" width="164" /></h1>
<h1><img src="https://user-images.githubusercontent.com/101275023/232313380-c6fe6b8f-107a-42b9-baa4-5f79f80e3ce9.png" height="264" width="164" /></h1>
<h1><img src="https://user-images.githubusercontent.com/101275023/232313413-690a0e9b-5c40-4830-b23a-e26092c8142d.png" height="264" width="164" /></h1>
<h1><img src="https://user-images.githubusercontent.com/101275023/232313432-6ace32fa-4268-4b10-9822-76b0f59a032e.png" height="264" width="164" /></h1>
<h1><img src="https://user-images.githubusercontent.com/101275023/232313505-72948453-bd60-47e6-87b4-65198f7a0fd5.png" height="264" width="164" /></h1>
<h1><img src="https://user-images.githubusercontent.com/101275023/232313536-0b3bec9b-4150-4da6-a548-460bf3e98ea9.png" height="264" width="164" /></h1>
<h1><img src="https://user-images.githubusercontent.com/101275023/232313569-eb9881ac-9320-4cae-93df-009cd2f24eb8.png" height="264" width="164" /></h1>
<br>
<h2> Definição das funcionalidades</h2>
<br>

Caso de uso 1:  <P>Tela de Cadastro de Usuário, Um usuário pode adicionar um novo jogador ao sistema. O usuário deve fornecer informações básicas, como nome, e-mail, senha, endereço, nacionalidade, posição, pé dominante e altura. 

Fluxo principal:  
•	O usuário acessa o sistema e seleciona a funcionalidade de cadastro de jogador. 
•	O sistema exibe o formulário de registro.

•	 O usuário preenche as informações básicas do jogador nome, e-mail, senha, endereço, nacionalidade, posição, pé dominante e altura. 

•	O sistema salva as informações e exibe uma mensagem de confirmação.

Fluxo Alternativo:  
•	Se o usuário cometer algum erro durante o preenchimento, o sistema deve exibir uma mensagem de erro e permitir que o usuário corrija a as informações incorretas.

<br>
Caso de uso 2:  <P>Tela de Login,  Um usuário pode fazer login no sistema usando seu e-mail e senha, cadastrar uma nova conta ou resetar a senha.

Fluxo Principal:

•	O usuário acessa a página de login do aplicativo.

•	O usuário insere o seu e-mail e senha.

•	O aplicativo verifica se as informações são corretas.

•	Caso as informações forem certas, o usuário poderá acessar o aplicativo.

•	Caso as informações forem erradas, o sistema exibirá uma mensagem de erro e solicitará ao usuário informar as informações certas.

Fluxo alternativo:

•	O usuário acessa a página de recuperar a senha, clicando em “Esqueci minha senha.

<br>
Caso de uso 3:  <p>Tela de Recuperar Senha, Se o usuário inserir uma senha incorreta, o sistema exibirá uma mensagem de erro e solicitará que o usuário tente novamente.
Se o usuário não se lembrar de sua senha atual, poderá selecionar uma opção de "Esqueceu sua senha?" e fornecer seu endereço de e-mail cadastrado na plataforma para redefinir sua senha.

Fluxo Principal:  
•	O usuário acessa a tela de recuperar senha e é solicitado a fornecer endereço de e-mail.

•	O sistema verifica se as credenciais do usuário estão corretas e permite que o usuário prossiga se estiverem.

•	O usuário é redirecionado para uma tela onde pode inserir seu e-mail sua nova senha e confirmá-la.

•	O sistema verifica se a nova senha atende aos requisitos de segurança (por exemplo, comprimento mínimo, uso de caracteres especiais etc.).

•	Se a nova senha atender aos requisitos de segurança, ela é atualizada e o usuário é redirecionado para a tela de login.

 Fluxo alternativo:  
•	Se o usuário inserir uma senha incorreta, o sistema exibirá uma mensagem de erro e solicitará que o usuário tente novamente.

•	Se o usuário não se lembrar de sua senha atual, poderá selecionar uma opção de "Esqueceu sua senha?" e fornecer seu endereço de e-mail cadastrado para redefinir sua senha. 

•	Se o usuário inserir uma nova senha que não atenda aos requisitos de segurança, o sistema exibirá uma mensagem de erro e solicitará que o usuário insira uma nova senha que atenda aos requisitos de segurança.

<br>
Caso de Uso 4: <P>tela de criação de partida, o Usuário poderá criar uma sala 
Ou entrar em uma sala criada.

 Fluxo Principal:  
•	O Usuário pode criar uma sala em “Criar sala”.

•	O Usuário pode entrar na sala em “Entrar na sala”, para entrar em uma sala já criada.

•	O Usuário pode ir para a página de detalhamento de jogado, no ícone de perfil no fim da tela.

Fluxo alternativo:

•	O usuário poderá se deparar com um erro ao entrar a sala, e será orientado pelo app, para ele checar a conexão com a internet.

•	 Caso o erro persista o usuário será informado que ele precisará reiniciar o app, e caso isso não funcione ele terá que entrar em contato com o suporte técnico para possíveis soluções.

<br>
Caso de Uso 5:  <P>Tela de Detalhamento do Jogador, O usuário irá ver suas informações na tela, como um “perfil. Informações básicas do jogador: a tela deve fornecer informações básicas sobre o jogador, como nome completo, idade, posição, altura, e outras informações relevantes.

 Fluxo Principal:  
•	O usuário acessa a tela de detalhamento de jogador, que exibe informações básicas do jogador, como seu nome, nacionalidade, posição, pé dominante e altura.

•	O usuário pode interagir com a tela, por exemplo, clicando no botão inferior com um símbolo de campo para ir para tela de criação de partida.

 Fluxo alternativo:  
•	Se o usuário quiser mudar algum dado da sua tela de detalhamento, basta clicar no botão “alterar dados”.

<br>
Caso de uso 6:  Tela de Sorteio, O usuário irá adicionar o nome dos jogadores na listagem e sortear os times de modo randômico.

Fluxo Principal:

•	O usuário acessa a página do sorteio.

•	Ele visualizará as informações sobre os jogadores que estarão no sorteio.

•	Depois de gerar o sorteio o usuário irá ver os times sorteados.

Fluxo Alternativo:

•	O usuário acessa a página do sorteio do campeonato de futebol, mas as informações não estão sendo exibidas corretamente.

•	Ele recebe uma mensagem de erro explicando o problema e pedindo que ele tente novamente mais tarde.

•	O usuário tenta acessar a página novamente, mas o problema persiste.

•	O usuário pode entrar em contato com o suporte técnico para reportar o problema.

<br>
Caso de uso 7:  Tela dos Times, o usuário verá os times formados (time 1 e 2)
 
Fluxo Principal:

•	O usuário acessa a página de times

•	Ele visualiza uma lista com times formados

•	O usuário pode visualizar informações sobre os jogadores de outros times

Fluxo Alternativo:

•	O usuário acessa a página de times, mas os times não estão sendo exibidos corretamente.

•	Ele recebe uma mensagem de erro explicando o problema e pedindo que ele tente novamente mais tarde.

•	O usuário tenta acessar a página novamente, mas o problema persiste.

•	O usuário pode entrar em contato com o suporte técnico para reportar o problema ou buscar mais informações sobre os times. 

<br>

<h1>Definição do contrato (JSON) que será comunicado entre o Back-end e o Front-end!</h1>
User/Login:<br>
Endpoint para fazer login do Jogador.<br>
Paramêtros: E-mail e Senha.

Resposta:

COD 200: Retorna os dados do usuário logado.<br>
COD 404: Usuário não encontrado.

```
{
"success": true,
"message": "Usuário logado com sucesso.",
    {
    "Id": 1,
    "name": "Carlos Figueroa",
    "Email": "carlos@hotmail.com"
    }
}
```
<br>

Update/password:
Endpoint para recuperar a senha  do Jogador.<br>
Parametros: senha

Resposta:

COD 200: Senha foi recuperada com sucesso.<br>
COD 404: Senha não atende os requisitos.
```
{
"senha": "12345678",   
}
```
<br>

Crete/localização:<br>
Endpoint para criar a localização do jogador no momnento do cadastro.

Resposta:<br>
COD 201: Localização criada com sucesso.<br>
COD 404: Parâmetros inválidos.
```
{
"id_usuario": "carlos",
"cidade": "abreu e lima",
"bairro": "desterro",
 "rua": "bellian",
"numero": 102,
"cep": 444844
}
```




Update/localização:<br>
Endpoint para mostrar os parametros de localização do jogador.

Resposta:<br>
COD 201: Parametros gravados com sucesso.
```
{
"id_usuario": "carlos",
"cidade": "abreu e lima",
"bairro": "desterro",
 "rua": "bellian",
"numero": 102,
"cep": 444844
}
```

Create/sala:<br>
Endpoint cria e adciona o jogador a uma sala.<br>
parametros: id.

Resposta:

COD 201: Sala criada com sucesso.<br>
COD 201: Jogador adcionado com sucesso.<br>
COD 404: Parâmetros inválidos.
```
{
  "id": "1824"
}
```




Create/Jogador:<br>
Endpoint para criar um cadastro do jogador.<br>
Paramêtros: email, nome, senha, endereço, nacionalidade, posição, pe_dominate, altura

Resposta:<br>
COD 201: Jogador criado com sucesso.<br>
COD 403: Email já está em uso.<br>
COD 404: Parâmetros inválidos.
```
{
"email": "carlos@hotmail.com",
  "nome": "Carlos",
  "senha": "12345678",
  "endereco": {
    "cidade": "abreu e lima",
    "bairro": "desterro",
    "rua": "bellian",
    "numero": 102,
    "cep": "444844"
  },
  "nacionalidade": "Brasil",
  "posicao": "Atacante",
  "pe_dominante": "Direito",
  "altura": "1.70"
}
```

Update/Jogador:<br>
Endpoint para atualizar o perfil do jogador.<br>
Paramêtros: nome, posição, altura, pe_dominante, nacionalidade.

Resposta:<br>
COD 200: Perfil atualizado com sucesso.<br>
COD 404: Erro ao atualizar, por favor verifique os parâmetros.
```
{
  "nome": "Carlos",
  "nacionalidade": "Brasil",
  "posicao": "Atacante",
  "pe_dominante": "Direito",
  "altura": "1.70"
}
```

