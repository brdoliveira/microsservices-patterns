# Spec: Expansao de padroes com exemplos Spring Boot

> feature: expansao-padroes-spring-boot
> status: auditada

<!--
  Como ler este arquivo (o formato é verificado por `onp-spec audit`):
  - US-xxx = história de usuário · AC-xxx = critério de aceite
    ASM-xxx = suposição · Q-xxx = pergunta em aberto
    São códigos de rastreio: ligam a especificação às tarefas e aos testes.
  - Toda história de usuário precisa de pelo menos um critério de aceite.
  - Todo critério de aceite precisa de Dado/Quando/Então completos.
  - Os códigos são únicos no projeto inteiro (nunca reutilize um número).
  - Suposições e Perguntas em aberto são OBRIGATÓRIAS: se não há nenhuma,
    escreva "Nenhuma." — mas desconfie: quase toda feature esconde uma.
-->

## Contexto

O catalogo inicial cobre 10 padroes com exemplos Java pequenos. Esta expansao
adiciona cinco padroes práticos comuns em microsservicos e aprofunda os
exemplos para ficarem mais proximos de projetos reais em Spring Boot, mantendo
o repositorio didatico, compilavel e auditavel.

## Histórias

<!-- História de usuário: quem precisa, o que precisa e por quê. -->

### US-005 — Expandir o catalogo com novos padroes

Como pessoa desenvolvedora, quero encontrar tambem Outbox, Idempotency,
Backends for Frontends, Retry with Backoff e Service Mesh no catalogo, para que
eu estude padroes usados em sistemas distribuidos reais.

<!-- Critério de aceite: o resultado observável que um teste consegue checar.
     Escreva para GENTE: título e Então descrevem o que o usuário vê
     ("a tela avisa X"), não o detalhe técnico ("endpoint retorna 403") —
     o detalhe pode ir entre parênteses. -->

#### AC-010 — README raiz lista os cinco novos padroes

- **Dado** o repositorio aberto na raiz
- **Quando** a pessoa le o arquivo `README.md`
- **Então** encontra links para `outbox`, `idempotency`, `backends-for-frontends`, `retry-with-backoff` e `service-mesh`

#### AC-011 — Cada novo padrao tem pasta, README e exemplo Spring Boot

- **Dado** qualquer um dos cinco novos padroes
- **Quando** a pessoa abre a pasta do padrao
- **Então** encontra `README.md`, `pom.xml`, codigo Java em `src/main/java` e ao menos um componente com anotacao Spring Boot ou Spring Framework

### US-006 — Aproximar exemplos existentes de Spring Boot

Como pessoa desenvolvedora Java, quero que os exemplos existentes mostrem
contornos parecidos com servicos Spring Boot, para que o codigo fique mais
proximo de um projeto profissional sem perder a simplicidade didatica.

#### AC-012 — Padroes existentes possuem componentes Spring Boot

- **Dado** os dez padroes ja existentes no catalogo
- **Quando** a pessoa inspeciona os arquivos Java de cada pasta
- **Então** encontra ao menos um componente com anotacao Spring Boot ou Spring Framework em cada padrao

### US-007 — Validar comportamento dos exemplos

Como mantenedor, quero testes unitarios para os exemplos de todos os padroes,
para que mudancas futuras nao quebrem o comportamento demonstrado.

#### AC-013 — Todos os padroes possuem testes comportamentais

- **Dado** as pastas de todos os padroes documentados
- **Quando** a suite de testes e executada
- **Então** cada padrao tem pelo menos um teste unitario que exercita o comportamento principal do exemplo Java

### US-008 — Manter auditoria ONP granular

Como mantenedor, quero que a auditoria ONP continue lendo provas por criterio,
para que a expansao nao volte a depender apenas do exit code global.

#### AC-014 — Verificacao ONP emite TAP para a expansao

- **Dado** o script de verificacao ONP do repositorio
- **Quando** ele e executado
- **Então** a saida TAP contem testes anotados para AC-010, AC-011, AC-012, AC-013 e AC-014

## Fora de escopo

- Criar aplicacoes Spring Boot executaveis completas por padrao.
- Substituir os exemplos didaticos por infraestrutura real de banco, broker, gateway ou service mesh.
- Adicionar Quarkus nesta etapa.

## Suposições

<!-- O que estamos ASSUMINDO sem confirmação. Status: aberta | confirmada | invalidada -->

| ID | Suposição | Status | Resolução |
|---|---|---|---|
| ASM-003 | Spring Boot sera usado como referencia de profundidade por ser comum no ecossistema Java de microsservicos. | confirmada | Usuario pediu exemplos mais proximos de Spring Boot ou Quarkus; escolhemos Spring Boot. |
| ASM-004 | A versao Spring Boot 4.1.1 sera usada porque a documentacao oficial indica Java 17+ e compatibilidade com Java 26. | confirmada | Confirmado em documentacao oficial da Spring em 2026-09-02. |

## Perguntas em aberto

<!-- O que ainda não sabemos. Status: aberta | respondida -->

| ID | Pergunta | Status | Resposta |
|---|---|---|---|
| Q-003 | Devemos implementar aplicacoes web completas com servidor por padrao? | respondida | Nao nesta etapa; os exemplos continuam didaticos, com componentes Spring Boot compilaveis e testaveis. |
