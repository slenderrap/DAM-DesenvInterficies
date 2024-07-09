<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="./assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<br/>

# Vistes i navegació

A Flutter les vistes també són Widgets.

Flutter proporciona diverses maneres de navegar entre pantalles. La més comuna és utilitzar el widget Navigator. El Navigator gestiona una pila de rutes (vistes/pantalles) i proporciona mètodes per empènyer noves rutes a la pila o treure-les.

- **Navigator.push**: Utilitzat per empènyer una nova ruta a la pila de navegació. En aquest exemple, MaterialPageRoute es construeix amb SecondPage com la nova pantalla.
- **Navigator.pop**: Utilitzat per treure la ruta superior de la pila de navegació i tornar a la pantalla anterior.

Per exemple, per canviar de vista apretant un botó:

```dart
CupertinoButton(
    child: const Text('Go to View 1'),
    onPressed: () {
        Navigator.push(
        context,
        CupertinoPageRoute(builder: (context) => View1()),
        );
    },
),
```

**Nota:** Amb els widgets de *Cupertino* la barra de navegació ja mostra el botó *"<"* per tornar enrrera fent un *".pop"* de manera automàtica.

**Exemple 0300:**

<br/>
<center><img src="./assets/ex0300.png" style="max-height: 400px" alt="">
<br/></center>
<br/>