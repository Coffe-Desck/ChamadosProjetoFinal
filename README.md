![Banner LOGO](https://i.imgur.com/9WAsKpZ.gif)

# ☕Sistema de Chamados Técnicos!

Este projeto consiste no desenvolvimento de um sistema completo de chamados técnicos em informática, que permite aos usuários solicitar atendimento e aos técnicos assumirem esses chamados, realizando o atendimento e modificando o status conforme necessário. O sistema é desenvolvido utilizando Java Spring Boot para a camada de backend, MySQL para o banco de dados, e um template de telas para a interface do usuário.

# Telas
### Tela Inicial
- Breve descrição sobre o sistema para introduzir o usuário.


![Gif tela inicial](https://i.imgur.com/wiu3kBx.png)

### Tela Login
- Possibilidade de login e cadastro (usuário, cadastro e admin).
- Utilização de verificação de login para acesso ao sistema.
- Utilização de banco de dados MySQL.
![Gif tela inicial](https://i.imgur.com/uj31mFP.png)

### Tela de Cadastro de cliente
- Contem um formulario com
  -  Nome
  -  Email
  -  Senha
  ![Gif tela inicial](https://i.imgur.com/kxOeUro.png)
### Tela do Usuário
- Visualização dos chamados criados anteriormente.
- Possibilidade de criar novos chamados.
- Cadastro dos chamados no banco de dados.
- Campos necessários para cadastro.
  ![Gif tela inicial](https://i.imgur.com/4fIMqUe.png)

### Tela do Técnico
- Visualização dos chamados disponíveis e atribuídos ao técnico.
- Visualização detalhada das informações do chamado.
- Modificação do status do chamado para "Aguardando técnico", "Em atendimento", "Escalado para outro setor" ou "Finalizado".
  ![Gif tela inicial](https://i.imgur.com/QutxQsO.png)

### Tela administrador 
- Tela do Administrador
- Visão abrangente do uso do sistema.
- Dados essenciais como número de chamados em aberto, em execução e aguardando.
- Gerenciamento de setores da empresa e tipos de prioridade.
- Essa tela oferece uma visão abrangente do uso do sistema, fornecendo dados
essenciais, como o número de chamados em aberto, em execução e
aguardando. Além disso, permite o gerenciamento de elementos-chave do
sistema, como os setores da empresa e os tipos de prioridade.
  ![Gif tela inicial](https://i.imgur.com/tSMgwkO.png)


# Especificações do Sistema Utilizadas
- Programação Orientada a Objetos.
- Java Spring Boot para o backend.
- Template de telas para a interface do usuário.
- Banco de dados MySQL.
- Versionamento no GitHub.
- Disponibilização de uma API RESTful.

# Tecnologias Usadas
- Back End
<div style="display: flex; align-items: center;">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" alt="Java Logo" width="50" height="50"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/spring/spring-original.svg" alt="Spring Logo" width="50" height="50"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/swagger/swagger-original.svg" alt="Swagger Logo" width="50" height="50"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/postman/postman-original.svg" alt="Postman Logo" width="50" height="50"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/mysql/mysql-original.svg" alt="MySQL Logo" width="50" height="50"/>
</div>
<br>
- Front End
<div style="display: flex; align-items: center;">
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/angular/angular-original.svg" width="50" height="50"/><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/html5/html5-original.svg" width="50" height="50"/><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/css3/css3-original.svg" width="50" height="50"/><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/bootstrap/bootstrap-original.svg" width="50" height="50"/>       
</div>

### Repositorio Front end
[Link do github](https://github.com/Nataly-Carvalho/CoffeDesck-front)

### Documentação do Swagger
[PDF com documentação](https://descomplica2-my.sharepoint.com/:b:/g/personal/nataly_2322956_aluno_faculdadedescomplica_com_br/Efaj8JCfFttJrcL6rchqPgABiVptaw_G01yZRySkR4KYPw?e=azQpaJ)

# Dependencias Usadas no spring
| **Group ID**                        | **Artifact ID**                              | **Version**  | **Scope**  | **Optional** |
|-------------------------------------|----------------------------------------------|--------------|------------|--------------|
| org.springframework.boot            | spring-boot-starter-data-jpa                 |              |            |              |
| org.springframework.security        | spring-security-crypto                       |              |            |              |
| org.springframework.boot            | spring-boot-starter-thymeleaf                |              |            |              |
| org.springframework.boot            | spring-boot-starter-validation               |              |            |              |
| org.springframework.boot            | spring-boot-starter-web                      |              |            |              |
| org.thymeleaf.extras                | thymeleaf-extras-springsecurity6             |              |            |              |
| org.springframework.boot            | spring-boot-devtools                         |              | runtime    | true         |
| com.mysql                           | mysql-connector-j                            |              | runtime    |              |
| org.projectlombok                   | lombok                                       |              |            | true         |
| org.springdoc                       | springdoc-openapi-starter-webmvc-api         | 2.2.0        |            |              |
| org.springdoc                       | springdoc-openapi-starter-webmvc-ui          | 2.2.0        |            |              |
| io.springfox                        | springfox-boot-starter                       | 3.0.0        |            |              |
| org.springframework.boot            | spring-boot-starter-test                     |              | test       |              |
| org.springframework.security        | spring-security-test                         |              | test       |              |
| org.springframework.boot            | spring-boot-starter-mail                     |              |            |              |
| org.springframework.security        | spring-security-core                         |              |            |              |
| org.postgresql                      | postgresql                                   |              |            |              |

# Como Executar o Projeto
- Clone o repositório do GitHub:
-     git clone https://github.com/seu-usuario/nome-do-repositorio.git
- Importe o projeto para sua IDE favorita.
- Configure o banco de dados MySQL conforme as configurações do arquivo application.properties.
- Execute o projeto.
# Equipe

☕[Lays Sousa](https://github.com/laregn)
<br>
☕[Juliana Rodrigues](https://github.com/jucrodrigues)
<br>
☕[Gracielle Pereira](https://github.com/Gracielle-Pereira)
<br>
☕[Bianca Bareto](https://github.com/BiancalBarreto)
<br>
☕[Nataly Carvalho](https://github.com/Nataly-Carvalho?tab=repositories)





