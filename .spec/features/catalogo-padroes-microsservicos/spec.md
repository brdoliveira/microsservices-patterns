# Spec: Catalogo de padroes de microsservicos

> feature: catalogo-padroes-microsservicos
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

O repositorio `microsservices-patterns` sera um catalogo pratico dos principais
padroes de arquitetura de microsservicos. Pessoas desenvolvedoras devem
conseguir abrir o README raiz, entender rapidamente quais padroes existem,
entrar na pasta de um padrao especifico e encontrar uma explicacao objetiva com
exemplo em Java documentado com JavaDoc.

## Histórias

<!-- História de usuário: quem precisa, o que precisa e por quê. -->

### US-001 — Navegar pelo catalogo a partir da raiz

Como pessoa desenvolvedora, quero ver um indice dos padroes no README raiz,
para que eu encontre rapidamente o padrao que quero estudar.

<!-- Critério de aceite: o resultado observável que um teste consegue checar.
     Escreva para GENTE: título e Então descrevem o que o usuário vê
     ("a tela avisa X"), não o detalhe técnico ("endpoint retorna 403") —
     o detalhe pode ir entre parênteses. -->

#### AC-001 — README raiz apresenta os padroes disponiveis

- **Dado** o repositorio aberto na raiz
- **Quando** a pessoa le o arquivo `README.md`
- **Então** encontra uma explicacao curta do repositorio e uma lista ou tabela com todos os padroes documentados

#### AC-002 — README raiz redireciona para cada pasta de padrao

- **Dado** a lista de padroes no arquivo `README.md`
- **Quando** a pessoa acessa o link de qualquer padrao listado
- **Então** o link aponta para uma pasta existente do repositorio que contem o README daquele padrao

### US-002 — Estudar um padrao especifico

Como pessoa desenvolvedora, quero que cada padrao tenha uma pasta propria com
README padronizado, para que eu entenda o problema, a solucao e os trade-offs
sem precisar procurar em outros lugares.

#### AC-003 — Cada pasta de padrao tem README explicativo

- **Dado** uma pasta de padrao existente no repositorio
- **Quando** a pessoa abre o `README.md` dessa pasta
- **Então** encontra as secoes "Intencao", "Problema", "Como funciona", "Quando usar", "Trade-offs", "Exemplo em Java" e "Como executar"

#### AC-004 — README de padrao conecta o conteudo ao restante do catalogo

- **Dado** uma pasta de padrao existente no repositorio
- **Quando** a pessoa abre o `README.md` dessa pasta
- **Então** encontra um link de volta para o README raiz e, quando aplicavel, links para padroes relacionados

### US-003 — Consultar exemplos em Java

Como pessoa desenvolvedora Java, quero exemplos pequenos e documentados em Java
para cada padrao, para que eu consiga relacionar a explicacao conceitual com
codigo executavel.

#### AC-005 — Cada padrao possui codigo Java no proprio diretorio

- **Dado** uma pasta de padrao existente no repositorio
- **Quando** a pessoa inspeciona a estrutura dessa pasta
- **Então** encontra codigo Java em `src/main/java` demonstrando o padrao descrito no README

#### AC-006 — Codigo publico possui JavaDoc

- **Dado** os arquivos `.java` dos exemplos de padroes
- **Quando** a documentacao JavaDoc e gerada
- **Então** todas as classes, interfaces, enums e metodos publicos dos exemplos possuem JavaDoc valido

#### AC-007 — O repositorio usa Java para os exemplos de implementacao

- **Dado** as pastas dos padroes documentados
- **Quando** a pessoa procura codigo de implementacao dos exemplos
- **Então** encontra implementacoes em Java, sem exemplos equivalentes escritos em outra linguagem de programacao

### US-004 — Validar o catalogo automaticamente

Como mantenedor do repositorio, quero verificacoes automatizadas para estrutura,
links, exemplos Java e JavaDoc, para que o catalogo continue consistente quando
novos padroes forem adicionados.

#### AC-008 — Build e testes validam exemplos Java

- **Dado** o repositorio clonado em uma maquina com Java e Maven instalados
- **Quando** o mantenedor executa `mvn test`
- **Então** todos os modulos dos padroes compilam e os testes dos exemplos passam

#### AC-009 — Verificacao automatica protege a estrutura de documentacao

- **Dado** o repositorio com pastas de padroes e READMEs
- **Quando** a suite de testes e executada
- **Então** ela falha se um padrao listado no README raiz nao tiver pasta, README, secoes obrigatorias, codigo Java ou JavaDoc publico

## Fora de escopo

- Criar servicos completos prontos para producao.
- Publicar artefatos em registries Maven.
- Configurar infraestrutura real de Kubernetes, service mesh, mensageria ou API gateway.
- Cobrir todos os padroes existentes de microsservicos; o primeiro recorte cobre os principais padroes definidos nesta spec.

## Suposições

<!-- O que estamos ASSUMINDO sem confirmação. Status: aberta | confirmada | invalidada -->

| ID | Suposição | Status | Resolução |
|---|---|---|---|
| ASM-001 | O catalogo inicial deve cobrir estes padroes: API Gateway, Service Discovery, Circuit Breaker, Saga, Event-Driven Architecture, CQRS, Database per Service, Strangler Fig, Bulkhead e Externalized Configuration. | confirmada | Usuario confirmou a lista inicial em 2026-09-01. |
| ASM-002 | A estrutura tecnica sera um projeto Maven multi-module, com uma pasta por padrao e codigo em `src/main/java` dentro de cada pasta. | confirmada | Usuario autorizou prosseguir com o plano em 2026-09-01. |

## Perguntas em aberto

<!-- O que ainda não sabemos. Status: aberta | respondida -->

| ID | Pergunta | Status | Resposta |
|---|---|---|---|
| Q-001 | A lista inicial de padroes em ASM-001 esta correta ou voce quer adicionar/remover algum padrao? | respondida | Correta para o primeiro recorte. |
| Q-002 | Voce prefere Maven multi-module, Gradle multi-project ou exemplos Java independentes por pasta? | respondida | Maven multi-module, com wrapper local porque `mvn` nao esta instalado neste ambiente. |
