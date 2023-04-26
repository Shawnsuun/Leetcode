int MOD = 1000000007;

int getGCD(int a, int b) {
    while (a % b != 0) {
        int temp = a % b;
        a = b;
        b = temp;
    }
    return b;
}

int getLCM(int a, int b) {  //accoding to the range of a and b, lcm can be represent in int
    return a * b / getGCD(a, b);
}


long getMagicalNumCount(long maxMagicalNum, int a, int b) {
    return maxMagicalNum / a + maxMagicalNum / b - maxMagicalNum / getLCM(a, b);
}

int nthMagicalNumber(int n, int a, int b){
    //f(x) = a/x + b/x - lcm(a, b)/x, represnet the count of magical num that <= x, round down
    long left = fmin(a, b);
    long right = (long) n * fmin(a, b); //may overflow if use integer
    while (left <= right) {
        long mid = (left + right) / 2;
        if (getMagicalNumCount(mid, a, b) >= n) {
            right = mid - 1;    //squeeze right to get the minimum magical number that can get n count
        } else {
            left = mid + 1;
        }
    }
    return (int) (left % MOD);
}



        
