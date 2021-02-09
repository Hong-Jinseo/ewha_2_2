#include <stdio.h>
#define MAX_DEGREE 10

typedef struct {
	int degree;
	int coef[MAX_DEGREE];
} polynomial;

int poly_eval(polynomial p, int x) {
	int degree = p.degree;
	int result=0, temp, i, j;
	int check=1;

	for (i=0; i<=p.degree; i++){
		temp = 1;
		for (j=0; j<degree; j++){
			temp *= x;
			//printf("%d \n", check++);
		}
		result += temp*p.coef[i];
		//printf("%d \n", check++);
		degree--;
	}
	return result;
}

void main(){
	int t;
	polynomial a = {5, {10, 0, 0, 0, 6, 3} };
	printf("%d \n\n", poly_eval(a, 3));
}