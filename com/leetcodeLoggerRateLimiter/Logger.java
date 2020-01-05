package com.leetcodeLoggerRateLimiter;

import java.util.TreeMap;

class Logger {

    TreeMap<String,Integer> treeMap;
/** Initialize your data structure here. */
public Logger() {
     treeMap = new TreeMap<>();
}

/** Returns true if the message should be printed in the given timestamp, otherwise returns false.
    If this method returns false, the message will not be printed.
    The timestamp is in seconds granularity. */
public boolean shouldPrintMessage(int timestamp, String message) {
         if (!treeMap.containsKey(message))  {
             treeMap.put(message, timestamp);
             return true;
        }
        Integer oldTimestamp = treeMap.get(message);
        if (timestamp - oldTimestamp >= 10) {
             treeMap.put(message, timestamp);
             return true;
        } else
            return false;
}
}

/**
* Your Logger object will be instantiated and called as such:
* Logger obj = new Logger();
* boolean param_1 = obj.shouldPrintMessage(timestamp,message);
*/