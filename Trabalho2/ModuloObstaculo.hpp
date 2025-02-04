#pragma once
#include "Modulo.hpp"

class ModuloObstaculo : public Modulo{

    public:
        ModuloObstaculo() : Modulo('#'){};
        bool podeAcessar() override;
};