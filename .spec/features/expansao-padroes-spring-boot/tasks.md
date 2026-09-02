# Tasks: Expansao de padroes com exemplos Spring Boot

> feature: expansao-padroes-spring-boot

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

## T-007 — Configurar suporte Spring Boot e auditoria da expansao [concluida]
- Refs: US-008, AC-012, AC-013, AC-014
- Arquivos: pom.xml, scripts/onp-verify-tap.mjs, catalog-validation/src/test/java/io/github/microservicespatterns/catalog/CatalogStructureTest.java
- Notas: Adicionar BOM/dependencias Spring Boot, atualizar validacoes para 15 padroes e emitir TAP granular para a expansao.

## T-008 — Adicionar Outbox e Idempotency [concluida]
- Refs: US-005, AC-010, AC-011, AC-013
- Arquivos: outbox/README.md, outbox/pom.xml, outbox/src/main/java/io/github/microservicespatterns/outbox/OutboxPatternExample.java, outbox/src/test/java/io/github/microservicespatterns/outbox/OutboxPatternExampleTest.java, idempotency/README.md, idempotency/pom.xml, idempotency/src/main/java/io/github/microservicespatterns/idempotency/IdempotencyExample.java, idempotency/src/test/java/io/github/microservicespatterns/idempotency/IdempotencyExampleTest.java
- Notas: Cobrir consistencia entre banco e evento, e protecao contra reprocessamento de comandos.

## T-009 — Adicionar Backends for Frontends e Retry with Backoff [concluida]
- Refs: US-005, AC-010, AC-011, AC-013
- Arquivos: backends-for-frontends/README.md, backends-for-frontends/pom.xml, backends-for-frontends/src/main/java/io/github/microservicespatterns/bff/BackendsForFrontendsExample.java, backends-for-frontends/src/test/java/io/github/microservicespatterns/bff/BackendsForFrontendsExampleTest.java, retry-with-backoff/README.md, retry-with-backoff/pom.xml, retry-with-backoff/src/main/java/io/github/microservicespatterns/retry/RetryWithBackoffExample.java, retry-with-backoff/src/test/java/io/github/microservicespatterns/retry/RetryWithBackoffExampleTest.java
- Notas: Cobrir APIs por cliente e retentativas com espera crescente.

## T-010 — Adicionar Service Mesh [concluida]
- Refs: US-005, AC-010, AC-011, AC-013
- Arquivos: service-mesh/README.md, service-mesh/pom.xml, service-mesh/src/main/java/io/github/microservicespatterns/servicemesh/ServiceMeshExample.java, service-mesh/src/test/java/io/github/microservicespatterns/servicemesh/ServiceMeshExampleTest.java
- Notas: Mostrar politicas transversais aplicadas fora do codigo de negocio.

## T-011 — Aprofundar exemplos existentes com componentes Spring [concluida]
- Refs: US-006, AC-012, AC-013
- Arquivos: api-gateway/src/main/java/io/github/microservicespatterns/apigateway/ApiGatewayExample.java, service-discovery/src/main/java/io/github/microservicespatterns/servicediscovery/ServiceDiscoveryExample.java, circuit-breaker/src/main/java/io/github/microservicespatterns/circuitbreaker/CircuitBreakerExample.java, bulkhead/src/main/java/io/github/microservicespatterns/bulkhead/BulkheadExample.java, database-per-service/src/main/java/io/github/microservicespatterns/databaseperservice/DatabasePerServiceExample.java, saga/src/main/java/io/github/microservicespatterns/saga/SagaExample.java, cqrs/src/main/java/io/github/microservicespatterns/cqrs/CqrsExample.java, event-driven-architecture/src/main/java/io/github/microservicespatterns/eventdriven/EventDrivenArchitectureExample.java, strangler-fig/src/main/java/io/github/microservicespatterns/stranglerfig/StranglerFigExample.java, externalized-configuration/src/main/java/io/github/microservicespatterns/externalizedconfiguration/ExternalizedConfigurationExample.java
- Notas: Adicionar anotacoes Spring Boot/Spring Framework preservando exemplos pequenos.

## T-012 — Atualizar documentacao e indice do catalogo [concluida]
- Refs: US-005, US-006, AC-010, AC-011, AC-012
- Arquivos: README.md, api-gateway/README.md, service-discovery/README.md, circuit-breaker/README.md, bulkhead/README.md, database-per-service/README.md, saga/README.md, cqrs/README.md, event-driven-architecture/README.md, strangler-fig/README.md, externalized-configuration/README.md
- Notas: Incluir os cinco novos padroes e mencionar a aproximacao com componentes Spring Boot nos exemplos.
