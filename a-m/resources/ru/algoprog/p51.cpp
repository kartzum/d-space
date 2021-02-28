// https://algoprog.ru/material/p51

#include <bits/stdc++.h>

using namespace std;

int main() {
  stack<char> st;
  map<char, char> pairs;
  pairs[')'] = '(';
  pairs['}'] = '{';
  pairs[']'] = '[';

  string str;
  cin >> str;
  for (int i = 0; i < str.length(); i += 1) {
    if (str[i] == '(' || str[i] == '{' || str[i] == '[') {
      st.push(str[i]);
    } else {
        if (st.size() == 0 || st.top() != pairs[str[i]]) {
          cout << "no" << endl;
          return 0;
        } else {
          st.pop();
        }
    }
  }
  cout << (st.size() == 0 ? "yes" : "no") << endl;
}