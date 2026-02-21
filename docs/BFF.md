# BFF - Backend for Frontend

## O que é BFF?

O **BFF (Backend for Frontend)** é um padrão de arquitetura onde se cria um serviço de backend dedicado para cada tipo de frontend (web, mobile, IoT, etc.). Em vez de um único backend genérico atender todos os clientes, cada frontend possui seu próprio backend intermediário, responsável por adaptar, agregar e formatar os dados de acordo com as necessidades específicas daquele canal.

## Por que usar BFF?

Cada tipo de frontend possui requisitos distintos:

- **Aplicações web** podem exibir muitos dados em uma única tela.
- **Aplicações mobile** precisam de payloads menores para economizar dados e bateria.
- **Dispositivos IoT** podem precisar de protocolos e formatos diferentes.

Um backend único tende a se tornar complexo ao tentar atender todas essas variações. O BFF resolve esse problema isolando a lógica de apresentação de cada canal.

## Como funciona?

```
┌──────────┐      ┌──────────────┐
│  Web App │─────▶│  BFF Web     │──┐
└──────────┘      └──────────────┘  │    ┌──────────────────┐
                                    ├───▶│  Microserviços / │
┌──────────┐      ┌──────────────┐  │    │  APIs internas   │
│ Mobile   │─────▶│  BFF Mobile  │──┘    └──────────────────┘
└──────────┘      └──────────────┘
```

1. O frontend faz requisições ao seu BFF dedicado.
2. O BFF orquestra chamadas aos microserviços ou APIs internas.
3. O BFF agrega, transforma e retorna os dados no formato ideal para aquele frontend.

## Vantagens

| Vantagem | Descrição |
|---|---|
| **Desacoplamento** | Cada frontend evolui independentemente sem impactar os outros. |
| **Performance** | Respostas otimizadas para cada canal (menos dados para mobile, por exemplo). |
| **Simplicidade no frontend** | A lógica de agregação e transformação fica no BFF, simplificando o código do cliente. |
| **Segurança** | Cada BFF pode expor apenas os dados necessários para o seu frontend. |
| **Autonomia das equipes** | Times de frontend podem evoluir seu BFF sem depender de um backend central. |

## Desvantagens

| Desvantagem | Descrição |
|---|---|
| **Duplicação de código** | Lógica semelhante pode ser replicada entre BFFs diferentes. |
| **Mais serviços para manter** | Cada BFF é um serviço adicional em produção. |
| **Complexidade operacional** | Mais deploys, mais monitoramento, mais infraestrutura. |

## Quando usar?

- Quando existem **múltiplos canais** de frontend com necessidades distintas.
- Quando um backend genérico está se tornando **complexo demais** com lógica específica de apresentação.
- Quando **equipes diferentes** cuidam de frontends diferentes e precisam de autonomia.

## Quando NÃO usar?

- Quando há **apenas um frontend** — um API Gateway ou um backend tradicional pode ser suficiente.
- Quando os frontends possuem **requisitos muito semelhantes** e não justificam serviços separados.

## Relação com este projeto

Este projeto implementa uma API REST para transações bancárias simplificadas. Em um cenário de evolução, caso a aplicação precisasse atender um app mobile além da interface web, o padrão BFF poderia ser adotado para criar backends dedicados a cada canal, mantendo os microserviços internos (como o serviço de transações) inalterados.

## Referências

- [Sam Newman - Backends for Frontends](https://samnewman.io/patterns/architectural/bff/)
- [Microsoft - Backends for Frontends pattern](https://learn.microsoft.com/en-us/azure/architecture/patterns/backends-for-frontends)
- [Phil Calçado - The Back-end for Front-end Pattern (BFF)](https://philcalcado.com/2015/09/18/the_back_end_for_front_end_pattern_bff.html)
