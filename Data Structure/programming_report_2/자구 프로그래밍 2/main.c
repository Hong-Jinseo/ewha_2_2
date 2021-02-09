#include <stdio.h>			//입출력 헤더파일
#include <stdlib.h>			//exit(), malloc() 관련 헤더파일
#include <string.h>			//string 관련 헤더파일

#define MAX_VERTICES 100	//최대 정점 저장 개수


/* == 스택 == */

typedef int element;
//스택 노드 구조체
typedef struct StackNode{
	element data;
	struct StackNode *link;
} StackNode;

//스택의 관련 데이터
typedef struct{
	StackNode *top;
} StackType;	

//스택 초기화 함수
void stack_init(StackType *s){
	s->top = NULL;
}

//스택 공백상태 검출 함수
int stack_is_empty(StackType *s){
	return (s->top == NULL);
}

//스택 삽입 함수
void push(StackType *s, element item){				//스택과 삽입할 데이터 입력
	StackNode *temp = (StackNode *)malloc(sizeof(StackNode));	//새로운 연결스택 메모리 할당
	if (temp==NULL) {
		fprintf(stderr, "메모리 할당에러\n");
		exit(1);
	}
	else{
		temp->data = item;							//temp의 data에 item값 대입
		temp->link = s->top;						//temp가 가리키는 값에 top이 가리키는 값 대입 
		s->top = temp;								//top이 가리키는 값에 temp 대입
	}
}

//스택 삭제 함수
element pop(StackType *s){
	int item;										//삭제할 스택 data
	if (stack_is_empty(s)){
		fprintf(stderr, "스택이 비어있음 \n");
		exit(1);
	}
	else{
		StackNode *temp = s->top;					//temp가 가리키는 값에 top이 가리키는 값 대입
		item = temp->data;							//item에 temp가 가리키는 값의 데이터 대입
		s->top = s->top->link;						//top이 가리키는 값에 top이 가리키던 노드가 가리키던 값 대입
		free(temp);									//temp의 메모리 반환
		return item;								//삭제한 데이터 반환
	}
}




/* == 큐 == */

//큐 구조체
typedef struct QueueType{
	int front;
	int rear;
	int data[MAX_VERTICES];
} QueueType;	

//큐 초기화 함수
void queue_init(QueueType *q){
	q->front = q->rear = 0;
}

//큐 공백상태 검출 함수
int queue_is_empty(QueueType *q){
	return (q->front == q->rear);
}

//큐 포화상태 검출 함수
int queue_is_full(QueueType *q){
	return (q->rear == MAX_VERTICES-1);
}

//큐 삽입 함수
void enqueue(QueueType *q, element item){
	if(queue_is_full(q)){
		fprintf(stderr, "큐 포화 에러\n");
		exit(1);
	}
	else{
		q->rear = q->rear+1;
		q->data[q->rear] = item;
	}
}

//큐 삭제 함수
element dequeue(QueueType *q){
	if(queue_is_empty(q)){
		fprintf(stderr, "큐 공백 에러\n");
		exit(1);
	}
	else{
		q->front = q->front+1;
		return q->data[q->front];
	}
}


/* == 그래프/ == */

//그래프(DAG) 구조체
typedef struct GraphNode{
	int vertex;					//정점 값
	struct GraphNode *link;		//에지
}GraphNode;

typedef struct GraphType{
	int n;						//정점의 개수
	GraphNode *adj_list[MAX_VERTICES];	//연결된 정점
}GraphType;

//그래프 초기화
void graph_init(GraphType *g){
	int i;
	g->n = 0;
	for(i=0; i<MAX_VERTICES; i++)
		g->adj_list[i] = NULL;
}


/* == 스택을 사용하는 위상 정렬 함수 == */
void topsort_stack(GraphType *g){
	int i, chk=0;		//chk: pop 횟수 기록
	StackType s;		//위상 정렬에 사용할 스택
	GraphNode *node;	//정렬에 필요한 보조 Graph node
	int *keep = (int*)malloc(g->n*sizeof(int));		//정렬된 정점 저장
	int *in_degree =(int*)malloc(g->n*sizeof(int));	//정점의 진입 차수 저장

	for(i=0; i<g->n; i++)
		in_degree[i] = 0;		//정점의 진입 차수 초기화

	for(i=0; i<g->n; i++){
		//정점 i에서 나오는 방향 에지 node에 저장
		GraphNode *node = g->adj_list[i];	
		while(node!=NULL){				//i에서 나오는 방향 에지가 있으면
			in_degree[node->vertex]++;	//정점 node->vertex 진입 차수 증가
			node = node->link;
		}
	}
	
	stack_init(&s);					//스택 초기화
	for(i=0; i<g->n; i++){
		if(in_degree[i]==0){		//진입 차수가 0인 정점을
			push(&s, i);			//스택에 삽입
		}
	}

	//위상 순서를 생성
	while(!stack_is_empty(&s)){		//스택이 비어있지 않을 때
		int w;
		w = pop(&s);
		keep[chk] = w;
		chk++;
		node = g-> adj_list[w];		//각 정점의 진입 차수를 변경

		//인접리스트 검토
		while(node!=NULL){			
			int u = node->vertex;
			in_degree[u]--;			//node 정점의 진입 차수 감소
			if(in_degree[u] == 0)	//node 정점 진입차수 0이면
				push(&s, u);		//스택에 정점 넣기
			node = node->link;		//다음 정점으로 이동
		}
	}

	if(chk!=g->n){					//pop 횟수와 정점 개수가 다르면
		printf("Impossible");
	}
	else{							//같으면
		for(i=0; i<g->n; i++)
			printf("%d ", keep[i]);	//배열 keep에 있는 정렬된 정점 출력
	}
	
	free(keep);
	free(in_degree);

	return;
}


/* == 큐를 사용하는 위상 정렬 함수 == */
void topsort_queue(GraphType *g){
	int i, chk=0;		//chk: pop 횟수 기록
	QueueType q;		//위상 정렬에 사용할 큐
	GraphNode *node;	//정렬에 필요한 보조 Graph node
	int *keep = (int*)malloc(g->n*sizeof(int));		//정렬된 정점 저장
	int *in_degree =(int*)malloc(g->n*sizeof(int));	//정점의 진입 차수 저장

	for(i=0; i<g->n; i++)
		in_degree[i] = 0;		//정점의 진입 차수 초기화

	for(i=0; i<g->n; i++){
		//정점 i에서 나오는 방향 에지 node에 저장
		GraphNode *node = g->adj_list[i];	
		while(node!=NULL){				//i에서 나오는 방향 에지가 있으면
			in_degree[node->vertex]++;	//정점 node->vertex 진입 차수 증가
			node = node->link;
		}
	}

	//스택 초기화
	queue_init(&q);
	for(i=0; i<g->n; i++)
		if(in_degree[i]==0)			//진입 차수가 0인 정점을
			enqueue(&q, i);			//큐에 삽입

	//위상 순서를 생성
	while(!queue_is_empty(&q)){		//큐가 비어있지 않을 때
		int w;
		w = dequeue(&q);
		keep[chk] = w;
		chk++;
		node = g-> adj_list[w];		//각 정점의 진입 차수를 변경

		//인접리스트 검토
		while(node!=NULL){
			int u = node->vertex;
			in_degree[u]--;			//node 정점의 진입 차수 감소
			if(in_degree[u] == 0)	//node 정점 진입차수 0이면
				enqueue(&q, u);		//스택에 정점 넣기
			node = node->link;		//다음 정점으로 이동
		}
	}

	if(chk!=g->n){					//pop 횟수와 정점 개수가 다르면
		printf("Impossible");
	}
	else{							//같으면
		for(i=0; i<g->n; i++)
			printf("%d ", keep[i]);	//배열 keep에 있는 정렬된 정점 출력
	}

	free(keep);
	free(in_degree);

	return;
}


/* == 그래프에 간선 삽입하는 함수 == */
void insert_edge(GraphType *g,int u,int v){ 
	int i;
	GraphNode *node = (GraphNode *)malloc(sizeof(GraphNode));
	GraphNode *p = (GraphNode *)malloc(sizeof(GraphNode));

    if(u>=g->n || v>=g->n){			//정점 값이 정점 개수보다 크다면
        printf("정점 번호 오류 \n"); 
        exit(-1); 
    } 

    if(!node){ 
        printf("메모리 할당 오류 \n"); 
        exit(-1); 
    } 

    node->vertex = v;				//새로 삽입할 노드의 vertex값 입력
    node->link = NULL;				//새로 삽입할 노드의 link 초기화
	
	if(g->adj_list[u]==NULL)		//출발 노드에 연결된 노드 없는 경우
		g->adj_list[u] = node;
	else{
		p->link = g->adj_list[u];	//다른 노드가 연결되어 있는 경우
		while(p->link->link!=NULL)	//연결된 마지막 노드까지 이동
			p->link = p->link->link;
		p->link->link = node;		//마지막 노드 뒤에 새로운 노드 연결
	}
}


/* == 메인 함수 == */
int main() {
	int vertex_size, edge_size, i, t, num1, num2;
	GraphType g;

	//파일 경로 저장한 배열
	char filePath[5][14] = {"dag\\dag1.txt", "dag\\dag2.txt", "dag\\dag3.txt", "dag\\dag4.txt", "dag\\dag5.txt"};
	
	for(t=0; t<5; t++){
		FILE *file = fopen(filePath[t],"r");	//읽기 전용 형식으로 파일 열기
		
		graph_init(&g);						//그래프 초기화

		if (file==NULL){
			printf("파일 열기 실패\n");
			return -1;
		}

		fscanf(file, "%d", &vertex_size);	//첫번째 숫자 vertex_size에 넣기
		fscanf(file, "%d", &edge_size);		//두번째 숫자 edge_size에 넣기

		g.n = vertex_size;					//그래프 정점 개수
	
		// DAG 입력받아서 위상 정렬하기 위한 자료구조로 변환
		for(i=0; i<edge_size; i++){
			num1 = num2 = NULL;			
			fscanf(file, "%d", &num1);
			fscanf(file, "%d", &num2);
			insert_edge(&g, num1, num2);
		}
	
		printf("스택 사용 위상정렬 결과 = ");
		topsort_stack(&g);
		printf("\n");
	
		printf("큐 사용 위상정렬 결과 = ");
		topsort_queue(&g);
		printf("\n\n");

		fclose(file);
	}
}