def lengthOfLongestSubstring(s):
    if len(s) == 0 or s is None:
        return 0
    mp = {}
    res = 0
    left = 0
    for i in range(len(s)):
        if s[i] in mp.keys():
            left = max(mp[s[i]] + 1, left)
        mp[s[i]] = i
        res = max(res, i - left + 1)
    return res


if __name__ == '__main__':
    print(lengthOfLongestSubstring("abcabcbb"))