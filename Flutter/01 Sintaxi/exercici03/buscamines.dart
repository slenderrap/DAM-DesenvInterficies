import 'dart:io';
import 'dart:math';
import 'casella.dart';
import 'dart:math';
import 'mina.dart';
int casellesRestants=10*6-8;
void main() {
    //si hi ha mina explota i es veu tot el taulell
    //caselles . per descobrir
    //' ' no hi ha mina ni hi ha al voltant
    // nums indiquen mines
    //  # indiquen bandera

    var opcions = ["xy", "xy flag", "xy bandera", "trampes", "cheat", "ajuda"];
    var lletres="abcdef";
    var matriu = crearMatriu();
    int tirades=0;
    bool primerMoviment=true;
    bool trampes=false;
    bool victoria = true;
    while(victoria && casellesRestants>0){

      var comanda="";
      imprimirTablero(matriu, trampes);
      comanda = verificarComanda(opcions,lletres);

      if (comanda.length==2||comanda.contains(" ")){
        tirades++;
        var fila=lletres.indexOf(comanda[0]);
        var columna = int.parse(comanda[1]);

        if (!comanda.contains(" ")) {

          if (destaparCasella(matriu,fila,columna,primerMoviment,true)){
          victoria = false;
          } else {
            //mina no explota
            primerMoviment=false;
          }

        }else{
          if(matriu[fila][columna].bandera){
            matriu[fila][columna].bandera=false;
          }else {
            matriu[fila][columna].bandera = true;
          }
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

    print("\n");
    }
    if(!victoria){
      print("Has perdut!\nNumero de tirades ${tirades}");
    }else{
        print("Felicitats! Has guanyat!");
    }

}

bool destaparCasella(List<List<Casella>> matriu, int fila, int columna, bool primerMoviment, bool jugadaUsuari) {

    //1. comprobar limits per evitar errors de fora de rang
    if (fila>=matriu.length||fila<0 || columna>=matriu[0].length || columna<0|| matriu[fila][columna].descoberta) {
      return false;
    }
    if (matriu[fila][columna].bandera){
      print("tens una bandera posada");
      return false;
    }
    //2. agafem la casella a destapar
    var casella = matriu[fila][columna];
    //3. com el meu metode ja gestiona si es una mina, si esta amb una bandera o si ja estava destapada no cal verificar la clase
    if (casella.destapar(primerMoviment)){
        //si es el primer moviment movem la mina
        if (primerMoviment){
          matriu = moureMina(matriu,fila,columna);
          destaparCasella(matriu, fila, columna, true, true);
        }else if(jugadaUsuari) {
          return true;
        }
    }

    //4. comptar mines al voltant i indicar que s'ha destapat una casella
    casellesRestants--;
    var minesTrobades=minesProperes(matriu, fila, columna);
    matriu[fila][columna].text = minesTrobades.toString();

    //5. Si no hi ha cap mina, que sigui recursiu
    if (minesTrobades==0){
      matriu[fila][columna].text =" ";
      for (var i = -1; i <= 1; i++) {
        for (var j = -1; j <= 1; j++) {
          if ((i != 0 || j != 0)) {
            destaparCasella(matriu, fila + i, columna +j, false, false);
          }
        }
      }
    }
    return false;
}

List<List<Casella>> moureMina(List<List<Casella>> matriu, int filaInicial, int columnaInicial) {
    for (var i = 0; i < matriu.length; i++) {
        for (var j = 0; j < matriu[i].length; j++) {
          if (matriu[i][j] is! Mina && !(i == filaInicial && j == columnaInicial)){
            matriu[i][j]=Mina();
            matriu[filaInicial][columnaInicial] = Casella();
            return matriu;
          }

        }
    }
    return matriu;



}

int minesProperes(List<List<Casella>> matriu, int fila, int columna) {
  var minesTrobades = 0;
  for (var i = -1; i <= 1; i++) {
    for (var j = -1; j <= 1; j++) {
      // Saltar la casella central
      if (i == 0 && j == 0) continue;
      // Comprovar que les coordenades són vàlides
      var novaFila = fila + i;
      var novaColumna = columna + j;
      if (novaFila >= 0 && novaFila < matriu.length &&
          novaColumna >= 0 && novaColumna < matriu[0].length) {
        if (matriu[novaFila][novaColumna] is Mina) {
          minesTrobades++;
        }
      }
    }
  }
  return minesTrobades;
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
          if (comanda.length==2 || (comanda.contains(" flag") && comanda.length==7)|| (comanda.contains(" bandera") && comanda.length==10)){
            var fila = comanda[0];
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
  List<List<Casella>> matriu =List.generate(6, (i) => List.generate(10,(j) =>Casella()),);
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
        matriu[y][x]=new Mina();
        minesPendents--;
      }
    }
  }

    return matriu;
}

