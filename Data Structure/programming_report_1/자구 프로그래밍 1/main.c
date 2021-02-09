#include <stdio.h>			//����� �������
#include <stdlib.h>			//exit(), malloc() ���� �������
#include <string.h>			//string ���� �������
#define MAX_LEN 100			//�Է¹��� �� �ִ� ���� �ִ� ����
#define MAX_STACK_SIZE 20	//������ �ִ� ũ��



/**** ���� ǥ����� ���� ǥ������� ��ȯ ****/

//�迭�� �̿��� ���� ����ü ����
typedef int element;
typedef struct{
	element stack[MAX_STACK_SIZE];
	int top;
}StackType;

//�迭���� �ʱ�ȭ �Լ�
void arr_init(StackType *s){
	s->top = -1;
}

//�迭���� ������� ���� �Լ�
int arr_is_empty(StackType *s){
	return (s->top == -1);
}

//�迭���� ��ȭ���� ���� �Լ�
int arr_is_full(StackType *s){
	return (s->top == (MAX_STACK_SIZE-1));
}

//�迭���� ���� �Լ�
void arr_push(StackType *s, element item){
	if(arr_is_full(s)){								//�迭�� ��ȭ ���¶�� ����
		fprintf(stderr, "���� ��ȭ ����\n");
		return;
	}
	else											//��ȭ ���°� �ƴ϶��
		s->stack[++(s->top)] = item;				//���� top�� ������Ű�� item ����
}

//�迭���� ���� �Լ�
element arr_pop(StackType *s){
	if(arr_is_empty(s)){							//�迭�� ���� ���¶�� ����
		fprintf(stderr, "���� ���� ���� 1\n");
		exit(1);
	}
	else											//���� ���°� �ƴ϶��
		return s->stack[(s->top)--];				//���� top�� 1ĭ ����
}

//�迭���� ��ũ �Լ�
element arr_peek(StackType *s){
	if(arr_is_empty(s)){							//�迭�� ���� ���¶�� ����
		fprintf(stderr, "���� ���� ���� 2\n");
		exit(1);
	}
	else											//���� ���°� �ƴ϶��
		return s->stack[s->top];					//������ top�� ����Ű�� �� ��ȯ
}

//���� ǥ��� ��� �Լ�
void print_infix(char exp[]){						//�迭�� �Է¹���
	int i;
	printf("infix notation = ");
	for (i=0; i<strlen(exp); i++){					//�Է¹��� �迭�� ���̸�ŭ �ݺ�
		printf("%c ", exp[i]);						//�迭 ���
	}
}

//���� ǥ�� ���� -> ���� ǥ�� ���� ��ȯ �Լ�
void infix_to_postfix(char exp[]){					//�迭 �Է¹���
	int i=0, j=0;
	//ch:��ĵ�� ����. ch_temp:������ pop�� �ӽ�����.
	//top_op: ������ ��� ������. keep[]:��ȯ�� ���� �ӽ�����
	char ch, ch_temp, top_op, keep[MAX_LEN];
	int len = strlen(exp);							//�Է¹��� �迭�� ���� ����
	StackType s;									//�����ڸ� ������ �迭���� ����

	arr_init(&s);									//���� �ʱ�ȭ
	arr_push(&s, '#');								//������ ������� �ʵ��� �ϴ� ������

	if (exp[0]>='0' && exp[0]<='9' && exp[1]==';')	//������ �ǿ����� �ϳ��� ���
		printf("\n");								//��½� �ٸ����� ���� \n ����
	
	printf("\bpostfix notation = ");
	
	for (i=0; i<len-1; i++){
		ch = exp[i];		//�迭���� ��ĵ�� ���� ������� ����
		switch(ch){
		case '+': case '-': case '*': case '/': case '^': case '%':		//ch�� �������� ���
			//�迭�� ���� ���°� �ƴϰ�, ICP�� ISP���� ũ�ٸ�
			while (!arr_is_empty(&s) && (icp(ch) <= isp(arr_peek(&s)))){
				ch_temp = arr_pop(&s);				//������ ��ܰ� ���� �� ch_temp�� ����
				printf("%c ", ch_temp);				//������ ��ܰ� ���
				keep[j++] = ch_temp;				//������ ��ܰ� keep�迭�� ����
			}
			arr_push(&s, ch);						//ch�� ���ÿ� ����
			break;
		case '(':									//ch�� ���� ��ȣ���
			arr_push(&s, ch);						//ch�� ���ÿ� ����
			break;
		case ')':									//ch�� ������ ��ȣ���
			top_op = arr_pop(&s);					//top_op�� ������ ��� ������ ����
			while(top_op != '('){					//���� ��ܰ��� ���� ��ȣ�� �� ������ �ݺ�
				printf("%c ", top_op);				//������ ��ܰ� ���
				keep[j++] = top_op;					//������ ��ܰ� keep �迭�� ����
				top_op = arr_pop(&s);				//top_op�� ������ ��� ������ ���� (while�� �ݺ�)
			}			
			break;
		case ';':									//ch�� ������ ���� ��Ÿ���� �����ݷ�(;)�� ���
			break;
		default:									//�� ��ʿ� �ش����� �ʴ� ���(=�ǿ�����)
			printf("%c ", ch);						//ch�� ���
			keep[j++] = ch;							//ch�� keep�迭�� ����
			break;
		}
	}
	printf("\b ");									//��� �� �ٸ����� ���� backspace
	while(!arr_is_empty(&s) && arr_peek(&s)!='#'){	//���� ��� ���� '#'�� �ƴ϶��
		ch_temp = arr_pop(&s);						//ch_tmep�� ���� ��ܰ� ����
		printf("%c ", ch_temp);						//������ ��ܰ� ���
		keep[j++] = ch_temp;						//������ ��ܰ� keep �迭�� ����
	}
	printf(";\n");									//������ ���� �ǹ��ϴ� �����ݷ�(;) ���
	keep[j] = NULL;									//keep�迭�� ���� NULL ����
	strcpy(exp, keep);								//keep�迭���� ������ exp�迭�� ����
}



/**** ���� ǥ��� ��� ****/

//���� ���� ����
typedef struct StackNode{
	element data;
	struct StackNode *link;
} StackNode;

//���� ������ ���� ������
typedef struct {
	StackNode *top;
} LinkedStackType;	

//���ὺ�� �ʱ�ȭ �Լ�
void linked_init(LinkedStackType *s){
	s->top = NULL;
}

//���ὺ�� ������� ���� �Լ�
int linked_is_empty(LinkedStackType *s){
	return (s->top == NULL);
}

//���ὺ�� ���� �Լ�
void linked_push(LinkedStackType *s, element item){				//���ð� ������ ������ �Է�
	StackNode *temp = (StackNode *)malloc(sizeof(StackNode));	//���ο� ���ὺ�� �޸� �Ҵ�
	if (temp==NULL) {
		fprintf(stderr, "�޸� �Ҵ翡��\n");
		return;
	}
	else{
		temp->data = item;							//temp�� data�� item�� ����
		temp->link = s->top;						//temp�� ����Ű�� ���� top�� ����Ű�� �� ���� 
		s->top = temp;								//top�� ����Ű�� ���� temp ����
	}
}

//���ὺ�� ���� �Լ�
element linked_pop(LinkedStackType *s){
	int item;						//������ ���� data
	if (linked_is_empty(s)){
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

//����ǥ��� ��� �Լ�
int eval(char exp[]){								//�迭 �Է¹���
	int op1, op2, value, i=0;						//op:�ǿ����� ����. value:��� ��� ����
	int len = strlen(exp);							//�Է¹��� �迭�� ���� .
	char ch;										//��ĵ�� ����
	LinkedStackType s;								//�ǿ����ڸ� ������ ���� ����

	linked_init(&s);								//���� �ʱ�ȭ
				
	for(i=0; i<len; i++){
		ch = exp[i];								//�迭���� ��ĵ�� ���� ������� ����
		//ch�� �����ڰ� �ƴ϶�� (�ǿ����ڶ��)
		if(ch!='+' && ch!='-' && ch!='*' && ch!='/' && ch!='^' && ch!='%'){
			value = ch-'0';							//�ƽ�Ű�ڵ尪�� �� �����ν� ������ ���ڷ� �ٲ�
			linked_push(&s, value);					//�ǿ����� ���ÿ� value ����
		}

		else {										//ch�� �����ڶ��
			op2 = linked_pop(&s);					//op2�� �ǿ����� ������ ��ܰ� ����(���ÿ��� ����)
			op1 = linked_pop(&s);					//op1�� �ǿ����� ������ ��ܰ� ����(���ÿ��� ����)
			switch(ch){
			case '+':								//�����ڿ� ���� �ǿ����� ���� ���� �� �ٽ� ���ÿ� ����
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
	return linked_pop(&s);							//���ÿ� ����� �� ��ȯ (������� �����)
}

//^ ��� �Լ�
int pow(int op1, int op2){
	int i, result = 1;								//result: ��� ��� ����
	for (i=0; i<op2; i++)
		result *= op1;								//op1�� op2��ŭ �ŵ��Ͽ� ����
	return result;									//��� ��� ��ȯ
}

//icp�� ��ȯ �Լ�  : ���� ���� �켱����
int icp(char ch){
	switch(ch){
	case '(':			//�Է¹��� ������ ch�� ICP���� ����
		return 20;		//�켱���� ������ ��ȯ(�������� �켱���� ����)
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

//isp�� ��ȯ �Լ� : ���� ���� �켱����
int isp(char ch){
	switch (ch){
	case '(':			//�Է¹��� ������ ch�� ICP���� ����
		return 0;		//�켱���� ������ ��ȯ(�������� �켱���� ����)
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


/**** ���� �Լ� ****/

int main() {
	int size, i, j;							//size : �Է� ���� ������ ����
	char line[MAX_LEN];						//���Ͽ��� �Է¹��� ������ �����ϴ� �迭

	FILE *file = fopen("infix.txt", "r");	//�б� ���� �������� ���� ����

	if (file==NULL){
		printf("���� ���� ����\n");
		return -1;
	}

	fscanf(file, "%d", &size);				//size�� ���Ͽ� �ִ� ���� ���� ����
	fgets(line, MAX_LEN, file);				//�ι�° �� ���� �������� �Է¹ޱ� ���� ù°�� �̸� �Է¹���

	for (i=0; i<size; i++){					//size��ŭ i �����ϸ� �ݺ�
		fgets(line, MAX_LEN, file);			//line�� file �� �پ� ����
		print_infix(line);					//line ��� (���� ǥ���)
		infix_to_postfix(line);				//����ǥ����� line�� ����ǥ������� ��ȯ
		printf("value = %d \n\n", eval(line));	//����ǥ����� line�� �� ��� �� ���
		
	}
	fclose(file);					//���� �ݱ�
}