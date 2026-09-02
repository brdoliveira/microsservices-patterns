# Idempotency

[Voltar ao catalogo](../README.md)

## Intencao

Garantir que repetir a mesma operacao produza o mesmo resultado sem duplicar
efeitos colaterais.

## Problema

Clientes, filas e retries podem enviar o mesmo comando mais de uma vez. Sem uma
chave idempotente, o sistema pode cobrar, criar ou publicar algo duplicado.

## Como funciona

O servico associa uma chave idempotente ao resultado do primeiro processamento.
Chamadas repetidas com a mesma chave recebem o resultado armazenado.

## Quando usar

Use em comandos de criacao, pagamento, publicacao e qualquer operacao exposta a
retries ou entrega pelo menos uma vez.

## Trade-offs

Evita duplicidade, mas exige armazenamento de chaves, expiracao e definicao
clara do escopo da operacao.

## Exemplo em Java

O exemplo `IdempotencyExample` e um `@Service` Spring que executa um comando
apenas na primeira vez que uma chave aparece.

## Como executar

```bash
../mvnw -pl idempotency test
```

## Padroes relacionados

- [Retry with Backoff](../retry-with-backoff/)
- [Outbox](../outbox/)
