# Database per Service

[Voltar ao catalogo](../README.md)

## Intencao

Dar a cada servico autonomia sobre seus dados.

## Problema

Um banco compartilhado acopla equipes e servicos por tabelas, transacoes e
mudancas de schema.

## Como funciona

Cada servico possui e altera somente sua propria base. Outros servicos acessam
esses dados por API ou eventos, nao por leitura direta das tabelas.

## Quando usar

Use quando servicos precisam evoluir e escalar independentemente.

## Trade-offs

Aumenta autonomia, mas exige desenho explicito para consultas entre dominios e
consistencia eventual.

## Exemplo em Java

O exemplo `DatabasePerServiceExample` explicita dono e banco de cada servico.

## Como executar

```bash
../mvnw -pl database-per-service test
```

## Padroes relacionados

- [Saga](../saga/)
- [CQRS](../cqrs/)
