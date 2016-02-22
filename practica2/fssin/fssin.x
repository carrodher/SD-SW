const BUF_SIZE=1024;
const MAX_PATH=256;

typedef opaque BUF<BUF_SIZE>;

struct LEER_result {
  int cod_error;
  BUF datos;
  };

program FSSIN {
   version SIN {

      LEER_result leer (string nom<MAX_PATH>, int offs, int nbytes)= 1;



      int escribir (string nom<MAX_PATH>, int offs, int nbytes, BUF buf)= 2;


   } = 2;
} = 999999992;
 
