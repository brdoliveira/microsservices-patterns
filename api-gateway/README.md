# API Gateway

[Voltar ao catalogo](../README.md)

## Intencao

Oferecer um ponto unico de entrada para clientes externos.

## Problema

Clientes nao devem conhecer a topologia interna de servicos, nem repetir logica
de autenticacao, roteamento e politicas transversais.

## Como funciona

O gateway recebe uma requisicao, identifica o destino pelo caminho ou contrato
publico e encaminha a chamada para o servico interno correto.

## Quando usar

Use quando varios clientes precisam consumir muitos servicos internos por uma
API publica consistente.

## Trade-offs

Centraliza politicas e simplifica clientes, mas pode virar ponto de gargalo se
nao houver escalabilidade e observabilidade.

## Exemplo em Java

O exemplo `ApiGatewayExample` mapeia caminhos publicos para nomes de servicos.

## Como executar

```bash
../mvnw -pl api-gateway test
```

## Padroes relacionados

- [Service Discovery](../service-discovery/)
- [Backends for Frontends](../backends-for-frontends/)
- [Strangler Fig](../strangler-fig/)
