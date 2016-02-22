const BUF_SIZE=1024;
const MAX_PATH=256;

typedef opaque BUF<BUF_SIZE>;

struct LEER_result {
  int cod_error;
  BUF datos;
  };

program FSCON {
   version CON {
      LEER_result leer(int fd, int nbytes) = 1;
      int escribir(int fd, int nbytes, BUF buf) = 2;
      int abrir(string nom<MAX_PATH>) = 3;
      int cerrar(int fd) = 4;
   } = 1;
} = 999999991;
 
