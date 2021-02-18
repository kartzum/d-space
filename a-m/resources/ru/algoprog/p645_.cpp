// https://algoprog.ru/material/p645

#include <iostream>
#include <queue>
using namespace std;

int main()
{
	int n, i, j, k, x1, y1, x2, y2, u, v;
	queue<pair<int, int> > q;
	int x[4] = {-1, 1, 0, 0}, y[4] = {0, 0, -1, 1};
	cin >> n;
	int d[n][n], p[n][n];
	string a[n];
	for (i = 0; i < n; ++i)
	{
		cin >> a[i];
		for (j = 0; j < n; ++j)
		{
			d[i][j] = 1000000000;
			if (a[i][j] == '@')
			{
				x1 = i;
				y1 = j;
			}
			else if (a[i][j] == 'X')
			{
				x2 = i;
				y2 = j;
			}
		}
	}
	d[x1][y1] = 0;
	q.push(make_pair(x1, y1));
	while (!q.empty())
	{
		i = q.front().first;
		j = q.front().second;
		q.pop();
		for (k = 0; k < 4; ++k)
		{
			u = i + x[k];
			v = j + y[k];
			if (u >= 0 && u < n && v >= 0 && v < n &&
				a[u][v] != 'O' && d[u][v] > d[i][j] + 1)
			{
				d[u][v] = d[i][j] + 1;
				p[u][v] = k;
				q.push(make_pair(u, v));
			}
		}
	}
	if (d[x2][y2] < 1000000000)
	{
		cout << 'Y';
		i = x2;
		j = y2;
		while (a[i][j] != '@')
		{
			a[i][j] = '+';
			k = p[i][j];
			i -= x[k];
			j -= y[k];
		}
		for (i = 0; i < n; ++i)
			cout << endl
				 << a[i];
	}
	else
		cout << 'N';
	return 0;
}
