# Tasks: Catalogo de padroes de microsservicos

> feature: catalogo-padroes-microsservicos

<!--
  Como ler este arquivo (o formato é verificado por `onp-spec audit`):
  - T-xxx = tarefa (código de rastreio, único no projeto inteiro).
  - Toda tarefa referencia em `Refs:` pelo menos uma história de usuário
    (US-xxx) ou critério de aceite (AC-xxx).
  - Toda tarefa lista os arquivos que cria/altera em `Arquivos:` — capriche:
    é o que decide o que `onp-spec plano` roda em PARALELO (arquivos
    disjuntos) e o que roda em sequência.
  - Campos opcionais por tarefa, usados pelo plano de execução:
    `- Modelo: claude-sonnet-5` e `- Esforço: alto` (baixo|medio|alto|xalto|max).
  - Uma tarefa só pode virar [concluida] quando os critérios de aceite dela
    tiverem prova PASS registrada por `onp-spec verify`.
  Status: pendente | em-andamento | concluida
    (atalho: `onp-spec tarefa <feature> <T-xxx> <status>`)
-->

## T-001 — Configurar base Java e verificacoes do catalogo [concluida]
- Refs: US-003, US-004, AC-006, AC-008, AC-009
- Arquivos: pom.xml, scripts/onp-verify-tap.mjs, catalog-validation/src/test/java/io/github/microservicespatterns/catalog/CatalogStructureTest.java, catalog-validation/pom.xml
- Notas: Criar projeto Maven multi-module, testes de validacao estrutural e geracao de JavaDoc.

## T-002 — Escrever README raiz com indice dos padroes [concluida]
- Refs: US-001, AC-001, AC-002
- Arquivos: README.md
- Notas: Incluir descricao curta do repositorio, tabela dos padroes, resumo de cada um e links para as pastas.

## T-003 — Documentar e exemplificar padroes de entrada e descoberta [concluida]
- Refs: US-002, US-003, AC-003, AC-004, AC-005, AC-006, AC-007
- Arquivos: api-gateway/README.md, api-gateway/pom.xml, api-gateway/src/main/java/io/github/microservicespatterns/apigateway/ApiGatewayExample.java, api-gateway/src/test/java/io/github/microservicespatterns/apigateway/ApiGatewayExampleTest.java, service-discovery/README.md, service-discovery/pom.xml, service-discovery/src/main/java/io/github/microservicespatterns/servicediscovery/ServiceDiscoveryExample.java, service-discovery/src/test/java/io/github/microservicespatterns/servicediscovery/ServiceDiscoveryExampleTest.java
- Notas: Cobrir API Gateway e Service Discovery com exemplos Java pequenos e JavaDoc publico.

## T-004 — Documentar e exemplificar padroes de resiliencia [concluida]
- Refs: US-002, US-003, AC-003, AC-004, AC-005, AC-006, AC-007
- Arquivos: circuit-breaker/README.md, circuit-breaker/pom.xml, circuit-breaker/src/main/java/io/github/microservicespatterns/circuitbreaker/CircuitBreakerExample.java, circuit-breaker/src/test/java/io/github/microservicespatterns/circuitbreaker/CircuitBreakerExampleTest.java, bulkhead/README.md, bulkhead/pom.xml, bulkhead/src/main/java/io/github/microservicespatterns/bulkhead/BulkheadExample.java, bulkhead/src/test/java/io/github/microservicespatterns/bulkhead/BulkheadExampleTest.java
- Notas: Cobrir Circuit Breaker e Bulkhead com exemplos Java pequenos e JavaDoc publico.

## T-005 — Documentar e exemplificar padroes de dados e transacao [concluida]
- Refs: US-002, US-003, AC-003, AC-004, AC-005, AC-006, AC-007
- Arquivos: database-per-service/README.md, database-per-service/pom.xml, database-per-service/src/main/java/io/github/microservicespatterns/databaseperservice/DatabasePerServiceExample.java, database-per-service/src/test/java/io/github/microservicespatterns/databaseperservice/DatabasePerServiceExampleTest.java, saga/README.md, saga/pom.xml, saga/src/main/java/io/github/microservicespatterns/saga/SagaExample.java, saga/src/test/java/io/github/microservicespatterns/saga/SagaExampleTest.java, cqrs/README.md, cqrs/pom.xml, cqrs/src/main/java/io/github/microservicespatterns/cqrs/CqrsExample.java, cqrs/src/test/java/io/github/microservicespatterns/cqrs/CqrsExampleTest.java
- Notas: Cobrir Database per Service, Saga e CQRS com exemplos Java pequenos e JavaDoc publico.

## T-006 — Documentar e exemplificar padroes de integracao e evolucao [concluida]
- Refs: US-002, US-003, AC-003, AC-004, AC-005, AC-006, AC-007
- Arquivos: event-driven-architecture/README.md, event-driven-architecture/pom.xml, event-driven-architecture/src/main/java/io/github/microservicespatterns/eventdriven/EventDrivenArchitectureExample.java, event-driven-architecture/src/test/java/io/github/microservicespatterns/eventdriven/EventDrivenArchitectureExampleTest.java, strangler-fig/README.md, strangler-fig/pom.xml, strangler-fig/src/main/java/io/github/microservicespatterns/stranglerfig/StranglerFigExample.java, strangler-fig/src/test/java/io/github/microservicespatterns/stranglerfig/StranglerFigExampleTest.java, externalized-configuration/README.md, externalized-configuration/pom.xml, externalized-configuration/src/main/java/io/github/microservicespatterns/externalizedconfiguration/ExternalizedConfigurationExample.java, externalized-configuration/src/test/java/io/github/microservicespatterns/externalizedconfiguration/ExternalizedConfigurationExampleTest.java
- Notas: Cobrir Event-Driven Architecture, Strangler Fig e Externalized Configuration com exemplos Java pequenos e JavaDoc publico.
