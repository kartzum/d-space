// https://algoprog.ru/material/p111648

#include <iostream>
#include <cmath>

using namespace std;

int main ()
{
  int N, x, y, t, L, h;
  cin >> N;
  int A[N], l, p;
  for (int i = 0; i < N; i++) {
      cin >> A[i];
  }
  L = N;
  h = 0;
  while (h < 100) {
      l = 0;
      p = 0;
      for (int i = p; i < L; i++) {
          if (A[i] == A[i + 1]) {
              l++;
          }
          else {
              p = l;
              l = 0;
              if (p >= 2) {
                x = abs (p - i);
                y = p + 1;
                break;
                }
          }
	  }
      if (p < 2) break;
      t = 0;
      while (t < y) {
          for (int i = x; i < L - t; i++) {
              A[i] = A[i + 1];
          }
          t++;
	  }
      L = L - t;
      h++;
  }
  cout << N - L << endl;
  return 0;
}
