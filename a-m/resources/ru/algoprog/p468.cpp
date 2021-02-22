// https://algoprog.ru/material/p468

#include <bits/stdc++.h>

using namespace std;

int n, m;
set<pair<int, int>> myset;

void read() {
        cin >> n >> m;
        int a, b;
        for (int edge = 0; edge < m; ++edge) {
            cin >> a >> b;
            if (myset.count({a, b})) {
                cout << "YES";
                return;
            }
            myset.insert({a, b});
            myset.insert({b, a});
        }
        cout << "NO";
}

int main() {
    read();
    return 0;
}