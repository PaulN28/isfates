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

//char

	char a = 0;

	while(a >= 0){
		a++;
	};
	printf("Min char : %d\n", a);
	printf("Max char : %d\n", --a);
	printf("limits.h char MIN: %d\n", CHAR_MIN);
	printf("limits.h char MAX: %d\n\n", CHAR_MAX);

//int

	int b = 0;

	while(b >= 0){
		b++;
	};
	printf("Min int : %d\n", b);
	printf("Max int : %d\n", --b);
	printf("limits.h int MIN: %d\n", INT_MIN);
	printf("limits.h int MAX: %d\n\n", INT_MAX);

//short
	short c = 0;

	while(c >= 0){
		c++;
	};
	printf("Min short : %d\n", c);
	printf("Max short : %d\n", --c);
	printf("limits.h short MIN: %d\n", SHRT_MIN);
	printf("limits.h short MAX: %d\n\n", SHRT_MAX);


//------------------unsigned------------------

//unsigned char

	unsigned char e = 0;
	printf("Max unsigned char : %d\n", --e);
	printf("limits.h Unsigned Char MAX: %d\n\n", UCHAR_MAX);


//unsigned int

	unsigned int f = 0;
	printf("Max unsigned int : %u\n", --f);
	printf("limits.h Unsigned Int MAX: %u\n\n", UINT_MAX);

//unsigned short

	unsigned short d = 0;
	printf("Max unsigned short : %d\n", --d);
	printf("limits.h Unsigned Short MAX: %d \n\n", USHRT_MAX);
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
