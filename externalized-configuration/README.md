# Externalized Configuration

[Voltar ao catalogo](../README.md)

## Intencao

Manter configuracoes fora do binario da aplicacao.

## Problema

Valores de ambiente, credenciais e parametros operacionais mudam entre
ambientes e nao devem exigir recompilacao.

## Como funciona

A aplicacao le configuracoes de variaveis de ambiente, arquivos externos ou um
servico de configuracao.

## Quando usar

Use em qualquer servico que precisa rodar em mais de um ambiente ou receber
ajustes operacionais sem alteracao de codigo.

## Trade-offs

Facilita operacao por ambiente, mas exige governanca para nomes, defaults e
seguranca dos valores.

## Exemplo em Java

O exemplo `ExternalizedConfigurationExample` le configuracoes de um mapa externo.

## Como executar

```bash
../mvnw -pl externalized-configuration test
```

## Padroes relacionados

- [Service Discovery](../service-discovery/)
- [Circuit Breaker](../circuit-breaker/)
