#include <stdio.h>			//입출력 헤더파일
#include <stdlib.h>			//exit(), malloc() 관련 헤더파일
#include <string.h>			//string 관련 헤더파일
#define MAX_LEN 100			//입력받을 수 있는 수식 최대 길이
#define MAX_STACK_SIZE 20	//스택의 최대 크기



/**** 중위 표기식을 후위 표기식으로 변환 ****/

//배열을 이용한 스택 구조체 선언
typedef int element;
typedef struct{
	element stack[MAX_STACK_SIZE];
	int top;
}StackType;

//배열스택 초기화 함수
void arr_init(StackType *s){
	s->top = -1;
}

//배열스택 공백상태 검출 함수
int arr_is_empty(StackType *s){
	return (s->top == -1);
}

//배열스택 포화상태 검출 함수
int arr_is_full(StackType *s){
	return (s->top == (MAX_STACK_SIZE-1));
}

//배열스택 삽입 함수
void arr_push(StackType *s, element item){
	if(arr_is_full(s)){								//배열이 포화 상태라면 에러
		fprintf(stderr, "스택 포화 에러\n");
		return;
	}
	else											//포화 상태가 아니라면
		s->stack[++(s->top)] = item;				//스택 top값 증가시키고 item 대입
}

//배열스택 삭제 함수
element arr_pop(StackType *s){
	if(arr_is_empty(s)){							//배열이 공백 상태라면 에러
		fprintf(stderr, "스택 공백 에러 1\n");
		exit(1);
	}
	else											//공백 상태가 아니라면
		return s->stack[(s->top)--];				//스택 top값 1칸 감소
}

//배열스택 피크 함수
element arr_peek(StackType *s){
	if(arr_is_empty(s)){							//배열이 공백 상태라면 에러
		fprintf(stderr, "스택 공백 에러 2\n");
		exit(1);
	}
	else											//공백 상태가 아니라면
		return s->stack[s->top];					//스택의 top이 가리키는 값 반환
}

//중위 표기식 출력 함수
void print_infix(char exp[]){						//배열을 입력받음
	int i;
	printf("infix notation = ");
	for (i=0; i<strlen(exp); i++){					//입력받은 배열의 길이만큼 반복
		printf("%c ", exp[i]);						//배열 출력
	}
}

//중위 표기 수식 -> 후위 표기 수식 변환 함수
void infix_to_postfix(char exp[]){					//배열 입력받음
	int i=0, j=0;
	//ch:스캔한 문자. ch_temp:스택의 pop값 임시저장.
	//top_op: 스택의 상단 연산자. keep[]:변환된 수식 임시저장
	char ch, ch_temp, top_op, keep[MAX_LEN];
	int len = strlen(exp);							//입력받은 배열의 길이 저장
	StackType s;									//연산자를 저장할 배열스택 선언

	arr_init(&s);									//스택 초기화
	arr_push(&s, '#');								//스택이 비어있지 않도록 하는 연산자

	if (exp[0]>='0' && exp[0]<='9' && exp[1]==';')	//수식이 피연산자 하나일 경우
		printf("\n");								//출력시 줄맞춤을 위해 \n 삽입
	
	printf("\bpostfix notation = ");
	
	for (i=0; i<len-1; i++){
		ch = exp[i];		//배열에서 스캔한 값을 순서대로 대입
		switch(ch){
		case '+': case '-': case '*': case '/': case '^': case '%':		//ch가 연산자일 경우
			//배열이 공백 상태가 아니고, ICP가 ISP보다 크다면
			while (!arr_is_empty(&s) && (icp(ch) <= isp(arr_peek(&s)))){
				ch_temp = arr_pop(&s);				//스택의 상단값 삭제 후 ch_temp에 저장
				printf("%c ", ch_temp);				//스택의 상단값 출력
				keep[j++] = ch_temp;				//스택의 상단값 keep배열에 저장
			}
			arr_push(&s, ch);						//ch값 스택에 저장
			break;
		case '(':									//ch가 왼쪽 괄호라면
			arr_push(&s, ch);						//ch값 스택에 저장
			break;
		case ')':									//ch가 오른쪽 괄호라면
			top_op = arr_pop(&s);					//top_op에 스택의 상단 연산자 저장
			while(top_op != '('){					//스택 상단값이 왼쪽 괄호가 될 때까지 반복
				printf("%c ", top_op);				//스택의 상단값 출력
				keep[j++] = top_op;					//스택의 상단값 keep 배열에 저장
				top_op = arr_pop(&s);				//top_op에 스택의 상단 연산자 저장 (while문 반복)
			}			
			break;
		case ';':									//ch가 수식의 끝을 나타내는 세미콜론(;)인 경우
			break;
		default:									//위 사례에 해당하지 않는 경우(=피연산자)
			printf("%c ", ch);						//ch값 출력
			keep[j++] = ch;							//ch값 keep배열에 저장
			break;
		}
	}
	printf("\b ");									//출력 시 줄맞춤을 위한 backspace
	while(!arr_is_empty(&s) && arr_peek(&s)!='#'){	//스택 상단 값이 '#'가 아니라면
		ch_temp = arr_pop(&s);						//ch_tmep에 스택 상단값 저장
		printf("%c ", ch_temp);						//스택의 상단값 출력
		keep[j++] = ch_temp;						//스택의 상단값 keep 배열에 저장
	}
	printf(";\n");									//수식의 끝을 의미하는 세미콜론(;) 출력
	keep[j] = NULL;									//keep배열의 끝에 NULL 삽입
	strcpy(exp, keep);								//keep배열값을 복사해 exp배열에 넣음
}



/**** 후위 표기식 계산 ****/

//연결 스택 정의
typedef struct StackNode{
	element data;
	struct StackNode *link;
} StackNode;

//연결 스택의 관련 데이터
typedef struct {
	StackNode *top;
} LinkedStackType;	

//연결스택 초기화 함수
void linked_init(LinkedStackType *s){
	s->top = NULL;
}

//연결스택 공백상태 검출 함수
int linked_is_empty(LinkedStackType *s){
	return (s->top == NULL);
}

//연결스택 삽입 함수
void linked_push(LinkedStackType *s, element item){				//스택과 삽입할 데이터 입력
	StackNode *temp = (StackNode *)malloc(sizeof(StackNode));	//새로운 연결스택 메모리 할당
	if (temp==NULL) {
		fprintf(stderr, "메모리 할당에러\n");
		return;
	}
	else{
		temp->data = item;							//temp의 data에 item값 대입
		temp->link = s->top;						//temp가 가리키는 값에 top이 가리키는 값 대입 
		s->top = temp;								//top이 가리키는 값에 temp 대입
	}
}

//연결스택 삭제 함수
element linked_pop(LinkedStackType *s){
	int item;						//삭제할 스택 data
	if (linked_is_empty(s)){
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

//후위표기식 계산 함수
int eval(char exp[]){								//배열 입력받음
	int op1, op2, value, i=0;						//op:피연산자 저장. value:계산 결과 저장
	int len = strlen(exp);							//입력받은 배열의 길이 .
	char ch;										//스캔한 문자
	LinkedStackType s;								//피연산자를 저장할 연결 스택

	linked_init(&s);								//스택 초기화
				
	for(i=0; i<len; i++){
		ch = exp[i];								//배열에서 스캔한 값을 순서대로 대입
		//ch가 연산자가 아니라면 (피연산자라면)
		if(ch!='+' && ch!='-' && ch!='*' && ch!='/' && ch!='^' && ch!='%'){
			value = ch-'0';							//아스키코드값을 뺴 줌으로써 정수형 숫자로 바꿈
			linked_push(&s, value);					//피연산자 스택에 value 저장
		}

		else {										//ch가 연산자라면
			op2 = linked_pop(&s);					//op2에 피연산자 스택의 상단값 저장(스택에서 삭제)
			op1 = linked_pop(&s);					//op1에 피연산자 스택의 상단값 저장(스택에서 삭제)
			switch(ch){
			case '+':								//연산자에 따라 피연산자 연산 실행 후 다시 스택에 저장
				linked_push(&s, op1+op2);
				break;
			case '-':
				linked_push(&s, op1-op2);
				break;
			case '*':
				linked_push(&s, op1*op2);
				break;
			case '/':
				linked_push(&s, op1/op2);
				break;
			case '^':
				linked_push(&s, pow(op1, op2));
				break;
			case '%':
				linked_push(&s, op1%op2);
				break;
			}
		}
	}
	return linked_pop(&s);							//스택에 저장된 값 반환 (연산식의 결과값)
}

//^ 계산 함수
int pow(int op1, int op2){
	int i, result = 1;								//result: 계산 결과 저장
	for (i=0; i<op2; i++)
		result *= op1;								//op1을 op2만큼 거듭하여 곱함
	return result;									//계산 결과 반환
}

//icp값 반환 함수  : 스택 내부 우선순위
int icp(char ch){
	switch(ch){
	case '(':			//입력받은 연산자 ch의 ICP값에 따라
		return 20;		//우선순위 데이터 반환(높을수록 우선순위 높음)
		break;
	case '+':
		return 12;
		break;
	case '-':
		return 12;
		break;
	case '*':
		return 13;
		break;
	case '/':
		return 13;
		break;
	case '%':
		return 13;
		break;
	case '^':
		return 15;
		break;
	default:
		return 0;
	}
}

//isp값 반환 함수 : 스택 진입 우선순위
int isp(char ch){
	switch (ch){
	case '(':			//입력받은 연산자 ch의 ICP값에 따라
		return 0;		//우선순위 데이터 반환(높을수록 우선순위 높음)
		break;
	case '+':
		return 12;
		break;
	case '-':
		return 12;
		break;
	case '*':
		return 13;
		break;
	case '/':
		return 13;
		break;
	case '%':
		return 13;
		break;
	case '^':
		return 14;
		break;
	case '#':
		return 0;
		break;
	default:
		return 0;
	}
}


/**** 메인 함수 ****/

int main() {
	int size, i, j;							//size : 입력 받을 수식의 개수
	char line[MAX_LEN];						//파일에서 입력받은 수식을 저장하는 배열

	FILE *file = fopen("infix.txt", "r");	//읽기 전용 형식으로 파일 열기

	if (file==NULL){
		printf("파일 열기 실패\n");
		return -1;
	}

	fscanf(file, "%d", &size);				//size에 파일에 있는 수식 개수 저장
	fgets(line, MAX_LEN, file);				//두번째 줄 부터 수식으로 입력받기 위해 첫째줄 미리 입력받음

	for (i=0; i<size; i++){					//size만큼 i 증가하며 반복
		fgets(line, MAX_LEN, file);			//line에 file 한 줄씩 저장
		print_infix(line);					//line 출력 (중위 표기식)
		infix_to_postfix(line);				//중위표기식인 line을 후위표기식으로 변환
		printf("value = %d \n\n", eval(line));	//후위표기식인 line의 값 계산 후 출력
		
	}
	fclose(file);					//파일 닫기
}