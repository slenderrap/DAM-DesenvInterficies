class Casella {
  late int _posicioX;
  late int _posicioY;
  bool _descoberta = false;
  bool _bandera = false;
  bool _trampa = false;
  late String _text;

  Casella(int posicioX,int posicioY){
    this._posicioX=posicioX;
    this._posicioY=posicioY;
  }

  destapar(){
    if(this._bandera){
      print("Tens una bandera posada");
    }
    else if (!this._descoberta){
      descoberta = true;
    }
    else{
      print("Ja estava destapada");
    }
  }

  setTrampa() {
    if (!this._trampa) {
      this._trampa = true;
    } else {
      this._trampa = false;
    }
  }


  int get posicioX => _posicioX;

  set posicioX(int value) {
    _posicioX = value;
  }

  toString(){
    if (this._bandera){
      return "#";
    }
    if (this._descoberta || this._trampa){
      return _text;
    }else{
      return ".";
    }


  }

  int get posicioY => _posicioY;

  set posicioY(int value) {
    _posicioY = value;
  }

  bool get descoberta => _descoberta;

  set descoberta(bool value) {
    _descoberta = value;
  }

  bool get bandera => _bandera;

  set bandera(bool value) {
    _bandera = value;
  }

  bool get trampa => _trampa;

  set trampa(bool value) {
    _trampa = value;
  }

  String get text => _text;

  set text(String value) {
    _text = value;
  }

}



