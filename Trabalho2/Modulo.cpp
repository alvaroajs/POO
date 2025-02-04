#include "Modulo.hpp"

Modulo::Modulo() {}

Modulo::Modulo(char tipo) {
    this->tipo = tipo;
}
char Modulo::getTipo() {  
    return this->tipo;
}

bool Modulo::podeAcessar() {
    return true;
}
