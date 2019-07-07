#include <stdio.h>
#include<math.h>

double pn(double x, int n) {
		if(n==0)
			return 1;
		if(n==1)
			return x;
		return ((2*n -1)*x*pn(x,n-1)-(n-1)*pn(x,n-2))/(n);
}
int main()
{
    int m = 2;
    scanf("%d",&m);
    int n[m];
    double x[m], res[m];
    for(int i = 0;i<m && m<20;i++){
        scanf("%f",&x[i]);
        scanf("%d",&n[i]);
    }

    for(int i = 0;i<m && m<20;i++){
        res[i] = (round(pn(x[i],n[i])*10000))/10000.0;
        printf("%0.4f\n",res[i]);
    }
    return 0;
}
