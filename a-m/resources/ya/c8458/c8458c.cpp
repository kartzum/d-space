#include <iostream>

using namespace std;

int main()
{
    int n = 0;
    cin>>n;
    int p = 0;
    for(int i =0; i < n; i++) {
        int v =0;
        cin>>v;
        if (i == 0) {
            cout << v << "\n";
        } else {
            if (p != v) {
                cout << v << "\n";
            }
        }
         p = v;
    }

    return 0;
}
