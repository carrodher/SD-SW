#include "calcular.h"

int main (int argc, char **argv)
{
	char *host;
	CLIENT *sv;
	int *res;
	int *sum1;
	int *sum2;

	if (argc!=4){
		printf("Uso: %s host sumando1 sumando2\n", argv[0]);
	}
	else
	{
		host = argv[1];
		sum1 = atoi(argv[2]);
		sum2 = atoi(argv[3])

		sv = clnt_create(host, CALCULAR, UNO, "tcp");
		if (sv != NULL)
		{
			res = sumar_1(sum1,sum2,sv);
			if (res != NULL) {
				printf("%d + %d = %d\n", sum1, sum2, *res);
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
