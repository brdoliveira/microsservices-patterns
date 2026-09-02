# Bulkhead

[Voltar ao catalogo](../README.md)

## Intencao

Isolar recursos para que uma falha localizada nao consuma todo o sistema.

## Problema

Quando todos os fluxos compartilham o mesmo pool de recursos, um fluxo lento
pode esgotar threads, conexoes ou memoria dos demais.

## Como funciona

Cada fluxo ou dependencia recebe um limite proprio de concorrencia. Ao atingir
o limite, novas chamadas daquele grupo sao rejeitadas ou enfileiradas.

## Quando usar

Use em sistemas com dependencias de risco diferente ou fluxos com prioridades
operacionais distintas.

## Trade-offs

Limita o impacto de falhas, mas pode reduzir utilizacao global se os limites
forem conservadores demais.

## Exemplo em Java

O exemplo `BulkheadExample` usa um semaforo para limitar concorrencia.

## Como executar

```bash
../mvnw -pl bulkhead test
```

## Padroes relacionados

- [Circuit Breaker](../circuit-breaker/)
- [Externalized Configuration](../externalized-configuration/)
