# Circuit Breaker

[Voltar ao catalogo](../README.md)

## Intencao

Parar temporariamente chamadas para uma dependencia que esta falhando.

## Problema

Repetir chamadas para um servico indisponivel consome recursos e espalha
lentidao para quem depende dele.

## Como funciona

O circuito conta falhas. Ao atingir um limite, abre e rejeita chamadas por um
periodo ou ate uma nova verificacao controlada.

## Quando usar

Use em chamadas remotas sujeitas a timeout, indisponibilidade ou degradacao.

## Trade-offs

Evita cascata de falhas, mas exige fallback claro e configuracao cuidadosa do
limite de falhas.

## Exemplo em Java

O exemplo `CircuitBreakerExample` abre o circuito depois de falhas consecutivas.

## Como executar

```bash
../mvnw -pl circuit-breaker test
```

## Padroes relacionados

- [Bulkhead](../bulkhead/)
- [Externalized Configuration](../externalized-configuration/)
