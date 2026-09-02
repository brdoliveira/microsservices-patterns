# Plano de execução — catalogo-padroes-microsservicos

> gerado por `onp-spec plano` em 2026-09-02 00:20 — NÃO edite à mão;
> mudou tasks.md ou a config? Regenere: `onp-spec plano catalogo-padroes-microsservicos`

## Resumo — o que vai acontecer

- **6 tarefa(s) pendente(s)**: 6 em 6 faixa(s) paralela(s) + 0 sequencial(is)
- **1 faixa = 1 worktree + 1 branch + 1 janela de contexto limpa** — faixas não compartilham nenhum arquivo entre si
- prefere outra seleção ou uma após a outra? Regenere com `onp-spec plano catalogo-padroes-microsservicos --paralelizar T-xxx,T-yyy` ou `--sequencial`
- tudo acontece na branch de trabalho `spec/catalogo-padroes-microsservicos`; levar para a main é decisão sua

## Faixas e ondas

### Onda 1 — faixa-1 ∥ faixa-2 ∥ faixa-3

#### faixa-1 — branch `spec/catalogo-padroes-microsservicos-faixa-1` — worktree `../onp-worktrees/kuala-lumpur-catalogo-padroes-microsservicos-faixa-1`

| tarefa | título | modelo | esforço | arquivos |
|---|---|---|---|---|
| T-001 | Configurar base Java e verificacoes do catalogo | `gpt-5.6-terra` | medium | `pom.xml`, `catalog-validation/src/test/java`, `catalog-validation/pom.xml` |

#### faixa-2 — branch `spec/catalogo-padroes-microsservicos-faixa-2` — worktree `../onp-worktrees/kuala-lumpur-catalogo-padroes-microsservicos-faixa-2`

| tarefa | título | modelo | esforço | arquivos |
|---|---|---|---|---|
| T-002 | Escrever README raiz com indice dos padroes | `gpt-5.6-terra` | medium | `README.md` |

#### faixa-3 — branch `spec/catalogo-padroes-microsservicos-faixa-3` — worktree `../onp-worktrees/kuala-lumpur-catalogo-padroes-microsservicos-faixa-3`

| tarefa | título | modelo | esforço | arquivos |
|---|---|---|---|---|
| T-003 | Documentar e exemplificar padroes de entrada e descoberta | `gpt-5.6-terra` | medium | `api-gateway/README.md`, `api-gateway/pom.xml`, `api-gateway/src/main/java`, `service-discovery/README.md`, `service-discovery/pom.xml`, `service-discovery/src/main/java` |

### Onda 2 — faixa-4 ∥ faixa-5 ∥ faixa-6

#### faixa-4 — branch `spec/catalogo-padroes-microsservicos-faixa-4` — worktree `../onp-worktrees/kuala-lumpur-catalogo-padroes-microsservicos-faixa-4`

| tarefa | título | modelo | esforço | arquivos |
|---|---|---|---|---|
| T-004 | Documentar e exemplificar padroes de resiliencia | `gpt-5.6-terra` | medium | `circuit-breaker/README.md`, `circuit-breaker/pom.xml`, `circuit-breaker/src/main/java`, `bulkhead/README.md`, `bulkhead/pom.xml`, `bulkhead/src/main/java` |

#### faixa-5 — branch `spec/catalogo-padroes-microsservicos-faixa-5` — worktree `../onp-worktrees/kuala-lumpur-catalogo-padroes-microsservicos-faixa-5`

| tarefa | título | modelo | esforço | arquivos |
|---|---|---|---|---|
| T-005 | Documentar e exemplificar padroes de dados e transacao | `gpt-5.6-terra` | medium | `database-per-service/README.md`, `database-per-service/pom.xml`, `database-per-service/src/main/java`, `saga/README.md`, `saga/pom.xml`, `saga/src/main/java`, `cqrs/README.md`, `cqrs/pom.xml`, `cqrs/src/main/java` |

#### faixa-6 — branch `spec/catalogo-padroes-microsservicos-faixa-6` — worktree `../onp-worktrees/kuala-lumpur-catalogo-padroes-microsservicos-faixa-6`

| tarefa | título | modelo | esforço | arquivos |
|---|---|---|---|---|
| T-006 | Documentar e exemplificar padroes de integracao e evolucao | `gpt-5.6-terra` | medium | `event-driven-architecture/README.md`, `event-driven-architecture/pom.xml`, `event-driven-architecture/src/main/java`, `strangler-fig/README.md`, `strangler-fig/pom.xml`, `strangler-fig/src/main/java`, `externalized-configuration/README.md`, `externalized-configuration/pom.xml`, `externalized-configuration/src/main/java` |

## Gestão de branches e commits

1. branch de trabalho `spec/catalogo-padroes-microsservicos` criada do ponto atual (se ainda não existir)
2. cada faixa nasce dela como branch própria e roda no seu worktree — **1 tarefa = 1 commit** (`T-xxx feature: título`)
3. terminou a onda → merge `--no-ff` de cada faixa de volta, na ordem; conflito interrompe a faixa e pede resolução humana
4. faixa mesclada → worktree removido, branch apagada, tarefa marcada `[concluida]` no tasks.md
5. gate final na branch de trabalho: `onp-spec verify catalogo-padroes-microsservicos` + `onp-spec audit --ci` — **exit 0 ou não está pronto**

## Como executar

### ▶ Execução — Codex headless (codex exec)

```bash
bash .spec/features/catalogo-padroes-microsservicos/executar-tarefas.sh
```

Cada faixa roda `codex exec` com **janela de contexto limpa**, no seu worktree, com
`--model` e `model_reasoning_effort` já definidos por tarefa e sandbox `workspace-write`. Os prompts exatos estão
embutidos no script — quer rodar uma faixa na mão, é só copiá-los de lá.
Logs: `../onp-worktrees/kuala-lumpur-catalogo-padroes-microsservicos-logs/`.

**Confirmação de custos — antes de executar**: os modelos e esforços por
tarefa estão nas tabelas acima; o agente CONFIRMA com o usuário se estão
dentro da licença/cota dele (modelo forte + esforço alto torra tokens).
Para gastar menos: `onp-spec plano catalogo-padroes-microsservicos --modelo gpt-5.6-luna --esforco baixo`
(tudo) ou por tarefa `onp-spec tarefa catalogo-padroes-microsservicos T-xxx --modelo <m> --esforco <nível>` — e regenere o plano.

### 📣 Acompanhamento — tabela + resumo no chat (a cada 1 min)

O script roda em **background**: o agente AVISA o usuário antes de iniciar e,
enquanto roda, posta no chat a cada ~1 minuto a **tabela de andamento** (qual
tarefa está rodando, qual não está, o que concluiu/falhou) junto com o
**resumo geral de andamento** (escrito por IA; sem IA, o motor resume). Ao
final, o usuário recebe o resumo completo da execução. A qualquer momento:

```bash
onp-spec resumo catalogo-padroes-microsservicos --tabela   # a tabela de andamento
onp-spec resumo catalogo-padroes-microsservicos            # o resumo em texto
```

