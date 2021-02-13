#include <bits/stdc++.h>
using namespace std;

int main(){
    vector<int> minV(1000000001,0);
vector<int> plV(1000000001,0);
    int n,x,num ;
    cin >> n >> x;

    for(int i = 0 ; i < n ; i++){
        cin >> num;
        if (num < 0){
            minV[-num]+=1;
        }else{
            plV[num]=1 + minV[num] ;
        }
    }
    
    if(x < 0){
        cout << minV[-num];
    }else{
        cout << plV[num];
    }

}