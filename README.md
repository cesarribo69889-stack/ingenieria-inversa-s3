# SistemaVentas-Mantenimiento (16 semanas)

Proyecto base en Java (sin Maven/Gradle) listo para importar en VS Code.
Diseñado para prácticas de mantenimiento correctivo, perfectivo, adaptativo y preventivo.

## Cómo ejecutar en VS Code
1. Abrir esta carpeta en VS Code
2. Instalar extensión **Extension Pack for Java**
3. Abrir `src/app/Main.java`
4. Click en **Run**

## Bugs y Code Smells intencionales
El proyecto contiene fallas intencionales para ser corregidas en actividades semanales:
- Validaciones incompletas (DNI, precio, cantidad)
- Duplicación de código en servicios
- Uso de `System.out.println` repetitivo (refactor)
- Dependencias fuertes (DIP)
- Métodos largos (SRP/DRY)
- Reportes acoplados
- Falta de manejo de excepciones
- Búsqueda lenta / sin índices (simulada)
- Formato de dinero incorrecto (double)
