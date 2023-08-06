/*
 * Feature 4 - Rate Limiting Requests - PROBLEM - Logger Rate Limiter
 */
package Facebook;

import java.util.HashMap;

public class LoggerRateLimiter {
    private HashMap<String, Integer> requests;
    int limit;

    public LoggerRateLimiter(int timeLimit){
        requests = new HashMap<String, Integer>();
        limit = timeLimit;
    }

    public boolean messageRequestDecision(int timestamp, String request){
        if(!this.requests.containsKey(request)){
            this.requests.put(request, timestamp);
            return true;
        }

        if(timestamp - this.requests.get(request) >= limit){
            this.requests.put(request, timestamp);
            return true;
        } 
        else {
            return false;
        }
    }
}
