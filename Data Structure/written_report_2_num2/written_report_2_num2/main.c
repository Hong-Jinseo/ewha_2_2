#include <stdio.h>


void main(){

	int i, cnt=0;
	int arr[4] = {1,1, 0, 0};
	
	int head, tail, temp;
	

	head = 0;
	tail = sizeof(arr)/sizeof(int)-1;
	
	while(1){
		cnt++;
		while(arr[head]==0){
			head++;
			cnt++;
			cnt++;
		}
		
		cnt++;
		while(arr[tail]==1){
			tail--;
			cnt++;
			cnt++;
		}

		cnt++;
		if(head<tail){
			temp = arr[head];
			arr[head] = arr[tail];
			arr[tail] = temp;
			cnt++;
			cnt++;
			cnt++;

			
		}
		else
			break;
	}


	for (i=0; i<sizeof(arr)/sizeof(int); i++)
		printf("%d ", arr[i]);
	printf("\n");
	printf("%d \n", cnt);
}


