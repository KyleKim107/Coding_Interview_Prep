#include <bits/stdc++.h>
#include <algorithm>
using namespace std;
vector<int> l;
vector<int> order;

bool goFind(vector<int>& l, int target, int start, int end ){
    while(start <= end){
        int middle = (start + end) / 2;
        if(l[middle] == target){return true;}
        cout << l[middle];
        if(target > l[middle]){
            start = middle +1 ;
        }else{
            end= middle -1;
        }
    }
    return false;
}

int main(){
 int n ;
 cin >> n ;
 int num;
 for(int i = 0 ; i < n ; i++)   {
     cin >> num;
     l.push_back(num);
 }
 int m ;
 cin >> m ;
 int target;
 sort(l.begin(), l.end());
 for(int i = 0 ; i < n ; i++)   {
     cin >> target;
     bool flag = goFind(l, target,0, n-1  );
     if (flag == false){
         cout << "no";   
     }else{
         cout << "yes";
     }
 }

}