<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="./assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<br/>

# Canvas

El **Canvas** és una classe en JavaFX que proporciona una superfície de dibuix sobre la qual es poden renderitzar formes, imatges i text. És similar a un llenç de pintura on es poden dibuixar diferents elements gràfics utilitzant operacions de dibuix proporcionades per la classe GraphicsContext.

El **Canvas** s'utilitza quan es necessita un control de dibuix flexible i personalitzable dins d'una aplicació JavaFX. És especialment útil per a aplicacions que requereixen dibuixos dinàmics, gràfics en temps real, jocs, visualitzacions personalitzades, i qualsevol altra situació on els elements gràfics es generen programàticament.

Per fer servir el *Canvas* cal definir un objecte **"Canvas"** a la vista:

```xml
<Canvas fx:id="canvas" height="400.0" width="500.0" ... />
````

Al controlador, cal mantenir una referència al *"context de dibuix"* del *Canvas*:

```java
private GraphicsContext gc;

@Override
public void initialize(URL url, ResourceBundle rb) {
    gc = canvas.getGraphicsContext2D();
}
```

Quan volem dibuixar al *Canvas* fem servir el context anterior:

```java
    // Dibuixar un quadrat
    gc.setFill(color);
    gc.fillRect(x, y, size, size);
```

```java
    // Dibuixar un cercle
    gc.setFill(color);
    gc.fillOval(x, y, size, size);
```

El canvas va 'pintant' els objectes a sobre dels antics, així si volem netejar-lo i començar de nou:

```java
@FXML
private void clearAction(ActionEvent event) {
    // Netejar tot el Canvas
    gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
}
```

## Exemple 0600

Aquest exemple mostra un projecte bàsic que inicia un canvas amb un dibuix, i té un botó per afegir cercles i quadres de manera aleatòria.

<br/>
<center><img src="./assets/ex0600.png" style="max-height: 400px" alt="">
<br/></center>
<br/>
<br/>