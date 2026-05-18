PROYECTO STREAMING - UNIDAD 9

Sistema de gestión de contenidos de streaming desarrollado en Java con ObjectDB y JPA, como proyecto evaluable de la Unidad 9 del módulo de Programación (1º DAM).

## Descripción del proyecto

Es una aplicación de consola que simula la gestión interna de una plataforma de streaming. 
Permite administrar usuarios, perfiles, suscripciones, contenido multimedia (películas y series), episodios, reproducciones, valoraciones y categorías.
La persistencia de datos se implementa mediante ObjectDB (Base de datos orientada a objetos) combinada con JPA (Java Persistence API), lo que permite almacenar y recuperar objetos Java directamente sin necesidad de escribir sentencias SQL.

## Requisitos previos

Para ejecutar este proyecto, asegúrate de tener instalado el siguiente software:
    - Java JDK: Versión 17 o superior.
    - Gestor de Dependencias: Apache Maven 3.8 o superior.
    - IDE Recomendado: IntelliJ IDEA (configurado con el JDK correcto, se recomienda JDK 25).

Las tecnologías que hemos aplicado a lo largo del proyecto:
    - ObjectDB(2.9.5): Base de datos orientada a objetos.
    - JPA (javax.persistence 2.2): API estándar de persistencia.


## Configuración de la base de datos

1. Configurar ObjectDB en el proyecto.
    La librería ObjectDB ("objectdb-2.9.5.jar") se encuentra dentro de la carpeta "/objectdb-2.9.5/objectdb-2.9.5/bin/" y está declarada como dependencia en el "pom.xml". Maven la descarga automáticamente desde el repositorio oficial de ObjectDB al compilar por primera vez.

    La dependencia y el repositorio y personalizado ya está configurado en el "pom.xml":

    <dependencies>
        <dependency>
            <groupId>com.objectdb</groupId>
            <artifactId>objectdb</artifactId>
            <version>2.9.5</version>
        </dependency>
    </dependencies>

    <repositories>
        <repository>
            <id>objectdb</id>
            <name>ObjectDB Repository</name>
            <url>https://m2.objectdb.com</url>
        </repository>
    </repositories>

2. Indicar la ruta del fichero de base de datos.
    ObjectDB genera automáticamente el fichero '.odb? la primera vez que se ejecuta la aplicación. No existe en el repositorio porque se crea en tiempo de ejecución.
    La ruta donde se creará el fichero está definida en "src/main/resources/META-INF/persistence.xml", en la propiedad 'javax.persistence.jdbc.url'. 
    En este proyecto la ruta configurada es "PE9_STREAMING/db/streaming_plataforma.odb". Es decir, el fichero se genera en la raíz del proyecto.
    Si necesitas cambiar esa ubicación (por ejemplo, apuntar a una ruta absoluta ), edita esa línea en el archivo 'persistence.xml':
        <property name="javax.persistence.jdbc.url" value="db/streaming_plataforma.odb"/>

3. Cargar los datos iniciales de prueba (si los hay).
    Al arrancar la aplicación por primera vez, la base de datos se crea vacía automáticamente (ObjectDB genera el fichero '.odb' si no existe). Si el proyecto incluye un método de carga de datos de prueba, se ejecuta desde "Main.java" al iniciar. 

4. Configurar el archivo persistence.xml.
    El archivo de configuración de JPA se encuentra en:
        src/main/resources/META-INF/persistence.xml

    Contenido de referencia:
        <?xml version="1.0" encoding="UTF-8"?>
        <persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
                    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                    xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
                    http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd"
                    version="2.1">

            <persistence-unit name="PE9streaming">
                <provider>com.objectdb.jpa.Provider</provider>

                <class>model.Categoria</class>
                <class>model.Contenido</class>
                <class>model.Episodio</class>
                <class>model.Pelicula</class>
                <class>model.Perfil</class>
                <class>model.Reproduccion</class>
                <class>model.Serie</class>
                <class>model.Subscripcion</class>
                <class>model.Usuario</class>
                <class>model.Valoracion</class>

                <properties>
                    <property name="javax.persistence.jdbc.url" value="db/streaming_plataforma.odb"/>
                    <property name="javax.persistence.jdbc.user" value="admin"/>
                    <property name="javax.persistence.jdbc.password" value="admin"/>
                </properties>
            </persistence-unit>
        </persistence>

## Clonar el repositorio

Para obtener una copia local del proyecto, ejecuta los siguientes comandos en tu terminal:

git clone https://github.com/fatimajdmp-hub/PE9_streaming.git
cd PE9_streaming

## Compilación y ejecución

Pasos para compilar el proyecto y ejecutarlo desde línea de comandos o IDE.

    - Desde línea de comandos (Maven)
        1. Situarse en la raíz del proyecto
            cd PE9_STREAMING

        2. Compilar el proyecto y descargar dependencias
            mvn clean compile

        3. Ejecutar la aplicación
            mvn exec:java -Dexec.mainClass="Main"

    - Desde IntelliJ IDEA
        1. Abre el proyecto desde IntelliJ IDEA.
        2. IntelliJ detectará el 'pom.xml' automáticamente y descargará las dependencias.
        3. Si el proyecto no reconoce el JDK, ve a File > Project Structure > Project y selecciona el JDK 17 instalado.
        4. Localiza la clase 'Main.java' en "src/main/java/".
        5. Haz clic sobre 'Run Main'.

## Estructura del proyecto

El proyecto sigue el estándar de Maven para la organización de archivos:

PE9_STREAMING/ 
│   .gitignore                                                  # Archivos excluidos del control de versiones 
│   pom.xml                                                     # Configuración Maven: dependencias y plugins 
│   README.md                                                   # Documentación general del proyecto 
│
├───.idea                                                       # Configuración del entorno IntelliJ IDEA 
│   .gitignore                                                  # Exclusiones de IntelliJ para Git 
│   encodings.xml                                               # Codificación de caracteres del proyecto 
│   misc.xml                                                    # Versión del JDK y configuración técnica 
│   vcs.xml
│
├───objectdb-2.9.5                                              # Librería ObjectDB incluida en el proyecto 
│   ├───.idea                                                   # Config IntelliJ del módulo ObjectDB
│   │   │   .gitignore
│   │   │   misc.xml
│   │   │   modules.xml
│   │   │
│   │   └───libraries                                           # Distribución de ObjectDB 
│   │           bin.xml
│   │           doc.xml
│   │           jakarta.xml
│   │           src.xml
│   │
│   └───objectdb-2.9.5                                          # Distribución de ObjectDB 
│       │   objectdb.conf
│       │   readme.html
│       │
│       ├───bin                                                 # Ejecutables y JARs de ObjectDB 
│       │   │   enhancer.bat
│       │   │   enhancer.sh
│       │   │   explorer-2.9.5.exe
│       │   │   explorer-2.9.5.jar
│       │   │   explorer.sh
│       │   │   javax.persistence-api-2.2.jar
│       │   │   javax.transaction-api-1.3.jar
│       │   │   objectdb-2.9.5.jar
│       │   │   server-2.9.5.exe
│       │   │   server.sh
│       │   │
│       │   └───jakarta                                         # Variantes Jakarta de los ejecutables
│       │           enhancer-jk.bat
│       │           enhancer-jk.sh
│       │           explorer-jk-2.9.5.exe
│       │           explorer-jk-2.9.5.jar
│       │           explorer-jk.sh
│       │           jakarta.persistence-api-3.2.0.jar
│       │           objectdb-jk-2.9.5.jar
│       │           server-jk-2.9.5.exe
│       │           server-jk.sh
│       │
│       ├───db                                                  # Bases de datos de ejemplo ObjectDB 
│       │       clinica.odb
│       │       point.odb
│       │       world.odb
│       │
│       ├───doc                                                 # Documentación Javadoc de JPA 
│       │       jakarta.persistence-api-3.2.0-javadoc.jar
│       │       javax.persistence-api-2.2-javadoc.jar
│       │       ObjectDB 2.9.pdf
│       │
│       ├───license                                             # Textos de licencias de las APIs 
│       │       jdo-apache-license-2.0.txt
│       │       jpa-2-eclipse-public-license-1.0.html
│       │       jpa-3-eclipse-public-license-2.0.html
│       │       jpa-eclipse-distribution-license-1.0.html
│       │       objectdb-license-2.0.4.html
│       │
│       └───src                                                 # Código fuente de las APIs JPA 
│           │   jakarta.persistence-api-3.2.0-sources.jar
│           │   javax.persistence-api-2.2-sources.jar
│           │
│           └───jakarta.persistence-api-3.1.0-sources           # Fuentes de JPA 3.1 
│               │   module-info.java
│               │
│               ├───jakarta                                     # Paquete raíz Jakarta
│               │   └───persistence                             # Anotaciones e interfaces JPA 3.1 
│               │       │   Access.java
│               │       │   AccessType.java
│               │       │   AssociationOverride.java
│               │       │   AssociationOverrides.java
│               │       │   AttributeConverter.java
│               │       │   AttributeNode.java
│               │       │   AttributeOverride.java
│               │       │   AttributeOverrides.java
│               │       │   Basic.java
│               │       │   Cache.java
│               │       │   Cacheable.java
│               │       │   CacheRetrieveMode.java
│               │       │   CacheStoreMode.java
│               │       │   CascadeType.java
│               │       │   CollectionTable.java
│               │       │   Column.java
│               │       │   ColumnResult.java
│               │       │   ConstraintMode.java
│               │       │   ConstructorResult.java
│               │       │   Convert.java
│               │       │   Converter.java
│               │       │   Converts.java
│               │       │   DiscriminatorColumn.java
│               │       │   DiscriminatorType.java
│               │       │   DiscriminatorValue.java
│               │       │   ElementCollection.java
│               │       │   Embeddable.java
│               │       │   Embedded.java
│               │       │   EmbeddedId.java
│               │       │   Entity.java
│               │       │   EntityExistsException.java
│               │       │   EntityGraph.java
│               │       │   EntityListeners.java
│               │       │   EntityManager.java
│               │       │   EntityManagerFactory.java
│               │       │   EntityNotFoundException.java
│               │       │   EntityResult.java
│               │       │   EntityTransaction.java
│               │       │   Enumerated.java
│               │       │   EnumType.java
│               │       │   ExcludeDefaultListeners.java
│               │       │   ExcludeSuperclassListeners.java
│               │       │   FetchType.java
│               │       │   FieldResult.java
│               │       │   FlushModeType.java
│               │       │   ForeignKey.java
│               │       │   GeneratedValue.java
│               │       │   GenerationType.java
│               │       │   Id.java
│               │       │   IdClass.java
│               │       │   Index.java
│               │       │   Inheritance.java
│               │       │   InheritanceType.java
│               │       │   JoinColumn.java
│               │       │   JoinColumns.java
│               │       │   JoinTable.java
│               │       │   Lob.java
│               │       │   LockModeType.java
│               │       │   LockTimeoutException.java
│               │       │   ManyToMany.java
│               │       │   ManyToOne.java
│               │       │   MapKey.java
│               │       │   MapKeyClass.java
│               │       │   MapKeyColumn.java
│               │       │   MapKeyEnumerated.java
│               │       │   MapKeyJoinColumn.java
│               │       │   MapKeyJoinColumns.java
│               │       │   MapKeyTemporal.java
│               │       │   MappedSuperclass.java
│               │       │   MapsId.java
│               │       │   NamedAttributeNode.java
│               │       │   NamedEntityGraph.java
│               │       │   NamedEntityGraphs.java
│               │       │   NamedNativeQueries.java
│               │       │   NamedNativeQuery.java
│               │       │   NamedQueries.java
│               │       │   NamedQuery.java
│               │       │   NamedStoredProcedureQueries.java
│               │       │   NamedStoredProcedureQuery.java
│               │       │   NamedSubgraph.java
│               │       │   NonUniqueResultException.java
│               │       │   NoResultException.java
│               │       │   OneToMany.java
│               │       │   OneToOne.java
│               │       │   OptimisticLockException.java
│               │       │   OrderBy.java
│               │       │   OrderColumn.java
│               │       │   orm_2_2.xsd
│               │       │   orm_3_0.xsd
│               │       │   orm_3_1.xsd
│               │       │   package-info.java
│               │       │   Parameter.java
│               │       │   ParameterMode.java
│               │       │   Persistence.java
│               │       │   PersistenceContext.java
│               │       │   PersistenceContexts.java
│               │       │   PersistenceContextType.java
│               │       │   PersistenceException.java
│               │       │   PersistenceProperty.java
│               │       │   PersistenceUnit.java
│               │       │   PersistenceUnits.java
│               │       │   PersistenceUnitUtil.java
│               │       │   PersistenceUtil.java
│               │       │   persistence_2_2.xsd
│               │       │   persistence_3_0.xsd
│               │       │   PessimisticLockException.java
│               │       │   PessimisticLockScope.java
│               │       │   PostLoad.java
│               │       │   PostPersist.java
│               │       │   PostRemove.java
│               │       │   PostUpdate.java
│               │       │   PrePersist.java
│               │       │   PreRemove.java
│               │       │   PreUpdate.java
│               │       │   PrimaryKeyJoinColumn.java
│               │       │   PrimaryKeyJoinColumns.java
│               │       │   Query.java
│               │       │   QueryHint.java
│               │       │   QueryTimeoutException.java
│               │       │   RollbackException.java
│               │       │   SecondaryTable.java
│               │       │   SecondaryTables.java
│               │       │   SequenceGenerator.java
│               │       │   SequenceGenerators.java
│               │       │   SharedCacheMode.java
│               │       │   SqlResultSetMapping.java
│               │       │   SqlResultSetMappings.java
│               │       │   StoredProcedureParameter.java
│               │       │   StoredProcedureQuery.java
│               │       │   Subgraph.java
│               │       │   SynchronizationType.java
│               │       │   Table.java
│               │       │   TableGenerator.java
│               │       │   TableGenerators.java
│               │       │   Temporal.java
│               │       │   TemporalType.java
│               │       │   TransactionRequiredException.java
│               │       │   Transient.java
│               │       │   Tuple.java
│               │       │   TupleElement.java
│               │       │   TypedQuery.java
│               │       │   UniqueConstraint.java
│               │       │   ValidationMode.java
│               │       │   Version.java
│               │       │
│               │       ├───criteria                           # API de consultas tipadas 
│               │       │       AbstractQuery.java
│               │       │       CollectionJoin.java
│               │       │       CommonAbstractCriteria.java
│               │       │       CompoundSelection.java
│               │       │       CriteriaBuilder.java
│               │       │       CriteriaDelete.java
│               │       │       CriteriaQuery.java
│               │       │       CriteriaUpdate.java
│               │       │       Expression.java
│               │       │       Fetch.java
│               │       │       FetchParent.java
│               │       │       From.java
│               │       │       Join.java
│               │       │       JoinType.java
│               │       │       ListJoin.java
│               │       │       MapJoin.java
│               │       │       Order.java
│               │       │       package-info.java
│               │       │       ParameterExpression.java
│               │       │       Path.java
│               │       │       PluralJoin.java
│               │       │       Predicate.java
│               │       │       Root.java
│               │       │       Selection.java
│               │       │       SetJoin.java
│               │       │       Subquery.java
│               │       │
│               │       ├───metamodel                          # Metamodelo estático de entidades JPA
│               │       │       Attribute.java
│               │       │       BasicType.java
│               │       │       Bindable.java
│               │       │       CollectionAttribute.java
│               │       │       EmbeddableType.java
│               │       │       EntityType.java
│               │       │       IdentifiableType.java
│               │       │       ListAttribute.java
│               │       │       ManagedType.java
│               │       │       MapAttribute.java
│               │       │       MappedSuperclassType.java
│               │       │       Metamodel.java
│               │       │       package-info.java
│               │       │       PluralAttribute.java
│               │       │       SetAttribute.java
│               │       │       SingularAttribute.java
│               │       │       StaticMetamodel.java
│               │       │       Type.java
│               │       │
│               │       └───spi                                 # Interfaces de proveedor JPA
│               │               ClassTransformer.java
│               │               LoadState.java
│               │               package-info.java
│               │               PersistenceProvider.java
│               │               PersistenceProviderResolver.java
│               │               PersistenceProviderResolverHolder.java
│               │               PersistenceUnitInfo.java
│               │               PersistenceUnitTransactionType.java
│               │               ProviderUtil.java
│               │               TransformerException.java
│               │
│               └───META-INF                                    # Metadatos del JAR                                                        
│                   │   LICENSE.md                              # Licencia del proyecto Jakarta 
│                   │   MANIFEST.MF                             # Manifiesto del JAR 
│                   │   NOTICE.md                               # Avisos legales o noticias
│                   │
│          	        └───maven                                   # Metadatos Maven
│                       └───jakarta.persistence
│                           └───jakarta.persistence-api
│                                   pom.properties
│                               	pom.xml
│
└───src                                                         # Código fuente principal del proyecto streaming 
    └───main                                                    # Fuentes y recursos principales
        ├───java                                                # Clases Java del proyecto 
        │   │   Main.java                                       # Entrada de la aplicación 
        │   │
        │   ├───Interfaz                                        # Presentación de interacción por consola con el usuario 
        │   │       ContenidoInterfaz.java                   
        │   │       UsuarioInterfaz.java
        │   │       Utils.java                                  # Funciones auxiliares para la lectura de datos y formato en consola 
        │   │       ValoracionInterfaz.java
        │   │
        │   ├───model                                           # Modelo de entidades persistentes anotadas con JPA
        │   │       Categoria.java                                                   
        │   │       Contenido.java                              # Clase madre abstracta de la jerarquía de contenidos 
        │   │       Episodio.java                                              
        │   │       Pelicula.java                               # Entidad especializada que hereda de Contenido            
        │   │       Perfil.java
        │   │       Reproduccion.java
        │   │       Serie.java                                  # Entidad especializada que hereda de Contenido            
        │   │       Subscripcion.java
        │   │       Usuario.java                                # Clase que gestiona perfiles y suscripciones 
        │   │       Valoracion.java
        │   │
        │   ├───repository                                      # Acceso a datos con ObjectDB/JPA 
        │   │       StreamingRepository.java                    # Operaciones CRUD sobre las entidades 
        │   │
        │   ├───service                                         # Lógica de negocio de la aplicación 
        │   │       StreamingService.java                       # Servicios: búsqueda y gestión de contenido 
        │   │
        │   └───util                                            # Utilidades y configuración JPA     
        │                 JPAUtil.java                          # Gestión del EntityManagerFactory 
        │
        └───resources                                           # Recursos de configuración 
            └───META-INF                                        # Metadatos de la aplicación 
                      persistence.xml                           # Unidad de persistencia JPA (ObjectDB) 

## Equipo

El proyecto ha sido desarrollado siguiendo una estrategia de colaboración por roles:
   Integrantes                  Rol                                       Tareas Principales
Fátima Vázquez            Jefe de Proyecto                  Coordinación, gestión de plazos y supervisión.
Diego Manuel Carrasco     Diseñador de BD                   Modelo E-R, modelo lógico y restricciones de integridad.
Juan Francisco Garrido    Calidad y Doc.                    Memoria, diagramas UML y mantenimiento del repositorio.
Hugo Rodríguez            Desarrollador Interfaz            Implementación de menús y lógica de interacción (Scanner).
Alejandro Andrade         Diseñador Backend                 Lógica de negocio, entidades y capa de acceso a datos (DAO).