# Esqueleto gradle con las dependencias para JavaFX

#### Autor: José Ramón Jiménez Reyes

#### Descripción

En este repositorio encontrarás el esqueleto de un proyecto que lanza una ventana sencilla de ejemplo, utilizando JavaFX.

Dicho proyecto contiene las dependencias **gradle** para trabajar con **JavaFX** y para empaquetarlo correctamente. Notar qure es un proyecto no modular, por lo que al ejecutarlo desde el IDE lanzará una advertencia indicándolo, que podemos obviar.

También contiene una clase pricipal de ejemplo `Main` y la correspondiente clase lanzadora `LanzadoraMain`.

#### Uso

Lo primero que debes hacer es clonar el repositorio en tu IDE.

Elimina el repositorio local, eliminando el directorio `.git`. Esto debes hacerlo desde el sistema de ficheros o desde la línea de comandos, ya que desde el IDE generalmente no se muestra este directorio. Generalmente, deberás refrescar para que el IDE sea consciente de los cambios.

Cambia el nombre del proyecto para adecuarlo a tus preferencias. Utiliza las funciones de refactorización que ofrece tu IDE para renombrar el proyecto. Es necesario que tamibén cambies el nombre de la carpeta que contiene el proyecto.

Abre el archivo `settings.gradle` y cambia el nombre de proyecto ahí también.

Si vas a utilizar un VCS, crea el repositorio conveniente.

Por último, empieza a hacer las modificaciones necesarias para crear tu aplicación.

#### Ejecución

Ejecutálo normalmente desde tu IDE o utiliza la tarea `run` asociada para ejecutarlo. Desde la línea de comandos puedes utilizar el comando `./gradlew run` (si queremos obviar la salida de gradle podemos ejecutarlo utilizando el siguiente comando `./gradlew --console plain --quiet run`).
