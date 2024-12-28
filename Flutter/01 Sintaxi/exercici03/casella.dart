class Casella {

  bool _descoberta = false;
  bool _bandera = false;
  bool _trampa = false;
  late String _text;

  Casella(){
    this._text ="·";
  }

bool destapar(bool primerMoviment){
    if(this._bandera){
      print("Tens una bandera posada");
    }
    else if (!this._descoberta){
      descoberta = true;
    }
    else{
      print("Ja estava destapada");
    }
    return false;
  }

  setTrampa() {
    if (!this._trampa) {
      this._trampa = true;
    } else {
      this._trampa = false;
    }
  }



  toString(){
    if (this._trampa){
      return _text;
    }
    else if (this._bandera){
      return "#";
    }
    else if (this._descoberta){
      return _text;
    }else{
      return "·";
    }


  }

  bool get descoberta => _descoberta;

  set descoberta(bool value) {
    _descoberta = value;
  }

  bool get bandera => _bandera;

  set bandera(bool value) {
    if (_bandera){
      this._bandera =false;
    }else{
      if (!_descoberta) {
        this._bandera = true;
      }else{
        print("No pots realitzar aquesta accio");
      }
    }
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



