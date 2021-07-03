
arr = [1,2,3,4,5]; k = 4; x = 4
L=0; R=len(arr)-1
while R-L>=k:
    if (x-arr[L]) <= (arr[R]-x):
        R-=1
    else:
        L+=1
print(arr[L:R+1])







