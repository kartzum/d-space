// https://algoprog.ru/material/p1766
// https://stackoverflow.com/questions/9851628/minimal-positive-number-divisible-to-n

#include<cstdio>
#include<queue>
#include<cstring>
#include<iostream>
using namespace std;
#define N 1100

queue<pair<int, int> >Q;
short sumTrace[N][N], mulTrace[N][N];

void print(int sum, int mul) {
    if (sumTrace[sum][mul] == 42) return;
    print(sum-sumTrace[sum][mul], mulTrace[sum][mul]);
    printf("%d", sumTrace[sum][mul]);
}
void solve(int n) {
    Q.push(make_pair(0, 0));
    sumTrace[0][0]=42;
    while (1) {
        int sum = Q.front().first;
        int mul = Q.front().second;
        if (sum == n && mul == 0) break;
        Q.pop();
        for (int i=0; i<10; i++) {
            int nsum = sum+i;
            if (nsum > n)break;
            int nmul = (mul*10+i)%n;
            if (sumTrace[nsum][nmul] == -1) {
                Q.push(make_pair(nsum, nmul));
                sumTrace[nsum][nmul] = i;
                mulTrace[nsum][nmul] = mul;
            }
        }
    }
    print(n,0);
}

int main() {
    int n;
    std::cin>>n;
    memset(sumTrace, -1, sizeof sumTrace);
    solve(n);
    return 0;
}