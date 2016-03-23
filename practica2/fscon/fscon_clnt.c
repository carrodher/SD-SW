/*
* Please do not edit this file.
* It was generated using rpcgen.
*/

#include <memory.h> /* for memset */
#include "fscon.h"

/* Default timeout can be changed using clnt_control() */
static struct timeval TIMEOUT = { 25, 0 };

LEER_result *
leer_1(int fd, int nbytes,  CLIENT *clnt)
{
	leer_1_argument arg;
	static LEER_result clnt_res;

	memset((char *)&clnt_res, 0, sizeof(clnt_res));
	arg.fd = fd;
	arg.nbytes = nbytes;
	if (clnt_call (clnt, leer, (xdrproc_t) xdr_leer_1_argument, (caddr_t) &arg,	(xdrproc_t) xdr_LEER_result, (caddr_t) &clnt_res,TIMEOUT) != RPC_SUCCESS) {
		return (NULL);
	}
	return (&clnt_res);
}

int *
escribir_1(int fd, int nbytes, BUF buf,  CLIENT *clnt)
{
	escribir_1_argument arg;
	static int clnt_res;

	memset((char *)&clnt_res, 0, sizeof(clnt_res));
	arg.fd = fd;
	arg.nbytes = nbytes;
	arg.buf = buf;
	if (clnt_call (clnt, escribir, (xdrproc_t) xdr_escribir_1_argument, (caddr_t) &arg,	(xdrproc_t) xdr_int, (caddr_t) &clnt_res,TIMEOUT) != RPC_SUCCESS) {
		return (NULL);
	}
	return (&clnt_res);
}

int *
abrir_1(char *nom,  CLIENT *clnt)
{
	static int clnt_res;

	memset((char *)&clnt_res, 0, sizeof(clnt_res));
	if (clnt_call (clnt, abrir,	(xdrproc_t) xdr_wrapstring, (caddr_t) &nom,	(xdrproc_t) xdr_int, (caddr_t) &clnt_res,TIMEOUT) != RPC_SUCCESS) {
		return (NULL);
	}
	return (&clnt_res);
}

int *
cerrar_1(int fd,  CLIENT *clnt)
{
	static int clnt_res;

	memset((char *)&clnt_res, 0, sizeof(clnt_res));
	if (clnt_call (clnt, cerrar,(xdrproc_t) xdr_int, (caddr_t) &fd,(xdrproc_t) xdr_int, (caddr_t) &clnt_res,TIMEOUT) != RPC_SUCCESS) {
		return (NULL);
	}
	return (&clnt_res);
}
