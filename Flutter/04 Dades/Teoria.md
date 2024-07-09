<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="./assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<br/>

<br/>
<center><img src="./assets/dartlogo.png" style="max-height: 75px" alt="">
<br/></center>
<br/>
<br/>

# Dades

Flutter pot fer servir un **Singleton** però no és recomanat, el motiu és que per optimitzar el rendiment i redibuix dels widgets, és més recomanable fer servir *notifyLiteners()*.

Quan hi han canvis a la informació (d'arxius o servidors), aquest l'objecte comú *"notifica"* als widgets que estan interessats en aquella informació, que cal redibuixar els seus continguts.

Així, enlloc de que el controlador hagi de decidir quins widgets cal actualitzar, aquests es redibuixen automàticament només si és necessari.

Per tal que funcionin els **"Notifiers"**, cal encapsular tota l’aplicació dins d’un **"ChangeNotifierProvider"** i definir quin objecte és el que s’encarrega de gestionar les dades.

```dart
runApp(
    ChangeNotifierProvider(
        create: (context) => AppData(),
            child: const App(),
    ),
);
```

I la classe que s'encarrega de gestionar les dades (conceptualment que fa la feina del *singleton*) fa servir el *mixin* **ChangeNotifier** per poder fer crides a *notifyListeners()*. I així redibuixar els widgets que depenen d'aquelles dades.

```dart
class AppData with ChangeNotifier {


  // Escull quin arxiu cal llegir i en carrega les dades
  void load (String type) async {

    // Forcem esperar 1 segon per veure el progrés
    await Future.delayed(const Duration(seconds: 1));

    // Carreguem les dades de l'arxiu
    var textArxiu = await rootBundle.loadString(arxiu);
    var dadesArxiu = json.decode(textArxiu);

    // Avisem que les dades estàn disponibles
    notifyListeners();
  }

}
```

## Arxius

Documentació:

- [Writing files](https://docs.flutter.dev/cookbook/persistence/reading-writing-files)

Per guardar arxius en format *.json*:

```dart
Future<void> saveFile(String fileName, Map<String, dynamic> data) async {

  file_saving = true;
  notifyListeners();

  try {
    final directory = await getApplicationDocumentsDirectory();
    final file = File('${directory.path}/$fileName');
    final jsonData = jsonEncode(data);
    await file.writeAsString(jsonData);
  } catch (e) {
    // ignore: avoid_print
    print("Error saving file: $e");
  } finally {
    file_saving = false;
    notifyListeners();
  }
}
```

Cridar la funció:

```dart
  final myData = {
    'type': 'list',
    'clients': clients,
    'selectedClient': selectedClient,
    // i més camps que vulguis guardar
  };
  await saveFile('myData.json', myData);
```

Per llegir arxius *.json*:

```dart
Future<Map<String, dynamic>?> readFile(String fileName) async {
  file_loading = true;
  notifyListeners();

  try {
    final directory = await getApplicationDocumentsDirectory();
    final file = File('${directory.path}/$fileName');
    if (await file.exists()) {
      final jsonData = await file.readAsString();
      final data = jsonDecode(jsonData) as Map<String, dynamic>;
      return data;
    } else {
      // ignore: avoid_print
      print("File does not exist!");
      return null;
    }
  } catch (e) {
    // ignore: avoid_print
    print("Error reading file: $e");
    return null;
  } finally {
    file_loading = false;
    notifyListeners();
  }
}
```

Cridar la funció:

```dart
    final data = await readFile('myData.json');
```
