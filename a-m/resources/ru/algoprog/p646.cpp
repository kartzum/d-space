// https://algoprog.ru/material/p646

#include <iostream>
#include <cstdio>
#include <vector>
#include <cstring>
#include <string.h>
#include <algorithm>
#include <stack>
#include <queue>

using namespace std;

int n;
const int max_size = 36;
char mas[max_size][max_size];

struct state {
    int x,y,pos;
    state(int X, int Y, int Pos) {
        x = X;
        y = Y;
        pos = Pos;
    }
};
int moveX[4] = {0,1,0,-1};
int moveY[4] = {1,0,-1,0};

void input() {
    scanf("%d\n",&n);
    char c;
    for (int i=1;i<=n;i++) {
        for (int j=1;j<=n;j++) {
            scanf("%c",&c);
            mas[i][j] = c;
        }
        scanf("%c",&c);
    }
    for (int i=0;i<n+2;i++) {
        mas[0][i] = mas[n+1][i] = '#';
        mas[i][0] = mas[i][n+1] = '#';
    }
}

void DFS(int x, int y, int &walls) {
    if (mas[x][y] == '.')
        mas[x][y] = 'X';
    else
        return;
    for (int i=0;i<4;i++) {
        int nextX = x + moveX[i];
        int nextY = y + moveY[i];
        if (mas[nextX][nextY] == '#')
            walls++;
    }
    for (int i=0;i<4;i++) {
        int nextX = x + moveX[i];
        int nextY = y + moveY[i];
        if (mas[nextX][nextY] == '.')
            DFS(nextX,nextY,walls);
    }
}

void solve() {
    int walls = 0;
    DFS(1,1,walls);
    DFS(n,n,walls);
    cout<<(walls-4) * 9;
}

int main() {
    input();
    solve();
    return 0;
}
