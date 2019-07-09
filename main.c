#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

void ticket(){
	float nettoPreis, brutoPreis, mwst, skonto, rechnungsbetrag;

	printf("\nNettopreis eingeben: \n");
	scanf("%f", &nettoPreis);

	mwst = nettoPreis * 0.2;
	brutoPreis = nettoPreis * 1.2;
	skonto = brutoPreis * 0.02;
	rechnungsbetrag = brutoPreis * 0.98;

	printf(	"\n\n\tNettopreis Euro %.2f \n"
	     	"\t+ 20%% MwSt Euro %.2f \n"
		    "\t===================================== \n"
		    "\tBruttopreis Euro %.2f \n"
		    "\t- 2%% Skonto Euro %.2f \n"
		    "\t===================================== \n"
		    "\tRechnungsbetrag Euro %.2f\n\n\n", nettoPreis, mwst, brutoPreis, skonto, rechnungsbetrag
		    );
}

void fibonacci(int n){

	long current = 1;
	long previous = 0;
	const long max_fib_long = 7540113804746346429;

	printf("%ld\n", previous);

	for (int i = 0; i < n - 1; ++i)
	{
		if(previous == max_fib_long){
			printf("Cannot represent any longer integer with the long type ...\n");
			break;
		}
		printf("%ld \n", current);

		long aux = current;
		current = aux + previous;
		previous = aux;
	}
}

void limits()
{
	printf("Minimum Signed Char %d\n",-(char)((unsigned char) ~0 >> 1) - 1);
    printf("Maximum Signed Char %d\n",(char) ((unsigned char) ~0 >> 1));
    printf("limits.h Signed Char MAX %d\n", CHAR_MAX);
    printf("limits.h Signed Char MIN %d\n\n", CHAR_MIN);


    printf("Minimum Signed Short %d\n",-(short)((unsigned short)~0 >>1) -1);
    printf("Maximum Signed Short %d\n",(short)((unsigned short)~0 >> 1));
    printf("limits.h Signed Short MAX %d\n", SHRT_MAX);
	printf("limits.h Signed Short MIN %d\n\n", SHRT_MIN);

    printf("Minimum Signed Int %d\n",-(int)((unsigned int)~0 >> 1) -1);
    printf("Maximum Signed Int %d\n",(int)((unsigned int)~0 >> 1));
    printf("limits.h Signed Int MAX %d\n", INT_MAX);
    printf("limits.h Signed Int MIN %d\n\n", INT_MIN);

    printf("Minimum Signed Long %ld\n",-(long)((unsigned long)~0 >>1) -1);
    printf("Maximum signed Long %ld\n",(long)((unsigned long)~0 >> 1));
    printf("limits.h Signed Long MAX %ld\n", LONG_MAX);
    printf("limits.h Signed Long MIN %ld\n\n", LONG_MIN);

    /* Unsigned Maximum Values */

    printf("Maximum Unsigned Char %d\n",(unsigned char)~0);
    printf("Maximum Unsigned Short %d\n",(unsigned short)~0);
    printf("limits.h Unsigned Char MAX %d\n", UCHAR_MAX);
    printf("limits.h Unsigned Short MIN %d\n\n", USHRT_MAX);

    printf("Maximum Unsigned Int %u\n",(unsigned int)~0);
    printf("Maximum Unsigned Long %lu\n",(unsigned long)~0);
    printf("limits.h Unsigned Int MAX %d\n", UINT_MAX);
    printf("limits.h Unsigned Long MAX %ld\n\n", ULONG_MAX);
}

int main()
{
	int userInput;

	do{

		printf("\n1. Ticket\n2. Fibonacci\n3. Limits\n\n0. Quit\n");
		printf("\nChoice: ");
		scanf("%d", &userInput);

		switch(userInput){

		//------ticket------

			case 1: 	printf("\nAufgabe 1: Ticket \n ");
						ticket();
						break;

		//------fibonacci------

			case 2: 	printf("\nAufgabe 2: Fibonacci \n\n");
						printf("Input n: ");
						int input;
						scanf("%d", &input);
						printf("\n");
						fibonacci(input);
						break;

		//------limits------

			case 3:		printf("\nAufgabe 3: Limits \n\n");
						limits();
						break;
		}
	}
	while(userInput != 0);

	exit(userInput);

	return 0;
}
