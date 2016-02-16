#include "calcular.h"

int main (int argc, char **argv)
{
	char *host;
	CLIENT *sv;
	int *res;
	int oper1;
	int oper2;

	if (argc != 5)
		printf("Uso: %s <host> <operador1> <operador2> <r/s/m>\n", argv[0]);
	else
	{
		host = argv[1];
		oper1 = atoi(argv[2]);
		oper2 = atoi(argv[3]);

		sv = clnt_create(host, CALCULAR, UNO, "tcp");
		if (sv != NULL)
		{
			if (strcmp(argv[4], "s") == 0)
			{
				res = sumar_1(oper1,oper2,sv);
				if (res != NULL)
					printf("%d + %d = %d\n", oper1, oper2, *res);
				else
					clnt_perror(sv, "error en RPC");
				clnt_destroy(sv);
			}
			else if (strcmp(argv[4], "r") == 0)
			{
				res = restar_1(oper1,oper2,sv);
				if (res != NULL)
					printf("%d - %d = %d\n", oper1, oper2, *res);
				else
					clnt_perror(sv, "error en RPC");
				clnt_destroy(sv);
			}
			else if (strcmp(argv[4], "m") == 0)
			{
				res = multiplicar_1(oper1,oper2,sv);
				if (res != NULL)
					printf("%d x %d = %d\n", oper1, oper2, *res);
				else
					clnt_perror(sv, "error en RPC");
				clnt_destroy(sv);
			}
			else
			{
				printf("Hay que introducir: r/s/m \n");
				clnt_destroy(sv);
			}
		}
		else
			clnt_pcreateerror(host);
	}
	return (0);
}