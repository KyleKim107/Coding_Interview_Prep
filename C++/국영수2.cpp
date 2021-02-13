#include <iostream>
#include <algorithm>
#include<bits/stdc++.h>
using namespace std;
// #include <bits/stdc++.h>

typedef struct student{
    char name[11];
    int lit,en,math;
}Student;

Student arr[100001];
bool sorting(struct student A,struct student B){
    if(A.lit == B.lit){
        if(A.en == B.en){
            if(A.math == B.math){
                return strcmp(A.name , B.name)< 0;
            }
                return A.math > B.math;
        }    
        return A.en < B.en;
    }
        return A.lit > B.lit;
    
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    for(int i = 0 ; i < n ; i++){
        cin >> arr[i].name >> arr[i].lit >> arr[i].en >>arr[i].math;
    }
    sort(arr, arr+n, sorting);
    for(int i = 0 ; i < n ; i++){
        cout << arr[i].name << "\n";
    }
    return 0;
}
