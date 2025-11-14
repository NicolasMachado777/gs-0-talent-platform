# GS-0 Talent Platform

## Equipe

- José Roberto Claudino Ferreira — RM 552407
- Nicolas Machado — RM 552493

## Tema escolhido

**Plataformas que conectam talentos a projetos com propósito.** A solução propõe um hub orientado a carreira e impacto social, onde profissionais com habilidades diversas encontram iniciativas alinhadas a valores e metas de transformação.

## Finalidade da API

A API desenvolvida integra sistemas e facilita o compartilhamento de oportunidades entre empresas e talentos, mantendo contratos de serviços alinhados ao tema da Global Solution. Ela oferece endpoints RESTful para listar temas, publicar demandas, conectar projetos a especialistas e disponibiliza documentação (OpenAPI) para acelerar a adoção em nuvem.

## Documentação (Swagger / OpenAPI)

- Acesse a especificação da API em `http://localhost:8081/swagger-ui/index.html` após executar a aplicação localmente.

## Execução local

1. Garanta que Java 17 e Docker estejam disponíveis.
2. Compile e execute os testes com Maven:
   ```bash
   ./mvnw clean package
   ./mvnw spring-boot:run
   ```
3. Alternativamente, execute diretamente via Maven Wrapper para validar localmente.
4. Para gerar a imagem Docker usada na pipeline, rode:
   ```bash
   docker build --file Dockerfile --tag gs-0-talent-platform-ci .
   ```
5. Verifique a imagem com:
   ```bash
   docker images | grep gs-0-talent-platform-ci
   ```
6. Para executar a imagem e rodar o serviço localmente:
   ```bash
   docker run -p 8081:8081 --rm gs-0-talent-platform-ci
   ```
   A aplicação ficará disponível em `http://localhost:8081`.

## Artefatos Docker

- Imagem pública no Docker Hub: [https://hub.docker.com/r/salocin777/gs-0-talent-platform/tags](https://hub.docker.com/r/salocin777/gs-0-talent-platform/tags)

## Workflows CI/CD implementados

### CI — Continuous Integration

- É disparado em `push` para `feature/**`, `release` e `hotfix/**`.
- Executa checkout, configura Java 17, roda `mvn -B clean verify` (build + testes) e valida o Dockerfile via `docker build --file Dockerfile --tag gs-0-talent-platform-ci .`.

### CD — Continuous Delivery

- Disparado por pull requests contra `develop`, garante que a imagem final ganhe tags com base no PR e no branch `develop`.
- Executa login no Docker Hub utilizando `DOCKER_USER`/`DOCKER_TOKEN`, gera metadados e publica a imagem em `salocin777/gs-0-talent-platform`.

### Automação de Versão (Versioning)

- Workflow `release-please` acionado por `push` em `main` usa o `googleapis/release-please-action@v4` para criar releases e tags automaticamente (`release-type: maven`).
- Garante versionamento semiautomático alinhado ao modelo Maven e disponibiliza evidência de tags criadas no repositório.

> A documentação e os workflows foram pensados para manter o projeto pronto para implantação contínua em nuvem, com rastreabilidade de versões, build seguro e publicação automática da imagem Docker.
