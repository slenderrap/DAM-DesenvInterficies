<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2024</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="./assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<br/>

# Exercici 03

Implementa un 'Buscamines' per linia de comandes amb NodeJS. 

- Es generen 8 mines aleatòriament
- Hi ha almenys 2 mines a cada quadrant del tauler: [0,4]-[5,9] i [A,C]-[D,F]

Aquests són els tipus de casella:

- Les caselles `·` estàn per descobrir
- Les caselles numèriques indiquen la quantiat de mines al seu voltant
- Les caselles `#`indiquen una bandera
- Les caselles buides amb ` ` indiquen que no hi ha mina

Les accions s'escriuen amb:

- **Escollir casella**: la lletra de la fila i el número de la columna (B2, D5, ...)
- **Posar bandera**: casella i paraula *bandera*
- **Mostrar trucs**: paraules *cheat* o *trampes*
- **Ajuda**: paraules *help* o *ajuda*, mostren la llista de comandes

Al escollir una casella:

- Si no té mina es destapen les caselles adjecents de manera recursiva
- Si té mina s'acaba el joc

Al acabar el joc:

- Es mostra el tauler amb les mines destapades 
- El número de tirades que s'han fet (posar banderes i fer trampes no conten)

Per exemple:

```text
 0123456789
A··········
B··········
C··········
D··········
E··········
F··········
Escriu una comanda: C3
```

Per posar o treure una bandera s'escriu la casella i la paraula: "bandera"

```text
 0123456789
A     1····
B111  12···
C··1   1···
D··21121···
E··········
F··········
Escriu una comanda: E1 bandera
```

```text
 0123456789
A     1····
B111  12···
C··1   1···
D··21121···
E·#········
F··········
Escriu una comanda: E1 bandera
```

La paraula trampa permet mostrar o amagar el tauler amb les mines, al costat del tauler de joc

```text
 0123456789
A     1····
B111  12···
C··1   1···
D··21121···
E··········
F··········
Escriu una comanda: trampes
```

```text
 0123456789      0123456789
A     1····     A     1*···
B111  12···     B111  12···
C··1   1···     C·*1   1*··
D··21121···     D·*21121···
E··········     E····**····
F··········     F·*·····*··
Escriu una comanda: cheat
```

```text
 0123456789
A     1····
B111  12···
C··1   1···
D··21121···
E·#········
F··········
Escriu una comanda: F1
```

```text
 0123456789
A     1*···
B111  12···
C·*1   1*··
D·*21121···
E····**····
F·*·····*··
Has perdut!
Número de tirades: 2
```