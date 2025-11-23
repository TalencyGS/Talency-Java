# Talency - Java

## Contexto da solução

O Talency é uma plataforma que ajuda estudantes e profissionais a planejarem e acompanharem sua evolução em carreiras de alta demanda, como

- Desenvolvedor Fullstack  
- Cientista de Dados  
- Designer de UX  
- Técnico em Energia Verde  
- Analista de Cibersegurança  
- Outras profissões emergentes ligadas a dados, ESG e automação  

Na web e no backend, a solução oferece trilhas pré definidas, testes práticos, roadmaps de metas e um módulo de IA Advisor.  
O aplicativo mobile concentra no celular as principais funcionalidades do Talency relacionadas a autenticação, visualização de trilhas, acompanhamento de roadmap e interação com a IA de orientação.

## Integrantes do grupo

- Felipe Menezes Prometti  · RM558976 · Turma 2TDSPM  
- Maria Eduarda Pires Vieira  · RM55514 · Turma 2TDSPZ  
- Samuel Damasceno Silva  · RM558876 · Turma 2TDSPM  

## Links importantes

- Vídeo de demonstração no YouTube: https://www.youtube.com/watch?v=fXTXSO7fhlQ

## Arquitetura

O projeto foi desenvolvido seguindo a Arquitetura em Camadas (MVC) e usando as melhores práticas do ecossistema Spring.

- MVC (Model-View-Controller): Separamos a exposição da API (Controller), regras de negócio (Service) e dados (Repository/Model).
- DTO (Data Transfer Object): Utilizamos para a transferência de dados entre o cliente (Mobile) e o servidor, protegendo as entidades de domínio e formatando as respostas.
- Spring Data JPA

## Fluxo da Solução:

- Mobile (Client): Envia requisição HTTP.
- Controller: Recebe o DTO e valida os dados.
- Service: Aplica regras de negócio.
- Integração IoT: Comunica-se com o microsserviço de IA (Python).
- Repository: Persiste os dados e logs de auditoria no Oracle DB.

## Tecnologias Utilizadas
- Java 21
- Spring Boot 3.2.3
- Spring Data JPA
- Spring Web (API REST)
- Oracle JDBC Driver
- Lombok
- Gradle

## Endpoints

| Método | Rota               | Descrição                               |
| :----: | :----------------: | :-------------------------------------: |
| POST   | /api/usuarios      | Cria um novo usuário com Hash de senha  |
| GET    | /api/usuarios      | Lista todos os usuários                 |
| GET    | /api/usuarios/{id} | Busca detalhes de um usuário específico |
| POST   | /api/ia/solicitar  | Envia prompt para o Python              |

## Como rodar o projeto

### Pré-requisitos
- Java JDK 21 instalado.
- Acesso ao Banco de Dados Oracle (VPN ou Cloud).
- Microsserviço de IA (Python) rodando (veja o readme de https://github.com/TalencyGS/Talency-IOT)

### Configuração

- Clone o repositório.
- Configure as credenciais do banco no arquivo src/main/resources/application.properties:

```properties
spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL
spring.datasource.username=SEU_RM
spring.datasource.password=SUA_SENHA
```

- Executar o projeto
