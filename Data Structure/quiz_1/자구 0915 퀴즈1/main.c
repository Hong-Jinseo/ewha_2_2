#include <stdio.h>
#include <time.h>

int fib(int n)	{
	if (n==0) return 0;
	if (n==1) return 1;
	return (fib(n-1) + fib(n-2));
}

void main(){
	int n=0, fn=0;
	double sec=0;
	const int INT_MAX = 2147483647; //2^31-1
	clock_t start, end;

	while((fn>=0 && fn<=INT_MAX) && (sec<180)){
		start = clock();
		fn = fib(++n);
		end = clock();
		sec = (end-start)/1000;
	}

	start = clock();
	fn = fib(n-1);
	end = clock();
	sec = (end-start)/1000;

	printf("n값 : %d \n", n-1);
	printf("fn값 : %d \n", fn);
	printf("시간 : %lf초 \n\n", sec);
}