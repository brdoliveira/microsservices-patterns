# Retry with Backoff

[Voltar ao catalogo](../README.md)

## Intencao

Repetir falhas transientes com esperas crescentes entre tentativas.

## Problema

Retentar imediatamente pode piorar uma indisponibilidade temporaria e gerar
picos de carga em uma dependencia ja degradada.

## Como funciona

O cliente tenta novamente apenas para falhas consideradas transientes e aumenta
o intervalo entre tentativas, normalmente com limite maximo e jitter.

## Quando usar

Use em chamadas remotas sujeitas a falhas temporarias, como timeouts curtos,
limites de taxa ou instabilidade momentanea.

## Trade-offs

Melhora resiliencia, mas pode aumentar latencia percebida e precisa de cuidado
para nao repetir operacoes nao idempotentes.

## Exemplo em Java

O exemplo `RetryWithBackoffExample` e um `@Service` Spring que aplica atrasos
exponenciais entre tentativas.

## Como executar

```bash
../mvnw -pl retry-with-backoff test
```

## Padroes relacionados

- [Idempotency](../idempotency/)
- [Circuit Breaker](../circuit-breaker/)
