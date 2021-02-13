#include <bits/stdc++.h>
using namespace std;
vector<int> V;

int main(){
    
    int n,m,num ; 
    cin >> n >> m;
    for(int i = 0 ; i < n ; i++){
        cin >> num;
        V.push_back(num);
    }
    int  middle, ind,cnt, start,end,result;
    start = 0;
    end = n-1;

    sort(V.begin(), V.end());
    while(start <= end){
        cnt = 0;
        ind = (start + end)/2;   
        middle = V[ind];

        for(int i =0 ;i < n; i++){
            if(V[i] > middle){
                cnt += (V[i]-middle);
            }
        }
        if (cnt < m){
            end = middle -1;
        }else {
            result = middle;
            start = middle +1;
        }

    }
    cout << result;
    
}
