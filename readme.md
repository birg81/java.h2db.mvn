[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)
[![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](https://opensource.org/licenses/)
[![AGPL License](https://img.shields.io/badge/license-AGPL-blue.svg)](http://www.gnu.org/licenses/agpl-3.0)

# java.h2db.mvn
Benvenuti in questo repository GitHub 🚀 che mostra un pregetto ![MVNrepo](https://mvnrepository.com/assets/images/7080b8b0f6f48e6fbaffd5f9d85fcc7f-favicon.ico) [Maven!](https://maven.apache.org) che sfrutta l'efficacia di ![H2DB](https://www.h2database.com/favicon.ico) [H2DB](https://www.h2database.com/html/main.html), un R-DBMS scritto in Java.
[H2 Database](https://it.wikipedia.org/wiki/H2_(DBMS)) si presenta come un'alternativa ai R-DBMS tradizionali come ![MySQL-logo](https://labs.mysql.com/common/themes/sakila/favicon.ico) [MySQL](https://www.mysql.com/) come sistema per lo storeging di Dati.

## Caratteristiche fondamentali

Una delle sue caratteristiche distintive è la dimensione ridotta, poiché archivia l'intero database in un unico file con estensione ```.mv.db```, simile al funzionamento di [SQLite](https://www.sqlite.org/index.html).
Questa caratteristica non solo garantisce robustezza, ma anche la resilienza dell'intero sistema in caso di corruzione di un singolo db.

H2DB, analogamente a SQLite, si distingue per la sua versatilità e velocità.
Questa agilità lo rende ideale per prototipare progetti.
Una caratteristica unica è la capacità di mantenere l'intero database in memoria, ottimizzando le prestazioni a scapito della persistenza.
Al riavvio del progetto, i dati vengono, optando per questa modalità, irrimediabilmente persi.
Per far uso di questa modalità (*in-memory storeging*) basta scrivere nel codice Java il seguente codice:

```java
Connection con = DriverManager.getConnection("jdbc:h2:mem:<db_name>", username, password);
```

Se invece si vuole puntare alla persistenza dei dati e al ripristino dei dati al riavvio dell'applicazione basta optare per la modalità classica (*Embedded storeging*) optando per il seguente codice:

```java
Connection con = DriverManager.getConnection("jdbc:h2:<path_to_db_name>", username, password);
```

Il nome del database non comprende la sua estensio (quindi senza ```.mv.db```).
Per altre modalità di connesione consultare [qui](http://www.h2database.com/html/features.html).

Essendo implementato in Java, H2DB è perfettamente integrato con il linguaggio, consentendo un approccio JDBC.
Altri linguaggi possono sfruttare questo DBMS a patto di avere una JVM installata e il relativo connettore (sotto forma di file JAR).

Nonostante la sua semplicità, H2DB offre un'interfaccia web integrata e una shell testuale estremamente versatile.

## WUI 

L'interfaccia web è flessibile ma non supporta la creazione del file di database stesso. A tale scopo, si ricorre all'interfaccia da riga di comando che offre la possibilità di impostare caratteristiche avanzate.

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

Come si può osservare l'interfaccia non è da meno alla classica interfaccia web <img src="https://www.phpmyadmin.net/static/favicon.ico" height="13"/> [phpMyAdmin](https://www.phpmyadmin.net) di MySQL.

![h2_WUI_2](https://www.tutorialspoint.com/h2_database/images/pop_ups.jpg)

## CLI

Se il database non esiste o vi è la necessità di impostare le credenziali di accesso al db, la CLI testuale è necessaria!

![CLI](https://northcoder.com/images/legacy/h2_create.png)

Per accedere ad essa si può adoperare il seguente comando:

```bash
java -cp h2.*.jar org.h2.tools.Shell
```

Questa interfaccia nel caso che il DB non esista, permetterà di crearlo e di settare in maniera avanzata tutte le credenziali; attraverso una serie di passaggi, sarà possibile scegliere a proprio piacimento username e password oltre che la posizione del db sul disco.

Questa interfaccia permetterà, inoltre, in caso di DB già esistente, di autenticarsi e successivamente operare in maniera professionale.

## Caricare istanza del server nel codice java
A differenza di MySQL, non è richiesto avviare un server H2 in un'istanza separata. Nel codice Java, è sufficiente richiamare:

```java
org.h2.Driver.load();	// Carica il Server H2DB
// esegui operazioni
org.h2.Driver.unload();	// Ferma il Server H2DB
```

## file POM

Il file [pom.xml](./pom.xml) o [**Project Object Model**](https://it.wikipedia.org/wiki/Apache_Maven) è un file costruito da Maven e serve per gestire le dipendenze del progetto.

All'interno del file si può facilmente notare il seguente snippet

```xml
<groupId>pkg</groupId>
<artifactId>java.h2db.mvn</artifactId>
<version>1.0.0-alpha</version>
<description>Maven and H2DB</description>
```

dove:

* ```grupId``` rappresenta il package nel qualve verrano disposte le diverse classi
* ```artifactId``` rappresenta il nome del progetto
* ```description``` è una descrizione del progetto (opzionale.

Si può inoltre notare il seguente spezzone:

**WIP**

```bash
/src
	/main
		/java/pkg
			Main.java
		/resources
	/test/java
/target
	/classes
	/test-classes
/PeopleDB.sql
/pom.xml
```

## 🔗 Links
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/biagio-rosario-greco-77145774/)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/birg_81)
