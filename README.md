# microsservices-patterns

Catalogo pratico dos principais padroes de arquitetura de microsservicos, com
uma pasta por padrao, explicacao objetiva e exemplos em Java documentados com
JavaDoc.

Os exemplos sao intencionalmente pequenos: eles mostram a ideia central do
padrao com componentes parecidos com Spring Boot, sem esconder o conceito atras
de infraestrutura real.

## Como usar

Abra a pasta do padrao que quer estudar. Cada pasta tem um `README.md` com a
intencao, problema, funcionamento, criterios de uso, trade-offs, exemplo em
Java e comando de execucao.

Para validar todos os exemplos:

```bash
./mvnw test
```

Se Maven estiver instalado globalmente, `mvn test` tambem funciona.

## Padroes

| Padrao | Pasta | Resumo |
|---|---|---|
| API Gateway | [api-gateway](api-gateway/) | Centraliza a entrada dos clientes e encaminha chamadas para servicos internos. |
| Service Discovery | [service-discovery](service-discovery/) | Permite localizar dinamicamente instancias de servicos. |
| Circuit Breaker | [circuit-breaker](circuit-breaker/) | Interrompe chamadas para dependencias instaveis antes que a falha se espalhe. |
| Bulkhead | [bulkhead](bulkhead/) | Isola recursos para limitar o impacto de falhas em partes do sistema. |
| Database per Service | [database-per-service](database-per-service/) | Mantem cada servico dono do seu proprio modelo de dados. |
| Saga | [saga](saga/) | Coordena processos de negocio distribuidos por etapas e compensacoes. |
| CQRS | [cqrs](cqrs/) | Separa modelos de escrita e leitura quando eles evoluem em ritmos diferentes. |
| Event-Driven Architecture | [event-driven-architecture](event-driven-architecture/) | Usa eventos para desacoplar servicos e propagar mudancas. |
| Strangler Fig | [strangler-fig](strangler-fig/) | Migra sistemas legados gradualmente para novos servicos. |
| Externalized Configuration | [externalized-configuration](externalized-configuration/) | Move configuracoes para fora do codigo e permite variacao por ambiente. |
| Outbox | [outbox](outbox/) | Persiste eventos junto com a mudanca local para publicacao confiavel. |
| Idempotency | [idempotency](idempotency/) | Evita efeitos duplicados quando comandos sao repetidos. |
| Backends for Frontends | [backends-for-frontends](backends-for-frontends/) | Cria APIs especificas para cada tipo de cliente. |
| Retry with Backoff | [retry-with-backoff](retry-with-backoff/) | Repete falhas transientes com esperas crescentes. |
| Service Mesh | [service-mesh](service-mesh/) | Move politicas de comunicacao para uma camada de plataforma. |
