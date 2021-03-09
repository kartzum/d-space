// https://algoprog.ru/material/p111648

#include <iostream>

int N;
int m[1001];

int main() {
    std::cin >> N;
    for(int i = 0; i < N; i++) std::cin >> m[i];
    for(int i = 0, count = 0; i < N-2; i++) {
        int L = i;
        int R = i + 1;
        while(m[L] == m[R]) {
            int cnt = 2;
            while((--L >= 0) && (m[L] == m[R]  )) cnt++;
            while((++R <  N) && (m[R] == m[L+1])) cnt++;
            if(cnt < 3) break;
            count += cnt;
        }
        if(count) {
            std::cout << count; return 0;
        }
    }
    std::cout << 0;
    return 0;
}