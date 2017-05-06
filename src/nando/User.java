package nando;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fernandogomez on 5/4/17.
 */
public class User {

    String name;

/* Now, when the GSON library deserializes a JSON String into a class instance,
it expects the key names in the JSON to exactly match the variable names of the class.
Sometimes this isn't ideal, so it provides a way for you to specify which JSON key
should connect to a given variable in a class. */

    @SerializedName("followers_count")
    int followers;


    public String getName() {

        return name;
    }

    public int getFollowers() {

        return followers;

    }

    public void setName(String name) {

        this.name = name;
    }

    public void setFollowers(int followers) {

        this.followers = followers;
    }

}
