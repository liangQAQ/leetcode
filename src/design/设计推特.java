package design;

import java.util.*;

/**
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 * <p>
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 */
public class 设计推特 {

    //用户所关注的人
    private Map<Integer, Set<Integer>> focus;
    //用户所发的推特
    private Map<Integer, List<Tweet>> text;

    /**
     * 全局使用的时间戳字段，用户每发布一条推文之前 + 1
     */
    private static int timestamp = 0;

    /**
     * 合并 k 组推文使用的数据结构（可以在方法里创建使用），声明成全局变量非必需，视个人情况使用
     */
    private static PriorityQueue<Tweet> maxHeap;

    /**
     * Initialize your data structure here.
     */
    public 设计推特() {
        //关注列表
        focus = new HashMap();
        //文章列表
        text = new HashMap();
        maxHeap = new PriorityQueue<>((o1, o2) -> -o1.time + o2.time);
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        List<Tweet> textList = text.get(userId);
        if (textList == null) {
            textList = new ArrayList();
            text.put(userId, textList);
        }
        textList.add(new Tweet(tweetId,timestamp++));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        maxHeap.clear();
        if (text.get(userId) != null) {
            maxHeap.addAll(text.get(userId));
        }
        Set<Integer> set = focus.get(userId);
        if (set != null) {
            for (Integer userIdItem : set) {
                if (text.get(userIdItem) != null) {
                    maxHeap.addAll(text.get(userIdItem));
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        int size = maxHeap.size();
        for(int i=0 ;i<10&&i<size;i++){
            result.add(maxHeap.poll().id);
        }
        System.out.println("用户{"+userId+"}的列表为"+result);
        return result;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        Set<Integer> set = focus.get(followerId);
        if (set == null) {
            set = new HashSet();
            focus.put(followerId, set);
        }
        set.add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = focus.get(followerId);
        if (set != null) {
            set.remove(followeeId);
        }
    }

    class Tweet {
        Integer id;
        Integer time;
        public Tweet(Integer id, Integer time) {
            this.id = id;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        设计推特 twitter = new 设计推特();

// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
//        twitter.postTweet(1, 5);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//        twitter.getNewsFeed(1);
//
//// 用户1关注了用户2.
//        twitter.follow(1, 2);
//
//// 用户2发送了一个新推文 (推文id = 6).
//        twitter.postTweet(2, 6);
//
//// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
//// 推文id6应当在推文id5之前，因为它是在5之后发送的.
//        twitter.getNewsFeed(1);
//
//// 用户1取消关注了用户2.
//        twitter.unfollow(1, 2);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//// 因为用户1已经不再关注用户2.
//        twitter.getNewsFeed(1);

        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        twitter.getNewsFeed(1);
    }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
}
