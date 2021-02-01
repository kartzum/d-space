// https://algoprog.ru/material/p61

#include <bits/stdc++.h>

using namespace std;

const int maxSize = 128;
int first = 0;
int last = 0;
int data[maxSize] = {0};

template<typename T>
T fromString(const std::string& str) {
  std::istringstream ss(str);
  T ret;
  ss >> ret;
  return ret;
}

void pushBack(int n) {
    if (first == (last + 1) % maxSize) {
        return;
    }
    data[last] = n;
    last = (last + 1) % maxSize;
}

int popBack() {
    if (first == last) {
        return 0;
    }
    last = (last - 1 + maxSize) % maxSize;
    return data[last];
}

void pushFront(int n) {
    if (first == (last + 1) % maxSize) {
        return;
    }
    first = (first - 1 + maxSize) % maxSize;
    data[first] = n;
}

int popFront() {
    if (first == last) {
        return 0;
    }
    int r = data[first];
    first = (first + 1) % maxSize;
    return r;
}

void clear() {
    first = 0;
    last = 0;
}

int back() {
  return data[(maxSize + ((last - 1) % maxSize)) % maxSize];
}

int front() {
    return data[first];
}

int size() {
    if (first > last) {
        return maxSize - first + last;
    } else {
        return last - first;
    }
}

int main() {
  string cmd;
  while(true) {
    getline(cin, cmd);
    if (cmd == "exit") {
      cout << "bye" << endl;
      break;
    }
    else if (cmd.rfind("push_front", 0) == 0) {
      pushFront(fromString<int>(cmd.substr(10)));
      cout << "ok" << endl;
    }
    else if (cmd.rfind("push_back", 0) == 0) {
      pushBack(fromString<int>(cmd.substr(10)));
      cout << "ok" << endl;
    }
    else if (cmd == "pop_front") {
      if (size() == 0) {
        cout << "error" << endl;
      } else {
        cout << popFront() << endl;
      }
    }
    else if (cmd == "pop_back") {
      if (size() == 0) {
        cout << "error" << endl;
      } else {
        cout << popBack() << endl;
      }
    }
    else if (cmd == "front") {
      if (size() == 0) {
        cout << "error" << endl;
      } else {
        cout << front() << endl;
      }
    }
    else if (cmd == "back") {
      if (size() == 0) {
        cout << "error" << endl;
      } else {
        cout << back() << endl;
      }
    }
    else if (cmd == "size") {
      cout << size() << endl;
    }
    else if (cmd == "clear") {
      clear();
      cout << "ok" << endl;
    }
  }
}
