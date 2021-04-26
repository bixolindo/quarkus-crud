
# Tutorial: Quarkus do Zero até o Deploy no Heroku, utilizando Quarkus Java + REST + CDI + Panache, Hibernate com Postgres + Postman
## Projeto: API REST

<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://quarkus.io">
  </a>
</p>


## Sobre o Projeto

### Um CRUD de Pessoa basico feito em quakus seguindo o tutorial do  Marcus Paulo

### Também foi criado um metodo para receber imagens e converter de ORM para DTO pra salvar no banco de dados e vice versa;


### Feito Com

Tecnologias utilizadas no projeto

- [JAVA](https://www.java.com/pt_BR/download/) - Java é uma linguagem de programação e plataforma computacional lançada pela primeira vez pela Sun Microsystems em 1995. Existem muitas aplicações e sites que não funcionarão, a menos que você tenha o Java instalado, e mais desses são criados todos os dias;
- [Quarkus](https://quarkus.io/) - A Red Hat lançou o Quarkus, um framework Java nativo do Kubernetes feito sob medida para o GraalVM e OpenJDK HotSpot. O Quarkus visa tornar o java uma plataforma líder em ambientes serverless e Kubernetes, oferecendo aos desenvolvedores um modelo unificado de programação reativa e imperativa;
- [Hibernate](http://hibernate.org/) - O Hibernate é um framework para o mapeamento objeto-relacional escrito na linguagem Java.
- [Hibernate Validator](https://hibernate.org/validator/)) - Permite implementar validações dos dados

<!-- GETTING STARTED -->

## Começando

Para reproduzir o exemplo, é necessário seguir os requisitos mínimos.

### Pré-requisitos

 - Você vai precisar de uma IDE como por exemplo: IntelliJ IDEA, Eclipse, VSCode.
 - Instale a JDK 8 or 11+
 - Instale o Apache Maven 3.6+
 - Panache Entity
 - Docker (Apenas para subir o banco de dados Postgres Localmente) 
 - Escolha um cliente para conectar com o Banco de dados, exemplo: DBeaver, PGAdmin, Postico (Mac)
 - Cliente para realizar requisições REST: Postman ou o Insomnia.
 - Conta no Github (repositório de Código)


 #### Docker
 - Escolha um cliente para conectar com o Banco de dados, exemplo: DBeaver, PGAdmin, Postico (Mac)
 - Cliente para realizar requisições REST: Postman ou o Insomnia.
 - Instruções Adicionais:
 - Instalação do Docker (Documentação oficial)
 - Instalando Docker no windows: (Youtube, ESR)
 - Instalando o Docker no Linux: (Youtube: LinuxTips)
 - Instalando o Docker no Mac: (Youtube: Wellington Rogati)

### Criação da aplicação

1. Para criar o projeto, basta utlizar o template do Maven + Quarkus, conforme o comando abaixo:

```sh
mvn io.quarkus:quarkus-maven-plugin:1.0.1.Final:create \
     -DprojectGroupId=br.com.food \
     -DprojectArtifactId=quarkus-food \
     -DclassName="br.com.food.resource.FoodResource" \
     -Dpath="/food"
```

(Alternativo) - O Quarkus disponibiliza um site chamado `https://code.quarkus.io/`, onde é posísvel configurar o projeto de uma forma mais visual, vale a pena conferir, segue o link: https://code.quarkus.io/

---

#### Executando a Instância do Postgresql no Docker 

Para iniciar o Postgresql, basta rodar o comando abaixo (O Docker precisa estar instalado): 

```sh
docker run --name postgres-product -e  "POSTGRES_PASSWORD=postgres" -p 5432:5432 -v ~/developer/PostgreSQL:/var/lib/postgresql/data -d postgres

```

### Executando o projeto em Quarkus

Para executar um projeto em Quarkus, basta executar o comando: 
```sh
mvn compile quarkus:dev
```

