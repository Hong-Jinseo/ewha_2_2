#include <stdio.h>
#define max(a,b)  (((a) > (b)) ? (a) : (b))

typedef struct Avl_node{
	struct Avl_node *left, *right;
	int data, df;
} Avl_node;

int get_height(Avl_node *node){
	int height=0;
	if (node != NULL)
		height = 1 + max(get_height(node->left), get_height(node->right));
	return height;
}

//근데 avl의 높이 h는 

void main(){

	Avl_node *root;



}