
package pojo;

import java.util.List;

public class CompleteResponse 
{

    private List<PostsArray> posts;
    private int total;
    private int skip;
    private int limit;

    public List<PostsArray> getPosts() 
    {
        return posts;
    }

    public void setPosts(List<PostsArray> posts) 
    {
        this.posts = posts;
    }

    public int getTotal()
    {
        return total;
    }

    public void setTotal(int total) 
    {
        this.total = total;
    }

    public int getSkip() 
    {
        return skip;
    }

    public void setSkip(int skip) 
    {
        this.skip = skip;
    }

    public int getLimit() 
    {
        return limit;
    }

    public void setLimit(int limit) 
    {
        this.limit = limit;
    }
}
