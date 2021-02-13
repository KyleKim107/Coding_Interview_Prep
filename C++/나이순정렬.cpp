#include <iostream>
#include <string>
#include <vector>
using namespace std;



int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int n, yr; 
    string name;
    scanf("%d", &n);
    vector<string> years[201];
    for(int i = 0 ; i < n ; i++){
        cin >> yr >> name;
        years[yr].push_back(name);
    }
    vector<string>::iterator ptr;
    for(int i = 1 ; i < 201 ; i++){
        for( ptr = years[i].begin() ; ptr != years[i].end(); ptr++){
            cout << i << " "<< *ptr << "\n";
        }
    }
    return 0;

}
//https://www.acmicpc.net/source/20446274