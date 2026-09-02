# Outbox

[Voltar ao catalogo](../README.md)

## Intencao

Publicar eventos de forma confiavel depois de uma mudanca local de estado.

## Problema

Gravar no banco e publicar em um broker sao duas operacoes diferentes. Se uma
passa e a outra falha, consumidores podem ficar sem saber que a mudanca ocorreu.

## Como funciona

O servico grava a entidade e uma mensagem de outbox na mesma transacao local.
Um publicador separado le mensagens pendentes, publica no broker e marca a
mensagem como enviada.

## Quando usar

Use quando um servico precisa persistir dados e emitir eventos sem depender de
transacao distribuida entre banco e mensageria.

## Trade-offs

Aumenta confiabilidade, mas adiciona tabela/fila local, publicador e tratamento
de duplicidade no consumidor.

## Exemplo em Java

O exemplo `OutboxPatternExample` e um componente Spring `@Service` que grava um
pedido e uma mensagem de outbox no mesmo fluxo.

## Como executar

```bash
../mvnw -pl outbox test
```

## Padroes relacionados

- [Event-Driven Architecture](../event-driven-architecture/)
- [Idempotency](../idempotency/)
