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

    var opcions = ["xy", "xy flag", "xy bandera", "trampes", "cheat", "ajuda"];
    var lletres="abdef";
    var matriu = crearMatriu();
    int tirades=0;
    bool trampes=false;
    bool victoria = true;
    int casellesRestants = (matriu.length * matriu[0].length) -8;
    while(victoria){

      var comanda="";
      imprimirTablero(matriu, trampes);
      comanda = verificarComanda(opcions,lletres);
      if (comanda.length==2||comanda.contains(" ")){
        tirades++;
        var fila=lletres.indexOf(comanda[0]);
        var columna = int.parse(comanda[1]);
        if (!comanda.contains(" ")) {
          if (matriu[fila][columna].destapar()) {
            victoria = false;
          } else {
            casellesRestants--;
          }
      }else{
          matriu[fila][columna].bandera;
        }
    }else if (comanda.contains(" ")){
        tirades++;

      }
      switch (comanda){
        case "trampes":
        case "cheat":
          trampes=true;
          break;
        case "ajuda":
          opcions.forEach((x)=>print(x));
          break;
      }

    }
    if(!victoria){
      print("Has perdut!\nNumero de tirades ${tirades}");
    }else{

    }

}

String verificarComanda(opcions,lletres) {
    String comanda="";
    while (!opcions.contains(comanda.toLowerCase())) {

        stdout.write("Escriu una comanda: ");
        String? input = stdin.readLineSync()?.trim();

        if (input == null||input.isEmpty) {

          print("Has d'introduir una comanda");
          continue;

        }else {
          comanda = input;
          print(comanda.contains(" flag") && comanda.length==7);
          if (comanda.length==2 || (comanda.contains(" flag") && comanda.length==7)|| (comanda.contains(" bandera") && comanda.length==10)){
            var fila = comanda[0];
            print(fila);
            try {
            if (lletres.indexOf(fila)!=-1) {
              var columna;
                columna = int.parse(comanda[1]);

              if (0<=columna && columna<=9){
                return comanda;
              }

            }
              } on FormatException {
                print("Error: La columna no era un numero");
              }catch(e){
                print("aqui");
                print(e);
              }
            print("No has introduit be la posicio de la casella");
          }

        }


    }
    return comanda;
}
void imprimirTablero(matriu, trampes){
      var fila = "";
      for (var i=-1;i<=9;i++){
        if (i!=-1){
          fila += " ${i}";
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
            fila += ' ' + matriu[n_fila][j].toString();
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
            fila += ' ' + matriu[n_fila][j].toString();
            matriu[n_fila][j].setTrampa();
          }
          fila +="\t"+String.fromCharCode(i);
          for (var j=0;j<10;j++){
            fila += ' ' + matriu[n_fila][j].toString();
            matriu[n_fila][j].setTrampa();
          }
          print(fila);
        }


      }


    }
List<List<Casella>> crearMatriu(){
  Random random = Random();
  // print(5 +random.nextInt(11-5));
  List<List<Casella>> matriu =List.generate(6, (i) => List.generate(10,(j) =>Casella(j, i)),);
  //8 minas: 2 cada quadrant
  //quadrant 1: (0,0) -> (2,4)
  //quadrant 2: (0,5) -> (2,9)
  //Quadrant 3: (3,4) -> (5,4)
  //quadrant 2: (3,5) -> (5,9)
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

    return matriu;
}
