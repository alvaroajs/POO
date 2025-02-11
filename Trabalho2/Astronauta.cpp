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
    cout << x << endl;
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
    return "- " + nome + ": Saude: " + to_string(getNivelSaude()) +  ", Atendimento Médico Urgente: " + (isAtendimentoUrgente() ? "Sim" : "Não") +  ", Posicao: (" + to_string(getX()) + ", " + to_string(getY()) +  ").\n";
}
string Astronauta::getDetalhes(){
    return "- " + nome + ": Saude: " + to_string(getNivelSaude()) +  ", Atendimento Médico Urgente: " + (isAtendimentoUrgente() ? "Sim" : "Não") +  ", Posicao: (" + to_string(getX()) + ", " + to_string(getY()) +  ").\n";
}