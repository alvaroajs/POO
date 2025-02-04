#include "Modulo.hpp"
#pragma once

class ModuloVazio : public Modulo{
    public:
        ModuloVazio() : Modulo('~'){};
        bool podeAcessar() override;
};