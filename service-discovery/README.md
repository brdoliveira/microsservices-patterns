# Service Discovery

[Voltar ao catalogo](../README.md)

## Intencao

Localizar instancias de servicos em tempo de execucao.

## Problema

Em microsservicos, instancias sobem, descem e mudam de endereco. Chamar
enderecos fixos torna o sistema fragil.

## Como funciona

Cada instancia se registra em um catalogo. Consumidores consultam esse catalogo
para escolher uma instancia disponivel antes de chamar o servico.

## Quando usar

Use quando servicos escalam horizontalmente ou rodam em infraestrutura dinamica.

## Trade-offs

Melhora flexibilidade operacional, mas adiciona dependencia de um registro
confiavel e estrategia para instancias obsoletas.

## Exemplo em Java

O exemplo `ServiceDiscoveryExample` registra instancias por nome de servico e
seleciona uma delas para chamada.

## Como executar

```bash
../mvnw -pl service-discovery test
```

## Padroes relacionados

- [API Gateway](../api-gateway/)
- [Externalized Configuration](../externalized-configuration/)
