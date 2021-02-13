#include<bits/stdc++.h>

using namespace std;

typedef struct score{
    char name[11];
    int lan, eng, mat;
}Score;

Score sc[100001];
bool cmp(struct score p, struct score q){
    if(p.lan == q.lan) // 국어점수가 같다면
    {
        if(p.eng == q.eng) // 영어점수가 같다
        {
            if(p.mat == q.mat) //  수학점수가 같다
            {
                return strcmp(p.name, q.name) < 0;
            }
            else if(p.mat != q.mat)
            {
                return p.mat > q.mat;
            }
        }
        else if(p.eng != q.eng)
        {
            return p.eng < q.eng;
        }   
    }
    else if(p.lan != q.lan)
    {
        return p.lan > q.lan;
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    int n;
    cin >> n;
    for(int i=0; i<n; i++)
    {
        cin >> sc[i].name >> sc[i].lan >> sc[i].eng >> sc[i].mat;
    }
    sort(sc, sc+n, cmp);
    for(int i=0; i<n; i++)
    {
        cout << sc[i].name << "\n";
    }
    return 0;
}