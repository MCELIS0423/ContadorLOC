
Instrucciones para descargar el proyecto desde GitHub
La ruta del repositorio GitHub es: https://github.com/MCELIS0423/ContadorLOC.git

Para descargarlo:

1. Ubicarse en la carpeta deseada para operar el proyecto
2. Ejecutar en la consola: git clone --bare https://github.com/MCELIS0423/ContadorLOC.git
3. cd ContadorLoc.git
4. Ya se puede observar todo el proyecto

Creación del proyecto maven
mvn archetype:generate -DgroupId=edu.uniandes.ecos.ase.app -DartifactId=ContadorLOC -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

Dentro de la carpeta del proyecto creado, es decir /contadorLOC, ejecutar: 
mvn package

Para ejecutar la clase principal del archivo de prueba, ejecutar:
java edu.uniandes.ecos.ASE.app.App
