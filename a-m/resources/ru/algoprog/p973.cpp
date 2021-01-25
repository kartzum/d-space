// https://algoprog.ru/material/p973

#include <bits/stdc++.h>

using namespace std;

int main() {
  int64_t k;
  cin >> k;
  const int64_t lim = 15485863; // 1000000th prime number
  bitset<lim+1> isPrime;
  isPrime.reset(0);
  isPrime.reset(1);
  for (int64_t i = 2; i <= lim; i += 1) {
    isPrime.set(i);
  }
  int64_t c = 0;
  int64_t nth = 0;
  for (int64_t i = 2; i <= lim && c < k; i += 1) {
    if (isPrime[i] == 1) {
      c += 1;
      nth = i;
      int64_t j = i*i;
      while (j <= lim) {
        isPrime.reset(j);
        j += i;
      }
    }
  }
  cout << nth << endl;
}