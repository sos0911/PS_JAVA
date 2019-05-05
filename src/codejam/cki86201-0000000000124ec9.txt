#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <memory.h>
#include <math.h>
#include <assert.h>
#include <stack>
#include <queue>
#include <map>
#include <set>
#include <string>
#include <algorithm>
#include <iostream>
#include <functional>
#include <unordered_set>
#include <bitset>
#include <time.h>
#include <limits.h>

using namespace std;
typedef long long ll;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
#define Fi first
#define Se second
#define pb push_back
#define szz(x) (int)x.size()
#define rep(i,n) for(int i=0;i<n;i++)
#define all(x) x.begin(),x.end()
typedef tuple<int, int, int> t3;

ll v[700][7];

void solve() {
	printf("203\n");
	fflush(stdout);
	ll a; scanf("%lld", &a);
	ll ans[7] = {};
	for(int i=4;i<=6;i++) {
		ans[i] = a / v[203][i];
		a %= v[203][i];
	}
	printf("56\n");
	fflush(stdout);
	scanf("%lld", &a);
	for(int i=4;i<=6;i++) a -= v[56][i] * ans[i];
	for(int i=1;i<=3;i++) {
		ans[i] = a / v[56][i];
		a %= v[56][i];
	}
	for(int i=1;i<=6;i++) printf("%lld ", ans[i]); puts("");
	fflush(stdout);
	int x; scanf("%d", &x);
	if(x == -1) exit(0);
}

int main() {
	for(int i=1;i<=6;i++) v[0][i] = 1;
	for(int i=1;i<=500;i++) {
		for(int j=1;j<=6;j++) {
			v[i][j] = v[i-1][j];
			if(i % j == 0) {
				if(v[i][j] == 1LL << 62) v[i][j] = 0;
				else v[i][j] *= 2;
			}
		}
	}
	int T; scanf("%d", &T);
	int w; scanf("%d", &w);
	for(int t=1;t<=T;t++) {
//		printf("Case #%d: ", t);
		solve();
	}
	return 0;
}
