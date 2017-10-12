#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct customer
{
    char id[5];
    char company[40];
    char name[20];
    char job[20];
    char address[80];
    char city[10];
    char post[10];
    char phone[20];
} Customer;

int count = 0;
Customer customers[100];

int readFile(void)
{
    FILE *fp;
    if((fp = fopen("file02.txt","r")) == NULL)
    {
        return 0;
    }
    while(!feof(fp))
    {
        fscanf(fp,"%s %s %s %s %s %s %s %s",
            customers[count].id,
            customers[count].company,
            customers[count].name,
            customers[count].job,
            customers[count].address,
            customers[count].city,
            customers[count].post,
            customers[count].phone);
        count++;
    }
    return count;
}

void check(void)
{
    int i;
    printf("邮编信息非法的客户：\n");
    for(i=0;i<count;i++)
    {
        if(strlen(customers[i].post) != 6)
        {
            printf("%s %s %s %s %s %s %s %s\n",
                customers[i].id,
                customers[i].company,
                customers[i].name,
                customers[i].job,
                customers[i].address,
                customers[i].city,
                customers[i].post,
                customers[i].phone);
        }
    }
}

void query(void)
{
    int i;
    char city[10];
    printf("请输入要查询的城市：");
    scanf("%s",city);
    for(i=0;i<count;i++)
    {
        if(strcmp(customers[i].city,city) == 0)
        {
            printf("%s %s %s %s %s %s %s %s\n",
                customers[i].id,
                customers[i].company,
                customers[i].name,
                customers[i].job,
                customers[i].address,
                customers[i].city,
                customers[i].post,
                customers[i].phone);
        }
    }
}

int main(void)
{
    char input[20];
    readFile();
    while(1)
    {
        system("cls");
        printf("1-邮编校验\n");
        printf("2-客户查询\n");
        printf("3-退出程序\n");
        printf("请输入：");
        scanf("%s",input);
        switch(input[0])
        {
        case '1':
            check();
            break;
        case '2':
            query();
            break;
        case '3':
            return 0;
        }
        printf("\n\n");
        system("pause");
    }
    return 0;
}
