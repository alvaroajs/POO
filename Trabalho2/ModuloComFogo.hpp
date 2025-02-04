#pragma once
#include <iostream>
#include "Modulo.hpp"

class ModuloComFogo : public Modulo{

    public:
        ModuloComFogo() : Modulo('F'){};
        bool podeAcessar() override;

};