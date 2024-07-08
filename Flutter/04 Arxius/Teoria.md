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

# Arxius

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