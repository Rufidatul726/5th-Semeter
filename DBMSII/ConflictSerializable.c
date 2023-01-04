#include<stdio.h>
#include<string.h>


int main(void){
    char input[1000];
    int i,j,k,flag,count, countTransaction=0;
    int min=0;
    int noOfTransaction=0;
    char transsactionType[100];
    char stack[100][5];

    printf("Enter Transaction: ");
    gets(input);
    count=0;

    for(i=0;i<strlen(input);i++){
        if(input[i]=='r' || input[i]=='w'){
            noOfTransaction++;
            min=input[i+1]-48;
            if(min>countTransaction){
                countTransaction=min;
            }
            if(strlen(transsactionType)==0){
                transsactionType[0]=input[i+3];
            }
            else{
                flag=0;
                for(j=0;j<strlen(transsactionType);j++){
                    if(transsactionType[j]==input[i+3]){
                        flag=1;
                        break;
                    }
                }
                if(flag==0){
                    transsactionType[count]=input[i+3];
                    count++;
                }
            }
            
        }
    }
    int stack[top];
    for(i=0;i<count;i++){
        flag=0;
        
        for(j=0;j<strlen(input);j++){
            if(input[j+3]==transsactionType[i]){
                stack[top]
            }
        }
    }
    printf("%d", min);
    // for(i=0; i<strlen(input);i++){
        
    // }

}
