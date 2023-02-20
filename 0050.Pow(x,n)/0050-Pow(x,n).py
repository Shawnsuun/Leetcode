class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        if n < 0:
            return self.myPow(1 / x, -n)
        if n & 1 == 1:
            temp = self.myPow(x, n >> 1)
            return temp * temp * x
        else:
            temp = self.myPow(x, n >> 1)
            return temp * temp
        