#include <stdio.h>
#include <pthread.h>

typedef struct {
	int num;
	int fib[100];
} Data;
void* getfib(void* data){
	Data* index = (Data*) data;
	index->fib[0] = 0;
	index->fib[1] = 1;
	if(index->num == 0 || index->num == 1){
		return;
	}
	for(int i = 2;i < index->num;i++){
		index->fib[i] = index->fib[i-1]+index->fib[i-2];
	}
	
}
int main(){

	Data  data;
	int n;
	 printf("Get the Fibonacci number! Please input an number : ");
    scanf("%d", &n);
    if(n == 0){
    	printf("0 is not valid!\n");
    	return 0;
    }
    data.num = n;

    pthread_t pindex;
	int respth;// 创建返回0，则创建成功
	respth = pthread_create(&pindex, NULL, getfib, (void *)&data);
	if(respth != 0){
		printf("create thread failed!\n");
		return -1;
	}
	pthread_join(pindex, NULL);
	for(int i=0;i<n;i++){
    		printf("Fibonacci:%d:%ld\n",i,data->fib[i] );
    	}
	return 0;
}
