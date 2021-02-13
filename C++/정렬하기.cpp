#include <stdio.h>
#include <iostream>
#include <algorithm>
using namespace std;
int main(void)
{
	
		
	int N;
	scanf("%d", &N);
	
	int n[1000000] = { 0, };// 초기화


	for (int i = 0; i < N; i++)
		scanf("%d", &n[i]);

	std::sort(n, n + N);

	for (int i = 0; i < N; i++)
		printf("%d \n", n[i]);
	return 0;

}