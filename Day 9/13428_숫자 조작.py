
def solution():
    length = len(num_str)
    min_case = num_str[:]
    isFinish = False
    for i in range(length):
        if isFinish:
            break
        minimum = min_case[i]
        for j in range(i + 1, length):
            if i == 0:
                if min_case[j] == "0":
                    continue

            if minimum >= min_case[j]:
                minimum = min_case[j]
                idx = j

        if minimum != min_case[i]:
            temp = min_case[i]
            min_case[i] = min_case[idx]
            min_case[idx] = temp
            isFinish = True

    min_num = "".join(min_case)

    max_case = num_str[:]
    isFinish = False
    for i in range(length):
        if isFinish:
            break
        maximum = max_case[i]
        for j in range(i + 1, length):
            if maximum <= max_case[j]:
                maximum = max_case[j]
                idx = j

        if maximum != max_case[i]:
            temp = max_case[i]
            max_case[i] = max_case[idx]
            max_case[idx] = temp
            isFinish = True

    max_num = "".join(max_case)

    return min_num, max_num




T = int(input())

for t in range(1, T + 1):
    num_str = list(input())
    min_num, max_num = solution()
    print(f'#{t} {min_num} {max_num}')