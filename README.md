# ProductMS - Compasso UOL Test
* Teste técnico com desenvolvimento de API Rest
* Especificações do teste podem ser encontradas no link: <https://bitbucket.org/RecrutamentoDesafios/desafio-java-springboot/src/master/>

##Passo a passo para execução
### Clone este repositório
$ git clone <https://github.com/mateusmatinato/productms-compasso.git>

### Acesse a pasta do projeto no terminal/cmd
$ cd productms-compasso

### Rode o maven para instalação de dependências
$ mvn clean install

### Execute a aplicação
$ mvn spring-boot:run

* Obs: necessário possuir o java 11 instalado e configurado.
* O servidor inciará na porta:9999

## Para testes dos endpoints
### Usuário de aplicação (Basic Auth)
* username: user
* password: password

### Collection
* É possível encontrar a collection do postman no arquivo /postman/collection.json

### Swagger
* Também é possível testar pela interface do swagger acessando a url <http://localhost:9999/swagger-ui.html>
