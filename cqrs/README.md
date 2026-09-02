# CQRS

[Voltar ao catalogo](../README.md)

## Intencao

Separar comandos de escrita e consultas de leitura.

## Problema

O mesmo modelo raramente atende bem validacoes de escrita e consultas otimizadas
quando o dominio cresce.

## Como funciona

Comandos alteram o estado do dominio. Consultas leem um modelo preparado para
exibicao, relatorio ou pesquisa.

## Quando usar

Use quando leituras e escritas tem necessidades diferentes de escala, formato ou
latencia.

## Trade-offs

Permite modelos especializados, mas adiciona sincronizacao entre escrita e
leitura e pode introduzir consistencia eventual.

## Exemplo em Java

O exemplo `CqrsExample` separa comando de criacao e consulta por identificador.

## Como executar

```bash
../mvnw -pl cqrs test
```

## Padroes relacionados

- [Database per Service](../database-per-service/)
- [Event-Driven Architecture](../event-driven-architecture/)
