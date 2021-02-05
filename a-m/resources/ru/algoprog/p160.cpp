// https://algoprog.ru/material/p160

// https://proglib.io/p/algorithm-tasks/

#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

const int SIZE = 100;

void matrix_input(int matrix[][SIZE], int size)
{
    for(int i = 0; i < size; ++i)
    {
        for(int j = 0; j < size; ++j)
        {
            cin >> matrix[i][j];
        }
    }
}

int main()
{
    int size;
    int start, end;
    cin >> size;

    vector<int> from(size, -1);
    vector<int> used(size, 0);
    vector<int> dist(size);

    int mainMatrix[SIZE][SIZE];
    int way[SIZE];
    int counter = 0;
    matrix_input(mainMatrix, size);

    cin >> start >> end;
    --start; --end;

    queue<int> Queue;
    Queue.push(start);

    dist[start] = 0;
    used[start] = 1;

    while (!Queue.empty())
    {
        int hold = Queue.front();
        Queue.pop();

        for (int i = 0; i < size; ++i)
        {
            if (mainMatrix[hold][i] && !used[i])
            {
                dist[i] = dist[hold] + 1;
                from[i] = hold;
                Queue.push(i);
                used[i] = true;
            }
        }

    }

    if (used[end])
    {
        if(dist[end] == 0)
        {
            cout << dist[end] << endl;
        }
        else
        {
            cout << dist[end] << endl;
            vector <int> way;
            for(int i = end; i != -1; i = from[i])
            {
                way.push_back(i);
            }
            reverse (way.begin(), way.end());
            for(int i = 0; i < way.size(); ++i)
            {
                cout << way[i] + 1 << " ";
            }
        }
    }
    else
    {
        cout << -1 << endl;
    }

    return 0;
}