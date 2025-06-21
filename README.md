# Sistema de Catálogo de Videojuegos

Nombre: Gonzalo Christian Andre Maturana Cruces |
Sección: 1 (14:56 - 16:25) | Asignatura: Patrones de Diseño

## Descripción general del sistema

Este proyecto es una aplicación de consola realizada en `Java`, que simula la gestión de un catálogo de videojuegos. Permite:

- Agregar nuevos videojuegos.
- Clonar videojuegos existentes (para crear ediciones especiales).
- Mostrar el catálogo en distintos formatos (texto y JSON simulado).
- Recorrer el catálogo secuencialmente usando un iterador.

La aplicación tiene una estructura modular y aplica **cuatro patrones de diseño** de forma clara y funcional.

---

## Problema a resolver

En tiendas de videojuegos o sistemas de gestión de inventario, se requiere de un sistema:

- Centralizado y consistente.
- Flexible para clonar productos base y crear nuevas versiones.
- Fácil de mostrar en múltiples formatos para exportación o visualización.
- Capaz de recorrer sus elementos sin exponer a detalles internos de su estructura.

Este sistema busca resolver esas necesidades mediante patrones de diseño vistos en clase.

---

## Patrones aplicados y justificación

### 1. **Singleton** - `GestorCatalogo`
- **Propósito**: Garantia una única instancia del catálogo de videojuegos.
- **Justificación**: Permite centralizar los datos para evitar inconsistencias. Toda acción hecha sobre el catálogo usa la misma instancia.

### 2. **Prototype** - `Videojuego.clonar()`
- **Propósito**: Permite clonar un videojuego existente dentro del catálogo para crear una nueva versión (por ejemplo, una edición especial).
- **Justificación**: Evita tener que construir un objeto nuevo desde cero si ya existe una base similar.

### 3. **Adapter** - `FormatoCatalogo`, `AdaptadorCatalogoTexto`, `AdaptadorCatalogoJSON`
- **Propósito**: Permite mostrar el catálogo existente en diferentes formatos sin modificar su estructura original.
- **Justificación**: Cumple el principio de abierto/cerrado (abierto a la extensión, cerrado a la modificación), permitiendo añadir nuevos formatos de salida fácilmente.

### 4. **Iterator** - `CatalogoIterator`
- **Propósito**: Permite recorrer los videojuegos registrados uno por uno sin exponer directamente la lista interna.
- **Justificación**: Abstrae el recorrido del catálogo, mejora el encapsulamiento y la flexibilidad del sistema.

---

## Instrucciones de compilación y ejecución

### Requisitos

- JDK 8 o superior instalado.

### Compilación

1. Abrir una terminal y ubicarse en el directorio raíz del proyecto:

```bash
cd /ruta/hacia/Evaluacion3Patrones
```

2. Compliar los archivos `.java`:

```bash
javac -d build/classes src/app/main.java src/model/*.java
```

3. Ejecutar el programa:

```bash
java -cp build/classes app.main
```

---

## Ejemplo de uso

```bash
===== MENÚ PRINCIPAL =====
1. Agregar videojuego nuevo
2. Clonar videojuego existente (Prototype)
3. Mostrar catálogo (Texto)
4. Mostrar catálogo (JSON)
5. Recorrer catálogo (Iterator)
6. Salir
Seleccione una opción:

```

Usted deberá elegir una de las opciones que aparecerá en su consola y seguir las instrucciones.
