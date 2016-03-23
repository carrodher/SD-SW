/*
* Please do not edit this file.
* It was generated using rpcgen.
*/

#include <memory.h> /* for memset */
#include "fssin.h"

/* Default timeout can be changed using clnt_control() */
static struct timeval TIMEOUT = { 25, 0 };

LEER_result * leer_2(char *nom, int offs, int nbytes,  CLIENT *clnt)
{
	leer_2_argument arg;
	static LEER_result clnt_res;

	memset((char *)&clnt_res, 0, sizeof(clnt_res));
	arg.nom = nom;
	arg.offs = offs;
	arg.nbytes = nbytes;
	if (clnt_call (clnt, leer, (xdrproc_t) xdr_leer_2_argument, (caddr_t) &arg,(xdrproc_t) xdr_LEER_result, (caddr_t) &clnt_res,TIMEOUT) != RPC_SUCCESS) {
		return (NULL);
	}
	return (&clnt_res);
}

int * escribir_2(char *nom, int offs, int nbytes, BUF buf,  CLIENT *clnt)
{
	escribir_2_argument arg;
	static int clnt_res;

	memset((char *)&clnt_res, 0, sizeof(clnt_res));
	arg.nom = nom;
	arg.offs = offs;
	arg.nbytes = nbytes;
	arg.buf = buf;
	if (clnt_call (clnt, escribir, (xdrproc_t) xdr_escribir_2_argument, (caddr_t) &arg,(xdrproc_t) xdr_int, (caddr_t) &clnt_res,TIMEOUT) != RPC_SUCCESS) {
		return (NULL);
	}
	return (&clnt_res);
}
