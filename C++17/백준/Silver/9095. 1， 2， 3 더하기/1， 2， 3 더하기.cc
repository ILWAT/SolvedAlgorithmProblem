//백준 9095
//https://www.acmicpc.net/problem/9095

#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstdio>
#include <algorithm>
#include <vector>

using namespace std;

int memoi[12];

int main(void) {
	vector<int> T;
	memoi[1] = 1;
	memoi[2] = 2;
	memoi[3] = 4;
	int n, nCount;
	cin >> nCount;
	for (int i = 0; i < nCount; i++) {
		cin >> n;
		T.push_back(n);
	}
	for (int i = 0; i < nCount; i++) {
		n = T[i];
		for (int j = 4; j <= n; j++) {
			memoi[j] = memoi[j - 1] + memoi[j - 2] + memoi[j - 3];
		}
		cout << memoi[n]<<endl;
		}	
	}