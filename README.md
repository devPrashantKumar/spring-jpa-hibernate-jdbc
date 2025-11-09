# spring-jpa-hibernate-jdbc

### JPA-Learning
- JPADemo01 - Simple project with JPA repository and H2 database, h2 database persistance in file 
- JPADemo02 - Spring JPA OneToOne Mapping Unidirectional Mapping
  - serialization error in case of lazy initialisation
  - N+1 query issue in case on Lazy Initialisation
- JPADemo03 - Spring JPA OneToOne Mapping Bidirectional Mapping
    - Jackson recursion issue. 
      - JsonManagedReference and JsonBackReference
      - JsonIdentityReference
- JPADemo04 - Spring JPA OneToMany Mapping Unidirectional Mapping
    - explicit table for relationship , or relationship maintain in child table
    - HibernateProxy object and PersistanceBag object 
    - orphan removal
- JPADemo05 - Spring JPA OneToMany Mapping Unidirectional Mapping
    - owingEntity and inverseOwingEntity
    - child removal issue in case of orphanRemoval=false
- JPADemo06 - Spring JPA ManyToOne Mapping Unidirectional Mapping