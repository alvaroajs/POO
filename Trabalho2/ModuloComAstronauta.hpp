#pragma once
#include "Modulo.hpp"
#include <iostream>

class ModuloComAstronauta : public Modulo{

    public:
        ModuloComAstronauta() : Modulo('A'){};
        bool podeAcessar() override;

};