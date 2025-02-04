#include"Astronauta.hpp"

Astronauta::Astronauta(string nome, int nivelSaude, bool atendimentoUrgente, int x, int y){
    this->nome = nome;
    this->nivelSaude = nivelSaude;
    this->antendimentoUrgente = atendimentoUrgente;
    this->x = x;
    this->y = y;
}

int Astronauta::getX(){
    return x;
}
int Astronauta::getY(){
    return y;
}
void Astronauta::setX(int x){
    this->x = x;
}
void Astronauta::setY(int y){
    this->y = y;
}
string Astronauta::getNome(){
    return nome;
}
int Astronauta::getNivelSaude(){
    return nivelSaude;
}
bool Astronauta::isAtendimentoUrgente(){
    return antendimentoUrgente;
}
string Astronauta::toString(){
    return "Astronauta: " + nome + ", Nivel de Saude: " + to_string(getNivelSaude()) +  ", Atendimento Urgente: " +  to_string(isAtendimentoUrgente()) +  ", Posicao: (" + to_string(getX()) + ", " + to_string(getY()) +  ").\n";
}