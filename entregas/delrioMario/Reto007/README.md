# Nuestro intento de Klondike

## ¡Versión beta!

Desarrollada en vivo en clase: **puede contener errores**. Por favor, indicarlos en los issues para ir corrigiéndolos. Si alguien detecta y corrige un error, hacer un **PR**

```
OPCIONES>
1. Mover de Baraja a Descarte
2. Mover de Descarte a Palo
3. Mover de Descarte a Columna
4. Mover de Palo a Columna
5. Mover de Columna a Palo
6. Mover de Columna a Columna
7. Voltear carta de Columna
8. Voltear Descarte en Baraja
9. Salir
BARAJA: [? ?]
Descarte: [Q ♦️][7 ♦️][9 ♣️]
1º Palo: [A ♥️]
2º Palo: [A ♦️]
3º Palo: No hay cartas en el palo
4º Palo: No hay cartas en el palo
Columna [1]: [3 ♠️]
Columna [2]: [K ♥️]
Columna [3]: [? ?][? ?][7 ♠️]
Columna [4]: [? ?][? ?][? ?]
Columna [5]: [? ?][? ?][? ?][? ?][X ♥️]
Columna [6]: [? ?][? ?][? ?][? ?][? ?][6 ♥️]
Columna [7]: [? ?][? ?][? ?][? ?][? ?][? ?][9 ♥️]
Elige una opción  [1-9]
```

## Clases propuestas y sus respectivas vistas públicas

- **Klondike**
  - [x] Klondike()
  - [x] void jugar()
- **Menu**
  - [x] void mostrar()
  - [x] int getOpcion()
- **Baraja**
  - [x] Baraja()
  - [x] void mostrar()
  - [x] void moverA(Descarte descarte)
  - [x] void poner(Carta carta)
  - [x] Carta sacar()
  - [x] boolean vacia()
- **Descarte**
  - [x] Descarte()
  - [x] void mostrar()
  - [x] void moverA(Palo palo)
  - [x] void moverA(Columna columna)
  - [x] void voltear(Baraja baraja)
  - [x] void poner(Carta carta)
- **Palo**
  - [x] Palo()
  - [x] void mostrar()
  - [x] void moverA(Columna columna)
  - [x] void moverA(Palo palo)
  - [x] void poner(Carta carta)
- **Columna**
  - [x] Columna(Baraja baraja, int numeroColumna)
  - [x] void mostrar()
  - [x] void moverA(Palo palo)
  - [x] void moverA(Columna columna)
  - [x] void voltear()
  - [x] void poner(Carta carta)
- **Carta**
  - [x] Carta(int palo, int numero)
  - [x] void mostrar()
  - [x] void voltear()
  - [x] boolean esAs()
  - [x] boolean esRey()
  - [x] boolean igualPalo(Carta carta)
  - [x] boolean siguiente(Carta carta)
  - [x] boolean bocaArriba()
  - [x] boolean distintoColor(Carta carta)

## Clases de apoyo

- **Intervalo**
