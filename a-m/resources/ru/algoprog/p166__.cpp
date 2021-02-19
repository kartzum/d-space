// https://algoprog.ru/material/p166

#include <bits/stdc++.h>

using namespace std;

const int MAXN = 123456;

vector<int> g[MAXN];
vector<bool> visited;
vector<int> color, result;
int n, m;

void read() {
        cin >> n >> m;
        visited.resize(n, false);
        color.resize(n, 0);
        int a, b;
        for (int edge = 0; edge < m; ++edge) {
            cin >> a >> b;
            --a; --b;
            g[a].emplace_back(b);
        }
}

bool dfs(int vertex) {
        visited[vertex] = true;
        color[vertex] = 1;
        for (int neighbour : g[vertex]) {
            if (color[neighbour] == 0) {
                if (dfs(neighbour)) { return true; }
            } else if (color[neighbour] == 1) {
                return true;
            }
        }
        color[vertex] = 2;
        result.emplace_back(vertex + 1);
        return false;
}

bool has_cycle() {
    bool has_found_cycle = false;
    for (int vertex = 0; vertex < n; ++vertex) {
        if (!visited[vertex]) {
            if (dfs(vertex)) {
                has_found_cycle = true;
                break;
            }
        }
    }
    return has_found_cycle;
}

void top_sort() {
    if (has_cycle()) {
        cout << "No";
    } else {
        reverse(result.begin(), result.end());
        cout << "Yes" << endl;
        for (int vertex : result) {
            cout << vertex << " ";
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    read();
    top_sort();
    return 0;
}