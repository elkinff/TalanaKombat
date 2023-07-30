
# Talana Kombat by Rodri 🤺 

Talana Kombat by Rodri es una "CLI APP" (aplicación de línea de comandos), la cual simula el enfrentamiento entre los jugadores Tonyn Stallone y Arnaldor Shuatseneguer, los cuales guiarás hacia la victoria o a la derrota, que lo disfrutes! 

## A Jugar 🚀

Podrás jugar Talana Kombat de la siguiente forma:

1. Enviarás las combinaciones de movimientos y golpes de cada uno de los jugadores de la siguiente forma:

```json
{"player1": {"movimientos": ["D", "DSD", "S", "DSD", "SD"], "golpes": ["K", "P", "", "K", "P"]}, "player2":{ "movimientos": ["SA", "SA", "SA", "ASA", "SA"],"golpes": ["K","","K","P","P"]}} 
```

De esta forma indicas como serán los movimientos, golpes y golpes especiales que realizarán los contrincantes durante el juego. 

Verás el paso a paso de la pelea cada segundo y medio, así le damos más drama y atención al juego:

```bash
Ingresa los datos de la pelea: 
{"player1": {"movimientos": ["D", "DSD", "S", "DSD", "SD"], "golpes": ["K", "P", "", "K", "P"]},"player2":{"movimientos": ["SA", "SA", "SA", "ASA", "SA"],"golpes": ["K","","K","P","P"]}}

Tonyn avanza y conecta una Patada
Arnaldor conecta un Remuyuken
Tonyn conecta un Taladoken
Arnaldor se mueve
Tonyn se mueve
Arnaldor conecta un Remuyuken
Arnaldor gana la pelea y aun le quedan 2 de energía
```

## Ejecución ▶ ✅

Talaba Kombat by Rodri puede ser ejecutado con Docker de la siguiente forma:

1. Clonar el repositorio en tu maquina local.

2. Generar la imagen de Docker con el siguiente comando:
```bash
docker build -t talanakombat .
```

3. Levantar el contenedor con la imagen creada, de esta forma iniciará el juego y quedará a la espera de que envíes los datos anteriormente mencionados:
```bash
docker docker run -i talanakombat
```

## Tech STACK  🔧
Para la creación de este software que es una aplicación de línea de comandos se implementó con las siguientes tecnologías:
* [Kotlin](https://kotlinlang.org/) - Es un lenguaje de programación multiplataforma, de tipado estático, de alto nivel, de propósito general y con inferencia de tipos.
* [Gradle](https://gradle.org/) - Es un sistema de automatización de la construcción de código de software que se basa en los conceptos de Apache Ant y Apache Maven e introduce un lenguaje específico de dominio basado en Groovy.
* [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) - Java 17 es la última versión de soporte a largo plazo (LTS, por sus siglas en inglés) dentro la cadencia de lanzamiento semestrales de Java y es el resultado de una amplia colaboración entre los ingenieros de Oracle.

## Estructura de archivos 📁
La carpeta más importante del proyecto es la carpeta /src, contiene el paquete /main con la implementación del juego en el archivo Main.kt.

Implementado y desarrollado con ❤️

# Preguntas ☕ 

#### 1. Supongamos que en un repositorio GIT hiciste un commit y olvidaste un archivo. Explica cómo se soluciona si hiciste push, y cómo si aún no hiciste.

1. Si ya se hizo push:
  En este caso, es importante tener en cuenta que reescribir la historia de Git puede causar problemas a otros colaboradores. Sin embargo, si se está seguro de que no afectará a otros, se pueden seguir estos pasos:

   a. Asegurarse de tener el archivo que falta en tu directorio de trabajo y que ha sido modificado según lo necesario.
   b. Realizar un nuevo commit que incluya el archivo que olvidado.
   c. Ahora, para solucionar el problema:

   Opción 1: Enmiendar el último commit:
      ```
      git add archivo_olvidado
      git commit --amend
      ```
   Esto agregará el archivo olvidado al último commit.

   d. Realizar un nuevo push:
   
   Reemplaza `<nombre_de_tu_rama>` con el nombre de la rama en la que estás trabajando.


2. Si aún no se ha hecho push:

   a. Agregar el archivo olvidado al área de preparación (staging):
   
   b. Realiza un nuevo commit que incluya el archivo olvidado:

De esta forma se habrá agregado el archivo olvidado al repositorio local con el nuevo commit.

#### 2. Si has trabajado con control de versiones ¿Cuáles han sido los flujos con los que has trabajado?

He trabajado con git flow, donde existen las ramas principales, de soporte y de características. Este flujo se caracteriza por su estructura y enfoque en la estabilidad del proyecto. Los cambios fluyen en una dirección clara y bien definida, y cada tipo de cambio tiene su propia rama específica para facilitar el desarrollo paralelo y el control de versiones.

#### 3. ¿Cuál ha sido la situación más compleja que has tenido con esto?

Respecto a git flow podría decir que los principales problemas con los conflictos de fusión y el tamaño excesivo del repositorio.

En una ocasión tuve que resolver un problema con un merge hacia una rama de soporte, la cual presentaba más de 70 conflictos, ya que era un refactor grande que se estaba haciendo a un proyecto legacy el cual aún estaba en producción y en mantenimiento. En esta oportunidad tuve que dimensionar el refactor de otra forma y dividirlo por etapas, y de esta forma resolver los conflictos de una forma más fácil, fue un gran aprendizaje que me lleve de esa ocasión.

#### 4. ¿Qué experiencia has tenido con los microservicios?

En los últimos dos proyectos donde estuve trabajando los cuales en total estuve prensente alrededor de 4 años y medio se utilizó la arquitectura de microservicios, de hecho en el primer proyecto tuvimos que hacer el diseño y arquitectura desde cero, ya que teníamos un monolito y la idea era “romperlo” por completo, en esa ocasión leí el libro "Monolith to microservices" de Sam Newman el cual te guía paso a paso con diferentes patrones y procesos para romper el monolito y empezar a crear tus microservicios desde cero.

En el segundo proyecto ya existía una arquitectura de microservicios consolidada, allí aprendí muchas más aspectos técnicos acerca de este patrón de arquitectura, como comunicación entre microservicios, tópicos, calendarizados, colas, base de datos no relacionales entre muchos más.

Se podría decir que tengo gran experiencia con microservicios tanto en proyectos desde cero como también consolidados.

#### 5. ¿Cuál es tu servicio favorito de GCP o AWS? ¿Por qué?

Se podría decir que tanto GCP como AWS son plataformas en la nube líderes que ofrecen una amplia gama de servicios y herramientas para alojar, gestionar y escalar aplicaciones y servicios en la nube. Ambas plataformas tienen sus ventajas y características únicas.

Me siento más cómodo trabajando con AWS, ya que llevo al rededor de 6 años trabajando con este proveedor y sus diferentes servicios, desde el punto de vista de material educativo, como cursos y certificaciones, siento que le lleva ventaja respecto a GCP, por eso me iría con AWS, pero no tendría problema de trabajar con GCP, de hecho en pasados proyectos he tenido la oportunidad de trabajar con este servicio y la verdad que me parece muy intuitivo y cómodo para trabajar. 