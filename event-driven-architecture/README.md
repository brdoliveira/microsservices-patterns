# Event-Driven Architecture

[Voltar ao catalogo](../README.md)

## Intencao

Desacoplar servicos por eventos de dominio.

## Problema

Chamadas sincronas em cadeia tornam servicos dependentes da disponibilidade uns
dos outros e dificultam evolucao independente.

## Como funciona

Um servico publica um evento quando algo relevante acontece. Outros servicos
assinam esse evento e reagem no seu proprio tempo.

## Quando usar

Use quando mudancas em um dominio precisam ser propagadas para varios
consumidores sem acoplamento direto.

## Trade-offs

Reduz acoplamento, mas exige observabilidade, tratamento de duplicidade e
consistencia eventual.

## Exemplo em Java

O exemplo `EventDrivenArchitectureExample` publica eventos para assinantes.

## Como executar

```bash
../mvnw -pl event-driven-architecture test
```

## Padroes relacionados

- [Saga](../saga/)
- [CQRS](../cqrs/)
