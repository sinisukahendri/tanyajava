# Checkout source code and build #

1. checkout source code using subversion

```
http://code.google.com/p/tanyajava/source/checkout
```

2. Install maven2

3. Install mysql and create database tanyajava

```
mysql> create database tanyajava;
mysql> grant all on tanyajava.* to tanyajava@localhost identified by 'tanyajava'
```

4. build source code

```
$ mvn clean install
```

5. generate database

```
$ mvn exec:java -Dexec.mainClass="com.tanyajava.utils.GenerateDatabaseUtils"
```

6. run application

```
$ mvn jetty:run
```

7. Open browser and access url http://localhost:8080/tanyajava/j/index