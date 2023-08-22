[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)
[![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](https://opensource.org/licenses/)
[![AGPL License](https://img.shields.io/badge/license-AGPL-blue.svg)](http://www.gnu.org/licenses/agpl-3.0)

# java.h2db.mvn
Benvenuti in questo repository GitHub 🚀 che mostra un pregetto ![MVNrepo](https://mvnrepository.com/assets/images/7080b8b0f6f48e6fbaffd5f9d85fcc7f-favicon.ico) [Maven!](https://maven.apache.org) che sfrutta l'efficacia di ![H2DB](https://www.h2database.com/favicon.ico) [H2DB](https://www.h2database.com/html/main.html), un R-DBMS scritto in Java.
[H2 Database](https://it.wikipedia.org/wiki/H2_(DBMS)) si presenta come un'alternativa ai R-DBMS tradizionali come ![MySQL-logo](https://labs.mysql.com/common/themes/sakila/favicon.ico) [MySQL](https://www.mysql.com/) come sistema per lo storeging di Dati.

## Caratteristiche fondamentali

Una delle sue caratteristiche distintive è la dimensione ridotta, poiché archivia l'intero database in un unico file con estensione ```.db```, simile al funzionamento di [SQLite](https://www.sqlite.org/index.html).
Questa caratteristica non solo garantisce robustezza, ma anche la resilienza dell'intero sistema in caso di corruzione.

H2DB, analogamente a SQLite, si distingue per la sua versatilità e velocità.
Questa agilità lo rende ideale per prototipare progetti.
Una caratteristica unica è la capacità di mantenere l'intero database in memoria, ottimizzando le prestazioni a scapito della persistenza. Al riavvio del progetto, i dati vengono ripristinati.

Essendo implementato in Java, H2DB è perfettamente integrato con il linguaggio, consentendo un approccio JDBC.
Altri linguaggi possono sfruttare questo DBMS a patto di avere una JVM installata e il relativo connettore (sotto forma di file JAR).

Nonostante la sua semplicità, H2DB offre un'interfaccia web integrata e una shell testuale estremamente versatile. L'interfaccia web è flessibile ma non supporta la creazione del file di database stesso. A tale scopo, si ricorre all'interfaccia da riga di comando che offre la possibilità di impostare caratteristiche avanzate.

## WUI 

Per avviare l'interfaccia web, utilizzare il seguente comando:

```bash
java -jar h2.*.jar
```

La GUI web sarà accessibile all'indirizzo [http://localhost:8082](http://localhost:8082).
È possibile, inoltre, personalizzare le porte utilizzate con le opzioni seguenti:

```bash
java -jar h2.*.jar -webPort 5000 [-tcpPort 5001] [-pgPort 5002]
```

che avvia l'interfaccia web sulla porta 5000 ed eventuamente quella TCP 5001 e pg 5002

![h2_WUI](https://www.codejava.net/images/articles/javase/jdbc/h2/H2_Console_login_page.png)

Come si può osservare l'interfaccia non è da meno alla classica interfaccia web ![phpmyadminlogo](https://www.phpmyadmin.net/static/favicon.ico) [phpMyAdmin](https://www.phpmyadmin.net) di MySQL.

![h2_WUI_2](https://www.tutorialspoint.com/h2_database/images/pop_ups.jpg)

## CLI

Se il database non esiste o vi è la necessità di impostare le credenziali di accesso al db, la CLI testuale è necessaria!

![CLI](https://northcoder.com/images/legacy/h2_create.png)

Per accedere ad essa si può adoperare il seguente comando:

```bash
java -cp h2.*.jar org.h2.tools.Shell
```

Questa interfaccia permetterà non solo di creare un nuovo DB ma anche di recuperarne uno già esistente ed operare in maniera testuale

A differenza di MySQL, non è richiesto avviare un server H2 in un'istanza separata. Nel codice Java, è sufficiente includere:

```java
org.h2.Driver.load();	// Carica il Server H2DB
// esegui operazioni
org.h2.Driver.unload();	// Ferma il Server H2DB
```

## 🔗 Links
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/biagio-rosario-greco-77145774/)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/birg_81)
