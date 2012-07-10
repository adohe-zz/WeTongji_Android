/**
 * 
 */
package com.wetongji.daofactory;

import org.json.JSONObject;

/**
 * @author hezibo
 *
 */
public interface EntityFactory 
{
	public void create(JSONObject jsonObject) throws Exception;
}
