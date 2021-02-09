#include <stdio.h>			//����� �������
#include <stdlib.h>			//exit(), malloc() ���� �������
#include <string.h>			//string ���� �������

#define MAX_VERTICES 100	//�ִ� ���� ���� ����


/* == ���� == */

typedef int element;
//���� ��� ����ü
typedef struct StackNode{
	element data;
	struct StackNode *link;
} StackNode;

//������ ���� ������
typedef struct{
	StackNode *top;
} StackType;	

//���� �ʱ�ȭ �Լ�
void stack_init(StackType *s){
	s->top = NULL;
}

//���� ������� ���� �Լ�
int stack_is_empty(StackType *s){
	return (s->top == NULL);
}

//���� ���� �Լ�
void push(StackType *s, element item){				//���ð� ������ ������ �Է�
	StackNode *temp = (StackNode *)malloc(sizeof(StackNode));	//���ο� ���ὺ�� �޸� �Ҵ�
	if (temp==NULL) {
		fprintf(stderr, "�޸� �Ҵ翡��\n");
		exit(1);
	}
	else{
		temp->data = item;							//temp�� data�� item�� ����
		temp->link = s->top;						//temp�� ����Ű�� ���� top�� ����Ű�� �� ���� 
		s->top = temp;								//top�� ����Ű�� ���� temp ����
	}
}

//���� ���� �Լ�
element pop(StackType *s){
	int item;										//������ ���� data
	if (stack_is_empty(s)){
		fprintf(stderr, "������ ������� \n");
		exit(1);
	}
	else{
		StackNode *temp = s->top;					//temp�� ����Ű�� ���� top�� ����Ű�� �� ����
		item = temp->data;							//item�� temp�� ����Ű�� ���� ������ ����
		s->top = s->top->link;						//top�� ����Ű�� ���� top�� ����Ű�� ��尡 ����Ű�� �� ����
		free(temp);									//temp�� �޸� ��ȯ
		return item;								//������ ������ ��ȯ
	}
}




/* == ť == */

//ť ����ü
typedef struct QueueType{
	int front;
	int rear;
	int data[MAX_VERTICES];
} QueueType;	

//ť �ʱ�ȭ �Լ�
void queue_init(QueueType *q){
	q->front = q->rear = 0;
}

//ť ������� ���� �Լ�
int queue_is_empty(QueueType *q){
	return (q->front == q->rear);
}

//ť ��ȭ���� ���� �Լ�
int queue_is_full(QueueType *q){
	return (q->rear == MAX_VERTICES-1);
}

//ť ���� �Լ�
void enqueue(QueueType *q, element item){
	if(queue_is_full(q)){
		fprintf(stderr, "ť ��ȭ ����\n");
		exit(1);
	}
	else{
		q->rear = q->rear+1;
		q->data[q->rear] = item;
	}
}

//ť ���� �Լ�
element dequeue(QueueType *q){
	if(queue_is_empty(q)){
		fprintf(stderr, "ť ���� ����\n");
		exit(1);
	}
	else{
		q->front = q->front+1;
		return q->data[q->front];
	}
}


/* == �׷���/ == */

//�׷���(DAG) ����ü
typedef struct GraphNode{
	int vertex;					//���� ��
	struct GraphNode *link;		//����
}GraphNode;

typedef struct GraphType{
	int n;						//������ ����
	GraphNode *adj_list[MAX_VERTICES];	//����� ����
}GraphType;

//�׷��� �ʱ�ȭ
void graph_init(GraphType *g){
	int i;
	g->n = 0;
	for(i=0; i<MAX_VERTICES; i++)
		g->adj_list[i] = NULL;
}


/* == ������ ����ϴ� ���� ���� �Լ� == */
void topsort_stack(GraphType *g){
	int i, chk=0;		//chk: pop Ƚ�� ���
	StackType s;		//���� ���Ŀ� ����� ����
	GraphNode *node;	//���Ŀ� �ʿ��� ���� Graph node
	int *keep = (int*)malloc(g->n*sizeof(int));		//���ĵ� ���� ����
	int *in_degree =(int*)malloc(g->n*sizeof(int));	//������ ���� ���� ����

	for(i=0; i<g->n; i++)
		in_degree[i] = 0;		//������ ���� ���� �ʱ�ȭ

	for(i=0; i<g->n; i++){
		//���� i���� ������ ���� ���� node�� ����
		GraphNode *node = g->adj_list[i];	
		while(node!=NULL){				//i���� ������ ���� ������ ������
			in_degree[node->vertex]++;	//���� node->vertex ���� ���� ����
			node = node->link;
		}
	}
	
	stack_init(&s);					//���� �ʱ�ȭ
	for(i=0; i<g->n; i++){
		if(in_degree[i]==0){		//���� ������ 0�� ������
			push(&s, i);			//���ÿ� ����
		}
	}

	//���� ������ ����
	while(!stack_is_empty(&s)){		//������ ������� ���� ��
		int w;
		w = pop(&s);
		keep[chk] = w;
		chk++;
		node = g-> adj_list[w];		//�� ������ ���� ������ ����

		//��������Ʈ ����
		while(node!=NULL){			
			int u = node->vertex;
			in_degree[u]--;			//node ������ ���� ���� ����
			if(in_degree[u] == 0)	//node ���� �������� 0�̸�
				push(&s, u);		//���ÿ� ���� �ֱ�
			node = node->link;		//���� �������� �̵�
		}
	}

	if(chk!=g->n){					//pop Ƚ���� ���� ������ �ٸ���
		printf("Impossible");
	}
	else{							//������
		for(i=0; i<g->n; i++)
			printf("%d ", keep[i]);	//�迭 keep�� �ִ� ���ĵ� ���� ���
	}
	
	free(keep);
	free(in_degree);

	return;
}


/* == ť�� ����ϴ� ���� ���� �Լ� == */
void topsort_queue(GraphType *g){
	int i, chk=0;		//chk: pop Ƚ�� ���
	QueueType q;		//���� ���Ŀ� ����� ť
	GraphNode *node;	//���Ŀ� �ʿ��� ���� Graph node
	int *keep = (int*)malloc(g->n*sizeof(int));		//���ĵ� ���� ����
	int *in_degree =(int*)malloc(g->n*sizeof(int));	//������ ���� ���� ����

	for(i=0; i<g->n; i++)
		in_degree[i] = 0;		//������ ���� ���� �ʱ�ȭ

	for(i=0; i<g->n; i++){
		//���� i���� ������ ���� ���� node�� ����
		GraphNode *node = g->adj_list[i];	
		while(node!=NULL){				//i���� ������ ���� ������ ������
			in_degree[node->vertex]++;	//���� node->vertex ���� ���� ����
			node = node->link;
		}
	}

	//���� �ʱ�ȭ
	queue_init(&q);
	for(i=0; i<g->n; i++)
		if(in_degree[i]==0)			//���� ������ 0�� ������
			enqueue(&q, i);			//ť�� ����

	//���� ������ ����
	while(!queue_is_empty(&q)){		//ť�� ������� ���� ��
		int w;
		w = dequeue(&q);
		keep[chk] = w;
		chk++;
		node = g-> adj_list[w];		//�� ������ ���� ������ ����

		//��������Ʈ ����
		while(node!=NULL){
			int u = node->vertex;
			in_degree[u]--;			//node ������ ���� ���� ����
			if(in_degree[u] == 0)	//node ���� �������� 0�̸�
				enqueue(&q, u);		//���ÿ� ���� �ֱ�
			node = node->link;		//���� �������� �̵�
		}
	}

	if(chk!=g->n){					//pop Ƚ���� ���� ������ �ٸ���
		printf("Impossible");
	}
	else{							//������
		for(i=0; i<g->n; i++)
			printf("%d ", keep[i]);	//�迭 keep�� �ִ� ���ĵ� ���� ���
	}

	free(keep);
	free(in_degree);

	return;
}


/* == �׷����� ���� �����ϴ� �Լ� == */
void insert_edge(GraphType *g,int u,int v){ 
	int i;
	GraphNode *node = (GraphNode *)malloc(sizeof(GraphNode));
	GraphNode *p = (GraphNode *)malloc(sizeof(GraphNode));

    if(u>=g->n || v>=g->n){			//���� ���� ���� �������� ũ�ٸ�
        printf("���� ��ȣ ���� \n"); 
        exit(-1); 
    } 

    if(!node){ 
        printf("�޸� �Ҵ� ���� \n"); 
        exit(-1); 
    } 

    node->vertex = v;				//���� ������ ����� vertex�� �Է�
    node->link = NULL;				//���� ������ ����� link �ʱ�ȭ
	
	if(g->adj_list[u]==NULL)		//��� ��忡 ����� ��� ���� ���
		g->adj_list[u] = node;
	else{
		p->link = g->adj_list[u];	//�ٸ� ��尡 ����Ǿ� �ִ� ���
		while(p->link->link!=NULL)	//����� ������ ������ �̵�
			p->link = p->link->link;
		p->link->link = node;		//������ ��� �ڿ� ���ο� ��� ����
	}
}


/* == ���� �Լ� == */
int main() {
	int vertex_size, edge_size, i, t, num1, num2;
	GraphType g;

	//���� ��� ������ �迭
	char filePath[5][14] = {"dag\\dag1.txt", "dag\\dag2.txt", "dag\\dag3.txt", "dag\\dag4.txt", "dag\\dag5.txt"};
	
	for(t=0; t<5; t++){
		FILE *file = fopen(filePath[t],"r");	//�б� ���� �������� ���� ����
		
		graph_init(&g);						//�׷��� �ʱ�ȭ

		if (file==NULL){
			printf("���� ���� ����\n");
			return -1;
		}

		fscanf(file, "%d", &vertex_size);	//ù��° ���� vertex_size�� �ֱ�
		fscanf(file, "%d", &edge_size);		//�ι�° ���� edge_size�� �ֱ�

		g.n = vertex_size;					//�׷��� ���� ����
	
		// DAG �Է¹޾Ƽ� ���� �����ϱ� ���� �ڷᱸ���� ��ȯ
		for(i=0; i<edge_size; i++){
			num1 = num2 = NULL;			
			fscanf(file, "%d", &num1);
			fscanf(file, "%d", &num2);
			insert_edge(&g, num1, num2);
		}
	
		printf("���� ��� �������� ��� = ");
		topsort_stack(&g);
		printf("\n");
	
		printf("ť ��� �������� ��� = ");
		topsort_queue(&g);
		printf("\n\n");

		fclose(file);
	}
}