#include<stdio.h>
#include<unistd.h>
#include<sys/shm.h>
#include<sys/stat.h>
#include<sys/types.h>

#define PERMS (S_IRUSR|S_IWUSR)
#define MAX 10

typedef struct 
{
	long fib[MAX];
	int size;
}Sharedata; 

int main(int argc,char* argv[]){
	int i,size;

	pid_t pid;
	int segment_id;
	Sharedata* share_memory;

	if(argc != 2){
		fprintf(stderr, "Usage: ./shm-fib<sequence size>\n");
		return -1;
	}
	size = atoi(argv[1]);
	if(size > MAX){
		fprintf(stderr, " size must be < %d\n", MAX );
		return -1;
	}
	if( (segment_id = shmget(IPC_PRIVATE, sizeof(Sharedata), PERMS)) == -1 )   { //(见注1)
        fprintf(stderr, "Unable to create shared memory segment\n");
        return 1;
    }
    printf("create share memory segment%d\n",segment_id);

    if( (share_memory = (Sharedata *) shmat(segment_id,0,0))== (Sharedata*)-1 ){
    	fprintf(stderr, "Unable to attach to segment %d\n",segment_id );
    	return 0;
    }
    share_memory->size = size;
    if((pid = fork()) = (pid_t)-1){
    	return 1;
    }
    if(pid == 0) {

    }else{
    	wait(NULL);
    	for(i=0;i<share_memory->size;i++){
    		printf("%d:%ld\n",i,share_memory->fib[i] );
    	}
    	shmdt((void*) share_memory);
    	shmctl(segment_id,IPC_PRIVATE,NULL);
    }
}
