#include <bits/stdc++.h>

using namespace std;

template<typename T>
T fromString(const std::string& str)
{
    std::istringstream ss(str);
    T ret;
    ss >> ret;
    return ret;
}

const int maxSize = 1024;
int first = 0;
int last = 0;
int data[maxSize] = {0};

int size()
{
    if (first > last) {
        return maxSize - first + last;
    } else {
        return last - first;
    }
}

void push(int n)
{
    if (size() != maxSize) {
        data[last] = n;
        last = (last + 1) % maxSize;
    }
}

int pop()
{
    if (first == last) {
        return 0;
    }
    int n = data[first];
    first = (first + 1) % maxSize;
    return n;
}

int front()
{
    if (first == last) {
        return 0;
    }
    return data[first];
}

void clear()
{
    first = 0;
    last = 0;
}

int main()
{
  string cmd;
  while(true) {
    getline(cin, cmd);
    if (cmd == "exit") {
      cout << "bye" << endl;
      break;
    }
    else if (cmd.rfind("push", 0) == 0) {
      push(fromString<int>(cmd.substr(5)));
      cout << "ok" << endl;
    }
    else if (cmd == "pop") {
      if (size() == 0) {
        cout << "error" << endl;
      } else {
        cout << pop() << endl;
      }
    }
    else if (cmd == "front") {
      if (size() == 0) {
        cout << "error" << endl;
      } else {
        cout << front() << endl;
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