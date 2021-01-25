// https://algoprog.ru/material/p112745

#include <iostream>
using namespace std;

int main() {
    long long a[100001], s[100001],pref[100001],suff[100001],mx,mn;
    int n,m,k,i,j;
    cin>>n>>k;
    s[0]=0;
    for (int i = 1; i <= n; i++) {
        cin>>a[i];
        s[i] = s[i - 1] + a[i];
    }
    for (int i = k; i <= n; i++) {
        pref[i] = max(pref[i - 1], s[i] - s[i - k]);
    }
    suff[n-k+1]=s[n]-s[n-k];
    for (int i = n - k + 1; i >= 1; i--) {
        suff[i] = max(suff[i + 1], s[i + k - 1] - s[i - 1]);
    }
    long long best = 2e18;
    for (int i = 1; i <= n - k + 1; i++) {
        best = min(best, max(pref[i - 1], suff[i + k]));
    }
    cout<<best;
    return 0;
}