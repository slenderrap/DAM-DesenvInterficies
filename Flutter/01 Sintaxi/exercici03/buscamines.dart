import 'dart:io';
import 'dart:math';
import 'casella.dart';
import 'dart:math';
import 'mina.dart';
void main() {
    //si hi ha mina explota i es veu tot el taulell
    //caselles . per descobrir
    //' ' no hi ha mina ni hi ha al voltant
    // nums indiquen mines
    //  # indiquen bandera
    Mina mina = new Mina(0, 0);
    print(mina.trampa);

    var opcions = ["xy", "xy flag", "xy bandera", "trampes", "cheat","ajuda"];
    bool trampes=false;
    String comanda="";
    var files="ABCDEF";
    var matriu = crearMatriu();

    imprimirTablero(matriu, trampes);
    comanda = verificarComanda(opcions);
    print(comanda);

}

String verificarComanda(opcions) {
      String comanda="";
      while (!opcions.contains(comanda.toLowerCase())) {
          stdout.write("Escriu una comanda: ");


          String? input = stdin.readLineSync()?.trim();
          print("aqui");
          print(input);
          if (input == null||input.isEmpty) {
              print("Has d'introduir una de les comandes");
              continue;

          }
          comanda = input;
          print("object");

      }
      return comanda;
}
void imprimirTablero(matriu, trampes){
      var fila = "";
      for (var i=-1;i<=9;i++){
        if (i!=-1){
          fila += "${i}";
        }else{
          fila =" ";
        }
      }
      if (!trampes){
        print(fila);
        var start = 'A'.codeUnitAt(0);
        var end = 'F'.codeUnitAt(0)+1;
        for (var i=start;i<end;i++){
          fila = String.fromCharCode(i);
          var n_fila = i-start;
          for (var j=0;j<10;j++){
            fila += matriu[n_fila][j].toString();
          }
          print(fila);
        }
      }
      else{
        print(fila +"\t"+ fila);
        var start = 'A'.codeUnitAt(0);
        var end = 'F'.codeUnitAt(0)+1;
        for (var i=start;i<end;i++){
          fila = String.fromCharCode(i);
          var n_fila = i-start;
          for (var j=0;j<10;j++){
            fila += matriu[n_fila][j].toString();
            matriu[n_fila][j].setTrampa();
          }
          fila +="\t"+String.fromCharCode(i);
          for (var j=0;j<10;j++){
            fila += matriu[n_fila][j].toString();
            matriu[n_fila][j].setTrampa();
          }
          print(fila);
        }


      }


    }
List<List<String>> crearMatriu(){
    List<List<String>> matriu =List.generate(6, (i) => List.filled(10,""));
    //8 minas: 2 cada cuadrante
    Random random = Random();

    // for (var fila = -1;fila<=6;fila++){
    //   for (var columna=-1;columna<=9;columna++){
    //
    //   }
    // }

    return matriu;
}
