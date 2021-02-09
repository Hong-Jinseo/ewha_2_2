#include <stdio.h>
#include <stdlib.h>

typedef int element;
typedef struct _ListNode{
	element data;
	struct _ListNode *Link;
} ListNode;

ListNode *h_concatenate(ListNode *chead1, ListNode *chead2) {
	ListNode *p;
	if (chead1==NULL)
		return chead2;
	else if (chead2==NULL)
		return chead1;
	else{
		p = chead1->Link;
		chead1->Link = chead2->Link->Link; 
		chead2->Link = p;
		return chead2;
	}
}


void main(){
	int i;
	ListNode *p1, *p2, *p3, *p4, *p5, *p6, *p;

	p1 = (ListNode *)malloc(sizeof(ListNode));
	p1->data = 12345;
	p1->Link = NULL;

	p2 = (ListNode *)malloc(sizeof(ListNode));
	p2->data = 20;
	p2->Link = NULL;
	
	p3 = (ListNode *)malloc(sizeof(ListNode));
	p3->data = 30;
	p3->Link = NULL;

	p4 = (ListNode *)malloc(sizeof(ListNode));
	p4->data = 6789;
	p4->Link = NULL;

	p5 = (ListNode *)malloc(sizeof(ListNode));
	p5->data = 50;
	p5->Link = NULL;

	p6 = (ListNode *)malloc(sizeof(ListNode));
	p6->data = 60;
	p6->Link = NULL;

	p1->Link = p2;
	p2->Link = p3;
	p3->Link = p1;
	p4->Link = p5;
	p5->Link = p6;
	p6->Link = p4;


	p = h_concatenate(p3, p6);

	for(i=0; i<13; i++) { 
		printf("%d -> ", p->data);
		p=p->Link;
	}
}
