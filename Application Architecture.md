## Rozhano's Software Design
    Rozhano follows a combination of Domain-Driven Design (DDD) 
    With Hexagonal Architecture and Clean Architecture principles.

## Example:
    src/
├── main/
│   ├── java/
│   │   └── wisepup/
│   │       └── service-name/
│   │           └── module-name/
│   │               ├── application/           # Application Layer
│   │               │   ├── ports/
│   │               │   │   ├── input/        # Input Ports (Use Cases)
│   │               │   │   │   └── CustomerService.java
│   │               │   │   └── output/       # Output Ports
│   │               │   │       └── CustomerRepository.java
│   │               │   └── services/         # Use Case Implementations
│   │               │       └── CustomerServiceImpl.java
│   │               │
│   │               ├── domain/               # Domain Layer
│   │               │   ├── aggregates/       # Aggregate Roots
│   │               │   │   └── Customer.java
│   │               │   ├── entities/         # Domain Entities
│   │               │   │   └── Address.java
│   │               │   ├── valueObjects/     # Value Objects
│   │               │   │   └── CustomerId.java
│   │               │   └── events/           # Domain Events
│   │               │       └── CustomerCreatedEvent.java
│   │               │
│   │               └── infrastructure/       # Infrastructure Layer
│   │                   ├── adapters/
│   │                   │   ├── input/        # Input Adapters
│   │                   │   │   ├── rest/     # REST Controllers
│   │                   │   │   │   └── CustomerController.java
│   │                   │   │   └── messaging/# Message Listeners
│   │                   │   └── output/       # Output Adapters
│   │                   │       ├── persistence/
│   │                   │       │   ├── repositories/
│   │                   │       │   │   └── JpaCustomerRepository.java
│   │                   │       │   └── entities/
│   │                   │       │       └── CustomerJpaEntity.java
│   │                   │       └── messaging/
│   │                   │           └── CustomerEventPublisher.java
│   │                   │
│   │                   └── config/           # Configuration Classes
│   │                       └── BeanConfiguration.java
│   │
│   └── resources/
│       └── application.yml
│
└── test/                                     # Test directories mirror main
└── java/
└── com/
└── company/
└── modulename/
├── application/
├── domain/
└── infrastructure/