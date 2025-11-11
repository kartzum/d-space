# ar-bz

## microservices & base

### c4
See: https://github.com/plantuml-stdlib/C4-PlantUML/tree/master
* https://github.com/plantuml-stdlib/C4-PlantUML/blob/master/samples/C4_Component%20Diagram%20Sample%20-%20bigbankplc.puml

### UML
* https://pdf.plantuml.net/PlantUML_Language_Reference_Guide_ru.pdf
* https://prog-cpp.ru/uml-classes/

### Resources & notes

#### spring-boot-docker-images
https://www.baeldung.com/spring-boot-docker-images

https://www.baeldung.com/docker-compose-support-spring-boot

https://www.baeldung.com/spring-boot-postgresql-docker

#### Patterns

**Паттерн CQRS**

* https://microservices.io/patterns/data/cqrs.html
* https://pcg.io/insights/a-case-for-cqrs/?redirect=true&origin=kw-en

```
Command Query Responsibility Segregation (CQRS) — это паттерн проектирования, 
который разделяет операцию чтения и записи данных в системе на два отдельных интерфейса.
```

**Паттерн Saga**

* https://microservices.io/patterns/data/saga.html
* https://habr.com/ru/articles/744460/

```
Паттерн Saga позволяет согласованно управлять состоянием системы, 
разделяя большую транзакцию на серию меньших шагов, 
каждый из которых может быть выполнен автономно. 
Каждый шаг транзакции имеет соответствующую компенсирующую операцию, 
которая выполняется в случае неудачи.
```

```
Оркестрация подразумевает наличие отдельного сервиса-оркестратора, 
а хореография — обмен событиями между микросервисами.
```

**API Gateway**

* https://microservices.io/patterns/apigateway.html
* https://learn.microsoft.com/en-us/azure/architecture/microservices/design/gateway

```
API Gateway выполняет функции прокси-сервера, принимая все клиентские запросы 
и маршрутизируя их к соответствующим микросервисам. Позволяет скрыть внутреннюю 
структуру микросервисов от клиентов, предоставляет единый интерфейс 
для взаимодействия с системой. API Gateway также может выполнять множество дополнительных задач, 
таких как трансформация запросов и ответов, кеширование, мониторинг, логирование, 
управление сессиями, аутентификация и авторизация.
```

**API Gateway — Kong**

* https://konghq.com/
* https://lightboxapi.ru/blog/api-gateway-architecture-guide
* https://developer.konghq.com/gateway/get-started/
* https://allopensourcetech.com/quick-start-kong-gateway-opensource/


```
Kong — это популярный API Gateway с открытым исходным кодом, который поддерживает 
множество плагинов для управления трафиком, аутентификации, авторизации и мониторинга.
Компании используют этот паттерн для надёжного 
и безопасного взаимодействия между микросервисами.  
```

#### Спецификации

**OpenAPI**

```
OpenAPI — это спецификация для описания RESTful API, которая позволяет разработчикам документировать
эндпоинты, методы, параметры и ответы API. 
OpenAPI широко используется для описания синхронных взаимодействий между сервисами. 
```

**AsyncAPI**

```
AsyncAPI — это спецификация для документирования и проектирования асинхронных API. 
Подобно OpenAPI для синхронных API, AsyncAPI позволяет описывать структуры сообщений, 
каналы и взаимодействия между компонентами в асинхронной системе.
```
