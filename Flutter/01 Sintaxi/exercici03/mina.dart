import 'casella.dart';
class Mina extends Casella{

  Mina() : super(){
    text = "*";
  }
  @override
  bool destapar(bool primeraJugada) {
      if (primeraJugada) return true;
      if(this.bandera){
        print("Tens una bandera posada");
        return false;
      }
      else if (!this.descoberta){
        descoberta = true;
        print("Has trobat una mina!");

      }
      return true;
  }


}
