#include <iostream>
#include <algorithm>
using namespace std;
int main(void){
    ios_base::sync_with_stdio( false );
    cin.tie(NULL);

    // cout << "Hello World";
    int n ;
    scanf("%d" , &n);
    int arr[10001] = {0,};

    int num;
    for( int i = 0 ; i < n ; i++){
        scanf("%d", &num);
        arr[num] += 1;
    }

    for(int i = 1 ; i < 10001 ; i++){
        if (arr[i] > 0){
            for(int j = 0 ;  j < arr[i] ; j ++ ){
                printf("%d\n", i);
            }
        }
    }

    return 0;
}


// int main( void )
// {
//     cin.tie( nullptr );
//     cout.tie( nullptr );
//     ios_base::sync_with_stdio( false );

//     uint16_t count[10001] = { 0, };

//     int num;
//     cin >> num;

//     int val;
//     for( int i = 0; i < num; ++i )
//     {
//         cin >> val;
//         ++count[val];
//     }

//     for( int i = 1; i <= 10000; ++i )
//     {
//         int size = count[i];
//         for( int j = 0; j < size; ++j )
//         {
//             cout << i << '\n';
//         }
//     }

//     return 0;
// }

