"""
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
"""

arr = [1,2,3,4,5]; k = 4; x = 4
L=0; R=len(arr)-1
while R-L>=k:
    if (x-arr[L]) <= (arr[R]-x):
        R-=1
    else:
        L+=1
print(arr[L:R+1])
