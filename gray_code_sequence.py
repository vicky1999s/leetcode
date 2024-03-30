n = int(input())
l = int(input())
harr = []
warr = []
for i in range(n):
    harr.append(int(input()))
for i in range(n):
    warr.append(int(input()))

total_width = warr[0]
total_height = 0
temp = 0

for i in range(n):
    if total_width > l:
        total_height += max(harr[temp:i])
        temp = i
        total_width = 0
    total_width += warr[i]
total_height += max(harr[temp:n])

if total_height == 0:
    print(max(harr))
else:
    print(total_height)
    


