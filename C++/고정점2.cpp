#include <bits/stdc++.h>
using namespace std;
vector<int> arr;

int finder(vector<int>&arr , int start, int end){
    if(start > end) return -1;
    int mid = (start+end) / 2;
    if (arr[mid] == mid){ return mid;}
    else if(arr[mid] > mid){ return finder(arr, start, mid-1);}
    else{ return finder(arr, mid+1, end);}
}

int main(void){
    cin.tie(0);
    int n ,tmp; 
    cin >> n;
   for(int i = 0 ; i < n ; i++){
        cin >> tmp;
        arr.push_back(tmp);
    }
    // for(int i = 0 ; i < n ; i++){
    //     cout << arr.at(i) << "";
    // }
    int result = finder(arr, 0, n-1);
    cout << result;
    
    
    
}