#!/bin/bash

cd observador
make clean
make all

cd ../centralita
make all

cd ../observador
make observador

cd ../centralita
make centralita

cd ../cliente
make all
