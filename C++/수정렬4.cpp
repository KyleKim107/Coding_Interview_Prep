
#include <bits/stdc++.h>

using namespace std;

int main(){
    cin.tie(0);
    ios_base::sync_with_stdio( false );
    int arr[1000000] = {0,};
    int n ;
    scanf("%d" , &n);
    for(int i = 0 ; i < n ; i++){
        scanf("%d", &arr[i]);
    }
    sort(arr, arr+n);
    for(int i = n-1 ; i >= 0 ; i--){
        printf("%d\n", arr[i]);
    }
    return 0;
}

// #include <bits/stdc++.h>
// using namespace std;
// int arr[1'000'001];
// int main(void) {
// 	ios::sync_with_stdio(0);
// 	cin.tie(0);
// 	int N;
// 	cin >> N;
// 	for (int n = 0; n < N; n++) {
// 		cin >> arr[n];
// 	}
// 	sort(arr, arr + N);
// 	for (int i = N - 1; i >= 0; i--) {
// 		cout << arr[i] << '\n';
// 	}
// }