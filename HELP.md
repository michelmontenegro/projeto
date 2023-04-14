# Getting Started

### Anotações e Informações da organização das classes 

* Controller:
  - **API Rest** (Retorna): Dados (JSON, XML)
  - **Web** (Retorna): Template (HTML + CSS + JavaScript)
  - A anotação "**RestController**" é a soma das anotações "**Controller** + **ResponseBody**", 
  onde **Controller** é o responsável por controlar as requisições indicando quem deve
 receber as requisições para quem deve responde-las, enquanto o **ResponseBody**
 retorna somente dados (XML ou JSon) em vez de retornar uma exibição (view (HTML + CSS + JavaScript))
  - **Autowired**: Cria um objeto com um contrutor padrão em cima
 da Interface "UsuarioRepository" (Injeção de dependencia)
  - **Transactional**: Quando terminar de excutar o metodo,
 ele encerra a transação aplicando um commit nos dados (Aplicando a transação).
  - **RequestBody**: indica que o campo vai retornar Dados (JSON ou XML), padrão é Json.

* DTO:
  - Anotação **Valid** garante que uma classe dentro de outra seja validada em cascata
    (Ex.: As classes UsuarioDTO->EnderecoDTO, são uma só classe, mas por organização foram divididas).
  - DTO é apenas um objeto não persistente, usado para a manipulação de dados

* Entity:
  - Entity: As entidades que representam as tabelas no banco de dados.
  - Relação DTO e Entity: Os DTOs que recebem inicialmente os dados 
enviados pela View ou Rest e usando o construtor da Entity repassamos os dados.
    - Explicação: Para fins de segurança um DTO nem sempre tem todos os atributos da entidade,
 para evitar injeção de dados via parametros do navegador, repassando assim só o que é
 extritamente necessario. Pode existir varios DTOs de Usuario e cada um com os campos especificos da entidade.
  - Getter: Adiciona automaticamente todos os Get
  - NoArgsConstructor: Adiciona automaticamente um construtor sem parametros
  - AllArgsConstructor: Adiciona automaticamente um construtor com todos os campos (parametros)
  - EqualsAndHashCode: Adiciona automaticamente o metodo Equals e Hascode usando o ID como base
  - Embedded: Informa que a classe Endereço é interna (uma continuação direta de Usuario),
 não representa outra tabela, é a mesma tabela.


### Links
Informações uteis para o projeto

* [Iniciando Spring](https://start.spring.io)
* [Acessando dados](https://spring.io/guides/gs/accessing-data-mysql/)
* [Import SpringBoot Eclipse](https://wwu-pi.github.io/tutorials/lectures/acse/030_importing_sample_projects.html)
* [docs spring WebApp](https://docs.spring.io/spring-boot/docs/2.1.7.RELEASE/reference/html/boot-features-developing-web-applications.html)
* [Spring MVC view layer: Thymeleaf vs. JSP](https://www.thymeleaf.org/doc/articles/thvsjsp.html)

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.0-M2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.0-M2/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.1.0-M2/reference/htmlsingle/#using.devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.0-M2/reference/htmlsingle/#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.0-M2/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Flyway Migration](https://docs.spring.io/spring-boot/docs/3.1.0-M2/reference/htmlsingle/#howto.data-initialization.migration-tool.flyway)
* [Validation](https://docs.spring.io/spring-boot/docs/3.1.0-M2/reference/htmlsingle/#io.validation)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/3.1.0-M2/reference/htmlsingle/#web.servlet.spring-mvc.template-engines)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Tutorial: Thymeleaf + Spring](https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html)
* [Spring and Thymeleaf 3: Expressions](https://www.baeldung.com/spring-thymeleaf-3-expressions)
* [Thymeleaf - Reaproveitando código com fragments](https://www.treinaweb.com.br/blog/thymeleaf-reaproveitando-codigo-com-fragments)