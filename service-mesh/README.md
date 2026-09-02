# Service Mesh

[Voltar ao catalogo](../README.md)

## Intencao

Aplicar politicas de comunicacao entre servicos fora do codigo de negocio.

## Problema

Timeouts, retries, mTLS, observabilidade e regras de trafego se repetem em
varios servicos quando cada aplicacao implementa tudo sozinha.

## Como funciona

Um proxy sidecar ou camada de malha intercepta comunicacao entre servicos e
aplica politicas configuradas pela plataforma.

## Quando usar

Use quando muitos servicos precisam de politicas uniformes de rede,
seguranca, telemetria ou roteamento gradual.

## Trade-offs

Reduz codigo transversal nas aplicacoes, mas aumenta complexidade operacional e
dependencia da plataforma.

## Exemplo em Java

O exemplo `ServiceMeshExample` mostra codigo de negocio chamando um cliente
enquanto politicas de malha sao modeladas fora do metodo de dominio.

## Como executar

```bash
../mvnw -pl service-mesh test
```

## Padroes relacionados

- [Retry with Backoff](../retry-with-backoff/)
- [Circuit Breaker](../circuit-breaker/)
