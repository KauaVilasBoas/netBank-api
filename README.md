<h1>API NetBank</h1>
  <p>Olá, seja muito bem vindo ao meu primeiro projeto solo utilizando Spring👋🏼</p>
  <p>Este é um projeto de uma APIRest do "NetBank".</p>
  
  <h2> 🗂️ Sumário </h2>
    <li><a href="#funcionalidades">Funcionalidades</a></li>
    <li><a href="#tecnologiasUtilizadas">Tecnologias Utilizadas</a></li>
    <li><a href="#estruturaDoProjeto">Estrutura do Projeto</a></li>
    <li><a href="#configurações">Configurações</a></li>
    <li><a href="#comoExecutar">Como Executar</a></li>
    <li><a href="#observações">Observações</a></li>
    <li><a href="#autor">Autor</a></li>
    <li><a href="#contatos">Contato</a></li>


  <h2  id="funcionalidades">📑Funcionalidades</h2>
  <ul>
    <li>Listar todas as contas cadastradas</li>
    <li>Cadastrar uma nova Conta</li>
    <li>Excluir uma Conta</li>
    <li>Efetuar um saque</li>
    <li>Efetuar depósito</li>
    <li>Efetuar transferência</li>
  </ul>

  <h2  id="tecnologiasUtilizadas">🖥️Tecnologias Utilizadas</h2>
  <ul>
    <li>Java</li>
    <li>Spring</li>
    <li>JPA / Hibernate</li>
    <li>PostgreSQL</li>
    <li>JDBC</li>
    <li>Lombok</li>
    <li>Spring Validation</li>
  </ul>
        

<h2 id="configurações">⚙️Configurações</h2>
  <p>Antes de executar o projeto, é necessário realizar as seguintes configurações:</p>
  <ol>
    <li>Configurar o banco de dados PostgreSQL e criar o banco de dados "contas".</li>
    <li>Modificar as informações de conexão com o banco de dados (URL, usuário e senha) no pacote resources/application.properties</li>
  </ol>

  <h2 id="comoExecutar">❓Como Executar</h2>
  <ol>
    <li>Clone ou faça o download do projeto para o seu ambiente de desenvolvimento.</li>
    <li>Importe o projeto para a sua IDE Java (Eclipse, IntelliJ, etc.).</li>
    <li>Realize as configurações necessárias conforme descrito acima.</li>
    <li>Start o projeto.</li>
    <li>Acesse a aplicação pelo Insomnia, Postman, etc. Utilizando as requisições abaixo.</li>
  </ol>

  <h2 id="endpoints">🌐Endpoints</h2>

|   Endpoints   |  Parameters  |    Verb    |
| :---         |     :---:      |          ---: |
| /contas/novaConta       |   *  |   POST    |
| /contas/getAll   |   *  | GET    |
| /contas/{id}   |   *  | DELETE    |
| /contas/saque        |   *  | PUT   |
/contas/deposito        |   *  | PUT   |
/contas/transferencia        |   *  | PUT   |

<details>
    <summary>CRIAR CONTA - /contas/novaConta </summary>
    
  ### Descrição
  
  - Cria uma conta e instancia-a no banco de dados.
  
  ### Códigos de Resposta
  
  - `201`: CREATED.
  
  ### Exemplo de Requisição
  
  - POST -  /contas/novaConta 
  - HTTP/1.1
  - Host: localhost:8080
  - Content-Type: application/json
  
  ```json
  {
    "numero": 48976,
    "conta": 713,
    "cliente": {
        "nome": "Kauã",
        "sobrenome": "Vilas Boas",
        "email": "kaua@netbank.com.br",
        "cpf": "09158963156",
        "endereco": {
        "rua": "rua 7",
        "bairro": "bairro 7",
        "cidade": "Salvador",
        "numeroResidencial": "960"
        }
    
      }
    }
  ```
  
  ### Exemplo de Resposta
  
  - HTTP/1.1 201 CREATED
  - Content-Type: application/json
  ```json
      Conta criada!
  ```
    
  </details>
  
  <details>
    <summary>LISTAR CONTAS - /contas/getAll </summary>
    
  ### Descrição
  
  Lista as contas contidas no banco de dados.
  
  ### Códigos de Resposta
  
  - `200`: OK.
  
  ### Exemplo de Requisição
  
  - GET - /contas/getAll
  - HTTP/1.1
  - Host: localhost:8080
  
  ### Exemplo de Resposta
  
  - HTTP/1.1 200 OK
  - Content-Type: application/json
  ```json
  [
  {
      "id": 1,
      "saldo": 923.0,
      "numero": 115789,
      "conta": 556,
      "cliente": {
          "nome": "Kaua",
          "sobrenome": "Vilas Boas",
          "cpf": "09158963544",
          "endereco": {
              "rua": "rua 1",
              "bairro": "bairro 1",
              "cidade": "Salvador",
              "numeroResidencial": 556
          }
      }
  },
  {
      "id": 7,
      "saldo": 0.0,
      "numero": 13245,
      "conta": 768,
      "cliente": {
          "nome": "Leonardo",
          "sobrenome": "Silva",
          "cpf": "09158963029",
          "endereco": {
              "rua": "rua 4",
              "bairro": "bairro 4",
              "cidade": "Salvador",
              "numeroResidencial": 416
          }
      }
  }
]
  ```
    
  </details>
  
  <details>
    <summary>EXCLUIR CONTA- /contas/{id}</summary>
    
  ### Descrição
  
  Deletar a conta.
  
  ### Códigos de Resposta
  
  - `204`: No Content.
  
  ### Exemplo de Requisição
  
  - DELETE - /contas/{id}
  - HTTP/1.1
  - Host: localhost:8080
  
  </details>
  
  <details>
    <summary>EFETUAR SAQUE - /contas/saque</summary>
    
  ### Descrição
  
  Efetua um saque do saldo da conta.
  
  ### Códigos de Resposta
  
  - `200`: OK!.
  
  ### Exemplo de Requisição
  
  - PUT /contas
  - Host: localhost:8080
    
    ```json
    {
      "id": 1,
      "valor": "920.00"
  }   ```
  
  ### Exemplo de Resposta
  
  - HTTP/1.1 200 OK
  - Content-Type: application/json
      
  ```json
    Saque efetuado com sucesso - 2023-06-02T15:57:15.411927900
  ```
    
  </details>

  <details>
    <summary>EFETUAR DEPÓSITO - /contas/deposito</summary>
    
  ### Descrição
  
  Efetua um deposito para o saldo da conta.
  
  ### Códigos de Resposta
  
  - `200`: OK!.
  
  ### Exemplo de Requisição
  
  - PUT /contas
  - Host: localhost:8080
    
    ```json
    {
      "id": 1,
      "valor": "780.00"
  }   ```
  
  ### Exemplo de Resposta
  
  - HTTP/1.1 200 OK
  - Content-Type: application/json
      
  ```json
    Depósito efetuado com sucesso - 2023-06-02T15:57:15.411927900
  ```
    
  </details>

  <details>
    <summary>EFETUAR TRANSFERÊNCIA - /contas/transferencia</summary>
    
  ### Descrição
  
  Efetua uma transferência de uma quantia de saldo de uma conta para outra.
  
  ### Códigos de Resposta
  
  - `200`: OK!.
  
  ### Exemplo de Requisição
  
  - PUT /contas
  - Host: localhost:8080
    
    ```json
    {
        "idContaRemetente": "1",
        "valor": "200.00",
        "idContaDestino": "7"
    } ```
  
  ### Exemplo de Resposta
  
  - HTTP/1.1 200 OK
  - Content-Type: application/json
      
  ```json
    Transferência realizada com sucesso! - 2023-06-02T15:12:54.502614100
  ```
    
  </details>

  <h2 id="observações">❗Observações</h2>
  <p>Este projeto é apenas uma demonstração básica de um banco ("netbank") utilizando Spring e Banco de Dados. Para fins de aprendizado e desenvolvimento.</p>

  <h2 id="autor">🖐️Autor</h2>
  <p>Kauã Caldeira Vilas Boas</p>
  
  <h2 id="contatos">📞Contato</h2>
  <ul>
    <li>Email: kauacaldeira@hotmail.com</li>
    <li>LinkedIn: <a href="https://www.linkedin.com/in/kauavilasboas/">Kauã Vilas Boas</a></li>
  </ul>
