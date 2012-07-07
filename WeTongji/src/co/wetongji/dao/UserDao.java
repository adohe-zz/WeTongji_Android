/**
 * 
 */
package co.wetongji.dao;

import org.json.JSONObject;

import android.util.Log;

import com.google.gson.Gson;
import com.wetongji.data.User;

/**
 * @author hezibo
 *
 */
public class UserDao implements EntityDao 
{
	private User user = new User();
	/* (non-Javadoc)
	 * @see co.wetongji.dao.EntityDao#create(org.json.JSONObject)
	 */
	@Override
	public void create(JSONObject jsonObject) throws Exception
	{
		/*String avatar = jsonObject.getString("Avatar");
		String birth = jsonObject.getString("Birthday");
		String degree = jsonObject.getString("degree");
		String department = jsonObject.getString("Department");
		String displayName = jsonObject.getString("DisplayName");
		String email = jsonObject.getString("Email");
		String gender = jsonObject.getString("Gender");
		String major = jsonObject.getString("Major");
		String number = jsonObject.getString("NO");
		String name = jsonObject.getString("Name");
		String nativePlace = jsonObject.getString("NativePlace");
		String phone = jsonObject.getString("Phone");
		String plan = jsonObject.getString("Plan");
		String qq = jsonObject.getString("QQ");
		String weibo = jsonObject.getString("SinaWeibo");
		String uId = jsonObject.getString("UID");
		String year = jsonObject.getString("Year");*/
		
		Log.v("User", jsonObject.toString());
		//Log.v("avatar", avatar);
		//Log.v("birth", birth);
		
		Gson gson = new Gson();
		User user = gson.fromJson(jsonObject.toString(), User.class);
		this.setUser(user);
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
