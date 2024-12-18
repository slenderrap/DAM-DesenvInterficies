import 'casella.dart';
class Mina extends Casella{

  Mina(int _posicioX,int _posicioY) : super(_posicioX, _posicioY);

  destapar(){
    _text = "*";
  }


}