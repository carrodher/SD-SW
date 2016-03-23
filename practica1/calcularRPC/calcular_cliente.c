#include "calcular.h"

int main (int argc, char **argv)
{
	char *host;
	CLIENT *sv;
	int *res;
	if (argc!=2){
		printf("Uso: %s <host>\n", argv[0]);
	}
	else
	{
		host = argv[1];
		sv = clnt_create(host, CALCULAR, UNO, "tcp");
		if (sv != NULL)
		{
			res = sumar_1(5,2,sv);
			if (res != NULL){
				printf("5+2 = %d\n", *res);
			}
			else {
				clnt_perror(sv, "error en RPC");
			}
			clnt_destroy(sv);
		}
		else{
			clnt_pcreateerror(host);
		}
	}
	return (0);
}
