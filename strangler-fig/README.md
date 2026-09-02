# Strangler Fig

[Voltar ao catalogo](../README.md)

## Intencao

Migrar funcionalidade legada gradualmente para uma nova arquitetura.

## Problema

Reescrever um sistema inteiro de uma vez aumenta risco, prazo e dificuldade de
validacao.

## Como funciona

Um roteador decide se uma funcionalidade ainda vai para o legado ou ja deve ir
para o novo servico. O novo sistema cresce ate substituir o antigo.

## Quando usar

Use em modernizacoes onde o legado precisa continuar operando durante a
migracao.

## Trade-offs

Reduz risco de migracao, mas exige convivencia entre legado e novo sistema por
um periodo.

## Exemplo em Java

O exemplo `StranglerFigExample` roteia funcionalidades entre legado e novo
servico.

## Como executar

```bash
../mvnw -pl strangler-fig test
```

## Padroes relacionados

- [API Gateway](../api-gateway/)
- [Externalized Configuration](../externalized-configuration/)
