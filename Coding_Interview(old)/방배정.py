#!/usr/bin/env python3

import sys
def main():
    students, capacity = map(int, sys.stdin.readline().split())
    stats = [[0, 0], [0, 0], [0, 0], [0, 0], [0, 0], [0, 0]]
    for _ in range(students):
        gender, year = map(int, sys.stdin.readline().split())
        stats[year - 1][gender] += 1
        cnt = 0
    for counts in stats:
        for count in counts:
            if (count % capacity) == 0 :
                cnt += int(count / capacity)
            else:
                cnt += int(count / capacity) + 1
    print(cnt)
                  
    
if __name__ == '__main__':
    sys.exit(main())