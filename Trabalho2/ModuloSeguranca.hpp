#pragma once
#include "Modulo.hpp"

class ModuloSeguranca : public Modulo{
    public:
        ModuloSeguranca() : Modulo('S'){};
        bool podeAcessar() override;
};