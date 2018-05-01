#include <stdio.h>
#include <pthread.h>

pthread_t thread[30][30];
int res_matrix[30][30];
int input_matrix1[30][30];
int input_matrix2[30][30];

int Row, Col;
int Row2, Col2;

typedef struct {
	int row;
	int col;
} Data;

void* calu(void* data){

	Data* index = (Data*)data;
	int r = index->row;
	int c = index->col;

	int res = 0;
	for(int i = 0;i < ;i++){
		res += input_matrix1[r][i] * input_matrix2[i][c];
	}
	res_matrix[r][c] = res;
}
int main(){

	//input matrix1
	printf("input Row and Column：\n");
	printf("not more than 30\n");
    scanf("%d%d", &Row, &Col);

    printf("input input_matrix1:\n");
    for(int i = 0; i < Row; i++){
        for(int j = 0; j < Col; j++){
            scanf("%d", &input_matrix1[i][j]);
        }
    }
	//input matrix2
    printf("input Row and Column：");
    printf("not more than 30\n");
    scanf("%d%d", &Row2, &Col2);
    printf("input input_matrix2:\n");
    for(int i = 0; i < Row2; i++){
        for(int j = 0; j < Col2; j++){
            scanf("%d", &input_matrix2[i][j]);
        }
    }
    //is valid?
    if (Col != Row2)
    {
    	printf("input error!\n");
    }
    //store row and column info
    Data data[30][30];
    // (3*4) * (4*5)->res[3][5] 
     for(i = 0; i < Row; i++){
        for(j = 0; j < Col2; j++){
            data[i][j].row = i;
            data[i][j].col = j;
            int res;
            //create thread
            ret = pthread_create(&thread[i][j], NULL, calu, (void*)&data[i][j]);
            //is success
            if(ret != 0){
                printf("Create thread error!\n");
                return -1;
            }
        }
    }
    printf("output\n");
    for(i = 0; i < Row; i++){
        for(j = 0; j < Col2; j++){
           printf("%-5d ", res_matrix[i][j]);
    	}
    	printf("\n");
    }
	return 0;
}
