#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool sorting(pair<int,int> one,pair<int,int> two){
    if(one.first==two.first){
        return one.second < two.second;
    }
        return one.first < two.first;
    
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n; 
    cin >> n;
    vector< pair<int,int> > V ;
    int one;
    int two;
    for(int i = 0 ; i < n ; i++){
        cin >> one >> two;
        V.push_back(make_pair(one,two));
    }
    sort(V.begin(), V.end(), sorting);
    for(int i = 0 ; i < n ; i++){
        cout << V[i].first <<" " <<V[i].second << "\n";
    }

    return 0;    
}