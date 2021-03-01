// https://algoprog.ru/material/p672

#include <iostream>
#include <cstdio>
#include <vector>

using namespace std;

int n,amount;
vector<int>  mas;

void input() {
    cin>>n>>amount;
    mas.resize(n);
    for (int i=0;i<n;i++)
        scanf("%d", &mas[i]);
}

int calc(int len, vector<int> &mas) {
    int res = 0;
    for (int i=0;i<mas.size();i++)
        res += mas[i]/len;
    return res;
}

void solve() {
    int l = 0, r = 1e8;
    int len = 0;
    while (r-l>1) {
        int m = (r + l) / 2;
        int curAmount = calc(m,mas);
        if (curAmount < amount)
            r = m;
        else if (curAmount >= amount) {
            l = m;
            len = max(len,m);
        }
    }
    cout<<len;
}

int main() {
    input();
    solve();
    return 0;
}