A aplicação irá rodar na porta `5000`.
Para acessar a interface de teste de API (Swagger) o link é: <http://localhost:5000/swagger-ui.html>
Para acessar o banco de dados de teste da aplicação: 
<http://localhost:5000/h2-console> ao entrar digitar no campo JDBC URL: `jdbc:h2:file:~/fesc/fesc-test`
O front-end requer as dependências: *nodejs, grunt e bower*.
Caso queira rodar o front-end localmente será necessário rodar dentro da pasta `fescAplication/fesc_app` os comandos:
```
npm install
bower install
grunt serve
```
