# Backends for Frontends

[Voltar ao catalogo](../README.md)

## Intencao

Criar APIs especificas para as necessidades de cada tipo de cliente.

## Problema

Mobile, web e integrações externas podem precisar de formatos, agregacoes e
ritmos de evolucao diferentes. Uma API unica tende a ficar generica demais.

## Como funciona

Cada frontend consome um backend dedicado que agrega dados e modela respostas
para aquele canal.

## Quando usar

Use quando clientes distintos exigem contratos muito diferentes ou quando uma
equipe precisa evoluir um canal sem afetar os demais.

## Trade-offs

Melhora experiencia do cliente e autonomia de equipes, mas pode duplicar logica
de agregacao se fronteiras nao forem claras.

## Exemplo em Java

O exemplo `BackendsForFrontendsExample` e um `@RestController` Spring com
respostas diferentes para mobile e web.

## Como executar

```bash
../mvnw -pl backends-for-frontends test
```

## Padroes relacionados

- [API Gateway](../api-gateway/)
- [CQRS](../cqrs/)
