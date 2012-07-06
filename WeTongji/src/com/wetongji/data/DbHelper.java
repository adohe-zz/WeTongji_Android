package com.wetongji.data;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import com.wetongji.R;

/**
 * DbHelper类负责新建数据库和数据库表，更新数据库表的操作。共6张表，对应每一个实体类
 * 另外附带了getDao()方法，所有DAO必须通过DbHelper获得
 * @author John
 */

public class DbHelper extends OrmLiteSqliteOpenHelper {
	
	private static final String DB_NAME="wetongji.db";
	private static final int DB_VERSION=1;
	
	private RuntimeExceptionDao<User, String> userDao=null;
	private RuntimeExceptionDao<Course, String> courseDao=null;
	private RuntimeExceptionDao<Activity, Integer> activityDao=null;
	private RuntimeExceptionDao<Event, Integer> eventDao=null;
	private RuntimeExceptionDao<Channel, Integer> channelDao=null;
	private RuntimeExceptionDao<News, Integer> newsDao=null;
	
	/**
	 * @param context
	 */
	public DbHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION, R.raw.ormlite_config);
		
	}

	/**
	 * 创建数据库表
	 */
	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
		Log.i("Dbhelper", "onCreated");
		try {
			TableUtils.createTableIfNotExists(connectionSource, User.class);
			TableUtils.createTableIfNotExists(connectionSource, Course.class);
			TableUtils.createTableIfNotExists(connectionSource, Event.class);
			TableUtils.createTableIfNotExists(connectionSource, Activity.class);
			TableUtils.createTableIfNotExists(connectionSource, Channel.class);
			TableUtils.createTableIfNotExists(connectionSource, News.class);
			Log.i("DbHelper", "tables created");
		} catch (SQLException e) {
			Log.e("DbHelper", "tables can not be created");
			throw new RuntimeException(e);
		}
		
	}

	/**
	 * 更新数据库表，这里简单的新建所有表
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource,
			int oldVersion, int newVersion) {
		Log.i("DbHelper", "onUpgrade");
		try {
			TableUtils.dropTable(connectionSource, User.class, true);
			TableUtils.dropTable(connectionSource, Course.class, true);
			TableUtils.dropTable(connectionSource, Event.class, true);
			TableUtils.dropTable(connectionSource, Activity.class, true);
			TableUtils.dropTable(connectionSource, Channel.class, true);
			TableUtils.dropTable(connectionSource, News.class, true);
			onCreate(db, connectionSource);
			Log.i("DbHelper", "tables dropped");
		} catch (SQLException e) {
			Log.e("DbHelper", "tables can not be dropped");
			throw new RuntimeException(e);
		}
		
	}
	
	public void close(){
		super.close();
		userDao=null;
		courseDao=null;
		activityDao=null;
		eventDao=null;
		channelDao=null;
		newsDao=null;
	}

	/**
	 * 获得所有DAO的方法
	 * @return
	 */
	public RuntimeExceptionDao<User, String> getUserDao() {
		if(userDao==null)
			userDao=getRuntimeExceptionDao(User.class);
		return userDao;
	}

	public RuntimeExceptionDao<Course, String> getCourseDao() {
		if(courseDao==null)
			courseDao=getRuntimeExceptionDao(Course.class);
		return courseDao;
	}

	public RuntimeExceptionDao<Activity, Integer> getActivityDao() {
		if(activityDao==null)
			activityDao=getRuntimeExceptionDao(Activity.class);
		return activityDao;
	}

	public RuntimeExceptionDao<Event, Integer> getEventDao() {
		if(eventDao==null)
			eventDao=getRuntimeExceptionDao(Event.class);
		return eventDao;
	}

	public RuntimeExceptionDao<Channel, Integer> getChannelDao() {
		if(channelDao==null)
			channelDao=getRuntimeExceptionDao(Channel.class);
		return channelDao;
	}

	public RuntimeExceptionDao<News, Integer> getNewsDao() {
		if(newsDao==null)
			newsDao=getRuntimeExceptionDao(News.class);
		return newsDao;
	}

}