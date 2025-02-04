#pragma once
#include "Modulo.hpp"

class ModuloNormal : public Modulo{

    public:
        ModuloNormal() : Modulo('.'){};
        bool podeAcessar() override;
};