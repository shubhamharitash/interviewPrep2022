## Introduction to Computer programs and Java

### How a java program executes
```mermaid
stateDiagram
    state "Source Code" as s1
    state "Byte Code" as s2
    state "Executed Program or Process" as s3
    s1 --> s2: Compile the source code<br> javac Hello.java
    s2 --> s3: Run the bytecode<br> JVM is resopnsible for executing Java bytecode <br>and can run java bytecode on any machine <br> java Hello
```
- Note: `java Hello` command can be used for both running or compile then run a java program. If Hello is a compiled bytecode 'Hello.class' then it is executed, else if its a java program it will be compiled then executed

## Types of errors
- Syntax
- Runtime
- Logic

## Naming Convention
- Functions: camelCasing
- Classes: PascalCasing

## Anatomy of Java Project
```mermaid
stateDiagram
    state "Anatomy of Java Project" as source
    state "Main Method Class" as main
    source --> documentation
    source --> packages
    source --> import
    source --> classes
    source --> interface
    source --> main
```

