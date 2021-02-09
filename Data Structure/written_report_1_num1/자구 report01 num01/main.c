#include <stdio.h>


int sorted_Sequential_search(int list[], int n, int key){
	int i, num=1;
	for (i=0; i<n; i++){
		printf("%d\n", num++);
		if (key <= list[i])
			return (key==list[i] ? i : -2);
	}
	return -1;
}

int main(void){

	int result;
	int list[5] = {3, 5, 7, 9, 11};

	result = sorted_Sequential_search(list, 5, 11);
	printf("\n%d \n\n", result);
	
}