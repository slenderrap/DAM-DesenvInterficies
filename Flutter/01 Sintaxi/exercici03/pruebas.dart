import 'dart:math';
import 'mina.dart';
import 'casella.dart';
import 'dart:io';

void main (){
    Random random = Random();
    // print(5 +random.nextInt(11-5));
    List<List<Casella>> matriu =List.generate(6, (i) => List.generate(10,(j) =>Casella(j, i)),);
    //8 minas: 2 cada quadrant
    //quadrant 1: (0,0) -> (2,4)
    //quadrant 2: (0,5) -> (2,9)
    //Quadrant 3: (3,4) -> (5,4)
    //quadrant 2: (3,5) -> (5,9)
    var trampes = true;
    var quadrants=[
      [0,5,0,3],
      [5,9,0,3],
      [0,5,3,6],
      [5,9,3,6]
    ];
    for (var i =0;i<4; i++){
      var quadrant= quadrants[i];
      var minesPendents=2;
      while (minesPendents>0){
        var x = quadrant[0]+ random.nextInt(quadrant[1]-quadrant[0]);
        var y = quadrant[2]+ random.nextInt(quadrant[3]-quadrant[2]);
        if (matriu[y][x] is! Mina ){
          matriu[y][x]=new Mina(x, y);
          minesPendents--;
      }
    }
  }

    //imprimir tablero
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
    String? comanda="";
    stdout.write("Escriu una comanda: ");


    String? input = stdin.readLineSync()?.trim();
    print("aqui");
    print(input);
    if (input == null||input.isEmpty) {
      print("Has d'introduir una de les comandes");

    }
    comanda = input;
    print("object");



  // for (var fila = -1;fila<=6;fila++){
  //   for (var columna=-1;columna<=9;columna++){
  //
  //   }
  // }
}