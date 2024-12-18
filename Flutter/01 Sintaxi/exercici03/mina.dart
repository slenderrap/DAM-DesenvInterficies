import 'casella.dart';
class Mina extends Casella{

  Mina(int _posicioX,int _posicioY) : super(_posicioX, _posicioY){
    text = "*";
  }
  @override
  bool destapar() {

      if(this.bandera){
        print("Tens una bandera posada");
      }
      else if (!this.descoberta){
        descoberta = true;
        print("Has trobat una mina!");

      }
      return true;
    }
}