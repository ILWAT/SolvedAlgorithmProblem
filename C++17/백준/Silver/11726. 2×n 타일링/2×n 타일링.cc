//백준 11726
//https://www.acmicpc.net/problem/11726

#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstdio>
#include <cstring>
#include <algorithm>

using namespace std;


int main(void) {
	int n, dp[1001];
	memset(dp, 0, sizeof(int) * 1001);
	dp[1] = 1;
	dp[2] = 2;
	cin >> n;
	for (int i = 3; i <= n; i++) {
		dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
	}
	cout << dp[n] << endl;
}
