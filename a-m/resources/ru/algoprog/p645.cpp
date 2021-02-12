// https://algoprog.ru/material/p645

#include <iostream>
#include <cstdio>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;

struct point {
    int x,y;
    point(){}
    point(int X, int Y)
    {
        x = X;
        y = Y;
    }
};

bool operator == (const point &a, const point &b) {
    return a.x == b.x && a.y == b.y;
}

const int max_size = 255;
int n;
char mas[max_size][max_size];
int  f[max_size][max_size];
point begin_,end_;
int moveX[4] = {0,1,0,-1};
int moveY[4] = {1,0,-1,0};

void input() {
    scanf("%d\n", &n);

    char c;
    for (int i=0;i<n;i++) {
        for (int j=0;j<n;j++) {
            scanf("%c",&c);
            mas[i][j] = c;
            if (c == '@')
                begin_ = point(i,j);
            if (c == 'X')
                end_ = point(i,j);
        }
        scanf("%c",&c);
    }
}

bool correct(int x, int y) {
    if (x<0 || y<0)
        return false;
    if (x==n || y==n)
        return false;
    return true;
}

void findWay() {
    memset(f,0,sizeof(f));
    f[begin_.x][begin_.y] = 1;
    queue<point> q;
    q.push(begin_);
    while (!q.empty()) {
        point cur = q.front(); q.pop();
        for (int i=0;i<4;i++) {
            int x = cur.x + moveX[i];
            int y = cur.y + moveY[i];
            if (correct(x,y) && f[x][y]==0 && mas[x][y] != 'O') {
                point next(x,y);
                f[x][y] = f[cur.x][cur.y] + 1;
                if (next == end_)
                    return;
                q.push(next);
            }
        }
    }
}

void findAnswer() {
    point cur = end_;
    int value = f[end_.x][end_.y]-1;
    mas[end_.x][end_.y] = '+';
    while (!(cur==begin_)) {
        for (int i=0;i<4;i++) {
            int x = cur.x + moveX[i];
            int y = cur.y + moveY[i];
            if (correct(x,y) && f[x][y] == value) {
                value--;
                if (value != 0)
                    mas[x][y] = '+';
                cur = point(x,y);
                break;
            }
        }
    }
}

void output() {
    for (int i=0;i<n;i++) {
        for (int j=0;j<n;j++)
            printf("%c",mas[i][j]);
        printf("\n");
    }
}

void solve() {
    findWay();
    if (!f[end_.x][end_.y])
        printf("N");
    else {
        printf("Y\n");
        findAnswer();
        output();
    }
}

int main() {
    input();
    solve();
    return 0;
}