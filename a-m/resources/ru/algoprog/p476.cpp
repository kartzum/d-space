// https://algoprog.ru/material/p476

#include <bits/stdc++.h>

using namespace std;

int n, m;
set<pair<int, int>> myset;

void read() {
        cin >> n >> m;

        int a, b;
        for (int edge = 0; edge < m; ++edge) {
            cin >> a >> b;
            --a; --b;
            myset.insert({a, b});
            myset.insert({b, a});
        }
}

void solve() {
        if (myset.size() == n * (n - 1)) {
            cout << "YES";
        } else {
            cout << "NO";
        }
}

int main() {
    read();
    solve();
    return 0;
}