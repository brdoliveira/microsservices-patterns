# Saga

[Voltar ao catalogo](../README.md)

## Intencao

Coordenar uma transacao de negocio distribuida sem depender de transacao global.

## Problema

Operacoes que atravessam varios servicos nao devem segurar locks distribuidos
nem depender de commit atomico entre bancos diferentes.

## Como funciona

A saga executa etapas locais e define uma compensacao para desfazer efeitos de
etapas ja concluidas quando uma etapa posterior falha.

## Quando usar

Use em processos de negocio longos, distribuidos e com necessidade de
recuperacao clara.

## Trade-offs

Evita transacao distribuida, mas exige idempotencia, compensacoes e modelagem de
estados intermediarios.

## Exemplo em Java

O exemplo `SagaExample` registra etapas e suas compensacoes.

## Como executar

```bash
../mvnw -pl saga test
```

## Padroes relacionados

- [Database per Service](../database-per-service/)
- [Event-Driven Architecture](../event-driven-architecture/)
