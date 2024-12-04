import 'dart:io';

void main() {
    //si hi ha mina explota i es veu tot el taulell
    //caselles . per descobrir
    //' ' no hi ha mina ni hi ha al voltant
    // nums indiquen mines
    //  # indiquen bandera

    var opcions = ["XY", "XY flag", "XY bandera", "trampes", "cheat","ajuda"];
    bool trampes=false;

    var files="ABCDEF";
    var matriu = crearMatriu();

    imprimirTablero(matriu, trampes);


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
    List<List<String>> matriu =List.generate(6, (i) => List.filled(10,"."));
    // for (var fila = -1;fila<=6;fila++){
    //   for (var columna=-1;columna<=9;columna++){
    //
    //   }
    // }

    return matriu;
}
